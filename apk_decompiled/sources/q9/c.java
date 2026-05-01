package q9;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.http.HTTP;
import h9.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import t9.i;

/* loaded from: classes3.dex */
public abstract class c extends b {
    public static final String a(File file, Charset charset) {
        i.g(file, "<this>");
        i.g(charset, HTTP.CHARSET);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String c10 = d.c(inputStreamReader);
            a.a(inputStreamReader, null);
            return c10;
        } finally {
        }
    }

    public static /* synthetic */ String b(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = ba.c.f5214b;
        }
        return a(file, charset);
    }

    public static final void c(File file, byte[] bArr) {
        i.g(file, "<this>");
        i.g(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            t tVar = t.f14242a;
            a.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void d(File file, String str, Charset charset) {
        i.g(file, "<this>");
        i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        i.g(charset, HTTP.CHARSET);
        byte[] bytes = str.getBytes(charset);
        i.f(bytes, "this as java.lang.String).getBytes(charset)");
        c(file, bytes);
    }

    public static /* synthetic */ void e(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = ba.c.f5214b;
        }
        d(file, str, charset);
    }
}
