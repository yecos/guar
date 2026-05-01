package i2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final b f14275c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final h9.g f14276d = h9.h.b(a.f14279a);

    /* renamed from: a, reason: collision with root package name */
    public Disposable f14277a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14278b;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14279a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final d invoke() {
            return new d(null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final d a() {
            return (d) d.f14276d.getValue();
        }
    }

    public interface c {
        void a();
    }

    /* renamed from: i2.d$d, reason: collision with other inner class name */
    public static final class C0228d implements Observer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f14281b;

        public C0228d(c cVar) {
            this.f14281b = cVar;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            c cVar;
            t9.i.g(str, "s");
            Disposable disposable = d.this.f14277a;
            boolean z10 = false;
            if (disposable != null && !disposable.isDisposed()) {
                z10 = true;
            }
            if (!z10 || (cVar = this.f14281b) == null) {
                return;
            }
            cVar.a();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            d.this.f14277a = disposable;
        }
    }

    public /* synthetic */ d(t9.g gVar) {
        this();
    }

    public static final void g(ObservableEmitter observableEmitter) {
        t9.i.g(observableEmitter, "emitter");
        observableEmitter.onNext("insert");
        observableEmitter.onComplete();
    }

    public final void e() {
        Disposable disposable;
        Disposable disposable2 = this.f14277a;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (!z10 || (disposable = this.f14277a) == null) {
            return;
        }
        disposable.dispose();
    }

    public final void f(c cVar) {
        Observable.create(new ObservableOnSubscribe() { // from class: i2.c
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                d.g(observableEmitter);
            }
        }).compose(s2.c.b()).subscribe(new C0228d(cVar));
    }

    public d() {
        this.f14278b = d.class.getSimpleName();
    }
}
