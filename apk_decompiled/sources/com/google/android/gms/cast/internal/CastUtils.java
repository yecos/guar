package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
/* loaded from: classes.dex */
public final class CastUtils {
    private static final Pattern zza = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");
    private static final Random zzb = new Random(SystemClock.elapsedRealtime());

    private CastUtils() {
    }

    @RecentlyNullable
    @KeepForSdk
    public static JSONObject jsonStringToJsonObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static double millisecToSec(long j10) {
        double d10 = j10;
        Double.isNaN(d10);
        return d10 / 1000.0d;
    }

    @RecentlyNullable
    @KeepForSdk
    public static String optStringOrNull(@RecentlyNonNull JSONObject jSONObject, @RecentlyNonNull String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    @KeepForSdk
    public static long secToMillisec(double d10) {
        return (long) (d10 * 1000.0d);
    }

    @KeepForSdk
    public static void throwIfInvalidNamespace(@RecentlyNonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (str.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static long[] toLongArray(@RecentlyNonNull Collection<Long> collection) {
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }

    @RecentlyNullable
    @KeepForSdk
    public static long[] toLongArraySafely(JSONArray jSONArray) {
        try {
            return zzj(jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int zza(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    public static long zzb() {
        return zzb.nextLong();
    }

    @RecentlyNonNull
    public static String zzc(@RecentlyNonNull String str) {
        return str.length() != 0 ? "urn:x-cast:".concat(str) : new String("urn:x-cast:");
    }

    @RecentlyNonNull
    public static String zzd(@RecentlyNonNull Locale locale) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            sb.append(variant);
        }
        return sb.toString();
    }

    @RecentlyNonNull
    public static String zze(@RecentlyNonNull String str) {
        if (zza.matcher(str).matches()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-' || charAt == '.' || charAt == ':'))) {
                sb.append(String.format("%%%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    @RecentlyNonNull
    public static List<Integer> zzf(@RecentlyNonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @RecentlyNullable
    public static JSONObject zzg(JSONObject jSONObject, @RecentlyNonNull String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static <T> boolean zzh(@RecentlyNonNull T t10, @RecentlyNonNull T t11) {
        if (t10 == null && t11 == null) {
            return true;
        }
        return (t10 == null || t11 == null || !t10.equals(t11)) ? false : true;
    }

    @RecentlyNonNull
    public static int[] zzi(@RecentlyNonNull Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    @RecentlyNullable
    public static long[] zzj(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        long[] jArr = new long[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            jArr[i10] = jSONArray.getLong(i10);
        }
        return jArr;
    }

    @KeepForSdk
    public static long secToMillisec(long j10) {
        return j10 * 1000;
    }
}
