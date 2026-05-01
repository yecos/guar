package com.google.android.gms.measurement.internal;

import java.util.List;

/* loaded from: classes.dex */
final class zzfg implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzfi zza;

    public zzfg(zzfi zzfiVar) {
        this.zza = zzfiVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i10, String str, List list, boolean z10, boolean z11) {
        int i11 = i10 - 1;
        zzef zzi = i11 != 0 ? i11 != 1 ? i11 != 3 ? i11 != 4 ? this.zza.zzt.zzay().zzi() : z10 ? this.zza.zzt.zzay().zzm() : !z11 ? this.zza.zzt.zzay().zzl() : this.zza.zzt.zzay().zzk() : this.zza.zzt.zzay().zzj() : z10 ? this.zza.zzt.zzay().zzh() : !z11 ? this.zza.zzt.zzay().zze() : this.zza.zzt.zzay().zzd() : this.zza.zzt.zzay().zzc();
        int size = list.size();
        if (size == 1) {
            zzi.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzi.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzi.zza(str);
        } else {
            zzi.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
