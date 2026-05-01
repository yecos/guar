package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzlz {
    private static final Class zza;
    private static final zzmo zzb;
    private static final zzmo zzc;
    private static final zzmo zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzmq();
    }

    public static zzmo zzA() {
        return zzc;
    }

    public static zzmo zzB() {
        return zzd;
    }

    public static Object zzC(Object obj, int i10, List list, zzkj zzkjVar, Object obj2, zzmo zzmoVar) {
        Object obj3 = null;
        if (zzkjVar == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = ((Integer) list.get(i12)).intValue();
                if (zzkjVar.zza(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    obj3 = zzD(obj, i10, intValue, obj3, zzmoVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj3;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzkjVar.zza(intValue2)) {
                    obj3 = zzD(obj, i10, intValue2, obj3, zzmoVar);
                    it.remove();
                }
            }
        }
        return obj3;
    }

    public static Object zzD(Object obj, int i10, int i11, Object obj2, zzmo zzmoVar) {
        if (obj2 == null) {
            obj2 = zzmoVar.zzc(obj);
        }
        zzmoVar.zzf(obj2, i10, i11);
        return obj2;
    }

    public static void zzE(zzjs zzjsVar, Object obj, Object obj2) {
        zzjsVar.zza(obj2);
        throw null;
    }

    public static void zzF(zzmo zzmoVar, Object obj, Object obj2) {
        zzmoVar.zzh(obj, zzmoVar.zze(zzmoVar.zzd(obj), zzmoVar.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkf.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzc(i10, list, z10);
    }

    public static void zzI(int i10, List list, zzng zzngVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zze(i10, list);
    }

    public static void zzJ(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzg(i10, list, z10);
    }

    public static void zzK(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzj(i10, list, z10);
    }

    public static void zzL(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzl(i10, list, z10);
    }

    public static void zzM(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzn(i10, list, z10);
    }

    public static void zzN(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzp(i10, list, z10);
    }

    public static void zzO(int i10, List list, zzng zzngVar, zzlx zzlxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((zzjn) zzngVar).zzq(i10, list.get(i11), zzlxVar);
        }
    }

    public static void zzP(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzs(i10, list, z10);
    }

    public static void zzQ(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzu(i10, list, z10);
    }

    public static void zzR(int i10, List list, zzng zzngVar, zzlx zzlxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((zzjn) zzngVar).zzv(i10, list.get(i11), zzlxVar);
        }
    }

    public static void zzS(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzx(i10, list, z10);
    }

    public static void zzT(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzz(i10, list, z10);
    }

    public static void zzU(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzB(i10, list, z10);
    }

    public static void zzV(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzD(i10, list, z10);
    }

    public static void zzW(int i10, List list, zzng zzngVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzG(i10, list);
    }

    public static void zzX(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzI(i10, list, z10);
    }

    public static void zzY(int i10, List list, zzng zzngVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzK(i10, list, z10);
    }

    public static boolean zzZ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 1);
    }

    public static void zzaa(zzlh zzlhVar, Object obj, Object obj2, long j10) {
        zzmy.zzs(obj, j10, zzlh.zzb(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10)));
    }

    private static zzmo zzab(boolean z10) {
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
            return (zzmo) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List list) {
        return list.size();
    }

    public static int zzc(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjm.zzz(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzz += zzjm.zzt((zzje) list.get(i11));
        }
        return zzz;
    }

    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjm.zzz(i10));
    }

    public static int zze(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzf(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 4);
    }

    public static int zzg(List list) {
        return list.size() * 4;
    }

    public static int zzh(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 8);
    }

    public static int zzi(List list) {
        return list.size() * 8;
    }

    public static int zzj(int i10, List list, zzlx zzlxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzjm.zzu(i10, (zzlm) list.get(i12), zzlxVar);
        }
        return i11;
    }

    public static int zzk(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjm.zzz(i10));
    }

    public static int zzl(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzm(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjm.zzz(i10));
    }

    public static int zzn(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(zzlbVar.zza(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzo(int i10, Object obj, zzlx zzlxVar) {
        if (!(obj instanceof zzks)) {
            return zzjm.zzA(i10 << 3) + zzjm.zzx((zzlm) obj, zzlxVar);
        }
        int zzA = zzjm.zzA(i10 << 3);
        int zza2 = ((zzks) obj).zza();
        return zzA + zzjm.zzA(zza2) + zza2;
    }

    public static int zzp(int i10, List list, zzlx zzlxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            zzz += obj instanceof zzks ? zzjm.zzw((zzks) obj) : zzjm.zzx((zzlm) obj, zzlxVar);
        }
        return zzz;
    }

    public static int zzq(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjm.zzz(i10));
    }

    public static int zzr(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzkgVar.zze(i11);
                i10 += zzjm.zzA((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i10 += zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzs(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjm.zzz(i10));
    }

    public static int zzt(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                long zza2 = zzlbVar.zza(i11);
                i10 += zzjm.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i10 += zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzu(int i10, List list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        if (list instanceof zzku) {
            zzku zzkuVar = (zzku) list;
            while (i11 < size) {
                Object zzf = zzkuVar.zzf(i11);
                zzz += zzf instanceof zzje ? zzjm.zzt((zzje) zzf) : zzjm.zzy((String) zzf);
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                zzz += obj instanceof zzje ? zzjm.zzt((zzje) obj) : zzjm.zzy((String) obj);
                i11++;
            }
        }
        return zzz;
    }

    public static int zzv(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjm.zzz(i10));
    }

    public static int zzw(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzA(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzx(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjm.zzz(i10));
    }

    public static int zzy(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(zzlbVar.zza(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzmo zzz() {
        return zzb;
    }
}
