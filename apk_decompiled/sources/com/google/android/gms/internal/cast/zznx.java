package com.google.android.gms.internal.cast;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

/* loaded from: classes.dex */
final class zznx implements Comparator<zzoe> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzoe zzoeVar, zzoe zzoeVar2) {
        zzoe zzoeVar3 = zzoeVar;
        zzoe zzoeVar4 = zzoeVar2;
        zznv zznvVar = new zznv(zzoeVar3);
        zznv zznvVar2 = new zznv(zzoeVar4);
        while (zznvVar.hasNext() && zznvVar2.hasNext()) {
            int zza = zznw.zza(zznvVar.zza() & UnsignedBytes.MAX_VALUE, zznvVar2.zza() & UnsignedBytes.MAX_VALUE);
            if (zza != 0) {
                return zza;
            }
        }
        return zznw.zza(zzoeVar3.zzd(), zzoeVar4.zzd());
    }
}
