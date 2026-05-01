package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzqh<T> implements zzqp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzrn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzqe zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzps zzk;
    private final zzrd<?, ?> zzl;
    private final zzoo<?> zzm;
    private final zzqj zzn;
    private final zzpz zzo;

    /* JADX WARN: Multi-variable type inference failed */
    private zzqh(int[] iArr, int[] iArr2, Object[] objArr, int i10, int i11, zzqe zzqeVar, boolean z10, boolean z11, int[] iArr3, int i12, int i13, zzqj zzqjVar, zzps zzpsVar, zzrd<?, ?> zzrdVar, zzoo<?> zzooVar, zzpz zzpzVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zzg = zzqeVar;
        boolean z12 = false;
        if (zzrdVar != 0 && zzrdVar.zzc((zzqe) i11)) {
            z12 = true;
        }
        this.zzf = z12;
        this.zzh = z11;
        this.zzi = iArr3;
        this.zzj = i12;
        this.zzn = i13;
        this.zzk = zzqjVar;
        this.zzl = zzpsVar;
        this.zzm = zzrdVar;
        this.zze = i11;
        this.zzo = zzooVar;
    }

    private final boolean zzA(T t10, int i10) {
        int zzo = zzo(i10);
        long j10 = zzo & 1048575;
        if (j10 != 1048575) {
            return (zzrn.zzc(t10, j10) & (1 << (zzo >>> 20))) != 0;
        }
        int zzq = zzq(i10);
        long j11 = zzq & 1048575;
        switch (zzp(zzq)) {
            case 0:
                return Double.doubleToRawLongBits(zzrn.zza(t10, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzrn.zzb(t10, j11)) != 0;
            case 2:
                return zzrn.zzd(t10, j11) != 0;
            case 3:
                return zzrn.zzd(t10, j11) != 0;
            case 4:
                return zzrn.zzc(t10, j11) != 0;
            case 5:
                return zzrn.zzd(t10, j11) != 0;
            case 6:
                return zzrn.zzc(t10, j11) != 0;
            case 7:
                return zzrn.zzw(t10, j11);
            case 8:
                Object zzf = zzrn.zzf(t10, j11);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzoe) {
                    return !zzoe.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzrn.zzf(t10, j11) != null;
            case 10:
                return !zzoe.zzb.equals(zzrn.zzf(t10, j11));
            case 11:
                return zzrn.zzc(t10, j11) != 0;
            case 12:
                return zzrn.zzc(t10, j11) != 0;
            case 13:
                return zzrn.zzc(t10, j11) != 0;
            case 14:
                return zzrn.zzd(t10, j11) != 0;
            case 15:
                return zzrn.zzc(t10, j11) != 0;
            case 16:
                return zzrn.zzd(t10, j11) != 0;
            case 17:
                return zzrn.zzf(t10, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzB(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzA(t10, i10) : (i12 & i13) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzC(Object obj, int i10, zzqp zzqpVar) {
        return zzqpVar.zzf(zzrn.zzf(obj, i10 & 1048575));
    }

    private final boolean zzD(T t10, int i10, int i11) {
        return zzrn.zzc(t10, (long) (zzo(i11) & 1048575)) == i10;
    }

    private static <T> boolean zzE(T t10, long j10) {
        return ((Boolean) zzrn.zzf(t10, j10)).booleanValue();
    }

    private final void zzF(T t10, zzom zzomVar) {
        int i10;
        if (this.zzf) {
            this.zzm.zza(t10);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        while (i12 < length) {
            int zzq = zzq(i12);
            int i15 = this.zzc[i12];
            int zzp = zzp(zzq);
            if (zzp <= 17) {
                int i16 = this.zzc[i12 + 2];
                int i17 = i16 & i11;
                if (i17 != i14) {
                    i13 = unsafe.getInt(t10, i17);
                    i14 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = zzq & i11;
            switch (zzp) {
                case 0:
                    if ((i13 & i10) == 0) {
                        break;
                    } else {
                        zzomVar.zzf(i15, zzrn.zza(t10, j10));
                        continue;
                    }
                case 1:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzn(i15, zzrn.zzb(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzs(i15, unsafe.getLong(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzH(i15, unsafe.getLong(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzq(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzl(i15, unsafe.getLong(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzj(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzb(i15, zzrn.zzw(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i13 & i10) != 0) {
                        zzH(i15, unsafe.getObject(t10, j10), zzomVar);
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzu(i15, unsafe.getObject(t10, j10), zzs(i12));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzd(i15, (zzoe) unsafe.getObject(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzF(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzh(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzv(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzx(i15, unsafe.getLong(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzz(i15, unsafe.getInt(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzB(i15, unsafe.getLong(t10, j10));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i13 & i10) != 0) {
                        zzomVar.zzp(i15, unsafe.getObject(t10, j10), zzs(i12));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzqr.zzJ(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 19:
                    zzqr.zzN(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 20:
                    zzqr.zzQ(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 21:
                    zzqr.zzY(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 22:
                    zzqr.zzP(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 23:
                    zzqr.zzM(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 24:
                    zzqr.zzL(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 25:
                    zzqr.zzH(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    continue;
                case 26:
                    zzqr.zzW(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar);
                    break;
                case 27:
                    zzqr.zzR(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, zzs(i12));
                    break;
                case 28:
                    zzqr.zzI(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar);
                    break;
                case 29:
                    zzqr.zzX(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 30:
                    zzqr.zzK(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 31:
                    zzqr.zzS(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 32:
                    zzqr.zzT(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 33:
                    zzqr.zzU(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 34:
                    zzqr.zzV(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, false);
                    break;
                case 35:
                    zzqr.zzJ(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 36:
                    zzqr.zzN(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 37:
                    zzqr.zzQ(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 38:
                    zzqr.zzY(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 39:
                    zzqr.zzP(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 40:
                    zzqr.zzM(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 41:
                    zzqr.zzL(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 42:
                    zzqr.zzH(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 43:
                    zzqr.zzX(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 44:
                    zzqr.zzK(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 45:
                    zzqr.zzS(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 46:
                    zzqr.zzT(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 47:
                    zzqr.zzU(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 48:
                    zzqr.zzV(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, true);
                    break;
                case 49:
                    zzqr.zzO(this.zzc[i12], (List) unsafe.getObject(t10, j10), zzomVar, zzs(i12));
                    break;
                case 50:
                    zzG(zzomVar, i15, unsafe.getObject(t10, j10), i12);
                    break;
                case 51:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzf(i15, zzj(t10, j10));
                        break;
                    }
                    break;
                case 52:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzn(i15, zzk(t10, j10));
                        break;
                    }
                    break;
                case 53:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzs(i15, zzr(t10, j10));
                        break;
                    }
                    break;
                case 54:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzH(i15, zzr(t10, j10));
                        break;
                    }
                    break;
                case 55:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzq(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 56:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzl(i15, zzr(t10, j10));
                        break;
                    }
                    break;
                case 57:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzj(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 58:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzb(i15, zzE(t10, j10));
                        break;
                    }
                    break;
                case 59:
                    if (zzD(t10, i15, i12)) {
                        zzH(i15, unsafe.getObject(t10, j10), zzomVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzu(i15, unsafe.getObject(t10, j10), zzs(i12));
                        break;
                    }
                    break;
                case 61:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzd(i15, (zzoe) unsafe.getObject(t10, j10));
                        break;
                    }
                    break;
                case 62:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzF(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 63:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzh(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 64:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzv(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 65:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzx(i15, zzr(t10, j10));
                        break;
                    }
                    break;
                case 66:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzz(i15, zzn(t10, j10));
                        break;
                    }
                    break;
                case 67:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzB(i15, zzr(t10, j10));
                        break;
                    }
                    break;
                case 68:
                    if (zzD(t10, i15, i12)) {
                        zzomVar.zzp(i15, unsafe.getObject(t10, j10), zzs(i12));
                        break;
                    }
                    break;
            }
            i12 += 3;
            i11 = 1048575;
        }
        zzrd<?, ?> zzrdVar = this.zzl;
        zzrdVar.zzg(zzrdVar.zzc(t10), zzomVar);
    }

    private final <K, V> void zzG(zzom zzomVar, int i10, Object obj, int i11) {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzH(int i10, Object obj, zzom zzomVar) {
        if (obj instanceof String) {
            zzomVar.zzD(i10, (String) obj);
        } else {
            zzomVar.zzd(i10, (zzoe) obj);
        }
    }

    public static <T> zzqh<T> zzg(Class<T> cls, zzqb zzqbVar, zzqj zzqjVar, zzps zzpsVar, zzrd<?, ?> zzrdVar, zzoo<?> zzooVar, zzpz zzpzVar) {
        if (zzqbVar instanceof zzqo) {
            return zzh((zzqo) zzqbVar, zzqjVar, zzpsVar, zzrdVar, zzooVar, zzpzVar);
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
    public static <T> zzqh<T> zzh(zzqo zzqoVar, zzqj zzqjVar, zzps zzpsVar, zzrd<?, ?> zzrdVar, zzoo<?> zzooVar, zzpz zzpzVar) {
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
        Field zzu;
        char charAt12;
        int i33;
        int i34;
        int i35;
        Object obj;
        Field zzu2;
        Object obj2;
        Field zzu3;
        int i36;
        char charAt13;
        int i37;
        char charAt14;
        int i38;
        char charAt15;
        int i39;
        char charAt16;
        boolean z10 = zzqoVar.zzc() == 2;
        String zzd = zzqoVar.zzd();
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
        Object[] zze = zzqoVar.zze();
        Class<?> cls = zzqoVar.zza().getClass();
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
                        zzu2 = zzu(cls, (String) obj);
                        zze[i91] = zzu2;
                    } else {
                        zzu2 = (Field) obj;
                    }
                    iArr2 = iArr3;
                    i26 = charAt;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzu2);
                    int i92 = i91 + 1;
                    obj2 = zze[i92];
                    if (obj2 instanceof Field) {
                        zzu3 = zzu(cls, (String) obj2);
                        zze[i92] = zzu3;
                    } else {
                        zzu3 = (Field) obj2;
                    }
                    str = zzd;
                    i29 = i12;
                    i32 = (int) unsafe.objectFieldOffset(zzu3);
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
                int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zzu2);
                int i922 = i912 + 1;
                obj2 = zze[i922];
                if (obj2 instanceof Field) {
                }
                str = zzd;
                i29 = i12;
                i32 = (int) unsafe.objectFieldOffset(zzu3);
                objArr = objArr2;
                objectFieldOffset = objectFieldOffset22;
                i31 = 0;
            } else {
                iArr2 = iArr3;
                i26 = charAt;
                i27 = i13;
                int i93 = i11 + 1;
                Field zzu4 = zzu(cls, (String) zze[i11]);
                if (i82 == 9 || i82 == 17) {
                    int i94 = i72 / 3;
                    objArr2[i94 + i94 + 1] = zzu4.getType();
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
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzu4);
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
                                    zzu = (Field) obj3;
                                } else {
                                    zzu = zzu(cls, (String) obj3);
                                    zze[i104] = zzu;
                                }
                                i29 = i12;
                                i32 = (int) unsafe.objectFieldOffset(zzu);
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzu4);
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
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzu4);
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
        return new zzqh<>(iArr3, objArr2, charAt, i13, zzqoVar.zza(), z10, false, iArr, charAt3, i69, zzqjVar, zzpsVar, zzrdVar, zzooVar, zzpzVar, null);
    }

    private static <T> double zzj(T t10, long j10) {
        return ((Double) zzrn.zzf(t10, j10)).doubleValue();
    }

    private static <T> float zzk(T t10, long j10) {
        return ((Float) zzrn.zzf(t10, j10)).floatValue();
    }

    private final int zzl(T t10) {
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
        int zzo;
        int zzz;
        int zzA8;
        int i11;
        Unsafe unsafe = zzb;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        for (int i15 = 0; i15 < this.zzc.length; i15 += 3) {
            int zzq = zzq(i15);
            int i16 = this.zzc[i15];
            int zzp = zzp(zzq);
            if (zzp <= 17) {
                int i17 = this.zzc[i15 + 2];
                int i18 = i17 & 1048575;
                i10 = 1 << (i17 >>> 20);
                if (i18 != i14) {
                    i13 = unsafe.getInt(t10, i18);
                    i14 = i18;
                }
            } else {
                i10 = 0;
            }
            long j10 = zzq & 1048575;
            switch (zzp) {
                case 0:
                    if ((i13 & i10) != 0) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i13 & i10) != 0) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i13 & i10) != 0) {
                        long j11 = unsafe.getLong(t10, j10);
                        zzA3 = zzol.zzA(i16 << 3);
                        zzB = zzol.zzB(j11);
                        zzo = zzA3 + zzB;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i13 & i10) != 0) {
                        long j12 = unsafe.getLong(t10, j10);
                        zzA3 = zzol.zzA(i16 << 3);
                        zzB = zzol.zzB(j12);
                        zzo = zzA3 + zzB;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i13 & i10) != 0) {
                        int i19 = unsafe.getInt(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzv(i19);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i10) != 0) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i13 & i10) != 0) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i13 & i10) != 0) {
                        zzA5 = zzol.zzA(i16 << 3);
                        zzo = zzA5 + 1;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i13 & i10) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t10, j10);
                        if (object instanceof zzoe) {
                            zzA6 = zzol.zzA(i16 << 3);
                            zzd = ((zzoe) object).zzd();
                            zzA7 = zzol.zzA(zzd);
                            i11 = zzA6 + zzA7 + zzd;
                            i12 += i11;
                            break;
                        } else {
                            zzA4 = zzol.zzA(i16 << 3);
                            zzv = zzol.zzy((String) object);
                            i11 = zzA4 + zzv;
                            i12 += i11;
                        }
                    }
                case 9:
                    if ((i13 & i10) != 0) {
                        zzo = zzqr.zzo(i16, unsafe.getObject(t10, j10), zzs(i15));
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i13 & i10) != 0) {
                        zzoe zzoeVar = (zzoe) unsafe.getObject(t10, j10);
                        zzA6 = zzol.zzA(i16 << 3);
                        zzd = zzoeVar.zzd();
                        zzA7 = zzol.zzA(zzd);
                        i11 = zzA6 + zzA7 + zzd;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i13 & i10) != 0) {
                        int i20 = unsafe.getInt(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzA(i20);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i13 & i10) != 0) {
                        int i21 = unsafe.getInt(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzv(i21);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i13 & i10) != 0) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i13 & i10) != 0) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i13 & i10) != 0) {
                        int i22 = unsafe.getInt(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzA((i22 >> 31) ^ (i22 + i22));
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i13 & i10) != 0) {
                        long j13 = unsafe.getLong(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzB((j13 >> 63) ^ (j13 + j13));
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i13 & i10) != 0) {
                        zzo = zzol.zzu(i16, (zzqe) unsafe.getObject(t10, j10), zzs(i15));
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzqr.zzh(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 19:
                    zzo = zzqr.zzf(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 20:
                    zzo = zzqr.zzm(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 21:
                    zzo = zzqr.zzx(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 22:
                    zzo = zzqr.zzk(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 23:
                    zzo = zzqr.zzh(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 24:
                    zzo = zzqr.zzf(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 25:
                    zzo = zzqr.zza(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 26:
                    zzo = zzqr.zzu(i16, (List) unsafe.getObject(t10, j10));
                    i12 += zzo;
                    break;
                case 27:
                    zzo = zzqr.zzp(i16, (List) unsafe.getObject(t10, j10), zzs(i15));
                    i12 += zzo;
                    break;
                case 28:
                    zzo = zzqr.zzc(i16, (List) unsafe.getObject(t10, j10));
                    i12 += zzo;
                    break;
                case 29:
                    zzo = zzqr.zzv(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 30:
                    zzo = zzqr.zzd(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 31:
                    zzo = zzqr.zzf(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 32:
                    zzo = zzqr.zzh(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 33:
                    zzo = zzqr.zzq(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 34:
                    zzo = zzqr.zzs(i16, (List) unsafe.getObject(t10, j10), false);
                    i12 += zzo;
                    break;
                case 35:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzqr.zzn((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzqr.zzy((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzqr.zzl((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzqr.zzb((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzqr.zzw((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzqr.zze((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzqr.zzr((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzqr.zzt((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i16);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzqr.zzj(i16, (List) unsafe.getObject(t10, j10), zzs(i15));
                    i12 += zzo;
                    break;
                case 50:
                    zzpz.zza(i16, unsafe.getObject(t10, j10), zzt(i15));
                    break;
                case 51:
                    if (zzD(t10, i16, i15)) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t10, i16, i15)) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t10, i16, i15)) {
                        long zzr = zzr(t10, j10);
                        zzA3 = zzol.zzA(i16 << 3);
                        zzB = zzol.zzB(zzr);
                        zzo = zzA3 + zzB;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t10, i16, i15)) {
                        long zzr2 = zzr(t10, j10);
                        zzA3 = zzol.zzA(i16 << 3);
                        zzB = zzol.zzB(zzr2);
                        zzo = zzA3 + zzB;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t10, i16, i15)) {
                        int zzn = zzn(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzv(zzn);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t10, i16, i15)) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t10, i16, i15)) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t10, i16, i15)) {
                        zzA5 = zzol.zzA(i16 << 3);
                        zzo = zzA5 + 1;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzD(t10, i16, i15)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t10, j10);
                        if (object2 instanceof zzoe) {
                            zzA6 = zzol.zzA(i16 << 3);
                            zzd = ((zzoe) object2).zzd();
                            zzA7 = zzol.zzA(zzd);
                            i11 = zzA6 + zzA7 + zzd;
                            i12 += i11;
                            break;
                        } else {
                            zzA4 = zzol.zzA(i16 << 3);
                            zzv = zzol.zzy((String) object2);
                            i11 = zzA4 + zzv;
                            i12 += i11;
                        }
                    }
                case 60:
                    if (zzD(t10, i16, i15)) {
                        zzo = zzqr.zzo(i16, unsafe.getObject(t10, j10), zzs(i15));
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t10, i16, i15)) {
                        zzoe zzoeVar2 = (zzoe) unsafe.getObject(t10, j10);
                        zzA6 = zzol.zzA(i16 << 3);
                        zzd = zzoeVar2.zzd();
                        zzA7 = zzol.zzA(zzd);
                        i11 = zzA6 + zzA7 + zzd;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t10, i16, i15)) {
                        int zzn2 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzA(zzn2);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t10, i16, i15)) {
                        int zzn3 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzv(zzn3);
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t10, i16, i15)) {
                        zzA2 = zzol.zzA(i16 << 3);
                        zzo = zzA2 + 4;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t10, i16, i15)) {
                        zzA = zzol.zzA(i16 << 3);
                        zzo = zzA + 8;
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t10, i16, i15)) {
                        int zzn4 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzA((zzn4 >> 31) ^ (zzn4 + zzn4));
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t10, i16, i15)) {
                        long zzr3 = zzr(t10, j10);
                        zzA4 = zzol.zzA(i16 << 3);
                        zzv = zzol.zzB((zzr3 >> 63) ^ (zzr3 + zzr3));
                        i11 = zzA4 + zzv;
                        i12 += i11;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t10, i16, i15)) {
                        zzo = zzol.zzu(i16, (zzqe) unsafe.getObject(t10, j10), zzs(i15));
                        i12 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzrd<?, ?> zzrdVar = this.zzl;
        int zza2 = i12 + zzrdVar.zza(zzrdVar.zzc(t10));
        if (!this.zzf) {
            return zza2;
        }
        this.zzm.zza(t10);
        throw null;
    }

    private final int zzm(T t10) {
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
            int zzq = zzq(i12);
            int zzp = zzp(zzq);
            int i13 = this.zzc[i12];
            long j10 = zzq & 1048575;
            if (zzp >= zzot.zzJ.zza() && zzp <= zzot.zzW.zza()) {
                int i14 = this.zzc[i12 + 2];
            }
            switch (zzp) {
                case 0:
                    if (zzA(t10, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzA(t10, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzA(t10, i12)) {
                        long zzd2 = zzrn.zzd(t10, j10);
                        zzA3 = zzol.zzA(i13 << 3);
                        zzB = zzol.zzB(zzd2);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzA(t10, i12)) {
                        long zzd3 = zzrn.zzd(t10, j10);
                        zzA3 = zzol.zzA(i13 << 3);
                        zzB = zzol.zzB(zzd3);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzA(t10, i12)) {
                        int zzc = zzrn.zzc(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzv(zzc);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzA(t10, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzA(t10, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzA(t10, i12)) {
                        zzA5 = zzol.zzA(i13 << 3);
                        zzo = zzA5 + 1;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzA(t10, i12)) {
                        break;
                    } else {
                        Object zzf = zzrn.zzf(t10, j10);
                        if (zzf instanceof zzoe) {
                            zzA6 = zzol.zzA(i13 << 3);
                            zzd = ((zzoe) zzf).zzd();
                            zzA7 = zzol.zzA(zzd);
                            i10 = zzA6 + zzA7 + zzd;
                            i11 += i10;
                            break;
                        } else {
                            zzA4 = zzol.zzA(i13 << 3);
                            zzv = zzol.zzy((String) zzf);
                            i10 = zzA4 + zzv;
                            i11 += i10;
                        }
                    }
                case 9:
                    if (zzA(t10, i12)) {
                        zzo = zzqr.zzo(i13, zzrn.zzf(t10, j10), zzs(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzA(t10, i12)) {
                        zzoe zzoeVar = (zzoe) zzrn.zzf(t10, j10);
                        zzA6 = zzol.zzA(i13 << 3);
                        zzd = zzoeVar.zzd();
                        zzA7 = zzol.zzA(zzd);
                        i10 = zzA6 + zzA7 + zzd;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzA(t10, i12)) {
                        int zzc2 = zzrn.zzc(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzA(zzc2);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzA(t10, i12)) {
                        int zzc3 = zzrn.zzc(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzv(zzc3);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzA(t10, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzA(t10, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzA(t10, i12)) {
                        int zzc4 = zzrn.zzc(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzA((zzc4 >> 31) ^ (zzc4 + zzc4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzA(t10, i12)) {
                        long zzd4 = zzrn.zzd(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzB((zzd4 >> 63) ^ (zzd4 + zzd4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzA(t10, i12)) {
                        zzo = zzol.zzu(i13, (zzqe) zzrn.zzf(t10, j10), zzs(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzqr.zzh(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 19:
                    zzo = zzqr.zzf(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 20:
                    zzo = zzqr.zzm(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 21:
                    zzo = zzqr.zzx(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 22:
                    zzo = zzqr.zzk(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 23:
                    zzo = zzqr.zzh(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 24:
                    zzo = zzqr.zzf(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 25:
                    zzo = zzqr.zza(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 26:
                    zzo = zzqr.zzu(i13, (List) zzrn.zzf(t10, j10));
                    i11 += zzo;
                    break;
                case 27:
                    zzo = zzqr.zzp(i13, (List) zzrn.zzf(t10, j10), zzs(i12));
                    i11 += zzo;
                    break;
                case 28:
                    zzo = zzqr.zzc(i13, (List) zzrn.zzf(t10, j10));
                    i11 += zzo;
                    break;
                case 29:
                    zzo = zzqr.zzv(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 30:
                    zzo = zzqr.zzd(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 31:
                    zzo = zzqr.zzf(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 32:
                    zzo = zzqr.zzh(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 33:
                    zzo = zzqr.zzq(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 34:
                    zzo = zzqr.zzs(i13, (List) zzrn.zzf(t10, j10), false);
                    i11 += zzo;
                    break;
                case 35:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzqr.zzn((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzqr.zzy((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzqr.zzl((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzqr.zzb((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzqr.zzw((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzqr.zze((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzqr.zzg((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzqr.zzi((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzqr.zzr((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzqr.zzt((List) unsafe.getObject(t10, j10));
                    if (zzv > 0) {
                        zzz = zzol.zzz(i13);
                        zzA8 = zzol.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzqr.zzj(i13, (List) zzrn.zzf(t10, j10), zzs(i12));
                    i11 += zzo;
                    break;
                case 50:
                    zzpz.zza(i13, zzrn.zzf(t10, j10), zzt(i12));
                    break;
                case 51:
                    if (zzD(t10, i13, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t10, i13, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t10, i13, i12)) {
                        long zzr = zzr(t10, j10);
                        zzA3 = zzol.zzA(i13 << 3);
                        zzB = zzol.zzB(zzr);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t10, i13, i12)) {
                        long zzr2 = zzr(t10, j10);
                        zzA3 = zzol.zzA(i13 << 3);
                        zzB = zzol.zzB(zzr2);
                        i11 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t10, i13, i12)) {
                        int zzn = zzn(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzv(zzn);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t10, i13, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t10, i13, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t10, i13, i12)) {
                        zzA5 = zzol.zzA(i13 << 3);
                        zzo = zzA5 + 1;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzD(t10, i13, i12)) {
                        break;
                    } else {
                        Object zzf2 = zzrn.zzf(t10, j10);
                        if (zzf2 instanceof zzoe) {
                            zzA6 = zzol.zzA(i13 << 3);
                            zzd = ((zzoe) zzf2).zzd();
                            zzA7 = zzol.zzA(zzd);
                            i10 = zzA6 + zzA7 + zzd;
                            i11 += i10;
                            break;
                        } else {
                            zzA4 = zzol.zzA(i13 << 3);
                            zzv = zzol.zzy((String) zzf2);
                            i10 = zzA4 + zzv;
                            i11 += i10;
                        }
                    }
                case 60:
                    if (zzD(t10, i13, i12)) {
                        zzo = zzqr.zzo(i13, zzrn.zzf(t10, j10), zzs(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t10, i13, i12)) {
                        zzoe zzoeVar2 = (zzoe) zzrn.zzf(t10, j10);
                        zzA6 = zzol.zzA(i13 << 3);
                        zzd = zzoeVar2.zzd();
                        zzA7 = zzol.zzA(zzd);
                        i10 = zzA6 + zzA7 + zzd;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t10, i13, i12)) {
                        int zzn2 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzA(zzn2);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t10, i13, i12)) {
                        int zzn3 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzv(zzn3);
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t10, i13, i12)) {
                        zzA2 = zzol.zzA(i13 << 3);
                        zzo = zzA2 + 4;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t10, i13, i12)) {
                        zzA = zzol.zzA(i13 << 3);
                        zzo = zzA + 8;
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t10, i13, i12)) {
                        int zzn4 = zzn(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzA((zzn4 >> 31) ^ (zzn4 + zzn4));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t10, i13, i12)) {
                        long zzr3 = zzr(t10, j10);
                        zzA4 = zzol.zzA(i13 << 3);
                        zzv = zzol.zzB((zzr3 >> 63) ^ (zzr3 + zzr3));
                        i10 = zzA4 + zzv;
                        i11 += i10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t10, i13, i12)) {
                        zzo = zzol.zzu(i13, (zzqe) zzrn.zzf(t10, j10), zzs(i12));
                        i11 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzrd<?, ?> zzrdVar = this.zzl;
        return i11 + zzrdVar.zza(zzrdVar.zzc(t10));
    }

    private static <T> int zzn(T t10, long j10) {
        return ((Integer) zzrn.zzf(t10, j10)).intValue();
    }

    private final int zzo(int i10) {
        return this.zzc[i10 + 2];
    }

    private static int zzp(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzq(int i10) {
        return this.zzc[i10 + 1];
    }

    private static <T> long zzr(T t10, long j10) {
        return ((Long) zzrn.zzf(t10, j10)).longValue();
    }

    private final zzqp zzs(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzqp zzqpVar = (zzqp) this.zzd[i12];
        if (zzqpVar != null) {
            return zzqpVar;
        }
        zzqp<T> zzb2 = zzqm.zza().zzb((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzt(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private static Field zzu(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzv(T t10, T t11, int i10) {
        long zzq = zzq(i10) & 1048575;
        if (zzA(t11, i10)) {
            Object zzf = zzrn.zzf(t10, zzq);
            Object zzf2 = zzrn.zzf(t11, zzq);
            if (zzf != null && zzf2 != null) {
                zzrn.zzs(t10, zzq, zzph.zzg(zzf, zzf2));
                zzx(t10, i10);
            } else if (zzf2 != null) {
                zzrn.zzs(t10, zzq, zzf2);
                zzx(t10, i10);
            }
        }
    }

    private final void zzw(T t10, T t11, int i10) {
        int zzq = zzq(i10);
        int i11 = this.zzc[i10];
        long j10 = zzq & 1048575;
        if (zzD(t11, i11, i10)) {
            Object zzf = zzD(t10, i11, i10) ? zzrn.zzf(t10, j10) : null;
            Object zzf2 = zzrn.zzf(t11, j10);
            if (zzf != null && zzf2 != null) {
                zzrn.zzs(t10, j10, zzph.zzg(zzf, zzf2));
                zzy(t10, i11, i10);
            } else if (zzf2 != null) {
                zzrn.zzs(t10, j10, zzf2);
                zzy(t10, i11, i10);
            }
        }
    }

    private final void zzx(T t10, int i10) {
        int zzo = zzo(i10);
        long j10 = 1048575 & zzo;
        if (j10 == 1048575) {
            return;
        }
        zzrn.zzq(t10, j10, (1 << (zzo >>> 20)) | zzrn.zzc(t10, j10));
    }

    private final void zzy(T t10, int i10, int i11) {
        zzrn.zzq(t10, zzo(i11) & 1048575, i10);
    }

    private final boolean zzz(T t10, T t11, int i10) {
        return zzA(t10, i10) == zzA(t11, i10);
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final int zza(T t10) {
        return this.zzg ? zzm(t10) : zzl(t10);
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final int zzb(T t10) {
        int i10;
        int zzc;
        int length = this.zzc.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int zzq = zzq(i12);
            int i13 = this.zzc[i12];
            long j10 = 1048575 & zzq;
            int i14 = 37;
            switch (zzp(zzq)) {
                case 0:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(Double.doubleToLongBits(zzrn.zza(t10, j10)));
                    i11 = i10 + zzc;
                    break;
                case 1:
                    i10 = i11 * 53;
                    zzc = Float.floatToIntBits(zzrn.zzb(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 2:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(zzrn.zzd(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 3:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(zzrn.zzd(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 4:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 5:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(zzrn.zzd(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 6:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 7:
                    i10 = i11 * 53;
                    zzc = zzph.zza(zzrn.zzw(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 8:
                    i10 = i11 * 53;
                    zzc = ((String) zzrn.zzf(t10, j10)).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 9:
                    Object zzf = zzrn.zzf(t10, j10);
                    if (zzf != null) {
                        i14 = zzf.hashCode();
                    }
                    i11 = (i11 * 53) + i14;
                    break;
                case 10:
                    i10 = i11 * 53;
                    zzc = zzrn.zzf(t10, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 11:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 12:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 13:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 14:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(zzrn.zzd(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 15:
                    i10 = i11 * 53;
                    zzc = zzrn.zzc(t10, j10);
                    i11 = i10 + zzc;
                    break;
                case 16:
                    i10 = i11 * 53;
                    zzc = zzph.zzc(zzrn.zzd(t10, j10));
                    i11 = i10 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzrn.zzf(t10, j10);
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
                    zzc = zzrn.zzf(t10, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 50:
                    i10 = i11 * 53;
                    zzc = zzrn.zzf(t10, j10).hashCode();
                    i11 = i10 + zzc;
                    break;
                case 51:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(Double.doubleToLongBits(zzj(t10, j10)));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = Float.floatToIntBits(zzk(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(zzr(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(zzr(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(zzr(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zza(zzE(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = ((String) zzrn.zzf(t10, j10)).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzrn.zzf(t10, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzrn.zzf(t10, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(zzr(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzn(t10, j10);
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzph.zzc(zzr(t10, j10));
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t10, i13, i12)) {
                        i10 = i11 * 53;
                        zzc = zzrn.zzf(t10, j10).hashCode();
                        i11 = i10 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i11 * 53) + this.zzl.zzc(t10).hashCode();
        if (!this.zzf) {
            return hashCode;
        }
        this.zzm.zza(t10);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzc(T t10) {
        int i10;
        int i11 = this.zzi;
        while (true) {
            i10 = this.zzj;
            if (i11 >= i10) {
                break;
            }
            long zzq = zzq(this.zzh[i11]) & 1048575;
            Object zzf = zzrn.zzf(t10, zzq);
            if (zzf != null) {
                ((zzpy) zzf).zzb();
                zzrn.zzs(t10, zzq, zzf);
            }
            i11++;
        }
        int length = this.zzh.length;
        while (i10 < length) {
            this.zzk.zza(t10, this.zzh[i10]);
            i10++;
        }
        this.zzl.zze(t10);
        if (this.zzf) {
            this.zzm.zzb(t10);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzd(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzq = zzq(i10);
            long j10 = 1048575 & zzq;
            int i11 = this.zzc[i10];
            switch (zzp(zzq)) {
                case 0:
                    if (zzA(t11, i10)) {
                        zzrn.zzo(t10, j10, zzrn.zza(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzA(t11, i10)) {
                        zzrn.zzp(t10, j10, zzrn.zzb(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzA(t11, i10)) {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzA(t11, i10)) {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzA(t11, i10)) {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzA(t11, i10)) {
                        zzrn.zzm(t10, j10, zzrn.zzw(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzA(t11, i10)) {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzv(t10, t11, i10);
                    break;
                case 10:
                    if (zzA(t11, i10)) {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzA(t11, i10)) {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzA(t11, i10)) {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzA(t11, i10)) {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzv(t10, t11, i10);
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
                    this.zzk.zzb(t10, t11, j10);
                    break;
                case 50:
                    zzqr.zzG(this.zzo, t10, t11, j10);
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
                    if (zzD(t11, i11, i10)) {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzy(t10, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzw(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzD(t11, i11, i10)) {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzy(t10, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzw(t10, t11, i10);
                    break;
            }
        }
        zzqr.zzD(this.zzl, t10, t11);
        if (this.zzf) {
            zzqr.zzC(this.zzm, t10, t11);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final boolean zze(T t10, T t11) {
        boolean zzF;
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzq = zzq(i10);
            long j10 = zzq & 1048575;
            switch (zzp(zzq)) {
                case 0:
                    if (zzz(t10, t11, i10) && Double.doubleToLongBits(zzrn.zza(t10, j10)) == Double.doubleToLongBits(zzrn.zza(t11, j10))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzz(t10, t11, i10) && Float.floatToIntBits(zzrn.zzb(t10, j10)) == Float.floatToIntBits(zzrn.zzb(t11, j10))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzz(t10, t11, i10) && zzrn.zzw(t10, j10) == zzrn.zzw(t11, j10)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
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
                    zzF = zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10));
                    break;
                case 50:
                    zzF = zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10));
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
                    long zzo = zzo(i10) & 1048575;
                    if (zzrn.zzc(t10, zzo) == zzrn.zzc(t11, zzo) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzF) {
                return false;
            }
        }
        if (!this.zzl.zzc(t10).equals(this.zzl.zzc(t11))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t10);
        this.zzm.zza(t11);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzqp
    public final boolean zzf(T t10) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzi) {
            int i15 = this.zzh[i14];
            int i16 = this.zzc[i15];
            int zzq = zzq(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(t10, i18);
                }
                i11 = i13;
                i10 = i18;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if ((268435456 & zzq) != 0 && !zzB(t10, i15, i10, i11, i19)) {
                return false;
            }
            int zzp = zzp(zzq);
            if (zzp != 9 && zzp != 17) {
                if (zzp != 27) {
                    if (zzp == 60 || zzp == 68) {
                        if (zzD(t10, i16, i15) && !zzC(t10, zzq, zzs(i15))) {
                            return false;
                        }
                    } else if (zzp != 49) {
                        if (zzp == 50 && !((zzpy) zzrn.zzf(t10, zzq & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzrn.zzf(t10, zzq & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzqp zzs = zzs(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzs.zzf(list.get(i20))) {
                            return false;
                        }
                    }
                }
            } else if (zzB(t10, i15, i10, i11, i19) && !zzC(t10, zzq, zzs(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t10);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzi(T t10, zzom zzomVar) {
        if (!this.zzg) {
            zzF(t10, zzomVar);
            return;
        }
        if (this.zzf) {
            this.zzm.zza(t10);
            throw null;
        }
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzq = zzq(i10);
            int i11 = this.zzc[i10];
            switch (zzp(zzq)) {
                case 0:
                    if (zzA(t10, i10)) {
                        zzomVar.zzf(i11, zzrn.zza(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzA(t10, i10)) {
                        zzomVar.zzn(i11, zzrn.zzb(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzA(t10, i10)) {
                        zzomVar.zzs(i11, zzrn.zzd(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzA(t10, i10)) {
                        zzomVar.zzH(i11, zzrn.zzd(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzA(t10, i10)) {
                        zzomVar.zzq(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzA(t10, i10)) {
                        zzomVar.zzl(i11, zzrn.zzd(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzA(t10, i10)) {
                        zzomVar.zzj(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzA(t10, i10)) {
                        zzomVar.zzb(i11, zzrn.zzw(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzA(t10, i10)) {
                        zzH(i11, zzrn.zzf(t10, zzq & 1048575), zzomVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzA(t10, i10)) {
                        zzomVar.zzu(i11, zzrn.zzf(t10, zzq & 1048575), zzs(i10));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzA(t10, i10)) {
                        zzomVar.zzd(i11, (zzoe) zzrn.zzf(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzA(t10, i10)) {
                        zzomVar.zzF(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzA(t10, i10)) {
                        zzomVar.zzh(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzA(t10, i10)) {
                        zzomVar.zzv(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzA(t10, i10)) {
                        zzomVar.zzx(i11, zzrn.zzd(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzA(t10, i10)) {
                        zzomVar.zzz(i11, zzrn.zzc(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzA(t10, i10)) {
                        zzomVar.zzB(i11, zzrn.zzd(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzA(t10, i10)) {
                        zzomVar.zzp(i11, zzrn.zzf(t10, zzq & 1048575), zzs(i10));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzqr.zzJ(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 19:
                    zzqr.zzN(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 20:
                    zzqr.zzQ(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 21:
                    zzqr.zzY(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 22:
                    zzqr.zzP(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 23:
                    zzqr.zzM(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 24:
                    zzqr.zzL(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 25:
                    zzqr.zzH(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 26:
                    zzqr.zzW(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar);
                    break;
                case 27:
                    zzqr.zzR(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, zzs(i10));
                    break;
                case 28:
                    zzqr.zzI(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar);
                    break;
                case 29:
                    zzqr.zzX(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 30:
                    zzqr.zzK(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 31:
                    zzqr.zzS(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 32:
                    zzqr.zzT(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 33:
                    zzqr.zzU(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 34:
                    zzqr.zzV(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, false);
                    break;
                case 35:
                    zzqr.zzJ(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 36:
                    zzqr.zzN(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 37:
                    zzqr.zzQ(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 38:
                    zzqr.zzY(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 39:
                    zzqr.zzP(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 40:
                    zzqr.zzM(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 41:
                    zzqr.zzL(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 42:
                    zzqr.zzH(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 43:
                    zzqr.zzX(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 44:
                    zzqr.zzK(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 45:
                    zzqr.zzS(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 46:
                    zzqr.zzT(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 47:
                    zzqr.zzU(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 48:
                    zzqr.zzV(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, true);
                    break;
                case 49:
                    zzqr.zzO(this.zzc[i10], (List) zzrn.zzf(t10, zzq & 1048575), zzomVar, zzs(i10));
                    break;
                case 50:
                    zzG(zzomVar, i11, zzrn.zzf(t10, zzq & 1048575), i10);
                    break;
                case 51:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzf(i11, zzj(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzn(i11, zzk(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzs(i11, zzr(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzH(i11, zzr(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzq(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzl(i11, zzr(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzj(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzb(i11, zzE(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzD(t10, i11, i10)) {
                        zzH(i11, zzrn.zzf(t10, zzq & 1048575), zzomVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzu(i11, zzrn.zzf(t10, zzq & 1048575), zzs(i10));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzd(i11, (zzoe) zzrn.zzf(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzF(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzh(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzv(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzx(i11, zzr(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzz(i11, zzn(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzB(i11, zzr(t10, zzq & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t10, i11, i10)) {
                        zzomVar.zzp(i11, zzrn.zzf(t10, zzq & 1048575), zzs(i10));
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzrd<?, ?> zzrdVar = this.zzl;
        zzrdVar.zzg(zzrdVar.zzc(t10), zzomVar);
    }
}
