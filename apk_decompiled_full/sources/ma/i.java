package ma;

/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16860a = true;

    public static String a(String str, String str2) {
        return b(str, str2);
    }

    public static String b(String str, String str2) {
        if (!f16860a) {
            return str;
        }
        if (str == null) {
            return "";
        }
        try {
            return v7.b.a(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        return b(str, v7.b.f19125b);
    }

    public static String d(String str) {
        return f(str, v7.b.f19124a);
    }

    public static String e(String str, String str2) {
        return f(str, str2);
    }

    public static String f(String str, String str2) {
        if (!f16860a) {
            return str;
        }
        if (str == null) {
            return "";
        }
        try {
            return v7.b.b(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String g(String str) {
        return f(str, v7.b.f19125b);
    }

    public static boolean h() {
        return f16860a;
    }
}
