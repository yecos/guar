package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.MulticastDNSCache;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

/* loaded from: classes3.dex */
public class MonitorTask extends Thread {
    private static final String TAG = "MonitorTask";
    private boolean isShutdown;
    private WeakReference<MulticastDNSCache> mWeakReference;

    public MonitorTask(MulticastDNSCache multicastDNSCache) {
        this(false);
        this.mWeakReference = new WeakReference<>(multicastDNSCache);
    }

    private void processElement(ElementHelper elementHelper, MulticastDNSCache multicastDNSCache) {
        try {
            if (!(elementHelper.getElement() instanceof RRset)) {
                if (elementHelper.getElement() != null) {
                    elementHelper.getElement().getClass();
                    return;
                }
                return;
            }
            RRset rRset = (RRset) elementHelper.getElement();
            if (this.isShutdown) {
                for (Record record : MulticastDNSUtils.extractRecords(rRset)) {
                    if (elementHelper.getCredibility() >= 4) {
                        MulticastDNSUtils.setTLLForRecord(record, 0L);
                    }
                }
            }
            MulticastDNSCache.CacheMonitor cacheMonitor = multicastDNSCache.getCacheMonitor();
            int expiresIn = elementHelper.getExpiresIn();
            if (expiresIn > 0 && rRset.getTTL() > 0) {
                cacheMonitor.check(rRset, elementHelper.getCredibility(), expiresIn);
                return;
            }
            cacheMonitor.expired(rRset, elementHelper.getCredibility());
        } catch (Exception e10) {
            MulticastDNSCache.logger.log(Level.WARNING, e10.getMessage(), (Throwable) e10);
        }
    }

    public void release() {
        this.isShutdown = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MulticastDNSCache multicastDNSCache;
        MulticastDNSCache.CacheMonitor cacheMonitor;
        Object[] array;
        Object[] array2;
        setName(TAG);
        while (!this.isShutdown) {
            try {
                multicastDNSCache = this.mWeakReference.get();
            } catch (Exception unused) {
            }
            if (multicastDNSCache == null || (cacheMonitor = multicastDNSCache.getCacheMonitor()) == null || this.isShutdown) {
                return;
            }
            try {
                cacheMonitor.begin();
            } catch (Exception e10) {
                MulticastDNSCache.logger.log(Level.WARNING, e10.getMessage(), (Throwable) e10);
            }
            synchronized (this) {
                Collection values = multicastDNSCache.dataCopy.values();
                array = values.toArray(new Object[values.size()]);
            }
            for (Object obj : array) {
                try {
                    if (obj instanceof List) {
                        List list = (List) obj;
                        synchronized (this) {
                            array2 = list.toArray(new Object[list.size()]);
                        }
                        for (Object obj2 : array2) {
                            processElement(new ElementHelper(multicastDNSCache, obj2), multicastDNSCache);
                        }
                    } else {
                        processElement(new ElementHelper(multicastDNSCache, obj), multicastDNSCache);
                    }
                } catch (Exception e11) {
                    MulticastDNSCache.logger.log(Level.WARNING, e11.getMessage(), (Throwable) e11);
                }
            }
            try {
                cacheMonitor.end();
            } catch (Exception e12) {
                MulticastDNSCache.logger.log(Level.WARNING, e12.getMessage(), (Throwable) e12);
            }
            Thread.sleep(1000L);
        }
    }

    public MonitorTask(boolean z10) {
        this.isShutdown = z10;
    }
}
