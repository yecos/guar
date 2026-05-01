package s2;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {
    public static File[] a(File file, FileFilter fileFilter, int i10) {
        String[] list;
        if (!file.exists() || (list = file.list()) == null) {
            return null;
        }
        int min = Math.min(list.length, i10);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < min; i11++) {
            File file2 = new File(file, list[i11]);
            if (fileFilter == null || fileFilter.accept(file2)) {
                arrayList.add(file2);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static void b(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                b(file2);
            }
        }
        file.delete();
    }
}
