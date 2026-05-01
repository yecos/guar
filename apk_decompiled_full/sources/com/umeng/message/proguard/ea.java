package com.umeng.message.proguard;

import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;

/* loaded from: classes3.dex */
public final class ea {
    private static void a(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static File a(String str) {
        String lowerCase = UMUtils.MD5(str).toLowerCase();
        File file = new File(de.a().getExternalFilesDir(null), "UMCache");
        a(file);
        return new File(file, lowerCase);
    }
}
