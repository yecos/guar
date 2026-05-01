package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.Logger;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.cast.zzku zze(com.google.android.gms.internal.cast.zzi r4, int r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.cast.zzkt r4 = r3.zzf(r4)
            com.google.android.gms.internal.cast.zzkm r0 = r4.zza()
            com.google.android.gms.internal.cast.zzkl r0 = com.google.android.gms.internal.cast.zzkm.zzc(r0)
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zze
            if (r1 == 0) goto L2e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L1b
            goto L2e
        L1b:
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zze
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L30
        L2e:
            int r1 = r5 + 10000
        L30:
            r0.zze(r1)
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zzd
            if (r1 == 0) goto L55
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.util.Map<java.lang.Integer, java.lang.Integer> r5 = r3.zzd
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L57
        L55:
            int r5 = r5 + 10000
        L57:
            r0.zzc(r5)
            com.google.android.gms.internal.cast.zzoy r5 = r0.zzp()
            com.google.android.gms.internal.cast.zzkm r5 = (com.google.android.gms.internal.cast.zzkm) r5
            r4.zze(r5)
            com.google.android.gms.internal.cast.zzoy r4 = r4.zzp()
            com.google.android.gms.internal.cast.zzku r4 = (com.google.android.gms.internal.cast.zzku) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzj.zze(com.google.android.gms.internal.cast.zzi, int):com.google.android.gms.internal.cast.zzku");
    }
}
