package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class m implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static m f5912a;

    /* renamed from: d, reason: collision with root package name */
    private int f5913d;

    /* renamed from: d, reason: collision with other field name */
    private long f23d = 0;

    public static m a() {
        if (f5912a == null) {
            f5912a = new m();
        }
        return f5912a;
    }

    public void a(int i10) {
        this.f5913d = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127 A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #13 {all -> 0x0158, blocks: (B:54:0x0119, B:56:0x0127, B:58:0x012b, B:61:0x013e), top: B:53:0x0119, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0143 A[Catch: all -> 0x0170, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:75:0x015b, B:85:0x0160, B:78:0x0168, B:83:0x016f, B:82:0x016c, B:64:0x0143, B:72:0x0148, B:67:0x0150, B:46:0x0154, B:44:0x010c, B:37:0x00fb, B:50:0x0100, B:40:0x0108), top: B:2:0x0001, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0150 A[Catch: IOException -> 0x014c, all -> 0x0170, TRY_LEAVE, TryCatch #4 {IOException -> 0x014c, blocks: (B:72:0x0148, B:67:0x0150), top: B:71:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015b A[Catch: all -> 0x0170, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:75:0x015b, B:85:0x0160, B:78:0x0168, B:83:0x016f, B:82:0x016c, B:64:0x0143, B:72:0x0148, B:67:0x0150, B:46:0x0154, B:44:0x010c, B:37:0x00fb, B:50:0x0100, B:40:0x0108), top: B:2:0x0001, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0168 A[Catch: IOException -> 0x0164, all -> 0x0170, TRY_LEAVE, TryCatch #11 {IOException -> 0x0164, blocks: (B:85:0x0160, B:78:0x0168), top: B:84:0x0160, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.String[] call() {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.m.call():java.lang.String[]");
    }
}
