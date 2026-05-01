package a4;

import com.fasterxml.jackson.databind.ser.std.i0;

/* loaded from: classes.dex */
public abstract class h extends i0 {
    public h(Class cls) {
        super(cls);
    }

    public abstract h c(w3.h hVar);

    public h d(w3.h hVar) {
        return hVar == null ? this : c(hVar);
    }

    public h(k3.j jVar) {
        super(jVar);
    }

    public h(Class cls, boolean z10) {
        super(cls, z10);
    }

    public h(h hVar) {
        super(hVar._handledType, false);
    }
}
