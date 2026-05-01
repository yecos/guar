package d4;

import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public o f12566a;

    /* renamed from: b, reason: collision with root package name */
    public o f12567b;

    /* renamed from: c, reason: collision with root package name */
    public int f12568c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f12569d;

    public final void a(Object obj, int i10, Object[] objArr, int i11) {
        int i12 = 0;
        for (o oVar = this.f12566a; oVar != null; oVar = oVar.b()) {
            Object[] objArr2 = (Object[]) oVar.c();
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i12, length);
            i12 += length;
        }
        System.arraycopy(objArr, 0, obj, i12, i11);
        int i13 = i12 + i11;
        if (i13 == i10) {
            return;
        }
        throw new IllegalStateException("Should have gotten " + i10 + " entries, got " + i13);
    }

    public void b() {
        o oVar = this.f12567b;
        if (oVar != null) {
            this.f12569d = (Object[]) oVar.c();
        }
        this.f12567b = null;
        this.f12566a = null;
        this.f12568c = 0;
    }

    public Object[] c(Object[] objArr) {
        o oVar = new o(objArr, null);
        if (this.f12566a == null) {
            this.f12567b = oVar;
            this.f12566a = oVar;
        } else {
            this.f12567b.a(oVar);
            this.f12567b = oVar;
        }
        int length = objArr.length;
        this.f12568c += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public int d() {
        return this.f12568c;
    }

    public void e(Object[] objArr, int i10, List list) {
        int i11;
        o oVar = this.f12566a;
        while (true) {
            i11 = 0;
            if (oVar == null) {
                break;
            }
            Object[] objArr2 = (Object[]) oVar.c();
            int length = objArr2.length;
            while (i11 < length) {
                list.add(objArr2[i11]);
                i11++;
            }
            oVar = oVar.b();
        }
        while (i11 < i10) {
            list.add(objArr[i11]);
            i11++;
        }
        b();
    }

    public Object[] f(Object[] objArr, int i10) {
        int i11 = this.f12568c + i10;
        Object[] objArr2 = new Object[i11];
        a(objArr2, i11, objArr, i10);
        b();
        return objArr2;
    }

    public Object[] g(Object[] objArr, int i10, Class cls) {
        int i11 = this.f12568c + i10;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) cls, i11);
        a(objArr2, i11, objArr, i10);
        b();
        return objArr2;
    }

    public int h() {
        Object[] objArr = this.f12569d;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public Object[] i() {
        b();
        Object[] objArr = this.f12569d;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this.f12569d = objArr2;
        return objArr2;
    }

    public Object[] j(Object[] objArr, int i10) {
        b();
        Object[] objArr2 = this.f12569d;
        if (objArr2 == null || objArr2.length < i10) {
            this.f12569d = new Object[Math.max(12, i10)];
        }
        System.arraycopy(objArr, 0, this.f12569d, 0, i10);
        return this.f12569d;
    }
}
