package a1;

import anet.channel.util.HttpConstant;

/* loaded from: classes.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final b.c f124a;

    /* renamed from: b, reason: collision with root package name */
    public static final b.C0003b f125b;

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public final Throwable f126a;

            public a(Throwable th) {
                this.f126a = th;
            }

            public Throwable a() {
                return this.f126a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f126a.getMessage());
            }
        }

        /* renamed from: a1.n$b$b, reason: collision with other inner class name */
        public static final class C0003b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            public C0003b() {
            }
        }

        public static final class c extends b {
            public String toString() {
                return HttpConstant.SUCCESS;
            }

            public c() {
            }
        }
    }

    static {
        f124a = new b.c();
        f125b = new b.C0003b();
    }
}
