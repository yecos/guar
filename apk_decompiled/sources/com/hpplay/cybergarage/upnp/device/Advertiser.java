package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.util.ThreadCore;

/* loaded from: classes2.dex */
public class Advertiser extends ThreadCore {
    private Device device;

    public Advertiser(Device device) {
        setDevice(device);
    }

    public Device getDevice() {
        return this.device;
    }

    @Override // com.hpplay.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        Device device = getDevice();
        long leaseTime = device.getLeaseTime();
        while (isRunnable()) {
            double d10 = leaseTime;
            double random = Math.random() * 0.25d;
            Double.isNaN(d10);
            try {
                Thread.sleep(((leaseTime / 4) + ((long) (d10 * random))) * 1000);
            } catch (InterruptedException unused) {
            }
            device.announce();
        }
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
