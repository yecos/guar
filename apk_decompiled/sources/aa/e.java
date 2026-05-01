package aa;

import java.util.Iterator;
import t9.i;

/* loaded from: classes3.dex */
public abstract class e extends d {

    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f482a;

        public a(Iterator it) {
            this.f482a = it;
        }

        @Override // aa.b
        public Iterator iterator() {
            return this.f482a;
        }
    }

    public static final b a(Iterator it) {
        i.g(it, "<this>");
        return b(new a(it));
    }

    public static final b b(b bVar) {
        i.g(bVar, "<this>");
        return bVar instanceof aa.a ? bVar : new aa.a(bVar);
    }
}
