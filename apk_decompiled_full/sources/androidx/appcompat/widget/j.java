package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f1514a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f1515b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1516c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1517d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1518e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1519f;

    public j(CompoundButton compoundButton) {
        this.f1514a = compoundButton;
    }

    public void a() {
        Drawable a10 = androidx.core.widget.g.a(this.f1514a);
        if (a10 != null) {
            if (this.f1517d || this.f1518e) {
                Drawable mutate = s.h.r(a10).mutate();
                if (this.f1517d) {
                    s.h.o(mutate, this.f1515b);
                }
                if (this.f1518e) {
                    s.h.p(mutate, this.f1516c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1514a.getDrawableState());
                }
                this.f1514a.setButtonDrawable(mutate);
            }
        }
    }

    public int b(int i10) {
        return i10;
    }

    public ColorStateList c() {
        return this.f1515b;
    }

    public PorterDuff.Mode d() {
        return this.f1516c;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[Catch: all -> 0x0075, TRY_ENTER, TryCatch #1 {all -> 0x0075, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002e, B:13:0x0036, B:15:0x003c, B:16:0x0049, B:18:0x0051, B:19:0x005a, B:21:0x0062), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[Catch: all -> 0x0075, TryCatch #1 {all -> 0x0075, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002e, B:13:0x0036, B:15:0x003c, B:16:0x0049, B:18:0x0051, B:19:0x005a, B:21:0x0062), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #1 {all -> 0x0075, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002e, B:13:0x0036, B:15:0x003c, B:16:0x0049, B:18:0x0051, B:19:0x005a, B:21:0x0062), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(AttributeSet attributeSet, int i10) {
        boolean z10;
        int i11;
        int i12;
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = this.f1514a.getContext().obtainStyledAttributes(attributeSet, R$styleable.f820r, i10, 0);
        try {
            int i13 = R$styleable.CompoundButton_buttonCompat;
            if (obtainStyledAttributes.hasValue(i13) && (resourceId2 = obtainStyledAttributes.getResourceId(i13, 0)) != 0) {
                try {
                    CompoundButton compoundButton = this.f1514a;
                    compoundButton.setButtonDrawable(d.b.d(compoundButton.getContext(), resourceId2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z10) {
                    int i14 = R$styleable.CompoundButton_android_button;
                    if (obtainStyledAttributes.hasValue(i14) && (resourceId = obtainStyledAttributes.getResourceId(i14, 0)) != 0) {
                        CompoundButton compoundButton2 = this.f1514a;
                        compoundButton2.setButtonDrawable(d.b.d(compoundButton2.getContext(), resourceId));
                    }
                }
                i11 = R$styleable.CompoundButton_buttonTint;
                if (obtainStyledAttributes.hasValue(i11)) {
                    androidx.core.widget.g.c(this.f1514a, obtainStyledAttributes.getColorStateList(i11));
                }
                i12 = R$styleable.CompoundButton_buttonTintMode;
                if (obtainStyledAttributes.hasValue(i12)) {
                    androidx.core.widget.g.d(this.f1514a, o1.e(obtainStyledAttributes.getInt(i12, -1), null));
                }
            }
            z10 = false;
            if (!z10) {
            }
            i11 = R$styleable.CompoundButton_buttonTint;
            if (obtainStyledAttributes.hasValue(i11)) {
            }
            i12 = R$styleable.CompoundButton_buttonTintMode;
            if (obtainStyledAttributes.hasValue(i12)) {
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void f() {
        if (this.f1519f) {
            this.f1519f = false;
        } else {
            this.f1519f = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.f1515b = colorStateList;
        this.f1517d = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.f1516c = mode;
        this.f1518e = true;
        a();
    }
}
