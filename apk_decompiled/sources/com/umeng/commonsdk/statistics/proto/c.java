package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
import com.umeng.analytics.pro.dd;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class c implements ch<c, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, ct> f11171d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11172e = -5764118265293965743L;

    /* renamed from: f, reason: collision with root package name */
    private static final dl f11173f = new dl("IdTracking");

    /* renamed from: g, reason: collision with root package name */
    private static final db f11174g = new db("snapshots", (byte) 13, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final db f11175h = new db("journals", (byte) 15, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final db f11176i = new db("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f11177j;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f11178a;

    /* renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f11179b;

    /* renamed from: c, reason: collision with root package name */
    public String f11180c;

    /* renamed from: k, reason: collision with root package name */
    private e[] f11181k;

    public static class a extends dq<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, c cVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f10263b;
                if (b10 == 0) {
                    dgVar.k();
                    cVar.n();
                    return;
                }
                short s10 = l10.f10264c;
                int i10 = 0;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            cVar.f11180c = dgVar.z();
                            cVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 15) {
                        dc p10 = dgVar.p();
                        cVar.f11179b = new ArrayList(p10.f10266b);
                        while (i10 < p10.f10266b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(dgVar);
                            cVar.f11179b.add(aVar);
                            i10++;
                        }
                        dgVar.q();
                        cVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    cVar.f11178a = new HashMap(n10.f10269c * 2);
                    while (i10 < n10.f10269c) {
                        String z10 = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(dgVar);
                        cVar.f11178a.put(z10, bVar);
                        i10++;
                    }
                    dgVar.o();
                    cVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, c cVar) {
            cVar.n();
            dgVar.a(c.f11173f);
            if (cVar.f11178a != null) {
                dgVar.a(c.f11174g);
                dgVar.a(new dd((byte) 11, (byte) 12, cVar.f11178a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11178a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            if (cVar.f11179b != null && cVar.j()) {
                dgVar.a(c.f11175h);
                dgVar.a(new dc((byte) 12, cVar.f11179b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11179b.iterator();
                while (it.hasNext()) {
                    it.next().write(dgVar);
                }
                dgVar.f();
                dgVar.c();
            }
            if (cVar.f11180c != null && cVar.m()) {
                dgVar.a(c.f11176i);
                dgVar.a(cVar.f11180c);
                dgVar.c();
            }
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    public static class C0183c extends dr<c> {
        private C0183c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(cVar.f11178a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11178a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (cVar.j()) {
                dmVar.a(cVar.f11179b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11179b.iterator();
                while (it.hasNext()) {
                    it.next().write(dmVar);
                }
            }
            if (cVar.m()) {
                dmVar.a(cVar.f11180c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            cVar.f11178a = new HashMap(ddVar.f10269c * 2);
            for (int i10 = 0; i10 < ddVar.f10269c; i10++) {
                String z10 = dmVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(dmVar);
                cVar.f11178a.put(z10, bVar);
            }
            cVar.a(true);
            BitSet b10 = dmVar.b(2);
            if (b10.get(0)) {
                dc dcVar = new dc((byte) 12, dmVar.w());
                cVar.f11179b = new ArrayList(dcVar.f10266b);
                for (int i11 = 0; i11 < dcVar.f10266b; i11++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(dmVar);
                    cVar.f11179b.add(aVar);
                }
                cVar.b(true);
            }
            if (b10.get(1)) {
                cVar.f11180c = dmVar.z();
                cVar.c(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0183c b() {
            return new C0183c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f11177j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new ct("snapshots", (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new ct("journals", (byte) 2, new cv((byte) 15, new cy((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 2, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f11171d = unmodifiableMap;
        ct.a(c.class, unmodifiableMap);
    }

    public c() {
        this.f11181k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f11178a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f11178a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11178a = null;
        this.f11179b = null;
        this.f11180c = null;
    }

    public void d() {
        this.f11178a = null;
    }

    public boolean e() {
        return this.f11178a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f11179b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f11179b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f11179b;
    }

    public void i() {
        this.f11179b = null;
    }

    public boolean j() {
        return this.f11179b != null;
    }

    public String k() {
        return this.f11180c;
    }

    public void l() {
        this.f11180c = null;
    }

    public boolean m() {
        return this.f11180c != null;
    }

    public void n() {
        if (this.f11178a != null) {
            return;
        }
        throw new dh("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f11177j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f11178a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f11179b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f11180c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f11177j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11185d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11187e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11188f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11185d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f11187e = s10;
            this.f11188f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return SNAPSHOTS;
            }
            if (i10 == 2) {
                return JOURNALS;
            }
            if (i10 != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f11188f;
        }

        public static e a(String str) {
            return f11185d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11187e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f11178a == null) {
            this.f11178a = new HashMap();
        }
        this.f11178a.put(str, bVar);
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f11179b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f11180c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f11178a = map;
    }

    public c(c cVar) {
        this.f11181k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f11178a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f11178a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f11179b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f11179b = arrayList;
        }
        if (cVar.m()) {
            this.f11180c = cVar.f11180c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f11178a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f11178a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f11179b == null) {
            this.f11179b = new ArrayList();
        }
        this.f11179b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f11179b = list;
        return this;
    }

    public c a(String str) {
        this.f11180c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
