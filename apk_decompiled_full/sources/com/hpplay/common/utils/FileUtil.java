package com.hpplay.common.utils;

import android.os.StatFs;
import com.hpplay.common.log.LeLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes2.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void compress(ZipOutputStream zipOutputStream, BufferedOutputStream bufferedOutputStream, File file, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles.length == 0) {
                        zipOutputStream.putNextEntry(new ZipEntry(str + Operator.Operation.DIVISION));
                    } else {
                        for (int i10 = 0; i10 < listFiles.length; i10++) {
                            compress(zipOutputStream, bufferedOutputStream, listFiles[i10], str + Operator.Operation.DIVISION + listFiles[i10].getName());
                        }
                    }
                    fileInputStream2 = null;
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(str));
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);
                        while (true) {
                            try {
                                int read = bufferedInputStream2.read();
                                if (read == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(read);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                bufferedInputStream = bufferedInputStream2;
                                Exception exc = e;
                                fileInputStream = fileInputStream2;
                                e = exc;
                                try {
                                    LeLog.w(TAG, e);
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e11) {
                                            LeLog.w(TAG, e11);
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e12) {
                                            LeLog.w(TAG, e12);
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        throw th;
                                    }
                                    try {
                                        fileInputStream.close();
                                        throw th;
                                    } catch (Exception e13) {
                                        LeLog.w(TAG, e13);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream2;
                                Throwable th3 = th;
                                fileInputStream = fileInputStream2;
                                th = th3;
                                if (bufferedInputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                            }
                        }
                        bufferedInputStream = bufferedInputStream2;
                    } catch (Exception e14) {
                        e = e14;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e15) {
                        LeLog.w(TAG, e15);
                    }
                }
            } catch (Exception e16) {
                LeLog.w(TAG, e16);
                return;
            }
        } catch (Exception e17) {
            e = e17;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        if (fileInputStream2 != null) {
            fileInputStream2.close();
        }
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
    */
    public static byte[] file2Bytes(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e10;
        LeLog.i(TAG, "file2String");
        byte[] bArr = new byte[0];
        File file = new File(str);
        ?? exists = file.exists();
        if (exists == 0) {
            LeLog.w(TAG, str + " is not exist: ");
            return bArr;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    try {
                        fileInputStream.close();
                    } catch (Exception e11) {
                        LeLog.w(TAG, e11);
                    }
                    bArr = bArr2;
                    exists = fileInputStream;
                } catch (Exception e12) {
                    e10 = e12;
                    LeLog.w(TAG, e10);
                    exists = fileInputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            exists = fileInputStream;
                        } catch (Exception e13) {
                            LeLog.w(TAG, e13);
                            exists = fileInputStream;
                        }
                    }
                    return bArr;
                }
            } catch (Throwable th2) {
                th = th2;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (Exception e14) {
                        LeLog.w(TAG, e14);
                    }
                }
                throw th;
            }
        } catch (Exception e15) {
            fileInputStream = null;
            e10 = e15;
        } catch (Throwable th3) {
            exists = 0;
            th = th3;
            if (exists != 0) {
            }
            throw th;
        }
        return bArr;
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
    */
    public static void zipFile(String str, String str2) {
        ZipOutputStream zipOutputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
                try {
                    zipOutputStream = new ZipOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
                    } catch (Exception e10) {
                        e = e10;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                    }
                } catch (Exception e11) {
                    e = e11;
                    zipOutputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    zipOutputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Exception e12) {
                LeLog.w(TAG, e12);
            }
        } catch (Exception e13) {
            e = e13;
            zipOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            File file = new File(str);
            compress(zipOutputStream, bufferedOutputStream, file, file.getName());
            try {
                fileOutputStream.close();
            } catch (Exception e14) {
                LeLog.w(TAG, e14);
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e15) {
                LeLog.w(TAG, e15);
            }
            zipOutputStream.close();
        } catch (Exception e16) {
            e = e16;
            fileOutputStream2 = fileOutputStream;
            try {
                LeLog.w(TAG, e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e17) {
                        LeLog.w(TAG, e17);
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e18) {
                        LeLog.w(TAG, e18);
                    }
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e19) {
                        LeLog.w(TAG, e19);
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e20) {
                        LeLog.w(TAG, e20);
                    }
                }
                if (zipOutputStream != null) {
                    throw th;
                }
                try {
                    zipOutputStream.close();
                    throw th;
                } catch (Exception e21) {
                    LeLog.w(TAG, e21);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (bufferedOutputStream != null) {
            }
            if (zipOutputStream != null) {
            }
        }
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
