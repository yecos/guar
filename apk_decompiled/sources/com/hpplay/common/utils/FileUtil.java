package com.hpplay.common.utils;

import android.os.StatFs;
import com.hpplay.common.log.LeLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void compress(java.util.zip.ZipOutputStream r8, java.io.BufferedOutputStream r9, java.io.File r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.compress(java.util.zip.ZipOutputStream, java.io.BufferedOutputStream, java.io.File, java.lang.String):void");
    }

    public static void deleteAllChildFile(File file) {
        String[] list;
        if (!file.isDirectory() || (list = file.list()) == null) {
            return;
        }
        for (String str : list) {
            deleteFile(new File(file, str));
        }
    }

    public static boolean deleteFile(String str) {
        return deleteFile(new File(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] file2Bytes(java.lang.String r4) {
        /*
            java.lang.String r0 = "file2String"
            java.lang.String r1 = "FileUtil"
            com.hpplay.common.log.LeLog.i(r1, r0)
            r0 = 0
            byte[] r0 = new byte[r0]
            java.io.File r2 = new java.io.File
            r2.<init>(r4)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L2a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " is not exist: "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.hpplay.common.log.LeLog.w(r1, r4)
            return r0
        L2a:
            r4 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4b
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3.read(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3.close()     // Catch: java.lang.Exception -> L3d
            goto L41
        L3d:
            r0 = move-exception
            com.hpplay.common.log.LeLog.w(r1, r0)
        L41:
            r0 = r4
            goto L5b
        L43:
            r4 = move-exception
            goto L5c
        L45:
            r4 = move-exception
            goto L4e
        L47:
            r0 = move-exception
            r3 = r4
            r4 = r0
            goto L5c
        L4b:
            r2 = move-exception
            r3 = r4
            r4 = r2
        L4e:
            com.hpplay.common.log.LeLog.w(r1, r4)     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto L5b
            r3.close()     // Catch: java.lang.Exception -> L57
            goto L5b
        L57:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r1, r4)
        L5b:
            return r0
        L5c:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Exception -> L62
            goto L66
        L62:
            r0 = move-exception
            com.hpplay.common.log.LeLog.w(r1, r0)
        L66:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.file2Bytes(java.lang.String):byte[]");
    }

    public static String file2String(String str) {
        FileInputStream fileInputStream;
        LeLog.i(TAG, "file2String");
        File file = new File(str);
        if (!file.exists()) {
            LeLog.w(TAG, str + " is not exist: ");
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Exception e10) {
                LeLog.w(TAG, e10);
            }
            return str2;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            LeLog.w(TAG, "read " + str + " failed");
            if (fileInputStream2 == null) {
                return "";
            }
            try {
                fileInputStream2.close();
                return "";
            } catch (Exception e11) {
                LeLog.w(TAG, e11);
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e12) {
                    LeLog.w(TAG, e12);
                }
            }
            throw th;
        }
    }

    public static long getAvailSize(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static void string2File(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(str2);
                    file.delete();
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                LeLog.w(TAG, "string2File failed," + str2);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e10) {
                        LeLog.w(TAG, e10);
                    }
                }
                throw th;
            }
        } catch (Exception e11) {
            LeLog.w(TAG, e11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0070 -> B:17:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zipFile(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "FileUtil"
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            java.util.zip.ZipOutputStream r5 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            compress(r5, r3, r1, r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r2.close()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r4)
        L2b:
            r3.close()     // Catch: java.lang.Exception -> L2f
            goto L33
        L2f:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r4)
        L33:
            r5.close()     // Catch: java.lang.Exception -> L6f
            goto L73
        L37:
            r4 = move-exception
            goto L44
        L39:
            r4 = move-exception
            goto L49
        L3b:
            r4 = move-exception
            r3 = r1
            goto L44
        L3e:
            r4 = move-exception
            r3 = r1
            goto L49
        L41:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L44:
            r1 = r2
            goto L75
        L46:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L49:
            r1 = r2
            goto L52
        L4b:
            r4 = move-exception
            r5 = r1
            r3 = r5
            goto L75
        L4f:
            r4 = move-exception
            r5 = r1
            r3 = r5
        L52:
            com.hpplay.common.log.LeLog.w(r0, r4)     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.lang.Exception -> L5b
            goto L5f
        L5b:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r4)
        L5f:
            if (r3 == 0) goto L69
            r3.close()     // Catch: java.lang.Exception -> L65
            goto L69
        L65:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r4)
        L69:
            if (r5 == 0) goto L73
            r5.close()     // Catch: java.lang.Exception -> L6f
            goto L73
        L6f:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r4)
        L73:
            return
        L74:
            r4 = move-exception
        L75:
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Exception -> L7b
            goto L7f
        L7b:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r1)
        L7f:
            if (r3 == 0) goto L89
            r3.close()     // Catch: java.lang.Exception -> L85
            goto L89
        L85:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r1)
        L89:
            if (r5 == 0) goto L93
            r5.close()     // Catch: java.lang.Exception -> L8f
            goto L93
        L8f:
            r5 = move-exception
            com.hpplay.common.log.LeLog.w(r0, r5)
        L93:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.FileUtil.zipFile(java.lang.String, java.lang.String):void");
    }

    public static boolean deleteFile(File file) {
        LeLog.i(TAG, "delete dir: " + file.getAbsolutePath());
        try {
            if (file.isDirectory()) {
                deleteAllChildFile(file);
            }
            return file.delete();
        } catch (Exception e10) {
            LeLog.i(TAG, "deleteFile:" + e10);
            return false;
        }
    }
}
