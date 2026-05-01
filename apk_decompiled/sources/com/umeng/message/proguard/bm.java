package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class bm {
    public static void a(String str) {
        a(str, null);
    }

    public static void a(String str, FileFilter fileFilter) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                LinkedList linkedList = new LinkedList();
                linkedList.push(file);
                while (!linkedList.isEmpty()) {
                    file = (File) linkedList.pop();
                    if (file.isDirectory()) {
                        if (file.isDirectory()) {
                            File[] listFiles = file.listFiles();
                            if (listFiles != null && listFiles.length != 0) {
                                for (File file2 : listFiles) {
                                    if (file2.isDirectory()) {
                                        linkedList.push(file2);
                                    } else if (fileFilter == null || fileFilter.accept(file2)) {
                                        file2.delete();
                                    }
                                }
                            } else if (fileFilter == null || fileFilter.accept(file)) {
                                file.delete();
                            }
                        }
                    } else if (fileFilter == null || fileFilter.accept(file)) {
                        file.delete();
                    }
                }
            }
            file.delete();
        }
    }
}
