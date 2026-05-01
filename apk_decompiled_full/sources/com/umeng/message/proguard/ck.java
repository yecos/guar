package com.umeng.message.proguard;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.bx;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ck {

    /* renamed from: a, reason: collision with root package name */
    public final bx.c f11739a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f11740b;

    /* renamed from: c, reason: collision with root package name */
    public String f11741c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11742d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11743e;

    /* renamed from: f, reason: collision with root package name */
    public int f11744f;

    /* renamed from: g, reason: collision with root package name */
    public int f11745g;

    /* renamed from: h, reason: collision with root package name */
    public int f11746h;

    /* renamed from: i, reason: collision with root package name */
    public long f11747i;

    /* renamed from: j, reason: collision with root package name */
    public long f11748j;

    /* renamed from: k, reason: collision with root package name */
    public long f11749k;

    /* renamed from: l, reason: collision with root package name */
    public long f11750l;

    /* renamed from: m, reason: collision with root package name */
    public float f11751m;

    /* renamed from: n, reason: collision with root package name */
    public float f11752n;

    /* renamed from: o, reason: collision with root package name */
    public float f11753o;

    /* renamed from: p, reason: collision with root package name */
    public float f11754p;

    /* renamed from: q, reason: collision with root package name */
    public float f11755q;

    /* renamed from: r, reason: collision with root package name */
    public float f11756r;

    /* renamed from: s, reason: collision with root package name */
    public float f11757s;

    /* renamed from: t, reason: collision with root package name */
    public float f11758t;

    public ck(JSONObject jSONObject) {
        this.f11744f = -1;
        this.f11745g = -1;
        this.f11746h = -1;
        this.f11747i = -1L;
        this.f11748j = -1L;
        this.f11749k = -1L;
        this.f11750l = -1L;
        this.f11751m = -1.0f;
        this.f11752n = -1.0f;
        this.f11753o = -1.0f;
        this.f11754p = -1.0f;
        this.f11755q = -1.0f;
        this.f11756r = -1.0f;
        this.f11757s = -1.0f;
        this.f11758t = -1.0f;
        this.f11740b = jSONObject;
        this.f11742d = jSONObject.optInt(Constants.KEY_HTTP_CODE, -1);
        this.f11739a = bt.a(this);
        int a10 = bs.a(a());
        boolean z10 = false;
        if (a10 != 0) {
            if (a10 == bs.f11670e || a10 == bs.f11671f) {
                z10 = true;
            }
        }
        this.f11743e = z10;
    }

    public final int a() {
        return this.f11740b.optInt("style", -1);
    }

    public final String b() {
        return this.f11740b.optString("image");
    }

    public final String c() {
        return this.f11740b.optString("sid");
    }

    public final String d() {
        return this.f11740b.optString("title");
    }

    public final String e() {
        return this.f11740b.optString("content");
    }

    public final boolean f() {
        return this.f11740b.optInt("ic", 0) == 1;
    }

    public final boolean g() {
        return this.f11740b.optInt("h5_in_app", 1) == 1;
    }

    public final int h() {
        return Math.max(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT, this.f11740b.optInt("imp_jg", com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT));
    }

    public final long i() {
        return this.f11740b.optLong("exposed_duration", -1L);
    }

    public final String j() {
        return this.f11740b.optString("pkg_name");
    }

    public final int k() {
        return this.f11740b.optInt("after_clk");
    }

    public final String l() {
        return this.f11740b.optString("v_url");
    }

    public ck(bx.c cVar, String str) {
        this.f11744f = -1;
        this.f11745g = -1;
        this.f11746h = -1;
        this.f11747i = -1L;
        this.f11748j = -1L;
        this.f11749k = -1L;
        this.f11750l = -1L;
        this.f11751m = -1.0f;
        this.f11752n = -1.0f;
        this.f11753o = -1.0f;
        this.f11754p = -1.0f;
        this.f11755q = -1.0f;
        this.f11756r = -1.0f;
        this.f11757s = -1.0f;
        this.f11758t = -1.0f;
        this.f11740b = new JSONObject();
        this.f11739a = cVar;
        this.f11742d = -1;
        this.f11741c = str;
        this.f11743e = false;
    }
}
