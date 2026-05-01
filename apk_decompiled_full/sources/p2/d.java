package p2;

import android.app.Application;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import s2.d;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f18048a = new Comparator() { // from class: p2.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int j10;
            j10 = d.j((File) obj, (File) obj2);
            return j10;
        }
    };

    public static /* synthetic */ boolean h(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.endsWith("user.meta");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Application application) {
        File filesDir = application.getFilesDir();
        e(new File(filesDir, ".com.google.firebase.crashlytics-ndk"));
        d(new File(filesDir, ".com.google.firebase.crashlytics"));
    }

    public static /* synthetic */ int j(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    public final void d(File file) {
        File[] a10 = s2.a.a(file, new FileFilter() { // from class: p2.c
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean h10;
                h10 = d.h(file2);
                return h10;
            }
        }, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a10 != null && a10.length > 10) {
            Arrays.sort(a10, this.f18048a);
            for (int i10 = 10; i10 < a10.length; i10++) {
                try {
                    s2.a.b(a10[i10]);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        File[] a11 = s2.a.a(new File(file, "log-files"), null, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a11 == null || a11.length <= 10) {
            return;
        }
        Arrays.sort(a11, this.f18048a);
        for (int i11 = 10; i11 < a11.length; i11++) {
            try {
                s2.a.b(a11[i11]);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void e(File file) {
        File[] a10 = s2.a.a(file, null, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a10 != null) {
            if (a10.length <= 10) {
                return;
            }
            Arrays.sort(a10, this.f18048a);
            for (int i10 = 10; i10 < a10.length; i10++) {
                try {
                    s2.a.b(a10[i10]);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public void f(Application application) {
        g(application);
    }

    public final void g(final Application application) {
        s2.d.c().schedule(new d.e("fix_firebase_log", new Runnable() { // from class: p2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.i(application);
            }
        }, false), 30L, TimeUnit.SECONDS);
    }
}
