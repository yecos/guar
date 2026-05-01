package com.hpplay.sdk.source.pass;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.ChangeHostSetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.cloud.FavoriteDeviceManager;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.pass.bean.HarassBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.PassDecoderBean;
import com.hpplay.sdk.source.pass.bean.PassLeboBean;
import com.hpplay.sdk.source.pass.bean.PassThirdBean;
import com.hpplay.sdk.source.pass.bean.PlayerRateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventBean;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventInfoBean;
import com.hpplay.sdk.source.pass.sinkkey.SinkKeyEventDispatcher;
import com.hpplay.sdk.source.process.CommonListenerWrapper;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.transceiver.IHostStatusChangeListener;
import com.hpplay.sdk.source.transceiver.IRemoteServerListener;
import com.hpplay.sdk.source.transceiver.ISinkHostSettingChangeListener;
import com.hpplay.sdk.source.transceiver.ISinkNotifySourceCastListener;
import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;
import com.hpplay.sdk.source.utils.Feature;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Parser {
    private static final String TAG = "Parser";
    private static Parser sInstance;
    private Map<String, SinkBean> mSinkMap = new HashMap();
    private OnSinkTouchEventInfoListener mSinkTouchEventInfoListener;

    public interface OnSinkTouchEventInfoListener {
        void onInfo(SinkTouchEventInfoBean sinkTouchEventInfoBean);
    }

    private Parser() {
    }

    public static synchronized Parser getInstance() {
        synchronized (Parser.class) {
            synchronized (Parser.class) {
                if (sInstance == null) {
                    sInstance = new Parser();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private SinkBean getSinkBean(String str) {
        SinkBean sinkBean = this.mSinkMap.get(str);
        if (sinkBean != null) {
            return sinkBean;
        }
        SinkBean sinkBean2 = new SinkBean();
        sinkBean2.uid = str;
        return sinkBean2;
    }

    private void handleAPPMessage(int i10, DescribeBean describeBean, String str) {
        String str2;
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "handleAPPMessage invalid input");
            return;
        }
        int i11 = describeBean.manifestType;
        int i12 = -1;
        if (i11 == -1) {
            handleErrorMessage(describeBean, str);
        } else if (i11 == 23) {
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
            }
            RightsManager.getInstance().handleRightMessage(describeBean.uid, str);
        } else {
            if (i11 != 45) {
                if (i11 != 100) {
                    if (i11 != 10000) {
                        SourceLog.w(TAG, "handleAPPMessage parse nonsupport msg type: " + describeBean.manifestType);
                        i12 = 1;
                        str2 = "Nonsupport message";
                    } else {
                        PassThirdBean formJSON = PassThirdBean.formJSON(str);
                        if (formJSON == null) {
                            SourceLog.w(TAG, "handleAPPMessage parse pass failed");
                            str2 = "parse pass failed";
                            i12 = 2;
                        } else if (formJSON.data == null) {
                            SourceLog.w(TAG, "handleAPPMessage parse pass invalid data");
                            str2 = "parse pass invalid data";
                            i12 = 3;
                        } else if (TextUtils.equals(Session.getInstance().appKey, formJSON.appID)) {
                            SourceLog.w(TAG, "MANIFEST_PASS_THIRD " + LelinkSdkManager.getInstance().mOuterRelevantInfoListener);
                            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(10000, str);
                            }
                        } else {
                            SourceLog.w(TAG, "handleAPPMessage parse pass unequal appID");
                            i12 = 4;
                            str2 = "wrong appID";
                        }
                    }
                } else if (Feature.isLeboApp()) {
                    PassLeboBean formJSON2 = PassLeboBean.formJSON(str);
                    if (formJSON2 == null) {
                        SourceLog.w(TAG, "handleAPPMessage, parse pass lebo failed");
                        str2 = "parse pass lebo failed";
                        i12 = 2;
                    } else if (formJSON2.data == null) {
                        SourceLog.w(TAG, "handleAPPMessage, parse pass lebo invalid data");
                        str2 = "parse pass lebo invalid data";
                        i12 = 3;
                    } else if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                        LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(100, str);
                    }
                } else {
                    SourceLog.i(TAG, "MANIFEST_PASS_LEBO ignore,not lebo app");
                }
                if (i12 > 0 || TextUtils.isEmpty(str2)) {
                }
                sendErrorMessage(describeBean, i12, str2);
                return;
            }
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
            }
        }
        str2 = null;
        if (i12 > 0) {
        }
    }

    private void handleErrorMessage(DescribeBean describeBean, String str) {
        SourceLog.w(TAG, "handleErrorMessage " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0363  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleSDKMessage(int i10, DescribeBean describeBean, String str) {
        ConnectBean connectBean;
        ChangeHostSetBean formJson;
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "handleSDKMessage invalid input");
            return;
        }
        SinkBean sinkBean = getSinkBean(describeBean.uid);
        String str2 = null;
        int i11 = 1;
        switch (describeBean.manifestType) {
            case -1:
                handleErrorMessage(describeBean, str);
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0 && !TextUtils.isEmpty(str2)) {
                    sendErrorMessage(describeBean, i11, str2);
                    break;
                }
                break;
            case 4:
                sinkBean.connectBean = ConnectBean.formJson(str);
                ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(describeBean.uid);
                if (connectBridge != null && (connectBean = sinkBean.connectBean) != null) {
                    connectBridge.setSinkSM(connectBean.sm);
                    connectBridge.saveConnectBean(str);
                }
                SourceLog.i(TAG, "handleSDKMessage parse receive connect " + str);
                if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                    LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                    break;
                }
                break;
            case 11:
                SinkTouchEventInfoBean fromJson = SinkTouchEventInfoBean.fromJson(str);
                if (fromJson == null) {
                    SourceLog.w(TAG, "handleSDKMessage: sinkTouchEventInfoBean is null");
                } else {
                    ConnectBridge connectBridge2 = ConnectManager.getInstance().getConnectBridge(describeBean.uid);
                    if (connectBridge2 != null && connectBridge2.getServiceInfo() != null && !TextUtils.isEmpty(connectBridge2.getServiceInfo().getIp())) {
                        fromJson.ip = connectBridge2.getServiceInfo().getIp();
                    }
                    SourceLog.i(TAG, "handleSDKMessage: sinkTouchEventInfoBean : " + fromJson.toString());
                    sinkBean.sinkTouchEventInfoBean = fromJson;
                }
                OnSinkTouchEventInfoListener onSinkTouchEventInfoListener = this.mSinkTouchEventInfoListener;
                if (onSinkTouchEventInfoListener != null) {
                    onSinkTouchEventInfoListener.onInfo(fromJson);
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 14:
                sinkBean.decoderBean = PassDecoderBean.formJson(str);
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 16:
                PlayerRateBean formJson2 = PlayerRateBean.formJson(str);
                if (formJson2 == null) {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_QUERY_REPLY ignore ");
                } else {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_QUERY_REPLY " + formJson2.rate);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 16, String.valueOf(formJson2.rate));
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 26:
                SourceLog.i(TAG, "handleSDKMessage parse mirror state");
                MirrorStateBean fromJson2 = MirrorStateBean.fromJson(str);
                if (fromJson2 == null) {
                    SourceLog.i(TAG, "handleSDKMessage parse mirror state failed");
                    break;
                } else {
                    ConnectManager.getInstance().getLastConnectBridge().notifyPassReceivedData(describeBean.manifestType, fromJson2);
                    i11 = -1;
                    this.mSinkMap.put(describeBean.uid, sinkBean);
                    if (i11 > 0) {
                    }
                }
                break;
            case 29:
                SinkKeyEventBean fromJson3 = SinkKeyEventBean.fromJson(str);
                if (fromJson3 == null) {
                    SourceLog.w(TAG, "handleSDKMessage: sinkKeyEventBean is null");
                } else {
                    SourceLog.i(TAG, "handleAPPMessage: sinkKeyEventBean keyCode: " + fromJson3.keyCode + " action: " + fromJson3.action);
                    SinkKeyEventDispatcher.getInstance().handleEvent(fromJson3.keyCode, fromJson3.action);
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 34:
                if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                    LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 37:
                PlayerRateBean formJson3 = PlayerRateBean.formJson(str);
                if (formJson3 == null) {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_UPDATE ignore ");
                } else {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_UPDATE " + formJson3.rate);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 37, String.valueOf(formJson3.rate));
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 40:
                IRemoteServerListener remoteServerListener = CommonListenerWrapper.getInstance().getRemoteServerListener();
                SourceLog.w(TAG, "MANIFEST_NOTIFY_REMOTE_REPLAY " + remoteServerListener);
                if (remoteServerListener != null) {
                    try {
                        int optInt = new JSONObject(str).optInt("result");
                        if (optInt == 1) {
                            remoteServerListener.onServerStarted(RemoteServerBean.formJson(str));
                        } else {
                            remoteServerListener.onServerFailed(optInt);
                        }
                    } catch (Exception e10) {
                        SourceLog.w(TAG, e10);
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 41:
                IHostStatusChangeListener hostStatusChangeListener = CommonListenerWrapper.getInstance().getHostStatusChangeListener();
                if (hostStatusChangeListener != null) {
                    try {
                        int optInt2 = new JSONObject(str).optInt("action");
                        if (optInt2 == 1) {
                            hostStatusChangeListener.onHostChange(true);
                        } else if (optInt2 == 0) {
                            hostStatusChangeListener.onHostChange(false);
                        }
                    } catch (Exception e11) {
                        SourceLog.w(TAG, e11);
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 42:
                ISinkHostSettingChangeListener sinkHostSettingChangeListener = CommonListenerWrapper.getInstance().getSinkHostSettingChangeListener();
                if (sinkHostSettingChangeListener != null && (formJson = ChangeHostSetBean.formJson(str)) != null) {
                    SourceLog.i(TAG, "MANIFEST_SOURCE_HOST_SET " + formJson.action + " " + formJson.value);
                    int i12 = formJson.action;
                    if (i12 == 1) {
                        sinkHostSettingChangeListener.onCastSetting(formJson.value);
                    } else if (i12 == 2) {
                        sinkHostSettingChangeListener.onReverseCastSetting(formJson.value);
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 43:
                ISinkNotifySourceCastListener sinkNotifySourceCastListener = CommonListenerWrapper.getInstance().getSinkNotifySourceCastListener();
                if (sinkNotifySourceCastListener != null) {
                    try {
                        sinkNotifySourceCastListener.onSinkNotifySourceCast(new JSONObject(str).optInt("action"));
                    } catch (Exception e12) {
                        SourceLog.w(TAG, e12);
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 46:
                HarassBean formJson4 = HarassBean.formJson(str);
                if (formJson4 != null) {
                    SourceLog.i(TAG, "msg type: " + describeBean.manifestType + " , harass timeout = " + formJson4.timeout);
                    HarassCode.getInstance().setHarass(formJson4.code, formJson4.timeout);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 46, String.valueOf(formJson4.timeout));
                    }
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 51:
                if (LelinkSdkManager.getInstance().mReceiverPropertiesCallback != null) {
                    LelinkSdkManager.getInstance().mReceiverPropertiesCallback.callback(ReceiverProperties.fromJson(str));
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 53:
                SourceLog.i(TAG, "MANIFEST_FAVORITE_DEV_RESPONSE " + str);
                try {
                    if (new JSONObject(str).optInt("result") == 1) {
                        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(describeBean.uid);
                        if (lelinkServiceInfo != null) {
                            FavoriteDeviceManager.getInstance().addFavoriteDeviceAfterConfirm(lelinkServiceInfo);
                        }
                    } else {
                        FavoriteDeviceManager.getInstance().onAddCallback(false, -110);
                    }
                } catch (Exception e13) {
                    SourceLog.w(TAG, e13);
                }
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 100:
                SourceLog.i(TAG, "handleSDKMessage sdk pass lebo msg ignore");
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            case 10000:
                SourceLog.w(TAG, "handleSDKMessage parse pass msg ignore");
                i11 = -1;
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
            default:
                SourceLog.w(TAG, "handleSDKMessage parse nonsupport msg type: " + describeBean.manifestType);
                str2 = "Nonsupport message";
                this.mSinkMap.put(describeBean.uid, sinkBean);
                if (i11 > 0) {
                }
                break;
        }
    }

    private void parse(int i10, DescribeBean describeBean, String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "parse invalid input");
            return;
        }
        if (describeBean == null) {
            SourceLog.w(TAG, "parse describeBean failed");
            return;
        }
        if (TextUtils.isEmpty(describeBean.uid) && TextUtils.isEmpty(describeBean.cuid)) {
            SourceLog.w(TAG, "parse describeBean miss uid");
            return;
        }
        int i11 = describeBean.handler;
        if (i11 != 1 && i11 != 2) {
            SourceLog.w(TAG, "parse describeBean invalid handler");
            return;
        }
        SourceLog.i(TAG, "parse " + describeBean.manifestType + " / " + str);
        SourceLog.i(TAG, "parse ");
        if (describeBean.handler == 2) {
            handleSDKMessage(i10, describeBean, str);
        } else {
            handleAPPMessage(i10, describeBean, str);
        }
    }

    private void sendErrorMessage(DescribeBean describeBean, int i10, String str) {
        SourceLog.w(TAG, "sendErrorMessage " + str);
    }

    public ConnectBean getConnectBean(String str) {
        ConnectBean connectBean;
        SinkBean sinkBean = getSinkBean(str);
        if (sinkBean == null || (connectBean = sinkBean.connectBean) == null) {
            return null;
        }
        return connectBean;
    }

    public void parseByLocalCast(DescribeBean describeBean, String str) {
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseByLocalCast invalid input");
        } else {
            parse(1, describeBean, str);
        }
    }

    public void parseByNetCast(String str) {
        String[] split = str.split(Pass.PLACEHOLDER_END);
        DescribeBean describeBean = null;
        for (int i10 = 0; i10 < split.length; i10++) {
            if (TextUtils.isEmpty(split[i10]) || !split[i10].startsWith(Pass.PLACEHOLDER_START)) {
                SourceLog.w(TAG, "parseByNetCast invalid msg at " + i10);
                return;
            }
            if (i10 == 0) {
                describeBean = DescribeBean.formJson(split[i10].substring(6));
                if (describeBean == null) {
                    SourceLog.w(TAG, "parseByNetCast describeBean failed");
                    return;
                }
                if (TextUtils.isEmpty(describeBean.uid) && TextUtils.isEmpty(describeBean.cuid)) {
                    SourceLog.w(TAG, "parseByNetCast describeBean miss cuid");
                    return;
                }
                int i11 = describeBean.handler;
                if (i11 != 1 && i11 != 2) {
                    sendErrorMessage(describeBean, 5, "wrong handler");
                    return;
                }
            } else if (i10 == 1) {
                parse(2, describeBean, split[i10].substring(6));
            }
        }
    }

    public void setOnSinkTouchEventInfoListener(OnSinkTouchEventInfoListener onSinkTouchEventInfoListener) {
        this.mSinkTouchEventInfoListener = onSinkTouchEventInfoListener;
    }
}
