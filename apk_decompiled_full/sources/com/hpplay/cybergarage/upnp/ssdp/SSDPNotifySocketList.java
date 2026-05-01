package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.net.InetAddress;
import java.util.Vector;

/* loaded from: classes2.dex */
public class SSDPNotifySocketList extends Vector {
    private InetAddress[] binds;

    public SSDPNotifySocketList() {
        this.binds = null;
    }

    public void close() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                getSSDPNotifySocket(i10).close();
            } catch (Exception e10) {
                CLog.w("ssdpnotify", e10);
            }
        }
        clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSDPNotifySocket getSSDPNotifySocket(int i10) {
        return (SSDPNotifySocket) get(i10);
    }

    public boolean isRuning() {
        try {
            if (size() > 0 && getSSDPNotifySocket(0) != null) {
                return getSSDPNotifySocket(0).isRuning();
            }
        } catch (Exception e10) {
            CLog.w("ssdpnotify", e10);
        }
        return false;
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
        for (String str : strArr) {
            if (str != null) {
                add(new SSDPNotifySocket(str));
            }
        }
        return true;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                getSSDPNotifySocket(i10).setControlPoint(controlPoint);
            } catch (Exception e10) {
                CLog.w("ssdpnotify", e10);
                return;
            }
        }
    }

    public void start() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                getSSDPNotifySocket(i10).start();
            } catch (Exception e10) {
                CLog.w("ssdpnotify", e10);
                return;
            }
        }
    }

    public void stop() {
        try {
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                getSSDPNotifySocket(i10).stop();
            }
        } catch (Exception e10) {
            CLog.w("ssdpnotify", e10);
        }
    }

    public SSDPNotifySocketList(InetAddress[] inetAddressArr) {
        this.binds = inetAddressArr;
    }
}
