package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class OverlayListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final List f2731a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public BitmapDrawable f2732a;

        /* renamed from: c, reason: collision with root package name */
        public Rect f2734c;

        /* renamed from: d, reason: collision with root package name */
        public Interpolator f2735d;

        /* renamed from: e, reason: collision with root package name */
        public long f2736e;

        /* renamed from: f, reason: collision with root package name */
        public Rect f2737f;

        /* renamed from: g, reason: collision with root package name */
        public int f2738g;

        /* renamed from: j, reason: collision with root package name */
        public long f2741j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f2742k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f2743l;

        /* renamed from: m, reason: collision with root package name */
        public InterfaceC0038a f2744m;

        /* renamed from: b, reason: collision with root package name */
        public float f2733b = 1.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f2739h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f2740i = 1.0f;

        /* renamed from: androidx.mediarouter.app.OverlayListView$a$a, reason: collision with other inner class name */
        public interface InterfaceC0038a {
            void onAnimationEnd();
        }

        public a(BitmapDrawable bitmapDrawable, Rect rect) {
            this.f2732a = bitmapDrawable;
            this.f2737f = rect;
            this.f2734c = new Rect(rect);
            BitmapDrawable bitmapDrawable2 = this.f2732a;
            if (bitmapDrawable2 != null) {
                bitmapDrawable2.setAlpha((int) (this.f2733b * 255.0f));
                this.f2732a.setBounds(this.f2734c);
            }
        }

        public BitmapDrawable a() {
            return this.f2732a;
        }

        public boolean b() {
            return this.f2742k;
        }

        public a c(float f10, float f11) {
            this.f2739h = f10;
            this.f2740i = f11;
            return this;
        }

        public a d(InterfaceC0038a interfaceC0038a) {
            this.f2744m = interfaceC0038a;
            return this;
        }

        public a e(long j10) {
            this.f2736e = j10;
            return this;
        }

        public a f(Interpolator interpolator) {
            this.f2735d = interpolator;
            return this;
        }

        public a g(int i10) {
            this.f2738g = i10;
            return this;
        }

        public void h(long j10) {
            this.f2741j = j10;
            this.f2742k = true;
        }

        public void i() {
            this.f2742k = true;
            this.f2743l = true;
            InterfaceC0038a interfaceC0038a = this.f2744m;
            if (interfaceC0038a != null) {
                interfaceC0038a.onAnimationEnd();
            }
        }

        public boolean j(long j10) {
            if (this.f2743l) {
                return false;
            }
            float max = this.f2742k ? Math.max(0.0f, Math.min(1.0f, (j10 - this.f2741j) / this.f2736e)) : 0.0f;
            Interpolator interpolator = this.f2735d;
            float interpolation = interpolator == null ? max : interpolator.getInterpolation(max);
            int i10 = (int) (this.f2738g * interpolation);
            Rect rect = this.f2734c;
            Rect rect2 = this.f2737f;
            rect.top = rect2.top + i10;
            rect.bottom = rect2.bottom + i10;
            float f10 = this.f2739h;
            float f11 = f10 + ((this.f2740i - f10) * interpolation);
            this.f2733b = f11;
            BitmapDrawable bitmapDrawable = this.f2732a;
            if (bitmapDrawable != null && rect != null) {
                bitmapDrawable.setAlpha((int) (f11 * 255.0f));
                this.f2732a.setBounds(this.f2734c);
            }
            if (this.f2742k && max >= 1.0f) {
                this.f2743l = true;
                InterfaceC0038a interfaceC0038a = this.f2744m;
                if (interfaceC0038a != null) {
                    interfaceC0038a.onAnimationEnd();
                }
            }
            return !this.f2743l;
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2731a = new ArrayList();
    }

    public void a(a aVar) {
        this.f2731a.add(aVar);
    }

    public void b() {
        for (a aVar : this.f2731a) {
            if (!aVar.b()) {
                aVar.h(getDrawingTime());
            }
        }
    }

    public void c() {
        Iterator it = this.f2731a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).i();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2731a.size() > 0) {
            Iterator it = this.f2731a.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BitmapDrawable a10 = aVar.a();
                if (a10 != null) {
                    a10.draw(canvas);
                }
                if (!aVar.j(getDrawingTime())) {
                    it.remove();
                }
            }
        }
    }
}
