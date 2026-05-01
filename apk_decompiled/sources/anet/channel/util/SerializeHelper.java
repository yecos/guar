package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import java.io.File;
import java.io.Serializable;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized <T> T restore(java.io.File r14, anet.channel.statist.StrategyStatObject r15) {
        /*
            java.lang.Class<anet.channel.util.SerializeHelper> r0 = anet.channel.util.SerializeHelper.class
            monitor-enter(r0)
            if (r15 == 0) goto Lf
            java.lang.String r1 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Lc
            r15.readStrategyFilePath = r1     // Catch: java.lang.Throwable -> Lc
            goto Lf
        Lc:
            r14 = move-exception
            goto Lba
        Lf:
            r1 = 0
            r2 = 3
            r3 = 0
            boolean r4 = r14.exists()     // Catch: java.lang.Throwable -> L95
            r5 = 2
            r6 = 1
            if (r4 != 0) goto L35
            boolean r4 = anet.channel.util.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L95
            if (r4 == 0) goto L33
            java.lang.String r4 = "awcn.SerializeHelper"
            java.lang.String r7 = "file not exist."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "file"
            r5[r1] = r8     // Catch: java.lang.Throwable -> L95
            java.lang.String r14 = r14.getName()     // Catch: java.lang.Throwable -> L95
            r5[r6] = r14     // Catch: java.lang.Throwable -> L95
            anet.channel.util.ALog.w(r4, r7, r3, r5)     // Catch: java.lang.Throwable -> L95
        L33:
            monitor-exit(r0)
            return r3
        L35:
            if (r15 == 0) goto L39
            r15.isFileExists = r6     // Catch: java.lang.Throwable -> L95
        L39:
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L95
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L95
            r4.<init>(r14)     // Catch: java.lang.Throwable -> L95
            java.io.ObjectInputStream r9 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L92
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L92
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L92
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r10 = r9.readObject()     // Catch: java.lang.Throwable -> L92
            r9.close()     // Catch: java.lang.Throwable -> L90
            long r11 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L90
            long r11 = r11 - r7
            if (r15 == 0) goto L5e
            r15.isReadObjectSucceed = r6     // Catch: java.lang.Throwable -> L90
            r15.readCostTime = r11     // Catch: java.lang.Throwable -> L90
        L5e:
            java.lang.String r7 = "awcn.SerializeHelper"
            java.lang.String r8 = "restore end."
            r9 = 6
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L90
            java.lang.String r13 = "file"
            r9[r1] = r13     // Catch: java.lang.Throwable -> L90
            java.io.File r13 = r14.getAbsoluteFile()     // Catch: java.lang.Throwable -> L90
            r9[r6] = r13     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = "size"
            r9[r5] = r6     // Catch: java.lang.Throwable -> L90
            long r5 = r14.length()     // Catch: java.lang.Throwable -> L90
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L90
            r9[r2] = r14     // Catch: java.lang.Throwable -> L90
            java.lang.String r14 = "cost"
            r5 = 4
            r9[r5] = r14     // Catch: java.lang.Throwable -> L90
            java.lang.Long r14 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L90
            r5 = 5
            r9[r5] = r14     // Catch: java.lang.Throwable -> L90
            anet.channel.util.ALog.i(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L90
        L8c:
            r4.close()     // Catch: java.lang.Throwable -> Lc java.io.IOException -> Lb1
            goto Lb1
        L90:
            r14 = move-exception
            goto L98
        L92:
            r14 = move-exception
            r10 = r3
            goto L98
        L95:
            r14 = move-exception
            r4 = r3
            r10 = r4
        L98:
            boolean r2 = anet.channel.util.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto La7
            java.lang.String r2 = "awcn.SerializeHelper"
            java.lang.String r5 = "restore file fail."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb3
            anet.channel.util.ALog.w(r2, r5, r3, r14, r1)     // Catch: java.lang.Throwable -> Lb3
        La7:
            if (r15 == 0) goto Lae
            java.lang.String r1 = "SerializeHelper.restore()"
            r15.appendErrorTrace(r1, r14)     // Catch: java.lang.Throwable -> Lb3
        Lae:
            if (r4 == 0) goto Lb1
            goto L8c
        Lb1:
            monitor-exit(r0)
            return r10
        Lb3:
            r14 = move-exception
            if (r4 == 0) goto Lb9
            r4.close()     // Catch: java.lang.Throwable -> Lc java.io.IOException -> Lb9
        Lb9:
            throw r14     // Catch: java.lang.Throwable -> Lc
        Lba:
            monitor-exit(r0)
            goto Lbd
        Lbc:
            throw r14
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.SerializeHelper.restore(java.io.File, anet.channel.statist.StrategyStatObject):java.lang.Object");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0102: MOVE (r4 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:67:0x0102 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: all -> 0x0114, TryCatch #6 {, blocks: (B:7:0x0011, B:18:0x0049, B:20:0x0079, B:22:0x0080, B:25:0x0091, B:28:0x0097, B:30:0x009d, B:34:0x00dd, B:37:0x00e3, B:46:0x00f2, B:48:0x00f6, B:49:0x00cd, B:60:0x0075, B:71:0x0105, B:69:0x0108, B:77:0x0109), top: B:4:0x000b, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[Catch: all -> 0x0114, TryCatch #6 {, blocks: (B:7:0x0011, B:18:0x0049, B:20:0x0079, B:22:0x0080, B:25:0x0091, B:28:0x0097, B:30:0x009d, B:34:0x00dd, B:37:0x00e3, B:46:0x00f2, B:48:0x00f6, B:49:0x00cd, B:60:0x0075, B:71:0x0105, B:69:0x0108, B:77:0x0109), top: B:4:0x000b, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void persist(java.io.Serializable r17, java.io.File r18, anet.channel.statist.StrategyStatObject r19) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.SerializeHelper.persist(java.io.Serializable, java.io.File, anet.channel.statist.StrategyStatObject):void");
    }
}
