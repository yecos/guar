package anet.channel.strategy.utils;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 7 || charArray.length > 15) {
            return false;
        }
        int i10 = 0;
        int i11 = 0;
        for (char c10 : charArray) {
            if (c10 >= '0' && c10 <= '9') {
                i11 = ((i11 * 10) + c10) - 48;
                if (i11 > 255) {
                    return false;
                }
            } else {
                if (c10 != '.' || (i10 = i10 + 1) > 3) {
                    return false;
                }
                i11 = 0;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        int i10;
        boolean z10;
        int i11;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        if (charArray[0] != ':') {
            i10 = 0;
            z10 = false;
            i11 = 0;
        } else {
            if (charArray[1] != ':') {
                return false;
            }
            i10 = 1;
            z10 = false;
            i11 = 1;
        }
        int i12 = 0;
        boolean z11 = true;
        while (i10 < charArray.length) {
            char c10 = charArray[i10];
            int digit = Character.digit(c10, 16);
            if (digit != -1) {
                i12 = (i12 << 4) + digit;
                if (i12 > 65535) {
                    return false;
                }
                z11 = false;
            } else {
                if (c10 != ':' || (i11 = i11 + 1) > 7) {
                    return false;
                }
                if (!z11) {
                    i12 = 0;
                    z11 = true;
                } else {
                    if (z10) {
                        return false;
                    }
                    z10 = true;
                }
            }
            i10++;
        }
        return z10 || i11 >= 7;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length <= 0 || charArray.length > 255) {
            return false;
        }
        boolean z10 = false;
        for (char c10 : charArray) {
            if ((c10 >= 'A' && c10 <= 'Z') || ((c10 >= 'a' && c10 <= 'z') || c10 == '*')) {
                z10 = true;
            } else if ((c10 < '0' || c10 > '9') && c10 != '.' && c10 != '-') {
                return false;
            }
        }
        return z10;
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static String a(long j10) {
        StringBuilder sb = new StringBuilder(16);
        long j11 = 1000000000;
        do {
            sb.append(j10 / j11);
            sb.append('.');
            j10 %= j11;
            j11 /= 1000;
        } while (j11 > 0);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static String a(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append(Operator.Operation.EQUALS);
                    sb.append(URLEncoder.encode(d(entry.getValue()), str).replace(Operator.Operation.PLUS, "%20"));
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException e10) {
            ALog.e("Request", "format params failed", null, e10, new Object[0]);
        }
        return sb.toString();
    }
}
