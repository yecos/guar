package f3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f13063a = a.d();

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13064b = a.c();

    /* renamed from: c, reason: collision with root package name */
    public static final e f13065c = new e();

    public static int d(int i10, int i11) {
        if (i11 >= 56320 && i11 <= 57343) {
            return ((i10 - 55296) << 10) + 65536 + (i11 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11) + "; illegal combination");
    }

    public static void e(int i10) {
        throw new IllegalArgumentException(j.c(i10));
    }

    public static e h() {
        return f13065c;
    }

    public final int a(int i10, int i11, j3.c cVar, int i12) {
        cVar.u(i12);
        cVar.b(92);
        if (i11 < 0) {
            cVar.b(117);
            if (i10 > 255) {
                int i13 = i10 >> 8;
                byte[] bArr = f13064b;
                cVar.b(bArr[i13 >> 4]);
                cVar.b(bArr[i13 & 15]);
                i10 &= 255;
            } else {
                cVar.b(48);
                cVar.b(48);
            }
            byte[] bArr2 = f13064b;
            cVar.b(bArr2[i10 >> 4]);
            cVar.b(bArr2[i10 & 15]);
        } else {
            cVar.b((byte) i11);
        }
        return cVar.s();
    }

    public final int b(int i10, char[] cArr) {
        cArr[1] = (char) i10;
        return 2;
    }

    public final int c(int i10, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f13063a;
        cArr[4] = cArr2[i10 >> 4];
        cArr[5] = cArr2[i10 & 15];
        return 6;
    }

    public final char[] f() {
        return new char[]{ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 0, '0', '0', 0, 0};
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] g(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.g(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r1[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r10 >= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r7 = c(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        r10 = r8 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r10 <= r0.length) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        r10 = r0.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r10 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r5 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r5 = j3.o.p(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        r0 = r5.o();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r0, 0, r7);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r7);
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        r7 = b(r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        r6 = f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] i(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 30
            char[] r0 = new char[r0]
            int[] r1 = f3.a.e()
            int r2 = r1.length
            int r3 = r13.length()
            r4 = 0
            r5 = 0
            r6 = r5
            r7 = 0
            r8 = 0
        L12:
            if (r7 >= r3) goto L73
        L14:
            char r9 = r13.charAt(r7)
            if (r9 >= r2) goto L59
            r10 = r1[r9]
            if (r10 == 0) goto L59
            if (r6 != 0) goto L24
            char[] r6 = r12.f()
        L24:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r1[r7]
            if (r10 >= 0) goto L33
            int r7 = r12.c(r7, r6)
            goto L37
        L33:
            int r7 = r12.b(r10, r6)
        L37:
            int r10 = r8 + r7
            int r11 = r0.length
            if (r10 <= r11) goto L53
            int r10 = r0.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L43
            java.lang.System.arraycopy(r6, r4, r0, r8, r10)
        L43:
            if (r5 != 0) goto L49
            j3.o r5 = j3.o.p(r0)
        L49:
            char[] r0 = r5.o()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r0, r4, r7)
            r8 = r7
            goto L57
        L53:
            java.lang.System.arraycopy(r6, r4, r0, r8, r7)
            r8 = r10
        L57:
            r7 = r9
            goto L12
        L59:
            int r10 = r0.length
            if (r8 < r10) goto L67
            if (r5 != 0) goto L62
            j3.o r5 = j3.o.p(r0)
        L62:
            char[] r0 = r5.o()
            r8 = 0
        L67:
            int r10 = r8 + 1
            r0[r8] = r9
            int r7 = r7 + 1
            if (r7 < r3) goto L71
            r8 = r10
            goto L73
        L71:
            r8 = r10
            goto L14
        L73:
            if (r5 != 0) goto L7a
            char[] r13 = java.util.Arrays.copyOfRange(r0, r4, r8)
            return r13
        L7a:
            r5.z(r8)
            char[] r13 = r5.g()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.i(java.lang.String):char[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] j(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.j(java.lang.String):byte[]");
    }
}
