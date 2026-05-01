package z1;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bigbee.bean.ServerTime;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.taobao.accs.utl.BaseMonitor;
import f2.b;
import f2.d;
import f2.e;
import i2.f;
import i2.h;
import okhttp3.Dns;
import okhttp3.Interceptor;
import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f20146a = a.class.getSimpleName();

    /* renamed from: z1.a$a, reason: collision with other inner class name */
    public static final class C0351a implements b {
        @Override // f2.b
        public void a(d dVar, g2.a aVar) {
            i.g(dVar, "request");
            i.g(aVar, "response");
            i2.a aVar2 = i2.a.f14261a;
            aVar2.k(false);
            if (!aVar.d() || TextUtils.isEmpty(aVar.b())) {
                aVar2.m(SystemClock.elapsedRealtime());
                return;
            }
            try {
                ServerTime serverTime = (ServerTime) new Gson().fromJson(aVar.b(), ServerTime.class);
                if (serverTime != null) {
                    h.f14287a.b(serverTime.getTimestamp());
                    aVar2.m(SystemClock.elapsedRealtime());
                }
            } catch (Exception unused) {
            }
        }

        @Override // f2.b
        public void b(d dVar, Exception exc) {
            i.g(dVar, "request");
            i.g(exc, "e");
            i2.a aVar = i2.a.f14261a;
            aVar.k(false);
            aVar.m(SystemClock.elapsedRealtime());
            exc.printStackTrace();
            if (b2.a.f4465d != null) {
                t2.a aVar2 = t2.a.f18798a;
                DomainInfo domainInfo = b2.a.f4465d;
                i.f(domainInfo, "TDC");
                aVar2.q(domainInfo, "key_tdc");
            }
        }
    }

    public final void a(Dns dns, Interceptor interceptor) {
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        f fVar = f.f14286a;
        String str = b2.a.f4466e;
        i.f(str, "URL_HOST_MAIN");
        String str2 = fVar.b(str) ? "http://" : "https://";
        String str3 = str2 + b2.a.f4466e + b2.a.f4464c + b2.a.f4463b;
        String str4 = str2 + b2.a.f4467f + b2.a.f4464c + b2.a.f4463b;
        i2.a.f14261a.k(true);
        e2.a.f12853b.a().c(new f2.a().i(str3, str4).h(e.GET).b(dns).f(interceptor).a(new C0351a()));
    }
}
