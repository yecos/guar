package n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class p1 extends BroadcastReceiver {
    public static boolean a(Context context) {
        Intent intent = new Intent(context, (Class<?>) p1.class);
        intent.setPackage(context.getPackageName());
        return context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0;
    }
}
