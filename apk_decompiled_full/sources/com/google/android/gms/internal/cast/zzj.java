package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.math.BigInteger;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzj {
    private static final Logger zza = new Logger("ApplicationAnalyticsUtils");
    private static final String zzb = "20.1.0";
    private final String zzc;
    private final Map<Integer, Integer> zzd;
    private final Map<Integer, Integer> zze;

    public zzj(Bundle bundle, String str) {
        this.zzc = str;
        this.zzd = zzn.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR");
        this.zze = zzn.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON");
    }

    private final zzkt zzf(zzi zziVar) {
        long j10;
        zzkt zzc = zzku.zzc();
        zzc.zzj(zziVar.zzd);
        int i10 = zziVar.zze;
        zziVar.zze = i10 + 1;
        zzc.zzg(i10);
        String str = zziVar.zzc;
        if (str != null) {
            zzc.zzh(str);
        }
        String str2 = zziVar.zzh;
        if (str2 != null) {
            zzc.zzf(str2);
        }
        zzkj zza2 = zzkk.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zzc);
        zzc.zzb(zza2.zzp());
        zzkl zza3 = zzkm.zza();
        if (zziVar.zzb != null) {
            zzlb zza4 = zzlc.zza();
            zza4.zza(zziVar.zzb);
            zza3.zza(zza4.zzp());
        }
        zza3.zzd(false);
        String str3 = zziVar.zzf;
        if (str3 != null) {
            try {
                String replace = str3.replace(Operator.Operation.MINUS, "");
                j10 = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
            } catch (NumberFormatException e10) {
                zza.w(e10, "receiverSessionId %s is not valid for hash", str3);
                j10 = 0;
            }
            zza3.zzf(j10);
        }
        zza3.zzb(zziVar.zzg);
        zzc.zzd(zza3);
        return zzc;
    }

    private static void zzg(zzkt zzktVar, boolean z10) {
        zzkl zzc = zzkm.zzc(zzktVar.zza());
        zzc.zzd(z10);
        zzktVar.zzd(zzc);
    }

    public final zzku zza(zzi zziVar) {
        return zzf(zziVar).zzp();
    }

    public final zzku zzb(zzi zziVar, boolean z10) {
        zzkt zzf = zzf(zziVar);
        zzg(zzf, z10);
        return zzf.zzp();
    }

    public final zzku zzc(zzi zziVar) {
        zzkt zzf = zzf(zziVar);
        zzkl zzc = zzkm.zzc(zzf.zza());
        zzc.zze(10);
        zzf.zze(zzc.zzp());
        zzg(zzf, true);
        return zzf.zzp();
    }

    public final zzku zzd(zzi zziVar) {
        zzkt zzf = zzf(zziVar);
        if (zziVar.zzi == 1) {
            zzkl zzc = zzkm.zzc(zzf.zza());
            zzc.zze(17);
            zzf.zze(zzc.zzp());
        }
        return zzf.zzp();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzku zze(zzi zziVar, int i10) {
        int i11;
        Map<Integer, Integer> map;
        int i12;
        zzkt zzf = zzf(zziVar);
        zzkl zzc = zzkm.zzc(zzf.zza());
        Map<Integer, Integer> map2 = this.zze;
        if (map2 != null) {
            Integer valueOf = Integer.valueOf(i10);
            if (map2.containsKey(valueOf)) {
                i11 = ((Integer) Preconditions.checkNotNull(this.zze.get(valueOf))).intValue();
                zzc.zze(i11);
                map = this.zzd;
                if (map != null) {
                    Integer valueOf2 = Integer.valueOf(i10);
                    if (map.containsKey(valueOf2)) {
                        i12 = ((Integer) Preconditions.checkNotNull(this.zzd.get(valueOf2))).intValue();
                        zzc.zzc(i12);
                        zzf.zze(zzc.zzp());
                        return zzf.zzp();
                    }
                }
                i12 = i10 + 10000;
                zzc.zzc(i12);
                zzf.zze(zzc.zzp());
                return zzf.zzp();
            }
        }
        i11 = i10 + 10000;
        zzc.zze(i11);
        map = this.zzd;
        if (map != null) {
        }
        i12 = i10 + 10000;
        zzc.zzc(i12);
        zzf.zze(zzc.zzp());
        return zzf.zzp();
    }
}
