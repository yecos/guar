package s7;

/* loaded from: classes3.dex */
public abstract class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Process] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r4.<init>()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r4.append(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.lang.Process r7 = r3.exec(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.io.InputStream r3 = r7.getInputStream()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L51
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L51
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L51
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L51
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L51
            java.lang.String r2 = r4.readLine()     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L83
            if (r2 == 0) goto L41
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L83
            if (r3 != 0) goto L41
            r7.destroy()
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r2
        L41:
            r7.destroy()
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r8
        L4c:
            r2 = move-exception
            goto L5c
        L4e:
            r8 = move-exception
            r4 = r2
            goto L84
        L51:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L5c
        L55:
            r8 = move-exception
            r4 = r2
            goto L85
        L58:
            r7 = move-exception
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.String r3 = "PropUtil"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r5.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = "Exception in getProp and exception info is "
            r5.append(r6)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch: java.lang.Throwable -> L83
            r5.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L83
            s7.b.c(r3, r2)     // Catch: java.lang.Throwable -> L83
            if (r7 == 0) goto L7b
            r7.destroy()
        L7b:
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            return r8
        L83:
            r8 = move-exception
        L84:
            r2 = r7
        L85:
            if (r2 == 0) goto L8a
            r2.destroy()
        L8a:
            java.io.Closeable[] r7 = new java.io.Closeable[r1]
            r7[r0] = r4
            s7.a.a(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.d.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
