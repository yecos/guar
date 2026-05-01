package com.hpplay.cybergarage.util;

/* loaded from: classes2.dex */
public final class TimerUtil {
    public static final void wait(int i10) {
        try {
            Thread.sleep(i10);
        } catch (Exception unused) {
        }
    }

    public static final void waitRandom(int i10) {
        double random = Math.random();
        Double.isNaN(i10);
        try {
            Thread.sleep((int) (random * r2));
        } catch (Exception unused) {
        }
    }
}
