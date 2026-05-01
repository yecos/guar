package kotlinx.coroutines.scheduling;

/* loaded from: classes3.dex */
public final class c extends f {

    /* renamed from: i, reason: collision with root package name */
    public static final c f15809i = new c();

    public c() {
        super(l.f15821b, l.f15822c, l.f15823d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ca.y
    public String toString() {
        return "Dispatchers.Default";
    }
}
