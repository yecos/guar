package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class d implements ch<d, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, ct> f11189d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11190e = 2846460275012375038L;

    /* renamed from: f, reason: collision with root package name */
    private static final dl f11191f = new dl("Imprint");

    /* renamed from: g, reason: collision with root package name */
    private static final db f11192g = new db("property", (byte) 13, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final db f11193h = new db("version", (byte) 8, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final db f11194i = new db("checksum", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f11195j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f11196k = 0;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f11197a;

    /* renamed from: b, reason: collision with root package name */
    public int f11198b;

    /* renamed from: c, reason: collision with root package name */
    public String f11199c;

    /* renamed from: l, reason: collision with root package name */
    private byte f11200l;

    public static class a extends dq<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, d dVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f10263b;
                if (b10 == 0) {
                    break;
                }
                short s10 = l10.f10264c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            dVar.f11199c = dgVar.z();
                            dVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 8) {
                        dVar.f11198b = dgVar.w();
                        dVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 13) {
                    dd n10 = dgVar.n();
                    dVar.f11197a = new HashMap(n10.f10269c * 2);
                    for (int i10 = 0; i10 < n10.f10269c; i10++) {
                        String z10 = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(dgVar);
                        dVar.f11197a.put(z10, eVar);
                    }
                    dgVar.o();
                    dVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, d dVar) {
            dVar.l();
            dgVar.a(d.f11191f);
            if (dVar.f11197a != null) {
                dgVar.a(d.f11192g);
                dgVar.a(new dd((byte) 11, (byte) 12, dVar.f11197a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11197a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            dgVar.a(d.f11193h);
            dgVar.a(dVar.f11198b);
            dgVar.c();
            if (dVar.f11199c != null) {
                dgVar.a(d.f11194i);
                dgVar.a(dVar.f11199c);
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

    public static class c extends dr<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(dVar.f11197a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11197a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            dmVar.a(dVar.f11198b);
            dmVar.a(dVar.f11199c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            dVar.f11197a = new HashMap(ddVar.f10269c * 2);
            for (int i10 = 0; i10 < ddVar.f10269c; i10++) {
                String z10 = dmVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(dmVar);
                dVar.f11197a.put(z10, eVar);
            }
            dVar.a(true);
            dVar.f11198b = dmVar.w();
            dVar.b(true);
            dVar.f11199c = dmVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    public static class C0184d implements dp {
        private C0184d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f11195j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new C0184d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new ct("property", (byte) 1, new cw((byte) 13, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 1, new cu((byte) 11)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f11189d = unmodifiableMap;
        ct.a(d.class, unmodifiableMap);
    }

    public d() {
        this.f11200l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f11197a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f11197a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11197a = null;
        b(false);
        this.f11198b = 0;
        this.f11199c = null;
    }

    public void d() {
        this.f11197a = null;
    }

    public boolean e() {
        return this.f11197a != null;
    }

    public int f() {
        return this.f11198b;
    }

    public void g() {
        this.f11200l = ce.b(this.f11200l, 0);
    }

    public boolean h() {
        return ce.a(this.f11200l, 0);
    }

    public String i() {
        return this.f11199c;
    }

    public void j() {
        this.f11199c = null;
    }

    public boolean k() {
        return this.f11199c != null;
    }

    public void l() {
        if (this.f11197a == null) {
            throw new dh("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f11199c != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f11195j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f11197a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f11198b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f11199c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f11195j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11204d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11206e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11207f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11204d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f11206e = s10;
            this.f11207f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return PROPERTY;
            }
            if (i10 == 2) {
                return VERSION;
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
            return this.f11207f;
        }

        public static e a(String str) {
            return f11204d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11206e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f11197a == null) {
            this.f11197a = new HashMap();
        }
        this.f11197a.put(str, eVar);
    }

    public void b(boolean z10) {
        this.f11200l = ce.a(this.f11200l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f11199c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i10, String str) {
        this();
        this.f11197a = map;
        this.f11198b = i10;
        b(true);
        this.f11199c = str;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f11197a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f11197a = null;
    }

    public d a(int i10) {
        this.f11198b = i10;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f11200l = (byte) 0;
        this.f11200l = dVar.f11200l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f11197a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f11197a = hashMap;
        }
        this.f11198b = dVar.f11198b;
        if (dVar.k()) {
            this.f11199c = dVar.f11199c;
        }
    }

    public d a(String str) {
        this.f11199c = str;
        return this;
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
            this.f11200l = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
