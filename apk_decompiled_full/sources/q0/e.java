package q0;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import t0.c;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public volatile t0.b f18120a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f18121b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f18122c;

    /* renamed from: d, reason: collision with root package name */
    public t0.c f18123d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18125f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18126g;

    /* renamed from: h, reason: collision with root package name */
    public List f18127h;

    /* renamed from: i, reason: collision with root package name */
    public final ReentrantReadWriteLock f18128i = new ReentrantReadWriteLock();

    /* renamed from: j, reason: collision with root package name */
    public final ThreadLocal f18129j = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    public final Map f18130k = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final androidx.room.c f18124e = e();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Class f18131a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18132b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f18133c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f18134d;

        /* renamed from: e, reason: collision with root package name */
        public Executor f18135e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f18136f;

        /* renamed from: g, reason: collision with root package name */
        public c.InterfaceC0321c f18137g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f18138h;

        /* renamed from: j, reason: collision with root package name */
        public boolean f18140j;

        /* renamed from: l, reason: collision with root package name */
        public boolean f18142l;

        /* renamed from: n, reason: collision with root package name */
        public Set f18144n;

        /* renamed from: o, reason: collision with root package name */
        public Set f18145o;

        /* renamed from: p, reason: collision with root package name */
        public String f18146p;

        /* renamed from: q, reason: collision with root package name */
        public File f18147q;

        /* renamed from: i, reason: collision with root package name */
        public c f18139i = c.AUTOMATIC;

        /* renamed from: k, reason: collision with root package name */
        public boolean f18141k = true;

        /* renamed from: m, reason: collision with root package name */
        public final d f18143m = new d();

        public a(Context context, Class cls, String str) {
            this.f18133c = context;
            this.f18131a = cls;
            this.f18132b = str;
        }

        public a a(b bVar) {
            if (this.f18134d == null) {
                this.f18134d = new ArrayList();
            }
            this.f18134d.add(bVar);
            return this;
        }

        public a b(r0.a... aVarArr) {
            if (this.f18145o == null) {
                this.f18145o = new HashSet();
            }
            for (r0.a aVar : aVarArr) {
                this.f18145o.add(Integer.valueOf(aVar.f18288a));
                this.f18145o.add(Integer.valueOf(aVar.f18289b));
            }
            this.f18143m.b(aVarArr);
            return this;
        }

        public a c() {
            this.f18138h = true;
            return this;
        }

        public e d() {
            Executor executor;
            if (this.f18133c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f18131a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.f18135e;
            if (executor2 == null && this.f18136f == null) {
                Executor d10 = h.a.d();
                this.f18136f = d10;
                this.f18135e = d10;
            } else if (executor2 != null && this.f18136f == null) {
                this.f18136f = executor2;
            } else if (executor2 == null && (executor = this.f18136f) != null) {
                this.f18135e = executor;
            }
            Set<Integer> set = this.f18145o;
            if (set != null && this.f18144n != null) {
                for (Integer num : set) {
                    if (this.f18144n.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.f18137g == null) {
                this.f18137g = new u0.d();
            }
            String str = this.f18146p;
            if (str != null || this.f18147q != null) {
                if (this.f18132b == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                if (str != null && this.f18147q != null) {
                    throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                }
                this.f18137g = new j(str, this.f18147q, this.f18137g);
            }
            Context context = this.f18133c;
            q0.a aVar = new q0.a(context, this.f18132b, this.f18137g, this.f18143m, this.f18134d, this.f18138h, this.f18139i.b(context), this.f18135e, this.f18136f, this.f18140j, this.f18141k, this.f18142l, this.f18144n, this.f18146p, this.f18147q);
            e eVar = (e) q0.d.b(this.f18131a, "_Impl");
            eVar.l(aVar);
            return eVar;
        }

        public a e() {
            this.f18141k = false;
            this.f18142l = true;
            return this;
        }

        public a f(c.InterfaceC0321c interfaceC0321c) {
            this.f18137g = interfaceC0321c;
            return this;
        }

        public a g(Executor executor) {
            this.f18135e = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(t0.b bVar) {
        }

        public void b(t0.b bVar) {
        }

        public void c(t0.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        public static boolean a(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        public c b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager == null || a(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public HashMap f18152a = new HashMap();

        public final void a(r0.a aVar) {
            int i10 = aVar.f18288a;
            int i11 = aVar.f18289b;
            TreeMap treeMap = (TreeMap) this.f18152a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.f18152a.put(Integer.valueOf(i10), treeMap);
            }
            r0.a aVar2 = (r0.a) treeMap.get(Integer.valueOf(i11));
            if (aVar2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Overriding migration ");
                sb.append(aVar2);
                sb.append(" with ");
                sb.append(aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }

        public void b(r0.a... aVarArr) {
            for (r0.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public List c(int i10, int i11) {
            if (i10 == i11) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i11 > i10, i10, i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List d(List list, boolean z10, int i10, int i11) {
            TreeMap treeMap;
            boolean z11;
            do {
                if (z10) {
                    if (i10 >= i11) {
                        return list;
                    }
                    treeMap = (TreeMap) this.f18152a.get(Integer.valueOf(i10));
                    if (treeMap == null) {
                        Iterator it = (z10 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                        while (true) {
                            z11 = false;
                            if (!it.hasNext()) {
                                break;
                            }
                            int intValue = ((Integer) it.next()).intValue();
                            if (!z10 ? !(intValue < i11 || intValue >= i10) : !(intValue > i11 || intValue <= i10)) {
                                z11 = true;
                            }
                            if (z11) {
                                list.add(treeMap.get(Integer.valueOf(intValue)));
                                i10 = intValue;
                                z11 = true;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i10 <= i11) {
                        return list;
                    }
                    treeMap = (TreeMap) this.f18152a.get(Integer.valueOf(i10));
                    if (treeMap == null) {
                    }
                }
            } while (z11);
            return null;
        }
    }

    public static boolean n() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a() {
        if (!this.f18125f && n()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        if (!k() && this.f18129j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void c() {
        a();
        t0.b A = this.f18123d.A();
        this.f18124e.m(A);
        A.beginTransaction();
    }

    public t0.f d(String str) {
        a();
        b();
        return this.f18123d.A().compileStatement(str);
    }

    public abstract androidx.room.c e();

    public abstract t0.c f(q0.a aVar);

    public void g() {
        this.f18123d.A().endTransaction();
        if (k()) {
            return;
        }
        this.f18124e.f();
    }

    public Lock h() {
        return this.f18128i.readLock();
    }

    public t0.c i() {
        return this.f18123d;
    }

    public Executor j() {
        return this.f18121b;
    }

    public boolean k() {
        return this.f18123d.A().G();
    }

    public void l(q0.a aVar) {
        t0.c f10 = f(aVar);
        this.f18123d = f10;
        if (f10 instanceof i) {
            ((i) f10).b(aVar);
        }
        boolean z10 = aVar.f18109g == c.WRITE_AHEAD_LOGGING;
        this.f18123d.setWriteAheadLoggingEnabled(z10);
        this.f18127h = aVar.f18107e;
        this.f18121b = aVar.f18110h;
        this.f18122c = new l(aVar.f18111i);
        this.f18125f = aVar.f18108f;
        this.f18126g = z10;
        if (aVar.f18112j) {
            this.f18124e.i(aVar.f18104b, aVar.f18105c);
        }
    }

    public void m(t0.b bVar) {
        this.f18124e.d(bVar);
    }

    public boolean o() {
        t0.b bVar = this.f18120a;
        return bVar != null && bVar.isOpen();
    }

    public Cursor p(t0.e eVar) {
        return q(eVar, null);
    }

    public Cursor q(t0.e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        return cancellationSignal != null ? this.f18123d.A().k(eVar, cancellationSignal) : this.f18123d.A().w(eVar);
    }

    public void r() {
        this.f18123d.A().setTransactionSuccessful();
    }
}
