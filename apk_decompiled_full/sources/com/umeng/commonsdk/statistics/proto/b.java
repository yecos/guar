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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class b implements ch<b, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, ct> f11151d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11152e = -6496538196005191531L;

    /* renamed from: f, reason: collision with root package name */
    private static final dl f11153f = new dl("IdSnapshot");

    /* renamed from: g, reason: collision with root package name */
    private static final db f11154g = new db("identity", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final db f11155h = new db("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final db f11156i = new db("version", (byte) 8, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f11157j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f11158k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f11159l = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f11160a;

    /* renamed from: b, reason: collision with root package name */
    public long f11161b;

    /* renamed from: c, reason: collision with root package name */
    public int f11162c;

    /* renamed from: m, reason: collision with root package name */
    private byte f11163m;

    public static class a extends dq<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, b bVar) {
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
                        } else if (b10 == 8) {
                            bVar.f11162c = dgVar.w();
                            bVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        bVar.f11161b = dgVar.x();
                        bVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    bVar.f11160a = dgVar.z();
                    bVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (!bVar.g()) {
                throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, b bVar) {
            bVar.k();
            dgVar.a(b.f11153f);
            if (bVar.f11160a != null) {
                dgVar.a(b.f11154g);
                dgVar.a(bVar.f11160a);
                dgVar.c();
            }
            dgVar.a(b.f11155h);
            dgVar.a(bVar.f11161b);
            dgVar.c();
            dgVar.a(b.f11156i);
            dgVar.a(bVar.f11162c);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    public static class C0182b implements dp {
        private C0182b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends dr<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, b bVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(bVar.f11160a);
            dmVar.a(bVar.f11161b);
            dmVar.a(bVar.f11162c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, b bVar) {
            dm dmVar = (dm) dgVar;
            bVar.f11160a = dmVar.z();
            bVar.a(true);
            bVar.f11161b = dmVar.x();
            bVar.b(true);
            bVar.f11162c = dmVar.w();
            bVar.c(true);
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
        f11157j = hashMap;
        hashMap.put(dq.class, new C0182b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new ct("identity", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new ct("ts", (byte) 1, new cu((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f11151d = unmodifiableMap;
        ct.a(b.class, unmodifiableMap);
    }

    public b() {
        this.f11163m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f11160a;
    }

    public void c() {
        this.f11160a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11160a = null;
        b(false);
        this.f11161b = 0L;
        c(false);
        this.f11162c = 0;
    }

    public boolean d() {
        return this.f11160a != null;
    }

    public long e() {
        return this.f11161b;
    }

    public void f() {
        this.f11163m = ce.b(this.f11163m, 0);
    }

    public boolean g() {
        return ce.a(this.f11163m, 0);
    }

    public int h() {
        return this.f11162c;
    }

    public void i() {
        this.f11163m = ce.b(this.f11163m, 1);
    }

    public boolean j() {
        return ce.a(this.f11163m, 1);
    }

    public void k() {
        if (this.f11160a != null) {
            return;
        }
        throw new dh("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f11157j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f11160a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f11161b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f11162c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f11157j.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11167d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11169e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11170f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11167d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f11169e = s10;
            this.f11170f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return IDENTITY;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return VERSION;
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
            return this.f11170f;
        }

        public static e a(String str) {
            return f11167d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11169e;
        }
    }

    public b a(String str) {
        this.f11160a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f11163m = ce.a(this.f11163m, 0, z10);
    }

    public void c(boolean z10) {
        this.f11163m = ce.a(this.f11163m, 1, z10);
    }

    public b(String str, long j10, int i10) {
        this();
        this.f11160a = str;
        this.f11161b = j10;
        b(true);
        this.f11162c = i10;
        c(true);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f11160a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public b a(long j10) {
        this.f11161b = j10;
        b(true);
        return this;
    }

    public b a(int i10) {
        this.f11162c = i10;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public b(b bVar) {
        this.f11163m = (byte) 0;
        this.f11163m = bVar.f11163m;
        if (bVar.d()) {
            this.f11160a = bVar.f11160a;
        }
        this.f11161b = bVar.f11161b;
        this.f11162c = bVar.f11162c;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f11163m = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
