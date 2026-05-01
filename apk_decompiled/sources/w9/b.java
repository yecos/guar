package w9;

import java.util.Random;
import t9.i;

/* loaded from: classes3.dex */
public final class b extends w9.a {

    /* renamed from: c, reason: collision with root package name */
    public final a f19266c = new a();

    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // w9.a
    public Random d() {
        Object obj = this.f19266c.get();
        i.f(obj, "implStorage.get()");
        return (Random) obj;
    }
}
