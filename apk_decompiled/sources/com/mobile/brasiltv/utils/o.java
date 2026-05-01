package com.mobile.brasiltv.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8735a = {"sh", "-c", "cd /sys && find . -name state"};

    public static boolean a(Context context) {
        Object systemService;
        AudioDeviceInfo[] devices;
        int type;
        int type2;
        if (Build.VERSION.SDK_INT < 23 || (systemService = context.getSystemService("audio")) == null) {
            return false;
        }
        devices = ((AudioManager) systemService).getDevices(2);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            type = audioDeviceInfo.getType();
            if (type == 9) {
                return true;
            }
            type2 = audioDeviceInfo.getType();
            if (type2 == 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (android.text.TextUtils.equals("hdmi=1", r6.toLowerCase()) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.io.File r6) {
        /*
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 1
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r6 = r3.readLine()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r2 != 0) goto L3f
            java.lang.String r2 = "1"
            boolean r2 = android.text.TextUtils.equals(r2, r6)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r2 != 0) goto L37
            java.lang.String r2 = "hdmi=1"
            java.lang.String r6 = r6.toLowerCase()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            boolean r6 = android.text.TextUtils.equals(r2, r6)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r6 == 0) goto L3f
        L37:
            java.io.Closeable[] r6 = new java.io.Closeable[r0]
            r6[r1] = r3
            com.mobile.brasiltv.utils.j.a(r6)
            return r0
        L3f:
            java.io.Closeable[] r6 = new java.io.Closeable[r0]
            r6[r1] = r3
            com.mobile.brasiltv.utils.j.a(r6)
            goto L5a
        L47:
            r6 = move-exception
            r2 = r3
            goto L5b
        L4a:
            r6 = move-exception
            r2 = r3
            goto L50
        L4d:
            r6 = move-exception
            goto L5b
        L4f:
            r6 = move-exception
        L50:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            java.io.Closeable[] r6 = new java.io.Closeable[r0]
            r6[r1] = r2
            com.mobile.brasiltv.utils.j.a(r6)
        L5a:
            return r1
        L5b:
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r0[r1] = r2
            com.mobile.brasiltv.utils.j.a(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.o.b(java.io.File):boolean");
    }

    public static boolean c(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        IOException e10;
        if (a(context) || d(context)) {
            return true;
        }
        File file = new File("/sys/devices/virtual/switch/hdmi/state");
        if (!file.exists()) {
            file = new File("/sys/class/switch/hdmi/state");
        }
        if (file.exists() && b(file)) {
            return true;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(f8735a).getInputStream()));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            j.a(bufferedReader);
                            break;
                        }
                        if (readLine.endsWith("/hdmi/state")) {
                            if (b(new File("/sys/" + readLine))) {
                                j.a(bufferedReader);
                                return true;
                            }
                        }
                    } catch (IOException e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        j.a(bufferedReader);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j.a(bufferedReader);
                    throw th;
                }
            }
        } catch (IOException e12) {
            bufferedReader = null;
            e10 = e12;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            j.a(bufferedReader);
            throw th;
        }
        return false;
    }

    public static boolean d(Context context) {
        Object systemService = context.getSystemService("uimode");
        return systemService != null && ((UiModeManager) systemService).getCurrentModeType() == 4;
    }
}
