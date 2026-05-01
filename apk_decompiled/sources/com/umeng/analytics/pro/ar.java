package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9898a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b, reason: collision with root package name */
    private String f9899b;

    /* renamed from: c, reason: collision with root package name */
    private String f9900c;

    /* renamed from: d, reason: collision with root package name */
    private String f9901d;

    public ar(String str, JSONObject jSONObject, String str2) {
        this.f9899b = str;
        this.f9900c = jSONObject.toString();
        this.f9901d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] a10 = ap.a(this.f9899b, this.f9900c);
            if (a10 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a10));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f9901d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
