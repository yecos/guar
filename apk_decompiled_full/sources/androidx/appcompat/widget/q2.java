package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class q2 extends h2 {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f1594b;

    public q2(Context context, Resources resources) {
        super(resources);
        this.f1594b = new WeakReference(context);
    }

    @Override // androidx.appcompat.widget.h2, android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Drawable drawable = super.getDrawable(i10);
        Context context = (Context) this.f1594b.get();
        if (drawable != null && context != null) {
            e2.h().x(context, i10, drawable);
        }
        return drawable;
    }
}
