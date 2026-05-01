package r8;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r8.a;

/* loaded from: classes3.dex */
public class b extends SurfaceView implements r8.a {

    /* renamed from: a, reason: collision with root package name */
    public q8.b f18558a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceHolderCallbackC0316b f18559b;

    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public b f18560a;

        /* renamed from: b, reason: collision with root package name */
        public SurfaceHolder f18561b;

        public a(b bVar, SurfaceHolder surfaceHolder) {
            this.f18560a = bVar;
            this.f18561b = surfaceHolder;
        }

        @Override // r8.a.b
        public r8.a getRenderView() {
            return this.f18560a;
        }

        @Override // r8.a.b
        public Surface openSurface() {
            SurfaceHolder surfaceHolder = this.f18561b;
            if (surfaceHolder == null) {
                return null;
            }
            return surfaceHolder.getSurface();
        }
    }

    /* renamed from: r8.b$b, reason: collision with other inner class name */
    public static final class SurfaceHolderCallbackC0316b implements SurfaceHolder.Callback {

        /* renamed from: a, reason: collision with root package name */
        public SurfaceHolder f18562a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f18563b;

        /* renamed from: c, reason: collision with root package name */
        public int f18564c;

        /* renamed from: d, reason: collision with root package name */
        public int f18565d;

        /* renamed from: e, reason: collision with root package name */
        public int f18566e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference f18567f;

        /* renamed from: g, reason: collision with root package name */
        public Map f18568g = new ConcurrentHashMap();

        public SurfaceHolderCallbackC0316b(b bVar) {
            this.f18567f = new WeakReference(bVar);
        }

        public void a(a.InterfaceC0315a interfaceC0315a) {
            a aVar;
            this.f18568g.put(interfaceC0315a, interfaceC0315a);
            if (this.f18562a != null) {
                aVar = new a((b) this.f18567f.get(), this.f18562a);
                interfaceC0315a.b(aVar, this.f18565d, this.f18566e);
            } else {
                aVar = null;
            }
            if (this.f18563b) {
                if (aVar == null) {
                    aVar = new a((b) this.f18567f.get(), this.f18562a);
                }
                interfaceC0315a.c(aVar, this.f18564c, this.f18565d, this.f18566e);
            }
        }

        public void b(a.InterfaceC0315a interfaceC0315a) {
            int i10;
            int i11;
            if (this.f18567f.get() != null) {
                i10 = ((b) this.f18567f.get()).getView().getWidth();
                i11 = ((b) this.f18567f.get()).getView().getHeight();
            } else {
                i10 = 0;
                i11 = 0;
            }
            interfaceC0315a.d(i10, i11);
        }

        public void c(a.InterfaceC0315a interfaceC0315a) {
            this.f18568g.remove(interfaceC0315a);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            this.f18562a = surfaceHolder;
            this.f18563b = true;
            this.f18564c = i10;
            this.f18565d = i11;
            this.f18566e = i12;
            a aVar = new a((b) this.f18567f.get(), this.f18562a);
            for (a.InterfaceC0315a interfaceC0315a : this.f18568g.keySet()) {
                interfaceC0315a.c(aVar, i10, i11, i12);
                b(interfaceC0315a);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f18562a = surfaceHolder;
            this.f18563b = false;
            this.f18564c = 0;
            this.f18565d = 0;
            this.f18566e = 0;
            a aVar = new a((b) this.f18567f.get(), this.f18562a);
            Iterator it = this.f18568g.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0315a) it.next()).b(aVar, 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f18562a = null;
            this.f18563b = false;
            this.f18564c = 0;
            this.f18565d = 0;
            this.f18566e = 0;
            a aVar = new a((b) this.f18567f.get(), this.f18562a);
            Iterator it = this.f18568g.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0315a) it.next()).a(aVar);
            }
        }
    }

    public b(Context context) {
        super(context);
        c(context);
    }

    @Override // r8.a
    public void a(a.InterfaceC0315a interfaceC0315a) {
        this.f18559b.c(interfaceC0315a);
    }

    @Override // r8.a
    public void b(a.InterfaceC0315a interfaceC0315a) {
        this.f18559b.a(interfaceC0315a);
    }

    public final void c(Context context) {
        this.f18558a = new q8.b(this);
        this.f18559b = new SurfaceHolderCallbackC0316b(this);
        getHolder().addCallback(this.f18559b);
        getHolder().setType(0);
    }

    public Bitmap getScreenshot() {
        return null;
    }

    @Override // r8.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(b.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(b.class.getName());
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        this.f18558a.a(i10, i11);
        setMeasuredDimension(this.f18558a.c(), this.f18558a.b());
    }

    @Override // r8.a
    public void setAspectRatio(int i10) {
        this.f18558a.d(i10);
        requestLayout();
    }

    @Override // r8.a
    public void setVideoRotation(int i10) {
        Log.e("", "SurfaceView doesn't support rotation (" + i10 + ")!\n");
    }

    @Override // r8.a
    public void setVideoSize(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.f18558a.f(i10, i11);
        getHolder().setFixedSize(i10, i11);
        requestLayout();
    }
}
