package s8;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Function f18780a = new C0320a();

    /* renamed from: b, reason: collision with root package name */
    public static final Predicate f18781b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final Function f18782c = new c();

    /* renamed from: s8.a$a, reason: collision with other inner class name */
    public static class C0320a implements Function {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Throwable th) {
            if (th instanceof s8.c) {
                return Boolean.TRUE;
            }
            Exceptions.propagate(th);
            return Boolean.FALSE;
        }
    }

    public static class b implements Predicate {
        @Override // io.reactivex.functions.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    public static class c implements Function {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Completable apply(Object obj) {
            return Completable.error(new CancellationException());
        }
    }
}
