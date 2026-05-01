package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.google.firebase.dynamiclinks.DynamicLink;

/* loaded from: classes.dex */
final class zzhu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhw zze;

    public zzhu(zzhw zzhwVar, boolean z10, Uri uri, String str, String str2) {
        this.zze = zzhwVar;
        this.zza = z10;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0 A[Catch: RuntimeException -> 0x0161, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0161, blocks: (B:3:0x0011, B:9:0x0086, B:11:0x0094, B:14:0x00a1, B:16:0x00a7, B:17:0x00bc, B:18:0x00c8, B:23:0x00d0, B:27:0x00f7, B:28:0x0115, B:30:0x0104, B:31:0x011c, B:33:0x0122, B:35:0x0128, B:37:0x012e, B:39:0x0134, B:41:0x013c, B:43:0x0144, B:45:0x014a, B:48:0x0151, B:50:0x002e, B:52:0x0034, B:54:0x003a, B:56:0x0040, B:58:0x0046, B:60:0x004e, B:62:0x0056, B:64:0x005e, B:65:0x006c, B:67:0x007c), top: B:2:0x0011 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle zzs;
        Bundle zzs2;
        zzhw zzhwVar = this.zze;
        boolean z10 = this.zza;
        Uri uri = this.zzb;
        String str = this.zzc;
        String str2 = this.zzd;
        zzhwVar.zza.zzg();
        try {
            zzlb zzv = zzhwVar.zza.zzt.zzv();
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid")) {
                    zzs = zzv.zzs(Uri.parse("https://google.com/search?".concat(str2)));
                    if (zzs != null) {
                        zzs.putString("_cis", "referrer");
                    }
                    if (z10 && (zzs2 = zzhwVar.zza.zzt.zzv().zzs(uri)) != null) {
                        zzs2.putString("_cis", "intent");
                        if (!zzs2.containsKey("gclid") && zzs != null && zzs.containsKey("gclid")) {
                            zzs2.putString("_cer", String.format("gclid=%s", zzs.getString("gclid")));
                        }
                        zzhwVar.zza.zzG(str, "_cmp", zzs2);
                        zzhwVar.zza.zzb.zza(str, zzs2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzhwVar.zza.zzt.zzay().zzc().zzb("Activity created with referrer", str2);
                        if (zzhwVar.zza.zzt.zzf().zzs(null, zzdu.zzY)) {
                            if (zzs != null) {
                                zzhwVar.zza.zzG(str, "_cmp", zzs);
                                zzhwVar.zza.zzb.zza(str, zzs);
                            } else {
                                zzhwVar.zza.zzt.zzay().zzc().zzb("Referrer does not contain valid parameters", str2);
                            }
                            zzhwVar.zza.zzW(ConnType.PK_AUTO, "_ldl", null, true);
                            return;
                        }
                        if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_TERM) && !str2.contains(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_CONTENT))) {
                            zzhwVar.zza.zzt.zzay().zzc().zza("Activity created with data 'referrer' without required params");
                            return;
                        } else {
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            zzhwVar.zza.zzW(ConnType.PK_AUTO, "_ldl", str2, true);
                            return;
                        }
                    }
                    return;
                }
                zzv.zzt.zzay().zzc().zza("Activity created with data 'referrer' without required params");
            }
            zzs = null;
            if (z10) {
                zzs2.putString("_cis", "intent");
                if (!zzs2.containsKey("gclid")) {
                    zzs2.putString("_cer", String.format("gclid=%s", zzs.getString("gclid")));
                }
                zzhwVar.zza.zzG(str, "_cmp", zzs2);
                zzhwVar.zza.zzb.zza(str, zzs2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e10) {
            zzhwVar.zza.zzt.zzay().zzd().zzb("Throwable caught in handleReferrerForOnActivityCreated", e10);
        }
    }
}
