package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.InputDevice;
import com.umeng.analytics.pro.q;

/* loaded from: classes3.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f8693a = new g1();

    public final boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen");
    }

    public final boolean b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        t9.i.f(configuration, "context.resources.configuration");
        return configuration.touchscreen != 1;
    }

    public final boolean c(Context context) {
        int length = InputDevice.getDeviceIds().length;
        for (int i10 = 0; i10 < length; i10++) {
            InputDevice device = InputDevice.getDevice(InputDevice.getDeviceIds()[i10]);
            if (device != null && (device.getSources() & q.a.f10522b) == 4098) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        return a(context) && b(context) && c(context);
    }
}
