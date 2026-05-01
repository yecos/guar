package n0;

import android.media.MediaRouter;
import android.view.Display;
import n0.l1;

/* loaded from: classes.dex */
public abstract class m1 {

    public interface a extends l1.a {
        void i(Object obj);
    }

    public static class b extends l1.b {
        public b(a aVar) {
            super(aVar);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((a) this.f16909a).i(routeInfo);
        }
    }

    public static final class c {
        public static Display a(Object obj) {
            try {
                return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
            } catch (NoSuchMethodError unused) {
                return null;
            }
        }

        public static boolean b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
