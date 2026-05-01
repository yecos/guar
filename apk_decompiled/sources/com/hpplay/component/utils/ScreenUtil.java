package com.hpplay.component.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    private ScreenUtil() {
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getDensityDpi(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return 0;
    }

    public static int[] getRelScreenSize(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i10 = point.x;
            i11 = point.y;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        CLog.d("ScreenUtils", " widthPixels  " + i10 + " heightPixels " + i11);
        return iArr;
    }

    public static int getScreenHeight(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        CLog.i(TAG, "getScreenWidth fail  context is: null");
        return -1;
    }

    private static double getScreenInches(Context context) {
        double sqrt = Math.sqrt(Math.pow(getScreenWidth(context), 2.0d) + Math.pow(getScreenHeight(context), 2.0d));
        double densityDpi = getDensityDpi(context);
        Double.isNaN(densityDpi);
        return sqrt / densityDpi;
    }

    public static int getScreenWidth(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        CLog.i(TAG, "getScreenWidth fail  context is: null");
        return -1;
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i10 = rect.top;
        if (i10 > 0) {
            return i10;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e10) {
            e10.printStackTrace();
            return i10;
        }
    }
}
