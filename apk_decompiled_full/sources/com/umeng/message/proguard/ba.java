package com.umeng.message.proguard;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ba extends c {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f11620b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final ad f11621c;

    /* renamed from: d, reason: collision with root package name */
    private long f11622d;

    public ba(ad adVar) {
        this.f11621c = adVar;
    }

    private StatusBarNotification a(NotificationManager notificationManager) {
        UMessage uMessage;
        StatusBarNotification[] activeNotifications;
        StatusBarNotification statusBarNotification;
        boolean z10;
        ad adVar = this.f11621c;
        if (adVar == null || (uMessage = adVar.f11454b) == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications != null && activeNotifications.length != 0) {
                int length = activeNotifications.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        statusBarNotification = null;
                        z10 = false;
                        break;
                    }
                    statusBarNotification = activeNotifications[i10];
                    if (TextUtils.equals(statusBarNotification.getTag(), "um") && statusBarNotification.getId() == this.f11621c.f11453a) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
                UPLog.i("Repost", "showing:", Boolean.valueOf(z10), "msgId:", uMessage.getMsgId());
                return statusBarNotification;
            }
            UPLog.i("Repost", "notification list null");
            return null;
        } catch (Throwable th) {
            UPLog.e("Repost", th);
            return null;
        }
    }

    @Override // com.umeng.message.proguard.c
    public final Future<?> b() {
        boolean z10;
        if (d()) {
            return this.f11695a;
        }
        ad adVar = this.f11621c;
        if (adVar == null) {
            return this.f11695a;
        }
        UMessage uMessage = adVar.f11454b;
        if (uMessage == null) {
            return this.f11695a;
        }
        long j10 = this.f11622d;
        if (j10 == 0) {
            this.f11622d = System.currentTimeMillis();
            z10 = true;
        } else {
            boolean a10 = f.a(j10);
            UPLog.i("Repost", "is today:", Boolean.valueOf(a10));
            if (!a10) {
                return this.f11695a;
            }
            z10 = false;
        }
        Application a11 = y.a();
        int p10 = MessageSharedPrefs.getInstance(a11).p();
        int o10 = MessageSharedPrefs.getInstance(a11).o();
        UPLog.i("Repost", "total times:", Integer.valueOf(p10), "config:", Integer.valueOf(o10));
        if (p10 >= o10) {
            return this.f11695a;
        }
        long repostStart = z10 ? uMessage.getRepostStart() : uMessage.getRepostInterval();
        this.f11695a = b.a(this, repostStart, TimeUnit.MINUTES);
        UPLog.i("Repost", "delay:", Long.valueOf(repostStart), "msgId:", uMessage.getMsgId());
        return this.f11695a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (f11620b) {
                if (this.f11621c == null) {
                    this.f11695a = null;
                    return;
                }
                boolean a10 = f.a(this.f11622d);
                UPLog.i("Repost", "is today:", Boolean.valueOf(a10));
                if (!a10) {
                    this.f11695a = null;
                    return;
                }
                Application a11 = y.a();
                NotificationManager notificationManager = (NotificationManager) a11.getSystemService("notification");
                if (notificationManager == null) {
                    this.f11695a = null;
                    UPLog.i("Repost", "mgr null!");
                    return;
                }
                StatusBarNotification a12 = a(notificationManager);
                if (a12 == null) {
                    this.f11695a = null;
                    UPLog.i("Repost", "sbn null! msgId:", this.f11621c.f11454b.getMsgId());
                    return;
                }
                int o10 = MessageSharedPrefs.getInstance(a11).o();
                int p10 = MessageSharedPrefs.getInstance(a11).p();
                UPLog.i("Repost", "task total times:", Integer.valueOf(p10), "config:", Integer.valueOf(o10));
                if (p10 >= o10) {
                    return;
                }
                Notification notification = a12.getNotification();
                if (notification != null) {
                    notificationManager.cancel("um", this.f11621c.f11453a);
                    notification.when = System.currentTimeMillis();
                    notificationManager.notify("um", this.f11621c.f11453a, notification);
                    this.f11695a = null;
                    this.f11621c.f11456d++;
                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                    Calendar calendar = Calendar.getInstance();
                    messageSharedPrefs.f11344b.a("re_pop_times", String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)), Integer.valueOf(p10 + 1)));
                    UTrack.getInstance().trackMsgRepost(this.f11621c.f11454b, notification);
                    UPLog.i("Repost", "show msgId:", this.f11621c.f11454b.getMsgId(), "count:", Integer.valueOf(this.f11621c.f11456d));
                    a();
                }
            }
        } catch (Throwable th) {
            UPLog.e("Repost", th);
        }
    }
}
