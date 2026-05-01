package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import anet.channel.util.SerializeHelper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private static File f4247a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f4248b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Comparator<File> f4249c = new n();

    public static void a(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir(), "awcn_strategy");
                f4247a = file;
                if (!a(file)) {
                    ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f4247a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    File file2 = new File(f4247a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    f4247a = file2;
                    if (!a(file2)) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f4247a.getAbsolutePath());
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "StrateyFolder", null, "path", f4247a.getAbsolutePath());
                if (!f4248b) {
                    c();
                } else {
                    a();
                    f4248b = false;
                }
            } catch (Throwable th) {
                ALog.e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
            }
        }
    }

    public static synchronized File[] b() {
        synchronized (m.class) {
            File file = f4247a;
            if (file == null) {
                return null;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, f4249c);
            }
            return listFiles;
        }
    }

    public static synchronized void c() {
        synchronized (m.class) {
            File[] b10 = b();
            if (b10 == null) {
                return;
            }
            int i10 = 0;
            for (File file : b10) {
                if (!file.isDirectory()) {
                    if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                        file.delete();
                    } else if (file.getName().startsWith("WIFI")) {
                        int i11 = i10 + 1;
                        if (i10 > 10) {
                            file.delete();
                        }
                        i10 = i11;
                    }
                }
            }
        }
    }

    private static boolean a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public static File a(String str) {
        a(f4247a);
        return new File(f4247a, str);
    }

    public static synchronized void a() {
        synchronized (m.class) {
            ALog.i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
            File file = f4247a;
            if (file == null) {
                ALog.w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
                f4248b = true;
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
            ALog.i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
        }
    }

    public static synchronized void a(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        synchronized (m.class) {
            SerializeHelper.persist(serializable, a(str), strategyStatObject);
        }
    }

    public static synchronized <T> T a(String str, StrategyStatObject strategyStatObject) {
        T t10;
        synchronized (m.class) {
            t10 = (T) SerializeHelper.restore(a(str), strategyStatObject);
        }
        return t10;
    }
}
