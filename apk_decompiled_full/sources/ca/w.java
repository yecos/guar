package ca;

/* loaded from: classes3.dex */
public abstract class w {
    public static final Object a(Object obj, j jVar) {
        Throwable b10 = h9.l.b(obj);
        if (b10 == null) {
            return obj;
        }
        return new s(b10, false, 2, null);
    }

    public static final Object b(Object obj, s9.l lVar) {
        Throwable b10 = h9.l.b(obj);
        if (b10 == null) {
            return lVar != null ? new t(obj, lVar) : obj;
        }
        return new s(b10, false, 2, null);
    }

    public static /* synthetic */ Object c(Object obj, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
