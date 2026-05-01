package q5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.taobao.accs.common.Constants;
import java.util.List;
import o.i1;
import o.s;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f18197a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f18198b = {"channel_system", "channel_activity", "channel_content", "channel_upgrade"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f18199c = {"System message", "Activity message", "Content message", "Upgrade message"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f18200d = {"System message", "Activity message", "Content message", "Upgrade message"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f18201e = {"channel_upgrade"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f18202f = {"Upgrade message"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f18203g = {"Upgrade message"};

    /* renamed from: h, reason: collision with root package name */
    public static int f18204h = 1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18205a;

        /* renamed from: b, reason: collision with root package name */
        public int f18206b;

        /* renamed from: c, reason: collision with root package name */
        public Context f18207c;

        /* renamed from: e, reason: collision with root package name */
        public int f18209e;

        /* renamed from: f, reason: collision with root package name */
        public Intent f18210f;

        /* renamed from: g, reason: collision with root package name */
        public int f18211g;

        /* renamed from: j, reason: collision with root package name */
        public int f18214j;

        /* renamed from: d, reason: collision with root package name */
        public String f18208d = "";

        /* renamed from: h, reason: collision with root package name */
        public String f18212h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f18213i = "";

        /* renamed from: k, reason: collision with root package name */
        public boolean f18215k = true;

        /* renamed from: l, reason: collision with root package name */
        public String f18216l = "event";

        /* renamed from: m, reason: collision with root package name */
        public boolean f18217m = true;

        /* renamed from: n, reason: collision with root package name */
        public boolean f18218n = true;

        public final Notification a() {
            return i.f18197a.h(this);
        }

        public final boolean b() {
            return this.f18217m;
        }

        public final String c() {
            return this.f18216l;
        }

        public final String d() {
            return this.f18208d;
        }

        public final String e() {
            return this.f18213i;
        }

        public final Context f() {
            return this.f18207c;
        }

        public final int g() {
            return this.f18206b;
        }

        public final Intent h() {
            return this.f18210f;
        }

        public final int i() {
            return this.f18211g;
        }

        public final boolean j() {
            return this.f18218n;
        }

        public final int k() {
            return this.f18209e;
        }

        public final boolean l() {
            return this.f18215k;
        }

        public final int m() {
            return this.f18214j;
        }

        public final String n() {
            return this.f18212h;
        }

        public final boolean o() {
            return this.f18205a;
        }

        public final a p(boolean z10) {
            this.f18217m = z10;
            return this;
        }

        public final a q(String str) {
            t9.i.g(str, "category");
            this.f18216l = str;
            return this;
        }

        public final a r(int i10) {
            this.f18208d = i.f18197a.i(i10);
            return this;
        }

        public final a s(Context context) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            this.f18207c = context;
            return this;
        }

        public final a t(int i10) {
            this.f18206b = i10;
            return this;
        }

        public final a u(boolean z10) {
            this.f18205a = z10;
            return this;
        }

        public final a v(int i10) {
            this.f18211g = i10;
            return this;
        }

        public final a w(boolean z10) {
            this.f18218n = z10;
            return this;
        }

        public final a x(int i10) {
            this.f18214j = i10;
            return this;
        }
    }

    public final void c(Context context, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i10);
    }

    public final void d(Context context, String str, String[] strArr, String[] strArr2, String[] strArr3) {
        NotificationChannel notificationChannel;
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            notificationChannel = notificationManager.getNotificationChannel(strArr[i10]);
            if (notificationChannel == null) {
                NotificationChannel notificationChannel2 = new NotificationChannel(strArr[i10], strArr2[i10], 3);
                notificationChannel2.setGroup(str);
                notificationChannel2.setDescription(strArr3[i10]);
                notificationChannel2.enableLights(true);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.setShowBadge(true);
                notificationChannel2.setSound(null, null);
                notificationChannel2.setImportance(3);
                notificationManager.createNotificationChannel(notificationChannel2);
            }
        }
    }

    public final void e(Context context, String str, String str2) {
        List notificationChannelGroups;
        String id;
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationChannelGroups = notificationManager.getNotificationChannelGroups();
        int size = notificationChannelGroups.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            id = f.a(notificationChannelGroups.get(i10)).getId();
            if (TextUtils.equals(id, str)) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            return;
        }
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(str, str2));
    }

    public final void f(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        e(context, "message_group", "Message Box");
        d(context, "message_group", f18198b, f18199c, f18200d);
        e(context, "upgrade_group", "Upgrade");
        d(context, "upgrade_group", f18201e, f18202f, f18203g);
    }

    public final int g() {
        int i10 = f18204h + 1;
        f18204h = i10;
        return i10;
    }

    public final Notification h(a aVar) {
        PendingIntent activity;
        Context f10 = aVar.f();
        if (f10 == null) {
            return null;
        }
        if (TextUtils.isEmpty(aVar.d())) {
            throw new IllegalArgumentException("require not-null channelId params.");
        }
        f(f10);
        int i10 = Build.VERSION.SDK_INT;
        s.e y10 = (i10 >= 26 ? new s.e(f10, aVar.d()) : new s.e(f10).z(1)).m(-1).A(aVar.l()).H(System.currentTimeMillis()).k(aVar.c()).j(aVar.b()).y(aVar.j());
        if (!TextUtils.isEmpty(aVar.n())) {
            y10 = y10.p(aVar.n());
        }
        if (!TextUtils.isEmpty(aVar.e())) {
            y10 = y10.o(aVar.e());
        }
        Intent h10 = aVar.h();
        if (h10 != null) {
            if (i10 >= 31) {
                activity = PendingIntent.getActivity(f10, aVar.k(), h10, 33554432);
                t9.i.f(activity, "getActivity(context, bui…ndingIntent.FLAG_MUTABLE)");
            } else {
                activity = PendingIntent.getActivity(f10, aVar.k(), h10, 134217728);
                t9.i.f(activity, "getActivity(context, bui…tent.FLAG_UPDATE_CURRENT)");
            }
            y10 = y10.n(activity);
        }
        if (aVar.i() != 0) {
            y10 = y10.u(BitmapFactory.decodeResource(f10.getResources(), aVar.i()));
        }
        if (aVar.m() != 0) {
            y10 = y10.B(aVar.m());
        }
        if (aVar.o() && aVar.g() != 0) {
            y10.q(new RemoteViews(f10.getPackageName(), aVar.g()));
        }
        return y10.c();
    }

    public final String i(int i10) {
        if (i10 == 1) {
            return f18198b[0];
        }
        if (i10 == 2) {
            return f18198b[1];
        }
        if (i10 == 3) {
            return f18198b[2];
        }
        if (i10 == 4) {
            return f18201e[0];
        }
        throw new UnsupportedOperationException("NotificationHelper: unsupported this type.");
    }

    public final boolean j(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        i1 b10 = i1.b(context);
        t9.i.f(b10, "from(context)");
        return Build.VERSION.SDK_INT >= 26 ? b10.c() != 0 : b10.a();
    }

    public final void k(Context context, Notification notification, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(notification, "notification");
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(i10, notification);
    }

    public final void l(Context context) {
        ApplicationInfo applicationInfo;
        try {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context != null ? context.getPackageName() : null);
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            if (i10 >= 21) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", context != null ? context.getPackageName() : null);
                intent.putExtra("app_uid", (context == null || (applicationInfo = context.getApplicationInfo()) == null) ? null : Integer.valueOf(applicationInfo.uid));
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(context != null ? context.getPackageName() : null);
            intent.setData(Uri.parse(sb.toString()));
            if (context != null) {
                context.startActivity(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            if (e10 instanceof ActivityNotFoundException) {
                Intent intent2 = new Intent();
                intent2.addFlags(268435456);
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts(Constants.KEY_PACKAGE, context != null ? context.getPackageName() : null, null));
                if (context != null) {
                    context.startActivity(intent2);
                }
            }
        }
    }
}
