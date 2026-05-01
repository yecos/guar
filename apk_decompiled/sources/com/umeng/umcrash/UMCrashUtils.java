package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.uc.crashsdk.export.CrashApi;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes3.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String[] getActiveUser(Context context) {
        Class<UMUtils> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = UMUtils.class;
            String str = UMUtils.UNKNOW;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return (String[]) invoke;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static int getInnerConfig(Context context, String str, int i10) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return i10;
        }
        try {
            return (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null) ? i10 : sharedPreferences.getInt(str, i10);
        } catch (Throwable th) {
            th.printStackTrace();
            return i10;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return DeviceConfig.getNetworkOperatorName(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isHarmony(final Context context) {
        final SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0);
        } catch (Throwable unused) {
        }
        if (sharedPreferences.contains("um_apm_harmony")) {
            return sharedPreferences.getBoolean("um_apm_harmony", false);
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrashUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sharedPreferences.edit().putBoolean("um_apm_harmony", context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony")).apply();
                } catch (Throwable unused2) {
                }
            }
        });
        return false;
    }

    public static boolean random(int i10) {
        if (i10 == 0) {
            return false;
        }
        return i10 == 100 || new Random().nextInt(100) <= i10;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt(str, Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(String str, String str2) {
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMConfigure.BS_TYPE bs_type = UMConfigure.BS_TYPE.APM;
            Method declaredMethod = UMConfigure.class.getDeclaredMethod("setModuleTag", UMConfigure.BS_TYPE.class, String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                for (Enum r92 : (Enum[]) UMConfigure.BS_TYPE.class.getEnumConstants()) {
                    if (r92 != null && r92.name().equals("APM")) {
                        declaredMethod.invoke(UMConfigure.class, r92, str, str2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static String splitByByte(String str, int i10) {
        StringBuffer stringBuffer = new StringBuffer(i10);
        try {
            int length = str.length();
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                String valueOf = String.valueOf(str.charAt(i12));
                i11 += valueOf.getBytes().length;
                if (i10 < i11) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
