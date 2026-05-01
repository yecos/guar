package o3;

import java.io.Serializable;

/* loaded from: classes.dex */
public class q implements n3.q, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final q f17556c = new q(null);

    /* renamed from: d, reason: collision with root package name */
    public static final q f17557d = new q(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f17558a;

    /* renamed from: b, reason: collision with root package name */
    public final d4.a f17559b;

    public q(Object obj) {
        this.f17558a = obj;
        this.f17559b = obj == null ? d4.a.ALWAYS_NULL : d4.a.CONSTANT;
    }

    public static q a(Object obj) {
        return obj == null ? f17557d : new q(obj);
    }

    public static boolean b(n3.q qVar) {
        return qVar == f17556c;
    }

    public static q c() {
        return f17557d;
    }

    public static q d() {
        return f17556c;
    }

    @Override // n3.q
    public Object getNullValue(k3.g gVar) {
        return this.f17558a;
    }
}
