package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.r2;
import d.b;

/* loaded from: classes2.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList c10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (c10 = b.c(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : c10;
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i11);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable d10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (d10 = b.d(context, resourceId)) == null) ? typedArray.getDrawable(i10) : d10;
    }

    public static int getIndexWithValue(TypedArray typedArray, int i10, int i11) {
        return typedArray.hasValue(i10) ? i10 : i11;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static ColorStateList getColorStateList(Context context, r2 r2Var, int i10) {
        int n10;
        ColorStateList c10;
        return (!r2Var.r(i10) || (n10 = r2Var.n(i10, 0)) == 0 || (c10 = b.c(context, n10)) == null) ? r2Var.c(i10) : c10;
    }
}
