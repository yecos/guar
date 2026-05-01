package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public final class zzas {
    public static void zza(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }

    public static boolean zzb(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("googlecast-introOverlayShown", false);
    }
}
