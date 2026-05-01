package com.hpplay.sdk.source.device;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.device.ServerInfoResolver;
import com.hpplay.sdk.source.device.pincode.LelinkCodeCreator;
import com.hpplay.sdk.source.device.pincode.PinCodeInfo;
import com.hpplay.sdk.source.device.pincode.PinCodeParser;
import com.hpplay.sdk.source.device.qr.QRCodeController;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Device {
    private static final String TAG = "Device";
    private static AtomicInteger parsedCount = new AtomicInteger(0);

    public static void addDeviceCodeServiceInfo(String str, int i10, final IServiceInfoParseListener iServiceInfoParseListener) {
        DeviceCodeResolver.getInstance().resolveDeviceCode(str, i10, new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.device.Device.3
            @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
            public void onParseResult(int i11, LelinkServiceInfo lelinkServiceInfo) {
                if (IServiceInfoParseListener.this == null) {
                    SourceLog.i(Device.TAG, "onParseResult: ignore");
                    return;
                }
                if (lelinkServiceInfo == null) {
                    SourceLog.i(Device.TAG, "onParseResult: invalid info resultCode: " + i11);
                    return;
                }
                SourceLog.i(Device.TAG, "onParseResult: " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
                Device.updateServiceList(lelinkServiceInfo);
                IServiceInfoParseListener.this.onParseResult(i11, lelinkServiceInfo);
            }
        });
    }

    public static void addPinCodeServiceInfo(Context context, String str, final IServiceInfoParseListener iServiceInfoParseListener) {
        PinCodeParser pinCodeParser = new PinCodeParser(context);
        final long currentTimeMillis = System.currentTimeMillis();
        pinCodeParser.setCodeCallback(new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.device.Device.2
            @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
            public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                if (IServiceInfoParseListener.this == null) {
                    SourceLog.w(Device.TAG, "addPinCodeServiceInfo ignore");
                    return;
                }
                if (lelinkServiceInfo == null) {
                    SourceLog.w(Device.TAG, "addPinCodeServiceInfo invalid info");
                    IServiceInfoParseListener.this.onParseResult(i10, null);
                    return;
                }
                SourceLog.w(Device.TAG, "addPinCodeServiceInfo " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
                LelinkServiceInfo updateServiceList = Device.updateServiceList(lelinkServiceInfo);
                IServiceInfoParseListener.this.onParseResult(i10, updateServiceList);
                BrowserHistory.getInstance().updateBrowserInfo(CastUtil.getBrowserInfo(updateServiceList, 4), 5, System.currentTimeMillis() - currentTimeMillis);
            }
        });
        pinCodeParser.parsePinCode(new PinCodeInfo(str));
    }

    public static void addQRLelinkServiceInfo(String str, final IServiceInfoParseListener iServiceInfoParseListener) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "addQRLelinkServiceInfo ignore, invalid qr info");
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            new QRCodeController().addQRCodeServiceInfo(str, new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.device.Device.1
                @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
                public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                    if (lelinkServiceInfo == null) {
                        IServiceInfoParseListener.this.onParseResult(i10, null);
                        return;
                    }
                    LelinkServiceInfo updateServiceList = Device.updateServiceList(lelinkServiceInfo);
                    IServiceInfoParseListener.this.onParseResult(i10, updateServiceList);
                    BrowserHistory.getInstance().updateBrowserInfo(CastUtil.getBrowserInfo(updateServiceList, 4), 2, System.currentTimeMillis() - currentTimeMillis);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callbackParse(IServiceInfoListParseListener iServiceInfoListParseListener, List<ServiceInfoParseBean> list) {
        parsedCount.decrementAndGet();
        SourceLog.i(TAG, "createLelinkServiceInfoList callbackParse : " + parsedCount.get());
        if (parsedCount.get() > 0 || iServiceInfoListParseListener == null) {
            return;
        }
        iServiceInfoListParseListener.onParseResult(list);
    }

    public static void createBySinkServer(final String str, int i10, final IServiceInfoParseListener iServiceInfoParseListener) {
        if (TextUtils.isEmpty(str) || i10 <= 0) {
            if (iServiceInfoParseListener != null) {
                iServiceInfoParseListener.onParseResult(11, null);
                return;
            }
            return;
        }
        String httpServerUrl = CloudAPI.getHttpServerUrl(str, String.valueOf(i10));
        SourceLog.i(TAG, "infoUlr" + httpServerUrl);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(httpServerUrl, null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(2L);
        asyncHttpParameter.in.tryCount = 1;
        System.currentTimeMillis();
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.Device.6
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                int i11 = out.resultType;
                if (i11 == 2) {
                    SourceLog.i(Device.TAG, "requestLelinkTxtInfo cancel");
                    IServiceInfoParseListener.this.onParseResult(5, null);
                    return;
                }
                if (i11 == 0) {
                    String str2 = out.result;
                    SourceLog.debug(Device.TAG, "requestLelinkTxtInfo response:" + str2);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String optString = jSONObject.optString("serviceName");
                        JSONObject optJSONObject = jSONObject.optJSONObject("leLinkTxt");
                        LelinkServiceInfo lelinkTxtInfo = LelinkServiceInfoCreator.getLelinkTxtInfo(optJSONObject.optString("u"), optString, str, optJSONObject.optString("lelinkport"), "", str2, 2);
                        if (lelinkTxtInfo == null) {
                            IServiceInfoParseListener.this.onParseResult(5, null);
                            return;
                        }
                        IServiceInfoParseListener iServiceInfoParseListener2 = IServiceInfoParseListener.this;
                        if (iServiceInfoParseListener2 != null) {
                            iServiceInfoParseListener2.onParseResult(1, lelinkTxtInfo);
                            return;
                        }
                        return;
                    } catch (Exception e10) {
                        SourceLog.w(Device.TAG, e10);
                    }
                }
                SourceLog.i(Device.TAG, "requestLelinkTxtInfo failed");
                IServiceInfoParseListener iServiceInfoParseListener3 = IServiceInfoParseListener.this;
                if (iServiceInfoParseListener3 != null) {
                    iServiceInfoParseListener3.onParseResult(5, null);
                }
            }
        });
    }

    public static void createLelinkServiceInfo(final SinkParameterBean sinkParameterBean, final IServiceInfoParseListener iServiceInfoParseListener) {
        AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.device.Device.4
            @Override // java.lang.Runnable
            public void run() {
                JSONArray optJSONArray;
                JSONObject optJSONObject;
                String sinkServerInfo = KeepAliveUtitls.getSinkServerInfo(SinkParameterBean.this);
                if (TextUtils.isEmpty(sinkServerInfo)) {
                    SourceLog.i(Device.TAG, "createLelinkServiceInfo *** " + sinkServerInfo);
                    IServiceInfoParseListener iServiceInfoParseListener2 = iServiceInfoParseListener;
                    if (iServiceInfoParseListener2 != null) {
                        iServiceInfoParseListener2.onParseResult(5, null);
                        return;
                    }
                    return;
                }
                SourceLog.i(Device.TAG, "createLelinkServiceInfo " + sinkServerInfo);
                try {
                    JSONObject optJSONObject2 = new JSONObject(sinkServerInfo).optJSONObject("data");
                    if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("tvList")) != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                        String optString = optJSONObject.optString("dsn");
                        String optString2 = optJSONObject.optString("ra");
                        String optString3 = optJSONObject.optString("u");
                        String optString4 = optJSONObject.optString("name");
                        String optString5 = optJSONObject.optString("pt");
                        String optString6 = optJSONObject.optString("localip");
                        String optString7 = optJSONObject.optString("localport");
                        boolean optBoolean = optJSONObject.optBoolean("online");
                        String optString8 = optJSONObject.optString(BrowserInfo.KEY_TUNNELS);
                        if (!optBoolean) {
                            IServiceInfoParseListener iServiceInfoParseListener3 = iServiceInfoParseListener;
                            if (iServiceInfoParseListener3 != null) {
                                iServiceInfoParseListener3.onParseResult(10, null);
                                return;
                            }
                            return;
                        }
                        if (!TextUtils.isEmpty(optString2) && (!TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString))) {
                            ServerInfoResolver.SinkServerBean sinkServerBean = new ServerInfoResolver.SinkServerBean();
                            sinkServerBean.appID = optString2;
                            sinkServerBean.uid = optString3;
                            sinkServerBean.name = optString4;
                            sinkServerBean.pt = optString5;
                            sinkServerBean.ip = optString6;
                            sinkServerBean.dsn = optString;
                            sinkServerBean.port = optString7;
                            sinkServerBean.tunnels = optString8;
                            new ServerInfoResolver().parserServerInfo(sinkServerBean, iServiceInfoParseListener);
                            return;
                        }
                        IServiceInfoParseListener iServiceInfoParseListener4 = iServiceInfoParseListener;
                        if (iServiceInfoParseListener4 != null) {
                            iServiceInfoParseListener4.onParseResult(9, null);
                        }
                    }
                } catch (Exception e10) {
                    SourceLog.w(Device.TAG, e10);
                }
                IServiceInfoParseListener iServiceInfoParseListener5 = iServiceInfoParseListener;
                if (iServiceInfoParseListener5 != null) {
                    iServiceInfoParseListener5.onParseResult(5, null);
                }
            }
        }, null);
    }

    public static void createLelinkServiceInfoList(final List<SinkParameterBean> list, final IServiceInfoListParseListener iServiceInfoListParseListener) {
        AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.device.Device.5
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList = new ArrayList();
                String sinkServerInfoList = KeepAliveUtitls.getSinkServerInfoList(list);
                if (TextUtils.isEmpty(sinkServerInfoList)) {
                    SourceLog.i(Device.TAG, "createLelinkServiceInfoList *** " + sinkServerInfoList);
                    if (iServiceInfoListParseListener != null) {
                        arrayList.add(new ServiceInfoParseBean(5, null, null));
                        iServiceInfoListParseListener.onParseResult(arrayList);
                        return;
                    }
                    return;
                }
                SourceLog.i(Device.TAG, "createLelinkServiceInfoList " + sinkServerInfoList);
                try {
                    JSONObject optJSONObject = new JSONObject(sinkServerInfoList).optJSONObject("data");
                    if (optJSONObject == null) {
                        if (iServiceInfoListParseListener != null) {
                            arrayList.add(new ServiceInfoParseBean(5, null, null));
                            iServiceInfoListParseListener.onParseResult(arrayList);
                            return;
                        }
                        return;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("tvList");
                    if (optJSONArray == null) {
                        if (iServiceInfoListParseListener != null) {
                            arrayList.add(new ServiceInfoParseBean(5, null, null));
                            iServiceInfoListParseListener.onParseResult(arrayList);
                            return;
                        }
                        return;
                    }
                    Device.parsedCount.set(optJSONArray.length());
                    for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                        if (optJSONObject2 == null) {
                            Device.callbackParse(iServiceInfoListParseListener, arrayList);
                        } else {
                            String optString = optJSONObject2.optString("dsn");
                            String optString2 = optJSONObject2.optString("ra");
                            final String optString3 = optJSONObject2.optString("u");
                            String optString4 = optJSONObject2.optString("name");
                            String optString5 = optJSONObject2.optString("pt");
                            String optString6 = optJSONObject2.optString("localip");
                            String optString7 = optJSONObject2.optString("localport");
                            boolean optBoolean = optJSONObject2.optBoolean("online");
                            String optString8 = optJSONObject2.optString(BrowserInfo.KEY_TUNNELS);
                            if (!optBoolean) {
                                arrayList.add(new ServiceInfoParseBean(10, optString3, null));
                                Device.callbackParse(iServiceInfoListParseListener, arrayList);
                            } else if (TextUtils.isEmpty(optString2) || (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString))) {
                                arrayList.add(new ServiceInfoParseBean(5, optString3, null));
                                Device.callbackParse(iServiceInfoListParseListener, arrayList);
                            } else {
                                ServerInfoResolver.SinkServerBean sinkServerBean = new ServerInfoResolver.SinkServerBean();
                                sinkServerBean.appID = optString2;
                                sinkServerBean.uid = optString3;
                                sinkServerBean.name = optString4;
                                sinkServerBean.pt = optString5;
                                sinkServerBean.ip = optString6;
                                sinkServerBean.dsn = optString;
                                sinkServerBean.port = optString7;
                                sinkServerBean.tunnels = optString8;
                                new ServerInfoResolver().parserServerInfo(sinkServerBean, new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.device.Device.5.1
                                    @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
                                    public void onParseResult(int i11, LelinkServiceInfo lelinkServiceInfo) {
                                        ServiceInfoParseBean serviceInfoParseBean = new ServiceInfoParseBean(i11, optString3, lelinkServiceInfo);
                                        if (arrayList.contains(serviceInfoParseBean)) {
                                            SourceLog.i(Device.TAG, "createLelinkServiceInfoList remove repeat: " + serviceInfoParseBean.uid);
                                            arrayList.remove(serviceInfoParseBean);
                                        }
                                        arrayList.add(serviceInfoParseBean);
                                        Device.callbackParse(iServiceInfoListParseListener, arrayList);
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e10) {
                    SourceLog.w(Device.TAG, e10);
                    if (iServiceInfoListParseListener != null) {
                        arrayList.add(new ServiceInfoParseBean(5, null, null));
                        iServiceInfoListParseListener.onParseResult(arrayList);
                    }
                }
            }
        }, null);
    }

    public static void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        new LelinkCodeCreator().createPinCode(iCreatePinCodeListener);
    }

    public static void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        new QRCodeController().requestShortUrl(iCreateShortUrlListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LelinkServiceInfo updateServiceList(LelinkServiceInfo lelinkServiceInfo) {
        return lelinkServiceInfo;
    }
}
