package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Opcode;
import com.hpplay.sdk.source.mdns.xbill.dns.Rcode;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Cacher implements ResolverListener {
    private static final String TAG = "Cacher";
    WeakReference<MulticastDNSMulticastOnlyQuerier> weakReference;

    public Cacher(MulticastDNSMulticastOnlyQuerier multicastDNSMulticastOnlyQuerier) {
        this.weakReference = new WeakReference<>(multicastDNSMulticastOnlyQuerier);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void handleException(Object obj, Exception exc) {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void receiveMessage(Object obj, Message message) {
        if (this.weakReference.get() == null) {
            return;
        }
        Header header = message.getHeader();
        int rcode = message.getRcode();
        int opcode = header.getOpcode();
        if (this.weakReference.get().ignoreTruncation && header.getFlag(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("receiveMessage Truncated Message Ignored : RCode: ");
            sb.append(Rcode.string(rcode));
            sb.append("; Opcode: ");
            sb.append(Opcode.string(opcode));
            return;
        }
        if (opcode == 0 || opcode == 1 || opcode == 2 || opcode == 4) {
            if (!header.getFlag(0) && !header.getFlag(5)) {
                return;
            } else {
                this.weakReference.get().updateCache(MulticastDNSUtils.extractRecords(message, 1, 2, 3), 3);
            }
        } else if (opcode == 5) {
            return;
        }
        if (this.weakReference.get().mdnsVerbose) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("receiveMessage RCode: ");
            sb2.append(Rcode.string(rcode));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("receiveMessage Opcode: ");
            sb3.append(Opcode.string(opcode));
        }
    }
}
