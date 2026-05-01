package b6;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.view.vod.CouponFloatView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface q {

    public static final class a {

        /* renamed from: b6.q$a$a, reason: collision with other inner class name */
        public static final class C0072a extends RecyclerView.t {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f4854a;

            /* renamed from: b6.q$a$a$a, reason: collision with other inner class name */
            public static final class C0073a implements Observer {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ q f4855a;

                public C0073a(q qVar) {
                    this.f4855a = qVar;
                }

                public void a(long j10) {
                    CouponFloatView D0 = this.f4855a.D0();
                    if (D0 != null) {
                        CouponFloatView.slideOut$default(D0, 0L, 1, null);
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    t9.i.g(th, "e");
                }

                @Override // io.reactivex.Observer
                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    a(((Number) obj).longValue());
                }

                @Override // io.reactivex.Observer
                public void onSubscribe(Disposable disposable) {
                    t9.i.g(disposable, "d");
                    this.f4855a.setDisposable(disposable);
                }
            }

            public C0072a(q qVar) {
                this.f4854a = qVar;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
                t9.i.g(recyclerView, "recyclerView");
                if (this.f4854a.D0() == null) {
                    return;
                }
                super.onScrollStateChanged(recyclerView, i10);
                if (i10 == 0) {
                    Observable.timer(2L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0073a(this.f4854a));
                    return;
                }
                if (i10 == 1 || i10 == 2) {
                    Disposable P1 = this.f4854a.P1();
                    if (P1 != null) {
                        P1.dispose();
                    }
                    CouponFloatView D0 = this.f4854a.D0();
                    if (D0 != null) {
                        CouponFloatView.slideIn$default(D0, 0L, 1, null);
                    }
                }
            }
        }

        public static void a(q qVar, Context context, ViewGroup viewGroup) {
            t9.i.g(viewGroup, "rootView");
            if (w6.i.f19214g.L() || qVar.D0() != null || context == null) {
                return;
            }
            qVar.Q1(new CouponFloatView(context, null, 0, 6, null));
            CouponFloatView D0 = qVar.D0();
            if (D0 != null) {
                D0.add(viewGroup);
            }
        }

        public static RecyclerView.t b(q qVar) {
            return new C0072a(qVar);
        }

        public static void c(q qVar) {
            CouponFloatView D0 = qVar.D0();
            if (D0 != null) {
                D0.remove();
            }
            qVar.Q1(null);
        }
    }

    CouponFloatView D0();

    Disposable P1();

    void Q1(CouponFloatView couponFloatView);

    void setDisposable(Disposable disposable);
}
