package j0;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: j0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0237a {
        androidx.loader.content.b onCreateLoader(int i10, Bundle bundle);

        void onLoadFinished(androidx.loader.content.b bVar, Object obj);

        void onLoaderReset(androidx.loader.content.b bVar);
    }

    public static a b(g gVar) {
        return new b(gVar, ((y) gVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract androidx.loader.content.b c(int i10, Bundle bundle, InterfaceC0237a interfaceC0237a);

    public abstract void d();
}
