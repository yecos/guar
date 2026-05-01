package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* loaded from: classes3.dex */
public final class ed {
    public static int a(float f10) {
        return Math.round(Resources.getSystem().getDisplayMetrics().density * f10);
    }

    public static Point a(Context context) {
        Point point = new Point();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        } catch (Throwable unused) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
        }
        return point;
    }

    public static float a(Point point) {
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            return Math.round(Math.sqrt(Math.pow(point.x / displayMetrics.xdpi, 2.0d) + Math.pow(point.y / displayMetrics.ydpi, 2.0d)) * 100.0d) / 100.0f;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean a(Activity activity) {
        if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            Point a10 = a((Context) activity);
            return width != a10.x && height <= (a10.y * 2) / 3;
        }
        throw new IllegalArgumentException("activity cant be null!");
    }
}
