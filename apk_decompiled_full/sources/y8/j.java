package y8;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y8.g;

/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final g f19875a = new a();

    public class a extends g {
        @Override // y8.g
        public void a(String str, Throwable th) {
        }

        @Override // y8.g
        public void b() {
        }

        @Override // y8.g
        public void c(int i10) {
        }

        @Override // y8.g
        public void d(Object obj) {
        }

        @Override // y8.g
        public void e(g.a aVar, v0 v0Var) {
        }
    }

    public static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public final d f19876a;

        /* renamed from: b, reason: collision with root package name */
        public final h f19877b;

        public /* synthetic */ b(d dVar, h hVar, i iVar) {
            this(dVar, hVar);
        }

        @Override // y8.d
        public String a() {
            return this.f19876a.a();
        }

        @Override // y8.d
        public g h(w0 w0Var, c cVar) {
            return this.f19877b.a(w0Var, cVar, this.f19876a);
        }

        public b(d dVar, h hVar) {
            this.f19876a = dVar;
            this.f19877b = (h) Preconditions.checkNotNull(hVar, "interceptor");
        }
    }

    public static d a(d dVar, List list) {
        Preconditions.checkNotNull(dVar, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dVar = new b(dVar, (h) it.next(), null);
        }
        return dVar;
    }

    public static d b(d dVar, h... hVarArr) {
        return a(dVar, Arrays.asList(hVarArr));
    }
}
