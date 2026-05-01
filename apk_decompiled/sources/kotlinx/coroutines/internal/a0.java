package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f15724a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f15724a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
