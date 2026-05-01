package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzqo implements zzqb {
    private final zzqe zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzqo(zzqe zzqeVar, String str, Object[] objArr) {
        this.zza = zzqeVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i10 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 < 55296) {
                this.zzd = i10 | (charAt2 << i11);
                return;
            } else {
                i10 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqb
    public final zzqe zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzqb
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.cast.zzqb
    public final int zzc() {
        return (this.zzd & 1) == 1 ? 1 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
