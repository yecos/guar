package com.hpplay.common.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    private ScreenUtil() {
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
            LeLog.w(TAG, e10);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        LeLog.i("ScreenUtils", " widthPixels  " + i10 + " heightPixels " + i11);
        return iArr;
    }

    public static int getScreenHeight(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        LeLog.i(TAG, "getScreenWidth fail  context is:" + context);
        return -1;
    }

    public static int getScreenWidth(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        LeLog.i(TAG, "getScreenWidth fail  context is:" + context);
        return -1;
    }
}
