package d4;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public Object f12570a;

    /* renamed from: b, reason: collision with root package name */
    public a f12571b;

    /* renamed from: c, reason: collision with root package name */
    public a f12572c;

    /* renamed from: d, reason: collision with root package name */
    public int f12573d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f12574a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12575b;

        /* renamed from: c, reason: collision with root package name */
        public a f12576c;

        public a(Object obj, int i10) {
            this.f12574a = obj;
            this.f12575b = i10;
        }

        public int a(Object obj, int i10) {
            System.arraycopy(this.f12574a, 0, obj, i10, this.f12575b);
            return i10 + this.f12575b;
        }

        public Object b() {
            return this.f12574a;
        }

        public void c(a aVar) {
            if (this.f12576c != null) {
                throw new IllegalStateException();
            }
            this.f12576c = aVar;
        }

        public a d() {
            return this.f12576c;
        }
    }

    public abstract Object a(int i10);

    public void b() {
        a aVar = this.f12572c;
        if (aVar != null) {
            this.f12570a = aVar.b();
        }
        this.f12572c = null;
        this.f12571b = null;
        this.f12573d = 0;
    }

    public final Object c(Object obj, int i10) {
        a aVar = new a(obj, i10);
        if (this.f12571b == null) {
            this.f12572c = aVar;
            this.f12571b = aVar;
        } else {
            this.f12572c.c(aVar);
            this.f12572c = aVar;
        }
        this.f12573d += i10;
        return a(i10 < 16384 ? i10 + i10 : i10 + (i10 >> 2));
    }

    public int d() {
        return this.f12573d;
    }

    public Object e(Object obj, int i10) {
        int i11 = this.f12573d + i10;
        Object a10 = a(i11);
        int i12 = 0;
        for (a aVar = this.f12571b; aVar != null; aVar = aVar.d()) {
            i12 = aVar.a(a10, i12);
        }
        System.arraycopy(obj, 0, a10, i12, i10);
        int i13 = i12 + i10;
        if (i13 == i11) {
            return a10;
        }
        throw new IllegalStateException("Should have gotten " + i11 + " entries, got " + i13);
    }

    public Object f() {
        b();
        Object obj = this.f12570a;
        return obj == null ? a(12) : obj;
    }
}
