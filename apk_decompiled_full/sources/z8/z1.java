package z8;

import com.google.common.base.Preconditions;
import java.util.Map;
import y8.y0;

/* loaded from: classes3.dex */
public final class z1 extends y0.f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21189a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21190b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21191c;

    /* renamed from: d, reason: collision with root package name */
    public final j f21192d;

    public z1(boolean z10, int i10, int i11, j jVar) {
        this.f21189a = z10;
        this.f21190b = i10;
        this.f21191c = i11;
        this.f21192d = (j) Preconditions.checkNotNull(jVar, "autoLoadBalancerFactory");
    }

    @Override // y8.y0.f
    public y0.b a(Map map) {
        Object c10;
        try {
            y0.b f10 = this.f21192d.f(map);
            if (f10 == null) {
                c10 = null;
            } else {
                if (f10.d() != null) {
                    return y0.b.b(f10.d());
                }
                c10 = f10.c();
            }
            return y0.b.a(i1.b(map, this.f21189a, this.f21190b, this.f21191c, c10));
        } catch (RuntimeException e10) {
            return y0.b.b(y8.k1.f19891h.r("failed to parse service config").q(e10));
        }
    }
}
