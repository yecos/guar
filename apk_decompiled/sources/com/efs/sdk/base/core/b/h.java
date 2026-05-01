package com.efs.sdk.base.core.b;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    static FileLock f6092b;

    /* renamed from: a, reason: collision with root package name */
    volatile int f6093a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f6096a = new h(0);
    }

    public /* synthetic */ h(byte b10) {
        this();
    }

    public final boolean a() {
        if (this.f6093a == 2) {
            return true;
        }
        if (this.f6093a != 0) {
            return false;
        }
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }

    private h() {
        this.f6093a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    private synchronized void a(final Context context) {
        Log.w("efs.send_log", "tryFileLock start! ");
        this.f6093a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.core.b.h.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock lock;
                try {
                    File a10 = com.efs.sdk.base.core.util.a.a(context);
                    if (!a10.exists()) {
                        a10.mkdirs();
                    }
                    File file = new File(a10.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        lock = new FileOutputStream(file).getChannel().lock();
                        h.f6092b = lock;
                    } while (!lock.isValid());
                    Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                    h.this.f6093a = 2;
                } catch (Exception e10) {
                    Log.w("efs.send_log", "tryFileLock fail! " + e10.getMessage());
                    h.this.f6093a = 0;
                }
            }
        }).start();
    }
}
