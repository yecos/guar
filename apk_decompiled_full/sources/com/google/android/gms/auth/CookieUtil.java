package com.google.android.gms.auth;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.google.android.gms.common.internal.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        String str2 = zza(bool) ? "https" : HttpConstant.HTTP;
        StringBuilder sb = new StringBuilder(str2.length() + 3 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(HttpConstant.SCHEME_SPLIT);
        sb.append(str);
        return sb.toString();
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l10) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (zza(bool)) {
            sb.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l10 != null && l10.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l10);
        }
        return sb.toString();
    }

    private static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
