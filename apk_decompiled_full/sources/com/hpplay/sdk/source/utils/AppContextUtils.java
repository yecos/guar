package com.hpplay.sdk.source.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public class AppContextUtils {
    private static AppContextUtils sInstance;
    private Context mContext;

    private AppContextUtils() {
    }

    public static synchronized AppContextUtils getInstance() {
        AppContextUtils appContextUtils;
        synchronized (AppContextUtils.class) {
            if (sInstance == null) {
                synchronized (AppContextUtils.class) {
                    if (sInstance == null) {
                        sInstance = new AppContextUtils();
                    }
                }
            }
            appContextUtils = sInstance;
        }
        return appContextUtils;
    }

    public Context getAppContext() {
        return this.mContext;
    }

    public void setAppContext(Context context) {
        this.mContext = context.getApplicationContext();
    }
}
