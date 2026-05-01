package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.Device;

/* loaded from: classes2.dex */
public interface DeviceChangeListener {
    void deviceAdded(int i10, Device device);

    void deviceAdded(Device device);

    void deviceRemoved(Device device);
}
