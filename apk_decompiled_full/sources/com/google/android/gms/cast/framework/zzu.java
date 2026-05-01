package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzu extends com.google.android.gms.internal.cast.zza implements zzw {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    @Override // com.google.android.gms.cast.framework.zzw
    public final Bundle zze() {
        Parcel zzb = zzb(1, zza());
        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.zzc.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.cast.framework.zzw
    public final zzad zzf() {
        zzad zzacVar;
        Parcel zzb = zzb(6, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzacVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            zzacVar = queryLocalInterface instanceof zzad ? (zzad) queryLocalInterface : new zzac(readStrongBinder);
        }
        zzb.recycle();
        return zzacVar;
    }

    @Override // com.google.android.gms.cast.framework.zzw
    public final zzal zzg() {
        zzal zzakVar;
        Parcel zzb = zzb(5, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzakVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            zzakVar = queryLocalInterface instanceof zzal ? (zzal) queryLocalInterface : new zzak(readStrongBinder);
        }
        zzb.recycle();
        return zzakVar;
    }

    @Override // com.google.android.gms.cast.framework.zzw
    public final void zzh(String str, Map map) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeMap(map);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzw
    public final boolean zzi() {
        Parcel zzb = zzb(12, zza());
        boolean zzf = com.google.android.gms.internal.cast.zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }
}
