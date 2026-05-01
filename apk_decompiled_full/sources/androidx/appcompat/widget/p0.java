package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
import java.util.Locale;
import q.h;

/* loaded from: classes.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1571a;

    /* renamed from: b, reason: collision with root package name */
    public p2 f1572b;

    /* renamed from: c, reason: collision with root package name */
    public p2 f1573c;

    /* renamed from: d, reason: collision with root package name */
    public p2 f1574d;

    /* renamed from: e, reason: collision with root package name */
    public p2 f1575e;

    /* renamed from: f, reason: collision with root package name */
    public p2 f1576f;

    /* renamed from: g, reason: collision with root package name */
    public p2 f1577g;

    /* renamed from: h, reason: collision with root package name */
    public p2 f1578h;

    /* renamed from: i, reason: collision with root package name */
    public final e1 f1579i;

    /* renamed from: j, reason: collision with root package name */
    public int f1580j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1581k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f1582l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1583m;

    public static class a extends h.c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f1584a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1585b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1586c;

        /* renamed from: androidx.appcompat.widget.p0$a$a, reason: collision with other inner class name */
        public class RunnableC0020a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f1587a;

            /* renamed from: b, reason: collision with root package name */
            public final Typeface f1588b;

            public RunnableC0020a(WeakReference weakReference, Typeface typeface) {
                this.f1587a = weakReference;
                this.f1588b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                p0 p0Var = (p0) this.f1587a.get();
                if (p0Var == null) {
                    return;
                }
                p0Var.B(this.f1588b);
            }
        }

        public a(p0 p0Var, int i10, int i11) {
            this.f1584a = new WeakReference(p0Var);
            this.f1585b = i10;
            this.f1586c = i11;
        }

        @Override // q.h.c
        public void onFontRetrievalFailed(int i10) {
        }

        @Override // q.h.c
        public void onFontRetrieved(Typeface typeface) {
            int i10;
            p0 p0Var = (p0) this.f1584a.get();
            if (p0Var == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1585b) != -1) {
                typeface = Typeface.create(typeface, i10, (this.f1586c & 2) != 0);
            }
            p0Var.q(new RunnableC0020a(this.f1584a, typeface));
        }
    }

    public p0(TextView textView) {
        this.f1571a = textView;
        this.f1579i = new e1(textView);
    }

    public static p2 d(Context context, k kVar, int i10) {
        ColorStateList f10 = kVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        p2 p2Var = new p2();
        p2Var.f1593d = true;
        p2Var.f1590a = f10;
        return p2Var;
    }

    public final void A(int i10, float f10) {
        this.f1579i.v(i10, f10);
    }

    public void B(Typeface typeface) {
        if (this.f1583m) {
            this.f1571a.setTypeface(typeface);
            this.f1582l = typeface;
        }
    }

    public final void C(Context context, r2 r2Var) {
        String o10;
        Typeface create;
        Typeface create2;
        this.f1580j = r2Var.k(R$styleable.TextAppearance_android_textStyle, this.f1580j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int k10 = r2Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1581k = k10;
            if (k10 != -1) {
                this.f1580j = (this.f1580j & 2) | 0;
            }
        }
        int i11 = R$styleable.TextAppearance_android_fontFamily;
        if (!r2Var.r(i11) && !r2Var.r(R$styleable.TextAppearance_fontFamily)) {
            int i12 = R$styleable.TextAppearance_android_typeface;
            if (r2Var.r(i12)) {
                this.f1583m = false;
                int k11 = r2Var.k(i12, 1);
                if (k11 == 1) {
                    this.f1582l = Typeface.SANS_SERIF;
                    return;
                } else if (k11 == 2) {
                    this.f1582l = Typeface.SERIF;
                    return;
                } else {
                    if (k11 != 3) {
                        return;
                    }
                    this.f1582l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1582l = null;
        int i13 = R$styleable.TextAppearance_fontFamily;
        if (r2Var.r(i13)) {
            i11 = i13;
        }
        int i14 = this.f1581k;
        int i15 = this.f1580j;
        if (!context.isRestricted()) {
            try {
                Typeface j10 = r2Var.j(i11, this.f1580j, new a(this, i14, i15));
                if (j10 != null) {
                    if (i10 < 28 || this.f1581k == -1) {
                        this.f1582l = j10;
                    } else {
                        create2 = Typeface.create(Typeface.create(j10, 0), this.f1581k, (this.f1580j & 2) != 0);
                        this.f1582l = create2;
                    }
                }
                this.f1583m = this.f1582l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1582l != null || (o10 = r2Var.o(i11)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1581k == -1) {
            this.f1582l = Typeface.create(o10, this.f1580j);
        } else {
            create = Typeface.create(Typeface.create(o10, 0), this.f1581k, (this.f1580j & 2) != 0);
            this.f1582l = create;
        }
    }

    public final void a(Drawable drawable, p2 p2Var) {
        if (drawable == null || p2Var == null) {
            return;
        }
        k.i(drawable, p2Var, this.f1571a.getDrawableState());
    }

    public void b() {
        if (this.f1572b != null || this.f1573c != null || this.f1574d != null || this.f1575e != null) {
            Drawable[] compoundDrawables = this.f1571a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1572b);
            a(compoundDrawables[1], this.f1573c);
            a(compoundDrawables[2], this.f1574d);
            a(compoundDrawables[3], this.f1575e);
        }
        if (this.f1576f == null && this.f1577g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1571a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1576f);
        a(compoundDrawablesRelative[2], this.f1577g);
    }

    public void c() {
        this.f1579i.a();
    }

    public int e() {
        return this.f1579i.h();
    }

    public int f() {
        return this.f1579i.i();
    }

    public int g() {
        return this.f1579i.j();
    }

    public int[] h() {
        return this.f1579i.k();
    }

    public int i() {
        return this.f1579i.l();
    }

    public ColorStateList j() {
        p2 p2Var = this.f1578h;
        if (p2Var != null) {
            return p2Var.f1590a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        p2 p2Var = this.f1578h;
        if (p2Var != null) {
            return p2Var.f1591b;
        }
        return null;
    }

    public boolean l() {
        return this.f1579i.p();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AttributeSet attributeSet, int i10) {
        ColorStateList colorStateList;
        String str;
        ColorStateList colorStateList2;
        String str2;
        ColorStateList colorStateList3;
        boolean z10;
        boolean z11;
        ColorStateList colorStateList4;
        int i11;
        ColorStateList colorStateList5;
        int i12;
        k kVar;
        Typeface typeface;
        r2 t10;
        int i13;
        int i14;
        int i15;
        int f10;
        int f11;
        int f12;
        int[] k10;
        int autoSizeStepGranularity;
        Locale forLanguageTag;
        LocaleList forLanguageTags;
        Context context = this.f1571a.getContext();
        k b10 = k.b();
        r2 u10 = r2.u(context, attributeSet, R$styleable.f815m, i10, 0);
        int n10 = u10.n(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i16 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (u10.r(i16)) {
            this.f1572b = d(context, b10, u10.n(i16, 0));
        }
        int i17 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (u10.r(i17)) {
            this.f1573c = d(context, b10, u10.n(i17, 0));
        }
        int i18 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (u10.r(i18)) {
            this.f1574d = d(context, b10, u10.n(i18, 0));
        }
        int i19 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (u10.r(i19)) {
            this.f1575e = d(context, b10, u10.n(i19, 0));
        }
        int i20 = Build.VERSION.SDK_INT;
        int i21 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (u10.r(i21)) {
            this.f1576f = d(context, b10, u10.n(i21, 0));
        }
        int i22 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (u10.r(i22)) {
            this.f1577g = d(context, b10, u10.n(i22, 0));
        }
        u10.v();
        boolean z12 = this.f1571a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n10 != -1) {
            r2 s10 = r2.s(context, n10, R$styleable.L);
            if (!z12) {
                int i23 = R$styleable.TextAppearance_textAllCaps;
                if (s10.r(i23)) {
                    z10 = s10.a(i23, false);
                    z11 = true;
                    C(context, s10);
                    if (i20 >= 23) {
                        int i24 = R$styleable.TextAppearance_android_textColor;
                        colorStateList2 = s10.r(i24) ? s10.c(i24) : null;
                        int i25 = R$styleable.TextAppearance_android_textColorHint;
                        colorStateList3 = s10.r(i25) ? s10.c(i25) : null;
                        int i26 = R$styleable.TextAppearance_android_textColorLink;
                        colorStateList = s10.r(i26) ? s10.c(i26) : null;
                    } else {
                        colorStateList = null;
                        colorStateList2 = null;
                        colorStateList3 = null;
                    }
                    int i27 = R$styleable.TextAppearance_textLocale;
                    str2 = !s10.r(i27) ? s10.o(i27) : null;
                    if (i20 >= 26) {
                        int i28 = R$styleable.TextAppearance_fontVariationSettings;
                        if (s10.r(i28)) {
                            str = s10.o(i28);
                            s10.v();
                        }
                    }
                    str = null;
                    s10.v();
                }
            }
            z10 = false;
            z11 = false;
            C(context, s10);
            if (i20 >= 23) {
            }
            int i272 = R$styleable.TextAppearance_textLocale;
            if (!s10.r(i272)) {
            }
            if (i20 >= 26) {
            }
            str = null;
            s10.v();
        } else {
            colorStateList = null;
            str = null;
            colorStateList2 = null;
            str2 = null;
            colorStateList3 = null;
            z10 = false;
            z11 = false;
        }
        r2 u11 = r2.u(context, attributeSet, R$styleable.L, i10, 0);
        if (!z12) {
            int i29 = R$styleable.TextAppearance_textAllCaps;
            if (u11.r(i29)) {
                colorStateList4 = colorStateList;
                z10 = u11.a(i29, false);
                i11 = 23;
                z11 = true;
                if (i20 < i11) {
                    int i30 = R$styleable.TextAppearance_android_textColor;
                    if (u11.r(i30)) {
                        colorStateList2 = u11.c(i30);
                    }
                    int i31 = R$styleable.TextAppearance_android_textColorHint;
                    if (u11.r(i31)) {
                        colorStateList3 = u11.c(i31);
                    }
                    int i32 = R$styleable.TextAppearance_android_textColorLink;
                    if (u11.r(i32)) {
                        colorStateList5 = u11.c(i32);
                        i12 = R$styleable.TextAppearance_textLocale;
                        if (u11.r(i12)) {
                            str2 = u11.o(i12);
                        }
                        if (i20 >= 26) {
                            int i33 = R$styleable.TextAppearance_fontVariationSettings;
                            if (u11.r(i33)) {
                                str = u11.o(i33);
                            }
                        }
                        if (i20 >= 28) {
                            int i34 = R$styleable.TextAppearance_android_textSize;
                            if (u11.r(i34)) {
                                kVar = b10;
                                if (u11.f(i34, -1) == 0) {
                                    this.f1571a.setTextSize(0, 0.0f);
                                }
                                C(context, u11);
                                u11.v();
                                if (colorStateList2 != null) {
                                    this.f1571a.setTextColor(colorStateList2);
                                }
                                if (colorStateList3 != null) {
                                    this.f1571a.setHintTextColor(colorStateList3);
                                }
                                if (colorStateList5 != null) {
                                    this.f1571a.setLinkTextColor(colorStateList5);
                                }
                                if (!z12 && z11) {
                                    r(z10);
                                }
                                typeface = this.f1582l;
                                if (typeface != null) {
                                    if (this.f1581k == -1) {
                                        this.f1571a.setTypeface(typeface, this.f1580j);
                                    } else {
                                        this.f1571a.setTypeface(typeface);
                                    }
                                }
                                if (str != null) {
                                    this.f1571a.setFontVariationSettings(str);
                                }
                                if (str2 != null) {
                                    if (i20 >= 24) {
                                        TextView textView = this.f1571a;
                                        forLanguageTags = LocaleList.forLanguageTags(str2);
                                        textView.setTextLocales(forLanguageTags);
                                    } else if (i20 >= 21) {
                                        String substring = str2.substring(0, str2.indexOf(44));
                                        TextView textView2 = this.f1571a;
                                        forLanguageTag = Locale.forLanguageTag(substring);
                                        textView2.setTextLocale(forLanguageTag);
                                    }
                                }
                                this.f1579i.q(attributeSet, i10);
                                if (androidx.core.widget.b.P && this.f1579i.l() != 0) {
                                    k10 = this.f1579i.k();
                                    if (k10.length > 0) {
                                        autoSizeStepGranularity = this.f1571a.getAutoSizeStepGranularity();
                                        if (autoSizeStepGranularity != -1.0f) {
                                            this.f1571a.setAutoSizeTextTypeUniformWithConfiguration(this.f1579i.i(), this.f1579i.h(), this.f1579i.j(), 0);
                                        } else {
                                            this.f1571a.setAutoSizeTextTypeUniformWithPresetSizes(k10, 0);
                                        }
                                    }
                                }
                                t10 = r2.t(context, attributeSet, R$styleable.f816n);
                                int n11 = t10.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                                k kVar2 = kVar;
                                Drawable c10 = n11 == -1 ? kVar2.c(context, n11) : null;
                                int n12 = t10.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                                Drawable c11 = n12 == -1 ? kVar2.c(context, n12) : null;
                                int n13 = t10.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                                Drawable c12 = n13 == -1 ? kVar2.c(context, n13) : null;
                                int n14 = t10.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                                Drawable c13 = n14 == -1 ? kVar2.c(context, n14) : null;
                                int n15 = t10.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                                Drawable c14 = n15 == -1 ? kVar2.c(context, n15) : null;
                                int n16 = t10.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                                x(c10, c11, c12, c13, c14, n16 == -1 ? kVar2.c(context, n16) : null);
                                i13 = R$styleable.AppCompatTextView_drawableTint;
                                if (t10.r(i13)) {
                                    androidx.core.widget.e0.h(this.f1571a, t10.c(i13));
                                }
                                i14 = R$styleable.AppCompatTextView_drawableTintMode;
                                if (t10.r(i14)) {
                                    i15 = -1;
                                } else {
                                    i15 = -1;
                                    androidx.core.widget.e0.i(this.f1571a, o1.e(t10.k(i14, -1), null));
                                }
                                f10 = t10.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
                                f11 = t10.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
                                f12 = t10.f(R$styleable.AppCompatTextView_lineHeight, i15);
                                t10.v();
                                if (f10 != i15) {
                                    androidx.core.widget.e0.k(this.f1571a, f10);
                                }
                                if (f11 != i15) {
                                    androidx.core.widget.e0.l(this.f1571a, f11);
                                }
                                if (f12 == i15) {
                                    androidx.core.widget.e0.m(this.f1571a, f12);
                                    return;
                                }
                                return;
                            }
                        }
                        kVar = b10;
                        C(context, u11);
                        u11.v();
                        if (colorStateList2 != null) {
                        }
                        if (colorStateList3 != null) {
                        }
                        if (colorStateList5 != null) {
                        }
                        if (!z12) {
                            r(z10);
                        }
                        typeface = this.f1582l;
                        if (typeface != null) {
                        }
                        if (str != null) {
                        }
                        if (str2 != null) {
                        }
                        this.f1579i.q(attributeSet, i10);
                        if (androidx.core.widget.b.P) {
                            k10 = this.f1579i.k();
                            if (k10.length > 0) {
                            }
                        }
                        t10 = r2.t(context, attributeSet, R$styleable.f816n);
                        int n112 = t10.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                        k kVar22 = kVar;
                        if (n112 == -1) {
                        }
                        int n122 = t10.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                        if (n122 == -1) {
                        }
                        int n132 = t10.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                        if (n132 == -1) {
                        }
                        int n142 = t10.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                        if (n142 == -1) {
                        }
                        int n152 = t10.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                        if (n152 == -1) {
                        }
                        int n162 = t10.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                        x(c10, c11, c12, c13, c14, n162 == -1 ? kVar22.c(context, n162) : null);
                        i13 = R$styleable.AppCompatTextView_drawableTint;
                        if (t10.r(i13)) {
                        }
                        i14 = R$styleable.AppCompatTextView_drawableTintMode;
                        if (t10.r(i14)) {
                        }
                        f10 = t10.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
                        f11 = t10.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
                        f12 = t10.f(R$styleable.AppCompatTextView_lineHeight, i15);
                        t10.v();
                        if (f10 != i15) {
                        }
                        if (f11 != i15) {
                        }
                        if (f12 == i15) {
                        }
                    }
                }
                colorStateList5 = colorStateList4;
                i12 = R$styleable.TextAppearance_textLocale;
                if (u11.r(i12)) {
                }
                if (i20 >= 26) {
                }
                if (i20 >= 28) {
                }
                kVar = b10;
                C(context, u11);
                u11.v();
                if (colorStateList2 != null) {
                }
                if (colorStateList3 != null) {
                }
                if (colorStateList5 != null) {
                }
                if (!z12) {
                }
                typeface = this.f1582l;
                if (typeface != null) {
                }
                if (str != null) {
                }
                if (str2 != null) {
                }
                this.f1579i.q(attributeSet, i10);
                if (androidx.core.widget.b.P) {
                }
                t10 = r2.t(context, attributeSet, R$styleable.f816n);
                int n1122 = t10.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                k kVar222 = kVar;
                if (n1122 == -1) {
                }
                int n1222 = t10.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                if (n1222 == -1) {
                }
                int n1322 = t10.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                if (n1322 == -1) {
                }
                int n1422 = t10.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (n1422 == -1) {
                }
                int n1522 = t10.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                if (n1522 == -1) {
                }
                int n1622 = t10.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                x(c10, c11, c12, c13, c14, n1622 == -1 ? kVar222.c(context, n1622) : null);
                i13 = R$styleable.AppCompatTextView_drawableTint;
                if (t10.r(i13)) {
                }
                i14 = R$styleable.AppCompatTextView_drawableTintMode;
                if (t10.r(i14)) {
                }
                f10 = t10.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
                f11 = t10.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
                f12 = t10.f(R$styleable.AppCompatTextView_lineHeight, i15);
                t10.v();
                if (f10 != i15) {
                }
                if (f11 != i15) {
                }
                if (f12 == i15) {
                }
            }
        }
        colorStateList4 = colorStateList;
        i11 = 23;
        if (i20 < i11) {
        }
        colorStateList5 = colorStateList4;
        i12 = R$styleable.TextAppearance_textLocale;
        if (u11.r(i12)) {
        }
        if (i20 >= 26) {
        }
        if (i20 >= 28) {
        }
        kVar = b10;
        C(context, u11);
        u11.v();
        if (colorStateList2 != null) {
        }
        if (colorStateList3 != null) {
        }
        if (colorStateList5 != null) {
        }
        if (!z12) {
        }
        typeface = this.f1582l;
        if (typeface != null) {
        }
        if (str != null) {
        }
        if (str2 != null) {
        }
        this.f1579i.q(attributeSet, i10);
        if (androidx.core.widget.b.P) {
        }
        t10 = r2.t(context, attributeSet, R$styleable.f816n);
        int n11222 = t10.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        k kVar2222 = kVar;
        if (n11222 == -1) {
        }
        int n12222 = t10.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        if (n12222 == -1) {
        }
        int n13222 = t10.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        if (n13222 == -1) {
        }
        int n14222 = t10.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (n14222 == -1) {
        }
        int n15222 = t10.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        if (n15222 == -1) {
        }
        int n16222 = t10.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        x(c10, c11, c12, c13, c14, n16222 == -1 ? kVar2222.c(context, n16222) : null);
        i13 = R$styleable.AppCompatTextView_drawableTint;
        if (t10.r(i13)) {
        }
        i14 = R$styleable.AppCompatTextView_drawableTintMode;
        if (t10.r(i14)) {
        }
        f10 = t10.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
        f11 = t10.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
        f12 = t10.f(R$styleable.AppCompatTextView_lineHeight, i15);
        t10.v();
        if (f10 != i15) {
        }
        if (f11 != i15) {
        }
        if (f12 == i15) {
        }
    }

    public void n(boolean z10, int i10, int i11, int i12, int i13) {
        if (androidx.core.widget.b.P) {
            return;
        }
        c();
    }

    public void o() {
        b();
    }

    public void p(Context context, int i10) {
        String o10;
        ColorStateList c10;
        r2 s10 = r2.s(context, i10, R$styleable.L);
        int i11 = R$styleable.TextAppearance_textAllCaps;
        if (s10.r(i11)) {
            r(s10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = R$styleable.TextAppearance_android_textColor;
            if (s10.r(i13) && (c10 = s10.c(i13)) != null) {
                this.f1571a.setTextColor(c10);
            }
        }
        int i14 = R$styleable.TextAppearance_android_textSize;
        if (s10.r(i14) && s10.f(i14, -1) == 0) {
            this.f1571a.setTextSize(0, 0.0f);
        }
        C(context, s10);
        if (i12 >= 26) {
            int i15 = R$styleable.TextAppearance_fontVariationSettings;
            if (s10.r(i15) && (o10 = s10.o(i15)) != null) {
                this.f1571a.setFontVariationSettings(o10);
            }
        }
        s10.v();
        Typeface typeface = this.f1582l;
        if (typeface != null) {
            this.f1571a.setTypeface(typeface, this.f1580j);
        }
    }

    public void q(Runnable runnable) {
        this.f1571a.post(runnable);
    }

    public void r(boolean z10) {
        this.f1571a.setAllCaps(z10);
    }

    public void s(int i10, int i11, int i12, int i13) {
        this.f1579i.r(i10, i11, i12, i13);
    }

    public void t(int[] iArr, int i10) {
        this.f1579i.s(iArr, i10);
    }

    public void u(int i10) {
        this.f1579i.t(i10);
    }

    public void v(ColorStateList colorStateList) {
        if (this.f1578h == null) {
            this.f1578h = new p2();
        }
        p2 p2Var = this.f1578h;
        p2Var.f1590a = colorStateList;
        p2Var.f1593d = colorStateList != null;
        y();
    }

    public void w(PorterDuff.Mode mode) {
        if (this.f1578h == null) {
            this.f1578h = new p2();
        }
        p2 p2Var = this.f1578h;
        p2Var.f1591b = mode;
        p2Var.f1592c = mode != null;
        y();
    }

    public final void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1571a.getCompoundDrawablesRelative();
            TextView textView = this.f1571a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1571a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            TextView textView2 = this.f1571a;
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1571a.getCompoundDrawables();
        TextView textView3 = this.f1571a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void y() {
        p2 p2Var = this.f1578h;
        this.f1572b = p2Var;
        this.f1573c = p2Var;
        this.f1574d = p2Var;
        this.f1575e = p2Var;
        this.f1576f = p2Var;
        this.f1577g = p2Var;
    }

    public void z(int i10, float f10) {
        if (androidx.core.widget.b.P || l()) {
            return;
        }
        A(i10, f10);
    }
}
