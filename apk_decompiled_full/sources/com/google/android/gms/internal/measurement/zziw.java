package com.google.android.gms.internal.measurement;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

/* loaded from: classes.dex */
final class zziw implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzje zzjeVar = (zzje) obj;
        zzje zzjeVar2 = (zzje) obj2;
        zziv zzivVar = new zziv(zzjeVar);
        zziv zzivVar2 = new zziv(zzjeVar2);
        while (zzivVar.hasNext() && zzivVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzivVar.zza() & UnsignedBytes.MAX_VALUE).compareTo(Integer.valueOf(zzivVar2.zza() & UnsignedBytes.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzjeVar.zzd()).compareTo(Integer.valueOf(zzjeVar2.zzd()));
    }
}
