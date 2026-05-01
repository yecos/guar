package r3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f18505c = new Class[0];

    /* renamed from: a, reason: collision with root package name */
    public final String f18506a;

    /* renamed from: b, reason: collision with root package name */
    public final Class[] f18507b;

    public y(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public int a() {
        return this.f18507b.length;
    }

    public String b() {
        return this.f18506a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != y.class) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.f18506a.equals(yVar.f18506a)) {
            return false;
        }
        Class[] clsArr = yVar.f18507b;
        int length = this.f18507b.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (clsArr[i10] != this.f18507b[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f18506a.hashCode() + this.f18507b.length;
    }

    public String toString() {
        return this.f18506a + "(" + this.f18507b.length + "-args)";
    }

    public y(Constructor constructor) {
        this("", constructor.getParameterTypes());
    }

    public y(String str, Class[] clsArr) {
        this.f18506a = str;
        this.f18507b = clsArr == null ? f18505c : clsArr;
    }
}
