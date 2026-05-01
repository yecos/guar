package com.uyumao.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.uyumao.b;
import com.uyumao.c;
import com.uyumao.d;
import com.uyumao.e;
import com.uyumao.g;
import com.uyumao.h;
import com.uyumao.l;
import com.uyumao.q;
import com.uyumao.s;
import com.uyumao.t;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UYMManager {

    /* renamed from: a, reason: collision with root package name */
    public static UYMManager f12456a;

    public class a implements ActionInfo {
        public a(UYMManager uYMManager) {
        }

        @Override // com.umeng.ccg.ActionInfo
        public String getModule(Context context) {
            return "anti";
        }

        @Override // com.umeng.ccg.ActionInfo
        public String[] getSupportAction(Context context) {
            return new String[]{com.umeng.ccg.a.f10645e, com.umeng.ccg.a.f10644d, com.umeng.ccg.a.f10643c, com.umeng.ccg.a.f10642b};
        }

        @Override // com.umeng.ccg.ActionInfo
        public boolean getSwitchState(Context context, String str) {
            boolean z10 = com.umeng.ccg.a.f10645e.equals(str) ? d.f12392f : false;
            if (com.umeng.ccg.a.f10644d.equals(str)) {
                boolean z11 = d.f12387a;
                boolean z12 = d.f12388b;
                if (z11 || z12) {
                    z10 = true;
                }
            }
            if (com.umeng.ccg.a.f10643c.equals(str)) {
                z10 = d.f12391e;
            }
            if (com.umeng.ccg.a.f10642b.equals(str)) {
                boolean z13 = d.f12389c;
                boolean z14 = d.f12390d;
                if (z13 || z14) {
                    return true;
                }
            }
            return z10;
        }

        @Override // com.umeng.ccg.ActionInfo
        public void onCommand(Context context, String str, Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            boolean z10 = d.f12387a;
            d.f12393g = context.getApplicationContext();
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("actionName")) {
                    Integer num = d.f12399m.get(jSONObject.optString("actionName"));
                    if (num != null) {
                        g.a(context, num.intValue(), d.e.f12404a, jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void enableYm1(Context context, boolean z10) {
        d.f12387a = z10;
    }

    public static void enableYm2(Context context, boolean z10) {
        d.f12388b = z10;
    }

    public static void enableYm3(Context context, boolean z10) {
        d.f12389c = z10;
    }

    public static void enableYm4(Context context, boolean z10) {
        d.f12390d = z10;
    }

    public static void enableYm5(Context context, boolean z10) {
        d.f12391e = z10;
    }

    public static void enableYm6(Context context, boolean z10) {
        d.f12392f = z10;
        try {
            Method a10 = t.a("com.umeng.commonsdk.UMConfigure", "enableAplCollection", (Class<?>[]) new Class[]{Boolean.TYPE});
            if (a10 != null) {
                t.a(a10, (Object) null, new Object[]{Boolean.valueOf(z10)});
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized UYMManager getInstance() {
        UYMManager uYMManager;
        synchronized (UYMManager.class) {
            if (f12456a == null) {
                f12456a = new UYMManager();
            }
            uYMManager = f12456a;
        }
        return uYMManager;
    }

    public static String getSdkVersion() {
        return "1.1.4";
    }

    public static void processEvent(Context context, String str) {
        boolean z10 = d.f12387a;
        d.f12393g = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("actionName")) {
                Integer num = d.f12399m.get(jSONObject.optString("actionName"));
                if (num != null) {
                    g.a(context, num.intValue(), d.e.f12404a, jSONObject);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void init(Context context) {
        Future<?> future;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        boolean z10 = true;
        if (!c.f12385a) {
            c.f12385a = true;
            if (applicationContext.getSharedPreferences("uyumao_info", 0).getBoolean(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()), false)) {
                new Thread(new com.uyumao.a(applicationContext)).start();
            } else {
                l.a().b().execute(new b(applicationContext));
            }
            try {
                h hVar = c.f12386b;
                if (hVar != null) {
                    applicationContext.unregisterReceiver(hVar);
                }
                c.f12386b = new h();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                applicationContext.registerReceiver(c.f12386b, intentFilter);
            } catch (Throwable unused) {
            }
        }
        e.f12405a = context;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            if (UMConfigure.class.getDeclaredMethod("registerActionInfo", ActionInfo.class) == null) {
                z10 = false;
            }
            if (z10) {
                UMConfigure.registerActionInfo(new a(this));
            }
        } catch (Throwable unused2) {
        }
        if (d.f12392f) {
            try {
                WeakReference<Future<?>> weakReference = e.f12406b;
                if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                    e.f12406b = new WeakReference<>(s.a(new q()));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
