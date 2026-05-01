package b4;

import com.fasterxml.jackson.databind.ser.std.b0;
import java.util.Collection;
import java.util.Iterator;
import k3.c0;

/* loaded from: classes.dex */
public class n extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final n f4636b = new n();

    public n() {
        super(Collection.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b0
    public k3.o c(k3.d dVar, Boolean bool) {
        return new n(this, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b0
    public k3.m d() {
        return createSchemaNode("string", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void serialize(Collection collection, c3.h hVar, c0 c0Var) {
        int size = collection.size();
        if (size == 1 && ((this.f6663a == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6663a == Boolean.TRUE)) {
            g(collection, hVar, c0Var);
            return;
        }
        hVar.u0(collection, size);
        g(collection, hVar, c0Var);
        hVar.V();
    }

    public final void g(Collection collection, c3.h hVar, c0 c0Var) {
        int i10 = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    c0Var.E(hVar);
                } else {
                    hVar.z0(str);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, collection, i10);
        }
    }

    @Override // k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(Collection collection, c3.h hVar, c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(collection, c3.n.START_ARRAY));
        hVar.z(collection);
        g(collection, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public n(n nVar, Boolean bool) {
        super(nVar, bool);
    }
}
