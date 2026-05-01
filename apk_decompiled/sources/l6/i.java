package l6;

import android.content.Context;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.view.adView.MemAdShowControl;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.RecommendList;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import w6.i;

/* loaded from: classes3.dex */
public final class i implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16022a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.j f16023b;

    /* renamed from: c, reason: collision with root package name */
    public ChildColumnList f16024c;

    /* renamed from: d, reason: collision with root package name */
    public String f16025d;

    /* renamed from: e, reason: collision with root package name */
    public List f16026e;

    /* renamed from: f, reason: collision with root package name */
    public List f16027f;

    /* renamed from: g, reason: collision with root package name */
    public List f16028g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f16029h;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16031b;

        /* renamed from: l6.i$a$a, reason: collision with other inner class name */
        public static final class C0277a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16032a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0277a(String str) {
                super(1);
                this.f16032a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16032a, null, null, 6, null));
            }
        }

        public a(String str) {
            this.f16031b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(PwdCheckResult pwdCheckResult) {
            t9.i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = ma.m.e(this.f16031b);
            t9.i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            i.this.H().y(false);
            i.this.H().I();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i.this.H().y(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i.this.H().y(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "aaa100012")) {
                com.mobile.brasiltv.utils.f1.f8649a.w(R.string.pwd_wrong);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
                com.mobile.brasiltv.utils.f1.f8649a.w(R.string.pi_connect_timeout);
                return;
            }
            Context context = i.this.C().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0277a(str));
            }
        }
    }

    public static final class b extends t9.j implements s9.l {
        public b() {
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
                l6.i r0 = l6.i.this
                i6.j r0 = r0.H()
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
            throw new UnsupportedOperationException("Method not decompiled: l6.i.b.invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult):java.util.List");
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f16034a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f16036b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ChildColumnList childColumnList) {
            super(1);
            this.f16036b = childColumnList;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            i.this.I(this.f16036b, list);
            return Observable.fromIterable(list).skip(6L);
        }
    }

    public static final class e extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16038a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t9.w f16039b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, t9.w wVar) {
                super(1);
                this.f16038a = str;
                this.f16039b = wVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16038a, null, null, 6, null);
                if (!t9.i.b(na.d.c(this.f16038a), "no_report_type")) {
                    t9.w wVar = this.f16039b;
                    String c10 = na.d.c(this.f16038a);
                    t9.i.f(c10, "isEBReport(returnCode)");
                    wVar.f18961a = c10;
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16038a, null, null, 6, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public e() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ChildColumnList childColumnList) {
            t9.i.g(childColumnList, "t");
            i.this.F(childColumnList);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i.this.f16027f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i.this.H().c(str);
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            Context context = i.this.C().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str, wVar));
            }
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f16040a = new f();

        public f() {
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

    public static final class g extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16042a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16042a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16042a, null, null, 6, null));
            }
        }

        public g() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                i.this.f16028g.clear();
                i.this.f16028g.addAll(list);
                if (i.this.B().size() > 0) {
                    i.this.L();
                }
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i.this.f16027f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = i.this.C().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f16043a = new h();

        public h() {
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

    /* renamed from: l6.i$i, reason: collision with other inner class name */
    public static final class C0278i extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f16045b;

        /* renamed from: l6.i$i$a */
        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16046a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16046a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16046a, null, null, 6, null);
                if (!t9.i.b(na.d.c(this.f16046a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16046a, null, null, 6, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public C0278i(ChildColumnList childColumnList) {
            this.f16045b = childColumnList;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            i.this.f16029h.put(Integer.valueOf(this.f16045b.getId()), list);
            i.this.M(this.f16045b.getId(), list);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i.this.f16027f.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i.this.H().k();
            i.this.H().c(str);
            Context context = i.this.C().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class j extends t9.j implements s9.l {
        public j() {
            super(1);
        }

        public final void b(Integer num) {
            i6.j H = i.this.H();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            H.r(num.intValue());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    public i(b6.f fVar, i6.j jVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(jVar, "view");
        this.f16022a = fVar;
        this.f16023b = jVar;
        this.f16025d = "";
        this.f16026e = new ArrayList();
        this.f16027f = new ArrayList();
        this.f16028g = new ArrayList();
        this.f16029h = new HashMap();
    }

    public static final ObservableSource A(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final List E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List G(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void N(i iVar, int i10, List list, ObservableEmitter observableEmitter) {
        t9.i.g(iVar, "this$0");
        t9.i.g(list, "$list");
        t9.i.g(observableEmitter, "it");
        int i11 = 0;
        for (Object obj : iVar.f16026e) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                i9.j.j();
            }
            MultiItemEntity multiItemEntity = (MultiItemEntity) obj;
            if (multiItemEntity instanceof g5.n) {
                ChildColumnList a10 = ((g5.n) multiItemEntity).a();
                if (a10 != null && a10.getId() == i10) {
                    Object obj2 = iVar.f16026e.get(i11);
                    t9.i.e(obj2, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.CRFragNormalItem");
                    ((g5.n) obj2).d(list);
                    observableEmitter.onNext(Integer.valueOf(i11));
                }
            }
            i11 = i12;
        }
    }

    public static final void O(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final List y(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final List B() {
        return this.f16026e;
    }

    public final b6.f C() {
        return this.f16022a;
    }

    public final void D(ChildColumnList childColumnList) {
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_6");
        this.f16025d = sb.toString();
        Observable compose = cVar.b().H1(i9.j.c(this.f16025d)).compose(this.f16022a.O2());
        final f fVar = f.f16040a;
        compose.map(new Function() { // from class: l6.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List E;
                E = i.E(s9.l.this, obj);
                return E;
            }
        }).subscribe(new g());
    }

    public final void F(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 20, 1, null, null)).compose(this.f16022a.O2());
        final h hVar = h.f16043a;
        compose.map(new Function() { // from class: l6.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List G;
                G = i.G(s9.l.this, obj);
                return G;
            }
        }).subscribe(new C0278i(childColumnList));
    }

    public final i6.j H() {
        return this.f16023b;
    }

    public final void I(ChildColumnList childColumnList, List list) {
        this.f16026e.clear();
        int i10 = 0;
        if (this.f16025d.length() > 0) {
            this.f16026e.add(0, new g5.l(childColumnList.getCode(), childColumnList.getId(), this.f16028g));
        }
        if (list.size() > 6) {
            List subList = list.subList(0, 6);
            for (Object obj : list.subList(6, list.size())) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList2 = (ChildColumnList) obj;
                List list2 = this.f16026e;
                List list3 = (List) this.f16029h.get(Integer.valueOf(childColumnList2.getId()));
                if (list3 == null) {
                    list3 = i9.j.d();
                }
                list2.add(new g5.n(childColumnList2, list3, i10 + 6));
                i10 = i11;
            }
            this.f16026e.add(2, new g5.m(subList));
        } else if (this.f16026e.size() >= 3) {
            this.f16026e.add(2, new g5.m(list));
        } else {
            this.f16026e.add(new g5.m(list));
        }
        K();
        this.f16023b.f(this.f16026e);
    }

    public void J(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "column");
        this.f16023b.a();
        v();
        this.f16026e.clear();
        this.f16024c = childColumnList;
        D(childColumnList);
        x(childColumnList);
    }

    public final void K() {
        ChildColumnList childColumnList = this.f16024c;
        if ((childColumnList != null ? Integer.valueOf(childColumnList.getId()) : null) != null && this.f16026e.size() > 0) {
            List list = this.f16026e;
            String string = this.f16022a.getString(R.string.home_bl1_ad_id);
            t9.i.f(string, "frag.getString(R.string.home_bl1_ad_id)");
            list.add(2, new g5.e1(string, a6.a.f228a.g(), new MemAdShowControl(), true));
        }
    }

    public final void L() {
        this.f16023b.r(0);
    }

    public final void M(final int i10, final List list) {
        if (!this.f16026e.isEmpty()) {
            Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.g
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    i.N(i.this, i10, list, observableEmitter);
                }
            }).compose(com.mobile.brasiltv.utils.p0.a());
            final j jVar = new j();
            compose.subscribe(new Consumer() { // from class: l6.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    i.O(s9.l.this, obj);
                }
            });
        }
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final void v() {
        for (Disposable disposable : this.f16027f) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f16027f.clear();
    }

    public void w(String str) {
        t9.i.g(str, "password");
        w6.i b10 = w6.i.f19214g.b();
        String e10 = ma.m.e(str);
        t9.i.f(e10, "md5(password)");
        b10.d2(e10).compose(this.f16022a.O2()).subscribe(new a(str));
    }

    public final void x(ChildColumnList childColumnList) {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), childColumnList.getId(), false, 0, 0, 14, null).compose(this.f16022a.O2());
        final b bVar = new b();
        Observable map = compose.map(new Function() { // from class: l6.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List y10;
                y10 = i.y(s9.l.this, obj);
                return y10;
            }
        });
        final c cVar = c.f16034a;
        Observable filter = map.filter(new Predicate() { // from class: l6.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean z10;
                z10 = i.z(s9.l.this, obj);
                return z10;
            }
        });
        final d dVar = new d(childColumnList);
        filter.flatMap(new Function() { // from class: l6.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource A;
                A = i.A(s9.l.this, obj);
                return A;
            }
        }).subscribe(new e());
    }
}
