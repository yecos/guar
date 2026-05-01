package com.hpplay.a.a.a.c;

import com.hpplay.cybergarage.http.HTTP;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class c implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private b f7271a;

    /* renamed from: b, reason: collision with root package name */
    private String f7272b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f7273c;

    /* renamed from: d, reason: collision with root package name */
    private long f7274d;

    /* renamed from: g, reason: collision with root package name */
    private com.hpplay.a.a.a.b.a f7277g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7278h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7279i;

    /* renamed from: j, reason: collision with root package name */
    private List<String> f7280j;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, String> f7275e = new HashMap<String, String>() { // from class: com.hpplay.a.a.a.c.c.1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String put(String str, String str2) {
            c.this.f7276f.put(str == null ? str : str.toLowerCase(), str2);
            return (String) super.put(str, str2);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f7276f = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private a f7281k = a.DEFAULT;

    public enum a {
        DEFAULT,
        ALWAYS,
        NEVER
    }

    public c(b bVar, String str, InputStream inputStream, long j10) {
        this.f7271a = bVar;
        this.f7272b = str;
        if (inputStream == null) {
            this.f7273c = new ByteArrayInputStream(new byte[0]);
            this.f7274d = 0L;
        } else {
            this.f7273c = inputStream;
            this.f7274d = j10;
        }
        this.f7278h = this.f7274d < 0;
        this.f7279i = true;
        this.f7280j = new ArrayList(10);
    }

    public boolean b() {
        return HTTP.CLOSE.equals(b("connection"));
    }

    public InputStream c() {
        return this.f7273c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.f7273c;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public String d() {
        return this.f7272b;
    }

    public com.hpplay.a.a.a.b.a e() {
        return this.f7277g;
    }

    public b f() {
        return this.f7271a;
    }

    public boolean g() {
        a aVar = this.f7281k;
        return aVar == a.DEFAULT ? d() != null && (d().toLowerCase().contains("text/") || d().toLowerCase().contains("/json")) : aVar == a.ALWAYS;
    }

    private void c(OutputStream outputStream, long j10) {
        byte[] bArr = new byte[(int) 16384];
        boolean z10 = j10 == -1;
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            int read = this.f7273c.read(bArr, 0, (int) (z10 ? 16384L : Math.min(j10, 16384L)));
            if (read <= 0) {
                return;
            }
            try {
                outputStream.write(bArr, 0, read);
            } catch (Exception unused) {
                if (this.f7273c != null) {
                    this.f7273c.close();
                }
            }
            if (!z10) {
                j10 -= read;
            }
        }
    }

    public static c d(String str) {
        return a(d.OK, com.hpplay.a.a.a.d.MIME_HTML, str);
    }

    public void a(String str) {
        this.f7280j.add(str);
    }

    public String b(String str) {
        return this.f7276f.get(str.toLowerCase());
    }

    public List<String> a() {
        return this.f7280j;
    }

    public void b(boolean z10) {
        this.f7279i = z10;
    }

    public c d(boolean z10) {
        this.f7281k = z10 ? a.ALWAYS : a.NEVER;
        return this;
    }

    private void b(OutputStream outputStream, long j10) {
        GZIPOutputStream gZIPOutputStream;
        if (g()) {
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
            } catch (Exception unused) {
                InputStream inputStream = this.f7273c;
                if (inputStream != null) {
                    inputStream.close();
                }
                gZIPOutputStream = null;
            }
            if (gZIPOutputStream != null) {
                c(gZIPOutputStream, -1L);
                gZIPOutputStream.finish();
                return;
            }
            return;
        }
        c(outputStream, j10);
    }

    public void a(String str, String str2) {
        this.f7275e.put(str, str2);
    }

    public void a(boolean z10) {
        if (z10) {
            this.f7275e.put("connection", HTTP.CLOSE);
        } else {
            this.f7275e.remove("connection");
        }
    }

    public void a(OutputStream outputStream) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            if (this.f7271a != null) {
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new com.hpplay.a.a.a.a.a(this.f7272b).c())), false);
                printWriter.append("HTTP/1.1 ").append((CharSequence) this.f7271a.a()).append(" \r\n");
                String str = this.f7272b;
                if (str != null) {
                    a(printWriter, "Content-Type", str);
                }
                if (b("date") == null) {
                    a(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry<String, String> entry : this.f7275e.entrySet()) {
                    a(printWriter, entry.getKey(), entry.getValue());
                }
                Iterator<String> it = this.f7280j.iterator();
                while (it.hasNext()) {
                    a(printWriter, "Set-Cookie", it.next());
                }
                if (b("connection") == null) {
                    a(printWriter, "Connection", this.f7279i ? "keep-alive" : HTTP.CLOSE);
                }
                if (b("content-length") != null) {
                    d(false);
                }
                if (g()) {
                    a(printWriter, "Content-Encoding", "gzip");
                    c(true);
                }
                long j10 = this.f7273c != null ? this.f7274d : 0L;
                if (this.f7277g != com.hpplay.a.a.a.b.a.HEAD && this.f7278h) {
                    a(printWriter, "Transfer-Encoding", "chunked");
                } else if (!g()) {
                    j10 = a(printWriter, j10);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                a(outputStream, j10);
                outputStream.flush();
                com.hpplay.a.a.a.d.safeClose(this.f7273c);
                return;
            }
            throw new Error("sendResponse(): Status can't be null.");
        } catch (IOException e10) {
            com.hpplay.a.a.a.d.LOG.log(Level.SEVERE, "Could not send response to the client", (Throwable) e10);
        }
    }

    public void c(boolean z10) {
        this.f7278h = z10;
    }

    public void c(String str) {
        this.f7272b = str;
    }

    public void a(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
    }

    public long a(PrintWriter printWriter, long j10) {
        String b10 = b("content-length");
        if (b10 != null) {
            try {
                return Long.parseLong(b10);
            } catch (NumberFormatException unused) {
                com.hpplay.a.a.a.d.LOG.severe("content-length was no number " + b10);
                return j10;
            }
        }
        printWriter.print("Content-Length: " + j10 + "\r\n");
        return j10;
    }

    private void a(OutputStream outputStream, long j10) {
        if (this.f7277g != com.hpplay.a.a.a.b.a.HEAD && this.f7278h) {
            com.hpplay.a.a.a.c.a aVar = new com.hpplay.a.a.a.c.a(outputStream);
            b(aVar, -1L);
            try {
                aVar.a();
                return;
            } catch (Exception unused) {
                if (this.f7273c != null) {
                    this.f7273c.close();
                    return;
                }
                return;
            }
        }
        b(outputStream, j10);
    }

    public void a(InputStream inputStream) {
        this.f7273c = inputStream;
    }

    public void a(com.hpplay.a.a.a.b.a aVar) {
        this.f7277g = aVar;
    }

    public void a(b bVar) {
        this.f7271a = bVar;
    }

    public static c a(b bVar, String str, InputStream inputStream) {
        return new c(bVar, str, inputStream, -1L);
    }

    public static c a(b bVar, String str, byte[] bArr) {
        return a(bVar, str, new ByteArrayInputStream(bArr), bArr.length);
    }

    public static c a(b bVar, String str, InputStream inputStream, long j10) {
        return new c(bVar, str, inputStream, j10);
    }

    public static c a(b bVar, String str, String str2) {
        byte[] bArr;
        com.hpplay.a.a.a.a.a aVar = new com.hpplay.a.a.a.a.a(str);
        if (str2 == null) {
            return a(bVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(aVar.c()).newEncoder().canEncode(str2)) {
                aVar = aVar.f();
            }
            bArr = str2.getBytes(aVar.c());
        } catch (UnsupportedEncodingException e10) {
            com.hpplay.a.a.a.d.LOG.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e10);
            bArr = new byte[0];
        }
        return a(bVar, aVar.a(), new ByteArrayInputStream(bArr), bArr.length);
    }
}
