package com.google.android.gms.internal.cast;

import java.util.List;

/* loaded from: classes.dex */
final class zzqr {
    private static final Class<?> zza;
    private static final zzrd<?, ?> zzb;
    private static final zzrd<?, ?> zzc;
    private static final zzrd<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzZ(false);
        zzc = zzZ(true);
        zzd = new zzrf();
    }

    public static zzrd<?, ?> zzA() {
        return zzc;
    }

    public static zzrd<?, ?> zzB() {
        return zzd;
    }

    public static <T, FT extends zzor<FT>> void zzC(zzoo<FT> zzooVar, T t10, T t11) {
        zzooVar.zza(t11);
        throw null;
    }

    public static <T, UT, UB> void zzD(zzrd<UT, UB> zzrdVar, T t10, T t11) {
        zzrdVar.zzf(t10, zzrdVar.zzd(zzrdVar.zzc(t10), zzrdVar.zzc(t11)));
    }

    public static void zzE(Class<?> cls) {
        Class<?> cls2;
        if (!zzoy.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> void zzG(zzpz zzpzVar, T t10, T t11, long j10) {
        zzpy zzpyVar = (zzpy) zzrn.zzf(t10, j10);
        zzpy zzpyVar2 = (zzpy) zzrn.zzf(t11, j10);
        if (!zzpyVar2.isEmpty()) {
            if (!zzpyVar.zzd()) {
                zzpyVar = zzpyVar.zza();
            }
            zzpyVar.zzc(zzpyVar2);
        }
        zzrn.zzs(t10, j10, zzpyVar);
    }

    public static void zzH(int i10, List<Boolean> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzc(i10, list, z10);
    }

    public static void zzI(int i10, List<zzoe> list, zzom zzomVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zze(i10, list);
    }

    public static void zzJ(int i10, List<Double> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzg(i10, list, z10);
    }

    public static void zzK(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzi(i10, list, z10);
    }

    public static void zzL(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzk(i10, list, z10);
    }

    public static void zzM(int i10, List<Long> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzm(i10, list, z10);
    }

    public static void zzN(int i10, List<Float> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzo(i10, list, z10);
    }

    public static void zzO(int i10, List<?> list, zzom zzomVar, zzqp zzqpVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzomVar.zzp(i10, list.get(i11), zzqpVar);
        }
    }

    public static void zzP(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzr(i10, list, z10);
    }

    public static void zzQ(int i10, List<Long> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzt(i10, list, z10);
    }

    public static void zzR(int i10, List<?> list, zzom zzomVar, zzqp zzqpVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzomVar.zzu(i10, list.get(i11), zzqpVar);
        }
    }

    public static void zzS(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzw(i10, list, z10);
    }

    public static void zzT(int i10, List<Long> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzy(i10, list, z10);
    }

    public static void zzU(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzA(i10, list, z10);
    }

    public static void zzV(int i10, List<Long> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzC(i10, list, z10);
    }

    public static void zzW(int i10, List<String> list, zzom zzomVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzE(i10, list);
    }

    public static void zzX(int i10, List<Integer> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzG(i10, list, z10);
    }

    public static void zzY(int i10, List<Long> list, zzom zzomVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzomVar.zzI(i10, list, z10);
    }

    private static zzrd<?, ?> zzZ(boolean z10) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzrd) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zza(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 1);
    }

    public static int zzb(List<?> list) {
        return list.size();
    }

    public static int zzc(int i10, List<zzoe> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzol.zzz(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzz += zzol.zzt(list.get(i11));
        }
        return zzz;
    }

    public static int zzd(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzol.zzz(i10));
    }

    public static int zze(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzozVar = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(zzozVar.zzd(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzf(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 4);
    }

    public static int zzg(List<?> list) {
        return list.size() * 4;
    }

    public static int zzh(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 8);
    }

    public static int zzi(List<?> list) {
        return list.size() * 8;
    }

    public static int zzj(int i10, List<zzqe> list, zzqp zzqpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzol.zzu(i10, list.get(i12), zzqpVar);
        }
        return i11;
    }

    public static int zzk(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzol.zzz(i10));
    }

    public static int zzl(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzozVar = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(zzozVar.zzd(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzm(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzol.zzz(i10));
    }

    public static int zzn(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzptVar = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(zzptVar.zzd(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzo(int i10, Object obj, zzqp zzqpVar) {
        if (!(obj instanceof zzpm)) {
            return zzol.zzA(i10 << 3) + zzol.zzx((zzqe) obj, zzqpVar);
        }
        int zzA = zzol.zzA(i10 << 3);
        int zza2 = ((zzpm) obj).zza();
        return zzA + zzol.zzA(zza2) + zza2;
    }

    public static int zzp(int i10, List<?> list, zzqp zzqpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzol.zzz(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            zzz += obj instanceof zzpm ? zzol.zzw((zzpm) obj) : zzol.zzx((zzqe) obj, zzqpVar);
        }
        return zzz;
    }

    public static int zzq(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzol.zzz(i10));
    }

    public static int zzr(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzozVar = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                int zzd2 = zzozVar.zzd(i11);
                i10 += zzol.zzA((zzd2 >> 31) ^ (zzd2 + zzd2));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                int intValue = list.get(i11).intValue();
                i10 += zzol.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzs(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzol.zzz(i10));
    }

    public static int zzt(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzptVar = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                long zzd2 = zzptVar.zzd(i11);
                i10 += zzol.zzB((zzd2 >> 63) ^ (zzd2 + zzd2));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                long longValue = list.get(i11).longValue();
                i10 += zzol.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzu(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzol.zzz(i10) * size;
        if (list instanceof zzpo) {
            zzpo zzpoVar = (zzpo) list;
            while (i11 < size) {
                Object zze = zzpoVar.zze(i11);
                zzz += zze instanceof zzoe ? zzol.zzt((zzoe) zze) : zzol.zzy((String) zze);
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                zzz += obj instanceof zzoe ? zzol.zzt((zzoe) obj) : zzol.zzy((String) obj);
                i11++;
            }
        }
        return zzz;
    }

    public static int zzv(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzol.zzz(i10));
    }

    public static int zzw(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzozVar = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzA(zzozVar.zzd(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzA(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzx(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzol.zzz(i10));
    }

    public static int zzy(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzptVar = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(zzptVar.zzd(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzrd<?, ?> zzz() {
        return zzb;
    }
}
