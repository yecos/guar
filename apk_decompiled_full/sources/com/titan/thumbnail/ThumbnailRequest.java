package com.titan.thumbnail;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import m8.b;
import m8.d;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import t9.i;

/* loaded from: classes3.dex */
public final class ThumbnailRequest {
    private static Disposable mDisposable;
    private static ThumbnailCallback mthumbnailCallback;
    public static final ThumbnailRequest INSTANCE = new ThumbnailRequest();
    private static final String TAG = ThumbnailRequest.class.getSimpleName();
    private static final String baseUrl = baseUrl;
    private static final String baseUrl = baseUrl;
    private static long TIME_OUT = 15;
    private static final ConnectionPool sConnectionPool = new ConnectionPool(5, 2, TimeUnit.MINUTES);

    private ThumbnailRequest() {
    }

    private final Retrofit getRetrofit(String str) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j10 = TIME_OUT;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(j10, timeUnit).readTimeout(TIME_OUT, timeUnit).writeTimeout(TIME_OUT, timeUnit).connectionPool(sConnectionPool).build();
        i.c(build, "builder.build()");
        Retrofit build2 = new Retrofit.Builder().baseUrl(baseUrl).client(build).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        i.c(build2, "Retrofit.Builder()\n     …e())\n            .build()");
        return build2;
    }

    private final Observable<ThumbnailResult> getThumbnailResult(String str) {
        Observable compose = ((ThumbnailApi) getRetrofit(str).create(ThumbnailApi.class)).getThumbnail(str).compose(b.a());
        i.c(compose, "getRetrofit(snapInfoUrl)…chedulerHelper.io2main())");
        return compose;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void request(String str) {
        if (d.a(str)) {
            ThumbnailCallback thumbnailCallback = mthumbnailCallback;
            if (thumbnailCallback != null) {
                thumbnailCallback.onGetThumbnail(false);
                return;
            }
            return;
        }
        Disposable disposable = mDisposable;
        if (disposable != null && !disposable.isDisposed()) {
            Disposable disposable2 = mDisposable;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            mDisposable = null;
        }
        getThumbnailResult(str).subscribe(new Observer<ThumbnailResult>() { // from class: com.titan.thumbnail.ThumbnailRequest$request$1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ThumbnailCallback thumbnailCallback2;
                i.h(th, "e");
                ThumbnailRequest thumbnailRequest = ThumbnailRequest.INSTANCE;
                thumbnailCallback2 = ThumbnailRequest.mthumbnailCallback;
                if (thumbnailCallback2 != null) {
                    thumbnailCallback2.onGetThumbnail(false);
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable3) {
                i.h(disposable3, "d");
                ThumbnailRequest thumbnailRequest = ThumbnailRequest.INSTANCE;
                ThumbnailRequest.mDisposable = disposable3;
            }

            @Override // io.reactivex.Observer
            public void onNext(ThumbnailResult thumbnailResult) {
                ThumbnailCallback thumbnailCallback2;
                ThumbnailCallback thumbnailCallback3;
                i.h(thumbnailResult, "t");
                if (d.b(thumbnailResult.getSource_url()) && thumbnailResult.getCombines() != null) {
                    if (thumbnailResult.getCombines() == null) {
                        i.q();
                    }
                    if (!r0.isEmpty()) {
                        ThumbnailUtil.INSTANCE.setData(thumbnailResult);
                        ThumbnailRequest thumbnailRequest = ThumbnailRequest.INSTANCE;
                        thumbnailCallback3 = ThumbnailRequest.mthumbnailCallback;
                        if (thumbnailCallback3 != null) {
                            thumbnailCallback3.onGetThumbnail(true);
                            return;
                        }
                        return;
                    }
                }
                ThumbnailRequest thumbnailRequest2 = ThumbnailRequest.INSTANCE;
                thumbnailCallback2 = ThumbnailRequest.mthumbnailCallback;
                if (thumbnailCallback2 != null) {
                    thumbnailCallback2.onGetThumbnail(false);
                }
            }
        });
    }

    public final void cancel() {
        Disposable disposable;
        Disposable disposable2 = mDisposable;
        if (disposable2 != null && !disposable2.isDisposed() && (disposable = mDisposable) != null) {
            disposable.dispose();
        }
        mDisposable = null;
    }

    public final void getThumbnail(final String str) {
        i.h(str, "snapInfoUrl");
        Observable.just("ioSchedulers").compose(b.b()).subscribe(new Consumer<String>() { // from class: com.titan.thumbnail.ThumbnailRequest$getThumbnail$1
            @Override // io.reactivex.functions.Consumer
            public final void accept(String str2) {
                ThumbnailRequest.INSTANCE.request(str);
            }
        }, new Consumer<Throwable>() { // from class: com.titan.thumbnail.ThumbnailRequest$getThumbnail$2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    public final void setThumbnailCallback(ThumbnailCallback thumbnailCallback) {
        mthumbnailCallback = thumbnailCallback;
    }
}
