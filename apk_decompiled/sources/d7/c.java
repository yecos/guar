package d7;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: k, reason: collision with root package name */
    public static c f12672k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f12673l;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12674a;

    /* renamed from: b, reason: collision with root package name */
    public final b f12675b;

    /* renamed from: c, reason: collision with root package name */
    public Camera f12676c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f12677d;

    /* renamed from: e, reason: collision with root package name */
    public Rect f12678e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12679f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12680g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f12681h;

    /* renamed from: i, reason: collision with root package name */
    public final f f12682i;

    /* renamed from: j, reason: collision with root package name */
    public final a f12683j;

    static {
        int i10;
        try {
            i10 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i10 = 10000;
        }
        f12673l = i10;
    }

    public c(Context context) {
        this.f12674a = context;
        b bVar = new b(context);
        this.f12675b = bVar;
        boolean z10 = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.f12681h = z10;
        this.f12682i = new f(bVar, z10);
        this.f12683j = new a();
    }

    public static c c() {
        return f12672k;
    }

    public static void f(Context context) {
        if (f12672k == null) {
            f12672k = new c(context);
        }
    }

    public e a(byte[] bArr, int i10, int i11) {
        Rect e10 = e();
        int e11 = this.f12675b.e();
        String f10 = this.f12675b.f();
        if (e11 == 16 || e11 == 17) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        }
        if ("yuv420p".equals(f10)) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        }
        throw new IllegalArgumentException("Unsupported picture format: " + e11 + '/' + f10);
    }

    public void b() {
        if (this.f12676c != null) {
            d.a();
            this.f12676c.release();
            this.f12676c = null;
        }
    }

    public Rect d() {
        Point g10 = this.f12675b.g();
        if (g10 == null) {
            return null;
        }
        if (this.f12677d == null) {
            if (this.f12676c == null) {
                return null;
            }
            int i10 = g10.x;
            int i11 = (i10 * 7) / 10;
            int i12 = g10.y;
            int i13 = (i12 * 7) / 10;
            if (i13 < i11) {
                i11 = i13;
            }
            int i14 = (i10 - i11) / 2;
            int i15 = (i12 - i11) / 2;
            this.f12677d = new Rect(i14, i15, i14 + i11, i11 + i15);
        }
        return this.f12677d;
    }

    public Rect e() {
        if (this.f12678e == null) {
            Rect rect = new Rect(d());
            Point c10 = this.f12675b.c();
            Point g10 = this.f12675b.g();
            int i10 = rect.left;
            int i11 = c10.y;
            int i12 = g10.x;
            rect.left = (i10 * i11) / i12;
            rect.right = (rect.right * i11) / i12;
            int i13 = rect.top;
            int i14 = c10.x;
            int i15 = g10.y;
            rect.top = (i13 * i14) / i15;
            rect.bottom = (rect.bottom * i14) / i15;
            this.f12678e = rect;
        }
        return this.f12678e;
    }

    public void g(SurfaceHolder surfaceHolder) {
        if (this.f12676c == null) {
            Camera open = Camera.open();
            this.f12676c = open;
            if (open == null) {
                throw new IOException();
            }
            open.setPreviewDisplay(surfaceHolder);
            if (!this.f12679f) {
                this.f12679f = true;
                this.f12675b.h(this.f12676c);
            }
            this.f12675b.i(this.f12676c);
            d.b();
        }
    }

    public void h(Handler handler, int i10) {
        if (this.f12676c == null || !this.f12680g) {
            return;
        }
        this.f12683j.a(handler, i10);
        this.f12676c.autoFocus(this.f12683j);
    }

    public void i(Handler handler, int i10) {
        if (this.f12676c == null || !this.f12680g) {
            return;
        }
        this.f12682i.a(handler, i10);
        if (this.f12681h) {
            this.f12676c.setOneShotPreviewCallback(this.f12682i);
        } else {
            this.f12676c.setPreviewCallback(this.f12682i);
        }
    }

    public void j() {
        Camera camera = this.f12676c;
        if (camera == null || this.f12680g) {
            return;
        }
        camera.startPreview();
        this.f12680g = true;
    }

    public void k() {
        Camera camera = this.f12676c;
        if (camera == null || !this.f12680g) {
            return;
        }
        if (!this.f12681h) {
            camera.setPreviewCallback(null);
        }
        this.f12676c.stopPreview();
        this.f12682i.a(null, 0);
        this.f12683j.a(null, 0);
        this.f12680g = false;
    }
}
