package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.utils.Wait;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class Lookup extends MulticastDNSLookupBase {

    public static class Domain {
        private boolean isDefault;
        private boolean isLegacy;
        private final Name name;

        public Domain(Name name) {
            this.name = name;
            byte[] label = name.getLabel(0);
            if (label != null) {
                char c10 = (char) label[0];
                if (c10 == 'd') {
                    this.isDefault = true;
                } else {
                    if (c10 != 'l') {
                        return;
                    }
                    this.isLegacy = true;
                }
            }
        }

        public boolean equals(Object obj) {
            Name name;
            if (obj == this || (name = this.name) == obj) {
                return true;
            }
            if (obj instanceof Domain) {
                return name.equals(((Domain) obj).name);
            }
            return false;
        }

        public Name getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public boolean isDefault() {
            return this.isDefault;
        }

        public boolean isLegacy() {
            return this.isLegacy;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(this.isDefault ? "  [default]" : "");
            sb.append(this.isLegacy ? "  [legacy]" : "");
            return sb.toString();
        }
    }

    public interface RecordListener {
        void handleException(Object obj, Exception exc);

        void receiveRecord(Object obj, Record record);
    }

    public Lookup(Name... nameArr) {
        super(nameArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public Domain[] lookupDomains() {
        final Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        final List synchronizedList = Collections.synchronizedList(new LinkedList());
        Message[] messageArr = this.queries;
        if (messageArr != null && messageArr.length > 0) {
            lookupRecordsAsync(new RecordListener() { // from class: com.hpplay.sdk.source.mdns.Lookup.1
                @Override // com.hpplay.sdk.source.mdns.Lookup.RecordListener
                public void handleException(Object obj, Exception exc) {
                    synchronizedList.add(exc);
                }

                @Override // com.hpplay.sdk.source.mdns.Lookup.RecordListener
                public void receiveRecord(Object obj, Record record) {
                    if (record.getTTL() <= 0 || record.getType() != 12) {
                        return;
                    }
                    String name = ((PTRRecord) record).getTarget().toString();
                    if (!name.endsWith(".")) {
                        name = name + ".";
                    }
                    try {
                        synchronizedSet.add(new Domain(new Name(name)));
                    } catch (Exception e10) {
                        e10.printStackTrace(System.err);
                    }
                }
            });
            Wait.forResponse((Iterable) synchronizedSet);
        }
        for (Name name : this.searchPath) {
            synchronizedSet.add(new Domain(name));
        }
        return (Domain[]) synchronizedSet.toArray(new Domain[synchronizedSet.size()]);
    }

    public Record[] lookupRecords() {
        final ConcurrentLinkedQueue<Message> concurrentLinkedQueue = new ConcurrentLinkedQueue();
        final ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        lookupRecordsAsync(new ResolverListener() { // from class: com.hpplay.sdk.source.mdns.Lookup.2
            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void handleException(Object obj, Exception exc) {
                concurrentLinkedQueue2.add(exc);
            }

            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void receiveMessage(Object obj, Message message) {
                concurrentLinkedQueue.add(message);
            }
        });
        Wait.forResponse((Iterable) concurrentLinkedQueue);
        ArrayList arrayList = new ArrayList();
        for (Message message : concurrentLinkedQueue) {
            if (message.getRcode() == 0) {
                arrayList.addAll(Arrays.asList(MulticastDNSUtils.extractRecords(message, 1, 2, 3)));
            }
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public Object[] lookupRecordsAsync(final RecordListener recordListener) {
        return lookupRecordsAsync(new ResolverListener() { // from class: com.hpplay.sdk.source.mdns.Lookup.3
            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void handleException(Object obj, Exception exc) {
                recordListener.handleException(obj, exc);
            }

            @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
            public void receiveMessage(Object obj, Message message) {
                for (Record record : MulticastDNSUtils.extractRecords(message, 1, 3, 2)) {
                    recordListener.receiveRecord(obj, record);
                }
            }
        });
    }

    public ServiceInstance[] lookupServices() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(extractServiceInstances(lookupRecords())));
        return (ServiceInstance[]) arrayList.toArray(new ServiceInstance[arrayList.size()]);
    }

    public Lookup(Name[] nameArr, int i10) {
        super(nameArr, i10);
    }

    public Object[] lookupRecordsAsync(ResolverListener resolverListener) {
        ArrayList arrayList = new ArrayList(this.queries.length);
        for (Message message : this.queries) {
            getQuerier().sendAsync(message, resolverListener);
        }
        return arrayList.toArray();
    }

    public Lookup(Name name, int i10) {
        super(new Name[]{name}, i10);
    }

    public Lookup(Name[] nameArr, int i10, int i11) {
        super(nameArr, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name name) {
        return lookupServices(new Name[]{name}, 255, 255);
    }

    public Lookup(Name name, int i10, int i11) {
        super(new Name[]{name}, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr) {
        return lookupServices(nameArr, 255, 255);
    }

    public Lookup(String... strArr) {
        super(strArr);
    }

    public static ServiceInstance[] lookupServices(Name name, int i10) {
        return lookupServices(new Name[]{name}, i10, 255);
    }

    public Lookup(String str, int i10) {
        super(str, i10);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr, int i10) {
        return lookupServices(nameArr, i10, 255);
    }

    public Lookup(String str, int i10, int i11) {
        super(str, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name name, int i10, int i11) {
        return lookupServices(new Name[]{name}, i10, i11);
    }

    public Lookup(String[] strArr, int i10) {
        super(strArr, i10);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr, int i10, int i11) {
        Lookup lookup = new Lookup(nameArr, i10, i11);
        try {
            return lookup.lookupServices();
        } finally {
            lookup.close();
        }
    }

    public Lookup(String[] strArr, int i10, int i11) {
        super(strArr, i10, i11);
    }

    public Lookup() {
    }

    public static Record[] lookupRecords(Name name) {
        return lookupRecords(new Name[]{name}, 255, 255);
    }

    public Lookup(Message message) {
        super(message);
    }

    public static Record[] lookupRecords(Name[] nameArr) {
        return lookupRecords(nameArr, 255, 255);
    }

    public static Record[] lookupRecords(Name name, int i10) {
        return lookupRecords(new Name[]{name}, i10, 255);
    }

    public static Record[] lookupRecords(Name[] nameArr, int i10) {
        return lookupRecords(nameArr, i10, 255);
    }

    public static Record[] lookupRecords(Name name, int i10, int i11) {
        return lookupRecords(new Name[]{name}, i10, i11);
    }

    public static Record[] lookupRecords(Name[] nameArr, int i10, int i11) {
        Lookup lookup = new Lookup(nameArr, i10, i11);
        try {
            return lookup.lookupRecords();
        } finally {
            lookup.close();
        }
    }
}
