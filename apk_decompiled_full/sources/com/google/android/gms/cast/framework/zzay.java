package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
final class zzay extends zzao {
    final /* synthetic */ SessionProvider zza;

    public /* synthetic */ zzay(SessionProvider sessionProvider, zzax zzaxVar) {
        this.zza = sessionProvider;
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final IObjectWrapper zzb(String str) {
        Session createSession = this.zza.createSession(str);
        if (createSession == null) {
            return null;
        }
        return createSession.zzl();
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final String zzc() {
        return this.zza.getCategory();
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final boolean zzd() {
        return this.zza.isSessionRecoverable();
    }
}
