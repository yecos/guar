package com.umeng.message.proguard;

import android.content.res.Resources;

/* loaded from: classes3.dex */
public final class bo {
    public static int a(float f10) {
        return Math.round(Resources.getSystem().getDisplayMetrics().density * f10);
    }

    public static int a() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
