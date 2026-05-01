package com.mobile.brasiltv.utils;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class z0 {
    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str2.hashCode();
            if (str2.equals("China")) {
                if (str.length() == 11) {
                    return Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$").matcher(str).matches();
                }
            } else if (str.length() >= 6 && str.length() <= 17) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str2.hashCode();
            switch (str2) {
                case "United States of America":
                case "Canada":
                    if (str.length() > 3) {
                        str3 = "(" + str.substring(0, 3) + ")" + str.substring(3);
                        break;
                    }
                    break;
                case "Brazil":
                    if (str.length() > 2) {
                        str3 = str.substring(0, 2) + " " + str.substring(2);
                        break;
                    }
                    break;
            }
            if (!TextUtils.isEmpty(str3)) {
                str = str3;
            }
            return Operator.Operation.PLUS + str2 + " " + str;
        }
        str3 = "";
        if (!TextUtils.isEmpty(str3)) {
        }
        return Operator.Operation.PLUS + str2 + " " + str;
    }
}
