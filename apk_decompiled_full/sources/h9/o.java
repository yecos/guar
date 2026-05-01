package h9;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class o implements g, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public s9.a f14238a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f14239b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14240c;

    public o(s9.a aVar, Object obj) {
        t9.i.g(aVar, "initializer");
        this.f14238a = aVar;
        this.f14239b = r.f14241a;
        this.f14240c = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f14239b != r.f14241a;
    }

    @Override // h9.g
    public Object getValue() {
        Object obj;
        Object obj2 = this.f14239b;
        r rVar = r.f14241a;
        if (obj2 != rVar) {
            return obj2;
        }
        synchronized (this.f14240c) {
            obj = this.f14239b;
            if (obj == rVar) {
                s9.a aVar = this.f14238a;
                t9.i.d(aVar);
                obj = aVar.invoke();
                this.f14239b = obj;
                this.f14238a = null;
            }
        }
        return obj;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ o(s9.a aVar, Object obj, int i10, t9.g gVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
