package ba;

/* loaded from: classes3.dex */
public abstract class r extends q {
    public static final Long b(String str) {
        t9.i.g(str, "<this>");
        return c(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Long c(String str, int i10) {
        boolean z10;
        t9.i.g(str, "<this>");
        a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char charAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (t9.i.i(charAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j10 = Long.MIN_VALUE;
                i11 = 1;
                long j11 = -256204778801521550L;
                long j12 = 0;
                long j13 = -256204778801521550L;
                while (i11 < length) {
                    int b10 = a.b(str.charAt(i11), i10);
                    if (b10 < 0) {
                        return null;
                    }
                    if (j12 < j13) {
                        if (j13 == j11) {
                            j13 = j10 / i10;
                            if (j12 < j13) {
                            }
                        }
                        return null;
                    }
                    long j14 = j12 * i10;
                    long j15 = b10;
                    if (j14 < j10 + j15) {
                        return null;
                    }
                    j12 = j14 - j15;
                    i11++;
                    j11 = -256204778801521550L;
                }
                return !z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
            }
            if (charAt != '+') {
                return null;
            }
            i11 = 1;
        }
        z10 = false;
        long j112 = -256204778801521550L;
        long j122 = 0;
        long j132 = -256204778801521550L;
        while (i11 < length) {
        }
        if (!z10) {
        }
    }
}
