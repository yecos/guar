package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class f1 extends ToggleButton {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f1500a;

    public f1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public f1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p0 p0Var = new p0(this);
        this.f1500a = p0Var;
        p0Var.m(attributeSet, i10);
    }
}
