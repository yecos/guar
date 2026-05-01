package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import java.util.List;

/* loaded from: classes.dex */
public final class zzah extends com.google.android.gms.internal.cast.zza {
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback, String[] strArr, String str, List list) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, iStatusCallback);
        zza.writeStringArray(strArr);
        zza.writeString(str);
        zza.writeTypedList(null);
        zzd(2, zza);
    }

    public final void zzf(zzad zzadVar, String[] strArr) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(5, zza);
    }

    public final void zzg(zzad zzadVar, String[] strArr) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(7, zza);
    }

    public final void zzh(zzad zzadVar, String[] strArr) {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zze(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(6, zza);
    }
}
