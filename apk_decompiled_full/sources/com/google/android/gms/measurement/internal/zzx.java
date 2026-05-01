package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.google.android.gms.internal.measurement.zznz;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
final class zzx extends zzy {
    final /* synthetic */ zzaa zza;
    private final com.google.android.gms.internal.measurement.zzek zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzaa zzaaVar, String str, int i10, com.google.android.gms.internal.measurement.zzek zzekVar) {
        super(str, i10);
        this.zza = zzaaVar;
        this.zzh = zzekVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return this.zzh.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(Long l10, Long l11, com.google.android.gms.internal.measurement.zzft zzftVar, long j10, zzas zzasVar, boolean z10) {
        Boolean zzi;
        zznz.zzc();
        boolean zzs = this.zza.zzt.zzf().zzs(this.zzb, zzdu.zzW);
        long j11 = this.zzh.zzn() ? zzasVar.zze : j10;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        Boolean bool = null;
        if (Log.isLoggable(this.zza.zzt.zzay().zzq(), 2)) {
            this.zza.zzt.zzay().zzj().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null, this.zza.zzt.zzj().zzd(this.zzh.zzg()));
            this.zza.zzt.zzay().zzj().zzb("Filter definition", this.zza.zzf.zzu().zzo(this.zzh));
        }
        if (!this.zzh.zzp() || this.zzh.zzb() > 256) {
            this.zza.zzt.zzay().zzk().zzc("Invalid event filter ID. appId, id", zzeh.zzn(this.zzb), String.valueOf(this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null));
            return false;
        }
        boolean z11 = this.zzh.zzk() || this.zzh.zzm() || this.zzh.zzn();
        if (z10 && !z11) {
            this.zza.zzt.zzay().zzj().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzek zzekVar = this.zzh;
        String zzh = zzftVar.zzh();
        if (zzekVar.zzo()) {
            Boolean zzh2 = zzy.zzh(j11, zzekVar.zzf());
            if (zzh2 != null) {
                if (!zzh2.booleanValue()) {
                    bool = Boolean.FALSE;
                }
            }
            this.zza.zzt.zzay().zzj().zzb("Event filter result", bool != null ? "null" : bool);
            if (bool != null) {
                return false;
            }
            Boolean bool2 = Boolean.TRUE;
            this.zzd = bool2;
            if (!bool.booleanValue()) {
                return true;
            }
            this.zze = bool2;
            if (z11 && zzftVar.zzu()) {
                Long valueOf = Long.valueOf(zzftVar.zzd());
                if (this.zzh.zzm()) {
                    if (zzs && this.zzh.zzo()) {
                        valueOf = l10;
                    }
                    this.zzg = valueOf;
                } else {
                    if (zzs && this.zzh.zzo()) {
                        valueOf = l11;
                    }
                    this.zzf = valueOf;
                }
            }
            return true;
        }
        HashSet hashSet = new HashSet();
        Iterator it = zzekVar.zzh().iterator();
        while (true) {
            if (!it.hasNext()) {
                androidx.collection.a aVar = new androidx.collection.a();
                Iterator it2 = zzftVar.zzi().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        Iterator it3 = zzekVar.zzh().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                bool = Boolean.TRUE;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zzem zzemVar = (com.google.android.gms.internal.measurement.zzem) it3.next();
                            boolean z12 = zzemVar.zzh() && zzemVar.zzg();
                            String zze = zzemVar.zze();
                            if (zze.isEmpty()) {
                                this.zza.zzt.zzay().zzk().zzb("Event has empty param name. event", this.zza.zzt.zzj().zzd(zzh));
                                break;
                            }
                            Object obj = aVar.get(zze);
                            if (obj instanceof Long) {
                                if (!zzemVar.zzi()) {
                                    this.zza.zzt.zzay().zzk().zzc("No number filter for long param. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                                    break;
                                }
                                Boolean zzh3 = zzy.zzh(((Long) obj).longValue(), zzemVar.zzc());
                                if (zzh3 == null) {
                                    break;
                                }
                                if (zzh3.booleanValue() == z12) {
                                    bool = Boolean.FALSE;
                                    break;
                                }
                            } else if (obj instanceof Double) {
                                if (!zzemVar.zzi()) {
                                    this.zza.zzt.zzay().zzk().zzc("No number filter for double param. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                                    break;
                                }
                                Boolean zzg = zzy.zzg(((Double) obj).doubleValue(), zzemVar.zzc());
                                if (zzg == null) {
                                    break;
                                }
                                if (zzg.booleanValue() == z12) {
                                    bool = Boolean.FALSE;
                                    break;
                                }
                            } else if (obj instanceof String) {
                                if (!zzemVar.zzk()) {
                                    if (!zzemVar.zzi()) {
                                        this.zza.zzt.zzay().zzk().zzc("No filter for String param. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                                        break;
                                    }
                                    String str = (String) obj;
                                    if (!zzkv.zzx(str)) {
                                        this.zza.zzt.zzay().zzk().zzc("Invalid param value for number filter. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                                        break;
                                    }
                                    zzi = zzy.zzi(str, zzemVar.zzc());
                                } else {
                                    zzi = zzy.zzf((String) obj, zzemVar.zzd(), this.zza.zzt.zzay());
                                }
                                if (zzi == null) {
                                    break;
                                }
                                if (zzi.booleanValue() == z12) {
                                    bool = Boolean.FALSE;
                                    break;
                                }
                            } else if (obj == null) {
                                this.zza.zzt.zzay().zzj().zzc("Missing param for filter. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                                bool = Boolean.FALSE;
                            } else {
                                this.zza.zzt.zzay().zzk().zzc("Unknown param type. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zze));
                            }
                        }
                    } else {
                        com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it2.next();
                        if (hashSet.contains(zzfxVar.zzg())) {
                            if (!zzfxVar.zzw()) {
                                if (!zzfxVar.zzu()) {
                                    if (!zzfxVar.zzy()) {
                                        this.zza.zzt.zzay().zzk().zzc("Unknown value for param. event, param", this.zza.zzt.zzj().zzd(zzh), this.zza.zzt.zzj().zze(zzfxVar.zzg()));
                                        break;
                                    }
                                    aVar.put(zzfxVar.zzg(), zzfxVar.zzh());
                                } else {
                                    aVar.put(zzfxVar.zzg(), zzfxVar.zzu() ? Double.valueOf(zzfxVar.zza()) : null);
                                }
                            } else {
                                aVar.put(zzfxVar.zzg(), zzfxVar.zzw() ? Long.valueOf(zzfxVar.zzd()) : null);
                            }
                        }
                    }
                }
            } else {
                com.google.android.gms.internal.measurement.zzem zzemVar2 = (com.google.android.gms.internal.measurement.zzem) it.next();
                if (zzemVar2.zze().isEmpty()) {
                    this.zza.zzt.zzay().zzk().zzb("null or empty param name in filter. event", this.zza.zzt.zzj().zzd(zzh));
                    break;
                }
                hashSet.add(zzemVar2.zze());
            }
        }
        this.zza.zzt.zzay().zzj().zzb("Event filter result", bool != null ? "null" : bool);
        if (bool != null) {
        }
    }
}
