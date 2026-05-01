package l7;

import t9.i;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public long f16271b;

    /* renamed from: c, reason: collision with root package name */
    public long f16272c;

    /* renamed from: a, reason: collision with root package name */
    public String f16270a = "";

    /* renamed from: d, reason: collision with root package name */
    public String f16273d = "";

    public final String a() {
        return this.f16273d;
    }

    public final long b() {
        return this.f16272c;
    }

    public final long c() {
        return this.f16271b;
    }

    public final void d(String str) {
        i.g(str, "<set-?>");
        this.f16273d = str;
    }

    public final void e(long j10) {
        this.f16272c = j10;
    }

    public final void f(String str) {
        i.g(str, "<set-?>");
        this.f16270a = str;
    }

    public final void g(long j10) {
        this.f16271b = j10;
    }

    public String toString() {
        return "SRT(node=" + this.f16270a + ", startTime=" + this.f16271b + ", endTime=" + this.f16272c + ", content='" + this.f16273d + "')";
    }
}
