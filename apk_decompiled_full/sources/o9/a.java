package o9;

import t9.i;

/* loaded from: classes3.dex */
public class a extends n9.a {

    /* renamed from: o9.a$a, reason: collision with other inner class name */
    public static final class C0303a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0303a f17667a = new C0303a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f17668b;

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
                f17668b = num2;
            }
            num = null;
            if (num != null) {
            }
            f17668b = num2;
        }
    }

    @Override // n9.a
    public void a(Throwable th, Throwable th2) {
        i.g(th, "cause");
        i.g(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }

    public final boolean c(int i10) {
        Integer num = C0303a.f17668b;
        return num == null || num.intValue() >= i10;
    }
}
