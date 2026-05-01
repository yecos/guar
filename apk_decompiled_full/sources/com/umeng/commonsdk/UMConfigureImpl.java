package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class UMConfigureImpl {

    /* renamed from: e, reason: collision with root package name */
    private static final int f10743e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f10744f;

    /* renamed from: g, reason: collision with root package name */
    private static Context f10745g;

    /* renamed from: a, reason: collision with root package name */
    private static String f10739a = bd.b().b(bd.f9988o);

    /* renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f10740b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static int f10741c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f10742d = false;

    /* renamed from: h, reason: collision with root package name */
    private static int f10746h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static Runnable f10747i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f10741c == 0 || UMConfigureImpl.f10746h >= 10) {
                    if (!UMConfigureImpl.f10742d) {
                        boolean unused = UMConfigureImpl.f10742d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f10745g);
                    }
                    if (UMConfigureImpl.f10744f != null) {
                        UMConfigureImpl.f10744f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f10744f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    public static /* synthetic */ int f() {
        int i10 = f10746h;
        f10746h = i10 + 1;
        return i10;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f10745g = context;
        try {
            if (f10741c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f10744f == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f10744f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(f10747i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f10741c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f10740b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f10740b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f10740b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f10741c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f10740b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f10740b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f10740b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f10739a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f10739a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f10739a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f10739a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
