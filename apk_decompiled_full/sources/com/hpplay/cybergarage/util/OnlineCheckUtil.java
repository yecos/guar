package com.hpplay.cybergarage.util;

import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/* loaded from: classes2.dex */
public class OnlineCheckUtil {
    private static final String TAG = "OnlineCheckUtil";
    private static final int TCP_TIMEOUT = 3000;

    public static int getAvailablePort() {
        Random random = new Random();
        int i10 = 10090;
        try {
            i10 = random.nextInt(10000) + 10000 + random.nextInt(100);
            for (int i11 = i10; i11 <= 65535; i11++) {
                try {
                    new ServerSocket(i11).close();
                    CLog.i(TAG, "get availabel port " + i11);
                    return i11;
                } catch (IOException unused) {
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return i10;
    }

    private static String matchLocalIp(String str) {
        String str2 = null;
        try {
            String substring = str.substring(0, str.lastIndexOf("."));
            int nHostAddresses = HostInterface.getNHostAddresses();
            for (int i10 = 0; i10 < nHostAddresses; i10++) {
                String hostAddress = HostInterface.getHostAddress(i10);
                if (hostAddress.contains(substring)) {
                    str2 = hostAddress;
                }
                CLog.i(TAG, "check local host ====> " + hostAddress.replace(".", ""));
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return str2;
    }

    public static boolean tcpCheckTvState(String str, int i10) {
        boolean z10;
        Socket socket;
        Socket socket2 = null;
        try {
            try {
                socket = new Socket();
                z10 = true;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            socket.setReuseAddress(true);
            socket.setSoTimeout(3000);
            String matchLocalIp = matchLocalIp(str);
            if (TextUtils.isEmpty(matchLocalIp)) {
                socket.connect(new InetSocketAddress(str, i10), 3000);
            } else {
                InetAddress byName = InetAddress.getByName(str);
                socket.bind(new InetSocketAddress(InetAddress.getByName(matchLocalIp), getAvailablePort()));
                socket.connect(new InetSocketAddress(byName, i10), 3000);
            }
            try {
                socket.close();
            } catch (IOException e10) {
                CLog.w(TAG, e10);
            }
        } catch (Exception unused2) {
            socket2 = socket;
            CLog.w(TAG, "local device : " + str.replace(".", "") + " is offline");
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e11) {
                    CLog.w(TAG, e11);
                }
            }
            z10 = false;
            CLog.i(TAG, "  check dev state " + z10);
            return z10;
        } catch (Throwable th2) {
            th = th2;
            socket2 = socket;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e12) {
                    CLog.w(TAG, e12);
                }
            }
            throw th;
        }
        CLog.i(TAG, "  check dev state " + z10);
        return z10;
    }
}
