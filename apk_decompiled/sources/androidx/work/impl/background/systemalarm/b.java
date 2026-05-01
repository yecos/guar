package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.d;
import j1.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static final String f3681e = k.f("ConstraintsCmdHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f3682a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3683b;

    /* renamed from: c, reason: collision with root package name */
    public final d f3684c;

    /* renamed from: d, reason: collision with root package name */
    public final f1.d f3685d;

    public b(Context context, int i10, d dVar) {
        this.f3682a = context;
        this.f3683b = i10;
        this.f3684c = dVar;
        this.f3685d = new f1.d(context, dVar.f(), null);
    }

    public void a() {
        List<p> c10 = this.f3684c.g().n().B().c();
        ConstraintProxy.a(this.f3682a, c10);
        this.f3685d.d(c10);
        ArrayList arrayList = new ArrayList(c10.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p pVar : c10) {
            String str = pVar.f14583a;
            if (currentTimeMillis >= pVar.a() && (!pVar.b() || this.f3685d.c(str))) {
                arrayList.add(pVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((p) it.next()).f14583a;
            Intent b10 = a.b(this.f3682a, str2);
            k.c().a(f3681e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            d dVar = this.f3684c;
            dVar.k(new d.b(dVar, b10, this.f3683b));
        }
        this.f3685d.e();
    }
}
