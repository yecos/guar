package l6;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import l6.p2;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;

/* loaded from: classes3.dex */
public final class p2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16142a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.m f16143b;

    /* renamed from: c, reason: collision with root package name */
    public List f16144c;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f16146b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t9.w wVar) {
            super(1);
            this.f16146b = wVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (!bool.booleanValue()) {
                p2.this.t();
                return;
            }
            p2 p2Var = p2.this;
            Object obj = this.f16146b.f18961a;
            t9.i.d(obj);
            p2Var.w((ColumnContentsBean) obj);
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16147a = new b();

        public b() {
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

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f16148a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            t9.i.d(data);
            List<ChildColumnList> childColumnList = data.getChildColumnList();
            t9.i.d(childColumnList);
            return childColumnList;
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f16150a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f16150a = columnContentsBean;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f17333a, "vod_column", m8.a.a().toJson(this.f16150a));
                String f10 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
                t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f17333a, "service_time_vod_column", String.valueOf((i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final b f16151a = new b();

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
            public final /* synthetic */ String f16152a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f16152a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f16152a, yVar.b(), null, 4, null));
            }
        }

        public d() {
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
            if (list.isEmpty()) {
                p2.this.s().b();
            } else {
                p2.this.s().q1(list);
            }
            p2.this.x(list);
            com.mobile.brasiltv.utils.b0.U(this, "getChildColumn:" + list);
            ColumnContentsBean columnContentsBean = new ColumnContentsBean(null, list);
            Observable compose = Observable.just("ioSchedulers").compose(com.mobile.brasiltv.utils.p0.c());
            final a aVar = new a(columnContentsBean);
            Consumer consumer = new Consumer() { // from class: l6.q2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    p2.d.i(s9.l.this, obj);
                }
            };
            final b bVar = b.f16151a;
            compose.subscribe(consumer, new Consumer() { // from class: l6.r2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    p2.d.j(s9.l.this, obj);
                }
            });
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            p2.this.s().c(str);
            Context context = p2.this.q().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new c(str));
            }
        }
    }

    public p2(b6.f fVar, j6.m mVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(mVar, "view");
        this.f16142a = fVar;
        this.f16143b = mVar;
    }

    public static final void o(t9.w wVar, t9.w wVar2, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f17333a, "vod_column", "");
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
        String f10 = na.f.f(na.a.f17333a, "service_time_vod_column", "0");
        t9.i.f(f10, "getStrings(AppHelper.mCo…ICE_TIME_VOD_COLUMN, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
        t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
        long a11 = (i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
        StringBuilder sb = new StringBuilder();
        sb.append("vod column: nowTime: ");
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

    public static final void p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List v(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void n() {
        final t9.w wVar = new t9.w();
        final t9.w wVar2 = new t9.w();
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.l2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                p2.o(t9.w.this, wVar2, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.b());
        final a aVar = new a(wVar2);
        compose.subscribe(new Consumer() { // from class: l6.m2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p2.p(s9.l.this, obj);
            }
        });
    }

    public final b6.f q() {
        return this.f16142a;
    }

    public final List r() {
        return this.f16144c;
    }

    public final j6.m s() {
        return this.f16143b;
    }

    public final void t() {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), RootColumnId.mainId, false, 0, 0, 14, null).compose(this.f16142a.O2());
        final b bVar = b.f16147a;
        Observable filter = compose.filter(new Predicate() { // from class: l6.n2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean u10;
                u10 = p2.u(s9.l.this, obj);
                return u10;
            }
        });
        final c cVar = c.f16148a;
        filter.map(new Function() { // from class: l6.o2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List v10;
                v10 = p2.v(s9.l.this, obj);
                return v10;
            }
        }).subscribe(new d());
    }

    public final void w(ColumnContentsBean columnContentsBean) {
        j6.m mVar = this.f16143b;
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        mVar.q1(childColumnList);
        List<ChildColumnList> childColumnList2 = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList2);
        this.f16144c = childColumnList2;
        StringBuilder sb = new StringBuilder();
        sb.append("getChildColumn by cache: ");
        List<ChildColumnList> childColumnList3 = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList3);
        sb.append(childColumnList3);
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
    }

    public final void x(List list) {
        this.f16144c = list;
    }
}
