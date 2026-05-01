package s0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static final Map f18625e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final File f18626a;

    /* renamed from: b, reason: collision with root package name */
    public final Lock f18627b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18628c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f18629d;

    public a(String str, File file, boolean z10) {
        File file2 = new File(file, str + ".lck");
        this.f18626a = file2;
        this.f18627b = a(file2.getAbsolutePath());
        this.f18628c = z10;
    }

    public static Lock a(String str) {
        Lock lock;
        Map map = f18625e;
        synchronized (map) {
            lock = (Lock) map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f18627b.lock();
        if (this.f18628c) {
            try {
                FileChannel channel = new FileOutputStream(this.f18626a).getChannel();
                this.f18629d = channel;
                channel.lock();
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to grab copy lock.", e10);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f18629d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f18627b.unlock();
    }
}
