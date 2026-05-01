package com.zhy.autolayout.utils;

import android.util.TypedValue;

/* loaded from: classes3.dex */
public class DimenUtils {
    private static int getComplexUnit(int i10) {
        return (i10 >> 0) & 15;
    }

    public static boolean isPxVal(TypedValue typedValue) {
        return typedValue != null && typedValue.type == 5 && getComplexUnit(typedValue.data) == 0;
    }
}
