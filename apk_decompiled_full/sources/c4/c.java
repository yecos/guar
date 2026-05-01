package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final c f5531a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f5532b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f5533c;

    public c(Class cls) {
        this(null, cls);
    }

    public void a(k kVar) {
        if (this.f5533c == null) {
            this.f5533c = new ArrayList();
        }
        this.f5533c.add(kVar);
    }

    public c b(Class cls) {
        return new c(this, cls);
    }

    public c c(Class cls) {
        if (this.f5532b == cls) {
            return this;
        }
        for (c cVar = this.f5531a; cVar != null; cVar = cVar.f5531a) {
            if (cVar.f5532b == cls) {
                return cVar;
            }
        }
        return null;
    }

    public void d(k3.j jVar) {
        ArrayList arrayList = this.f5533c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((k) it.next()).c0(jVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ClassStack (self-refs: ");
        ArrayList arrayList = this.f5533c;
        sb.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        for (c cVar = this; cVar != null; cVar = cVar.f5531a) {
            sb.append(' ');
            sb.append(cVar.f5532b.getName());
        }
        sb.append(']');
        return sb.toString();
    }

    public c(c cVar, Class cls) {
        this.f5531a = cVar;
        this.f5532b = cls;
    }
}
