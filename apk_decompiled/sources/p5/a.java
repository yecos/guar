package p5;

import android.os.Build;
import android.text.TextUtils;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Exception while closing InputStream"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            r3.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.lang.String r4 = "getprop "
            r3.append(r4)     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            r3.append(r8)     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            r2 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> L47 java.lang.IllegalStateException -> L49 java.io.IOException -> L6e
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.IllegalStateException -> L43 java.io.IOException -> L45 java.lang.Throwable -> L93
            java.lang.String r4 = "input.readLine()"
            t9.i.f(r2, r4)     // Catch: java.lang.IllegalStateException -> L43 java.io.IOException -> L45 java.lang.Throwable -> L93
            r3.close()     // Catch: java.lang.IllegalStateException -> L43 java.io.IOException -> L45 java.lang.Throwable -> L93
            r3.close()     // Catch: java.io.IOException -> L3c
            goto L42
        L3c:
            r8 = move-exception
            java.lang.String r1 = p5.a.f18065b
            android.util.Log.e(r1, r0, r8)
        L42:
            return r2
        L43:
            r2 = move-exception
            goto L4b
        L45:
            r2 = move-exception
            goto L70
        L47:
            r8 = move-exception
            goto L95
        L49:
            r2 = move-exception
            r3 = r1
        L4b:
            java.lang.String r4 = p5.a.f18065b     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r5.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = "Illegal state and Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L93
            r5.append(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L93
            android.util.Log.e(r4, r8, r2)     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L6d
            r3.close()     // Catch: java.io.IOException -> L67
            goto L6d
        L67:
            r8 = move-exception
            java.lang.String r2 = p5.a.f18065b
            android.util.Log.e(r2, r0, r8)
        L6d:
            return r1
        L6e:
            r2 = move-exception
            r3 = r1
        L70:
            java.lang.String r4 = p5.a.f18065b     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r5.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L93
            r5.append(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L93
            android.util.Log.e(r4, r8, r2)     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L92
            r3.close()     // Catch: java.io.IOException -> L8c
            goto L92
        L8c:
            r8 = move-exception
            java.lang.String r2 = p5.a.f18065b
            android.util.Log.e(r2, r0, r8)
        L92:
            return r1
        L93:
            r8 = move-exception
            r1 = r3
        L95:
            if (r1 == 0) goto La1
            r1.close()     // Catch: java.io.IOException -> L9b
            goto La1
        L9b:
            r1 = move-exception
            java.lang.String r2 = p5.a.f18065b
            android.util.Log.e(r2, r0, r1)
        La1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.a.e(java.lang.String):java.lang.String");
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
