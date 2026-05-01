package p5;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18064a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18065b = a.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public static final String f18066c = "EMUI";

    /* renamed from: d, reason: collision with root package name */
    public static final String f18067d = "ro.build.version.emui";

    public final boolean a() {
        return f();
    }

    public final boolean b() {
        return g();
    }

    public final String c() {
        String str = Build.MANUFACTURER;
        i.f(str, "MANUFACTURER");
        return str;
    }

    public final String d(String str) {
        i.g(str, "romType");
        if (i.b(str, f18066c)) {
            return e(f18067d);
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0094: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:149), block:B:34:0x0094 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    i.f(readLine, "input.readLine()");
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                        Log.e(f18065b, "Exception while closing InputStream", e10);
                    }
                    return readLine;
                } catch (IOException e11) {
                    e = e11;
                    Log.e(f18065b, "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            Log.e(f18065b, "Exception while closing InputStream", e12);
                        }
                    }
                    return null;
                } catch (IllegalStateException e13) {
                    e = e13;
                    Log.e(f18065b, "Illegal state and Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e14) {
                            Log.e(f18065b, "Exception while closing InputStream", e14);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e15) {
                        Log.e(f18065b, "Exception while closing InputStream", e15);
                    }
                }
                throw th;
            }
        } catch (IOException e16) {
            e = e16;
            bufferedReader = null;
        } catch (IllegalStateException e17) {
            e = e17;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
    }

    public final boolean f() {
        return !h() || Build.VERSION.SDK_INT >= 21;
    }

    public final boolean g() {
        String d10 = d(f18066c);
        if (TextUtils.isEmpty(d10)) {
            return false;
        }
        return i.b(d10, "EmotionUI_3.1");
    }

    public final boolean h() {
        String c10 = c();
        return !TextUtils.isEmpty(c10) && i.b(c10, "OPPO");
    }
}
