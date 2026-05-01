package ma;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f16852a = new d();

    public final void a(Context context, String str, String str2, String str3, String str4) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "dnsType");
        t9.i.g(str2, Constants.KEY_HOST);
        t9.i.g(str3, "mapper");
        t9.i.g(str4, "resolver");
        HashMap hashMap = new HashMap();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        t9.i.f(format, "sDateFormat.format(Date())");
        hashMap.put("key_start_time", format);
        String h10 = na.a.h();
        t9.i.f(h10, "getSn()");
        hashMap.put("sn", h10);
        String userId = c2.l.f5383a.b().getUserId();
        if (userId == null) {
            userId = "";
        }
        hashMap.put("userId", userId);
        hashMap.put("apkVersion", String.valueOf(na.a.b()));
        hashMap.put("key_dns_type", str);
        hashMap.put("key_host", str2);
        hashMap.put("key_mapper", str3);
        hashMap.put("key_resolver", str4);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_BIGBEE_APP_DNS", hashMap);
    }

    public final void b(Context context, String str, String str2, int i10, String str3) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "uri");
        t9.i.g(str2, "domain");
        t9.i.g(str3, "userName");
        if (i10 < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        t9.i.f(format, "sDateFormat.format(Date())");
        hashMap.put("key_start_time", format);
        String h10 = na.a.h();
        t9.i.f(h10, "getSn()");
        hashMap.put("sn", h10);
        String userId = c2.l.f5383a.b().getUserId();
        if (userId == null) {
            userId = "";
        }
        hashMap.put("userId", userId);
        hashMap.put("apkVersion", String.valueOf(na.a.b()));
        hashMap.put("key_uri", str);
        hashMap.put("key_domin", str2);
        hashMap.put("key_http_status", String.valueOf(i10));
        hashMap.put("key_user_name", str3);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_BIGBEE_REQUEST_ERROR_MESSAGE", hashMap);
    }
}
