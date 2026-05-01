package ka;

import android.text.TextUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import ma.f;
import ma.r;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Retrofit f15709a;

    /* renamed from: b, reason: collision with root package name */
    public d f15710b;

    /* renamed from: c, reason: collision with root package name */
    public String f15711c;

    public class a implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f15712a;

        public a(File file) {
            this.f15712a = file;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(InputStream inputStream) {
            b.this.c(inputStream, this.f15712a);
        }
    }

    /* renamed from: ka.b$b, reason: collision with other inner class name */
    public class C0266b implements Function {
        public C0266b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream apply(ResponseBody responseBody) {
            return responseBody.byteStream();
        }
    }

    public b(String str, d dVar) {
        try {
            str = TextUtils.isEmpty(str) ? "http://www.baidu.com" : str;
            this.f15711c = str;
            this.f15710b = dVar;
            c cVar = new c(dVar);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.proxy(Proxy.NO_PROXY);
            builder.addInterceptor(cVar).retryOnConnectionFailure(true).connectTimeout(15L, TimeUnit.SECONDS).addInterceptor(new la.a(".subtitle")).dns(new ja.c(".subtitle"));
            X509TrustManager a10 = f.a();
            if (a10 != null) {
                builder.sslSocketFactory(new r(a10), a10);
            }
            this.f15709a = new Retrofit.Builder().baseUrl(str).client(builder.build()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void b(String str, File file, Observer observer) {
        try {
            ((ka.a) this.f15709a.create(ka.a.class)).a(str).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).map(new C0266b()).observeOn(Schedulers.computation()).doOnNext(new a(file)).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void c(InputStream inputStream, File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e10) {
            this.f15710b.c(e10);
        } catch (IOException e11) {
            this.f15710b.c(e11);
        } catch (Exception e12) {
            this.f15710b.c(e12);
        }
    }
}
