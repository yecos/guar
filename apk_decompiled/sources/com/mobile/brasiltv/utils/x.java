package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.ConfigData;
import mobile.com.requestframe.utils.response.ConfigInfoBean;
import mobile.com.requestframe.utils.response.ConfigResult;

/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f8754a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f8755b;

    /* renamed from: c, reason: collision with root package name */
    public static String f8756c;

    /* renamed from: d, reason: collision with root package name */
    public static int f8757d;

    /* renamed from: e, reason: collision with root package name */
    public static int f8758e;

    /* renamed from: f, reason: collision with root package name */
    public static int f8759f;

    /* renamed from: g, reason: collision with root package name */
    public static Disposable f8760g;

    /* renamed from: h, reason: collision with root package name */
    public static String f8761h;

    /* renamed from: i, reason: collision with root package name */
    public static String f8762i;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8763a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(1);
            this.f8763a = context;
        }

        public final void b(ConfigResult configResult) {
            ConfigData data = configResult.getData();
            if ((data != null ? data.getConfig() : null) != null) {
                Context context = this.f8763a;
                ConfigData data2 = configResult.getData();
                t9.i.d(data2);
                String config = data2.getConfig();
                t9.i.d(config);
                n7.a.e(context, "Properties", config);
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ConfigResult) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.l f8764a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s9.l f8765b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f8766c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s9.l lVar, s9.l lVar2, x xVar) {
            super(1);
            this.f8764a = lVar;
            this.f8765b = lVar2;
            this.f8766c = xVar;
        }

        public final void b(ConfigResult configResult) {
            Gson a10 = s2.b.a();
            ConfigData data = configResult.getData();
            t9.i.d(data);
            Object fromJson = a10.fromJson(data.getConfig(), (Class<Object>) ConfigInfoBean.class);
            t9.i.f(fromJson, "jsoner.fromJson(it.data!…nfigInfoBean::class.java)");
            x.s(x.f8754a, (ConfigInfoBean) fromJson, this.f8764a, this.f8765b, false, 8, null);
            synchronized (this.f8766c) {
                x.f8759f = 1;
                h9.t tVar = h9.t.f14242a;
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ConfigResult) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s9.l f8768b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s9.l lVar) {
            super(1);
            this.f8768b = lVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            synchronized (x.this) {
                x.f8759f = 2;
                h9.t tVar = h9.t.f14242a;
            }
            x.f8757d++;
            s9.l lVar = this.f8768b;
            if (lVar != null) {
                lVar.invoke("");
            }
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f8769a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(t9.w wVar) {
            super(1);
            this.f8769a = wVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            this.f8769a.f18961a = str;
        }
    }

    static {
        x xVar = new x();
        f8754a = xVar;
        String simpleName = xVar.getClass().getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        f8755b = simpleName;
        f8758e = 3;
        f8759f = 2;
    }

    public static /* synthetic */ void j(x xVar, Context context, s9.l lVar, s9.l lVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        xVar.i(context, lVar, lVar2);
    }

    public static final void k(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void o(x xVar, Context context, s9.l lVar, s9.l lVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        xVar.n(context, lVar, lVar2);
    }

    public static /* synthetic */ void s(x xVar, ConfigInfoBean configInfoBean, s9.l lVar, s9.l lVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        xVar.r(configInfoBean, lVar, lVar2, z10);
    }

    public static final void u(Context context) {
        t9.i.g(context, "$context");
        Object b10 = n7.a.b(context, "Properties", "");
        String str = b10 instanceof String ? (String) b10 : null;
        if (str == null || str.length() == 0) {
            return;
        }
        f8754a.r((ConfigInfoBean) s2.b.a().fromJson(str, ConfigInfoBean.class), null, null, true);
    }

    public final String h() {
        String str;
        String str2 = f8756c;
        if (str2 == null || str2.length() == 0) {
            String str3 = f8761h;
            return ((str3 == null || str3.length() == 0) || (str = f8761h) == null) ? "" : str;
        }
        String str4 = f8756c;
        return str4 == null ? "" : str4;
    }

    public final void i(Context context, s9.l lVar, s9.l lVar2) {
        Disposable disposable;
        Disposable disposable2 = f8760g;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = f8760g) != null) {
            disposable.dispose();
        }
        Observable j12 = w6.i.f19214g.b().j1();
        final a aVar = new a(context);
        Observable compose = j12.doOnNext(new Consumer() { // from class: com.mobile.brasiltv.utils.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                x.k(s9.l.this, obj);
            }
        }).compose(s2.c.a());
        final b bVar = new b(lVar, lVar2, this);
        Consumer consumer = new Consumer() { // from class: com.mobile.brasiltv.utils.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                x.l(s9.l.this, obj);
            }
        };
        final c cVar = new c(lVar);
        f8760g = compose.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.utils.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                x.m(s9.l.this, obj);
            }
        });
    }

    public final void n(Context context, s9.l lVar, s9.l lVar2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        if (lVar2 != null) {
            if (TextUtils.isEmpty(f8762i)) {
                i(context, lVar, lVar2);
                return;
            } else {
                String str = f8762i;
                t9.i.d(str);
                lVar2.invoke(str);
            }
        }
        if (!TextUtils.isEmpty(f8756c)) {
            if (lVar != null) {
                lVar.invoke(f8756c);
                return;
            }
            return;
        }
        if (f8757d >= f8758e) {
            String q10 = q();
            if (lVar != null) {
                lVar.invoke(q10);
                return;
            }
            return;
        }
        synchronized (this) {
            if (f8759f != 2) {
                String q11 = f8754a.q();
                if (lVar != null) {
                    lVar.invoke(q11);
                }
            } else {
                f8759f = 3;
                h9.t tVar = h9.t.f14242a;
                j(this, context, lVar, null, 4, null);
            }
        }
    }

    public final String p(String str) {
        t9.i.g(str, Scopes.EMAIL);
        int x10 = ba.t.x(str, '@', 0, false, 6, null);
        if (x10 == -1) {
            return null;
        }
        String substring = str.substring(x10);
        t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String q() {
        return TextUtils.isEmpty(f8756c) ? !TextUtils.isEmpty(f8761h) ? f8761h : "" : f8756c;
    }

    public final void r(ConfigInfoBean configInfoBean, s9.l lVar, s9.l lVar2, boolean z10) {
        String customerEmail;
        if (!TextUtils.isEmpty(configInfoBean != null ? configInfoBean.getOfficialWebsiteLink() : null) && !z10) {
            String officialWebsiteLink = configInfoBean != null ? configInfoBean.getOfficialWebsiteLink() : null;
            f8762i = officialWebsiteLink;
            if (lVar2 != null) {
                t9.i.d(officialWebsiteLink);
                lVar2.invoke(officialWebsiteLink);
            }
        }
        if (TextUtils.isEmpty(configInfoBean != null ? configInfoBean.getCustomerEmail() : null)) {
            if (lVar != null) {
                lVar.invoke("");
            }
        } else {
            if (z10) {
                customerEmail = configInfoBean != null ? configInfoBean.getCustomerEmail() : null;
                f8761h = customerEmail;
                if (lVar != null) {
                    lVar.invoke(customerEmail);
                    return;
                }
                return;
            }
            customerEmail = configInfoBean != null ? configInfoBean.getCustomerEmail() : null;
            f8756c = customerEmail;
            if (lVar != null) {
                lVar.invoke(customerEmail);
            }
        }
    }

    public final void t(final Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        s2.d.b("loadCacheConfigInfo", new Runnable() { // from class: com.mobile.brasiltv.utils.w
            @Override // java.lang.Runnable
            public final void run() {
                x.u(context);
            }
        }, false);
    }

    public final String v(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.w wVar = new t9.w();
        wVar.f18961a = "";
        o(this, context, new d(wVar), null, 4, null);
        return (String) wVar.f18961a;
    }

    public final void w(Context context, s9.l lVar) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        x(context, lVar, null);
    }

    public final void x(Context context, s9.l lVar, s9.l lVar2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        n(context, lVar, lVar2);
    }

    public final String y(Context context, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.z zVar = t9.z.f18964a;
        String string = context.getString(i10);
        t9.i.f(string, "context.getString(resId)");
        String format = String.format(string, Arrays.copyOf(new Object[]{h()}, 1));
        t9.i.f(format, "format(format, *args)");
        return format;
    }
}
