package v4;

import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f19103a = "GetFileInfoTask";

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f19104b;

    /* renamed from: c, reason: collision with root package name */
    public final y4.a f19105c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0328a f19106d;

    /* renamed from: v4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0328a {
        void a(long j10, boolean z10);
    }

    public a(u4.a aVar, y4.a aVar2, InterfaceC0328a interfaceC0328a) {
        this.f19104b = aVar;
        this.f19105c = aVar2;
        this.f19106d = interfaceC0328a;
    }

    public final void a() {
        if (this.f19105c.p()) {
            throw new z4.a(7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(String str) {
        Throwable th;
        IOException e10;
        ProtocolException e11;
        MalformedURLException e12;
        this.f19105c.w(str);
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        d(httpURLConnection, false);
                    } else {
                        if (responseCode != 206) {
                            throw new z4.a(3, responseCode, "UnSupported response code:" + responseCode);
                        }
                        d(httpURLConnection, true);
                    }
                    httpURLConnection.disconnect();
                } catch (MalformedURLException e13) {
                    e12 = e13;
                    throw new z4.a(2, "Bad url.", e12);
                } catch (ProtocolException e14) {
                    e11 = e14;
                    throw new z4.a(4, "Protocol error", e11);
                } catch (IOException e15) {
                    e10 = e15;
                    throw new z4.a(5, "IO error", e10);
                }
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    str.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e16) {
            e12 = e16;
        } catch (ProtocolException e17) {
            e11 = e17;
        } catch (IOException e18) {
            e10 = e18;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(String str, String str2) {
        Exception e10;
        HttpURLConnection httpURLConnection;
        this.f19105c.w(str);
        ?? r02 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        d(httpURLConnection, false);
                    } else {
                        if (responseCode != 206) {
                            throw new z4.a(3, responseCode, "UnSupported response code:" + responseCode);
                        }
                        d(httpURLConnection, true);
                    }
                } catch (Exception e11) {
                    e10 = e11;
                    e10.printStackTrace();
                    b(str2);
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                r02 = str;
                if (r02 != 0) {
                    r02.disconnect();
                }
                throw th;
            }
        } catch (Exception e12) {
            e10 = e12;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r02 != 0) {
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    public final void d(HttpURLConnection httpURLConnection, boolean z10) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        long contentLength = (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField);
        if (contentLength <= 0) {
            throw new z4.a(6, "length <= 0");
        }
        a();
        this.f19106d.a(contentLength, z10);
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            if (TextUtils.isEmpty(this.f19105c.a())) {
                b(this.f19105c.m());
            } else {
                c(this.f19105c.m(), this.f19105c.a());
            }
        } catch (z4.a e10) {
            this.f19104b.b(this.f19105c, e10);
        } catch (Exception e11) {
            this.f19104b.b(this.f19105c, new z4.a(9, e11));
        }
    }
}
