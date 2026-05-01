package ca;

/* loaded from: classes3.dex */
public abstract class p1 extends y {
    public abstract p1 O();

    public final String P() {
        p1 p1Var;
        p1 c10 = n0.c();
        if (this == c10) {
            return "Dispatchers.Main";
        }
        try {
            p1Var = c10.O();
        } catch (UnsupportedOperationException unused) {
            p1Var = null;
        }
        if (this == p1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
