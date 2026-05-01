package xa;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class c {

    /* renamed from: q, reason: collision with root package name */
    public static String f19586q = "EventBus";

    /* renamed from: r, reason: collision with root package name */
    public static volatile c f19587r;

    /* renamed from: s, reason: collision with root package name */
    public static final d f19588s = new d();

    /* renamed from: t, reason: collision with root package name */
    public static final Map f19589t = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Map f19590a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f19591b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f19592c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f19593d;

    /* renamed from: e, reason: collision with root package name */
    public final f f19594e;

    /* renamed from: f, reason: collision with root package name */
    public final xa.b f19595f;

    /* renamed from: g, reason: collision with root package name */
    public final xa.a f19596g;

    /* renamed from: h, reason: collision with root package name */
    public final m f19597h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorService f19598i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19599j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19600k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f19601l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19602m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f19603n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f19604o;

    /* renamed from: p, reason: collision with root package name */
    public final int f19605p;

    public class a extends ThreadLocal {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0337c initialValue() {
            return new C0337c();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19607a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f19607a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19607a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19607a[ThreadMode.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19607a[ThreadMode.ASYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: xa.c$c, reason: collision with other inner class name */
    public static final class C0337c {

        /* renamed from: a, reason: collision with root package name */
        public final List f19608a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f19609b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19610c;

        /* renamed from: d, reason: collision with root package name */
        public n f19611d;

        /* renamed from: e, reason: collision with root package name */
        public Object f19612e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19613f;
    }

    public c() {
        this(f19588s);
    }

    public static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static c c() {
        if (f19587r == null) {
            synchronized (c.class) {
                if (f19587r == null) {
                    f19587r = new c();
                }
            }
        }
        return f19587r;
    }

    public static List i(Class cls) {
        List list;
        Map map = f19589t;
        synchronized (map) {
            list = (List) map.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f19589t.put(cls, list);
            }
        }
        return list;
    }

    public final void b(n nVar, Object obj) {
        if (obj != null) {
            n(nVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public ExecutorService d() {
        return this.f19598i;
    }

    public final void e(n nVar, Object obj, Throwable th) {
        if (!(obj instanceof k)) {
            if (this.f19599j) {
                throw new e("Invoking subscriber failed", th);
            }
            if (this.f19600k) {
                Log.e(f19586q, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f19659a.getClass(), th);
            }
            if (this.f19602m) {
                j(new k(this, th, obj, nVar.f19659a));
                return;
            }
            return;
        }
        if (this.f19600k) {
            Log.e(f19586q, "SubscriberExceptionEvent subscriber " + nVar.f19659a.getClass() + " threw an exception", th);
            k kVar = (k) obj;
            Log.e(f19586q, "Initial event " + kVar.f19639c + " caused exception in " + kVar.f19640d, kVar.f19638b);
        }
    }

    public void f(h hVar) {
        Object obj = hVar.f19632a;
        n nVar = hVar.f19633b;
        h.b(hVar);
        if (nVar.f19661c) {
            g(nVar, obj);
        }
    }

    public void g(n nVar, Object obj) {
        try {
            nVar.f19660b.f19641a.invoke(nVar.f19659a, obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Unexpected exception", e10);
        } catch (InvocationTargetException e11) {
            e(nVar, obj, e11.getCause());
        }
    }

    public synchronized boolean h(Object obj) {
        return this.f19591b.containsKey(obj);
    }

    public void j(Object obj) {
        C0337c c0337c = (C0337c) this.f19593d.get();
        List list = c0337c.f19608a;
        list.add(obj);
        if (c0337c.f19609b) {
            return;
        }
        c0337c.f19610c = Looper.getMainLooper() == Looper.myLooper();
        c0337c.f19609b = true;
        if (c0337c.f19613f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                k(list.remove(0), c0337c);
            } finally {
                c0337c.f19609b = false;
                c0337c.f19610c = false;
            }
        }
    }

    public final void k(Object obj, C0337c c0337c) {
        boolean l10;
        Class<?> cls = obj.getClass();
        if (this.f19604o) {
            List i10 = i(cls);
            int size = i10.size();
            l10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                l10 |= l(obj, c0337c, (Class) i10.get(i11));
            }
        } else {
            l10 = l(obj, c0337c, cls);
        }
        if (l10) {
            return;
        }
        if (this.f19601l) {
            StringBuilder sb = new StringBuilder();
            sb.append("No subscribers registered for event ");
            sb.append(cls);
        }
        if (!this.f19603n || cls == g.class || cls == k.class) {
            return;
        }
        j(new g(this, obj));
    }

    public final boolean l(Object obj, C0337c c0337c, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f19590a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            c0337c.f19612e = obj;
            c0337c.f19611d = nVar;
            try {
                n(nVar, obj, c0337c.f19610c);
                if (c0337c.f19613f) {
                    return true;
                }
            } finally {
                c0337c.f19612e = null;
                c0337c.f19611d = null;
                c0337c.f19613f = false;
            }
        }
        return true;
    }

    public void m(Object obj) {
        synchronized (this.f19592c) {
            this.f19592c.put(obj.getClass(), obj);
        }
        j(obj);
    }

    public final void n(n nVar, Object obj, boolean z10) {
        int i10 = b.f19607a[nVar.f19660b.f19642b.ordinal()];
        if (i10 == 1) {
            g(nVar, obj);
            return;
        }
        if (i10 == 2) {
            if (z10) {
                g(nVar, obj);
                return;
            } else {
                this.f19594e.a(nVar, obj);
                return;
            }
        }
        if (i10 == 3) {
            if (z10) {
                this.f19595f.a(nVar, obj);
                return;
            } else {
                g(nVar, obj);
                return;
            }
        }
        if (i10 == 4) {
            this.f19596g.a(nVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + nVar.f19660b.f19642b);
    }

    public void o(Object obj) {
        List a10 = this.f19597h.a(obj.getClass());
        synchronized (this) {
            Iterator it = a10.iterator();
            while (it.hasNext()) {
                q(obj, (l) it.next());
            }
        }
    }

    public boolean p(Object obj) {
        synchronized (this.f19592c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f19592c.get(cls))) {
                return false;
            }
            this.f19592c.remove(cls);
            return true;
        }
    }

    public final void q(Object obj, l lVar) {
        Class cls = lVar.f19643c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f19590a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f19590a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i10 = 0; i10 <= size; i10++) {
            if (i10 == size || lVar.f19644d > ((n) copyOnWriteArrayList.get(i10)).f19660b.f19644d) {
                copyOnWriteArrayList.add(i10, nVar);
                break;
            }
        }
        List list = (List) this.f19591b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f19591b.put(obj, list);
        }
        list.add(cls);
        if (lVar.f19645e) {
            if (!this.f19604o) {
                b(nVar, this.f19592c.get(cls));
                return;
            }
            for (Map.Entry entry : this.f19592c.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(nVar, entry.getValue());
                }
            }
        }
    }

    public synchronized void r(Object obj) {
        List list = (List) this.f19591b.get(obj);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                s(obj, (Class) it.next());
            }
            this.f19591b.remove(obj);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Subscriber to unregister was not registered before: ");
            sb.append(obj.getClass());
        }
    }

    public final void s(Object obj, Class cls) {
        List list = (List) this.f19590a.get(cls);
        if (list != null) {
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                n nVar = (n) list.get(i10);
                if (nVar.f19659a == obj) {
                    nVar.f19661c = false;
                    list.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f19605p + ", eventInheritance=" + this.f19604o + "]";
    }

    public c(d dVar) {
        this.f19593d = new a();
        this.f19590a = new HashMap();
        this.f19591b = new HashMap();
        this.f19592c = new ConcurrentHashMap();
        this.f19594e = new f(this, Looper.getMainLooper(), 10);
        this.f19595f = new xa.b(this);
        this.f19596g = new xa.a(this);
        List list = dVar.f19624j;
        this.f19605p = list != null ? list.size() : 0;
        this.f19597h = new m(dVar.f19624j, dVar.f19622h, dVar.f19621g);
        this.f19600k = dVar.f19615a;
        this.f19601l = dVar.f19616b;
        this.f19602m = dVar.f19617c;
        this.f19603n = dVar.f19618d;
        this.f19599j = dVar.f19619e;
        this.f19604o = dVar.f19620f;
        this.f19598i = dVar.f19623i;
    }
}
