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
    */
    public final Void R() {
        String str;
        if (this.f15776c == null) {
            s.d();
            throw new h9.c();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.f15777d;
        if (str2 != null) {
            str = ". " + str2;
        }
        str = "";
        sb.append(str);
        throw new IllegalStateException(sb.toString(), this.f15776c);
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
