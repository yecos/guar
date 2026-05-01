package s7;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/* loaded from: classes3.dex */
public abstract class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Process] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        Closeable closeable;
        LineNumberReader lineNumberReader;
        IOException e10;
        Process process = null;
        try {
            try {
                str = Runtime.getRuntime().exec("getprop " + ((String) str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e11) {
            lineNumberReader = null;
            e10 = e11;
            str = 0;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            if (process != null) {
                process.destroy();
            }
            a.a(closeable);
            throw th;
        }
        try {
            lineNumberReader = new LineNumberReader(new InputStreamReader(str.getInputStream()));
            try {
                String readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    if (!TextUtils.isEmpty(readLine)) {
                        str.destroy();
                        a.a(lineNumberReader);
                        return readLine;
                    }
                }
                str.destroy();
                a.a(lineNumberReader);
                return str2;
            } catch (IOException e12) {
                e10 = e12;
                b.c("PropUtil", "Exception in getProp and exception info is " + e10.getLocalizedMessage());
                if (str != 0) {
                    str.destroy();
                }
                a.a(lineNumberReader);
                return str2;
            }
        } catch (IOException e13) {
            lineNumberReader = null;
            e10 = e13;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            process = str;
            if (process != null) {
            }
            a.a(closeable);
            throw th;
        }
    }
}
