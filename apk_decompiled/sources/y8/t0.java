package y8;

/* loaded from: classes3.dex */
public abstract class t0 {

    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static t0 d() {
        t0 d10 = u0.b().d();
        if (d10 != null) {
            return d10;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract s0 a(String str);

    public abstract boolean b();

    public abstract int c();
}
