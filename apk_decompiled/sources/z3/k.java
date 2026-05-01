package z3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final t3.a f20182a;

    /* renamed from: b, reason: collision with root package name */
    public static final k3.v f20183b;

    /* renamed from: c, reason: collision with root package name */
    public static final k3.v f20184c;

    /* renamed from: d, reason: collision with root package name */
    public static final k3.u f20185d;

    static {
        t3.a aVar = new t3.a();
        f20182a = aVar;
        f20183b = aVar.D();
        f20184c = aVar.D().k();
        f20185d = aVar.A(k3.m.class);
    }

    public static String a(k3.m mVar) {
        try {
            return f20183b.n(mVar);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
