package y8;

import com.google.common.base.Preconditions;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public final class c0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f19817f = Logger.getLogger(c0.class.getName());

    /* renamed from: g, reason: collision with root package name */
    public static final c0 f19818g = new c0();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap f19819a = new ConcurrentSkipListMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap f19820b = new ConcurrentSkipListMap();

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentMap f19821c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f19822d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentMap f19823e = new ConcurrentHashMap();

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f19824a;

        public b(c cVar) {
            this.f19824a = (c) Preconditions.checkNotNull(cVar);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f19825a;

        /* renamed from: b, reason: collision with root package name */
        public final Certificate f19826b;

        /* renamed from: c, reason: collision with root package name */
        public final Certificate f19827c;

        public c(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e10) {
                c0.f19817f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e10);
            }
            this.f19825a = cipherSuite;
            this.f19826b = certificate2;
            this.f19827c = certificate;
        }
    }

    public static void b(Map map, h0 h0Var) {
    }

    public static long f(m0 m0Var) {
        return m0Var.d().d();
    }

    public static c0 g() {
        return f19818g;
    }

    public static void h(Map map, h0 h0Var) {
    }

    public void c(h0 h0Var) {
        b(this.f19822d, h0Var);
    }

    public void d(h0 h0Var) {
        b(this.f19820b, h0Var);
    }

    public void e(h0 h0Var) {
        b(this.f19821c, h0Var);
    }

    public void i(h0 h0Var) {
        h(this.f19822d, h0Var);
    }

    public void j(h0 h0Var) {
        h(this.f19820b, h0Var);
    }

    public void k(h0 h0Var) {
        h(this.f19821c, h0Var);
    }
}
