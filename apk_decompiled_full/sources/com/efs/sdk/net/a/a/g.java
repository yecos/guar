package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.net.a.a.f;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f6383a = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private static g f6384c;

    /* renamed from: b, reason: collision with root package name */
    private b f6385b = new b();

    private g() {
    }

    public static g c() {
        if (f6384c == null) {
            f6384c = new g();
        }
        return f6384c;
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.b bVar) {
        String str;
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar2 = this.f6385b;
        try {
            String a10 = bVar.a();
            bVar2.f6374a.put(bVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.c a11 = com.efs.sdk.net.a.a.a().a(a10);
            String b10 = bVar.b();
            if (!TextUtils.isEmpty(b10)) {
                a11.f6397d = b10;
            }
            a11.f6398e = bVar.c();
            HashMap hashMap = new HashMap();
            int e10 = bVar.e();
            for (int i10 = 0; i10 < e10; i10++) {
                hashMap.put(bVar.a(i10), bVar.b(i10));
            }
            a11.f6399f = b.a(bVar);
            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                String str2 = a11.f6398e;
                if ((str2 == null || !str2.equalsIgnoreCase("get")) && (str = a11.f6398e) != null && str.equalsIgnoreCase("post") && a11.f6399f < 10240) {
                    if (hashMap.containsKey("Content-Type") || hashMap.containsKey("content-type")) {
                        String str3 = (String) hashMap.get("Content-Type");
                        if (TextUtils.isEmpty(str3)) {
                            str3 = (String) hashMap.get("content-type");
                        }
                        if (str3 != null) {
                            if (str3.contains("application/json") || str3.contains("application/x-www-form-urlencoded")) {
                                a11.f6400g = new String(bVar.d());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f6383a.getAndIncrement());
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.d dVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.f6385b;
        Log.i("NetTrace-Interceptor", "save response");
        String a10 = dVar.a();
        if (bVar.f6374a != null) {
            com.efs.sdk.net.a.a.a().a(a10).f6401h = dVar.b();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
