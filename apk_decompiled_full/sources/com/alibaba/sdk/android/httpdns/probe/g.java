package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.i;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private CountDownLatch f5948a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5949b;

    /* renamed from: o, reason: collision with root package name */
    private String f5950o;
    private int port;

    public g(String str, int i10, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.f5950o = str;
        this.port = i10;
        this.f5948a = countDownLatch;
        this.f5949b = concurrentHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long a(String str, int i10) {
        long j10;
        Socket socket;
        long currentTimeMillis = System.currentTimeMillis();
        Socket socket2 = null;
        try {
            try {
                socket = new Socket();
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            socket.connect(new InetSocketAddress(str, i10), com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
            j10 = System.currentTimeMillis();
            try {
                socket.close();
            } catch (IOException e11) {
                i.f("socket close failed:" + e11.toString());
            }
        } catch (IOException e12) {
            e = e12;
            socket2 = socket;
            i.f("connect failed:" + e.toString());
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e13) {
                    i.f("socket close failed:" + e13.toString());
                }
            }
            j10 = 2147483647L;
            if (j10 != TTL.MAX_VALUE) {
            }
        } catch (Throwable th2) {
            th = th2;
            socket2 = socket;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e14) {
                    i.f("socket close failed:" + e14.toString());
                }
            }
            throw th;
        }
        return j10 != TTL.MAX_VALUE ? TTL.MAX_VALUE : j10 - currentTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000d, B:9:0x0037, B:10:0x0046, B:12:0x004a, B:17:0x0041), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CountDownLatch countDownLatch;
        try {
            if (this.f5950o != null && a(this.port)) {
                long a10 = a(this.f5950o, this.port);
                i.d("connect cost for ip:" + this.f5950o + " is " + a10);
                ConcurrentHashMap<String, Long> concurrentHashMap = this.f5949b;
                if (concurrentHashMap != null) {
                    concurrentHashMap.put(this.f5950o, Long.valueOf(a10));
                }
                countDownLatch = this.f5948a;
                if (countDownLatch == null) {
                    countDownLatch.countDown();
                    return;
                }
                return;
            }
            i.f("invalid params, give up");
            countDownLatch = this.f5948a;
            if (countDownLatch == null) {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private boolean a(int i10) {
        return i10 >= 1 && i10 <= 65535;
    }
}
