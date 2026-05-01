package b;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f4291a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f4292b;

    public void a(b bVar) {
        if (this.f4292b != null) {
            bVar.a(this.f4292b);
        }
        this.f4291a.add(bVar);
    }

    public void b() {
        this.f4292b = null;
    }

    public void c(Context context) {
        this.f4292b = context;
        Iterator it = this.f4291a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }

    public Context d() {
        return this.f4292b;
    }

    public void e(b bVar) {
        this.f4291a.remove(bVar);
    }
}
