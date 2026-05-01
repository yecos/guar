package p9;

import w9.c;
import x9.b;

/* loaded from: classes3.dex */
public class a extends o9.a {

    /* renamed from: p9.a$a, reason: collision with other inner class name */
    public static final class C0310a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0310a f18072a = new C0310a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f18073b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null) {
                    if (num.intValue() > 0) {
                        num2 = num;
                    }
                }
                f18073b = num2;
            }
            num = null;
            if (num != null) {
            }
            f18073b = num2;
        }
    }

    private final boolean c(int i10) {
        Integer num = C0310a.f18073b;
        return num == null || num.intValue() >= i10;
    }

    @Override // n9.a
    public c b() {
        return c(34) ? new b() : super.b();
    }
}
