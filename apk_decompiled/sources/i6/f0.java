package i6;

/* loaded from: classes3.dex */
public interface f0 extends l5.a {

    public static final class a {
        public static /* synthetic */ void a(f0 f0Var, String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authProgram");
            }
            f0Var.a(str, str2, i10, str3, str4, z10, z11, (i11 & 128) != 0 ? false : z12, (i11 & 256) != 0 ? null : str5, (i11 & 512) != 0 ? null : iArr, (i11 & 1024) != 0 ? false : z13);
        }
    }

    void a(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13);
}
