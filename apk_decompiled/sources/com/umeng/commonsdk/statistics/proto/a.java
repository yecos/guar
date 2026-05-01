package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class a implements ch<a, e>, Serializable, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Map<e, ct> f11128e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f11129f = 9132678615281394583L;

    /* renamed from: g, reason: collision with root package name */
    private static final dl f11130g = new dl("IdJournal");

    /* renamed from: h, reason: collision with root package name */
    private static final db f11131h = new db("domain", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    private static final db f11132i = new db("old_id", (byte) 11, 2);

    /* renamed from: j, reason: collision with root package name */
    private static final db f11133j = new db("new_id", (byte) 11, 3);

    /* renamed from: k, reason: collision with root package name */
    private static final db f11134k = new db("ts", (byte) 10, 4);

    /* renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f11135l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f11136m = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f11137a;

    /* renamed from: b, reason: collision with root package name */
    public String f11138b;

    /* renamed from: c, reason: collision with root package name */
    public String f11139c;

    /* renamed from: d, reason: collision with root package name */
    public long f11140d;

    /* renamed from: n, reason: collision with root package name */
    private byte f11141n;

    /* renamed from: o, reason: collision with root package name */
    private e[] f11142o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    public static class C0181a extends dq<a> {
        private C0181a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, a aVar) {
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
                            if (s10 != 4) {
                                dj.a(dgVar, b10);
                            } else if (b10 == 10) {
                                aVar.f11140d = dgVar.x();
                                aVar.d(true);
                            } else {
                                dj.a(dgVar, b10);
                            }
                        } else if (b10 == 11) {
                            aVar.f11139c = dgVar.z();
                            aVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 11) {
                        aVar.f11138b = dgVar.z();
                        aVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    aVar.f11137a = dgVar.z();
                    aVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, a aVar) {
            aVar.n();
            dgVar.a(a.f11130g);
            if (aVar.f11137a != null) {
                dgVar.a(a.f11131h);
                dgVar.a(aVar.f11137a);
                dgVar.c();
            }
            if (aVar.f11138b != null && aVar.g()) {
                dgVar.a(a.f11132i);
                dgVar.a(aVar.f11138b);
                dgVar.c();
            }
            if (aVar.f11139c != null) {
                dgVar.a(a.f11133j);
                dgVar.a(aVar.f11139c);
                dgVar.c();
            }
            dgVar.a(a.f11134k);
            dgVar.a(aVar.f11140d);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0181a b() {
            return new C0181a();
        }
    }

    public static class c extends dr<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, a aVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(aVar.f11137a);
            dmVar.a(aVar.f11139c);
            dmVar.a(aVar.f11140d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (aVar.g()) {
                dmVar.a(aVar.f11138b);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, a aVar) {
            dm dmVar = (dm) dgVar;
            aVar.f11137a = dmVar.z();
            aVar.a(true);
            aVar.f11139c = dmVar.z();
            aVar.c(true);
            aVar.f11140d = dmVar.x();
            aVar.d(true);
            if (dmVar.b(1).get(0)) {
                aVar.f11138b = dmVar.z();
                aVar.b(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f11135l = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new ct("domain", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new ct("old_id", (byte) 2, new cu((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new ct("new_id", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new ct("ts", (byte) 1, new cu((byte) 10)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f11128e = unmodifiableMap;
        ct.a(a.class, unmodifiableMap);
    }

    public a() {
        this.f11141n = (byte) 0;
        this.f11142o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f11137a;
    }

    public void c() {
        this.f11137a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11137a = null;
        this.f11138b = null;
        this.f11139c = null;
        d(false);
        this.f11140d = 0L;
    }

    public boolean d() {
        return this.f11137a != null;
    }

    public String e() {
        return this.f11138b;
    }

    public void f() {
        this.f11138b = null;
    }

    public boolean g() {
        return this.f11138b != null;
    }

    public String h() {
        return this.f11139c;
    }

    public void i() {
        this.f11139c = null;
    }

    public boolean j() {
        return this.f11139c != null;
    }

    public long k() {
        return this.f11140d;
    }

    public void l() {
        this.f11141n = ce.b(this.f11141n, 0);
    }

    public boolean m() {
        return ce.a(this.f11141n, 0);
    }

    public void n() {
        if (this.f11137a == null) {
            throw new dh("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f11139c != null) {
            return;
        }
        throw new dh("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f11135l.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f11137a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f11138b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f11139c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f11140d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f11135l.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f11147e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private final short f11149f;

        /* renamed from: g, reason: collision with root package name */
        private final String f11150g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11147e.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f11149f = s10;
            this.f11150g = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return DOMAIN;
            }
            if (i10 == 2) {
                return OLD_ID;
            }
            if (i10 == 3) {
                return NEW_ID;
            }
            if (i10 != 4) {
                return null;
            }
            return TS;
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
            return this.f11150g;
        }

        public static e a(String str) {
            return f11147e.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11149f;
        }
    }

    public a a(String str) {
        this.f11137a = str;
        return this;
    }

    public a b(String str) {
        this.f11138b = str;
        return this;
    }

    public a c(String str) {
        this.f11139c = str;
        return this;
    }

    public void d(boolean z10) {
        this.f11141n = ce.a(this.f11141n, 0, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f11137a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f11138b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f11139c = null;
    }

    public a(String str, String str2, long j10) {
        this();
        this.f11137a = str;
        this.f11139c = str2;
        this.f11140d = j10;
        d(true);
    }

    public a a(long j10) {
        this.f11140d = j10;
        d(true);
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

    public a(a aVar) {
        this.f11141n = (byte) 0;
        this.f11142o = new e[]{e.OLD_ID};
        this.f11141n = aVar.f11141n;
        if (aVar.d()) {
            this.f11137a = aVar.f11137a;
        }
        if (aVar.g()) {
            this.f11138b = aVar.f11138b;
        }
        if (aVar.j()) {
            this.f11139c = aVar.f11139c;
        }
        this.f11140d = aVar.f11140d;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f11141n = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
