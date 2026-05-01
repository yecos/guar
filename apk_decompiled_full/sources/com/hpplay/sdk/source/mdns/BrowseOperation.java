package com.hpplay.sdk.source.mdns;

import android.util.Log;
import com.hpplay.sdk.source.mdns.xbill.dns.AAAARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.ARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.TXTRecord;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class BrowseOperation extends Thread implements ResolverListener {
    private static final String TAG = "BrowseOperation";
    private int dclass;
    private DNSSDListener dnssdListener;
    private String mErrorMsg;
    protected Message[] mMessages;
    protected Querier mQuerier;
    private ResolverListener resolverListener;
    private int broadcastDelay = 0;
    private final AtomicBoolean isQuit = new AtomicBoolean();
    private final Map services = new LinkedHashMap();

    public BrowseOperation(ResolverListener resolverListener, Message[] messageArr, Querier querier, int i10) {
        setName(TAG);
        StringBuilder sb = new StringBuilder();
        sb.append(" sBrowseOperation  create hashCode : ");
        sb.append(hashCode());
        if (resolverListener != null) {
            registerListener(resolverListener);
        }
        this.mMessages = messageArr;
        this.mQuerier = querier;
        this.dclass = i10;
    }

    public synchronized boolean answersQuery(Record record) {
        Message[] messageArr;
        if (this.isQuit.get()) {
            return false;
        }
        if (record != null && (messageArr = this.mMessages) != null) {
            for (Message message : messageArr) {
                for (Record record2 : MulticastDNSUtils.extractRecords(message, 0)) {
                    Name name = record2.getName();
                    Name name2 = record.getName();
                    int type = record2.getType();
                    int type2 = record.getType();
                    int dClass = record2.getDClass();
                    int dClass2 = record.getDClass();
                    if (type == 255 || type == type2) {
                        if (!name.equals(name2) && !name.subdomain(name2)) {
                            if (!name2.toString().endsWith("." + name.toString())) {
                                continue;
                            }
                        }
                        if (dClass == 255 || (dClass & 32767) == (dClass2 & 32767)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public synchronized void convertMassge(Object obj, Message message) {
        if (message != null) {
            if (!this.isQuit.get()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedList<Record> linkedList = new LinkedList();
                LinkedList<Record> linkedList2 = new LinkedList();
                for (Record record : MulticastDNSUtils.extractRecords(message, 1, 2, 3)) {
                    if (answersQuery(record)) {
                        Name additionalName = record.getAdditionalName();
                        if (additionalName != null) {
                            linkedHashSet.add(additionalName);
                        }
                        int type = record.getType();
                        if (type == 12) {
                            linkedHashSet.add(((PTRRecord) record).getTarget());
                        } else if (type == 33) {
                            linkedHashSet.add(((SRVRecord) record).getTarget());
                        }
                        linkedList2.add(record);
                    } else {
                        linkedList.add(record);
                    }
                }
                for (Record record2 : linkedList) {
                    if (linkedHashSet.contains(record2.getName())) {
                        linkedList2.add(record2);
                    }
                }
                if (linkedList2.size() > 0) {
                    DNSSDListener dNSSDListener = this.dnssdListener;
                    if (dNSSDListener != null) {
                        dNSSDListener.receiveMessage(obj, message);
                    }
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    for (Record record3 : linkedList2) {
                        try {
                            if (record3.getType() == 12) {
                                if (this.isQuit.get()) {
                                    return;
                                }
                                PTRRecord pTRRecord = (PTRRecord) record3;
                                if (pTRRecord.getTTL() > 0) {
                                    ServiceInstance[] extractServiceInstances = extractServiceInstances(this.mQuerier.send(Message.newQuery(Record.newRecord(pTRRecord.getTarget(), 255, this.dclass))));
                                    if (extractServiceInstances.length > 0) {
                                        synchronized (this.services) {
                                            for (int i10 = 0; i10 < extractServiceInstances.length; i10++) {
                                                if (!this.services.containsKey(extractServiceInstances[i10].getName())) {
                                                    this.services.put(extractServiceInstances[i10].getName(), extractServiceInstances[i10]);
                                                    hashMap.put(extractServiceInstances[i10].getName(), extractServiceInstances[i10]);
                                                }
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    synchronized (this.services) {
                                        ServiceInstance serviceInstance = (ServiceInstance) this.services.get(pTRRecord.getTarget());
                                        if (serviceInstance != null) {
                                            this.services.remove(serviceInstance.getName());
                                            hashMap2.put(serviceInstance.getName(), serviceInstance);
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        try {
                            this.dnssdListener.serviceDiscovered(obj, (ServiceInstance) it.next());
                        } catch (Exception unused2) {
                        }
                    }
                    Iterator it2 = hashMap2.values().iterator();
                    while (it2.hasNext()) {
                        try {
                            this.dnssdListener.serviceRemoved(obj, (ServiceInstance) it2.next());
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        }
    }

    public ServiceInstance[] extractServiceInstances(Message... messageArr) {
        Record[] recordArr = null;
        for (Message message : messageArr) {
            Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 2, 1, 3);
            if (recordArr == null) {
                recordArr = extractRecords;
            } else {
                int length = recordArr.length + extractRecords.length;
                Record[] recordArr2 = new Record[length];
                System.arraycopy(recordArr, 0, recordArr2, 0, length);
                System.arraycopy(extractRecords, 0, recordArr2, length, extractRecords.length);
                recordArr = recordArr2;
            }
        }
        return extractServiceInstances(recordArr);
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public Message[] getQueries() {
        return this.mMessages;
    }

    public AtomicBoolean getQuitSwitch() {
        return this.isQuit;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void handleException(Object obj, Exception exc) {
        ResolverListener resolverListener = this.resolverListener;
        if (resolverListener != null) {
            resolverListener.handleException(obj, exc);
        }
    }

    public boolean matchesBrowse(Message message) {
        for (Record record : MulticastDNSUtils.extractRecords(message, 1, 2, 3)) {
            if (answersQuery(record)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
    public void receiveMessage(Object obj, Message message) {
        if (message != null) {
            Header header = message.getHeader();
            if ((header.getFlag(0) || header.getFlag(5)) && matchesBrowse(message)) {
                try {
                    convertMassge(obj, message);
                } catch (Exception unused) {
                }
            }
        }
    }

    public ResolverListener registerListener(ResolverListener resolverListener) {
        this.resolverListener = resolverListener;
        return resolverListener;
    }

    public void release() {
        this.isQuit.set(true);
        this.resolverListener = null;
        this.dnssdListener = null;
        interrupt();
        StringBuilder sb = new StringBuilder();
        sb.append(" browse release  hashCode :");
        sb.append(hashCode());
        try {
            this.mQuerier.close();
            this.mMessages = null;
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z10;
        try {
            z10 = this.mQuerier.initNetWorkState();
        } catch (Exception e10) {
            this.mErrorMsg = Log.getStackTraceString(e10);
            z10 = false;
        }
        if (z10) {
            try {
                this.mQuerier.registerListener(this);
                while (!this.isQuit.get() && !isInterrupted()) {
                    int i10 = this.broadcastDelay;
                    this.broadcastDelay = i10 > 0 ? Math.min(i10 * 2, 3600) : 1;
                    for (Message message : this.mMessages) {
                        this.mQuerier.broadcast((Message) message.clone(), false);
                    }
                    Thread.sleep(this.broadcastDelay);
                }
            } catch (Exception unused) {
            }
        }
        try {
            this.mQuerier.close();
            this.mQuerier = null;
        } catch (Exception unused2) {
        }
    }

    public void setDNSSDListener(DNSSDListener dNSSDListener) {
        this.dnssdListener = dNSSDListener;
    }

    public ResolverListener unregisterListener(ResolverListener resolverListener) {
        this.resolverListener = null;
        return null;
    }

    public ServiceInstance[] extractServiceInstances(Record[] recordArr) {
        HashMap hashMap = new HashMap();
        Arrays.sort(recordArr, new ServiceRecodSorter());
        for (Record record : recordArr) {
            int type = record.getType();
            if (type == 1) {
                ARecord aRecord = (ARecord) record;
                for (ServiceInstance serviceInstance : hashMap.values()) {
                    if (aRecord.getName().equals(serviceInstance.getHost())) {
                        if (aRecord.getTTL() > 0) {
                            serviceInstance.addAddress(aRecord.getAddress());
                        } else {
                            serviceInstance.removeAddress(aRecord.getAddress());
                        }
                    }
                }
            } else if (type == 12) {
                PTRRecord pTRRecord = (PTRRecord) record;
                ServiceInstance serviceInstance2 = (ServiceInstance) hashMap.get(pTRRecord.getTarget());
                if (serviceInstance2 != null) {
                    if (pTRRecord.getTTL() > 0) {
                        serviceInstance2.addPointer(pTRRecord.getName());
                    } else {
                        serviceInstance2.removePointer(pTRRecord.getName());
                    }
                }
            } else if (type == 16) {
                TXTRecord tXTRecord = (TXTRecord) record;
                ServiceInstance serviceInstance3 = (ServiceInstance) hashMap.get(tXTRecord.getName());
                if (serviceInstance3 != null) {
                    if (tXTRecord.getTTL() > 0) {
                        serviceInstance3.addTextRecords(tXTRecord);
                    } else {
                        serviceInstance3.removeTextRecords(tXTRecord);
                    }
                }
            } else if (type == 28) {
                AAAARecord aAAARecord = (AAAARecord) record;
                for (ServiceInstance serviceInstance4 : hashMap.values()) {
                    if (aAAARecord.getName().equals(serviceInstance4.getHost())) {
                        if (aAAARecord.getTTL() > 0) {
                            serviceInstance4.addAddress(aAAARecord.getAddress());
                        } else {
                            serviceInstance4.removeAddress(aAAARecord.getAddress());
                        }
                    }
                }
            } else if (type == 33) {
                try {
                    ServiceInstance serviceInstance5 = new ServiceInstance((SRVRecord) record);
                    hashMap.put(serviceInstance5.getName(), serviceInstance5);
                } catch (Exception unused) {
                }
            }
        }
        return (ServiceInstance[]) hashMap.values().toArray(new ServiceInstance[hashMap.size()]);
    }
}
