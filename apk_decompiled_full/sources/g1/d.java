package g1;

import android.content.Context;
import android.os.Build;
import h1.l;
import j1.p;

/* loaded from: classes.dex */
public class d extends c {
    public d(Context context, m1.a aVar) {
        super(l.c(context, aVar).d());
    }

    @Override // g1.c
    public boolean b(p pVar) {
        return pVar.f14592j.b() == a1.l.CONNECTED;
    }

    @Override // g1.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(f1.b bVar) {
        return Build.VERSION.SDK_INT >= 26 ? (bVar.a() && bVar.d()) ? false : true : !bVar.a();
    }
}
