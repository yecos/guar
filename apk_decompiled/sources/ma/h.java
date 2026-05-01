package ma;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f16853a;

    /* renamed from: b, reason: collision with root package name */
    public static String f16854b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f16855c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f16856d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f16857e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f16858f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f16859g;

    static {
        h hVar = new h();
        f16853a = hVar;
        f16854b = hVar.getClass().getSimpleName();
        f16855c = "de.robv.android.xposed.XposedHelpers";
        f16856d = "de.robv.android.xposed.XposedBridge";
        f16857e = "xposed";
        f16858f = "/system/lib/libxposed_art.so";
        f16859g = "/system/lib64/libxposed_art.so";
    }

    public final boolean a() {
        try {
            String str = Build.MODEL;
            t9.i.f(str, "MODEL");
            return ba.s.l(str, "Emulator", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean b() {
        try {
            Process exec = Runtime.getRuntime().exec("ps");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            bufferedReader.close();
            exec.waitFor();
            String sb2 = sb.toString();
            t9.i.f(sb2, "output.toString()");
            return ba.t.o(sb2, "frida-server", false, 2, null);
        } catch (IOException | InterruptedException | Exception unused) {
            return false;
        }
    }

    public final boolean c() {
        try {
            String stackTraceString = Log.getStackTraceString(new Throwable());
            t9.i.f(stackTraceString, "getStackTraceString(Throwable())");
            return ba.t.o(stackTraceString, "xposed", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void d(Context context, String str) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "pkgName");
        l.a(m7.f.f16828a);
        try {
            b.f16848a.b();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } catch (Exception unused) {
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public final String e(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            String d10 = m.d(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0]);
            t9.i.f(d10, "signStr");
            return d10;
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean f() {
        return c() || h() || g();
    }

    public final boolean g() {
        try {
            throw new Exception("gg");
        } catch (Exception e10) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            t9.i.f(stackTrace, "e.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                t9.i.f(className, "stackTraceElement.className");
                if (ba.t.o(className, f16856d, false, 2, null)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean h() {
        try {
            ClassLoader.getSystemClassLoader().loadClass(f16855c).newInstance();
            try {
                ClassLoader.getSystemClassLoader().loadClass(f16856d).newInstance();
                return true;
            } catch (ClassNotFoundException | Exception unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        } catch (ClassNotFoundException | Exception unused3) {
            return false;
        } catch (IllegalAccessException | InstantiationException unused4) {
            return true;
        }
    }
}
