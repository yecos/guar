package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public abstract class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    public Activity f13997a;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.a(1.0f);
        }
    }

    public b(Activity activity) {
        super(activity);
        this.f13997a = activity;
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.SharePopupAnimation);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(-1));
        setOutsideTouchable(true);
        setOnDismissListener(new a());
    }

    public void a(float f10) {
        WindowManager.LayoutParams attributes = this.f13997a.getWindow().getAttributes();
        attributes.alpha = f10;
        this.f13997a.getWindow().setAttributes(attributes);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        view.setSystemUiVisibility(5894);
    }

    public void c(boolean z10) {
        setAnimationStyle(R.style.SharePopupAnimation);
        showAtLocation((ViewGroup) this.f13997a.getWindow().getDecorView().findViewById(android.R.id.content), 80, 0, 0);
        if (z10) {
            a(0.6f);
        }
    }

    public void d(View view, boolean z10) {
        setAnimationStyle(R.style.RightPopAnim);
        showAtLocation(view, 8388613, 0, 0);
        if (z10) {
            a(0.6f);
        }
    }

    public boolean e() {
        return false;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (!e()) {
            super.showAsDropDown(view);
            return;
        }
        setFocusable(false);
        super.showAsDropDown(view);
        b(getContentView());
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
        b(getContentView());
        setFocusable(true);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view, i10, i11);
            b(getContentView());
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
            b(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
