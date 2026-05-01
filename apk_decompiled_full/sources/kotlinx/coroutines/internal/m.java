package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f15755a = new y("CONDITION_FALSE");

    /* renamed from: b, reason: collision with root package name */
    public static final Object f15756b = new y("LIST_EMPTY");

    public static final Object a() {
        return f15755a;
    }

    public static final n b(Object obj) {
        n nVar;
        v vVar = obj instanceof v ? (v) obj : null;
        return (vVar == null || (nVar = vVar.f15778a) == null) ? (n) obj : nVar;
    }
}
