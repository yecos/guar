package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
final class zzko implements zzla {
    final /* synthetic */ zzkt zza;

    public zzko(zzkt zzktVar) {
        this.zza = zzktVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzla
    public final void zza(String str, String str2, Bundle bundle) {
        zzfr zzfrVar;
        zzfr zzfrVar2;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaz().zzp(new zzkn(this, str, "_err", bundle));
            return;
        }
        zzkt zzktVar = this.zza;
        zzfrVar = zzktVar.zzn;
        if (zzfrVar != null) {
            zzfrVar2 = zzktVar.zzn;
            zzfrVar2.zzay().zzd().zzb("AppId not known when logging event", "_err");
        }
    }
}
