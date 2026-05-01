package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.component.protocol.PlistBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.custommapping.UAPMCustomMapping;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f9890a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = f9890a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f9890a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put("dm", Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.f10046g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bt.al, UMUtils.getZid(context));
            jSONObject2.put("sv", "9.7.9");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_CT, localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put(PlistBuilder.KEY_AUDIO_SOCKET_TYPE, networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bt.f10036a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + Operator.Operation.MULTIPLY + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bt.f10039b, "9.7.9");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", "Android");
            }
            jSONObject2.put(com.umeng.ccg.a.f10658r, str);
            jSONObject2.put(com.umeng.ccg.a.f10661u, jSONArray);
            f9890a = jSONObject2;
        } catch (Throwable unused) {
        }
        return f9890a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("ekv", jSONArray);
                return jSONObject3;
            } catch (Throwable unused) {
                jSONObject2 = jSONObject3;
                return jSONObject2;
            }
        } catch (Throwable unused2) {
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            an anVar = new an();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            anVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            anVar.b(appkey);
            anVar.c(UMUtils.getAppVersionName(context));
            anVar.d("9.7.9");
            anVar.e(UMUtils.getChannel(context));
            anVar.f(Build.VERSION.SDK_INT + "");
            anVar.g(Build.BRAND);
            anVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            anVar.i(localeInfo[1]);
            anVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            anVar.b(Integer.valueOf(resolutionArray[1]));
            anVar.a(Integer.valueOf(resolutionArray[0]));
            anVar.k(as.a(context, "install_datetime", ""));
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e10) {
                e = e10;
            }
            try {
                jSONObject.put(an.f9864a, anVar.a());
                jSONObject.put(an.f9866c, anVar.c());
                jSONObject.put(an.f9865b, anVar.b());
                jSONObject.put(an.f9867d, anVar.d());
                jSONObject.put(an.f9868e, anVar.e());
                jSONObject.put(an.f9869f, anVar.f());
                jSONObject.put(an.f9870g, anVar.g());
                jSONObject.put(an.f9871h, anVar.h());
                jSONObject.put(an.f9874k, anVar.k());
                jSONObject.put(an.f9873j, anVar.j());
                jSONObject.put(an.f9875l, anVar.l());
                jSONObject.put(an.f9872i, anVar.i());
                jSONObject.put(an.f9876m, anVar.m());
                jSONObject.put(bt.al, UMUtils.getZid(context));
                jSONObject.put(DispatchConstants.PLATFORM, "android");
                jSONObject.put("optional", new JSONObject(as.a()));
                String[] split = str.split("@");
                if (split.length == 4) {
                    try {
                        long parseLong = Long.parseLong(split[0]);
                        String str2 = split[1];
                        jSONObject.put(UAPMCustomMapping.STRING_PARAM_1, parseLong);
                        jSONObject.put(UAPMCustomMapping.STRING_PARAM_2, str2);
                    } catch (Throwable unused) {
                    }
                }
                try {
                    String str3 = Build.BRAND;
                    String a10 = at.a(str3);
                    String b10 = at.b(str3);
                    if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(b10)) {
                        jSONObject.put(an.f9877n, a10);
                        jSONObject.put(an.f9878o, b10);
                    } else {
                        jSONObject.put(an.f9877n, "Android");
                        jSONObject.put(an.f9878o, Build.VERSION.RELEASE);
                    }
                } catch (Throwable unused2) {
                }
                return jSONObject;
            } catch (JSONException e11) {
                e = e11;
                jSONObject2 = jSONObject;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                return jSONObject2;
            } catch (Throwable th) {
                th = th;
                jSONObject2 = jSONObject;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                return jSONObject2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject a(Context context, int i10, JSONArray jSONArray, String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (TextUtils.isEmpty(zid)) {
                    return jSONObject2;
                }
                jSONObject2.put("atoken", zid);
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject2.put("device_token", deviceToken);
                }
                jSONObject2.put(Constants.KEY_MODEL, Build.MODEL);
                jSONObject2.put("os", "android");
                jSONObject2.put(bt.f10064y, Build.VERSION.RELEASE);
                jSONObject2.put(com.umeng.ccg.a.f10658r, str);
                jSONObject2.put(com.umeng.ccg.a.f10661u, jSONArray);
                jSONObject2.put("e", i10);
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
    }
}
