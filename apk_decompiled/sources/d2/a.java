package d2;

import ba.t;
import com.bigbee.bean.request.BBEventRequestBean;
import com.bigbee.bean.request.CustomizeEventBean;
import com.bigbee.db.EventDbModel;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.utl.BaseMonitor;
import f2.d;
import f2.e;
import i2.f;
import i2.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Dns;
import okhttp3.Interceptor;
import t9.i;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public a2.b f12467a;

    /* renamed from: b, reason: collision with root package name */
    public final Dns f12468b;

    /* renamed from: c, reason: collision with root package name */
    public final Interceptor f12469c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12470d;

    /* renamed from: e, reason: collision with root package name */
    public Gson f12471e;

    /* renamed from: d2.a$a, reason: collision with other inner class name */
    public static final class C0204a implements f2.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f12473b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f12474c;

        public C0204a(List list, b bVar) {
            this.f12473b = list;
            this.f12474c = bVar;
        }

        @Override // f2.b
        public void a(d dVar, g2.a aVar) {
            i.g(dVar, "request");
            i.g(aVar, "response");
            b bVar = this.f12474c;
            if (bVar != null) {
                bVar.a(aVar.a());
            }
            List list = this.f12473b;
            if (list != null && list.size() > 998) {
                a.this.e();
            }
            if (aVar.d()) {
                a.this.f12467a.b(this.f12473b);
                return;
            }
            if (aVar.c() != 200 && aVar.c() != 304 && aVar.c() != 403 && b2.a.f4465d != null) {
                t2.a aVar2 = t2.a.f18798a;
                DomainInfo domainInfo = b2.a.f4465d;
                i.f(domainInfo, "TDC");
                aVar2.q(domainInfo, "key_tdc");
            }
            a.this.f12467a.f(this.f12473b, false);
        }

        @Override // f2.b
        public void b(d dVar, Exception exc) {
            i.g(dVar, "request");
            i.g(exc, "e");
            a.this.f12467a.f(this.f12473b, false);
            List list = this.f12473b;
            if (list != null && list.size() > 998) {
                a.this.e();
            }
            if (b2.a.f4465d != null) {
                t2.a aVar = t2.a.f18798a;
                DomainInfo domainInfo = b2.a.f4465d;
                i.f(domainInfo, "TDC");
                aVar.q(domainInfo, "key_tdc");
            }
        }
    }

    public a(a2.b bVar, Dns dns, Interceptor interceptor) {
        i.g(bVar, "mCollector");
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f12467a = bVar;
        this.f12468b = dns;
        this.f12469c = interceptor;
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "this.javaClass.simpleName");
        this.f12470d = simpleName;
        this.f12471e = new Gson();
    }

    @Override // d2.c
    public void a(EventDbModel eventDbModel) {
        i.g(eventDbModel, "dbModel");
        this.f12467a.d(eventDbModel);
    }

    @Override // d2.c
    public void b(EventDbModel eventDbModel) {
        i.g(eventDbModel, "dbModel");
        this.f12467a.e(eventDbModel);
    }

    @Override // d2.c
    public void c(b bVar) {
        BBEventRequestBean a10;
        List g10 = g();
        if (g10 == null || g.b(g10) || (a10 = this.f12467a.a(f(g10))) == null) {
            return;
        }
        ArrayList<CustomizeEventBean> event = a10.getEvent();
        boolean z10 = false;
        if (event != null && g.b(event)) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        String json = this.f12471e.toJson(a10);
        if (g.a(json)) {
            return;
        }
        f fVar = f.f14286a;
        String str = b2.a.f4466e;
        i.f(str, "URL_HOST_MAIN");
        String str2 = fVar.b(str) ? "http://" : "https://";
        f2.a e10 = new f2.a().i(str2 + b2.a.f4466e + b2.a.f4464c + b2.a.f4462a, str2 + b2.a.f4467f + b2.a.f4464c + b2.a.f4462a).h(e.POST).e("Content-Type", "application/json;charset=utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("{\"data\":");
        sb.append(json);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        e2.a.f12853b.a().c(e10.g(sb.toString()).f(this.f12469c).b(this.f12468b).a(new C0204a(g10, bVar)));
    }

    public final void e() {
        i2.a aVar = i2.a.f14261a;
        if (aVar.b()) {
            this.f12467a.c();
        }
        aVar.i(false);
    }

    public final List f(List list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EventDbModel eventDbModel = (EventDbModel) it.next();
            if (i.b(eventDbModel.eventId, "app_cast")) {
                String str = eventDbModel.reserveA;
                i.f(str, "it.reserveA");
                if (t.o(str, "\"errorCode\",\"value\":\"\"", false, 2, null)) {
                    String str2 = eventDbModel.reserveA;
                    i.f(str2, "it.reserveA");
                    int y10 = t.y(str2, "transId", 0, false, 6, null);
                    String str3 = eventDbModel.reserveA;
                    i.f(str3, "it.reserveA");
                    int y11 = t.y(str3, "currId", 0, false, 6, null);
                    String str4 = eventDbModel.reserveA;
                    i.f(str4, "it.reserveA");
                    String substring = str4.substring(y10 + 18, y10 + 54);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String str5 = eventDbModel.reserveA;
                    i.f(str5, "it.reserveA");
                    String substring2 = str5.substring(y11 + 17, y11 + 18);
                    i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (hashMap.get(substring) != null) {
                        String str6 = (String) hashMap2.get(substring);
                        if (str6 == null) {
                            str6 = "0";
                        }
                        if (str6.compareTo(substring2) < 0) {
                        }
                    }
                    hashMap.put(substring, eventDbModel);
                    hashMap2.put(substring, substring2);
                } else {
                    arrayList.add(eventDbModel);
                }
            } else {
                arrayList.add(eventDbModel);
            }
        }
        if (!hashMap.isEmpty()) {
            Iterator it2 = hashMap.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList.add(((Map.Entry) it2.next()).getValue());
            }
        }
        return arrayList;
    }

    public List g() {
        List g10;
        synchronized (this) {
            g10 = this.f12467a.g();
            h9.t tVar = h9.t.f14242a;
        }
        return g10;
    }
}
