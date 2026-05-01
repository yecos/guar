package com.umeng.message.proguard;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class r extends Service {
    private static final String TAG = "BaseService";
    private static final int sJobIndex = 21000;
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    b mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    private static final HashMap<Class<?>, Integer> sJobMap = new HashMap<>();
    private static final Object mRealTimeModeLock = new Object();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private r f12155a;

        public a(r rVar) {
            this.f12155a = rVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    e dequeueWork = this.f12155a.dequeueWork();
                    if (dequeueWork != null) {
                        UPLog.i(r.TAG, this.f12155a.getClass().getSimpleName(), "onHandleWork");
                        this.f12155a.onHandleWork(dequeueWork.a());
                        dequeueWork.b();
                    }
                } catch (Throwable th) {
                    UPLog.e(r.TAG, th);
                }
                try {
                    break;
                } catch (Throwable th2) {
                    UPLog.e(r.TAG, th2);
                }
            }
            this.f12155a.processorFinished();
            this.f12155a = null;
        }
    }

    public interface b {
        IBinder a();

        e b();
    }

    public final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f12161a;

        /* renamed from: b, reason: collision with root package name */
        final int f12162b;

        public d(Intent intent, int i10) {
            this.f12161a = intent;
            this.f12162b = i10;
        }

        @Override // com.umeng.message.proguard.r.e
        public final Intent a() {
            return this.f12161a;
        }

        @Override // com.umeng.message.proguard.r.e
        public final void b() {
            try {
                r.this.stopSelf(this.f12162b);
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }
    }

    public interface e {
        Intent a();

        void b();
    }

    public static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final r f12164a;

        /* renamed from: b, reason: collision with root package name */
        final Object f12165b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f12166c;

        public final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f12167a;

            public a(JobWorkItem jobWorkItem) {
                this.f12167a = jobWorkItem;
            }

            @Override // com.umeng.message.proguard.r.e
            public final Intent a() {
                Intent intent;
                intent = this.f12167a.getIntent();
                return intent;
            }

            @Override // com.umeng.message.proguard.r.e
            public final void b() {
                try {
                    synchronized (f.this.f12165b) {
                        JobParameters jobParameters = f.this.f12166c;
                        if (jobParameters != null) {
                            try {
                                jobParameters.completeWork(this.f12167a);
                            } catch (Throwable th) {
                                UPLog.e(r.TAG, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    UPLog.e(r.TAG, th2);
                }
            }
        }

        public f(r rVar) {
            super(rVar);
            this.f12165b = new Object();
            this.f12164a = rVar;
        }

        @Override // com.umeng.message.proguard.r.b
        public final IBinder a() {
            IBinder binder;
            binder = getBinder();
            return binder;
        }

        @Override // com.umeng.message.proguard.r.b
        public final e b() {
            JobWorkItem dequeueWork;
            Intent intent;
            try {
                synchronized (this.f12165b) {
                    JobParameters jobParameters = this.f12166c;
                    if (jobParameters == null) {
                        return null;
                    }
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    intent = dequeueWork.getIntent();
                    intent.setExtrasClassLoader(this.f12164a.getClassLoader());
                    return new a(dequeueWork);
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.f12166c = jobParameters;
            this.f12164a.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.f12164a.doStopCurrentWork();
            synchronized (this.f12165b) {
                this.f12166c = null;
            }
            return doStopCurrentWork;
        }
    }

    public static final class g extends h {

        /* renamed from: a, reason: collision with root package name */
        private final JobInfo f12169a;

        /* renamed from: b, reason: collision with root package name */
        private JobScheduler f12170b;

        public g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            JobInfo.Builder overrideDeadline;
            JobInfo build;
            a(i10);
            overrideDeadline = new JobInfo.Builder(i10, this.f12171c).setOverrideDeadline(0L);
            build = overrideDeadline.build();
            this.f12169a = build;
            try {
                this.f12170b = e1.v.a(context.getApplicationContext().getSystemService("jobscheduler"));
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.r.h
        public final void a(Intent intent) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f12170b.enqueue(this.f12169a, new JobWorkItem(intent));
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }
    }

    public static abstract class h {

        /* renamed from: c, reason: collision with root package name */
        final ComponentName f12171c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12172d;

        /* renamed from: e, reason: collision with root package name */
        int f12173e;

        public h(ComponentName componentName) {
            this.f12171c = componentName;
        }

        public void a() {
        }

        public abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }

        public final void a(int i10) {
            if (!this.f12172d) {
                this.f12172d = true;
                this.f12173e = i10;
            } else {
                if (this.f12173e == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f12173e);
            }
        }
    }

    public r() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    private static void enqueueWork(Context context, Class<?> cls, int i10, Intent intent) {
        if (context == null || cls == null || intent == null) {
            return;
        }
        try {
            enqueueWork(context, new ComponentName(context, cls), i10, intent);
        } catch (Throwable th) {
            UPLog.e(TAG, "jobId:", Integer.valueOf(i10), "failed:", th.getMessage());
        }
    }

    public static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z10, int i10) {
        h cVar;
        HashMap<ComponentName, h> hashMap = sClassWorkEnqueuer;
        h hVar = hashMap.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z10) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i10);
        }
        h hVar2 = cVar;
        hashMap.put(componentName, hVar2);
        return hVar2;
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJobImpl = new f(this);
                this.mCompatWorkEnqueuer = null;
            } else {
                this.mJobImpl = null;
                this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public e dequeueWork() {
        d remove;
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.b();
        }
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            remove = this.mCompatQueue.size() > 0 ? this.mCompatQueue.remove(0) : null;
        }
        return remove;
    }

    public boolean doStopCurrentWork() {
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean z10) {
        try {
            if (this.mCurProcessor == null) {
                this.mCurProcessor = new a(this);
                h hVar = this.mCompatWorkEnqueuer;
                if (hVar != null && z10) {
                    hVar.b();
                }
                com.umeng.message.proguard.b.a(this.mCurProcessor);
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            b bVar = this.mJobImpl;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        } catch (Throwable th) {
            UPLog.e(TAG, th);
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (arrayList != null) {
                synchronized (arrayList) {
                    this.mDestroyed = true;
                    this.mCompatWorkEnqueuer.c();
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void onHandleWork(Intent intent) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent != null) {
            try {
                if (this.mCompatQueue == null) {
                    return 2;
                }
                if (this.mCompatWorkEnqueuer == null) {
                    init();
                }
                this.mCompatWorkEnqueuer.a();
                synchronized (this.mCompatQueue) {
                    this.mCompatQueue.add(new d(intent, i11));
                    ensureProcessorRunningLocked(true);
                }
                return 3;
            } catch (Throwable th) {
                UPLog.e(TAG, th);
            }
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void processorFinished() {
        try {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (arrayList != null) {
                synchronized (arrayList) {
                    this.mCurProcessor = null;
                    if (this.mCompatQueue.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.c();
                    }
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void setInterruptIfStopped(boolean z10) {
        this.mInterruptIfStopped = z10;
    }

    private static void enqueueWork(final Context context, final ComponentName componentName, final int i10, final Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        if (context == null || componentName == null) {
            return;
        }
        com.umeng.message.proguard.b.c(new Runnable() { // from class: com.umeng.message.proguard.r.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (r.sLock) {
                    h workEnqueuer = r.getWorkEnqueuer(context, componentName, true, i10);
                    workEnqueuer.a(i10);
                    workEnqueuer.a(intent);
                }
            }
        });
    }

    public static <T extends r> void enqueueWork(Context context, Class<T> cls, Intent intent) {
        int intValue;
        synchronized (mRealTimeModeLock) {
            if (context == null || cls == null || intent == null) {
                return;
            }
            UPLog.i(TAG, "enqueue cls:", cls.getSimpleName());
            HashMap<Class<?>, Integer> hashMap = sJobMap;
            if (!hashMap.containsKey(cls)) {
                intValue = hashMap.size() + sJobIndex;
                hashMap.put(cls, Integer.valueOf(intValue));
            } else {
                Integer num = hashMap.get(cls);
                if (num == null) {
                    return;
                } else {
                    intValue = num.intValue();
                }
            }
            UPLog.i(TAG, "jobId:", Integer.valueOf(intValue));
            enqueueWork(context, (Class<?>) cls, intValue, intent);
        }
    }

    public static final class c extends h {

        /* renamed from: a, reason: collision with root package name */
        boolean f12156a;

        /* renamed from: b, reason: collision with root package name */
        boolean f12157b;

        /* renamed from: f, reason: collision with root package name */
        private final Context f12158f;

        /* renamed from: g, reason: collision with root package name */
        private final PowerManager.WakeLock f12159g;

        /* renamed from: h, reason: collision with root package name */
        private final PowerManager.WakeLock f12160h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f12158f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f12159g = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f12160h = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // com.umeng.message.proguard.r.h
        public final void a(Intent intent) {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.f12171c);
                if (this.f12158f.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.f12156a) {
                            this.f12156a = true;
                            if (!this.f12157b) {
                                this.f12159g.acquire(60000L);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.r.h
        public final void b() {
            try {
                synchronized (this) {
                    if (!this.f12157b) {
                        this.f12157b = true;
                        this.f12160h.acquire(600000L);
                        this.f12159g.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.r.h
        public final void c() {
            try {
                synchronized (this) {
                    if (this.f12157b) {
                        if (this.f12156a) {
                            this.f12159g.acquire(60000L);
                        }
                        this.f12157b = false;
                        this.f12160h.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(r.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.r.h
        public final void a() {
            synchronized (this) {
                this.f12156a = false;
            }
        }
    }
}
