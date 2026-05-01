package com.umeng.message.proguard;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.ConfigListener;
import com.umeng.ccg.ConfigResult;
import com.umeng.ccg.ConfigUpdateListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.ut.device.UTDevice;
import java.io.Closeable;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    private static String f12087e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f12088f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f12089g;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f12086d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12083a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12084b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12085c = false;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f12088f;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(a(context), packageName));
        f12088f = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean c(Context context) {
        Boolean bool = null;
        try {
            bool = (Boolean) bn.a(bn.a(UTDevice.class.getName(), "isNewDid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
        return Boolean.TRUE.equals(bool);
    }

    public static String d(Context context) {
        try {
            return (String) bn.a(bn.a(UTDevice.class.getName(), "getTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return null;
        }
    }

    public static void e(Context context) {
        try {
            bn.a(bn.a(UTDevice.class.getName(), "removeTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean f(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static File g(Context context) {
        File file = new File(context.getCacheDir(), "umeng_push");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return file;
    }

    public static void a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) >= 0) {
                ComponentName componentName = new ComponentName(context, cls);
                if (a(packageManager, componentName)) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean b() {
        Boolean bool = f12089g;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = null;
        try {
            bool2 = (Boolean) bn.a(bn.a(UMConfigure.class.getName(), "isSilentMode", (Class<?>[]) new Class[0]), (Object) null, (Object[]) null);
        } catch (Throwable unused) {
        }
        Boolean valueOf = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
        f12089g = valueOf;
        return valueOf.booleanValue();
    }

    public static void c() {
        boolean z10;
        try {
            CcgAgent.getConfigInfo(new ConfigResult() { // from class: com.umeng.message.proguard.f.1
                @Override // com.umeng.ccg.ConfigResult
                public final void onConfigInfo(JSONObject jSONObject) {
                    ak.a().a("get", jSONObject);
                }
            });
            CcgAgent.registerConfigUpdateListener(new ConfigUpdateListener() { // from class: com.umeng.message.proguard.f.2
                @Override // com.umeng.ccg.ConfigUpdateListener
                public final void onConfigUpdate(JSONObject jSONObject) {
                    ak.a().a(DialogManager.DIALOG_UPDATE, jSONObject);
                }
            });
            z10 = true;
        } catch (Throwable unused) {
            z10 = false;
        }
        if (!z10) {
            try {
                CcgAgent.registerConfigListener(new ConfigListener() { // from class: com.umeng.message.proguard.f.3
                    @Override // com.umeng.ccg.ConfigListener
                    public final void onConfigReady(JSONObject jSONObject) {
                        ak.a().a("init", jSONObject);
                    }
                });
            } catch (Throwable unused2) {
            }
        }
        try {
            UMConfigure.registerActionInfo(new s());
            f12085c = true;
        } catch (Throwable unused3) {
        }
    }

    private static boolean a(PackageManager packageManager, ComponentName componentName) {
        try {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return false;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f12087e)) {
            return f12087e;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
        if (TextUtils.isEmpty(str)) {
            str = UMFrUtils.getCurrentProcessName(context);
        }
        f12087e = str;
        return str;
    }

    public static String a(Context context, String str) {
        String str2 = context.getCacheDir() + "/umeng_push_inapp/";
        if (str == null) {
            return str2;
        }
        return str2 + str + Operator.Operation.DIVISION;
    }

    public static int a() {
        return View.generateViewId();
    }

    public static void a(Context context, String str, long j10) {
        try {
            bn.a(bn.a(UTDevice.class.getName(), "resetDid", (Class<?>[]) new Class[]{Context.class, String.class, Long.TYPE}), (Object) null, new Object[]{context, str, Long.valueOf(j10)});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static Object a(Object obj, String str) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(long j10) {
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(1);
        int i11 = calendar.get(6);
        calendar.setTimeInMillis(j10);
        return i11 == calendar.get(6) && i10 == calendar.get(1);
    }

    public static Bitmap a(File file, int i10, int i11) {
        try {
            if (i11 != 0 && i10 != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                float f10 = i10 >= i11 ? options.outWidth / i10 : options.outHeight / i11;
                if (f10 < 1.0f) {
                    f10 = 1.0f;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = (int) f10;
                return BitmapFactory.decodeFile(file.getPath(), options);
            }
            return BitmapFactory.decodeFile(file.getPath(), null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str.hashCode();
        switch (str) {
            case "NIOPUSH_TOKEN":
                return UPushThirdTokenCallback.TYPE_NIO;
            case "HW_TOKEN":
                return "huawei";
            case "MI_TOKEN":
                return "xiaomi";
            case "gcm":
                return "fcm";
            case "HONOR_TOKEN":
                return UPushThirdTokenCallback.TYPE_HONOR;
            case "OPPO_TOKEN":
                return "oppo";
            case "VIVO_TOKEN":
                return "vivo";
            case "MZ_TOKEN":
                return "meizu";
            default:
                return str;
        }
    }

    public static void a(boolean z10) {
        f12083a = z10;
        try {
            bn.a(bn.a(UMConfigure.class.getName(), "enableAplCollection", (Class<?>[]) new Class[]{Boolean.TYPE}), (Object) null, new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused) {
        }
    }
}
