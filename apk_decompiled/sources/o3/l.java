package o3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f17538a = Arrays.asList(null, null).getClass();

    /* renamed from: b, reason: collision with root package name */
    public static final Class f17539b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class f17540c;

    /* renamed from: d, reason: collision with root package name */
    public static final Class f17541d;

    /* renamed from: e, reason: collision with root package name */
    public static final Class f17542e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class f17543f;

    /* renamed from: g, reason: collision with root package name */
    public static final Class f17544g;

    /* renamed from: h, reason: collision with root package name */
    public static final Class f17545h;

    public static class a implements d4.j {

        /* renamed from: a, reason: collision with root package name */
        public final k3.j f17546a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17547b;

        public a(int i10, k3.j jVar) {
            this.f17546a = jVar;
            this.f17547b = i10;
        }

        @Override // d4.j
        public k3.j a(c4.o oVar) {
            return this.f17546a;
        }

        @Override // d4.j
        public k3.j b(c4.o oVar) {
            return this.f17546a;
        }

        public final void c(int i10) {
            if (i10 == 1) {
                return;
            }
            throw new IllegalArgumentException("Can not deserialize Singleton container from " + i10 + " entries");
        }

        @Override // d4.j
        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this.f17547b) {
                case 1:
                    Set set = (Set) obj;
                    c(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    c(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    c(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        Set singleton = Collections.singleton(bool);
        f17539b = singleton.getClass();
        f17542e = Collections.unmodifiableSet(singleton).getClass();
        List singletonList = Collections.singletonList(bool);
        f17540c = singletonList.getClass();
        f17543f = Collections.unmodifiableList(singletonList).getClass();
        f17544g = Collections.unmodifiableList(new LinkedList()).getClass();
        Map singletonMap = Collections.singletonMap("a", c8.b.f5629b);
        f17541d = singletonMap.getClass();
        f17545h = Collections.unmodifiableMap(singletonMap).getClass();
    }

    public static String a(Class cls) {
        String name = cls.getName();
        return name.startsWith("java.util.Collections$") ? name.substring(22) : "";
    }

    public static String b(Class cls) {
        String a10 = a(cls);
        return (a10 == null || !a10.startsWith("Synchronized")) ? "" : a10.substring(12);
    }

    public static a c(int i10, k3.j jVar, Class cls) {
        return new a(i10, jVar.i(cls));
    }

    public static k3.k d(k3.g gVar, k3.j jVar) {
        a c10;
        if (jVar.y(f17538a)) {
            c10 = c(11, jVar, List.class);
        } else if (jVar.y(f17540c)) {
            c10 = c(2, jVar, List.class);
        } else if (jVar.y(f17539b)) {
            c10 = c(1, jVar, Set.class);
        } else if (jVar.y(f17543f) || jVar.y(f17544g)) {
            c10 = c(5, jVar, List.class);
        } else if (jVar.y(f17542e)) {
            c10 = c(4, jVar, Set.class);
        } else {
            String b10 = b(jVar.q());
            if (b10.endsWith("Set")) {
                c10 = c(7, jVar, Set.class);
            } else if (b10.endsWith("List")) {
                c10 = c(9, jVar, List.class);
            } else {
                if (!b10.endsWith("Collection")) {
                    return null;
                }
                c10 = c(8, jVar, Collection.class);
            }
        }
        return new com.fasterxml.jackson.databind.deser.std.a0(c10);
    }

    public static k3.k e(k3.g gVar, k3.j jVar) {
        a c10;
        if (jVar.y(f17541d)) {
            c10 = c(3, jVar, Map.class);
        } else if (jVar.y(f17545h)) {
            c10 = c(6, jVar, Map.class);
        } else {
            if (!b(jVar.q()).endsWith("Map")) {
                return null;
            }
            c10 = c(10, jVar, Map.class);
        }
        return new com.fasterxml.jackson.databind.deser.std.a0(c10);
    }
}
