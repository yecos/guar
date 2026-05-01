package com.umeng.message.proguard;

import com.hpplay.cybergarage.http.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    long f11523a;

    /* renamed from: b, reason: collision with root package name */
    int f11524b;

    /* renamed from: c, reason: collision with root package name */
    long f11525c;

    /* renamed from: d, reason: collision with root package name */
    long f11526d;

    /* renamed from: e, reason: collision with root package name */
    long f11527e;

    /* renamed from: f, reason: collision with root package name */
    boolean f11528f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11529g;

    /* renamed from: h, reason: collision with root package name */
    String[] f11530h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f11531i;

    public final boolean a() {
        return !this.f11531i;
    }

    public final synchronized void a(JSONObject jSONObject) {
        this.f11523a = jSONObject.optLong("duration") * 1000;
        this.f11524b = jSONObject.optInt("count");
        this.f11525c = jSONObject.optLong("delay") * 1000;
        this.f11526d = jSONObject.optLong("ttl") * 60 * 1000;
        this.f11527e = jSONObject.optLong("valid") * 60 * 1000;
        this.f11528f = jSONObject.optInt(HTTP.CLOSE, 0) == 1;
        this.f11529g = jSONObject.optInt("swipe", 1) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("activity");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f11530h = new String[optJSONArray.length()];
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                this.f11530h[i10] = optJSONArray.optString(i10);
            }
        }
        this.f11531i = true;
    }
}
