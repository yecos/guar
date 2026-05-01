package com.uyumao;

import android.content.Context;
import android.util.Log;
import com.umeng.analytics.pro.bd;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r9, com.uyumao.i r10, org.json.JSONArray r11) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.c.a(android.content.Context, com.uyumao.i, org.json.JSONArray):org.json.JSONObject");
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
