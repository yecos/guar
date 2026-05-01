package x1;

import anet.channel.util.HttpConstant;
import com.advertlib.bean.AdReportRequest;
import com.advertlib.bean.AdvertBean;
import com.advertlib.bean.AdvertResult;
import com.advertlib.bean.ReportResult;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.taobao.accs.utl.BaseMonitor;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: g, reason: collision with root package name */
    public static final b f19391g = new b(null);

    /* renamed from: h, reason: collision with root package name */
    public static final String f19392h = HttpConstant.HTTP;

    /* renamed from: i, reason: collision with root package name */
    public static final h9.g f19393i = h.b(a.f19400a);

    /* renamed from: a, reason: collision with root package name */
    public Dns f19394a;

    /* renamed from: b, reason: collision with root package name */
    public Interceptor f19395b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19396c;

    /* renamed from: d, reason: collision with root package name */
    public final h9.g f19397d;

    /* renamed from: e, reason: collision with root package name */
    public final Gson f19398e;

    /* renamed from: f, reason: collision with root package name */
    public long f19399f;

    public static final class a extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19400a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DomainInfo invoke() {
            return t2.a.f18798a.b(m7.c.a().first.toString(), m7.c.a().second.toString(), "key_ads");
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final String a() {
            return d.f19392h;
        }

        public final DomainInfo b() {
            return (DomainInfo) d.f19393i.getValue();
        }
    }

    public static final class c implements Function {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestBody f19402b;

        public c(RequestBody requestBody) {
            this.f19402b = requestBody;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable apply(Throwable th) {
            i.g(th, "t");
            x1.a i10 = d.this.i();
            b bVar = d.f19391g;
            return i10.b(bVar.a(), bVar.b().getSecond(), this.f19402b);
        }
    }

    /* renamed from: x1.d$d, reason: collision with other inner class name */
    public static final class C0332d extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final C0332d f19403a = new C0332d();

        public C0332d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            t2.a.f18798a.q(d.f19391g.b(), "key_ads");
        }
    }

    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x1.a invoke() {
            return (x1.a) d.this.j().create(x1.a.class);
        }
    }

    public static final class f implements Function {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestBody f19406b;

        public f(RequestBody requestBody) {
            this.f19406b = requestBody;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable apply(Throwable th) {
            i.g(th, "t");
            x1.a i10 = d.this.i();
            b bVar = d.f19391g;
            return i10.a(bVar.a(), bVar.b().getSecond(), this.f19406b);
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f19407a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            t2.a.f18798a.q(d.f19391g.b(), "key_ads");
        }
    }

    public d(Dns dns, Interceptor interceptor) {
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f19394a = dns;
        this.f19395b = interceptor;
        this.f19396c = d.class.getSimpleName();
        this.f19397d = h.b(new e());
        this.f19399f = 15L;
        Gson create = new GsonBuilder().disableHtmlEscaping().create();
        i.f(create, "GsonBuilder().disableHtmlEscaping().create()");
        this.f19398e = create;
    }

    public static final void h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final Observable g(AdvertBean advertBean) {
        i.g(advertBean, "bean");
        String json = this.f19398e.toJson(advertBean);
        i.f(json, "mGson.toJson(bean)");
        RequestBody n10 = n(json);
        Observable<AdvertResult> onErrorResumeNext = i().b(f19392h, f19391g.b().getFirst(), n10).onErrorResumeNext(new c(n10));
        final C0332d c0332d = C0332d.f19403a;
        Observable<AdvertResult> doOnError = onErrorResumeNext.doOnError(new Consumer() { // from class: x1.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d.h(l.this, obj);
            }
        });
        i.f(doOnError, "fun getAd(bean: AdvertBe…\n                }\n\n    }");
        return doOnError;
    }

    public final x1.a i() {
        Object value = this.f19397d.getValue();
        i.f(value, "<get-mAdApi>(...)");
        return (x1.a) value;
    }

    public final Retrofit j() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j10 = this.f19399f;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder dns = builder.connectTimeout(j10, timeUnit).readTimeout(this.f19399f, timeUnit).writeTimeout(this.f19399f, timeUnit).connectionPool(o2.a.a()).dns(this.f19394a);
        Interceptor interceptor = this.f19395b;
        if (interceptor != null) {
            dns.addInterceptor(interceptor);
        }
        X509TrustManager a10 = y1.a.a();
        if (a10 != null) {
            dns.sslSocketFactory(new y1.d(a10), a10);
        }
        OkHttpClient build = dns.build();
        i.f(build, "builder.build()");
        Retrofit build2 = new Retrofit.Builder().baseUrl("http://www.baidu.com").client(build).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        i.f(build2, "Builder()\n              …\n                .build()");
        return build2;
    }

    public final Observable k(AdReportRequest adReportRequest) {
        i.g(adReportRequest, "bean");
        String json = this.f19398e.toJson(adReportRequest);
        i.f(json, "mGson.toJson(bean)");
        RequestBody n10 = n(json);
        Observable<ReportResult> onErrorResumeNext = i().a(f19392h, f19391g.b().getFirst(), n10).onErrorResumeNext(new f(n10));
        final g gVar = g.f19407a;
        Observable<ReportResult> doOnError = onErrorResumeNext.doOnError(new Consumer() { // from class: x1.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d.l(l.this, obj);
            }
        });
        i.f(doOnError, "fun reportAd(bean: AdRep…)\n                }\n    }");
        return doOnError;
    }

    public final Call m(String str) {
        i.g(str, "videoUrl");
        return i().c(str);
    }

    public final RequestBody n(String str) {
        RequestBody create = RequestBody.create(MediaType.parse("application/json"), str);
        i.f(create, "create(MediaType.parse(\"application/json\"), str)");
        return create;
    }
}
