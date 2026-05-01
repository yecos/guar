package d9;

import b9.e;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final d9.a f12747a;

    /* renamed from: b, reason: collision with root package name */
    public final e f12748b;

    /* renamed from: d9.b$b, reason: collision with other inner class name */
    public static class C0210b {

        /* renamed from: a, reason: collision with root package name */
        public d9.a f12749a;

        /* renamed from: b, reason: collision with root package name */
        public e.b f12750b = new e.b();

        public b c() {
            if (this.f12749a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0210b d(String str, String str2) {
            this.f12750b.f(str, str2);
            return this;
        }

        public C0210b e(d9.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f12749a = aVar;
            return this;
        }
    }

    public e a() {
        return this.f12748b;
    }

    public d9.a b() {
        return this.f12747a;
    }

    public String toString() {
        return "Request{url=" + this.f12747a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public b(C0210b c0210b) {
        this.f12747a = c0210b.f12749a;
        this.f12748b = c0210b.f12750b.c();
    }
}
