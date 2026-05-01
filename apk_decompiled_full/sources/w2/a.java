package w2;

import a3.d;
import a3.j;
import android.content.Context;
import android.os.SystemClock;
import ba.t;
import com.dcs.bean.NetWorkUnavailableException;
import com.taobao.accs.common.Constants;
import com.umeng.umcrash.UMCrash;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;
import t9.i;
import v2.b;

/* loaded from: classes.dex */
public final class a implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f19147a;

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f19147a = simpleName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        if (ba.t.o(r3, "Canceled", false, 2, r15) == true) goto L38;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        String str;
        long j10;
        Object obj;
        boolean z10;
        b f10;
        i.g(chain, "chain");
        Request build = chain.request().newBuilder().build();
        URL url = build.url().url();
        String path = url.getPath();
        String a10 = d.a(url.getHost(), d.f161a);
        url.getProtocol();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        t2.a aVar = t2.a.f18798a;
        i.f(a10, Constants.KEY_HOST);
        aVar.v(a10);
        Context a11 = aVar.a();
        if (a11 != null && !j.f170a.f(a11)) {
            throw new NetWorkUnavailableException();
        }
        try {
            Response proceed = chain.proceed(build);
            int code = proceed.code();
            i.f(path, "path");
            if (t.o(path, "v1", false, 2, null) || t.o(path, "n1", false, 2, null)) {
                aVar.x(proceed.header(UMCrash.SP_KEY_TIMESTAMP));
            }
            if (code == 200 || code == 304 || (f10 = aVar.f()) == null) {
                str = Constants.KEY_HOST;
                j10 = elapsedRealtime;
                obj = null;
            } else {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                i.f(a10, Constants.KEY_HOST);
                j10 = elapsedRealtime;
                obj = null;
                str = Constants.KEY_HOST;
                try {
                    f10.a(elapsedRealtime, elapsedRealtime2, path, a10, code, true);
                } catch (Exception e10) {
                    e = e10;
                    String message = e.getMessage();
                    if (message != null) {
                        z10 = true;
                    }
                    z10 = false;
                    if (!z10) {
                        int code2 = e instanceof HttpException ? ((HttpException) e).code() : e instanceof TimeoutException ? 50010 : e instanceof ConnectException ? 50011 : e instanceof SocketTimeoutException ? 50012 : e instanceof SSLException ? 50013 : e instanceof UnknownHostException ? 50014 : 50015;
                        b f11 = t2.a.f18798a.f();
                        if (f11 != null) {
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            i.f(path, "path");
                            i.f(a10, str);
                            f11.a(j10, elapsedRealtime3, path, a10, code2, true);
                        }
                    }
                    throw e;
                }
            }
            i.f(proceed, "mResponse");
            return proceed;
        } catch (Exception e11) {
            e = e11;
            str = Constants.KEY_HOST;
            j10 = elapsedRealtime;
            obj = null;
        }
    }
}
