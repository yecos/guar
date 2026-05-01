package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzak extends com.google.android.gms.internal.cast.zza implements zzal {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final int zze() {
        Parcel zzb = zzb(8, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final IObjectWrapper zzf() {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final IObjectWrapper zzg() {
        Parcel zzb = zzb(7, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzh(zzab zzabVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzabVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzi(zzan zzanVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzanVar);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzj(boolean z10, boolean z11) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, true);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z11);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzk(zzab zzabVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzabVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzl(zzan zzanVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzanVar);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzm(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(zza, bundle);
        zzc(9, zza);
    }
}
