package com.hpplay.sdk.source.mdns;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.sdk.source.mdns.MulticastDNSCache;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CacheMonitors implements MulticastDNSCache.CacheMonitor {
    private static final String TAG = "CacheMonitors";
    private WeakReference<MulticastDNSMulticastOnlyQuerier> querierWeakReference;
    private final List authRecords = new ArrayList();
    private final List nonauthRecords = new ArrayList();
    private long lastPoll = System.currentTimeMillis();

    public CacheMonitors(MulticastDNSMulticastOnlyQuerier multicastDNSMulticastOnlyQuerier) {
        this.querierWeakReference = new WeakReference<>(multicastDNSMulticastOnlyQuerier);
    }

    @Override // com.hpplay.sdk.source.mdns.MulticastDNSCache.CacheMonitor
    public void begin() {
        if (this.querierWeakReference.get() == null) {
            return;
        }
        if (this.querierWeakReference.get().mdnsVerbose || this.querierWeakReference.get().cacheVerbose) {
            StringBuilder sb = new StringBuilder();
            if (this.lastPoll > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Last Poll ");
                double nanoTime = System.nanoTime() - this.lastPoll;
                Double.isNaN(nanoTime);
                sb2.append(nanoTime / 1.0E9d);
                sb2.append(" seconds ago. ");
                sb.append(sb2.toString());
            }
            sb.append(" Cache Monitor Check ");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("begin");
            sb3.append(sb.toString());
        }
        this.lastPoll = System.currentTimeMillis();
        this.authRecords.clear();
        this.nonauthRecords.clear();
    }

    @Override // com.hpplay.sdk.source.mdns.MulticastDNSCache.CacheMonitor
    public void check(RRset rRset, int i10, int i11) {
        if (!this.querierWeakReference.get().mdnsVerbose) {
            boolean z10 = this.querierWeakReference.get().cacheVerbose;
        }
        long ttl = rRset.getTTL();
        if (i10 < 4 || !isAboutToExpire(ttl, i11)) {
            return;
        }
        for (Record record : MulticastDNSUtils.extractRecords(rRset)) {
            try {
                MulticastDNSUtils.setTLLForRecord(record, ttl);
                this.authRecords.add(record);
            } catch (Exception e10) {
                e10.getMessage();
            }
        }
    }

    @Override // com.hpplay.sdk.source.mdns.MulticastDNSCache.CacheMonitor
    public void end() {
        try {
            if (this.authRecords.size() > 0) {
                Message message = new Message();
                message.getHeader().setOpcode(5);
                for (int i10 = 0; i10 < this.authRecords.size(); i10++) {
                    message.addRecord((Record) this.authRecords.get(i10), 2);
                }
                if (this.querierWeakReference.get().mdnsVerbose || this.querierWeakReference.get().cacheVerbose) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("end CacheMonitor Broadcasting update for Authoritative Records:\n");
                    sb.append(message);
                }
                this.querierWeakReference.get().broadcast(message, false);
            }
            if (this.nonauthRecords.size() > 0) {
                Message message2 = new Message();
                Header header = message2.getHeader();
                header.setOpcode(0);
                header.setFlag(0);
                for (int i11 = 0; i11 < this.nonauthRecords.size(); i11++) {
                    message2.addRecord((Record) this.nonauthRecords.get(i11), 2);
                }
                if (this.querierWeakReference.get().mdnsVerbose || this.querierWeakReference.get().cacheVerbose) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("end CacheMonitor Locally Broadcasting Non-Authoritative Records:\n");
                    sb2.append(message2);
                }
                Iterator<ResolverListener> it = this.querierWeakReference.get().mResolverListener.iterator();
                while (it.hasNext()) {
                    it.next().receiveMessage(Integer.valueOf(header.getID()), message2);
                }
            }
        } catch (IOException e10) {
            IOException iOException = new IOException("Exception \"" + e10.getMessage() + "\" occured while refreshing cached entries.");
            iOException.setStackTrace(e10.getStackTrace());
            Iterator<ResolverListener> it2 = this.querierWeakReference.get().mResolverListener.iterator();
            while (it2.hasNext()) {
                it2.next().handleException(TAG, iOException);
            }
            if (this.querierWeakReference.get().mdnsVerbose) {
                e10.getMessage();
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
        this.authRecords.clear();
        this.nonauthRecords.clear();
    }

    @Override // com.hpplay.sdk.source.mdns.MulticastDNSCache.CacheMonitor
    public void expired(RRset rRset, int i10) {
        if (this.querierWeakReference.get().mdnsVerbose || this.querierWeakReference.get().cacheVerbose) {
            StringBuilder sb = new StringBuilder();
            sb.append("expiredCacheMonitor RRset expired : ");
            sb.append(rRset);
        }
        List list = i10 >= 4 ? this.authRecords : this.nonauthRecords;
        Record[] extractRecords = MulticastDNSUtils.extractRecords(rRset);
        if (extractRecords == null || extractRecords.length <= 0) {
            return;
        }
        for (int i11 = 0; i11 < extractRecords.length; i11++) {
            try {
                MulticastDNSUtils.setTLLForRecord(extractRecords[i11], 0L);
                list.add(extractRecords[i11]);
            } catch (Exception e10) {
                e10.getMessage();
            }
        }
    }

    public boolean isAboutToExpire(long j10, int i10) {
        double d10 = i10;
        double d11 = j10;
        Double.isNaN(d10);
        Double.isNaN(d11);
        double d12 = d10 / d11;
        return d12 <= 0.07000000029802322d || (d12 >= 0.10000000149011612d && d12 <= 0.11999999731779099d) || ((d12 >= 0.15000000596046448d && d12 <= 0.17000000178813934d) || (d12 >= 0.20000000298023224d && d12 <= 0.2199999988079071d));
    }

    @Override // com.hpplay.sdk.source.mdns.MulticastDNSCache.CacheMonitor
    public boolean isOperational() {
        return System.currentTimeMillis() < this.lastPoll + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
    }
}
