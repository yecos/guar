package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.Device;
import java.net.InetAddress;
import java.util.Vector;

/* loaded from: classes2.dex */
public class HTTPServerList extends Vector {
    private static final String TAG = "HTTPServerList";
    private InetAddress[] binds;
    private int port;

    public HTTPServerList() {
        this.binds = null;
        this.port = Device.HTTP_DEFAULT_PORT;
    }

    public void addRequestListener(HTTPRequestListener hTTPRequestListener) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getHTTPServer(i10).addRequestListener(hTTPRequestListener);
        }
    }

    public void close() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getHTTPServer(i10).close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HTTPServer getHTTPServer(int i10) {
        return (HTTPServer) get(i10);
    }

    public boolean isRuning() {
        if (size() <= 0 || getHTTPServer(0) == null) {
            return false;
        }
        return getHTTPServer(0).isRunning();
    }

    public int open() {
        String[] strArr;
        InetAddress[] inetAddressArr = this.binds;
        if (inetAddressArr != null) {
            strArr = new String[inetAddressArr.length];
            for (int i10 = 0; i10 < inetAddressArr.length; i10++) {
                strArr[i10] = inetAddressArr[i10].getHostAddress();
            }
        } else {
            int nHostAddresses = HostInterface.getNHostAddresses();
            strArr = new String[nHostAddresses];
            for (int i11 = 0; i11 < nHostAddresses; i11++) {
                strArr[i11] = HostInterface.getHostAddress(i11);
            }
        }
        int i12 = 0;
        for (String str : strArr) {
            HTTPServer hTTPServer = new HTTPServer();
            if (str != null && hTTPServer.open(str, this.port)) {
                add(hTTPServer);
                i12++;
            } else if (i12 == 0) {
                close();
                clear();
            }
        }
        return i12;
    }

    public void start() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                getHTTPServer(i10).start();
            } catch (Exception e10) {
                CLog.w(TAG, e10);
                return;
            }
        }
    }

    public void stop() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getHTTPServer(i10).stop();
        }
    }

    public HTTPServerList(InetAddress[] inetAddressArr, int i10) {
        this.binds = inetAddressArr;
        this.port = i10;
    }

    public boolean open(int i10) {
        this.port = i10;
        return open() != 0;
    }
}
