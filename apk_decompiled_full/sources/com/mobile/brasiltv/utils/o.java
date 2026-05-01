package com.mobile.brasiltv.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
    */
    public static boolean b(File file) {
        BufferedReader bufferedReader;
        if (!file.exists()) {
            return false;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                if (!TextUtils.equals("1", readLine)) {
                }
                j.a(bufferedReader);
                return true;
            }
            j.a(bufferedReader);
        } catch (Exception e11) {
            e = e11;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            j.a(bufferedReader2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            j.a(bufferedReader2);
            throw th;
        }
        return false;
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
