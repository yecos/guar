package i2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import ba.t;
import com.hpplay.cybergarage.soap.SOAP;
import i9.r;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f14286a = new f();

    public final long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public final boolean b(String str) {
        List d10;
        t9.i.g(str, "addr");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (t.y(str, SOAP.DELIM, 0, false, 6, null) != -1) {
            List e10 = new ba.i(SOAP.DELIM).e(str, 0);
            if (!e10.isEmpty()) {
                ListIterator listIterator = e10.listIterator(e10.size());
                while (listIterator.hasPrevious()) {
                    if (!(((String) listIterator.previous()).length() == 0)) {
                        d10 = r.D(e10, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            d10 = i9.j.d();
            String[] strArr = (String[]) d10.toArray(new String[0]);
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    str = strArr[0];
                }
            }
        }
        if (str.length() < 7 || str.length() > 15 || t9.i.b("", str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    public final boolean c(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("connectivity");
        t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
