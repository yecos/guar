package com.zhy.autolayout.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.zhy.autolayout.utils.L;
import com.zhy.autolayout.utils.ScreenUtils;

/* loaded from: classes.dex */
public class AutoLayoutConifg {
    private static final String KEY_DESIGN_HEIGHT = "design_height";
    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static AutoLayoutConifg sIntance = new AutoLayoutConifg();
    private int mDesignHeight;
    private int mDesignWidth;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean useDeviceSize;

    private AutoLayoutConifg() {
    }

    public static AutoLayoutConifg getInstance() {
        return sIntance;
    }

    private void getMetaData(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                this.mDesignWidth = ((Integer) bundle.get(KEY_DESIGN_WIDTH)).intValue();
                this.mDesignHeight = ((Integer) applicationInfo.metaData.get(KEY_DESIGN_HEIGHT)).intValue();
            }
            L.e(" designWidth =" + this.mDesignWidth + " , designHeight = " + this.mDesignHeight);
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("you must set design_width and design_height  in your manifest file.", e10);
        }
    }

    public void checkParams() {
        if (this.mDesignHeight <= 0 || this.mDesignWidth <= 0) {
            throw new RuntimeException("you must set design_width and design_height  in your manifest file.");
        }
    }

    public int getDesignHeight() {
        return this.mDesignHeight;
    }

    public int getDesignWidth() {
        return this.mDesignWidth;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public void init(Context context) {
        getMetaData(context);
        L.e("init1screenWidth00 =" + this.mScreenWidth + " ,screenHeight = " + this.mScreenHeight);
        int[] screenSize = ScreenUtils.getScreenSize(context, this.useDeviceSize);
        this.mScreenWidth = screenSize[0];
        L.e("init1screenWidth11 =" + this.mScreenWidth + " ,screenHeight = " + this.mScreenHeight);
        float f10 = (((float) this.mDesignHeight) * 1.0f) / ((float) this.mDesignWidth);
        L.e("init1screenWidth =" + this.mScreenWidth + " ,screenHeight = " + this.mScreenHeight);
        float f11 = (((float) screenSize[1]) * 1.0f) / ((float) screenSize[0]);
        L.e("initscreenSize[0]:" + screenSize[0] + "initscreenSize[1]:" + screenSize[1] + ", mDesignRate =" + f10 + " ,screenRate = " + f11);
        if (f11 > f10) {
            this.mScreenHeight = (int) (screenSize[1] * (f10 / f11));
            L.e(" scale>ruleScale:screenHeight = " + this.mScreenHeight);
        } else {
            this.mScreenHeight = screenSize[1];
        }
        L.e("screenWidth =" + this.mScreenWidth + " ,screenHeight = " + this.mScreenHeight);
    }

    public AutoLayoutConifg useDeviceSize() {
        this.useDeviceSize = true;
        return this;
    }
}
