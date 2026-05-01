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
public class e implements ch<e, EnumC0185e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0185e, ct> f11208d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f11209e = 7501688097813630241L;

    /* renamed from: f, reason: collision with root package name */
    private static final dl f11210f = new dl("ImprintValue");

    /* renamed from: g, reason: collision with root package name */
    private static final db f11211g = new db("value", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final db f11212h = new db("ts", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    private static final db f11213i = new db("guid", (byte) 11, 3);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f11214j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f11215k = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f11216a;

    /* renamed from: b, reason: collision with root package name */
    public long f11217b;

    /* renamed from: c, reason: collision with root package name */
    public String f11218c;

    /* renamed from: l, reason: collision with root package name */
    private byte f11219l;

    /* renamed from: m, reason: collision with root package name */
    private EnumC0185e[] f11220m;

    public static class a extends dq<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, e eVar) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f10263b;
                if (b10 == 0) {
                    dgVar.k();
                    eVar.k();
                    return;
                }
                short s10 = l10.f10264c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 11) {
                            eVar.f11218c = dgVar.z();
                            eVar.c(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 10) {
                        eVar.f11217b = dgVar.x();
                        eVar.b(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 11) {
                    eVar.f11216a = dgVar.z();
                    eVar.a(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, e eVar) {
            eVar.k();
            dgVar.a(e.f11210f);
            if (eVar.f11216a != null && eVar.d()) {
                dgVar.a(e.f11211g);
                dgVar.a(eVar.f11216a);
                dgVar.c();
            }
            if (eVar.g()) {
                dgVar.a(e.f11212h);
                dgVar.a(eVar.f11217b);
                dgVar.c();
            }
            if (eVar.f11218c != null && eVar.j()) {
                dgVar.a(e.f11213i);
                dgVar.a(eVar.f11218c);
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

    public static class c extends dr<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            dmVar.a(bitSet, 3);
            if (eVar.d()) {
                dmVar.a(eVar.f11216a);
            }
            if (eVar.g()) {
                dmVar.a(eVar.f11217b);
            }
            if (eVar.j()) {
                dmVar.a(eVar.f11218c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet b10 = dmVar.b(3);
            if (b10.get(0)) {
                eVar.f11216a = dmVar.z();
                eVar.a(true);
            }
            if (b10.get(1)) {
                eVar.f11217b = dmVar.x();
                eVar.b(true);
            }
            if (b10.get(2)) {
                eVar.f11218c = dmVar.z();
                eVar.c(true);
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
        f11214j = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0185e.class);
        enumMap.put((EnumMap) EnumC0185e.VALUE, (EnumC0185e) new ct("value", (byte) 2, new cu((byte) 11)));
        enumMap.put((EnumMap) EnumC0185e.TS, (EnumC0185e) new ct("ts", (byte) 2, new cu((byte) 10)));
        enumMap.put((EnumMap) EnumC0185e.GUID, (EnumC0185e) new ct("guid", (byte) 2, new cu((byte) 11)));
        Map<EnumC0185e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f11208d = unmodifiableMap;
        ct.a(e.class, unmodifiableMap);
    }

    public e() {
        this.f11219l = (byte) 0;
        this.f11220m = new EnumC0185e[]{EnumC0185e.VALUE, EnumC0185e.TS, EnumC0185e.GUID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f11216a;
    }

    public void c() {
        this.f11216a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11216a = null;
        b(false);
        this.f11217b = 0L;
        this.f11218c = null;
    }

    public boolean d() {
        return this.f11216a != null;
    }

    public long e() {
        return this.f11217b;
    }

    public void f() {
        this.f11219l = ce.b(this.f11219l, 0);
    }

    public boolean g() {
        return ce.a(this.f11219l, 0);
    }

    public String h() {
        return this.f11218c;
    }

    public void i() {
        this.f11218c = null;
    }

    public boolean j() {
        return this.f11218c != null;
    }

    public void k() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f11214j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f11216a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f11217b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f11218c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f11214j.get(dgVar.D()).b().a(dgVar, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC0185e implements co {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0185e> f11224d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11226e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11227f;

        static {
            Iterator it = EnumSet.allOf(EnumC0185e.class).iterator();
            while (it.hasNext()) {
                EnumC0185e enumC0185e = (EnumC0185e) it.next();
                f11224d.put(enumC0185e.b(), enumC0185e);
            }
        }

        EnumC0185e(short s10, String str) {
            this.f11226e = s10;
            this.f11227f = str;
        }

        public static EnumC0185e a(int i10) {
            if (i10 == 1) {
                return VALUE;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0185e b(int i10) {
            EnumC0185e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f11227f;
        }

        public static EnumC0185e a(String str) {
            return f11224d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11226e;
        }
    }

    public e a(String str) {
        this.f11216a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f11219l = ce.a(this.f11219l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f11218c = null;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f11216a = null;
    }

    public e b(String str) {
        this.f11218c = str;
        return this;
    }

    public e(long j10, String str) {
        this();
        this.f11217b = j10;
        b(true);
        this.f11218c = str;
    }

    public e a(long j10) {
        this.f11217b = j10;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0185e fieldForId(int i10) {
        return EnumC0185e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public e(e eVar) {
        this.f11219l = (byte) 0;
        this.f11220m = new EnumC0185e[]{EnumC0185e.VALUE, EnumC0185e.TS, EnumC0185e.GUID};
        this.f11219l = eVar.f11219l;
        if (eVar.d()) {
            this.f11216a = eVar.f11216a;
        }
        this.f11217b = eVar.f11217b;
        if (eVar.j()) {
            this.f11218c = eVar.f11218c;
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.f11219l = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
