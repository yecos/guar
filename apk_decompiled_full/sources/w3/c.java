package w3;

import java.io.Serializable;
import k3.j;
import m3.m;

/* loaded from: classes.dex */
public abstract class c implements Serializable {

    public static abstract class a extends c {
    }

    public enum b {
        ALLOWED,
        DENIED,
        INDETERMINATE
    }

    public abstract b a(m mVar, j jVar);

    public abstract b b(m mVar, j jVar, String str);

    public abstract b c(m mVar, j jVar, j jVar2);
}
