package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f9045a;

    /* renamed from: b, reason: collision with root package name */
    public static String f9046b;

    /* renamed from: c, reason: collision with root package name */
    public static String f9047c;

    /* renamed from: d, reason: collision with root package name */
    public static String f9048d;

    /* renamed from: e, reason: collision with root package name */
    public static IProcessName f9049e;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicInteger f9050f = new AtomicInteger(-1);

    /* renamed from: g, reason: collision with root package name */
    private static volatile a f9051g;

    /* renamed from: h, reason: collision with root package name */
    private static Context f9052h;

    /* renamed from: i, reason: collision with root package name */
    private ActivityManager f9053i;

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f9052h == null) {
            f9052h = context.getApplicationContext();
        }
    }

    public static a a(Context context) {
        if (f9051g == null) {
            synchronized (a.class) {
                if (f9051g == null) {
                    f9051g = new a(context);
                }
            }
        }
        return f9051g;
    }

    public static String b() {
        String str = TextUtils.isEmpty(f9045a) ? "com.umeng.message.component.UmengIntentService" : f9045a;
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    public static boolean c() {
        return f9050f.intValue() == 0;
    }

    public ActivityManager a() {
        if (this.f9053i == null) {
            this.f9053i = (ActivityManager) f9052h.getSystemService("activity");
        }
        return this.f9053i;
    }
}
