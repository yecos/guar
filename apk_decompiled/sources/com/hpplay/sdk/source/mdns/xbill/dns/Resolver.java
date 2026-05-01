package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.List;

/* loaded from: classes3.dex */
public interface Resolver {
    Message send(Message message);

    Object sendAsync(Message message, ResolverListener resolverListener);

    void setEDNS(int i10);

    void setEDNS(int i10, int i11, int i12, List list);

    void setIgnoreTruncation(boolean z10);

    void setPort(int i10);

    void setTCP(boolean z10);

    void setTSIGKey(TSIG tsig);

    void setTimeout(int i10);

    void setTimeout(int i10, int i11);
}
