package com.hpplay.cybergarage.upnp.ssdp;

import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPHeader;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.device.MAN;
import com.hpplay.cybergarage.upnp.device.NT;
import com.hpplay.cybergarage.upnp.device.NTS;
import com.hpplay.cybergarage.upnp.device.ST;
import com.hpplay.cybergarage.upnp.device.USN;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public class SSDPPacket {
    private DatagramPacket dgmPacket;
    private String localAddr = "";
    public byte[] packetBytes = null;
    private long timeStamp;

    public SSDPPacket(byte[] bArr, int i10) {
        this.dgmPacket = null;
        this.dgmPacket = new DatagramPacket(bArr, i10);
    }

    public String getCacheControl() {
        return HTTPHeader.getValue(getData(), "Cache-Control");
    }

    public byte[] getData() {
        byte[] bArr = this.packetBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
            DatagramPacket datagramPacket = getDatagramPacket();
            this.packetBytes = new String(datagramPacket.getData(), 0, datagramPacket.getLength()).getBytes();
        } catch (Exception e10) {
            CLog.W("SSDPP", e10);
        }
        return this.packetBytes;
    }

    public DatagramPacket getDatagramPacket() {
        return this.dgmPacket;
    }

    public String getHost() {
        return HTTPHeader.getValue(getData(), HTTP.HOST);
    }

    public InetAddress getHostInetAddress() {
        String str;
        String host = getHost();
        int lastIndexOf = host.lastIndexOf(SOAP.DELIM);
        if (lastIndexOf >= 0) {
            str = host.substring(0, lastIndexOf);
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length());
            }
            if (str.charAt(str.length() - 1) == ']') {
                str = str.substring(0, str.length() - 1);
            }
        } else {
            str = "127.0.0.1";
        }
        return new InetSocketAddress(str, 0).getAddress();
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getCacheControl());
    }

    public String getLocalAddress() {
        return this.localAddr;
    }

    public String getLocation() {
        return HTTPHeader.getValue(getData(), "Location");
    }

    public String getMAN() {
        return HTTPHeader.getValue(getData(), HTTP.MAN);
    }

    public int getMX() {
        return HTTPHeader.getIntegerValue(getData(), HTTP.MX);
    }

    public String getNT() {
        return HTTPHeader.getValue(getData(), HTTP.NT);
    }

    public String getNTS() {
        return HTTPHeader.getValue(getData(), HTTP.NTS);
    }

    public String getOpt() {
        return HTTPHeader.getValue(getData(), HTTP.OPT);
    }

    public String getRemoteAddress() {
        return getDatagramPacket().getAddress().getHostAddress();
    }

    public InetAddress getRemoteInetAddress() {
        return getDatagramPacket().getAddress();
    }

    public int getRemotePort() {
        return getDatagramPacket().getPort();
    }

    public String getST() {
        return HTTPHeader.getValue(getData(), HTTP.ST);
    }

    public String getServer() {
        return HTTPHeader.getValue(getData(), "Server");
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getUSN() {
        return HTTPHeader.getValue(getData(), HTTP.USN);
    }

    public boolean isAlive() {
        return NTS.isAlive(getNTS());
    }

    public boolean isByeBye() {
        return NTS.isByeBye(getNTS());
    }

    public boolean isDiscover() {
        return MAN.isDiscover(getMAN());
    }

    public boolean isRootDevice() {
        if (NT.isRootDevice(getNT()) || ST.isRootDevice(getST()) || TextUtils.equals(getST(), ST.MEDIA_RENDER)) {
            return true;
        }
        return USN.isRootDevice(getUSN());
    }

    public void setLocalAddress(String str) {
        this.localAddr = str;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return new String(getData());
    }
}
