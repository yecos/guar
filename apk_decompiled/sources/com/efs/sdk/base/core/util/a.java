package com.efs.sdk.base.core.util;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6224a = "efs";

    /* renamed from: b, reason: collision with root package name */
    private static File f6225b;

    public static void a(String str) {
        f6224a = str;
    }

    public static File b(Context context, String str) {
        return new File(j(context, str), "efs_config");
    }

    public static File c(Context context, String str) {
        return new File(j(context, str), "efs_flow");
    }

    public static File d(Context context, String str) {
        File file = new File(j(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File e(Context context, String str) {
        File file = new File(j(context, str), "ready_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(d(context, str), String.valueOf(ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g(Context context, String str) {
        File file = new File(e(context, str), String.valueOf(ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File h(Context context, String str) {
        File file = new File(j(context, str), "upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File i(Context context, String str) {
        File file = new File(j(context, str), "upload_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File j(Context context, String str) {
        if (f6225b == null) {
            synchronized (a.class) {
                if (f6225b == null) {
                    f6225b = a(context);
                }
            }
        }
        File file = new File(f6225b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File a(Context context) {
        File dir = context.getDir(f6224a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File a(Context context, String str) {
        return new File(j(context, str), "efs_cst");
    }
}
