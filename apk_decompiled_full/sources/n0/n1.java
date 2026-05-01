package n0;

import android.media.MediaRouter;

/* loaded from: classes.dex */
public abstract class n1 {

    public static final class a {
        public static CharSequence a(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getDescription();
        }

        public static boolean b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isConnecting();
        }
    }

    public static final class b {
        public static void a(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setDescription(charSequence);
        }
    }

    public static void a(Object obj, int i10, Object obj2, int i11) {
        ((MediaRouter) obj).addCallback(i10, (MediaRouter.Callback) obj2, i11);
    }

    public static Object b(Object obj) {
        return ((MediaRouter) obj).getDefaultRoute();
    }
}
