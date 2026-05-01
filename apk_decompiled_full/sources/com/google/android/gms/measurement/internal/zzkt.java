package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import anet.channel.entity.ConnType;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.export.CrashStatKey;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.f;
import com.umeng.umcrash.UMCrash;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public final class zzkt implements zzgm {
    private static volatile zzkt zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzie zzD;
    private String zzE;

    @VisibleForTesting
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private zzam zze;
    private zzep zzf;
    private zzkf zzg;
    private zzaa zzh;
    private final zzkv zzi;
    private zzic zzj;
    private zzjo zzk;
    private final zzki zzl;
    private zzez zzm;
    private final zzfr zzn;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;
    private boolean zzo = false;
    private final zzla zzF = new zzko(this);

    public zzkt(zzku zzkuVar, zzfr zzfrVar) {
        Preconditions.checkNotNull(zzkuVar);
        this.zzn = zzfr.zzp(zzkuVar.zza, null, null);
        this.zzA = -1L;
        this.zzl = new zzki(this);
        zzkv zzkvVar = new zzkv(this);
        zzkvVar.zzX();
        this.zzi = zzkvVar;
        zzen zzenVar = new zzen(this);
        zzenVar.zzX();
        this.zzd = zzenVar;
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzX();
        this.zzc = zzfiVar;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkj(this, zzkuVar));
    }

    @VisibleForTesting
    public static final void zzaa(com.google.android.gms.internal.measurement.zzfs zzfsVar, int i10, String str) {
        List zzp = zzfsVar.zzp();
        for (int i11 = 0; i11 < zzp.size(); i11++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(i11)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zze = com.google.android.gms.internal.measurement.zzfx.zze();
        zze.zzj("_err");
        zze.zzi(Long.valueOf(i10).longValue());
        com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) zze.zzaC();
        com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        com.google.android.gms.internal.measurement.zzfx zzfxVar2 = (com.google.android.gms.internal.measurement.zzfx) zze2.zzaC();
        zzfsVar.zzf(zzfxVar);
        zzfsVar.zzf(zzfxVar2);
    }

    @VisibleForTesting
    public static final void zzab(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str) {
        List zzp = zzfsVar.zzp();
        for (int i10 = 0; i10 < zzp.size(); i10++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(i10)).zzg())) {
                zzfsVar.zzh(i10);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzj = zzamVar.zzj(str);
        if (zzj == null || TextUtils.isEmpty(zzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzad = zzad(zzj);
        if (zzad != null && !zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
            return null;
        }
        String zzy = zzj.zzy();
        String zzw = zzj.zzw();
        long zzb2 = zzj.zzb();
        String zzv = zzj.zzv();
        long zzm = zzj.zzm();
        long zzj2 = zzj.zzj();
        boolean zzai = zzj.zzai();
        String zzx = zzj.zzx();
        zzj.zza();
        return new zzq(str, zzy, zzw, zzb2, zzv, zzm, zzj2, (String) null, zzai, false, zzx, 0L, 0L, 0, zzj.zzah(), false, zzj.zzr(), zzj.zzq(), zzj.zzk(), zzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
    }

    private final Boolean zzad(zzh zzhVar) {
        try {
            if (zzhVar.zzb() != -2147483648L) {
                if (zzhVar.zzb() == Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionName;
                String zzw = zzhVar.zzw();
                if (zzw != null && zzw.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    @VisibleForTesting
    private final void zzaf(com.google.android.gms.internal.measurement.zzgc zzgcVar, long j10, boolean z10) {
        String str = true != z10 ? "_lte" : "_se";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzky zzp = zzamVar.zzp(zzgcVar.zzap(), str);
        zzky zzkyVar = (zzp == null || zzp.zze == null) ? new zzky(zzgcVar.zzap(), ConnType.PK_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(j10)) : new zzky(zzgcVar.zzap(), ConnType.PK_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp.zze).longValue() + j10));
        com.google.android.gms.internal.measurement.zzgl zzd = com.google.android.gms.internal.measurement.zzgm.zzd();
        zzd.zzf(str);
        zzd.zzg(zzav().currentTimeMillis());
        zzd.zze(((Long) zzkyVar.zze).longValue());
        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzd.zzaC();
        int zza = zzkv.zza(zzgcVar, str);
        if (zza >= 0) {
            zzgcVar.zzam(zza, zzgmVar);
        } else {
            zzgcVar.zzm(zzgmVar);
        }
        if (j10 > 0) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzL(zzkyVar);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z10 ? "lifetime" : "session-scoped", zzkyVar.zze);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzag() {
        long max;
        long j10;
        zzaz().zzg();
        zzB();
        if (this.zza > 0) {
            long abs = 3600000 - Math.abs(zzav().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzay().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzm().zzc();
                zzkf zzkfVar = this.zzg;
                zzal(zzkfVar);
                zzkfVar.zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzai()) {
            zzay().zzj().zza("Nothing to upload or uploading impossible");
            zzm().zzc();
            zzkf zzkfVar2 = this.zzg;
            zzal(zzkfVar2);
            zzkfVar2.zza();
            return;
        }
        long currentTimeMillis = zzav().currentTimeMillis();
        zzg();
        long max2 = Math.max(0L, ((Long) zzdu.zzz.zza(null)).longValue());
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        boolean z10 = true;
        if (!zzamVar.zzH()) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            if (!zzamVar2.zzG()) {
                z10 = false;
            }
        }
        if (z10) {
            String zzl = zzg().zzl();
            if (TextUtils.isEmpty(zzl) || ".none.".equals(zzl)) {
                zzg();
                max = Math.max(0L, ((Long) zzdu.zzt.zza(null)).longValue());
            } else {
                zzg();
                max = Math.max(0L, ((Long) zzdu.zzu.zza(null)).longValue());
            }
        } else {
            zzg();
            max = Math.max(0L, ((Long) zzdu.zzs.zza(null)).longValue());
        }
        long zza = this.zzk.zzc.zza();
        long zza2 = this.zzk.zzd.zza();
        zzam zzamVar3 = this.zze;
        zzal(zzamVar3);
        boolean z11 = z10;
        long zzd = zzamVar3.zzd();
        zzam zzamVar4 = this.zze;
        zzal(zzamVar4);
        long max3 = Math.max(zzd, zzamVar4.zze());
        if (max3 != 0) {
            long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
            long abs3 = Math.abs(zza - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long max4 = Math.max(currentTimeMillis - abs3, abs4);
            j10 = abs2 + max2;
            if (z11 && max4 > 0) {
                j10 = Math.min(abs2, max4) + max;
            }
            zzkv zzkvVar = this.zzi;
            zzal(zzkvVar);
            if (!zzkvVar.zzw(max4, max)) {
                j10 = max4 + max;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i10 = 0;
                while (true) {
                    zzg();
                    if (i10 >= Math.min(20, Math.max(0, ((Integer) zzdu.zzB.zza(null)).intValue()))) {
                        break;
                    }
                    zzg();
                    j10 += Math.max(0L, ((Long) zzdu.zzA.zza(null)).longValue()) * (1 << i10);
                    if (j10 > abs4) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (j10 != 0) {
                zzay().zzj().zza("Next upload time is 0");
                zzm().zzc();
                zzkf zzkfVar3 = this.zzg;
                zzal(zzkfVar3);
                zzkfVar3.zza();
                return;
            }
            zzen zzenVar = this.zzd;
            zzal(zzenVar);
            if (!zzenVar.zza()) {
                zzay().zzj().zza("No network");
                zzm().zzb();
                zzkf zzkfVar4 = this.zzg;
                zzal(zzkfVar4);
                zzkfVar4.zza();
                return;
            }
            long zza3 = this.zzk.zzb.zza();
            zzg();
            long max5 = Math.max(0L, ((Long) zzdu.zzq.zza(null)).longValue());
            zzkv zzkvVar2 = this.zzi;
            zzal(zzkvVar2);
            if (!zzkvVar2.zzw(zza3, max5)) {
                j10 = Math.max(j10, zza3 + max5);
            }
            zzm().zzc();
            long currentTimeMillis2 = j10 - zzav().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                zzg();
                currentTimeMillis2 = Math.max(0L, ((Long) zzdu.zzv.zza(null)).longValue());
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
            }
            zzay().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzkf zzkfVar5 = this.zzg;
            zzal(zzkfVar5);
            zzkfVar5.zzd(currentTimeMillis2);
            return;
        }
        j10 = 0;
        if (j10 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:385:0x0b69, code lost:
    
        if (r11 > (com.google.android.gms.measurement.internal.zzag.zzA() + r9)) goto L373;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x04b4 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x080d A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0857 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x087a A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x08fb A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0927 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0b59 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0be0 A[Catch: all -> 0x0cfd, TRY_LEAVE, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0bfc A[Catch: SQLiteException -> 0x0c14, all -> 0x0cfd, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0c14, blocks: (B:393:0x0bed, B:395:0x0bfc), top: B:392:0x0bed, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03a0 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0464 A[Catch: all -> 0x0cfd, TryCatch #4 {all -> 0x0cfd, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:25:0x0528, B:26:0x00f5, B:28:0x0103, B:31:0x0123, B:33:0x0129, B:35:0x013b, B:37:0x0149, B:39:0x0159, B:41:0x0166, B:46:0x016b, B:49:0x0184, B:65:0x03a0, B:66:0x03ac, B:69:0x03b6, B:73:0x03d9, B:74:0x03c8, B:83:0x0458, B:85:0x0464, B:88:0x0477, B:90:0x0488, B:92:0x0494, B:94:0x0512, B:101:0x04b4, B:103:0x04c2, B:106:0x04d7, B:108:0x04e9, B:110:0x04f5, B:114:0x03e1, B:116:0x03ed, B:118:0x03f9, B:122:0x043e, B:123:0x0416, B:126:0x0428, B:128:0x042e, B:130:0x0438, B:135:0x01e1, B:138:0x01eb, B:140:0x01f9, B:142:0x023e, B:143:0x0215, B:145:0x0225, B:152:0x024b, B:154:0x0277, B:155:0x02a1, B:157:0x02d7, B:158:0x02dd, B:161:0x02e9, B:163:0x031f, B:164:0x033a, B:166:0x0340, B:168:0x034e, B:170:0x0361, B:171:0x0356, B:179:0x0368, B:182:0x036f, B:183:0x0387, B:196:0x053d, B:198:0x054b, B:200:0x0556, B:202:0x0588, B:203:0x055e, B:205:0x0569, B:207:0x056f, B:209:0x057b, B:211:0x0583, B:218:0x058b, B:219:0x0597, B:222:0x059f, B:225:0x05b1, B:226:0x05bd, B:228:0x05c5, B:229:0x05ea, B:231:0x060f, B:233:0x0620, B:235:0x0626, B:237:0x0632, B:238:0x0663, B:240:0x0669, B:244:0x0677, B:242:0x067b, B:246:0x067e, B:247:0x0681, B:248:0x068f, B:250:0x0695, B:252:0x06a5, B:253:0x06ac, B:255:0x06b8, B:257:0x06bf, B:260:0x06c2, B:262:0x0700, B:263:0x0713, B:265:0x0719, B:268:0x0733, B:270:0x074e, B:272:0x0767, B:274:0x076c, B:276:0x0770, B:278:0x0774, B:280:0x077e, B:281:0x0788, B:283:0x078c, B:285:0x0792, B:286:0x07a0, B:287:0x07a9, B:290:0x09f8, B:291:0x07b6, B:356:0x07cd, B:294:0x07e9, B:296:0x080d, B:297:0x0815, B:299:0x081b, B:303:0x082d, B:308:0x0857, B:309:0x087a, B:311:0x0886, B:313:0x089b, B:314:0x08dc, B:317:0x08f4, B:319:0x08fb, B:321:0x090a, B:323:0x090e, B:325:0x0912, B:327:0x0916, B:328:0x0922, B:329:0x0927, B:331:0x092d, B:333:0x0949, B:334:0x094e, B:335:0x09f5, B:337:0x0969, B:339:0x0971, B:342:0x0998, B:344:0x09c4, B:345:0x09cb, B:347:0x09db, B:349:0x09e3, B:350:0x097e, B:354:0x0841, B:360:0x07d4, B:362:0x0a03, B:364:0x0a10, B:365:0x0a16, B:366:0x0a1e, B:368:0x0a24, B:371:0x0a3e, B:373:0x0a4f, B:374:0x0ac3, B:376:0x0ac9, B:378:0x0ae1, B:381:0x0ae8, B:382:0x0b17, B:384:0x0b59, B:386:0x0b8e, B:388:0x0b92, B:389:0x0b9d, B:391:0x0be0, B:393:0x0bed, B:395:0x0bfc, B:399:0x0c16, B:402:0x0c2f, B:403:0x0b6b, B:404:0x0af0, B:406:0x0afc, B:407:0x0b00, B:408:0x0c47, B:409:0x0c5f, B:412:0x0c67, B:414:0x0c6c, B:417:0x0c7c, B:419:0x0c96, B:420:0x0cb1, B:422:0x0cba, B:423:0x0cd9, B:430:0x0cc6, B:431:0x0a67, B:433:0x0a6d, B:435:0x0a77, B:436:0x0a7e, B:441:0x0a8e, B:442:0x0a95, B:444:0x0ab4, B:445:0x0abb, B:446:0x0ab8, B:447:0x0a92, B:449:0x0a7b, B:451:0x05ca, B:453:0x05d0, B:456:0x0ceb), top: B:2:0x000e, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzah(String str, long j10) {
        int i10;
        int i11;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        zzkq zzkqVar;
        zzam zzamVar;
        com.google.android.gms.internal.measurement.zzgd zzgdVar;
        long currentTimeMillis;
        long zzk;
        ContentValues contentValues;
        long parseLong;
        int zzc;
        long j11;
        SecureRandom secureRandom;
        com.google.android.gms.internal.measurement.zzgc zzgcVar2;
        zzkq zzkqVar2;
        Long l10;
        int i12;
        long zzr;
        int i13;
        com.google.android.gms.internal.measurement.zzgc zzgcVar3;
        String str2;
        String str3;
        int i14;
        int i15;
        com.google.android.gms.internal.measurement.zzgc zzgcVar4;
        com.google.android.gms.internal.measurement.zzfs zzfsVar;
        com.google.android.gms.internal.measurement.zzfs zzfsVar2;
        com.google.android.gms.internal.measurement.zzgc zzgcVar5;
        int i16;
        com.google.android.gms.internal.measurement.zzfs zzfsVar3;
        int i17;
        com.google.android.gms.internal.measurement.zzfs zzfsVar4;
        char c10;
        String str4 = "_npa";
        String str5 = "_ai";
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        zzamVar2.zzw();
        try {
            zzkq zzkqVar3 = new zzkq(this, null);
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzU(null, j10, this.zzA, zzkqVar3);
            List list = zzkqVar3.zzc;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.zzgc zzgcVar6 = (com.google.android.gms.internal.measurement.zzgc) zzkqVar3.zza.zzby();
                zzgcVar6.zzr();
                com.google.android.gms.internal.measurement.zzfs zzfsVar5 = null;
                com.google.android.gms.internal.measurement.zzfs zzfsVar6 = null;
                int i18 = 0;
                int i19 = 0;
                int i20 = -1;
                int i21 = -1;
                int i22 = 0;
                while (true) {
                    i10 = i22;
                    i11 = i19;
                    com.google.android.gms.internal.measurement.zzfs zzfsVar7 = zzfsVar5;
                    if (i18 >= zzkqVar3.zzc.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzfs zzfsVar8 = (com.google.android.gms.internal.measurement.zzfs) ((com.google.android.gms.internal.measurement.zzft) zzkqVar3.zzc.get(i18)).zzby();
                    zzfi zzfiVar = this.zzc;
                    zzal(zzfiVar);
                    String str6 = str4;
                    if (zzfiVar.zzr(zzkqVar3.zza.zzx(), zzfsVar8.zzo())) {
                        zzay().zzk().zzc("Dropping blocked raw event. appId", zzeh.zzn(zzkqVar3.zza.zzx()), this.zzn.zzj().zzd(zzfsVar8.zzo()));
                        zzfi zzfiVar2 = this.zzc;
                        zzal(zzfiVar2);
                        if (!zzfiVar2.zzp(zzkqVar3.zza.zzx())) {
                            zzfi zzfiVar3 = this.zzc;
                            zzal(zzfiVar3);
                            if (!zzfiVar3.zzs(zzkqVar3.zza.zzx()) && !"_err".equals(zzfsVar8.zzo())) {
                                zzv().zzN(this.zzF, zzkqVar3.zza.zzx(), 11, "_ev", zzfsVar8.zzo(), 0);
                            }
                        }
                        str2 = str5;
                        zzgcVar5 = zzgcVar6;
                        i17 = i18;
                        i22 = i10;
                        i19 = i11;
                        zzfsVar5 = zzfsVar7;
                    } else {
                        if (zzfsVar8.zzo().equals(zzgo.zza(str5))) {
                            zzfsVar8.zzi(str5);
                            zzay().zzj().zza("Renaming ad_impression to _ai");
                            if (Log.isLoggable(zzay().zzq(), 5)) {
                                int i23 = 0;
                                while (i23 < zzfsVar8.zza()) {
                                    String str7 = str5;
                                    if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzfsVar8.zzn(i23).zzg()) && !zzfsVar8.zzn(i23).zzh().isEmpty() && "admob".equalsIgnoreCase(zzfsVar8.zzn(i23).zzh())) {
                                        zzay().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                    i23++;
                                    str5 = str7;
                                }
                            }
                        }
                        str2 = str5;
                        zzfi zzfiVar4 = this.zzc;
                        zzal(zzfiVar4);
                        boolean zzq = zzfiVar4.zzq(zzkqVar3.zza.zzx(), zzfsVar8.zzo());
                        if (zzq) {
                            str3 = "_et";
                            i14 = i18;
                            i15 = i20;
                        } else {
                            zzal(this.zzi);
                            String zzo = zzfsVar8.zzo();
                            Preconditions.checkNotEmpty(zzo);
                            i14 = i18;
                            int hashCode = zzo.hashCode();
                            i15 = i20;
                            str3 = "_et";
                            if (hashCode == 94660) {
                                if (zzo.equals("_in")) {
                                    c10 = 0;
                                    if (c10 != 0) {
                                    }
                                }
                                c10 = 65535;
                                if (c10 != 0) {
                                }
                            } else if (hashCode != 95025) {
                                if (hashCode == 95027 && zzo.equals("_ui")) {
                                    c10 = 1;
                                    if (c10 != 0 && c10 != 1 && c10 != 2) {
                                        zzgcVar4 = zzgcVar6;
                                        zzfsVar = zzfsVar6;
                                        zzq = false;
                                        if (zzq) {
                                            ArrayList arrayList = new ArrayList(zzfsVar8.zzp());
                                            int i24 = -1;
                                            int i25 = -1;
                                            for (int i26 = 0; i26 < arrayList.size(); i26++) {
                                                if ("value".equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i26)).zzg())) {
                                                    i24 = i26;
                                                } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i26)).zzg())) {
                                                    i25 = i26;
                                                }
                                            }
                                            if (i24 != -1) {
                                                if (((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i24)).zzw() || ((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i24)).zzu()) {
                                                    if (i25 != -1) {
                                                        String zzh = ((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i25)).zzh();
                                                        if (zzh.length() == 3) {
                                                            int i27 = 0;
                                                            while (i27 < zzh.length()) {
                                                                int codePointAt = zzh.codePointAt(i27);
                                                                if (Character.isLetter(codePointAt)) {
                                                                    i27 += Character.charCount(codePointAt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                    zzfsVar8.zzh(i24);
                                                    zzab(zzfsVar8, "_c");
                                                    zzaa(zzfsVar8, 19, FirebaseAnalytics.Param.CURRENCY);
                                                    break;
                                                }
                                                zzay().zzl().zza("Value must be specified with a numeric type.");
                                                zzfsVar8.zzh(i24);
                                                zzab(zzfsVar8, "_c");
                                                zzaa(zzfsVar8, 18, "value");
                                            }
                                            if ("_e".equals(zzfsVar8.zzo())) {
                                                zzgcVar5 = zzgcVar4;
                                                if ("_vs".equals(zzfsVar8.zzo())) {
                                                    zzal(this.zzi);
                                                    if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC(), str3) == null) {
                                                        if (zzfsVar7 == null || Math.abs(zzfsVar7.zzc() - zzfsVar8.zzc()) > 1000) {
                                                            i20 = i15;
                                                            zzfsVar6 = zzfsVar8;
                                                            i21 = i11;
                                                        } else {
                                                            com.google.android.gms.internal.measurement.zzfs zzfsVar9 = (com.google.android.gms.internal.measurement.zzfs) zzfsVar7.clone();
                                                            if (zzaj(zzfsVar9, zzfsVar8)) {
                                                                i16 = i15;
                                                                zzgcVar5.zzS(i16, zzfsVar9);
                                                                zzfsVar3 = null;
                                                                zzfsVar7 = null;
                                                            } else {
                                                                i16 = i15;
                                                                zzfsVar3 = zzfsVar8;
                                                                i21 = i11;
                                                            }
                                                            zzfsVar6 = zzfsVar3;
                                                            i20 = i16;
                                                        }
                                                    }
                                                }
                                                i20 = i15;
                                                zzfsVar6 = zzfsVar;
                                            } else {
                                                zzal(this.zzi);
                                                if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC(), "_fr") != null) {
                                                    zzgcVar5 = zzgcVar4;
                                                    i20 = i15;
                                                    zzfsVar6 = zzfsVar;
                                                } else if (zzfsVar == null || Math.abs(zzfsVar.zzc() - zzfsVar8.zzc()) > 1000) {
                                                    zzgcVar5 = zzgcVar4;
                                                    zzfsVar7 = zzfsVar8;
                                                    i20 = i11;
                                                    zzfsVar6 = zzfsVar;
                                                } else {
                                                    com.google.android.gms.internal.measurement.zzfs zzfsVar10 = (com.google.android.gms.internal.measurement.zzfs) zzfsVar.clone();
                                                    if (zzaj(zzfsVar8, zzfsVar10)) {
                                                        zzgcVar5 = zzgcVar4;
                                                        zzgcVar5.zzS(i21, zzfsVar10);
                                                        i20 = i15;
                                                        zzfsVar4 = null;
                                                        zzfsVar6 = null;
                                                    } else {
                                                        zzgcVar5 = zzgcVar4;
                                                        zzfsVar4 = zzfsVar8;
                                                        i20 = i11;
                                                        zzfsVar6 = zzfsVar;
                                                    }
                                                    zzfsVar7 = zzfsVar4;
                                                }
                                            }
                                            i17 = i14;
                                            zzkqVar3.zzc.set(i17, (com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC());
                                            i19 = i11 + 1;
                                            zzgcVar5.zzk(zzfsVar8);
                                            i22 = i10;
                                            zzfsVar5 = zzfsVar7;
                                        }
                                        if ("_e".equals(zzfsVar8.zzo())) {
                                        }
                                        i17 = i14;
                                        zzkqVar3.zzc.set(i17, (com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC());
                                        i19 = i11 + 1;
                                        zzgcVar5.zzk(zzfsVar8);
                                        i22 = i10;
                                        zzfsVar5 = zzfsVar7;
                                    }
                                }
                                c10 = 65535;
                                if (c10 != 0) {
                                    zzgcVar4 = zzgcVar6;
                                    zzfsVar = zzfsVar6;
                                    zzq = false;
                                    if (zzq) {
                                    }
                                    if ("_e".equals(zzfsVar8.zzo())) {
                                    }
                                    i17 = i14;
                                    zzkqVar3.zzc.set(i17, (com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC());
                                    i19 = i11 + 1;
                                    zzgcVar5.zzk(zzfsVar8);
                                    i22 = i10;
                                    zzfsVar5 = zzfsVar7;
                                }
                            } else {
                                if (zzo.equals("_ug")) {
                                    c10 = 2;
                                    if (c10 != 0) {
                                    }
                                }
                                c10 = 65535;
                                if (c10 != 0) {
                                }
                            }
                        }
                        int i28 = 0;
                        boolean z10 = false;
                        boolean z11 = false;
                        while (true) {
                            zzgcVar4 = zzgcVar6;
                            if (i28 >= zzfsVar8.zza()) {
                                break;
                            }
                            if ("_c".equals(zzfsVar8.zzn(i28).zzg())) {
                                com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) zzfsVar8.zzn(i28).zzby();
                                zzfsVar2 = zzfsVar6;
                                zzfwVar.zzi(1L);
                                zzfsVar8.zzk(i28, (com.google.android.gms.internal.measurement.zzfx) zzfwVar.zzaC());
                                z10 = true;
                            } else {
                                zzfsVar2 = zzfsVar6;
                                if ("_r".equals(zzfsVar8.zzn(i28).zzg())) {
                                    com.google.android.gms.internal.measurement.zzfw zzfwVar2 = (com.google.android.gms.internal.measurement.zzfw) zzfsVar8.zzn(i28).zzby();
                                    zzfwVar2.zzi(1L);
                                    zzfsVar8.zzk(i28, (com.google.android.gms.internal.measurement.zzfx) zzfwVar2.zzaC());
                                    z11 = true;
                                }
                            }
                            i28++;
                            zzgcVar6 = zzgcVar4;
                            zzfsVar6 = zzfsVar2;
                        }
                        zzfsVar = zzfsVar6;
                        if (!z10 && zzq) {
                            zzay().zzj().zzb("Marking event as conversion", this.zzn.zzj().zzd(zzfsVar8.zzo()));
                            com.google.android.gms.internal.measurement.zzfw zze = com.google.android.gms.internal.measurement.zzfx.zze();
                            zze.zzj("_c");
                            zze.zzi(1L);
                            zzfsVar8.zze(zze);
                        }
                        if (!z11) {
                            zzay().zzj().zzb("Marking event as real-time", this.zzn.zzj().zzd(zzfsVar8.zzo()));
                            com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
                            zze2.zzj("_r");
                            zze2.zzi(1L);
                            zzfsVar8.zze(zze2);
                        }
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        if (zzamVar4.zzl(zza(), zzkqVar3.zza.zzx(), false, false, false, false, true).zze > zzg().zze(zzkqVar3.zza.zzx(), zzdu.zzn)) {
                            zzab(zzfsVar8, "_r");
                        } else {
                            i10 = 1;
                        }
                        if (zzlb.zzai(zzfsVar8.zzo()) && zzq) {
                            zzam zzamVar5 = this.zze;
                            zzal(zzamVar5);
                            if (zzamVar5.zzl(zza(), zzkqVar3.zza.zzx(), false, false, true, false, false).zzc > zzg().zze(zzkqVar3.zza.zzx(), zzdu.zzm)) {
                                zzay().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzeh.zzn(zzkqVar3.zza.zzx()));
                                com.google.android.gms.internal.measurement.zzfw zzfwVar3 = null;
                                boolean z12 = false;
                                int i29 = -1;
                                for (int i30 = 0; i30 < zzfsVar8.zza(); i30++) {
                                    com.google.android.gms.internal.measurement.zzfx zzn = zzfsVar8.zzn(i30);
                                    if ("_c".equals(zzn.zzg())) {
                                        zzfwVar3 = (com.google.android.gms.internal.measurement.zzfw) zzn.zzby();
                                        i29 = i30;
                                    } else if ("_err".equals(zzn.zzg())) {
                                        z12 = true;
                                    }
                                }
                                if (z12) {
                                    if (zzfwVar3 != null) {
                                        zzfsVar8.zzh(i29);
                                    } else {
                                        zzfwVar3 = null;
                                    }
                                }
                                if (zzfwVar3 != null) {
                                    com.google.android.gms.internal.measurement.zzfw zzfwVar4 = (com.google.android.gms.internal.measurement.zzfw) zzfwVar3.clone();
                                    zzfwVar4.zzj("_err");
                                    zzfwVar4.zzi(10L);
                                    zzfsVar8.zzk(i29, (com.google.android.gms.internal.measurement.zzfx) zzfwVar4.zzaC());
                                } else {
                                    zzay().zzd().zzb("Did not find conversion parameter. appId", zzeh.zzn(zzkqVar3.zza.zzx()));
                                }
                            }
                        }
                        if (zzq) {
                        }
                        if ("_e".equals(zzfsVar8.zzo())) {
                        }
                        i17 = i14;
                        zzkqVar3.zzc.set(i17, (com.google.android.gms.internal.measurement.zzft) zzfsVar8.zzaC());
                        i19 = i11 + 1;
                        zzgcVar5.zzk(zzfsVar8);
                        i22 = i10;
                        zzfsVar5 = zzfsVar7;
                    }
                    i18 = i17 + 1;
                    zzgcVar6 = zzgcVar5;
                    str4 = str6;
                    str5 = str2;
                }
                String str8 = str4;
                com.google.android.gms.internal.measurement.zzgc zzgcVar7 = zzgcVar6;
                long j12 = 0;
                int i31 = i11;
                int i32 = 0;
                while (i32 < i31) {
                    com.google.android.gms.internal.measurement.zzft zze3 = zzgcVar7.zze(i32);
                    if ("_e".equals(zze3.zzh())) {
                        zzal(this.zzi);
                        if (zzkv.zzB(zze3, "_fr") != null) {
                            zzgcVar7.zzA(i32);
                            i31--;
                            i32--;
                            i32++;
                        }
                    }
                    zzal(this.zzi);
                    com.google.android.gms.internal.measurement.zzfx zzB = zzkv.zzB(zze3, "_et");
                    if (zzB != null) {
                        Long valueOf = zzB.zzw() ? Long.valueOf(zzB.zzd()) : null;
                        if (valueOf != null && valueOf.longValue() > 0) {
                            j12 += valueOf.longValue();
                        }
                    }
                    i32++;
                }
                zzaf(zzgcVar7, j12, false);
                Iterator it = zzgcVar7.zzas().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("_s".equals(((com.google.android.gms.internal.measurement.zzft) it.next()).zzh())) {
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzA(zzgcVar7.zzap(), "_se");
                        break;
                    }
                }
                if (zzkv.zza(zzgcVar7, "_sid") >= 0) {
                    zzaf(zzgcVar7, j12, true);
                } else {
                    int zza = zzkv.zza(zzgcVar7, "_se");
                    if (zza >= 0) {
                        zzgcVar7.zzB(zza);
                        zzay().zzd().zzb("Session engagement user property is in the bundle without session ID. appId", zzeh.zzn(zzkqVar3.zza.zzx()));
                    }
                }
                zzkv zzkvVar = this.zzi;
                zzal(zzkvVar);
                zzkvVar.zzt.zzay().zzj().zza("Checking account type status for ad personalization signals");
                zzfi zzfiVar5 = zzkvVar.zzf.zzc;
                zzal(zzfiVar5);
                if (zzfiVar5.zzn(zzgcVar7.zzap())) {
                    zzam zzamVar7 = zzkvVar.zzf.zze;
                    zzal(zzamVar7);
                    zzh zzj = zzamVar7.zzj(zzgcVar7.zzap());
                    if (zzj != null && zzj.zzah() && zzkvVar.zzt.zzg().zze()) {
                        zzkvVar.zzt.zzay().zzc().zza("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.zzgl zzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                        zzd.zzf(str8);
                        zzd.zzg(zzkvVar.zzt.zzg().zza());
                        zzd.zze(1L);
                        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzd.zzaC();
                        int i33 = 0;
                        while (true) {
                            if (i33 >= zzgcVar7.zzb()) {
                                zzgcVar7.zzm(zzgmVar);
                                break;
                            }
                            if (str8.equals(zzgcVar7.zzao(i33).zzf())) {
                                zzgcVar7.zzam(i33, zzgmVar);
                                break;
                            }
                            i33++;
                        }
                    }
                }
                zzgcVar7.zzai(Long.MAX_VALUE);
                zzgcVar7.zzQ(Long.MIN_VALUE);
                for (int i34 = 0; i34 < zzgcVar7.zza(); i34++) {
                    com.google.android.gms.internal.measurement.zzft zze4 = zzgcVar7.zze(i34);
                    if (zze4.zzd() < zzgcVar7.zzd()) {
                        zzgcVar7.zzai(zze4.zzd());
                    }
                    if (zze4.zzd() > zzgcVar7.zzc()) {
                        zzgcVar7.zzQ(zze4.zzd());
                    }
                }
                zzgcVar7.zzz();
                zzgcVar7.zzo();
                zzaa zzaaVar = this.zzh;
                zzal(zzaaVar);
                zzgcVar7.zzf(zzaaVar.zza(zzgcVar7.zzap(), zzgcVar7.zzas(), zzgcVar7.zzat(), Long.valueOf(zzgcVar7.zzd()), Long.valueOf(zzgcVar7.zzc())));
                if (zzg().zzw(zzkqVar3.zza.zzx())) {
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom zzG = zzv().zzG();
                    int i35 = 0;
                    while (i35 < zzgcVar7.zza()) {
                        com.google.android.gms.internal.measurement.zzfs zzfsVar11 = (com.google.android.gms.internal.measurement.zzfs) zzgcVar7.zze(i35).zzby();
                        if (zzfsVar11.zzo().equals("_ep")) {
                            zzal(this.zzi);
                            String str9 = (String) zzkv.zzC((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC(), "_en");
                            zzas zzasVar = (zzas) hashMap.get(str9);
                            if (zzasVar == null) {
                                zzam zzamVar8 = this.zze;
                                zzal(zzamVar8);
                                zzasVar = zzamVar8.zzn(zzkqVar3.zza.zzx(), (String) Preconditions.checkNotNull(str9));
                                if (zzasVar != null) {
                                    hashMap.put(str9, zzasVar);
                                }
                            }
                            if (zzasVar != null && zzasVar.zzi == null) {
                                Long l11 = zzasVar.zzj;
                                if (l11 != null && l11.longValue() > 1) {
                                    zzal(this.zzi);
                                    zzkv.zzz(zzfsVar11, "_sr", zzasVar.zzj);
                                }
                                Boolean bool = zzasVar.zzk;
                                if (bool != null && bool.booleanValue()) {
                                    zzal(this.zzi);
                                    zzkv.zzz(zzfsVar11, "_efs", 1L);
                                }
                                arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC());
                            }
                            zzgcVar7.zzS(i35, zzfsVar11);
                        } else {
                            zzfi zzfiVar6 = this.zzc;
                            zzal(zzfiVar6);
                            String zzx = zzkqVar3.zza.zzx();
                            String zza2 = zzfiVar6.zza(zzx, "measurement.account.time_zone_offset_minutes");
                            if (!TextUtils.isEmpty(zza2)) {
                                try {
                                    parseLong = Long.parseLong(zza2);
                                } catch (NumberFormatException e10) {
                                    zzfiVar6.zzt.zzay().zzk().zzc("Unable to parse timezone offset. appId", zzeh.zzn(zzx), e10);
                                }
                                long zzr2 = zzv().zzr(zzfsVar11.zzc(), parseLong);
                                com.google.android.gms.internal.measurement.zzft zzftVar = (com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC();
                                Long l12 = 1L;
                                long j13 = parseLong;
                                if (!TextUtils.isEmpty("_dbg")) {
                                    Iterator it2 = zzftVar.zzi().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it2.next();
                                        Iterator it3 = it2;
                                        if (!"_dbg".equals(zzfxVar.zzg())) {
                                            it2 = it3;
                                        } else if (l12.equals(Long.valueOf(zzfxVar.zzd()))) {
                                            zzc = 1;
                                        }
                                    }
                                }
                                zzfi zzfiVar7 = this.zzc;
                                zzal(zzfiVar7);
                                zzc = zzfiVar7.zzc(zzkqVar3.zza.zzx(), zzfsVar11.zzo());
                                if (zzc > 0) {
                                    zzay().zzk().zzc("Sample rate must be positive. event, rate", zzfsVar11.zzo(), Integer.valueOf(zzc));
                                    arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC());
                                    zzgcVar7.zzS(i35, zzfsVar11);
                                } else {
                                    zzas zzasVar2 = (zzas) hashMap.get(zzfsVar11.zzo());
                                    if (zzasVar2 == null) {
                                        zzam zzamVar9 = this.zze;
                                        zzal(zzamVar9);
                                        zzasVar2 = zzamVar9.zzn(zzkqVar3.zza.zzx(), zzfsVar11.zzo());
                                        if (zzasVar2 == null) {
                                            j11 = zzr2;
                                            zzay().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzkqVar3.zza.zzx(), zzfsVar11.zzo());
                                            zzasVar2 = new zzas(zzkqVar3.zza.zzx(), zzfsVar11.zzo(), 1L, 1L, 1L, zzfsVar11.zzc(), 0L, null, null, null, null);
                                            zzal(this.zzi);
                                            Long l13 = (Long) zzkv.zzC((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC(), "_eid");
                                            Boolean valueOf2 = Boolean.valueOf(l13 == null);
                                            if (zzc != 1) {
                                                arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC());
                                                if (valueOf2.booleanValue() && (zzasVar2.zzi != null || zzasVar2.zzj != null || zzasVar2.zzk != null)) {
                                                    hashMap.put(zzfsVar11.zzo(), zzasVar2.zza(null, null, null));
                                                }
                                                zzgcVar7.zzS(i35, zzfsVar11);
                                            } else {
                                                if (zzG.nextInt(zzc) == 0) {
                                                    zzal(this.zzi);
                                                    Long valueOf3 = Long.valueOf(zzc);
                                                    zzkv.zzz(zzfsVar11, "_sr", valueOf3);
                                                    arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC());
                                                    if (valueOf2.booleanValue()) {
                                                        zzasVar2 = zzasVar2.zza(null, valueOf3, null);
                                                    }
                                                    hashMap.put(zzfsVar11.zzo(), zzasVar2.zzb(zzfsVar11.zzc(), j11));
                                                    zzkqVar2 = zzkqVar3;
                                                    secureRandom = zzG;
                                                    i13 = i35;
                                                    zzgcVar3 = zzgcVar7;
                                                } else {
                                                    long j14 = j11;
                                                    secureRandom = zzG;
                                                    Long l14 = zzasVar2.zzh;
                                                    if (l14 != null) {
                                                        zzr = l14.longValue();
                                                        zzgcVar2 = zzgcVar7;
                                                        zzkqVar2 = zzkqVar3;
                                                        l10 = l13;
                                                        i12 = i35;
                                                    } else {
                                                        zzgcVar2 = zzgcVar7;
                                                        zzkqVar2 = zzkqVar3;
                                                        l10 = l13;
                                                        i12 = i35;
                                                        zzr = zzv().zzr(zzfsVar11.zzb(), j13);
                                                    }
                                                    if (zzr != j14) {
                                                        zzal(this.zzi);
                                                        zzkv.zzz(zzfsVar11, "_efs", 1L);
                                                        zzal(this.zzi);
                                                        Long valueOf4 = Long.valueOf(zzc);
                                                        zzkv.zzz(zzfsVar11, "_sr", valueOf4);
                                                        arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC());
                                                        if (valueOf2.booleanValue()) {
                                                            zzasVar2 = zzasVar2.zza(null, valueOf4, Boolean.TRUE);
                                                        }
                                                        hashMap.put(zzfsVar11.zzo(), zzasVar2.zzb(zzfsVar11.zzc(), j14));
                                                    } else if (valueOf2.booleanValue()) {
                                                        hashMap.put(zzfsVar11.zzo(), zzasVar2.zza(l10, null, null));
                                                    }
                                                    i13 = i12;
                                                    zzgcVar3 = zzgcVar2;
                                                }
                                                zzgcVar3.zzS(i13, zzfsVar11);
                                                i35 = i13 + 1;
                                                zzgcVar7 = zzgcVar3;
                                                zzG = secureRandom;
                                                zzkqVar3 = zzkqVar2;
                                            }
                                        }
                                    }
                                    j11 = zzr2;
                                    zzal(this.zzi);
                                    Long l132 = (Long) zzkv.zzC((com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC(), "_eid");
                                    Boolean valueOf22 = Boolean.valueOf(l132 == null);
                                    if (zzc != 1) {
                                    }
                                }
                            }
                            parseLong = 0;
                            long zzr22 = zzv().zzr(zzfsVar11.zzc(), parseLong);
                            com.google.android.gms.internal.measurement.zzft zzftVar2 = (com.google.android.gms.internal.measurement.zzft) zzfsVar11.zzaC();
                            Long l122 = 1L;
                            long j132 = parseLong;
                            if (!TextUtils.isEmpty("_dbg")) {
                            }
                            zzfi zzfiVar72 = this.zzc;
                            zzal(zzfiVar72);
                            zzc = zzfiVar72.zzc(zzkqVar3.zza.zzx(), zzfsVar11.zzo());
                            if (zzc > 0) {
                            }
                        }
                        zzkqVar2 = zzkqVar3;
                        secureRandom = zzG;
                        i13 = i35;
                        zzgcVar3 = zzgcVar7;
                        i35 = i13 + 1;
                        zzgcVar7 = zzgcVar3;
                        zzG = secureRandom;
                        zzkqVar3 = zzkqVar2;
                    }
                    zzgcVar = zzgcVar7;
                    zzkq zzkqVar4 = zzkqVar3;
                    if (arrayList2.size() < zzgcVar.zza()) {
                        zzgcVar.zzr();
                        zzgcVar.zzg(arrayList2);
                    }
                    for (Map.Entry entry : hashMap.entrySet()) {
                        zzam zzamVar10 = this.zze;
                        zzal(zzamVar10);
                        zzamVar10.zzE((zzas) entry.getValue());
                    }
                    zzkqVar = zzkqVar4;
                } else {
                    zzgcVar = zzgcVar7;
                    zzkqVar = zzkqVar3;
                }
                String zzx2 = zzkqVar.zza.zzx();
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzh zzj2 = zzamVar11.zzj(zzx2);
                if (zzj2 == null) {
                    zzay().zzd().zzb("Bundling raw events w/o app info. appId", zzeh.zzn(zzkqVar.zza.zzx()));
                } else if (zzgcVar.zza() > 0) {
                    long zzn2 = zzj2.zzn();
                    if (zzn2 != 0) {
                        zzgcVar.zzab(zzn2);
                    } else {
                        zzgcVar.zzv();
                    }
                    long zzp = zzj2.zzp();
                    if (zzp != 0) {
                        zzn2 = zzp;
                    }
                    if (zzn2 != 0) {
                        zzgcVar.zzac(zzn2);
                    } else {
                        zzgcVar.zzw();
                    }
                    zzj2.zzE();
                    zzgcVar.zzI((int) zzj2.zzo());
                    zzj2.zzab(zzgcVar.zzd());
                    zzj2.zzZ(zzgcVar.zzc());
                    String zzs = zzj2.zzs();
                    if (zzs != null) {
                        zzgcVar.zzW(zzs);
                    } else {
                        zzgcVar.zzs();
                    }
                    zzam zzamVar12 = this.zze;
                    zzal(zzamVar12);
                    zzamVar12.zzD(zzj2);
                }
                if (zzgcVar.zza() > 0) {
                    this.zzn.zzaw();
                    zzfi zzfiVar8 = this.zzc;
                    zzal(zzfiVar8);
                    com.google.android.gms.internal.measurement.zzff zze5 = zzfiVar8.zze(zzkqVar.zza.zzx());
                    try {
                        try {
                            if (zze5 != null && zze5.zzs()) {
                                zzgcVar.zzK(zze5.zzc());
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                zzgdVar = (com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC();
                                zzamVar.zzg();
                                zzamVar.zzW();
                                Preconditions.checkNotNull(zzgdVar);
                                Preconditions.checkNotEmpty(zzgdVar.zzx());
                                Preconditions.checkState(zzgdVar.zzbe());
                                zzamVar.zzz();
                                currentTimeMillis = zzamVar.zzt.zzav().currentTimeMillis();
                                zzk = zzgdVar.zzk();
                                zzamVar.zzt.zzf();
                                if (zzk >= currentTimeMillis - zzag.zzA()) {
                                    long zzk2 = zzgdVar.zzk();
                                    zzamVar.zzt.zzf();
                                }
                                zzamVar.zzt.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                                byte[] zzbu = zzgdVar.zzbu();
                                zzkv zzkvVar2 = zzamVar.zzf.zzi;
                                zzal(zzkvVar2);
                                byte[] zzy = zzkvVar2.zzy(zzbu);
                                zzamVar.zzt.zzay().zzj().zzb("Saving bundle, size", Integer.valueOf(zzy.length));
                                contentValues = new ContentValues();
                                contentValues.put("app_id", zzgdVar.zzx());
                                contentValues.put("bundle_end_timestamp", Long.valueOf(zzgdVar.zzk()));
                                contentValues.put("data", zzy);
                                contentValues.put("has_realtime", Integer.valueOf(i10));
                                if (zzgdVar.zzbk()) {
                                    contentValues.put("retry_count", Integer.valueOf(zzgdVar.zze()));
                                }
                                if (zzamVar.zzh().insert("queue", null, contentValues) == -1) {
                                    zzamVar.zzt.zzay().zzd().zzb("Failed to insert bundle (got -1). appId", zzeh.zzn(zzgdVar.zzx()));
                                }
                            }
                            if (zzamVar.zzh().insert("queue", null, contentValues) == -1) {
                            }
                        } catch (SQLiteException e11) {
                            zzamVar.zzt.zzay().zzd().zzc("Error storing bundle. appId", zzeh.zzn(zzgdVar.zzx()), e11);
                        }
                        zzkv zzkvVar22 = zzamVar.zzf.zzi;
                        zzal(zzkvVar22);
                        byte[] zzy2 = zzkvVar22.zzy(zzbu);
                        zzamVar.zzt.zzay().zzj().zzb("Saving bundle, size", Integer.valueOf(zzy2.length));
                        contentValues = new ContentValues();
                        contentValues.put("app_id", zzgdVar.zzx());
                        contentValues.put("bundle_end_timestamp", Long.valueOf(zzgdVar.zzk()));
                        contentValues.put("data", zzy2);
                        contentValues.put("has_realtime", Integer.valueOf(i10));
                        if (zzgdVar.zzbk()) {
                        }
                    } catch (IOException e12) {
                        zzamVar.zzt.zzay().zzd().zzc("Data loss. Failed to serialize bundle. appId", zzeh.zzn(zzgdVar.zzx()), e12);
                    }
                    if (zzkqVar.zza.zzF().isEmpty()) {
                        zzgcVar.zzK(-1L);
                    } else {
                        zzay().zzk().zzb("Did not find measurement config or missing version info. appId", zzeh.zzn(zzkqVar.zza.zzx()));
                    }
                    zzamVar = this.zze;
                    zzal(zzamVar);
                    zzgdVar = (com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC();
                    zzamVar.zzg();
                    zzamVar.zzW();
                    Preconditions.checkNotNull(zzgdVar);
                    Preconditions.checkNotEmpty(zzgdVar.zzx());
                    Preconditions.checkState(zzgdVar.zzbe());
                    zzamVar.zzz();
                    currentTimeMillis = zzamVar.zzt.zzav().currentTimeMillis();
                    zzk = zzgdVar.zzk();
                    zzamVar.zzt.zzf();
                    if (zzk >= currentTimeMillis - zzag.zzA()) {
                    }
                    zzamVar.zzt.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                    byte[] zzbu2 = zzgdVar.zzbu();
                }
                zzam zzamVar13 = this.zze;
                zzal(zzamVar13);
                List list2 = zzkqVar.zzb;
                Preconditions.checkNotNull(list2);
                zzamVar13.zzg();
                zzamVar13.zzW();
                StringBuilder sb = new StringBuilder("rowid in (");
                for (int i36 = 0; i36 < list2.size(); i36++) {
                    if (i36 != 0) {
                        sb.append(",");
                    }
                    sb.append(((Long) list2.get(i36)).longValue());
                }
                sb.append(")");
                int delete = zzamVar13.zzh().delete("raw_events", sb.toString(), null);
                if (delete != list2.size()) {
                    zzamVar13.zzt.zzay().zzd().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list2.size()));
                }
                zzam zzamVar14 = this.zze;
                zzal(zzamVar14);
                try {
                    zzamVar14.zzh().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzx2, zzx2});
                } catch (SQLiteException e13) {
                    zzamVar14.zzt.zzay().zzd().zzc("Failed to remove unused event metadata. appId", zzeh.zzn(zzx2), e13);
                }
                zzam zzamVar15 = this.zze;
                zzal(zzamVar15);
                zzamVar15.zzC();
                zzam zzamVar16 = this.zze;
                zzal(zzamVar16);
                zzamVar16.zzx();
                return true;
            }
            zzam zzamVar17 = this.zze;
            zzal(zzamVar17);
            zzamVar17.zzC();
            zzam zzamVar18 = this.zze;
            zzal(zzamVar18);
            zzamVar18.zzx();
            return false;
        } catch (Throwable th) {
            zzam zzamVar19 = this.zze;
            zzal(zzamVar19);
            zzamVar19.zzx();
            throw th;
        }
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        if (zzamVar.zzF()) {
            return true;
        }
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        return !TextUtils.isEmpty(zzamVar2.zzr());
    }

    private final boolean zzaj(com.google.android.gms.internal.measurement.zzfs zzfsVar, com.google.android.gms.internal.measurement.zzfs zzfsVar2) {
        Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzB = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC(), "_sc");
        String zzh = zzB == null ? null : zzB.zzh();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzB2 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaC(), "_pc");
        String zzh2 = zzB2 != null ? zzB2.zzh() : null;
        if (zzh2 == null || !zzh2.equals(zzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzB3 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC(), "_et");
        if (zzB3 == null || !zzB3.zzw() || zzB3.zzd() <= 0) {
            return true;
        }
        long zzd = zzB3.zzd();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzB4 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaC(), "_et");
        if (zzB4 != null && zzB4.zzd() > 0) {
            zzd += zzB4.zzd();
        }
        zzal(this.zzi);
        zzkv.zzz(zzfsVar2, "_et", Long.valueOf(zzd));
        zzal(this.zzi);
        zzkv.zzz(zzfsVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzqVar) {
        return (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) ? false : true;
    }

    private static final zzkh zzal(zzkh zzkhVar) {
        if (zzkhVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkhVar.zzY()) {
            return zzkhVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkhVar.getClass())));
    }

    public static zzkt zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                if (zzb == null) {
                    zzb = new zzkt((zzku) Preconditions.checkNotNull(new zzku(context)), null);
                }
            }
        }
        return zzb;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzkt zzktVar, zzku zzkuVar) {
        zzktVar.zzaz().zzg();
        zzktVar.zzm = new zzez(zzktVar);
        zzam zzamVar = new zzam(zzktVar);
        zzamVar.zzX();
        zzktVar.zze = zzamVar;
        zzktVar.zzg().zzq((zzaf) Preconditions.checkNotNull(zzktVar.zzc));
        zzjo zzjoVar = new zzjo(zzktVar);
        zzjoVar.zzX();
        zzktVar.zzk = zzjoVar;
        zzaa zzaaVar = new zzaa(zzktVar);
        zzaaVar.zzX();
        zzktVar.zzh = zzaaVar;
        zzic zzicVar = new zzic(zzktVar);
        zzicVar.zzX();
        zzktVar.zzj = zzicVar;
        zzkf zzkfVar = new zzkf(zzktVar);
        zzkfVar.zzX();
        zzktVar.zzg = zzkfVar;
        zzktVar.zzf = new zzep(zzktVar);
        if (zzktVar.zzr != zzktVar.zzs) {
            zzktVar.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzktVar.zzr), Integer.valueOf(zzktVar.zzs));
        }
        zzktVar.zzo = true;
    }

    @VisibleForTesting
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzZ()) {
            FileChannel fileChannel = this.zzx;
            zzaz().zzg();
            int i10 = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzay().zzd().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i10 = allocate.getInt();
                    } else if (read != -1) {
                        zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e10) {
                    zzay().zzd().zzb("Failed to read from channel", e10);
                }
            }
            int zzi = this.zzn.zzh().zzi();
            zzaz().zzg();
            if (i10 > zzi) {
                zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi));
                return;
            }
            if (i10 < zzi) {
                FileChannel fileChannel2 = this.zzx;
                zzaz().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzi);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi));
                        return;
                    } catch (IOException e11) {
                        zzay().zzd().zzb("Failed to write to channel", e11);
                    }
                }
                zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi));
            }
        }
    }

    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzC(String str, com.google.android.gms.internal.measurement.zzgc zzgcVar) {
        int zza;
        int indexOf;
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        Set zzk = zzfiVar.zzk(str);
        if (zzk != null) {
            zzgcVar.zzi(zzk);
        }
        zzfi zzfiVar2 = this.zzc;
        zzal(zzfiVar2);
        if (zzfiVar2.zzv(str)) {
            zzgcVar.zzp();
        }
        zzfi zzfiVar3 = this.zzc;
        zzal(zzfiVar3);
        if (zzfiVar3.zzy(str)) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String zzar = zzgcVar.zzar();
                if (!TextUtils.isEmpty(zzar) && (indexOf = zzar.indexOf(".")) != -1) {
                    zzgcVar.zzY(zzar.substring(0, indexOf));
                }
            } else {
                zzgcVar.zzu();
            }
        }
        zzfi zzfiVar4 = this.zzc;
        zzal(zzfiVar4);
        if (zzfiVar4.zzz(str) && (zza = zzkv.zza(zzgcVar, bx.f10121d)) != -1) {
            zzgcVar.zzB(zza);
        }
        zzfi zzfiVar5 = this.zzc;
        zzal(zzfiVar5);
        if (zzfiVar5.zzx(str)) {
            zzgcVar.zzq();
        }
        zzfi zzfiVar6 = this.zzc;
        zzal(zzfiVar6);
        if (zzfiVar6.zzu(str)) {
            zzgcVar.zzn();
            zzks zzksVar = (zzks) this.zzC.get(str);
            if (zzksVar == null || zzksVar.zzb + zzg().zzi(str, zzdu.zzR) < zzav().elapsedRealtime()) {
                zzksVar = new zzks(this);
                this.zzC.put(str, zzksVar);
            }
            zzgcVar.zzR(zzksVar.zza);
        }
        zzfi zzfiVar7 = this.zzc;
        zzal(zzfiVar7);
        if (zzfiVar7.zzw(str)) {
            zzgcVar.zzy();
        }
    }

    public final void zzD(zzh zzhVar) {
        androidx.collection.a aVar;
        androidx.collection.a aVar2;
        zzaz().zzg();
        if (TextUtils.isEmpty(zzhVar.zzy()) && TextUtils.isEmpty(zzhVar.zzr())) {
            zzI((String) Preconditions.checkNotNull(zzhVar.zzt()), 204, null, null, null);
            return;
        }
        zzki zzkiVar = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String zzy = zzhVar.zzy();
        if (TextUtils.isEmpty(zzy)) {
            zzy = zzhVar.zzr();
        }
        androidx.collection.a aVar3 = null;
        Uri.Builder appendQueryParameter = builder.scheme((String) zzdu.zzd.zza(null)).encodedAuthority((String) zzdu.zze.zza(null)).path("config/app/".concat(String.valueOf(zzy))).appendQueryParameter(DispatchConstants.PLATFORM, "android");
        zzkiVar.zzt.zzf().zzh();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            String str = (String) Preconditions.checkNotNull(zzhVar.zzt());
            URL url = new URL(uri);
            zzay().zzj().zzb("Fetching remote configuration", str);
            zzfi zzfiVar = this.zzc;
            zzal(zzfiVar);
            com.google.android.gms.internal.measurement.zzff zze = zzfiVar.zze(str);
            zzfi zzfiVar2 = this.zzc;
            zzal(zzfiVar2);
            String zzh = zzfiVar2.zzh(str);
            if (zze != null) {
                if (TextUtils.isEmpty(zzh)) {
                    aVar2 = null;
                } else {
                    aVar2 = new androidx.collection.a();
                    aVar2.put(HttpHeaders.IF_MODIFIED_SINCE, zzh);
                }
                zzox.zzc();
                if (zzg().zzs(null, zzdu.zzao)) {
                    zzfi zzfiVar3 = this.zzc;
                    zzal(zzfiVar3);
                    String zzf = zzfiVar3.zzf(str);
                    if (!TextUtils.isEmpty(zzf)) {
                        if (aVar2 == null) {
                            aVar2 = new androidx.collection.a();
                        }
                        aVar3 = aVar2;
                        aVar3.put(HttpHeaders.IF_NONE_MATCH, zzf);
                    }
                }
                aVar = aVar2;
                this.zzt = true;
                zzen zzenVar = this.zzd;
                zzal(zzenVar);
                zzkl zzklVar = new zzkl(this);
                zzenVar.zzg();
                zzenVar.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzklVar);
                zzenVar.zzt.zzaz().zzo(new zzem(zzenVar, str, url, null, aVar, zzklVar));
            }
            aVar = aVar3;
            this.zzt = true;
            zzen zzenVar2 = this.zzd;
            zzal(zzenVar2);
            zzkl zzklVar2 = new zzkl(this);
            zzenVar2.zzg();
            zzenVar2.zzW();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzklVar2);
            zzenVar2.zzt.zzaz().zzo(new zzem(zzenVar2, str, url, null, aVar, zzklVar2));
        } catch (MalformedURLException unused) {
            zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(zzhVar.zzt()), uri);
        }
    }

    public final void zzE(zzaw zzawVar, zzq zzqVar) {
        zzaw zzawVar2;
        List<zzac> zzt;
        List<zzac> zzt2;
        List<zzac> zzt3;
        String str;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzqVar.zza;
        long j10 = zzawVar.zzd;
        zzei zzb2 = zzei.zzb(zzawVar);
        zzaz().zzg();
        zzie zzieVar = null;
        if (this.zzD != null && (str = this.zzE) != null && str.equals(str2)) {
            zzieVar = this.zzD;
        }
        zzlb.zzK(zzieVar, zzb2.zzd, false);
        zzaw zza = zzb2.zza();
        zzal(this.zzi);
        if (zzkv.zzA(zza, zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            List list = zzqVar.zzt;
            if (list == null) {
                zzawVar2 = zza;
            } else if (!list.contains(zza.zza)) {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza.zza, zza.zzc);
                return;
            } else {
                Bundle zzc = zza.zzb.zzc();
                zzc.putLong("ga_safelisted", 1L);
                zzawVar2 = new zzaw(zza.zza, new zzau(zzc), zza.zzc, zza.zzd);
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                Preconditions.checkNotEmpty(str2);
                zzamVar2.zzg();
                zzamVar2.zzW();
                if (j10 < 0) {
                    zzamVar2.zzt.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    zzt = Collections.emptyList();
                } else {
                    zzt = zzamVar2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzac zzacVar : zzt) {
                    if (zzacVar != null) {
                        zzay().zzj().zzd("User property timed out", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb), zzacVar.zzc.zza());
                        zzaw zzawVar3 = zzacVar.zzg;
                        if (zzawVar3 != null) {
                            zzY(new zzaw(zzawVar3, j10), zzqVar);
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zza(str2, zzacVar.zzc.zzb);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                Preconditions.checkNotEmpty(str2);
                zzamVar4.zzg();
                zzamVar4.zzW();
                if (j10 < 0) {
                    zzamVar4.zzt.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    zzt2 = Collections.emptyList();
                } else {
                    zzt2 = zzamVar4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList arrayList = new ArrayList(zzt2.size());
                for (zzac zzacVar2 : zzt2) {
                    if (zzacVar2 != null) {
                        zzay().zzj().zzd("User property expired", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(str2, zzacVar2.zzc.zzb);
                        zzaw zzawVar4 = zzacVar2.zzk;
                        if (zzawVar4 != null) {
                            arrayList.add(zzawVar4);
                        }
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zza(str2, zzacVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzY(new zzaw((zzaw) it.next(), j10), zzqVar);
                }
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                String str3 = zzawVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzamVar7.zzg();
                zzamVar7.zzW();
                if (j10 < 0) {
                    zzamVar7.zzt.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzamVar7.zzt.zzj().zzd(str3), Long.valueOf(j10));
                    zzt3 = Collections.emptyList();
                } else {
                    zzt3 = zzamVar7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList arrayList2 = new ArrayList(zzt3.size());
                for (zzac zzacVar3 : zzt3) {
                    if (zzacVar3 != null) {
                        zzkw zzkwVar = zzacVar3.zzc;
                        zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzacVar3.zza), zzacVar3.zzb, zzkwVar.zzb, j10, Preconditions.checkNotNull(zzkwVar.zza()));
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        if (zzamVar8.zzL(zzkyVar)) {
                            zzay().zzj().zzd("User property triggered", zzacVar3.zza, this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzacVar3.zza), this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                        }
                        zzaw zzawVar5 = zzacVar3.zzi;
                        if (zzawVar5 != null) {
                            arrayList2.add(zzawVar5);
                        }
                        zzacVar3.zzc = new zzkw(zzkyVar);
                        zzacVar3.zze = true;
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzK(zzacVar3);
                    }
                }
                zzY(zzawVar2, zzqVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzY(new zzaw((zzaw) it2.next(), j10), zzqVar);
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzC();
            } finally {
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            }
        }
    }

    public final void zzF(zzaw zzawVar, String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzj = zzamVar.zzj(str);
        if (zzj == null || TextUtils.isEmpty(zzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzad = zzad(zzj);
        if (zzad == null) {
            if (!"_ui".equals(zzawVar.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        String zzy = zzj.zzy();
        String zzw = zzj.zzw();
        long zzb2 = zzj.zzb();
        String zzv = zzj.zzv();
        long zzm = zzj.zzm();
        long zzj2 = zzj.zzj();
        boolean zzai = zzj.zzai();
        String zzx = zzj.zzx();
        zzj.zza();
        zzG(zzawVar, new zzq(str, zzy, zzw, zzb2, zzv, zzm, zzj2, (String) null, zzai, false, zzx, 0L, 0L, 0, zzj.zzah(), false, zzj.zzr(), zzj.zzq(), zzj.zzk(), zzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null));
    }

    public final void zzG(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzei zzb2 = zzei.zzb(zzawVar);
        zzlb zzv = zzv();
        Bundle bundle = zzb2.zzd;
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzv.zzL(bundle, zzamVar.zzi(zzqVar.zza));
        zzv().zzM(zzb2, zzg().zzd(zzqVar.zza));
        zzaw zza = zzb2.zza();
        if ("_cmp".equals(zza.zza) && "referrer API v2".equals(zza.zzb.zzg("_cis"))) {
            String zzg = zza.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg)) {
                zzW(new zzkw("_lgclid", zza.zzd, zzg, ConnType.PK_AUTO), zzqVar);
            }
        }
        zzE(zza, zzqVar);
    }

    public final void zzH() {
        this.zzs++;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[Catch: all -> 0x0186, TryCatch #1 {all -> 0x0186, blocks: (B:5:0x002c, B:13:0x004a, B:14:0x0170, B:24:0x0064, B:28:0x00b6, B:29:0x00a7, B:32:0x00be, B:34:0x00ca, B:36:0x00d0, B:37:0x00d8, B:40:0x00e9, B:42:0x00f5, B:44:0x00fb, B:48:0x0108, B:49:0x0124, B:51:0x0139, B:52:0x0158, B:54:0x0163, B:56:0x0169, B:57:0x016d, B:58:0x0147, B:59:0x0111, B:61:0x011c), top: B:4:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0139 A[Catch: all -> 0x0186, TryCatch #1 {all -> 0x0186, blocks: (B:5:0x002c, B:13:0x004a, B:14:0x0170, B:24:0x0064, B:28:0x00b6, B:29:0x00a7, B:32:0x00be, B:34:0x00ca, B:36:0x00d0, B:37:0x00d8, B:40:0x00e9, B:42:0x00f5, B:44:0x00fb, B:48:0x0108, B:49:0x0124, B:51:0x0139, B:52:0x0158, B:54:0x0163, B:56:0x0169, B:57:0x016d, B:58:0x0147, B:59:0x0111, B:61:0x011c), top: B:4:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0163 A[Catch: all -> 0x0186, TryCatch #1 {all -> 0x0186, blocks: (B:5:0x002c, B:13:0x004a, B:14:0x0170, B:24:0x0064, B:28:0x00b6, B:29:0x00a7, B:32:0x00be, B:34:0x00ca, B:36:0x00d0, B:37:0x00d8, B:40:0x00e9, B:42:0x00f5, B:44:0x00fb, B:48:0x0108, B:49:0x0124, B:51:0x0139, B:52:0x0158, B:54:0x0163, B:56:0x0169, B:57:0x016d, B:58:0x0147, B:59:0x0111, B:61:0x011c), top: B:4:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147 A[Catch: all -> 0x0186, TryCatch #1 {all -> 0x0186, blocks: (B:5:0x002c, B:13:0x004a, B:14:0x0170, B:24:0x0064, B:28:0x00b6, B:29:0x00a7, B:32:0x00be, B:34:0x00ca, B:36:0x00d0, B:37:0x00d8, B:40:0x00e9, B:42:0x00f5, B:44:0x00fb, B:48:0x0108, B:49:0x0124, B:51:0x0139, B:52:0x0158, B:54:0x0163, B:56:0x0169, B:57:0x016d, B:58:0x0147, B:59:0x0111, B:61:0x011c), top: B:4:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c A[Catch: all -> 0x0186, TryCatch #1 {all -> 0x0186, blocks: (B:5:0x002c, B:13:0x004a, B:14:0x0170, B:24:0x0064, B:28:0x00b6, B:29:0x00a7, B:32:0x00be, B:34:0x00ca, B:36:0x00d0, B:37:0x00d8, B:40:0x00e9, B:42:0x00f5, B:44:0x00fb, B:48:0x0108, B:49:0x0124, B:51:0x0139, B:52:0x0158, B:54:0x0163, B:56:0x0169, B:57:0x016d, B:58:0x0147, B:59:0x0111, B:61:0x011c), top: B:4:0x002c, outer: #0 }] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzI(String str, int i10, Throwable th, byte[] bArr, Map map) {
        boolean z10;
        String str2;
        zzfi zzfiVar;
        zzen zzenVar;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzt = false;
                zzae();
            }
        }
        zzef zzj = zzay().zzj();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzj.zzb("onConfigFetched. Response size", valueOf);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzh zzj2 = zzamVar2.zzj(str);
            if (i10 != 200 && i10 != 204) {
                if (i10 == 304) {
                    i10 = 304;
                }
                z10 = false;
                if (zzj2 == null) {
                    zzay().zzk().zzb("App does not exist in onConfigFetched. appId", zzeh.zzn(str));
                } else {
                    if (!z10 && i10 != 404) {
                        zzj2.zzU(zzav().currentTimeMillis());
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zzD(zzj2);
                        zzay().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i10), th);
                        zzfi zzfiVar2 = this.zzc;
                        zzal(zzfiVar2);
                        zzfiVar2.zzl(str);
                        this.zzk.zzd.zzb(zzav().currentTimeMillis());
                        if (i10 == 503 || i10 == 429) {
                            this.zzk.zzb.zzb(zzav().currentTimeMillis());
                        }
                        zzag();
                    }
                    List list = map != null ? (List) map.get("Last-Modified") : null;
                    String str3 = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                    zzox.zzc();
                    if (zzg().zzs(null, zzdu.zzao)) {
                        List list2 = map != null ? (List) map.get("ETag") : null;
                        if (list2 != null && !list2.isEmpty()) {
                            str2 = (String) list2.get(0);
                            if (i10 != 404 && i10 != 304) {
                                zzfi zzfiVar3 = this.zzc;
                                zzal(zzfiVar3);
                                zzfiVar3.zzt(str, bArr, str3, str2);
                                zzj2.zzL(zzav().currentTimeMillis());
                                zzam zzamVar4 = this.zze;
                                zzal(zzamVar4);
                                zzamVar4.zzD(zzj2);
                                if (i10 != 404) {
                                    zzay().zzl().zzb("Config not found. Using empty config. appId", str);
                                } else {
                                    zzay().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i10), valueOf);
                                }
                                zzenVar = this.zzd;
                                zzal(zzenVar);
                                if (zzenVar.zza() || !zzai()) {
                                    zzag();
                                } else {
                                    zzX();
                                }
                            }
                            zzfiVar = this.zzc;
                            zzal(zzfiVar);
                            if (zzfiVar.zze(str) == null) {
                                zzfi zzfiVar4 = this.zzc;
                                zzal(zzfiVar4);
                                zzfiVar4.zzt(str, null, null, null);
                            }
                            zzj2.zzL(zzav().currentTimeMillis());
                            zzam zzamVar42 = this.zze;
                            zzal(zzamVar42);
                            zzamVar42.zzD(zzj2);
                            if (i10 != 404) {
                            }
                            zzenVar = this.zzd;
                            zzal(zzenVar);
                            if (zzenVar.zza()) {
                            }
                            zzag();
                        }
                    }
                    str2 = null;
                    if (i10 != 404) {
                        zzfi zzfiVar32 = this.zzc;
                        zzal(zzfiVar32);
                        zzfiVar32.zzt(str, bArr, str3, str2);
                        zzj2.zzL(zzav().currentTimeMillis());
                        zzam zzamVar422 = this.zze;
                        zzal(zzamVar422);
                        zzamVar422.zzD(zzj2);
                        if (i10 != 404) {
                        }
                        zzenVar = this.zzd;
                        zzal(zzenVar);
                        if (zzenVar.zza()) {
                        }
                        zzag();
                    }
                    zzfiVar = this.zzc;
                    zzal(zzfiVar);
                    if (zzfiVar.zze(str) == null) {
                    }
                    zzj2.zzL(zzav().currentTimeMillis());
                    zzam zzamVar4222 = this.zze;
                    zzal(zzamVar4222);
                    zzamVar4222.zzD(zzj2);
                    if (i10 != 404) {
                    }
                    zzenVar = this.zzd;
                    zzal(zzenVar);
                    if (zzenVar.zza()) {
                    }
                    zzag();
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            }
            if (th == null) {
                z10 = true;
                if (zzj2 == null) {
                }
                zzam zzamVar52 = this.zze;
                zzal(zzamVar52);
                zzamVar52.zzC();
            }
            z10 = false;
            if (zzj2 == null) {
            }
            zzam zzamVar522 = this.zze;
            zzal(zzamVar522);
            zzamVar522.zzC();
        } finally {
            zzam zzamVar6 = this.zze;
            zzal(zzamVar6);
            zzamVar6.zzx();
        }
    }

    public final void zzJ(boolean z10) {
        zzag();
    }

    @VisibleForTesting
    public final void zzK(int i10, Throwable th, byte[] bArr, String str) {
        zzam zzamVar;
        long longValue;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzae();
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i10 != 503 || i10 == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzy(list);
            zzag();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0L);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzamVar3.zzw();
            } catch (SQLiteException e10) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e10);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            try {
                for (Long l10 : list) {
                    try {
                        zzamVar = this.zze;
                        zzal(zzamVar);
                        longValue = l10.longValue();
                        zzamVar.zzg();
                        zzamVar.zzW();
                    } catch (SQLiteException e11) {
                        List list2 = this.zzz;
                        if (list2 == null || !list2.contains(l10)) {
                            throw e11;
                        }
                    }
                    try {
                        if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    } catch (SQLiteException e12) {
                        zzamVar.zzt.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e12);
                        throw e12;
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzC();
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzx();
                this.zzz = null;
                zzen zzenVar = this.zzd;
                zzal(zzenVar);
                if (zzenVar.zza() && zzai()) {
                    zzX();
                } else {
                    this.zzA = -1L;
                    zzag();
                }
                this.zza = 0L;
            } catch (Throwable th2) {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
                throw th2;
            }
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        if (i10 != 503) {
        }
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzam zzamVar22 = this.zze;
        zzal(zzamVar22);
        zzamVar22.zzy(list);
        zzag();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:94|95|(2:97|(11:99|(3:101|(2:103|(1:105))(1:130)|106)(1:131)|107|(1:109)(1:129)|110|111|112|113|114|115|(4:117|(1:119)|120|(1:122))))|132|111|112|113|114|115|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x04bd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x04c2, code lost:
    
        zzay().zzd().zzc("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r13), r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x04bf, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x04c0, code lost:
    
        r13 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04d6 A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0551 A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x026c A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0203 A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025d A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027c A[Catch: all -> 0x057f, TRY_LEAVE, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03f1 A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x041d A[Catch: all -> 0x057f, TRY_LEAVE, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04f1 A[Catch: all -> 0x057f, TryCatch #7 {all -> 0x057f, blocks: (B:24:0x00a4, B:26:0x00b3, B:30:0x0117, B:32:0x012a, B:34:0x0140, B:36:0x0167, B:39:0x01c2, B:41:0x01c8, B:43:0x01d1, B:47:0x0203, B:49:0x020e, B:52:0x021b, B:55:0x022c, B:58:0x0237, B:60:0x023a, B:63:0x0258, B:65:0x025d, B:67:0x027c, B:70:0x0290, B:72:0x02b6, B:75:0x02be, B:77:0x02cd, B:79:0x03bd, B:81:0x03f1, B:82:0x03f4, B:84:0x041d, B:88:0x04f1, B:89:0x04f4, B:90:0x056e, B:95:0x0432, B:97:0x0456, B:99:0x045e, B:101:0x0466, B:105:0x0479, B:107:0x048a, B:110:0x0496, B:112:0x04ac, B:115:0x04b8, B:117:0x04d6, B:119:0x04db, B:120:0x04e0, B:122:0x04e6, B:125:0x04c2, B:130:0x0482, B:135:0x0442, B:136:0x02e0, B:138:0x030b, B:139:0x031b, B:141:0x0322, B:143:0x0328, B:145:0x0332, B:147:0x0338, B:149:0x033e, B:151:0x0344, B:153:0x0349, B:156:0x0354, B:160:0x036c, B:163:0x0374, B:167:0x0388, B:169:0x039b, B:170:0x03ac, B:171:0x0509, B:173:0x0539, B:174:0x053c, B:175:0x0551, B:177:0x0555, B:178:0x026c, B:180:0x01ea, B:185:0x00c5, B:187:0x00c9, B:190:0x00da, B:192:0x00f1, B:194:0x00fb, B:198:0x0107), top: B:23:0x00a4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0432 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzL(zzq zzqVar) {
        String str;
        String str2;
        zzh zzj;
        String str3;
        zzas zzn;
        boolean z10;
        int i10;
        long zzc;
        PackageInfo packageInfo;
        String str4;
        String str5;
        int i11;
        int i12;
        ApplicationInfo applicationInfo;
        boolean z11;
        SQLiteDatabase zzh;
        String[] strArr;
        int delete;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        if (zzak(zzqVar)) {
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzh zzj2 = zzamVar.zzj(zzqVar.zza);
            if (zzj2 != null && TextUtils.isEmpty(zzj2.zzy()) && !TextUtils.isEmpty(zzqVar.zzb)) {
                zzj2.zzL(0L);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzamVar2.zzD(zzj2);
                zzfi zzfiVar = this.zzc;
                zzal(zzfiVar);
                zzfiVar.zzm(zzqVar.zza);
            }
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            long j10 = zzqVar.zzm;
            if (j10 == 0) {
                j10 = zzav().currentTimeMillis();
            }
            this.zzn.zzg().zzd();
            int i13 = zzqVar.zzn;
            if (i13 != 0 && i13 != 1) {
                zzay().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzeh.zzn(zzqVar.zza), Integer.valueOf(i13));
                i13 = 0;
            }
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzw();
            try {
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzky zzp = zzamVar4.zzp(zzqVar.zza, "_npa");
                if (zzp != null && !ConnType.PK_AUTO.equals(zzp.zzb)) {
                    str = "_sysu";
                    str2 = "_sys";
                    zzam zzamVar5 = this.zze;
                    zzal(zzamVar5);
                    zzj = zzamVar5.zzj((String) Preconditions.checkNotNull(zzqVar.zza));
                    if (zzj == null && zzv().zzam(zzqVar.zzb, zzj.zzy(), zzqVar.zzq, zzj.zzr())) {
                        zzay().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzeh.zzn(zzj.zzt()));
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        String zzt = zzj.zzt();
                        zzamVar6.zzW();
                        zzamVar6.zzg();
                        Preconditions.checkNotEmpty(zzt);
                        try {
                            zzh = zzamVar6.zzh();
                            strArr = new String[]{zzt};
                            delete = zzh.delete(f.ax, "app_id=?", strArr) + zzh.delete("user_attributes", "app_id=?", strArr) + zzh.delete("conditional_properties", "app_id=?", strArr) + zzh.delete("apps", "app_id=?", strArr) + zzh.delete("raw_events", "app_id=?", strArr) + zzh.delete("raw_events_metadata", "app_id=?", strArr) + zzh.delete("event_filters", "app_id=?", strArr) + zzh.delete("property_filters", "app_id=?", strArr) + zzh.delete("audience_filter_values", "app_id=?", strArr) + zzh.delete("consent_settings", "app_id=?", strArr);
                            zzoi.zzc();
                            str3 = "_pfo";
                        } catch (SQLiteException e10) {
                            e = e10;
                            str3 = "_pfo";
                        }
                        try {
                            if (zzamVar6.zzt.zzf().zzs(null, zzdu.zzat)) {
                                delete += zzh.delete("default_event_params", "app_id=?", strArr);
                            }
                            if (delete > 0) {
                                zzamVar6.zzt.zzay().zzj().zzc("Deleted application data. app, records", zzt, Integer.valueOf(delete));
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            zzamVar6.zzt.zzay().zzd().zzc("Error deleting application data. appId, error", zzeh.zzn(zzt), e);
                            zzj = null;
                            if (zzj != null) {
                            }
                            zzd(zzqVar);
                            if (i13 == 0) {
                            }
                            if (zzn == null) {
                            }
                            zzam zzamVar7 = this.zze;
                            zzal(zzamVar7);
                            zzamVar7.zzC();
                        }
                        zzj = null;
                    } else {
                        str3 = "_pfo";
                    }
                    if (zzj != null) {
                        boolean z12 = (zzj.zzb() == -2147483648L || zzj.zzb() == zzqVar.zzj) ? false : true;
                        String zzw = zzj.zzw();
                        if (z12 | ((zzj.zzb() != -2147483648L || zzw == null || zzw.equals(zzqVar.zzc)) ? false : true)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", zzw);
                            zzE(new zzaw("_au", new zzau(bundle), ConnType.PK_AUTO, j10), zzqVar);
                        }
                    }
                    zzd(zzqVar);
                    if (i13 == 0) {
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        zzn = zzamVar8.zzn(zzqVar.zza, "_f");
                        z10 = false;
                    } else {
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzn = zzamVar9.zzn(zzqVar.zza, "_v");
                        z10 = true;
                    }
                    if (zzn == null) {
                        long j11 = ((j10 / 3600000) + 1) * 3600000;
                        if (z10) {
                            zzW(new zzkw("_fvt", j10, Long.valueOf(j11), ConnType.PK_AUTO), zzqVar);
                            zzaz().zzg();
                            zzB();
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("_c", 1L);
                            bundle2.putLong("_r", 1L);
                            bundle2.putLong("_et", 1L);
                            if (zzqVar.zzp) {
                                bundle2.putLong("_dac", 1L);
                            }
                            zzG(new zzaw("_v", new zzau(bundle2), ConnType.PK_AUTO, j10), zzqVar);
                        } else {
                            zzW(new zzkw("_fot", j10, Long.valueOf(j11), ConnType.PK_AUTO), zzqVar);
                            zzaz().zzg();
                            zzez zzezVar = (zzez) Preconditions.checkNotNull(this.zzm);
                            String str6 = zzqVar.zza;
                            if (str6 != null && !str6.isEmpty()) {
                                zzezVar.zza.zzaz().zzg();
                                if (zzezVar.zza()) {
                                    zzey zzeyVar = new zzey(zzezVar, str6);
                                    zzezVar.zza.zzaz().zzg();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzezVar.zza.zzau().getPackageManager();
                                    if (packageManager == null) {
                                        zzezVar.zza.zzay().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        i10 = 0;
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                                            zzezVar.zza.zzay().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                                            if (serviceInfo != null) {
                                                String str7 = serviceInfo.packageName;
                                                if (serviceInfo.name != null && "com.android.vending".equals(str7) && zzezVar.zza()) {
                                                    try {
                                                    } catch (RuntimeException e12) {
                                                        e = e12;
                                                    }
                                                    try {
                                                        zzezVar.zza.zzay().zzj().zzb("Install Referrer Service is", true != ConnectionTracker.getInstance().bindService(zzezVar.zza.zzau(), new Intent(intent), zzeyVar, 1) ? "not available" : "available");
                                                    } catch (RuntimeException e13) {
                                                        e = e13;
                                                        zzezVar.zza.zzay().zzd().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                        zzaz().zzg();
                                                        zzB();
                                                        Bundle bundle3 = new Bundle();
                                                        bundle3.putLong("_c", 1L);
                                                        bundle3.putLong("_r", 1L);
                                                        bundle3.putLong("_uwa", 0L);
                                                        String str8 = str3;
                                                        bundle3.putLong(str8, 0L);
                                                        String str9 = str2;
                                                        bundle3.putLong(str9, 0L);
                                                        String str10 = str;
                                                        bundle3.putLong(str10, 0L);
                                                        bundle3.putLong("_et", 1L);
                                                        if (zzqVar.zzp) {
                                                        }
                                                        String str11 = (String) Preconditions.checkNotNull(zzqVar.zza);
                                                        zzam zzamVar10 = this.zze;
                                                        zzal(zzamVar10);
                                                        Preconditions.checkNotEmpty(str11);
                                                        zzamVar10.zzg();
                                                        zzamVar10.zzW();
                                                        zzc = zzamVar10.zzc(str11, "first_open_count");
                                                        if (this.zzn.zzau().getPackageManager() != null) {
                                                        }
                                                        if (zzc >= 0) {
                                                        }
                                                        zzG(new zzaw("_f", new zzau(bundle3), ConnType.PK_AUTO, j10), zzqVar);
                                                        zzam zzamVar72 = this.zze;
                                                        zzal(zzamVar72);
                                                        zzamVar72.zzC();
                                                    }
                                                } else {
                                                    zzezVar.zza.zzay().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                }
                                            }
                                        }
                                        zzaz().zzg();
                                        zzB();
                                        Bundle bundle32 = new Bundle();
                                        bundle32.putLong("_c", 1L);
                                        bundle32.putLong("_r", 1L);
                                        bundle32.putLong("_uwa", 0L);
                                        String str82 = str3;
                                        bundle32.putLong(str82, 0L);
                                        String str92 = str2;
                                        bundle32.putLong(str92, 0L);
                                        String str102 = str;
                                        bundle32.putLong(str102, 0L);
                                        bundle32.putLong("_et", 1L);
                                        if (zzqVar.zzp) {
                                            bundle32.putLong("_dac", 1L);
                                        }
                                        String str112 = (String) Preconditions.checkNotNull(zzqVar.zza);
                                        zzam zzamVar102 = this.zze;
                                        zzal(zzamVar102);
                                        Preconditions.checkNotEmpty(str112);
                                        zzamVar102.zzg();
                                        zzamVar102.zzW();
                                        zzc = zzamVar102.zzc(str112, "first_open_count");
                                        if (this.zzn.zzau().getPackageManager() != null) {
                                            zzay().zzd().zzb("PackageManager is null, first open report might be inaccurate. appId", zzeh.zzn(str112));
                                        } else {
                                            try {
                                                packageInfo = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(str112, i10);
                                            } catch (PackageManager.NameNotFoundException e14) {
                                                zzay().zzd().zzc("Package info is null, first open report might be inaccurate. appId", zzeh.zzn(str112), e14);
                                                packageInfo = null;
                                            }
                                            if (packageInfo != null) {
                                                long j12 = packageInfo.firstInstallTime;
                                                if (j12 != 0) {
                                                    str4 = str112;
                                                    if (j12 != packageInfo.lastUpdateTime) {
                                                        if (!zzg().zzs(null, zzdu.zzab)) {
                                                            bundle32.putLong("_uwa", 1L);
                                                        } else if (zzc == 0) {
                                                            bundle32.putLong("_uwa", 1L);
                                                            zzc = 0;
                                                        }
                                                        z11 = false;
                                                    } else {
                                                        z11 = true;
                                                    }
                                                    i11 = 1;
                                                    str5 = str102;
                                                    i12 = 0;
                                                    zzW(new zzkw("_fi", j10, Long.valueOf(true != z11 ? 0L : 1L), ConnType.PK_AUTO), zzqVar);
                                                    String str12 = str4;
                                                    applicationInfo = Wrappers.packageManager(this.zzn.zzau()).getApplicationInfo(str12, i12);
                                                    if (applicationInfo != null) {
                                                        if ((i11 & applicationInfo.flags) != 0) {
                                                            bundle32.putLong(str92, 1L);
                                                        }
                                                        if ((applicationInfo.flags & 128) != 0) {
                                                            bundle32.putLong(str5, 1L);
                                                        }
                                                    }
                                                }
                                            }
                                            str4 = str112;
                                            str5 = str102;
                                            i11 = 1;
                                            i12 = 0;
                                            String str122 = str4;
                                            applicationInfo = Wrappers.packageManager(this.zzn.zzau()).getApplicationInfo(str122, i12);
                                            if (applicationInfo != null) {
                                            }
                                        }
                                        if (zzc >= 0) {
                                            bundle32.putLong(str82, zzc);
                                        }
                                        zzG(new zzaw("_f", new zzau(bundle32), ConnType.PK_AUTO, j10), zzqVar);
                                    }
                                } else {
                                    zzezVar.zza.zzay().zzi().zza("Install Referrer Reporter is not available");
                                }
                                i10 = 0;
                                zzaz().zzg();
                                zzB();
                                Bundle bundle322 = new Bundle();
                                bundle322.putLong("_c", 1L);
                                bundle322.putLong("_r", 1L);
                                bundle322.putLong("_uwa", 0L);
                                String str822 = str3;
                                bundle322.putLong(str822, 0L);
                                String str922 = str2;
                                bundle322.putLong(str922, 0L);
                                String str1022 = str;
                                bundle322.putLong(str1022, 0L);
                                bundle322.putLong("_et", 1L);
                                if (zzqVar.zzp) {
                                }
                                String str1122 = (String) Preconditions.checkNotNull(zzqVar.zza);
                                zzam zzamVar1022 = this.zze;
                                zzal(zzamVar1022);
                                Preconditions.checkNotEmpty(str1122);
                                zzamVar1022.zzg();
                                zzamVar1022.zzW();
                                zzc = zzamVar1022.zzc(str1122, "first_open_count");
                                if (this.zzn.zzau().getPackageManager() != null) {
                                }
                                if (zzc >= 0) {
                                }
                                zzG(new zzaw("_f", new zzau(bundle322), ConnType.PK_AUTO, j10), zzqVar);
                            }
                            i10 = 0;
                            zzezVar.zza.zzay().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaz().zzg();
                            zzB();
                            Bundle bundle3222 = new Bundle();
                            bundle3222.putLong("_c", 1L);
                            bundle3222.putLong("_r", 1L);
                            bundle3222.putLong("_uwa", 0L);
                            String str8222 = str3;
                            bundle3222.putLong(str8222, 0L);
                            String str9222 = str2;
                            bundle3222.putLong(str9222, 0L);
                            String str10222 = str;
                            bundle3222.putLong(str10222, 0L);
                            bundle3222.putLong("_et", 1L);
                            if (zzqVar.zzp) {
                            }
                            String str11222 = (String) Preconditions.checkNotNull(zzqVar.zza);
                            zzam zzamVar10222 = this.zze;
                            zzal(zzamVar10222);
                            Preconditions.checkNotEmpty(str11222);
                            zzamVar10222.zzg();
                            zzamVar10222.zzW();
                            zzc = zzamVar10222.zzc(str11222, "first_open_count");
                            if (this.zzn.zzau().getPackageManager() != null) {
                            }
                            if (zzc >= 0) {
                            }
                            zzG(new zzaw("_f", new zzau(bundle3222), ConnType.PK_AUTO, j10), zzqVar);
                        }
                    } else if (zzqVar.zzi) {
                        zzG(new zzaw("_cd", new zzau(new Bundle()), ConnType.PK_AUTO, j10), zzqVar);
                    }
                    zzam zzamVar722 = this.zze;
                    zzal(zzamVar722);
                    zzamVar722.zzC();
                }
                if (zzqVar.zzr != null) {
                    str = "_sysu";
                    str2 = "_sys";
                    zzkw zzkwVar = new zzkw("_npa", j10, Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), ConnType.PK_AUTO);
                    if (zzp == null || !zzp.zze.equals(zzkwVar.zzd)) {
                        zzW(zzkwVar, zzqVar);
                    }
                } else {
                    str = "_sysu";
                    str2 = "_sys";
                    if (zzp != null) {
                        zzP(new zzkw("_npa", j10, null, ConnType.PK_AUTO), zzqVar);
                    }
                }
                zzam zzamVar52 = this.zze;
                zzal(zzamVar52);
                zzj = zzamVar52.zzj((String) Preconditions.checkNotNull(zzqVar.zza));
                if (zzj == null) {
                }
                str3 = "_pfo";
                if (zzj != null) {
                }
                zzd(zzqVar);
                if (i13 == 0) {
                }
                if (zzn == null) {
                }
                zzam zzamVar7222 = this.zze;
                zzal(zzamVar7222);
                zzamVar7222.zzC();
            } finally {
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            }
        }
    }

    public final void zzM() {
        this.zzr++;
    }

    public final void zzN(zzac zzacVar) {
        zzq zzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzac != null) {
            zzO(zzacVar, zzac);
        }
    }

    public final void zzO(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                String str = (String) Preconditions.checkNotNull(zzacVar.zza);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzk = zzamVar2.zzk(str, zzacVar.zzc.zzb);
                if (zzk != null) {
                    zzay().zzc().zzc("Removing conditional user property", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zza(str, zzacVar.zzc.zzb);
                    if (zzk.zze) {
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzA(str, zzacVar.zzc.zzb);
                    }
                    zzaw zzawVar = zzacVar.zzk;
                    if (zzawVar != null) {
                        zzau zzauVar = zzawVar.zzb;
                        zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzacVar.zzk)).zza, zzauVar != null ? zzauVar.zzc() : null, zzk.zzb, zzacVar.zzk.zzd, true, true)), zzqVar);
                    }
                } else {
                    zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzacVar.zza), this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    public final void zzP(zzkw zzkwVar, zzq zzqVar) {
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            if ("_npa".equals(zzkwVar.zzb) && zzqVar.zzr != null) {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzkw("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), ConnType.PK_AUTO), zzqVar);
                return;
            }
            zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkwVar.zzb));
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                if (bx.f10121d.equals(zzkwVar.zzb)) {
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    zzamVar2.zzA((String) Preconditions.checkNotNull(zzqVar.zza), "_lair");
                }
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzamVar3.zzA((String) Preconditions.checkNotNull(zzqVar.zza), zzkwVar.zzb);
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzC();
                zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkwVar.zzb));
            } finally {
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzx();
            }
        }
    }

    @VisibleForTesting
    public final void zzQ(zzq zzqVar) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        String str = (String) Preconditions.checkNotNull(zzqVar.zza);
        Preconditions.checkNotEmpty(str);
        zzamVar.zzg();
        zzamVar.zzW();
        try {
            SQLiteDatabase zzh = zzamVar.zzh();
            String[] strArr = {str};
            int delete = zzh.delete("apps", "app_id=?", strArr) + zzh.delete(f.ax, "app_id=?", strArr) + zzh.delete("user_attributes", "app_id=?", strArr) + zzh.delete("conditional_properties", "app_id=?", strArr) + zzh.delete("raw_events", "app_id=?", strArr) + zzh.delete("raw_events_metadata", "app_id=?", strArr) + zzh.delete("queue", "app_id=?", strArr) + zzh.delete("audience_filter_values", "app_id=?", strArr) + zzh.delete("main_event_params", "app_id=?", strArr) + zzh.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzamVar.zzt.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            zzamVar.zzt.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e10);
        }
        if (zzqVar.zzh) {
            zzL(zzqVar);
        }
    }

    public final void zzR(String str, zzie zzieVar) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzieVar != null) {
            this.zzE = str;
            this.zzD = zzieVar;
        }
    }

    public final void zzS() {
        zzaz().zzg();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    public final void zzT(zzac zzacVar) {
        zzq zzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzac != null) {
            zzU(zzacVar, zzac);
        }
    }

    public final void zzU(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzb);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzac zzacVar2 = new zzac(zzacVar);
            boolean z10 = false;
            zzacVar2.zze = false;
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzk = zzamVar2.zzk((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzc.zzb);
                if (zzk != null && !zzk.zzb.equals(zzacVar2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzb, zzk.zzb);
                }
                if (zzk != null && zzk.zze) {
                    zzacVar2.zzb = zzk.zzb;
                    zzacVar2.zzd = zzk.zzd;
                    zzacVar2.zzh = zzk.zzh;
                    zzacVar2.zzf = zzk.zzf;
                    zzacVar2.zzi = zzk.zzi;
                    zzacVar2.zze = true;
                    zzkw zzkwVar = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzkwVar.zzb, zzk.zzc.zzc, zzkwVar.zza(), zzk.zzc.zzf);
                } else if (TextUtils.isEmpty(zzacVar2.zzf)) {
                    zzkw zzkwVar2 = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzkwVar2.zzb, zzacVar2.zzd, zzkwVar2.zza(), zzacVar2.zzc.zzf);
                    zzacVar2.zze = true;
                    z10 = true;
                }
                if (zzacVar2.zze) {
                    zzkw zzkwVar3 = zzacVar2.zzc;
                    zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzb, zzkwVar3.zzb, zzkwVar3.zzc, Preconditions.checkNotNull(zzkwVar3.zza()));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzL(zzkyVar)) {
                        zzay().zzc().zzd("User property updated immediately", zzacVar2.zza, this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    }
                    if (z10 && zzacVar2.zzi != null) {
                        zzY(new zzaw(zzacVar2.zzi, zzacVar2.zzd), zzqVar);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                if (zzamVar4.zzK(zzacVar2)) {
                    zzay().zzc().zzd("Conditional property added", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    public final void zzV(String str, zzai zzaiVar) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzaiVar);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaiVar);
        zzamVar.zzg();
        zzamVar.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzaiVar.zzh());
        try {
            if (zzamVar.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzamVar.zzt.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e10) {
            zzamVar.zzt.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e10);
        }
    }

    public final void zzW(zzkw zzkwVar, zzq zzqVar) {
        long j10;
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            int zzl = zzv().zzl(zzkwVar.zzb);
            if (zzl != 0) {
                zzlb zzv = zzv();
                String str = zzkwVar.zzb;
                zzg();
                String zzD = zzv.zzD(str, 24, true);
                String str2 = zzkwVar.zzb;
                zzv().zzN(this.zzF, zzqVar.zza, zzl, "_ev", zzD, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd = zzv().zzd(zzkwVar.zzb, zzkwVar.zza());
            if (zzd != 0) {
                zzlb zzv2 = zzv();
                String str3 = zzkwVar.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str3, 24, true);
                Object zza = zzkwVar.zza();
                zzv().zzN(this.zzF, zzqVar.zza, zzd, "_ev", zzD2, (zza == null || !((zza instanceof String) || (zza instanceof CharSequence))) ? 0 : zza.toString().length());
                return;
            }
            Object zzB = zzv().zzB(zzkwVar.zzb, zzkwVar.zza());
            if (zzB == null) {
                return;
            }
            if ("_sid".equals(zzkwVar.zzb)) {
                long j11 = zzkwVar.zzc;
                String str4 = zzkwVar.zzf;
                String str5 = (String) Preconditions.checkNotNull(zzqVar.zza);
                zzam zzamVar = this.zze;
                zzal(zzamVar);
                zzky zzp = zzamVar.zzp(str5, "_sno");
                if (zzp != null) {
                    Object obj = zzp.zze;
                    if (obj instanceof Long) {
                        j10 = ((Long) obj).longValue();
                        zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzqVar);
                    }
                }
                if (zzp != null) {
                    zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp.zze);
                }
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzas zzn = zzamVar2.zzn(str5, "_s");
                if (zzn != null) {
                    j10 = zzn.zzc;
                    zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j10));
                } else {
                    j10 = 0;
                }
                zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzqVar);
            }
            zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzqVar.zza), (String) Preconditions.checkNotNull(zzkwVar.zzf), zzkwVar.zzb, zzkwVar.zzc, zzB);
            zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzkyVar.zzc), zzB);
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzw();
            try {
                if (bx.f10121d.equals(zzkyVar.zzc)) {
                    zzam zzamVar4 = this.zze;
                    zzal(zzamVar4);
                    zzky zzp2 = zzamVar4.zzp(zzqVar.zza, bx.f10121d);
                    if (zzp2 != null && !zzkyVar.zze.equals(zzp2.zze)) {
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(zzqVar.zza, "_lair");
                    }
                }
                zzd(zzqVar);
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                boolean zzL = zzamVar6.zzL(zzkyVar);
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                zzamVar7.zzC();
                if (!zzL) {
                    zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    zzv().zzN(this.zzF, zzqVar.zza, 9, null, null, 0);
                }
            } finally {
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzx();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:220:0x0126, code lost:
    
        if (r11 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0562, code lost:
    
        if (r11 == null) goto L224;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0580: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:1409), block:B:260:0x0580 */
    /* JADX WARN: Removed duplicated region for block: B:242:0x056c A[Catch: all -> 0x0587, TryCatch #5 {all -> 0x0587, blocks: (B:3:0x0010, B:5:0x0021, B:10:0x0034, B:12:0x003a, B:14:0x004a, B:16:0x0052, B:18:0x0058, B:20:0x0063, B:22:0x0073, B:24:0x007e, B:26:0x0091, B:28:0x00b0, B:30:0x00b6, B:32:0x00b9, B:34:0x00c5, B:35:0x00dc, B:37:0x00ed, B:207:0x00f3, B:213:0x0108, B:214:0x0129, B:226:0x0130, B:227:0x0133, B:39:0x0134, B:42:0x015c, B:45:0x0164, B:53:0x019e, B:55:0x029e, B:57:0x02a4, B:59:0x02b0, B:60:0x02b4, B:62:0x02ba, B:65:0x02ce, B:68:0x02d7, B:70:0x02dd, B:74:0x0302, B:75:0x02f2, B:78:0x02fc, B:84:0x0305, B:86:0x0320, B:89:0x032f, B:91:0x0353, B:96:0x0365, B:98:0x039f, B:100:0x03a4, B:102:0x03ac, B:103:0x03af, B:105:0x03b4, B:106:0x03b7, B:108:0x03c3, B:110:0x03d9, B:113:0x03e1, B:115:0x03f2, B:116:0x0404, B:118:0x0426, B:120:0x0464, B:122:0x0476, B:123:0x048b, B:125:0x0496, B:126:0x049f, B:128:0x0484, B:129:0x04e3, B:130:0x045b, B:155:0x026f, B:177:0x029b, B:197:0x04fa, B:198:0x04fd, B:231:0x04fe, B:238:0x053f, B:240:0x0566, B:242:0x056c, B:244:0x0577, B:247:0x0548, B:257:0x0583, B:258:0x0586), top: B:2:0x0010, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a4 A[Catch: all -> 0x0587, TryCatch #5 {all -> 0x0587, blocks: (B:3:0x0010, B:5:0x0021, B:10:0x0034, B:12:0x003a, B:14:0x004a, B:16:0x0052, B:18:0x0058, B:20:0x0063, B:22:0x0073, B:24:0x007e, B:26:0x0091, B:28:0x00b0, B:30:0x00b6, B:32:0x00b9, B:34:0x00c5, B:35:0x00dc, B:37:0x00ed, B:207:0x00f3, B:213:0x0108, B:214:0x0129, B:226:0x0130, B:227:0x0133, B:39:0x0134, B:42:0x015c, B:45:0x0164, B:53:0x019e, B:55:0x029e, B:57:0x02a4, B:59:0x02b0, B:60:0x02b4, B:62:0x02ba, B:65:0x02ce, B:68:0x02d7, B:70:0x02dd, B:74:0x0302, B:75:0x02f2, B:78:0x02fc, B:84:0x0305, B:86:0x0320, B:89:0x032f, B:91:0x0353, B:96:0x0365, B:98:0x039f, B:100:0x03a4, B:102:0x03ac, B:103:0x03af, B:105:0x03b4, B:106:0x03b7, B:108:0x03c3, B:110:0x03d9, B:113:0x03e1, B:115:0x03f2, B:116:0x0404, B:118:0x0426, B:120:0x0464, B:122:0x0476, B:123:0x048b, B:125:0x0496, B:126:0x049f, B:128:0x0484, B:129:0x04e3, B:130:0x045b, B:155:0x026f, B:177:0x029b, B:197:0x04fa, B:198:0x04fd, B:231:0x04fe, B:238:0x053f, B:240:0x0566, B:242:0x056c, B:244:0x0577, B:247:0x0548, B:257:0x0583, B:258:0x0586), top: B:2:0x0010, inners: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzX() {
        Cursor cursor;
        Cursor cursor2;
        zzam zzamVar;
        long zzz;
        Cursor cursor3;
        String str;
        zzam zzamVar2;
        Cursor cursor4;
        Cursor cursor5;
        long j10;
        Cursor cursor6;
        List emptyList;
        String str2;
        String str3;
        String str4;
        byte[] byteArray;
        zzaz().zzg();
        zzB();
        int i10 = 1;
        this.zzv = true;
        int i11 = 0;
        try {
            this.zzn.zzaw();
            Boolean zzj = this.zzn.zzt().zzj();
            if (zzj == null) {
                zzay().zzk().zza("Upload data called on the client side before use of service was decided");
                this.zzv = false;
            } else if (zzj.booleanValue()) {
                zzay().zzd().zza("Upload called in the client side when service should be used");
                this.zzv = false;
            } else if (this.zza > 0) {
                zzag();
                this.zzv = false;
            } else {
                zzaz().zzg();
                if (this.zzy != null) {
                    zzay().zzj().zza("Uploading requested multiple times");
                    this.zzv = false;
                } else {
                    zzen zzenVar = this.zzd;
                    zzal(zzenVar);
                    if (zzenVar.zza()) {
                        long currentTimeMillis = zzav().currentTimeMillis();
                        Cursor cursor7 = null;
                        int zze = zzg().zze(null, zzdu.zzP);
                        zzg();
                        long zzz2 = currentTimeMillis - zzag.zzz();
                        for (int i12 = 0; i12 < zze && zzah(null, zzz2); i12++) {
                        }
                        long zza = this.zzk.zzc.zza();
                        if (zza != 0) {
                            zzay().zzc().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        String zzr = zzamVar3.zzr();
                        long j11 = -1;
                        if (TextUtils.isEmpty(zzr)) {
                            try {
                                this.zzA = -1L;
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                zzg();
                                zzz = currentTimeMillis - zzag.zzz();
                                zzamVar.zzg();
                                zzamVar.zzW();
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                            }
                            try {
                                cursor3 = zzamVar.zzh().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzz)});
                                try {
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    zzamVar.zzt.zzay().zzd().zzb("Error selecting expired configs", e);
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursor3 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = null;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                            if (cursor3.moveToFirst()) {
                                str = cursor3.getString(0);
                                cursor3.close();
                                if (!TextUtils.isEmpty(str)) {
                                }
                            } else {
                                zzamVar.zzt.zzay().zzj().zza("No expired configs for apps with pending events");
                                cursor3.close();
                                str = null;
                                if (!TextUtils.isEmpty(str)) {
                                    zzam zzamVar4 = this.zze;
                                    zzal(zzamVar4);
                                    zzh zzj2 = zzamVar4.zzj(str);
                                    if (zzj2 != null) {
                                        zzD(zzj2);
                                    }
                                }
                            }
                        } else {
                            if (this.zzA == -1) {
                                try {
                                    zzamVar2 = this.zze;
                                    zzal(zzamVar2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor7 = cursor4;
                                }
                                try {
                                    cursor4 = zzamVar2.zzh().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    try {
                                        if (cursor4.moveToFirst()) {
                                            j11 = cursor4.getLong(0);
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        zzamVar2.zzt.zzay().zzd().zzb("Error querying raw events", e);
                                    }
                                } catch (SQLiteException e13) {
                                    e = e13;
                                    cursor4 = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (cursor7 != null) {
                                        cursor7.close();
                                    }
                                    throw th;
                                }
                                cursor4.close();
                                this.zzA = j11;
                            }
                            int zze2 = zzg().zze(zzr, zzdu.zzf);
                            int max = Math.max(0, zzg().zze(zzr, zzdu.zzg));
                            zzam zzamVar5 = this.zze;
                            zzal(zzamVar5);
                            zzamVar5.zzg();
                            zzamVar5.zzW();
                            Preconditions.checkArgument(zze2 > 0);
                            Preconditions.checkArgument(max > 0);
                            Preconditions.checkNotEmpty(zzr);
                            try {
                                cursor6 = zzamVar5.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{zzr}, null, null, "rowid", String.valueOf(zze2));
                                try {
                                    try {
                                        if (cursor6.moveToFirst()) {
                                            ArrayList arrayList = new ArrayList();
                                            int i13 = 0;
                                            while (true) {
                                                long j12 = cursor6.getLong(i11);
                                                try {
                                                    byte[] blob = cursor6.getBlob(i10);
                                                    zzkv zzkvVar = zzamVar5.zzf.zzi;
                                                    zzal(zzkvVar);
                                                    try {
                                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                        byte[] bArr = new byte[1024];
                                                        j10 = currentTimeMillis;
                                                        while (true) {
                                                            try {
                                                                try {
                                                                    int read = gZIPInputStream.read(bArr);
                                                                    if (read <= 0) {
                                                                        break;
                                                                    } else {
                                                                        byteArrayOutputStream.write(bArr, 0, read);
                                                                    }
                                                                } catch (SQLiteException e14) {
                                                                    e = e14;
                                                                    zzamVar5.zzt.zzay().zzd().zzc("Error querying bundles. appId", zzeh.zzn(zzr), e);
                                                                    emptyList = Collections.emptyList();
                                                                    if (cursor6 != null) {
                                                                        cursor6.close();
                                                                    }
                                                                    if (!emptyList.isEmpty()) {
                                                                    }
                                                                    this.zzv = false;
                                                                    zzae();
                                                                }
                                                            } catch (IOException e15) {
                                                                e = e15;
                                                                try {
                                                                    zzkvVar.zzt.zzay().zzd().zzb("Failed to ungzip content", e);
                                                                    throw e;
                                                                } catch (IOException e16) {
                                                                    e = e16;
                                                                    zzamVar5.zzt.zzay().zzd().zzc("Failed to unzip queued bundle. appId", zzeh.zzn(zzr), e);
                                                                    if (cursor6.moveToNext()) {
                                                                        break;
                                                                    }
                                                                    currentTimeMillis = j10;
                                                                    i10 = 1;
                                                                    i11 = 0;
                                                                    cursor6.close();
                                                                    emptyList = arrayList;
                                                                    if (!emptyList.isEmpty()) {
                                                                    }
                                                                    this.zzv = false;
                                                                    zzae();
                                                                }
                                                            }
                                                        }
                                                        gZIPInputStream.close();
                                                        byteArrayInputStream.close();
                                                        byteArray = byteArrayOutputStream.toByteArray();
                                                    } catch (IOException e17) {
                                                        e = e17;
                                                        j10 = currentTimeMillis;
                                                    }
                                                } catch (IOException e18) {
                                                    e = e18;
                                                    j10 = currentTimeMillis;
                                                }
                                                if (!arrayList.isEmpty() && byteArray.length + i13 > max) {
                                                    break;
                                                }
                                                try {
                                                    com.google.android.gms.internal.measurement.zzgc zzgcVar = (com.google.android.gms.internal.measurement.zzgc) zzkv.zzl(com.google.android.gms.internal.measurement.zzgd.zzt(), byteArray);
                                                    if (!cursor6.isNull(2)) {
                                                        zzgcVar.zzaf(cursor6.getInt(2));
                                                    }
                                                    i13 += byteArray.length;
                                                    arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC(), Long.valueOf(j12)));
                                                } catch (IOException e19) {
                                                    zzamVar5.zzt.zzay().zzd().zzc("Failed to merge queued bundle. appId", zzeh.zzn(zzr), e19);
                                                }
                                                if (cursor6.moveToNext() || i13 > max) {
                                                    break;
                                                    break;
                                                } else {
                                                    currentTimeMillis = j10;
                                                    i10 = 1;
                                                    i11 = 0;
                                                }
                                            }
                                            cursor6.close();
                                            emptyList = arrayList;
                                        } else {
                                            emptyList = Collections.emptyList();
                                            cursor6.close();
                                            j10 = currentTimeMillis;
                                        }
                                    } catch (SQLiteException e20) {
                                        e = e20;
                                        j10 = currentTimeMillis;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    cursor5 = cursor6;
                                    if (cursor5 != null) {
                                        cursor5.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e21) {
                                e = e21;
                                j10 = currentTimeMillis;
                                cursor6 = null;
                            } catch (Throwable th6) {
                                th = th6;
                                cursor5 = null;
                            }
                            if (!emptyList.isEmpty()) {
                                if (zzh(zzr).zzi(zzah.AD_STORAGE)) {
                                    Iterator it = emptyList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            str4 = null;
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) ((Pair) it.next()).first;
                                        if (!zzgdVar.zzJ().isEmpty()) {
                                            str4 = zzgdVar.zzJ();
                                            break;
                                        }
                                    }
                                    if (str4 != null) {
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= emptyList.size()) {
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzgd zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) ((Pair) emptyList.get(i14)).first;
                                            if (!zzgdVar2.zzJ().isEmpty() && !zzgdVar2.zzJ().equals(str4)) {
                                                emptyList = emptyList.subList(0, i14);
                                                break;
                                            }
                                            i14++;
                                        }
                                    }
                                }
                                com.google.android.gms.internal.measurement.zzga zza2 = com.google.android.gms.internal.measurement.zzgb.zza();
                                int size = emptyList.size();
                                ArrayList arrayList2 = new ArrayList(emptyList.size());
                                boolean z10 = zzg().zzt(zzr) && zzh(zzr).zzi(zzah.AD_STORAGE);
                                boolean zzi = zzh(zzr).zzi(zzah.AD_STORAGE);
                                boolean zzi2 = zzh(zzr).zzi(zzah.ANALYTICS_STORAGE);
                                zzpd.zzc();
                                boolean z11 = zzg().zzs(null, zzdu.zzal) && zzg().zzs(zzr, zzdu.zzan);
                                int i15 = 0;
                                while (i15 < size) {
                                    com.google.android.gms.internal.measurement.zzgc zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((com.google.android.gms.internal.measurement.zzgd) ((Pair) emptyList.get(i15)).first).zzby();
                                    arrayList2.add((Long) ((Pair) emptyList.get(i15)).second);
                                    zzg().zzh();
                                    zzgcVar2.zzal(74029L);
                                    long j13 = j10;
                                    zzgcVar2.zzak(j13);
                                    this.zzn.zzaw();
                                    zzgcVar2.zzag(false);
                                    if (!z10) {
                                        zzgcVar2.zzq();
                                    }
                                    if (!zzi) {
                                        zzgcVar2.zzx();
                                        zzgcVar2.zzt();
                                    }
                                    if (!zzi2) {
                                        zzgcVar2.zzn();
                                    }
                                    zzC(zzr, zzgcVar2);
                                    if (!z11) {
                                        zzgcVar2.zzy();
                                    }
                                    if (zzg().zzs(zzr, zzdu.zzT)) {
                                        byte[] zzbu = ((com.google.android.gms.internal.measurement.zzgd) zzgcVar2.zzaC()).zzbu();
                                        zzkv zzkvVar2 = this.zzi;
                                        zzal(zzkvVar2);
                                        zzgcVar2.zzJ(zzkvVar2.zzd(zzbu));
                                    }
                                    zza2.zza(zzgcVar2);
                                    i15++;
                                    j10 = j13;
                                }
                                long j14 = j10;
                                if (Log.isLoggable(zzay().zzq(), 2)) {
                                    zzkv zzkvVar3 = this.zzi;
                                    zzal(zzkvVar3);
                                    str2 = zzkvVar3.zzm((com.google.android.gms.internal.measurement.zzgb) zza2.zzaC());
                                } else {
                                    str2 = null;
                                }
                                zzal(this.zzi);
                                byte[] zzbu2 = ((com.google.android.gms.internal.measurement.zzgb) zza2.zzaC()).zzbu();
                                zzfi zzfiVar = this.zzl.zzf.zzc;
                                zzal(zzfiVar);
                                String zzi3 = zzfiVar.zzi(zzr);
                                if (TextUtils.isEmpty(zzi3)) {
                                    str3 = (String) zzdu.zzp.zza(null);
                                } else {
                                    Uri parse = Uri.parse((String) zzdu.zzp.zza(null));
                                    Uri.Builder buildUpon = parse.buildUpon();
                                    buildUpon.authority(zzi3 + "." + parse.getAuthority());
                                    str3 = buildUpon.build().toString();
                                }
                                try {
                                    URL url = new URL(str3);
                                    Preconditions.checkArgument(!arrayList2.isEmpty());
                                    if (this.zzy != null) {
                                        zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                    } else {
                                        this.zzy = new ArrayList(arrayList2);
                                    }
                                    this.zzk.zzd.zzb(j14);
                                    String str5 = Operator.Operation.EMPTY_PARAM;
                                    if (size > 0) {
                                        str5 = zza2.zzb(0).zzx();
                                    }
                                    zzay().zzj().zzd("Uploading data. app, uncompressed size, data", str5, Integer.valueOf(zzbu2.length), str2);
                                    this.zzu = true;
                                    zzen zzenVar2 = this.zzd;
                                    zzal(zzenVar2);
                                    zzkk zzkkVar = new zzkk(this, zzr);
                                    zzenVar2.zzg();
                                    zzenVar2.zzW();
                                    Preconditions.checkNotNull(url);
                                    Preconditions.checkNotNull(zzbu2);
                                    Preconditions.checkNotNull(zzkkVar);
                                    zzenVar2.zzt.zzaz().zzo(new zzem(zzenVar2, zzr, url, zzbu2, null, zzkkVar));
                                } catch (MalformedURLException unused) {
                                    zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", zzeh.zzn(zzr), str3);
                                }
                            }
                        }
                        this.zzv = false;
                    } else {
                        zzay().zzj().zza("Network not connected, ignoring upload request");
                        zzag();
                        this.zzv = false;
                    }
                }
            }
            zzae();
        } catch (Throwable th7) {
            this.zzv = false;
            zzae();
            throw th7;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:289|(2:291|(1:293)(8:294|295|296|(1:298)|45|(0)(0)|48|(0)(0)))|299|300|301|302|303|304|305|295|296|(0)|45|(0)(0)|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x072c, code lost:
    
        if (r14.isEmpty() == false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x026c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0272, code lost:
    
        r11.zzt.zzay().zzd().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r10), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x026e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0525 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05e9 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05f6 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0603 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x063c A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x064d A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x068e A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x06d1 A[Catch: all -> 0x0a5a, TRY_LEAVE, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0731 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0777 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07bf A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07d9 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0865 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0884 A[Catch: all -> 0x0a5a, TRY_LEAVE, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0917 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x09c3 A[Catch: SQLiteException -> 0x09de, all -> 0x0a5a, TRY_LEAVE, TryCatch #9 {SQLiteException -> 0x09de, blocks: (B:210:0x09b2, B:212:0x09c3), top: B:209:0x09b2, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x09d9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0924 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x059e A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02f2 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x016b A[Catch: all -> 0x0a5a, TRY_ENTER, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x01e2 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x02ac A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x01d2 A[Catch: all -> 0x0a5a, TRY_ENTER, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0355 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04e5 A[Catch: all -> 0x0a5a, TryCatch #5 {all -> 0x0a5a, blocks: (B:31:0x0124, B:34:0x0135, B:36:0x013f, B:40:0x014b, B:45:0x02dc, B:48:0x0312, B:50:0x0355, B:52:0x035a, B:53:0x0371, B:57:0x0384, B:59:0x039b, B:61:0x03a2, B:62:0x03b9, B:67:0x03e3, B:71:0x0406, B:72:0x041d, B:75:0x0430, B:78:0x044f, B:79:0x0463, B:81:0x046d, B:83:0x047a, B:85:0x0480, B:86:0x0489, B:88:0x0497, B:91:0x04ac, B:94:0x04bc, B:98:0x04e5, B:99:0x04fa, B:101:0x0525, B:104:0x053d, B:107:0x0580, B:108:0x05ac, B:110:0x05e9, B:111:0x05ee, B:113:0x05f6, B:114:0x05fb, B:116:0x0603, B:117:0x0608, B:119:0x0618, B:121:0x0626, B:123:0x062e, B:124:0x0633, B:126:0x063c, B:127:0x0640, B:129:0x064d, B:130:0x0652, B:132:0x0679, B:134:0x0681, B:135:0x0686, B:137:0x068e, B:138:0x0691, B:140:0x06a9, B:143:0x06b1, B:144:0x06cb, B:146:0x06d1, B:149:0x06e5, B:152:0x06f1, B:155:0x06fe, B:243:0x0718, B:158:0x0728, B:161:0x0731, B:162:0x0734, B:164:0x0752, B:166:0x0756, B:168:0x0768, B:170:0x076c, B:172:0x0777, B:173:0x0780, B:175:0x07bf, B:177:0x07c9, B:178:0x07cc, B:180:0x07d9, B:182:0x07f9, B:183:0x0806, B:184:0x083c, B:186:0x0844, B:188:0x084e, B:189:0x085b, B:191:0x0865, B:192:0x0872, B:193:0x087e, B:195:0x0884, B:198:0x08b4, B:200:0x08fa, B:201:0x0905, B:202:0x0911, B:204:0x0917, B:208:0x0964, B:210:0x09b2, B:212:0x09c3, B:213:0x0a27, B:218:0x09db, B:220:0x09df, B:223:0x0924, B:225:0x094e, B:232:0x09f8, B:233:0x0a0f, B:237:0x0a12, B:248:0x059e, B:252:0x04cd, B:260:0x02f2, B:261:0x02f9, B:263:0x02ff, B:266:0x030b, B:271:0x015f, B:274:0x016b, B:276:0x0182, B:282:0x019e, B:285:0x01dc, B:287:0x01e2, B:289:0x01f0, B:291:0x0201, B:294:0x0208, B:296:0x02a1, B:298:0x02ac, B:299:0x0230, B:301:0x024f, B:304:0x0258, B:305:0x0285, B:309:0x0272, B:313:0x01ac, B:316:0x01d2), top: B:30:0x0124, inners: #1, #6, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(zzaw zzawVar, zzq zzqVar) {
        boolean z10;
        String zzg;
        long longValue;
        String str;
        String str2;
        zzky zzkyVar;
        Object obj;
        zzky zzkyVar2;
        zzam zzamVar;
        zzau zzauVar;
        long j10;
        long intValue;
        String str3;
        String str4;
        long j11;
        zzar zzarVar;
        String str5;
        zzas zzn;
        zzas zzc;
        com.google.android.gms.internal.measurement.zzgc zzt;
        long j12;
        long j13;
        Map zzc2;
        ArrayList arrayList;
        zzai zzc3;
        zzah zzahVar;
        zzh zzj;
        List zzu;
        int i10;
        zzam zzamVar2;
        zzam zzamVar3;
        zzat zzatVar;
        int i11;
        ContentValues contentValues;
        Pair zzd;
        Object obj2;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        long nanoTime = System.nanoTime();
        zzaz().zzg();
        zzB();
        String str6 = zzqVar.zza;
        zzal(this.zzi);
        if (!zzkv.zzA(zzawVar, zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            zzd(zzqVar);
            return;
        }
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        if (zzfiVar.zzr(str6, zzawVar.zza)) {
            zzay().zzk().zzc("Dropping blocked event. appId", zzeh.zzn(str6), this.zzn.zzj().zzd(zzawVar.zza));
            zzfi zzfiVar2 = this.zzc;
            zzal(zzfiVar2);
            if (!zzfiVar2.zzp(str6)) {
                zzfi zzfiVar3 = this.zzc;
                zzal(zzfiVar3);
                if (!zzfiVar3.zzs(str6)) {
                    if ("_err".equals(zzawVar.zza)) {
                        return;
                    }
                    zzv().zzN(this.zzF, str6, 11, "_ev", zzawVar.zza, 0);
                    return;
                }
            }
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            zzh zzj2 = zzamVar4.zzj(str6);
            if (zzj2 != null) {
                long abs = Math.abs(zzav().currentTimeMillis() - Math.max(zzj2.zzl(), zzj2.zzc()));
                zzg();
                if (abs > ((Long) zzdu.zzy.zza(null)).longValue()) {
                    zzay().zzc().zza("Fetching config for blocked app");
                    zzD(zzj2);
                    return;
                }
                return;
            }
            return;
        }
        zzei zzb2 = zzei.zzb(zzawVar);
        zzv().zzM(zzb2, zzg().zzd(str6));
        zzaw zza = zzb2.zza();
        if (Log.isLoggable(zzay().zzq(), 2)) {
            zzay().zzj().zzb("Logging event", this.zzn.zzj().zzc(zza));
        }
        zzam zzamVar5 = this.zze;
        zzal(zzamVar5);
        zzamVar5.zzw();
        try {
            zzd(zzqVar);
            if (!"ecommerce_purchase".equals(zza.zza) && !FirebaseAnalytics.Event.PURCHASE.equals(zza.zza) && !FirebaseAnalytics.Event.REFUND.equals(zza.zza)) {
                z10 = false;
                if (!"_iap".equals(zza.zza)) {
                    if (z10) {
                        z10 = true;
                    }
                    str = "metadata_fingerprint";
                    str2 = "_err";
                    obj = null;
                    boolean zzai = zzlb.zzai(zza.zza);
                    boolean equals = str2.equals(zza.zza);
                    zzv();
                    zzauVar = zza.zzb;
                    if (zzauVar != null) {
                        j10 = 0;
                    } else {
                        zzat zzatVar2 = new zzat(zzauVar);
                        j10 = 0;
                        while (zzatVar2.hasNext()) {
                            if (zzauVar.zzf(zzatVar2.next()) instanceof Parcelable[]) {
                                j10 += ((Parcelable[]) r13).length;
                            }
                        }
                    }
                    zzam zzamVar6 = this.zze;
                    zzal(zzamVar6);
                    zzak zzm = zzamVar6.zzm(zza(), str6, j10 + 1, true, zzai, false, equals, false);
                    long j14 = zzm.zzb;
                    zzg();
                    intValue = j14 - ((Integer) zzdu.zzj.zza(obj)).intValue();
                    if (intValue <= 0) {
                        if (intValue % 1000 == 1) {
                            zzay().zzd().zzc("Data loss. Too many events logged. appId, count", zzeh.zzn(str6), Long.valueOf(zzm.zzb));
                        }
                        zzam zzamVar7 = this.zze;
                        zzal(zzamVar7);
                        zzamVar7.zzC();
                        return;
                    }
                    if (zzai) {
                        long j15 = zzm.zza;
                        zzg();
                        long intValue2 = j15 - ((Integer) zzdu.zzl.zza(obj)).intValue();
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                zzay().zzd().zzc("Data loss. Too many public events logged. appId, count", zzeh.zzn(str6), Long.valueOf(zzm.zza));
                            }
                            zzv().zzN(this.zzF, str6, 16, "_ev", zza.zza, 0);
                            zzam zzamVar8 = this.zze;
                            zzal(zzamVar8);
                            zzamVar8.zzC();
                            return;
                        }
                    }
                    if (equals) {
                        str3 = str6;
                        long max = zzm.zzd - Math.max(0, Math.min(CrashStatKey.STATS_REPORT_FINISHED, zzg().zze(zzqVar.zza, zzdu.zzk)));
                        if (max > 0) {
                            if (max == 1) {
                                zzay().zzd().zzc("Too many error events logged. appId, count", zzeh.zzn(str3), Long.valueOf(zzm.zzd));
                            }
                            zzam zzamVar9 = this.zze;
                            zzal(zzamVar9);
                            zzamVar9.zzC();
                            return;
                        }
                    } else {
                        str3 = str6;
                    }
                    Bundle zzc4 = zza.zzb.zzc();
                    zzv().zzO(zzc4, "_o", zza.zzc);
                    String str7 = str3;
                    if (zzv().zzae(str7)) {
                        zzv().zzO(zzc4, "_dbg", 1L);
                        zzv().zzO(zzc4, "_r", 1L);
                    }
                    if ("_s".equals(zza.zza)) {
                        zzam zzamVar10 = this.zze;
                        zzal(zzamVar10);
                        zzky zzp = zzamVar10.zzp(zzqVar.zza, "_sno");
                        if (zzp != null && (zzp.zze instanceof Long)) {
                            zzv().zzO(zzc4, "_sno", zzp.zze);
                        }
                    }
                    zzam zzamVar11 = this.zze;
                    zzal(zzamVar11);
                    Preconditions.checkNotEmpty(str7);
                    zzamVar11.zzg();
                    zzamVar11.zzW();
                    try {
                        try {
                            str4 = "raw_events";
                        } catch (SQLiteException e10) {
                            e = e10;
                            str4 = "raw_events";
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        str4 = "raw_events";
                    }
                    try {
                        j11 = zzamVar11.zzh().delete(str4, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str7, String.valueOf(Math.max(0, Math.min(CrashStatKey.STATS_REPORT_FINISHED, zzamVar11.zzt.zzf().zze(str7, zzdu.zzo))))});
                    } catch (SQLiteException e12) {
                        e = e12;
                        zzamVar11.zzt.zzay().zzd().zzc("Error deleting over the limit events. appId", zzeh.zzn(str7), e);
                        j11 = 0;
                        if (j11 > 0) {
                        }
                        zzfr zzfrVar = this.zzn;
                        String str8 = zza.zzc;
                        String str9 = zza.zza;
                        long j16 = zza.zzd;
                        str5 = str4;
                        zzarVar = new zzar(zzfrVar, str8, str7, str9, j16, 0L, zzc4);
                        zzam zzamVar12 = this.zze;
                        zzal(zzamVar12);
                        zzn = zzamVar12.zzn(str7, zzarVar.zzb);
                        if (zzn != null) {
                        }
                        zzam zzamVar13 = this.zze;
                        zzal(zzamVar13);
                        zzamVar13.zzE(zzc);
                        zzaz().zzg();
                        zzB();
                        Preconditions.checkNotNull(zzarVar);
                        Preconditions.checkNotNull(zzqVar);
                        Preconditions.checkNotEmpty(zzarVar.zza);
                        Preconditions.checkArgument(zzarVar.zza.equals(zzqVar.zza));
                        zzt = com.google.android.gms.internal.measurement.zzgd.zzt();
                        zzt.zzad(1);
                        zzt.zzZ("android");
                        if (!TextUtils.isEmpty(zzqVar.zza)) {
                        }
                        if (!TextUtils.isEmpty(zzqVar.zzd)) {
                        }
                        if (!TextUtils.isEmpty(zzqVar.zzc)) {
                        }
                        zzpd.zzc();
                        if (zzg().zzs(null, zzdu.zzal)) {
                            zzt.zzah(zzqVar.zzx);
                        }
                        j12 = zzqVar.zzj;
                        if (j12 != -2147483648L) {
                        }
                        zzt.zzV(zzqVar.zze);
                        if (!TextUtils.isEmpty(zzqVar.zzb)) {
                        }
                        zzt.zzL(zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv)).zzh());
                        if (zzt.zzaq().isEmpty()) {
                            zzt.zzC(zzqVar.zzq);
                        }
                        j13 = zzqVar.zzf;
                        if (j13 != 0) {
                        }
                        zzt.zzP(zzqVar.zzs);
                        zzkv zzkvVar = this.zzi;
                        zzal(zzkvVar);
                        zzc2 = zzdu.zzc(zzkvVar.zzf.zzn.zzau());
                        if (zzc2 != null) {
                            arrayList = new ArrayList();
                            int intValue3 = ((Integer) zzdu.zzO.zza(null)).intValue();
                            while (r8.hasNext()) {
                            }
                        }
                        arrayList = null;
                        if (arrayList != null) {
                        }
                        zzc3 = zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv));
                        zzahVar = zzah.AD_STORAGE;
                        if (zzc3.zzi(zzahVar)) {
                            zzd = this.zzk.zzd(zzqVar.zza, zzc3);
                            if (!TextUtils.isEmpty((CharSequence) zzd.first)) {
                                zzt.zzae((String) zzd.first);
                                obj2 = zzd.second;
                                if (obj2 != null) {
                                }
                            }
                        }
                        this.zzn.zzg().zzu();
                        zzt.zzN(Build.MODEL);
                        this.zzn.zzg().zzu();
                        zzt.zzY(Build.VERSION.RELEASE);
                        zzt.zzaj((int) this.zzn.zzg().zzb());
                        zzt.zzan(this.zzn.zzg().zzc());
                        if (this.zzn.zzJ()) {
                        }
                        zzam zzamVar14 = this.zze;
                        zzal(zzamVar14);
                        zzj = zzamVar14.zzj(zzqVar.zza);
                        if (zzj == null) {
                        }
                        if (zzc3.zzi(zzah.ANALYTICS_STORAGE)) {
                            zzt.zzE((String) Preconditions.checkNotNull(zzj.zzu()));
                        }
                        if (!TextUtils.isEmpty(zzj.zzx())) {
                        }
                        zzam zzamVar15 = this.zze;
                        zzal(zzamVar15);
                        zzu = zzamVar15.zzu(zzqVar.zza);
                        while (i10 < zzu.size()) {
                        }
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) zzt.zzaC();
                        zzamVar2.zzg();
                        zzamVar2.zzW();
                        Preconditions.checkNotNull(zzgdVar);
                        Preconditions.checkNotEmpty(zzgdVar.zzx());
                        byte[] zzbu = zzgdVar.zzbu();
                        zzkv zzkvVar2 = zzamVar2.zzf.zzi;
                        zzal(zzkvVar2);
                        long zzd2 = zzkvVar2.zzd(zzbu);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", zzgdVar.zzx());
                        String str10 = str;
                        contentValues2.put(str10, Long.valueOf(zzd2));
                        contentValues2.put("metadata", zzbu);
                        try {
                            zzamVar2.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                            zzamVar3 = this.zze;
                            zzal(zzamVar3);
                            zzatVar = new zzat(zzarVar.zzf);
                            while (true) {
                                if (!zzatVar.hasNext()) {
                                }
                            }
                            i11 = 1;
                            zzamVar3.zzg();
                            zzamVar3.zzW();
                            Preconditions.checkNotNull(zzarVar);
                            Preconditions.checkNotEmpty(zzarVar.zza);
                            zzkv zzkvVar3 = zzamVar3.zzf.zzi;
                            zzal(zzkvVar3);
                            byte[] zzbu2 = zzkvVar3.zzj(zzarVar).zzbu();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", zzarVar.zza);
                            contentValues.put("name", zzarVar.zzb);
                            contentValues.put(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(zzarVar.zzd));
                            contentValues.put(str10, Long.valueOf(zzd2));
                            contentValues.put("data", zzbu2);
                            contentValues.put("realtime", Integer.valueOf(i11));
                            if (zzamVar3.zzh().insert(str5, null, contentValues) != -1) {
                            }
                            zzam zzamVar16 = this.zze;
                            zzal(zzamVar16);
                            zzamVar16.zzC();
                            zzam zzamVar17 = this.zze;
                            zzal(zzamVar17);
                            zzamVar17.zzx();
                            zzag();
                            zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                            return;
                        } catch (SQLiteException e13) {
                            zzamVar2.zzt.zzay().zzd().zzc("Error storing raw event metadata. appId", zzeh.zzn(zzgdVar.zzx()), e13);
                            throw e13;
                        }
                    }
                    if (j11 > 0) {
                        zzay().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzeh.zzn(str7), Long.valueOf(j11));
                    }
                    zzfr zzfrVar2 = this.zzn;
                    String str82 = zza.zzc;
                    String str92 = zza.zza;
                    long j162 = zza.zzd;
                    str5 = str4;
                    zzarVar = new zzar(zzfrVar2, str82, str7, str92, j162, 0L, zzc4);
                    zzam zzamVar122 = this.zze;
                    zzal(zzamVar122);
                    zzn = zzamVar122.zzn(str7, zzarVar.zzb);
                    if (zzn != null) {
                        zzam zzamVar18 = this.zze;
                        zzal(zzamVar18);
                        if (zzamVar18.zzf(str7) >= zzg().zzb(str7) && zzai) {
                            zzay().zzd().zzd("Too many event names used, ignoring event. appId, name, supported count", zzeh.zzn(str7), this.zzn.zzj().zzd(zzarVar.zzb), Integer.valueOf(zzg().zzb(str7)));
                            zzv().zzN(this.zzF, str7, 8, null, null, 0);
                            return;
                        }
                        zzc = new zzas(str7, zzarVar.zzb, 0L, 0L, 0L, zzarVar.zzd, 0L, null, null, null, null);
                    } else {
                        zzarVar = zzarVar.zza(this.zzn, zzn.zzf);
                        zzc = zzn.zzc(zzarVar.zzd);
                    }
                    zzam zzamVar132 = this.zze;
                    zzal(zzamVar132);
                    zzamVar132.zzE(zzc);
                    zzaz().zzg();
                    zzB();
                    Preconditions.checkNotNull(zzarVar);
                    Preconditions.checkNotNull(zzqVar);
                    Preconditions.checkNotEmpty(zzarVar.zza);
                    Preconditions.checkArgument(zzarVar.zza.equals(zzqVar.zza));
                    zzt = com.google.android.gms.internal.measurement.zzgd.zzt();
                    zzt.zzad(1);
                    zzt.zzZ("android");
                    if (!TextUtils.isEmpty(zzqVar.zza)) {
                        zzt.zzD(zzqVar.zza);
                    }
                    if (!TextUtils.isEmpty(zzqVar.zzd)) {
                        zzt.zzF(zzqVar.zzd);
                    }
                    if (!TextUtils.isEmpty(zzqVar.zzc)) {
                        zzt.zzG(zzqVar.zzc);
                    }
                    zzpd.zzc();
                    if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(zzqVar.zza, zzdu.zzan) && !TextUtils.isEmpty(zzqVar.zzx)) {
                        zzt.zzah(zzqVar.zzx);
                    }
                    j12 = zzqVar.zzj;
                    if (j12 != -2147483648L) {
                        zzt.zzH((int) j12);
                    }
                    zzt.zzV(zzqVar.zze);
                    if (!TextUtils.isEmpty(zzqVar.zzb)) {
                        zzt.zzU(zzqVar.zzb);
                    }
                    zzt.zzL(zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv)).zzh());
                    if (zzt.zzaq().isEmpty() && !TextUtils.isEmpty(zzqVar.zzq)) {
                        zzt.zzC(zzqVar.zzq);
                    }
                    j13 = zzqVar.zzf;
                    if (j13 != 0) {
                        zzt.zzM(j13);
                    }
                    zzt.zzP(zzqVar.zzs);
                    zzkv zzkvVar4 = this.zzi;
                    zzal(zzkvVar4);
                    zzc2 = zzdu.zzc(zzkvVar4.zzf.zzn.zzau());
                    if (zzc2 != null && !zzc2.isEmpty()) {
                        arrayList = new ArrayList();
                        int intValue32 = ((Integer) zzdu.zzO.zza(null)).intValue();
                        for (Map.Entry entry : zzc2.entrySet()) {
                            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                try {
                                    int parseInt = Integer.parseInt((String) entry.getValue());
                                    if (parseInt != 0) {
                                        arrayList.add(Integer.valueOf(parseInt));
                                        if (arrayList.size() >= intValue32) {
                                            zzkvVar4.zzt.zzay().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                            break;
                                        }
                                        continue;
                                    } else {
                                        continue;
                                    }
                                } catch (NumberFormatException e14) {
                                    zzkvVar4.zzt.zzay().zzk().zzb("Experiment ID NumberFormatException", e14);
                                }
                            }
                        }
                    }
                    arrayList = null;
                    if (arrayList != null) {
                        zzt.zzh(arrayList);
                    }
                    zzc3 = zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv));
                    zzahVar = zzah.AD_STORAGE;
                    if (zzc3.zzi(zzahVar) && zzqVar.zzo) {
                        zzd = this.zzk.zzd(zzqVar.zza, zzc3);
                        if (!TextUtils.isEmpty((CharSequence) zzd.first) && zzqVar.zzo) {
                            zzt.zzae((String) zzd.first);
                            obj2 = zzd.second;
                            if (obj2 != null) {
                                zzt.zzX(((Boolean) obj2).booleanValue());
                            }
                        }
                    }
                    this.zzn.zzg().zzu();
                    zzt.zzN(Build.MODEL);
                    this.zzn.zzg().zzu();
                    zzt.zzY(Build.VERSION.RELEASE);
                    zzt.zzaj((int) this.zzn.zzg().zzb());
                    zzt.zzan(this.zzn.zzg().zzc());
                    if (this.zzn.zzJ()) {
                        zzt.zzap();
                        if (!TextUtils.isEmpty(null)) {
                            zzt.zzO(null);
                        }
                    }
                    zzam zzamVar142 = this.zze;
                    zzal(zzamVar142);
                    zzj = zzamVar142.zzj(zzqVar.zza);
                    if (zzj == null) {
                        zzj = new zzh(this.zzn, zzqVar.zza);
                        zzj.zzH(zzw(zzc3));
                        zzj.zzV(zzqVar.zzk);
                        zzj.zzW(zzqVar.zzb);
                        if (zzc3.zzi(zzahVar)) {
                            zzj.zzae(this.zzk.zzf(zzqVar.zza, zzqVar.zzo));
                        }
                        zzj.zzaa(0L);
                        zzj.zzab(0L);
                        zzj.zzZ(0L);
                        zzj.zzJ(zzqVar.zzc);
                        zzj.zzK(zzqVar.zzj);
                        zzj.zzI(zzqVar.zzd);
                        zzj.zzX(zzqVar.zze);
                        zzj.zzS(zzqVar.zzf);
                        zzj.zzac(zzqVar.zzh);
                        zzj.zzT(zzqVar.zzs);
                        zzam zzamVar19 = this.zze;
                        zzal(zzamVar19);
                        zzamVar19.zzD(zzj);
                    }
                    if (zzc3.zzi(zzah.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzj.zzu())) {
                        zzt.zzE((String) Preconditions.checkNotNull(zzj.zzu()));
                    }
                    if (!TextUtils.isEmpty(zzj.zzx())) {
                        zzt.zzT((String) Preconditions.checkNotNull(zzj.zzx()));
                    }
                    zzam zzamVar152 = this.zze;
                    zzal(zzamVar152);
                    zzu = zzamVar152.zzu(zzqVar.zza);
                    for (i10 = 0; i10 < zzu.size(); i10++) {
                        com.google.android.gms.internal.measurement.zzgl zzd3 = com.google.android.gms.internal.measurement.zzgm.zzd();
                        zzd3.zzf(((zzky) zzu.get(i10)).zzc);
                        zzd3.zzg(((zzky) zzu.get(i10)).zzd);
                        zzkv zzkvVar5 = this.zzi;
                        zzal(zzkvVar5);
                        zzkvVar5.zzu(zzd3, ((zzky) zzu.get(i10)).zze);
                        zzt.zzl(zzd3);
                    }
                    try {
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        com.google.android.gms.internal.measurement.zzgd zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) zzt.zzaC();
                        zzamVar2.zzg();
                        zzamVar2.zzW();
                        Preconditions.checkNotNull(zzgdVar2);
                        Preconditions.checkNotEmpty(zzgdVar2.zzx());
                        byte[] zzbu3 = zzgdVar2.zzbu();
                        zzkv zzkvVar22 = zzamVar2.zzf.zzi;
                        zzal(zzkvVar22);
                        long zzd22 = zzkvVar22.zzd(zzbu3);
                        ContentValues contentValues22 = new ContentValues();
                        contentValues22.put("app_id", zzgdVar2.zzx());
                        String str102 = str;
                        contentValues22.put(str102, Long.valueOf(zzd22));
                        contentValues22.put("metadata", zzbu3);
                        zzamVar2.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                        zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzatVar = new zzat(zzarVar.zzf);
                        while (true) {
                            if (!zzatVar.hasNext()) {
                                if ("_r".equals(zzatVar.next())) {
                                    break;
                                }
                            } else {
                                zzfi zzfiVar4 = this.zzc;
                                zzal(zzfiVar4);
                                boolean zzq = zzfiVar4.zzq(zzarVar.zza, zzarVar.zzb);
                                zzam zzamVar20 = this.zze;
                                zzal(zzamVar20);
                                zzak zzl = zzamVar20.zzl(zza(), zzarVar.zza, false, false, false, false, false);
                                if (!zzq || zzl.zze >= zzg().zze(zzarVar.zza, zzdu.zzn)) {
                                    i11 = 0;
                                }
                            }
                        }
                        i11 = 1;
                        zzamVar3.zzg();
                        zzamVar3.zzW();
                        Preconditions.checkNotNull(zzarVar);
                        Preconditions.checkNotEmpty(zzarVar.zza);
                        zzkv zzkvVar32 = zzamVar3.zzf.zzi;
                        zzal(zzkvVar32);
                        byte[] zzbu22 = zzkvVar32.zzj(zzarVar).zzbu();
                        contentValues = new ContentValues();
                        contentValues.put("app_id", zzarVar.zza);
                        contentValues.put("name", zzarVar.zzb);
                        contentValues.put(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(zzarVar.zzd));
                        contentValues.put(str102, Long.valueOf(zzd22));
                        contentValues.put("data", zzbu22);
                        contentValues.put("realtime", Integer.valueOf(i11));
                        try {
                            if (zzamVar3.zzh().insert(str5, null, contentValues) != -1) {
                                zzamVar3.zzt.zzay().zzd().zzb("Failed to insert raw event (got -1). appId", zzeh.zzn(zzarVar.zza));
                            } else {
                                this.zza = 0L;
                            }
                        } catch (SQLiteException e15) {
                            zzamVar3.zzt.zzay().zzd().zzc("Error storing raw event. appId", zzeh.zzn(zzarVar.zza), e15);
                        }
                    } catch (IOException e16) {
                        zzay().zzd().zzc("Data loss. Failed to insert raw event metadata. appId", zzeh.zzn(zzt.zzap()), e16);
                    }
                    zzam zzamVar162 = this.zze;
                    zzal(zzamVar162);
                    zzamVar162.zzC();
                    zzam zzamVar172 = this.zze;
                    zzal(zzamVar172);
                    zzamVar172.zzx();
                    zzag();
                    zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                    return;
                }
                zzg = zza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
                if (z10) {
                    longValue = zza.zzb.zze("value").longValue();
                } else {
                    double doubleValue = zza.zzb.zzd("value").doubleValue() * 1000000.0d;
                    if (doubleValue == 0.0d) {
                        double longValue2 = zza.zzb.zze("value").longValue();
                        Double.isNaN(longValue2);
                        doubleValue = longValue2 * 1000000.0d;
                    }
                    if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                        zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzeh.zzn(str6), Double.valueOf(doubleValue));
                        zzam zzamVar21 = this.zze;
                        zzal(zzamVar21);
                        zzamVar21.zzC();
                        return;
                    }
                    longValue = Math.round(doubleValue);
                    if (FirebaseAnalytics.Event.REFUND.equals(zza.zza)) {
                        longValue = -longValue;
                    }
                }
                if (!TextUtils.isEmpty(zzg)) {
                    String upperCase = zzg.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        String concat = "_ltv_".concat(upperCase);
                        zzam zzamVar22 = this.zze;
                        zzal(zzamVar22);
                        zzky zzp2 = zzamVar22.zzp(str6, concat);
                        if (zzp2 != null) {
                            Object obj3 = zzp2.zze;
                            if (obj3 instanceof Long) {
                                obj = null;
                                str = "metadata_fingerprint";
                                str2 = "_err";
                                zzkyVar = new zzky(str6, zza.zzc, concat, zzav().currentTimeMillis(), Long.valueOf(((Long) obj3).longValue() + longValue));
                                zzkyVar2 = zzkyVar;
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                if (!zzamVar.zzL(zzkyVar2)) {
                                    zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeh.zzn(str6), this.zzn.zzj().zzf(zzkyVar2.zzc), zzkyVar2.zze);
                                    zzv().zzN(this.zzF, str6, 9, null, null, 0);
                                }
                                boolean zzai2 = zzlb.zzai(zza.zza);
                                boolean equals2 = str2.equals(zza.zza);
                                zzv();
                                zzauVar = zza.zzb;
                                if (zzauVar != null) {
                                }
                                zzam zzamVar62 = this.zze;
                                zzal(zzamVar62);
                                zzak zzm2 = zzamVar62.zzm(zza(), str6, j10 + 1, true, zzai2, false, equals2, false);
                                long j142 = zzm2.zzb;
                                zzg();
                                intValue = j142 - ((Integer) zzdu.zzj.zza(obj)).intValue();
                                if (intValue <= 0) {
                                }
                            }
                        }
                        str = "metadata_fingerprint";
                        str2 = "_err";
                        zzam zzamVar23 = this.zze;
                        zzal(zzamVar23);
                        int zze = zzg().zze(str6, zzdu.zzD) - 1;
                        Preconditions.checkNotEmpty(str6);
                        zzamVar23.zzg();
                        zzamVar23.zzW();
                        SQLiteDatabase zzh = zzamVar23.zzh();
                        String[] strArr = new String[3];
                        strArr[0] = str6;
                        strArr[1] = str6;
                        strArr[2] = String.valueOf(zze);
                        zzh.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                        obj = null;
                        zzkyVar = new zzky(str6, zza.zzc, concat, zzav().currentTimeMillis(), Long.valueOf(longValue));
                        zzkyVar2 = zzkyVar;
                        zzamVar = this.zze;
                        zzal(zzamVar);
                        if (!zzamVar.zzL(zzkyVar2)) {
                        }
                        boolean zzai22 = zzlb.zzai(zza.zza);
                        boolean equals22 = str2.equals(zza.zza);
                        zzv();
                        zzauVar = zza.zzb;
                        if (zzauVar != null) {
                        }
                        zzam zzamVar622 = this.zze;
                        zzal(zzamVar622);
                        zzak zzm22 = zzamVar622.zzm(zza(), str6, j10 + 1, true, zzai22, false, equals22, false);
                        long j1422 = zzm22.zzb;
                        zzg();
                        intValue = j1422 - ((Integer) zzdu.zzj.zza(obj)).intValue();
                        if (intValue <= 0) {
                        }
                    }
                }
                str = "metadata_fingerprint";
                str2 = "_err";
                obj = null;
                boolean zzai222 = zzlb.zzai(zza.zza);
                boolean equals222 = str2.equals(zza.zza);
                zzv();
                zzauVar = zza.zzb;
                if (zzauVar != null) {
                }
                zzam zzamVar6222 = this.zze;
                zzal(zzamVar6222);
                zzak zzm222 = zzamVar6222.zzm(zza(), str6, j10 + 1, true, zzai222, false, equals222, false);
                long j14222 = zzm222.zzb;
                zzg();
                intValue = j14222 - ((Integer) zzdu.zzj.zza(obj)).intValue();
                if (intValue <= 0) {
                }
            }
            z10 = true;
            if (!"_iap".equals(zza.zza)) {
            }
            zzg = zza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
            if (z10) {
            }
            if (!TextUtils.isEmpty(zzg)) {
            }
            str = "metadata_fingerprint";
            str2 = "_err";
            obj = null;
            boolean zzai2222 = zzlb.zzai(zza.zza);
            boolean equals2222 = str2.equals(zza.zza);
            zzv();
            zzauVar = zza.zzb;
            if (zzauVar != null) {
            }
            zzam zzamVar62222 = this.zze;
            zzal(zzamVar62222);
            zzak zzm2222 = zzamVar62222.zzm(zza(), str6, j10 + 1, true, zzai2222, false, equals2222, false);
            long j142222 = zzm2222.zzb;
            zzg();
            intValue = j142222 - ((Integer) zzdu.zzj.zza(obj)).intValue();
            if (intValue <= 0) {
            }
        } finally {
            zzam zzamVar24 = this.zze;
            zzal(zzamVar24);
            zzamVar24.zzx();
        }
    }

    @VisibleForTesting
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock != null && fileLock.isValid()) {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzt.zzf();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzx = channel;
            FileLock tryLock = channel.tryLock();
            this.zzw = tryLock;
            if (tryLock != null) {
                zzay().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzay().zzd().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e10) {
            zzay().zzd().zzb("Failed to acquire storage lock", e10);
            return false;
        } catch (IOException e11) {
            zzay().zzd().zzb("Failed to access storage lock file", e11);
            return false;
        } catch (OverlappingFileLockException e12) {
            zzay().zzk().zzb("Storage lock already acquired", e12);
            return false;
        }
    }

    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjo zzjoVar = this.zzk;
        zzjoVar.zzW();
        zzjoVar.zzg();
        long zza = zzjoVar.zze.zza();
        if (zza == 0) {
            zza = zzjoVar.zzt.zzv().zzG().nextInt(86400000) + 1;
            zzjoVar.zze.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Context zzau() {
        return this.zzn.zzau();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzab zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    public final zzh zzd(zzq zzqVar) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzkr zzkrVar = null;
        if (!zzqVar.zzw.isEmpty()) {
            this.zzC.put(zzqVar.zza, new zzks(this, zzqVar.zzw));
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzj = zzamVar.zzj(zzqVar.zza);
        zzai zzc = zzh(zzqVar.zza).zzc(zzai.zzb(zzqVar.zzv));
        zzah zzahVar = zzah.AD_STORAGE;
        String zzf = zzc.zzi(zzahVar) ? this.zzk.zzf(zzqVar.zza, zzqVar.zzo) : "";
        if (zzj == null) {
            zzj = new zzh(this.zzn, zzqVar.zza);
            if (zzc.zzi(zzah.ANALYTICS_STORAGE)) {
                zzj.zzH(zzw(zzc));
            }
            if (zzc.zzi(zzahVar)) {
                zzj.zzae(zzf);
            }
        } else if (zzc.zzi(zzahVar) && zzf != null && !zzf.equals(zzj.zzA())) {
            zzj.zzae(zzf);
            if (zzqVar.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzqVar.zza, zzc).first)) {
                zzj.zzH(zzw(zzc));
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                if (zzamVar2.zzp(zzqVar.zza, bx.f10121d) != null) {
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzp(zzqVar.zza, "_lair") == null) {
                        zzky zzkyVar = new zzky(zzqVar.zza, ConnType.PK_AUTO, "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzL(zzkyVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj.zzu()) && zzc.zzi(zzah.ANALYTICS_STORAGE)) {
            zzj.zzH(zzw(zzc));
        }
        zzj.zzW(zzqVar.zzb);
        zzj.zzF(zzqVar.zzq);
        if (!TextUtils.isEmpty(zzqVar.zzk)) {
            zzj.zzV(zzqVar.zzk);
        }
        long j10 = zzqVar.zze;
        if (j10 != 0) {
            zzj.zzX(j10);
        }
        if (!TextUtils.isEmpty(zzqVar.zzc)) {
            zzj.zzJ(zzqVar.zzc);
        }
        zzj.zzK(zzqVar.zzj);
        String str = zzqVar.zzd;
        if (str != null) {
            zzj.zzI(str);
        }
        zzj.zzS(zzqVar.zzf);
        zzj.zzac(zzqVar.zzh);
        if (!TextUtils.isEmpty(zzqVar.zzg)) {
            zzj.zzY(zzqVar.zzg);
        }
        zzj.zzG(zzqVar.zzo);
        zzj.zzad(zzqVar.zzr);
        zzj.zzT(zzqVar.zzs);
        zzpd.zzc();
        if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(zzqVar.zza, zzdu.zzan)) {
            zzj.zzag(zzqVar.zzx);
        }
        zznt.zzc();
        if (zzg().zzs(null, zzdu.zzaj)) {
            zzj.zzaf(zzqVar.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs(null, zzdu.zzai)) {
                zzj.zzaf(null);
            }
        }
        if (zzj.zzaj()) {
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzD(zzj);
        }
        return zzj;
    }

    public final zzaa zzf() {
        zzaa zzaaVar = this.zzh;
        zzal(zzaaVar);
        return zzaaVar;
    }

    public final zzag zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzai zzh(String str) {
        String str2;
        zzai zzaiVar = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzaiVar2 = (zzai) this.zzB.get(str);
        if (zzaiVar2 != null) {
            return zzaiVar2;
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        zzamVar.zzg();
        zzamVar.zzW();
        Cursor cursor = null;
        try {
            try {
                cursor = zzamVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(0);
                    cursor.close();
                } else {
                    cursor.close();
                    str2 = "G1";
                }
                zzai zzb2 = zzai.zzb(str2);
                zzV(str, zzb2);
                return zzb2;
            } catch (SQLiteException e10) {
                zzamVar.zzt.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        return zzamVar;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzenVar = this.zzd;
        zzal(zzenVar);
        return zzenVar;
    }

    public final zzep zzm() {
        zzep zzepVar = this.zzf;
        if (zzepVar != null) {
            return zzepVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        return zzfiVar;
    }

    public final zzfr zzq() {
        return this.zzn;
    }

    public final zzic zzr() {
        zzic zzicVar = this.zzj;
        zzal(zzicVar);
        return zzicVar;
    }

    public final zzjo zzs() {
        return this.zzk;
    }

    public final zzkv zzu() {
        zzkv zzkvVar = this.zzi;
        zzal(zzkvVar);
        return zzkvVar;
    }

    public final zzlb zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    public final String zzw(zzai zzaiVar) {
        if (!zzaiVar.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final String zzx(zzq zzqVar) {
        try {
            return (String) zzaz().zzh(new zzkm(this, zzqVar)).get(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzqVar.zza), e10);
            return null;
        }
    }

    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
