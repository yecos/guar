package v5;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.business.message.db.MessageDao;
import com.mobile.brasiltv.utils.b0;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import ma.q;
import s9.l;
import t9.i;
import t9.j;
import w5.m;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f19112a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static int f19113b;

    /* renamed from: c, reason: collision with root package name */
    public static int f19114c;

    /* renamed from: d, reason: collision with root package name */
    public static int f19115d;

    /* renamed from: e, reason: collision with root package name */
    public static h f19116e;

    public static final class a extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19117a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(Integer num) {
            i.g(num, "it");
            m mVar = m.f19178a;
            MessageDao C = mVar.C();
            d6.b bVar = d6.b.f12660a;
            int queryCouponNum = C.queryCouponNum(bVar.l());
            b0.U(g.f19112a, "cache coupon num is " + queryCouponNum);
            int intValue = num.intValue() - queryCouponNum;
            if (intValue < 0) {
                mVar.C().updateCouponNum(bVar.l(), num.intValue());
            }
            return Integer.valueOf(intValue);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f19118a = new b();

        public b() {
            super(1);
        }

        public final void b(Integer num) {
            g gVar = g.f19112a;
            i.f(num, "it");
            gVar.v((num.intValue() < 0 ? 0 : num).intValue());
            b0.U(gVar, "diff coupon num is " + num);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f14242a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f19119a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f19120a = new d();

        public d() {
            super(1);
        }

        public final void b(Integer num) {
            g gVar = g.f19112a;
            gVar.v(0);
            b0.U(gVar, "update coupon num is " + num);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f14242a;
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f19121a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final Integer h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (Integer) lVar.invoke(obj);
    }

    public static final void i(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void j(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(ObservableEmitter observableEmitter) {
        i.g(observableEmitter, "it");
        m mVar = m.f19178a;
        MessageDao C = mVar.C();
        d6.b bVar = d6.b.f12660a;
        int queryCouponNum = C.queryCouponNum(bVar.l());
        g gVar = f19112a;
        b0.U(gVar, "cache coupon num is " + queryCouponNum);
        int l10 = queryCouponNum + gVar.l();
        mVar.C().updateCouponNum(bVar.l(), l10);
        observableEmitter.onNext(Integer.valueOf(l10));
        observableEmitter.onComplete();
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void g(int i10) {
        Observable just = Observable.just(Integer.valueOf(i10));
        final a aVar = a.f19117a;
        Observable compose = just.map(new Function() { // from class: v5.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer h10;
                h10 = g.h(l.this, obj);
                return h10;
            }
        }).compose(q.b());
        final b bVar = b.f19118a;
        Consumer consumer = new Consumer() { // from class: v5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.i(l.this, obj);
            }
        };
        final c cVar = c.f19119a;
        compose.subscribe(consumer, new Consumer() { // from class: v5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.j(l.this, obj);
            }
        });
    }

    public final int k() {
        return f19114c;
    }

    public final int l() {
        return f19115d;
    }

    public final int m() {
        return f19113b + f19114c;
    }

    public final int n() {
        return f19113b;
    }

    public final void o(h hVar) {
        i.g(hVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f19116e = hVar;
    }

    public final void p() {
        f19116e = null;
        f19113b = 0;
        f19114c = 0;
        f19115d = 0;
    }

    public final void q(int i10) {
        f19114c = i10;
        h hVar = f19116e;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void r() {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: v5.d
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                g.s(observableEmitter);
            }
        }).compose(q.b());
        final d dVar = d.f19120a;
        Consumer consumer = new Consumer() { // from class: v5.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.t(l.this, obj);
            }
        };
        final e eVar = e.f19121a;
        compose.subscribe(consumer, new Consumer() { // from class: v5.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.u(l.this, obj);
            }
        });
    }

    public final void v(int i10) {
        f19115d = i10;
        h hVar = f19116e;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void w(int i10) {
        f19113b = i10;
        h hVar = f19116e;
        if (hVar != null) {
            hVar.a();
        }
    }
}
