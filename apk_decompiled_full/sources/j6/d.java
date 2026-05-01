package j6;

/* loaded from: classes3.dex */
public interface d extends m5.a {

    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
            }
            if ((i10 & 1) != 0) {
                str = "";
            }
            dVar.c(str);
        }
    }

    void c(String str);

    void onLoading();

    void s();
}
