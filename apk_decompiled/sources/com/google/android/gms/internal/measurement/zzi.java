package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzi {
    public static zzap zza(zzgy zzgyVar) {
        if (zzgyVar == null) {
            return zzap.zzf;
        }
        int zzj = zzgyVar.zzj() - 1;
        if (zzj == 1) {
            return zzgyVar.zzi() ? new zzat(zzgyVar.zzd()) : zzap.zzm;
        }
        if (zzj == 2) {
            return zzgyVar.zzh() ? new zzah(Double.valueOf(zzgyVar.zza())) : new zzah(null);
        }
        if (zzj == 3) {
            return zzgyVar.zzg() ? new zzaf(Boolean.valueOf(zzgyVar.zzf())) : new zzaf(null);
        }
        if (zzj != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List zze = zzgyVar.zze();
        ArrayList arrayList = new ArrayList();
        Iterator it = zze.iterator();
        while (it.hasNext()) {
            arrayList.add(zza((zzgy) it.next()));
        }
        return new zzaq(zzgyVar.zzc(), arrayList);
    }

    public static zzap zzb(Object obj) {
        if (obj == null) {
            return zzap.zzg;
        }
        if (obj instanceof String) {
            return new zzat((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            zzae zzaeVar = new zzae();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzaeVar.zzq(zzaeVar.zzc(), zzb(it.next()));
            }
            return zzaeVar;
        }
        zzam zzamVar = new zzam();
        Map map = (Map) obj;
        for (Object obj2 : map.keySet()) {
            zzap zzb = zzb(map.get(obj2));
            if (obj2 != null) {
                if (!(obj2 instanceof String)) {
                    obj2 = obj2.toString();
                }
                zzamVar.zzr((String) obj2, zzb);
            }
        }
        return zzamVar;
    }
}
