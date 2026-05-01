package z6;

import android.content.Context;
import com.mobile.brasiltv.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class a {
    public static boolean a(Context context, String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str2));
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        j.a(fileOutputStream, inputStream);
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e11) {
                e = e11;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                j.a(fileOutputStream2, inputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                j.a(fileOutputStream2, inputStream);
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static void b(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                b(file2);
            }
        }
        file.delete();
    }
}
