package com.hpplay.sdk.source.business.cloud;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ADENSTUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.AnalyticsConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LicenseManager {
    private static final String TAG = "LicenseManager";
    private static LicenseManager sInstance;
    private ILicenseCheckListener mListener;
    private AsyncTask mTask;
    private int mAuthCode = -1;
    private Date mStartTime = null;
    private Date mEndTime = null;
    private boolean mRequestDone = false;

    public interface ILicenseCheckListener {
        void checkLicense(boolean z10);
    }

    private LicenseManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackError(int i10) {
        LelinkPlayerListenerDispatcher listenerDispatcher = BusinessEntity.getInstance().getListenerDispatcher();
        if (listenerDispatcher == null) {
            return;
        }
        int i11 = PlayerListenerConstant.EXTRA_ERROR_LICENSE_REQUEST;
        if (i10 != -1) {
            if (i10 == 1) {
                i11 = PlayerListenerConstant.EXTRA_ERROR_LICENSE_NOT_SUPPORT;
            } else if (i10 == 2) {
                i11 = PlayerListenerConstant.EXTRA_ERROR_LICENSE_FORBID;
            } else if (i10 == 3) {
                i11 = PlayerListenerConstant.EXTRA_ERROR_LICENSE_QUANTITY_OVER_LIMIT;
            } else if (i10 == 4) {
                i11 = PlayerListenerConstant.EXTRA_ERROR_LICENSE_OUT_OF_TIME;
            }
        }
        listenerDispatcher.onError(null, PlayerListenerConstant.WHAT_ERROR_LICENSE_INVALID, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getCheckResult() {
        if (this.mAuthCode != 0) {
            SourceLog.i(TAG, "checkLicense fail, authCode :" + this.mAuthCode);
            return false;
        }
        Date date = new Date();
        Date date2 = this.mStartTime;
        if (date2 != null && !date.after(date2)) {
            SourceLog.w(TAG, "checkLicense fail, wrong start time");
            return false;
        }
        Date date3 = this.mEndTime;
        if (date3 == null || date.before(date3)) {
            return true;
        }
        SourceLog.w(TAG, "checkLicense fail, wrong end time");
        return false;
    }

    public static synchronized LicenseManager getInstance() {
        LicenseManager licenseManager;
        synchronized (LicenseManager.class) {
            if (sInstance == null) {
                sInstance = new LicenseManager();
            }
            licenseManager = sInstance;
        }
        return licenseManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseLicense(Context context, String str, String str2) {
        JSONObject jSONObject;
        int optInt;
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseLicense,json is invalid");
            return -1;
        }
        try {
            jSONObject = new JSONObject(str);
            optInt = jSONObject.optInt(Constant.KEY_STATUS);
        } catch (Exception e10) {
            SourceLog.w(TAG, "parseLicense,error :" + e10);
        }
        if (optInt != 200) {
            SourceLog.w(TAG, "parseLicense, error status :" + optInt);
            return getCheckResult() ? 0 : -1;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            SourceLog.w(TAG, "parseLicense, error data");
            return -1;
        }
        int optInt2 = optJSONObject.optInt("authCode", -1);
        long optLong = optJSONObject.optLong("stime");
        String optString = optJSONObject.optString(AnalyticsConfig.RTD_START_TIME);
        String optString2 = optJSONObject.optString("endTime");
        String optString3 = optJSONObject.optString("sign");
        StringBuilder sb = new StringBuilder();
        sb.append(optInt2);
        sb.append(str2);
        sb.append(context.getPackageName());
        sb.append(optLong);
        if (!TextUtils.isEmpty(optString)) {
            sb.append(optString);
        }
        if (!TextUtils.isEmpty(optString2)) {
            sb.append(optString2);
        }
        sb.append(Session.getInstance().appSecret);
        String encryptMD5ToString = EncryptUtil.encryptMD5ToString(sb.toString());
        if (!TextUtils.isEmpty(encryptMD5ToString)) {
            encryptMD5ToString = encryptMD5ToString.toLowerCase();
        }
        if (!TextUtils.isEmpty(encryptMD5ToString) && !TextUtils.isEmpty(optString3) && optString3.equals(encryptMD5ToString)) {
            updateLicense(optInt2, optString, optString2);
            saveLicense(optInt2, optString, optString2);
            return optInt2;
        }
        SourceLog.w(TAG, "parseLicense, sign wrong:" + optString3 + Operator.Operation.DIVISION + encryptMD5ToString);
        return -1;
    }

    private void saveLicense(int i10, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authCode", i10);
            jSONObject.put(AnalyticsConfig.RTD_START_TIME, str);
            jSONObject.put("endTime", str2);
            Preference.getInstance().put(Preference.KEY_LICENSE, ADENSTUtils.encrypt(jSONObject.toString()));
        } catch (Exception e10) {
            SourceLog.w(TAG, "saveLicense,error :" + e10);
        }
    }

    private void updateLicense(int i10, String str, String str2) {
        this.mAuthCode = i10;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            if (TextUtils.isEmpty(str)) {
                this.mStartTime = null;
            } else {
                if (!str.contains(SOAP.DELIM)) {
                    str = str.trim() + " 00:00:00";
                }
                this.mStartTime = simpleDateFormat.parse(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.mEndTime = null;
                return;
            }
            if (!str2.contains(SOAP.DELIM)) {
                str2 = str2.trim() + " 23:59:59";
            }
            this.mEndTime = simpleDateFormat.parse(str2);
        } catch (Exception e10) {
            SourceLog.w(TAG, "updateLicense,error :" + e10);
        }
    }

    public void checkLicense(ILicenseCheckListener iLicenseCheckListener) {
        this.mListener = iLicenseCheckListener;
        boolean checkResult = getCheckResult();
        SourceLog.i(TAG, "checkLicense, mRequestDone :" + this.mRequestDone + ", cachedResult :" + checkResult);
        if ((this.mRequestDone || checkResult) && iLicenseCheckListener != null) {
            iLicenseCheckListener.checkLicense(checkResult);
        }
    }

    public void readCachedLicense() {
        try {
            String str = Preference.getInstance().get(Preference.KEY_LICENSE, (String) null);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String decrypt = ADENSTUtils.decrypt(str);
            SourceLog.debug(TAG, "getCachedLicense, license :" + decrypt);
            JSONObject jSONObject = new JSONObject(decrypt);
            updateLicense(jSONObject.optInt("authCode", -1), jSONObject.optString(AnalyticsConfig.RTD_START_TIME), jSONObject.optString("endTime"));
        } catch (Exception e10) {
            SourceLog.w(TAG, "getCachedLicense,error :" + e10);
        }
    }

    public void requestLicense(final Context context) {
        AsyncTask asyncTask = this.mTask;
        if (asyncTask != null) {
            try {
                asyncTask.cancel(true);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            this.mTask = null;
        }
        final String str = Preference.getInstance().get(Preference.KEY_LICENSE_TSN, "");
        final Session session = Session.getInstance();
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, session.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, session.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, session.getToken());
        hashMap.put("lbsn", DeviceUtil.getAID(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("tsn", str);
        }
        String mapParams = HapplayUtils.getMapParams(hashMap);
        SourceLog.debug(TAG, "requestLicense " + CloudAPI.sLicenseAuth + Operator.Operation.EMPTY_PARAM + mapParams);
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sLicenseAuth, httpEncrypt.encode(mapParams));
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.requestHeaders = httpEncrypt.buildHeader();
        this.mTask = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.LicenseManager.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                int i10;
                LicenseManager.this.mTask = null;
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out != null && out.resultType == 2) {
                    SourceLog.i(LicenseManager.TAG, "requestLicense ignore cancel");
                    return;
                }
                if (out == null || out.resultType != 0) {
                    i10 = -1;
                } else {
                    String decode = httpEncrypt.decode(out);
                    SourceLog.debug(LicenseManager.TAG, "requestLicense result: " + decode);
                    String str2 = str;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = session.getUID();
                    }
                    i10 = LicenseManager.this.parseLicense(context, decode, str2);
                }
                if (!LicenseManager.this.mRequestDone && LicenseManager.this.mListener != null) {
                    LicenseManager.this.mListener.checkLicense(LicenseManager.this.getCheckResult());
                    LicenseManager.this.mListener = null;
                }
                LicenseManager.this.mRequestDone = true;
                if (i10 != 0) {
                    LicenseManager.this.callbackError(i10);
                }
            }
        });
    }
}
