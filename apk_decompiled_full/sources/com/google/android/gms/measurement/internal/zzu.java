package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzu {
    final /* synthetic */ zzaa zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzgi zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzu(zzaa zzaaVar, String str, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new androidx.collection.a();
        this.zzh = new androidx.collection.a();
    }

    public final com.google.android.gms.internal.measurement.zzfp zza(int i10) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzfo zzb = com.google.android.gms.internal.measurement.zzfp.zzb();
        zzb.zza(i10);
        zzb.zzc(this.zzc);
        com.google.android.gms.internal.measurement.zzgi zzgiVar = this.zzd;
        if (zzgiVar != null) {
            zzb.zzd(zzgiVar);
        }
        com.google.android.gms.internal.measurement.zzgh zzf = com.google.android.gms.internal.measurement.zzgi.zzf();
        zzf.zzb(zzkv.zzr(this.zze));
        zzf.zzd(zzkv.zzr(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator it = this.zzg.keySet().iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                Long l10 = (Long) this.zzg.get(Integer.valueOf(intValue));
                if (l10 != null) {
                    com.google.android.gms.internal.measurement.zzfq zzc = com.google.android.gms.internal.measurement.zzfr.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l10.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzfr) zzc.zzaC());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzf.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzgj zzd = com.google.android.gms.internal.measurement.zzgk.zzd();
                zzd.zzb(num.intValue());
                List list2 = (List) this.zzh.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzgk) zzd.zzaC());
            }
            list = arrayList3;
        }
        zzf.zzc(list);
        zzb.zzb(zzf);
        return (com.google.android.gms.internal.measurement.zzfp) zzb.zzaC();
    }

    public final void zzc(zzy zzyVar) {
        int zza = zzyVar.zza();
        Boolean bool = zzyVar.zzd;
        if (bool != null) {
            this.zzf.set(zza, bool.booleanValue());
        }
        Boolean bool2 = zzyVar.zze;
        if (bool2 != null) {
            this.zze.set(zza, bool2.booleanValue());
        }
        if (zzyVar.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza);
            Long l10 = (Long) map.get(valueOf);
            long longValue = zzyVar.zzf.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzyVar.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzyVar.zzc()) {
                list.clear();
            }
            zznz.zzc();
            zzag zzf = this.zza.zzt.zzf();
            String str = this.zzb;
            zzdt zzdtVar = zzdu.zzW;
            if (zzf.zzs(str, zzdtVar) && zzyVar.zzb()) {
                list.clear();
            }
            zznz.zzc();
            if (!this.zza.zzt.zzf().zzs(this.zzb, zzdtVar)) {
                list.add(Long.valueOf(zzyVar.zzg.longValue() / 1000));
                return;
            }
            Long valueOf3 = Long.valueOf(zzyVar.zzg.longValue() / 1000);
            if (list.contains(valueOf3)) {
                return;
            }
            list.add(valueOf3);
        }
    }

    public /* synthetic */ zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new androidx.collection.a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgiVar;
    }
}
