package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.PassSinkAuthBean;
import com.hpplay.sdk.source.bean.VipAuthResultBean;
import com.hpplay.sdk.source.bean.VipAuthSetting;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RightsManager {
    private static final String TAG = "RightsManager";
    public static final String VIP_KEY_LEBO_CLOUDMIRROR = "LEBO_CLOUDMIRROR_QY";
    private static Session mSession;
    private static RightsManager singleInstance;
    private List<VipAuthResultBean.VipAuthDataEntity.AuthInfo> mSourceAuthInfo;
    private Map<String, List<VipAuthResultBean.VipAuthDataEntity.AuthInfo>> mSinkAuthInfoMap = new HashMap();
    private Map<String, PassSinkAuthBean> mPassSinkAuthMap = new HashMap();

    private RightsManager() {
        mSession = Session.getInstance();
    }

    public static synchronized RightsManager getInstance() {
        RightsManager rightsManager;
        synchronized (RightsManager.class) {
            if (singleInstance == null) {
                synchronized (RightsManager.class) {
                    if (singleInstance == null) {
                        singleInstance = new RightsManager();
                    }
                }
            }
            rightsManager = singleInstance;
        }
        return rightsManager;
    }

    private boolean hasVipFeatureInAuthInfo(String str, List<VipAuthResultBean.VipAuthDataEntity.AuthInfo> list) {
        if (list != null && str != null) {
            Iterator<VipAuthResultBean.VipAuthDataEntity.AuthInfo> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void requestSinkTempVipInfo(final String str, String str2) {
        HashMap hashMap = new HashMap();
        Session session = Session.getInstance();
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, session.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, session.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_RECEIVER_UID, str);
        hashMap.put("rappid", str2);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, session.getToken());
        hashMap.put("sdkVer", String.valueOf(41214));
        SourceLog.i(TAG, "requestSinkVipInfo " + CloudAPI.sTemporaryAuth + Operator.Operation.EMPTY_PARAM + HapplayUtils.getJsonParams(hashMap));
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sTemporaryAuth, HapplayUtils.getJsonParams(hashMap));
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTaskWithoutParallel(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.RightsManager.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                VipAuthResultBean.VipAuthDataEntity vipAuthDataEntity;
                SourceLog.debug(RightsManager.TAG, "requestSinkVipInfo result: " + asyncHttpParameter2.out.result);
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.i(RightsManager.TAG, "requestSinkVipInfo onRequestResult,cancel request");
                    return;
                }
                try {
                    VipAuthResultBean vipAuthResultBean = new VipAuthResultBean(new JSONObject(asyncHttpParameter2.out.result));
                    if (vipAuthResultBean.status == 200 && (vipAuthDataEntity = vipAuthResultBean.data) != null) {
                        if (TextUtils.isEmpty(vipAuthDataEntity.sign) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter2.out.result)) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoLeBoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter2.out.result))) {
                            RightsManager.this.mSinkAuthInfoMap.put(str, vipAuthResultBean.data.authinfo);
                            return;
                        } else {
                            SourceLog.i(RightsManager.TAG, "requestSinkVipInfo sign not pass ");
                            return;
                        }
                    }
                    SourceLog.i(RightsManager.TAG, "requestSinkVipInfo data is illegal argument");
                } catch (Exception e10) {
                    SourceLog.w(RightsManager.TAG, e10);
                }
            }
        });
    }

    public void getSinkTempRights(String str, int i10, int i11) {
        if (i11 == 4) {
            requestSinkTempVipInfo(str, String.valueOf(i10));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, str);
        } catch (JSONException e10) {
            SourceLog.w(TAG, e10);
        }
        PassSender.getInstance().sendVIPQuery(jSONObject.toString());
    }

    public void handleNetConnectMessage(String str, String str2) {
        try {
            SourceLog.i(TAG, "handleNetConnectMessage: " + str + " / " + str2);
            this.mPassSinkAuthMap.put(str, new PassSinkAuthBean(new JSONObject(str2)));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void handleRightMessage(String str, String str2) {
        try {
            SourceLog.i(TAG, "handleRightMessage: " + str + " / " + str2);
            this.mPassSinkAuthMap.put(str, new PassSinkAuthBean(new JSONObject(str2)));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public boolean hasVipFeature(String str, String str2) {
        boolean z10;
        if (Feature.isLeboApp()) {
            return true;
        }
        PassSinkAuthBean passSinkAuthBean = this.mPassSinkAuthMap.get(str);
        if (passSinkAuthBean != null) {
            z10 = passSinkAuthBean.enterprise;
            if (VIP_KEY_LEBO_CLOUDMIRROR.equals(str2)) {
                if (z10 || passSinkAuthBean.cm) {
                    z10 = true;
                }
            }
            return !z10 ? true : true;
        }
        z10 = false;
        return !z10 ? true : true;
    }

    public void loginVipAuth(VipAuthSetting vipAuthSetting) {
        loginVipAuth(vipAuthSetting, 2);
    }

    public void logout() {
        SourceLog.i(TAG, "logout");
        this.mSourceAuthInfo = null;
        Preference.getInstance().put(Constant.KEY_VUUID, "");
        Preference.getInstance().put(Constant.KEY_VSESSION, "");
    }

    public void removeSinkRights(String str) {
        SourceLog.i(TAG, "removeSinkRights:" + str);
        this.mSinkAuthInfoMap.remove(str);
        this.mPassSinkAuthMap.remove(str);
    }

    public void vipAuth() {
        SourceLog.i(TAG, "vipAuth");
        vipAuth(2);
    }

    private void loginVipAuth(VipAuthSetting vipAuthSetting, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, mSession.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, mSession.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, mSession.getToken());
        hashMap.put("tid", mSession.tid);
        hashMap.put("uuid", vipAuthSetting == null ? "" : vipAuthSetting.uuid);
        hashMap.put(BrowserInfo.KEY_SSID, vipAuthSetting == null ? "" : vipAuthSetting.ssid);
        hashMap.put(ParamsMap.DeviceParams.KEY_HID, mSession.getHID());
        hashMap.put("sdk_ver", String.valueOf(41214));
        hashMap.put("ehid", Preference.getInstance().get(Constant.KEY_SUPER_DEVICE_ID, ""));
        hashMap.put("prot_ver", "1.0");
        SourceLog.i(TAG, "loginVipAuth " + CloudAPI.sVipAuth + "," + HapplayUtils.getJsonParams(hashMap));
        final AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sVipAuth, HapplayUtils.getJsonParams(hashMap), i10);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.RightsManager.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                VipAuthResultBean.VipAuthDataEntity vipAuthDataEntity;
                SourceLog.debug(RightsManager.TAG, "loginVipAuth onRequestResult = " + asyncHttpParameter2.out.result);
                int i11 = asyncHttpParameter2.out.resultType;
                if (i11 == 2) {
                    SourceLog.w(RightsManager.TAG, "loginVipAuth cancel request");
                    return;
                }
                if (i11 == 0) {
                    try {
                        VipAuthResultBean vipAuthResultBean = new VipAuthResultBean(new JSONObject(asyncHttpParameter2.out.result));
                        int i12 = vipAuthResultBean.status;
                        if (i12 != 200 && asyncHttpParameter2.out.requestTryCount < asyncHttpParameter.in.tryCount) {
                            SourceLog.i(RightsManager.TAG, "loginVipAuth status illgeal,request again: " + asyncHttpParameter2.out.requestTryCount);
                            RightsManager.this.vipAuth(asyncHttpParameter.in.tryCount - asyncHttpParameter2.out.requestTryCount);
                            return;
                        }
                        if (i12 == 404) {
                            RightsManager.this.logout();
                            return;
                        }
                        if (i12 == 200 && (vipAuthDataEntity = vipAuthResultBean.data) != null) {
                            if (TextUtils.isEmpty(vipAuthDataEntity.sign) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter2.out.result)) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoLeBoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter2.out.result))) {
                                RightsManager.this.mSourceAuthInfo = vipAuthResultBean.data.authinfo;
                                return;
                            } else {
                                SourceLog.i(RightsManager.TAG, "loginVipAuth sign not pass ");
                                return;
                            }
                        }
                        SourceLog.i(RightsManager.TAG, "loginVipAuth data is illegal argument");
                    } catch (Exception e10) {
                        SourceLog.w(RightsManager.TAG, e10);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vipAuth(int i10) {
        String str = Preference.getInstance().get(Constant.KEY_VUUID, "");
        String str2 = Preference.getInstance().get(Constant.KEY_VSESSION, "");
        VipAuthSetting vipAuthSetting = new VipAuthSetting();
        vipAuthSetting.uuid = str;
        vipAuthSetting.ssid = str2;
        loginVipAuth(vipAuthSetting, i10);
    }
}
