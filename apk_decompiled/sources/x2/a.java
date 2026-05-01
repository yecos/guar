package x2;

import a3.c;
import a3.h;
import a3.j;
import com.dcs.bean.NetWorkUnavailableException;
import com.dcs.bean.V1Bean;
import com.dcs.bean.V1Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public y2.a f19408a;

    /* renamed from: b, reason: collision with root package name */
    public y2.a f19409b;

    /* renamed from: c, reason: collision with root package name */
    public Gson f19410c;

    /* renamed from: d, reason: collision with root package name */
    public int f19411d;

    /* renamed from: x2.a$a, reason: collision with other inner class name */
    public class C0333a extends u2.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19412b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19413c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f19414d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ RequestBody f19415e;

        public C0333a(String str, String str2, String str3, RequestBody requestBody) {
            this.f19412b = str;
            this.f19413c = str2;
            this.f19414d = str3;
            this.f19415e = requestBody;
        }

        @Override // u2.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            if (th instanceof NetWorkUnavailableException) {
                return Observable.never();
            }
            if (a.this.f19409b != null) {
                if (!"304,500,404,400,506,401".contains(b() + "")) {
                    return a.this.f19409b.a(this.f19412b, this.f19413c, this.f19414d, this.f19415e);
                }
            }
            return Observable.error(th);
        }
    }

    public a() {
        this.f19411d = 15;
        this.f19410c = new GsonBuilder().disableHtmlEscaping().create();
    }

    public final y2.a b(String str) {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        X509TrustManager a10 = c.a();
        if (a10 != null) {
            builder.sslSocketFactory(new h(a10), a10);
        }
        OkHttpClient.Builder retryOnConnectionFailure = builder.retryOnConnectionFailure(true);
        long j10 = this.f19411d;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        retryOnConnectionFailure.connectTimeout(j10, timeUnit).readTimeout(this.f19411d, timeUnit).writeTimeout(this.f19411d, timeUnit).dispatcher(new Dispatcher(j.f170a.d())).addInterceptor(new w2.a());
        Dns g10 = t2.a.f18798a.g();
        if (g10 != null) {
            builder.dns(g10);
        }
        return (y2.a) new Retrofit.Builder().client(builder.build()).baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(GsonConverterFactory.create()).build().create(y2.a.class);
    }

    public Observable c(V1Data v1Data) {
        RequestBody create = RequestBody.create(MediaType.parse("application/json"), this.f19410c.toJson(new V1Bean(a3.a.c(this.f19410c.toJson(v1Data)), 0)));
        j jVar = j.f170a;
        String e10 = jVar.e(jVar.b());
        String e11 = jVar.e(jVar.c());
        String e12 = t2.a.f18798a.e();
        return this.f19408a.a(e10, e11, e12, create).onErrorResumeNext(new C0333a(e10, e11, e12, create));
    }

    public a(String str, String str2) {
        this();
        this.f19408a = b(str);
        this.f19409b = b(str2);
    }
}
