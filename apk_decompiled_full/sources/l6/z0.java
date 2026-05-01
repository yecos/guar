package l6;

import android.content.Context;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.mobile.brasiltv.db.VodDao;
import com.umeng.analytics.AnalyticsConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public final class z0 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16211a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.h f16212b;

    /* renamed from: c, reason: collision with root package name */
    public VodDao f16213c;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                com.mobile.brasiltv.utils.b0.U(z0.this, "clear expire sub info success");
            }
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16215a = new b();

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
        public c() {
            super(1);
        }

        public final void b(List list) {
            com.mobile.brasiltv.utils.b0.U(z0.this, "subscribe list size: " + list.size());
            if (list.isEmpty()) {
                z0.this.u().J0(true);
            }
            z0.this.u().showLoading(false);
            j6.h u10 = z0.this.u();
            t9.i.f(list, "it");
            u10.i1(list);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    public static final class d extends t9.j implements s9.l {
        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(z0.this, "subscribe list is empty");
            th.printStackTrace();
            z0.this.u().showLoading(false);
            z0.this.u().J0(true);
        }
    }

    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((LiveSubProgram) obj).getStartTime(), ((LiveSubProgram) obj2).getStartTime());
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16219b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i10) {
            super(1);
            this.f16219b = i10;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            com.mobile.brasiltv.utils.b0.U(z0.this, "unsub list result: " + bool);
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                z0.this.u().B2(this.f16219b);
            }
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f16220a = new g();

        public g() {
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

    public z0(b6.f fVar, j6.h hVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(hVar, "view");
        this.f16211a = fVar;
        this.f16212b = hVar;
        Context requireContext = fVar.requireContext();
        t9.i.f(requireContext, "frag.requireContext()");
        this.f16213c = new VodDao(requireContext);
    }

    public static final void A(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void C(LiveSubProgram liveSubProgram, z0 z0Var, ObservableEmitter observableEmitter) {
        t9.i.g(liveSubProgram, "$subProgram");
        t9.i.g(z0Var, "this$0");
        t9.i.g(observableEmitter, "it");
        String e10 = ma.m.e(liveSubProgram.getChannelName() + liveSubProgram.getProgramName() + liveSubProgram.getStartTime() + liveSubProgram.getEndTime());
        VodDao vodDao = z0Var.f16213c;
        t9.i.f(e10, "pid");
        vodDao.delLiveSub(e10);
        observableEmitter.onNext(Boolean.TRUE);
    }

    public static final void D(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r(z0 z0Var, ObservableEmitter observableEmitter) {
        t9.i.g(z0Var, "this$0");
        t9.i.g(observableEmitter, "it");
        String d10 = y6.a.d("yyyy/MM/dd HH:mm");
        for (LiveSubProgram liveSubProgram : z0Var.f16213c.queryAllLiveSub()) {
            if (y6.a.b(d10, liveSubProgram.getEndTime())) {
                z0Var.f16213c.delLiveSub(liveSubProgram.get_pid());
            }
        }
        observableEmitter.onNext(Boolean.TRUE);
    }

    public static final void s(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(z0 z0Var, String str, ObservableEmitter observableEmitter) {
        t9.i.g(z0Var, "this$0");
        t9.i.g(str, "$startTime");
        t9.i.g(observableEmitter, "it");
        observableEmitter.onNext(i9.r.C(z0Var.v(str), new e()));
    }

    public static final void z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void B(final LiveSubProgram liveSubProgram, int i10) {
        t9.i.g(liveSubProgram, "subProgram");
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.w0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                z0.C(LiveSubProgram.this, this, observableEmitter);
            }
        }).compose(ma.q.b()).compose(this.f16211a.O2());
        final f fVar = new f(i10);
        Consumer consumer = new Consumer() { // from class: l6.x0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.D(s9.l.this, obj);
            }
        };
        final g gVar = g.f16220a;
        compose.subscribe(consumer, new Consumer() { // from class: l6.y0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.E(s9.l.this, obj);
            }
        });
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void q() {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.t0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                z0.r(z0.this, observableEmitter);
            }
        }).compose(ma.q.b()).compose(this.f16211a.O2());
        final a aVar = new a();
        Consumer consumer = new Consumer() { // from class: l6.u0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.s(s9.l.this, obj);
            }
        };
        final b bVar = b.f16215a;
        compose.subscribe(consumer, new Consumer() { // from class: l6.v0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.t(s9.l.this, obj);
            }
        });
    }

    public final j6.h u() {
        return this.f16212b;
    }

    public final List v(String str) {
        ArrayList arrayList = new ArrayList();
        List<LiveSubProgram> queryLiveSubByDate = this.f16213c.queryLiveSubByDate(str);
        String d10 = y6.a.d("yyyy/MM/dd HH:mm");
        for (LiveSubProgram liveSubProgram : queryLiveSubByDate) {
            if (!y6.a.b(d10, liveSubProgram.getEndTime())) {
                arrayList.add(liveSubProgram);
            }
        }
        return arrayList;
    }

    public void w() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i10 = 0; i10 < 7; i10++) {
            arrayList.add(y6.b.b((86400000 * i10) + currentTimeMillis, "yyyy/MM/dd"));
        }
        this.f16212b.o0(arrayList);
    }

    public void x(final String str) {
        t9.i.g(str, AnalyticsConfig.RTD_START_TIME);
        this.f16212b.showLoading(true);
        this.f16212b.J0(false);
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.q0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                z0.y(z0.this, str, observableEmitter);
            }
        }).compose(ma.q.b()).compose(this.f16211a.O2());
        final c cVar = new c();
        Consumer consumer = new Consumer() { // from class: l6.r0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.z(s9.l.this, obj);
            }
        };
        final d dVar = new d();
        compose.subscribe(consumer, new Consumer() { // from class: l6.s0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                z0.A(s9.l.this, obj);
            }
        });
    }
}
