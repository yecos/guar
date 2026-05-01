package r1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import ba.s;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.taobao.accs.common.Constants;
import h9.t;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import r1.a;
import s9.l;
import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18290a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18291b = a.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public static final String f18292c = "image_manager_ad";

    /* renamed from: d, reason: collision with root package name */
    public static final long f18293d = 62914560;

    /* renamed from: e, reason: collision with root package name */
    public static volatile DiskLruCache f18294e;

    /* renamed from: r1.a$a, reason: collision with other inner class name */
    public static final class C0312a implements RequestListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f18295a;

        public C0312a(l lVar) {
            this.f18295a = lVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(gifDrawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(target, "target");
            i.g(dataSource, "dataSource");
            l lVar = this.f18295a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            l lVar = this.f18295a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.FALSE);
            return false;
        }
    }

    public static final class b implements RequestListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f18296a;

        public b(l lVar) {
            this.f18296a = lVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(drawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(target, "target");
            i.g(dataSource, "dataSource");
            l lVar = this.f18296a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            l lVar = this.f18296a;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.FALSE);
            return false;
        }
    }

    public static final class c implements RequestListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18297a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f18298b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f18299c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f18300d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l f18301e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f18302f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f18303g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f18304h;

        public c(String str, ImageView imageView, Context context, Integer num, l lVar, Integer num2, boolean z10, int i10) {
            this.f18297a = str;
            this.f18298b = imageView;
            this.f18299c = context;
            this.f18300d = num;
            this.f18301e = lVar;
            this.f18302f = num2;
            this.f18303g = z10;
            this.f18304h = i10;
        }

        public static final void b(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
            i.g(context, "$context");
            i.g(imageView, "$iv");
            i.g(str, "$url");
            a.f18290a.g(context, imageView, str, num, lVar, num2, z10);
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(gifDrawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(dataSource, "dataSource");
            int i10 = this.f18304h;
            if (i10 > 0) {
                gifDrawable.setLoopCount(i10);
            }
            l lVar = this.f18301e;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            final ImageView imageView = this.f18298b;
            final Context context = this.f18299c;
            final String str = this.f18297a;
            final Integer num = this.f18300d;
            final l lVar = this.f18301e;
            final Integer num2 = this.f18302f;
            final boolean z11 = this.f18303g;
            imageView.post(new Runnable() { // from class: r1.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.b(context, imageView, str, num, lVar, num2, z11);
                }
            });
            return false;
        }
    }

    public static final class d implements RequestListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18305a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f18306b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f18307c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f18308d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l f18309e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f18310f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f18311g;

        public d(String str, ImageView imageView, Context context, Integer num, l lVar, Integer num2, boolean z10) {
            this.f18305a = str;
            this.f18306b = imageView;
            this.f18307c = context;
            this.f18308d = num;
            this.f18309e = lVar;
            this.f18310f = num2;
            this.f18311g = z10;
        }

        public static final void b(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
            i.g(context, "$context");
            i.g(imageView, "$iv");
            i.g(str, "$url");
            a.f18290a.g(context, imageView, str, num, lVar, num2, z10);
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z10) {
            i.g(drawable, "resource");
            i.g(obj, Constants.KEY_MODEL);
            i.g(dataSource, "dataSource");
            l lVar = this.f18309e;
            if (lVar == null) {
                return false;
            }
            lVar.invoke(Boolean.TRUE);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            i.g(target, "target");
            final ImageView imageView = this.f18306b;
            final Context context = this.f18307c;
            final String str = this.f18305a;
            final Integer num = this.f18308d;
            final l lVar = this.f18309e;
            final Integer num2 = this.f18310f;
            final boolean z11 = this.f18311g;
            imageView.post(new Runnable() { // from class: r1.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.b(context, imageView, str, num, lVar, num2, z11);
                }
            });
            return false;
        }
    }

    public final boolean b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return false;
    }

    public final File c(Context context, String str) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "url");
        try {
            DiskLruCache.Value value = d(context).get(new SafeKeyGenerator().getSafeKey(new g(str, EmptySignature.obtain())));
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final DiskLruCache d(Context context) {
        if (f18294e == null) {
            synchronized (a.class) {
                if (f18294e == null) {
                    f18294e = DiskLruCache.open(new File(context.getCacheDir(), f18292c), 1, 1, f18293d);
                }
                t tVar = t.f14242a;
            }
        }
        DiskLruCache diskLruCache = f18294e;
        i.d(diskLruCache);
        return diskLruCache;
    }

    public final void e(Context context, String str, File file) {
        Throwable th;
        Exception e10;
        File c10;
        File c11;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        if (file == null || file.isDirectory()) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                DiskLruCache.Editor edit = d(context).edit(new SafeKeyGenerator().getSafeKey(new g(str, EmptySignature.obtain())));
                if (edit != null) {
                    try {
                        try {
                            File file2 = edit.getFile(0);
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = bufferedInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                    }
                                    bufferedOutputStream.flush();
                                    edit.commit();
                                    edit.abortUnlessCommitted();
                                    bufferedInputStream = bufferedInputStream2;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    edit.abortUnlessCommitted();
                                    throw th2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                th2 = th;
                                edit.abortUnlessCommitted();
                                throw th2;
                            }
                        } catch (Exception e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            r1.d dVar = r1.d.f18326a;
                            dVar.a(null);
                            dVar.a(null);
                            String b10 = f.b(file);
                            c11 = c(context, str);
                            if (c11 == null || TextUtils.equals(b10, f.b(c11))) {
                                return;
                            }
                            c11.delete();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    bufferedOutputStream = null;
                }
                r1.d dVar2 = r1.d.f18326a;
                dVar2.a(bufferedInputStream);
                dVar2.a(bufferedOutputStream);
                String b11 = f.b(file);
                c11 = c(context, str);
                if (c11 == null || TextUtils.equals(b11, f.b(c11))) {
                    return;
                }
            } catch (Throwable th6) {
                th = th6;
                r1.d dVar3 = r1.d.f18326a;
                dVar3.a(null);
                dVar3.a(null);
                String b12 = f.b(file);
                c10 = c(context, str);
                if (c10 != null && !TextUtils.equals(b12, f.b(c10))) {
                    c10.delete();
                }
                throw th;
            }
        } catch (Exception e12) {
            e10 = e12;
        } catch (Throwable th7) {
            th = th7;
            r1.d dVar32 = r1.d.f18326a;
            dVar32.a(null);
            dVar32.a(null);
            String b122 = f.b(file);
            c10 = c(context, str);
            if (c10 != null) {
                c10.delete();
            }
            throw th;
        }
        c11.delete();
    }

    public final boolean f(Context context, String str) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "url");
        File c10 = c(context, str);
        if (c10 != null && !c10.isDirectory()) {
            return true;
        }
        try {
            e(context, str, Glide.with(context).downloadOnly().load((Object) e.a(str)).submit().get());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void g(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
        if (b(context)) {
            return;
        }
        if (s.e(str, ".gif", false, 2, null)) {
            RequestBuilder<GifDrawable> load = Glide.with(context).asGif().load((Object) e.a(str));
            i.f(load, "with(context).asGif().load(url.toGlideUrl())");
            if (num2 != null) {
                Cloneable override = load.override(num2.intValue(), num2.intValue());
                i.f(override, "requestBuilder.override(size,size)");
                load = (RequestBuilder) override;
            }
            if (z10) {
                Cloneable dontAnimate = load.dontAnimate();
                i.f(dontAnimate, "requestBuilder.dontAnimate()");
                load = (RequestBuilder) dontAnimate;
            }
            if (num != null) {
                Cloneable error = load.placeholder(num.intValue()).error(num.intValue());
                i.f(error, "requestBuilder.placehold…urceId).error(resourceId)");
                load = (RequestBuilder) error;
            }
            load.addListener(new C0312a(lVar)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(imageView);
            return;
        }
        RequestBuilder<Drawable> load2 = Glide.with(context).load((Object) e.a(str));
        i.f(load2, "with(context).load(url.toGlideUrl())");
        if (num2 != null) {
            Cloneable override2 = load2.override(num2.intValue(), num2.intValue());
            i.f(override2, "requestBuilder.override(size,size)");
            load2 = (RequestBuilder) override2;
        }
        if (z10) {
            Cloneable dontAnimate2 = load2.dontAnimate();
            i.f(dontAnimate2, "requestBuilder.dontAnimate()");
            load2 = (RequestBuilder) dontAnimate2;
        }
        if (num != null) {
            Cloneable error2 = load2.placeholder(num.intValue()).error(num.intValue());
            i.f(error2, "requestBuilder.placehold…urceId).error(resourceId)");
            load2 = (RequestBuilder) error2;
        }
        load2.addListener(new b(lVar)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(imageView);
    }

    public final void h(Context context, ImageView imageView, String str, File file, Integer num, l lVar, Integer num2, boolean z10, int i10) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(imageView, "iv");
        i.g(str, "url");
        if (b(context)) {
            return;
        }
        if (file != null) {
            try {
                if (file.exists() && !file.isDirectory()) {
                    if (!s.e(str, ".gif", false, 2, null)) {
                        RequestBuilder<Drawable> load = Glide.with(context).load(file);
                        i.f(load, "with(context).load(cache)");
                        if (num2 != null) {
                            Cloneable override = load.override(num2.intValue(), num2.intValue());
                            i.f(override, "requestBuilder.override(size,size)");
                            load = (RequestBuilder) override;
                        }
                        if (z10) {
                            Cloneable dontAnimate = load.dontAnimate();
                            i.f(dontAnimate, "requestBuilder.dontAnimate()");
                            load = (RequestBuilder) dontAnimate;
                        }
                        if (num != null) {
                            Cloneable error = load.placeholder(num.intValue()).error(num.intValue());
                            i.f(error, "requestBuilder.placehold…).error(placeholderResId)");
                            load = (RequestBuilder) error;
                        }
                        load.addListener(new d(str, imageView, context, num, lVar, num2, z10)).into(imageView);
                        return;
                    }
                    RequestBuilder timeout = Glide.with(context).asGif().load(file).timeout(0);
                    i.f(timeout, "with(context).asGif().load(cache).timeout(0)");
                    RequestBuilder requestBuilder = timeout;
                    if (num2 != null) {
                        Cloneable override2 = requestBuilder.override(num2.intValue(), num2.intValue());
                        i.f(override2, "requestBuilder.override(size,size)");
                        requestBuilder = (RequestBuilder) override2;
                    }
                    if (z10) {
                        Cloneable dontAnimate2 = requestBuilder.dontAnimate();
                        i.f(dontAnimate2, "requestBuilder.dontAnimate()");
                        requestBuilder = (RequestBuilder) dontAnimate2;
                    }
                    if (num != null) {
                        Cloneable error2 = requestBuilder.placeholder(num.intValue()).error(num.intValue());
                        i.f(error2, "requestBuilder.placehold…).error(placeholderResId)");
                        requestBuilder = (RequestBuilder) error2;
                    }
                    requestBuilder.addListener(new c(str, imageView, context, num, lVar, num2, z10, i10)).into(imageView);
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        g(context, imageView, str, num, lVar, num2, z10);
    }
}
