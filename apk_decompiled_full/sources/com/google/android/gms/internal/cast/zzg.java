package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.taobao.accs.common.Constants;

/* loaded from: classes.dex */
final class zzg implements SessionManagerListener<CastSession> {
    final /* synthetic */ zzh zza;

    public /* synthetic */ zzg(zzh zzhVar, zzf zzfVar) {
        this.zza = zzhVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* synthetic */ void onSessionEnded(CastSession castSession, int i10) {
        zzh.zzj(this.zza, castSession, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnding(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* synthetic */ void onSessionResumeFailed(CastSession castSession, int i10) {
        zzh.zzj(this.zza, castSession, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumed(CastSession castSession, boolean z10) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzq(castSession);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzku zzb = zzjVar.zzb(zziVar2, z10);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzb, 227);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzs();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResuming(CastSession castSession, String str) {
        SharedPreferences sharedPreferences;
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        zzh zzhVar = this.zza;
        sharedPreferences = zzhVar.zzf;
        zzh.zzk(zzhVar, sharedPreferences, str);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzku zzc = zzjVar.zzc(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzc, 226);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* synthetic */ void onSessionStartFailed(CastSession castSession, int i10) {
        zzh.zzj(this.zza, castSession, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarted(CastSession castSession, String str) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzq(castSession);
        zziVar = this.zza.zzg;
        zziVar.zzf = str;
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzku zza = zzjVar.zza(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zza, 222);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzs();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarting(CastSession castSession) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        Logger logger;
        CastSession castSession2 = castSession;
        zziVar = this.zza.zzg;
        if (zziVar != null) {
            logger = zzh.zza;
            logger.w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzr(castSession2);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzku zzd = zzjVar.zzd(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzd, Constants.SDK_VERSION_CODE);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionSuspended(CastSession castSession, int i10) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzq(castSession);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzku zze = zzjVar.zze(zziVar2, i10);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zze, 225);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzp();
    }
}
