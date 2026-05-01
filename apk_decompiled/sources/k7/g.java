package k7;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f15681a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public final List f15682b = new ArrayList();

    @Override // k7.i
    public void a(c cVar) {
        this.f15682b.add(cVar);
    }

    @Override // k7.i
    public void b(String str, Object... objArr) {
        j(4, null, str, objArr);
    }

    @Override // k7.i
    public void c(Object obj) {
        j(3, null, j.d(obj), new Object[0]);
    }

    @Override // k7.i
    public void d(String str, Object... objArr) {
        j(3, null, str, objArr);
    }

    @Override // k7.i
    public void e(String str, Object... objArr) {
        j(5, null, str, objArr);
    }

    @Override // k7.i
    public void f(Throwable th, String str, Object... objArr) {
        j(6, th, str, objArr);
    }

    public final String g(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public final String h() {
        String str = (String) this.f15681a.get();
        if (str == null) {
            return null;
        }
        this.f15681a.remove();
        return str;
    }

    public synchronized void i(int i10, String str, String str2, Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + j.b(th);
        }
        if (th != null && str2 == null) {
            str2 = j.b(th);
        }
        if (j.c(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (c cVar : this.f15682b) {
            if (cVar.b(i10, str)) {
                cVar.a(i10, str, str2);
            }
        }
    }

    public final synchronized void j(int i10, Throwable th, String str, Object... objArr) {
        i(i10, h(), g(str, objArr), th);
    }
}
