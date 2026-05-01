package com.google.firebase.platforminfo;

import h9.e;

/* loaded from: classes2.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return e.f14218f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
