package com.umeng.message.proguard;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import anet.channel.util.HttpConstant;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.cq;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dy {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f12024a;

    /* renamed from: b, reason: collision with root package name */
    private static String f12025b;

    /* renamed from: c, reason: collision with root package name */
    private static String f12026c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f12027d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f12028e;

    public static void a(Context context, ck ckVar, cq.a aVar) {
        boolean z10;
        if (context == null || ckVar == null) {
            return;
        }
        try {
            int k10 = ckVar.k();
            if (k10 <= 0 || k10 > 6 || k10 == 5) {
                cr.a().a(ckVar, false, aVar);
                return;
            }
            try {
                z10 = a(context, ckVar);
                try {
                    try {
                        ckVar.f11740b.put("clk_tp", 1);
                    } catch (ActivityNotFoundException e10) {
                        e = e10;
                        ce.a("Utils", "start fail:", e.getMessage());
                        String optString = ckVar.f11740b.optString("lp");
                        ckVar.g();
                        z10 = a(ckVar, context, optString);
                        if (z10) {
                            ckVar.f11740b.put("clk_tp", 2);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        ce.a("Utils", "error:", th.getMessage());
                    } finally {
                        cr.a().a(ckVar, z10, aVar);
                    }
                }
            } catch (ActivityNotFoundException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }

    private static String b(Context context) {
        if (!TextUtils.isEmpty(f12026c)) {
            return f12026c;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            str = UMFrUtils.getCurrentProcessName(context);
        }
        f12026c = str;
        return str;
    }

    public static boolean b() {
        Boolean bool = f12028e;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = null;
        try {
            bool2 = (Boolean) ec.a(UMConfigure.class.getName(), "isSilentMode", null, null);
        } catch (Throwable unused) {
        }
        Boolean valueOf = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
        f12028e = valueOf;
        return valueOf.booleanValue();
    }

    private static void a(Intent intent, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (intent == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("sdk_extra")) == null || optJSONObject.length() == 0) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (next != null) {
                intent.putExtra(next, optString);
            }
        }
    }

    private static boolean a(Context context, ck ckVar) {
        Intent intent;
        boolean booleanValue;
        int k10 = ckVar.k();
        String optString = ckVar.f11740b.optString("dl");
        if (k10 == 3) {
            String j10 = ckVar.j();
            String optString2 = ckVar.f11740b.optString("param_k");
            String optString3 = ckVar.f11740b.optString("param_v");
            intent = context.getPackageManager().getLaunchIntentForPackage(j10);
            if (intent != null) {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    intent.putExtra(optString2, optString3);
                }
                a(intent, ckVar.f11740b);
            } else {
                throw new ActivityNotFoundException("app not found:".concat(String.valueOf(j10)));
            }
        } else if (k10 == 4) {
            String j11 = ckVar.j();
            String optString4 = ckVar.f11740b.optString("param_k");
            String optString5 = ckVar.f11740b.optString("param_v");
            Intent intent2 = new Intent();
            intent2.setPackage(j11);
            intent2.setClassName(j11, optString);
            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                intent2.putExtra(optString4, optString5);
            }
            a(intent2, ckVar.f11740b);
            intent = intent2;
        } else {
            if (k10 == 2) {
                ckVar.g();
                return a(ckVar, context, optString);
            }
            if (k10 == 6) {
                ce.c("Utils", "not support download apk");
                return false;
            }
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri parse = Uri.parse(optString);
            intent.setData(parse);
            Boolean bool = f12024a;
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                if (Build.VERSION.SDK_INT < 30) {
                    f12024a = Boolean.TRUE;
                } else if (context.getApplicationInfo().targetSdkVersion < 30) {
                    f12024a = Boolean.TRUE;
                } else {
                    Boolean valueOf = Boolean.valueOf(UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES"));
                    f12024a = valueOf;
                    booleanValue = valueOf.booleanValue();
                }
                booleanValue = true;
            }
            if (booleanValue && intent.resolveActivity(context.getPackageManager()) == null) {
                ce.a("Utils", "cant find dl:", parse.getScheme(), HttpConstant.SCHEME_SPLIT, parse.getHost());
                cr.a().a("deeplink_fail", ckVar);
                throw new ActivityNotFoundException("cant find dl!");
            }
        }
        intent.addFlags(805339136);
        try {
            context.startActivity(intent);
            cr.a().a("deeplink_suc", ckVar);
            return true;
        } catch (Throwable th) {
            cr.a().a("deeplink_fail", ckVar);
            throw new ActivityNotFoundException(th.getMessage());
        }
    }

    private static boolean a(ck ckVar, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ce.a("Utils", "start landingPage url:", str);
        cr.a().a(ckVar);
        return a(context, str);
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            ce.d("Utils", "start url:", str, " error:", th.getMessage());
            return false;
        }
    }

    public static void a(String str, String str2) {
        try {
            Method declaredMethod = UMConfigure.class.getDeclaredMethod("setModuleTag", UMConfigure.BS_TYPE.class, String.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, UMConfigure.BS_TYPE.PUSH, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (dy.class) {
            String str2 = f12025b;
            if (str2 != null) {
                return str2;
            }
            Context a10 = de.a();
            if (!a(a10)) {
                return "";
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                str = WebSettings.getDefaultUserAgent(a10);
            } catch (Throwable unused) {
                str = null;
            }
            ce.a("Load", "get ua consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            if (str == null) {
                str = "";
            }
            f12025b = str;
            return str;
        }
    }

    public static boolean a(Context context) {
        Boolean bool = f12027d;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(b(context), packageName));
        f12027d = valueOf;
        return valueOf.booleanValue();
    }

    public static String a(String str, ck ckVar) {
        if (ckVar == null || TextUtils.isEmpty(str)) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a10 = a(a(str, "__TS_MS__", Long.valueOf(currentTimeMillis)), "__TS__", Long.valueOf(currentTimeMillis / 1000));
        int i10 = ckVar.f11744f;
        if (i10 != -1) {
            a10 = a(a(a10, "__VIDEO_MS__", Integer.valueOf(i10)), "__VIDEO_S__", Integer.valueOf(ckVar.f11744f / 1000));
        }
        int i11 = ckVar.f11745g;
        if (i11 != -1) {
            a10 = a(a10, "__SLOT_W__", Integer.valueOf(i11));
        }
        int i12 = ckVar.f11746h;
        if (i12 != -1) {
            a10 = a(a10, "__SLOT_H__", Integer.valueOf(i12));
        }
        long j10 = ckVar.f11747i;
        if (j10 != -1) {
            a10 = a(a10, "__RESPONSE_TIME__", Long.valueOf(j10));
        }
        if (ckVar.f11747i != -1) {
            a10 = a(a10, "__READY_TIME__", Long.valueOf(ckVar.f11748j));
        }
        long j11 = ckVar.f11749k;
        if (j11 != -1) {
            a10 = a(a10, "__SHOW_TIME__", Long.valueOf(j11));
        }
        long j12 = ckVar.f11750l;
        if (j12 != -1) {
            a10 = a(a10, "__CLICK_TIME__", Long.valueOf(j12));
        }
        float f10 = ckVar.f11751m;
        if (f10 != -1.0f && ckVar.f11752n != -1.0f) {
            a10 = a(a(a10, "__DOWN_X__", Float.valueOf(f10)), "__DOWN_Y__", Float.valueOf(ckVar.f11752n));
        }
        float f11 = ckVar.f11753o;
        if (f11 != -1.0f && ckVar.f11754p != -1.0f) {
            a10 = a(a(a10, "__UP_X__", Float.valueOf(f11)), "__UP_Y__", Float.valueOf(ckVar.f11754p));
        }
        float f12 = ckVar.f11755q;
        if (f12 != -1.0f && ckVar.f11756r != -1.0f) {
            a10 = a(a(a10, "__PNT_DOWN_X__", Float.valueOf(f12)), "__PNT_DOWN_Y__", Float.valueOf(ckVar.f11756r));
        }
        float f13 = ckVar.f11757s;
        return (f13 == -1.0f || ckVar.f11758t == -1.0f) ? a10 : a(a(a10, "__PNT_UP_X__", Float.valueOf(f13)), "__PNT_UP_Y__", Float.valueOf(ckVar.f11758t));
    }

    private static String a(String str, String str2, Object obj) {
        return str == null ? "" : (obj != null && str.contains(str2)) ? str.replaceAll(str2, String.valueOf(obj)) : str;
    }
}
