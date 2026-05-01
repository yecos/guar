package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class i extends CheckedTextView {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1504b = {R.attr.checkMark};

    /* renamed from: a, reason: collision with root package name */
    public final p0 f1505a;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p0 p0Var = this.f1505a;
        if (p0Var != null) {
            p0Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(d.b.d(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.e0.q(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        p0 p0Var = this.f1505a;
        if (p0Var != null) {
            p0Var.p(context, i10);
        }
    }

    public i(Context context, AttributeSet attributeSet, int i10) {
        super(o2.b(context), attributeSet, i10);
        p0 p0Var = new p0(this);
        this.f1505a = p0Var;
        p0Var.m(attributeSet, i10);
        p0Var.b();
        r2 u10 = r2.u(getContext(), attributeSet, f1504b, i10, 0);
        setCheckMarkDrawable(u10.g(0));
        u10.v();
    }
}
