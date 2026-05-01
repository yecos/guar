package com.efs.sdk.base.core.util;

import com.efs.sdk.base.core.model.LogDto;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class FileUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f6220a = new Random();

    public static void copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("efs.util.file", "error when copy", e);
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        safeClose(fileInputStream);
                        safeClose(fileOutputStream);
                        throw th;
                    }
                }
                safeClose(fileInputStream2);
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        safeClose(fileOutputStream);
    }

    public static LogDto createCodeLogDtoByName(String str) {
        String[] split = str.split("_");
        if (split.length != 11) {
            Log.w("efs.util.file", "[code log]File name error, name is ".concat(str));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        byte byteValue2 = Byte.valueOf(split[3]).byteValue();
        String str4 = split[7];
        String str5 = split[8];
        long longValue = Long.valueOf(split[9]).longValue();
        long longValue2 = Long.valueOf(split[10]).longValue();
        LogDto logDto = new LogDto(str2, byteValue2);
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        logDto.setUid(str4);
        logDto.setDid(str5);
        logDto.setBeginTime(longValue);
        logDto.setEndTime(longValue2);
        return logDto;
    }

    public static LogDto createLogDtoByName(String str) {
        String[] split = str.split("_");
        if (split.length != 7) {
            Log.w("efs.util.file", "File name error, name is ".concat(str));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        LogDto logDto = new LogDto(str2, Byte.valueOf(split[3]).byteValue());
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        return logDto;
    }

    public static void delete(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                delete(file2);
            }
        }
        file.delete();
    }

    public static String getCodelogFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append((int) logDto.getLogProtocol());
        sb.append("_");
        sb.append(ProcessUtil.myPid());
        sb.append("_");
        sb.append(f6220a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        sb.append("_");
        sb.append(logDto.getUid());
        sb.append("_");
        sb.append(logDto.getDid());
        sb.append("_");
        sb.append(logDto.getBeginTime());
        sb.append("_");
        sb.append(logDto.getEndTime());
        return sb.toString();
    }

    public static String getFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append((int) logDto.getLogProtocol());
        sb.append("_");
        sb.append(ProcessUtil.myPid());
        sb.append("_");
        sb.append(f6220a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        return sb.toString();
    }

    public static long getFolderSize(File file) {
        long j10 = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            j10 += getFolderSize(file2);
        }
        return j10;
    }

    public static List<File> listFiles(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
                Log.i("efs.util.file", "file is " + file2.getName());
            } else {
                arrayList.addAll(listFiles(file2));
            }
        }
        return arrayList;
    }

    public static void move(File file, File file2) {
        copy(file, file2);
        delete(file);
    }

    public static String read(File file) {
        return read(file, 1024);
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean write(String str, byte[] bArr) {
        return write(new File(str), bArr);
    }

    public static String read(File file, int i10) {
        FileInputStream fileInputStream;
        String str = "";
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[i10];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
            str = sb.toString();
            safeClose(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                Log.e("efs.util.file", "read file error", th);
                return str;
            } finally {
                safeClose(fileInputStream2);
            }
        }
        return str;
    }

    public static boolean write(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                safeClose(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    safeClose(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    safeClose(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean write(File file, String str) {
        return write(file, str.getBytes());
    }

    public static byte[] read(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            safeClose(fileInputStream);
        } catch (Exception e11) {
            e = e11;
            fileInputStream2 = fileInputStream;
            Log.e("efs.util.file", "read data error", e);
            safeClose(fileInputStream2);
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            safeClose(fileInputStream2);
            throw th;
        }
        return bArr;
    }
}
