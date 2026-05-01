package b4;

import com.fasterxml.jackson.databind.ser.std.b0;
import java.util.List;
import k3.c0;

/* loaded from: classes.dex */
public final class f extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final f f4591b = new f();

    public f() {
        super(List.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b0
    public k3.o c(k3.d dVar, Boolean bool) {
        return new f(this, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b0
    public k3.m d() {
        return createSchemaNode("string", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void serialize(List list, c3.h hVar, c0 c0Var) {
        int size = list.size();
        if (size == 1 && ((this.f6663a == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6663a == Boolean.TRUE)) {
            g(list, hVar, c0Var, 1);
            return;
        }
        hVar.u0(list, size);
        g(list, hVar, c0Var, size);
        hVar.V();
    }

    public final void g(List list, c3.h hVar, c0 c0Var, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            try {
                String str = (String) list.get(i11);
                if (str == null) {
                    c0Var.E(hVar);
                } else {
                    hVar.z0(str);
                }
            } catch (Exception e10) {
                wrapAndThrow(c0Var, e10, list, i11);
                return;
            }
        }
    }

    @Override // k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(List list, c3.h hVar, c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(list, c3.n.START_ARRAY));
        hVar.z(list);
        g(list, hVar, c0Var, list.size());
        hVar2.h(hVar, g10);
    }

    public f(f fVar, Boolean bool) {
        super(fVar, bool);
    }
}
