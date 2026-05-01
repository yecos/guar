package n0;

import android.media.MediaRouter;

/* loaded from: classes.dex */
public abstract class k1 {
    public static int a(Object obj) {
        int deviceType;
        deviceType = ((MediaRouter.RouteInfo) obj).getDeviceType();
        return deviceType;
    }
}
