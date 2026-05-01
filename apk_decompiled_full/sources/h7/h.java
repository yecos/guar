package h7;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import retrofit2.HttpException;

/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static b f14216a;

    public static int a(Throwable th) {
        if (th instanceof HttpException) {
            return ((HttpException) th).code();
        }
        if (th instanceof TimeoutException) {
            return 50010;
        }
        if (th instanceof ConnectException) {
            return 50011;
        }
        if (th instanceof SocketTimeoutException) {
            return 50012;
        }
        if (th instanceof SSLException) {
            return 50013;
        }
        return th instanceof UnknownHostException ? 50014 : 50015;
    }

    public static void b(String str, Throwable th) {
        if (f14216a == null) {
            return;
        }
        int i10 = 50015;
        if (th instanceof z4.a) {
            z4.a aVar = (z4.a) th;
            if (aVar.a() == 3 || aVar.a() == 8) {
                i10 = aVar.b();
            } else {
                Throwable cause = aVar.getCause();
                if (cause != null) {
                    i10 = a(cause);
                }
            }
        }
        f14216a.b(str, String.valueOf(i10));
    }

    public static void c(String str, long j10, int i10, String str2, long j11, String str3) {
        b bVar = f14216a;
        if (bVar == null) {
            return;
        }
        bVar.a(str, j10, i10, str2, j11, str3);
    }

    public static void d(String str, long j10, String str2) {
        b bVar = f14216a;
        if (bVar == null) {
            return;
        }
        bVar.d(str, j10, str2);
    }

    public static void e(String str, Throwable th) {
        b bVar = f14216a;
        if (bVar == null) {
            return;
        }
        bVar.c(str, String.valueOf(a(th)));
    }

    public static void f(b bVar) {
        f14216a = bVar;
    }
}
