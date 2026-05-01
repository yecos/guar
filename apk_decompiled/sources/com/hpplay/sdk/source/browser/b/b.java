package com.hpplay.sdk.source.browser.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hpplay.common.log.LeLog;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7464a = "DisplayMetricsUtil";

    /* renamed from: b, reason: collision with root package name */
    public static int f7465b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static int f7466c = -1;

    public static int a(Context context, double d10) {
        if (f7465b <= 0) {
            a(context);
        }
        int i10 = f7465b;
        if (i10 <= 0) {
            return (int) d10;
        }
        double min = Math.min(f7466c, i10);
        Double.isNaN(min);
        return (int) ((d10 * min) / 750.0d);
    }

    public static int b(Context context, double d10) {
        if (f7465b <= 0) {
            a(context);
        }
        if (f7465b <= 0) {
            return (int) d10;
        }
        LeLog.i(f7464a, "getRelativeWidth SCREEN_WIDTH:" + f7465b + ", SCREEN_HEIGHT:" + f7466c);
        double max = (double) Math.max(f7466c, f7465b);
        Double.isNaN(max);
        return (int) ((d10 * max) / 1624.0d);
    }

    public static int c(Context context) {
        int a10;
        if (context == null) {
            return f7466c;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            a10 = displayMetrics.heightPixels;
        } catch (Exception e10) {
            LeLog.w(f7464a, e10);
            a10 = a(context);
        }
        return a10 <= 0 ? a(context) : a10;
    }

    public static void d(Context context) {
        a(context);
    }

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        f7465b = displayMetrics.widthPixels;
        int i10 = displayMetrics.heightPixels;
        f7466c = i10;
        return i10;
    }

    public static int b(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f7465b = displayMetrics.widthPixels;
            f7466c = c(context);
        } catch (Exception e10) {
            LeLog.w(f7464a, "getScreenWidth failed " + e10);
        }
        return f7465b;
    }
}
