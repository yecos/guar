package o3;

import java.io.Serializable;

/* loaded from: classes.dex */
public class p implements n3.q, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.k f17555a;

    public p(k3.k kVar) {
        this.f17555a = kVar;
    }

    @Override // n3.q
    public Object getNullValue(k3.g gVar) {
        return this.f17555a.getEmptyValue(gVar);
    }
}
