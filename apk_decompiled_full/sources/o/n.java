package o;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class n {
    public static int a(Context context, String str, String str2) {
        Object systemService;
        int noteProxyOpNoThrow;
        if (Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
        noteProxyOpNoThrow = ((AppOpsManager) systemService).noteProxyOpNoThrow(str, str2);
        return noteProxyOpNoThrow;
    }

    public static String b(String str) {
        String permissionToOp;
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        permissionToOp = AppOpsManager.permissionToOp(str);
        return permissionToOp;
    }
}
