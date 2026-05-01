package com.efs.sdk.base.integrationtesting;

/* loaded from: classes.dex */
public class IntegrationTestingUtil {
    private static boolean sIsInPeriod = false;

    public static boolean isIntegrationTestingInPeriod() {
        return sIsInPeriod;
    }

    public static void setIntegrationTestingInPeriod(boolean z10) {
        sIsInPeriod = z10;
    }
}
