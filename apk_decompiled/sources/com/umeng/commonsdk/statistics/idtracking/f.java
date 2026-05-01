package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cq;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11082a = 86400000;

    /* renamed from: b, reason: collision with root package name */
    public static f f11083b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f11084c = bd.b().b("id");

    /* renamed from: j, reason: collision with root package name */
    private static Object f11085j = new Object();

    /* renamed from: d, reason: collision with root package name */
    private File f11086d;

    /* renamed from: f, reason: collision with root package name */
    private long f11088f;

    /* renamed from: i, reason: collision with root package name */
    private a f11091i;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f11087e = null;

    /* renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f11090h = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private long f11089g = 86400000;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f11092a;

        /* renamed from: b, reason: collision with root package name */
        private Set<String> f11093b = new HashSet();

        public a(Context context) {
            this.f11092a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f11093b.contains(str);
        }

        public synchronized void b(String str) {
            this.f11093b.add(str);
        }

        public void c(String str) {
            this.f11093b.remove(str);
        }

        public synchronized void a() {
            if (!this.f11093b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f11093b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f11092a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f11092a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f11093b.add(str);
                    }
                }
            }
        }
    }

    public f(Context context) {
        this.f11091i = null;
        this.f11086d = new File(context.getFilesDir(), f11084c);
        a aVar = new a(context);
        this.f11091i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (f.class) {
            f fVar = f11083b;
            if (fVar != null) {
                fVar.e();
                f11083b = null;
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f11090h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.f11087e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f11085j) {
            if (!this.f11086d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f11086d);
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new ck().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11088f >= this.f11089g) {
            boolean z10 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f11090h) {
                if (aVar.c() && aVar.a()) {
                    if (!aVar.c()) {
                        this.f11091i.b(aVar.b());
                    }
                    z10 = true;
                }
            }
            if (z10) {
                h();
                this.f11091i.a();
                g();
            }
            this.f11088f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f11087e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f11083b == null) {
            return;
        }
        boolean z10 = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f11090h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z10 = true;
            }
        }
        if (z10) {
            this.f11087e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i10 = i();
        if (i10 == null) {
            return;
        }
        a(i10);
        ArrayList arrayList = new ArrayList(this.f11090h.size());
        synchronized (this) {
            this.f11087e = i10;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f11090h) {
                aVar.a(this.f11087e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f11090h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f11087e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f11083b == null) {
                f fVar2 = new f(context);
                f11083b = fVar2;
                fVar2.a(new g(context));
                f11083b.a(new b(context));
                f11083b.a(new k(context));
                f11083b.a(new e(context));
                f11083b.a(new d(context));
                f11083b.a(new h(context));
                f11083b.a(new j());
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                    f11083b.a(new i(context));
                    if (DeviceConfig.isHonorDevice()) {
                        f11083b.a(new c(context));
                    }
                }
                f11083b.f();
            }
            fVar = f11083b;
        }
        return fVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a10;
        synchronized (f11085j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a10 = new cq().a(cVar);
                    }
                    if (a10 != null) {
                        HelperUtils.writeFile(this.f11086d, a10);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f11091i.a(aVar.b())) {
            return this.f11090h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j10) {
        this.f11089g = j10;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f11178a) == null) {
            return;
        }
        if (map.containsKey(ParamsMap.DeviceParams.KEY_MAC) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11260h)) {
            cVar.f11178a.remove(ParamsMap.DeviceParams.KEY_MAC);
        }
        if (cVar.f11178a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11259g)) {
            cVar.f11178a.remove("imei");
        }
        if (cVar.f11178a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11261i)) {
            cVar.f11178a.remove("android_id");
        }
        if (cVar.f11178a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11262j)) {
            cVar.f11178a.remove("serial");
        }
        if (cVar.f11178a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11275w)) {
            cVar.f11178a.remove("idfa");
        }
        if (!cVar.f11178a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f11178a.remove("oaid");
    }
}
