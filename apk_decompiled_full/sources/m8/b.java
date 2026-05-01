package m8;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public abstract class b {

    public static class a implements ObservableTransformer {
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    /* renamed from: m8.b$b, reason: collision with other inner class name */
    public static class C0287b implements ObservableTransformer {
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
        }
    }

    public static ObservableTransformer a() {
        return new a();
    }

    public static ObservableTransformer b() {
        return new C0287b();
    }
}
