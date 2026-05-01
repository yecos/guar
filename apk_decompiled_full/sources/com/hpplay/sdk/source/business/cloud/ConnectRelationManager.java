package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ADENSTUtils;
import com.hpplay.sdk.source.utils.Feature;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConnectRelationManager {
    private static final String TAG = "ConnectRelationManager";
    private IServiceInfoParseListener mListener;
    private Session mSession = Session.getInstance();

    private Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(DispatchConstants.CONFIG_VERSION, "41214");
        hashMap.put("app-id", this.mSession.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, this.mSession.getUID());
        String token = this.mSession.getToken();
        if (!TextUtils.isEmpty(token)) {
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, token);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
        IServiceInfoParseListener iServiceInfoParseListener = this.mListener;
        if (iServiceInfoParseListener != null) {
            iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
        }
    }

    private void requestLelinkTxtInfo(String str, final String str2, final String str3, final LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "requestLelinkTxtInfo " + lelinkServiceInfo);
        String httpServerUrl = CloudAPI.getHttpServerUrl(str, str2);
        SourceLog.i(TAG, "requestLelinkTxtInfo infoUrl:" + httpServerUrl);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(httpServerUrl, null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(5L);
        asyncHttpParameter.in.tryCount = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.ConnectRelationManager.3
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.i(ConnectRelationManager.TAG, "requestLelinkTxtInfo: cancel");
                    return;
                }
                SourceLog.i(ConnectRelationManager.TAG, "requestLelinkTxtInfo result:" + asyncHttpParameter2.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType == 0) {
                    String str4 = out.result;
                    BrowserInfo browserInfo = lelinkServiceInfo.getBrowserInfos().get(1);
                    if (browserInfo == null) {
                        browserInfo = lelinkServiceInfo.getBrowserInfos().get(4);
                    }
                    LelinkServiceInfo lelinkTxtInfo = LelinkServiceInfoCreator.getLelinkTxtInfo(browserInfo.getUid(), lelinkServiceInfo.getName(), browserInfo.getIp(), str2, TextUtils.isEmpty(str3) ? "tv" : str3, str4, 9);
                    if (lelinkTxtInfo == null) {
                        SourceLog.i(ConnectRelationManager.TAG, "resolveLelinkTxtInfo: failed ");
                        return;
                    } else {
                        lelinkTxtInfo.setAlias(lelinkServiceInfo.getAlias());
                        ConnectRelationManager.this.notifyParseResult(1, lelinkTxtInfo);
                        return;
                    }
                }
                if (Feature.isDisableIM()) {
                    SourceLog.i(ConnectRelationManager.TAG, "requestLelinkTxtInfo: isDisableIM");
                    return;
                }
                try {
                    if (lelinkServiceInfo.getBrowserInfos().size() <= 1 || !lelinkServiceInfo.getBrowserInfos().containsKey(4)) {
                        return;
                    }
                    lelinkServiceInfo.getBrowserInfos().remove(1);
                } catch (Exception e10) {
                    SourceLog.w(ConnectRelationManager.TAG, e10);
                }
            }
        });
    }

    public void findByNumberId(String str, int i10, final int i11) {
        SourceLog.i(TAG, "uploadConnectDeivce FindUrl: " + CloudAPI.sFindByNumber);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SourceDataReport.getInstance().onConnectDeviceQuery();
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        hashMap.put("linkType", i10 + "");
        hashMap.put("online", "1");
        String mapParams = HapplayUtils.getMapParams(hashMap);
        SourceLog.i(TAG, "findByNumberId params: " + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sFindByNumber, mapParams);
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 0;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.ConnectRelationManager.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                SourceLog.d(ConnectRelationManager.TAG, "findByNumberId: " + asyncHttpParameter2.out.result);
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.i(ConnectRelationManager.TAG, "onRequestResult: request cancel");
                    return;
                }
                if (ConnectRelationManager.this.mListener == null || TextUtils.isEmpty(asyncHttpParameter2.out.result)) {
                    ConnectRelationManager.this.notifyParseResult(5, null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(asyncHttpParameter2.out.result);
                    int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
                    if (optInt != 200) {
                        if (optInt == 211) {
                            ConnectRelationManager.this.notifyParseResult(8, null);
                            return;
                        } else if (optInt == 221) {
                            ConnectRelationManager.this.notifyParseResult(7, null);
                            return;
                        } else {
                            ConnectRelationManager.this.notifyParseResult(5, null);
                            return;
                        }
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i12 = 0; i12 < optJSONArray.length(); i12++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i12);
                            SourceLog.i(ConnectRelationManager.TAG, "data " + optJSONObject.toString());
                            ConnectRelationManager.this.parseServiceInfo(optJSONObject, i11);
                        }
                        return;
                    }
                    ConnectRelationManager.this.notifyParseResult(5, null);
                } catch (Exception e10) {
                    SourceLog.w(ConnectRelationManager.TAG, e10);
                    ConnectRelationManager.this.notifyParseResult(5, null);
                }
            }
        });
    }

    public LelinkServiceInfo parseServiceInfo(JSONObject jSONObject, int i10) {
        if (this.mListener == null || jSONObject == null) {
            notifyParseResult(0, null);
            return null;
        }
        try {
            LelinkServiceInfo createByServiceBrowseInfo = LelinkServiceInfoCreator.createByServiceBrowseInfo(jSONObject, i10);
            SourceLog.i(TAG, "parseServiceInfo " + createByServiceBrowseInfo);
            if (createByServiceBrowseInfo == null) {
                notifyParseResult(0, null);
                return null;
            }
            String optString = jSONObject.optString("name");
            if ("null".equals(optString)) {
                optString = "";
            }
            createByServiceBrowseInfo.setAlias(optString);
            if (Feature.isDisableIM()) {
                notifyParseResult(0, null);
            } else {
                notifyParseResult(1, createByServiceBrowseInfo);
            }
            if (!TextUtils.isEmpty(createByServiceBrowseInfo.getIp())) {
                requestLelinkTxtInfo(createByServiceBrowseInfo.getIp(), createByServiceBrowseInfo.getPort() + "", createByServiceBrowseInfo.getPlatform(), createByServiceBrowseInfo);
            }
            return createByServiceBrowseInfo;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            notifyParseResult(0, null);
            return null;
        }
    }

    public void setParseResultListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mListener = iServiceInfoParseListener;
    }

    public void uploadConnectDeivce(HistoryConfigBean historyConfigBean, int i10, String str, int i11) {
        SourceLog.i(TAG, "uploadConnectDeivce UploadUrl: " + CloudAPI.sUploadConn);
        if (TextUtils.isEmpty(historyConfigBean.encryptNumberId)) {
            return;
        }
        SourceDataReport.getInstance().onConnectDeviceUpload();
        if (this.mSession == null) {
            this.mSession = Session.getInstance();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("appId", i10 + "");
        hashMap.put("id", historyConfigBean.encryptNumberId);
        hashMap.put("linkType", i11 + "");
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, str);
        if (!TextUtils.isEmpty(historyConfigBean.numberId)) {
            hashMap.put("mobile", historyConfigBean.numberId);
        }
        String jsonParams = HapplayUtils.getJsonParams(hashMap);
        SourceLog.i(TAG, "uploadConnectDeivce params: " + jsonParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sUploadConn, ADENSTUtils.encrypt(jsonParams));
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.ConnectRelationManager.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                SourceLog.i(ConnectRelationManager.TAG, "reuslt: " + asyncHttpParameter2.out.result);
            }
        });
    }
}
