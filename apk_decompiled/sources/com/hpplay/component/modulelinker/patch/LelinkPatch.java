package com.hpplay.component.modulelinker.patch;

/* loaded from: classes2.dex */
public class LelinkPatch {
    static {
        try {
            System.loadLibrary("hppatch");
        } catch (Exception unused) {
        }
    }

    public static native void genPatch(String str, String str2, String str3);

    public static native void mergePatch(String str, String str2, String str3);
}
