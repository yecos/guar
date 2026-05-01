package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
abstract class zzw extends zzj {
    final CharSequence zzb;
    final zzo zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    public zzw(zzx zzxVar, CharSequence charSequence) {
        zzo zzoVar;
        boolean z10;
        zzoVar = zzxVar.zza;
        this.zzc = zzoVar;
        z10 = zzxVar.zzb;
        this.zzd = z10;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r3 = r5.zzf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r3 != 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        r1 = r5.zzb.length();
        r5.zze = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r1 <= r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        r5.zzb.charAt(r1 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return r5.zzb.subSequence(r0, r1).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r5.zzf = r3 - 1;
     */
    @Override // com.google.android.gms.internal.common.zzj
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object zza() {
        int zzc;
        int i10 = this.zze;
        while (true) {
            int i11 = this.zze;
            if (i11 == -1) {
                zzb();
                return null;
            }
            int zzd = zzd(i11);
            if (zzd == -1) {
                zzd = this.zzb.length();
                this.zze = -1;
                zzc = -1;
            } else {
                zzc = zzc(zzd);
                this.zze = zzc;
            }
            if (zzc == i10) {
                int i12 = zzc + 1;
                this.zze = i12;
                if (i12 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i10 < zzd) {
                    this.zzb.charAt(i10);
                }
                if (i10 < zzd) {
                    this.zzb.charAt(zzd - 1);
                }
                if (!this.zzd || i10 != zzd) {
                    break;
                }
                i10 = this.zze;
            }
        }
    }

    public abstract int zzc(int i10);

    public abstract int zzd(int i10);
}
