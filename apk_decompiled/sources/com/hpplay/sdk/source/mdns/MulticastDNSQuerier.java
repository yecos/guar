package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.Resolver;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.TSIG;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class MulticastDNSQuerier implements Querier {
    private Querier ipv4Responder;
    private Querier ipv6Responder;
    protected boolean mIpv4;
    protected boolean mIpv6;
    private ResolverListener mResolverListener;
    protected Resolver[] mUnicastResolvers;
    private boolean mdnsVerbose;
    protected Querier[] multicastResponders;
    protected ResolverListener resolverDispatch;

    public MulticastDNSQuerier() {
        this(true, false, new Resolver[]{new ExtendedResolver()});
    }

    private boolean getNetWorkInfos(boolean z10, boolean z11, Resolver[] resolverArr) {
        Querier querier;
        this.mdnsVerbose = Options.check("mdns_verbose");
        if (resolverArr == null || resolverArr.length == 0) {
            this.mUnicastResolvers = new Resolver[]{new ExtendedResolver()};
        } else {
            this.mUnicastResolvers = resolverArr;
        }
        IOException iOException = null;
        if (z10) {
            try {
                this.ipv4Responder = new MulticastDNSMulticastOnlyQuerier(false);
                this.mIpv4 = true;
            } catch (Exception e10) {
                e = e10;
                this.ipv4Responder = null;
            }
        }
        e = null;
        if (z11) {
            try {
                this.ipv6Responder = new MulticastDNSMulticastOnlyQuerier(true);
                this.mIpv6 = true;
            } catch (IOException e11) {
                this.ipv6Responder = null;
                iOException = e11;
            }
        }
        Querier querier2 = this.ipv4Responder;
        if (querier2 != null && (querier = this.ipv6Responder) != null) {
            this.multicastResponders = new Querier[]{querier2, querier};
            querier2.registerListener(this.resolverDispatch);
            this.ipv6Responder.registerListener(this.resolverDispatch);
            return true;
        }
        if (querier2 != null) {
            this.multicastResponders = new Querier[]{querier2};
            querier2.registerListener(this.resolverDispatch);
            return true;
        }
        Querier querier3 = this.ipv6Responder;
        if (querier3 != null) {
            this.multicastResponders = new Querier[]{querier3};
            querier3.registerListener(this.resolverDispatch);
            return true;
        }
        if (e != null) {
            throw e;
        }
        if (iOException == null) {
            return false;
        }
        throw iOException;
    }

    public static boolean isMulticastDomain(Name name) {
        for (Name name2 : Constants.IPv4_MULTICAST_DOMAINS) {
            if (name.equals(name2) || name.subdomain(name2)) {
                return true;
            }
        }
        for (Name name3 : Constants.IPv6_MULTICAST_DOMAINS) {
            if (name.equals(name3) || name.subdomain(name3)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void broadcast(Message message, boolean z10) {
        IOException e10 = null;
        boolean z11 = false;
        for (Querier querier : this.multicastResponders) {
            try {
                querier.broadcast(message, z10);
                z11 = true;
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.sendAsync(message, new ResolverListener() { // from class: com.hpplay.sdk.source.mdns.MulticastDNSQuerier.2
                @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
                public void handleException(Object obj, Exception exc) {
                    if (MulticastDNSQuerier.this.mResolverListener != null) {
                        MulticastDNSQuerier.this.mResolverListener.handleException(obj, exc);
                    }
                }

                @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
                public void receiveMessage(Object obj, Message message2) {
                    if (MulticastDNSQuerier.this.mResolverListener != null) {
                        MulticastDNSQuerier.this.mResolverListener.receiveMessage(obj, message2);
                    }
                }
            });
        }
        if (!z11 && e10 != null) {
            throw e10;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (Querier querier : this.multicastResponders) {
            try {
                querier.close();
            } catch (Exception unused) {
            }
        }
        this.ipv4Responder = null;
        this.ipv6Responder = null;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public Name[] getMulticastDomains() {
        boolean z10 = this.mIpv4;
        return (z10 && this.mIpv6) ? Constants.ALL_MULTICAST_DNS_DOMAINS : z10 ? Constants.IPv4_MULTICAST_DOMAINS : this.mIpv6 ? Constants.IPv6_MULTICAST_DOMAINS : new Name[0];
    }

    public Resolver[] getmUnicastResolvers() {
        return this.mUnicastResolvers;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean initNetWorkState() {
        return getNetWorkInfos(this.mIpv4, this.mIpv6, this.mUnicastResolvers);
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isIPv4() {
        return this.mIpv4;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isIPv6() {
        return this.mIpv6;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isOperational() {
        for (Querier querier : this.multicastResponders) {
            if (!querier.isOperational()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public ResolverListener registerListener(ResolverListener resolverListener) {
        for (Querier querier : this.multicastResponders) {
            this.mResolverListener = querier.registerListener(resolverListener);
        }
        return resolverListener;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Message send(Message message) {
        Resolution resolution = new Resolution(this, message, null);
        resolution.start();
        return resolution.getResponse(Querier.DEFAULT_TIMEOUT);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Resolution resolution = new Resolution(this, message, resolverListener);
        resolution.start();
        return resolution;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10) {
        for (Querier querier : this.multicastResponders) {
            querier.setEDNS(i10);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setEDNS(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setIgnoreTruncation(boolean z10) {
        for (Querier querier : this.multicastResponders) {
            querier.setIgnoreTruncation(z10);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setIgnoreTruncation(z10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setPort(int i10) {
        for (Querier querier : this.multicastResponders) {
            querier.setPort(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void setRetryWaitTime(int i10) {
        for (Querier querier : this.multicastResponders) {
            querier.setTimeout(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTCP(boolean z10) {
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setTCP(z10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTSIGKey(TSIG tsig) {
        for (Querier querier : this.multicastResponders) {
            querier.setTSIGKey(tsig);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setTSIGKey(tsig);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10) {
        for (Querier querier : this.multicastResponders) {
            querier.setTimeout(i10);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setTimeout(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean unregisterListener(ResolverListener resolverListener) {
        for (Querier querier : this.multicastResponders) {
            querier.unregisterListener(resolverListener);
        }
        return true;
    }

    public MulticastDNSQuerier(boolean z10, boolean z11) {
        this(z10, z11, (Resolver[]) null);
    }

    public MulticastDNSQuerier(boolean z10, boolean z11, Resolver resolver) {
        this(z10, z11, new Resolver[]{resolver});
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void setRetryWaitTime(int i10, int i11) {
        for (Querier querier : this.multicastResponders) {
            querier.setTimeout(i10, i11);
        }
    }

    public MulticastDNSQuerier(boolean z10, boolean z11, Resolver[] resolverArr) {
        this.mIpv4 = false;
        this.mIpv6 = false;
        this.resolverDispatch = new ResolverListener() { // from class: com.hpplay.sdk.source.mdns.MulticastDNSQuerier.1
            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void handleException(Object obj, Exception exc) {
                if (MulticastDNSQuerier.this.mResolverListener != null) {
                    MulticastDNSQuerier.this.mResolverListener.handleException(obj, exc);
                }
            }

            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void receiveMessage(Object obj, Message message) {
                if (MulticastDNSQuerier.this.mResolverListener != null) {
                    MulticastDNSQuerier.this.mResolverListener.receiveMessage(obj, message);
                }
            }
        };
        this.ipv4Responder = null;
        this.ipv6Responder = null;
        this.mIpv4 = z10;
        this.mIpv6 = z11;
        this.mUnicastResolvers = resolverArr;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10, int i11, int i12, List list) {
        for (Querier querier : this.multicastResponders) {
            querier.setEDNS(i10, i11, i12, list);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setEDNS(i10, i11, i12, list);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10, int i11) {
        for (Querier querier : this.multicastResponders) {
            querier.setTimeout(i10, i11);
        }
        for (Resolver resolver : this.mUnicastResolvers) {
            resolver.setTimeout(i10, i11);
        }
    }
}
