package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzp extends zza implements zzq {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzw zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzsVar, Map map) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, zzsVar);
        zza.writeMap(map);
        Parcel zzb = zzb(1, zza);
        com.google.android.gms.cast.framework.zzw zzb2 = com.google.android.gms.cast.framework.zzv.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzz zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzt zztVar) {
        Parcel zza = zza();
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zztVar);
        Parcel zzb = zzb(3, zza);
        com.google.android.gms.cast.framework.zzz zzb2 = com.google.android.gms.cast.framework.zzy.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzag zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, iObjectWrapper2);
        zzc.zze(zza, iObjectWrapper3);
        Parcel zzb = zzb(5, zza);
        com.google.android.gms.cast.framework.zzag zzb2 = com.google.android.gms.cast.framework.zzaf.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzaj zzh(String str, String str2, com.google.android.gms.cast.framework.zzar zzarVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzarVar);
        Parcel zzb = zzb(2, zza);
        com.google.android.gms.cast.framework.zzaj zzb2 = com.google.android.gms.cast.framework.zzai.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.media.internal.zzi zzi(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzkVar);
        zza.writeInt(i10);
        zza.writeInt(i11);
        zzc.zzb(zza, false);
        zza.writeLong(2097152L);
        zza.writeInt(5);
        zza.writeInt(333);
        zza.writeInt(10000);
        Parcel zzb = zzb(6, zza);
        com.google.android.gms.cast.framework.media.internal.zzi zzb2 = com.google.android.gms.cast.framework.media.internal.zzh.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }
}
