package d4;

import java.io.Serializable;

/* loaded from: classes.dex */
public class b0 implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f12513a = new b0();

    public static final class a extends b0 {

        /* renamed from: b, reason: collision with root package name */
        public final Class[] f12514b;

        public a(Class[] clsArr) {
            this.f12514b = clsArr;
        }

        @Override // d4.b0
        public boolean b(Class cls) {
            int length = this.f12514b.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class cls2 = this.f12514b[i10];
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b extends b0 {

        /* renamed from: b, reason: collision with root package name */
        public final Class f12515b;

        public b(Class cls) {
            this.f12515b = cls;
        }

        @Override // d4.b0
        public boolean b(Class cls) {
            Class cls2 = this.f12515b;
            return cls == cls2 || cls2.isAssignableFrom(cls);
        }
    }

    public static b0 a(Class[] clsArr) {
        if (clsArr == null) {
            return f12513a;
        }
        int length = clsArr.length;
        return length != 0 ? length != 1 ? new a(clsArr) : new b(clsArr[0]) : f12513a;
    }

    public boolean b(Class cls) {
        return false;
    }
}
