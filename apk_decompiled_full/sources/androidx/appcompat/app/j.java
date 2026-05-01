package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import b0.k;
import g.b;

/* loaded from: classes.dex */
public class j extends Dialog implements e {
    private f mDelegate;
    private final k.a mKeyDispatcher;

    public class a implements k.a {
        public a() {
        }

        @Override // b0.k.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public j(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        this.mKeyDispatcher = new a();
        f delegate = getDelegate();
        delegate.C(getThemeResId(context, i10));
        delegate.p(null);
    }

    public static int getThemeResId(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b0.k.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().e(i10);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.d(this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().j();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().l();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().k();
        super.onCreate(bundle);
        getDelegate().p(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().v();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(g.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(g.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public g.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        getDelegate().y(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().D(charSequence);
    }

    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().x(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().z(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().A(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().D(getContext().getString(i10));
    }

    public j(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        this.mKeyDispatcher = new a();
    }
}
