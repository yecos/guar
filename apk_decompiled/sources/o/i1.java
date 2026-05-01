package o;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.taobao.accs.flowcontrol.FlowControl;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f17363c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static Set f17364d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f17365e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f17366a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f17367b;

    public i1(Context context) {
        this.f17366a = context;
        this.f17367b = (NotificationManager) context.getSystemService("notification");
    }

    public static i1 b(Context context) {
        return new i1(context);
    }

    public boolean a() {
        boolean areNotificationsEnabled;
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = this.f17367b.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f17366a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f17366a.getApplicationInfo();
        String packageName = this.f17366a.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i10), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public int c() {
        int importance;
        if (Build.VERSION.SDK_INT < 24) {
            return FlowControl.DELAY_MAX_BRUSH;
        }
        importance = this.f17367b.getImportance();
        return importance;
    }
}
