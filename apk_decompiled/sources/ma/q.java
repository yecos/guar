package ma;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public abstract class q {

    public class a implements SingleTransformer {
        @Override // io.reactivex.SingleTransformer
        public SingleSource apply(Single single) {
            return single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public class b implements ObservableTransformer {
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public class c implements ObservableTransformer {
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
        }
    }

    public static ObservableTransformer a() {
        return new c();
    }

    public static ObservableTransformer b() {
        return new b();
    }

    public static SingleTransformer c() {
        return new a();
    }
}
