package com.umeng.message.proguard;

import android.os.SystemClock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static final ct f11817a = new ct();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, b> f11818b = new HashMap<>();

    public interface a {
        void a();

        void a(String str);
    }

    private ct() {
    }

    public static void a(final boolean z10, final String str, final a aVar) {
        ct ctVar = f11817a;
        if (str == null || str.length() == 0) {
            new IllegalArgumentException("url empty");
            aVar.a();
            return;
        }
        File a10 = ea.a(str);
        if (!a10.exists() || a10.length() <= 512) {
            cb.b(new Runnable() { // from class: com.umeng.message.proguard.ct.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (ct.class) {
                        b bVar = (b) ct.this.f11818b.get(str);
                        if (bVar != null) {
                            bVar.a(aVar);
                            return;
                        }
                        b bVar2 = new b(str, new a() { // from class: com.umeng.message.proguard.ct.1.1
                            @Override // com.umeng.message.proguard.ct.a
                            public final void a(String str2) {
                                synchronized (ct.class) {
                                    ct.this.f11818b.remove(str);
                                }
                            }

                            @Override // com.umeng.message.proguard.ct.a
                            public final void a() {
                                synchronized (ct.class) {
                                    ct.this.f11818b.remove(str);
                                }
                            }
                        });
                        bVar2.a(aVar);
                        ct.this.f11818b.put(str, bVar2);
                        if (z10) {
                            bVar2.run();
                        } else {
                            cb.a(bVar2);
                        }
                    }
                }
            });
        } else {
            aVar.a(a10.getPath());
            cu.a(a10);
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final String f11824a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<a> f11825b;

        public b(String str, a aVar) {
            ArrayList<a> arrayList = new ArrayList<>();
            this.f11825b = arrayList;
            this.f11824a = str;
            arrayList.add(aVar);
        }

        public final void a(a aVar) {
            synchronized (ct.class) {
                this.f11825b.add(0, aVar);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a(this.f11824a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            synchronized (ct.class) {
                this.f11825b.clear();
            }
        }

        private void a(String str) {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            int contentLength;
            FileOutputStream fileOutputStream;
            byte[] bArr;
            long j10;
            long j11;
            int i10;
            byte[] bArr2;
            File a10 = ea.a(str);
            if (a10.exists() && a10.length() > 512) {
                cu.a(a10);
                synchronized (ct.class) {
                    Iterator<a> it = this.f11825b.iterator();
                    while (it.hasNext()) {
                        it.next().a(a10.getPath());
                    }
                }
                return;
            }
            File file = new File(a10.getParent(), a10.getName() + ".tmp");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i11 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        inputStream = httpURLConnection2.getInputStream();
                        contentLength = httpURLConnection2.getContentLength();
                        fileOutputStream = new FileOutputStream(file);
                        bArr = new byte[8192];
                        ce.a("VideoDownload", "video contentLength:".concat(String.valueOf(contentLength)));
                        j10 = 0;
                        j11 = 0;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                    }
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, i11, read);
                        j10 += read;
                        if (contentLength > 0) {
                            httpURLConnection = httpURLConnection2;
                            try {
                                long j12 = (100 * j10) / contentLength;
                                if (j11 != j12) {
                                    if (j12 % 50 == 0) {
                                        i10 = contentLength;
                                        bArr2 = bArr;
                                        ce.a("VideoDownload", "video download progress:".concat(String.valueOf(j12)));
                                    } else {
                                        i10 = contentLength;
                                        bArr2 = bArr;
                                    }
                                    j11 = j12;
                                } else {
                                    i10 = contentLength;
                                    bArr2 = bArr;
                                }
                                httpURLConnection2 = httpURLConnection;
                                contentLength = i10;
                                bArr = bArr2;
                                i11 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        th = th2;
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    httpURLConnection = httpURLConnection2;
                    fileOutputStream.flush();
                    eb.a(fileOutputStream);
                    eb.a(inputStream);
                    a10.delete();
                    file.renameTo(a10);
                    cu.a(a10);
                    synchronized (ct.class) {
                        Iterator<a> it2 = this.f11825b.iterator();
                        while (it2.hasNext()) {
                            it2.next().a(a10.getPath());
                        }
                    }
                    httpURLConnection.disconnect();
                    ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                } catch (IOException e10) {
                    file.delete();
                    ce.d("VideoDownload", "video download error:", e10.getMessage());
                    ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    synchronized (ct.class) {
                        Iterator<a> it3 = this.f11825b.iterator();
                        while (it3.hasNext()) {
                            a next = it3.next();
                            new IOException("download video:" + str + " failed!");
                            next.a();
                        }
                    }
                }
            } catch (Throwable th3) {
                ce.b("VideoDownload", "video download consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                throw th3;
            }
        }
    }
}
