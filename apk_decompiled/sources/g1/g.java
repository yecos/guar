package g1;

import android.content.Context;
import android.os.Build;
import h1.l;
import j1.p;

/* loaded from: classes.dex */
public class g extends c {
    public g(Context context, m1.a aVar) {
        super(l.c(context, aVar).d());
    }

    @Override // g1.c
    public boolean b(p pVar) {
        return pVar.f14592j.b() == a1.l.UNMETERED || (Build.VERSION.SDK_INT >= 30 && pVar.f14592j.b() == a1.l.TEMPORARILY_UNMETERED);
    }

    @Override // g1.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(f1.b bVar) {
        return !bVar.a() || bVar.b();
    }
}
