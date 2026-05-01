package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.uyumao.sdk.UYMManager;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ZIDManager {

    /* renamed from: d, reason: collision with root package name */
    public static ZIDManager f12334d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12335a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12336b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12337c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12338a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f12339b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f12338a = context;
            this.f12339b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = ZIDManager.a(ZIDManager.this, this.f12338a);
            if (TextUtils.isEmpty(a10)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f12339b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(LelinkSourceSDK.FEEDBACK_PUSH_BLACK, "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f12339b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a10);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12341a;

        public b(Context context) {
            this.f12341a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.f12341a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12343a;

        public c(Context context) {
            this.f12343a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f12343a);
        }
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = d.b(str);
        if (context == null || b10 == null || TextUtils.isEmpty(b10) || (a10 = com.umeng.umzid.a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", b10).commit();
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f12334d == null) {
                f12334d = new ZIDManager();
            }
            zIDManager = f12334d;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.6";
    }

    public final void a(Context context) {
        Object invoke;
        Method declaredMethod;
        try {
            Method declaredMethod2 = UYMManager.class.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(UYMManager.class, new Object[0])) == null || (declaredMethod = UYMManager.class.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:14|(3:80|81|(27:83|17|(1:79)(2:21|(1:23))|24|(1:78)(2:28|(1:30))|31|32|(1:36)|37|(1:39)|40|41|42|43|44|45|46|47|48|(1:50)|51|(1:53)|54|(2:56|(6:58|(1:60)|61|(1:63)|64|(1:66)))|67|68|69))|16|17|(1:19)|79|24|(1:26)|78|31|32|(2:34|36)|37|(0)|40|41|42|43|44|45|46|47|48|(0)|51|(0)|54|(0)|67|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ef, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f4, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f1, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r11 = r6;
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(Context context) {
        boolean z10;
        String str;
        String str2;
        SharedPreferences a10;
        Object string;
        String str3;
        String str4;
        JSONObject jSONObject;
        String b10;
        String a11;
        SharedPreferences a12;
        SharedPreferences a13;
        SharedPreferences a14;
        try {
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        if (new JSONObject(d.c(context)).optLong("ets") > System.currentTimeMillis()) {
            z10 = false;
            str = null;
            if (z10 || this.f12336b) {
                return null;
            }
            this.f12336b = true;
            JSONObject jSONObject2 = new JSONObject();
            str2 = "";
            if (context != null) {
                try {
                    a10 = com.umeng.umzid.a.a(context);
                } catch (Throwable unused) {
                }
                if (a10 != null) {
                    string = a10.getString("zdata", null);
                    String id = Spy.getID();
                    jSONObject2.put(bt.aJ, id);
                    jSONObject2.put("o_z", string);
                    if (context != null || (a14 = com.umeng.umzid.a.a(context)) == null) {
                        str3 = "";
                    } else {
                        str3 = a14.getString("oaid", "");
                        if (d.c(str3)) {
                            str3 = d.a(str3);
                        }
                    }
                    String f10 = d.f(context);
                    jSONObject2.put("o_o", str3);
                    jSONObject2.put("o", f10);
                    if (context != null || (a13 = com.umeng.umzid.a.a(context)) == null) {
                        str4 = "";
                    } else {
                        str4 = a13.getString(ParamsMap.DeviceParams.KEY_MAC, "");
                        if (d.c(str4)) {
                            str4 = d.a(str4);
                        }
                    }
                    String e11 = d.e(context);
                    jSONObject2.put(bt.A, e11);
                    jSONObject2.put("o_mc", str4);
                    a(context, jSONObject2);
                    jSONObject2.put("aaid", d.d(context));
                    jSONObject2.put("uabc", d.c(context));
                    if (context != null && (a12 = com.umeng.umzid.a.a(context)) != null) {
                        str2 = a12.getString("resetToken", "");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put("rt", str2);
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("vpn_pxy", d.i(context));
                    jSONObject.put("wifi_pxy", d.j(context));
                    jSONObject.put("double", d.g(context));
                    if (jSONObject != null) {
                        jSONObject2.put("anti", jSONObject);
                    }
                    b10 = d.b(context);
                    if (b10.length() <= 0) {
                        b10 = "https://utoken.umeng.com";
                    }
                    a11 = com.umeng.umzid.a.a(b10 + "/anti/updateZdata", jSONObject2.toString());
                    if (!TextUtils.isEmpty(a11)) {
                        JSONObject jSONObject3 = new JSONObject(a11);
                        if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                            d.f(context, id);
                            d.a(context, e11);
                            d.b(context, f10);
                            str = jSONObject3.optString("aaid");
                            if (!TextUtils.isEmpty(str)) {
                                d.e(context, str);
                            }
                            String optString = jSONObject3.optString("uabc");
                            if (!TextUtils.isEmpty(optString)) {
                                d.d(context, optString);
                            }
                            String optString2 = jSONObject3.optString("resetToken");
                            if (!TextUtils.isEmpty(optString2)) {
                                d.c(context, optString2);
                            }
                        }
                    }
                    a(context);
                    this.f12336b = false;
                    return str;
                }
            }
            string = "";
            String id2 = Spy.getID();
            jSONObject2.put(bt.aJ, id2);
            jSONObject2.put("o_z", string);
            if (context != null) {
            }
            str3 = "";
            String f102 = d.f(context);
            jSONObject2.put("o_o", str3);
            jSONObject2.put("o", f102);
            if (context != null) {
            }
            str4 = "";
            String e112 = d.e(context);
            jSONObject2.put(bt.A, e112);
            jSONObject2.put("o_mc", str4);
            a(context, jSONObject2);
            jSONObject2.put("aaid", d.d(context));
            jSONObject2.put("uabc", d.c(context));
            if (context != null) {
                str2 = a12.getString("resetToken", "");
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            jSONObject = new JSONObject();
            jSONObject.put("vpn_pxy", d.i(context));
            jSONObject.put("wifi_pxy", d.j(context));
            jSONObject.put("double", d.g(context));
            if (jSONObject != null) {
            }
            b10 = d.b(context);
            if (b10.length() <= 0) {
            }
            a11 = com.umeng.umzid.a.a(b10 + "/anti/updateZdata", jSONObject2.toString());
            if (!TextUtils.isEmpty(a11)) {
            }
            a(context);
            this.f12336b = false;
            return str;
        }
        z10 = true;
        str = null;
        if (z10) {
            return null;
        }
        this.f12336b = true;
        JSONObject jSONObject22 = new JSONObject();
        str2 = "";
        if (context != null) {
        }
        string = "";
        String id22 = Spy.getID();
        jSONObject22.put(bt.aJ, id22);
        jSONObject22.put("o_z", string);
        if (context != null) {
        }
        str3 = "";
        String f1022 = d.f(context);
        jSONObject22.put("o_o", str3);
        jSONObject22.put("o", f1022);
        if (context != null) {
        }
        str4 = "";
        String e1122 = d.e(context);
        jSONObject22.put(bt.A, e1122);
        jSONObject22.put("o_mc", str4);
        a(context, jSONObject22);
        jSONObject22.put("aaid", d.d(context));
        jSONObject22.put("uabc", d.c(context));
        if (context != null) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        jSONObject = new JSONObject();
        jSONObject.put("vpn_pxy", d.i(context));
        jSONObject.put("wifi_pxy", d.j(context));
        jSONObject.put("double", d.g(context));
        if (jSONObject != null) {
        }
        b10 = d.b(context);
        if (b10.length() <= 0) {
        }
        a11 = com.umeng.umzid.a.a(b10 + "/anti/updateZdata", jSONObject22.toString());
        if (!TextUtils.isEmpty(a11)) {
        }
        a(context);
        this.f12336b = false;
        return str;
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String d10 = d.d(applicationContext);
        if (!TextUtils.isEmpty(d10)) {
            return d10;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0077 A[Catch: all -> 0x00a6, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences a10;
        SharedPreferences a11;
        SharedPreferences.Editor edit;
        boolean h10 = d.h(context);
        this.f12337c = h10;
        if (h10) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(LelinkSourceSDK.FEEDBACK_PUSH_UNSMOOTH, "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(LelinkSourceSDK.FEEDBACK_PUSH_PLAY_FAILED, "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (a11 = com.umeng.umzid.a.a(applicationContext)) != null && (edit = a11.edit()) != null) {
                edit.putString("appkey", str).commit();
            }
            String d10 = d.d(applicationContext);
            if (d10 != null && !TextUtils.isEmpty(d10)) {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(d10);
                }
                a10 = com.umeng.umzid.a.a(context);
                if (TextUtils.isEmpty(a10 != null ? a10.getString("uuid", "") : "")) {
                    String str2 = "";
                    SharedPreferences a12 = com.umeng.umzid.a.a(context);
                    try {
                        str2 = UUID.randomUUID().toString();
                    } catch (Throwable unused) {
                    }
                    if (a12 != null) {
                        a12.edit().putString("uuid", str2).commit();
                    }
                }
            }
            com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            a10 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(a10 != null ? a10.getString("uuid", "") : "")) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        Throwable th;
        JSONObject jSONObject;
        String b10;
        String a10;
        String str = null;
        if (!zIDManager.f12335a) {
            zIDManager.f12335a = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject2.put(bt.aJ, id);
                String e10 = d.e(context);
                jSONObject2.put(bt.A, e10);
                String f10 = d.f(context);
                jSONObject2.put("o", f10);
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("vpn_pxy", d.i(context));
                        jSONObject.put("wifi_pxy", d.j(context));
                        jSONObject.put("double", d.g(context));
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (jSONObject != null) {
                        }
                        zIDManager.a(context, jSONObject2);
                        b10 = d.b(context);
                        if (b10.length() <= 0) {
                        }
                        a10 = com.umeng.umzid.a.a(b10 + "/anti/postZdata", jSONObject2.toString());
                        if (!TextUtils.isEmpty(a10)) {
                        }
                        zIDManager.a(context);
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                zIDManager.a(context, jSONObject2);
                b10 = d.b(context);
                if (b10.length() <= 0) {
                    b10 = "https://utoken.umeng.com";
                }
                a10 = com.umeng.umzid.a.a(b10 + "/anti/postZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(a10)) {
                    JSONObject jSONObject3 = new JSONObject(a10);
                    if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, e10);
                        d.b(context, f10);
                        str = jSONObject3.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            d.e(context, str);
                        }
                        String optString = jSONObject3.optString("uabc");
                        if (!TextUtils.isEmpty(optString)) {
                            d.d(context, optString);
                        }
                        String optString2 = jSONObject3.optString("resetToken");
                        if (!TextUtils.isEmpty(optString2)) {
                            d.c(context, optString2);
                        }
                    }
                }
                zIDManager.a(context);
            } finally {
                try {
                } finally {
                }
            }
        }
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:0|1|(5:88|89|(2:96|97)|91|(37:93|4|5|6|7|8|(2:10|(30:14|15|16|17|18|19|(3:69|70|(5:72|73|(2:76|74)|77|78))|21|(1:23)(1:68)|24|(1:26)(1:67)|27|28|29|30|31|32|33|34|35|36|(1:40)|41|42|43|44|45|(2:47|(2:51|52))|54|55))|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(2:38|40)|41|42|43|44|45|(0)|54|55))|3|4|5|6|7|8|(0)|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(0)|41|42|43|44|45|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0164, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0165, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014c, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0131, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e5, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0072 A[Catch: all -> 0x0086, TryCatch #6 {all -> 0x0086, blocks: (B:6:0x0064, B:8:0x0068, B:10:0x0072, B:12:0x007f, B:14:0x0083), top: B:5:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018f A[Catch: all -> 0x01a3, TryCatch #3 {all -> 0x01a3, blocks: (B:43:0x0181, B:45:0x0185, B:47:0x018f, B:49:0x019c, B:51:0x01a0), top: B:42:0x0181 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject a(Context context, JSONObject jSONObject) {
        Locale locale;
        int rawOffset;
        Object obj;
        String str;
        Method declaredMethod;
        SharedPreferences a10;
        Method declaredMethod2;
        Object obj2 = "";
        jSONObject.putOpt("z_v", Spy.getVersion());
        jSONObject.putOpt("a_id", d.a(context));
        jSONObject.putOpt("os_v", Build.VERSION.RELEASE);
        Object obj3 = null;
        if (context != null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable unused) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = Locale.getDefault();
                } catch (Throwable unused2) {
                }
            }
            Calendar calendar = Calendar.getInstance(locale);
            if (calendar != null) {
                rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                jSONObject.putOpt("tz", Integer.valueOf(rawOffset));
                jSONObject.putOpt("m", Build.MODEL);
                String str2 = DeviceConfig.UNKNOW;
                declaredMethod2 = DeviceConfig.class.getDeclaredMethod("getImeiNew", Context.class);
                if (declaredMethod2 != null) {
                    declaredMethod2.setAccessible(true);
                    Object invoke = declaredMethod2.invoke(DeviceConfig.class, context);
                    if (invoke != null && (invoke instanceof String)) {
                        obj = (String) invoke;
                        jSONObject.putOpt("im", obj);
                        Method declaredMethod3 = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod3.setAccessible(true);
                        str = declaredMethod3.invoke(null, "net.hostname").toString();
                        if (str != null) {
                            try {
                                if (!str.equalsIgnoreCase("")) {
                                    try {
                                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                                        messageDigest.update(str.getBytes());
                                        byte[] digest = messageDigest.digest();
                                        StringBuffer stringBuffer = new StringBuffer();
                                        for (byte b10 : digest) {
                                            stringBuffer.append(Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE));
                                        }
                                        str = stringBuffer.toString();
                                    } catch (Throwable unused3) {
                                        str = "";
                                    }
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        jSONObject.putOpt("hn", str);
                        jSONObject.putOpt("s_v", "1.8.6");
                        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
                        jSONObject.putOpt("s_t", "Android");
                        SharedPreferences a11 = com.umeng.umzid.a.a(context);
                        jSONObject.putOpt(ParamsMap.DeviceParams.KEY_UID, a11 != null ? a11.getString("uuid", "") : "");
                        jSONObject.putOpt("s_id", "umeng");
                        Object obj4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        jSONObject.putOpt("a_v", obj4);
                        Object obj5 = String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
                        jSONObject.putOpt("a_n", obj5);
                        Object obj6 = context.getResources().getConfiguration().locale.getCountry();
                        jSONObject.putOpt(bt.aL, obj6);
                        if (context != null && (a10 = com.umeng.umzid.a.a(context)) != null) {
                            obj3 = a10.getString("appkey", null);
                        }
                        jSONObject.putOpt("ak", obj3);
                        String str3 = DeviceConfig.UNKNOW;
                        declaredMethod = DeviceConfig.class.getDeclaredMethod("getIdfa", Context.class);
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            Object invoke2 = declaredMethod.invoke(DeviceConfig.class, context);
                            if (invoke2 != null && (invoke2 instanceof String)) {
                                obj2 = (String) invoke2;
                            }
                        }
                        jSONObject.putOpt("gd", obj2);
                        return jSONObject;
                    }
                }
                obj = "";
                jSONObject.putOpt("im", obj);
                Method declaredMethod32 = Build.class.getDeclaredMethod("getString", String.class);
                declaredMethod32.setAccessible(true);
                str = declaredMethod32.invoke(null, "net.hostname").toString();
                if (str != null) {
                }
                jSONObject.putOpt("hn", str);
                jSONObject.putOpt("s_v", "1.8.6");
                jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
                jSONObject.putOpt("s_t", "Android");
                SharedPreferences a112 = com.umeng.umzid.a.a(context);
                jSONObject.putOpt(ParamsMap.DeviceParams.KEY_UID, a112 != null ? a112.getString("uuid", "") : "");
                jSONObject.putOpt("s_id", "umeng");
                Object obj42 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                jSONObject.putOpt("a_v", obj42);
                Object obj52 = String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
                jSONObject.putOpt("a_n", obj52);
                Object obj62 = context.getResources().getConfiguration().locale.getCountry();
                jSONObject.putOpt(bt.aL, obj62);
                if (context != null) {
                    obj3 = a10.getString("appkey", null);
                }
                jSONObject.putOpt("ak", obj3);
                String str32 = DeviceConfig.UNKNOW;
                declaredMethod = DeviceConfig.class.getDeclaredMethod("getIdfa", Context.class);
                if (declaredMethod != null) {
                }
                jSONObject.putOpt("gd", obj2);
                return jSONObject;
            }
        }
        rawOffset = 8;
        jSONObject.putOpt("tz", Integer.valueOf(rawOffset));
        jSONObject.putOpt("m", Build.MODEL);
        String str22 = DeviceConfig.UNKNOW;
        declaredMethod2 = DeviceConfig.class.getDeclaredMethod("getImeiNew", Context.class);
        if (declaredMethod2 != null) {
        }
        obj = "";
        jSONObject.putOpt("im", obj);
        Method declaredMethod322 = Build.class.getDeclaredMethod("getString", String.class);
        declaredMethod322.setAccessible(true);
        str = declaredMethod322.invoke(null, "net.hostname").toString();
        if (str != null) {
        }
        jSONObject.putOpt("hn", str);
        jSONObject.putOpt("s_v", "1.8.6");
        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
        jSONObject.putOpt("s_t", "Android");
        SharedPreferences a1122 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt(ParamsMap.DeviceParams.KEY_UID, a1122 != null ? a1122.getString("uuid", "") : "");
        jSONObject.putOpt("s_id", "umeng");
        Object obj422 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        jSONObject.putOpt("a_v", obj422);
        Object obj522 = String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        jSONObject.putOpt("a_n", obj522);
        Object obj622 = context.getResources().getConfiguration().locale.getCountry();
        jSONObject.putOpt(bt.aL, obj622);
        if (context != null) {
        }
        jSONObject.putOpt("ak", obj3);
        String str322 = DeviceConfig.UNKNOW;
        declaredMethod = DeviceConfig.class.getDeclaredMethod("getIdfa", Context.class);
        if (declaredMethod != null) {
        }
        jSONObject.putOpt("gd", obj2);
        return jSONObject;
    }
}
