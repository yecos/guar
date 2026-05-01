package j6;

/* loaded from: classes3.dex */
public interface a extends l5.a {

    /* renamed from: j6.a$a, reason: collision with other inner class name */
    public static final class C0239a {
        public static /* synthetic */ void a(a aVar, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCouponsData");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            aVar.f(str);
        }
    }

    void f(String str);
}
