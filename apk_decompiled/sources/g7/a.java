package g7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes3.dex */
public abstract class a extends PopupWindow {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        setWidth(d());
        setHeight(c());
        setAnimationStyle(b());
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final void a(View view) {
        if (view == null) {
            return;
        }
        view.setSystemUiVisibility(5894);
    }

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract boolean e();

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (!e()) {
            super.showAsDropDown(view);
            return;
        }
        setFocusable(false);
        super.showAsDropDown(view);
        a(getContentView());
        setFocusable(true);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i10, int i11, int i12) {
        if (!e()) {
            super.showAtLocation(view, i10, i11, i12);
            return;
        }
        setFocusable(false);
        super.showAtLocation(view, i10, i11, i12);
        a(getContentView());
        setFocusable(true);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view, i10, i11);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view, i10, i11, i12);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
