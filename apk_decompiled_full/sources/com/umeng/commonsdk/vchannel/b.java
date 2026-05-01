package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f11290b;

    /* renamed from: a, reason: collision with root package name */
    private String f11289a = "_$unknown";

    /* renamed from: c, reason: collision with root package name */
    private long f11291c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f11292d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f11293e = a.f11288j;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Object> f11294f = null;

    public b(Context context) {
        this.f11290b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f11289a;
    }

    public long b() {
        return this.f11291c;
    }

    public Map<String, Object> c() {
        return this.f11294f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f11289a);
            jSONObject.put("pn", this.f11290b);
            jSONObject.put("ds", this.f11292d);
            jSONObject.put("ts", this.f11291c);
            Map<String, Object> map = this.f11294f;
            if (map != null && map.size() > 0) {
                for (String str : this.f11294f.keySet()) {
                    jSONObject.put(str, this.f11294f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f11293e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f11289a + ",");
        sb.append("pn:" + this.f11290b + ",");
        sb.append("ts:" + this.f11291c + ",");
        Map<String, Object> map = this.f11294f;
        if (map != null && map.size() > 0) {
            for (String str : this.f11294f.keySet()) {
                Object obj = this.f11294f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f11292d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f11289a = str;
    }

    public void a(long j10) {
        this.f11291c = j10;
    }

    public void a(Map<String, Object> map) {
        this.f11294f = map;
    }
}
