package a0;

/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f74a;

    /* renamed from: b, reason: collision with root package name */
    public int f75b;

    public f(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f74a = new Object[i10];
    }

    public final boolean a(Object obj) {
        for (int i10 = 0; i10 < this.f75b; i10++) {
            if (this.f74a[i10] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // a0.e
    public Object acquire() {
        int i10 = this.f75b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f74a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f75b = i10 - 1;
        return obj;
    }

    @Override // a0.e
    public boolean release(Object obj) {
        if (a(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f75b;
        Object[] objArr = this.f74a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f75b = i10 + 1;
        return true;
    }
}
