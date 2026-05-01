package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class zzd extends zza<Integer> {
    public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) com.google.android.gms.internal.flags.zze.zza(new zze(sharedPreferences, str, num));
        } catch (Exception e10) {
            String valueOf = String.valueOf(e10.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            }
            return num;
        }
    }
}
