package oa;

import com.dcs.bean.DomainInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f17670a = 10;

    /* renamed from: b, reason: collision with root package name */
    public qa.a f17671b;

    /* renamed from: c, reason: collision with root package name */
    public qa.a f17672c;

    /* renamed from: d, reason: collision with root package name */
    public DomainInfo f17673d;

    public class a extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17674b;

        public a(String str) {
            this.f17674b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return b.this.f17672c != null ? b.this.f17672c.b(this.f17674b) : Observable.error(th);
        }
    }

    public b(DomainInfo domainInfo) {
        this.f17673d = domainInfo;
        String str = "http://" + this.f17673d.getFirst();
        String str2 = "http://" + this.f17673d.getSecond();
        this.f17671b = e(str);
        this.f17672c = e(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Throwable th) {
        t2.a.f18798a.q(this.f17673d, "key_epg");
    }

    public Observable c(String str) {
        String str2 = "/epg/live/app/" + str;
        return this.f17671b.b(str2).onErrorResumeNext(new a(str2)).observeOn(Schedulers.computation()).doOnError(new Consumer() { // from class: oa.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b.this.d((Throwable) obj);
            }
        });
    }

    public final qa.a e(String str) {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        OkHttpClient.Builder retryOnConnectionFailure = builder.retryOnConnectionFailure(true);
        long j10 = this.f17670a;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (qa.a) new Retrofit.Builder().client(retryOnConnectionFailure.connectTimeout(j10, timeUnit).readTimeout(this.f17670a, timeUnit).writeTimeout(this.f17670a, timeUnit).dispatcher(new Dispatcher(na.a.f())).addInterceptor(new la.b()).dns(new ja.c(".epg")).build()).baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(GsonConverterFactory.create()).build().create(qa.a.class);
    }
}
