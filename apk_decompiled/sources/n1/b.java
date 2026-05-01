package n1;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static List f17146a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final ReentrantReadWriteLock f17147b;

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock.ReadLock f17148c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantReadWriteLock.WriteLock f17149d;

    public static class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final n1.a f17150a;

        /* renamed from: b, reason: collision with root package name */
        public final c f17151b;

        /* renamed from: c, reason: collision with root package name */
        public final int f17152c;

        public a(n1.a aVar, c cVar, int i10) {
            this.f17150a = aVar;
            this.f17151b = cVar;
            this.f17152c = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f17152c - aVar.f17152c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f17147b = reentrantReadWriteLock;
        f17148c = reentrantReadWriteLock.readLock();
        f17149d = reentrantReadWriteLock.writeLock();
    }

    public static void a(n1.a aVar, c cVar, int i10) {
        try {
            if (aVar == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (cVar == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            ReentrantReadWriteLock.WriteLock writeLock = f17149d;
            writeLock.lock();
            f17146a.add(new a(aVar, cVar, i10));
            Collections.sort(f17146a);
            writeLock.unlock();
        } catch (Throwable th) {
            f17149d.unlock();
            throw th;
        }
    }

    public static void b() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator it = f17146a.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).f17150a.clear();
            } catch (Exception unused) {
            }
        }
    }
}
