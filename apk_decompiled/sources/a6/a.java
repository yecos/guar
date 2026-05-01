package a6;

import android.content.Context;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.r0;
import w6.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f228a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f229b = "pause_popup";

    /* renamed from: c, reason: collision with root package name */
    public static final String f230c = "pause_popup_on_admob";

    /* renamed from: d, reason: collision with root package name */
    public static final String f231d = "pause_popup_on_admob_portrait";

    /* renamed from: e, reason: collision with root package name */
    public static final String f232e = "apk_booting";

    /* renamed from: f, reason: collision with root package name */
    public static final String f233f = "app_screen";

    /* renamed from: g, reason: collision with root package name */
    public static final String f234g = "movie_first_banner";

    /* renamed from: h, reason: collision with root package name */
    public static final String f235h = "home_bl_on_admob_1";

    /* renamed from: i, reason: collision with root package name */
    public static final String f236i = "vod_detail_on_admob";

    /* renamed from: j, reason: collision with root package name */
    public static final String f237j = "home_page_ad";

    /* renamed from: k, reason: collision with root package name */
    public static final String f238k = "home_page_ad_1";

    /* renamed from: l, reason: collision with root package name */
    public static final String f239l = "tv_series_ad";

    /* renamed from: m, reason: collision with root package name */
    public static final String f240m = "tv_kids_ad_1";

    /* renamed from: n, reason: collision with root package name */
    public static final String f241n = "tv_anime_ad_1";

    /* renamed from: o, reason: collision with root package name */
    public static final String f242o = "free_movie_list_on_admob";

    /* renamed from: p, reason: collision with root package name */
    public static final String f243p = "ad_cast_mode";

    /* renamed from: q, reason: collision with root package name */
    public static final String f244q = "home_ad_carousel";

    /* renamed from: r, reason: collision with root package name */
    public static final String f245r = "movie_ad_carousel";

    /* renamed from: s, reason: collision with root package name */
    public static final String f246s = "free_game_ad";

    /* renamed from: t, reason: collision with root package name */
    public static final String f247t = "player_loading";

    public static /* synthetic */ void u(a aVar, Context context, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.t(context, str, z10);
    }

    public final String a() {
        return f243p;
    }

    public final String b() {
        return f232e;
    }

    public final String c() {
        return f234g;
    }

    public final String d() {
        return f233f;
    }

    public final String e() {
        return f246s;
    }

    public final String f() {
        return f242o;
    }

    public final String g() {
        return f235h;
    }

    public final String h() {
        return f244q;
    }

    public final String i() {
        return f237j;
    }

    public final String j() {
        return f238k;
    }

    public final String k() {
        return f229b;
    }

    public final String l() {
        return f230c;
    }

    public final String m() {
        return f231d;
    }

    public final String n() {
        return f247t;
    }

    public final String o() {
        return f241n;
    }

    public final String p() {
        return f240m;
    }

    public final String q() {
        return f239l;
    }

    public final String r() {
        return f236i;
    }

    public final boolean s() {
        i.c cVar = i.f19214g;
        return t9.i.b(cVar.e(), "0") || !t9.i.b(cVar.I(), "4");
    }

    public final void t(Context context, String str, boolean z10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        String b10 = r0.f8743a.b(str, z10);
        if (b10 == null || b10.length() == 0) {
            return;
        }
        if (t.o(b10, "play.google.com", false, 2, null)) {
            b0.g0(context, b10);
        } else {
            b0.j0(context, b10, false, true, false, false, 24, null);
        }
    }
}
