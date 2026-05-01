package y9;

/* loaded from: classes3.dex */
public abstract class e extends d {
    public static final int a(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static final int b(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static final long c(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static final int d(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static final a e(int i10, int i11) {
        return a.f20097d.a(i10, i11, -1);
    }

    public static final c f(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? c.f20105e.a() : new c(i10, i11 - 1);
    }
}
