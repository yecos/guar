package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.s1;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public s1.a f1356a;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        s1.a aVar = this.f1356a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.s1
    public void setOnFitSystemWindowsListener(s1.a aVar) {
        this.f1356a = aVar;
    }
}
