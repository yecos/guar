package com.google.android.gms.internal.cast;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzol extends zznu {
    private static final Logger zzb = Logger.getLogger(zzol.class.getName());
    private static final boolean zzc = zzrn.zzx();
    zzom zza;

    private zzol() {
    }

    public /* synthetic */ zzol(zzoi zzoiVar) {
    }

    public static int zzA(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzB(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static zzol zzC(byte[] bArr) {
        return new zzoj(bArr, 0, bArr.length);
    }

    public static int zzt(zzoe zzoeVar) {
        int zzd = zzoeVar.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    public static int zzu(int i10, zzqe zzqeVar, zzqp zzqpVar) {
        int zzA = zzA(i10 << 3);
        int i11 = zzA + zzA;
        zznr zznrVar = (zznr) zzqeVar;
        int zzn = zznrVar.zzn();
        if (zzn == -1) {
            zzn = zzqpVar.zza(zznrVar);
            zznrVar.zzp(zzn);
        }
        return i11 + zzn;
    }

    public static int zzv(int i10) {
        if (i10 >= 0) {
            return zzA(i10);
        }
        return 10;
    }

    public static int zzw(zzpm zzpmVar) {
        int zza = zzpmVar.zza();
        return zzA(zza) + zza;
    }

    public static int zzx(zzqe zzqeVar, zzqp zzqpVar) {
        zznr zznrVar = (zznr) zzqeVar;
        int zzn = zznrVar.zzn();
        if (zzn == -1) {
            zzn = zzqpVar.zza(zznrVar);
            zznrVar.zzp(zzn);
        }
        return zzA(zzn) + zzn;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzrr.zzc(str);
        } catch (zzrq unused) {
            length = str.getBytes(zzph.zzb).length;
        }
        return zzA(length) + length;
    }

    public static int zzz(int i10) {
        return zzA(i10 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzE(String str, zzrq zzrqVar) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzrqVar);
        byte[] bytes = str.getBytes(zzph.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (zzok e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzok(e11);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10);

    public abstract void zzd(int i10, boolean z10);

    public abstract void zze(int i10, zzoe zzoeVar);

    public abstract void zzf(int i10, int i11);

    public abstract void zzg(int i10);

    public abstract void zzh(int i10, long j10);

    public abstract void zzi(long j10);

    public abstract void zzj(int i10, int i11);

    public abstract void zzk(int i10);

    public abstract void zzl(byte[] bArr, int i10, int i11);

    public abstract void zzm(int i10, String str);

    public abstract void zzo(int i10, int i11);

    public abstract void zzp(int i10, int i11);

    public abstract void zzq(int i10);

    public abstract void zzr(int i10, long j10);

    public abstract void zzs(long j10);
}
