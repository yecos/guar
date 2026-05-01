package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
final class zzh implements zzj<Bundle> {
    private final /* synthetic */ Account zzo;

    public zzh(Account account) {
        this.zzo = account;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Bundle zzb(IBinder iBinder) {
        Object zza;
        zza = zzd.zza(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.zzo));
        return (Bundle) zza;
    }
}
