package com.google.android.gms.cast.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class zzp {
    protected final Logger zza;
    private final String zzb;
    private zzaq zzc;

    public zzp(String str, String str2, String str3) {
        CastUtils.throwIfInvalidNamespace(str);
        this.zzb = str;
        Logger logger = new Logger("MediaControlChannel");
        this.zza = logger;
        if (TextUtils.isEmpty(null)) {
            return;
        }
        logger.zzc(null);
    }

    public final long zzd() {
        zzaq zzaqVar = this.zzc;
        if (zzaqVar != null) {
            return zzaqVar.zza();
        }
        this.zza.e("Attempt to generate requestId without a sink", new Object[0]);
        return 0L;
    }

    public final String zze() {
        return this.zzb;
    }

    public void zzf() {
        throw null;
    }

    public final void zzg(String str, long j10, String str2) {
        zzaq zzaqVar = this.zzc;
        if (zzaqVar == null) {
            this.zza.e("Attempt to send text message without a sink", new Object[0]);
        } else {
            zzaqVar.zzb(this.zzb, str, j10, null);
        }
    }

    public final void zzh(zzaq zzaqVar) {
        this.zzc = zzaqVar;
        if (zzaqVar == null) {
            zzf();
        }
    }
}
