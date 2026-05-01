package y8;

import com.google.common.io.BaseEncoding;
import java.nio.charset.Charset;
import y8.v0;

/* loaded from: classes3.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f19878a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    public static final BaseEncoding f19879b = v0.f20030f;

    public interface a extends v0.j {
    }

    public static int a(v0 v0Var) {
        return v0Var.h();
    }

    public static v0.g b(String str, a aVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return v0.g.g(str, z10, aVar);
    }

    public static v0 c(byte[]... bArr) {
        return new v0(bArr);
    }

    public static byte[][] d(v0 v0Var) {
        return v0Var.p();
    }
}
