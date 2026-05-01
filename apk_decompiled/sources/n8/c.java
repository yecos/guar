package n8;

import android.content.Context;
import android.os.SystemClock;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import l8.h;
import r8.a;
import t9.i;
import t9.z;

/* loaded from: classes3.dex */
public final class c implements n8.a {

    /* renamed from: b, reason: collision with root package name */
    public int f17312b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f17313c;

    /* renamed from: d, reason: collision with root package name */
    public a.b f17314d;

    /* renamed from: e, reason: collision with root package name */
    public r8.a f17315e;

    /* renamed from: f, reason: collision with root package name */
    public int f17316f;

    /* renamed from: a, reason: collision with root package name */
    public final String f17311a = c.class.getSimpleName();

    /* renamed from: g, reason: collision with root package name */
    public int f17317g = 3;

    /* renamed from: h, reason: collision with root package name */
    public String f17318h = "";

    /* renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0315a f17319i = new a();

    public static final class a implements a.InterfaceC0315a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f17320a;

        public a() {
        }

        @Override // r8.a.InterfaceC0315a
        public void a(a.b bVar) {
            i.g(bVar, "holder");
            this.f17320a = true;
            if (i.b(bVar.getRenderView(), c.this.f17315e)) {
                c.this.f17314d = null;
                h.f16357m.a().I(c.this.f17312b, null, c.this.j());
            }
        }

        @Override // r8.a.InterfaceC0315a
        public void b(a.b bVar, int i10, int i11) {
            i.g(bVar, "holder");
            if (i.b(bVar.getRenderView(), c.this.f17315e)) {
                c.this.f17314d = bVar;
                c.this.l(String.valueOf(SystemClock.elapsedRealtime()));
                h.f16357m.a().I(c.this.f17312b, bVar.openSurface(), c.this.j());
            }
        }

        @Override // r8.a.InterfaceC0315a
        public void c(a.b bVar, int i10, int i11, int i12) {
            i.g(bVar, "holder");
            i.b(bVar.getRenderView(), c.this.f17315e);
        }

        @Override // r8.a.InterfaceC0315a
        public void d(int i10, int i11) {
        }
    }

    @Override // n8.a
    public void a(ViewGroup viewGroup) {
        i.g(viewGroup, "videoView");
        this.f17313c = viewGroup;
    }

    @Override // n8.a
    public void b(int i10, String str, Context context, Integer num) {
        i.g(str, "value");
        h.f16357m.a().H(i10, "player", str, context, num != null ? num.intValue() : 0);
    }

    @Override // n8.a
    public void c(int i10, int i11) {
        View view;
        r8.a aVar = this.f17315e;
        if (aVar != null) {
            aVar.setVideoSize(i10, i11);
        }
        r8.a aVar2 = this.f17315e;
        if (aVar2 == null || (view = aVar2.getView()) == null) {
            return;
        }
        view.requestLayout();
    }

    @Override // n8.a
    public void d(int i10) {
        this.f17312b = i10;
    }

    @Override // n8.a
    public void e(Context context, int i10) {
        i.g(context, f.X);
        if (i10 == 0) {
            k(null);
            return;
        }
        if (i10 == 1) {
            k(new r8.b(context));
        } else if (i10 == 2) {
            k(new r8.c(context));
        } else {
            z zVar = z.f18964a;
            i.f(String.format("invalid render %d\n", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1)), "format(format, *args)");
        }
    }

    @Override // n8.a
    public void f() {
        this.f17313c = null;
    }

    @Override // n8.a
    public View getRenderView() {
        r8.a aVar = this.f17315e;
        if (aVar != null) {
            return aVar.getView();
        }
        return null;
    }

    public final String j() {
        return this.f17318h;
    }

    public final void k(r8.a aVar) {
        if (this.f17315e != null) {
            h.f16357m.a().I(this.f17312b, null, this.f17318h);
            r8.a aVar2 = this.f17315e;
            i.d(aVar2);
            View view = aVar2.getView();
            i.f(view, "mRenderView!!.view");
            r8.a aVar3 = this.f17315e;
            i.d(aVar3);
            aVar3.a(this.f17319i);
            this.f17315e = null;
            ViewGroup viewGroup = this.f17313c;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        if (aVar == null) {
            return;
        }
        this.f17315e = aVar;
        aVar.setAspectRatio(this.f17317g);
        r8.a aVar4 = this.f17315e;
        i.d(aVar4);
        View view2 = aVar4.getView();
        i.f(view2, "mRenderView!!.getView()");
        if (this.f17312b == 1 && (view2 instanceof SurfaceView)) {
            ((SurfaceView) view2).setZOrderMediaOverlay(true);
        }
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        ViewGroup viewGroup2 = this.f17313c;
        if (viewGroup2 != null) {
            viewGroup2.addView(view2);
        }
        r8.a aVar5 = this.f17315e;
        i.d(aVar5);
        aVar5.b(this.f17319i);
        r8.a aVar6 = this.f17315e;
        i.d(aVar6);
        aVar6.setVideoRotation(this.f17316f);
    }

    public final void l(String str) {
        i.g(str, "<set-?>");
        this.f17318h = str;
    }

    @Override // n8.a
    public void setAspectRatio(int i10) {
        this.f17317g = i10;
        r8.a aVar = this.f17315e;
        if (aVar != null) {
            i.d(aVar);
            aVar.setAspectRatio(this.f17317g);
        }
    }
}
