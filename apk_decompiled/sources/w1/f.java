package w1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import com.bumptech.glide.disklrucache.DiskLruCache;
import h9.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.ResponseBody;
import retrofit2.Response;
import s1.m;
import s2.d;
import t9.i;

/* loaded from: classes.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public x1.d f19139a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19140b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19141c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19142d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19143e;

    /* renamed from: f, reason: collision with root package name */
    public String f19144f;

    /* renamed from: g, reason: collision with root package name */
    public DiskLruCache f19145g;

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f19146h;

    public f(x1.d dVar) {
        i.g(dVar, "mAdRequestModel");
        this.f19139a = dVar;
        this.f19140b = f.class.getSimpleName();
        this.f19141c = "ad_video";
        this.f19142d = ".tmp";
        this.f19143e = 104857600L;
        this.f19144f = "";
        this.f19146h = new AtomicInteger(0);
    }

    public static final void e(f fVar, Context context, String str, AdInfo adInfo, v1.b bVar) {
        i.g(fVar, "this$0");
        i.g(context, "$context");
        i.g(str, "$adType");
        i.g(adInfo, "$adInfo");
        fVar.m(context, str, adInfo, bVar);
        if (fVar.f19146h.decrementAndGet() == 0) {
            m.f18686a.M().a("video");
        }
    }

    public static final void k(v1.b bVar, String str, boolean z10) {
        i.g(str, "$adType");
        if (bVar != null) {
            bVar.a(str, z10);
        }
    }

    @Override // w1.a
    public void a(final Context context, final String str, final AdInfo adInfo, final v1.b bVar) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        y1.c cVar = y1.c.f19721a;
        String str2 = this.f19140b;
        StringBuilder sb = new StringBuilder();
        sb.append("send request: ");
        String url = adInfo.getUrl();
        i.d(url);
        sb.append(url);
        cVar.a(str2, sb.toString());
        String url2 = adInfo.getUrl();
        if (url2 == null || url2.length() == 0) {
            return;
        }
        this.f19146h.getAndIncrement();
        m.f18686a.Q().submit(new d.e("video cache", new Runnable() { // from class: w1.d
            @Override // java.lang.Runnable
            public final void run() {
                f.e(f.this, context, str, adInfo, bVar);
            }
        }, false));
    }

    @Override // w1.a
    public File b(Context context, String str, AdInfo adInfo) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        n(context);
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        return g(url);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: IOException -> 0x005c, TryCatch #0 {IOException -> 0x005c, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x001b, B:10:0x0022, B:12:0x0032, B:19:0x003f, B:21:0x004a, B:23:0x0050), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.f19144f     // Catch: java.io.IOException -> L5c
            com.bumptech.glide.disklrucache.DiskLruCache r1 = r4.h(r1)     // Catch: java.io.IOException -> L5c
            java.lang.String r2 = ""
            java.lang.String r5 = r1.f.c(r5, r2)     // Catch: java.io.IOException -> L5c
            com.bumptech.glide.disklrucache.DiskLruCache$Value r5 = r1.get(r5)     // Catch: java.io.IOException -> L5c
            if (r5 == 0) goto L18
            java.io.File r5 = r5.getFile(r0)     // Catch: java.io.IOException -> L5c
            goto L19
        L18:
            r5 = 0
        L19:
            if (r5 == 0) goto L5b
            boolean r1 = r5.exists()     // Catch: java.io.IOException -> L5c
            if (r1 != 0) goto L22
            goto L5b
        L22:
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.io.IOException -> L5c
            java.lang.String r1 = "file.absolutePath"
            t9.i.f(r5, r1)     // Catch: java.io.IOException -> L5c
            java.lang.String r5 = r4.i(r5)     // Catch: java.io.IOException -> L5c
            r1 = 1
            if (r5 == 0) goto L3b
            int r2 = r5.length()     // Catch: java.io.IOException -> L5c
            if (r2 != 0) goto L39
            goto L3b
        L39:
            r2 = 0
            goto L3c
        L3b:
            r2 = 1
        L3c:
            if (r2 == 0) goto L3f
            return r0
        L3f:
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L5c
            r2.<init>(r5)     // Catch: java.io.IOException -> L5c
            boolean r3 = r2.exists()     // Catch: java.io.IOException -> L5c
            if (r3 == 0) goto L50
            y1.b r5 = y1.b.f19720a     // Catch: java.io.IOException -> L5c
            r5.b(r2)     // Catch: java.io.IOException -> L5c
            return r0
        L50:
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L5c
            r2.<init>(r5)     // Catch: java.io.IOException -> L5c
            boolean r5 = r2.exists()     // Catch: java.io.IOException -> L5c
            r5 = r5 ^ r1
            return r5
        L5b:
            return r0
        L5c:
            r5 = move-exception
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.f.f(java.lang.String):boolean");
    }

    public final File g(String str) {
        if (!(str == null || str.length() == 0) && f(str)) {
            try {
                DiskLruCache.Value value = h(this.f19144f).get(r1.f.c(str, ""));
                if (value != null) {
                    return value.getFile(0);
                }
                return null;
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public final DiskLruCache h(String str) {
        if (this.f19145g == null) {
            synchronized (f.class) {
                if (this.f19145g == null) {
                    this.f19145g = DiskLruCache.open(new File(str, this.f19141c), 1, 1, this.f19143e);
                }
                t tVar = t.f14242a;
            }
        }
        DiskLruCache diskLruCache = this.f19145g;
        i.d(diskLruCache);
        return diskLruCache;
    }

    public final String i(String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, str.length() - 2);
        i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(this.f19142d);
        return sb.toString();
    }

    public final void j(final v1.b bVar, final String str, final boolean z10) {
        m.f18686a.P().post(new Runnable() { // from class: w1.e
            @Override // java.lang.Runnable
            public final void run() {
                f.k(v1.b.this, str, z10);
            }
        });
    }

    public final boolean l(String str, String str2, InputStream inputStream) {
        File file;
        if (inputStream == null) {
            return false;
        }
        DiskLruCache.Editor edit = h(str).edit(r1.f.c(str2, ""));
        if (edit == null || (file = edit.getFile(0)) == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        i.f(absolutePath, "cacheFile.absolutePath");
        String i10 = i(absolutePath);
        y1.b bVar = y1.b.f19720a;
        bVar.d(i10);
        if (bVar.a(inputStream, file)) {
            bVar.c(i10);
            edit.commit();
            return true;
        }
        bVar.c(i10);
        edit.abortUnlessCommitted();
        return false;
    }

    public final void m(Context context, String str, AdInfo adInfo, v1.b bVar) {
        n(context);
        String url = adInfo.getUrl();
        i.d(url);
        if (f(url)) {
            j(bVar, str, true);
            return;
        }
        try {
            x1.d dVar = this.f19139a;
            String url2 = adInfo.getUrl();
            i.d(url2);
            Response execute = dVar.m(url2).execute();
            if (!execute.isSuccessful()) {
                j(bVar, str, false);
                t2.a.f18798a.q(x1.d.f19391g.b(), "key_ads");
                return;
            }
            ResponseBody responseBody = (ResponseBody) execute.body();
            if (responseBody == null) {
                j(bVar, str, false);
                return;
            }
            String str2 = this.f19144f;
            String url3 = adInfo.getUrl();
            if (url3 == null) {
                url3 = "";
            }
            if (l(str2, url3, responseBody.byteStream())) {
                j(bVar, str, true);
            } else {
                j(bVar, str, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            j(bVar, str, false);
            t2.a.f18798a.q(x1.d.f19391g.b(), "key_ads");
        }
    }

    public final void n(Context context) {
        String str = this.f19144f;
        if (str == null || str.length() == 0) {
            String absolutePath = context.getCacheDir().getAbsolutePath();
            i.f(absolutePath, "context.cacheDir.absolutePath");
            this.f19144f = absolutePath;
        }
    }
}
