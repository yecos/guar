package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.taobao.accs.utl.BaseMonitor;

/* loaded from: classes.dex */
final class zzo extends zzp<Void> {
    public zzo(int i10, int i11, Bundle bundle) {
        super(i10, 2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzp
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean(BaseMonitor.COUNT_ACK, false)) {
            zzd(null);
        } else {
            zzc(new zzq(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzp
    public final boolean zzb() {
        return true;
    }
}
