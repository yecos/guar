package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes.dex */
class OpenId {

    /* renamed from: a, reason: collision with root package name */
    long f17882a;

    /* renamed from: b, reason: collision with root package name */
    String f17883b;

    /* renamed from: c, reason: collision with root package name */
    String f17884c;

    /* renamed from: d, reason: collision with root package name */
    int f17885d;

    public OpenId(String str) {
        this.f17884c = str;
    }

    public void a(int i10) {
        this.f17885d = i10;
    }

    public void b() {
        this.f17882a = 0L;
    }

    public void a(long j10) {
        this.f17882a = j10;
    }

    public void a(String str) {
        this.f17883b = str;
    }

    public boolean a() {
        return this.f17882a > System.currentTimeMillis();
    }
}
