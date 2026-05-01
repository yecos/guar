package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/* loaded from: classes.dex */
final class d implements UMMemoryMonitorApi {
    private boolean A;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6324u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6325v = true;

    /* renamed from: w, reason: collision with root package name */
    private b f6326w;

    /* renamed from: x, reason: collision with root package name */
    private WeakReference<Activity> f6327x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6328y;

    /* renamed from: z, reason: collision with root package name */
    private int f6329z;

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final String getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f6327x;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getName();
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isEnable() {
        b bVar;
        return this.f6325v && (bVar = this.f6326w) != null && bVar.f6302b;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isForeground() {
        return this.f6328y;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityResumed(Activity activity) {
        if (this.f6325v) {
            this.f6327x = new WeakReference<>(activity);
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStarted(Activity activity) {
        if (this.f6325v && activity != null) {
            if (this.A) {
                this.A = false;
                return;
            }
            int i10 = this.f6329z + 1;
            this.f6329z = i10;
            if (i10 == 1) {
                this.f6328y = true;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStopped(Activity activity) {
        if (this.f6325v && activity != null) {
            if (activity.isChangingConfigurations()) {
                this.A = true;
                return;
            }
            int i10 = this.f6329z - 1;
            this.f6329z = i10;
            if (i10 == 0) {
                this.f6328y = false;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void setEnable(boolean z10) {
        this.f6325v = z10;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void start(Context context, EfsReporter efsReporter) {
        if ((this.f6325v || IntegrationTestingUtil.isIntegrationTestingInPeriod()) && !this.f6324u) {
            this.f6324u = true;
            final b bVar = new b(context, efsReporter);
            this.f6326w = bVar;
            bVar.f6301a.getAllSdkConfig(new String[]{"apm_memperf_sampling_rate", "apm_memperf_collect_interval", "apm_memperf_collect_max_period_sec"}, new IConfigCallback() { // from class: com.efs.sdk.memoryinfo.b.1

                /* renamed from: com.efs.sdk.memoryinfo.b$1$1 */
                public class HandlerC00951 extends Handler {

                    /* renamed from: d */
                    final /* synthetic */ HandlerThread f6304d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public HandlerC00951(Looper looper, HandlerThread handlerThread) {
                        super(looper);
                        r3 = handlerThread;
                    }

                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message.what == 1) {
                            try {
                                r3.quit();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }

                /* renamed from: com.efs.sdk.memoryinfo.b$1$2 */
                public class AnonymousClass2 implements Runnable {

                    /* renamed from: f */
                    final /* synthetic */ Handler f6307f;

                    /* renamed from: g */
                    final /* synthetic */ int f6308g;

                    /* renamed from: h */
                    final /* synthetic */ int f6309h;

                    public AnonymousClass2(Handler handler, int i10, int i11) {
                        r2 = handler;
                        r3 = i10;
                        r4 = i11;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            String lowerCase = UMUtils.MD5(Process.myPid() + uuid).toLowerCase();
                            b bVar = b.this;
                            Handler handler = r2;
                            handler.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2

                                /* renamed from: f */
                                final /* synthetic */ Handler f6311f;

                                /* renamed from: i */
                                final /* synthetic */ long f6312i;

                                /* renamed from: j */
                                final /* synthetic */ int f6313j;

                                /* renamed from: k */
                                final /* synthetic */ e f6314k;

                                /* renamed from: l */
                                final /* synthetic */ String f6315l;

                                /* renamed from: m */
                                final /* synthetic */ int f6316m;

                                public AnonymousClass2(long j10, int i10, Handler handler2, e eVar, String lowerCase2, int i11) {
                                    r2 = j10;
                                    r4 = i10;
                                    r5 = handler2;
                                    r6 = eVar;
                                    r7 = lowerCase2;
                                    r8 = i11;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (SystemClock.elapsedRealtime() - r2 > r4 * 1000) {
                                        r5.sendEmptyMessage(1);
                                        return;
                                    }
                                    try {
                                        b.a(b.this, r6, r7);
                                    } catch (Throwable th) {
                                        f.a("collect ", th);
                                    }
                                    r5.postDelayed(this, r8 * 1000);
                                }
                            });
                        } catch (Throwable unused) {
                            r2.sendEmptyMessage(1);
                        }
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    Object obj;
                    boolean z10;
                    Object obj2;
                    Object obj3;
                    try {
                        if (b.this.f6302b || (obj = map.get("apm_memperf_sampling_rate")) == null) {
                            return;
                        }
                        int parseInt = Integer.parseInt(obj.toString());
                        if (parseInt == 0 || (parseInt != 100 && !SamplingWhiteListUtil.isHitWL() && new Random().nextInt(100) > parseInt)) {
                            z10 = false;
                            if ((z10 && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) || (obj2 = map.get("apm_memperf_collect_interval")) == null || (obj3 = map.get("apm_memperf_collect_max_period_sec")) == null) {
                                return;
                            }
                            int parseInt2 = Integer.parseInt(obj2.toString());
                            int parseInt3 = Integer.parseInt(obj3.toString());
                            HandlerThread handlerThread = new HandlerThread("mem-info");
                            handlerThread.start();
                            HandlerC00951 handlerC00951 = new Handler(handlerThread.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1

                                /* renamed from: d */
                                final /* synthetic */ HandlerThread f6304d;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public HandlerC00951(Looper looper, HandlerThread handlerThread2) {
                                    super(looper);
                                    r3 = handlerThread2;
                                }

                                @Override // android.os.Handler
                                public final void handleMessage(Message message) {
                                    super.handleMessage(message);
                                    if (message.what == 1) {
                                        try {
                                            r3.quit();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            };
                            handlerC00951.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2

                                /* renamed from: f */
                                final /* synthetic */ Handler f6307f;

                                /* renamed from: g */
                                final /* synthetic */ int f6308g;

                                /* renamed from: h */
                                final /* synthetic */ int f6309h;

                                public AnonymousClass2(Handler handlerC009512, int parseInt22, int parseInt32) {
                                    r2 = handlerC009512;
                                    r3 = parseInt22;
                                    r4 = parseInt32;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        String uuid = UUID.randomUUID().toString();
                                        String lowerCase2 = UMUtils.MD5(Process.myPid() + uuid).toLowerCase();
                                        b bVar2 = b.this;
                                        Handler handler2 = r2;
                                        handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2

                                            /* renamed from: f */
                                            final /* synthetic */ Handler f6311f;

                                            /* renamed from: i */
                                            final /* synthetic */ long f6312i;

                                            /* renamed from: j */
                                            final /* synthetic */ int f6313j;

                                            /* renamed from: k */
                                            final /* synthetic */ e f6314k;

                                            /* renamed from: l */
                                            final /* synthetic */ String f6315l;

                                            /* renamed from: m */
                                            final /* synthetic */ int f6316m;

                                            public AnonymousClass2(long j10, int i10, Handler handler22, e eVar, String lowerCase22, int i11) {
                                                r2 = j10;
                                                r4 = i10;
                                                r5 = handler22;
                                                r6 = eVar;
                                                r7 = lowerCase22;
                                                r8 = i11;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (SystemClock.elapsedRealtime() - r2 > r4 * 1000) {
                                                    r5.sendEmptyMessage(1);
                                                    return;
                                                }
                                                try {
                                                    b.a(b.this, r6, r7);
                                                } catch (Throwable th) {
                                                    f.a("collect ", th);
                                                }
                                                r5.postDelayed(this, r8 * 1000);
                                            }
                                        });
                                    } catch (Throwable unused) {
                                        r2.sendEmptyMessage(1);
                                    }
                                }
                            });
                            b.this.f6302b = true;
                        }
                        z10 = true;
                        if (z10) {
                        }
                        int parseInt22 = Integer.parseInt(obj2.toString());
                        int parseInt32 = Integer.parseInt(obj3.toString());
                        HandlerThread handlerThread2 = new HandlerThread("mem-info");
                        handlerThread2.start();
                        Handler handlerC009512 = new Handler(handlerThread2.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1

                            /* renamed from: d */
                            final /* synthetic */ HandlerThread f6304d;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public HandlerC00951(Looper looper, HandlerThread handlerThread22) {
                                super(looper);
                                r3 = handlerThread22;
                            }

                            @Override // android.os.Handler
                            public final void handleMessage(Message message) {
                                super.handleMessage(message);
                                if (message.what == 1) {
                                    try {
                                        r3.quit();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        };
                        handlerC009512.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2

                            /* renamed from: f */
                            final /* synthetic */ Handler f6307f;

                            /* renamed from: g */
                            final /* synthetic */ int f6308g;

                            /* renamed from: h */
                            final /* synthetic */ int f6309h;

                            public AnonymousClass2(Handler handlerC0095122, int parseInt222, int parseInt322) {
                                r2 = handlerC0095122;
                                r3 = parseInt222;
                                r4 = parseInt322;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    String uuid = UUID.randomUUID().toString();
                                    String lowerCase22 = UMUtils.MD5(Process.myPid() + uuid).toLowerCase();
                                    b bVar2 = b.this;
                                    Handler handler22 = r2;
                                    handler22.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2

                                        /* renamed from: f */
                                        final /* synthetic */ Handler f6311f;

                                        /* renamed from: i */
                                        final /* synthetic */ long f6312i;

                                        /* renamed from: j */
                                        final /* synthetic */ int f6313j;

                                        /* renamed from: k */
                                        final /* synthetic */ e f6314k;

                                        /* renamed from: l */
                                        final /* synthetic */ String f6315l;

                                        /* renamed from: m */
                                        final /* synthetic */ int f6316m;

                                        public AnonymousClass2(long j10, int i10, Handler handler222, e eVar, String lowerCase222, int i11) {
                                            r2 = j10;
                                            r4 = i10;
                                            r5 = handler222;
                                            r6 = eVar;
                                            r7 = lowerCase222;
                                            r8 = i11;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            if (SystemClock.elapsedRealtime() - r2 > r4 * 1000) {
                                                r5.sendEmptyMessage(1);
                                                return;
                                            }
                                            try {
                                                b.a(b.this, r6, r7);
                                            } catch (Throwable th) {
                                                f.a("collect ", th);
                                            }
                                            r5.postDelayed(this, r8 * 1000);
                                        }
                                    });
                                } catch (Throwable unused) {
                                    r2.sendEmptyMessage(1);
                                }
                            }
                        });
                        b.this.f6302b = true;
                    } catch (Throwable th) {
                        f.a("collect ", th);
                    }
                }
            });
        }
    }
}
