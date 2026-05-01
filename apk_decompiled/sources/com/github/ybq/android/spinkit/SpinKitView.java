package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.ybq.android.library.R$attr;
import com.github.ybq.android.library.R$style;
import com.github.ybq.android.library.R$styleable;
import h4.e;
import i4.b;
import i4.c;
import i4.d;
import i4.f;
import i4.g;
import i4.h;
import i4.i;
import i4.j;

/* loaded from: classes.dex */
public class SpinKitView extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    public e4.a f6761a;

    /* renamed from: b, reason: collision with root package name */
    public int f6762b;

    /* renamed from: c, reason: collision with root package name */
    public e f6763c;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6764a;

        static {
            int[] iArr = new int[e4.a.values().length];
            f6764a = iArr;
            try {
                iArr[e4.a.ROTATING_PLANE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6764a[e4.a.DOUBLE_BOUNCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6764a[e4.a.WAVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6764a[e4.a.WANDERING_CUBES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6764a[e4.a.PULSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6764a[e4.a.CHASING_DOTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6764a[e4.a.THREE_BOUNCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6764a[e4.a.CIRCLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6764a[e4.a.CUBE_GRID.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6764a[e4.a.FADING_CIRCLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6764a[e4.a.FOLDING_CUBE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.SpinKitViewStyle);
    }

    public final void a() {
        switch (a.f6764a[this.f6761a.ordinal()]) {
            case 1:
                setIndeterminateDrawable((e) new h());
                break;
            case 2:
                setIndeterminateDrawable((e) new d());
                break;
            case 3:
                setIndeterminateDrawable((e) new h());
                break;
            case 4:
                setIndeterminateDrawable((e) new j());
                break;
            case 5:
                setIndeterminateDrawable((e) new g());
                break;
            case 6:
                setIndeterminateDrawable((e) new i4.a());
                break;
            case 7:
                setIndeterminateDrawable((e) new i());
                break;
            case 8:
                setIndeterminateDrawable((e) new b());
                break;
            case 9:
                setIndeterminateDrawable((e) new c());
                break;
            case 10:
                setIndeterminateDrawable((e) new i4.e());
                break;
            case 11:
                setIndeterminateDrawable((e) new f());
                break;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (!(drawable instanceof e)) {
            throw new IllegalArgumentException();
        }
        setIndeterminateDrawable((e) drawable);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawableTiled(Drawable drawable) {
        super.setIndeterminateDrawableTiled(drawable);
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R$style.SpinKitView);
    }

    @Override // android.widget.ProgressBar
    public e getIndeterminateDrawable() {
        return this.f6763c;
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f6760a, i10, i11);
        this.f6761a = e4.a.values()[obtainStyledAttributes.getInt(R$styleable.SpinKitView_SpinKit_Style, 0)];
        this.f6762b = obtainStyledAttributes.getColor(R$styleable.SpinKitView_SpinKit_Color, -1);
        obtainStyledAttributes.recycle();
        a();
        setIndeterminate(true);
    }

    public void setIndeterminateDrawable(e eVar) {
        super.setIndeterminateDrawable((Drawable) eVar);
        this.f6763c = eVar;
        eVar.t(this.f6762b);
    }
}
