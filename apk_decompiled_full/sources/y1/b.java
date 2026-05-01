package y1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import t9.i;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f19720a = new b();

    public final boolean a(InputStream inputStream, File file) {
        i.g(inputStream, "ins");
        i.g(file, "file");
        return e(inputStream, file, 8192);
    }

    public final void b(File file) {
        i.g(file, "file");
        if (file.exists()) {
            file.delete();
        }
    }

    public final void c(String str) {
        i.g(str, "filePath");
        b(new File(str));
    }

    public final void d(String str) {
        i.g(str, "filePath");
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    public final boolean e(InputStream inputStream, File file, int i10) {
        i.g(inputStream, "ins");
        i.g(file, "file");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            try {
                byte[] bArr = new byte[i10];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        r1.d dVar = r1.d.f18326a;
                        dVar.a(inputStream);
                        dVar.a(fileOutputStream);
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                r1.d dVar2 = r1.d.f18326a;
                dVar2.a(inputStream);
                dVar2.a(fileOutputStream);
                return false;
            }
        } catch (Throwable th) {
            r1.d dVar3 = r1.d.f18326a;
            dVar3.a(inputStream);
            dVar3.a(fileOutputStream);
            throw th;
        }
    }
}
