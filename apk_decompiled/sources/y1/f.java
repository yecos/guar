package y1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.i;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f19726a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static Integer f19727b;

    public final AdInfo a(Context context, String str, AdInfo adInfo, String str2, long j10, boolean z10, String str3) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        i.g(str2, "userIdentity");
        i.g(str3, "hasPay");
        Integer identityFrequency = adInfo.getIdentityFrequency(str2, str3);
        if (identityFrequency != null && identityFrequency.intValue() == 0) {
            return null;
        }
        long longValue = ((Number) e.f19725a.b(context, str, adInfo.getAd_id(), 0L)).longValue();
        if (identityFrequency == null || (j10 - longValue <= identityFrequency.intValue() * 60 * 60 * 1000 && !d(z10, longValue, j10))) {
            return null;
        }
        return adInfo;
    }

    public final int b(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (f19727b == null) {
            f19727b = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionCode);
        }
        Integer num = f19727b;
        i.d(num);
        return num.intValue();
    }

    public final ArrayList c(Context context, String str, List list, String str2, long j10, boolean z10, String str3) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(str2, "userIdentity");
        i.g(str3, "hasPay");
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdInfo a10 = f19726a.a(context, str, (AdInfo) it.next(), str2, j10, z10, str3);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final boolean d(boolean z10, long j10, long j11) {
        return z10 && j10 == j11 && j10 != 0;
    }
}
