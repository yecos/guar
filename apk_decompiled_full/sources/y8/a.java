package y8;

import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap f19770b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f19771c;

    /* renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f19772a;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public a f19773a;

        /* renamed from: b, reason: collision with root package name */
        public IdentityHashMap f19774b;

        public a a() {
            if (this.f19774b != null) {
                for (Map.Entry entry : this.f19773a.f19772a.entrySet()) {
                    if (!this.f19774b.containsKey(entry.getKey())) {
                        this.f19774b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f19773a = new a(this.f19774b);
                this.f19774b = null;
            }
            return this.f19773a;
        }

        public final IdentityHashMap b(int i10) {
            if (this.f19774b == null) {
                this.f19774b = new IdentityHashMap(i10);
            }
            return this.f19774b;
        }

        public b c(c cVar) {
            if (this.f19773a.f19772a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f19773a.f19772a);
                identityHashMap.remove(cVar);
                this.f19773a = new a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f19774b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }

        public b(a aVar) {
            this.f19773a = aVar;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f19775a;

        public c(String str) {
            this.f19775a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f19775a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f19770b = identityHashMap;
        f19771c = new a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f19772a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f19772a.size() != aVar.f19772a.size()) {
            return false;
        }
        for (Map.Entry entry : this.f19772a.entrySet()) {
            if (!aVar.f19772a.containsKey(entry.getKey()) || !Objects.equal(entry.getValue(), aVar.f19772a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = 0;
        for (Map.Entry entry : this.f19772a.entrySet()) {
            i10 += Objects.hashCode(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public String toString() {
        return this.f19772a.toString();
    }

    public a(IdentityHashMap identityHashMap) {
        this.f19772a = identityHashMap;
    }
}
