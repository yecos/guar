package l;

/* loaded from: classes.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f15869a;

    /* renamed from: b, reason: collision with root package name */
    public int f15870b;

    public h(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f15869a = new Object[i10];
    }

    @Override // l.g
    public void a(Object[] objArr, int i10) {
        if (i10 > objArr.length) {
            i10 = objArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            int i12 = this.f15870b;
            Object[] objArr2 = this.f15869a;
            if (i12 < objArr2.length) {
                objArr2[i12] = obj;
                this.f15870b = i12 + 1;
            }
        }
    }

    @Override // l.g
    public Object acquire() {
        int i10 = this.f15870b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f15869a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f15870b = i10 - 1;
        return obj;
    }

    @Override // l.g
    public boolean release(Object obj) {
        int i10 = this.f15870b;
        Object[] objArr = this.f15869a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f15870b = i10 + 1;
        return true;
    }
}
