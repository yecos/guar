package n0;

import android.os.Messenger;

/* loaded from: classes.dex */
public abstract class r0 {
    public static boolean a(Messenger messenger) {
        if (messenger == null) {
            return false;
        }
        try {
            return messenger.getBinder() != null;
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
