package b1;

import a1.n;
import androidx.lifecycle.l;

/* loaded from: classes.dex */
public class c implements n {

    /* renamed from: c, reason: collision with root package name */
    public final l f4384c = new l();

    /* renamed from: d, reason: collision with root package name */
    public final l1.c f4385d = l1.c.s();

    public c() {
        a(n.f125b);
    }

    public void a(n.b bVar) {
        this.f4384c.l(bVar);
        if (bVar instanceof n.b.c) {
            this.f4385d.o((n.b.c) bVar);
        } else if (bVar instanceof n.b.a) {
            this.f4385d.p(((n.b.a) bVar).a());
        }
    }
}
