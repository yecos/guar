package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class zzpq extends zzps {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzpq(zzpp zzppVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.cast.zzps
    public final void zza(Object obj, long j10) {
        Object unmodifiableList;
        List list = (List) zzrn.zzf(obj, j10);
        if (list instanceof zzpo) {
            unmodifiableList = ((zzpo) list).zzd();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzql) && (list instanceof zzpg)) {
                zzpg zzpgVar = (zzpg) list;
                if (zzpgVar.zzc()) {
                    zzpgVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzrn.zzs(obj, j10, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzps
    public final <E> void zzb(Object obj, Object obj2, long j10) {
        zzpn zzpnVar;
        List list = (List) zzrn.zzf(obj2, j10);
        int size = list.size();
        List list2 = (List) zzrn.zzf(obj, j10);
        if (list2.isEmpty()) {
            list2 = list2 instanceof zzpo ? new zzpn(size) : ((list2 instanceof zzql) && (list2 instanceof zzpg)) ? ((zzpg) list2).zzg(size) : new ArrayList(size);
            zzrn.zzs(obj, j10, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzrn.zzs(obj, j10, arrayList);
                zzpnVar = arrayList;
            } else if (list2 instanceof zzri) {
                zzpn zzpnVar2 = new zzpn(list2.size() + size);
                zzpnVar2.addAll(zzpnVar2.size(), (zzri) list2);
                zzrn.zzs(obj, j10, zzpnVar2);
                zzpnVar = zzpnVar2;
            } else if ((list2 instanceof zzql) && (list2 instanceof zzpg)) {
                zzpg zzpgVar = (zzpg) list2;
                if (!zzpgVar.zzc()) {
                    list2 = zzpgVar.zzg(list2.size() + size);
                    zzrn.zzs(obj, j10, list2);
                }
            }
            list2 = zzpnVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzrn.zzs(obj, j10, list);
    }

    private zzpq() {
        super(null);
    }
}
