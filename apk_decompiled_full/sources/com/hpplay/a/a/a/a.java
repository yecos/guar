package com.hpplay.a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final d f7212a;

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f7213b;

    /* renamed from: c, reason: collision with root package name */
    private final Socket f7214c;

    public a(d dVar, InputStream inputStream, Socket socket) {
        this.f7212a = dVar;
        this.f7213b = inputStream;
        this.f7214c = socket;
    }

    public void a() {
        d.safeClose(this.f7213b);
        d.safeClose(this.f7214c);
    }

    @Override // java.lang.Runnable
    public void run() {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = this.f7214c.getOutputStream();
                b bVar = new b(this.f7212a, this.f7212a.getTempFileManagerFactory().b(), this.f7213b, outputStream, this.f7214c.getInetAddress());
                while (!this.f7214c.isClosed()) {
                    bVar.a();
                }
            } catch (Exception e10) {
                if ((!(e10 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e10.getMessage())) && !(e10 instanceof SocketTimeoutException)) {
                    d.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e10);
                }
            }
        } finally {
            d.safeClose(outputStream);
            d.safeClose(this.f7213b);
            d.safeClose(this.f7214c);
            this.f7212a.asyncRunner.a(this);
        }
    }
}
