package n0;

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final s0 f17005c = new s0(new Bundle(), null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f17006a;

    /* renamed from: b, reason: collision with root package name */
    public List f17007b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f17008a;

        public a() {
        }

        public a a(Collection collection) {
            if (collection == null) {
                throw new IllegalArgumentException("categories must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    b((String) it.next());
                }
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            if (this.f17008a == null) {
                this.f17008a = new ArrayList();
            }
            if (!this.f17008a.contains(str)) {
                this.f17008a.add(str);
            }
            return this;
        }

        public a c(s0 s0Var) {
            if (s0Var == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            a(s0Var.e());
            return this;
        }

        public s0 d() {
            if (this.f17008a == null) {
                return s0.f17005c;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", this.f17008a);
            return new s0(bundle, this.f17008a);
        }

        public a(s0 s0Var) {
            if (s0Var == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            s0Var.c();
            if (s0Var.f17007b.isEmpty()) {
                return;
            }
            this.f17008a = new ArrayList(s0Var.f17007b);
        }
    }

    public s0(Bundle bundle, List list) {
        this.f17006a = bundle;
        this.f17007b = list;
    }

    public static s0 d(Bundle bundle) {
        if (bundle != null) {
            return new s0(bundle, null);
        }
        return null;
    }

    public Bundle a() {
        return this.f17006a;
    }

    public boolean b(s0 s0Var) {
        if (s0Var == null) {
            return false;
        }
        c();
        s0Var.c();
        return this.f17007b.containsAll(s0Var.f17007b);
    }

    public void c() {
        if (this.f17007b == null) {
            ArrayList<String> stringArrayList = this.f17006a.getStringArrayList("controlCategories");
            this.f17007b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f17007b = Collections.emptyList();
            }
        }
    }

    public List e() {
        c();
        return this.f17007b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        c();
        s0Var.c();
        return this.f17007b.equals(s0Var.f17007b);
    }

    public boolean f() {
        c();
        return this.f17007b.isEmpty();
    }

    public boolean g() {
        c();
        return !this.f17007b.contains(null);
    }

    public boolean h(List list) {
        if (list != null) {
            c();
            int size = this.f17007b.size();
            if (size != 0) {
                int size2 = list.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    IntentFilter intentFilter = (IntentFilter) list.get(i10);
                    if (intentFilter != null) {
                        for (int i11 = 0; i11 < size; i11++) {
                            if (intentFilter.hasCategory((String) this.f17007b.get(i11))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        c();
        return this.f17007b.hashCode();
    }

    public String toString() {
        return "MediaRouteSelector{ controlCategories=" + Arrays.toString(e().toArray()) + " }";
    }
}
