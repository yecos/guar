package com.google.android.gms.internal.cast;

import java.util.List;

/* loaded from: classes.dex */
final class zzom {
    private final zzol zza;

    private zzom(zzol zzolVar) {
        zzph.zzf(zzolVar, "output");
        this.zza = zzolVar;
        zzolVar.zza = this;
    }

    public static zzom zza(zzol zzolVar) {
        zzom zzomVar = zzolVar.zza;
        return zzomVar != null ? zzomVar : new zzom(zzolVar);
    }

    public final void zzA(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                zzol zzolVar = this.zza;
                int intValue = list.get(i11).intValue();
                zzolVar.zzp(i10, (intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            int intValue2 = list.get(i13).intValue();
            i12 += zzol.zzA((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            zzol zzolVar2 = this.zza;
            int intValue3 = list.get(i11).intValue();
            zzolVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
            i11++;
        }
    }

    public final void zzB(int i10, long j10) {
        this.zza.zzr(i10, (j10 >> 63) ^ (j10 + j10));
    }

    public final void zzC(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                zzol zzolVar = this.zza;
                long longValue = list.get(i11).longValue();
                zzolVar.zzr(i10, (longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            long longValue2 = list.get(i13).longValue();
            i12 += zzol.zzB((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            zzol zzolVar2 = this.zza;
            long longValue3 = list.get(i11).longValue();
            zzolVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
            i11++;
        }
    }

    public final void zzD(int i10, String str) {
        this.zza.zzm(i10, str);
    }

    public final void zzE(int i10, List<String> list) {
        int i11 = 0;
        if (!(list instanceof zzpo)) {
            while (i11 < list.size()) {
                this.zza.zzm(i10, list.get(i11));
                i11++;
            }
            return;
        }
        zzpo zzpoVar = (zzpo) list;
        while (i11 < list.size()) {
            Object zze = zzpoVar.zze(i11);
            if (zze instanceof String) {
                this.zza.zzm(i10, (String) zze);
            } else {
                this.zza.zze(i10, (zzoe) zze);
            }
            i11++;
        }
    }

    public final void zzF(int i10, int i11) {
        this.zza.zzp(i10, i11);
    }

    public final void zzG(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzp(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzol.zzA(list.get(i13).intValue());
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzq(list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzH(int i10, long j10) {
        this.zza.zzr(i10, j10);
    }

    public final void zzI(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzr(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzol.zzB(list.get(i13).longValue());
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzs(list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzb(int i10, boolean z10) {
        this.zza.zzd(i10, z10);
    }

    public final void zzc(int i10, List<Boolean> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzd(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).booleanValue();
            i12++;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzb(list.get(i11).booleanValue() ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    public final void zzd(int i10, zzoe zzoeVar) {
        this.zza.zze(i10, zzoeVar);
    }

    public final void zze(int i10, List<zzoe> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zze(i10, list.get(i11));
        }
    }

    public final void zzf(int i10, double d10) {
        this.zza.zzh(i10, Double.doubleToRawLongBits(d10));
    }

    public final void zzg(int i10, List<Double> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, Double.doubleToRawLongBits(list.get(i11).doubleValue()));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).doubleValue();
            i12 += 8;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(list.get(i11).doubleValue()));
            i11++;
        }
    }

    public final void zzh(int i10, int i11) {
        this.zza.zzj(i10, i11);
    }

    public final void zzi(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzj(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzol.zzv(list.get(i13).intValue());
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzk(list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzj(int i10, int i11) {
        this.zza.zzf(i10, i11);
    }

    public final void zzk(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzf(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).intValue();
            i12 += 4;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzg(list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzl(int i10, long j10) {
        this.zza.zzh(i10, j10);
    }

    public final void zzm(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).longValue();
            i12 += 8;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzi(list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzn(int i10, float f10) {
        this.zza.zzf(i10, Float.floatToRawIntBits(f10));
    }

    public final void zzo(int i10, List<Float> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzf(i10, Float.floatToRawIntBits(list.get(i11).floatValue()));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).floatValue();
            i12 += 4;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(list.get(i11).floatValue()));
            i11++;
        }
    }

    public final void zzp(int i10, Object obj, zzqp zzqpVar) {
        zzol zzolVar = this.zza;
        zzolVar.zzo(i10, 3);
        zzqpVar.zzi((zzqe) obj, zzolVar.zza);
        zzolVar.zzo(i10, 4);
    }

    public final void zzq(int i10, int i11) {
        this.zza.zzj(i10, i11);
    }

    public final void zzr(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzj(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzol.zzv(list.get(i13).intValue());
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzk(list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzs(int i10, long j10) {
        this.zza.zzr(i10, j10);
    }

    public final void zzt(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzr(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzol.zzB(list.get(i13).longValue());
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzs(list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzu(int i10, Object obj, zzqp zzqpVar) {
        zzqe zzqeVar = (zzqe) obj;
        zzoj zzojVar = (zzoj) this.zza;
        zzojVar.zzq((i10 << 3) | 2);
        zznr zznrVar = (zznr) zzqeVar;
        int zzn = zznrVar.zzn();
        if (zzn == -1) {
            zzn = zzqpVar.zza(zznrVar);
            zznrVar.zzp(zzn);
        }
        zzojVar.zzq(zzn);
        zzqpVar.zzi(zzqeVar, zzojVar.zza);
    }

    public final void zzv(int i10, int i11) {
        this.zza.zzf(i10, i11);
    }

    public final void zzw(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzf(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).intValue();
            i12 += 4;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzg(list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzx(int i10, long j10) {
        this.zza.zzh(i10, j10);
    }

    public final void zzy(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            list.get(i13).longValue();
            i12 += 8;
        }
        this.zza.zzq(i12);
        while (i11 < list.size()) {
            this.zza.zzi(list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzz(int i10, int i11) {
        this.zza.zzp(i10, (i11 >> 31) ^ (i11 + i11));
    }
}
