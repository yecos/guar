package y8;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f20005b = Logger.getLogger(r.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final r f20006c = new r();

    /* renamed from: a, reason: collision with root package name */
    public final int f20007a = 0;

    public interface a {
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f20008a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f20008a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                r.f20005b.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static c a(AtomicReference atomicReference) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e10) {
                atomicReference.set(e10);
                return new p1();
            } catch (Exception e11) {
                throw new RuntimeException("Storage override failed to initialize", e11);
            }
        }
    }

    public static abstract class c {
        public abstract r a();

        public abstract void b(r rVar, r rVar2);

        public abstract r c(r rVar);
    }

    public r() {
        k(0);
    }

    public static Object d(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static r e() {
        r a10 = j().a();
        return a10 == null ? f20006c : a10;
    }

    public static c j() {
        return b.f20008a;
    }

    public static void k(int i10) {
        if (i10 == 1000) {
            f20005b.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void a(a aVar, Executor executor) {
        d(aVar, "cancellationListener");
        d(executor, "executor");
    }

    public r b() {
        r c10 = j().c(this);
        return c10 == null ? f20006c : c10;
    }

    public Throwable c() {
        return null;
    }

    public void f(r rVar) {
        d(rVar, "toAttach");
        j().b(this, rVar);
    }

    public t g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(a aVar) {
    }
}
