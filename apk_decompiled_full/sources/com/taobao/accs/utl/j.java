package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.umeng.ut.device.UTDevice;
import java.io.File;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f9358a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f9359b = "";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f9360c = true;
    public static final String channelService = "com.taobao.accs.ChannelService";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f9361d = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean a(Context context) {
        String str;
        if (f9361d) {
            return f9360c;
        }
        try {
            if (TextUtils.isEmpty(com.taobao.accs.client.a.f9047c)) {
                if (TextUtils.isEmpty(f9358a)) {
                    f9358a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                str = f9358a;
            } else {
                str = com.taobao.accs.client.a.f9047c;
            }
            if (TextUtils.isEmpty(f9359b)) {
                f9359b = a(context, Process.myPid());
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f9359b)) {
                f9360c = str.equalsIgnoreCase(f9359b);
                f9361d = true;
            }
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
        }
        return f9360c;
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String c(Context context) {
        boolean areNotificationsEnabled;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                areNotificationsEnabled = ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
                return String.valueOf(areNotificationsEnabled);
            } catch (Throwable th) {
                ALog.e("AdapterUtilityImpl", "Android above 7.0 isNotificationEnabled", th, new Object[0]);
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i10 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                boolean z10 = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i10), packageName)).intValue() != 0) {
                    z10 = false;
                }
                return String.valueOf(z10);
            } catch (Throwable th2) {
                ALog.e("AdapterUtilityImpl", "isNotificationEnabled", th2, new Object[0]);
            }
        }
        return "unknown";
    }

    public static String a(Context context, int i10) {
        IProcessName iProcessName = com.taobao.accs.client.a.f9049e;
        if (iProcessName != null) {
            return iProcessName.getCurrProcessName();
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com.taobao.accs.client.a.a(context).a().getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i10) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            return dataDirectory.getUsableSpace();
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static boolean a(String str, int i10) {
        if (str == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(str);
            int blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("st.getAvailableBlocks()=");
            sb.append(statFs.getAvailableBlocks());
            sb.append(",st.getAvailableBlocks() * blockSize=");
            long j10 = blockSize;
            sb.append(statFs.getAvailableBlocks() * j10);
            ALog.d("FileCheckUtils", sb.toString(), new Object[0]);
            return statFs.getAvailableBlocks() > 10 && availableBlocks * j10 > ((long) i10);
        } catch (Throwable unused) {
            return false;
        }
    }
}
