package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
final class zzav extends zzaq {
    final /* synthetic */ Session zza;

    public /* synthetic */ zzav(Session session, zzau zzauVar) {
        this.zza = session;
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final long zzb() {
        return this.zza.getSessionRemainingTimeMs();
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final IObjectWrapper zzc() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zzd(boolean z10) {
        this.zza.end(z10);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zze(Bundle bundle) {
        this.zza.onResuming(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zzf(Bundle bundle) {
        this.zza.onStarting(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zzg(Bundle bundle) {
        this.zza.resume(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zzh(Bundle bundle) {
        this.zza.start(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzar
    public final void zzi(Bundle bundle) {
        this.zza.zzj(bundle);
    }
}
