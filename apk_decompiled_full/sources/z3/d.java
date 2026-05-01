package z3;

import java.util.Arrays;
import k3.c0;

/* loaded from: classes.dex */
public class d extends v {

    /* renamed from: b, reason: collision with root package name */
    public static final d f20166b = new d(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f20167a;

    public d(byte[] bArr) {
        this.f20167a = bArr;
    }

    public static d v(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? f20166b : new d(bArr);
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_EMBEDDED_OBJECT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        c3.a h10 = c0Var.k().h();
        byte[] bArr = this.f20167a;
        hVar.R(h10, bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof d)) {
            return Arrays.equals(((d) obj).f20167a, this.f20167a);
        }
        return false;
    }

    @Override // k3.m
    public String g() {
        return c3.b.a().i(this.f20167a, false);
    }

    public int hashCode() {
        byte[] bArr = this.f20167a;
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    @Override // k3.m
    public byte[] i() {
        return this.f20167a;
    }

    @Override // k3.m
    public m o() {
        return m.BINARY;
    }
}
