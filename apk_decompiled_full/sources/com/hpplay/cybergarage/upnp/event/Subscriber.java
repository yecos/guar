package com.hpplay.cybergarage.upnp.event;

import java.net.URL;

/* loaded from: classes2.dex */
public class Subscriber {
    private String SID = null;
    private String ifAddr = "";
    private String deliveryURL = "";
    private String deliveryHost = "";
    private String deliveryPath = "";
    private int deliveryPort = 0;
    private long timeOut = 0;
    private long subscriptionTime = 0;
    private long notifyCount = 0;

    public Subscriber() {
        renew();
    }

    public String getDeliveryHost() {
        return this.deliveryHost;
    }

    public String getDeliveryPath() {
        return this.deliveryPath;
    }

    public int getDeliveryPort() {
        return this.deliveryPort;
    }

    public String getDeliveryURL() {
        return this.deliveryURL;
    }

    public String getInterfaceAddress() {
        return this.ifAddr;
    }

    public long getNotifyCount() {
        return this.notifyCount;
    }

    public String getSID() {
        return this.SID;
    }

    public long getSubscriptionTime() {
        return this.subscriptionTime;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public void incrementNotifyCount() {
        long j10 = this.notifyCount;
        if (j10 == Long.MAX_VALUE) {
            this.notifyCount = 1L;
        } else {
            this.notifyCount = j10 + 1;
        }
    }

    public boolean isExpired() {
        return this.timeOut != -1 && getSubscriptionTime() + (getTimeOut() * 1000) < System.currentTimeMillis();
    }

    public void renew() {
        setSubscriptionTime(System.currentTimeMillis());
        setNotifyCount(0);
    }

    public void setDeliveryURL(String str) {
        this.deliveryURL = str;
        try {
            URL url = new URL(str);
            this.deliveryHost = url.getHost();
            this.deliveryPath = url.getPath();
            this.deliveryPort = url.getPort();
        } catch (Exception unused) {
        }
    }

    public void setInterfaceAddress(String str) {
        this.ifAddr = str;
    }

    public void setNotifyCount(int i10) {
        this.notifyCount = i10;
    }

    public void setSID(String str) {
        this.SID = str;
    }

    public void setSubscriptionTime(long j10) {
        this.subscriptionTime = j10;
    }

    public void setTimeOut(long j10) {
        this.timeOut = j10;
    }
}
