package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class Cache {
    private static final int defaultMaxEntries = 50000;
    private CacheMap data;
    private int dclass;
    private int maxcache;
    private int maxncache;

    public static class CacheMap extends LinkedHashMap {
        private int maxsize;

        public CacheMap(int i10) {
            super(16, 0.75f, true);
            this.maxsize = i10;
        }

        public int getMaxSize() {
            return this.maxsize;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return this.maxsize >= 0 && size() > this.maxsize;
        }

        public void setMaxSize(int i10) {
            this.maxsize = i10;
        }
    }

    public interface Element {
        int compareCredibility(int i10);

        boolean expired();

        int getType();
    }

    public static class NegativeElement implements Element {
        int credibility;
        int expire;
        Name name;
        int type;

        public NegativeElement(Name name, int i10, SOARecord sOARecord, int i11, long j10) {
            this.name = name;
            this.type = i10;
            long minimum = sOARecord != null ? sOARecord.getMinimum() : 0L;
            this.credibility = i11;
            this.expire = Cache.limitExpire(minimum, j10);
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element
        public final int compareCredibility(int i10) {
            return this.credibility - i10;
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element
        public int getType() {
            return this.type;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.type == 0) {
                stringBuffer.append("NXDOMAIN " + this.name);
            } else {
                stringBuffer.append("NXRRSET " + this.name + " " + Type.string(this.type));
            }
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.credibility);
            return stringBuffer.toString();
        }
    }

    public Cache(int i10) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.dclass = i10;
        this.data = new CacheMap(defaultMaxEntries);
    }

    private synchronized void addElement(Name name, Element element) {
        V v10 = this.data.get(name);
        if (v10 == 0) {
            this.data.put(name, element);
            return;
        }
        int type = element.getType();
        if (v10 instanceof List) {
            List list = (List) v10;
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (((Element) list.get(i10)).getType() == type) {
                    list.set(i10, element);
                    return;
                }
            }
            list.add(element);
        } else {
            Element element2 = (Element) v10;
            if (element2.getType() == type) {
                this.data.put(name, element);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(element2);
                linkedList.add(element);
                this.data.put(name, linkedList);
            }
        }
    }

    private synchronized Element[] allElements(Object obj) {
        if (!(obj instanceof List)) {
            return new Element[]{(Element) obj};
        }
        List list = (List) obj;
        return (Element[]) list.toArray(new Element[list.size()]);
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    private synchronized Element findElement(Name name, int i10, int i11) {
        Object exactName = exactName(name);
        if (exactName == null) {
            return null;
        }
        return oneElement(name, exactName, i10, i11);
    }

    private RRset[] findRecords(Name name, int i10, int i11) {
        SetResponse lookupRecords = lookupRecords(name, i10, i11);
        if (lookupRecords.isSuccessful()) {
            return lookupRecords.answers();
        }
        return null;
    }

    private final int getCred(int i10, boolean z10) {
        if (i10 == 1) {
            return !z10 ? 3 : 4;
        }
        if (i10 == 2) {
            return !z10 ? 3 : 4;
        }
        if (i10 == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int limitExpire(long j10, long j11) {
        if (j11 >= 0 && j11 < j10) {
            j10 = j11;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j10;
        if (currentTimeMillis < 0 || currentTimeMillis > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }

    private static void markAdditional(RRset rRset, Set set) {
        if (rRset.first().getAdditionalName() == null) {
            return;
        }
        Iterator rrs = rRset.rrs();
        while (rrs.hasNext()) {
            Name additionalName = ((Record) rrs.next()).getAdditionalName();
            if (additionalName != null) {
                set.add(additionalName);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x002b, code lost:
    
        if (r2.getType() == r7) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized Element oneElement(Name name, Object obj, int i10, int i11) {
        Element element;
        if (i10 == 255) {
            throw new IllegalArgumentException("oneElement(ANY)");
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i12 = 0; i12 < list.size(); i12++) {
                element = (Element) list.get(i12);
                if (element.getType() == i10) {
                    break;
                }
            }
            element = null;
        } else {
            element = (Element) obj;
        }
        if (element == null) {
            return null;
        }
        if (element.expired()) {
            removeElement(name, i10);
            return null;
        }
        if (element.compareCredibility(i11) < 0) {
            return null;
        }
        return element;
    }

    private synchronized void removeElement(Name name, int i10) {
        V v10 = this.data.get(name);
        if (v10 == 0) {
            return;
        }
        if (v10 instanceof List) {
            List list = (List) v10;
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (((Element) list.get(i11)).getType() == i10) {
                    list.remove(i11);
                    if (list.size() == 0) {
                        this.data.remove(name);
                    }
                    return;
                }
            }
        } else if (((Element) v10).getType() == i10) {
            this.data.remove(name);
        }
    }

    private synchronized void removeName(Name name) {
        this.data.remove(name);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public com.hpplay.sdk.source.mdns.xbill.dns.SetResponse addMessage(com.hpplay.sdk.source.mdns.xbill.dns.Message r20) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Cache.addMessage(com.hpplay.sdk.source.mdns.xbill.dns.Message):com.hpplay.sdk.source.mdns.xbill.dns.SetResponse");
    }

    public synchronized void addNegative(Name name, int i10, SOARecord sOARecord, int i11) {
        long ttl = sOARecord != null ? sOARecord.getTTL() : 0L;
        Element findElement = findElement(name, i10, 0);
        if (ttl != 0) {
            if (findElement != null && findElement.compareCredibility(i11) <= 0) {
                findElement = null;
            }
            if (findElement == null) {
                addElement(name, new NegativeElement(name, i10, sOARecord, i11, this.maxncache));
            }
        } else if (findElement != null && findElement.compareCredibility(i11) <= 0) {
            removeElement(name, i10);
        }
    }

    public synchronized void addRRset(RRset rRset, int i10) {
        long ttl = rRset.getTTL();
        Name name = rRset.getName();
        int type = rRset.getType();
        Element findElement = findElement(name, type, 0);
        if (ttl != 0) {
            if (findElement != null && findElement.compareCredibility(i10) <= 0) {
                findElement = null;
            }
            if (findElement == null) {
                addElement(name, rRset instanceof CacheRRset ? (CacheRRset) rRset : new CacheRRset(rRset, i10, this.maxcache));
            }
        } else if (findElement != null && findElement.compareCredibility(i10) <= 0) {
            removeElement(name, type);
        }
    }

    public synchronized void addRecord(Record record, int i10, Object obj) {
        Name name = record.getName();
        int rRsetType = record.getRRsetType();
        if (Type.isRR(rRsetType)) {
            Element findElement = findElement(name, rRsetType, i10);
            if (findElement == null) {
                addRRset(new CacheRRset(record, i10, this.maxcache), i10);
            } else if (findElement.compareCredibility(i10) == 0 && (findElement instanceof CacheRRset)) {
                ((CacheRRset) findElement).addRR(record);
            }
        }
    }

    public synchronized void clearCache() {
        this.data.clear();
    }

    public int getDClass() {
        return this.dclass;
    }

    public int getMaxCache() {
        return this.maxcache;
    }

    public int getSize() {
        return this.data.size();
    }

    public synchronized SetResponse lookup(Name name, int i10, int i11) {
        int labels = name.labels();
        int i12 = labels;
        while (i12 >= 1) {
            boolean z10 = i12 == 1;
            boolean z11 = i12 == labels;
            Name name2 = z10 ? Name.root : z11 ? name : new Name(name, labels - i12);
            Object obj = this.data.get(name2);
            if (obj != null) {
                if (z11 && i10 == 255) {
                    SetResponse setResponse = new SetResponse(6);
                    int i13 = 0;
                    for (Element element : allElements(obj)) {
                        if (element.expired()) {
                            removeElement(name2, element.getType());
                        } else if ((element instanceof CacheRRset) && element.compareCredibility(i11) >= 0) {
                            setResponse.addRRset((CacheRRset) element);
                            i13++;
                        }
                    }
                    if (i13 > 0) {
                        return setResponse;
                    }
                } else if (z11) {
                    Element oneElement = oneElement(name2, obj, i10, i11);
                    if (oneElement != null && (oneElement instanceof CacheRRset)) {
                        SetResponse setResponse2 = new SetResponse(6);
                        setResponse2.addRRset((CacheRRset) oneElement);
                        return setResponse2;
                    }
                    if (oneElement != null) {
                        return new SetResponse(2);
                    }
                    Element oneElement2 = oneElement(name2, obj, 5, i11);
                    if (oneElement2 != null && (oneElement2 instanceof CacheRRset)) {
                        return new SetResponse(4, (CacheRRset) oneElement2);
                    }
                } else {
                    Element oneElement3 = oneElement(name2, obj, 39, i11);
                    if (oneElement3 != null && (oneElement3 instanceof CacheRRset)) {
                        return new SetResponse(5, (CacheRRset) oneElement3);
                    }
                }
                Element oneElement4 = oneElement(name2, obj, 2, i11);
                if (oneElement4 != null && (oneElement4 instanceof CacheRRset)) {
                    return new SetResponse(3, (CacheRRset) oneElement4);
                }
                if (z11 && oneElement(name2, obj, 0, i11) != null) {
                    return SetResponse.ofType(1);
                }
            }
            i12--;
        }
        return SetResponse.ofType(0);
    }

    public SetResponse lookupRecords(Name name, int i10, int i11) {
        return lookup(name, i10, i11);
    }

    public void release() {
        CacheMap cacheMap = this.data;
        if (cacheMap != null) {
            cacheMap.clear();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this) {
            Iterator it = this.data.values().iterator();
            while (it.hasNext()) {
                for (Element element : allElements(it.next())) {
                    stringBuffer.append(element);
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    public class CacheRRset extends RRset implements Element {
        private static final long serialVersionUID = 5971755205903597024L;
        int credibility;
        int expire;

        public CacheRRset(Record record, int i10, long j10) {
            this.credibility = i10;
            this.expire = Cache.limitExpire(record.getTTL(), j10);
            addRR(record);
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element
        public final int compareCredibility(int i10) {
            return this.credibility - i10;
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.RRset
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.toString());
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.credibility);
            return stringBuffer.toString();
        }

        public CacheRRset(RRset rRset, int i10, long j10) {
            super(rRset);
            this.credibility = i10;
            this.expire = Cache.limitExpire(rRset.getTTL(), j10);
        }
    }

    public Cache() {
        this(1);
    }

    public Cache(String str) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.data = new CacheMap(defaultMaxEntries);
        Master master = new Master(str);
        while (true) {
            Record nextRecord = master.nextRecord();
            if (nextRecord == null) {
                return;
            } else {
                addRecord(nextRecord, 0, master);
            }
        }
    }
}
