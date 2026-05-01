package t0;

/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f18787a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f18788b;

    public a(String str, Object[] objArr) {
        this.f18787a = str;
        this.f18788b = objArr;
    }

    public static void c(d dVar, int i10, Object obj) {
        if (obj == null) {
            dVar.bindNull(i10);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.bindBlob(i10, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            dVar.bindDouble(i10, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            dVar.bindDouble(i10, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            dVar.bindLong(i10, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            dVar.bindLong(i10, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            dVar.bindLong(i10, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            dVar.bindLong(i10, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            dVar.bindString(i10, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            dVar.bindLong(i10, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void d(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            c(dVar, i10, obj);
        }
    }

    @Override // t0.e
    public void a(d dVar) {
        d(dVar, this.f18788b);
    }

    @Override // t0.e
    public String b() {
        return this.f18787a;
    }

    public a(String str) {
        this(str, null);
    }
}
