package aa;

import com.google.firebase.analytics.FirebaseAnalytics;
import i9.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import s9.l;
import t9.i;

/* loaded from: classes3.dex */
public abstract class g extends f {

    public static final class a implements Iterable, u9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f483a;

        public a(b bVar) {
            this.f483a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f483a.iterator();
        }
    }

    public static final Iterable c(b bVar) {
        i.g(bVar, "<this>");
        return new a(bVar);
    }

    public static final b d(b bVar, l lVar) {
        i.g(bVar, "<this>");
        i.g(lVar, "transform");
        return new h(bVar, lVar);
    }

    public static final Collection e(b bVar, Collection collection) {
        i.g(bVar, "<this>");
        i.g(collection, FirebaseAnalytics.Param.DESTINATION);
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static final List f(b bVar) {
        i.g(bVar, "<this>");
        return j.i(g(bVar));
    }

    public static final List g(b bVar) {
        i.g(bVar, "<this>");
        return (List) e(bVar, new ArrayList());
    }
}
