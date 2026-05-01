package com.mobile.brasiltv.utils;

import android.os.SystemClock;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8648a = new f();

    public final void a(String str, String str2, int i10) {
        t9.i.g(str, "searchWords");
        t9.i.g(str2, "title");
        HashMap hashMap = new HashMap();
        hashMap.put("title", str2);
        hashMap.put("searchWords", str);
        hashMap.put("position", Integer.valueOf(i10));
        c2.e.f5339a.a("app_search_result_click", hashMap, SystemClock.elapsedRealtime(), 0L, false, true);
    }

    public final void b() {
        c2.e.f5339a.a("app_coupon_click", new HashMap(), SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : false);
    }

    public final void c() {
        c2.e.f5339a.a("app_game_ad", new HashMap(), SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : false);
    }
}
