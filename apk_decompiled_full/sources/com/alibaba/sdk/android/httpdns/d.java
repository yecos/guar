package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f5861a = new d();

    /* renamed from: a, reason: collision with other field name */
    private static IPProbeService f11a = com.alibaba.sdk.android.httpdns.probe.d.a(new com.alibaba.sdk.android.httpdns.probe.b() { // from class: com.alibaba.sdk.android.httpdns.d.1
        @Override // com.alibaba.sdk.android.httpdns.probe.b
        public void a(String str, String[] strArr) {
            e eVar;
            if (str == null || strArr == null || strArr.length == 0 || (eVar = (e) d.f12a.get(str)) == null) {
                return;
            }
            e eVar2 = new e(str, strArr, eVar.a(), eVar.b(), eVar.m14a(), eVar.getCacheKey());
            d.f12a.put(str, eVar2);
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < eVar2.getIps().length; i10++) {
                sb.append(eVar2.getIps()[i10] + ",");
            }
            i.f("optimized host:" + str + ", ip:" + sb.toString());
        }
    });

    /* renamed from: a, reason: collision with other field name */
    private static ConcurrentMap<String, e> f12a;

    /* renamed from: a, reason: collision with other field name */
    private static ConcurrentSkipListSet<String> f13a;

    private d() {
        f12a = new ConcurrentHashMap();
        f13a = new ConcurrentSkipListSet<>();
    }

    public static d a() {
        return f5861a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<com.alibaba.sdk.android.httpdns.b.e> a10 = com.alibaba.sdk.android.httpdns.b.b.a();
        String i10 = com.alibaba.sdk.android.httpdns.b.b.i();
        for (com.alibaba.sdk.android.httpdns.b.e eVar : a10) {
            if (a(eVar)) {
                com.alibaba.sdk.android.httpdns.b.b.b(eVar);
            } else if (i10.equals(eVar.f5852m)) {
                eVar.f5853n = String.valueOf(System.currentTimeMillis() / 1000);
                e eVar2 = new e(eVar);
                f12a.put(eVar.host, eVar2);
                if (com.alibaba.sdk.android.httpdns.b.b.g()) {
                    com.alibaba.sdk.android.httpdns.b.b.b(eVar);
                }
                a(eVar.host, eVar2);
            }
        }
    }

    public void clear() {
        f12a.clear();
        f13a.clear();
    }

    public int count() {
        return f12a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public e m6a(String str) {
        return f12a.get(str);
    }

    public void b(String str) {
        f13a.remove(str);
    }

    private IPProbeItem a(String str) {
        List<IPProbeItem> list = f.f18a;
        if (list == null) {
            return null;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (str.equals(list.get(i10).getHostName())) {
                return list.get(i10);
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ArrayList<String> m7a() {
        return new ArrayList<>(f12a.keySet());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m8a() {
        if (com.alibaba.sdk.android.httpdns.b.b.m1a()) {
            c.a().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.b();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9a(String str) {
        f13a.add(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m10a(String str, e eVar) {
        ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList;
        f12a.put(str, eVar);
        if (com.alibaba.sdk.android.httpdns.b.b.m1a()) {
            com.alibaba.sdk.android.httpdns.b.e m13a = eVar.m13a();
            ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList2 = m13a.f7a;
            if ((arrayList2 == null || arrayList2.size() <= 0) && ((arrayList = m13a.f8b) == null || arrayList.size() <= 0)) {
                com.alibaba.sdk.android.httpdns.b.b.b(m13a);
            } else {
                com.alibaba.sdk.android.httpdns.b.b.a(m13a);
            }
        }
        a(str, eVar);
    }

    private boolean a(com.alibaba.sdk.android.httpdns.b.e eVar) {
        return (System.currentTimeMillis() / 1000) - com.alibaba.sdk.android.httpdns.b.c.a(eVar.f5853n) > 604800;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m11a(String str) {
        return f13a.contains(str);
    }

    private boolean a(String str, e eVar) {
        IPProbeItem a10;
        if (eVar == null || eVar.getIps() == null || eVar.getIps().length <= 1 || f11a == null || (a10 = a(str)) == null) {
            return false;
        }
        if (f11a.getProbeStatus(str) == IPProbeService.a.PROBING) {
            f11a.stopIPProbeTask(str);
        }
        i.f("START PROBE");
        f11a.launchIPProbeTask(str, a10.getPort(), eVar.getIps());
        return true;
    }
}
