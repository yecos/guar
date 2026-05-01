package com.google.android.gms.cast.internal.media;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class zza {
    private static final Logger zza = new Logger("MetadataUtils");
    private static final String[] zzb;
    private static final String zzc;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        zzb = strArr;
        String valueOf = String.valueOf(strArr[0]);
        zzc = valueOf.length() != 0 ? "yyyyMMdd'T'HHmmss".concat(valueOf) : new String("yyyyMMdd'T'HHmmss");
    }

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zza.d("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzc;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", zzb[0]) : format;
    }

    public static Calendar zzb(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            zza.d("Input string is empty or null", new Object[0]);
            return null;
        }
        String zze = zze(str);
        if (TextUtils.isEmpty(zze)) {
            zza.d("Invalid date format", new Object[0]);
            return null;
        }
        String zzf = zzf(str);
        if (TextUtils.isEmpty(zzf)) {
            str2 = "yyyyMMdd";
        } else {
            String valueOf = String.valueOf(zze);
            StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(zzf).length());
            sb.append(valueOf);
            sb.append("T");
            sb.append(zzf);
            zze = sb.toString();
            str2 = zzf.length() == 6 ? "yyyyMMdd'T'HHmmss" : zzc;
        }
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(str2).parse(zze));
            return calendar;
        } catch (ParseException e10) {
            zza.e(e10, "Error parsing string", new Object[0]);
            return null;
        }
    }

    public static JSONArray zzc(List<WebImage> list) {
        list.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator<WebImage> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }

    public static void zzd(List<WebImage> list, JSONArray jSONArray) {
        try {
            list.clear();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i10)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    private static String zze(String str) {
        if (TextUtils.isEmpty(str)) {
            zza.d("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, 8);
        } catch (IndexOutOfBoundsException e10) {
            zza.e(e10, "Error extracting the date", new Object[0]);
            return null;
        }
    }

    private static String zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            zza.d("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i10 = indexOf + 1;
        if (indexOf != 8) {
            zza.d("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i10);
            if (substring.length() == 6) {
                return substring;
            }
            char charAt = substring.charAt(6);
            if (charAt != '+' && charAt != '-') {
                if (charAt == 'Z' && substring.length() == zzb[0].length() + 6) {
                    return String.valueOf(substring.substring(0, substring.length() - 1)).concat("+0000");
                }
                return null;
            }
            int length = substring.length();
            String[] strArr = zzb;
            if (length == strArr[1].length() + 6 || length == strArr[2].length() + 6 || length == strArr[3].length() + 6) {
                return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
            }
            return null;
        } catch (IndexOutOfBoundsException e10) {
            zza.e(e10, "Error extracting the time substring: %s", new Object[0]);
            return null;
        }
    }
}
