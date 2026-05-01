package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ad extends ab {

    /* renamed from: a, reason: collision with root package name */
    private String f9845a;

    /* renamed from: b, reason: collision with root package name */
    private String f9846b;

    public ad(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
        this.f9845a = "";
        this.f9846b = "";
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (a10 != null) {
            try {
                a10.put(com.umeng.ccg.a.f10662v, this.f9845a);
                a10.put("action", this.f9846b);
            } catch (Throwable unused) {
            }
        }
        return a10;
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has("action")) {
            d(jSONObject.optString("action"));
        }
        if (jSONObject.has(com.umeng.ccg.a.f10662v)) {
            c(jSONObject.optString(com.umeng.ccg.a.f10662v));
        }
    }

    public void c(String str) {
        this.f9845a = str;
    }

    public String d() {
        return this.f9845a;
    }

    public String e() {
        return this.f9846b;
    }

    public void d(String str) {
        this.f9846b = str;
    }
}
