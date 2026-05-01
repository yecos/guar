package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzck extends zza {
    public zzck(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() {
        zzd(3, zza());
    }

    public final void zzf(zzcj zzcjVar, int i10) {
        Parcel zza = zza();
        zzc.zze(zza, zzcjVar);
        zza.writeInt(i10);
        zzd(5, zza);
    }

    public final void zzg(zzcj zzcjVar, zzcm zzcmVar, String str, String str2, Bundle bundle) {
        Parcel zza = zza();
        zzc.zze(zza, zzcjVar);
        zzc.zze(zza, zzcmVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(7, zza);
    }

    public final void zzh(zzcj zzcjVar, PendingIntent pendingIntent, String str, String str2, Bundle bundle) {
        Parcel zza = zza();
        zzc.zze(zza, zzcjVar);
        zzc.zzc(zza, pendingIntent);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(8, zza);
    }

    public final void zzi(zzcj zzcjVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzcjVar);
        zzd(6, zza);
    }
}
