package r3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r3.f0;
import r3.t;

/* loaded from: classes.dex */
public class h extends u {

    /* renamed from: d, reason: collision with root package name */
    public final c4.o f18427d;

    /* renamed from: e, reason: collision with root package name */
    public final t.a f18428e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18429f;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final f0 f18430a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f18431b;

        /* renamed from: c, reason: collision with root package name */
        public o f18432c = o.e();

        public a(f0 f0Var, Field field) {
            this.f18430a = f0Var;
            this.f18431b = field;
        }

        public g a() {
            return new g(this.f18430a, this.f18431b, this.f18432c.b());
        }
    }

    public h(k3.b bVar, c4.o oVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f18427d = oVar;
        this.f18428e = bVar == null ? null : aVar;
        this.f18429f = z10;
    }

    public static List m(k3.b bVar, f0 f0Var, t.a aVar, c4.o oVar, k3.j jVar, boolean z10) {
        return new h(bVar, oVar, aVar, z10).l(f0Var, jVar);
    }

    public final void i(Class cls, Class cls2, Map map) {
        a aVar;
        Iterator it = d4.h.x(cls, cls2, true).iterator();
        while (it.hasNext()) {
            for (Field field : ((Class) it.next()).getDeclaredFields()) {
                if (k(field) && (aVar = (a) map.get(field.getName())) != null) {
                    aVar.f18432c = d(aVar.f18432c, field.getDeclaredAnnotations());
                }
            }
        }
    }

    public final Map j(f0 f0Var, k3.j jVar, Map map) {
        t.a aVar;
        Class a10;
        k3.j s10 = jVar.s();
        if (s10 == null) {
            return map;
        }
        Class q10 = jVar.q();
        Map j10 = j(new f0.a(this.f18427d, s10.j()), s10, map);
        for (Field field : q10.getDeclaredFields()) {
            if (k(field)) {
                if (j10 == null) {
                    j10 = new LinkedHashMap();
                }
                a aVar2 = new a(f0Var, field);
                if (this.f18429f) {
                    aVar2.f18432c = d(aVar2.f18432c, field.getDeclaredAnnotations());
                }
                j10.put(field.getName(), aVar2);
            }
        }
        if (j10 != null && (aVar = this.f18428e) != null && (a10 = aVar.a(q10)) != null) {
            i(a10, q10, j10);
        }
        return j10;
    }

    public final boolean k(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }

    public List l(f0 f0Var, k3.j jVar) {
        Map j10 = j(f0Var, jVar, null);
        if (j10 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(j10.size());
        Iterator it = j10.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).a());
        }
        return arrayList;
    }
}
