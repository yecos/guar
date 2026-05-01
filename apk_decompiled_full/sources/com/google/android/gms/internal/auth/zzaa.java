package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzaa extends zza implements zzz {
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzaf zzafVar) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzxVar);
        zzc.zza(obtainAndWriteInterfaceToken, zzafVar);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzad zzadVar) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzxVar);
        zzc.zza(obtainAndWriteInterfaceToken, zzadVar);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzv zzvVar) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzxVar);
        zzc.zza(obtainAndWriteInterfaceToken, zzvVar);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzah zzahVar) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzxVar);
        zzc.zza(obtainAndWriteInterfaceToken, zzahVar);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzab zzabVar) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzxVar);
        zzc.zza(obtainAndWriteInterfaceToken, zzabVar);
        transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
    }
}
