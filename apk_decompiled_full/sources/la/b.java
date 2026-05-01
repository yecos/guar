package la;

import android.os.Build;
import android.os.SystemClock;
import ba.t;
import com.taobao.accs.common.Constants;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import mobile.com.requestframe.utils.bean.ResultException;
import na.e;
import na.f;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;
import s9.l;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class b implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16439b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static l f16440c;

    /* renamed from: a, reason: collision with root package name */
    public final String f16441a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(l lVar) {
            i.g(lVar, "slbCallback");
            b(lVar);
        }

        public final void b(l lVar) {
            b.f16440c = lVar;
        }
    }

    public b() {
        String simpleName = b.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f16441a = simpleName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f2, code lost:
    
        if (ba.t.o(r4, "Canceled", false, r3, r2) == true) goto L31;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        String str;
        Object obj;
        String str2;
        int i10;
        boolean z10;
        i.g(chain, "chain");
        Request request = chain.request();
        Request.Builder addHeader = request.newBuilder().addHeader("Content-Type", "application/json;charset=utf-8").addHeader("apk", na.a.g()).addHeader("apkVer", String.valueOf(na.a.b())).addHeader("spkgVer", Build.VERSION.RELEASE);
        URL url = request.url().url();
        String path = url.getPath();
        i.f(path, "path");
        if (t.o(path, "dcs/getAddr", false, 2, null)) {
            String f10 = f.f(na.a.f17333a, "key_user_id", "");
            String f11 = f.f(na.a.f17333a, "key_user_identity", "");
            addHeader.addHeader("userId", f10);
            addHeader.addHeader("userIdentity", f11);
        }
        Request build = addHeader.build();
        String a10 = a3.d.a(url.getHost(), a3.d.f161a);
        url.getProtocol();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Response proceed = chain.proceed(build);
            int code = proceed.code();
            if ((code == 200 || code == 304) && (code != 304 || t.o(path, "epg/", false, 2, null))) {
                str = a10;
                obj = null;
                str2 = path;
                i10 = 2;
            } else {
                c2.d dVar = c2.d.f5311a;
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                i.f(a10, Constants.KEY_HOST);
                str = a10;
                obj = null;
                i10 = 2;
                str2 = path;
                try {
                    dVar.d(elapsedRealtime, elapsedRealtime2, path, a10, code, (r23 & 32) != 0 ? "" : e.f17345e, (r23 & 64) != 0 ? null : null, true);
                } catch (Exception e10) {
                    e = e10;
                    if (!(e instanceof ResultException)) {
                        String message = e.getMessage();
                        if (message != null) {
                            z10 = true;
                        }
                        z10 = false;
                        if (!z10) {
                            int code2 = !(e instanceof HttpException) ? !(e instanceof TimeoutException) ? !(e instanceof ConnectException) ? !(e instanceof SocketTimeoutException) ? !(e instanceof SSLException) ? e instanceof UnknownHostException ? 50014 : 50015 : 50013 : 50012 : 50011 : 50010 : ((HttpException) e).code();
                            c2.d dVar2 = c2.d.f5311a;
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            String str3 = str;
                            i.f(str3, Constants.KEY_HOST);
                            dVar2.d(elapsedRealtime, elapsedRealtime3, str2, str3, code2, (r23 & 32) != 0 ? "" : e.f17345e, (r23 & 64) != 0 ? null : null, true);
                        }
                    }
                    throw e;
                }
            }
            i.f(proceed, "mResponse");
            return proceed;
        } catch (Exception e11) {
            e = e11;
            str = a10;
            obj = null;
            str2 = path;
            i10 = 2;
        }
    }
}
