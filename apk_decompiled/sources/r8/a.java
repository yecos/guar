package r8;

import android.view.Surface;
import android.view.View;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: r8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0315a {
        void a(b bVar);

        void b(b bVar, int i10, int i11);

        void c(b bVar, int i10, int i11, int i12);

        void d(int i10, int i11);
    }

    public interface b {
        a getRenderView();

        Surface openSurface();
    }

    void a(InterfaceC0315a interfaceC0315a);

    void b(InterfaceC0315a interfaceC0315a);

    View getView();

    void setAspectRatio(int i10);

    void setVideoRotation(int i10);

    void setVideoSize(int i10, int i11);
}
