package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;

/* loaded from: classes3.dex */
public interface DNSSDListener {
    void handleException(Object obj, Exception exc);

    void receiveMessage(Object obj, Message message);

    void serviceDiscovered(Object obj, ServiceInstance serviceInstance);

    void serviceRemoved(Object obj, ServiceInstance serviceInstance);
}
