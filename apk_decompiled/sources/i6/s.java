package i6;

/* loaded from: classes3.dex */
public interface s extends l5.a {

    public static final class a {
        public static /* synthetic */ void a(s sVar, String str, x7.a aVar, String str2, String str3, boolean z10, String str4, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginThirdPart");
            }
            if ((i10 & 32) != 0) {
                str4 = null;
            }
            sVar.c(str, aVar, str2, str3, z10, str4);
        }
    }

    void c(String str, x7.a aVar, String str2, String str3, boolean z10, String str4);
}
