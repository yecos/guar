package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class a extends androidx.constraintlayout.widget.a {

    /* renamed from: g, reason: collision with root package name */
    public int f16876g;

    /* renamed from: h, reason: collision with root package name */
    public int f16877h;

    /* renamed from: i, reason: collision with root package name */
    public m.b f16878i;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.a
    public void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.f16878i = new m.b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1913a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f16878i.K0(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1920d = this.f16878i;
        f();
    }

    public int getType() {
        return this.f16876g;
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f16878i.K0(z10);
    }

    public void setType(int i10) {
        this.f16876g = i10;
        this.f16877h = i10;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            int i11 = this.f16876g;
            if (i11 == 5) {
                this.f16877h = 1;
            } else if (i11 == 6) {
                this.f16877h = 0;
            }
        } else {
            int i12 = this.f16876g;
            if (i12 == 5) {
                this.f16877h = 0;
            } else if (i12 == 6) {
                this.f16877h = 1;
            }
        }
        this.f16878i.L0(this.f16877h);
    }
}
