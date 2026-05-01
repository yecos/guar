package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f6237a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f6237a)) {
            synchronized (c.class) {
                if (TextUtils.isEmpty(f6237a)) {
                    String b10 = b(context);
                    f6237a = b10;
                    if (TextUtils.isEmpty(b10)) {
                        f6237a = c(context);
                    }
                }
            }
        }
        return f6237a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return FileUtil.read(file);
            }
            return null;
        } catch (Exception e10) {
            Log.e("efs.base", "get uuid error", e10);
            return null;
        }
    }

    private static String c(Context context) {
        String str = "";
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                str = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        }
        try {
            File a10 = a.a(context);
            File file = new File(a10, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileUtil.write(file, str);
            if (file.renameTo(new File(a10, "efsid"))) {
                file.delete();
            }
        } catch (Exception e10) {
            Log.e("efs.base", "save uuid '" + str + "' error", e10);
        }
        return str;
    }
}
