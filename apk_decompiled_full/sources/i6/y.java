package i6;

/* loaded from: classes3.dex */
public interface y extends l5.a {

    public static final class a {
        public static /* synthetic */ void a(y yVar, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMyFavList");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            yVar.d(z10);
        }
    }

    void d(boolean z10);
}
