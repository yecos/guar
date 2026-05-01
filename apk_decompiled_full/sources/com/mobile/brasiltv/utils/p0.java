package com.mobile.brasiltv.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public abstract class p0 {

    public class a implements ObservableTransformer {
        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
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
        return new a();
    }

    public static ObservableTransformer b() {
        return new b();
    }

    public static ObservableTransformer c() {
        return new c();
    }
}
