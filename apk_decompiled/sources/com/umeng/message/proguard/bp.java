package com.umeng.message.proguard;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(java.io.Serializable r8, java.io.File r9) {
        /*
            java.lang.Class<com.umeng.message.proguard.bp> r0 = com.umeng.message.proguard.bp.class
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L91
            if (r9 != 0) goto Lb
            goto L91
        Lb:
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9e
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.lang.String r5 = "u_push_"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.util.UUID r5 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            r4.append(r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.io.File r5 = com.umeng.message.proguard.bp.f11658a     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            if (r5 != 0) goto L3b
            android.app.Application r5 = com.umeng.message.proguard.y.a()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.io.File r5 = r5.getCacheDir()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            com.umeng.message.proguard.bp.f11658a = r5     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
        L3b:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            java.io.File r6 = com.umeng.message.proguard.bp.f11658a     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            r5.<init>(r6, r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L77
            r5.createNewFile()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L6e
            r5.setReadable(r2)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L6e
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L6e
            r4.<init>(r5)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L6e
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L79
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L79
            r7.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L79
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L79
            r6.writeObject(r8)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r6.flush()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            com.umeng.message.proguard.f.a(r6)     // Catch: java.lang.Throwable -> L9e
            com.umeng.message.proguard.f.a(r4)     // Catch: java.lang.Throwable -> L9e
            r1 = 1
            goto L7f
        L65:
            r8 = move-exception
            r3 = r6
            goto L70
        L68:
            r3 = r6
            goto L79
        L6a:
            r8 = move-exception
            goto L70
        L6c:
            r4 = r3
            goto L79
        L6e:
            r8 = move-exception
            r4 = r3
        L70:
            com.umeng.message.proguard.f.a(r3)     // Catch: java.lang.Throwable -> L9e
            com.umeng.message.proguard.f.a(r4)     // Catch: java.lang.Throwable -> L9e
            throw r8     // Catch: java.lang.Throwable -> L9e
        L77:
            r4 = r3
            r5 = r4
        L79:
            com.umeng.message.proguard.f.a(r3)     // Catch: java.lang.Throwable -> L9e
            com.umeng.message.proguard.f.a(r4)     // Catch: java.lang.Throwable -> L9e
        L7f:
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto L87
            r5.renameTo(r9)     // Catch: java.lang.Throwable -> L9e
        L87:
            if (r5 == 0) goto L8f
            r5.delete()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9e
            goto L8f
        L8d:
            monitor-exit(r0)
            return
        L8f:
            monitor-exit(r0)
            return
        L91:
            java.lang.String r8 = "SerializeUtils"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = "parameter invalid"
            r9[r1] = r2     // Catch: java.lang.Throwable -> L9e
            com.umeng.message.common.UPLog.e(r8, r9)     // Catch: java.lang.Throwable -> L9e
            monitor-exit(r0)
            return
        L9e:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.bp.a(java.io.Serializable, java.io.File):void");
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
