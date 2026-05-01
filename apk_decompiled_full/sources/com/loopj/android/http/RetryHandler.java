package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
class RetryHandler implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> exceptionBlacklist;
    private static final HashSet<Class<?>> exceptionWhitelist;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        exceptionWhitelist = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        exceptionBlacklist = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    public RetryHandler(int i10, int i11) {
        this.maxRetries = i10;
        this.retrySleepTimeMS = i11;
    }

    public static void addClassToBlacklist(Class<?> cls) {
        exceptionBlacklist.add(cls);
    }

    public static void addClassToWhitelist(Class<?> cls) {
        exceptionWhitelist.add(cls);
    }

    public boolean isInList(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (isInList(com.loopj.android.http.RetryHandler.exceptionBlacklist, r3) == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    @Override // org.apache.http.client.HttpRequestRetryHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean retryRequest(IOException iOException, int i10, HttpContext httpContext) {
        boolean z10;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        if (i10 <= this.maxRetries) {
            z10 = true;
            if (!isInList(exceptionWhitelist, iOException)) {
            }
            if (!z10 && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
                return false;
            }
            if (z10) {
                iOException.printStackTrace();
            } else {
                SystemClock.sleep(this.retrySleepTimeMS);
            }
            return z10;
        }
        z10 = false;
        if (!z10) {
        }
        if (z10) {
        }
        return z10;
    }
}
