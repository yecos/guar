package com.core.sysopt.so;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class SoOptimizer {
    private static final String TAG = "SoOptimizer";
    private static Application sApplication;

    public static void bindApplication(Application application) {
        sApplication = application;
    }

    public static void reloadLibrary(String str) {
        ApplicationInfo applicationInfo;
        Application application = sApplication;
        if (application == null || (applicationInfo = application.getApplicationInfo()) == null) {
            return;
        }
        String str2 = applicationInfo.nativeLibraryDir;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length <= 0) {
                return;
            }
            String format = String.format("lib%s.so", str);
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(format)) {
                    Runtime.getRuntime().load(file2.getAbsolutePath());
                    StringBuilder sb = new StringBuilder();
                    sb.append("reload library(");
                    sb.append(format);
                    sb.append(") success.");
                    return;
                }
            }
        }
    }
}
