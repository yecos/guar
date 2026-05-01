package com.hpplay.a.a.a.d;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: classes2.dex */
public class b implements com.hpplay.a.b.b<ServerSocket, IOException> {

    /* renamed from: a, reason: collision with root package name */
    private SSLServerSocketFactory f7317a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f7318b;

    public b(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.f7317a = sSLServerSocketFactory;
        this.f7318b = strArr;
    }

    @Override // com.hpplay.a.b.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ServerSocket b() {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f7317a.createServerSocket();
        String[] strArr = this.f7318b;
        if (strArr != null) {
            sSLServerSocket.setEnabledProtocols(strArr);
        } else {
            sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
        }
        sSLServerSocket.setUseClientMode(false);
        sSLServerSocket.setWantClientAuth(false);
        sSLServerSocket.setNeedClientAuth(false);
        return sSLServerSocket;
    }
}
