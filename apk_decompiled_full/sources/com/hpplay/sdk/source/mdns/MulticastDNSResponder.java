package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.Opcode;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class MulticastDNSResponder implements ResolverListener {
    private static final String TAG = "MulticastDNSResponder";
    private WeakReference<MulticastDNSMulticastOnlyQuerier> mMulticastOnlyQuerierWeakReference;
    private boolean mdnsVerbose;

    public MulticastDNSResponder(boolean z10, MulticastDNSMulticastOnlyQuerier multicastDNSMulticastOnlyQuerier) {
        this.mdnsVerbose = z10;
        this.mMulticastOnlyQuerierWeakReference = new WeakReference<>(multicastDNSMulticastOnlyQuerier);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void handleException(Object obj, Exception exc) {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void receiveMessage(Object obj, Message message) {
        Message queryCache;
        MulticastDNSMulticastOnlyQuerier multicastDNSMulticastOnlyQuerier = this.mMulticastOnlyQuerierWeakReference.get();
        if (multicastDNSMulticastOnlyQuerier == null) {
            return;
        }
        message.getRcode();
        Header header = message.getHeader();
        int opcode = header.getOpcode();
        if (header.getFlag(0) || header.getFlag(5)) {
            return;
        }
        if (this.mdnsVerbose) {
            StringBuilder sb = new StringBuilder();
            sb.append("receiveMessage Opcode: ");
            sb.append(Opcode.string(opcode));
        }
        try {
            if (opcode != 0 && opcode != 1) {
                if (opcode == 2 || opcode == 4 || opcode == 5) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("receiveMessage Received Invalid Request - Opcode: ");
                    sb2.append(Opcode.string(opcode));
                    return;
                }
                return;
            }
            MulticastDNSCache multicastDNSCache = multicastDNSMulticastOnlyQuerier.cache;
            if (multicastDNSCache == null || (queryCache = multicastDNSCache.queryCache(message, 4)) == null) {
                return;
            }
            Header header2 = queryCache.getHeader();
            if (header2.getCount(1) > 0 || header2.getCount(2) > 0 || header2.getCount(3) > 0) {
                if (this.mdnsVerbose) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("receiveMessage Query Reply ID: ");
                    sb3.append(obj);
                    sb3.append("\n");
                    sb3.append(queryCache);
                }
                header2.setFlag(5);
                header2.setFlag(0);
                multicastDNSMulticastOnlyQuerier.writeResponse(queryCache);
            }
        } catch (Exception e10) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Error replying to query - ");
            sb4.append(e10.getMessage());
        }
    }
}
