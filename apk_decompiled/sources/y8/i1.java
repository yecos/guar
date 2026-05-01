package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f19869a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f19870b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19871c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f19872a;

        /* renamed from: b, reason: collision with root package name */
        public List f19873b;

        /* renamed from: c, reason: collision with root package name */
        public Object f19874c;

        public final b e(Collection collection) {
            this.f19873b.addAll(collection);
            return this;
        }

        public b f(w0 w0Var) {
            this.f19873b.add((w0) Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD));
            return this;
        }

        public i1 g() {
            return new i1(this);
        }

        public b h(String str) {
            this.f19872a = (String) Preconditions.checkNotNull(str, "name");
            return this;
        }

        public b(String str) {
            this.f19873b = new ArrayList();
            h(str);
        }
    }

    public static b c(String str) {
        return new b(str);
    }

    public static void d(String str, Collection collection) {
        HashSet hashSet = new HashSet(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            w0 w0Var = (w0) it.next();
            Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
            String d10 = w0Var.d();
            Preconditions.checkArgument(str.equals(d10), "service names %s != %s", d10, str);
            Preconditions.checkArgument(hashSet.add(w0Var.c()), "duplicate name %s", w0Var.c());
        }
    }

    public Collection a() {
        return this.f19870b;
    }

    public String b() {
        return this.f19869a;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.f19869a).add("schemaDescriptor", this.f19871c).add("methods", this.f19870b).omitNullValues().toString();
    }

    public i1(String str, Collection collection) {
        this(c(str).e((Collection) Preconditions.checkNotNull(collection, "methods")));
    }

    public i1(b bVar) {
        String str = bVar.f19872a;
        this.f19869a = str;
        d(str, bVar.f19873b);
        this.f19870b = Collections.unmodifiableList(new ArrayList(bVar.f19873b));
        this.f19871c = bVar.f19874c;
    }
}
