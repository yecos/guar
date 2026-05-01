package a7;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.widget.ImageView;
import ba.s;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import t9.i;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f288a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final int f289b = 10000;

    /* renamed from: c, reason: collision with root package name */
    public static int f290c = 2048;

    public final boolean a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return false;
    }

    public final void b(Context context, String str, ImageView imageView, int i10) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(imageView, "imageView");
        if (a(context)) {
            return;
        }
        RequestManager with = Glide.with(context);
        i.f(with, "with(context)");
        Long c10 = j1.c(context);
        i.f(c10, "totalMenu");
        if (c10.longValue() <= f290c) {
            with.setDefaultRequestOptions(new RequestOptions().format(DecodeFormat.PREFER_RGB_565));
        }
        Object obj = null;
        if (i10 == -1) {
            if (str != null && s.e(str, ".gif", false, 2, null)) {
                RequestBuilder<GifDrawable> asGif = with.asGif();
                if (TextUtils.isEmpty(str)) {
                    obj = a3.e.a(str, "key_poster");
                } else {
                    String a10 = a3.e.a(str, "key_poster");
                    if (a10 != null) {
                        obj = b0.W(a10);
                    }
                }
                asGif.load(obj).timeout(f289b).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                return;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            Object obj2 = str;
            if (!isEmpty) {
                String a11 = a3.e.a(str, "key_poster");
                obj2 = a11 != null ? b0.W(a11) : null;
            } else if (str == null) {
                obj2 = a3.e.a("", "key_poster");
            }
            with.load(obj2).timeout(f289b).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            return;
        }
        if (str != null && s.e(str, ".gif", false, 2, null)) {
            RequestBuilder<GifDrawable> asGif2 = with.asGif();
            if (TextUtils.isEmpty(str)) {
                obj = a3.e.a(str, "key_poster");
            } else {
                String a12 = a3.e.a(str, "key_poster");
                if (a12 != null) {
                    obj = b0.W(a12);
                }
            }
            asGif2.load(obj).timeout(f289b).error(i10).skipMemoryCache(false).placeholder(i10).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            return;
        }
        boolean isEmpty2 = TextUtils.isEmpty(str);
        Object obj3 = str;
        if (!isEmpty2) {
            String a13 = a3.e.a(str, "key_poster");
            obj3 = a13 != null ? b0.W(a13) : null;
        } else if (str == null) {
            obj3 = a3.e.a("", "key_poster");
        }
        with.load(obj3).timeout(f289b).error(i10).skipMemoryCache(false).placeholder(i10).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }
}
