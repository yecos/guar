package com.hpplay.sdk.source.business.cloud;

import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.api.DeviceListenerConstant;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HistoryDeviceManager extends DeviceManager {
    private static final String TAG = "HistoryDeviceManager";
    private static HistoryDeviceManager sInstance;
    public IHistoryDeviceListener mHistoryDeviceListener;

    private HistoryDeviceManager() {
    }

    public static synchronized HistoryDeviceManager getInstance() {
        HistoryDeviceManager historyDeviceManager;
        synchronized (HistoryDeviceManager.class) {
            if (sInstance == null) {
                sInstance = new HistoryDeviceManager();
            }
            historyDeviceManager = sInstance;
        }
        return historyDeviceManager;
    }

    private boolean isFunctionDisable() {
        return !SDKConfig.getInstance().getHistoryDevSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetDeviceCallback(boolean z10, int i10, List<LelinkServiceInfo> list) {
        IHistoryDeviceListener iHistoryDeviceListener = this.mHistoryDeviceListener;
        if (iHistoryDeviceListener == null) {
            return;
        }
        if (z10) {
            iHistoryDeviceListener.onGetDeviceList(1, 200, list);
        } else {
            iHistoryDeviceListener.onGetDeviceList(2, i10, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRemoveCallback(boolean z10, int i10) {
        IHistoryDeviceListener iHistoryDeviceListener = this.mHistoryDeviceListener;
        if (iHistoryDeviceListener == null) {
            return;
        }
        if (z10) {
            iHistoryDeviceListener.onRemoveDevice(1, 200);
        } else {
            iHistoryDeviceListener.onRemoveDevice(2, i10);
        }
    }

    public void addHistoryDevice(LelinkServiceInfo lelinkServiceInfo) {
        int i10;
        if (isFunctionDisable()) {
            SourceLog.i(TAG, "addHistoryDevice ignore, function disable");
            return;
        }
        if (!Preference.getInstance().get(Constant.KEY_ENABLE_HISTORY_DEV, false)) {
            SourceLog.i(TAG, "addHistoryDevice ignore, sp disable");
            return;
        }
        if (emptySourceID()) {
            SourceLog.i(TAG, "addHistoryDevice ignore, null source id");
            return;
        }
        if (lelinkServiceInfo == null) {
            SourceLog.i(TAG, "addHistoryDevice ignore, null service info");
            return;
        }
        ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid());
        if (connectBridge == null) {
            SourceLog.i(TAG, "addHistoryDevice ignore, not connect 1");
            return;
        }
        String connectBean = connectBridge.getConnectBean();
        if (connectBean == null) {
            SourceLog.i(TAG, "addHistoryDevice ignore, not connect 2");
            return;
        }
        try {
            i10 = new JSONObject(connectBean).optInt("historyDev", 1);
        } catch (Exception e10) {
            SourceLog.w(TAG, "addHistoryDevice " + e10.getMessage());
            i10 = 1;
        }
        SourceLog.i(TAG, "addHistoryDevice, historyDev: " + i10);
        if (i10 != 1) {
            SourceLog.i(TAG, "addHistoryDevice ignore, sink not support");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", Session.getInstance().getSourceID());
            jSONObject.put("appId", String.valueOf(lelinkServiceInfo.getAppId()));
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
        } catch (Exception e11) {
            SourceLog.i(TAG, e11.toString());
        }
        String jSONObject2 = jSONObject.toString();
        SourceLog.i(TAG, "addHistoryDevice " + CloudAPI.sAddHistoryDevice + Operator.Operation.EMPTY_PARAM + jSONObject2);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sAddHistoryDevice, jSONObject2);
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.HistoryDeviceManager.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (HistoryDeviceManager.this.isResultInvalid(asyncHttpParameter2)) {
                    SourceLog.i(HistoryDeviceManager.TAG, "addHistoryDevice ignore");
                    return;
                }
                SourceLog.i(HistoryDeviceManager.TAG, "addHistoryDevice result: " + asyncHttpParameter2.out.result);
            }
        });
    }

    public void getHistoryDeviceList(int i10, final int i11) {
        if (!Preference.getInstance().get(Constant.KEY_ENABLE_HISTORY_DEV, false)) {
            onGetDeviceCallback(false, DeviceListenerConstant.ERROR_HISTORY_DEV_SWITCH_CLOSED, null);
            return;
        }
        if (isFunctionDisable()) {
            onGetDeviceCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE, null);
            return;
        }
        if (emptySourceID()) {
            onGetDeviceCallback(false, -100, null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Session.getInstance().getSourceID());
        if (i10 == 1) {
            hashMap.put("online", "1");
        } else if (i10 == 2) {
            hashMap.put("online", "0");
        }
        String mapParams = HapplayUtils.getMapParams(hashMap);
        SourceLog.i(TAG, "getHistoryDeviceList " + CloudAPI.sGetHistoryDevice + Operator.Operation.EMPTY_PARAM + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGetHistoryDevice, mapParams);
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 0;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.HistoryDeviceManager.3
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (HistoryDeviceManager.this.isResultInvalid(asyncHttpParameter2)) {
                    HistoryDeviceManager.this.onGetDeviceCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE, null);
                    return;
                }
                SourceLog.i(HistoryDeviceManager.TAG, "getHistoryDeviceList result: " + asyncHttpParameter2.out.result);
                int parseCode = HistoryDeviceManager.this.parseCode(asyncHttpParameter2.out.result);
                if (parseCode != 200) {
                    HistoryDeviceManager.this.onGetDeviceCallback(false, parseCode, null);
                } else {
                    HistoryDeviceManager.this.parseDevice(i11, asyncHttpParameter2.out.result, new IBrowseListener() { // from class: com.hpplay.sdk.source.business.cloud.HistoryDeviceManager.3.1
                        @Override // com.hpplay.sdk.source.browse.api.IBrowseListener
                        public void onBrowse(int i12, List<LelinkServiceInfo> list) {
                            if (i12 == 1) {
                                HistoryDeviceManager.this.onGetDeviceCallback(true, 200, list);
                            } else {
                                HistoryDeviceManager.this.onGetDeviceCallback(false, DeviceListenerConstant.ERROR_PARSE_ERROR, null);
                            }
                        }
                    });
                }
            }
        });
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        if (!Preference.getInstance().get(Constant.KEY_ENABLE_HISTORY_DEV, false)) {
            onRemoveCallback(false, DeviceListenerConstant.ERROR_HISTORY_DEV_SWITCH_CLOSED);
            return;
        }
        if (isFunctionDisable()) {
            onRemoveCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE);
            return;
        }
        if (emptySourceID()) {
            onRemoveCallback(false, -100);
            return;
        }
        if (i10 == 0 && (list == null || list.isEmpty())) {
            onRemoveCallback(false, -101);
            return;
        }
        String valueOf = String.valueOf(2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", Session.getInstance().getSourceID());
            if (i10 == 1) {
                valueOf = String.valueOf(1);
                jSONObject.put("devices", new JSONArray());
            } else {
                JSONArray jSONArray = new JSONArray();
                for (LelinkServiceInfo lelinkServiceInfo : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appId", String.valueOf(lelinkServiceInfo.getAppId()));
                    jSONObject2.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("devices", jSONArray);
            }
        } catch (Exception e10) {
            SourceLog.i(TAG, e10.toString());
        }
        String jSONObject3 = jSONObject.toString();
        SourceLog.i(TAG, "removeHistoryDevice " + CloudAPI.sRemoveHistoryDevice + "?delType=" + valueOf + Operator.Operation.DIVISION + jSONObject3);
        StringBuilder sb = new StringBuilder();
        sb.append(CloudAPI.sRemoveHistoryDevice);
        sb.append("?delType=");
        sb.append(valueOf);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(sb.toString(), jSONObject3);
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.HistoryDeviceManager.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (HistoryDeviceManager.this.isResultInvalid(asyncHttpParameter2)) {
                    HistoryDeviceManager.this.onRemoveCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE);
                    return;
                }
                SourceLog.i(HistoryDeviceManager.TAG, "removeHistoryDevice result: " + asyncHttpParameter2.out.result);
                int parseCode = HistoryDeviceManager.this.parseCode(asyncHttpParameter2.out.result);
                HistoryDeviceManager.this.onRemoveCallback(parseCode == 200, parseCode);
            }
        });
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        this.mHistoryDeviceListener = iHistoryDeviceListener;
    }
}
