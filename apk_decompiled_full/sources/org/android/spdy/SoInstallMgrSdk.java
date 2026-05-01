package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.hpplay.common.utils.ContextPath;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext;

    private static String _cpuType() {
        String _getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (_getFieldReflectively == null || _getFieldReflectively.length() == 0 || _getFieldReflectively.equals("Unknown")) {
            _getFieldReflectively = ARMEABI;
        }
        return _getFieldReflectively.toLowerCase();
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static boolean _loadUnzipSo(String str, int i10, ClassLoader classLoader) {
        try {
            if (isExist(str, i10)) {
                if (classLoader == null) {
                    System.load(_targetSoFile(str, i10));
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    Method declaredMethod = Runtime.class.getDeclaredMethod("load", String.class, ClassLoader.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(runtime, _targetSoFile(str, i10), classLoader);
                }
            }
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e11) {
            e11.printStackTrace();
            return false;
        } catch (Error e12) {
            e12.printStackTrace();
            return false;
        }
    }

    public static String _targetSoFile(String str, int i10) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        String str2 = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getPath();
        }
        return str2 + "/lib" + str + "bk" + i10 + ".so";
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i10) {
        return initSo(str, i10, null);
    }

    public static boolean isExist(String str, int i10) {
        return new File(_targetSoFile(str, i10)).exists();
    }

    public static void removeSoIfExit(String str, int i10) {
        File file = new File(_targetSoFile(str, i10));
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean unZipSelectedFiles(String str, int i10, ClassLoader classLoader) {
        Context context;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        String str2 = "lib/armeabi/lib" + str + ".so";
        try {
            context = mContext;
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (context == null) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (!name.contains("..") && !name.contains("\\") && !name.contains(Operator.Operation.MOD)) {
                if (nextElement.getName().startsWith(str2)) {
                    InputStream inputStream = null;
                    FileChannel fileChannel2 = null;
                    try {
                        removeSoIfExit(str, i10);
                        InputStream inputStream2 = zipFile.getInputStream(nextElement);
                        try {
                            fileOutputStream = context.openFileOutput(ContextPath.LIB + str + "bk" + i10 + ".so", 0);
                            try {
                                fileChannel2 = fileOutputStream.getChannel();
                                byte[] bArr = new byte[1024];
                                int i11 = 0;
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    if (read > 0) {
                                        fileChannel2.write(ByteBuffer.wrap(bArr, 0, read));
                                        i11 += read;
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                inputStream2.close();
                                if (fileChannel2 != null) {
                                    try {
                                        fileChannel2.close();
                                    } catch (Exception e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                }
                                zipFile.close();
                                if (i11 > 0) {
                                    return _loadUnzipSo(str, i10, classLoader);
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileChannel = fileChannel2;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e14) {
                                        e14.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e15) {
                                        e15.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                }
                                zipFile.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileChannel = null;
                        fileOutputStream = null;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean initSo(String str, int i10, ClassLoader classLoader) {
        boolean z10 = true;
        try {
            if (classLoader == null) {
                System.loadLibrary(str);
            } else {
                Runtime runtime = Runtime.getRuntime();
                Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(runtime, str, classLoader);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            z10 = false;
            if (!z10) {
            }
            return z10;
        } catch (UnsatisfiedLinkError e11) {
            e11.printStackTrace();
            z10 = false;
            if (!z10) {
            }
            return z10;
        } catch (Error e12) {
            e12.printStackTrace();
            z10 = false;
            if (!z10) {
            }
            return z10;
        }
        if (!z10) {
            try {
                if (isExist(str, i10)) {
                    boolean _loadUnzipSo = _loadUnzipSo(str, i10, classLoader);
                    if (_loadUnzipSo) {
                        return _loadUnzipSo;
                    }
                    removeSoIfExit(str, i10);
                }
                String _cpuType = _cpuType();
                if (!_cpuType.equalsIgnoreCase(MIPS) && !_cpuType.equalsIgnoreCase(X86)) {
                    try {
                        return unZipSelectedFiles(str, i10, classLoader);
                    } catch (ZipException e13) {
                        e13.printStackTrace();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
            } catch (Error e15) {
                e15.printStackTrace();
                return false;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            } catch (UnsatisfiedLinkError e17) {
                e17.printStackTrace();
                return false;
            }
        }
        return z10;
    }
}
