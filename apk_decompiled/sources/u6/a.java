package u6;

import android.os.SystemClock;
import c2.e;
import com.taobao.accs.common.Constants;
import i2.f;
import java.util.HashMap;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19062a = new a();

    public final void a(String str, String str2, String str3, long j10, int i10, String str4, Long l10, String str5) {
        i.g(str, "eCode");
        i.g(str2, "uri");
        i.g(str3, Constants.KEY_HOST);
        HashMap hashMap = new HashMap();
        hashMap.put("eCode", str);
        hashMap.put("uri", str2);
        hashMap.put(Constants.KEY_HOST, str3);
        hashMap.put("duration", Long.valueOf(j10));
        hashMap.put("resumeCount", Integer.valueOf(i10));
        if (str4 != null) {
            hashMap.put("filePath", str4);
        }
        if (l10 != null) {
            hashMap.put("fileSize", Long.valueOf(l10.longValue()));
        }
        if (str5 != null) {
            hashMap.put("apkMd5", str5);
        }
        hashMap.put("availableSize", Long.valueOf(f.f14286a.a()));
        e.f5339a.a("app_update", hashMap, SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : true);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        i.g(str, "mCode");
        i.g(str2, Constants.KEY_HOST);
        i.g(str3, "bussType");
        i.g(str4, "cdnType");
        i.g(str5, "title");
        i.g(str6, "castMode");
        i.g(str7, "castDevice");
        i.g(str8, "eventId");
        HashMap hashMap = new HashMap();
        hashMap.put("mCode", str);
        hashMap.put("cdnType", str4);
        hashMap.put("bussType", str3);
        hashMap.put("castMode", str6);
        hashMap.put("castDevice", str7);
        hashMap.put("title", str5);
        hashMap.put(Constants.KEY_HOST, str2);
        e.f5339a.a(str8, hashMap, SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : false);
    }
}
