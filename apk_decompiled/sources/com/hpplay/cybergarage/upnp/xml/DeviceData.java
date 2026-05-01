package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.http.HTTPServerList;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.device.Advertiser;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import com.hpplay.cybergarage.util.ListenerList;
import java.io.File;
import java.net.InetAddress;

/* loaded from: classes2.dex */
public class DeviceData extends NodeData {
    private String descriptionURI = null;
    private File descriptionFile = null;
    private String location = "";
    private int leaseTime = 30;
    private HTTPServerList httpServerList = null;
    private InetAddress[] httpBinds = null;
    private int httpPort = Device.HTTP_DEFAULT_PORT;
    private ListenerList controlActionListenerList = new ListenerList();
    private SSDPSearchSocketList ssdpSearchSocketList = null;
    private String ssdpMulticastIPv4 = SSDP.ADDRESS;
    private String ssdpMulticastIPv6 = SSDP.getIPv6Address();
    private int ssdpPort = SSDP.PORT;
    private InetAddress[] ssdpBinds = null;
    private SSDPPacket ssdpPacket = null;
    private Advertiser advertiser = null;

    public Advertiser getAdvertiser() {
        return this.advertiser;
    }

    public ListenerList getControlActionListenerList() {
        return this.controlActionListenerList;
    }

    public File getDescriptionFile() {
        return this.descriptionFile;
    }

    public String getDescriptionURI() {
        return this.descriptionURI;
    }

    public InetAddress[] getHTTPBindAddress() {
        return this.httpBinds;
    }

    public int getHTTPPort() {
        return this.httpPort;
    }

    public HTTPServerList getHTTPServerList() {
        if (this.httpServerList == null) {
            this.httpServerList = new HTTPServerList(this.httpBinds, this.httpPort);
        }
        return this.httpServerList;
    }

    public int getLeaseTime() {
        return this.leaseTime;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMulticastIPv4Address() {
        return this.ssdpMulticastIPv4;
    }

    public String getMulticastIPv6Address() {
        return this.ssdpMulticastIPv6;
    }

    public InetAddress[] getSSDPBindAddress() {
        return this.ssdpBinds;
    }

    public SSDPPacket getSSDPPacket() {
        return this.ssdpPacket;
    }

    public int getSSDPPort() {
        return this.ssdpPort;
    }

    public SSDPSearchSocketList getSSDPSearchSocketList() {
        if (this.ssdpSearchSocketList == null) {
            this.ssdpSearchSocketList = new SSDPSearchSocketList(this.ssdpBinds, this.ssdpPort, this.ssdpMulticastIPv4, this.ssdpMulticastIPv6);
        }
        return this.ssdpSearchSocketList;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public void setDescriptionFile(File file) {
        this.descriptionFile = file;
    }

    public void setDescriptionURI(String str) {
        this.descriptionURI = str;
    }

    public void setHTTPBindAddress(InetAddress[] inetAddressArr) {
        this.httpBinds = inetAddressArr;
    }

    public void setHTTPPort(int i10) {
        this.httpPort = i10;
    }

    public void setLeaseTime(int i10) {
        this.leaseTime = i10;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMulticastIPv4Address(String str) {
        this.ssdpMulticastIPv4 = str;
    }

    public void setMulticastIPv6Address(String str) {
        this.ssdpMulticastIPv6 = str;
    }

    public void setSSDPBindAddress(InetAddress[] inetAddressArr) {
        this.ssdpBinds = inetAddressArr;
    }

    public void setSSDPPacket(SSDPPacket sSDPPacket) {
        this.ssdpPacket = sSDPPacket;
    }

    public void setSSDPPort(int i10) {
        this.ssdpPort = i10;
    }
}
