package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.resources.MaterialAttributes;
import r.a;

/* loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    public static int getColor(View view, int i10) {
        return MaterialAttributes.resolveOrThrow(view, i10);
    }

    public static int layer(View view, int i10, int i11) {
        return layer(view, i10, i11, 1.0f);
    }

    public static int getColor(Context context, int i10, String str) {
        return MaterialAttributes.resolveOrThrow(context, i10, str);
    }

    public static int layer(View view, int i10, int i11, float f10) {
        return layer(getColor(view, i10), getColor(view, i11), f10);
    }

    public static int getColor(View view, int i10, int i11) {
        return getColor(view.getContext(), i10, i11);
    }

    public static int getColor(Context context, int i10, int i11) {
        TypedValue resolve = MaterialAttributes.resolve(context, i10);
        return resolve != null ? resolve.data : i11;
    }

    public static int layer(int i10, int i11, float f10) {
        return layer(i10, a.m(i11, Math.round(Color.alpha(i11) * f10)));
    }

    public static int layer(int i10, int i11) {
        return a.i(i11, i10);
    }
}
