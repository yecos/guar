package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HpplayUtil {
    private static final String TAG = "CastUtil";

    public static String getVipAuthInfoLeBoSign(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONArray optJSONArray = new JSONObject(str2).optJSONObject("data").optJSONArray("authinfo");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return "";
            }
            JSONArray sortJsonArray = JSONUtil.getSortJsonArray(optJSONArray, true);
            int length = sortJsonArray.length();
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < length; i10++) {
                String obj = sortJsonArray.get(i10).toString();
                if (i10 == 0) {
                    sb.append("[");
                    sb.append(obj);
                } else if (i10 == sortJsonArray.length() - 1) {
                    sb.append(",");
                    sb.append(obj);
                    sb.append("]");
                } else {
                    sb.append(",");
                    sb.append(obj);
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return "";
            }
            return EncryptUtil.md5EncryData(sb2 + context.getPackageName() + str + Session.getInstance().appSecret);
        } catch (Exception e10) {
            SourceLog.w(TAG, "getVipAuthInfoLeBoSign Exception: " + e10);
            return "";
        }
    }

    public static String getVipAuthInfoSign(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONArray optJSONArray = new JSONObject(str2).optJSONObject("data").optJSONArray("authinfo");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return "";
            }
            String jSONArray = JSONUtil.getSortJsonArray(optJSONArray, false).toString();
            if (TextUtils.isEmpty(jSONArray)) {
                return "";
            }
            return EncryptUtil.md5EncryData(jSONArray + context.getPackageName() + str + Session.getInstance().appSecret);
        } catch (JSONException e10) {
            SourceLog.w(TAG, "getVipAuthInfoSign JSONException: " + e10);
            return "";
        }
    }

    public static boolean isDigitsOnly(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isDigitsOnly(str) || TextUtils.isDigitsOnly(str.replaceFirst(Operator.Operation.MINUS, ""));
    }

    public static boolean isWifiApOpen(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return ((Boolean) wifiManager.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            SourceLog.w(TAG, " getWifiApState  check wifi ip error ");
            return false;
        }
    }

    public static String secToTime(long j10) {
        if (j10 <= 0) {
            return "00:00:00";
        }
        int i10 = (int) (j10 / 60);
        if (i10 < 60) {
            return "00:" + unitFormat(i10) + SOAP.DELIM + unitFormat((int) (j10 % 60));
        }
        int i11 = i10 / 60;
        if (i11 > 99) {
            return "99:59:59";
        }
        return unitFormat(i11) + SOAP.DELIM + unitFormat(i10 % 60) + SOAP.DELIM + unitFormat((int) ((j10 - (i11 * 3600)) - (r3 * 60)));
    }

    public static String unitFormat(int i10) {
        if (i10 < 0 || i10 >= 10) {
            return "" + i10;
        }
        return "0" + i10;
    }
}
