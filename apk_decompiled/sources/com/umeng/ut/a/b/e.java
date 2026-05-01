package com.umeng.ut.a.b;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
class e extends SSLSocketFactory {

    /* renamed from: b, reason: collision with root package name */
    private String f12357b;

    /* renamed from: a, reason: collision with root package name */
    private Method f12356a = null;
    private HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public e(String str) {
        this.f12357b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return null;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f12357b) || !(obj instanceof e)) {
            return false;
        }
        String str = ((e) obj).f12357b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f12357b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        SSLSocket sSLSocket;
        com.umeng.ut.a.c.e.b("", "peerHost", this.f12357b, Constants.KEY_HOST, str, "port", Integer.valueOf(i10), "autoClose", Boolean.valueOf(z10));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            sSLCertificateSocketFactory.setTrustManagers(f.getTrustManagers());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(c.getTrustManagers());
        }
        com.umeng.ut.a.c.e.m72a("", "createSocket");
        if (i11 < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z10) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i10);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f12357b, i10, true);
        }
        com.umeng.ut.a.c.e.m72a("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLCertificateSocketFactory.setHostname(sSLSocket, this.f12357b);
        SSLSession session = sSLSocket.getSession();
        if (this.hostnameVerifier.verify(this.f12357b, session)) {
            com.umeng.ut.a.c.e.b("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f12357b);
    }
}
