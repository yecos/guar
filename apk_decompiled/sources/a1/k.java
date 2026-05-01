package a1;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static k f114a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final int f115b = 20;

    public static class a extends k {

        /* renamed from: c, reason: collision with root package name */
        public int f116c;

        public a(int i10) {
            super(i10);
            this.f116c = i10;
        }

        @Override // a1.k
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f116c > 3 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th = thArr[0];
        }

        @Override // a1.k
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f116c <= 6) {
                if (thArr == null || thArr.length < 1) {
                    Log.e(str, str2);
                } else {
                    Log.e(str, str2, thArr[0]);
                }
            }
        }

        @Override // a1.k
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f116c > 4 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th = thArr[0];
        }

        @Override // a1.k
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f116c > 2 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th = thArr[0];
        }

        @Override // a1.k
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f116c > 5 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th = thArr[0];
        }
    }

    public k(int i10) {
    }

    public static synchronized k c() {
        k kVar;
        synchronized (k.class) {
            if (f114a == null) {
                f114a = new a(3);
            }
            kVar = f114a;
        }
        return kVar;
    }

    public static synchronized void e(k kVar) {
        synchronized (k.class) {
            f114a = kVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i10 = f115b;
        if (length >= i10) {
            sb.append(str.substring(0, i10));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
