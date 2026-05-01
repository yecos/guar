package t6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import com.umeng.analytics.pro.f;
import q8.e;
import t9.i;

/* loaded from: classes3.dex */
public final class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final String f18907a = "DozeReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean isDeviceIdleMode;
        i.g(context, f.X);
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Object systemService = context.getSystemService("power");
        i.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        isDeviceIdleMode = ((PowerManager) systemService).isDeviceIdleMode();
        StringBuilder sb = new StringBuilder();
        sb.append("收到广播！是省电模式：");
        sb.append(isDeviceIdleMode);
        if (isDeviceIdleMode) {
            e.c("start");
        } else {
            e.c("stop");
        }
    }
}
