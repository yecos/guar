package c4;

/* loaded from: classes.dex */
public class i extends m {

    /* renamed from: l, reason: collision with root package name */
    public final int f5551l;

    /* renamed from: m, reason: collision with root package name */
    public k3.j f5552m;

    public i(int i10) {
        super(Object.class, n.i(), o.O(), null, 1, null, null, false);
        this.f5551l = i10;
    }

    @Override // k3.j
    public boolean D() {
        return false;
    }

    @Override // k3.j
    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return (k3.j) b0();
    }

    @Override // k3.j
    public k3.j R(k3.j jVar) {
        return (k3.j) b0();
    }

    @Override // k3.j
    public k3.j S(Object obj) {
        return (k3.j) b0();
    }

    @Override // k3.j
    /* renamed from: T */
    public k3.j c0(Object obj) {
        return (k3.j) b0();
    }

    @Override // k3.j
    /* renamed from: V */
    public k3.j d0() {
        return (k3.j) b0();
    }

    @Override // k3.j
    /* renamed from: W */
    public k3.j e0(Object obj) {
        return (k3.j) b0();
    }

    @Override // k3.j
    /* renamed from: X */
    public k3.j f0(Object obj) {
        return (k3.j) b0();
    }

    @Override // c4.m
    public String a0() {
        return toString();
    }

    public final Object b0() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + getClass().getName());
    }

    public k3.j c0() {
        return this.f5552m;
    }

    public void d0(k3.j jVar) {
        this.f5552m = jVar;
    }

    @Override // k3.j
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // k3.j
    public StringBuilder l(StringBuilder sb) {
        sb.append('$');
        sb.append(this.f5551l + 1);
        return sb;
    }

    @Override // k3.j
    public StringBuilder n(StringBuilder sb) {
        return l(sb);
    }

    @Override // k3.j
    public String toString() {
        return l(new StringBuilder()).toString();
    }
}
