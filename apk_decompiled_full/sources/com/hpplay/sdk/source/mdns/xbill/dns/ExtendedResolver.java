package com.hpplay.sdk.source.mdns.xbill.dns;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtendedResolver implements Resolver {
    private static final int quantum = 5;
    private List resolvers;
    private boolean loadBalance = false;
    private int lbStart = 0;
    private int retries = 3;

    public static class Resolution implements ResolverListener {
        boolean done;
        Object[] inprogress;
        ResolverListener listener;
        int outstanding;
        Message query;
        Resolver[] resolvers;
        Message response;
        int retries;
        int[] sent;
        Throwable thrown;

        public Resolution(ExtendedResolver extendedResolver, Message message) {
            List list = extendedResolver.resolvers;
            this.resolvers = (Resolver[]) list.toArray(new Resolver[list.size()]);
            if (extendedResolver.loadBalance) {
                int length = this.resolvers.length;
                int access$208 = ExtendedResolver.access$208(extendedResolver) % length;
                if (extendedResolver.lbStart > length) {
                    extendedResolver.lbStart = length;
                }
                if (access$208 > 0) {
                    Resolver[] resolverArr = new Resolver[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        resolverArr[i10] = this.resolvers[(i10 + access$208) % length];
                    }
                    this.resolvers = resolverArr;
                }
            }
            Resolver[] resolverArr2 = this.resolvers;
            this.sent = new int[resolverArr2.length];
            this.inprogress = new Object[resolverArr2.length];
            this.retries = extendedResolver.retries;
            this.query = message;
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
        public void handleException(Object obj, Exception exc) {
            Object[] objArr;
            if (Options.check("verbose")) {
                System.err.println("ExtendedResolver: got " + exc);
            }
            synchronized (this) {
                this.outstanding--;
                if (this.done) {
                    return;
                }
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    objArr = this.inprogress;
                    if (i10 >= objArr.length || objArr[i10] == obj) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 == objArr.length) {
                    return;
                }
                int i11 = this.sent[i10];
                if (i11 == 1 && i10 < this.resolvers.length - 1) {
                    z10 = true;
                }
                if (exc instanceof InterruptedIOException) {
                    if (i11 < this.retries) {
                        send(i10);
                    }
                    if (this.thrown == null) {
                        this.thrown = exc;
                    }
                } else if (exc instanceof SocketException) {
                    Throwable th = this.thrown;
                    if (th == null || (th instanceof InterruptedIOException)) {
                        this.thrown = exc;
                    }
                } else {
                    this.thrown = exc;
                }
                if (this.done) {
                    return;
                }
                if (z10) {
                    send(i10 + 1);
                }
                if (this.done) {
                    return;
                }
                if (this.outstanding == 0) {
                    this.done = true;
                    if (this.listener == null) {
                        notifyAll();
                        return;
                    }
                }
                if (this.done) {
                    if (!(this.thrown instanceof Exception)) {
                        this.thrown = new RuntimeException(this.thrown.getMessage());
                    }
                    this.listener.handleException(this, (Exception) this.thrown);
                }
            }
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
        public void receiveMessage(Object obj, Message message) {
            if (Options.check("verbose")) {
                System.err.println("ExtendedResolver: received message");
            }
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.response = message;
                this.done = true;
                ResolverListener resolverListener = this.listener;
                if (resolverListener == null) {
                    notifyAll();
                } else {
                    resolverListener.receiveMessage(this, message);
                }
            }
        }

        public void send(int i10) {
            int[] iArr = this.sent;
            iArr[i10] = iArr[i10] + 1;
            this.outstanding++;
            try {
                this.inprogress[i10] = this.resolvers[i10].sendAsync(this.query, this);
            } catch (Throwable th) {
                synchronized (this) {
                    this.thrown = th;
                    this.done = true;
                    if (this.listener == null) {
                        notifyAll();
                    }
                }
            }
        }

        public Message start() {
            try {
                int[] iArr = this.sent;
                iArr[0] = iArr[0] + 1;
                this.outstanding++;
                this.inprogress[0] = new Object();
                return this.resolvers[0].send(this.query);
            } catch (Exception e10) {
                handleException(this.inprogress[0], e10);
                synchronized (this) {
                    while (!this.done) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    Message message = this.response;
                    if (message != null) {
                        return message;
                    }
                    Throwable th = this.thrown;
                    if (th instanceof IOException) {
                        throw ((IOException) th);
                    }
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new IllegalStateException("ExtendedResolver failure");
                }
            }
        }

        public void startAsync(ResolverListener resolverListener) {
            this.listener = resolverListener;
            send(0);
        }
    }

    public ExtendedResolver() {
        init();
        String[] servers = ResolverConfig.getCurrentConfig().servers();
        if (servers == null) {
            this.resolvers.add(new SimpleResolver());
            return;
        }
        for (String str : servers) {
            SimpleResolver simpleResolver = new SimpleResolver(str);
            simpleResolver.setTimeout(5);
            this.resolvers.add(simpleResolver);
        }
    }

    public static /* synthetic */ int access$208(ExtendedResolver extendedResolver) {
        int i10 = extendedResolver.lbStart;
        extendedResolver.lbStart = i10 + 1;
        return i10;
    }

    private void init() {
        this.resolvers = new ArrayList();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Message send(Message message) {
        return new Resolution(this, message).start();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Resolution resolution = new Resolution(this, message);
        resolution.startAsync(resolverListener);
        return resolution;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10) {
        for (int i11 = 0; i11 < this.resolvers.size(); i11++) {
            ((Resolver) this.resolvers.get(i11)).setEDNS(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setIgnoreTruncation(boolean z10) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setIgnoreTruncation(z10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setPort(int i10) {
        for (int i11 = 0; i11 < this.resolvers.size(); i11++) {
            ((Resolver) this.resolvers.get(i11)).setPort(i10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTCP(boolean z10) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setTCP(z10);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTSIGKey(TSIG tsig) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setTSIGKey(tsig);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10, int i11) {
        for (int i12 = 0; i12 < this.resolvers.size(); i12++) {
            ((Resolver) this.resolvers.get(i12)).setTimeout(i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10, int i11, int i12, List list) {
        for (int i13 = 0; i13 < this.resolvers.size(); i13++) {
            ((Resolver) this.resolvers.get(i13)).setEDNS(i10, i11, i12, list);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10) {
        setTimeout(i10, 0);
    }
}
