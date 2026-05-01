package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class zzc {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zza.matcher(str);
        int i10 = 0;
        StringBuilder sb = null;
        while (matcher.find()) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            int start = matcher.start();
            int i11 = start;
            while (i11 >= 0 && str.charAt(i11) == '\\') {
                i11--;
            }
            if ((start - i11) % 2 != 0) {
                int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                sb.append((CharSequence) str, i10, matcher.start());
                if (parseInt == 92) {
                    sb.append("\\\\");
                } else {
                    sb.append(Character.toChars(parseInt));
                }
                i10 = matcher.end();
            }
        }
        if (sb == null) {
            return str;
        }
        if (i10 < matcher.regionEnd()) {
            sb.append((CharSequence) str, i10, matcher.regionEnd());
        }
        return sb.toString();
    }
}
