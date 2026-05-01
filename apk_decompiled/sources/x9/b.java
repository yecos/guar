package x9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import t9.i;

/* loaded from: classes3.dex */
public final class b extends w9.a {
    @Override // w9.a
    public Random d() {
        ThreadLocalRandom current;
        current = ThreadLocalRandom.current();
        i.f(current, "current()");
        return current;
    }
}
