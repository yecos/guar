package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
final class zzis {
    public static int zza(byte[] bArr, int i10, zzir zzirVar) {
        int zzj = zzj(bArr, i10, zzirVar);
        int i11 = zzirVar.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        }
        if (i11 > bArr.length - zzj) {
            throw zzkp.zzf();
        }
        if (i11 == 0) {
            zzirVar.zzc = zzje.zzb;
            return zzj;
        }
        zzirVar.zzc = zzje.zzl(bArr, zzj, i11);
        return zzj + i11;
    }

    public static int zzb(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i10] & UnsignedBytes.MAX_VALUE) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static int zzc(zzlx zzlxVar, byte[] bArr, int i10, int i11, int i12, zzir zzirVar) {
        Object zze = zzlxVar.zze();
        int zzn = zzn(zze, zzlxVar, bArr, i10, i11, i12, zzirVar);
        zzlxVar.zzf(zze);
        zzirVar.zzc = zze;
        return zzn;
    }

    public static int zzd(zzlx zzlxVar, byte[] bArr, int i10, int i11, zzir zzirVar) {
        Object zze = zzlxVar.zze();
        int zzo = zzo(zze, zzlxVar, bArr, i10, i11, zzirVar);
        zzlxVar.zzf(zze);
        zzirVar.zzc = zze;
        return zzo;
    }

    public static int zze(zzlx zzlxVar, int i10, byte[] bArr, int i11, int i12, zzkm zzkmVar, zzir zzirVar) {
        int zzd = zzd(zzlxVar, bArr, i11, i12, zzirVar);
        zzkmVar.add(zzirVar.zzc);
        while (zzd < i12) {
            int zzj = zzj(bArr, zzd, zzirVar);
            if (i10 != zzirVar.zza) {
                break;
            }
            zzd = zzd(zzlxVar, bArr, zzj, i12, zzirVar);
            zzkmVar.add(zzirVar.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i10, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int zzj = zzj(bArr, i10, zzirVar);
        int i11 = zzirVar.zza + zzj;
        while (zzj < i11) {
            zzj = zzj(bArr, zzj, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        if (zzj == i11) {
            return zzj;
        }
        throw zzkp.zzf();
    }

    public static int zzg(byte[] bArr, int i10, zzir zzirVar) {
        int zzj = zzj(bArr, i10, zzirVar);
        int i11 = zzirVar.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        }
        if (i11 == 0) {
            zzirVar.zzc = "";
            return zzj;
        }
        zzirVar.zzc = new String(bArr, zzj, i11, zzkn.zzb);
        return zzj + i11;
    }

    public static int zzh(byte[] bArr, int i10, zzir zzirVar) {
        int zzj = zzj(bArr, i10, zzirVar);
        int i11 = zzirVar.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        }
        if (i11 == 0) {
            zzirVar.zzc = "";
            return zzj;
        }
        zzirVar.zzc = zznd.zzd(bArr, zzj, i11);
        return zzj + i11;
    }

    public static int zzi(int i10, byte[] bArr, int i11, int i12, zzmp zzmpVar, zzir zzirVar) {
        if ((i10 >>> 3) == 0) {
            throw zzkp.zzb();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int zzm = zzm(bArr, i11, zzirVar);
            zzmpVar.zzj(i10, Long.valueOf(zzirVar.zzb));
            return zzm;
        }
        if (i13 == 1) {
            zzmpVar.zzj(i10, Long.valueOf(zzp(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int zzj = zzj(bArr, i11, zzirVar);
            int i14 = zzirVar.zza;
            if (i14 < 0) {
                throw zzkp.zzd();
            }
            if (i14 > bArr.length - zzj) {
                throw zzkp.zzf();
            }
            if (i14 == 0) {
                zzmpVar.zzj(i10, zzje.zzb);
            } else {
                zzmpVar.zzj(i10, zzje.zzl(bArr, zzj, i14));
            }
            return zzj + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw zzkp.zzb();
            }
            zzmpVar.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        zzmp zzf = zzmp.zzf();
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int zzj2 = zzj(bArr, i11, zzirVar);
            int i17 = zzirVar.zza;
            if (i17 == i15) {
                i16 = i17;
                i11 = zzj2;
                break;
            }
            i16 = i17;
            i11 = zzi(i17, bArr, zzj2, i12, zzf, zzirVar);
        }
        if (i11 > i12 || i16 != i15) {
            throw zzkp.zze();
        }
        zzmpVar.zzj(i10, zzf);
        return i11;
    }

    public static int zzj(byte[] bArr, int i10, zzir zzirVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzk(b10, bArr, i11, zzirVar);
        }
        zzirVar.zza = b10;
        return i11;
    }

    public static int zzk(int i10, byte[] bArr, int i11, zzir zzirVar) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            zzirVar.zza = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Ascii.DEL) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            zzirVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Ascii.DEL) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzirVar.zza = i16 | (b12 << Ascii.NAK);
            return i17;
        }
        int i18 = i16 | ((b12 & Ascii.DEL) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzirVar.zza = i18 | (b13 << Ascii.FS);
            return i19;
        }
        int i20 = i18 | ((b13 & Ascii.DEL) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzirVar.zza = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int zzl(int i10, byte[] bArr, int i11, int i12, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int zzj = zzj(bArr, i11, zzirVar);
        zzkgVar.zzh(zzirVar.zza);
        while (zzj < i12) {
            int zzj2 = zzj(bArr, zzj, zzirVar);
            if (i10 != zzirVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i10, zzir zzirVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            zzirVar.zzb = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & Ascii.DEL) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & Ascii.DEL) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        zzirVar.zzb = j11;
        return i12;
    }

    public static int zzn(Object obj, zzlx zzlxVar, byte[] bArr, int i10, int i11, int i12, zzir zzirVar) {
        int zzc = ((zzlp) zzlxVar).zzc(obj, bArr, i10, i11, i12, zzirVar);
        zzirVar.zzc = obj;
        return zzc;
    }

    public static int zzo(Object obj, zzlx zzlxVar, byte[] bArr, int i10, int i11, zzir zzirVar) {
        int i12 = i10 + 1;
        int i13 = bArr[i10];
        if (i13 < 0) {
            i12 = zzk(i13, bArr, i12, zzirVar);
            i13 = zzirVar.zza;
        }
        int i14 = i12;
        if (i13 < 0 || i13 > i11 - i14) {
            throw zzkp.zzf();
        }
        int i15 = i13 + i14;
        zzlxVar.zzh(obj, bArr, i14, i15, zzirVar);
        zzirVar.zzc = obj;
        return i15;
    }

    public static long zzp(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }
}
