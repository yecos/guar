package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f15721a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    public int f15722b;

    /* renamed from: c, reason: collision with root package name */
    public int f15723c;

    public final void a(Object obj) {
        Object[] objArr = this.f15721a;
        int i10 = this.f15723c;
        objArr[i10] = obj;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f15723c = length;
        if (length == this.f15722b) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.f15721a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        i9.f.c(objArr, objArr2, 0, this.f15722b, 0, 10, null);
        Object[] objArr3 = this.f15721a;
        int length2 = objArr3.length;
        int i10 = this.f15722b;
        i9.f.c(objArr3, objArr2, length2 - i10, 0, i10, 4, null);
        this.f15721a = objArr2;
        this.f15722b = 0;
        this.f15723c = length;
    }

    public final boolean c() {
        return this.f15722b == this.f15723c;
    }

    public final Object d() {
        int i10 = this.f15722b;
        if (i10 == this.f15723c) {
            return null;
        }
        Object[] objArr = this.f15721a;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f15722b = (i10 + 1) & (objArr.length - 1);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
