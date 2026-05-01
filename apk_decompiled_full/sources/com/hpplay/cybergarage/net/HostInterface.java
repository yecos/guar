package com.hpplay.cybergarage.net;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.soap.SOAP;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes2.dex */
public class HostInterface {
    public static final int IPV4_BITMASK = 1;
    public static final int IPV6_BITMASK = 16;
    public static final int LOCAL_BITMASK = 256;
    private static final String TAG = "hpplay-HostInterface";
    public static boolean USE_LOOPBACK_ADDR = false;
    public static boolean USE_ONLY_IPV4_ADDR = true;
    public static boolean USE_ONLY_IPV6_ADDR = false;
    private static String ifAddress = "";

    public static final String getHostAddress(int i10) {
        if (hasAssignedInterface()) {
            return getInterface();
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (isUsableAddress(nextElement)) {
                        if (i11 >= i10) {
                            return nextElement.getHostAddress();
                        }
                        i11++;
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String getHostURL(String str, int i10, String str2) {
        if (isIPv6Address(str)) {
            str = "[" + str + "]";
        }
        return "http://" + str + SOAP.DELIM + Integer.toString(i10) + str2;
    }

    public static final String getIPv4Address() {
        int nHostAddresses = getNHostAddresses();
        for (int i10 = 0; i10 < nHostAddresses; i10++) {
            String hostAddress = getHostAddress(i10);
            if (isIPv4Address(hostAddress)) {
                return hostAddress;
            }
        }
        return "";
    }

    public static final String getIPv6Address() {
        int nHostAddresses = getNHostAddresses();
        for (int i10 = 0; i10 < nHostAddresses; i10++) {
            String hostAddress = getHostAddress(i10);
            if (isIPv6Address(hostAddress)) {
                return hostAddress;
            }
        }
        return "";
    }

    public static final InetAddress[] getInetAddress(int i10, String[] strArr) {
        Enumeration<NetworkInterface> networkInterfaces;
        if (strArr != null) {
            Vector vector = new Vector();
            for (String str : strArr) {
                try {
                    NetworkInterface byName = NetworkInterface.getByName(str);
                    if (byName != null) {
                        vector.add(byName);
                    }
                } catch (SocketException unused) {
                }
            }
            networkInterfaces = vector.elements();
        } else {
            try {
                networkInterfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException unused2) {
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if ((i10 & 256) != 0 || !nextElement.isLoopbackAddress()) {
                    if ((i10 & 1) != 0 && (nextElement instanceof Inet4Address)) {
                        arrayList.add(nextElement);
                    } else if ((i10 & 16) != 0 && (nextElement instanceof InetAddress)) {
                        arrayList.add(nextElement);
                    }
                }
            }
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[0]);
    }

    public static final String getInterface() {
        return ifAddress;
    }

    public static final int getNHostAddresses() {
        if (hasAssignedInterface()) {
            return 1;
        }
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
        }
        return i10;
    }

    private static final boolean hasAssignedInterface() {
        return ifAddress.length() > 0;
    }

    public static final boolean hasIPv4Addresses() {
        int nHostAddresses = getNHostAddresses();
        for (int i10 = 0; i10 < nHostAddresses; i10++) {
            if (isIPv4Address(getHostAddress(i10))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasIPv6Addresses() {
        int nHostAddresses = getNHostAddresses();
        for (int i10 = 0; i10 < nHostAddresses; i10++) {
            if (isIPv6Address(getHostAddress(i10))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isIPv4Address(String str) {
        return InetAddress.getByName(str) instanceof Inet4Address;
    }

    public static final boolean isIPv6Address(String str) {
        return InetAddress.getByName(str) instanceof Inet6Address;
    }

    private static final boolean isUsableAddress(InetAddress inetAddress) {
        if (!USE_LOOPBACK_ADDR && inetAddress.isLoopbackAddress()) {
            return false;
        }
        if (USE_ONLY_IPV4_ADDR && (inetAddress instanceof Inet6Address)) {
            return false;
        }
        return (USE_ONLY_IPV6_ADDR && (inetAddress instanceof Inet4Address)) ? false : true;
    }

    public static final void setInterface(String str) {
        ifAddress = str;
    }
}
