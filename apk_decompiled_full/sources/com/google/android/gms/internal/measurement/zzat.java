package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0286  */
    @Override // com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zzbR(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        char c10;
        zzat zzatVar;
        int i10;
        zzap zzahVar;
        String str8;
        double min;
        double min2;
        int i11;
        int i12;
        zzg zzgVar2;
        int i13;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str)) {
            str2 = "toLocaleUpperCase";
            str3 = "toUpperCase";
        } else {
            str3 = "toUpperCase";
            str2 = "toLocaleUpperCase";
            if (!str3.equals(str) && !str2.equals(str)) {
                str4 = "hasOwnProperty";
                if (!"trim".equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
                switch (str.hashCode()) {
                    case -1789698943:
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        if (str.equals(str6)) {
                            c10 = 2;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case -1776922004:
                        str5 = "charAt";
                        str7 = "toString";
                        if (str.equals(str7)) {
                            c10 = 14;
                            str6 = str4;
                            break;
                        } else {
                            str6 = str4;
                            c10 = 65535;
                            break;
                        }
                    case -1464939364:
                        str5 = "charAt";
                        if (str.equals("toLocaleLowerCase")) {
                            c10 = '\f';
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -1361633751:
                        str5 = "charAt";
                        if (str.equals(str5)) {
                            str6 = str4;
                            str7 = "toString";
                            c10 = 0;
                            break;
                        }
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -1354795244:
                        if (str.equals("concat")) {
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            c10 = 1;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -1137582698:
                        if (str.equals("toLowerCase")) {
                            c10 = ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -906336856:
                        if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                            c10 = 7;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -726908483:
                        if (str.equals(str2)) {
                            c10 = 11;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -467511597:
                        if (str.equals("lastIndexOf")) {
                            c10 = 4;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case -399551817:
                        if (str.equals(str3)) {
                            c10 = 15;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 3568674:
                        if (str.equals("trim")) {
                            c10 = 16;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 103668165:
                        if (str.equals("match")) {
                            c10 = 5;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 109526418:
                        if (str.equals("slice")) {
                            c10 = '\b';
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 109648666:
                        if (str.equals("split")) {
                            c10 = '\t';
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 530542161:
                        if (str.equals("substring")) {
                            c10 = '\n';
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 1094496948:
                        if (str.equals("replace")) {
                            c10 = 6;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    case 1943291465:
                        if (str.equals("indexOf")) {
                            c10 = 3;
                            str5 = "charAt";
                            str6 = str4;
                            str7 = "toString";
                            break;
                        }
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                    default:
                        str5 = "charAt";
                        str6 = str4;
                        str7 = "toString";
                        c10 = 65535;
                        break;
                }
                String str9 = str6;
                String str10 = str5;
                switch (c10) {
                    case 0:
                        zzh.zzj(str10, 1, list);
                        int zza = !list.isEmpty() ? (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) : 0;
                        String str11 = this.zza;
                        return (zza < 0 || zza >= str11.length()) ? zzap.zzm : new zzat(String.valueOf(str11.charAt(zza)));
                    case 1:
                        zzatVar = this;
                        if (!list.isEmpty()) {
                            StringBuilder sb = new StringBuilder(zzatVar.zza);
                            for (int i14 = 0; i14 < list.size(); i14++) {
                                sb.append(zzgVar.zzb((zzap) list.get(i14)).zzi());
                            }
                            return new zzat(sb.toString());
                        }
                        return zzatVar;
                    case 2:
                        zzh.zzh(str9, 1, list);
                        String str12 = this.zza;
                        zzap zzb = zzgVar.zzb((zzap) list.get(0));
                        if ("length".equals(zzb.zzi())) {
                            return zzap.zzk;
                        }
                        double doubleValue = zzb.zzh().doubleValue();
                        return (doubleValue != Math.floor(doubleValue) || (i10 = (int) doubleValue) < 0 || i10 >= str12.length()) ? zzap.zzl : zzap.zzk;
                    case 3:
                        zzh.zzj("indexOf", 2, list);
                        zzahVar = new zzah(Double.valueOf(this.zza.indexOf(list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined", (int) zzh.zza(list.size() < 2 ? 0.0d : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()))));
                        return zzahVar;
                    case 4:
                        zzh.zzj("lastIndexOf", 2, list);
                        String str13 = this.zza;
                        String zzi = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                        zzahVar = new zzah(Double.valueOf(str13.lastIndexOf(zzi, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zza(r1)))));
                        return zzahVar;
                    case 5:
                        zzh.zzj("match", 1, list);
                        Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza);
                        return matcher.find() ? new zzae(Arrays.asList(new zzat(matcher.group()))) : zzap.zzg;
                    case 6:
                        zzatVar = this;
                        zzh.zzj("replace", 2, list);
                        zzap zzapVar = zzap.zzf;
                        if (!list.isEmpty()) {
                            str8 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                zzapVar = zzgVar.zzb((zzap) list.get(1));
                            }
                        }
                        String str14 = str8;
                        String str15 = zzatVar.zza;
                        int indexOf = str15.indexOf(str14);
                        if (indexOf >= 0) {
                            if (zzapVar instanceof zzai) {
                                zzapVar = ((zzai) zzapVar).zza(zzgVar, Arrays.asList(new zzat(str14), new zzah(Double.valueOf(indexOf)), zzatVar));
                            }
                            zzahVar = new zzat(str15.substring(0, indexOf) + zzapVar.zzi() + str15.substring(indexOf + str14.length()));
                            return zzahVar;
                        }
                        return zzatVar;
                    case 7:
                        zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                        return Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza).find() ? new zzah(Double.valueOf(r1.start())) : new zzah(Double.valueOf(-1.0d));
                    case '\b':
                        zzh.zzj("slice", 2, list);
                        String str16 = this.zza;
                        double zza2 = zzh.zza(!list.isEmpty() ? zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() : 0.0d);
                        if (zza2 < 0.0d) {
                            double length = str16.length();
                            Double.isNaN(length);
                            min = Math.max(length + zza2, 0.0d);
                        } else {
                            min = Math.min(zza2, str16.length());
                        }
                        int i15 = (int) min;
                        double zza3 = zzh.zza(list.size() > 1 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : str16.length());
                        if (zza3 < 0.0d) {
                            double length2 = str16.length();
                            Double.isNaN(length2);
                            min2 = Math.max(length2 + zza3, 0.0d);
                        } else {
                            min2 = Math.min(zza3, str16.length());
                        }
                        zzahVar = new zzat(str16.substring(i15, Math.max(0, ((int) min2) - i15) + i15));
                        return zzahVar;
                    case '\t':
                        zzh.zzj("split", 2, list);
                        String str17 = this.zza;
                        if (str17.length() == 0) {
                            return new zzae(Arrays.asList(this));
                        }
                        ArrayList arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            String zzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            long zzd = list.size() > 1 ? zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) : TTL.MAX_VALUE;
                            if (zzd == 0) {
                                return new zzae();
                            }
                            String[] split = str17.split(Pattern.quote(zzi2), ((int) zzd) + 1);
                            int length3 = split.length;
                            if (!zzi2.isEmpty() || length3 <= 0) {
                                i11 = length3;
                                i12 = 0;
                            } else {
                                boolean isEmpty = split[0].isEmpty();
                                i11 = length3 - 1;
                                i12 = isEmpty;
                                if (!split[i11].isEmpty()) {
                                    i11 = length3;
                                    i12 = isEmpty;
                                }
                            }
                            if (length3 > zzd) {
                                i11--;
                            }
                            while (i12 < i11) {
                                arrayList.add(new zzat(split[i12]));
                                i12++;
                            }
                        }
                        return new zzae(arrayList);
                    case '\n':
                        zzh.zzj("substring", 2, list);
                        String str18 = this.zza;
                        if (list.isEmpty()) {
                            zzgVar2 = zzgVar;
                            i13 = 0;
                        } else {
                            zzgVar2 = zzgVar;
                            i13 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                        }
                        int zza4 = list.size() > 1 ? (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue()) : str18.length();
                        int min3 = Math.min(Math.max(i13, 0), str18.length());
                        int min4 = Math.min(Math.max(zza4, 0), str18.length());
                        zzahVar = new zzat(str18.substring(Math.min(min3, min4), Math.max(min3, min4)));
                        return zzahVar;
                    case 11:
                        zzh.zzh(str2, 0, list);
                        return new zzat(this.zza.toUpperCase());
                    case '\f':
                        zzh.zzh("toLocaleLowerCase", 0, list);
                        return new zzat(this.zza.toLowerCase());
                    case '\r':
                        zzh.zzh("toLowerCase", 0, list);
                        return new zzat(this.zza.toLowerCase(Locale.ENGLISH));
                    case 14:
                        zzatVar = this;
                        zzh.zzh(str7, 0, list);
                        return zzatVar;
                    case 15:
                        zzh.zzh(str3, 0, list);
                        return new zzat(this.zza.toUpperCase(Locale.ENGLISH));
                    case 16:
                        zzh.zzh(str3, 0, list);
                        return new zzat(this.zza.trim());
                    default:
                        throw new IllegalArgumentException("Command not supported");
                }
            }
        }
        str4 = "hasOwnProperty";
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        String str92 = str6;
        String str102 = str5;
        switch (c10) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
