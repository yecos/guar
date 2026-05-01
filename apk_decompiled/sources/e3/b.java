package e3;

import c3.k;
import c3.l;

/* loaded from: classes.dex */
public abstract class b extends l {

    /* renamed from: b, reason: collision with root package name */
    public transient k f12858b;

    public b(k kVar, String str) {
        super(str, kVar == null ? null : kVar.z());
        this.f12858b = kVar;
    }

    @Override // c3.l
    /* renamed from: e */
    public k d() {
        return this.f12858b;
    }

    @Override // c3.l, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public b(k kVar, String str, Throwable th) {
        super(str, kVar == null ? null : kVar.z(), th);
        this.f12858b = kVar;
    }
}
