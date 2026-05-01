package k7;

import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public class h implements k7.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f15683a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15684b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15685c;

    /* renamed from: d, reason: collision with root package name */
    public final d f15686d;

    /* renamed from: e, reason: collision with root package name */
    public final String f15687e;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f15688a;

        /* renamed from: b, reason: collision with root package name */
        public int f15689b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15690c;

        /* renamed from: d, reason: collision with root package name */
        public d f15691d;

        /* renamed from: e, reason: collision with root package name */
        public String f15692e;

        public h a() {
            if (this.f15691d == null) {
                this.f15691d = new e();
            }
            return new h(this);
        }

        public b b(boolean z10) {
            this.f15690c = z10;
            return this;
        }

        public b c(String str) {
            this.f15692e = str;
            return this;
        }

        public b() {
            this.f15688a = 2;
            this.f15689b = 0;
            this.f15690c = true;
            this.f15692e = "PRETTY_LOGGER";
        }
    }

    public static b k() {
        return new b();
    }

    @Override // k7.b
    public void a(int i10, String str, String str2) {
        String b10 = b(str);
        j(i10, b10);
        i(i10, b10, this.f15683a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f15683a > 0) {
                h(i10, b10);
            }
            g(i10, b10, str2);
            e(i10, b10);
            return;
        }
        if (this.f15683a > 0) {
            h(i10, b10);
        }
        for (int i11 = 0; i11 < length; i11 += 4000) {
            g(i10, b10, new String(bytes, i11, Math.min(length - i11, 4000)));
        }
        e(i10, b10);
    }

    public final String b(String str) {
        if (j.c(str) || j.a(this.f15687e, str)) {
            return this.f15687e;
        }
        return this.f15687e + Operator.Operation.MINUS + str;
    }

    public final String c(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public final int d(StackTraceElement[] stackTraceElementArr) {
        for (int i10 = 5; i10 < stackTraceElementArr.length; i10++) {
            String className = stackTraceElementArr[i10].getClassName();
            if (!className.equals(g.class.getName()) && !className.equals(f.class.getName())) {
                return i10 - 1;
            }
        }
        return -1;
    }

    public final void e(int i10, String str) {
        f(i10, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public final void f(int i10, String str, String str2) {
        this.f15686d.a(i10, str, str2);
    }

    public final void g(int i10, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            f(i10, str, "│ " + str3);
        }
    }

    public final void h(int i10, String str) {
        f(i10, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    public final void i(int i10, String str, int i11) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f15685c) {
            f(i10, str, "│ Thread: " + Thread.currentThread().getName());
            h(i10, str);
        }
        int d10 = d(stackTrace) + this.f15684b;
        if (i11 + d10 > stackTrace.length) {
            i11 = (stackTrace.length - d10) - 1;
        }
        String str2 = "";
        while (i11 > 0) {
            int i12 = i11 + d10;
            if (i12 < stackTrace.length) {
                str2 = str2 + "   ";
                f(i10, str, "│ " + str2 + c(stackTrace[i12].getClassName()) + "." + stackTrace[i12].getMethodName() + "  (" + stackTrace[i12].getFileName() + SOAP.DELIM + stackTrace[i12].getLineNumber() + ")");
            }
            i11--;
        }
    }

    public final void j(int i10, String str) {
        f(i10, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public h(b bVar) {
        this.f15683a = bVar.f15688a;
        this.f15684b = bVar.f15689b;
        this.f15685c = bVar.f15690c;
        this.f15686d = bVar.f15691d;
        this.f15687e = bVar.f15692e;
    }
}
