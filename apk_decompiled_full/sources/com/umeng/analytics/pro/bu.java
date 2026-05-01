package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class bu implements ch<bu, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<e, ct> f10066k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f10067l = 420342210744516016L;

    /* renamed from: m, reason: collision with root package name */
    private static final dl f10068m = new dl("UMEnvelope");

    /* renamed from: n, reason: collision with root package name */
    private static final db f10069n = new db("version", (byte) 11, 1);

    /* renamed from: o, reason: collision with root package name */
    private static final db f10070o = new db("address", (byte) 11, 2);

    /* renamed from: p, reason: collision with root package name */
    private static final db f10071p = new db(com.umeng.ccg.a.f10664x, (byte) 11, 3);

    /* renamed from: q, reason: collision with root package name */
    private static final db f10072q = new db("serial_num", (byte) 8, 4);

    /* renamed from: r, reason: collision with root package name */
    private static final db f10073r = new db("ts_secs", (byte) 8, 5);

    /* renamed from: s, reason: collision with root package name */
    private static final db f10074s = new db("length", (byte) 8, 6);

    /* renamed from: t, reason: collision with root package name */
    private static final db f10075t = new db("entity", (byte) 11, 7);

    /* renamed from: u, reason: collision with root package name */
    private static final db f10076u = new db("guid", (byte) 11, 8);

    /* renamed from: v, reason: collision with root package name */
    private static final db f10077v = new db("checksum", (byte) 11, 9);

    /* renamed from: w, reason: collision with root package name */
    private static final db f10078w = new db("codex", (byte) 8, 10);

    /* renamed from: x, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f10079x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f10080y = 0;

    /* renamed from: z, reason: collision with root package name */
    private static final int f10081z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a, reason: collision with root package name */
    public String f10082a;

    /* renamed from: b, reason: collision with root package name */
    public String f10083b;

    /* renamed from: c, reason: collision with root package name */
    public String f10084c;

    /* renamed from: d, reason: collision with root package name */
    public int f10085d;

    /* renamed from: e, reason: collision with root package name */
    public int f10086e;

    /* renamed from: f, reason: collision with root package name */
    public int f10087f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f10088g;

    /* renamed from: h, reason: collision with root package name */
    public String f10089h;

    /* renamed from: i, reason: collision with root package name */
    public String f10090i;

    /* renamed from: j, reason: collision with root package name */
    public int f10091j;

    public static class a extends dq<bu> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, bu buVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f10263b;
                if (b10 == 0) {
                    dgVar.k();
                    if (!buVar.m()) {
                        throw new dh("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!buVar.p()) {
                        throw new dh("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (buVar.s()) {
                        buVar.G();
                        return;
                    }
                    throw new dh("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (l10.f10264c) {
                    case 1:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10082a = dgVar.z();
                            buVar.a(true);
                            break;
                        }
                    case 2:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10083b = dgVar.z();
                            buVar.b(true);
                            break;
                        }
                    case 3:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10084c = dgVar.z();
                            buVar.c(true);
                            break;
                        }
                    case 4:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10085d = dgVar.w();
                            buVar.d(true);
                            break;
                        }
                    case 5:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10086e = dgVar.w();
                            buVar.e(true);
                            break;
                        }
                    case 6:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10087f = dgVar.w();
                            buVar.f(true);
                            break;
                        }
                    case 7:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10088g = dgVar.A();
                            buVar.g(true);
                            break;
                        }
                    case 8:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10089h = dgVar.z();
                            buVar.h(true);
                            break;
                        }
                    case 9:
                        if (b10 != 11) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10090i = dgVar.z();
                            buVar.i(true);
                            break;
                        }
                    case 10:
                        if (b10 != 8) {
                            dj.a(dgVar, b10);
                            break;
                        } else {
                            buVar.f10091j = dgVar.w();
                            buVar.j(true);
                            break;
                        }
                    default:
                        dj.a(dgVar, b10);
                        break;
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, bu buVar) {
            buVar.G();
            dgVar.a(bu.f10068m);
            if (buVar.f10082a != null) {
                dgVar.a(bu.f10069n);
                dgVar.a(buVar.f10082a);
                dgVar.c();
            }
            if (buVar.f10083b != null) {
                dgVar.a(bu.f10070o);
                dgVar.a(buVar.f10083b);
                dgVar.c();
            }
            if (buVar.f10084c != null) {
                dgVar.a(bu.f10071p);
                dgVar.a(buVar.f10084c);
                dgVar.c();
            }
            dgVar.a(bu.f10072q);
            dgVar.a(buVar.f10085d);
            dgVar.c();
            dgVar.a(bu.f10073r);
            dgVar.a(buVar.f10086e);
            dgVar.c();
            dgVar.a(bu.f10074s);
            dgVar.a(buVar.f10087f);
            dgVar.c();
            if (buVar.f10088g != null) {
                dgVar.a(bu.f10075t);
                dgVar.a(buVar.f10088g);
                dgVar.c();
            }
            if (buVar.f10089h != null) {
                dgVar.a(bu.f10076u);
                dgVar.a(buVar.f10089h);
                dgVar.c();
            }
            if (buVar.f10090i != null) {
                dgVar.a(bu.f10077v);
                dgVar.a(buVar.f10090i);
                dgVar.c();
            }
            if (buVar.F()) {
                dgVar.a(bu.f10078w);
                dgVar.a(buVar.f10091j);
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

    public static class c extends dr<bu> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, bu buVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(buVar.f10082a);
            dmVar.a(buVar.f10083b);
            dmVar.a(buVar.f10084c);
            dmVar.a(buVar.f10085d);
            dmVar.a(buVar.f10086e);
            dmVar.a(buVar.f10087f);
            dmVar.a(buVar.f10088g);
            dmVar.a(buVar.f10089h);
            dmVar.a(buVar.f10090i);
            BitSet bitSet = new BitSet();
            if (buVar.F()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (buVar.F()) {
                dmVar.a(buVar.f10091j);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, bu buVar) {
            dm dmVar = (dm) dgVar;
            buVar.f10082a = dmVar.z();
            buVar.a(true);
            buVar.f10083b = dmVar.z();
            buVar.b(true);
            buVar.f10084c = dmVar.z();
            buVar.c(true);
            buVar.f10085d = dmVar.w();
            buVar.d(true);
            buVar.f10086e = dmVar.w();
            buVar.e(true);
            buVar.f10087f = dmVar.w();
            buVar.f(true);
            buVar.f10088g = dmVar.A();
            buVar.g(true);
            buVar.f10089h = dmVar.z();
            buVar.h(true);
            buVar.f10090i = dmVar.z();
            buVar.i(true);
            if (dmVar.b(1).get(0)) {
                buVar.f10091j = dmVar.w();
                buVar.j(true);
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
        f10079x = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new ct("version", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new ct("address", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new ct(com.umeng.ccg.a.f10664x, (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new ct("serial_num", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new ct("ts_secs", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new ct("length", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new ct("entity", (byte) 1, new cu((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new ct("guid", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new ct("checksum", (byte) 1, new cu((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new ct("codex", (byte) 2, new cu((byte) 8)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f10066k = unmodifiableMap;
        ct.a(bu.class, unmodifiableMap);
    }

    public bu() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f10090i;
    }

    public void B() {
        this.f10090i = null;
    }

    public boolean C() {
        return this.f10090i != null;
    }

    public int D() {
        return this.f10091j;
    }

    public void E() {
        this.C = ce.b(this.C, 3);
    }

    public boolean F() {
        return ce.a(this.C, 3);
    }

    public void G() {
        if (this.f10082a == null) {
            throw new dh("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f10083b == null) {
            throw new dh("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f10084c == null) {
            throw new dh("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f10088g == null) {
            throw new dh("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f10089h == null) {
            throw new dh("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f10090i != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bu deepCopy() {
        return new bu(this);
    }

    public String b() {
        return this.f10082a;
    }

    public void c() {
        this.f10082a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f10082a = null;
        this.f10083b = null;
        this.f10084c = null;
        d(false);
        this.f10085d = 0;
        e(false);
        this.f10086e = 0;
        f(false);
        this.f10087f = 0;
        this.f10088g = null;
        this.f10089h = null;
        this.f10090i = null;
        j(false);
        this.f10091j = 0;
    }

    public boolean d() {
        return this.f10082a != null;
    }

    public String e() {
        return this.f10083b;
    }

    public void f() {
        this.f10083b = null;
    }

    public boolean g() {
        return this.f10083b != null;
    }

    public String h() {
        return this.f10084c;
    }

    public void i() {
        this.f10084c = null;
    }

    public boolean j() {
        return this.f10084c != null;
    }

    public int k() {
        return this.f10085d;
    }

    public void l() {
        this.C = ce.b(this.C, 0);
    }

    public boolean m() {
        return ce.a(this.C, 0);
    }

    public int n() {
        return this.f10086e;
    }

    public void o() {
        this.C = ce.b(this.C, 1);
    }

    public boolean p() {
        return ce.a(this.C, 1);
    }

    public int q() {
        return this.f10087f;
    }

    public void r() {
        this.C = ce.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f10079x.get(dgVar.D()).b().b(dgVar, this);
    }

    public boolean s() {
        return ce.a(this.C, 2);
    }

    public byte[] t() {
        a(ci.c(this.f10088g));
        ByteBuffer byteBuffer = this.f10088g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f10082a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f10083b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f10084c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f10085d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f10086e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f10087f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f10088g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            ci.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f10089h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f10090i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f10091j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f10088g;
    }

    public void v() {
        this.f10088g = null;
    }

    public boolean w() {
        return this.f10088g != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f10079x.get(dgVar.D()).b().a(dgVar, this);
    }

    public String x() {
        return this.f10089h;
    }

    public void y() {
        this.f10089h = null;
    }

    public boolean z() {
        return this.f10089h != null;
    }

    public enum e implements co {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, com.umeng.ccg.a.f10664x),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f10102k = new HashMap();

        /* renamed from: l, reason: collision with root package name */
        private final short f10104l;

        /* renamed from: m, reason: collision with root package name */
        private final String f10105m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f10102k.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f10104l = s10;
            this.f10105m = str;
        }

        public static e a(int i10) {
            switch (i10) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f10105m;
        }

        public static e a(String str) {
            return f10102k.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f10104l;
        }
    }

    public bu a(String str) {
        this.f10082a = str;
        return this;
    }

    public bu b(String str) {
        this.f10083b = str;
        return this;
    }

    public bu c(String str) {
        this.f10084c = str;
        return this;
    }

    public void d(boolean z10) {
        this.C = ce.a(this.C, 0, z10);
    }

    public void e(boolean z10) {
        this.C = ce.a(this.C, 1, z10);
    }

    public void f(boolean z10) {
        this.C = ce.a(this.C, 2, z10);
    }

    public void g(boolean z10) {
        if (z10) {
            return;
        }
        this.f10088g = null;
    }

    public void h(boolean z10) {
        if (z10) {
            return;
        }
        this.f10089h = null;
    }

    public void i(boolean z10) {
        if (z10) {
            return;
        }
        this.f10090i = null;
    }

    public void j(boolean z10) {
        this.C = ce.a(this.C, 3, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f10082a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f10083b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f10084c = null;
    }

    public bu d(String str) {
        this.f10089h = str;
        return this;
    }

    public bu e(String str) {
        this.f10090i = str;
        return this;
    }

    public bu(String str, String str2, String str3, int i10, int i11, int i12, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f10082a = str;
        this.f10083b = str2;
        this.f10084c = str3;
        this.f10085d = i10;
        d(true);
        this.f10086e = i11;
        e(true);
        this.f10087f = i12;
        f(true);
        this.f10088g = byteBuffer;
        this.f10089h = str4;
        this.f10090i = str5;
    }

    public bu a(int i10) {
        this.f10085d = i10;
        d(true);
        return this;
    }

    public bu b(int i10) {
        this.f10086e = i10;
        e(true);
        return this;
    }

    public bu c(int i10) {
        this.f10087f = i10;
        f(true);
        return this;
    }

    public bu d(int i10) {
        this.f10091j = i10;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public bu a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bu a(ByteBuffer byteBuffer) {
        this.f10088g = byteBuffer;
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
            this.C = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public bu(bu buVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = buVar.C;
        if (buVar.d()) {
            this.f10082a = buVar.f10082a;
        }
        if (buVar.g()) {
            this.f10083b = buVar.f10083b;
        }
        if (buVar.j()) {
            this.f10084c = buVar.f10084c;
        }
        this.f10085d = buVar.f10085d;
        this.f10086e = buVar.f10086e;
        this.f10087f = buVar.f10087f;
        if (buVar.w()) {
            this.f10088g = ci.d(buVar.f10088g);
        }
        if (buVar.z()) {
            this.f10089h = buVar.f10089h;
        }
        if (buVar.C()) {
            this.f10090i = buVar.f10090i;
        }
        this.f10091j = buVar.f10091j;
    }
}
