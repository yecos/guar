package s7;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class a {
    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
