package p3;

import k3.j;
import k3.x;

/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: e, reason: collision with root package name */
    public final x f18053e;

    public d(k3.g gVar, String str, x xVar) {
        super(gVar.S(), str);
        this.f18053e = xVar;
    }

    public static d v(k3.g gVar, x xVar, j jVar) {
        d dVar = new d(gVar, String.format("Invalid `null` value encountered for property %s", d4.h.c0(xVar, "<UNKNOWN>")), xVar);
        if (jVar != null) {
            dVar.u(jVar);
        }
        return dVar;
    }
}
