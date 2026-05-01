package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
final class zzlp<T> implements zzlx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzla zzm;
    private final zzmo zzn;
    private final zzjs zzo;
    private final zzlr zzp;
    private final zzlh zzq;

    private zzlp(int[] iArr, Object[] objArr, int i10, int i11, zzlm zzlmVar, boolean z10, boolean z11, int[] iArr2, int i12, int i13, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        this.zzi = z10;
        boolean z12 = false;
        if (zzjsVar != null && zzjsVar.zzc(zzlmVar)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzj = iArr2;
        this.zzk = i12;
        this.zzl = i13;
        this.zzp = zzlrVar;
        this.zzm = zzlaVar;
        this.zzn = zzmoVar;
        this.zzo = zzjsVar;
        this.zzg = zzlmVar;
        this.zzq = zzlhVar;
    }

    private static int zzA(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzB(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzC(Object obj, long j10) {
        return ((Long) zzmy.zzf(obj, j10)).longValue();
    }

    private final zzkj zzD(int i10) {
        int i11 = i10 / 3;
        return (zzkj) this.zzd[i11 + i11 + 1];
    }

    private final zzlx zzE(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzlx zzlxVar = (zzlx) this.zzd[i12];
        if (zzlxVar != null) {
            return zzlxVar;
        }
        zzlx zzb2 = zzlu.zza().zzb((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private final Object zzG(Object obj, int i10) {
        zzlx zzE = zzE(i10);
        long zzB = zzB(i10) & 1048575;
        if (!zzT(obj, i10)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, zzB);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzE.zze();
        if (object != null) {
            zzE.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzH(Object obj, int i10, int i11) {
        zzlx zzE = zzE(i11);
        if (!zzX(obj, i10, i11)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, zzB(i11) & 1048575);
        if (zzW(object)) {
            return object;
        }
        Object zze = zzE.zze();
        if (object != null) {
            zzE.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzI(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzJ(Object obj) {
        if (!zzW(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzK(Object obj, Object obj2, int i10) {
        if (zzT(obj2, i10)) {
            long zzB = zzB(i10) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzB);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzlx zzE = zzE(i10);
            if (!zzT(obj, i10)) {
                if (zzW(object)) {
                    Object zze = zzE.zze();
                    zzE.zzg(zze, object);
                    unsafe.putObject(obj, zzB, zze);
                } else {
                    unsafe.putObject(obj, zzB, object);
                }
                zzM(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzB);
            if (!zzW(object2)) {
                Object zze2 = zzE.zze();
                zzE.zzg(zze2, object2);
                unsafe.putObject(obj, zzB, zze2);
                object2 = zze2;
            }
            zzE.zzg(object2, object);
        }
    }

    private final void zzL(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (zzX(obj2, i11, i10)) {
            long zzB = zzB(i10) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzB);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzlx zzE = zzE(i10);
            if (!zzX(obj, i11, i10)) {
                if (zzW(object)) {
                    Object zze = zzE.zze();
                    zzE.zzg(zze, object);
                    unsafe.putObject(obj, zzB, zze);
                } else {
                    unsafe.putObject(obj, zzB, object);
                }
                zzN(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzB);
            if (!zzW(object2)) {
                Object zze2 = zzE.zze();
                zzE.zzg(zze2, object2);
                unsafe.putObject(obj, zzB, zze2);
                object2 = zze2;
            }
            zzE.zzg(object2, object);
        }
    }

    private final void zzM(Object obj, int i10) {
        int zzy = zzy(i10);
        long j10 = 1048575 & zzy;
        if (j10 == 1048575) {
            return;
        }
        zzmy.zzq(obj, j10, (1 << (zzy >>> 20)) | zzmy.zzc(obj, j10));
    }

    private final void zzN(Object obj, int i10, int i11) {
        zzmy.zzq(obj, zzy(i11) & 1048575, i10);
    }

    private final void zzO(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzB(i10) & 1048575, obj2);
        zzM(obj, i10);
    }

    private final void zzP(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzB(i11) & 1048575, obj2);
        zzN(obj, i10, i11);
    }

    private final void zzQ(Object obj, zzng zzngVar) {
        int i10;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        while (i12 < length) {
            int zzB = zzB(i12);
            int[] iArr = this.zzc;
            int i15 = iArr[i12];
            int zzA = zzA(zzB);
            if (zzA <= 17) {
                int i16 = iArr[i12 + 2];
                int i17 = i16 & i11;
                if (i17 != i14) {
                    i13 = unsafe.getInt(obj, i17);
                    i14 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = zzB & i11;
            switch (zzA) {
                case 0:
                    if ((i13 & i10) == 0) {
                        break;
                    } else {
                        zzngVar.zzf(i15, zzmy.zza(obj, j10));
                        continue;
                    }
                case 1:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzo(i15, zzmy.zzb(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzt(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzJ(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzr(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzm(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzk(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzb(i15, zzmy.zzw(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i13 & i10) != 0) {
                        zzZ(i15, unsafe.getObject(obj, j10), zzngVar);
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzv(i15, unsafe.getObject(obj, j10), zzE(i12));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzd(i15, (zzje) unsafe.getObject(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzH(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzi(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzw(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzy(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzA(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzC(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i13 & i10) != 0) {
                        zzngVar.zzq(i15, unsafe.getObject(obj, j10), zzE(i12));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzlz.zzJ(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 19:
                    zzlz.zzN(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 20:
                    zzlz.zzQ(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 21:
                    zzlz.zzY(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 22:
                    zzlz.zzP(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 23:
                    zzlz.zzM(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 24:
                    zzlz.zzL(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 25:
                    zzlz.zzH(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    continue;
                case 26:
                    zzlz.zzW(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar);
                    break;
                case 27:
                    zzlz.zzR(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, zzE(i12));
                    break;
                case 28:
                    zzlz.zzI(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar);
                    break;
                case 29:
                    zzlz.zzX(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 30:
                    zzlz.zzK(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 31:
                    zzlz.zzS(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 32:
                    zzlz.zzT(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 33:
                    zzlz.zzU(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 34:
                    zzlz.zzV(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, false);
                    break;
                case 35:
                    zzlz.zzJ(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 36:
                    zzlz.zzN(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 37:
                    zzlz.zzQ(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 38:
                    zzlz.zzY(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 39:
                    zzlz.zzP(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 40:
                    zzlz.zzM(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 41:
                    zzlz.zzL(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 42:
                    zzlz.zzH(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 43:
                    zzlz.zzX(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 44:
                    zzlz.zzK(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 45:
                    zzlz.zzS(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 46:
                    zzlz.zzT(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 47:
                    zzlz.zzU(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 48:
                    zzlz.zzV(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, true);
                    break;
                case 49:
                    zzlz.zzO(this.zzc[i12], (List) unsafe.getObject(obj, j10), zzngVar, zzE(i12));
                    break;
                case 50:
                    zzR(zzngVar, i15, unsafe.getObject(obj, j10), i12);
                    break;
                case 51:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzf(i15, zzn(obj, j10));
                        break;
                    }
                    break;
                case 52:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzo(i15, zzo(obj, j10));
                        break;
                    }
                    break;
                case 53:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzt(i15, zzC(obj, j10));
                        break;
                    }
                    break;
                case 54:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzJ(i15, zzC(obj, j10));
                        break;
                    }
                    break;
                case 55:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzr(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 56:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzm(i15, zzC(obj, j10));
                        break;
                    }
                    break;
                case 57:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzk(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 58:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzb(i15, zzY(obj, j10));
                        break;
                    }
                    break;
                case 59:
                    if (zzX(obj, i15, i12)) {
                        zzZ(i15, unsafe.getObject(obj, j10), zzngVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzv(i15, unsafe.getObject(obj, j10), zzE(i12));
                        break;
                    }
                    break;
                case 61:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzd(i15, (zzje) unsafe.getObject(obj, j10));
                        break;
                    }
                    break;
                case 62:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzH(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 63:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzi(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 64:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzw(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 65:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzy(i15, zzC(obj, j10));
                        break;
                    }
                    break;
                case 66:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzA(i15, zzr(obj, j10));
                        break;
                    }
                    break;
                case 67:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzC(i15, zzC(obj, j10));
                        break;
                    }
                    break;
                case 68:
                    if (zzX(obj, i15, i12)) {
                        zzngVar.zzq(i15, unsafe.getObject(obj, j10), zzE(i12));
                        break;
                    }
                    break;
            }
            i12 += 3;
            i11 = 1048575;
        }
        zzmo zzmoVar = this.zzn;
        zzmoVar.zzi(zzmoVar.zzd(obj), zzngVar);
    }

    private final void zzR(zzng zzngVar, int i10, Object obj, int i11) {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzS(Object obj, Object obj2, int i10) {
        return zzT(obj, i10) == zzT(obj2, i10);
    }

    private final boolean zzT(Object obj, int i10) {
        int zzy = zzy(i10);
        long j10 = zzy & 1048575;
        if (j10 != 1048575) {
            return (zzmy.zzc(obj, j10) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i10);
        long j11 = zzB & 1048575;
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmy.zza(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmy.zzb(obj, j11)) != 0;
            case 2:
                return zzmy.zzd(obj, j11) != 0;
            case 3:
                return zzmy.zzd(obj, j11) != 0;
            case 4:
                return zzmy.zzc(obj, j11) != 0;
            case 5:
                return zzmy.zzd(obj, j11) != 0;
            case 6:
                return zzmy.zzc(obj, j11) != 0;
            case 7:
                return zzmy.zzw(obj, j11);
            case 8:
                Object zzf = zzmy.zzf(obj, j11);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzje) {
                    return !zzje.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmy.zzf(obj, j11) != null;
            case 10:
                return !zzje.zzb.equals(zzmy.zzf(obj, j11));
            case 11:
                return zzmy.zzc(obj, j11) != 0;
            case 12:
                return zzmy.zzc(obj, j11) != 0;
            case 13:
                return zzmy.zzc(obj, j11) != 0;
            case 14:
                return zzmy.zzd(obj, j11) != 0;
            case 15:
                return zzmy.zzc(obj, j11) != 0;
            case 16:
                return zzmy.zzd(obj, j11) != 0;
            case 17:
                return zzmy.zzf(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzU(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzT(obj, i10) : (i12 & i13) != 0;
    }

    private static boolean zzV(Object obj, int i10, zzlx zzlxVar) {
        return zzlxVar.zzk(zzmy.zzf(obj, i10 & 1048575));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkf) {
            return ((zzkf) obj).zzbO();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i10, int i11) {
        return zzmy.zzc(obj, (long) (zzy(i11) & 1048575)) == i10;
    }

    private static boolean zzY(Object obj, long j10) {
        return ((Boolean) zzmy.zzf(obj, j10)).booleanValue();
    }

    private static final void zzZ(int i10, Object obj, zzng zzngVar) {
        if (obj instanceof String) {
            zzngVar.zzF(i10, (String) obj);
        } else {
            zzngVar.zzd(i10, (zzje) obj);
        }
    }

    public static zzmp zzd(Object obj) {
        zzkf zzkfVar = (zzkf) obj;
        zzmp zzmpVar = zzkfVar.zzc;
        if (zzmpVar != zzmp.zzc()) {
            return zzmpVar;
        }
        zzmp zzf = zzmp.zzf();
        zzkfVar.zzc = zzf;
        return zzf;
    }

    public static zzlp zzl(Class cls, zzlj zzljVar, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
        if (zzljVar instanceof zzlw) {
            return zzm((zzlw) zzljVar, zzlrVar, zzlaVar, zzmoVar, zzjsVar, zzlhVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzlp zzm(zzlw zzlwVar, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
        int i10;
        int charAt;
        int charAt2;
        int charAt3;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        char charAt4;
        int i16;
        char charAt5;
        int i17;
        char charAt6;
        int i18;
        char charAt7;
        int i19;
        char charAt8;
        int i20;
        char charAt9;
        int i21;
        char charAt10;
        int i22;
        char charAt11;
        int i23;
        int i24;
        int i25;
        int[] iArr2;
        int i26;
        int i27;
        int i28;
        int objectFieldOffset;
        Object[] objArr;
        String str;
        int i29;
        int i30;
        int i31;
        int i32;
        Field zzI;
        char charAt12;
        int i33;
        int i34;
        int i35;
        Object obj;
        Field zzI2;
        Object obj2;
        Field zzI3;
        int i36;
        char charAt13;
        int i37;
        char charAt14;
        int i38;
        char charAt15;
        int i39;
        char charAt16;
        boolean z10 = zzlwVar.zzc() == 2;
        String zzd = zzlwVar.zzd();
        int length = zzd.length();
        char c10 = 55296;
        if (zzd.charAt(0) >= 55296) {
            int i40 = 1;
            while (true) {
                i10 = i40 + 1;
                if (zzd.charAt(i40) < 55296) {
                    break;
                }
                i40 = i10;
            }
        } else {
            i10 = 1;
        }
        int i41 = i10 + 1;
        int charAt17 = zzd.charAt(i10);
        if (charAt17 >= 55296) {
            int i42 = charAt17 & 8191;
            int i43 = 13;
            while (true) {
                i39 = i41 + 1;
                charAt16 = zzd.charAt(i41);
                if (charAt16 < 55296) {
                    break;
                }
                i42 |= (charAt16 & 8191) << i43;
                i43 += 13;
                i41 = i39;
            }
            charAt17 = i42 | (charAt16 << i43);
            i41 = i39;
        }
        if (charAt17 == 0) {
            iArr = zza;
            i12 = 0;
            charAt = 0;
            i14 = 0;
            charAt2 = 0;
            i13 = 0;
            charAt3 = 0;
            i11 = 0;
        } else {
            int i44 = i41 + 1;
            int charAt18 = zzd.charAt(i41);
            if (charAt18 >= 55296) {
                int i45 = charAt18 & 8191;
                int i46 = 13;
                while (true) {
                    i22 = i44 + 1;
                    charAt11 = zzd.charAt(i44);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i45 |= (charAt11 & 8191) << i46;
                    i46 += 13;
                    i44 = i22;
                }
                charAt18 = i45 | (charAt11 << i46);
                i44 = i22;
            }
            int i47 = i44 + 1;
            int charAt19 = zzd.charAt(i44);
            if (charAt19 >= 55296) {
                int i48 = charAt19 & 8191;
                int i49 = 13;
                while (true) {
                    i21 = i47 + 1;
                    charAt10 = zzd.charAt(i47);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i48 |= (charAt10 & 8191) << i49;
                    i49 += 13;
                    i47 = i21;
                }
                charAt19 = i48 | (charAt10 << i49);
                i47 = i21;
            }
            int i50 = i47 + 1;
            charAt = zzd.charAt(i47);
            if (charAt >= 55296) {
                int i51 = charAt & 8191;
                int i52 = 13;
                while (true) {
                    i20 = i50 + 1;
                    charAt9 = zzd.charAt(i50);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i51 |= (charAt9 & 8191) << i52;
                    i52 += 13;
                    i50 = i20;
                }
                charAt = i51 | (charAt9 << i52);
                i50 = i20;
            }
            int i53 = i50 + 1;
            int charAt20 = zzd.charAt(i50);
            if (charAt20 >= 55296) {
                int i54 = charAt20 & 8191;
                int i55 = 13;
                while (true) {
                    i19 = i53 + 1;
                    charAt8 = zzd.charAt(i53);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i54 |= (charAt8 & 8191) << i55;
                    i55 += 13;
                    i53 = i19;
                }
                charAt20 = i54 | (charAt8 << i55);
                i53 = i19;
            }
            int i56 = i53 + 1;
            charAt2 = zzd.charAt(i53);
            if (charAt2 >= 55296) {
                int i57 = charAt2 & 8191;
                int i58 = 13;
                while (true) {
                    i18 = i56 + 1;
                    charAt7 = zzd.charAt(i56);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i57 |= (charAt7 & 8191) << i58;
                    i58 += 13;
                    i56 = i18;
                }
                charAt2 = i57 | (charAt7 << i58);
                i56 = i18;
            }
            int i59 = i56 + 1;
            int charAt21 = zzd.charAt(i56);
            if (charAt21 >= 55296) {
                int i60 = charAt21 & 8191;
                int i61 = 13;
                while (true) {
                    i17 = i59 + 1;
                    charAt6 = zzd.charAt(i59);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i60 |= (charAt6 & 8191) << i61;
                    i61 += 13;
                    i59 = i17;
                }
                charAt21 = i60 | (charAt6 << i61);
                i59 = i17;
            }
            int i62 = i59 + 1;
            int charAt22 = zzd.charAt(i59);
            if (charAt22 >= 55296) {
                int i63 = charAt22 & 8191;
                int i64 = 13;
                while (true) {
                    i16 = i62 + 1;
                    charAt5 = zzd.charAt(i62);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i63 |= (charAt5 & 8191) << i64;
                    i64 += 13;
                    i62 = i16;
                }
                charAt22 = i63 | (charAt5 << i64);
                i62 = i16;
            }
            int i65 = i62 + 1;
            charAt3 = zzd.charAt(i62);
            if (charAt3 >= 55296) {
                int i66 = charAt3 & 8191;
                int i67 = 13;
                while (true) {
                    i15 = i65 + 1;
                    charAt4 = zzd.charAt(i65);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i66 |= (charAt4 & 8191) << i67;
                    i67 += 13;
                    i65 = i15;
                }
                charAt3 = i66 | (charAt4 << i67);
                i65 = i15;
            }
            iArr = new int[charAt3 + charAt21 + charAt22];
            i11 = charAt18 + charAt18 + charAt19;
            i12 = charAt18;
            i41 = i65;
            int i68 = charAt21;
            i13 = charAt20;
            i14 = i68;
        }
        Unsafe unsafe = zzb;
        Object[] zze = zzlwVar.zze();
        Class<?> cls = zzlwVar.zza().getClass();
        int[] iArr3 = new int[charAt2 * 3];
        Object[] objArr2 = new Object[charAt2 + charAt2];
        int i69 = charAt3 + i14;
        int i70 = charAt3;
        int i71 = i69;
        int i72 = 0;
        int i73 = 0;
        while (i41 < length) {
            int i74 = i41 + 1;
            int charAt23 = zzd.charAt(i41);
            if (charAt23 >= c10) {
                int i75 = charAt23 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i38 = i76 + 1;
                    charAt15 = zzd.charAt(i76);
                    if (charAt15 < c10) {
                        break;
                    }
                    i75 |= (charAt15 & 8191) << i77;
                    i77 += 13;
                    i76 = i38;
                }
                charAt23 = i75 | (charAt15 << i77);
                i23 = i38;
            } else {
                i23 = i74;
            }
            int i78 = i23 + 1;
            int charAt24 = zzd.charAt(i23);
            if (charAt24 >= c10) {
                int i79 = charAt24 & 8191;
                int i80 = i78;
                int i81 = 13;
                while (true) {
                    i37 = i80 + 1;
                    charAt14 = zzd.charAt(i80);
                    i24 = length;
                    if (charAt14 < 55296) {
                        break;
                    }
                    i79 |= (charAt14 & 8191) << i81;
                    i81 += 13;
                    i80 = i37;
                    length = i24;
                }
                charAt24 = i79 | (charAt14 << i81);
                i25 = i37;
            } else {
                i24 = length;
                i25 = i78;
            }
            int i82 = charAt24 & 255;
            int i83 = charAt3;
            if ((charAt24 & 1024) != 0) {
                iArr[i73] = i72;
                i73++;
            }
            if (i82 >= 51) {
                int i84 = i25 + 1;
                int charAt25 = zzd.charAt(i25);
                if (charAt25 >= 55296) {
                    int i85 = charAt25 & 8191;
                    int i86 = i84;
                    int i87 = 13;
                    while (true) {
                        i36 = i86 + 1;
                        charAt13 = zzd.charAt(i86);
                        i27 = i13;
                        if (charAt13 < 55296) {
                            break;
                        }
                        i85 |= (charAt13 & 8191) << i87;
                        i87 += 13;
                        i86 = i36;
                        i13 = i27;
                    }
                    charAt25 = i85 | (charAt13 << i87);
                    i34 = i36;
                } else {
                    i27 = i13;
                    i34 = i84;
                }
                int i88 = i82 - 51;
                i30 = i34;
                if (i88 == 9 || i88 == 17) {
                    int i89 = i72 / 3;
                    i35 = i11 + 1;
                    objArr2[i89 + i89 + 1] = zze[i11];
                } else {
                    if (i88 == 12 && !z10) {
                        int i90 = i72 / 3;
                        i35 = i11 + 1;
                        objArr2[i90 + i90 + 1] = zze[i11];
                    }
                    int i91 = charAt25 + charAt25;
                    obj = zze[i91];
                    if (obj instanceof Field) {
                        zzI2 = zzI(cls, (String) obj);
                        zze[i91] = zzI2;
                    } else {
                        zzI2 = (Field) obj;
                    }
                    iArr2 = iArr3;
                    i26 = charAt;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzI2);
                    int i92 = i91 + 1;
                    obj2 = zze[i92];
                    if (obj2 instanceof Field) {
                        zzI3 = zzI(cls, (String) obj2);
                        zze[i92] = zzI3;
                    } else {
                        zzI3 = (Field) obj2;
                    }
                    str = zzd;
                    i29 = i12;
                    i32 = (int) unsafe.objectFieldOffset(zzI3);
                    objArr = objArr2;
                    objectFieldOffset = objectFieldOffset2;
                    i31 = 0;
                }
                i11 = i35;
                int i912 = charAt25 + charAt25;
                obj = zze[i912];
                if (obj instanceof Field) {
                }
                iArr2 = iArr3;
                i26 = charAt;
                int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zzI2);
                int i922 = i912 + 1;
                obj2 = zze[i922];
                if (obj2 instanceof Field) {
                }
                str = zzd;
                i29 = i12;
                i32 = (int) unsafe.objectFieldOffset(zzI3);
                objArr = objArr2;
                objectFieldOffset = objectFieldOffset22;
                i31 = 0;
            } else {
                iArr2 = iArr3;
                i26 = charAt;
                i27 = i13;
                int i93 = i11 + 1;
                Field zzI4 = zzI(cls, (String) zze[i11]);
                if (i82 == 9 || i82 == 17) {
                    int i94 = i72 / 3;
                    objArr2[i94 + i94 + 1] = zzI4.getType();
                } else {
                    if (i82 == 27 || i82 == 49) {
                        int i95 = i72 / 3;
                        i33 = i93 + 1;
                        objArr2[i95 + i95 + 1] = zze[i93];
                    } else if (i82 == 12 || i82 == 30 || i82 == 44) {
                        if (!z10) {
                            int i96 = i72 / 3;
                            i33 = i93 + 1;
                            objArr2[i96 + i96 + 1] = zze[i93];
                        }
                    } else if (i82 == 50) {
                        int i97 = i70 + 1;
                        iArr[i70] = i72;
                        int i98 = i72 / 3;
                        int i99 = i98 + i98;
                        int i100 = i93 + 1;
                        objArr2[i99] = zze[i93];
                        if ((charAt24 & 2048) != 0) {
                            i93 = i100 + 1;
                            objArr2[i99 + 1] = zze[i100];
                            i70 = i97;
                        } else {
                            i70 = i97;
                            i28 = i100;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzI4);
                            objArr = objArr2;
                            if ((charAt24 & 4096) == 4096 || i82 > 17) {
                                str = zzd;
                                i29 = i12;
                                i30 = i25;
                                i31 = 0;
                                i32 = 1048575;
                            } else {
                                int i101 = i25 + 1;
                                int charAt26 = zzd.charAt(i25);
                                if (charAt26 >= 55296) {
                                    int i102 = charAt26 & 8191;
                                    int i103 = 13;
                                    while (true) {
                                        i30 = i101 + 1;
                                        charAt12 = zzd.charAt(i101);
                                        if (charAt12 < 55296) {
                                            break;
                                        }
                                        i102 |= (charAt12 & 8191) << i103;
                                        i103 += 13;
                                        i101 = i30;
                                    }
                                    charAt26 = i102 | (charAt12 << i103);
                                } else {
                                    i30 = i101;
                                }
                                int i104 = i12 + i12 + (charAt26 / 32);
                                Object obj3 = zze[i104];
                                str = zzd;
                                if (obj3 instanceof Field) {
                                    zzI = (Field) obj3;
                                } else {
                                    zzI = zzI(cls, (String) obj3);
                                    zze[i104] = zzI;
                                }
                                i29 = i12;
                                i32 = (int) unsafe.objectFieldOffset(zzI);
                                i31 = charAt26 % 32;
                            }
                            if (i82 >= 18 && i82 <= 49) {
                                iArr[i71] = objectFieldOffset;
                                i71++;
                            }
                            i11 = i28;
                        }
                    }
                    i28 = i33;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzI4);
                    objArr = objArr2;
                    if ((charAt24 & 4096) == 4096) {
                    }
                    str = zzd;
                    i29 = i12;
                    i30 = i25;
                    i31 = 0;
                    i32 = 1048575;
                    if (i82 >= 18) {
                        iArr[i71] = objectFieldOffset;
                        i71++;
                    }
                    i11 = i28;
                }
                i28 = i93;
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzI4);
                objArr = objArr2;
                if ((charAt24 & 4096) == 4096) {
                }
                str = zzd;
                i29 = i12;
                i30 = i25;
                i31 = 0;
                i32 = 1048575;
                if (i82 >= 18) {
                }
                i11 = i28;
            }
            int i105 = i72 + 1;
            iArr2[i72] = charAt23;
            int i106 = i105 + 1;
            iArr2[i105] = ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (i82 << 20) | objectFieldOffset;
            i72 = i106 + 1;
            iArr2[i106] = (i31 << 20) | i32;
            i12 = i29;
            charAt = i26;
            charAt3 = i83;
            i41 = i30;
            length = i24;
            objArr2 = objArr;
            zzd = str;
            iArr3 = iArr2;
            i13 = i27;
            c10 = 55296;
        }
        return new zzlp(iArr3, objArr2, charAt, i13, zzlwVar.zza(), z10, false, iArr, charAt3, i69, zzlrVar, zzlaVar, zzmoVar, zzjsVar, zzlhVar, null);
    }

    private static double zzn(Object obj, long j10) {
        return ((Double) zzmy.zzf(obj, j10)).doubleValue();
    }

    private static float zzo(Object obj, long j10) {
        return ((Float) zzmy.zzf(obj, j10)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i10;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int i11;
        int zzu;
        int zzi;
        int zzz;
        int zzA8;
        int i12;
        int zzA9;
        int zzA10;
        int zzA11;
        int zzB2;
        int zzA12;
        int zzd2;
        int zzA13;
        int i13;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1048575;
        while (i15 < this.zzc.length) {
            int zzB3 = zzB(i15);
            int[] iArr = this.zzc;
            int i19 = iArr[i15];
            int zzA14 = zzA(zzB3);
            if (zzA14 <= 17) {
                int i20 = iArr[i15 + 2];
                int i21 = i20 & i14;
                i10 = 1 << (i20 >>> 20);
                if (i21 != i18) {
                    i17 = unsafe.getInt(obj, i21);
                    i18 = i21;
                }
            } else {
                i10 = 0;
            }
            long j10 = zzB3 & i14;
            switch (zzA14) {
                case 0:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA = zzjm.zzA(i19 << 3);
                        zzA5 = zzA + 8;
                        i16 += zzA5;
                        break;
                    }
                case 1:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA2 = zzjm.zzA(i19 << 3);
                        zzA5 = zzA2 + 4;
                        i16 += zzA5;
                        break;
                    }
                case 2:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        long j11 = unsafe.getLong(obj, j10);
                        zzA3 = zzjm.zzA(i19 << 3);
                        zzB = zzjm.zzB(j11);
                        i16 += zzA3 + zzB;
                        break;
                    }
                case 3:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        long j12 = unsafe.getLong(obj, j10);
                        zzA3 = zzjm.zzA(i19 << 3);
                        zzB = zzjm.zzB(j12);
                        i16 += zzA3 + zzB;
                        break;
                    }
                case 4:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        int i22 = unsafe.getInt(obj, j10);
                        zzA4 = zzjm.zzA(i19 << 3);
                        zzv = zzjm.zzv(i22);
                        i11 = zzA4 + zzv;
                        i16 += i11;
                        break;
                    }
                case 5:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA = zzjm.zzA(i19 << 3);
                        zzA5 = zzA + 8;
                        i16 += zzA5;
                        break;
                    }
                case 6:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA2 = zzjm.zzA(i19 << 3);
                        zzA5 = zzA2 + 4;
                        i16 += zzA5;
                        break;
                    }
                case 7:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA5 = zzjm.zzA(i19 << 3) + 1;
                        i16 += zzA5;
                        break;
                    }
                case 8:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof zzje) {
                            zzA6 = zzjm.zzA(i19 << 3);
                            zzd = ((zzje) object).zzd();
                            zzA7 = zzjm.zzA(zzd);
                            i11 = zzA6 + zzA7 + zzd;
                            i16 += i11;
                            break;
                        } else {
                            zzA4 = zzjm.zzA(i19 << 3);
                            zzv = zzjm.zzy((String) object);
                            i11 = zzA4 + zzv;
                            i16 += i11;
                        }
                    }
                case 9:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA5 = zzlz.zzo(i19, unsafe.getObject(obj, j10), zzE(i15));
                        i16 += zzA5;
                        break;
                    }
                case 10:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzje zzjeVar = (zzje) unsafe.getObject(obj, j10);
                        zzA6 = zzjm.zzA(i19 << 3);
                        zzd = zzjeVar.zzd();
                        zzA7 = zzjm.zzA(zzd);
                        i11 = zzA6 + zzA7 + zzd;
                        i16 += i11;
                        break;
                    }
                case 11:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        int i23 = unsafe.getInt(obj, j10);
                        zzA4 = zzjm.zzA(i19 << 3);
                        zzv = zzjm.zzA(i23);
                        i11 = zzA4 + zzv;
                        i16 += i11;
                        break;
                    }
                case 12:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        int i24 = unsafe.getInt(obj, j10);
                        zzA4 = zzjm.zzA(i19 << 3);
                        zzv = zzjm.zzv(i24);
                        i11 = zzA4 + zzv;
                        i16 += i11;
                        break;
                    }
                case 13:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA2 = zzjm.zzA(i19 << 3);
                        zzA5 = zzA2 + 4;
                        i16 += zzA5;
                        break;
                    }
                case 14:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA = zzjm.zzA(i19 << 3);
                        zzA5 = zzA + 8;
                        i16 += zzA5;
                        break;
                    }
                case 15:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        int i25 = unsafe.getInt(obj, j10);
                        zzA4 = zzjm.zzA(i19 << 3);
                        zzv = zzjm.zzA((i25 >> 31) ^ (i25 + i25));
                        i11 = zzA4 + zzv;
                        i16 += i11;
                        break;
                    }
                case 16:
                    if ((i10 & i17) == 0) {
                        break;
                    } else {
                        long j13 = unsafe.getLong(obj, j10);
                        i16 += zzjm.zzA(i19 << 3) + zzjm.zzB((j13 >> 63) ^ (j13 + j13));
                        break;
                    }
                case 17:
                    if ((i17 & i10) == 0) {
                        break;
                    } else {
                        zzA5 = zzjm.zzu(i19, (zzlm) unsafe.getObject(obj, j10), zzE(i15));
                        i16 += zzA5;
                        break;
                    }
                case 18:
                    zzA5 = zzlz.zzh(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 19:
                    zzA5 = zzlz.zzf(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 20:
                    zzA5 = zzlz.zzm(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 21:
                    zzA5 = zzlz.zzx(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 22:
                    zzA5 = zzlz.zzk(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 23:
                    zzA5 = zzlz.zzh(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 24:
                    zzA5 = zzlz.zzf(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 25:
                    zzA5 = zzlz.zza(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzA5;
                    break;
                case 26:
                    zzu = zzlz.zzu(i19, (List) unsafe.getObject(obj, j10));
                    i16 += zzu;
                    break;
                case 27:
                    zzu = zzlz.zzp(i19, (List) unsafe.getObject(obj, j10), zzE(i15));
                    i16 += zzu;
                    break;
                case 28:
                    zzu = zzlz.zzc(i19, (List) unsafe.getObject(obj, j10));
                    i16 += zzu;
                    break;
                case 29:
                    zzu = zzlz.zzv(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 30:
                    zzu = zzlz.zzd(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 31:
                    zzu = zzlz.zzf(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 32:
                    zzu = zzlz.zzh(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 33:
                    zzu = zzlz.zzq(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 34:
                    zzu = zzlz.zzs(i19, (List) unsafe.getObject(obj, j10), false);
                    i16 += zzu;
                    break;
                case 35:
                    zzi = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 36:
                    zzi = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 37:
                    zzi = zzlz.zzn((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 38:
                    zzi = zzlz.zzy((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 39:
                    zzi = zzlz.zzl((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 40:
                    zzi = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 41:
                    zzi = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 42:
                    zzi = zzlz.zzb((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 43:
                    zzi = zzlz.zzw((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 44:
                    zzi = zzlz.zze((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 45:
                    zzi = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 46:
                    zzi = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 47:
                    zzi = zzlz.zzr((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 48:
                    zzi = zzlz.zzt((List) unsafe.getObject(obj, j10));
                    if (zzi > 0) {
                        zzz = zzjm.zzz(i19);
                        zzA8 = zzjm.zzA(zzi);
                        i12 = zzz + zzA8;
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 49:
                    zzu = zzlz.zzj(i19, (List) unsafe.getObject(obj, j10), zzE(i15));
                    i16 += zzu;
                    break;
                case 50:
                    zzlh.zza(i19, unsafe.getObject(obj, j10), zzF(i15));
                    break;
                case 51:
                    if (zzX(obj, i19, i15)) {
                        zzA9 = zzjm.zzA(i19 << 3);
                        zzu = zzA9 + 8;
                        i16 += zzu;
                    }
                    break;
                case 52:
                    if (zzX(obj, i19, i15)) {
                        zzA10 = zzjm.zzA(i19 << 3);
                        zzu = zzA10 + 4;
                        i16 += zzu;
                    }
                    break;
                case 53:
                    if (zzX(obj, i19, i15)) {
                        long zzC = zzC(obj, j10);
                        zzA11 = zzjm.zzA(i19 << 3);
                        zzB2 = zzjm.zzB(zzC);
                        i16 += zzA11 + zzB2;
                    }
                    break;
                case 54:
                    if (zzX(obj, i19, i15)) {
                        long zzC2 = zzC(obj, j10);
                        zzA11 = zzjm.zzA(i19 << 3);
                        zzB2 = zzjm.zzB(zzC2);
                        i16 += zzA11 + zzB2;
                    }
                    break;
                case 55:
                    if (zzX(obj, i19, i15)) {
                        int zzr = zzr(obj, j10);
                        i12 = zzjm.zzA(i19 << 3);
                        zzi = zzjm.zzv(zzr);
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 56:
                    if (zzX(obj, i19, i15)) {
                        zzA9 = zzjm.zzA(i19 << 3);
                        zzu = zzA9 + 8;
                        i16 += zzu;
                    }
                    break;
                case 57:
                    if (zzX(obj, i19, i15)) {
                        zzA10 = zzjm.zzA(i19 << 3);
                        zzu = zzA10 + 4;
                        i16 += zzu;
                    }
                    break;
                case 58:
                    if (zzX(obj, i19, i15)) {
                        zzu = zzjm.zzA(i19 << 3) + 1;
                        i16 += zzu;
                    }
                    break;
                case 59:
                    if (zzX(obj, i19, i15)) {
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof zzje) {
                            zzA12 = zzjm.zzA(i19 << 3);
                            zzd2 = ((zzje) object2).zzd();
                            zzA13 = zzjm.zzA(zzd2);
                            i13 = zzA12 + zzA13 + zzd2;
                            i16 += i13;
                        } else {
                            i12 = zzjm.zzA(i19 << 3);
                            zzi = zzjm.zzy((String) object2);
                            i13 = i12 + zzi;
                            i16 += i13;
                        }
                    }
                    break;
                case 60:
                    if (zzX(obj, i19, i15)) {
                        zzu = zzlz.zzo(i19, unsafe.getObject(obj, j10), zzE(i15));
                        i16 += zzu;
                    }
                    break;
                case 61:
                    if (zzX(obj, i19, i15)) {
                        zzje zzjeVar2 = (zzje) unsafe.getObject(obj, j10);
                        zzA12 = zzjm.zzA(i19 << 3);
                        zzd2 = zzjeVar2.zzd();
                        zzA13 = zzjm.zzA(zzd2);
                        i13 = zzA12 + zzA13 + zzd2;
                        i16 += i13;
                    }
                    break;
                case 62:
                    if (zzX(obj, i19, i15)) {
                        int zzr2 = zzr(obj, j10);
                        i12 = zzjm.zzA(i19 << 3);
                        zzi = zzjm.zzA(zzr2);
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 63:
                    if (zzX(obj, i19, i15)) {
                        int zzr3 = zzr(obj, j10);
                        i12 = zzjm.zzA(i19 << 3);
                        zzi = zzjm.zzv(zzr3);
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 64:
                    if (zzX(obj, i19, i15)) {
                        zzA10 = zzjm.zzA(i19 << 3);
                        zzu = zzA10 + 4;
                        i16 += zzu;
                    }
                    break;
                case 65:
                    if (zzX(obj, i19, i15)) {
                        zzA9 = zzjm.zzA(i19 << 3);
                        zzu = zzA9 + 8;
                        i16 += zzu;
                    }
                    break;
                case 66:
                    if (zzX(obj, i19, i15)) {
                        int zzr4 = zzr(obj, j10);
                        i12 = zzjm.zzA(i19 << 3);
                        zzi = zzjm.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i13 = i12 + zzi;
                        i16 += i13;
                    }
                    break;
                case 67:
                    if (zzX(obj, i19, i15)) {
                        long zzC3 = zzC(obj, j10);
                        i16 += zzjm.zzA(i19 << 3) + zzjm.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                    }
                    break;
                case 68:
                    if (zzX(obj, i19, i15)) {
                        zzu = zzjm.zzu(i19, (zzlm) unsafe.getObject(obj, j10), zzE(i15));
                        i16 += zzu;
                    }
                    break;
            }
            i15 += 3;
            i14 = 1048575;
        }
        zzmo zzmoVar = this.zzn;
        int zza2 = i16 + zzmoVar.zza(zzmoVar.zzd(obj));
        if (!this.zzh) {
            return zza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final int zzq(Object obj) {
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzz;
        int zzA8;
        int i10;
        Unsafe unsafe = zzb;
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzc.length; i12 += 3) {
            int zzB2 = zzB(i12);
            int zzA9 = zzA(zzB2);
            int i13 = this.zzc[i12];
            long j10 = zzB2 & 1048575;
            if (zzA9 >= zzjx.zzJ.zza() && zzA9 <= zzjx.zzW.zza()) {
                int i14 = this.zzc[i12 + 2];
            }
            switch (zzA9) {
                case 0:
                    if (zzT(obj, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzT(obj, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzT(obj, i12)) {
                        long zzd2 = zzmy.zzd(obj, j10);
                        zzA3 = zzjm.zzA(i13 << 3);
                        zzB = zzjm.zzB(zzd2);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzT(obj, i12)) {
                        long zzd3 = zzmy.zzd(obj, j10);
                        zzA3 = zzjm.zzA(i13 << 3);
                        zzB = zzjm.zzB(zzd3);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzT(obj, i12)) {
                        int zzc = zzmy.zzc(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzv(zzc);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzT(obj, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzT(obj, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzT(obj, i12)) {
                        zzA5 = zzjm.zzA(i13 << 3);
                        zzo = zzA5 + 1;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzT(obj, i12)) {
                        break;
                    } else {
                        Object zzf = zzmy.zzf(obj, j10);
                        if (zzf instanceof zzje) {
                            zzA6 = zzjm.zzA(i13 << 3);
                            zzd = ((zzje) zzf).zzd();
                            zzA7 = zzjm.zzA(zzd);
                            i10 = zzA6 + zzA7 + zzd;
                            i11 += i10;
                            break;
                        } else {
                            zzA4 = zzjm.zzA(i13 << 3);
                            zzv = zzjm.zzy((String) zzf);
                            i10 = zzA4 + zzv;
                            i11 += i10;
                        }
                    }
                case 9:
                    if (zzT(obj, i12)) {
                        zzo = zzlz.zzo(i13, zzmy.zzf(obj, j10), zzE(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzT(obj, i12)) {
                        zzje zzjeVar = (zzje) zzmy.zzf(obj, j10);
                        zzA6 = zzjm.zzA(i13 << 3);
                        zzd = zzjeVar.zzd();
                        zzA7 = zzjm.zzA(zzd);
                        i10 = zzA6 + zzA7 + zzd;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzT(obj, i12)) {
                        int zzc2 = zzmy.zzc(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzA(zzc2);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzT(obj, i12)) {
                        int zzc3 = zzmy.zzc(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzv(zzc3);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzT(obj, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzT(obj, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzT(obj, i12)) {
                        int zzc4 = zzmy.zzc(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzA((zzc4 >> 31) ^ (zzc4 + zzc4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzT(obj, i12)) {
                        long zzd4 = zzmy.zzd(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzB((zzd4 >> 63) ^ (zzd4 + zzd4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzT(obj, i12)) {
                        zzo = zzjm.zzu(i13, (zzlm) zzmy.zzf(obj, j10), zzE(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzlz.zzh(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 19:
                    zzo = zzlz.zzf(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 20:
                    zzo = zzlz.zzm(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 21:
                    zzo = zzlz.zzx(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 22:
                    zzo = zzlz.zzk(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 23:
                    zzo = zzlz.zzh(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 24:
                    zzo = zzlz.zzf(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 25:
                    zzo = zzlz.zza(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 26:
                    zzo = zzlz.zzu(i13, (List) zzmy.zzf(obj, j10));
                    i11 += zzo;
                    break;
                case 27:
                    zzo = zzlz.zzp(i13, (List) zzmy.zzf(obj, j10), zzE(i12));
                    i11 += zzo;
                    break;
                case 28:
                    zzo = zzlz.zzc(i13, (List) zzmy.zzf(obj, j10));
                    i11 += zzo;
                    break;
                case 29:
                    zzo = zzlz.zzv(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 30:
                    zzo = zzlz.zzd(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 31:
                    zzo = zzlz.zzf(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 32:
                    zzo = zzlz.zzh(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 33:
                    zzo = zzlz.zzq(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 34:
                    zzo = zzlz.zzs(i13, (List) zzmy.zzf(obj, j10), false);
                    i11 += zzo;
                    break;
                case 35:
                    zzv = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzlz.zzn((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzlz.zzy((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzlz.zzl((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzlz.zzb((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzlz.zzw((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzlz.zze((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzlz.zzg((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzlz.zzi((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzlz.zzr((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzlz.zzt((List) unsafe.getObject(obj, j10));
                    if (zzv > 0) {
                        zzz = zzjm.zzz(i13);
                        zzA8 = zzjm.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzlz.zzj(i13, (List) zzmy.zzf(obj, j10), zzE(i12));
                    i11 += zzo;
                    break;
                case 50:
                    zzlh.zza(i13, zzmy.zzf(obj, j10), zzF(i12));
                    break;
                case 51:
                    if (zzX(obj, i13, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzX(obj, i13, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzX(obj, i13, i12)) {
                        long zzC = zzC(obj, j10);
                        zzA3 = zzjm.zzA(i13 << 3);
                        zzB = zzjm.zzB(zzC);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzX(obj, i13, i12)) {
                        long zzC2 = zzC(obj, j10);
                        zzA3 = zzjm.zzA(i13 << 3);
                        zzB = zzjm.zzB(zzC2);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzX(obj, i13, i12)) {
                        int zzr = zzr(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzv(zzr);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzX(obj, i13, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzX(obj, i13, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzX(obj, i13, i12)) {
                        zzA5 = zzjm.zzA(i13 << 3);
                        zzo = zzA5 + 1;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzX(obj, i13, i12)) {
                        break;
                    } else {
                        Object zzf2 = zzmy.zzf(obj, j10);
                        if (zzf2 instanceof zzje) {
                            zzA6 = zzjm.zzA(i13 << 3);
                            zzd = ((zzje) zzf2).zzd();
                            zzA7 = zzjm.zzA(zzd);
                            i10 = zzA6 + zzA7 + zzd;
                            i11 += i10;
                            break;
                        } else {
                            zzA4 = zzjm.zzA(i13 << 3);
                            zzv = zzjm.zzy((String) zzf2);
                            i10 = zzA4 + zzv;
                            i11 += i10;
                        }
                    }
                case 60:
                    if (zzX(obj, i13, i12)) {
                        zzo = zzlz.zzo(i13, zzmy.zzf(obj, j10), zzE(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzX(obj, i13, i12)) {
                        zzje zzjeVar2 = (zzje) zzmy.zzf(obj, j10);
                        zzA6 = zzjm.zzA(i13 << 3);
                        zzd = zzjeVar2.zzd();
                        zzA7 = zzjm.zzA(zzd);
                        i10 = zzA6 + zzA7 + zzd;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzX(obj, i13, i12)) {
                        int zzr2 = zzr(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzA(zzr2);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzX(obj, i13, i12)) {
                        int zzr3 = zzr(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzv(zzr3);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzX(obj, i13, i12)) {
                        zzA2 = zzjm.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzX(obj, i13, i12)) {
                        zzA = zzjm.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzX(obj, i13, i12)) {
                        int zzr4 = zzr(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzX(obj, i13, i12)) {
                        long zzC3 = zzC(obj, j10);
                        zzA4 = zzjm.zzA(i13 << 3);
                        zzv = zzjm.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzX(obj, i13, i12)) {
                        zzo = zzjm.zzu(i13, (zzlm) zzmy.zzf(obj, j10), zzE(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmo zzmoVar = this.zzn;
        return i11 + zzmoVar.zza(zzmoVar.zzd(obj));
    }

    private static int zzr(Object obj, long j10) {
        return ((Integer) zzmy.zzf(obj, j10)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i10, int i11, int i12, long j10, zzir zzirVar) {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i12);
        Object object = unsafe.getObject(obj, j10);
        if (!((zzlg) object).zze()) {
            zzlg zzb2 = zzlg.zza().zzb();
            zzlh.zzb(zzb2, object);
            unsafe.putObject(obj, j10, zzb2);
        }
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, zzir zzirVar) {
        Unsafe unsafe = zzb;
        long j11 = this.zzc[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 == 1) {
                    unsafe.putObject(obj, j10, Double.valueOf(Double.longBitsToDouble(zzis.zzp(bArr, i10))));
                    unsafe.putInt(obj, j11, i13);
                    return i10 + 8;
                }
                break;
            case 52:
                if (i14 == 5) {
                    unsafe.putObject(obj, j10, Float.valueOf(Float.intBitsToFloat(zzis.zzb(bArr, i10))));
                    unsafe.putInt(obj, j11, i13);
                    return i10 + 4;
                }
                break;
            case 53:
            case 54:
                if (i14 == 0) {
                    int zzm = zzis.zzm(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, Long.valueOf(zzirVar.zzb));
                    unsafe.putInt(obj, j11, i13);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i14 == 0) {
                    int zzj = zzis.zzj(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, Integer.valueOf(zzirVar.zza));
                    unsafe.putInt(obj, j11, i13);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i14 == 1) {
                    unsafe.putObject(obj, j10, Long.valueOf(zzis.zzp(bArr, i10)));
                    unsafe.putInt(obj, j11, i13);
                    return i10 + 8;
                }
                break;
            case 57:
            case 64:
                if (i14 == 5) {
                    unsafe.putObject(obj, j10, Integer.valueOf(zzis.zzb(bArr, i10)));
                    unsafe.putInt(obj, j11, i13);
                    return i10 + 4;
                }
                break;
            case 58:
                if (i14 == 0) {
                    int zzm2 = zzis.zzm(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, Boolean.valueOf(zzirVar.zzb != 0));
                    unsafe.putInt(obj, j11, i13);
                    return zzm2;
                }
                break;
            case 59:
                if (i14 == 2) {
                    int zzj2 = zzis.zzj(bArr, i10, zzirVar);
                    int i18 = zzirVar.zza;
                    if (i18 == 0) {
                        unsafe.putObject(obj, j10, "");
                    } else {
                        if ((i15 & 536870912) != 0 && !zznd.zzf(bArr, zzj2, zzj2 + i18)) {
                            throw zzkp.zzc();
                        }
                        unsafe.putObject(obj, j10, new String(bArr, zzj2, i18, zzkn.zzb));
                        zzj2 += i18;
                    }
                    unsafe.putInt(obj, j11, i13);
                    return zzj2;
                }
                break;
            case 60:
                if (i14 == 2) {
                    Object zzH = zzH(obj, i13, i17);
                    int zzo = zzis.zzo(zzH, zzE(i17), bArr, i10, i11, zzirVar);
                    zzP(obj, i13, i17, zzH);
                    return zzo;
                }
                break;
            case 61:
                if (i14 == 2) {
                    int zza2 = zzis.zza(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, zzirVar.zzc);
                    unsafe.putInt(obj, j11, i13);
                    return zza2;
                }
                break;
            case 63:
                if (i14 == 0) {
                    int zzj3 = zzis.zzj(bArr, i10, zzirVar);
                    int i19 = zzirVar.zza;
                    zzkj zzD = zzD(i17);
                    if (zzD == null || zzD.zza(i19)) {
                        unsafe.putObject(obj, j10, Integer.valueOf(i19));
                        unsafe.putInt(obj, j11, i13);
                    } else {
                        zzd(obj).zzj(i12, Long.valueOf(i19));
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i14 == 0) {
                    int zzj4 = zzis.zzj(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, Integer.valueOf(zzji.zzb(zzirVar.zza)));
                    unsafe.putInt(obj, j11, i13);
                    return zzj4;
                }
                break;
            case 67:
                if (i14 == 0) {
                    int zzm3 = zzis.zzm(bArr, i10, zzirVar);
                    unsafe.putObject(obj, j10, Long.valueOf(zzji.zzc(zzirVar.zzb)));
                    unsafe.putInt(obj, j11, i13);
                    return zzm3;
                }
                break;
            case 68:
                if (i14 == 3) {
                    Object zzH2 = zzH(obj, i13, i17);
                    int zzn = zzis.zzn(zzH2, zzE(i17), bArr, i10, i11, (i12 & (-8)) | 4, zzirVar);
                    zzP(obj, i13, i17, zzH2);
                    return zzn;
                }
                break;
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x029a, code lost:
    
        if (r0 != r15) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x029c, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r2 = r19;
        r1 = r23;
        r7 = r26;
        r6 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02b0, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02dd, code lost:
    
        if (r0 != r15) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0301, code lost:
    
        if (r0 != r15) goto L100;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0087. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zzu(Object obj, byte[] bArr, int i10, int i11, zzir zzirVar) {
        byte b10;
        int i12;
        int i13;
        int i14;
        Unsafe unsafe;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int zza2;
        int zzm;
        zzlp<T> zzlpVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i22 = i11;
        zzir zzirVar2 = zzirVar;
        zzJ(obj);
        Unsafe unsafe2 = zzb;
        int i23 = 1048575;
        int i24 = -1;
        int i25 = i10;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (i25 < i22) {
            int i30 = i25 + 1;
            byte b11 = bArr2[i25];
            if (b11 < 0) {
                i12 = zzis.zzk(b11, bArr2, i30, zzirVar2);
                b10 = zzirVar2.zza;
            } else {
                b10 = b11;
                i12 = i30;
            }
            int i31 = b10 >>> 3;
            int i32 = b10 & 7;
            int zzx = i31 > i26 ? zzlpVar.zzx(i31, i27 / 3) : zzlpVar.zzw(i31);
            if (zzx == i24) {
                i13 = i12;
                i14 = i31;
                unsafe = unsafe2;
                i15 = 0;
            } else {
                int[] iArr = zzlpVar.zzc;
                int i33 = iArr[zzx + 1];
                int zzA = zzA(i33);
                long j10 = i33 & i23;
                if (zzA <= 17) {
                    int i34 = iArr[zzx + 2];
                    int i35 = 1 << (i34 >>> 20);
                    int i36 = 1048575;
                    int i37 = i34 & 1048575;
                    if (i37 != i29) {
                        if (i29 != 1048575) {
                            unsafe2.putInt(obj2, i29, i28);
                            i36 = 1048575;
                        }
                        if (i37 != i36) {
                            i28 = unsafe2.getInt(obj2, i37);
                        }
                        i29 = i37;
                    }
                    switch (zzA) {
                        case 0:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i20 = i12;
                            i21 = i28;
                            if (i32 == 1) {
                                zzmy.zzo(obj2, j10, Double.longBitsToDouble(zzis.zzp(bArr2, i20)));
                                i25 = i20 + 8;
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 1:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i20 = i12;
                            i21 = i28;
                            if (i32 == 5) {
                                zzmy.zzp(obj2, j10, Float.intBitsToFloat(zzis.zzb(bArr2, i20)));
                                i25 = i20 + 4;
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 2:
                        case 3:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i20 = i12;
                            i21 = i28;
                            if (i32 != 0) {
                                i28 = i21;
                                unsafe = unsafe2;
                                i15 = i16;
                                i13 = i20;
                                break;
                            } else {
                                zzm = zzis.zzm(bArr2, i20, zzirVar2);
                                unsafe2.putLong(obj, j10, zzirVar2.zzb);
                                i28 = i21 | i35;
                                i27 = i16;
                                i25 = zzm;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                i22 = i11;
                                break;
                            }
                        case 4:
                        case 11:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i20 = i12;
                            i21 = i28;
                            if (i32 == 0) {
                                i25 = zzis.zzj(bArr2, i20, zzirVar2);
                                unsafe2.putInt(obj2, j10, zzirVar2.zza);
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 5:
                        case 14:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i21 = i28;
                            if (i32 == 1) {
                                i20 = i12;
                                unsafe2.putLong(obj, j10, zzis.zzp(bArr2, i12));
                                i25 = i20 + 8;
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 6:
                        case 13:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i21 = i28;
                            if (i32 == 5) {
                                unsafe2.putInt(obj2, j10, zzis.zzb(bArr2, i12));
                                i25 = i12 + 4;
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 7:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i21 = i28;
                            if (i32 == 0) {
                                int zzm2 = zzis.zzm(bArr2, i12, zzirVar2);
                                zzmy.zzm(obj2, j10, zzirVar2.zzb != 0);
                                i28 = i21 | i35;
                                i22 = i11;
                                i25 = zzm2;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 8:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            i21 = i28;
                            if (i32 == 2) {
                                i25 = (536870912 & i33) == 0 ? zzis.zzg(bArr2, i12, zzirVar2) : zzis.zzh(bArr2, i12, zzirVar2);
                                unsafe2.putObject(obj2, j10, zzirVar2.zzc);
                                i28 = i21 | i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 9:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            if (i32 == 2) {
                                Object zzG = zzlpVar.zzG(obj2, i16);
                                i25 = zzis.zzo(zzG, zzlpVar.zzE(i16), bArr, i12, i11, zzirVar);
                                zzlpVar.zzO(obj2, i16, zzG);
                                i28 |= i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i21 = i28;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 10:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            if (i32 == 2) {
                                zza2 = zzis.zza(bArr2, i12, zzirVar2);
                                unsafe2.putObject(obj2, j10, zzirVar2.zzc);
                                i28 |= i35;
                                i22 = i11;
                                i25 = zza2;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i21 = i28;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 12:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            if (i32 == 0) {
                                zza2 = zzis.zzj(bArr2, i12, zzirVar2);
                                unsafe2.putInt(obj2, j10, zzirVar2.zza);
                                i28 |= i35;
                                i22 = i11;
                                i25 = zza2;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i21 = i28;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 15:
                            i14 = i31;
                            zzirVar2 = zzirVar;
                            i16 = zzx;
                            if (i32 == 0) {
                                i25 = zzis.zzj(bArr2, i12, zzirVar2);
                                unsafe2.putInt(obj2, j10, zzji.zzb(zzirVar2.zza));
                                i28 |= i35;
                                i22 = i11;
                                i27 = i16;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                break;
                            }
                            i20 = i12;
                            i21 = i28;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                        case 16:
                            if (i32 != 0) {
                                i14 = i31;
                                i16 = zzx;
                                i20 = i12;
                                i21 = i28;
                                i28 = i21;
                                unsafe = unsafe2;
                                i15 = i16;
                                i13 = i20;
                                break;
                            } else {
                                zzirVar2 = zzirVar;
                                zzm = zzis.zzm(bArr2, i12, zzirVar2);
                                i16 = zzx;
                                i14 = i31;
                                unsafe2.putLong(obj, j10, zzji.zzc(zzirVar2.zzb));
                                i28 |= i35;
                                i27 = i16;
                                i25 = zzm;
                                i26 = i14;
                                i24 = -1;
                                i23 = 1048575;
                                i22 = i11;
                                break;
                            }
                        default:
                            i14 = i31;
                            i16 = zzx;
                            i20 = i12;
                            i21 = i28;
                            i28 = i21;
                            unsafe = unsafe2;
                            i15 = i16;
                            i13 = i20;
                            break;
                    }
                } else {
                    i14 = i31;
                    int i38 = i28;
                    zzirVar2 = zzirVar;
                    i16 = zzx;
                    if (zzA != 27) {
                        if (zzA <= 49) {
                            int i39 = i12;
                            i18 = i29;
                            i19 = i38;
                            unsafe = unsafe2;
                            i15 = i16;
                            i25 = zzv(obj, bArr, i12, i11, b10, i14, i32, i16, i33, zzA, j10, zzirVar);
                        } else {
                            i17 = i12;
                            i18 = i29;
                            i19 = i38;
                            unsafe = unsafe2;
                            i15 = i16;
                            if (zzA != 50) {
                                i25 = zzt(obj, bArr, i17, i11, b10, i14, i32, i33, zzA, j10, i15, zzirVar);
                            } else if (i32 == 2) {
                                i25 = zzs(obj, bArr, i17, i11, i15, j10, zzirVar);
                            }
                        }
                        i24 = -1;
                        i23 = 1048575;
                    } else if (i32 == 2) {
                        zzkm zzkmVar = (zzkm) unsafe2.getObject(obj2, j10);
                        if (!zzkmVar.zzc()) {
                            int size = zzkmVar.size();
                            zzkmVar = zzkmVar.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj2, j10, zzkmVar);
                        }
                        i25 = zzis.zze(zzlpVar.zzE(i16), b10, bArr, i12, i11, zzkmVar, zzirVar);
                        i22 = i11;
                        i28 = i38;
                        i27 = i16;
                        i26 = i14;
                        i24 = -1;
                        i23 = 1048575;
                    } else {
                        i17 = i12;
                        i18 = i29;
                        i19 = i38;
                        unsafe = unsafe2;
                        i15 = i16;
                    }
                    i13 = i17;
                    i29 = i18;
                    i28 = i19;
                }
            }
            i25 = zzis.zzi(b10, bArr, i13, i11, zzd(obj), zzirVar);
            zzlpVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i22 = i11;
            zzirVar2 = zzirVar;
            i27 = i15;
            i26 = i14;
            unsafe2 = unsafe;
            i24 = -1;
            i23 = 1048575;
        }
        int i40 = i28;
        Unsafe unsafe3 = unsafe2;
        if (i29 != 1048575) {
            unsafe3.putInt(obj, i29, i40);
        }
        if (i25 == i11) {
            return i25;
        }
        throw zzkp.zze();
    }

    private final int zzv(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, zzir zzirVar) {
        int i17;
        int i18;
        int i19;
        int i20;
        int zzj;
        int i21 = i10;
        Unsafe unsafe = zzb;
        zzkm zzkmVar = (zzkm) unsafe.getObject(obj, j11);
        if (!zzkmVar.zzc()) {
            int size = zzkmVar.size();
            zzkmVar = zzkmVar.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j11, zzkmVar);
        }
        switch (i16) {
            case 18:
            case 35:
                if (i14 == 2) {
                    zzjo zzjoVar = (zzjo) zzkmVar;
                    int zzj2 = zzis.zzj(bArr, i21, zzirVar);
                    int i22 = zzirVar.zza + zzj2;
                    while (zzj2 < i22) {
                        zzjoVar.zze(Double.longBitsToDouble(zzis.zzp(bArr, zzj2)));
                        zzj2 += 8;
                    }
                    if (zzj2 == i22) {
                        return zzj2;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 1) {
                    zzjo zzjoVar2 = (zzjo) zzkmVar;
                    zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(bArr, i10)));
                    while (true) {
                        i17 = i21 + 8;
                        if (i17 < i11) {
                            i21 = zzis.zzj(bArr, i17, zzirVar);
                            if (i12 == zzirVar.zza) {
                                zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(bArr, i21)));
                            }
                        }
                    }
                    return i17;
                }
                return i21;
            case 19:
            case 36:
                if (i14 == 2) {
                    zzjy zzjyVar = (zzjy) zzkmVar;
                    int zzj3 = zzis.zzj(bArr, i21, zzirVar);
                    int i23 = zzirVar.zza + zzj3;
                    while (zzj3 < i23) {
                        zzjyVar.zze(Float.intBitsToFloat(zzis.zzb(bArr, zzj3)));
                        zzj3 += 4;
                    }
                    if (zzj3 == i23) {
                        return zzj3;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 5) {
                    zzjy zzjyVar2 = (zzjy) zzkmVar;
                    zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(bArr, i10)));
                    while (true) {
                        i18 = i21 + 4;
                        if (i18 < i11) {
                            i21 = zzis.zzj(bArr, i18, zzirVar);
                            if (i12 == zzirVar.zza) {
                                zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(bArr, i21)));
                            }
                        }
                    }
                    return i18;
                }
                return i21;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i14 == 2) {
                    zzlb zzlbVar = (zzlb) zzkmVar;
                    int zzj4 = zzis.zzj(bArr, i21, zzirVar);
                    int i24 = zzirVar.zza + zzj4;
                    while (zzj4 < i24) {
                        zzj4 = zzis.zzm(bArr, zzj4, zzirVar);
                        zzlbVar.zzg(zzirVar.zzb);
                    }
                    if (zzj4 == i24) {
                        return zzj4;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 0) {
                    zzlb zzlbVar2 = (zzlb) zzkmVar;
                    int zzm = zzis.zzm(bArr, i21, zzirVar);
                    zzlbVar2.zzg(zzirVar.zzb);
                    while (zzm < i11) {
                        int zzj5 = zzis.zzj(bArr, zzm, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzm;
                        }
                        zzm = zzis.zzm(bArr, zzj5, zzirVar);
                        zzlbVar2.zzg(zzirVar.zzb);
                    }
                    return zzm;
                }
                return i21;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i14 == 2) {
                    return zzis.zzf(bArr, i21, zzkmVar, zzirVar);
                }
                if (i14 == 0) {
                    return zzis.zzl(i12, bArr, i10, i11, zzkmVar, zzirVar);
                }
                return i21;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i14 == 2) {
                    zzlb zzlbVar3 = (zzlb) zzkmVar;
                    int zzj6 = zzis.zzj(bArr, i21, zzirVar);
                    int i25 = zzirVar.zza + zzj6;
                    while (zzj6 < i25) {
                        zzlbVar3.zzg(zzis.zzp(bArr, zzj6));
                        zzj6 += 8;
                    }
                    if (zzj6 == i25) {
                        return zzj6;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 1) {
                    zzlb zzlbVar4 = (zzlb) zzkmVar;
                    zzlbVar4.zzg(zzis.zzp(bArr, i10));
                    while (true) {
                        i19 = i21 + 8;
                        if (i19 < i11) {
                            i21 = zzis.zzj(bArr, i19, zzirVar);
                            if (i12 == zzirVar.zza) {
                                zzlbVar4.zzg(zzis.zzp(bArr, i21));
                            }
                        }
                    }
                    return i19;
                }
                return i21;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i14 == 2) {
                    zzkg zzkgVar = (zzkg) zzkmVar;
                    int zzj7 = zzis.zzj(bArr, i21, zzirVar);
                    int i26 = zzirVar.zza + zzj7;
                    while (zzj7 < i26) {
                        zzkgVar.zzh(zzis.zzb(bArr, zzj7));
                        zzj7 += 4;
                    }
                    if (zzj7 == i26) {
                        return zzj7;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 5) {
                    zzkg zzkgVar2 = (zzkg) zzkmVar;
                    zzkgVar2.zzh(zzis.zzb(bArr, i10));
                    while (true) {
                        i20 = i21 + 4;
                        if (i20 < i11) {
                            i21 = zzis.zzj(bArr, i20, zzirVar);
                            if (i12 == zzirVar.zza) {
                                zzkgVar2.zzh(zzis.zzb(bArr, i21));
                            }
                        }
                    }
                    return i20;
                }
                return i21;
            case 25:
            case 42:
                if (i14 == 2) {
                    zzit zzitVar = (zzit) zzkmVar;
                    zzj = zzis.zzj(bArr, i21, zzirVar);
                    int i27 = zzirVar.zza + zzj;
                    while (zzj < i27) {
                        zzj = zzis.zzm(bArr, zzj, zzirVar);
                        zzitVar.zze(zzirVar.zzb != 0);
                    }
                    if (zzj != i27) {
                        throw zzkp.zzf();
                    }
                    return zzj;
                }
                if (i14 == 0) {
                    zzit zzitVar2 = (zzit) zzkmVar;
                    int zzm2 = zzis.zzm(bArr, i21, zzirVar);
                    zzitVar2.zze(zzirVar.zzb != 0);
                    while (zzm2 < i11) {
                        int zzj8 = zzis.zzj(bArr, zzm2, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzm2;
                        }
                        zzm2 = zzis.zzm(bArr, zzj8, zzirVar);
                        zzitVar2.zze(zzirVar.zzb != 0);
                    }
                    return zzm2;
                }
                return i21;
            case 26:
                if (i14 == 2) {
                    if ((j10 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                        i21 = zzis.zzj(bArr, i21, zzirVar);
                        int i28 = zzirVar.zza;
                        if (i28 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i28 == 0) {
                            zzkmVar.add("");
                        } else {
                            zzkmVar.add(new String(bArr, i21, i28, zzkn.zzb));
                            i21 += i28;
                        }
                        while (i21 < i11) {
                            int zzj9 = zzis.zzj(bArr, i21, zzirVar);
                            if (i12 == zzirVar.zza) {
                                i21 = zzis.zzj(bArr, zzj9, zzirVar);
                                int i29 = zzirVar.zza;
                                if (i29 < 0) {
                                    throw zzkp.zzd();
                                }
                                if (i29 == 0) {
                                    zzkmVar.add("");
                                } else {
                                    zzkmVar.add(new String(bArr, i21, i29, zzkn.zzb));
                                    i21 += i29;
                                }
                            }
                        }
                    } else {
                        i21 = zzis.zzj(bArr, i21, zzirVar);
                        int i30 = zzirVar.zza;
                        if (i30 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i30 == 0) {
                            zzkmVar.add("");
                        } else {
                            int i31 = i21 + i30;
                            if (!zznd.zzf(bArr, i21, i31)) {
                                throw zzkp.zzc();
                            }
                            zzkmVar.add(new String(bArr, i21, i30, zzkn.zzb));
                            i21 = i31;
                        }
                        while (i21 < i11) {
                            int zzj10 = zzis.zzj(bArr, i21, zzirVar);
                            if (i12 == zzirVar.zza) {
                                i21 = zzis.zzj(bArr, zzj10, zzirVar);
                                int i32 = zzirVar.zza;
                                if (i32 < 0) {
                                    throw zzkp.zzd();
                                }
                                if (i32 == 0) {
                                    zzkmVar.add("");
                                } else {
                                    int i33 = i21 + i32;
                                    if (!zznd.zzf(bArr, i21, i33)) {
                                        throw zzkp.zzc();
                                    }
                                    zzkmVar.add(new String(bArr, i21, i32, zzkn.zzb));
                                    i21 = i33;
                                }
                            }
                        }
                    }
                }
                return i21;
            case 27:
                if (i14 == 2) {
                    return zzis.zze(zzE(i15), i12, bArr, i10, i11, zzkmVar, zzirVar);
                }
                return i21;
            case 28:
                if (i14 == 2) {
                    int zzj11 = zzis.zzj(bArr, i21, zzirVar);
                    int i34 = zzirVar.zza;
                    if (i34 < 0) {
                        throw zzkp.zzd();
                    }
                    if (i34 > bArr.length - zzj11) {
                        throw zzkp.zzf();
                    }
                    if (i34 == 0) {
                        zzkmVar.add(zzje.zzb);
                    } else {
                        zzkmVar.add(zzje.zzl(bArr, zzj11, i34));
                        zzj11 += i34;
                    }
                    while (zzj11 < i11) {
                        int zzj12 = zzis.zzj(bArr, zzj11, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzj11;
                        }
                        zzj11 = zzis.zzj(bArr, zzj12, zzirVar);
                        int i35 = zzirVar.zza;
                        if (i35 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i35 > bArr.length - zzj11) {
                            throw zzkp.zzf();
                        }
                        if (i35 == 0) {
                            zzkmVar.add(zzje.zzb);
                        } else {
                            zzkmVar.add(zzje.zzl(bArr, zzj11, i35));
                            zzj11 += i35;
                        }
                    }
                    return zzj11;
                }
                return i21;
            case 30:
            case 44:
                if (i14 != 2) {
                    if (i14 == 0) {
                        zzj = zzis.zzl(i12, bArr, i10, i11, zzkmVar, zzirVar);
                    }
                    return i21;
                }
                zzj = zzis.zzf(bArr, i21, zzkmVar, zzirVar);
                zzlz.zzC(obj, i13, zzkmVar, zzD(i15), null, this.zzn);
                return zzj;
            case 33:
            case 47:
                if (i14 == 2) {
                    zzkg zzkgVar3 = (zzkg) zzkmVar;
                    int zzj13 = zzis.zzj(bArr, i21, zzirVar);
                    int i36 = zzirVar.zza + zzj13;
                    while (zzj13 < i36) {
                        zzj13 = zzis.zzj(bArr, zzj13, zzirVar);
                        zzkgVar3.zzh(zzji.zzb(zzirVar.zza));
                    }
                    if (zzj13 == i36) {
                        return zzj13;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 0) {
                    zzkg zzkgVar4 = (zzkg) zzkmVar;
                    int zzj14 = zzis.zzj(bArr, i21, zzirVar);
                    zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                    while (zzj14 < i11) {
                        int zzj15 = zzis.zzj(bArr, zzj14, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzj14;
                        }
                        zzj14 = zzis.zzj(bArr, zzj15, zzirVar);
                        zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                    }
                    return zzj14;
                }
                return i21;
            case 34:
            case 48:
                if (i14 == 2) {
                    zzlb zzlbVar5 = (zzlb) zzkmVar;
                    int zzj16 = zzis.zzj(bArr, i21, zzirVar);
                    int i37 = zzirVar.zza + zzj16;
                    while (zzj16 < i37) {
                        zzj16 = zzis.zzm(bArr, zzj16, zzirVar);
                        zzlbVar5.zzg(zzji.zzc(zzirVar.zzb));
                    }
                    if (zzj16 == i37) {
                        return zzj16;
                    }
                    throw zzkp.zzf();
                }
                if (i14 == 0) {
                    zzlb zzlbVar6 = (zzlb) zzkmVar;
                    int zzm3 = zzis.zzm(bArr, i21, zzirVar);
                    zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                    while (zzm3 < i11) {
                        int zzj17 = zzis.zzj(bArr, zzm3, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzm3;
                        }
                        zzm3 = zzis.zzm(bArr, zzj17, zzirVar);
                        zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                    }
                    return zzm3;
                }
                return i21;
            default:
                if (i14 == 3) {
                    zzlx zzE = zzE(i15);
                    int i38 = (i12 & (-8)) | 4;
                    int zzc = zzis.zzc(zzE, bArr, i10, i11, i38, zzirVar);
                    zzkmVar.add(zzirVar.zzc);
                    while (zzc < i11) {
                        int zzj18 = zzis.zzj(bArr, zzc, zzirVar);
                        if (i12 != zzirVar.zza) {
                            return zzc;
                        }
                        zzc = zzis.zzc(zzE, bArr, zzj18, i11, i38, zzirVar);
                        zzkmVar.add(zzirVar.zzc);
                    }
                    return zzc;
                }
                return i21;
        }
    }

    private final int zzw(int i10) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzz(i10, 0);
    }

    private final int zzx(int i10, int i11) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzz(i10, i11);
    }

    private final int zzy(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzz(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zzb(Object obj) {
        int i10;
        int zzc;
        int length = this.zzc.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int zzB = zzB(i12);
            int i13 = this.zzc[i12];
            long j10 = 1048575 & zzB;
            int i14 = 37;
            switch (zzA(zzB)) {
                case 0:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(Double.doubleToLongBits(zzmy.zza(obj, j10)));
                    i11 = i10 + zzc;
                    break;
                case 1:
                    i10 = i11 * 53;
                    zzc = Float.floatToIntBits(zzmy.zzb(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 2:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(zzmy.zzd(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 3:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(zzmy.zzd(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 4:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 5:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(zzmy.zzd(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 6:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 7:
                    i10 = i11 * 53;
                    zzc = zzkn.zza(zzmy.zzw(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 8:
                    i10 = i11 * 53;
                    zzc = ((String) zzmy.zzf(obj, j10)).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 9:
                    Object zzf = zzmy.zzf(obj, j10);
                    if (zzf != null) {
                        i14 = zzf.hashCode();
                    }
                    i11 = (i11 * 53) + i14;
                    break;
                case 10:
                    i10 = i11 * 53;
                    zzc = zzmy.zzf(obj, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 11:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 12:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 13:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 14:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(zzmy.zzd(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 15:
                    i10 = i11 * 53;
                    zzc = zzmy.zzc(obj, j10);
                    i11 = i10 + zzc;
                    break;
                case 16:
                    i10 = i11 * 53;
                    zzc = zzkn.zzc(zzmy.zzd(obj, j10));
                    i11 = i10 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzmy.zzf(obj, j10);
                    if (zzf2 != null) {
                        i14 = zzf2.hashCode();
                    }
                    i11 = (i11 * 53) + i14;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    zzc = zzmy.zzf(obj, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 50:
                    i10 = i11 * 53;
                    zzc = zzmy.zzf(obj, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 51:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(Double.doubleToLongBits(zzn(obj, j10)));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = Float.floatToIntBits(zzo(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(zzC(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(zzC(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(zzC(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zza(zzY(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = ((String) zzmy.zzf(obj, j10)).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzmy.zzf(obj, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzmy.zzf(obj, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(zzC(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzr(obj, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzkn.zzc(zzC(obj, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzX(obj, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzmy.zzf(obj, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i11 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0427, code lost:
    
        if (r6 == 1048575) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0429, code lost:
    
        r28.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x042f, code lost:
    
        r3 = r9.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0433, code lost:
    
        if (r3 >= r9.zzl) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0435, code lost:
    
        r4 = r9.zzj[r3];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r9.zzB(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0447, code lost:
    
        if (r5 != null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x044e, code lost:
    
        if (r9.zzD(r4) != null) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0453, code lost:
    
        r5 = (com.google.android.gms.internal.measurement.zzlg) r5;
        r0 = (com.google.android.gms.internal.measurement.zzlf) r9.zzF(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x045b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0450, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x045c, code lost:
    
        if (r7 != 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0460, code lost:
    
        if (r0 != r33) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0467, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkp.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x046e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x046a, code lost:
    
        if (r0 > r33) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x046c, code lost:
    
        if (r1 != r7) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0474, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkp.zze();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i10, int i11, int i12, zzir zzirVar) {
        Unsafe unsafe;
        int i13;
        Object obj2;
        zzlp<T> zzlpVar;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Object obj3;
        int i20;
        zzir zzirVar2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        zzlp<T> zzlpVar2 = this;
        Object obj4 = obj;
        byte[] bArr2 = bArr;
        int i32 = i11;
        int i33 = i12;
        zzir zzirVar3 = zzirVar;
        zzJ(obj);
        Unsafe unsafe2 = zzb;
        int i34 = i10;
        int i35 = 0;
        int i36 = -1;
        int i37 = 0;
        int i38 = 0;
        int i39 = 1048575;
        while (true) {
            if (i34 < i32) {
                int i40 = i34 + 1;
                byte b10 = bArr2[i34];
                if (b10 < 0) {
                    int zzk = zzis.zzk(b10, bArr2, i40, zzirVar3);
                    i14 = zzirVar3.zza;
                    i40 = zzk;
                } else {
                    i14 = b10;
                }
                int i41 = i14 >>> 3;
                int i42 = i14 & 7;
                int zzx = i41 > i36 ? zzlpVar2.zzx(i41, i37 / 3) : zzlpVar2.zzw(i41);
                if (zzx == -1) {
                    i15 = i41;
                    i16 = i40;
                    i17 = i14;
                    i18 = i38;
                    unsafe = unsafe2;
                    i13 = i33;
                    i19 = 0;
                } else {
                    int[] iArr = zzlpVar2.zzc;
                    int i43 = iArr[zzx + 1];
                    int zzA = zzA(i43);
                    int i44 = i40;
                    long j10 = i43 & 1048575;
                    if (zzA <= 17) {
                        int i45 = iArr[zzx + 2];
                        int i46 = 1 << (i45 >>> 20);
                        int i47 = i45 & 1048575;
                        if (i47 != i39) {
                            i21 = i14;
                            if (i39 != 1048575) {
                                unsafe2.putInt(obj4, i39, i38);
                            }
                            i22 = i47;
                            i18 = unsafe2.getInt(obj4, i47);
                        } else {
                            i21 = i14;
                            i18 = i38;
                            i22 = i39;
                        }
                        switch (zzA) {
                            case 0:
                                i23 = zzx;
                                i24 = i41;
                                i25 = i44;
                                if (i42 != 1) {
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    zzmy.zzo(obj4, j10, Double.longBitsToDouble(zzis.zzp(bArr2, i25)));
                                    i34 = i25 + 8;
                                    i38 = i18 | i46;
                                    i36 = i24;
                                    i37 = i23;
                                    i35 = i21;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 1:
                                i23 = zzx;
                                i24 = i41;
                                i25 = i44;
                                if (i42 != 5) {
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    zzmy.zzp(obj4, j10, Float.intBitsToFloat(zzis.zzb(bArr2, i25)));
                                    i34 = i25 + 4;
                                    i38 = i18 | i46;
                                    i36 = i24;
                                    i37 = i23;
                                    i35 = i21;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 2:
                            case 3:
                                i23 = zzx;
                                i24 = i41;
                                i25 = i44;
                                if (i42 != 0) {
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    int zzm = zzis.zzm(bArr2, i25, zzirVar3);
                                    unsafe2.putLong(obj, j10, zzirVar3.zzb);
                                    i38 = i18 | i46;
                                    i34 = zzm;
                                    i36 = i24;
                                    i37 = i23;
                                    i35 = i21;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 4:
                            case 11:
                                i23 = zzx;
                                i24 = i41;
                                i25 = i44;
                                if (i42 != 0) {
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = zzis.zzj(bArr2, i25, zzirVar3);
                                    unsafe2.putInt(obj4, j10, zzirVar3.zza);
                                    i38 = i18 | i46;
                                    i36 = i24;
                                    i37 = i23;
                                    i35 = i21;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 5:
                            case 14:
                                i23 = zzx;
                                int i48 = i21;
                                i24 = i41;
                                if (i42 != 1) {
                                    i21 = i48;
                                    i25 = i44;
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i21 = i48;
                                    i25 = i44;
                                    unsafe2.putLong(obj, j10, zzis.zzp(bArr2, i44));
                                    i34 = i25 + 8;
                                    i38 = i18 | i46;
                                    i36 = i24;
                                    i37 = i23;
                                    i35 = i21;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 6:
                            case 13:
                                i23 = zzx;
                                i26 = i21;
                                i24 = i41;
                                i27 = i44;
                                if (i42 != 5) {
                                    i17 = i26;
                                    i25 = i27;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    unsafe2.putInt(obj4, j10, zzis.zzb(bArr2, i27));
                                    i34 = i27 + 4;
                                    i38 = i18 | i46;
                                    i35 = i26;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 7:
                                i23 = zzx;
                                i26 = i21;
                                i24 = i41;
                                i27 = i44;
                                if (i42 != 0) {
                                    i17 = i26;
                                    i25 = i27;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = zzis.zzm(bArr2, i27, zzirVar3);
                                    zzmy.zzm(obj4, j10, zzirVar3.zzb != 0);
                                    i38 = i18 | i46;
                                    i35 = i26;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 8:
                                i23 = zzx;
                                i26 = i21;
                                i24 = i41;
                                i27 = i44;
                                if (i42 != 2) {
                                    i17 = i26;
                                    i25 = i27;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = (536870912 & i43) == 0 ? zzis.zzg(bArr2, i27, zzirVar3) : zzis.zzh(bArr2, i27, zzirVar3);
                                    unsafe2.putObject(obj4, j10, zzirVar3.zzc);
                                    i38 = i18 | i46;
                                    i35 = i26;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 9:
                                i23 = zzx;
                                i28 = i21;
                                i24 = i41;
                                i29 = i44;
                                if (i42 != 2) {
                                    i25 = i29;
                                    i17 = i28;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    Object zzG = zzlpVar2.zzG(obj4, i23);
                                    i34 = zzis.zzo(zzG, zzlpVar2.zzE(i23), bArr, i29, i11, zzirVar);
                                    zzlpVar2.zzO(obj4, i23, zzG);
                                    i38 = i18 | i46;
                                    i35 = i28;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 10:
                                i23 = zzx;
                                i28 = i21;
                                i24 = i41;
                                i29 = i44;
                                if (i42 != 2) {
                                    i25 = i29;
                                    i17 = i28;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = zzis.zza(bArr2, i29, zzirVar3);
                                    unsafe2.putObject(obj4, j10, zzirVar3.zzc);
                                    i38 = i18 | i46;
                                    i35 = i28;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 12:
                                i23 = zzx;
                                i28 = i21;
                                i24 = i41;
                                i29 = i44;
                                if (i42 != 0) {
                                    i25 = i29;
                                    i17 = i28;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = zzis.zzj(bArr2, i29, zzirVar3);
                                    int i49 = zzirVar3.zza;
                                    zzkj zzD = zzlpVar2.zzD(i23);
                                    if (zzD == null || zzD.zza(i49)) {
                                        unsafe2.putInt(obj4, j10, i49);
                                        i38 = i18 | i46;
                                        i35 = i28;
                                        i36 = i24;
                                        i37 = i23;
                                        i39 = i22;
                                        i32 = i11;
                                        i33 = i12;
                                    } else {
                                        zzd(obj).zzj(i28, Long.valueOf(i49));
                                        i35 = i28;
                                        i36 = i24;
                                        i37 = i23;
                                        i38 = i18;
                                        i39 = i22;
                                        i32 = i11;
                                        i33 = i12;
                                    }
                                }
                                break;
                            case 15:
                                i23 = zzx;
                                i28 = i21;
                                i24 = i41;
                                i29 = i44;
                                if (i42 != 0) {
                                    i25 = i29;
                                    i17 = i28;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    i34 = zzis.zzj(bArr2, i29, zzirVar3);
                                    unsafe2.putInt(obj4, j10, zzji.zzb(zzirVar3.zza));
                                    i38 = i18 | i46;
                                    i35 = i28;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            case 16:
                                if (i42 != 0) {
                                    i23 = zzx;
                                    i24 = i41;
                                    i17 = i21;
                                    i25 = i44;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    int zzm2 = zzis.zzm(bArr2, i44, zzirVar3);
                                    i24 = i41;
                                    i23 = zzx;
                                    i28 = i21;
                                    unsafe2.putLong(obj, j10, zzji.zzc(zzirVar3.zzb));
                                    i38 = i18 | i46;
                                    i34 = zzm2;
                                    i35 = i28;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                            default:
                                i23 = zzx;
                                i24 = i41;
                                i25 = i44;
                                if (i42 != 3) {
                                    i17 = i21;
                                    i13 = i12;
                                    i16 = i25;
                                    unsafe = unsafe2;
                                    i15 = i24;
                                    i19 = i23;
                                    i39 = i22;
                                    break;
                                } else {
                                    Object zzG2 = zzlpVar2.zzG(obj4, i23);
                                    i34 = zzis.zzn(zzG2, zzlpVar2.zzE(i23), bArr, i25, i11, (i24 << 3) | 4, zzirVar);
                                    zzlpVar2.zzO(obj4, i23, zzG2);
                                    i38 = i18 | i46;
                                    i35 = i21;
                                    i36 = i24;
                                    i37 = i23;
                                    i39 = i22;
                                    i32 = i11;
                                    i33 = i12;
                                }
                        }
                    } else {
                        i23 = zzx;
                        int i50 = i14;
                        i22 = i39;
                        if (zzA != 27) {
                            i18 = i38;
                            if (zzA <= 49) {
                                i15 = i41;
                                i30 = i50;
                                unsafe = unsafe2;
                                i19 = i23;
                                i34 = zzv(obj, bArr, i44, i11, i50, i15, i42, i23, i43, zzA, j10, zzirVar);
                                if (i34 != i44) {
                                    zzlpVar2 = this;
                                    obj4 = obj;
                                    bArr2 = bArr;
                                    i36 = i15;
                                    i32 = i11;
                                    i33 = i12;
                                    zzirVar3 = zzirVar;
                                    i35 = i30;
                                    i37 = i19;
                                    i38 = i18;
                                    i39 = i22;
                                    unsafe2 = unsafe;
                                } else {
                                    i13 = i12;
                                    i16 = i34;
                                    i17 = i30;
                                }
                            } else {
                                i30 = i50;
                                i15 = i41;
                                i31 = i44;
                                unsafe = unsafe2;
                                i19 = i23;
                                if (zzA != 50) {
                                    i34 = zzt(obj, bArr, i31, i11, i30, i15, i42, i43, zzA, j10, i19, zzirVar);
                                    if (i34 != i31) {
                                        zzlpVar2 = this;
                                        obj4 = obj;
                                        bArr2 = bArr;
                                        i36 = i15;
                                        i32 = i11;
                                        i33 = i12;
                                        zzirVar3 = zzirVar;
                                        i35 = i30;
                                        i37 = i19;
                                        i38 = i18;
                                        i39 = i22;
                                        unsafe2 = unsafe;
                                    } else {
                                        i13 = i12;
                                        i16 = i34;
                                        i17 = i30;
                                    }
                                } else if (i42 == 2) {
                                    i34 = zzs(obj, bArr, i31, i11, i19, j10, zzirVar);
                                    if (i34 != i31) {
                                        zzlpVar2 = this;
                                        obj4 = obj;
                                        bArr2 = bArr;
                                        i36 = i15;
                                        i32 = i11;
                                        i33 = i12;
                                        zzirVar3 = zzirVar;
                                        i35 = i30;
                                        i37 = i19;
                                        i38 = i18;
                                        i39 = i22;
                                        unsafe2 = unsafe;
                                    } else {
                                        i13 = i12;
                                        i16 = i34;
                                        i17 = i30;
                                    }
                                }
                            }
                            i39 = i22;
                        } else if (i42 == 2) {
                            zzkm zzkmVar = (zzkm) unsafe2.getObject(obj4, j10);
                            if (!zzkmVar.zzc()) {
                                int size = zzkmVar.size();
                                zzkmVar = zzkmVar.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj4, j10, zzkmVar);
                            }
                            i18 = i38;
                            i34 = zzis.zze(zzlpVar2.zzE(i23), i50, bArr, i44, i11, zzkmVar, zzirVar);
                            i36 = i41;
                            i35 = i50;
                            i37 = i23;
                            i38 = i18;
                            i39 = i22;
                            i32 = i11;
                            i33 = i12;
                        } else {
                            i18 = i38;
                            i15 = i41;
                            i30 = i50;
                            i31 = i44;
                            unsafe = unsafe2;
                            i19 = i23;
                        }
                        i13 = i12;
                        i16 = i31;
                        i17 = i30;
                        i39 = i22;
                    }
                }
                if (i17 != i13 || i13 == 0) {
                    if (this.zzh) {
                        zzirVar2 = zzirVar;
                        zzjr zzjrVar = zzirVar2.zzd;
                        if (zzjrVar != zzjr.zza) {
                            i20 = i15;
                            if (zzjrVar.zzb(this.zzg, i20) != null) {
                                throw null;
                            }
                            i34 = zzis.zzi(i17, bArr, i16, i11, zzd(obj), zzirVar);
                            obj3 = obj;
                            i32 = i11;
                            i35 = i17;
                            zzlpVar2 = this;
                            zzirVar3 = zzirVar2;
                            i36 = i20;
                            obj4 = obj3;
                            i37 = i19;
                            i38 = i18;
                            unsafe2 = unsafe;
                            bArr2 = bArr;
                            i33 = i13;
                        } else {
                            obj3 = obj;
                            i20 = i15;
                        }
                    } else {
                        obj3 = obj;
                        i20 = i15;
                        zzirVar2 = zzirVar;
                    }
                    i34 = zzis.zzi(i17, bArr, i16, i11, zzd(obj), zzirVar);
                    i32 = i11;
                    i35 = i17;
                    zzlpVar2 = this;
                    zzirVar3 = zzirVar2;
                    i36 = i20;
                    obj4 = obj3;
                    i37 = i19;
                    i38 = i18;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i33 = i13;
                } else {
                    zzlpVar = this;
                    obj2 = obj;
                    i34 = i16;
                    i35 = i17;
                    i38 = i18;
                }
            } else {
                unsafe = unsafe2;
                i13 = i33;
                obj2 = obj4;
                zzlpVar = zzlpVar2;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final Object zze() {
        return ((zzkf) this.zzg).zzbA();
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzf(Object obj) {
        if (zzW(obj)) {
            if (obj instanceof zzkf) {
                zzkf zzkfVar = (zzkf) obj;
                zzkfVar.zzbM(Integer.MAX_VALUE);
                zzkfVar.zzb = 0;
                zzkfVar.zzbK();
            }
            int length = this.zzc.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int zzB = zzB(i10);
                long j10 = 1048575 & zzB;
                int zzA = zzA(zzB);
                if (zzA != 9) {
                    switch (zzA) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.zzm.zza(obj, j10);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j10);
                            if (object != null) {
                                ((zzlg) object).zzc();
                                unsafe.putObject(obj, j10, object);
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (zzT(obj, i10)) {
                    zzE(i10).zzf(zzb.getObject(obj, j10));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzg(Object obj, Object obj2) {
        zzJ(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzB = zzB(i10);
            long j10 = 1048575 & zzB;
            int i11 = this.zzc[i10];
            switch (zzA(zzB)) {
                case 0:
                    if (zzT(obj2, i10)) {
                        zzmy.zzo(obj, j10, zzmy.zza(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzT(obj2, i10)) {
                        zzmy.zzp(obj, j10, zzmy.zzb(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzT(obj2, i10)) {
                        zzmy.zzr(obj, j10, zzmy.zzd(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzT(obj2, i10)) {
                        zzmy.zzr(obj, j10, zzmy.zzd(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzT(obj2, i10)) {
                        zzmy.zzr(obj, j10, zzmy.zzd(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzT(obj2, i10)) {
                        zzmy.zzm(obj, j10, zzmy.zzw(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzT(obj2, i10)) {
                        zzmy.zzs(obj, j10, zzmy.zzf(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzK(obj, obj2, i10);
                    break;
                case 10:
                    if (zzT(obj2, i10)) {
                        zzmy.zzs(obj, j10, zzmy.zzf(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzT(obj2, i10)) {
                        zzmy.zzr(obj, j10, zzmy.zzd(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzT(obj2, i10)) {
                        zzmy.zzq(obj, j10, zzmy.zzc(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzT(obj2, i10)) {
                        zzmy.zzr(obj, j10, zzmy.zzd(obj2, j10));
                        zzM(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzK(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j10);
                    break;
                case 50:
                    zzlz.zzaa(this.zzq, obj, obj2, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzX(obj2, i11, i10)) {
                        zzmy.zzs(obj, j10, zzmy.zzf(obj2, j10));
                        zzN(obj, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzL(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzX(obj2, i11, i10)) {
                        zzmy.zzs(obj, j10, zzmy.zzf(obj2, j10));
                        zzN(obj, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzL(obj, obj2, i10);
                    break;
            }
        }
        zzlz.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzlz.zzE(this.zzo, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzh(Object obj, byte[] bArr, int i10, int i11, zzir zzirVar) {
        if (this.zzi) {
            zzu(obj, bArr, i10, i11, zzirVar);
        } else {
            zzc(obj, bArr, i10, i11, 0, zzirVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzi(Object obj, zzng zzngVar) {
        if (!this.zzi) {
            zzQ(obj, zzngVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzB = zzB(i10);
            int i11 = this.zzc[i10];
            switch (zzA(zzB)) {
                case 0:
                    if (zzT(obj, i10)) {
                        zzngVar.zzf(i11, zzmy.zza(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzT(obj, i10)) {
                        zzngVar.zzo(i11, zzmy.zzb(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzT(obj, i10)) {
                        zzngVar.zzt(i11, zzmy.zzd(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzT(obj, i10)) {
                        zzngVar.zzJ(i11, zzmy.zzd(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzT(obj, i10)) {
                        zzngVar.zzr(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzT(obj, i10)) {
                        zzngVar.zzm(i11, zzmy.zzd(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzT(obj, i10)) {
                        zzngVar.zzk(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzT(obj, i10)) {
                        zzngVar.zzb(i11, zzmy.zzw(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzT(obj, i10)) {
                        zzZ(i11, zzmy.zzf(obj, zzB & 1048575), zzngVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzT(obj, i10)) {
                        zzngVar.zzv(i11, zzmy.zzf(obj, zzB & 1048575), zzE(i10));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzT(obj, i10)) {
                        zzngVar.zzd(i11, (zzje) zzmy.zzf(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzT(obj, i10)) {
                        zzngVar.zzH(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzT(obj, i10)) {
                        zzngVar.zzi(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzT(obj, i10)) {
                        zzngVar.zzw(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzT(obj, i10)) {
                        zzngVar.zzy(i11, zzmy.zzd(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzT(obj, i10)) {
                        zzngVar.zzA(i11, zzmy.zzc(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzT(obj, i10)) {
                        zzngVar.zzC(i11, zzmy.zzd(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzT(obj, i10)) {
                        zzngVar.zzq(i11, zzmy.zzf(obj, zzB & 1048575), zzE(i10));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzlz.zzJ(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 19:
                    zzlz.zzN(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 20:
                    zzlz.zzQ(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 21:
                    zzlz.zzY(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 22:
                    zzlz.zzP(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 23:
                    zzlz.zzM(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 24:
                    zzlz.zzL(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 25:
                    zzlz.zzH(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 26:
                    zzlz.zzW(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar);
                    break;
                case 27:
                    zzlz.zzR(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, zzE(i10));
                    break;
                case 28:
                    zzlz.zzI(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar);
                    break;
                case 29:
                    zzlz.zzX(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 30:
                    zzlz.zzK(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 31:
                    zzlz.zzS(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 32:
                    zzlz.zzT(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 33:
                    zzlz.zzU(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 34:
                    zzlz.zzV(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, false);
                    break;
                case 35:
                    zzlz.zzJ(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 36:
                    zzlz.zzN(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 37:
                    zzlz.zzQ(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 38:
                    zzlz.zzY(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 39:
                    zzlz.zzP(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 40:
                    zzlz.zzM(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 41:
                    zzlz.zzL(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 42:
                    zzlz.zzH(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 43:
                    zzlz.zzX(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 44:
                    zzlz.zzK(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 45:
                    zzlz.zzS(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 46:
                    zzlz.zzT(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 47:
                    zzlz.zzU(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 48:
                    zzlz.zzV(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, true);
                    break;
                case 49:
                    zzlz.zzO(i11, (List) zzmy.zzf(obj, zzB & 1048575), zzngVar, zzE(i10));
                    break;
                case 50:
                    zzR(zzngVar, i11, zzmy.zzf(obj, zzB & 1048575), i10);
                    break;
                case 51:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzf(i11, zzn(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzo(i11, zzo(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzt(i11, zzC(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzJ(i11, zzC(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzr(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzm(i11, zzC(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzk(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzb(i11, zzY(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzX(obj, i11, i10)) {
                        zzZ(i11, zzmy.zzf(obj, zzB & 1048575), zzngVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzv(i11, zzmy.zzf(obj, zzB & 1048575), zzE(i10));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzd(i11, (zzje) zzmy.zzf(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzH(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzi(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzw(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzy(i11, zzC(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzA(i11, zzr(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzC(i11, zzC(obj, zzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzX(obj, i11, i10)) {
                        zzngVar.zzq(i11, zzmy.zzf(obj, zzB & 1048575), zzE(i10));
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmo zzmoVar = this.zzn;
        zzmoVar.zzi(zzmoVar.zzd(obj), zzngVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzZ;
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzB = zzB(i10);
            long j10 = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (zzS(obj, obj2, i10) && Double.doubleToLongBits(zzmy.zza(obj, j10)) == Double.doubleToLongBits(zzmy.zza(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzS(obj, obj2, i10) && Float.floatToIntBits(zzmy.zzb(obj, j10)) == Float.floatToIntBits(zzmy.zzb(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzS(obj, obj2, i10) && zzmy.zzd(obj, j10) == zzmy.zzd(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzS(obj, obj2, i10) && zzmy.zzd(obj, j10) == zzmy.zzd(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzS(obj, obj2, i10) && zzmy.zzd(obj, j10) == zzmy.zzd(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzS(obj, obj2, i10) && zzmy.zzw(obj, j10) == zzmy.zzw(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzS(obj, obj2, i10) && zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzS(obj, obj2, i10) && zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzS(obj, obj2, i10) && zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzS(obj, obj2, i10) && zzmy.zzd(obj, j10) == zzmy.zzd(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzS(obj, obj2, i10) && zzmy.zzc(obj, j10) == zzmy.zzc(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzS(obj, obj2, i10) && zzmy.zzd(obj, j10) == zzmy.zzd(obj2, j10)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzS(obj, obj2, i10) && zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzZ = zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10));
                    break;
                case 50:
                    zzZ = zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = zzy(i10) & 1048575;
                    if (zzmy.zzc(obj, zzy) == zzmy.zzc(obj2, zzy) && zzlz.zzZ(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzZ) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzk(Object obj) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzk) {
            int i15 = this.zzj[i14];
            int i16 = this.zzc[i15];
            int zzB = zzB(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(obj, i18);
                }
                i11 = i13;
                i10 = i18;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if ((268435456 & zzB) != 0 && !zzU(obj, i15, i10, i11, i19)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzX(obj, i16, i15) && !zzV(obj, zzB, zzE(i15))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzlg) zzmy.zzf(obj, zzB & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzmy.zzf(obj, zzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzlx zzE = zzE(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzE.zzk(list.get(i20))) {
                            return false;
                        }
                    }
                }
            } else if (zzU(obj, i15, i10, i11, i19) && !zzV(obj, zzB, zzE(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }
}
