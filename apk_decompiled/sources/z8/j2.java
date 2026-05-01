package z8;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface j2 {

    /* renamed from: a, reason: collision with root package name */
    public static final j2 f20666a = new a();

    public class a implements j2 {
        @Override // z8.j2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
