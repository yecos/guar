package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.FlagRegistry;

/* loaded from: classes.dex */
public final class zzaa {
    public static final Flag<Boolean> zza = Flag.define(0, "gms:cast:remote_display_enabled", Boolean.FALSE);

    public static final void zza(Context context) {
        FlagRegistry.initialize(context);
    }
}
