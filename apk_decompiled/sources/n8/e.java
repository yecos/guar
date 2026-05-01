package n8;

import com.titan.ranger.bean.Program;
import t9.i;

/* loaded from: classes3.dex */
public final class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public String f17326a;

    /* renamed from: b, reason: collision with root package name */
    public Program f17327b;

    /* renamed from: c, reason: collision with root package name */
    public Program f17328c;

    @Override // n8.b
    public Program a() {
        return this.f17328c;
    }

    @Override // n8.b
    public void b() {
        this.f17328c = null;
    }

    @Override // n8.b
    public void c() {
        this.f17326a = null;
        this.f17327b = null;
    }

    @Override // n8.b
    public void d(Program program) {
        i.g(program, "castProgram");
        this.f17328c = program;
    }

    @Override // n8.b
    public String e() {
        return this.f17326a;
    }

    @Override // n8.b
    public void f(Program program) {
        i.g(program, "program");
        this.f17327b = program;
    }

    @Override // n8.b
    public void g(String str) {
        i.g(str, "programCode");
        this.f17326a = str;
    }

    @Override // n8.b
    public Program h() {
        return this.f17327b;
    }
}
