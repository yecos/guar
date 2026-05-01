package ma;

import android.util.SparseArray;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f16863a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final SparseArray f16864b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public static final StringBuilder f16865c = new StringBuilder();

    public static void a(String str) {
        StringBuilder sb = f16865c;
        if (sb.length() > 0) {
            sb.append("_");
        }
        sb.append(str);
    }

    public static String b() {
        return f16865c.toString();
    }

    public static void c() {
        StringBuilder sb = f16865c;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }
}
