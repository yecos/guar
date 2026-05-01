package q0;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class h implements t0.e, t0.d {

    /* renamed from: i, reason: collision with root package name */
    public static final TreeMap f18160i = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    public volatile String f18161a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f18162b;

    /* renamed from: c, reason: collision with root package name */
    public final double[] f18163c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f18164d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[][] f18165e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f18166f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18167g;

    /* renamed from: h, reason: collision with root package name */
    public int f18168h;

    public h(int i10) {
        this.f18167g = i10;
        int i11 = i10 + 1;
        this.f18166f = new int[i11];
        this.f18162b = new long[i11];
        this.f18163c = new double[i11];
        this.f18164d = new String[i11];
        this.f18165e = new byte[i11][];
    }

    public static h c(String str, int i10) {
        TreeMap treeMap = f18160i;
        synchronized (treeMap) {
            Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (ceilingEntry == null) {
                h hVar = new h(i10);
                hVar.e(str, i10);
                return hVar;
            }
            treeMap.remove(ceilingEntry.getKey());
            h hVar2 = (h) ceilingEntry.getValue();
            hVar2.e(str, i10);
            return hVar2;
        }
    }

    public static void f() {
        TreeMap treeMap = f18160i;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i10 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i10;
        }
    }

    @Override // t0.e
    public void a(t0.d dVar) {
        for (int i10 = 1; i10 <= this.f18168h; i10++) {
            int i11 = this.f18166f[i10];
            if (i11 == 1) {
                dVar.bindNull(i10);
            } else if (i11 == 2) {
                dVar.bindLong(i10, this.f18162b[i10]);
            } else if (i11 == 3) {
                dVar.bindDouble(i10, this.f18163c[i10]);
            } else if (i11 == 4) {
                dVar.bindString(i10, this.f18164d[i10]);
            } else if (i11 == 5) {
                dVar.bindBlob(i10, this.f18165e[i10]);
            }
        }
    }

    @Override // t0.e
    public String b() {
        return this.f18161a;
    }

    @Override // t0.d
    public void bindBlob(int i10, byte[] bArr) {
        this.f18166f[i10] = 5;
        this.f18165e[i10] = bArr;
    }

    @Override // t0.d
    public void bindDouble(int i10, double d10) {
        this.f18166f[i10] = 3;
        this.f18163c[i10] = d10;
    }

    @Override // t0.d
    public void bindLong(int i10, long j10) {
        this.f18166f[i10] = 2;
        this.f18162b[i10] = j10;
    }

    @Override // t0.d
    public void bindNull(int i10) {
        this.f18166f[i10] = 1;
    }

    @Override // t0.d
    public void bindString(int i10, String str) {
        this.f18166f[i10] = 4;
        this.f18164d[i10] = str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void e(String str, int i10) {
        this.f18161a = str;
        this.f18168h = i10;
    }

    public void release() {
        TreeMap treeMap = f18160i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f18167g), this);
            f();
        }
    }
}
