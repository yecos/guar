package s8;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/* loaded from: classes3.dex */
public abstract class d {

    public static class a implements Predicate {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f18784a;

        public a(Object obj) {
            this.f18784a = obj;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return obj.equals(this.f18784a);
        }
    }

    public static class b implements BiFunction {
        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj, Object obj2) {
            return Boolean.valueOf(obj2.equals(obj));
        }
    }

    public static s8.b a(Observable observable) {
        return new s8.b(observable);
    }

    public static s8.b b(Observable observable, Function function) {
        v8.a.a(observable, "lifecycle == null");
        v8.a.a(function, "correspondingEvents == null");
        return a(d(observable.share(), function));
    }

    public static s8.b c(Observable observable, Object obj) {
        v8.a.a(observable, "lifecycle == null");
        v8.a.a(obj, "event == null");
        return a(e(observable, obj));
    }

    public static Observable d(Observable observable, Function function) {
        return Observable.combineLatest(observable.take(1L).map(function), observable.skip(1L), new b()).onErrorReturn(s8.a.f18780a).filter(s8.a.f18781b);
    }

    public static Observable e(Observable observable, Object obj) {
        return observable.filter(new a(obj));
    }
}
