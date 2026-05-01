package com.umeng.umzid;

import android.content.Context;
import android.os.Build;

/* loaded from: classes3.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID(Build.VERSION.SDK_INT >= 29);
        }
        return null;
    }

    public static native String getNativeID(boolean z10);

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z10, boolean z11, boolean z12);

    public static synchronized String getTag(Context context) {
        boolean j10;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    j10 = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                j10 = false;
            }
            nativeTag = getNativeTag(j10, context != null ? d.i(context) : false, Build.VERSION.SDK_INT >= 29);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
