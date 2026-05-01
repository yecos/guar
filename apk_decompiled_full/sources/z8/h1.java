package z8;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class h1 extends l0 {

    /* renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f20633c = new ReferenceQueue();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f20634d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f20635e = Logger.getLogger(h1.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final a f20636b;

    public static final class a extends WeakReference {

        /* renamed from: f, reason: collision with root package name */
        public static final boolean f20637f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: g, reason: collision with root package name */
        public static final RuntimeException f20638g = c();

        /* renamed from: a, reason: collision with root package name */
        public final ReferenceQueue f20639a;

        /* renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f20640b;

        /* renamed from: c, reason: collision with root package name */
        public final String f20641c;

        /* renamed from: d, reason: collision with root package name */
        public final Reference f20642d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f20643e;

        public a(h1 h1Var, y8.r0 r0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(h1Var, referenceQueue);
            this.f20643e = new AtomicBoolean();
            this.f20642d = new SoftReference(f20637f ? new RuntimeException("ManagedChannel allocation site") : f20638g);
            this.f20641c = r0Var.toString();
            this.f20639a = referenceQueue;
            this.f20640b = concurrentMap;
            concurrentMap.put(this, this);
            a(referenceQueue);
        }

        public static int a(ReferenceQueue referenceQueue) {
            int i10 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i10;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f20642d.get();
                aVar.b();
                if (!aVar.f20643e.get()) {
                    i10++;
                    Level level = Level.SEVERE;
                    if (h1.f20635e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        logRecord.setLoggerName(h1.f20635e.getName());
                        logRecord.setParameters(new Object[]{aVar.f20641c});
                        logRecord.setThrown(runtimeException);
                        h1.f20635e.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException c() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void b() {
            super.clear();
            this.f20640b.remove(this);
            this.f20642d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            b();
            a(this.f20639a);
        }
    }

    public h1(y8.r0 r0Var) {
        this(r0Var, f20633c, f20634d);
    }

    public h1(y8.r0 r0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(r0Var);
        this.f20636b = new a(this, r0Var, referenceQueue, concurrentMap);
    }
}
