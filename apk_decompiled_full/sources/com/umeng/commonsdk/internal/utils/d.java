package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class d {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10947a;

        /* renamed from: b, reason: collision with root package name */
        public String f10948b;

        /* renamed from: c, reason: collision with root package name */
        public int f10949c;

        /* renamed from: d, reason: collision with root package name */
        public String f10950d;

        /* renamed from: e, reason: collision with root package name */
        public String f10951e;

        /* renamed from: f, reason: collision with root package name */
        public String f10952f;

        /* renamed from: g, reason: collision with root package name */
        public String f10953g;

        /* renamed from: h, reason: collision with root package name */
        public String f10954h;

        /* renamed from: i, reason: collision with root package name */
        public String f10955i;

        /* renamed from: j, reason: collision with root package name */
        public String f10956j;

        /* renamed from: k, reason: collision with root package name */
        public String f10957k;

        /* renamed from: l, reason: collision with root package name */
        public String f10958l;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a() {
        a aVar;
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        int i10;
        FileReader fileReader2 = null;
        int i11 = 0;
        try {
            try {
                aVar = new a();
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
                bufferedReader = null;
            }
            try {
                fileReader = new FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        try {
                            int i12 = 0;
                            boolean z10 = true;
                            i10 = 0;
                            for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine) && (i12 = i12 + 1) < 30; readLine = bufferedReader.readLine()) {
                                try {
                                    String[] split = readLine.split(":\\s+", 2);
                                    if (z10 && split != null && split.length > 1) {
                                        aVar.f10947a = split[1];
                                        z10 = false;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("processor")) {
                                        i10++;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Features")) {
                                        aVar.f10950d = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.f10951e = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("architecture")) {
                                        aVar.f10952f = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("variant")) {
                                        aVar.f10953g = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("part")) {
                                        aVar.f10954h = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("revision")) {
                                        aVar.f10955i = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Hardware")) {
                                        aVar.f10956j = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Revision")) {
                                        aVar.f10957k = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Serial")) {
                                        aVar.f10958l = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.f10951e = split[1];
                                    }
                                } catch (Exception unused) {
                                    fileReader2 = fileReader;
                                    i11 = i10;
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    i10 = i11;
                                    aVar.f10949c = i10;
                                    return aVar;
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        } catch (Exception unused6) {
                            fileReader2 = fileReader;
                            if (fileReader2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            i10 = i11;
                            aVar.f10949c = i10;
                            return aVar;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (bufferedReader != null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (IOException unused8) {
                            throw th;
                        }
                    }
                } catch (Exception unused9) {
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    th = th;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                }
            } catch (Exception unused10) {
                bufferedReader = null;
            }
        } catch (Exception unused11) {
            aVar = null;
            bufferedReader = null;
        }
        aVar.f10949c = i10;
        return aVar;
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return trim;
                } catch (Throwable unused) {
                    return trim;
                }
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
