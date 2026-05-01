package com.efs.sdk.base.samplingwhitelist;

/* loaded from: classes.dex */
public class SamplingWhiteListUtil {
    private static boolean sHitWL = false;

    public static boolean isHitWL() {
        return sHitWL;
    }

    public static void setHitWL(boolean z10) {
        sHitWL = z10;
    }
}
