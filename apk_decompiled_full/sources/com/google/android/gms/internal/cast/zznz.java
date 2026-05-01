package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zznz extends zzoc {
    private final int zzc;

    public zznz(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzoe.zzj(0, i11, bArr.length);
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.cast.zzoc, com.google.android.gms.internal.cast.zzoe
    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(i11);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.cast.zzoc, com.google.android.gms.internal.cast.zzoe
    public final byte zzb(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.cast.zzoc
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzoc, com.google.android.gms.internal.cast.zzoe
    public final int zzd() {
        return this.zzc;
    }
}
