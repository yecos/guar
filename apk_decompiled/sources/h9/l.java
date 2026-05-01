package h9;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class l implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14231a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f14232a;

        public b(Throwable th) {
            t9.i.g(th, "exception");
            this.f14232a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && t9.i.b(this.f14232a, ((b) obj).f14232a);
        }

        public int hashCode() {
            return this.f14232a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f14232a + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f14232a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
