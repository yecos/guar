package o3;

import b3.k0;
import b3.n0;

/* loaded from: classes.dex */
public class w extends n0 {
    public w(Class cls) {
        super(cls);
    }

    @Override // b3.k0
    public k0 b(Class cls) {
        return cls == this.f4545a ? this : new w(cls);
    }

    @Override // b3.k0
    public Object c(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // b3.k0
    public k0.a f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new k0.a(getClass(), this.f4545a, obj);
    }

    @Override // b3.k0
    public k0 h(Object obj) {
        return this;
    }
}
