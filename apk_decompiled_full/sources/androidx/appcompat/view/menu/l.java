package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.m;
import b0.c1;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1236a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1237b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1238c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1239d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1240e;

    /* renamed from: f, reason: collision with root package name */
    public View f1241f;

    /* renamed from: g, reason: collision with root package name */
    public int f1242g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1243h;

    /* renamed from: i, reason: collision with root package name */
    public m.a f1244i;

    /* renamed from: j, reason: collision with root package name */
    public k f1245j;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1246k;

    /* renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f1247l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z10, int i10) {
        this(context, gVar, view, z10, i10, 0);
    }

    public final k a() {
        Display defaultDisplay = ((WindowManager) this.f1236a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        k dVar = Math.min(point.x, point.y) >= this.f1236a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new d(this.f1236a, this.f1241f, this.f1239d, this.f1240e, this.f1238c) : new q(this.f1236a, this.f1237b, this.f1241f, this.f1239d, this.f1240e, this.f1238c);
        dVar.a(this.f1237b);
        dVar.j(this.f1247l);
        dVar.e(this.f1241f);
        dVar.setCallback(this.f1244i);
        dVar.g(this.f1243h);
        dVar.h(this.f1242g);
        return dVar;
    }

    public void b() {
        if (d()) {
            this.f1245j.dismiss();
        }
    }

    public k c() {
        if (this.f1245j == null) {
            this.f1245j = a();
        }
        return this.f1245j;
    }

    public boolean d() {
        k kVar = this.f1245j;
        return kVar != null && kVar.isShowing();
    }

    public void e() {
        this.f1245j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1246k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f1241f = view;
    }

    public void g(boolean z10) {
        this.f1243h = z10;
        k kVar = this.f1245j;
        if (kVar != null) {
            kVar.g(z10);
        }
    }

    public void h(int i10) {
        this.f1242g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1246k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f1244i = aVar;
        k kVar = this.f1245j;
        if (kVar != null) {
            kVar.setCallback(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i10, int i11, boolean z10, boolean z11) {
        k c10 = c();
        c10.k(z11);
        if (z10) {
            if ((b0.j.b(this.f1242g, c1.z(this.f1241f)) & 7) == 5) {
                i10 -= this.f1241f.getWidth();
            }
            c10.i(i10);
            c10.l(i11);
            int i12 = (int) ((this.f1236a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.f(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1241f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f1241f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z10, int i10, int i11) {
        this.f1242g = 8388611;
        this.f1247l = new a();
        this.f1236a = context;
        this.f1237b = gVar;
        this.f1241f = view;
        this.f1238c = z10;
        this.f1239d = i10;
        this.f1240e = i11;
    }
}
