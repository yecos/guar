package c5;

import android.content.Context;
import android.content.pm.PackageManager;
import com.dcs.bean.DomainInfo;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.bean.UpdateBean;
import d5.d;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import j7.f;
import java.net.Proxy;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.c;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public c5.b f5609a;

    /* renamed from: b, reason: collision with root package name */
    public c5.b f5610b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f5611c;

    /* renamed from: d, reason: collision with root package name */
    public Disposable f5612d;

    /* renamed from: e, reason: collision with root package name */
    public DomainInfo f5613e = t2.a.f18798a.b(c.j().first.toString(), c.j().second.toString(), "key_update");

    /* renamed from: c5.a$a, reason: collision with other inner class name */
    public class C0081a implements Observer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h7.a f5614a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5615b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5616c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f5617d;

        public C0081a(h7.a aVar, String str, String str2, String str3) {
            this.f5614a = aVar;
            this.f5615b = str;
            this.f5616c = str2;
            this.f5617d = str3;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(UpdateBean updateBean) {
            a.this.k("main return result " + updateBean);
            this.f5614a.onOver(updateBean);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f5614a.onCompleted();
            a.this.k("main completed");
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a.this.k("main error " + th.toString());
            if ((th instanceof NullPointerException) && th.getMessage().contains("Null is not a valid element")) {
                a.this.k("main check no update info");
                this.f5614a.onError(th);
            } else {
                h.e("updateA", th);
                a.this.j(this.f5615b, this.f5616c, this.f5617d, this.f5614a);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            a.this.f5611c = disposable;
        }
    }

    public class b implements Observer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h7.a f5619a;

        public b(h7.a aVar) {
            this.f5619a = aVar;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(UpdateBean updateBean) {
            a.this.k("second return result " + updateBean);
            this.f5619a.onOver(updateBean);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a.this.k("second completed");
            this.f5619a.onCompleted();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a.this.k("second error " + th.toString());
            this.f5619a.onError(th);
            h.e("updateB", th);
            t2.a.f18798a.q(a.this.f5613e, "key_update");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            a.this.f5612d = disposable;
        }
    }

    public a(Dns dns, Interceptor interceptor) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        OkHttpClient build = builder.connectTimeout(20L, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor).addInterceptor(interceptor).dns(dns).build();
        this.f5609a = l("http://" + this.f5613e.getFirst(), build);
        this.f5610b = l("http://" + this.f5613e.getSecond(), build);
    }

    public void f() {
        Disposable disposable = this.f5611c;
        if (disposable != null) {
            disposable.dispose();
            this.f5611c = null;
        }
        Disposable disposable2 = this.f5612d;
        if (disposable2 != null) {
            disposable2.dispose();
            this.f5612d = null;
        }
    }

    public void g(Context context, String str, String str2, h7.a aVar) {
        String packageName = context.getApplicationContext().getPackageName();
        int i10 = 0;
        try {
            i10 = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 0).versionCode;
            str = j7.c.a(str, "tvmarket");
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        h(packageName, i10, str, str2, aVar);
    }

    public void h(String str, int i10, String str2, String str3, h7.a aVar) {
        i(str + "," + i10, str2, str3, aVar);
    }

    public final void i(String str, String str2, String str3, h7.a aVar) {
        m(this.f5609a, str, str2, str3).subscribe(new C0081a(aVar, str, str2, str3));
    }

    public final void j(String str, String str2, String str3, h7.a aVar) {
        m(this.f5610b, str, str2, str3).subscribe(new b(aVar));
    }

    public final void k(String str) {
    }

    public final c5.b l(String str, OkHttpClient okHttpClient) {
        return (c5.b) new Retrofit.Builder().baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(new d()).client(okHttpClient).build().create(c5.b.class);
    }

    public final Observable m(c5.b bVar, String str, String str2, String str3) {
        String language = "zh".equals(Locale.getDefault().getLanguage()) ? XML.DEFAULT_CONTENT_LANGUAGE : Locale.getDefault().getLanguage();
        if (str3.isEmpty()) {
            str3 = "unknown";
        }
        return bVar.a("checkUpdate", str, language, str2, str3).compose(f.a());
    }
}
