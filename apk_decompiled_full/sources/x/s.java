package x;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes.dex */
public abstract class s {
    public static boolean a(Context context) {
        Object systemService;
        boolean isUserUnlocked;
        if (Build.VERSION.SDK_INT < 24) {
            return true;
        }
        systemService = context.getSystemService((Class<Object>) UserManager.class);
        isUserUnlocked = ((UserManager) systemService).isUserUnlocked();
        return isUserUnlocked;
    }
}
