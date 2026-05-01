package com.umeng.message.proguard;

import android.content.Context;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.message.common.UPLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class bp {

    /* renamed from: a, reason: collision with root package name */
    private static File f11658a;

    public static File a(Context context) {
        return new File(context.getFilesDir(), "umeng_push_notify");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #8 {, blocks: (B:7:0x000b, B:21:0x005d, B:22:0x007f, B:24:0x0084, B:30:0x0089, B:39:0x0070, B:40:0x0076, B:36:0x0079, B:50:0x0091), top: B:4:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Serializable serializable, File file) {
        FileOutputStream fileOutputStream;
        File file2;
        synchronized (bp.class) {
            boolean z10 = false;
            if (serializable == null || file == null) {
                UPLog.e("SerializeUtils", "parameter invalid");
                return;
            }
            System.currentTimeMillis();
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    String str = "u_push_" + UUID.randomUUID().toString().replace(Operator.Operation.MINUS, "");
                    if (f11658a == null) {
                        f11658a = y.a().getCacheDir();
                    }
                    file2 = new File(f11658a, str);
                    try {
                        file2.createNewFile();
                        file2.setReadable(true);
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                            try {
                                objectOutputStream2.writeObject(serializable);
                                objectOutputStream2.flush();
                                f.a(objectOutputStream2);
                                f.a(fileOutputStream);
                                z10 = true;
                            } catch (Exception unused) {
                                objectOutputStream = objectOutputStream2;
                                f.a(objectOutputStream);
                                f.a(fileOutputStream);
                                System.currentTimeMillis();
                                if (z10) {
                                }
                                if (file2 != null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                f.a(objectOutputStream);
                                f.a(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused3) {
                        fileOutputStream = null;
                    }
                } catch (Exception unused4) {
                    fileOutputStream = null;
                    file2 = null;
                }
                System.currentTimeMillis();
                if (z10) {
                    file2.renameTo(file);
                }
                if (file2 != null) {
                    try {
                        file2.delete();
                    } catch (Exception unused5) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
    }

    public static synchronized <T> T a(File file) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        synchronized (bp.class) {
            T t10 = null;
            try {
            } catch (Throwable unused) {
                objectInputStream = null;
                fileInputStream = null;
            }
            if (!file.exists()) {
                f.a((Closeable) null);
                f.a((Closeable) null);
                return null;
            }
            System.currentTimeMillis();
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                try {
                    t10 = (T) objectInputStream.readObject();
                    f.a(objectInputStream);
                } catch (Throwable unused2) {
                    f.a(objectInputStream);
                    f.a(fileInputStream);
                    return t10;
                }
            } catch (Throwable unused3) {
                objectInputStream = null;
            }
            f.a(fileInputStream);
            return t10;
        }
    }
}
