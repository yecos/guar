package com.mobile.brasiltv.utils;

import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    public static LelinkServiceInfo f8672c;

    /* renamed from: d, reason: collision with root package name */
    public static Disposable f8673d;

    /* renamed from: f, reason: collision with root package name */
    public static a f8675f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f8676g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f8677h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f8678i;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f8685p;

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f8670a = new g0();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList f8671b = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static final int f8674e = 1001;

    /* renamed from: j, reason: collision with root package name */
    public static long f8679j = -1;

    /* renamed from: k, reason: collision with root package name */
    public static String f8680k = "";

    /* renamed from: l, reason: collision with root package name */
    public static String f8681l = "";

    /* renamed from: m, reason: collision with root package name */
    public static final String f8682m = "http://www.oi1lgew.com/dl/1";

    /* renamed from: n, reason: collision with root package name */
    public static final String f8683n = "http://www.oi1lgew.com/dl/2";

    /* renamed from: o, reason: collision with root package name */
    public static final String f8684o = "http://www.oi1lgew.com/dl/1080p_short.ts";

    /* renamed from: q, reason: collision with root package name */
    public static String f8686q = "";

    /* renamed from: r, reason: collision with root package name */
    public static String f8687r = "";

    /* renamed from: s, reason: collision with root package name */
    public static String f8688s = "";

    /* renamed from: t, reason: collision with root package name */
    public static String f8689t = "";

    /* renamed from: u, reason: collision with root package name */
    public static String f8690u = "";

    /* renamed from: v, reason: collision with root package name */
    public static String f8691v = "";

    /* renamed from: w, reason: collision with root package name */
    public static String f8692w = "";

    public interface a {
    }

    public final void a() {
        LelinkSourceSDK.getInstance().addVolume();
    }

    public final void b() {
        n();
        j(null);
        Disposable disposable = f8673d;
        if (disposable != null) {
            disposable.dispose();
        }
        p();
    }

    public final LelinkServiceInfo c() {
        return f8672c;
    }

    public final boolean d() {
        return f8678i;
    }

    public final boolean e() {
        return f8677h;
    }

    public final boolean f() {
        return f8676g;
    }

    public final void g() {
        f8676g = false;
        LelinkSourceSDK.getInstance().pause();
    }

    public final void h() {
        f8677h = false;
        LelinkSourceSDK.getInstance().resume();
    }

    public final void i(int i10) {
        LelinkSourceSDK.getInstance().seekTo(i10);
    }

    public final void j(a aVar) {
        f8675f = aVar;
    }

    public final void k(String str) {
        t9.i.g(str, "<set-?>");
        f8681l = str;
    }

    public final void l(boolean z10) {
        f8685p = z10;
    }

    public final void m(int i10) {
        if (f8672c == null) {
            return;
        }
        String str = i10 != 0 ? i10 != 1 ? i10 != 2 ? f8682m : f8682m : f8683n : f8684o;
        f8686q = "Experience";
        f8678i = false;
        LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
        lelinkPlayerInfo.setLelinkServiceInfo(f8672c);
        lelinkPlayerInfo.setType(102);
        lelinkPlayerInfo.setUrl(str);
        LelinkSourceSDK.getInstance().startPlayMedia(lelinkPlayerInfo);
    }

    public final void n() {
        LelinkSourceSDK.getInstance().stopPlay();
        f8680k = "";
    }

    public final void o() {
        LelinkSourceSDK.getInstance().subVolume();
    }

    public final void p() {
        LelinkSourceSDK.getInstance().unBindSdk();
    }
}
