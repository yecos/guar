package o3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n3.w;

/* loaded from: classes.dex */
public abstract class k {

    public static class a extends w.a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f17534b = new a();

        public a() {
            super(ArrayList.class);
        }

        @Override // n3.w
        public boolean j() {
            return true;
        }

        @Override // n3.w
        public boolean l() {
            return true;
        }

        @Override // n3.w
        public Object x(k3.g gVar) {
            return new ArrayList();
        }
    }

    public static class b extends w.a {

        /* renamed from: b, reason: collision with root package name */
        public final Object f17535b;

        public b(Object obj) {
            super(obj.getClass());
            this.f17535b = obj;
        }

        @Override // n3.w
        public boolean j() {
            return true;
        }

        @Override // n3.w
        public boolean l() {
            return true;
        }

        @Override // n3.w
        public Object x(k3.g gVar) {
            return this.f17535b;
        }
    }

    public static class c extends w.a {

        /* renamed from: b, reason: collision with root package name */
        public static final c f17536b = new c();

        public c() {
            super(HashMap.class);
        }

        @Override // n3.w
        public boolean j() {
            return true;
        }

        @Override // n3.w
        public boolean l() {
            return true;
        }

        @Override // n3.w
        public Object x(k3.g gVar) {
            return new HashMap();
        }
    }

    public static class d extends w.a {

        /* renamed from: b, reason: collision with root package name */
        public static final d f17537b = new d();

        public d() {
            super(LinkedHashMap.class);
        }

        @Override // n3.w
        public boolean j() {
            return true;
        }

        @Override // n3.w
        public boolean l() {
            return true;
        }

        @Override // n3.w
        public Object x(k3.g gVar) {
            return new LinkedHashMap();
        }
    }

    public static n3.w a(k3.f fVar, Class cls) {
        if (cls == c3.i.class) {
            return new com.fasterxml.jackson.databind.deser.std.q();
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (cls == ArrayList.class) {
                return a.f17534b;
            }
            Set set = Collections.EMPTY_SET;
            if (set.getClass() == cls) {
                return new b(set);
            }
            List list = Collections.EMPTY_LIST;
            if (list.getClass() == cls) {
                return new b(list);
            }
            return null;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == LinkedHashMap.class) {
            return d.f17537b;
        }
        if (cls == HashMap.class) {
            return c.f17536b;
        }
        if (Collections.EMPTY_MAP.getClass() == cls) {
            return new b(Collections.EMPTY_MAP);
        }
        return null;
    }
}
