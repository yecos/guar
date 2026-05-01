package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
class zzoc extends zzob {
    protected final byte[] zza;

    public zzoc(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzoe) || zzd() != ((zzoe) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzoc)) {
            return obj.equals(this);
        }
        zzoc zzocVar = (zzoc) obj;
        int zzk = zzk();
        int zzk2 = zzocVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzocVar.zzd()) {
            int zzd2 = zzd();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(zzd);
            sb.append(zzd2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (zzd > zzocVar.zzd()) {
            int zzd3 = zzocVar.zzd();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzd);
            sb2.append(", ");
            sb2.append(zzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzocVar.zza;
        zzocVar.zzc();
        int i10 = 0;
        int i11 = 0;
        while (i10 < zzd) {
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public byte zza(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final int zze(int i10, int i11, int i12) {
        return zzph.zzd(i10, this.zza, 0, i12);
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final zzoe zzf(int i10, int i11) {
        zzoe.zzj(0, i11, zzd());
        return i11 == 0 ? zzoe.zzb : new zznz(this.zza, 0, i11);
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final void zzh(zznu zznuVar) {
        ((zzoj) zznuVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.cast.zzoe
    public final boolean zzi() {
        return zzrr.zze(this.zza, 0, zzd());
    }
}
