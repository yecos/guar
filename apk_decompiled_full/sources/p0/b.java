package p0;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import com.mobile.brasiltv.view.RoundedDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final c f18012f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List f18013a;

    /* renamed from: b, reason: collision with root package name */
    public final List f18014b;

    /* renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f18016d = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    public final Map f18015c = new androidx.collection.a();

    /* renamed from: e, reason: collision with root package name */
    public final d f18017e = a();

    public static class a implements c {
        @Override // p0.b.c
        public boolean a(int i10, float[] fArr) {
            return (d(fArr) || b(fArr) || c(fArr)) ? false : true;
        }

        public final boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        public final boolean c(float[] fArr) {
            float f10 = fArr[0];
            return f10 >= 10.0f && f10 <= 37.0f && fArr[1] <= 0.82f;
        }

        public final boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }
    }

    /* renamed from: p0.b$b, reason: collision with other inner class name */
    public static final class C0309b {

        /* renamed from: a, reason: collision with root package name */
        public final List f18018a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f18019b;

        /* renamed from: c, reason: collision with root package name */
        public final List f18020c;

        /* renamed from: d, reason: collision with root package name */
        public int f18021d;

        /* renamed from: e, reason: collision with root package name */
        public int f18022e;

        /* renamed from: f, reason: collision with root package name */
        public int f18023f;

        /* renamed from: g, reason: collision with root package name */
        public final List f18024g;

        /* renamed from: h, reason: collision with root package name */
        public Rect f18025h;

        public C0309b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f18020c = arrayList;
            this.f18021d = 16;
            this.f18022e = 12544;
            this.f18023f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f18024g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(b.f18012f);
            this.f18019b = bitmap;
            this.f18018a = null;
            arrayList.add(p0.c.f18035e);
            arrayList.add(p0.c.f18036f);
            arrayList.add(p0.c.f18037g);
            arrayList.add(p0.c.f18038h);
            arrayList.add(p0.c.f18039i);
            arrayList.add(p0.c.f18040j);
        }

        public b a() {
            List list;
            c[] cVarArr;
            Bitmap bitmap = this.f18019b;
            if (bitmap != null) {
                Bitmap d10 = d(bitmap);
                Rect rect = this.f18025h;
                if (d10 != this.f18019b && rect != null) {
                    double width = d10.getWidth();
                    double width2 = this.f18019b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d11 = width / width2;
                    double d12 = rect.left;
                    Double.isNaN(d12);
                    rect.left = (int) Math.floor(d12 * d11);
                    double d13 = rect.top;
                    Double.isNaN(d13);
                    rect.top = (int) Math.floor(d13 * d11);
                    double d14 = rect.right;
                    Double.isNaN(d14);
                    rect.right = Math.min((int) Math.ceil(d14 * d11), d10.getWidth());
                    double d15 = rect.bottom;
                    Double.isNaN(d15);
                    rect.bottom = Math.min((int) Math.ceil(d15 * d11), d10.getHeight());
                }
                int[] b10 = b(d10);
                int i10 = this.f18021d;
                if (this.f18024g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List list2 = this.f18024g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                p0.a aVar = new p0.a(b10, i10, cVarArr);
                if (d10 != this.f18019b) {
                    d10.recycle();
                }
                list = aVar.d();
            } else {
                list = this.f18018a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f18020c);
            bVar.b();
            return bVar;
        }

        public final int[] b(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f18025h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f18025h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i10 = 0; i10 < height2; i10++) {
                Rect rect2 = this.f18025h;
                System.arraycopy(iArr, ((rect2.top + i10) * width) + rect2.left, iArr2, i10 * width2, width2);
            }
            return iArr2;
        }

        public C0309b c(int i10) {
            this.f18021d = i10;
            return this;
        }

        public final Bitmap d(Bitmap bitmap) {
            int max;
            int i10;
            double d10 = -1.0d;
            if (this.f18022e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i11 = this.f18022e;
                if (width > i11) {
                    double d11 = i11;
                    double d12 = width;
                    Double.isNaN(d11);
                    Double.isNaN(d12);
                    d10 = Math.sqrt(d11 / d12);
                }
            } else if (this.f18023f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i10 = this.f18023f)) {
                double d13 = i10;
                double d14 = max;
                Double.isNaN(d13);
                Double.isNaN(d14);
                d10 = d13 / d14;
            }
            if (d10 <= 0.0d) {
                return bitmap;
            }
            double width2 = bitmap.getWidth();
            Double.isNaN(width2);
            int ceil = (int) Math.ceil(width2 * d10);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d10), false);
        }
    }

    public interface c {
        boolean a(int i10, float[] fArr);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f18026a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18027b;

        /* renamed from: c, reason: collision with root package name */
        public final int f18028c;

        /* renamed from: d, reason: collision with root package name */
        public final int f18029d;

        /* renamed from: e, reason: collision with root package name */
        public final int f18030e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f18031f;

        /* renamed from: g, reason: collision with root package name */
        public int f18032g;

        /* renamed from: h, reason: collision with root package name */
        public int f18033h;

        /* renamed from: i, reason: collision with root package name */
        public float[] f18034i;

        public d(int i10, int i11) {
            this.f18026a = Color.red(i10);
            this.f18027b = Color.green(i10);
            this.f18028c = Color.blue(i10);
            this.f18029d = i10;
            this.f18030e = i11;
        }

        public final void a() {
            if (this.f18031f) {
                return;
            }
            int e10 = r.a.e(-1, this.f18029d, 4.5f);
            int e11 = r.a.e(-1, this.f18029d, 3.0f);
            if (e10 != -1 && e11 != -1) {
                this.f18033h = r.a.m(-1, e10);
                this.f18032g = r.a.m(-1, e11);
                this.f18031f = true;
                return;
            }
            int e12 = r.a.e(RoundedDrawable.DEFAULT_BORDER_COLOR, this.f18029d, 4.5f);
            int e13 = r.a.e(RoundedDrawable.DEFAULT_BORDER_COLOR, this.f18029d, 3.0f);
            if (e12 == -1 || e13 == -1) {
                this.f18033h = e10 != -1 ? r.a.m(-1, e10) : r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e12);
                this.f18032g = e11 != -1 ? r.a.m(-1, e11) : r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e13);
                this.f18031f = true;
            } else {
                this.f18033h = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e12);
                this.f18032g = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e13);
                this.f18031f = true;
            }
        }

        public int b() {
            a();
            return this.f18033h;
        }

        public float[] c() {
            if (this.f18034i == null) {
                this.f18034i = new float[3];
            }
            r.a.a(this.f18026a, this.f18027b, this.f18028c, this.f18034i);
            return this.f18034i;
        }

        public int d() {
            return this.f18030e;
        }

        public int e() {
            return this.f18029d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f18030e == dVar.f18030e && this.f18029d == dVar.f18029d;
        }

        public int f() {
            a();
            return this.f18032g;
        }

        public int hashCode() {
            return (this.f18029d * 31) + this.f18030e;
        }

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f18030e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    public b(List list, List list2) {
        this.f18013a = list;
        this.f18014b = list2;
    }

    public final d a() {
        int size = this.f18013a.size();
        int i10 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar2 = (d) this.f18013a.get(i11);
            if (dVar2.d() > i10) {
                i10 = dVar2.d();
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public void b() {
        int size = this.f18014b.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0.c cVar = (p0.c) this.f18014b.get(i10);
            cVar.k();
            this.f18015c.put(cVar, d(cVar));
        }
        this.f18016d.clear();
    }

    public final float c(d dVar, p0.c cVar) {
        float[] c10 = dVar.c();
        d dVar2 = this.f18017e;
        return (cVar.g() > 0.0f ? cVar.g() * (1.0f - Math.abs(c10[1] - cVar.i())) : 0.0f) + (cVar.a() > 0.0f ? cVar.a() * (1.0f - Math.abs(c10[2] - cVar.h())) : 0.0f) + (cVar.f() > 0.0f ? cVar.f() * (dVar.d() / (dVar2 != null ? dVar2.d() : 1)) : 0.0f);
    }

    public final d d(p0.c cVar) {
        d e10 = e(cVar);
        if (e10 != null && cVar.j()) {
            this.f18016d.append(e10.e(), true);
        }
        return e10;
    }

    public final d e(p0.c cVar) {
        int size = this.f18013a.size();
        float f10 = 0.0f;
        d dVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar2 = (d) this.f18013a.get(i10);
            if (g(dVar2, cVar)) {
                float c10 = c(dVar2, cVar);
                if (dVar == null || c10 > f10) {
                    dVar = dVar2;
                    f10 = c10;
                }
            }
        }
        return dVar;
    }

    public List f() {
        return Collections.unmodifiableList(this.f18013a);
    }

    public final boolean g(d dVar, p0.c cVar) {
        float[] c10 = dVar.c();
        return c10[1] >= cVar.e() && c10[1] <= cVar.c() && c10[2] >= cVar.d() && c10[2] <= cVar.b() && !this.f18016d.get(dVar.e());
    }
}
