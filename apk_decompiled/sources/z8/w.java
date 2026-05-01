package z8;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f20966a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public volatile y8.p f20967b = y8.p.IDLE;

    public void a(y8.p pVar) {
        Preconditions.checkNotNull(pVar, "newState");
        if (this.f20967b == pVar || this.f20967b == y8.p.SHUTDOWN) {
            return;
        }
        this.f20967b = pVar;
        if (this.f20966a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f20966a;
        this.f20966a = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.m.a(it.next());
            throw null;
        }
    }
}
