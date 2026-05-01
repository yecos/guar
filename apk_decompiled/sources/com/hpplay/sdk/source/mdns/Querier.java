package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.Resolver;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.io.Closeable;

/* loaded from: classes3.dex */
public interface Querier extends Resolver, Closeable {
    public static final int DEFAULT_RESPONSE_WAIT_TIME = 500;
    public static final int DEFAULT_RETRY_INTERVAL = 1000;
    public static final int DEFAULT_TIMEOUT = 6000;
    public static final int DEFAULT_UDPSIZE = 512;

    void broadcast(Message message, boolean z10);

    Name[] getMulticastDomains();

    boolean initNetWorkState();

    boolean isIPv4();

    boolean isIPv6();

    boolean isOperational();

    ResolverListener registerListener(ResolverListener resolverListener);

    void setRetryWaitTime(int i10);

    void setRetryWaitTime(int i10, int i11);

    boolean unregisterListener(ResolverListener resolverListener);
}
