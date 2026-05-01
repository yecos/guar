package p0;

import android.graphics.Color;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import p0.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final Comparator f17995g = new C0308a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f17996a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f17997b;

    /* renamed from: c, reason: collision with root package name */
    public final List f17998c;

    /* renamed from: e, reason: collision with root package name */
    public final b.c[] f18000e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f18001f = new float[3];

    /* renamed from: d, reason: collision with root package name */
    public final TimingLogger f17999d = null;

    /* renamed from: p0.a$a, reason: collision with other inner class name */
    public static class C0308a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f18002a;

        /* renamed from: b, reason: collision with root package name */
        public int f18003b;

        /* renamed from: c, reason: collision with root package name */
        public int f18004c;

        /* renamed from: d, reason: collision with root package name */
        public int f18005d;

        /* renamed from: e, reason: collision with root package name */
        public int f18006e;

        /* renamed from: f, reason: collision with root package name */
        public int f18007f;

        /* renamed from: g, reason: collision with root package name */
        public int f18008g;

        /* renamed from: h, reason: collision with root package name */
        public int f18009h;

        /* renamed from: i, reason: collision with root package name */
        public int f18010i;

        public b(int i10, int i11) {
            this.f18002a = i10;
            this.f18003b = i11;
            c();
        }

        public final boolean a() {
            return e() > 1;
        }

        public final int b() {
            int f10 = f();
            a aVar = a.this;
            int[] iArr = aVar.f17996a;
            int[] iArr2 = aVar.f17997b;
            a.e(iArr, f10, this.f18002a, this.f18003b);
            Arrays.sort(iArr, this.f18002a, this.f18003b + 1);
            a.e(iArr, f10, this.f18002a, this.f18003b);
            int i10 = this.f18004c / 2;
            int i11 = this.f18002a;
            int i12 = 0;
            while (true) {
                int i13 = this.f18003b;
                if (i11 > i13) {
                    return this.f18002a;
                }
                i12 += iArr2[iArr[i11]];
                if (i12 >= i10) {
                    return Math.min(i13 - 1, i11);
                }
                i11++;
            }
        }

        public final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f17996a;
            int[] iArr2 = aVar.f17997b;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE;
            int i16 = 0;
            for (int i17 = this.f18002a; i17 <= this.f18003b; i17++) {
                int i18 = iArr[i17];
                i16 += iArr2[i18];
                int k10 = a.k(i18);
                int j10 = a.j(i18);
                int i19 = a.i(i18);
                if (k10 > i13) {
                    i13 = k10;
                }
                if (k10 < i10) {
                    i10 = k10;
                }
                if (j10 > i14) {
                    i14 = j10;
                }
                if (j10 < i11) {
                    i11 = j10;
                }
                if (i19 > i15) {
                    i15 = i19;
                }
                if (i19 < i12) {
                    i12 = i19;
                }
            }
            this.f18005d = i10;
            this.f18006e = i13;
            this.f18007f = i11;
            this.f18008g = i14;
            this.f18009h = i12;
            this.f18010i = i15;
            this.f18004c = i16;
        }

        public final b.d d() {
            a aVar = a.this;
            int[] iArr = aVar.f17996a;
            int[] iArr2 = aVar.f17997b;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = this.f18002a; i14 <= this.f18003b; i14++) {
                int i15 = iArr[i14];
                int i16 = iArr2[i15];
                i11 += i16;
                i10 += a.k(i15) * i16;
                i12 += a.j(i15) * i16;
                i13 += i16 * a.i(i15);
            }
            float f10 = i11;
            return new b.d(a.b(Math.round(i10 / f10), Math.round(i12 / f10), Math.round(i13 / f10)), i11);
        }

        public final int e() {
            return (this.f18003b + 1) - this.f18002a;
        }

        public final int f() {
            int i10 = this.f18006e - this.f18005d;
            int i11 = this.f18008g - this.f18007f;
            int i12 = this.f18010i - this.f18009h;
            if (i10 < i11 || i10 < i12) {
                return (i11 < i10 || i11 < i12) ? -1 : -2;
            }
            return -3;
        }

        public final int g() {
            return ((this.f18006e - this.f18005d) + 1) * ((this.f18008g - this.f18007f) + 1) * ((this.f18010i - this.f18009h) + 1);
        }

        public final b h() {
            if (!a()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int b10 = b();
            b bVar = a.this.new b(b10 + 1, this.f18003b);
            this.f18003b = b10;
            c();
            return bVar;
        }
    }

    public a(int[] iArr, int i10, b.c[] cVarArr) {
        this.f18000e = cVarArr;
        int[] iArr2 = new int[32768];
        this.f17997b = iArr2;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int g10 = g(iArr[i11]);
            iArr[i11] = g10;
            iArr2[g10] = iArr2[g10] + 1;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 32768; i13++) {
            if (iArr2[i13] > 0 && l(i13)) {
                iArr2[i13] = 0;
            }
            if (iArr2[i13] > 0) {
                i12++;
            }
        }
        int[] iArr3 = new int[i12];
        this.f17996a = iArr3;
        int i14 = 0;
        for (int i15 = 0; i15 < 32768; i15++) {
            if (iArr2[i15] > 0) {
                iArr3[i14] = i15;
                i14++;
            }
        }
        if (i12 > i10) {
            this.f17998c = h(i10);
            return;
        }
        this.f17998c = new ArrayList();
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = iArr3[i16];
            this.f17998c.add(new b.d(a(i17), iArr2[i17]));
        }
    }

    public static int a(int i10) {
        return b(k(i10), j(i10), i(i10));
    }

    public static int b(int i10, int i11, int i12) {
        return Color.rgb(f(i10, 5, 8), f(i11, 5, 8), f(i12, 5, 8));
    }

    public static void e(int[] iArr, int i10, int i11, int i12) {
        if (i10 == -2) {
            while (i11 <= i12) {
                int i13 = iArr[i11];
                iArr[i11] = i(i13) | (j(i13) << 10) | (k(i13) << 5);
                i11++;
            }
            return;
        }
        if (i10 != -1) {
            return;
        }
        while (i11 <= i12) {
            int i14 = iArr[i11];
            iArr[i11] = k(i14) | (i(i14) << 10) | (j(i14) << 5);
            i11++;
        }
    }

    public static int f(int i10, int i11, int i12) {
        return (i12 > i11 ? i10 << (i12 - i11) : i10 >> (i11 - i12)) & ((1 << i12) - 1);
    }

    public static int g(int i10) {
        return f(Color.blue(i10), 8, 5) | (f(Color.red(i10), 8, 5) << 10) | (f(Color.green(i10), 8, 5) << 5);
    }

    public static int i(int i10) {
        return i10 & 31;
    }

    public static int j(int i10) {
        return (i10 >> 5) & 31;
    }

    public static int k(int i10) {
        return (i10 >> 10) & 31;
    }

    public final List c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b.d d10 = ((b) it.next()).d();
            if (!n(d10)) {
                arrayList.add(d10);
            }
        }
        return arrayList;
    }

    public List d() {
        return this.f17998c;
    }

    public final List h(int i10) {
        PriorityQueue priorityQueue = new PriorityQueue(i10, f17995g);
        priorityQueue.offer(new b(0, this.f17996a.length - 1));
        o(priorityQueue, i10);
        return c(priorityQueue);
    }

    public final boolean l(int i10) {
        int a10 = a(i10);
        r.a.f(a10, this.f18001f);
        return m(a10, this.f18001f);
    }

    public final boolean m(int i10, float[] fArr) {
        b.c[] cVarArr = this.f18000e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (!this.f18000e[i11].a(i10, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n(b.d dVar) {
        return m(dVar.e(), dVar.c());
    }

    public final void o(PriorityQueue priorityQueue, int i10) {
        b bVar;
        while (priorityQueue.size() < i10 && (bVar = (b) priorityQueue.poll()) != null && bVar.a()) {
            priorityQueue.offer(bVar.h());
            priorityQueue.offer(bVar);
        }
    }
}
