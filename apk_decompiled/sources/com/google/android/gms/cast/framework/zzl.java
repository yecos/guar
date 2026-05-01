package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbp;
import com.google.android.gms.cast.zzbq;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzl extends zzs {
    final /* synthetic */ CastSession zza;

    public /* synthetic */ zzl(CastSession castSession, zzk zzkVar) {
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void zzb(int i10) {
        CastSession.zzg(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void zzc(final String str, final String str2) {
        com.google.android.gms.cast.zzr zzrVar;
        com.google.android.gms.cast.zzr zzrVar2;
        zzrVar = this.zza.zzh;
        if (zzrVar != null) {
            zzrVar2 = this.zza.zzh;
            final zzbp zzbpVar = (zzbp) zzrVar2;
            final zzbq zzbqVar = null;
            zzbpVar.doWrite(TaskApiCall.builder().run(new RemoteCall(str, str2, zzbqVar) { // from class: com.google.android.gms.cast.zzbe
                public final /* synthetic */ String zzb;
                public final /* synthetic */ String zzc;

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzbp.this.zzF(this.zzb, this.zzc, null, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8407).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzi
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CastSession.zzh(zzl.this.zza, "joinApplication", task);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void zzd(final String str, final LaunchOptions launchOptions) {
        com.google.android.gms.cast.zzr zzrVar;
        com.google.android.gms.cast.zzr zzrVar2;
        zzrVar = this.zza.zzh;
        if (zzrVar != null) {
            zzrVar2 = this.zza.zzh;
            final zzbp zzbpVar = (zzbp) zzrVar2;
            zzbpVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbd
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzbp.this.zzG(str, launchOptions, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8406).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzj
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CastSession.zzh(zzl.this.zza, "launchApplication", task);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void zze(final String str) {
        com.google.android.gms.cast.zzr zzrVar;
        com.google.android.gms.cast.zzr zzrVar2;
        zzrVar = this.zza.zzh;
        if (zzrVar != null) {
            zzrVar2 = this.zza.zzh;
            final zzbp zzbpVar = (zzbp) zzrVar2;
            zzbpVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbb
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzbp.this.zzM(str, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8409).build());
        }
    }
}
