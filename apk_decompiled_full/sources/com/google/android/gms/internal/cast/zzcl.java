package com.google.android.gms.internal.cast;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzcl extends zzb implements zzcm {
    public zzcl() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        zzb(parcel.readInt());
        return true;
    }
}
