package w4;

import android.os.Process;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import y4.b;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final b f19159a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f19160b;

    /* renamed from: c, reason: collision with root package name */
    public final t4.a f19161c;

    /* renamed from: d, reason: collision with root package name */
    public final y4.a f19162d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0330a f19163e;

    /* renamed from: f, reason: collision with root package name */
    public long f19164f;

    /* renamed from: g, reason: collision with root package name */
    public InputStream f19165g;

    /* renamed from: w4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0330a {
        void b();

        void c();
    }

    public a(b bVar, u4.a aVar, t4.a aVar2, y4.a aVar3, InterfaceC0330a interfaceC0330a) {
        this.f19159a = bVar;
        this.f19160b = aVar;
        this.f19161c = aVar2;
        this.f19162d = aVar3;
        this.f19164f = aVar3.q() ? bVar.e() : 0L;
        this.f19163e = interfaceC0330a;
    }

    public final void a() {
        if (this.f19162d.p()) {
            throw new z4.b(7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.b(java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.c(java.lang.String, java.lang.String):void");
    }

    public HttpURLConnection d(String str) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(this.f19161c.a());
                httpURLConnection.setReadTimeout(this.f19161c.h());
                httpURLConnection.setRequestMethod(this.f19161c.g());
                this.f19159a.f();
                if (this.f19162d.q()) {
                    httpURLConnection.setRequestProperty("Range", "bytes=" + (this.f19159a.f() + this.f19164f) + Operator.Operation.MINUS + this.f19159a.c());
                }
                httpURLConnection.disconnect();
                return httpURLConnection;
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return httpURLConnection2;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            a();
            if ((this.f19159a.f() + this.f19164f) - 1 == this.f19159a.c()) {
                this.f19163e.b();
            } else if (TextUtils.isEmpty(this.f19159a.a())) {
                b(this.f19159a.h());
            } else {
                c(this.f19159a.h(), this.f19159a.a());
            }
        } catch (z4.a e10) {
            if (e10.a() != 7) {
                this.f19160b.b(this.f19162d, e10);
                return;
            }
            this.f19162d.C(6);
            this.f19162d.x(e10);
            this.f19160b.a(this.f19162d);
        }
    }
}
