package com.hpplay.a.b;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f7330a = Logger.getLogger(d.class.getName());

    public static void a(com.hpplay.a.a.a.d dVar) {
        try {
            dVar.start(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e10) {
            System.err.println("Couldn't start server:\n" + e10);
            System.exit(-1);
        }
        System.out.println("Server started, Hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (Throwable unused) {
        }
        dVar.stop();
        System.out.println("Server stopped.\n");
    }

    public static <T extends com.hpplay.a.a.a.d> void a(Class<T> cls) {
        try {
            a(cls.newInstance());
        } catch (Exception e10) {
            f7330a.log(Level.SEVERE, "Could not create server", (Throwable) e10);
        }
    }
}
