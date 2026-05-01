package w9;

import java.util.Random;

/* loaded from: classes3.dex */
public abstract class a extends c {
    @Override // w9.c
    public int b() {
        return d().nextInt();
    }

    @Override // w9.c
    public int c(int i10) {
        return d().nextInt(i10);
    }

    public abstract Random d();
}
