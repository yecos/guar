package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzac extends com.google.android.gms.internal.cast.zzb implements zzad {
    public zzac() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        zzb((Bundle) com.google.android.gms.internal.cast.zzc.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
