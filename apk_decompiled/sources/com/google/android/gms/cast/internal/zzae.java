package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbq;

/* loaded from: classes.dex */
public final class zzae extends com.google.android.gms.internal.cast.zza {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze() {
        zzd(17, zza());
    }

    public final void zzf() {
        zzd(1, zza());
    }

    public final void zzg(String str, String str2, zzbq zzbqVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.cast.zzc.zzc(zza, zzbqVar);
        zzd(14, zza);
    }

    public final void zzh(String str, LaunchOptions launchOptions) {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.cast.zzc.zzc(zza, launchOptions);
        zzd(13, zza);
    }

    public final void zzi() {
        zzd(4, zza());
    }

    public final void zzj(zzag zzagVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzagVar);
        zzd(18, zza);
    }

    public final void zzk(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(11, zza);
    }

    public final void zzl() {
        zzd(6, zza());
    }

    public final void zzm(String str, String str2, long j10) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j10);
        zzd(9, zza);
    }

    public final void zzn(boolean z10, double d10, boolean z11) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, z10);
        zza.writeDouble(d10);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z11);
        zzd(8, zza);
    }

    public final void zzo(double d10, double d11, boolean z10) {
        Parcel zza = zza();
        zza.writeDouble(d10);
        zza.writeDouble(d11);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z10);
        zzd(7, zza);
    }

    public final void zzp(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(5, zza);
    }

    public final void zzq() {
        zzd(19, zza());
    }

    public final void zzr(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(12, zza);
    }
}
