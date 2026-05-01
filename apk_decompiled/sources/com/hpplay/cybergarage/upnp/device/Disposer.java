package com.hpplay.cybergarage.upnp.device;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.util.ThreadCore;

/* loaded from: classes2.dex */
public class Disposer extends ThreadCore {
    private static final String TAG = "Disposer";
    private ControlPoint ctrlPoint;

    public Disposer(ControlPoint controlPoint) {
        setControlPoint(controlPoint);
    }

    public ControlPoint getControlPoint() {
        return this.ctrlPoint;
    }

    @Override // com.hpplay.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        ControlPoint controlPoint = getControlPoint();
        long expiredDeviceMonitoringInterval = controlPoint.getExpiredDeviceMonitoringInterval() * 1000;
        while (isRunnable()) {
            try {
                CLog.d("checkdev", "Disposer start : " + expiredDeviceMonitoringInterval);
                Thread.sleep(expiredDeviceMonitoringInterval);
                controlPoint.removeExpiredDevices();
            } catch (Exception unused) {
                CLog.w(TAG, "Disposer run Exception");
                return;
            }
        }
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.ctrlPoint = controlPoint;
    }
}
