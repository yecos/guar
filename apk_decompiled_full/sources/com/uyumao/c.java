package com.uyumao;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12385a = false;

    /* renamed from: b, reason: collision with root package name */
    public static h f12386b;

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(Context context, i iVar, JSONArray jSONArray) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String valueOf;
        String str = "";
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("ak", UMUtils.getAppkey(context));
                if (UMUtils.getUMId(context) == null) {
                    jSONObject.put(bt.f10046g, "");
                } else {
                    jSONObject.put(bt.f10046g, UMUtils.getUMId(context));
                }
                if (UMUtils.getActiveUser(context) == null || UMUtils.getActiveUser(context).length != 2) {
                    jSONObject.put(com.umeng.analytics.pro.f.N, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.f.N, UMUtils.getActiveUser(context)[1]);
                }
                if (DeviceConfig.getAndroidId(context) == null) {
                    jSONObject.put("aid", "");
                } else {
                    jSONObject.put("aid", DeviceConfig.getAndroidId(context));
                }
                if (UMUtils.getZid(context) == null) {
                    jSONObject.put("atoken", "");
                } else {
                    jSONObject.put("atoken", UMUtils.getZid(context));
                }
                jSONObject.put("oaid", DeviceConfig.getOaid(context));
                jSONObject.put("idfa", DeviceConfig.getIdfa(context));
                jSONObject.put("db", Build.BRAND);
                jSONObject.put("dm", Build.MODEL);
                jSONObject.put("os", "Android");
                jSONObject.put("ov", Build.VERSION.RELEASE);
                jSONObject.put("sv", "1.1.4");
                jSONObject.put("av", DeviceConfig.getAppVersionName(context));
                jSONObject.put("chn", UMUtils.getChannel(context));
                jSONObject.put("cts", System.currentTimeMillis());
                jSONObject.put("pkg", DeviceConfig.getPackageName(context));
                String string = context.getSharedPreferences("uyumao_info", 0).getString(bd.f9976c, "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(bd.f9976c, string);
                }
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                if (jSONObject != null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            jSONObject = null;
        }
        if (jSONObject != null) {
            return null;
        }
        try {
            jSONObject2 = new JSONObject();
            if (iVar != null) {
                jSONObject2.put("le", iVar.f12414a);
                jSONObject2.put("vo", iVar.f12415b);
                jSONObject2.put("te", iVar.f12416c);
                jSONObject2.put("st", iVar.f12417d);
                jSONObject2.put("ch", iVar.f12418e);
                jSONObject2.put("ts", iVar.f12419f);
            }
            jSONObject3 = new JSONObject();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (context != null) {
            try {
                valueOf = String.valueOf(context.getResources().getConfiguration().mcc);
            } catch (Throwable unused) {
            }
            jSONObject3.put("mcc", valueOf);
            if (context != null) {
                try {
                    int i10 = context.getResources().getConfiguration().mnc;
                    str = i10 < 10 ? String.format("%02d", Integer.valueOf(i10)) : String.valueOf(i10);
                } catch (Throwable unused2) {
                }
            }
            jSONObject3.put(DispatchConstants.MNC, str);
            jSONObject3.put("net", e.c(context)[0]);
            jSONObject3.put(bt.Z, jSONObject2);
            if (jSONArray != null && jSONArray.length() != 0) {
                jSONObject3.put("net_state", jSONArray);
            }
            jSONObject.put("anti", jSONObject3);
            return jSONObject;
        }
        valueOf = "";
        jSONObject3.put("mcc", valueOf);
        if (context != null) {
        }
        jSONObject3.put(DispatchConstants.MNC, str);
        jSONObject3.put("net", e.c(context)[0]);
        jSONObject3.put(bt.Z, jSONObject2);
        if (jSONArray != null) {
            jSONObject3.put("net_state", jSONArray);
        }
        jSONObject.put("anti", jSONObject3);
        return jSONObject;
    }

    public static void a(Context context, JSONObject jSONObject, boolean z10) {
        if (jSONObject == null) {
            Log.e("UYMInnerManager", "JSONObject in sendInitData() is null.");
            return;
        }
        String a10 = k.a(context, "https://yumao.puata.info/anti_logs", jSONObject.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("msg: ");
        sb.append(a10);
        sb.append("; json: ");
        sb.append(jSONObject);
        if (a10 == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(a10);
            if (jSONObject2.has(bd.f9976c)) {
                context.getSharedPreferences("uyumao_info", 0).edit().putString(bd.f9976c, jSONObject2.optString(bd.f9976c)).apply();
            }
            if (z10) {
                if (jSONObject2.has("resp_code") && jSONObject2.optInt("resp_code") == 0) {
                    context.getSharedPreferences("uyumao_info", 0).edit().putBoolean(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()), true).apply();
                }
                e.a(new File(context.getCacheDir() + File.separator + "net_change"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
