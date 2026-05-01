package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public class TrafficsMonitor {

    /* renamed from: d, reason: collision with root package name */
    private Context f9306d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<a>> f9303a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f9304b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private int f9305c = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f9307e = "";

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f9306d = context;
    }

    private void b() {
        String str;
        boolean z10;
        synchronized (this.f9303a) {
            String a10 = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f9307e) || this.f9307e.equals(a10)) {
                str = a10;
                z10 = false;
            } else {
                str = this.f9307e;
                z10 = true;
            }
            Iterator<String> it = this.f9303a.keySet().iterator();
            while (it.hasNext()) {
                for (a aVar : this.f9303a.get(it.next())) {
                    if (aVar != null) {
                        com.taobao.accs.b.a a11 = com.taobao.accs.b.a.a(this.f9306d);
                        String str2 = aVar.f9313e;
                        String str3 = aVar.f9311c;
                        a11.a(str2, str3, this.f9304b.get(str3), aVar.f9312d, aVar.f9314f, str);
                    }
                }
            }
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f9303a.toString(), new Object[0]);
            }
            if (z10) {
                this.f9303a.clear();
                c();
            } else if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f9307e + " currday:" + a10, new Object[0]);
            }
            this.f9307e = a10;
            this.f9305c = 0;
        }
    }

    private void c() {
        List<a> a10 = com.taobao.accs.b.a.a(this.f9306d).a(false);
        if (a10 == null) {
            return;
        }
        try {
            for (a aVar : a10) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.f9310b;
                    statTrafficMonitor.date = aVar.f9309a;
                    statTrafficMonitor.host = aVar.f9313e;
                    statTrafficMonitor.isBackground = aVar.f9312d;
                    statTrafficMonitor.size = aVar.f9314f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.b.a.a(this.f9306d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        boolean z10;
        String str;
        if (aVar == null || aVar.f9313e == null || aVar.f9314f <= 0) {
            return;
        }
        aVar.f9311c = TextUtils.isEmpty(aVar.f9311c) ? "accsSelf" : aVar.f9311c;
        synchronized (this.f9303a) {
            String str2 = this.f9304b.get(aVar.f9311c);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            aVar.f9310b = str2;
            ALog.isPrintLog(ALog.Level.D);
            List<a> list = this.f9303a.get(str2);
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z10 = true;
                        break;
                    }
                    a next = it.next();
                    if (next.f9312d == aVar.f9312d && (str = next.f9313e) != null && str.equals(aVar.f9313e)) {
                        next.f9314f += aVar.f9314f;
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    list.add(aVar);
                }
            } else {
                list = new ArrayList<>();
                list.add(aVar);
            }
            this.f9303a.put(str2, list);
            int i10 = this.f9305c + 1;
            this.f9305c = i10;
            if (i10 >= 10) {
                b();
            }
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f9309a;

        /* renamed from: b, reason: collision with root package name */
        String f9310b;

        /* renamed from: c, reason: collision with root package name */
        String f9311c;

        /* renamed from: d, reason: collision with root package name */
        boolean f9312d;

        /* renamed from: e, reason: collision with root package name */
        String f9313e;

        /* renamed from: f, reason: collision with root package name */
        long f9314f;

        public a(String str, boolean z10, String str2, long j10) {
            this.f9311c = str;
            this.f9312d = z10;
            this.f9313e = str2;
            this.f9314f = j10;
        }

        public String toString() {
            return "date:" + this.f9309a + " bizId:" + this.f9310b + " serviceId:" + this.f9311c + " host:" + this.f9313e + " isBackground:" + this.f9312d + " size:" + this.f9314f;
        }

        public a(String str, String str2, String str3, boolean z10, String str4, long j10) {
            this.f9309a = str;
            this.f9310b = str2;
            this.f9311c = str3;
            this.f9312d = z10;
            this.f9313e = str4;
            this.f9314f = j10;
        }
    }

    public void a() {
        try {
            synchronized (this.f9303a) {
                this.f9303a.clear();
            }
            List<a> a10 = com.taobao.accs.b.a.a(this.f9306d).a(true);
            if (a10 == null) {
                return;
            }
            Iterator<a> it = a10.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e10) {
            ALog.w("TrafficsMonitor", e10.toString(), new Object[0]);
        }
    }
}
