package com.google.android.gms.internal.cast;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdi {
    private static final Logger zza = Logger.getLogger(zzdi.class.getName());
    private static final zzdh zzb = new zzdh(null);

    private zzdi() {
    }

    @CheckForNull
    public static String zza(@CheckForNull String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }
}
