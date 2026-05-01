package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class zzkw extends zzla {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzkw(zzkv zzkvVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(Object obj, long j10) {
        Object unmodifiableList;
        List list = (List) zzmy.zzf(obj, j10);
        if (list instanceof zzku) {
            unmodifiableList = ((zzku) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzlt) && (list instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list;
                if (zzkmVar.zzc()) {
                    zzkmVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzmy.zzs(obj, j10, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(Object obj, Object obj2, long j10) {
        zzkt zzktVar;
        List list = (List) zzmy.zzf(obj2, j10);
        int size = list.size();
        List list2 = (List) zzmy.zzf(obj, j10);
        if (list2.isEmpty()) {
            list2 = list2 instanceof zzku ? new zzkt(size) : ((list2 instanceof zzlt) && (list2 instanceof zzkm)) ? ((zzkm) list2).zzd(size) : new ArrayList(size);
            zzmy.zzs(obj, j10, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzmy.zzs(obj, j10, arrayList);
                zzktVar = arrayList;
            } else if (list2 instanceof zzmt) {
                zzkt zzktVar2 = new zzkt(list2.size() + size);
                zzktVar2.addAll(zzktVar2.size(), (zzmt) list2);
                zzmy.zzs(obj, j10, zzktVar2);
                zzktVar = zzktVar2;
            } else if ((list2 instanceof zzlt) && (list2 instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list2;
                if (!zzkmVar.zzc()) {
                    list2 = zzkmVar.zzd(list2.size() + size);
                    zzmy.zzs(obj, j10, list2);
                }
            }
            list2 = zzktVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzmy.zzs(obj, j10, list);
    }

    private zzkw() {
        super(null);
    }
}
