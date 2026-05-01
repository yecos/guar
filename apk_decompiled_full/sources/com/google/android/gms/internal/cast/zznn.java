package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class zznn<V> extends zznp implements ListenableFuture<V> {
    private static final boolean zza;
    private static final Logger zzb;
    private static final zza zzc;
    private static final Object zzd;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzk waiters;

    abstract class zza {
        public /* synthetic */ zza(AnonymousClass1 anonymousClass1) {
        }

        public abstract void zza(zzk zzkVar, @CheckForNull zzk zzkVar2);

        public abstract void zzb(zzk zzkVar, Thread thread);

        public abstract boolean zzc(zznn<?> zznnVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        public abstract boolean zzd(zznn<?> zznnVar, @CheckForNull Object obj, Object obj2);

        public abstract boolean zze(zznn<?> zznnVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2);
    }

    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zznn.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        public zzb(boolean z10, @CheckForNull Throwable th) {
            this.zzc = z10;
            this.zzd = th;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.cast.zznn.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zznn, zzk> zzc;
        final AtomicReferenceFieldUpdater<zznn, zzd> zzd;
        final AtomicReferenceFieldUpdater<zznn, Object> zze;

        public zze(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zznn, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zznn, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zznn, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zza(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zzb(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzc(zznn<?> zznnVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return androidx.concurrent.futures.b.a(this.zzd, zznnVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzd(zznn<?> zznnVar, @CheckForNull Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.zze, zznnVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zze(zznn<?> zznnVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return androidx.concurrent.futures.b.a(this.zzc, zznnVar, zzkVar, zzkVar2);
        }
    }

    final class zzf<V> implements Runnable {
        final zznn<V> zza;
        final ListenableFuture<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    final class zzg extends zza {
        public /* synthetic */ zzg(AnonymousClass1 anonymousClass1) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zza(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zzb(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzc(zznn<?> zznnVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zznnVar) {
                if (((zznn) zznnVar).listeners != zzdVar) {
                    return false;
                }
                ((zznn) zznnVar).listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzd(zznn<?> zznnVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zznnVar) {
                if (((zznn) zznnVar).value != obj) {
                    return false;
                }
                ((zznn) zznnVar).value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zze(zznn<?> zznnVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            synchronized (zznnVar) {
                if (((zznn) zznnVar).waiters != zzkVar) {
                    return false;
                }
                ((zznn) zznnVar).waiters = zzkVar2;
                return true;
            }
        }

        private zzg() {
            super(null);
        }
    }

    interface zzh<V> extends ListenableFuture<V> {
    }

    abstract class zzi<V> extends zznn<V> implements zzh<V> {
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.cast.zznn.zzj.1
                    public static final Unsafe zza() {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }

                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() {
                        return zza();
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zznn.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zznn.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zznn.class.getDeclaredField("value"));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (Exception e11) {
                zzdm.zza(e11);
                throw new RuntimeException(e11);
            }
        }

        public /* synthetic */ zzj(AnonymousClass1 anonymousClass1) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zza(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final void zzb(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzc(zznn<?> zznnVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return b.a(zza, zznnVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zzd(zznn<?> zznnVar, @CheckForNull Object obj, Object obj2) {
            return b.a(zza, zznnVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.cast.zznn.zza
        public final boolean zze(zznn<?> zznnVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return b.a(zza, zznnVar, zzc, zzkVar, zzkVar2);
        }

        private zzj() {
            super(null);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);

        @CheckForNull
        volatile zzk next;

        @CheckForNull
        volatile Thread thread;

        public zzk() {
            zznn.zzc.zzb(this, Thread.currentThread());
        }

        public zzk(boolean z10) {
        }
    }

    static {
        boolean z10;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        zza = z10;
        zzb = Logger.getLogger(zznn.class.getName());
        AnonymousClass1 anonymousClass1 = null;
        try {
            zzgVar = new zzj(anonymousClass1);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th = null;
                th2 = th3;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zznn.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zznn.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zznn.class, Object.class, "value"));
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                zzgVar = new zzg(anonymousClass1);
            }
        }
        zzc = zzgVar;
        if (th != null) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzk(ListenableFuture<?> listenableFuture) {
        Throwable zzh2;
        if (listenableFuture instanceof zzh) {
            Object obj = ((zznn) listenableFuture).value;
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (zzbVar.zzc) {
                    Throwable th = zzbVar.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        }
        if ((listenableFuture instanceof zznp) && (zzh2 = ((zznp) listenableFuture).zzh()) != null) {
            return new zzc(zzh2);
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!zza) && isCancelled) {
            zzb zzbVar2 = zzb.zzb;
            zzbVar2.getClass();
            return zzbVar2;
        }
        try {
            Object zzl = zzl(listenableFuture);
            if (!isCancelled) {
                return zzl == null ? zzd : zzl;
            }
            String valueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(valueOf.length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(valueOf);
            return new zzb(false, new IllegalArgumentException(sb.toString()));
        } catch (CancellationException e10) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e10)) : new zzb(false, e10);
        } catch (ExecutionException e11) {
            return isCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e11)) : new zzc(e11.getCause());
        } catch (Throwable th2) {
            return new zzc(th2);
        }
    }

    private static <V> V zzl(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private final void zzm(StringBuilder sb) {
        try {
            Object zzl = zzl(this);
            sb.append("SUCCESS, result=[");
            if (zzl == null) {
                sb.append("null");
            } else if (zzl == this) {
                sb.append("this future");
            } else {
                sb.append(zzl.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzl)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb.append("FAILURE, cause=[");
            sb.append(e11.getCause());
            sb.append("]");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzn(StringBuilder sb) {
        String concat;
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzo(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("remaining delay=[");
                    sb2.append(delay);
                    sb2.append(" ms]");
                    str = sb2.toString();
                } else {
                    str = null;
                }
                concat = zzdl.zza(str);
            } catch (RuntimeException | StackOverflowError e10) {
                concat = "Exception thrown from implementation: ".concat(String.valueOf(e10.getClass()));
            }
            if (concat != null) {
                sb.append(", info=[");
                sb.append(concat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzm(sb);
        }
    }

    private final void zzo(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e10) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e10.getClass());
        }
    }

    private static void zzp(zznn<?> zznnVar) {
        zzd zzdVar;
        zzd zzdVar2;
        zzd zzdVar3 = null;
        while (true) {
            zzk zzkVar = ((zznn) zznnVar).waiters;
            if (zzc.zze(zznnVar, zzkVar, zzk.zza)) {
                while (zzkVar != null) {
                    Thread thread = zzkVar.thread;
                    if (thread != null) {
                        zzkVar.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzkVar = zzkVar.next;
                }
                do {
                    zzdVar = ((zznn) zznnVar).listeners;
                } while (!zzc.zzc(zznnVar, zzdVar, zzd.zza));
                while (true) {
                    zzdVar2 = zzdVar3;
                    zzdVar3 = zzdVar;
                    if (zzdVar3 == null) {
                        break;
                    }
                    zzdVar = zzdVar3.next;
                    zzdVar3.next = zzdVar2;
                }
                while (zzdVar2 != null) {
                    zzdVar3 = zzdVar2.next;
                    Runnable runnable = zzdVar2.zzb;
                    runnable.getClass();
                    if (runnable instanceof zzf) {
                        zzf zzfVar = (zzf) runnable;
                        zznnVar = zzfVar.zza;
                        if (((zznn) zznnVar).value == zzfVar) {
                            if (zzc.zzd(zznnVar, zzfVar, zzk(zzfVar.zzb))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = zzdVar2.zzc;
                        executor.getClass();
                        zzq(runnable, executor);
                    }
                    zzdVar2 = zzdVar3;
                }
                return;
            }
        }
    }

    private static void zzq(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e10);
        }
    }

    private final void zzr(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zze(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final V zzs(Object obj) {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzdj.zzc(runnable, "Runnable was null.");
        zzdj.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zzc(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzq(runnable, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean cancel(boolean z10) {
        zzb zzbVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zzf)) {
            return false;
        }
        if (zza) {
            zzbVar = new zzb(z10, new CancellationException("Future.cancel() was called."));
        } else {
            zzbVar = z10 ? zzb.zza : zzb.zzb;
            zzbVar.getClass();
        }
        boolean z11 = false;
        zznn<V> zznnVar = this;
        while (true) {
            if (zzc.zzd(zznnVar, obj, zzbVar)) {
                zzp(zznnVar);
                if (!(obj instanceof zzf)) {
                    break;
                }
                ListenableFuture<? extends V> listenableFuture = ((zzf) obj).zzb;
                if (!(listenableFuture instanceof zzh)) {
                    listenableFuture.cancel(z10);
                    break;
                }
                zznnVar = (zznn) listenableFuture;
                obj = zznnVar.value;
                if (!(obj == null) && !(obj instanceof zzf)) {
                    break;
                }
                z11 = true;
            } else {
                obj = zznnVar.value;
                if (!(obj instanceof zzf)) {
                    return z11;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return (V) zzs(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzc;
                zzaVar.zza(zzkVar2, zzkVar);
                if (zzaVar.zze(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzr(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return (V) zzs(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        obj3.getClass();
        return (V) zzs(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof zzf)) & (this.value != null);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzm(sb);
        } else {
            zzn(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.cast.zznp
    @CheckForNull
    public final Throwable zzh() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public boolean zzj(V v10) {
        if (!zzc.zzd(this, null, zzd)) {
            return false;
        }
        zzp(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z10 = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return (V) zzs(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zzc;
                        zzaVar.zza(zzkVar2, zzkVar);
                        if (zzaVar.zze(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return (V) zzs(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzr(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzr(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return (V) zzs(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof zzf))) {
                    return (V) zzs(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zznnVar = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j10);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = sb2.concat(" (plus ");
                long j11 = -nanos;
                long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z10 = false;
                }
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z10) {
                        sb4 = sb4.concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z10) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + zznnVar.length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zznnVar);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }
}
