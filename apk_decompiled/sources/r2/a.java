package r2;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: r2.a$a, reason: collision with other inner class name */
    public static class HandlerC0313a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f18329a;

        public HandlerC0313a(Handler handler) {
            this.f18329a = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler handler = this.f18329a;
            if (handler != null) {
                try {
                    handler.handleMessage(message);
                } catch (WindowManager.BadTokenException unused) {
                }
            }
        }
    }

    public static void a(Toast toast) {
        try {
            Field declaredField = toast.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Handler handler = (Handler) declaredField2.get(obj);
            if (handler instanceof HandlerC0313a) {
                return;
            }
            declaredField2.set(obj, new HandlerC0313a(handler));
        } catch (Exception e10) {
            e10.printStackTrace();
            m2.a.a(e10, "FIX TOAST FAIL");
        }
    }
}
