package a9;

import anet.channel.strategy.dispatch.DispatchConstants;
import b9.h;
import com.google.common.base.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import z8.q0;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f445b = Logger.getLogger(k.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final b9.h f446c = b9.h.e();

    /* renamed from: d, reason: collision with root package name */
    public static k f447d = d(k.class.getClassLoader());

    /* renamed from: a, reason: collision with root package name */
    public final b9.h f448a;

    public static final class a extends k {

        /* renamed from: e, reason: collision with root package name */
        public static final b9.g f449e;

        /* renamed from: f, reason: collision with root package name */
        public static final b9.g f450f;

        /* renamed from: g, reason: collision with root package name */
        public static final b9.g f451g;

        /* renamed from: h, reason: collision with root package name */
        public static final b9.g f452h;

        /* renamed from: i, reason: collision with root package name */
        public static final b9.g f453i;

        /* renamed from: j, reason: collision with root package name */
        public static final b9.g f454j;

        /* renamed from: k, reason: collision with root package name */
        public static final Method f455k;

        /* renamed from: l, reason: collision with root package name */
        public static final Method f456l;

        /* renamed from: m, reason: collision with root package name */
        public static final Method f457m;

        /* renamed from: n, reason: collision with root package name */
        public static final Method f458n;

        /* renamed from: o, reason: collision with root package name */
        public static final Method f459o;

        /* renamed from: p, reason: collision with root package name */
        public static final Method f460p;

        /* renamed from: q, reason: collision with root package name */
        public static final Constructor f461q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class<?> cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            f449e = new b9.g(null, "setUseSessionTickets", cls);
            f450f = new b9.g(null, "setHostname", String.class);
            f451g = new b9.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f452h = new b9.g(null, "setAlpnProtocols", byte[].class);
            f453i = new b9.g(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f454j = new b9.g(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method2 = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f457m = method;
                    f458n = method2;
                    f459o = method3;
                    f455k = method4;
                    f456l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f460p = method6;
                    f461q = constructor;
                } catch (NoSuchMethodException e11) {
                    e = e11;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f457m = method;
                    f458n = method2;
                    f459o = method3;
                    f455k = method4;
                    f456l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f460p = method6;
                    f461q = constructor;
                }
                try {
                    method3 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                    try {
                        Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                        method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                        try {
                            method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                        } catch (ClassNotFoundException e12) {
                            e = e12;
                            k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                            method5 = null;
                            f457m = method;
                            f458n = method2;
                            f459o = method3;
                            f455k = method4;
                            f456l = method5;
                            method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                            f460p = method6;
                            f461q = constructor;
                        } catch (NoSuchMethodException e13) {
                            e = e13;
                            k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                            method5 = null;
                            f457m = method;
                            f458n = method2;
                            f459o = method3;
                            f455k = method4;
                            f456l = method5;
                            method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                            f460p = method6;
                            f461q = constructor;
                        }
                    } catch (ClassNotFoundException e14) {
                        e = e14;
                        method4 = null;
                    } catch (NoSuchMethodException e15) {
                        e = e15;
                        method4 = null;
                    }
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    method3 = null;
                    method4 = method3;
                    k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f457m = method;
                    f458n = method2;
                    f459o = method3;
                    f455k = method4;
                    f456l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f460p = method6;
                    f461q = constructor;
                } catch (NoSuchMethodException e17) {
                    e = e17;
                    method3 = null;
                    method4 = method3;
                    k.f445b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f457m = method;
                    f458n = method2;
                    f459o = method3;
                    f455k = method4;
                    f456l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f460p = method6;
                    f461q = constructor;
                }
            } catch (ClassNotFoundException e18) {
                e = e18;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e19) {
                e = e19;
                method = null;
                method2 = null;
            }
            f457m = method;
            f458n = method2;
            f459o = method3;
            f455k = method4;
            f456l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
            } catch (ClassNotFoundException e20) {
                e = e20;
                method6 = null;
            } catch (NoSuchMethodException e21) {
                e = e21;
                method6 = null;
            }
            try {
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e22) {
                e = e22;
                k.f445b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                f460p = method6;
                f461q = constructor;
            } catch (NoSuchMethodException e23) {
                e = e23;
                k.f445b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                f460p = method6;
                f461q = constructor;
            }
            f460p = method6;
            f461q = constructor;
        }

        public a(b9.h hVar) {
            super(hVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00d4  */
        @Override // a9.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(javax.net.ssl.SSLSocket r9, java.lang.String r10, java.util.List r11) {
            /*
                Method dump skipped, instructions count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: a9.k.a.c(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        @Override // a9.k
        public String f(SSLSocket sSLSocket) {
            Method method = f459o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    if (!(e11.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e11);
                    }
                    k.f445b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f448a.i() == h.EnumC0076h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f451g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, b9.l.f5212b);
                    }
                } catch (Exception e12) {
                    k.f445b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e12);
                }
            }
            if (this.f448a.i() == h.EnumC0076h.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) f453i.f(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, b9.l.f5212b);
                }
                return null;
            } catch (Exception e13) {
                k.f445b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e13);
                return null;
            }
        }

        @Override // a9.k
        public String h(SSLSocket sSLSocket, String str, List list) {
            String f10 = f(sSLSocket);
            return f10 == null ? super.h(sSLSocket, str, list) : f10;
        }
    }

    public k(b9.h hVar) {
        this.f448a = (b9.h) Preconditions.checkNotNull(hVar, DispatchConstants.PLATFORM);
    }

    public static k d(ClassLoader classLoader) {
        boolean z10;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e10) {
            f445b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e10);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e11) {
                f445b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e11);
                z10 = false;
            }
        }
        z10 = true;
        return z10 ? new a(f446c) : new k(f446c);
    }

    public static k e() {
        return f447d;
    }

    public static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            q0.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String[] i(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((b9.i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f448a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f448a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String f10 = f(sSLSocket);
            if (f10 != null) {
                return f10;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.f448a.a(sSLSocket);
        }
    }
}
