package o2;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConnectionPool f17475a = new ConnectionPool(5, 2, TimeUnit.MINUTES);

    public static synchronized ConnectionPool a() {
        ConnectionPool connectionPool;
        synchronized (a.class) {
            connectionPool = f17475a;
        }
        return connectionPool;
    }
}
