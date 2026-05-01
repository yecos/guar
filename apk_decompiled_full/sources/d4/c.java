package d4;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public b f12516a = null;

    /* renamed from: b, reason: collision with root package name */
    public C0205c f12517b = null;

    /* renamed from: c, reason: collision with root package name */
    public h f12518c = null;

    /* renamed from: d, reason: collision with root package name */
    public f f12519d = null;

    /* renamed from: e, reason: collision with root package name */
    public g f12520e = null;

    /* renamed from: f, reason: collision with root package name */
    public e f12521f = null;

    /* renamed from: g, reason: collision with root package name */
    public d f12522g = null;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f12523a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12524b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f12525c;

        public a(Class cls, int i10, Object obj) {
            this.f12523a = cls;
            this.f12524b = i10;
            this.f12525c = obj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!d4.h.H(obj, this.f12523a) || Array.getLength(obj) != this.f12524b) {
                return false;
            }
            for (int i10 = 0; i10 < this.f12524b; i10++) {
                Object obj2 = Array.get(this.f12525c, i10);
                Object obj3 = Array.get(obj, i10);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class b extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final boolean[] a(int i10) {
            return new boolean[i10];
        }
    }

    /* renamed from: d4.c$c, reason: collision with other inner class name */
    public static final class C0205c extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final byte[] a(int i10) {
            return new byte[i10];
        }
    }

    public static final class d extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final double[] a(int i10) {
            return new double[i10];
        }
    }

    public static final class e extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final float[] a(int i10) {
            return new float[i10];
        }
    }

    public static final class f extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final int[] a(int i10) {
            return new int[i10];
        }
    }

    public static final class g extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final long[] a(int i10) {
            return new long[i10];
        }
    }

    public static final class h extends t {
        @Override // d4.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public final short[] a(int i10) {
            return new short[i10];
        }
    }

    public static Object a(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    public static Object[] i(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (objArr[i10] == obj) {
                if (i10 == 0) {
                    return objArr;
                }
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, 0, objArr2, 1, i10);
                objArr2[0] = obj;
                int i11 = i10 + 1;
                int i12 = length - i11;
                if (i12 > 0) {
                    System.arraycopy(objArr, i11, objArr2, i11, i12);
                }
                return objArr2;
            }
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length + 1);
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr3, 1, length);
        }
        objArr3[0] = obj;
        return objArr3;
    }

    public b b() {
        if (this.f12516a == null) {
            this.f12516a = new b();
        }
        return this.f12516a;
    }

    public C0205c c() {
        if (this.f12517b == null) {
            this.f12517b = new C0205c();
        }
        return this.f12517b;
    }

    public d d() {
        if (this.f12522g == null) {
            this.f12522g = new d();
        }
        return this.f12522g;
    }

    public e e() {
        if (this.f12521f == null) {
            this.f12521f = new e();
        }
        return this.f12521f;
    }

    public f f() {
        if (this.f12519d == null) {
            this.f12519d = new f();
        }
        return this.f12519d;
    }

    public g g() {
        if (this.f12520e == null) {
            this.f12520e = new g();
        }
        return this.f12520e;
    }

    public h h() {
        if (this.f12518c == null) {
            this.f12518c = new h();
        }
        return this.f12518c;
    }
}
