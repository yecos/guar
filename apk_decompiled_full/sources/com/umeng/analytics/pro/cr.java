package com.umeng.analytics.pro;

import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.cr;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class cr<T extends cr<?, ?>, F extends co> implements ch<T, F> {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Cdo>, dp> f10191c;

    /* renamed from: a, reason: collision with root package name */
    protected Object f10192a;

    /* renamed from: b, reason: collision with root package name */
    protected F f10193b;

    public static class a extends dq<cr> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, cr crVar) {
            crVar.f10193b = null;
            crVar.f10192a = null;
            dgVar.j();
            db l10 = dgVar.l();
            Object a10 = crVar.a(dgVar, l10);
            crVar.f10192a = a10;
            if (a10 != null) {
                crVar.f10193b = (F) crVar.a(l10.f10264c);
            }
            dgVar.m();
            dgVar.l();
            dgVar.k();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, cr crVar) {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.d());
            dgVar.a(crVar.c(crVar.f10193b));
            crVar.a(dgVar);
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
        public a b() {
            return new a();
        }
    }

    public static class c extends dr<cr> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, cr crVar) {
            crVar.f10193b = null;
            crVar.f10192a = null;
            short v10 = dgVar.v();
            Object a10 = crVar.a(dgVar, v10);
            crVar.f10192a = a10;
            if (a10 != null) {
                crVar.f10193b = (F) crVar.a(v10);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, cr crVar) {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.f10193b.a());
            crVar.b(dgVar);
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
        f10191c = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
    }

    public cr() {
        this.f10193b = null;
        this.f10192a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof ch ? ((ch) obj).deepCopy() : obj instanceof ByteBuffer ? ci.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s10);

    public abstract Object a(dg dgVar, db dbVar);

    public abstract Object a(dg dgVar, short s10);

    public abstract void a(dg dgVar);

    public Object b() {
        return this.f10192a;
    }

    public abstract void b(F f10, Object obj);

    public abstract void b(dg dgVar);

    public abstract db c(F f10);

    public boolean c() {
        return this.f10193b != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public final void clear() {
        this.f10193b = null;
        this.f10192a = null;
    }

    public abstract dl d();

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        f10191c.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Operator.Operation.LESS_THAN);
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b10 = b();
            sb.append(c(a()).f10262a);
            sb.append(SOAP.DELIM);
            if (b10 instanceof ByteBuffer) {
                ci.a((ByteBuffer) b10, sb);
            } else {
                sb.append(b10.toString());
            }
        }
        sb.append(Operator.Operation.GREATER_THAN);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        f10191c.get(dgVar.D()).b().a(dgVar, this);
    }

    public boolean b(F f10) {
        return this.f10193b == f10;
    }

    public boolean b(int i10) {
        return b((cr<T, F>) a((short) i10));
    }

    public cr(F f10, Object obj) {
        a((cr<T, F>) f10, obj);
    }

    public cr(cr<T, F> crVar) {
        if (crVar.getClass().equals(getClass())) {
            this.f10193b = crVar.f10193b;
            this.f10192a = a(crVar.f10192a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f10193b;
    }

    public Object a(F f10) {
        if (f10 == this.f10193b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f10 + " because union's set field is " + this.f10193b);
    }

    public Object a(int i10) {
        return a((cr<T, F>) a((short) i10));
    }

    public void a(F f10, Object obj) {
        b(f10, obj);
        this.f10193b = f10;
        this.f10192a = obj;
    }

    public void a(int i10, Object obj) {
        a((cr<T, F>) a((short) i10), obj);
    }
}
