package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class zzx extends com.google.android.gms.internal.cast.zza implements zzz {
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zze(boolean z10, int i10) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, z10);
        zza.writeInt(0);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zzf(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, applicationMetadata);
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z10);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zzg(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zzh(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, null);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zzi(ConnectionResult connectionResult) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, connectionResult);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzz
    public final void zzj(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(2, zza);
    }
}
