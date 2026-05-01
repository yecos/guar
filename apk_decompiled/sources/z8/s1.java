package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.hpplay.cybergarage.soap.SOAP;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.b0;

/* loaded from: classes3.dex */
public class s1 implements y8.d1 {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f20916d = Logger.getLogger(s1.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final c f20917e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final Supplier f20918f = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f20919a;

    /* renamed from: b, reason: collision with root package name */
    public final c f20920b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f20921c;

    public class a implements c {
        @Override // z8.s1.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i10, "");
            } catch (MalformedURLException unused) {
                s1.f20916d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i10, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements Supplier {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4);
    }

    public s1() {
        this(f20918f, f20917e, System.getenv("GRPC_PROXY_EXP"));
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(SOAP.DELIM, 2);
        int parseInt = split.length > 1 ? Integer.parseInt(split[1]) : 80;
        f20916d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(split[0], parseInt);
    }

    @Override // y8.d1
    public y8.c1 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f20921c != null ? y8.b0.e().c(this.f20921c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final y8.c1 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, q0.h(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.f20919a.get();
                if (proxySelector == null) {
                    f20916d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> select = proxySelector.select(uri);
                if (select.size() > 1) {
                    f20916d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication a10 = this.f20920b.a(q0.h(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                b0.b c10 = y8.b0.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (a10 == null) {
                    return c10.a();
                }
                return c10.e(a10.getUserName()).b(a10.getPassword() != null ? new String(a10.getPassword()) : null).a();
            } catch (URISyntaxException e10) {
                f20916d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e10);
                return null;
            }
        } catch (Throwable th) {
            f20916d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    public s1(Supplier supplier, c cVar, String str) {
        this.f20919a = (Supplier) Preconditions.checkNotNull(supplier);
        this.f20920b = (c) Preconditions.checkNotNull(cVar);
        if (str != null) {
            this.f20921c = d(str);
        } else {
            this.f20921c = null;
        }
    }
}
