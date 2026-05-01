package m8;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import t9.i;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Disposable f16835a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16836b = "RxTimerUtil";

    public interface a {
        void a(String str);
    }

    public static final class b implements Function {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.a f16837a;

        public b(s9.a aVar) {
            this.f16837a = aVar;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String apply(Long l10) {
            i.h(l10, "it");
            return (String) this.f16837a.invoke();
        }
    }

    /* renamed from: m8.c$c, reason: collision with other inner class name */
    public static final class C0288c implements Observer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f16839b;

        public C0288c(a aVar) {
            this.f16839b = aVar;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            i.h(str, "programData");
            a aVar = this.f16839b;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            String unused = c.this.f16836b;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            i.h(th, "e");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            i.h(disposable, "disposable");
            c.this.f16835a = disposable;
        }
    }

    public final void c() {
        Disposable disposable;
        Disposable disposable2 = this.f16835a;
        if (disposable2 != null && !disposable2.isDisposed() && (disposable = this.f16835a) != null) {
            disposable.dispose();
        }
        this.f16835a = null;
    }

    public final void d(long j10, s9.a aVar, a aVar2) {
        i.h(aVar, "subscribe");
        Observable.interval(j10, TimeUnit.SECONDS).map(new b(aVar)).compose(m8.b.a()).subscribe(new C0288c(aVar2));
    }
}
