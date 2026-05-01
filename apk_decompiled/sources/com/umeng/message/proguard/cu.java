package com.umeng.message.proguard;

import java.io.File;
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
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cu.a.run():void");
        }
    }

    public static void a(File file) {
        cb.b(new a(file));
    }
}
