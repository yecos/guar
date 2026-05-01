package c3;

import java.io.Serializable;

/* loaded from: classes.dex */
public class i implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final i f5449f = new i(null, -1, -1, -1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final long f5450a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5451b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5452c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5453d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object f5454e;

    public i(Object obj, long j10, int i10, int i11) {
        this(obj, -1L, j10, i10, i11);
    }

    public final int a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.StringBuilder b(java.lang.StringBuilder r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f5454e
            if (r0 != 0) goto La
            java.lang.String r0 = "UNKNOWN"
            r7.append(r0)
            return r7
        La:
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L12
            r1 = r0
            java.lang.Class r1 = (java.lang.Class) r1
            goto L16
        L12:
            java.lang.Class r1 = r0.getClass()
        L16:
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "java."
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L27
            java.lang.String r2 = r1.getSimpleName()
            goto L34
        L27:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L2e
            java.lang.String r2 = "byte[]"
            goto L34
        L2e:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L34
            java.lang.String r2 = "char[]"
        L34:
            r1 = 40
            r7.append(r1)
            r7.append(r2)
            r1 = 41
            r7.append(r1)
            boolean r1 = r0 instanceof java.lang.CharSequence
            r2 = 500(0x1f4, float:7.0E-43)
            r3 = 0
            java.lang.String r4 = " chars"
            if (r1 == 0) goto L63
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            int r2 = java.lang.Math.min(r1, r2)
            java.lang.CharSequence r0 = r0.subSequence(r3, r2)
            java.lang.String r0 = r0.toString()
            int r0 = r6.a(r7, r0)
        L60:
            int r3 = r1 - r0
            goto L96
        L63:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L78
            char[] r0 = (char[]) r0
            int r1 = r0.length
            java.lang.String r5 = new java.lang.String
            int r2 = java.lang.Math.min(r1, r2)
            r5.<init>(r0, r3, r2)
            int r0 = r6.a(r7, r5)
            goto L60
        L78:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L96
            byte[] r0 = (byte[]) r0
            int r1 = r0.length
            int r1 = java.lang.Math.min(r1, r2)
            java.lang.String r2 = new java.lang.String
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            r2.<init>(r0, r3, r1, r4)
            r6.a(r7, r2)
            int r0 = r0.length
            int r3 = r0 - r1
            java.lang.String r4 = " bytes"
        L96:
            if (r3 <= 0) goto La8
            java.lang.String r0 = "[truncated "
            r7.append(r0)
            r7.append(r3)
            r7.append(r4)
            r0 = 93
            r7.append(r0)
        La8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.i.b(java.lang.StringBuilder):java.lang.StringBuilder");
    }

    public long c() {
        return this.f5450a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        Object obj2 = this.f5454e;
        if (obj2 == null) {
            if (iVar.f5454e != null) {
                return false;
            }
        } else if (!obj2.equals(iVar.f5454e)) {
            return false;
        }
        return this.f5452c == iVar.f5452c && this.f5453d == iVar.f5453d && this.f5451b == iVar.f5451b && c() == iVar.c();
    }

    public int hashCode() {
        Object obj = this.f5454e;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.f5452c) + this.f5453d) ^ ((int) this.f5451b)) + ((int) this.f5450a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        b(sb);
        sb.append("; line: ");
        sb.append(this.f5452c);
        sb.append(", column: ");
        sb.append(this.f5453d);
        sb.append(']');
        return sb.toString();
    }

    public i(Object obj, long j10, long j11, int i10, int i11) {
        this.f5454e = obj;
        this.f5450a = j10;
        this.f5451b = j11;
        this.f5452c = i10;
        this.f5453d = i11;
    }
}
