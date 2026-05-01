package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.Resolver;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class Resolution implements ResolverListener {
    private WeakReference<MulticastDNSQuerier> dnsQuerierWeakReference;
    private WeakReference<ResolverListener> listenerWeakReference;
    private boolean mdnsVerbose;
    private WeakReference<Message> messageWeakReference;
    private int requestsSent;
    private final LinkedList responses = new LinkedList();
    private final List requestIDs = new ArrayList();

    public Resolution(MulticastDNSQuerier multicastDNSQuerier, Message message, ResolverListener resolverListener) {
        this.messageWeakReference = null;
        this.listenerWeakReference = null;
        this.mdnsVerbose = false;
        this.dnsQuerierWeakReference = new WeakReference<>(multicastDNSQuerier);
        this.messageWeakReference = new WeakReference<>(message);
        this.listenerWeakReference = new WeakReference<>(resolverListener);
        this.mdnsVerbose = Options.check("mdns_verbose");
    }

    public static boolean hasMulticastDomains(Message message) {
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3);
        if (extractRecords != null) {
            for (Record record : extractRecords) {
                if (MulticastDNSQuerier.isMulticastDomain(record.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUnicastDomains(Message message) {
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3);
        if (extractRecords != null) {
            for (Record record : extractRecords) {
                if (!MulticastDNSQuerier.isMulticastDomain(record.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Message getResponse(int i10) {
        boolean z10;
        Message message = (Message) this.messageWeakReference.get().clone();
        Header header = message.getHeader();
        int i11 = 1;
        try {
            Message[] results = getResults(true, i10);
            if (results == null || results.length <= 0) {
                z10 = false;
            } else {
                header.setRcode(0);
                header.setOpcode(0);
                header.setFlag(0);
                int length = results.length;
                int i12 = 0;
                boolean z11 = false;
                while (i12 < length) {
                    Message message2 = results[i12];
                    Header header2 = message2.getHeader();
                    if (header2.getRcode() == 0) {
                        if (header2.getFlag(5)) {
                            header.setFlag(5);
                        }
                        if (header2.getFlag(10)) {
                            header.setFlag(10);
                        }
                        int[] iArr = {i11, 3, 2};
                        for (int i13 = 0; i13 < 3; i13++) {
                            int i14 = iArr[i13];
                            Record[] sectionArray = message2.getSectionArray(i14);
                            if (sectionArray != null && sectionArray.length > 0) {
                                for (Record record : sectionArray) {
                                    if (!message.findRecord(record)) {
                                        message.addRecord(record, i14);
                                        z11 = true;
                                    }
                                }
                            }
                        }
                    }
                    i12++;
                    i11 = 1;
                }
                z10 = z11;
            }
            if (!z10) {
                header.setRcode(3);
            }
            return message;
        } catch (Exception e10) {
            if (e10 instanceof IOException) {
                throw ((IOException) e10);
            }
            IOException iOException = new IOException(e10.getMessage());
            iOException.setStackTrace(e10.getStackTrace());
            throw iOException;
        }
    }

    public Message[] getResults(boolean z10, int i10) {
        if (z10) {
            long currentTimeMillis = System.currentTimeMillis() + i10;
            while (!hasResults()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                }
                synchronized (this.responses) {
                    if (!hasResults()) {
                        try {
                            this.responses.wait(currentTimeMillis - currentTimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
        if (this.responses.size() <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator it = this.responses.iterator();
        while (it.hasNext()) {
            Response response = (Response) it.next();
            if (response.inError()) {
                linkedList2.add(response.getException());
            } else {
                linkedList.add(response.getMessage());
            }
        }
        if (linkedList.size() > 0) {
            return (Message[]) linkedList.toArray(new Message[linkedList.size()]);
        }
        if (linkedList2.size() <= 0) {
            return null;
        }
        throw ((Exception) linkedList2.get(0));
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void handleException(Object obj, Exception exc) {
        if (this.requestIDs.size() == 0 || (this.requestIDs.contains(obj) && this == obj && equals(obj))) {
            if (this.mdnsVerbose) {
                if (this.requestIDs.size() == 0 || (this.requestIDs.contains(obj) && this == obj && equals(obj))) {
                    Objects.toString(obj);
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.responses) {
            this.responses.add(new Response(obj, exc));
            this.responses.notifyAll();
        }
        if (this.listenerWeakReference.get() != null) {
            this.listenerWeakReference.get().handleException(this, exc);
        }
    }

    public boolean hasResults() {
        return this.responses.size() >= this.requestsSent;
    }

    public boolean inError() {
        Iterator it = this.responses.iterator();
        while (it.hasNext()) {
            if (!((Response) it.next()).inError()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void receiveMessage(Object obj, Message message) {
        if (this.requestIDs.size() == 0 || this.requestIDs.contains(obj) || this == obj || equals(obj) || MulticastDNSUtils.answersAny(this.messageWeakReference.get(), message)) {
            synchronized (this.responses) {
                this.responses.add(new Response(this, message));
                this.responses.notifyAll();
            }
            if (this.listenerWeakReference.get() != null) {
                this.listenerWeakReference.get().receiveMessage(this, message);
                return;
            }
            return;
        }
        if (this.mdnsVerbose) {
            if (this.requestIDs.size() != 0 && (!this.requestIDs.contains(obj) || this != obj || !equals(obj))) {
                StringBuilder sb = new StringBuilder();
                sb.append("!!!!! Message Disgarded ");
                sb.append("[Request ID does not match Response ID] ");
            }
            MulticastDNSUtils.answersAny(this.messageWeakReference.get(), message);
        }
    }

    public Object start() {
        this.requestsSent = 0;
        this.requestIDs.clear();
        WeakReference<MulticastDNSQuerier> weakReference = this.dnsQuerierWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        if (hasUnicastDomains(this.messageWeakReference.get()) && this.dnsQuerierWeakReference.get().mUnicastResolvers != null && this.dnsQuerierWeakReference.get().mUnicastResolvers.length > 0) {
            for (Resolver resolver : this.dnsQuerierWeakReference.get().mUnicastResolvers) {
                this.requestIDs.add(resolver.sendAsync(this.messageWeakReference.get(), this));
                this.requestsSent++;
            }
        }
        if (hasMulticastDomains(this.messageWeakReference.get()) && this.dnsQuerierWeakReference.get().multicastResponders != null && this.dnsQuerierWeakReference.get().multicastResponders.length > 0) {
            for (Querier querier : this.dnsQuerierWeakReference.get().multicastResponders) {
                this.requestIDs.add(querier.sendAsync(this.messageWeakReference.get(), this));
                this.requestsSent++;
            }
        }
        return this;
    }
}
