package com.hpplay.component.dlna;

import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.upnp.event.EventListener;

/* loaded from: classes2.dex */
public class UPNPSubscriber {
    private static UPNPSubscriber mSubscriber;
    private ControlPoint mControlPoint;

    public static synchronized UPNPSubscriber getInstance() {
        UPNPSubscriber uPNPSubscriber;
        synchronized (UPNPSubscriber.class) {
            if (mSubscriber == null) {
                mSubscriber = new UPNPSubscriber();
            }
            uPNPSubscriber = mSubscriber;
        }
        return uPNPSubscriber;
    }

    public void removeSubscribeEventListener(EventListener eventListener) {
        ControlPoint controlPoint = this.mControlPoint;
        if (controlPoint != null) {
            controlPoint.removeEventListener(eventListener);
        }
    }

    public void setSubscribeEventListener(EventListener eventListener) {
        ControlPoint controlPoint = this.mControlPoint;
        if (controlPoint != null) {
            controlPoint.addEventListener(eventListener);
        }
    }

    public void startSubscribeServ(String str) {
        if (this.mControlPoint == null) {
            this.mControlPoint = new ControlPoint(str);
        }
        this.mControlPoint.startSucribeServ();
    }

    public boolean subscribePlayEvent(Device device) {
        Service service;
        if (this.mControlPoint == null || (service = device.getService(DLNASender.AV_TRANSPORT_1)) == null) {
            return false;
        }
        return this.mControlPoint.subscribe(service);
    }

    public void unSubscribe(Device device) {
        ControlPoint controlPoint = this.mControlPoint;
        if (controlPoint != null) {
            controlPoint.unsubscribe(device);
        }
    }
}
