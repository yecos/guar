package com.zhy.autolayout.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes3.dex */
public class ScreenUtils {
    public static int[] getScreenSize(Context context, boolean z10) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (!z10) {
            iArr[0] = i10;
            iArr[1] = i11 - getStatusBarHeight(context);
            return iArr;
        }
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i10 = point.x;
            i11 = point.y;
        } catch (Exception unused) {
        }
        iArr[0] = i10;
        iArr[1] = i11;
        return iArr;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Resources.NotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
