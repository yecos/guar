package l6;

import android.content.Context;
import android.os.SystemClock;
import b6.z;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.UpdateFullScreenSortEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import j6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l6.n0;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import w6.i;

/* loaded from: classes3.dex */
public final class n0 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16122a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.d f16123b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f16124a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            return Boolean.valueOf(getColumnContentsResult.getData() != null);
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16125a = new b();

        public b() {
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

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f16126a = new c();

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

        /* renamed from: a, reason: collision with root package name */
        public static final d f16127a = new d();

        public d() {
            super(1);
        }

        public final void b(List list) {
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ChildColumnList childColumnList = (ChildColumnList) it.next();
                    if (t9.i.b(childColumnList.getRestricted(), "1")) {
                        b6.z.f5049u.i(childColumnList);
                    }
                    if (t9.i.b(childColumnList.getFree(), "1")) {
                        b6.z.f5049u.m(childColumnList);
                    }
                }
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    public static final class e extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f16129a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f16129a = columnContentsBean;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f17333a, "live_column", m8.a.a().toJson(this.f16129a));
                String f10 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
                t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f17333a, "service_time_live_column", String.valueOf((i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final b f16130a = new b();

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
            public final /* synthetic */ String f16131a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f16131a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f16131a, yVar.b(), null, 4, null));
            }
        }

        public e() {
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
            ColumnContentsBean columnContentsBean = new ColumnContentsBean(null, list);
            Observable compose = Observable.just("ioSchedulers").compose(com.mobile.brasiltv.utils.p0.c());
            final a aVar = new a(columnContentsBean);
            Consumer consumer = new Consumer() { // from class: l6.o0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    n0.e.i(s9.l.this, obj);
                }
            };
            final b bVar = b.f16130a;
            compose.subscribe(consumer, new Consumer() { // from class: l6.p0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    n0.e.j(s9.l.this, obj);
                }
            });
            z.a aVar2 = b6.z.f5049u;
            aVar2.k(new ArrayList());
            ArrayList d10 = aVar2.d();
            t9.i.d(d10);
            d10.addAll(list);
            if (aVar2.a() != null) {
                ArrayList d11 = aVar2.d();
                t9.i.d(d11);
                ChildColumnList a10 = aVar2.a();
                t9.i.d(a10);
                d11.remove(a10);
                ArrayList d12 = aVar2.d();
                t9.i.d(d12);
                ChildColumnList a11 = aVar2.a();
                t9.i.d(a11);
                d12.add(a11);
            }
            i.c cVar = w6.i.f19214g;
            if (!t9.i.b(cVar.A(), "1")) {
                ArrayList d13 = aVar2.d();
                t9.i.d(d13);
                t9.a0.a(d13).remove(aVar2.a());
            }
            if (aVar2.e() != null) {
                ArrayList d14 = aVar2.d();
                t9.i.d(d14);
                ChildColumnList e10 = aVar2.e();
                t9.i.d(e10);
                d14.remove(e10);
                if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                    ArrayList d15 = aVar2.d();
                    t9.i.d(d15);
                    if (d15.size() > 0) {
                        ArrayList d16 = aVar2.d();
                        t9.i.d(d16);
                        ChildColumnList e11 = aVar2.e();
                        t9.i.d(e11);
                        d16.add(1, e11);
                    } else {
                        ArrayList d17 = aVar2.d();
                        t9.i.d(d17);
                        ChildColumnList e12 = aVar2.e();
                        t9.i.d(e12);
                        d17.add(e12);
                    }
                }
            }
            xa.c.c().m(new UpdateFullScreenSortEvent());
            n0.this.w().s();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            n0.this.w().onLoading();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            n0.this.w().c(str);
            Context context = n0.this.p().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new c(str));
            }
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f16133b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(t9.w wVar) {
            super(1);
            this.f16133b = wVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (!bool.booleanValue()) {
                n0.this.r();
                return;
            }
            n0 n0Var = n0.this;
            Object obj = this.f16133b.f18961a;
            t9.i.d(obj);
            n0Var.q((ColumnContentsBean) obj);
        }
    }

    public n0(b6.f fVar, j6.d dVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(dVar, "view");
        this.f16122a = fVar;
        this.f16123b = dVar;
    }

    public static final boolean s(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void v(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(t9.w wVar, t9.w wVar2, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f17333a, "live_column", "");
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
        String f10 = na.f.f(na.a.f17333a, "service_time_live_column", "0");
        t9.i.f(f10, "getStrings(AppHelper.mCo…CE_TIME_LIVE_COLUMN, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
        t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
        long a11 = (i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
        StringBuilder sb = new StringBuilder();
        sb.append("live column: nowTime: ");
        sb.append(a11);
        sb.append(", lastCacheTime: ");
        sb.append(parseLong);
        sb.append(", cacheTime: ");
        int i10 = 60000 * d10;
        sb.append(i10);
        sb.append(", needRequest= ");
        sb.append(a11 > ((long) i10) + parseLong);
        k7.f.e(sb.toString(), new Object[0]);
        if (parseLong == 0 || d10 == 0 || a11 >= parseLong + (d10 * 60 * 1000)) {
            observableEmitter.onNext(Boolean.FALSE);
        } else {
            observableEmitter.onNext(Boolean.TRUE);
        }
    }

    public static final void z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final b6.f p() {
        return this.f16122a;
    }

    public final void q(ColumnContentsBean columnContentsBean) {
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        for (ChildColumnList childColumnList2 : childColumnList) {
            if (t9.i.b(childColumnList2.getRestricted(), "1")) {
                b6.z.f5049u.i(childColumnList2);
            } else if (t9.i.b(childColumnList2.getFree(), "1")) {
                b6.z.f5049u.m(childColumnList2);
            }
        }
        z.a aVar = b6.z.f5049u;
        aVar.k(new ArrayList());
        ArrayList d10 = aVar.d();
        t9.i.d(d10);
        List<ChildColumnList> childColumnList3 = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList3);
        d10.addAll(childColumnList3);
        if (aVar.a() != null) {
            ArrayList d11 = aVar.d();
            t9.i.d(d11);
            ChildColumnList a10 = aVar.a();
            t9.i.d(a10);
            d11.remove(a10);
            ArrayList d12 = aVar.d();
            t9.i.d(d12);
            ChildColumnList a11 = aVar.a();
            t9.i.d(a11);
            d12.add(a11);
        }
        i.c cVar = w6.i.f19214g;
        if (!t9.i.b(cVar.A(), "1")) {
            ArrayList d13 = aVar.d();
            t9.i.d(d13);
            t9.a0.a(d13).remove(aVar.a());
        }
        if (aVar.e() != null) {
            ArrayList d14 = aVar.d();
            t9.i.d(d14);
            ChildColumnList e10 = aVar.e();
            t9.i.d(e10);
            d14.remove(e10);
            if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                ArrayList d15 = aVar.d();
                t9.i.d(d15);
                if (d15.size() > 0) {
                    ArrayList d16 = aVar.d();
                    t9.i.d(d16);
                    ChildColumnList e11 = aVar.e();
                    t9.i.d(e11);
                    d16.add(1, e11);
                } else {
                    ArrayList d17 = aVar.d();
                    t9.i.d(d17);
                    ChildColumnList e12 = aVar.e();
                    t9.i.d(e12);
                    d17.add(e12);
                }
            }
        }
        xa.c.c().m(new UpdateFullScreenSortEvent());
        this.f16123b.s();
    }

    public final void r() {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), RootColumnId.tvId, false, 0, 0, 14, null).compose(this.f16122a.O2());
        final a aVar = a.f16124a;
        Observable filter = compose.filter(new Predicate() { // from class: l6.j0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean s10;
                s10 = n0.s(s9.l.this, obj);
                return s10;
            }
        });
        final b bVar = b.f16125a;
        Observable map = filter.map(new Function() { // from class: l6.k0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List t10;
                t10 = n0.t(s9.l.this, obj);
                return t10;
            }
        });
        final c cVar = c.f16126a;
        Observable filter2 = map.filter(new Predicate() { // from class: l6.l0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean u10;
                u10 = n0.u(s9.l.this, obj);
                return u10;
            }
        });
        final d dVar = d.f16127a;
        filter2.doOnNext(new Consumer() { // from class: l6.m0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n0.v(s9.l.this, obj);
            }
        }).subscribe(new e());
    }

    public final j6.d w() {
        return this.f16123b;
    }

    public void x() {
        if (RootColumnId.tvColumn == null) {
            com.mobile.brasiltv.utils.b0.U(this, "tv column id == null");
            d.a.a(this.f16123b, null, 1, null);
            return;
        }
        final t9.w wVar = new t9.w();
        final t9.w wVar2 = new t9.w();
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.h0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                n0.y(t9.w.this, wVar2, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.b());
        final f fVar = new f(wVar2);
        compose.subscribe(new Consumer() { // from class: l6.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n0.z(s9.l.this, obj);
            }
        });
    }
}
