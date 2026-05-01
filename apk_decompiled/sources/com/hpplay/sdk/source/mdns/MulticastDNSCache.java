package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.utils.Misc;
import com.hpplay.sdk.source.mdns.xbill.dns.Cache;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.SetResponse;
import java.io.Closeable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class MulticastDNSCache extends Cache implements Closeable {
    protected static final Logger logger;
    private static MulticastDNSCache multicastDNSCache;
    private CacheMonitor cacheMonitor;
    public LinkedHashMap dataCopy;
    private Field dataField;
    private Method findElement;
    private MonitorTask monitorTask;
    private Method removeElement;

    public interface CacheMonitor {
        void begin();

        void check(RRset rRset, int i10, int i11);

        void end();

        void expired(RRset rRset, int i10);

        boolean isOperational();
    }

    static {
        logger = Misc.getLogger(MulticastDNSCache.class.getName(), Options.check("mdns_verbose") || Options.check("dns_verbose") || Options.check("verbose"));
    }

    public MulticastDNSCache() {
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    private ElementHelper findElementCopy(Name name, int i10, int i11) {
        Object invoke = this.findElement.invoke(this, name, new Integer(i10), new Integer(i11));
        if (invoke == null) {
            return null;
        }
        try {
            return new ElementHelper(this, invoke);
        } catch (Exception e10) {
            logger.log(Level.WARNING, e10.getMessage(), (Throwable) e10);
            return null;
        }
    }

    public static MulticastDNSCache getInstance() {
        if (multicastDNSCache == null) {
            try {
                multicastDNSCache = new MulticastDNSCache();
            } catch (Exception unused) {
            }
        }
        return multicastDNSCache;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache
    public synchronized void addRRset(RRset rRset, int i10) {
        super.addRRset(rRset, i10);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache
    public synchronized void addRecord(Record record, int i10, Object obj) {
        super.addRecord(record, i10, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MonitorTask monitorTask = this.monitorTask;
        if (monitorTask != null) {
            monitorTask.release();
        }
        release();
        this.cacheMonitor = null;
        multicastDNSCache = null;
    }

    public CacheMonitor getCacheMonitor() {
        return this.cacheMonitor;
    }

    public void populateReflectedFields() {
        if (this.monitorTask == null) {
            MonitorTask monitorTask = new MonitorTask(this);
            this.monitorTask = monitorTask;
            monitorTask.start();
        }
        Class<? super Object> superclass = getClass().getSuperclass();
        try {
            Field findField = ElementHelper.findField(superclass, "data");
            this.dataField = findField;
            AccessibleObject.setAccessible(new AccessibleObject[]{findField}, true);
            this.dataCopy = (LinkedHashMap) this.dataField.get(this);
        } catch (NoSuchFieldException e10) {
            logger.log(Level.WARNING, e10.getMessage(), (Throwable) e10);
            throw e10;
        } catch (Exception e11) {
            logger.log(Level.WARNING, e11.getMessage(), (Throwable) e11);
        }
        try {
            Class cls = Integer.TYPE;
            this.findElement = ElementHelper.findMethod(superclass, "findElement", new Class[]{Name.class, cls, cls});
            Method findMethod = ElementHelper.findMethod(superclass, "removeElement", new Class[]{Name.class, cls});
            this.removeElement = findMethod;
            AccessibleObject.setAccessible(new AccessibleObject[]{this.findElement, findMethod}, true);
        } catch (NoSuchMethodException e12) {
            logger.log(Level.WARNING, e12.getMessage(), (Throwable) e12);
            throw e12;
        } catch (Exception e13) {
            logger.log(Level.WARNING, e13.getMessage(), (Throwable) e13);
        }
    }

    public Message queryCache(Message message) {
        return queryCache(message, 1);
    }

    public Record[] queryCacheForAdditionalRecords(Record record, int i10) {
        if (record == null) {
            return MulticastDNSUtils.EMPTY_RECORDS;
        }
        LinkedList linkedList = new LinkedList();
        Name targetFromRecord = MulticastDNSUtils.getTargetFromRecord(record);
        if (targetFromRecord != null) {
            SetResponse lookupRecords = lookupRecords(targetFromRecord, 255, i10);
            if (lookupRecords.isSuccessful()) {
                for (Record record2 : MulticastDNSUtils.extractRecords(lookupRecords.answers())) {
                    linkedList.add(record2);
                    for (Record record3 : queryCacheForAdditionalRecords(record2, i10)) {
                        linkedList.add(record3);
                    }
                }
            }
        }
        return (Record[]) linkedList.toArray(new Record[linkedList.size()]);
    }

    public void removeElementCopy(Name name, int i10) {
        try {
            this.removeElement.invoke(this, name, new Integer(i10));
        } catch (Exception e10) {
            logger.log(Level.WARNING, e10.getMessage(), (Throwable) e10);
        }
    }

    public synchronized void removeRRset(RRset rRset) {
        removeElementCopy(rRset.getName(), rRset.getType());
    }

    public synchronized void setCacheMonitor(CacheMonitor cacheMonitor) {
        if (cacheMonitor != null) {
            this.cacheMonitor = cacheMonitor;
        }
    }

    public synchronized void updateRRset(Record record, int i10) {
        long ttl = record.getTTL();
        ElementHelper findElementCopy = findElementCopy(record.getName(), record.getType(), 0);
        if (findElementCopy == null) {
            addRecord(record, i10, this);
        } else if (findElementCopy.compareCredibility(i10) <= 0) {
            if (findElementCopy.getElement() instanceof RRset) {
                ((RRset) findElementCopy.getElement()).addRR(record);
                if (findElementCopy.getTTL() == ttl) {
                    findElementCopy.resetExpire();
                } else {
                    addRecord(record, i10, this);
                }
            } else {
                addRecord(record, i10, this);
            }
        }
    }

    public Message queryCache(Message message, int i10) {
        int i11 = 255;
        int i12 = 1;
        if (message.getHeader().getOpcode() == 5) {
            Message message2 = new Message(message.getHeader().getID());
            Header header = message2.getHeader();
            header.setRcode(3);
            Stack stack = new Stack();
            for (Record record : MulticastDNSUtils.extractRecords(message, 2)) {
                stack.push(record.getName());
            }
            while (!stack.isEmpty()) {
                SetResponse lookupRecords = lookupRecords((Name) stack.pop(), 255, i10);
                if (lookupRecords.isSuccessful()) {
                    header.setRcode(0);
                    header.setOpcode(0);
                    header.setFlag(0);
                    for (Record record2 : MulticastDNSUtils.extractRecords(lookupRecords.answers())) {
                        if (!message2.findRecord(record2)) {
                            message2.addRecord(record2, 1);
                        }
                        Name targetFromRecord = MulticastDNSUtils.getTargetFromRecord(record2);
                        if (targetFromRecord != null) {
                            stack.push(targetFromRecord);
                        }
                    }
                }
            }
            return message2;
        }
        Message message3 = new Message(message.getHeader().getID());
        Header header2 = message3.getHeader();
        header2.setRcode(3);
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 0);
        if (extractRecords != null && extractRecords.length > 0) {
            int length = extractRecords.length;
            int i13 = 0;
            while (i13 < length) {
                Record record3 = extractRecords[i13];
                message3.addRecord(record3, 0);
                MulticastDNSUtils.setDClassForRecord(record3, record3.getDClass() & 32767);
                SetResponse lookupRecords2 = lookupRecords(record3.getName(), i11, i10);
                if (lookupRecords2.isSuccessful()) {
                    header2.setRcode(0);
                    header2.setOpcode(0);
                    header2.setFlag(0);
                    Record[] extractRecords2 = MulticastDNSUtils.extractRecords(lookupRecords2.answers());
                    if (extractRecords2 != null && extractRecords2.length > 0) {
                        int length2 = extractRecords2.length;
                        int i14 = 0;
                        while (i14 < length2) {
                            Record record4 = extractRecords2[i14];
                            if (!message3.findRecord(record4)) {
                                message3.addRecord(record4, i12);
                            }
                            for (Record record5 : queryCacheForAdditionalRecords(record4, i10)) {
                                if (!message3.findRecord(record5)) {
                                    message3.addRecord(record5, 3);
                                }
                            }
                            i14++;
                            i12 = 1;
                        }
                    }
                }
                i13++;
                i11 = 255;
                i12 = 1;
            }
        }
        return message3;
    }

    public MulticastDNSCache(int i10) {
        super(i10);
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    public MulticastDNSCache(String str) {
        super(str);
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    public MulticastDNSCache(Cache cache) {
        this();
        Field declaredField = cache.getClass().getDeclaredField("data");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cache);
        Field declaredField2 = super.getClass().getDeclaredField("data");
        declaredField2.setAccessible(true);
        declaredField2.set(this, obj);
        populateReflectedFields();
    }
}
