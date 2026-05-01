package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import m.j;

/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1917a;

    /* renamed from: b, reason: collision with root package name */
    public int f1918b;

    /* renamed from: c, reason: collision with root package name */
    public Context f1919c;

    /* renamed from: d, reason: collision with root package name */
    public j f1920d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1921e;

    /* renamed from: f, reason: collision with root package name */
    public String f1922f;

    public a(Context context) {
        super(context);
        this.f1917a = new int[32];
        this.f1921e = false;
        this.f1919c = context;
        b(null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                a(str.substring(i10));
                return;
            } else {
                a(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    public final void a(String str) {
        int i10;
        Object c10;
        if (str == null || this.f1919c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i10 = R$id.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i10 = 0;
        }
        if (i10 == 0) {
            i10 = this.f1919c.getResources().getIdentifier(trim, "id", this.f1919c.getPackageName());
        }
        if (i10 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (c10 = ((ConstraintLayout) getParent()).c(0, trim)) != null && (c10 instanceof Integer)) {
            i10 = ((Integer) c10).intValue();
        }
        if (i10 != 0) {
            setTag(i10, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find id of \"");
        sb.append(trim);
        sb.append("\"");
    }

    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1913a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1922f = string;
                    setIds(string);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void e(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1922f);
        }
        j jVar = this.f1920d;
        if (jVar == null) {
            return;
        }
        jVar.J0();
        for (int i10 = 0; i10 < this.f1918b; i10++) {
            View e10 = constraintLayout.e(this.f1917a[i10]);
            if (e10 != null) {
                this.f1920d.I0(constraintLayout.f(e10));
            }
        }
    }

    public void f() {
        if (this.f1920d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f1896l0 = this.f1920d;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1917a, this.f1918b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1921e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1918b = 0;
        for (int i10 : iArr) {
            setTag(i10, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        int i11 = this.f1918b + 1;
        int[] iArr = this.f1917a;
        if (i11 > iArr.length) {
            this.f1917a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1917a;
        int i12 = this.f1918b;
        iArr2[i12] = i10;
        this.f1918b = i12 + 1;
    }
}
