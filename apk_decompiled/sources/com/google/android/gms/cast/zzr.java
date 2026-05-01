package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.Task;

@ShowFirstParty
/* loaded from: classes.dex */
public interface zzr extends HasApiKey<Cast.CastOptions> {
    double zza();

    int zzb();

    int zzc();

    ApplicationMetadata zzd();

    Task<Void> zze();

    Task<Void> zzf();

    Task<Void> zzg(String str);

    Task<Void> zzh(String str, String str2);

    Task<Void> zzi(String str, Cast.MessageReceivedCallback messageReceivedCallback);

    String zzj();

    void zzk(zzq zzqVar);

    boolean zzl();
}
