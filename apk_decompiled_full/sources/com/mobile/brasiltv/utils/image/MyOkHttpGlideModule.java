package com.mobile.brasiltv.utils.image;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.umeng.analytics.pro.f;
import java.io.InputStream;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import ma.r;
import na.a;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import t9.i;

/* loaded from: classes3.dex */
public final class MyOkHttpGlideModule extends OkHttpGlideModule {

    /* renamed from: a, reason: collision with root package name */
    public final int f8722a = 15;

    @Override // com.bumptech.glide.integration.okhttp3.OkHttpGlideModule, com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        i.g(context, f.X);
        i.g(glide, "glide");
        i.g(registry, "registry");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        long j10 = this.f8722a;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j10, timeUnit).readTimeout(this.f8722a, timeUnit).writeTimeout(this.f8722a, timeUnit).dispatcher(new Dispatcher(a.f())).addInterceptor(new a7.a()).dns(new a7.f());
        Log.e("AddGlideErrorInter", "初始化：AddGlideErrorInterceptor");
        X509TrustManager a10 = ma.f.a();
        if (a10 != null) {
            builder.sslSocketFactory(new r(a10), a10);
        }
        OkHttpClient build = builder.build();
        i.f(build, "builder.build()");
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(build));
    }
}
