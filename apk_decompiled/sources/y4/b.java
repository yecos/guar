package y4;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public int f19759a;

    /* renamed from: b, reason: collision with root package name */
    public int f19760b;

    /* renamed from: c, reason: collision with root package name */
    public String f19761c;

    /* renamed from: d, reason: collision with root package name */
    public String f19762d;

    /* renamed from: e, reason: collision with root package name */
    public String f19763e;

    /* renamed from: f, reason: collision with root package name */
    public long f19764f;

    /* renamed from: g, reason: collision with root package name */
    public long f19765g;

    /* renamed from: h, reason: collision with root package name */
    public long f19766h;

    public b(int i10, String str, String str2, String str3, long j10, long j11) {
        this.f19759a = str.hashCode() + i10;
        this.f19760b = i10;
        this.f19761c = str;
        this.f19762d = str2;
        this.f19763e = str3;
        this.f19764f = j10;
        this.f19765g = j11;
    }

    public String a() {
        return this.f19763e;
    }

    public String b() {
        return this.f19761c;
    }

    public long c() {
        return this.f19765g;
    }

    public int d() {
        return this.f19759a;
    }

    public long e() {
        return this.f19766h;
    }

    public long f() {
        return this.f19764f;
    }

    public int g() {
        return this.f19760b;
    }

    public String h() {
        return this.f19762d;
    }

    public void i(String str) {
        this.f19761c = str;
    }

    public void j(long j10) {
        this.f19765g = j10;
    }

    public void k(int i10) {
        this.f19759a = i10;
    }

    public void l(long j10) {
        this.f19766h = j10;
    }

    public void m(long j10) {
        this.f19764f = j10;
    }

    public void n(int i10) {
        this.f19760b = i10;
    }

    public void o(String str) {
        this.f19762d = str;
    }

    public b() {
    }
}
