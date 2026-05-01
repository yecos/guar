package ma;

import android.content.Context;
import android.os.SystemClock;
import com.taobao.accs.common.Constants;
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

/* loaded from: classes.dex */
public final class c implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16850a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16851b;

    public c(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f16850a = context;
        String simpleName = c.class.getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        this.f16851b = simpleName;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:2|3)|(7:(5:(1:54)|56|13|14|15)|10|11|12|13|14|15)|6|7|8|9|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00aa, code lost:
    
        if (ba.t.o(r9, "Canceled", r6, 2, null) == true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
    
        r18 = r6;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0051, code lost:
    
        if (ba.t.o(r14, "epg/", false, 2, null) == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        boolean z10;
        boolean z11;
        Response proceed;
        int code;
        String sb;
        String str;
        d dVar;
        Context context;
        String str2;
        t9.i.g(chain, "chain");
        Request request = chain.request();
        URL url = request.url().url();
        String path = url.getPath();
        Request build = request.newBuilder().build();
        String host = url.getHost();
        url.getProtocol();
        SystemClock.elapsedRealtime();
        try {
            proceed = chain.proceed(build);
            code = proceed.code();
        } catch (Exception e10) {
            e = e10;
            z10 = false;
        }
        try {
            try {
                if (code == 200 || code == 304) {
                    if (code == 304) {
                        t9.i.f(path, "path");
                    }
                    z10 = false;
                    t9.i.f(proceed, "mResponse");
                    return proceed;
                }
                t9.i.f(proceed, "mResponse");
                return proceed;
            } catch (Exception e11) {
                e = e11;
                String message = e.getMessage();
                z11 = message != null;
                if (!z11) {
                    StringBuilder sb2 = new StringBuilder();
                    na.g gVar = na.g.f17347a;
                    t9.i.f(host, Constants.KEY_HOST);
                    sb2.append(gVar.a(host));
                    sb2.append(".bigbee");
                    String sb3 = sb2.toString();
                    int code2 = !(e instanceof HttpException) ? !(e instanceof TimeoutException) ? !(e instanceof ConnectException) ? !(e instanceof SocketTimeoutException) ? !(e instanceof SSLException) ? e instanceof UnknownHostException ? 50014 : 50015 : 50013 : 50012 : 50011 : 50010 : ((HttpException) e).code();
                    d dVar2 = d.f16852a;
                    Context context2 = this.f16850a;
                    t9.i.f(path, "path");
                    t9.i.f(sb3, Constants.KEY_HOST);
                    String str3 = na.e.f17345e;
                    t9.i.f(str3, "mTemporaryAccount");
                    dVar2.b(context2, path, sb3, code2, str3);
                }
                throw e;
            }
            dVar.b(context, path, sb, code, str2);
            host = str;
        } catch (Exception e12) {
            e = e12;
            host = str;
            String message2 = e.getMessage();
            if (message2 != null) {
            }
            if (!z11) {
            }
            throw e;
        }
        StringBuilder sb4 = new StringBuilder();
        na.g gVar2 = na.g.f17347a;
        t9.i.f(host, Constants.KEY_HOST);
        sb4.append(gVar2.a(host));
        sb4.append(".bigbee");
        sb = sb4.toString();
        dVar = d.f16852a;
        context = this.f16850a;
        t9.i.f(path, "path");
        t9.i.f(sb, Constants.KEY_HOST);
        str2 = na.e.f17345e;
        t9.i.f(str2, "mTemporaryAccount");
        str = sb;
        z10 = false;
    }
}
