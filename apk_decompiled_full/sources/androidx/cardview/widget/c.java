package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
public class c implements f {
    @Override // androidx.cardview.widget.f
    public void a(e eVar, float f10) {
        p(eVar).h(f10);
    }

    @Override // androidx.cardview.widget.f
    public float b(e eVar) {
        return p(eVar).d();
    }

    @Override // androidx.cardview.widget.f
    public void c(e eVar, float f10) {
        eVar.f().setElevation(f10);
    }

    @Override // androidx.cardview.widget.f
    public float d(e eVar) {
        return p(eVar).c();
    }

    @Override // androidx.cardview.widget.f
    public ColorStateList e(e eVar) {
        return p(eVar).b();
    }

    @Override // androidx.cardview.widget.f
    public float f(e eVar) {
        return b(eVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.f
    public void g(e eVar) {
        o(eVar, d(eVar));
    }

    @Override // androidx.cardview.widget.f
    public void h(e eVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        eVar.a(new h(colorStateList, f10));
        View f13 = eVar.f();
        f13.setClipToOutline(true);
        f13.setElevation(f11);
        o(eVar, f12);
    }

    @Override // androidx.cardview.widget.f
    public float i(e eVar) {
        return eVar.f().getElevation();
    }

    @Override // androidx.cardview.widget.f
    public void j(e eVar) {
        o(eVar, d(eVar));
    }

    @Override // androidx.cardview.widget.f
    public void k(e eVar) {
        if (!eVar.b()) {
            eVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float d10 = d(eVar);
        float b10 = b(eVar);
        int ceil = (int) Math.ceil(i.c(d10, b10, eVar.e()));
        int ceil2 = (int) Math.ceil(i.d(d10, b10, eVar.e()));
        eVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.f
    public void l() {
    }

    @Override // androidx.cardview.widget.f
    public float m(e eVar) {
        return b(eVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.f
    public void n(e eVar, ColorStateList colorStateList) {
        p(eVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.f
    public void o(e eVar, float f10) {
        p(eVar).g(f10, eVar.b(), eVar.e());
        k(eVar);
    }

    public final h p(e eVar) {
        return (h) eVar.c();
    }
}
