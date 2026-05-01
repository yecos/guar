package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class zzw {
    final /* synthetic */ zzaa zza;
    private com.google.android.gms.internal.measurement.zzft zzb;
    private Long zzc;
    private long zzd;

    public /* synthetic */ zzw(zzaa zzaaVar, zzv zzvVar) {
        this.zza = zzaaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r8 != r13.zzc.longValue()) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
    
        if (r8 == null) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d5  */
    /* JADX WARN: Type inference failed for: r8v10, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.zzft zza(String str, com.google.android.gms.internal.measurement.zzft zzftVar) {
        SQLiteException e10;
        Cursor cursor;
        Pair pair;
        Object obj;
        ?? longValue;
        String zzh = zzftVar.zzh();
        List zzi = zzftVar.zzi();
        this.zza.zzf.zzu();
        Long l10 = (Long) zzkv.zzC(zzftVar, "_eid");
        if (l10 != null) {
            if (zzh.equals("_ep")) {
                Preconditions.checkNotNull(l10);
                this.zza.zzf.zzu();
                zzh = (String) zzkv.zzC(zzftVar, "_en");
                Cursor cursor2 = null;
                if (TextUtils.isEmpty(zzh)) {
                    this.zza.zzt.zzay().zzh().zzb("Extra parameter without an event name. eventId", l10);
                    return null;
                }
                if (this.zzb != null && this.zzc != null) {
                    longValue = l10.longValue();
                }
                zzam zzi2 = this.zza.zzf.zzi();
                zzi2.zzg();
                zzi2.zzW();
                try {
                    try {
                        cursor = zzi2.zzh().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l10.toString()});
                        try {
                        } catch (SQLiteException e11) {
                            e10 = e11;
                            zzi2.zzt.zzay().zzd().zzb("Error selecting main event", e10);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = longValue;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e10 = e12;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
                if (cursor.moveToFirst()) {
                    try {
                        pair = Pair.create((com.google.android.gms.internal.measurement.zzft) ((com.google.android.gms.internal.measurement.zzfs) zzkv.zzl(com.google.android.gms.internal.measurement.zzft.zze(), cursor.getBlob(0))).zzaC(), Long.valueOf(cursor.getLong(1)));
                        cursor.close();
                    } catch (IOException e13) {
                        zzi2.zzt.zzay().zzd().zzd("Failed to merge main event. appId, eventId", zzeh.zzn(str), l10, e13);
                    }
                    if (pair != null || (obj = pair.first) == null) {
                        this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", zzh, l10);
                        return null;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzft) obj;
                    this.zzd = ((Long) pair.second).longValue();
                    this.zza.zzf.zzu();
                    this.zzc = (Long) zzkv.zzC(this.zzb, "_eid");
                    long j10 = this.zzd - 1;
                    this.zzd = j10;
                    if (j10 <= 0) {
                        zzam zzi3 = this.zza.zzf.zzi();
                        zzi3.zzg();
                        zzi3.zzt.zzay().zzj().zzb("Clearing complex main event info. appId", str);
                        try {
                            zzi3.zzh().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                        } catch (SQLiteException e14) {
                            zzi3.zzt.zzay().zzd().zzb("Error clearing complex main event", e14);
                        }
                    } else {
                        this.zza.zzf.zzi().zzJ(str, l10, this.zzd, this.zzb);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.google.android.gms.internal.measurement.zzfx zzfxVar : this.zzb.zzi()) {
                        this.zza.zzf.zzu();
                        if (zzkv.zzB(zzftVar, zzfxVar.zzg()) == null) {
                            arrayList.add(zzfxVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        this.zza.zzt.zzay().zzh().zzb("No unique parameters in main event. eventName", zzh);
                    } else {
                        arrayList.addAll(zzi);
                        zzi = arrayList;
                    }
                } else {
                    zzi2.zzt.zzay().zzj().zza("Main event not found");
                }
                cursor.close();
                pair = null;
                if (pair != null) {
                }
                this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", zzh, l10);
                return null;
            }
            this.zzc = l10;
            this.zzb = zzftVar;
            this.zza.zzf.zzu();
            Object zzC = zzkv.zzC(zzftVar, "_epc");
            long longValue2 = ((Long) (zzC != null ? zzC : 0L)).longValue();
            this.zzd = longValue2;
            if (longValue2 <= 0) {
                this.zza.zzt.zzay().zzh().zzb("Complex event with zero extra param count. eventName", zzh);
            } else {
                this.zza.zzf.zzi().zzJ(str, (Long) Preconditions.checkNotNull(l10), this.zzd, zzftVar);
            }
        }
        com.google.android.gms.internal.measurement.zzfs zzfsVar = (com.google.android.gms.internal.measurement.zzfs) zzftVar.zzby();
        zzfsVar.zzi(zzh);
        zzfsVar.zzg();
        zzfsVar.zzd(zzi);
        return (com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC();
    }
}
