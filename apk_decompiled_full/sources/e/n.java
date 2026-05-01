package e;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import e.h;

/* loaded from: classes.dex */
public abstract class n extends h {

    /* renamed from: n, reason: collision with root package name */
    public a f12829n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12830o;

    public static class a extends h.c {
        public int[][] J;

        public a(a aVar, n nVar, Resources resources) {
            super(aVar, nVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int h10 = h();
            for (int i10 = 0; i10 < h10; i10++) {
                if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // e.h.c
        public void o(int i10, int i11) {
            super.o(i10, i11);
            int[][] iArr = new int[i11][];
            System.arraycopy(this.J, 0, iArr, 0, i10);
            this.J = iArr;
        }

        @Override // e.h.c
        public abstract void r();

        public int z(int[] iArr, Drawable drawable) {
            int a10 = a(drawable);
            this.J[a10] = iArr;
            return a10;
        }
    }

    public n(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // e.h
    public void h(h.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.f12829n = (a) cVar;
        }
    }

    public int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i10 = 0;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i12 = i10 + 1;
                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i10] = attributeNameResource;
                i10 = i12;
            }
        }
        return StateSet.trimStateSet(iArr, i10);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f12830o && super.mutate() == this) {
            this.f12829n.r();
            this.f12830o = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public abstract boolean onStateChange(int[] iArr);
}
