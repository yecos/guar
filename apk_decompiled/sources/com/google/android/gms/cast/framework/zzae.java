package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzae extends com.google.android.gms.internal.cast.zza implements zzag {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.IReconnectionService");
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final int zze(Intent intent, int i10, int i11) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, intent);
        zza.writeInt(i10);
        zza.writeInt(i11);
        Parcel zzb = zzb(2, zza);
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final IBinder zzf(Intent intent) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, intent);
        Parcel zzb = zzb(3, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        zzb.recycle();
        return readStrongBinder;
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zzg() {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zzh() {
        zzc(4, zza());
    }
}
