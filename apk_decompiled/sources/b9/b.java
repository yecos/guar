package b9;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b9.a[] f5144e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f5145f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f5146g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f5147h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5148a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f5149b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f5150c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5151d;

    static {
        b9.a[] aVarArr = {b9.a.TLS_AES_128_GCM_SHA256, b9.a.TLS_AES_256_GCM_SHA384, b9.a.TLS_CHACHA20_POLY1305_SHA256, b9.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, b9.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, b9.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, b9.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, b9.a.TLS_RSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_RSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_RSA_WITH_AES_128_CBC_SHA, b9.a.TLS_RSA_WITH_AES_256_CBC_SHA, b9.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f5144e = aVarArr;
        C0075b f10 = new C0075b(true).f(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b e10 = f10.i(kVar, kVar2).h(true).e();
        f5145f = e10;
        f5146g = new C0075b(e10).i(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f5147h = new C0075b(false).e();
    }

    public void c(SSLSocket sSLSocket, boolean z10) {
        b e10 = e(sSLSocket, z10);
        sSLSocket.setEnabledProtocols(e10.f5150c);
        String[] strArr = e10.f5149b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f5149b;
        if (strArr == null) {
            return null;
        }
        b9.a[] aVarArr = new b9.a[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.f5149b;
            if (i10 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i10] = b9.a.a(strArr2[i10]);
            i10++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z10) {
        String[] strArr;
        if (this.f5149b != null) {
            strArr = (String[]) l.c(String.class, this.f5149b, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        if (z10 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (strArr == null) {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = "TLS_FALLBACK_SCSV";
            strArr = strArr2;
        }
        return new C0075b(this).g(strArr).j((String[]) l.c(String.class, this.f5150c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z10 = this.f5148a;
        if (z10 != bVar.f5148a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f5149b, bVar.f5149b) && Arrays.equals(this.f5150c, bVar.f5150c) && this.f5151d == bVar.f5151d);
    }

    public boolean f() {
        return this.f5151d;
    }

    public List g() {
        k[] kVarArr = new k[this.f5150c.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.f5150c;
            if (i10 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i10] = k.a(strArr[i10]);
            i10++;
        }
    }

    public int hashCode() {
        if (this.f5148a) {
            return ((((527 + Arrays.hashCode(this.f5149b)) * 31) + Arrays.hashCode(this.f5150c)) * 31) + (!this.f5151d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5148a) {
            return "ConnectionSpec()";
        }
        List d10 = d();
        return "ConnectionSpec(cipherSuites=" + (d10 == null ? "[use default]" : d10.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f5151d + ")";
    }

    /* renamed from: b9.b$b, reason: collision with other inner class name */
    public static final class C0075b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5152a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f5153b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f5154c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5155d;

        public C0075b(boolean z10) {
            this.f5152a = z10;
        }

        public b e() {
            return new b(this);
        }

        public C0075b f(b9.a... aVarArr) {
            if (!this.f5152a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                strArr[i10] = aVarArr[i10].f5143a;
            }
            this.f5153b = strArr;
            return this;
        }

        public C0075b g(String... strArr) {
            if (!this.f5152a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f5153b = null;
            } else {
                this.f5153b = (String[]) strArr.clone();
            }
            return this;
        }

        public C0075b h(boolean z10) {
            if (!this.f5152a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f5155d = z10;
            return this;
        }

        public C0075b i(k... kVarArr) {
            if (!this.f5152a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i10 = 0; i10 < kVarArr.length; i10++) {
                strArr[i10] = kVarArr[i10].f5210a;
            }
            this.f5154c = strArr;
            return this;
        }

        public C0075b j(String... strArr) {
            if (!this.f5152a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f5154c = null;
            } else {
                this.f5154c = (String[]) strArr.clone();
            }
            return this;
        }

        public C0075b(b bVar) {
            this.f5152a = bVar.f5148a;
            this.f5153b = bVar.f5149b;
            this.f5154c = bVar.f5150c;
            this.f5155d = bVar.f5151d;
        }
    }

    public b(C0075b c0075b) {
        this.f5148a = c0075b.f5152a;
        this.f5149b = c0075b.f5153b;
        this.f5150c = c0075b.f5154c;
        this.f5151d = c0075b.f5155d;
    }
}
