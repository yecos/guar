package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1514a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.f820r
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L75
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L2b
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L75
            if (r5 == 0) goto L2b
            android.widget.CompoundButton r0 = r3.f1514a     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L75
            android.content.Context r1 = r0.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L75
            android.graphics.drawable.Drawable r5 = d.b.d(r1, r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L75
            r0.setButtonDrawable(r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L75
            r5 = 1
            goto L2c
        L2a:
        L2b:
            r5 = 0
        L2c:
            if (r5 != 0) goto L49
            int r5 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L75
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L49
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L75
            if (r5 == 0) goto L49
            android.widget.CompoundButton r0 = r3.f1514a     // Catch: java.lang.Throwable -> L75
            android.content.Context r1 = r0.getContext()     // Catch: java.lang.Throwable -> L75
            android.graphics.drawable.Drawable r5 = d.b.d(r1, r5)     // Catch: java.lang.Throwable -> L75
            r0.setButtonDrawable(r5)     // Catch: java.lang.Throwable -> L75
        L49:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L75
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L5a
            android.widget.CompoundButton r0 = r3.f1514a     // Catch: java.lang.Throwable -> L75
            android.content.res.ColorStateList r5 = r4.getColorStateList(r5)     // Catch: java.lang.Throwable -> L75
            androidx.core.widget.g.c(r0, r5)     // Catch: java.lang.Throwable -> L75
        L5a:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L75
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L71
            android.widget.CompoundButton r0 = r3.f1514a     // Catch: java.lang.Throwable -> L75
            r1 = -1
            int r5 = r4.getInt(r5, r1)     // Catch: java.lang.Throwable -> L75
            r1 = 0
            android.graphics.PorterDuff$Mode r5 = androidx.appcompat.widget.o1.e(r5, r1)     // Catch: java.lang.Throwable -> L75
            androidx.core.widget.g.d(r0, r5)     // Catch: java.lang.Throwable -> L75
        L71:
            r4.recycle()
            return
        L75:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.e(android.util.AttributeSet, int):void");
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
