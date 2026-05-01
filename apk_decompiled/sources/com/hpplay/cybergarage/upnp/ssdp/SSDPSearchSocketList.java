package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.device.SearchListener;
import java.net.InetAddress;
import java.util.Vector;

/* loaded from: classes2.dex */
public class SSDPSearchSocketList extends Vector {
    private static final String TAG = "SSDPSearchSocketList";
    private InetAddress[] binds;
    private String multicastIPv4;
    private String multicastIPv6;
    private int port;

    public SSDPSearchSocketList() {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        this.multicastIPv6 = SSDP.getIPv6Address();
        this.port = SSDP.PORT;
    }

    public void addSearchListener(SearchListener searchListener) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchSocket(i10).addSearchListener(searchListener);
        }
    }

    public void close() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                getSSDPSearchSocket(i10).close();
            } catch (Exception e10) {
                CLog.w(TAG, e10);
                return;
            }
        }
        clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSDPSearchSocket getSSDPSearchSocket(int i10) {
        return (SSDPSearchSocket) get(i10);
    }

    public boolean open() {
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
        for (int i12 = 0; i12 < strArr.length; i12++) {
            String str = strArr[i12];
            if (str != null) {
                add(HostInterface.isIPv6Address(str) ? new SSDPSearchSocket(strArr[i12], this.port, this.multicastIPv6) : new SSDPSearchSocket(strArr[i12], this.port, this.multicastIPv4));
            }
        }
        return true;
    }

    public void start() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchSocket(i10).start();
        }
    }

    public void stop() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            getSSDPSearchSocket(i10).stop();
        }
    }

    public SSDPSearchSocketList(InetAddress[] inetAddressArr) {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        this.multicastIPv6 = SSDP.getIPv6Address();
        this.port = SSDP.PORT;
        this.binds = inetAddressArr;
    }

    public SSDPSearchSocketList(InetAddress[] inetAddressArr, int i10, String str, String str2) {
        this.binds = null;
        this.multicastIPv4 = SSDP.ADDRESS;
        SSDP.getIPv6Address();
        this.binds = inetAddressArr;
        this.port = i10;
        this.multicastIPv4 = str;
        this.multicastIPv6 = str2;
    }
}
