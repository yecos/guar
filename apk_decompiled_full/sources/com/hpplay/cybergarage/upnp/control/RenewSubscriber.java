package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.util.ThreadCore;

/* loaded from: classes2.dex */
public class RenewSubscriber extends ThreadCore {
    public static final long INTERVAL = 120;
    private ControlPoint ctrlPoint;

    public RenewSubscriber(ControlPoint controlPoint) {
        setControlPoint(controlPoint);
    }

    public ControlPoint getControlPoint() {
        return this.ctrlPoint;
    }

    @Override // com.hpplay.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        ControlPoint controlPoint = getControlPoint();
        while (isRunnable()) {
            try {
                Thread.sleep(120000L);
            } catch (InterruptedException unused) {
            }
            controlPoint.renewSubscriberService();
        }
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.ctrlPoint = controlPoint;
    }
}
