package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        String memoryStat;
        if (Build.VERSION.SDK_INT < 23) {
            return 0L;
        }
        memoryStat = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (TextUtils.isEmpty(memoryStat)) {
                return 0L;
            }
            return Long.parseLong(memoryStat);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r5 = java.lang.Long.parseLong(r8.group());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        BufferedReader bufferedReader;
        long j10;
        long j11 = -1;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/status")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String[] split = sb.toString().trim().split("\n");
                int length = split.length;
                int length2 = split.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        j10 = -1;
                        break;
                    }
                    String str = split[i10];
                    if (str.startsWith("VmSize")) {
                        Matcher matcher = Pattern.compile("\\d+").matcher(str);
                        if (matcher.find()) {
                            break;
                        }
                    }
                    i10++;
                }
                if (j10 == -1 && length > 12) {
                    try {
                        Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
                        if (matcher2.find()) {
                            j10 = Long.parseLong(matcher2.group());
                        }
                    } catch (Throwable unused) {
                        j11 = j10;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return j11;
                    }
                }
                try {
                    bufferedReader.close();
                    return j10;
                } catch (Throwable unused3) {
                    return j10;
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
