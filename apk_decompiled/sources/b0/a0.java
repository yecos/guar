package b0;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4294a;

    /* renamed from: b, reason: collision with root package name */
    public int f4295b;

    public a0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4294a | this.f4295b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f4295b = i10;
        } else {
            this.f4294a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f4295b = 0;
        } else {
            this.f4294a = 0;
        }
    }
}
