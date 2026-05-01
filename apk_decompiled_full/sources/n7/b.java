package n7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public abstract class b {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return v7.b.a(str, str2);
        } catch (Exception unused) {
            return str;
        }
    }

    public static int b(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
