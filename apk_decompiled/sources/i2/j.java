package i2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final b f14291c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final h9.g f14292d = h9.h.b(a.f14295a);

    /* renamed from: a, reason: collision with root package name */
    public Disposable f14293a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14294b;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14295a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j invoke() {
            return new j(null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final j a() {
            return (j) j.f14292d.getValue();
        }
    }

    public interface c {
        void a();
    }

    public static final class d implements Observer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f14297b;

        public d(c cVar) {
            this.f14297b = cVar;
        }

        public void a(long j10) {
            c cVar = this.f14297b;
            if (cVar != null) {
                cVar.a();
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
            t9.i.g(disposable, "disposable");
            j.this.f14293a = disposable;
        }
    }

    public /* synthetic */ j(t9.g gVar) {
        this();
    }

    public final void c() {
        Disposable disposable;
        Disposable disposable2 = this.f14293a;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (!z10 || (disposable = this.f14293a) == null) {
            return;
        }
        disposable.dispose();
    }

    public final void d(long j10, long j11, c cVar) {
        Observable.interval(j10, j11, TimeUnit.SECONDS).compose(s2.c.b()).safeSubscribe(new d(cVar));
    }

    public j() {
        this.f14294b = j.class.getSimpleName();
    }
}
