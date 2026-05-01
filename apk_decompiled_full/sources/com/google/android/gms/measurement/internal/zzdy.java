package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.internal.measurement.zzpj;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzdy extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    public zzdy(zzfr zzfrVar, long j10) {
        super(zzfrVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|1|(1:3)(6:65|66|(1:68)(2:83|(1:85))|69|70|(20:72|(1:74)(1:81)|76|77|5|(1:64)(1:9)|10|11|13|(1:15)|16|17|(1:19)|20|(3:22|(1:24)(1:26)|25)|(3:28|(1:30)(1:33)|31)|34|(3:36|(1:38)(3:45|(3:48|(1:50)(1:51)|46)|52)|(2:40|41)(2:43|44))|53|(0)(0)))|4|5|(1:7)|64|10|11|13|(0)|16|17|(0)|20|(0)|(0)|34|(0)|53|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01db, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01dc, code lost:
    
        r11.zzt.zzay().zzd().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0194 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:17:0x0173, B:20:0x018c, B:22:0x0194, B:25:0x01b2, B:26:0x01ae, B:28:0x01bc, B:30:0x01d2, B:31:0x01d7, B:33:0x01d5), top: B:16:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01bc A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:17:0x0173, B:20:0x018c, B:22:0x0194, B:25:0x01b2, B:26:0x01ae, B:28:0x01bc, B:30:0x01d2, B:31:0x01d7, B:33:0x01d5), top: B:16:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00b6  */
    @Override // com.google.android.gms.measurement.internal.zzf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd() {
        String str;
        String str2;
        PackageInfo packageInfo;
        boolean z10;
        int zza;
        List zzp;
        String zzc;
        String packageName = this.zzt.zzau().getPackageName();
        PackageManager packageManager = this.zzt.zzau().getPackageManager();
        int i10 = Integer.MIN_VALUE;
        String str3 = "unknown";
        String str4 = "Unknown";
        if (packageManager == null) {
            this.zzt.zzay().zzd().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzeh.zzn(packageName));
        } else {
            try {
                str3 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzt.zzay().zzd().zzb("Error retrieving app installer package name. appId", zzeh.zzn(packageName));
            }
            if (str3 == null) {
                str3 = "manual_install";
            } else if ("com.android.vending".equals(str3)) {
                str3 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzt.zzau().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = "Unknown";
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                str2 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                try {
                    str4 = packageInfo.versionName;
                    i10 = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str4;
                    str4 = str2;
                    this.zzt.zzay().zzd().zzc("Error retrieving package info. appId, appName", zzeh.zzn(packageName), str4);
                    str2 = str4;
                    str4 = str;
                    this.zza = packageName;
                    this.zzd = str3;
                    this.zzb = str4;
                    this.zzc = i10;
                    this.zze = str2;
                    this.zzf = 0L;
                    if (TextUtils.isEmpty(this.zzt.zzw())) {
                    }
                    zza = this.zzt.zza();
                    switch (zza) {
                    }
                    this.zzk = "";
                    this.zzl = "";
                    this.zzt.zzaw();
                    if (z10) {
                    }
                    zzc = zzid.zzc(this.zzt.zzau(), "google_app_id", this.zzt.zzz());
                    this.zzk = true != TextUtils.isEmpty(zzc) ? zzc : "";
                    if (!TextUtils.isEmpty(zzc)) {
                    }
                    if (zza == 0) {
                    }
                    this.zzh = null;
                    this.zzt.zzaw();
                    zzp = this.zzt.zzf().zzp("analytics.safelisted_events");
                    if (zzp != null) {
                    }
                    this.zzh = zzp;
                    if (packageManager == null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str3;
                this.zzb = str4;
                this.zzc = i10;
                this.zze = str2;
                this.zzf = 0L;
                z10 = TextUtils.isEmpty(this.zzt.zzw()) && "am".equals(this.zzt.zzx());
                zza = this.zzt.zza();
                switch (zza) {
                    case 0:
                        this.zzt.zzay().zzj().zza("App measurement collection enabled");
                        break;
                    case 1:
                        this.zzt.zzay().zzi().zza("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        this.zzt.zzay().zzj().zza("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        this.zzt.zzay().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        this.zzt.zzay().zzi().zza("App measurement disabled via the manifest");
                        break;
                    case 5:
                        this.zzt.zzay().zzj().zza("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        this.zzt.zzay().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        break;
                    case 7:
                        this.zzt.zzay().zzi().zza("App measurement disabled via the global data collection setting");
                        break;
                    default:
                        this.zzt.zzay().zzi().zza("App measurement disabled due to denied storage consent");
                        break;
                }
                this.zzk = "";
                this.zzl = "";
                this.zzt.zzaw();
                if (z10) {
                    this.zzl = this.zzt.zzw();
                }
                zzc = zzid.zzc(this.zzt.zzau(), "google_app_id", this.zzt.zzz());
                this.zzk = true != TextUtils.isEmpty(zzc) ? zzc : "";
                if (!TextUtils.isEmpty(zzc)) {
                    Context zzau = this.zzt.zzau();
                    String zzz = this.zzt.zzz();
                    Preconditions.checkNotNull(zzau);
                    Resources resources = zzau.getResources();
                    if (TextUtils.isEmpty(zzz)) {
                        zzz = zzfj.zza(zzau);
                    }
                    this.zzl = zzfj.zzb("admob_app_id", resources, zzz);
                }
                if (zza == 0) {
                    this.zzt.zzay().zzj().zzc("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzk) ? this.zzl : this.zzk);
                }
                this.zzh = null;
                this.zzt.zzaw();
                zzp = this.zzt.zzf().zzp("analytics.safelisted_events");
                if (zzp != null) {
                    if (zzp.isEmpty()) {
                        this.zzt.zzay().zzl().zza("Safelisted event list is empty. Ignoring");
                    } else {
                        Iterator it = zzp.iterator();
                        while (it.hasNext()) {
                            if (!this.zzt.zzv().zzab("safelisted event", (String) it.next())) {
                            }
                        }
                    }
                    if (packageManager == null) {
                        this.zzj = InstantApps.isInstantApp(this.zzt.zzau()) ? 1 : 0;
                        return;
                    } else {
                        this.zzj = 0;
                        return;
                    }
                }
                this.zzh = zzp;
                if (packageManager == null) {
                }
            }
        }
        str2 = "Unknown";
        this.zza = packageName;
        this.zzd = str3;
        this.zzb = str4;
        this.zzc = i10;
        this.zze = str2;
        this.zzf = 0L;
        if (TextUtils.isEmpty(this.zzt.zzw())) {
        }
        zza = this.zzt.zza();
        switch (zza) {
        }
        this.zzk = "";
        this.zzl = "";
        this.zzt.zzaw();
        if (z10) {
        }
        zzc = zzid.zzc(this.zzt.zzau(), "google_app_id", this.zzt.zzz());
        this.zzk = true != TextUtils.isEmpty(zzc) ? zzc : "";
        if (!TextUtils.isEmpty(zzc)) {
        }
        if (zza == 0) {
        }
        this.zzh = null;
        this.zzt.zzaw();
        zzp = this.zzt.zzf().zzp("analytics.safelisted_events");
        if (zzp != null) {
        }
        this.zzh = zzp;
        if (packageManager == null) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return true;
    }

    public final int zzh() {
        zza();
        return this.zzj;
    }

    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0192  */
    /* JADX WARN: Type inference failed for: r9v38, types: [com.google.android.gms.measurement.internal.zzgk, com.google.android.gms.measurement.internal.zzlb] */
    /* JADX WARN: Type inference failed for: r9v39, types: [com.google.android.gms.measurement.internal.zzgk] */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v48 */
    /* JADX WARN: Type inference failed for: r9v49 */
    /* JADX WARN: Type inference failed for: r9v50 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzq zzj(String str) {
        String str2;
        Class<?> loadClass;
        Object invoke;
        long zza;
        String str3;
        long min;
        String str4;
        long j10;
        String str5;
        String str6;
        zzg();
        String zzl = zzl();
        String zzm = zzm();
        zza();
        String str7 = this.zzb;
        zza();
        long j11 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str8 = this.zzd;
        this.zzt.zzf().zzh();
        zza();
        zzg();
        long j12 = this.zzf;
        if (j12 == 0) {
            ?? zzv = this.zzt.zzv();
            Context zzau = this.zzt.zzau();
            String packageName = this.zzt.zzau().getPackageName();
            zzv.zzg();
            Preconditions.checkNotNull(zzau);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = zzau.getPackageManager();
            MessageDigest zzF = zzlb.zzF();
            long j13 = -1;
            if (zzF == null) {
                zzv.zzt.zzay().zzd().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (zzv.zzag(zzau, packageName)) {
                            j13 = 0;
                            zzv = zzv;
                        } else {
                            Signature[] signatureArr = Wrappers.packageManager(zzau).getPackageInfo(zzv.zzt.zzau().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                zzv.zzt.zzay().zzk().zza("Could not get signatures");
                                zzv = zzv;
                            } else {
                                long zzp = zzlb.zzp(zzF.digest(signatureArr[0].toByteArray()));
                                j13 = zzp;
                                zzv = zzp;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e10) {
                        zzv.zzt.zzay().zzd().zzb("Package name not found", e10);
                    }
                }
                j12 = 0;
                this.zzf = j12;
            }
            j12 = j13;
            this.zzf = j12;
        }
        long j14 = j12;
        boolean zzJ = this.zzt.zzJ();
        boolean z10 = !this.zzt.zzm().zzl;
        zzg();
        if (this.zzt.zzJ()) {
            zzpj.zzc();
            if (this.zzt.zzf().zzs(null, zzdu.zzaa)) {
                this.zzt.zzay().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    loadClass = this.zzt.zzau().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (loadClass != null) {
                    try {
                        invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzt.zzau());
                    } catch (Exception unused2) {
                        this.zzt.zzay().zzm().zza("Failed to obtain Firebase Analytics instance");
                    }
                    if (invoke != null) {
                        try {
                            str2 = (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                        } catch (Exception unused3) {
                            this.zzt.zzay().zzl().zza("Failed to retrieve Firebase Instance Id");
                        }
                        zzfr zzfrVar = this.zzt;
                        zza = zzfrVar.zzm().zzc.zza();
                        if (zza == 0) {
                            str3 = zzl;
                            min = zzfrVar.zzc;
                        } else {
                            str3 = zzl;
                            min = Math.min(zzfrVar.zzc, zza);
                        }
                        zza();
                        int i10 = this.zzj;
                        boolean zzr = this.zzt.zzf().zzr();
                        zzew zzm2 = this.zzt.zzm();
                        zzm2.zzg();
                        boolean z11 = zzm2.zza().getBoolean("deferred_analytics_collection", false);
                        zza();
                        String str9 = this.zzl;
                        Boolean valueOf = this.zzt.zzf().zzk("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r2.booleanValue());
                        long j15 = this.zzg;
                        List list = this.zzh;
                        String zzh = this.zzt.zzm().zzc().zzh();
                        if (this.zzi == null) {
                            str4 = str9;
                            j10 = j15;
                            if (this.zzt.zzf().zzs(null, zzdu.zzap)) {
                                this.zzi = this.zzt.zzv().zzC();
                            } else {
                                this.zzi = "";
                            }
                        } else {
                            str4 = str9;
                            j10 = j15;
                        }
                        String str10 = this.zzi;
                        zzpd.zzc();
                        if (this.zzt.zzf().zzs(null, zzdu.zzam)) {
                            zzg();
                            if (this.zzn == 0) {
                                str5 = str10;
                            } else {
                                str5 = str10;
                                long currentTimeMillis = this.zzt.zzav().currentTimeMillis() - this.zzn;
                                if (this.zzm != null && currentTimeMillis > 86400000 && this.zzo == null) {
                                    zzo();
                                }
                            }
                            if (this.zzm == null) {
                                zzo();
                            }
                            str6 = this.zzm;
                        } else {
                            str5 = str10;
                            str6 = null;
                        }
                        return new zzq(str3, zzm, str7, j11, str8, 74029L, j14, str, zzJ, z10, str2, 0L, min, i10, zzr, z11, str4, valueOf, j10, list, (String) null, zzh, str5, str6);
                    }
                    str2 = null;
                    zzfr zzfrVar2 = this.zzt;
                    zza = zzfrVar2.zzm().zzc.zza();
                    if (zza == 0) {
                    }
                    zza();
                    int i102 = this.zzj;
                    boolean zzr2 = this.zzt.zzf().zzr();
                    zzew zzm22 = this.zzt.zzm();
                    zzm22.zzg();
                    boolean z112 = zzm22.zza().getBoolean("deferred_analytics_collection", false);
                    zza();
                    String str92 = this.zzl;
                    if (this.zzt.zzf().zzk("google_analytics_default_allow_ad_personalization_signals") == null) {
                    }
                    long j152 = this.zzg;
                    List list2 = this.zzh;
                    String zzh2 = this.zzt.zzm().zzc().zzh();
                    if (this.zzi == null) {
                    }
                    String str102 = this.zzi;
                    zzpd.zzc();
                    if (this.zzt.zzf().zzs(null, zzdu.zzam)) {
                    }
                    return new zzq(str3, zzm, str7, j11, str8, 74029L, j14, str, zzJ, z10, str2, 0L, min, i102, zzr2, z112, str4, valueOf, j10, list2, (String) null, zzh2, str5, str6);
                }
            }
        }
        str2 = null;
        zzfr zzfrVar22 = this.zzt;
        zza = zzfrVar22.zzm().zzc.zza();
        if (zza == 0) {
        }
        zza();
        int i1022 = this.zzj;
        boolean zzr22 = this.zzt.zzf().zzr();
        zzew zzm222 = this.zzt.zzm();
        zzm222.zzg();
        boolean z1122 = zzm222.zza().getBoolean("deferred_analytics_collection", false);
        zza();
        String str922 = this.zzl;
        if (this.zzt.zzf().zzk("google_analytics_default_allow_ad_personalization_signals") == null) {
        }
        long j1522 = this.zzg;
        List list22 = this.zzh;
        String zzh22 = this.zzt.zzm().zzc().zzh();
        if (this.zzi == null) {
        }
        String str1022 = this.zzi;
        zzpd.zzc();
        if (this.zzt.zzf().zzs(null, zzdu.zzam)) {
        }
        return new zzq(str3, zzm, str7, j11, str8, 74029L, j14, str, zzJ, z10, str2, 0L, min, i1022, zzr22, z1122, str4, valueOf, j10, list22, (String) null, zzh22, str5, str6);
    }

    public final String zzk() {
        zza();
        return this.zzl;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final void zzo() {
        String format;
        zzg();
        if (this.zzt.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.zzt.zzv().zzG().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.zzt.zzay().zzc().zza("Analytics Storage consent is not granted");
            format = null;
        }
        zzef zzc = this.zzt.zzay().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = format == null ? "null" : "not null";
        zzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = format;
        this.zzn = this.zzt.zzav().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.zzo = str;
        return z10;
    }
}
