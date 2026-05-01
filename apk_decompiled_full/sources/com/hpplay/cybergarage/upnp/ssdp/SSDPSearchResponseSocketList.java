package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.net.InetAddress;
import java.util.Vector;

/* loaded from: classes2.dex */
public class SSDPSearchResponseSocketList extends Vector {
    private InetAddress[] binds;

    public SSDPSearchResponseSocketList() {
        this.binds = null;
    }

    public void callbackErrorCode() {
        try {
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                SSDPSearchResponseSocket sSDPSearchResponseSocket = getSSDPSearchResponseSocket(i10);
                if (sSDPSearchResponseSocket.getControlPoint() != null) {
                    sSDPSearchResponseSocket.getControlPoint().callbackResultCode(5);
                }
            }
        } catch (Exception e10) {
            CLog.w("SSDPSearchList", e10);
        }
    }

    public void close() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchResponseSocket(i10).close();
        }
        clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSDPSearchResponseSocket getSSDPSearchResponseSocket(int i10) {
        return (SSDPSearchResponseSocket) get(i10);
    }

    public boolean open(int i10) {
        String[] strArr;
        InetAddress[] inetAddressArr = this.binds;
        if (inetAddressArr != null) {
            strArr = new String[inetAddressArr.length];
            for (int i11 = 0; i11 < inetAddressArr.length; i11++) {
                strArr[i11] = inetAddressArr[i11].getHostAddress();
            }
        } else {
            int nHostAddresses = HostInterface.getNHostAddresses();
            strArr = new String[nHostAddresses];
            for (int i12 = 0; i12 < nHostAddresses; i12++) {
                strArr[i12] = HostInterface.getHostAddress(i12);
            }
        }
        for (String str : strArr) {
            try {
                add(new SSDPSearchResponseSocket(str, i10));
            } catch (Exception unused) {
                callbackErrorCode();
                stop();
                close();
                clear();
                return false;
            }
        }
        return true;
    }

    public boolean post(SSDPSearchRequest sSDPSearchRequest) {
        int size = size();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            SSDPSearchResponseSocket sSDPSearchResponseSocket = getSSDPSearchResponseSocket(i10);
            String localAddress = sSDPSearchResponseSocket.getLocalAddress();
            sSDPSearchRequest.setLocalAddress(localAddress);
            if (!sSDPSearchResponseSocket.post(HostInterface.isIPv6Address(localAddress) ? SSDP.getIPv6Address() : SSDP.ADDRESS, SSDP.PORT, sSDPSearchRequest)) {
                z10 = false;
            }
        }
        return z10;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchResponseSocket(i10).setControlPoint(controlPoint);
        }
    }

    public void start() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchResponseSocket(i10).start();
        }
    }

    public void stop() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchResponseSocket(i10).stop();
        }
    }

    public SSDPSearchResponseSocketList(InetAddress[] inetAddressArr) {
        this.binds = inetAddressArr;
    }

    public boolean open() {
        return open(SSDP.PORT);
    }
}
