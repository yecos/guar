package b9;

import com.google.android.gms.security.ProviderInstaller;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f5170b = Logger.getLogger(h.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f5171c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* renamed from: d, reason: collision with root package name */
    public static final h f5172d = d();

    /* renamed from: a, reason: collision with root package name */
    public final Provider f5173a;

    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public class b implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }
    }

    public class c implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public static class d extends h {

        /* renamed from: e, reason: collision with root package name */
        public final b9.g f5174e;

        /* renamed from: f, reason: collision with root package name */
        public final b9.g f5175f;

        /* renamed from: g, reason: collision with root package name */
        public final Method f5176g;

        /* renamed from: h, reason: collision with root package name */
        public final Method f5177h;

        /* renamed from: i, reason: collision with root package name */
        public final b9.g f5178i;

        /* renamed from: j, reason: collision with root package name */
        public final b9.g f5179j;

        /* renamed from: k, reason: collision with root package name */
        public final EnumC0076h f5180k;

        public d(b9.g gVar, b9.g gVar2, Method method, Method method2, b9.g gVar3, b9.g gVar4, Provider provider, EnumC0076h enumC0076h) {
            super(provider);
            this.f5174e = gVar;
            this.f5175f = gVar2;
            this.f5176g = method;
            this.f5177h = method2;
            this.f5178i = gVar3;
            this.f5179j = gVar4;
            this.f5180k = enumC0076h;
        }

        @Override // b9.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f5174e.e(sSLSocket, Boolean.TRUE);
                this.f5175f.e(sSLSocket, str);
            }
            if (this.f5179j.g(sSLSocket)) {
                this.f5179j.f(sSLSocket, h.b(list));
            }
        }

        @Override // b9.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f5178i.g(sSLSocket) && (bArr = (byte[]) this.f5178i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f5212b);
            }
            return null;
        }

        @Override // b9.h
        public EnumC0076h i() {
            return this.f5180k;
        }
    }

    public static class e extends h {

        /* renamed from: e, reason: collision with root package name */
        public final Method f5181e;

        /* renamed from: f, reason: collision with root package name */
        public final Method f5182f;

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // b9.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f5181e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // b9.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f5182f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // b9.h
        public EnumC0076h i() {
            return EnumC0076h.ALPN_AND_NPN;
        }

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f5181e = method;
            this.f5182f = method2;
        }
    }

    public static class f extends h {

        /* renamed from: e, reason: collision with root package name */
        public final Method f5183e;

        /* renamed from: f, reason: collision with root package name */
        public final Method f5184f;

        /* renamed from: g, reason: collision with root package name */
        public final Method f5185g;

        /* renamed from: h, reason: collision with root package name */
        public final Class f5186h;

        /* renamed from: i, reason: collision with root package name */
        public final Class f5187i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f5183e = method;
            this.f5184f = method2;
            this.f5185g = method3;
            this.f5186h = cls;
            this.f5187i = cls2;
        }

        @Override // b9.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f5185g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e10) {
                h.f5170b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e10);
            }
        }

        @Override // b9.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = (i) list.get(i10);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f5183e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f5186h, this.f5187i}, new g(arrayList)));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // b9.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f5184f.invoke(null, sSLSocket));
                if (!gVar.f5189b && gVar.f5190c == null) {
                    h.f5170b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f5189b) {
                    return null;
                }
                return gVar.f5190c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // b9.h
        public EnumC0076h i() {
            return EnumC0076h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final List f5188a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5189b;

        /* renamed from: c, reason: collision with root package name */
        public String f5190c;

        public g(List list) {
            this.f5188a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f5211a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5189b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f5188a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f5188a.contains(list.get(i10))) {
                            String str = (String) list.get(i10);
                            this.f5190c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f5188a.get(0);
                    this.f5190c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f5190c = (String) objArr[0];
            return null;
        }
    }

    /* renamed from: b9.h$h, reason: collision with other inner class name */
    public enum EnumC0076h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f5173a = provider;
    }

    public static byte[] b(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) list.get(i10);
            if (iVar != i.HTTP_1_0) {
                buffer.writeByte(iVar.toString().length());
                buffer.writeUtf8(iVar.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static h d() {
        Method method;
        Method method2;
        Provider f10 = f();
        a aVar = null;
        if (f10 != null) {
            b9.g gVar = new b9.g(null, "setUseSessionTickets", Boolean.TYPE);
            b9.g gVar2 = new b9.g(null, "setHostname", String.class);
            b9.g gVar3 = new b9.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            b9.g gVar4 = new b9.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = null;
                    return new d(gVar, gVar2, method, method2, gVar3, gVar4, f10, (!f10.getName().equals(ProviderInstaller.PROVIDER_NAME) || f10.getName().equals("Conscrypt") || f10.getName().equals("Ssl_Guard")) ? EnumC0076h.ALPN_AND_NPN : k() ? EnumC0076h.ALPN_AND_NPN : j() ? EnumC0076h.NPN : EnumC0076h.NONE);
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            return new d(gVar, gVar2, method, method2, gVar3, gVar4, f10, (!f10.getName().equals(ProviderInstaller.PROVIDER_NAME) || f10.getName().equals("Conscrypt") || f10.getName().equals("Ssl_Guard")) ? EnumC0076h.ALPN_AND_NPN : k() ? EnumC0076h.ALPN_AND_NPN : j() ? EnumC0076h.NPN : EnumC0076h.NONE);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                sSLContext.init(null, null, null);
                ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), new Object[0]);
                return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), aVar);
            } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                try {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    return new h(provider);
                }
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static h e() {
        return f5172d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f5171c) {
                if (str.equals(provider.getClass().getName())) {
                    f5170b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f5170b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e10) {
            f5170b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e10) {
            f5170b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }

    public Provider g() {
        return this.f5173a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0076h i() {
        return EnumC0076h.NONE;
    }
}
