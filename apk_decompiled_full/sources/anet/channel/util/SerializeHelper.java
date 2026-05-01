package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes.dex */
public class SerializeHelper {
    private static final String TAG = "awcn.SerializeHelper";
    private static File cacheDir;

    public static File getCacheFiles(String str) {
        Context context;
        if (cacheDir == null && (context = GlobalAppRuntimeInfo.getContext()) != null) {
            cacheDir = context.getCacheDir();
        }
        return new File(cacheDir, str);
    }

    public static synchronized void persist(Serializable serializable, File file) {
        synchronized (SerializeHelper.class) {
            persist(serializable, file, null);
        }
    }

    public static synchronized <T> T restore(File file) {
        T t10;
        synchronized (SerializeHelper.class) {
            t10 = (T) restore(file, null);
        }
        return t10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ae, code lost:
    
        if (r4 != null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized <T> T restore(File file, StrategyStatObject strategyStatObject) {
        FileInputStream fileInputStream;
        T t10;
        synchronized (SerializeHelper.class) {
            if (strategyStatObject != null) {
                strategyStatObject.readStrategyFilePath = String.valueOf(file);
            }
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                t10 = null;
            }
            if (!file.exists()) {
                if (ALog.isPrintLog(3)) {
                    ALog.w(TAG, "file not exist.", null, "file", file.getName());
                }
                return null;
            }
            if (strategyStatObject != null) {
                strategyStatObject.isFileExists = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                t10 = (T) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (strategyStatObject != null) {
                        strategyStatObject.isReadObjectSucceed = 1;
                        strategyStatObject.readCostTime = currentTimeMillis2;
                    }
                    ALog.i(TAG, "restore end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis2));
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (ALog.isPrintLog(3)) {
                            ALog.w(TAG, "restore file fail.", null, th, new Object[0]);
                        }
                        if (strategyStatObject != null) {
                            strategyStatObject.appendErrorTrace("SerializeHelper.restore()", th);
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                t10 = null;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return t10;
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0102: MOVE (r4 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:67:0x0102 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: all -> 0x0114, TryCatch #6 {, blocks: (B:7:0x0011, B:18:0x0049, B:20:0x0079, B:22:0x0080, B:25:0x0091, B:28:0x0097, B:30:0x009d, B:34:0x00dd, B:37:0x00e3, B:46:0x00f2, B:48:0x00f6, B:49:0x00cd, B:60:0x0075, B:71:0x0105, B:69:0x0108, B:77:0x0109), top: B:4:0x000b, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[Catch: all -> 0x0114, TryCatch #6 {, blocks: (B:7:0x0011, B:18:0x0049, B:20:0x0079, B:22:0x0080, B:25:0x0091, B:28:0x0097, B:30:0x009d, B:34:0x00dd, B:37:0x00e3, B:46:0x00f2, B:48:0x00f6, B:49:0x00cd, B:60:0x0075, B:71:0x0105, B:69:0x0108, B:77:0x0109), top: B:4:0x000b, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void persist(Serializable serializable, File file, StrategyStatObject strategyStatObject) {
        File file2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        boolean z10;
        boolean z11;
        synchronized (SerializeHelper.class) {
            FileOutputStream fileOutputStream3 = null;
            if (serializable != null && file != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i10 = 1;
                try {
                    try {
                        try {
                            file2 = getCacheFiles(UUID.randomUUID().toString().replace(Operator.Operation.MINUS, ""));
                            try {
                                file2.createNewFile();
                                file2.setReadable(true);
                                fileOutputStream = new FileOutputStream(file2);
                            } catch (Exception e10) {
                                e = e10;
                                fileOutputStream = null;
                            }
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                                objectOutputStream.writeObject(serializable);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                                z10 = true;
                            } catch (Exception e11) {
                                e = e11;
                                ALog.e(TAG, "persist fail. ", null, e, "file", file.getName());
                                if (strategyStatObject != null) {
                                    strategyStatObject.appendErrorTrace("SerializeHelper.persist()", e);
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                z10 = false;
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (strategyStatObject != null) {
                                }
                                if (z10) {
                                }
                                if (z10) {
                                }
                                try {
                                    file2.delete();
                                } catch (Exception unused3) {
                                    ALog.e(TAG, "delete failed.", null, new Object[0]);
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream3 = fileOutputStream2;
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream3 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    file2 = null;
                    fileOutputStream = null;
                }
                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                if (strategyStatObject != null) {
                    strategyStatObject.writeTempFilePath = String.valueOf(file2);
                    strategyStatObject.writeStrategyFilePath = String.valueOf(file);
                    strategyStatObject.isTempWriteSucceed = z10 ? 1 : 0;
                    strategyStatObject.writeCostTime = currentTimeMillis22;
                }
                if (z10) {
                    z11 = false;
                } else {
                    z11 = file2.renameTo(file);
                    if (z11) {
                        ALog.i(TAG, "persist end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis22));
                    } else {
                        ALog.e(TAG, "rename failed.", null, new Object[0]);
                    }
                    if (strategyStatObject != null) {
                        strategyStatObject.isRenameSucceed = z11 ? 1 : 0;
                        if (!z11) {
                            i10 = 0;
                        }
                        strategyStatObject.isSucceed = i10;
                        AppMonitor.getInstance().commitStat(strategyStatObject);
                    }
                }
                if (z10 || !z11) {
                    file2.delete();
                }
                return;
            }
            ALog.e(TAG, "persist fail. Invalid parameter", null, new Object[0]);
        }
    }
}
