package n3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o3.z;

/* loaded from: classes.dex */
public class u extends k3.l {

    /* renamed from: d, reason: collision with root package name */
    public z f17262d;

    /* renamed from: e, reason: collision with root package name */
    public List f17263e;

    public u(c3.k kVar, String str, c3.i iVar, z zVar) {
        super(kVar, str, iVar);
        this.f17262d = zVar;
    }

    @Override // k3.l, c3.l, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this.f17263e == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(message);
        Iterator it = this.f17263e.iterator();
        while (it.hasNext()) {
            sb.append(((v) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }

    public void s(Object obj, Class cls, c3.i iVar) {
        this.f17263e.add(new v(obj, cls, iVar));
    }

    public z t() {
        return this.f17262d;
    }

    public u(c3.k kVar, String str) {
        super(kVar, str);
        this.f17263e = new ArrayList();
    }
}
