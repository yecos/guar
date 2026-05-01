package ja;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import ba.s;
import c2.e;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.f;
import h9.g;
import h9.h;
import h9.t;
import i9.r;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Dns;
import s7.d;
import t9.i;
import t9.j;
import t9.z;

/* loaded from: classes.dex */
public final class b implements Dns {

    /* renamed from: g, reason: collision with root package name */
    public static b f14707g;

    /* renamed from: h, reason: collision with root package name */
    public static Context f14708h;

    /* renamed from: a, reason: collision with root package name */
    public final String f14710a;

    /* renamed from: b, reason: collision with root package name */
    public final g f14711b;

    /* renamed from: c, reason: collision with root package name */
    public final g f14712c;

    /* renamed from: d, reason: collision with root package name */
    public o7.a f14713d;

    /* renamed from: e, reason: collision with root package name */
    public ha.c f14714e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f14706f = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final Set f14709i = new LinkedHashSet();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final b a() {
            if (b.f14707g == null) {
                synchronized (b.class) {
                    if (b.f14707g == null) {
                        b.f14707g = new b(null);
                    }
                    t tVar = t.f14242a;
                }
            }
            b bVar = b.f14707g;
            i.d(bVar);
            return bVar;
        }

        public final void b(Context context) {
            i.g(context, f.X);
            b.f14708h = context.getApplicationContext();
        }
    }

    /* renamed from: ja.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0241b extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0241b f14715a = new C0241b();

        public C0241b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(i.b(d.a("debug.dns.enable", "1"), "1"));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f14716a = new c();

        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(i.b(d.a("debug.dns.filter", "1"), "1"));
        }
    }

    public /* synthetic */ b(t9.g gVar) {
        this();
    }

    public static final void n(String str, String str2, b bVar, String str3, String str4) {
        String str5;
        i.g(str, "$type");
        i.g(str2, "$hostname");
        i.g(bVar, "this$0");
        i.g(str3, "$mapper");
        i.g(str4, "$alias");
        if (i.b(str, "system")) {
            str5 = d.a("net.dns1", "") + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + d.a("net.dns2", "");
        } else {
            str5 = "google";
        }
        String str6 = str5;
        String a10 = a3.d.a(str2, a3.d.f161a);
        String str7 = a10 == null || a10.length() == 0 ? str2 : a10;
        i.f(str7, "hostnameMapper");
        bVar.l(str, str7, str3, str6, str4);
    }

    public final boolean e(String str) {
        return TextUtils.isDigitsOnly(s.j(s.j(str, ".", "", false, 4, null), SOAP.DELIM, "", false, 4, null));
    }

    public final List f(List list, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            byte[] address = ((InetAddress) next).getAddress();
            if (address != null && address.length == 4) {
                z zVar = z.f18964a;
                String format = String.format("%03d.%03d.%03d.%03d", Arrays.copyOf(new Object[]{Integer.valueOf(address[0] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[1] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[2] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[3] & UnsignedBytes.MAX_VALUE)}, 4));
                i.f(format, "format(format, *args)");
                boolean z11 = (("192.168.000.000".compareTo(format) <= 0 && "192.168.255.255".compareTo(format) >= 0) || TextUtils.equals(format, "127.000.000.001") || TextUtils.equals(format, "000.000.000.000") || TextUtils.equals(format, "255.255.255.255")) ? false : true;
                if (!z11) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    String format2 = String.format("%d.%d.%d.%d(%d/%d)", Arrays.copyOf(new Object[]{Integer.valueOf(address[0] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[1] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[2] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[3] & UnsignedBytes.MAX_VALUE), Integer.valueOf(i11), Integer.valueOf(size)}, 6));
                    i.f(format2, "format(format, *args)");
                    sb.append(format2);
                }
                z10 = z11;
            }
            if (z10) {
                arrayList.add(next);
            }
            i10 = i11;
        }
        List I = r.I(arrayList);
        if (sb.length() > 0) {
            String sb2 = sb.toString();
            i.f(sb2, "filterDnsResult.toString()");
            m(str, str2, sb2, str3);
        }
        return I;
    }

    public final o7.c g() {
        Context context = f14708h;
        File cacheDir = context != null ? context.getCacheDir() : null;
        if (cacheDir != null) {
            String absolutePath = cacheDir.getAbsolutePath();
            if (!(absolutePath == null || absolutePath.length() == 0)) {
                return new p7.a(cacheDir.getAbsolutePath());
            }
        }
        return new p7.b();
    }

    public final boolean h() {
        return ((Boolean) this.f14711b.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.f14712c.getValue()).booleanValue();
    }

    public final List j(String str, String str2) {
        List k10;
        i.g(str, "hostname");
        i.g(str2, "alias");
        try {
            List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
            if (lookup == null || lookup.isEmpty()) {
                throw new UnknownHostException("system dns lookup empty list.(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
            }
            if (e(str)) {
                i.f(lookup, "lookupList");
                return lookup;
            }
            if (i()) {
                i.f(lookup, "lookupList");
                lookup = f(lookup, "system", str, str2);
                if (lookup.isEmpty()) {
                    throw new UnknownHostException("system dns lookup empty list.(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
                }
            }
            i.f(lookup, "lookupList");
            return lookup;
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            if (this.f14713d == null || e(str)) {
                throw e10;
            }
            if (h() && (k10 = k(str)) != null) {
                return true ^ k10.isEmpty() ? f(k10, HttpConstant.HTTP, str, str2) : k10;
            }
            throw new UnknownHostException("unknown host name(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
        }
    }

    public final List k(String str) {
        try {
            o7.a aVar = this.f14713d;
            String[] e10 = aVar != null ? aVar.e(str) : null;
            if (e10 != null && e10.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (e10 != null) {
                for (String str2 : e10) {
                    InetAddress[] allByName = InetAddress.getAllByName(str2);
                    i.f(allByName, "getAllByName(it)");
                    arrayList.addAll(i9.f.a(allByName));
                }
            }
            return arrayList;
        } catch (IOException e11) {
            StringBuilder sb = new StringBuilder();
            sb.append("query http dns exception and exception info is ");
            sb.append(e11.getLocalizedMessage());
            e11.printStackTrace();
            return null;
        }
    }

    public final void l(String str, String str2, String str3, String str4, String str5) {
        if (ba.t.o(str5, ".bigbee", false, 2, null)) {
            ha.c cVar = this.f14714e;
            if (cVar != null) {
                cVar.a(str, str2, str3, str4);
                return;
            }
            return;
        }
        if (!ba.t.o(str5, ".img", false, 2, null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("dns_type", str);
            hashMap.put("domain|DES", str2);
            hashMap.put("mapper", str3);
            hashMap.put("resolver", str4);
            e.f5339a.a("app_dns", hashMap, SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : false);
            return;
        }
        String str6 = str + str2 + str3;
        Set set = f14709i;
        if (set.contains(str6)) {
            return;
        }
        set.add(str6);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("dns_type", str);
        hashMap2.put("domain|DES", str2);
        hashMap2.put("mapper", str3);
        hashMap2.put("resolver", str4);
        e.f5339a.a("app_dns", hashMap2, SystemClock.elapsedRealtime(), (r20 & 8) != 0 ? 0L : 0L, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? false : false);
    }

    @Override // okhttp3.Dns
    public List lookup(String str) {
        i.g(str, "hostname");
        List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
        i.f(lookup, "SYSTEM.lookup(hostname)");
        return lookup;
    }

    public final void m(final String str, final String str2, final String str3, final String str4) {
        s2.d.b("exception-dns", new Runnable() { // from class: ja.a
            @Override // java.lang.Runnable
            public final void run() {
                b.n(str, str2, this, str3, str4);
            }
        }, false);
    }

    public final void o(ha.c cVar) {
        i.g(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f14714e = cVar;
    }

    public b() {
        this.f14710a = b.class.getSimpleName();
        this.f14711b = h.b(C0241b.f14715a);
        this.f14712c = h.b(c.f14716a);
        this.f14713d = new o7.a(com.qiniu.android.dns.a.f9006d, new o7.d[]{new q7.a()}, g());
    }
}
