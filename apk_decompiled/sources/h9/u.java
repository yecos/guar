package h9;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class u implements g, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public s9.a f14243a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14244b;

    public u(s9.a aVar) {
        t9.i.g(aVar, "initializer");
        this.f14243a = aVar;
        this.f14244b = r.f14241a;
    }

    public boolean a() {
        return this.f14244b != r.f14241a;
    }

    @Override // h9.g
    public Object getValue() {
        if (this.f14244b == r.f14241a) {
            s9.a aVar = this.f14243a;
            t9.i.d(aVar);
            this.f14244b = aVar.invoke();
            this.f14243a = null;
        }
        return this.f14244b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
