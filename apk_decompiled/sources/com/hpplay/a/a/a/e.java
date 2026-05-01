package com.hpplay.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private d f7319a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7320b;

    /* renamed from: c, reason: collision with root package name */
    private IOException f7321c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7322d = false;

    /* renamed from: e, reason: collision with root package name */
    private a f7323e;

    public interface a {
        void a();

        void b();
    }

    public e(d dVar, int i10) {
        this.f7319a = dVar;
        this.f7320b = i10;
    }

    public void a(a aVar) {
        this.f7323e = aVar;
    }

    public boolean b() {
        return this.f7322d;
    }

    @Override // java.lang.Runnable
    public void run() {
        InetSocketAddress inetSocketAddress;
        try {
            ServerSocket myServerSocket = this.f7319a.getMyServerSocket();
            if (this.f7319a.hostname != null) {
                d dVar = this.f7319a;
                inetSocketAddress = new InetSocketAddress(dVar.hostname, dVar.myPort);
            } else {
                inetSocketAddress = new InetSocketAddress(this.f7319a.myPort);
            }
            myServerSocket.bind(inetSocketAddress);
            this.f7322d = true;
            a aVar = this.f7323e;
            if (aVar != null) {
                aVar.a();
            }
            do {
                try {
                    Socket accept = this.f7319a.getMyServerSocket().accept();
                    int i10 = this.f7320b;
                    if (i10 > 0) {
                        accept.setSoTimeout(i10);
                    }
                    InputStream inputStream = accept.getInputStream();
                    d dVar2 = this.f7319a;
                    dVar2.asyncRunner.b(dVar2.createClientHandler(accept, inputStream));
                } catch (IOException e10) {
                    d.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e10);
                }
            } while (!this.f7319a.getMyServerSocket().isClosed());
            a aVar2 = this.f7323e;
            if (aVar2 != null) {
                aVar2.b();
            }
        } catch (IOException e11) {
            this.f7321c = e11;
        }
    }

    public IOException a() {
        return this.f7321c;
    }
}
