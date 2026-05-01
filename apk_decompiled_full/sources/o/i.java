package o;

import android.app.ActivityManager;

/* loaded from: classes.dex */
public abstract class i {
    public static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
