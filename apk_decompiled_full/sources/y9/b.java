package y9;

import i9.w;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class b extends w {

    /* renamed from: a, reason: collision with root package name */
    public final int f20101a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20102b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20103c;

    /* renamed from: d, reason: collision with root package name */
    public int f20104d;

    public b(int i10, int i11, int i12) {
        this.f20101a = i12;
        this.f20102b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f20103c = z10;
        this.f20104d = z10 ? i10 : i11;
    }

    @Override // i9.w
    public int a() {
        int i10 = this.f20104d;
        if (i10 != this.f20102b) {
            this.f20104d = this.f20101a + i10;
        } else {
            if (!this.f20103c) {
                throw new NoSuchElementException();
            }
            this.f20103c = false;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20103c;
    }
}
