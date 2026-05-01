package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class s extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1617b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1618a;

    static {
        f1617b = Build.VERSION.SDK_INT < 21;
    }

    public s(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        r2 u10 = r2.u(context, attributeSet, R$styleable.D, i10, i11);
        int i12 = R$styleable.PopupWindow_overlapAnchor;
        if (u10.r(i12)) {
            b(u10.a(i12, false));
        }
        setBackgroundDrawable(u10.g(R$styleable.PopupWindow_android_popupBackground));
        u10.v();
    }

    public final void b(boolean z10) {
        if (f1617b) {
            this.f1618a = z10;
        } else {
            androidx.core.widget.t.a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f1617b && this.f1618a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f1617b && this.f1618a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f1617b && this.f1618a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
