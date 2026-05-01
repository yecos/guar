package com.umeng.message.proguard;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class cu {

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final File f11826a;

        public a(File file) {
            this.f11826a = file;
        }

        private static long a(List<File> list) {
            Iterator<File> it = list.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                j10 += it.next().length();
            }
            return j10;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[Catch: all -> 0x00e2, TryCatch #3 {all -> 0x00e2, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0021, B:13:0x0027, B:15:0x0031, B:21:0x004c, B:28:0x0063, B:29:0x0066, B:33:0x0067, B:35:0x0074, B:37:0x007a, B:38:0x0085, B:39:0x0091, B:41:0x0097, B:46:0x00c2, B:49:0x00cc, B:57:0x00b7, B:25:0x0054), top: B:6:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007a A[Catch: all -> 0x00e2, TryCatch #3 {all -> 0x00e2, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0021, B:13:0x0027, B:15:0x0031, B:21:0x004c, B:28:0x0063, B:29:0x0066, B:33:0x0067, B:35:0x0074, B:37:0x007a, B:38:0x0085, B:39:0x0091, B:41:0x0097, B:46:0x00c2, B:49:0x00cc, B:57:0x00b7, B:25:0x0054), top: B:6:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: all -> 0x00e2, TryCatch #3 {all -> 0x00e2, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0021, B:13:0x0027, B:15:0x0031, B:21:0x004c, B:28:0x0063, B:29:0x0066, B:33:0x0067, B:35:0x0074, B:37:0x007a, B:38:0x0085, B:39:0x0091, B:41:0x0097, B:46:0x00c2, B:49:0x00cc, B:57:0x00b7, B:25:0x0054), top: B:6:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0091 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            File[] listFiles;
            boolean z10;
            RandomAccessFile randomAccessFile;
            File file = this.f11826a;
            if (file == null) {
                return;
            }
            try {
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - file.lastModified() >= 60000 && !file.setLastModified(currentTimeMillis)) {
                        long length = file.length();
                        if (length == 0) {
                            file.delete();
                        } else {
                            try {
                                randomAccessFile = new RandomAccessFile(file, "rwd");
                                long j10 = length - 1;
                                try {
                                    randomAccessFile.seek(j10);
                                    byte readByte = randomAccessFile.readByte();
                                    randomAccessFile.seek(j10);
                                    randomAccessFile.write(readByte);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        ce.d("FileUtils", th.getMessage());
                                        File parentFile = this.f11826a.getParentFile();
                                        ArrayList<File> arrayList = new ArrayList();
                                        if (parentFile != null) {
                                        }
                                        if (listFiles != null) {
                                        }
                                        long a10 = a(arrayList);
                                        int size = arrayList.size();
                                        while (r4.hasNext()) {
                                        }
                                    } finally {
                                        eb.a(randomAccessFile);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile = null;
                            }
                        }
                    }
                }
                File parentFile2 = this.f11826a.getParentFile();
                ArrayList<File> arrayList2 = new ArrayList();
                listFiles = parentFile2 != null ? parentFile2.listFiles() : null;
                if (listFiles != null) {
                    Collections.addAll(arrayList2, listFiles);
                    Collections.sort(arrayList2, new Comparator<File>() { // from class: com.umeng.message.proguard.ea.1
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(File file2, File file3) {
                            long lastModified = file2.lastModified();
                            long lastModified2 = file3.lastModified();
                            if (lastModified >= lastModified2) {
                                return lastModified == lastModified2 ? 0 : 1;
                            }
                            return -1;
                        }
                    });
                }
                long a102 = a(arrayList2);
                int size2 = arrayList2.size();
                for (File file2 : arrayList2) {
                    if (System.currentTimeMillis() - file2.lastModified() < 259200000 && a102 < 268435456 && size2 < 30) {
                        z10 = true;
                        if (z10) {
                            long length2 = file2.length();
                            if (file2.delete()) {
                                size2--;
                                a102 -= length2;
                                ce.a("", "cache file deleted:".concat(String.valueOf(file2)));
                            }
                        }
                    }
                    z10 = false;
                    if (z10) {
                    }
                }
            } catch (Throwable th3) {
                ce.d("", "check file error:", th3.getMessage());
            }
        }
    }

    public static void a(File file) {
        cb.b(new a(file));
    }
}
