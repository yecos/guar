package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import q.h;

/* loaded from: classes.dex */
public class r2 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1614a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f1615b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1616c;

    public r2(Context context, TypedArray typedArray) {
        this.f1614a = context;
        this.f1615b = typedArray;
    }

    public static r2 s(Context context, int i10, int[] iArr) {
        return new r2(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static r2 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new r2(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static r2 u(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new r2(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1615b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1615b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList c10;
        return (!this.f1615b.hasValue(i10) || (resourceId = this.f1615b.getResourceId(i10, 0)) == 0 || (c10 = d.b.c(this.f1614a, resourceId)) == null) ? this.f1615b.getColorStateList(i10) : c10;
    }

    public float d(int i10, float f10) {
        return this.f1615b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1615b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1615b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        return (!this.f1615b.hasValue(i10) || (resourceId = this.f1615b.getResourceId(i10, 0)) == 0) ? this.f1615b.getDrawable(i10) : d.b.d(this.f1614a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1615b.hasValue(i10) || (resourceId = this.f1615b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return k.b().d(this.f1614a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1615b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.c cVar) {
        int resourceId = this.f1615b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1616c == null) {
            this.f1616c = new TypedValue();
        }
        return q.h.f(this.f1614a, resourceId, this.f1616c, i11, cVar);
    }

    public int k(int i10, int i11) {
        return this.f1615b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1615b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1615b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1615b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1615b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1615b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1615b.getTextArray(i10);
    }

    public boolean r(int i10) {
        return this.f1615b.hasValue(i10);
    }

    public void v() {
        this.f1615b.recycle();
    }
}
