package t9;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class j implements h, Serializable {
    private final int arity;

    public j(int i10) {
        this.arity = i10;
    }

    @Override // t9.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String g10 = x.g(this);
        i.f(g10, "renderLambdaToString(this)");
        return g10;
    }
}
