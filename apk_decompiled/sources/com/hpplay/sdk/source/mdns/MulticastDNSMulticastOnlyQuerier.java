package com.hpplay.sdk.source.mdns;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.hpplay.sdk.source.mdns.net.DatagramProcessor;
import com.hpplay.sdk.source.mdns.net.Packet;
import com.hpplay.sdk.source.mdns.net.PacketListener;
import com.hpplay.sdk.source.mdns.utils.Wait;
import com.hpplay.sdk.source.mdns.xbill.dns.Cache;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.OPTRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Opcode;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.TSIG;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class MulticastDNSMulticastOnlyQuerier implements Querier, PacketListener {
    public static final int DEFAULT_EDNS_PAYLOADSIZE = 1280;
    public static final String TAG = "MulticastDNSMulticastOnlyQuerier";
    private static final boolean USE_ONLY_IPV4_ADDR = true;
    private static final boolean USE_ONLY_IPV6_ADDR = false;
    protected MulticastDNSCache cache;
    public CacheMonitors cacheMonitor;
    protected boolean cacheVerbose;
    protected Cacher cacher;
    protected boolean ignoreTruncation;
    private ReceiveMessageThread mReceiveMessageThread;
    protected CopyOnWriteArrayList<ResolverListener> mResolverListener;
    protected boolean mdnsVerbose;
    protected InetAddress multicastAddress;
    protected CopyOnWriteArrayList<DatagramProcessor> multicastProcessors;
    protected int port;
    protected OPTRecord queryOPT;
    protected long responseWaitTime;
    protected long timeoutValue;
    protected TSIG tsig;

    public MulticastDNSMulticastOnlyQuerier(boolean z10) {
        this(null, InetAddress.getByName(z10 ? Constants.DEFAULT_IPv6_ADDRESS : Constants.DEFAULT_IPv4_ADDRESS));
    }

    public static Application getApplication() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getIpStr(int i10) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (isUsableAddress(nextElement)) {
                        if (i11 >= i10) {
                            return nextElement.getHostAddress();
                        }
                        i11++;
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean isUsableAddress(InetAddress inetAddress) {
        return !(inetAddress instanceof Inet6Address);
    }

    private void startMDNS(InetAddress inetAddress, InetAddress inetAddress2) {
        if (inetAddress.getAddress().length == inetAddress2.getAddress().length) {
            this.multicastProcessors.add(new DatagramProcessor(inetAddress, inetAddress2, this.port, this));
        }
    }

    public void applyEDNS(Message message) {
        if (this.queryOPT == null || message.getOPT() != null) {
            return;
        }
        message.addRecord(this.queryOPT, 3);
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void broadcast(Message message, boolean z10) {
        if (message.getHeader().getOpcode() == 5) {
            updateCache(MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3), 4);
            writeMessageToWire(convertUpdateToQueryResponse(message));
            return;
        }
        if (!z10) {
            writeMessageToWire(message);
            return;
        }
        Message queryCache = this.cache.queryCache(message, 1);
        Integer[] numArr = {1, 3, 2};
        for (int i10 = 0; i10 < 3; i10++) {
            Integer num = numArr[i10];
            Record[] sectionArray = queryCache.getSectionArray(num.intValue());
            if (sectionArray != null && sectionArray.length > 0) {
                for (Record record : sectionArray) {
                    if (!message.findRecord(record)) {
                        message.addRecord(record, num.intValue());
                    }
                }
            }
        }
        writeMessageToWire(message);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ReceiveMessageThread receiveMessageThread = this.mReceiveMessageThread;
        if (receiveMessageThread != null) {
            receiveMessageThread.release();
        }
        try {
            MulticastDNSCache multicastDNSCache = this.cache;
            if (multicastDNSCache != null) {
                multicastDNSCache.close();
            }
            this.cache = null;
        } catch (Exception unused) {
        }
        CopyOnWriteArrayList<DatagramProcessor> copyOnWriteArrayList = this.multicastProcessors;
        if (copyOnWriteArrayList != null) {
            Iterator<DatagramProcessor> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                try {
                    it.next().close();
                } catch (Exception unused2) {
                }
            }
            try {
                CopyOnWriteArrayList<DatagramProcessor> copyOnWriteArrayList2 = this.multicastProcessors;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                    this.multicastProcessors = null;
                }
            } catch (Exception unused3) {
            }
        }
        try {
            CopyOnWriteArrayList<ResolverListener> copyOnWriteArrayList3 = this.mResolverListener;
            if (copyOnWriteArrayList3 != null) {
                copyOnWriteArrayList3.clear();
                this.mResolverListener = null;
            }
        } catch (Exception unused4) {
        }
    }

    public Message convertUpdateToQueryResponse(Message message) {
        Message message2 = new Message();
        Header header = message2.getHeader();
        header.setOpcode(0);
        header.setFlag(5);
        header.setFlag(0);
        for (Record record : message.getSectionArray(2)) {
            message2.addRecord(record, 1);
        }
        for (Record record2 : message.getSectionArray(3)) {
            message2.addRecord(record2, 3);
        }
        return message2;
    }

    public Cache getCache() {
        return this.cache;
    }

    public InetAddress getDeviceIpAddress(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        try {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)});
        } catch (Exception unused) {
            return null;
        }
    }

    public int getHostCount() {
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return i10;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public Name[] getMulticastDomains() {
        boolean isIPv4 = isIPv4();
        boolean isIPv6 = isIPv6();
        return (isIPv4 && isIPv6) ? Constants.ALL_MULTICAST_DNS_DOMAINS : isIPv4 ? Constants.IPv4_MULTICAST_DOMAINS : isIPv6 ? Constants.IPv6_MULTICAST_DOMAINS : new Name[0];
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean initNetWorkState() {
        return false;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isIPv4() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv4()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isIPv6() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv6()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public boolean isOperational() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (!it.next().isOperational()) {
                return false;
            }
        }
        return this.cacheMonitor.isOperational();
    }

    @Override // com.hpplay.sdk.source.mdns.net.PacketListener
    public void packetReceived(Packet packet) {
        byte[] data = packet.getData();
        if (data.length <= 0 || data.length < 12) {
            return;
        }
        try {
            Message parseMessage = parseMessage(data);
            CopyOnWriteArrayList<ResolverListener> copyOnWriteArrayList = this.mResolverListener;
            if (copyOnWriteArrayList != null) {
                Iterator<ResolverListener> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().receiveMessage(Integer.valueOf(parseMessage.getHeader().getID()), parseMessage);
                }
            }
        } catch (Exception unused) {
        }
    }

    public Message parseMessage(byte[] bArr) {
        try {
            return new Message(bArr);
        } catch (IOException e10) {
            if (this.mdnsVerbose) {
                e10.printStackTrace(System.err);
            }
            Exception exc = new Exception("Error parsing message - " + e10.getMessage());
            exc.setStackTrace(e10.getStackTrace());
            throw exc;
        }
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public ResolverListener registerListener(ResolverListener resolverListener) {
        this.mResolverListener.add(resolverListener);
        return resolverListener;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Message send(Message message) {
        if (message == null) {
            throw new IOException("Query is null");
        }
        Message message2 = (Message) message.clone();
        int opcode = message2.getHeader().getOpcode();
        if (opcode == 0 || opcode == 1) {
            Message queryCache = this.cache.queryCache(message2, 1);
            if (MulticastDNSUtils.answersAll(message2, queryCache)) {
                return queryCache;
            }
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            sendAsync(message2, new ResolverListener() { // from class: com.hpplay.sdk.source.mdns.MulticastDNSMulticastOnlyQuerier.1
                @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
                public void handleException(Object obj, Exception exc) {
                    synchronized (arrayList) {
                        arrayList2.add(exc);
                        arrayList.notifyAll();
                    }
                }

                @Override // com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener
                public void receiveMessage(Object obj, Message message3) {
                    synchronized (arrayList) {
                        arrayList.add(message3);
                        arrayList.notifyAll();
                    }
                }
            });
            Wait.forResponse((Iterable) arrayList);
            if (arrayList2.size() > 0) {
                Exception exc = (Exception) arrayList2.get(0);
                IOException iOException = new IOException(exc.getMessage());
                iOException.setStackTrace(exc.getStackTrace());
                throw iOException;
            }
        } else {
            if (opcode != 5) {
                throw new IOException("Don't know what to do with Opcode: " + Opcode.string(opcode) + " queries.");
            }
            broadcast(message2, false);
        }
        return this.cache.queryCache(message2, 1);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Message message2 = (Message) message.clone();
        Integer valueOf = Integer.valueOf(message2.getHeader().getID());
        int opcode = message2.getHeader().getOpcode();
        ListenerWrapper listenerWrapper = new ListenerWrapper(valueOf, message2, resolverListener, this);
        registerListener(listenerWrapper);
        if (opcode == 0 || opcode == 1) {
            try {
                Message queryCache = this.cache.queryCache(message2, 1);
                if (queryCache != null && queryCache.getRcode() == 0 && MulticastDNSUtils.answersAll(message2, queryCache)) {
                    MessageInfos messageInfos = new MessageInfos();
                    messageInfos.setIds(valueOf);
                    messageInfos.setListener(resolverListener);
                    messageInfos.setMessage(queryCache);
                    this.mReceiveMessageThread.updateReceiveData(messageInfos);
                }
                try {
                    broadcast(message2, false);
                } catch (IOException e10) {
                    unregisterListener(listenerWrapper);
                    resolverListener.handleException(valueOf, e10);
                }
                Options.intValue("mdns_resolve_wait");
                System.currentTimeMillis();
                unregisterListener(listenerWrapper);
            } catch (Exception e11) {
                resolverListener.handleException(valueOf, e11);
            }
        } else if (opcode != 5) {
            resolverListener.handleException(valueOf, new IOException("Don't know what to do with Opcode: " + Opcode.string(opcode) + " queries."));
            unregisterListener(listenerWrapper);
        } else {
            try {
                broadcast(message2, false);
            } catch (Exception e12) {
                resolverListener.handleException(valueOf, e12);
                unregisterListener(listenerWrapper);
            }
        }
        return valueOf;
    }

    public void setAddress(InetAddress inetAddress) {
        this.multicastAddress = inetAddress;
    }

    public void setCache(Cache cache) {
        if (cache instanceof MulticastDNSCache) {
            MulticastDNSCache multicastDNSCache = (MulticastDNSCache) cache;
            this.cache = multicastDNSCache;
            if (multicastDNSCache.getCacheMonitor() == null) {
                this.cache.setCacheMonitor(this.cacheMonitor);
                return;
            }
            return;
        }
        try {
            MulticastDNSCache multicastDNSCache2 = new MulticastDNSCache(cache);
            this.cache = multicastDNSCache2;
            if (multicastDNSCache2.getCacheMonitor() == null) {
                this.cache.setCacheMonitor(this.cacheMonitor);
            }
        } catch (Exception e10) {
            throw new IllegalArgumentException("Could not set Cache - " + e10.getMessage());
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10) {
        setEDNS(i10, 0, 0, null);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setIgnoreTruncation(boolean z10) {
        this.ignoreTruncation = z10;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setPort(int i10) {
        this.port = i10;
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void setRetryWaitTime(int i10) {
        setRetryWaitTime(i10, 0);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTCP(boolean z10) {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10) {
        setTimeout(i10, 0);
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public synchronized boolean unregisterListener(ResolverListener resolverListener) {
        try {
            CopyOnWriteArrayList<ResolverListener> copyOnWriteArrayList = this.mResolverListener;
            if (copyOnWriteArrayList == null) {
                return false;
            }
            return copyOnWriteArrayList.remove(resolverListener);
        } catch (Exception unused) {
            return false;
        }
    }

    public void updateCache(Record[] recordArr, int i10) {
        if (recordArr == null || recordArr.length <= 0) {
            return;
        }
        for (Record record : recordArr) {
            try {
                Record clone = MulticastDNSUtils.clone(record);
                MulticastDNSUtils.setDClassForRecord(clone, clone.getDClass() & 32767);
                if (clone.getTTL() > 0) {
                    RRset[] answers = this.cache.lookupRecords(clone.getName(), clone.getType(), 1).answers();
                    if (answers == null || answers.length <= 0) {
                        this.cache.addRecord(clone, i10, null);
                    } else {
                        Record[] extractRecords = MulticastDNSUtils.extractRecords(answers);
                        if (extractRecords != null && extractRecords.length > 0) {
                            this.cache.updateRRset(clone, i10);
                        }
                    }
                } else {
                    this.cache.removeElementCopy(clone.getName(), clone.getType());
                }
            } catch (Exception unused) {
            }
        }
    }

    public int verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig) {
        if (tsig == null) {
            return 0;
        }
        return tsig.verify(message2, bArr, message.getTSIG());
    }

    public void writeMessageToWire(Message message) {
        Header header = message.getHeader();
        header.setID(0);
        applyEDNS(message);
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(message, null);
        }
        byte[] wire = message.toWire(Message.MAXLENGTH);
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            DatagramProcessor next = it.next();
            OPTRecord opt = message.getOPT();
            if (wire.length > (opt != null ? opt.getPayloadSize() : next.getMaxPayloadSize())) {
                if (header.getFlag(0)) {
                    throw new IOException("DNS Message too large! - " + wire.length + " bytes in size.");
                }
                for (Message message2 : MulticastDNSUtils.splitMessage(message)) {
                    writeMessageToWire(message2);
                }
                return;
            }
            try {
                next.send(wire);
            } catch (Exception e10) {
                Iterator<ResolverListener> it2 = this.mResolverListener.iterator();
                while (it2.hasNext()) {
                    it2.next().handleException(TAG, e10);
                }
            }
        }
    }

    public void writeResponse(Message message) {
        Header header = message.getHeader();
        header.setFlag(5);
        header.setFlag(0);
        header.setRcode(0);
        writeMessageToWire(message);
    }

    public MulticastDNSMulticastOnlyQuerier(InetAddress inetAddress, InetAddress inetAddress2) {
        this.mdnsVerbose = false;
        this.cacheVerbose = false;
        this.mResolverListener = new CopyOnWriteArrayList<>();
        this.port = Constants.DEFAULT_PORT;
        this.ignoreTruncation = false;
        this.timeoutValue = 6000L;
        this.responseWaitTime = 500L;
        this.multicastProcessors = new CopyOnWriteArrayList<>();
        if (this.mReceiveMessageThread == null) {
            ReceiveMessageThread receiveMessageThread = new ReceiveMessageThread();
            this.mReceiveMessageThread = receiveMessageThread;
            receiveMessageThread.start();
        }
        this.cacheMonitor = new CacheMonitors(this);
        boolean z10 = true;
        this.mdnsVerbose = Options.check("mdns_verbose") || Options.check("verbose");
        if (!Options.check("mdns_cache_verbose") && !Options.check("cache_verbose")) {
            z10 = false;
        }
        this.cacheVerbose = z10;
        MulticastDNSCache multicastDNSCache = MulticastDNSCache.getInstance();
        this.cache = multicastDNSCache;
        if (multicastDNSCache.getCacheMonitor() == null) {
            this.cache.setCacheMonitor(this.cacheMonitor);
        }
        setAddress(inetAddress2);
        if (inetAddress != null) {
            this.multicastProcessors.add(new DatagramProcessor(inetAddress, inetAddress2, this.port, this));
        } else {
            try {
                int hostCount = getHostCount();
                for (int i10 = 0; i10 < hostCount; i10++) {
                    String ipStr = getIpStr(i10);
                    if (!TextUtils.isEmpty(ipStr)) {
                        startMDNS(InetAddress.getByName(ipStr), inetAddress2);
                    }
                }
            } catch (Exception unused) {
                startMDNS(getDeviceIpAddress(getApplication()), inetAddress2);
            }
        }
        Cacher cacher = new Cacher(this);
        this.cacher = cacher;
        registerListener(cacher);
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
        registerListener(new MulticastDNSResponder(this.mdnsVerbose, this));
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setEDNS(int i10, int i11, int i12, List list) {
        if (i10 != 0 && i10 != -1) {
            throw new IllegalArgumentException("invalid EDNS level - must be 0 or -1");
        }
        this.queryOPT = new OPTRecord(i11 == 0 ? 1280 : i11, 0, i10, i12, list);
    }

    @Override // com.hpplay.sdk.source.mdns.Querier
    public void setRetryWaitTime(int i10, int i11) {
        this.responseWaitTime = (i10 * 1000) + i11;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Resolver
    public void setTimeout(int i10, int i11) {
        this.timeoutValue = (i10 * 1000) + i11;
    }
}
