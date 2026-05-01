package l6;

import android.content.Context;
import android.os.SystemClock;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.view.adView.MemAdShowControl;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import l6.z1;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.RecommendList;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import w6.i;

/* loaded from: classes3.dex */
public final class z1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16221a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.j f16222b;

    /* renamed from: c, reason: collision with root package name */
    public ChildColumnList f16223c;

    /* renamed from: d, reason: collision with root package name */
    public String f16224d;

    /* renamed from: e, reason: collision with root package name */
    public List f16225e;

    /* renamed from: f, reason: collision with root package name */
    public List f16226f;

    /* renamed from: g, reason: collision with root package name */
    public List f16227g;

    /* renamed from: h, reason: collision with root package name */
    public int f16228h;

    /* renamed from: i, reason: collision with root package name */
    public final Set f16229i;

    /* renamed from: j, reason: collision with root package name */
    public List f16230j;

    /* renamed from: k, reason: collision with root package name */
    public List f16231k;

    /* renamed from: l, reason: collision with root package name */
    public HashMap f16232l;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
        
            if (com.mobile.brasiltv.utils.b0.I(r0.getChildColumnList()) == false) goto L6;
         */
        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult r2) {
            /*
                r1 = this;
                java.lang.String r0 = "it"
                t9.i.g(r2, r0)
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r2.getData()
                if (r0 == 0) goto L1c
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r2.getData()
                t9.i.d(r0)
                java.util.List r0 = r0.getChildColumnList()
                boolean r0 = com.mobile.brasiltv.utils.b0.I(r0)
                if (r0 != 0) goto L25
            L1c:
                l6.z1 r0 = l6.z1.this
                j6.j r0 = r0.Y()
                r0.b()
            L25:
                mobile.com.requestframe.utils.response.ColumnContentsBean r2 = r2.getData()
                if (r2 == 0) goto L30
                java.util.List r2 = r2.getChildColumnList()
                goto L31
            L30:
                r2 = 0
            L31:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.z1.a.invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult):java.util.List");
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16234a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f16236b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16237a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16237a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16237a, yVar.b(), null, 4, null);
                if (!t9.i.b(na.d.c(this.f16237a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16237a, yVar.b(), null, 4, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public c(ChildColumnList childColumnList) {
            this.f16236b = childColumnList;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "it");
            z1.this.f16227g = t9.a0.b(list);
            z1.this.f16228h = -1;
            z1.this.f16229i.clear();
            z1.this.Z(this.f16236b, list);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            z1.this.f16226f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            z1.this.Y().c(str);
            Context context = z1.this.M().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f16238a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(VodRecommendsRespone vodRecommendsRespone) {
            t9.i.g(vodRecommendsRespone, "it");
            RecommendList data = vodRecommendsRespone.getData();
            if (data != null) {
                return data.getRecommendList();
            }
            return null;
        }
    }

    public static final class e extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16240a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16240a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f16240a, yVar.g(), null, 4, null));
            }
        }

        public e() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                z1.this.f16230j.clear();
                z1.this.f16230j.addAll(list);
                if (z1.this.L().size() > 0) {
                    z1.this.e0();
                }
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            z1.this.f16226f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = z1.this.M().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f16241a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(ShelveDataBean shelveDataBean) {
            t9.i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class g extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f16243b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16244a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16244a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16244a, yVar.k(), null, 4, null);
                if (!t9.i.b(na.d.c(this.f16244a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16244a, yVar.k(), null, 4, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public g(ChildColumnList childColumnList) {
            this.f16243b = childColumnList;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            z1.this.f16232l.put(Integer.valueOf(this.f16243b.getId()), list);
            z1.this.f0(this.f16243b.getId(), list);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            z1.this.f16226f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            z1.this.Y().k();
            z1.this.Y().c(str);
            Context context = z1.this.M().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f16246b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(t9.w wVar) {
            super(1);
            this.f16246b = wVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (!bool.booleanValue()) {
                z1.this.V();
                return;
            }
            z1 z1Var = z1.this;
            Object obj = this.f16246b.f18961a;
            t9.i.d(obj);
            z1Var.a0((ColumnContentsBean) obj);
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final i f16247a = new i();

        public i() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(data != null ? data.getChildColumnList() : null));
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final j f16248a = new j();

        public j() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            t9.i.d(data);
            return data.getChildColumnList();
        }
    }

    public static final class k extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f16250a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f16250a = columnContentsBean;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f17333a, "special_column", m8.a.a().toJson(this.f16250a));
                String f10 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
                t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f17333a, "service_time_hot_search", String.valueOf((i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final b f16251a = new b();

            public b() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return h9.t.f14242a;
            }

            public final void invoke(Throwable th) {
                th.printStackTrace();
            }
        }

        public static final class c extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16252a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f16252a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f16252a, yVar.b(), null, 4, null));
            }
        }

        public k() {
        }

        public static final void i(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void j(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                z1.this.f16231k.clear();
                z1.this.f16231k.addAll(list);
                if (z1.this.L().size() > 7) {
                    z1.this.i0();
                }
                ColumnContentsBean columnContentsBean = new ColumnContentsBean(null, list);
                Observable compose = Observable.just("ioSchedulers").compose(com.mobile.brasiltv.utils.p0.c());
                final a aVar = new a(columnContentsBean);
                Consumer consumer = new Consumer() { // from class: l6.a2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        z1.k.i(s9.l.this, obj);
                    }
                };
                final b bVar = b.f16251a;
                compose.subscribe(consumer, new Consumer() { // from class: l6.b2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        z1.k.j(s9.l.this, obj);
                    }
                });
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            z1.this.f16226f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = z1.this.M().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new c(str));
            }
        }
    }

    public static final class l extends t9.j implements s9.l {
        public l() {
            super(1);
        }

        public final void b(Integer num) {
            j6.j Y = z1.this.Y();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            Y.r(num.intValue());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    public static final class m extends t9.j implements s9.l {
        public m() {
            super(1);
        }

        public final void b(Integer num) {
            j6.j Y = z1.this.Y();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            Y.r(num.intValue());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    public z1(b6.f fVar, j6.j jVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(jVar, "view");
        this.f16221a = fVar;
        this.f16222b = jVar;
        this.f16224d = "";
        this.f16225e = new ArrayList();
        this.f16226f = new ArrayList();
        this.f16227g = new ArrayList();
        this.f16228h = -1;
        this.f16229i = new LinkedHashSet();
        this.f16230j = new ArrayList();
        this.f16231k = new ArrayList();
        this.f16232l = new HashMap();
    }

    public static final List J(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean K(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List P(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List R(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void T(t9.w wVar, t9.w wVar2, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f17333a, "special_column", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b10;
        wVar.f18961a = str;
        if (!com.mobile.brasiltv.utils.b0.J(str)) {
            Gson a10 = m8.a.a();
            Object obj = wVar.f18961a;
            t9.i.d(obj);
            wVar2.f18961a = a10.fromJson((String) obj, ColumnContentsBean.class);
        }
        if (wVar2.f18961a == null) {
            observableEmitter.onNext(Boolean.FALSE);
            return;
        }
        int d10 = na.f.d(na.a.f17333a, "column_cache_time", 0);
        String f10 = na.f.f(na.a.f17333a, "service_time_hot_search", "0");
        t9.i.f(f10, "getStrings(AppHelper.mCo…TIME_SPECIAL_COLUMN, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
        t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
        long a11 = (i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
        if (parseLong == 0 || d10 == 0 || a11 >= parseLong + (d10 * 60 * 1000)) {
            observableEmitter.onNext(Boolean.FALSE);
        } else {
            observableEmitter.onNext(Boolean.TRUE);
        }
    }

    public static final void U(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List X(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void g0(z1 z1Var, int i10, List list, ObservableEmitter observableEmitter) {
        t9.i.g(z1Var, "this$0");
        t9.i.g(list, "$list");
        t9.i.g(observableEmitter, "it");
        int i11 = 0;
        for (Object obj : z1Var.f16225e) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                i9.j.j();
            }
            Object obj2 = (MultiItemEntity) obj;
            if (obj2 instanceof g5.f1) {
                ChildColumnList a10 = ((g5.f1) obj2).a();
                if (a10 != null && a10.getId() == i10) {
                    Object obj3 = z1Var.f16225e.get(i11);
                    t9.i.e(obj3, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.RecommenFragmentNormal");
                    ((g5.f1) obj3).c(list);
                    observableEmitter.onNext(Integer.valueOf(i11));
                }
            }
            i11 = i12;
        }
    }

    public static final void h0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void j0(z1 z1Var, ObservableEmitter observableEmitter) {
        t9.i.g(z1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        int i10 = 0;
        for (Object obj : z1Var.f16225e) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (((MultiItemEntity) obj) instanceof g5.u1) {
                observableEmitter.onNext(Integer.valueOf(i10));
            }
            i10 = i11;
        }
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void G(List list) {
        t9.i.g(list, "datas");
        if (s6.a.f18777a.a().r()) {
            int i10 = 0;
            int i11 = -1;
            for (Object obj : list) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (((MultiItemEntity) obj).getItemType() == a6.d.f249a.f()) {
                    i11 = i10;
                }
                i10 = i12;
            }
            if (i11 != -1 || list.size() <= 0) {
                return;
            }
            list.add(1, new g5.b0());
        }
    }

    public final void H() {
        for (Disposable disposable : this.f16226f) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f16226f.clear();
    }

    public final void I(ChildColumnList childColumnList) {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), childColumnList.getId(), false, 0, 0, 14, null).compose(this.f16221a.O2());
        final a aVar = new a();
        Observable map = compose.map(new Function() { // from class: l6.r1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List J;
                J = z1.J(s9.l.this, obj);
                return J;
            }
        });
        final b bVar = b.f16234a;
        map.filter(new Predicate() { // from class: l6.s1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean K;
                K = z1.K(s9.l.this, obj);
                return K;
            }
        }).subscribe(new c(childColumnList));
    }

    public final List L() {
        return this.f16225e;
    }

    public final b6.f M() {
        return this.f16221a;
    }

    public final void N(int i10, int i11) {
        List list = this.f16227g;
        if (i10 > i11) {
            return;
        }
        while (true) {
            if (i10 >= 0 && i10 < list.size() && (i10 > this.f16228h || !this.f16229i.contains(Integer.valueOf(i10)))) {
                Q((ChildColumnList) list.get(i10));
                this.f16228h = i10;
                this.f16229i.add(Integer.valueOf(i10));
            }
            if (i10 == i11) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void O(ChildColumnList childColumnList) {
        String a10 = a6.b.f248a.a(childColumnList.getCode());
        this.f16224d = a10;
        if (a10.length() > 0) {
            Observable compose = w6.i.f19214g.b().H1(i9.j.c(this.f16224d)).compose(this.f16221a.O2());
            final d dVar = d.f16238a;
            compose.map(new Function() { // from class: l6.u1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List P;
                    P = z1.P(s9.l.this, obj);
                    return P;
                }
            }).subscribe(new e());
        }
    }

    public final void Q(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 20, 1, null, null)).compose(this.f16221a.O2());
        final f fVar = f.f16241a;
        compose.map(new Function() { // from class: l6.t1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List R;
                R = z1.R(s9.l.this, obj);
                return R;
            }
        }).subscribe(new g(childColumnList));
    }

    public final void S(ChildColumnList childColumnList) {
        if (!t9.i.b(childColumnList.getCode(), w6.i.f19214g.v() + "_movies") || RootColumnId.specialColumn == null) {
            return;
        }
        final t9.w wVar = new t9.w();
        final t9.w wVar2 = new t9.w();
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.n1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                z1.T(t9.w.this, wVar2, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.b());
        final h hVar = new h(wVar2);
        compose.subscribe(new Consumer() { // from class: l6.q1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z1.U(s9.l.this, obj);
            }
        });
    }

    public final void V() {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), RootColumnId.specialColumn.getId(), true, 0, 10, 4, null).compose(this.f16221a.O2());
        final i iVar = i.f16247a;
        Observable filter = compose.filter(new Predicate() { // from class: l6.o1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean W;
                W = z1.W(s9.l.this, obj);
                return W;
            }
        });
        final j jVar = j.f16248a;
        filter.map(new Function() { // from class: l6.p1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List X;
                X = z1.X(s9.l.this, obj);
                return X;
            }
        }).subscribe(new k());
    }

    public final j6.j Y() {
        return this.f16222b;
    }

    public final void Z(ChildColumnList childColumnList, List list) {
        this.f16225e.clear();
        int i10 = 0;
        if (this.f16224d.length() > 0) {
            this.f16225e.add(0, new g5.s1(childColumnList.getCode(), childColumnList.getId(), this.f16230j));
        }
        String code = childColumnList.getCode();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(code, sb.toString()) && ((t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && s6.a.f18777a.a().r())) {
            if (this.f16225e.size() > 0) {
                this.f16225e.add(1, new g5.b0());
            } else {
                this.f16225e.add(0, new g5.b0());
            }
        }
        if (com.mobile.brasiltv.utils.b0.I(list)) {
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList2 = (ChildColumnList) obj;
                if (i10 == 4) {
                    if (t9.i.b(childColumnList.getCode(), w6.i.f19214g.v() + "_movies")) {
                        this.f16225e.add(new g5.u1(RootColumnId.specialColumn, this.f16231k));
                    }
                }
                String style = childColumnList2.getStyle();
                if (t9.i.b(style, "top")) {
                    List list2 = this.f16225e;
                    List list3 = (List) this.f16232l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list3 == null) {
                        list3 = i9.j.d();
                    }
                    list2.add(new g5.o2(childColumnList2, list3, i10));
                } else if (t9.i.b(style, "normal")) {
                    List list4 = this.f16225e;
                    List list5 = (List) this.f16232l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list5 == null) {
                        list5 = i9.j.d();
                    }
                    list4.add(new g5.p2(childColumnList2, list5, i10));
                } else {
                    List list6 = this.f16225e;
                    List list7 = (List) this.f16232l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list7 == null) {
                        list7 = i9.j.d();
                    }
                    list6.add(new g5.t1(childColumnList2, list7, i10));
                }
                i10 = i11;
            }
        }
        d0();
        this.f16222b.f(this.f16225e);
    }

    public final void a0(ColumnContentsBean columnContentsBean) {
        this.f16231k.clear();
        List list = this.f16231k;
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        list.addAll(childColumnList);
        if (this.f16225e.size() > 7) {
            i0();
        }
    }

    public void b0(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "column");
        this.f16222b.a();
        H();
        this.f16225e.clear();
        this.f16223c = childColumnList;
        O(childColumnList);
        S(childColumnList);
        I(childColumnList);
    }

    public void c0(List list) {
        t9.i.g(list, "datas");
        if (s6.a.f18777a.a().r()) {
            int i10 = 0;
            int i11 = -1;
            for (Object obj : list) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (((MultiItemEntity) obj).getItemType() == a6.d.f249a.f()) {
                    i11 = i10;
                }
                i10 = i12;
            }
            if (i11 == -1 || list.size() <= i11) {
                return;
            }
            list.remove(i11);
        }
    }

    public final void d0() {
        ChildColumnList childColumnList = this.f16223c;
        if ((childColumnList != null ? Integer.valueOf(childColumnList.getId()) : null) == null) {
            return;
        }
        ChildColumnList childColumnList2 = this.f16223c;
        t9.i.d(childColumnList2);
        String code = childColumnList2.getCode();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_Recommended");
        if (t9.i.b(code, sb.toString())) {
            if (this.f16225e.size() > 0) {
                List list = this.f16225e;
                String string = this.f16221a.getString(R.string.home1_ad_id);
                t9.i.f(string, "frag.getString(R.string.home1_ad_id)");
                list.add(2, new g5.e1(string, a6.a.f228a.j(), new MemAdShowControl(), true));
                return;
            }
            return;
        }
        if (t9.i.b(code, cVar.v() + "_movies")) {
            if (this.f16225e.size() > 0) {
                List list2 = this.f16225e;
                String string2 = this.f16221a.getString(R.string.home_movie_first_banner_id);
                t9.i.f(string2, "frag.getString(R.string.…me_movie_first_banner_id)");
                list2.add(2, new g5.e1(string2, a6.a.f228a.c(), new MemAdShowControl(), true));
                return;
            }
            return;
        }
        if (t9.i.b(code, cVar.v() + "_series")) {
            if (this.f16225e.size() > 0) {
                List list3 = this.f16225e;
                String string3 = this.f16221a.getString(R.string.home_tv_ad_id);
                t9.i.f(string3, "frag.getString(R.string.home_tv_ad_id)");
                list3.add(2, new g5.e1(string3, a6.a.f228a.q(), new MemAdShowControl(), true));
                return;
            }
            return;
        }
        if (t9.i.b(code, cVar.v() + "_kids")) {
            if (this.f16225e.size() > 0) {
                List list4 = this.f16225e;
                String string4 = this.f16221a.getString(R.string.home_kids_ad_id);
                t9.i.f(string4, "frag.getString(R.string.home_kids_ad_id)");
                list4.add(2, new g5.e1(string4, a6.a.f228a.p(), new MemAdShowControl(), true));
                return;
            }
            return;
        }
        if (!t9.i.b(code, cVar.v() + "_animes") || this.f16225e.size() <= 0) {
            return;
        }
        List list5 = this.f16225e;
        String string5 = this.f16221a.getString(R.string.home_anime_ad_id);
        t9.i.f(string5, "frag.getString(R.string.home_anime_ad_id)");
        list5.add(2, new g5.e1(string5, a6.a.f228a.o(), new MemAdShowControl(), true));
    }

    @Override // l5.a
    public void e() {
    }

    public final void e0() {
        this.f16222b.r(0);
    }

    public final void f0(final int i10, final List list) {
        if (!this.f16225e.isEmpty()) {
            Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.x1
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    z1.g0(z1.this, i10, list, observableEmitter);
                }
            }).compose(com.mobile.brasiltv.utils.p0.a());
            final l lVar = new l();
            compose.subscribe(new Consumer() { // from class: l6.y1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    z1.h0(s9.l.this, obj);
                }
            });
        }
    }

    @Override // l5.a
    public void g() {
    }

    public final void i0() {
        if (!this.f16225e.isEmpty()) {
            Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.v1
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    z1.j0(z1.this, observableEmitter);
                }
            }).compose(com.mobile.brasiltv.utils.p0.a());
            final m mVar = new m();
            compose.subscribe(new Consumer() { // from class: l6.w1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    z1.k0(s9.l.this, obj);
                }
            });
        }
    }
}
