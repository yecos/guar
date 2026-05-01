package kotlinx.coroutines.internal;

import ca.j0;
import ca.p1;

/* loaded from: classes3.dex */
public final class t extends p1 implements j0 {

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f15776c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15777d;

    public t(Throwable th, String str) {
        this.f15776c = th;
        this.f15777d = str;
    }

    @Override // ca.y
    public boolean M(k9.f fVar) {
        R();
        throw new h9.c();
    }

    @Override // ca.p1
    public p1 O() {
        return this;
    }

    @Override // ca.y
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Void L(k9.f fVar, Runnable runnable) {
        R();
        throw new h9.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Void R() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f15776c
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f15777d
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f15776c
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.s.d()
            h9.c r0 = new h9.c
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.t.R():java.lang.Void");
    }

    @Override // ca.y
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f15776c != null) {
            str = ", cause=" + this.f15776c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
