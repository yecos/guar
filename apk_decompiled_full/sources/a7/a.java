package a7;

import android.os.SystemClock;
import ba.t;
import com.taobao.accs.common.Constants;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import mobile.com.requestframe.utils.bean.ResultException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final C0005a f272b = new C0005a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Set f273c = new LinkedHashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f274a;

    /* renamed from: a7.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        public C0005a() {
        }

        public /* synthetic */ C0005a(g gVar) {
            this();
        }
    }

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f274a = simpleName;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String str;
        String str2;
        i.g(chain, "chain");
        Request request = chain.request();
        URL url = request.url().url();
        String path = url.getPath();
        if (!i.b(request.header("ReqSource"), "own")) {
            Response proceed = chain.proceed(request);
            i.f(proceed, "chain.proceed(original)");
            return proceed;
        }
        Request build = request.newBuilder().build();
        String a10 = a3.d.a(url.getHost(), a3.d.f161a);
        url.getProtocol();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Response proceed2 = chain.proceed(build);
            int code = proceed2.code();
            if (code != 200) {
                String str3 = url.getHost() + code;
                Set set = f273c;
                if (!set.contains(str3)) {
                    set.add(str3);
                    c2.d dVar = c2.d.f5311a;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    i.f(path, "path");
                    i.f(a10, Constants.KEY_HOST);
                    str = a10;
                    str2 = path;
                    try {
                        dVar.d(elapsedRealtime, elapsedRealtime2, path, a10, code, (r23 & 32) != 0 ? "" : na.e.f17345e, (r23 & 64) != 0 ? null : null, true);
                        i.f(proceed2, "mResponse");
                        return proceed2;
                    } catch (Exception e10) {
                        e = e10;
                        if (!(e instanceof ResultException)) {
                            String message = e.getMessage();
                            boolean z10 = false;
                            if (message != null && t.o(message, "Canceled", false, 2, null)) {
                                z10 = true;
                            }
                            if (!z10) {
                                int code2 = e instanceof HttpException ? ((HttpException) e).code() : e instanceof TimeoutException ? 50010 : e instanceof ConnectException ? 50011 : e instanceof SocketTimeoutException ? 50012 : e instanceof SSLException ? 50013 : e instanceof UnknownHostException ? 50014 : 50015;
                                String str4 = url.getHost() + code2;
                                Set set2 = f273c;
                                if (!set2.contains(str4)) {
                                    set2.add(str4);
                                    c2.d dVar2 = c2.d.f5311a;
                                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                    i.f(str2, "path");
                                    String str5 = str;
                                    i.f(str5, Constants.KEY_HOST);
                                    dVar2.d(elapsedRealtime, elapsedRealtime3, str2, str5, code2, (r23 & 32) != 0 ? "" : na.e.f17345e, (r23 & 64) != 0 ? null : null, true);
                                }
                            }
                        }
                        throw e;
                    }
                }
            }
            str = a10;
            str2 = path;
            i.f(proceed2, "mResponse");
            return proceed2;
        } catch (Exception e11) {
            e = e11;
            str = a10;
            str2 = path;
        }
    }
}
