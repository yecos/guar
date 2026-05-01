package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CastState {
    public static final int CONNECTED = 4;
    public static final int CONNECTING = 3;
    public static final int NOT_CONNECTED = 2;
    public static final int NO_DEVICES_AVAILABLE = 1;

    private CastState() {
    }

    @RecentlyNonNull
    public static String toString(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? String.format(Locale.ROOT, "UNKNOWN_STATE(%d)", Integer.valueOf(i10)) : "CONNECTED" : "CONNECTING" : "NOT_CONNECTED" : "NO_DEVICES_AVAILABLE";
    }
}
