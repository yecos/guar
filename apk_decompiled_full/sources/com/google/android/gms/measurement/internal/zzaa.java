package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzoc;
import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class zzaa extends zzkh {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzkt zzktVar) {
        super(zzktVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i10, int i11) {
        BitSet bitSet;
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i10));
        if (zzuVar == null) {
            return false;
        }
        bitSet = zzuVar.zze;
        return bitSet.get(i11);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(6:19|20|21|22|23|(19:(7:25|26|27|28|(1:30)(3:505|(1:507)(1:509)|508)|31|(1:34)(1:33))|35|36|37|38|39|40|(2:42|43)(3:471|(6:472|473|474|475|476|(1:479)(1:478))|480)|44|(1:46)(6:281|(11:283|284|285|286|287|(1:(3:289|(1:291)|292))(1:457)|295|296|(3:391|(6:394|(1:453)(2:398|(4:404|405|(7:407|(4:410|(2:412|413)(1:415)|414|408)|416|417|(4:420|(3:422|423|424)(1:426)|425|418)|427|428)(6:432|(4:435|(2:437|438)(1:440)|439|433)|441|442|(4:445|(2:447|448)(1:450)|449|443)|451)|429)(4:400|401|402|403))|430|431|403|392)|455)|298|299)(1:470)|300|(10:303|(3:307|(4:310|(5:312|313|(1:315)(1:319)|316|317)(1:320)|318|308)|321)|322|(3:326|(4:329|(3:334|335|336)|337|327)|340)|341|(3:343|(6:346|(2:348|(3:350|351|352))(1:355)|353|354|352|344)|356)|357|(3:366|(8:369|(1:371)|372|(1:374)|375|(3:377|378|379)(1:381)|380|367)|382)|383|301)|389|390)|47|(3:169|(4:172|(10:174|175|(1:177)(1:278)|178|(13:180|181|182|183|184|185|186|187|188|189|190|(3:192|(11:193|194|195|196|197|198|199|(3:201|202|203)(1:251)|204|205|(1:208)(1:207))|209)(3:257|258|259)|210)(1:277)|211|(4:214|(3:232|233|234)(4:216|217|(2:218|(2:220|(1:222)(2:223|224))(1:231))|(3:226|227|228)(1:230))|229|212)|235|236|237)(1:279)|238|170)|280)|49|50|(3:52|(6:55|(6:57|58|59|60|61|(3:(9:63|64|65|66|67|68|(1:70)|71|72)|75|76)(4:128|129|124|76))(1:144)|77|(2:78|(2:80|(3:114|115|116)(8:82|(2:83|(4:85|(3:87|(1:89)(1:91)|90)|92|(1:1)(2:96|(1:98)(2:99|100)))(1:113))|107|(1:109)(1:111)|110|102|103|104))(0))|117|53)|145)|146|(9:149|150|151|152|153|154|(2:156|157)(1:159)|158|147)|167|168)(2:513|514))|39|40|(0)(0)|44|(0)(0)|47|(0)|49|50|(0)|146|(1:147)|167|168) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:0|1|(2:2|(2:4|(2:6|7)(1:528))(2:529|530))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(19:(7:25|26|27|28|(1:30)(3:505|(1:507)(1:509)|508)|31|(1:34)(1:33))|35|36|37|38|39|40|(2:42|43)(3:471|(6:472|473|474|475|476|(1:479)(1:478))|480)|44|(1:46)(6:281|(11:283|284|285|286|287|(1:(3:289|(1:291)|292))(1:457)|295|296|(3:391|(6:394|(1:453)(2:398|(4:404|405|(7:407|(4:410|(2:412|413)(1:415)|414|408)|416|417|(4:420|(3:422|423|424)(1:426)|425|418)|427|428)(6:432|(4:435|(2:437|438)(1:440)|439|433)|441|442|(4:445|(2:447|448)(1:450)|449|443)|451)|429)(4:400|401|402|403))|430|431|403|392)|455)|298|299)(1:470)|300|(10:303|(3:307|(4:310|(5:312|313|(1:315)(1:319)|316|317)(1:320)|318|308)|321)|322|(3:326|(4:329|(3:334|335|336)|337|327)|340)|341|(3:343|(6:346|(2:348|(3:350|351|352))(1:355)|353|354|352|344)|356)|357|(3:366|(8:369|(1:371)|372|(1:374)|375|(3:377|378|379)(1:381)|380|367)|382)|383|301)|389|390)|47|(3:169|(4:172|(10:174|175|(1:177)(1:278)|178|(13:180|181|182|183|184|185|186|187|188|189|190|(3:192|(11:193|194|195|196|197|198|199|(3:201|202|203)(1:251)|204|205|(1:208)(1:207))|209)(3:257|258|259)|210)(1:277)|211|(4:214|(3:232|233|234)(4:216|217|(2:218|(2:220|(1:222)(2:223|224))(1:231))|(3:226|227|228)(1:230))|229|212)|235|236|237)(1:279)|238|170)|280)|49|50|(3:52|(6:55|(6:57|58|59|60|61|(3:(9:63|64|65|66|67|68|(1:70)|71|72)|75|76)(4:128|129|124|76))(1:144)|77|(2:78|(2:80|(3:114|115|116)(8:82|(2:83|(4:85|(3:87|(1:89)(1:91)|90)|92|(1:1)(2:96|(1:98)(2:99|100)))(1:113))|107|(1:109)(1:111)|110|102|103|104))(0))|117|53)|145)|146|(9:149|150|151|152|153|154|(2:156|157)(1:159)|158|147)|167|168)(2:513|514))|527|36|37|38|39|40|(0)(0)|44|(0)(0)|47|(0)|49|50|(0)|146|(1:147)|167|168|(4:(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0a58, code lost:
    
        if (r8 != false) goto L478;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0939, code lost:
    
        if (r9 == null) goto L358;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x02de, code lost:
    
        if (r5 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x021c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x021d, code lost:
    
        r20 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x0224, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0225, code lost:
    
        r20 = "audience_id";
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0220, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x0221, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0174, code lost:
    
        if (r5 == null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b5 A[Catch: SQLiteException -> 0x021c, all -> 0x0b14, TRY_LEAVE, TryCatch #8 {SQLiteException -> 0x021c, blocks: (B:40:0x01af, B:42:0x01b5, B:471:0x01c1, B:472:0x01c6, B:474:0x01d0, B:475:0x01e0, B:489:0x01ed), top: B:39:0x01af }] */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x01c1 A[Catch: SQLiteException -> 0x021c, all -> 0x0b14, TRY_ENTER, TryCatch #8 {SQLiteException -> 0x021c, blocks: (B:40:0x01af, B:42:0x01b5, B:471:0x01c1, B:472:0x01c6, B:474:0x01d0, B:475:0x01e0, B:489:0x01ed), top: B:39:0x01af }] */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x085c  */
    /* JADX WARN: Type inference failed for: r0v197, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v29, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v63, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza(String str, List list, List list2, Long l10, Long l11) {
        int i10;
        int i11;
        boolean z10;
        Cursor cursor;
        Map map;
        String str2;
        Cursor cursor2;
        Map map2;
        String str3;
        Map map3;
        String str4;
        String str5;
        String str6;
        List<com.google.android.gms.internal.measurement.zzek> list3;
        String str7;
        Cursor cursor3;
        Map map4;
        Iterator it;
        String str8;
        zzas zzasVar;
        zzw zzwVar;
        Iterator it2;
        zzas zzasVar2;
        String str9;
        Iterator it3;
        Cursor cursor4;
        List list4;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzet zzetVar;
        Cursor cursor5;
        Cursor cursor6;
        androidx.collection.a aVar;
        Cursor cursor7;
        List list5;
        String str10 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new androidx.collection.a();
        this.zzd = l10;
        this.zze = l11;
        Iterator it5 = list.iterator();
        while (true) {
            i10 = 0;
            i11 = 1;
            if (!it5.hasNext()) {
                z10 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzft) it5.next()).zzh())) {
                z10 = true;
                break;
            }
        }
        zznz.zzc();
        boolean zzs = this.zzt.zzf().zzs(this.zza, zzdu.zzW);
        zznz.zzc();
        boolean zzs2 = this.zzt.zzf().zzs(this.zza, zzdu.zzV);
        if (z10) {
            zzam zzi = this.zzf.zzi();
            String str11 = this.zza;
            zzi.zzW();
            zzi.zzg();
            Preconditions.checkNotEmpty(str11);
            ?? contentValues = new ContentValues();
            int i12 = 0;
            contentValues.put("current_session_count", 0);
            try {
                i12 = new String[]{str11};
                zzi.zzh().update(f.ax, contentValues, "app_id = ?", i12);
                cursor = i12;
            } catch (SQLiteException e10) {
                zzi.zzt.zzay().zzd().zzc("Error resetting session-scoped event counts. appId", zzeh.zzn(str11), e10);
                cursor = i12;
            }
        }
        Map emptyMap = Collections.emptyMap();
        String str12 = "Failed to merge filter. appId";
        String str13 = "Database error querying filters. appId";
        String str14 = "audience_id";
        try {
            if (zzs2 && zzs) {
                zzam zzi2 = this.zzf.zzi();
                String str15 = this.zza;
                Preconditions.checkNotEmpty(str15);
                androidx.collection.a aVar2 = new androidx.collection.a();
                try {
                    try {
                        cursor7 = zzi2.zzh().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str15}, null, null, null);
                        try {
                        } catch (SQLiteException e11) {
                            e = e11;
                            zzi2.zzt.zzay().zzd().zzc("Database error querying filters. appId", zzeh.zzn(str15), e);
                            emptyMap = Collections.emptyMap();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    cursor7 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    throw th;
                }
                if (cursor7.moveToFirst()) {
                    while (true) {
                        try {
                            com.google.android.gms.internal.measurement.zzek zzekVar = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), cursor7.getBlob(i11))).zzaC();
                            if (zzekVar.zzo()) {
                                Integer valueOf = Integer.valueOf(cursor7.getInt(i10));
                                List list6 = (List) aVar2.get(valueOf);
                                if (list6 == null) {
                                    list5 = new ArrayList();
                                    aVar2.put(valueOf, list5);
                                } else {
                                    list5 = list6;
                                }
                                list5.add(zzekVar);
                            }
                        } catch (IOException e13) {
                            zzi2.zzt.zzay().zzd().zzc("Failed to merge filter. appId", zzeh.zzn(str15), e13);
                        }
                        if (!cursor7.moveToNext()) {
                            break;
                        }
                        i10 = 0;
                        i11 = 1;
                    }
                    cursor7.close();
                    map = aVar2;
                    zzam zzi3 = this.zzf.zzi();
                    String str16 = this.zza;
                    zzi3.zzW();
                    zzi3.zzg();
                    Preconditions.checkNotEmpty(str16);
                    cursor2 = zzi3.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str16}, null, null, null);
                    if (cursor2.moveToFirst()) {
                        Map emptyMap2 = Collections.emptyMap();
                        cursor2.close();
                        map2 = emptyMap2;
                        str2 = "audience_id";
                    } else {
                        androidx.collection.a aVar3 = new androidx.collection.a();
                        while (true) {
                            int i13 = cursor2.getInt(0);
                            try {
                                aVar3.put(Integer.valueOf(i13), (com.google.android.gms.internal.measurement.zzgi) ((com.google.android.gms.internal.measurement.zzgh) zzkv.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursor2.getBlob(1))).zzaC());
                                aVar = aVar3;
                                str2 = str14;
                            } catch (IOException e14) {
                                aVar = aVar3;
                                str2 = str14;
                                try {
                                    zzi3.zzt.zzay().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzeh.zzn(str16), Integer.valueOf(i13), e14);
                                } catch (SQLiteException e15) {
                                    e = e15;
                                    zzi3.zzt.zzay().zzd().zzc("Database error querying filter results. appId", zzeh.zzn(str16), e);
                                    Map emptyMap3 = Collections.emptyMap();
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    map2 = emptyMap3;
                                    if (map2.isEmpty()) {
                                    }
                                    if (!list.isEmpty()) {
                                    }
                                    String str17 = str10;
                                    if (!list2.isEmpty()) {
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    Set keySet = this.zzc.keySet();
                                    keySet.removeAll(this.zzb);
                                    it4 = keySet.iterator();
                                    while (it4.hasNext()) {
                                    }
                                    return arrayList;
                                }
                            }
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            aVar3 = aVar;
                            str14 = str2;
                        }
                        cursor2.close();
                        map2 = aVar;
                    }
                    if (map2.isEmpty()) {
                        str6 = "Database error querying filters. appId";
                        str4 = "Failed to merge filter. appId";
                        str5 = str2;
                    } else {
                        HashSet hashSet = new HashSet(map2.keySet());
                        if (z10) {
                            String str18 = this.zza;
                            zzam zzi4 = this.zzf.zzi();
                            String str19 = this.zza;
                            zzi4.zzW();
                            zzi4.zzg();
                            Preconditions.checkNotEmpty(str19);
                            Map aVar4 = new androidx.collection.a();
                            ?? zzh = zzi4.zzh();
                            try {
                                try {
                                    cursor3 = zzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str19, str19});
                                    try {
                                        if (cursor3.moveToFirst()) {
                                            do {
                                                Integer valueOf2 = Integer.valueOf(cursor3.getInt(0));
                                                List list7 = (List) aVar4.get(valueOf2);
                                                if (list7 == null) {
                                                    list7 = new ArrayList();
                                                    aVar4.put(valueOf2, list7);
                                                }
                                                list7.add(Integer.valueOf(cursor3.getInt(1)));
                                            } while (cursor3.moveToNext());
                                        } else {
                                            aVar4 = Collections.emptyMap();
                                        }
                                    } catch (SQLiteException e16) {
                                        e = e16;
                                        zzi4.zzt.zzay().zzd().zzc("Database error querying scoped filters. appId", zzeh.zzn(str19), e);
                                        aVar4 = Collections.emptyMap();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (zzh != 0) {
                                        zzh.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e17) {
                                e = e17;
                                cursor3 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                zzh = 0;
                                if (zzh != 0) {
                                }
                                throw th;
                            }
                            cursor3.close();
                            Preconditions.checkNotEmpty(str18);
                            Preconditions.checkNotNull(map2);
                            androidx.collection.a aVar5 = new androidx.collection.a();
                            if (!map2.isEmpty()) {
                                Iterator it6 = map2.keySet().iterator();
                                while (it6.hasNext()) {
                                    int intValue = ((Integer) it6.next()).intValue();
                                    Integer valueOf3 = Integer.valueOf(intValue);
                                    com.google.android.gms.internal.measurement.zzgi zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map2.get(valueOf3);
                                    List list8 = (List) aVar4.get(valueOf3);
                                    if (list8 == null || list8.isEmpty()) {
                                        map4 = aVar4;
                                        it = it6;
                                        str8 = str13;
                                        aVar5.put(valueOf3, zzgiVar);
                                    } else {
                                        map4 = aVar4;
                                        List zzq = this.zzf.zzu().zzq(zzgiVar.zzk(), list8);
                                        if (zzq.isEmpty()) {
                                            aVar4 = map4;
                                        } else {
                                            com.google.android.gms.internal.measurement.zzgh zzghVar = (com.google.android.gms.internal.measurement.zzgh) zzgiVar.zzby();
                                            zzghVar.zzf();
                                            zzghVar.zzb(zzq);
                                            it = it6;
                                            List zzq2 = this.zzf.zzu().zzq(zzgiVar.zzn(), list8);
                                            zzghVar.zzh();
                                            zzghVar.zzd(zzq2);
                                            zzoc.zzc();
                                            str8 = str13;
                                            if (this.zzt.zzf().zzs(null, zzdu.zzas)) {
                                                ArrayList arrayList2 = new ArrayList();
                                                Iterator it7 = zzgiVar.zzj().iterator();
                                                while (it7.hasNext()) {
                                                    com.google.android.gms.internal.measurement.zzfr zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it7.next();
                                                    Iterator it8 = it7;
                                                    if (!list8.contains(Integer.valueOf(zzfrVar.zza()))) {
                                                        arrayList2.add(zzfrVar);
                                                    }
                                                    it7 = it8;
                                                }
                                                zzghVar.zze();
                                                zzghVar.zza(arrayList2);
                                                ArrayList arrayList3 = new ArrayList();
                                                for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzm()) {
                                                    if (!list8.contains(Integer.valueOf(zzgkVar.zzb()))) {
                                                        arrayList3.add(zzgkVar);
                                                    }
                                                }
                                                zzghVar.zzg();
                                                zzghVar.zzc(arrayList3);
                                            } else {
                                                for (int i14 = 0; i14 < zzgiVar.zza(); i14++) {
                                                    if (list8.contains(Integer.valueOf(zzgiVar.zze(i14).zza()))) {
                                                        zzghVar.zzi(i14);
                                                    }
                                                }
                                                for (int i15 = 0; i15 < zzgiVar.zzc(); i15++) {
                                                    if (list8.contains(Integer.valueOf(zzgiVar.zzi(i15).zzb()))) {
                                                        zzghVar.zzj(i15);
                                                    }
                                                }
                                            }
                                            aVar5.put(Integer.valueOf(intValue), (com.google.android.gms.internal.measurement.zzgi) zzghVar.zzaC());
                                        }
                                    }
                                    aVar4 = map4;
                                    it6 = it;
                                    str13 = str8;
                                }
                            }
                            str3 = str13;
                            map3 = aVar5;
                        } else {
                            str3 = "Database error querying filters. appId";
                            map3 = map2;
                        }
                        Iterator it9 = hashSet.iterator();
                        while (it9.hasNext()) {
                            int intValue2 = ((Integer) it9.next()).intValue();
                            com.google.android.gms.internal.measurement.zzgi zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(intValue2));
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            androidx.collection.a aVar6 = new androidx.collection.a();
                            if (zzgiVar2 != null && zzgiVar2.zza() != 0) {
                                for (com.google.android.gms.internal.measurement.zzfr zzfrVar2 : zzgiVar2.zzj()) {
                                    if (zzfrVar2.zzh()) {
                                        aVar6.put(Integer.valueOf(zzfrVar2.zza()), zzfrVar2.zzg() ? Long.valueOf(zzfrVar2.zzb()) : null);
                                    }
                                }
                            }
                            androidx.collection.a aVar7 = new androidx.collection.a();
                            if (zzgiVar2 != null && zzgiVar2.zzc() != 0) {
                                for (com.google.android.gms.internal.measurement.zzgk zzgkVar2 : zzgiVar2.zzm()) {
                                    if (zzgkVar2.zzi() && zzgkVar2.zza() > 0) {
                                        aVar7.put(Integer.valueOf(zzgkVar2.zzb()), Long.valueOf(zzgkVar2.zzc(zzgkVar2.zza() - 1)));
                                        map3 = map3;
                                    }
                                }
                            }
                            Map map5 = map3;
                            if (zzgiVar2 != null) {
                                int i16 = 0;
                                while (i16 < zzgiVar2.zzd() * 64) {
                                    if (zzkv.zzv(zzgiVar2.zzn(), i16)) {
                                        str7 = str12;
                                        this.zzt.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i16));
                                        bitSet2.set(i16);
                                        if (zzkv.zzv(zzgiVar2.zzk(), i16)) {
                                            bitSet.set(i16);
                                            i16++;
                                            str12 = str7;
                                        }
                                    } else {
                                        str7 = str12;
                                    }
                                    aVar6.remove(Integer.valueOf(i16));
                                    i16++;
                                    str12 = str7;
                                }
                            }
                            String str20 = str12;
                            Integer valueOf4 = Integer.valueOf(intValue2);
                            com.google.android.gms.internal.measurement.zzgi zzgiVar3 = (com.google.android.gms.internal.measurement.zzgi) map2.get(valueOf4);
                            if (zzs2 && zzs && (list3 = (List) map.get(valueOf4)) != null && this.zze != null && this.zzd != null) {
                                for (com.google.android.gms.internal.measurement.zzek zzekVar2 : list3) {
                                    int zzb = zzekVar2.zzb();
                                    long longValue = this.zze.longValue() / 1000;
                                    if (zzekVar2.zzm()) {
                                        longValue = this.zzd.longValue() / 1000;
                                    }
                                    Integer valueOf5 = Integer.valueOf(zzb);
                                    if (aVar6.containsKey(valueOf5)) {
                                        aVar6.put(valueOf5, Long.valueOf(longValue));
                                    }
                                    if (aVar7.containsKey(valueOf5)) {
                                        aVar7.put(valueOf5, Long.valueOf(longValue));
                                    }
                                }
                            }
                            this.zzc.put(Integer.valueOf(intValue2), new zzu(this, this.zza, zzgiVar3, bitSet, bitSet2, aVar6, aVar7, null));
                            str12 = str20;
                            map = map;
                            map3 = map5;
                            map2 = map2;
                        }
                        str4 = str12;
                        str5 = str2;
                        str6 = str3;
                    }
                    if (!list.isEmpty()) {
                        zzw zzwVar2 = new zzw(this, null);
                        androidx.collection.a aVar8 = new androidx.collection.a();
                        Iterator it10 = list.iterator();
                        while (it10.hasNext()) {
                            com.google.android.gms.internal.measurement.zzft zzftVar = (com.google.android.gms.internal.measurement.zzft) it10.next();
                            com.google.android.gms.internal.measurement.zzft zza = zzwVar2.zza(this.zza, zzftVar);
                            if (zza != null) {
                                zzam zzi5 = this.zzf.zzi();
                                String str21 = this.zza;
                                String zzh2 = zza.zzh();
                                zzas zzn = zzi5.zzn(str21, zzftVar.zzh());
                                if (zzn == null) {
                                    zzi5.zzt.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeh.zzn(str21), zzi5.zzt.zzj().zzd(zzh2));
                                    zzasVar = new zzas(str21, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                } else {
                                    zzasVar = new zzas(zzn.zza, zzn.zzb, zzn.zzc + 1, zzn.zzd + 1, zzn.zze + 1, zzn.zzf, zzn.zzg, zzn.zzh, zzn.zzi, zzn.zzj, zzn.zzk);
                                }
                                this.zzf.zzi().zzE(zzasVar);
                                long j10 = zzasVar.zzc;
                                String zzh3 = zza.zzh();
                                Map map6 = (Map) aVar8.get(zzh3);
                                if (map6 == null) {
                                    zzam zzi6 = this.zzf.zzi();
                                    String str22 = this.zza;
                                    zzi6.zzW();
                                    zzi6.zzg();
                                    Preconditions.checkNotEmpty(str22);
                                    Preconditions.checkNotEmpty(zzh3);
                                    zzwVar = zzwVar2;
                                    androidx.collection.a aVar9 = new androidx.collection.a();
                                    SQLiteDatabase zzh4 = zzi6.zzh();
                                    it2 = it10;
                                    try {
                                        try {
                                            String[] strArr = new String[2];
                                            String str23 = str5;
                                            try {
                                                strArr[0] = str23;
                                                strArr[1] = "data";
                                                str9 = str10;
                                            } catch (SQLiteException e18) {
                                                e = e18;
                                                str5 = str23;
                                                zzasVar2 = zzasVar;
                                                str9 = str10;
                                                cursor4 = null;
                                                try {
                                                    zzi6.zzt.zzay().zzd().zzc(str6, zzeh.zzn(str22), e);
                                                    map6 = Collections.emptyMap();
                                                    if (cursor4 != null) {
                                                    }
                                                    aVar8.put(zzh3, map6);
                                                    it3 = map6.keySet().iterator();
                                                    while (it3.hasNext()) {
                                                    }
                                                    zzwVar2 = zzwVar;
                                                    it10 = it2;
                                                    str10 = str9;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    if (cursor4 != null) {
                                                        cursor4.close();
                                                    }
                                                    throw th;
                                                }
                                            }
                                            try {
                                                Cursor query = zzh4.query("event_filters", strArr, "app_id=? AND event_name=?", new String[]{str22, zzh3}, null, null, null);
                                                try {
                                                    try {
                                                        if (query.moveToFirst()) {
                                                            str5 = str23;
                                                            while (true) {
                                                                try {
                                                                    try {
                                                                        com.google.android.gms.internal.measurement.zzek zzekVar3 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), query.getBlob(1))).zzaC();
                                                                        Integer valueOf6 = Integer.valueOf(query.getInt(0));
                                                                        List list9 = (List) aVar9.get(valueOf6);
                                                                        if (list9 == null) {
                                                                            zzasVar2 = zzasVar;
                                                                            try {
                                                                                list4 = new ArrayList();
                                                                                aVar9.put(valueOf6, list4);
                                                                            } catch (SQLiteException e19) {
                                                                                e = e19;
                                                                                cursor4 = query;
                                                                                zzi6.zzt.zzay().zzd().zzc(str6, zzeh.zzn(str22), e);
                                                                                map6 = Collections.emptyMap();
                                                                                if (cursor4 != null) {
                                                                                }
                                                                                aVar8.put(zzh3, map6);
                                                                                it3 = map6.keySet().iterator();
                                                                                while (it3.hasNext()) {
                                                                                }
                                                                                zzwVar2 = zzwVar;
                                                                                it10 = it2;
                                                                                str10 = str9;
                                                                            }
                                                                        } else {
                                                                            zzasVar2 = zzasVar;
                                                                            list4 = list9;
                                                                        }
                                                                        list4.add(zzekVar3);
                                                                    } catch (IOException e20) {
                                                                        zzasVar2 = zzasVar;
                                                                        zzi6.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str22), e20);
                                                                    }
                                                                    if (!query.moveToNext()) {
                                                                        break;
                                                                    }
                                                                    zzasVar = zzasVar2;
                                                                } catch (SQLiteException e21) {
                                                                    e = e21;
                                                                    zzasVar2 = zzasVar;
                                                                    cursor4 = query;
                                                                    zzi6.zzt.zzay().zzd().zzc(str6, zzeh.zzn(str22), e);
                                                                    map6 = Collections.emptyMap();
                                                                    if (cursor4 != null) {
                                                                        cursor4.close();
                                                                    }
                                                                    aVar8.put(zzh3, map6);
                                                                    it3 = map6.keySet().iterator();
                                                                    while (it3.hasNext()) {
                                                                    }
                                                                    zzwVar2 = zzwVar;
                                                                    it10 = it2;
                                                                    str10 = str9;
                                                                }
                                                            }
                                                            query.close();
                                                            map6 = aVar9;
                                                        } else {
                                                            str5 = str23;
                                                            zzasVar2 = zzasVar;
                                                            map6 = Collections.emptyMap();
                                                            query.close();
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        cursor4 = query;
                                                        if (cursor4 != null) {
                                                        }
                                                        throw th;
                                                    }
                                                } catch (SQLiteException e22) {
                                                    e = e22;
                                                    str5 = str23;
                                                }
                                            } catch (SQLiteException e23) {
                                                e = e23;
                                                str5 = str23;
                                                zzasVar2 = zzasVar;
                                                cursor4 = null;
                                                zzi6.zzt.zzay().zzd().zzc(str6, zzeh.zzn(str22), e);
                                                map6 = Collections.emptyMap();
                                                if (cursor4 != null) {
                                                }
                                                aVar8.put(zzh3, map6);
                                                it3 = map6.keySet().iterator();
                                                while (it3.hasNext()) {
                                                }
                                                zzwVar2 = zzwVar;
                                                it10 = it2;
                                                str10 = str9;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            cursor4 = null;
                                        }
                                    } catch (SQLiteException e24) {
                                        e = e24;
                                    }
                                    aVar8.put(zzh3, map6);
                                } else {
                                    zzwVar = zzwVar2;
                                    it2 = it10;
                                    zzasVar2 = zzasVar;
                                    str9 = str10;
                                }
                                it3 = map6.keySet().iterator();
                                while (it3.hasNext()) {
                                    int intValue3 = ((Integer) it3.next()).intValue();
                                    Set set = this.zzb;
                                    Integer valueOf7 = Integer.valueOf(intValue3);
                                    if (set.contains(valueOf7)) {
                                        this.zzt.zzay().zzj().zzb("Skipping failed audience ID", valueOf7);
                                    } else {
                                        Iterator it11 = ((List) map6.get(valueOf7)).iterator();
                                        boolean z11 = true;
                                        while (true) {
                                            if (!it11.hasNext()) {
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzek zzekVar4 = (com.google.android.gms.internal.measurement.zzek) it11.next();
                                            zzx zzxVar = new zzx(this, this.zza, intValue3, zzekVar4);
                                            z11 = zzxVar.zzd(this.zzd, this.zze, zza, j10, zzasVar2, zzf(intValue3, zzekVar4.zzb()));
                                            if (!z11) {
                                                this.zzb.add(Integer.valueOf(intValue3));
                                                break;
                                            }
                                            zzd(Integer.valueOf(intValue3)).zzc(zzxVar);
                                        }
                                        if (!z11) {
                                            this.zzb.add(Integer.valueOf(intValue3));
                                        }
                                    }
                                }
                                zzwVar2 = zzwVar;
                                it10 = it2;
                                str10 = str9;
                            }
                        }
                    }
                    String str172 = str10;
                    if (!list2.isEmpty()) {
                        androidx.collection.a aVar10 = new androidx.collection.a();
                        Iterator it12 = list2.iterator();
                        while (it12.hasNext()) {
                            com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) it12.next();
                            String zzf = zzgmVar.zzf();
                            Map map7 = (Map) aVar10.get(zzf);
                            if (map7 == null) {
                                zzam zzi7 = this.zzf.zzi();
                                String str24 = this.zza;
                                zzi7.zzW();
                                zzi7.zzg();
                                Preconditions.checkNotEmpty(str24);
                                Preconditions.checkNotEmpty(zzf);
                                androidx.collection.a aVar11 = new androidx.collection.a();
                                try {
                                    cursor6 = zzi7.zzh().query("property_filters", new String[]{str5, "data"}, "app_id=? AND property_name=?", new String[]{str24, zzf}, null, null, null);
                                    try {
                                        try {
                                        } catch (SQLiteException e25) {
                                            e = e25;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        cursor5 = cursor6;
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e26) {
                                    e = e26;
                                    cursor6 = null;
                                } catch (Throwable th9) {
                                    th = th9;
                                    cursor5 = null;
                                }
                                if (cursor6.moveToFirst()) {
                                    do {
                                        try {
                                            com.google.android.gms.internal.measurement.zzet zzetVar2 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzkv.zzl(com.google.android.gms.internal.measurement.zzet.zzc(), cursor6.getBlob(1))).zzaC();
                                            try {
                                                Integer valueOf8 = Integer.valueOf(cursor6.getInt(0));
                                                List list10 = (List) aVar11.get(valueOf8);
                                                if (list10 == null) {
                                                    list10 = new ArrayList();
                                                    aVar11.put(valueOf8, list10);
                                                }
                                                list10.add(zzetVar2);
                                            } catch (SQLiteException e27) {
                                                e = e27;
                                                zzi7.zzt.zzay().zzd().zzc(str6, zzeh.zzn(str24), e);
                                                map7 = Collections.emptyMap();
                                            }
                                        } catch (IOException e28) {
                                            zzi7.zzt.zzay().zzd().zzc("Failed to merge filter", zzeh.zzn(str24), e28);
                                        }
                                    } while (cursor6.moveToNext());
                                    cursor6.close();
                                    map7 = aVar11;
                                    aVar10.put(zzf, map7);
                                } else {
                                    map7 = Collections.emptyMap();
                                    cursor6.close();
                                    aVar10.put(zzf, map7);
                                }
                            }
                            Iterator it13 = map7.keySet().iterator();
                            while (true) {
                                if (it13.hasNext()) {
                                    int intValue4 = ((Integer) it13.next()).intValue();
                                    Set set2 = this.zzb;
                                    Integer valueOf9 = Integer.valueOf(intValue4);
                                    if (set2.contains(valueOf9)) {
                                        this.zzt.zzay().zzj().zzb("Skipping failed audience ID", valueOf9);
                                        break;
                                    }
                                    Iterator it14 = ((List) map7.get(valueOf9)).iterator();
                                    boolean z12 = true;
                                    while (true) {
                                        if (!it14.hasNext()) {
                                            break;
                                        }
                                        zzetVar = (com.google.android.gms.internal.measurement.zzet) it14.next();
                                        if (Log.isLoggable(this.zzt.zzay().zzq(), 2)) {
                                            this.zzt.zzay().zzj().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), zzetVar.zzj() ? Integer.valueOf(zzetVar.zza()) : null, this.zzt.zzj().zzf(zzetVar.zze()));
                                            this.zzt.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzetVar));
                                        }
                                        if (!zzetVar.zzj() || zzetVar.zza() > 256) {
                                            break;
                                        }
                                        zzz zzzVar = new zzz(this, this.zza, intValue4, zzetVar);
                                        z12 = zzzVar.zzd(this.zzd, this.zze, zzgmVar, zzf(intValue4, zzetVar.zza()));
                                        if (!z12) {
                                            this.zzb.add(Integer.valueOf(intValue4));
                                            break;
                                        }
                                        zzd(Integer.valueOf(intValue4)).zzc(zzzVar);
                                    }
                                    this.zzt.zzay().zzk().zzc("Invalid property filter ID. appId, id", zzeh.zzn(this.zza), String.valueOf(zzetVar.zzj() ? Integer.valueOf(zzetVar.zza()) : null));
                                    this.zzb.add(Integer.valueOf(intValue4));
                                }
                            }
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Set keySet2 = this.zzc.keySet();
                    keySet2.removeAll(this.zzb);
                    it4 = keySet2.iterator();
                    while (it4.hasNext()) {
                        int intValue5 = ((Integer) it4.next()).intValue();
                        Map map8 = this.zzc;
                        Integer valueOf10 = Integer.valueOf(intValue5);
                        zzu zzuVar = (zzu) map8.get(valueOf10);
                        Preconditions.checkNotNull(zzuVar);
                        com.google.android.gms.internal.measurement.zzfp zza2 = zzuVar.zza(intValue5);
                        arrayList4.add(zza2);
                        zzam zzi8 = this.zzf.zzi();
                        String str25 = this.zza;
                        com.google.android.gms.internal.measurement.zzgi zzd = zza2.zzd();
                        zzi8.zzW();
                        zzi8.zzg();
                        Preconditions.checkNotEmpty(str25);
                        Preconditions.checkNotNull(zzd);
                        byte[] zzbu = zzd.zzbu();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str25);
                        String str26 = str5;
                        contentValues2.put(str26, valueOf10);
                        String str27 = str172;
                        contentValues2.put(str27, zzbu);
                        try {
                        } catch (SQLiteException e29) {
                            e = e29;
                        }
                        try {
                            if (zzi8.zzh().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                zzi8.zzt.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeh.zzn(str25));
                            }
                        } catch (SQLiteException e30) {
                            e = e30;
                            zzi8.zzt.zzay().zzd().zzc("Error storing filter results. appId", zzeh.zzn(str25), e);
                            str172 = str27;
                            str5 = str26;
                        }
                        str172 = str27;
                        str5 = str26;
                    }
                    return arrayList4;
                }
                emptyMap = Collections.emptyMap();
                cursor7.close();
            }
            if (cursor2.moveToFirst()) {
            }
            if (map2.isEmpty()) {
            }
            if (!list.isEmpty()) {
            }
            String str1722 = str10;
            if (!list2.isEmpty()) {
            }
            ArrayList arrayList42 = new ArrayList();
            Set keySet22 = this.zzc.keySet();
            keySet22.removeAll(this.zzb);
            it4 = keySet22.iterator();
            while (it4.hasNext()) {
            }
            return arrayList42;
        } catch (Throwable th10) {
            th = th10;
            Cursor cursor8 = cursor2;
            if (cursor8 != null) {
                cursor8.close();
            }
            throw th;
        }
        map = emptyMap;
        zzam zzi32 = this.zzf.zzi();
        String str162 = this.zza;
        zzi32.zzW();
        zzi32.zzg();
        Preconditions.checkNotEmpty(str162);
        cursor2 = zzi32.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str162}, null, null, null);
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final boolean zzb() {
        return false;
    }
}
