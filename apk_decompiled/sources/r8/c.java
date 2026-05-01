package r8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r8.a;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

/* loaded from: classes3.dex */
public class c extends TextureView implements r8.a {

    /* renamed from: a, reason: collision with root package name */
    public q8.b f18569a;

    /* renamed from: b, reason: collision with root package name */
    public b f18570b;

    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public c f18571a;

        /* renamed from: b, reason: collision with root package name */
        public SurfaceTexture f18572b;

        /* renamed from: c, reason: collision with root package name */
        public ISurfaceTextureHost f18573c;

        public a(c cVar, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.f18571a = cVar;
            this.f18572b = surfaceTexture;
            this.f18573c = iSurfaceTextureHost;
        }

        @Override // r8.a.b
        public r8.a getRenderView() {
            return this.f18571a;
        }

        @Override // r8.a.b
        public Surface openSurface() {
            if (this.f18572b == null) {
                return null;
            }
            return new Surface(this.f18572b);
        }
    }

    public static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {

        /* renamed from: a, reason: collision with root package name */
        public SurfaceTexture f18574a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f18575b;

        /* renamed from: c, reason: collision with root package name */
        public int f18576c;

        /* renamed from: d, reason: collision with root package name */
        public int f18577d;

        /* renamed from: h, reason: collision with root package name */
        public WeakReference f18581h;

        /* renamed from: e, reason: collision with root package name */
        public boolean f18578e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f18579f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f18580g = false;

        /* renamed from: i, reason: collision with root package name */
        public Map f18582i = new ConcurrentHashMap();

        public b(c cVar) {
            this.f18581h = new WeakReference(cVar);
        }

        public void b(a.InterfaceC0315a interfaceC0315a) {
            a aVar;
            this.f18582i.put(interfaceC0315a, interfaceC0315a);
            if (this.f18574a != null) {
                aVar = new a((c) this.f18581h.get(), this.f18574a, this);
                interfaceC0315a.b(aVar, this.f18576c, this.f18577d);
            } else {
                aVar = null;
            }
            if (this.f18575b) {
                if (aVar == null) {
                    aVar = new a((c) this.f18581h.get(), this.f18574a, this);
                }
                interfaceC0315a.c(aVar, 0, this.f18576c, this.f18577d);
            }
        }

        public void c() {
            this.f18580g = true;
        }

        public void d(a.InterfaceC0315a interfaceC0315a) {
            int i10;
            int i11;
            if (this.f18581h.get() != null) {
                i10 = ((c) this.f18581h.get()).getView().getWidth();
                i11 = ((c) this.f18581h.get()).getView().getHeight();
            } else {
                i10 = 0;
                i11 = 0;
            }
            interfaceC0315a.d(i10, i11);
        }

        public void e(a.InterfaceC0315a interfaceC0315a) {
            this.f18582i.remove(interfaceC0315a);
        }

        public void f(boolean z10) {
            this.f18578e = z10;
        }

        public void g() {
            this.f18579f = true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            this.f18574a = surfaceTexture;
            this.f18575b = false;
            this.f18576c = 0;
            this.f18577d = 0;
            a aVar = new a((c) this.f18581h.get(), surfaceTexture, this);
            Iterator it = this.f18582i.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0315a) it.next()).b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f18574a = surfaceTexture;
            this.f18575b = false;
            this.f18576c = 0;
            this.f18577d = 0;
            a aVar = new a((c) this.f18581h.get(), surfaceTexture, this);
            Iterator it = this.f18582i.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0315a) it.next()).a(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onSurfaceTextureDestroyed: destroy: ");
            sb.append(this.f18578e);
            return this.f18578e;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            this.f18574a = surfaceTexture;
            this.f18575b = true;
            this.f18576c = i10;
            this.f18577d = i11;
            a aVar = new a((c) this.f18581h.get(), surfaceTexture, this);
            for (a.InterfaceC0315a interfaceC0315a : this.f18582i.keySet()) {
                interfaceC0315a.c(aVar, 0, i10, i11);
                d(interfaceC0315a);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHost
        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                return;
            }
            if (this.f18580g) {
                if (surfaceTexture != this.f18574a) {
                    surfaceTexture.release();
                    return;
                } else {
                    if (this.f18578e) {
                        return;
                    }
                    surfaceTexture.release();
                    return;
                }
            }
            if (this.f18579f) {
                if (surfaceTexture != this.f18574a) {
                    surfaceTexture.release();
                    return;
                } else {
                    if (this.f18578e) {
                        return;
                    }
                    f(true);
                    return;
                }
            }
            if (surfaceTexture != this.f18574a) {
                surfaceTexture.release();
            } else {
                if (this.f18578e) {
                    return;
                }
                f(true);
            }
        }
    }

    public c(Context context) {
        super(context);
        c(context);
    }

    @Override // r8.a
    public void a(a.InterfaceC0315a interfaceC0315a) {
        this.f18570b.e(interfaceC0315a);
    }

    @Override // r8.a
    public void b(a.InterfaceC0315a interfaceC0315a) {
        this.f18570b.b(interfaceC0315a);
    }

    public final void c(Context context) {
        this.f18569a = new q8.b(this);
        b bVar = new b(this);
        this.f18570b = bVar;
        setSurfaceTextureListener(bVar);
    }

    public Bitmap getScreenshot() {
        return getBitmap();
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.f18570b.f18574a, this.f18570b);
    }

    @Override // r8.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f18570b.g();
        super.onDetachedFromWindow();
        this.f18570b.c();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(c.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        this.f18569a.a(i10, i11);
        setMeasuredDimension(this.f18569a.c(), this.f18569a.b());
    }

    @Override // r8.a
    public void setAspectRatio(int i10) {
        this.f18569a.d(i10);
        requestLayout();
    }

    @Override // r8.a
    public void setVideoRotation(int i10) {
        this.f18569a.e(i10);
        setRotation(i10);
    }

    @Override // r8.a
    public void setVideoSize(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.f18569a.f(i10, i11);
        requestLayout();
    }
}
