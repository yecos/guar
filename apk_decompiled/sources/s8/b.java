package s8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

/* loaded from: classes3.dex */
public final class b implements ObservableTransformer, FlowableTransformer, SingleTransformer, MaybeTransformer, CompletableTransformer {

    /* renamed from: a, reason: collision with root package name */
    public final Observable f18783a;

    public b(Observable observable) {
        v8.a.a(observable, "observable == null");
        this.f18783a = observable;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource apply(Observable observable) {
        return observable.takeUntil(this.f18783a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f18783a.equals(((b) obj).f18783a);
    }

    public int hashCode() {
        return this.f18783a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f18783a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    @Override // io.reactivex.FlowableTransformer
    public fb.b apply(Flowable flowable) {
        return flowable.takeUntil(this.f18783a.toFlowable(BackpressureStrategy.LATEST));
    }

    @Override // io.reactivex.SingleTransformer
    public SingleSource apply(Single single) {
        return single.takeUntil(this.f18783a.firstOrError());
    }

    @Override // io.reactivex.MaybeTransformer
    public MaybeSource apply(Maybe maybe) {
        return maybe.takeUntil(this.f18783a.firstElement());
    }

    @Override // io.reactivex.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        return Completable.ambArray(completable, this.f18783a.flatMapCompletable(a.f18782c));
    }
}
