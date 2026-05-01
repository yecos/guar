package com.zhy.autolayout.utils;

import android.view.View;
import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.R;
import com.zhy.autolayout.config.AutoLayoutConifg;

/* loaded from: classes3.dex */
public class AutoUtils {
    public static void auto(View view) {
        autoSize(view);
        autoPadding(view);
        autoMargin(view);
        autoTextSize(view, 3);
    }

    public static void autoMargin(View view) {
        auto(view, 16, 3);
    }

    public static void autoPadding(View view) {
        auto(view, 8, 3);
    }

    public static void autoSize(View view) {
        auto(view, 3, 3);
    }

    public static void autoTextSize(View view) {
        auto(view, 4, 3);
    }

    public static boolean autoed(View view) {
        int i10 = R.id.id_tag_autolayout_size;
        if (view.getTag(i10) != null) {
            return true;
        }
        view.setTag(i10, "Just Identify");
        return false;
    }

    public static float getPercentHeight1px() {
        return (AutoLayoutConifg.getInstance().getScreenHeight() * 1.0f) / AutoLayoutConifg.getInstance().getDesignHeight();
    }

    public static int getPercentHeightSize(int i10) {
        return (int) (((i10 * 1.0f) / AutoLayoutConifg.getInstance().getDesignHeight()) * AutoLayoutConifg.getInstance().getScreenHeight());
    }

    public static int getPercentHeightSizeBigger(int i10) {
        int screenHeight = AutoLayoutConifg.getInstance().getScreenHeight();
        int designHeight = AutoLayoutConifg.getInstance().getDesignHeight();
        int i11 = i10 * screenHeight;
        return i11 % designHeight == 0 ? i11 / designHeight : (i11 / designHeight) + 1;
    }

    public static float getPercentWidth1px() {
        return (AutoLayoutConifg.getInstance().getScreenWidth() * 1.0f) / AutoLayoutConifg.getInstance().getDesignWidth();
    }

    public static int getPercentWidthSize(int i10) {
        return (int) (((i10 * 1.0f) / AutoLayoutConifg.getInstance().getDesignWidth()) * AutoLayoutConifg.getInstance().getScreenWidth());
    }

    public static int getPercentWidthSizeBigger(int i10) {
        int screenWidth = AutoLayoutConifg.getInstance().getScreenWidth();
        int designWidth = AutoLayoutConifg.getInstance().getDesignWidth();
        int i11 = i10 * screenWidth;
        return i11 % designWidth == 0 ? i11 / designWidth : (i11 / designWidth) + 1;
    }

    public static void autoMargin(View view, int i10) {
        auto(view, 16, i10);
    }

    public static void autoPadding(View view, int i10) {
        auto(view, 8, i10);
    }

    public static void autoSize(View view, int i10) {
        auto(view, 3, i10);
    }

    public static void autoTextSize(View view, int i10) {
        auto(view, 4, i10);
    }

    public static void auto(View view, int i10, int i11) {
        AutoLayoutInfo attrFromView = AutoLayoutInfo.getAttrFromView(view, i10, i11);
        if (attrFromView != null) {
            attrFromView.fillAttrs(view);
        }
    }
}
