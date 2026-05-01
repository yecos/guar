package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public final class zzcn {
    public static final int zza;

    static {
        int i10 = Build.VERSION.SDK_INT;
        zza = i10 >= 23 ? 67108864 : 0;
        if (i10 < 31 && i10 >= 30) {
            String str = Build.VERSION.CODENAME;
            if (str.length() != 1 || str.charAt(0) < 'S') {
                return;
            }
            str.charAt(0);
        }
    }

    public static PendingIntent zza(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getActivity(context, i10, intent, i11);
    }

    public static PendingIntent zzb(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getBroadcast(context, i10, intent, i11);
    }
}
