package t9;

import z9.f;

/* loaded from: classes3.dex */
public abstract class k extends m implements z9.d {
    public k(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // z9.f
    public f.a a() {
        ((z9.d) h()).a();
        return null;
    }

    @Override // t9.c
    public z9.a c() {
        return x.c(this);
    }

    @Override // s9.l
    public Object invoke(Object obj) {
        return get(obj);
    }
}
