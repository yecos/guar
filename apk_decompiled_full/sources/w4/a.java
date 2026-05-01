package w4;

import android.os.Process;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
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
    */
    public final void b(String str) {
        InputStream inputStream;
        HttpURLConnection d10;
        try {
            try {
                d10 = d(str);
            } catch (Throwable th) {
                th = th;
                inputStream = this.f19165g;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        this.f19165g = null;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (ProtocolException e11) {
            e = e11;
        } catch (IOException e12) {
            e = e12;
        } catch (z4.b e13) {
            throw e13;
        } catch (z4.a e14) {
            throw e14;
        } catch (Exception e15) {
            e = e15;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            inputStream = this.f19165g;
            if (inputStream != null) {
            }
            if (str != 0) {
            }
        }
        try {
            long f10 = this.f19159a.f();
            if (this.f19162d.q()) {
                f10 = this.f19159a.f() + this.f19164f;
                d10.setRequestProperty("Range", "bytes=" + f10 + Operator.Operation.MINUS + this.f19159a.c());
            }
            int responseCode = d10.getResponseCode();
            if (responseCode != 206 && responseCode != 200) {
                throw new z4.a(8, responseCode, "UnSupported response code:" + responseCode);
            }
            this.f19165g = d10.getInputStream();
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f19162d.h(), "rwd");
            randomAccessFile.seek(f10);
            byte[] bArr = new byte[4096];
            int i10 = 0;
            while (true) {
                a();
                int read = this.f19165g.read(bArr);
                if (read == -1) {
                    break;
                }
                randomAccessFile.write(bArr, 0, read);
                i10 += read;
                this.f19159a.l(this.f19164f + i10);
                this.f19163e.c();
            }
            this.f19163e.b();
            a();
            InputStream inputStream2 = this.f19165g;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    this.f19165g = null;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            d10.disconnect();
        } catch (ProtocolException e17) {
            e = e17;
            throw new z4.a(4, "Protocol error", e);
        } catch (IOException e18) {
            e = e18;
            throw new z4.a(5, "IO error", e);
        } catch (z4.b e19) {
        } catch (z4.a e20) {
        } catch (Exception e21) {
            e = e21;
            throw new z4.a(9, "Unknown error", e);
        }
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
    */
    public final void c(String str, String str2) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        try {
            try {
                httpURLConnection = d(str);
                try {
                    long f10 = this.f19159a.f();
                    if (this.f19162d.q()) {
                        f10 = this.f19159a.f() + this.f19164f;
                        httpURLConnection.setRequestProperty("Range", "bytes=" + f10 + Operator.Operation.MINUS + this.f19159a.c());
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 206 && responseCode != 200) {
                        throw new z4.a(8, responseCode, "UnSupported response code:" + responseCode);
                    }
                    this.f19165g = httpURLConnection.getInputStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f19162d.h(), "rwd");
                    randomAccessFile.seek(f10);
                    byte[] bArr = new byte[4096];
                    int i10 = 0;
                    while (true) {
                        a();
                        int read = this.f19165g.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        i10 += read;
                        this.f19159a.l(this.f19164f + i10);
                        this.f19163e.c();
                    }
                    this.f19163e.b();
                    a();
                    InputStream inputStream2 = this.f19165g;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            this.f19165g = null;
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    b(str2);
                    InputStream inputStream3 = this.f19165g;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                            this.f19165g = null;
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                inputStream = this.f19165g;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        this.f19165g = null;
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            inputStream = this.f19165g;
            if (inputStream != null) {
            }
            if (str != 0) {
            }
        }
        httpURLConnection.disconnect();
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
