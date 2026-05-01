package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.utils.Misc;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class MulticastDNSUtils {
    private static final Logger logger = Misc.getLogger((Class<?>) MulticastDNSUtils.class, Options.check("mdns_verbose"));
    public static final Record[] EMPTY_RECORDS = new Record[0];

    public static boolean answersAll(Message message, Message message2) {
        int opcode = message2.getHeader().getOpcode();
        if (opcode != 0 && opcode != 1 && opcode != 2 && opcode != 4) {
            return false;
        }
        Record[] extractRecords = extractRecords(message, 0);
        Record[] extractRecords2 = extractRecords(message2, 0);
        int length = extractRecords.length;
        boolean[] zArr = new boolean[length];
        int i10 = 0;
        for (Record record : extractRecords) {
            zArr[i10] = false;
            for (Record record2 : extractRecords2) {
                if (record.getName().equals(record2.getName()) && (record2.getType() == 255 || record.getType() == record2.getType())) {
                    zArr[i10] = true;
                    break;
                }
            }
            i10++;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (!zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public static boolean answersAny(Message message, Message message2) {
        Header header = message2.getHeader();
        if (!header.getFlag(0)) {
            return false;
        }
        int opcode = header.getOpcode();
        if ((opcode != 0 && opcode != 1 && opcode != 2 && opcode != 4) || message == null) {
            return false;
        }
        Record[] extractRecords = extractRecords(message, 0);
        Record[] extractRecords2 = extractRecords(message2, 1, 3, 2);
        for (Record record : extractRecords) {
            for (Record record2 : extractRecords2) {
                if (record.getName().equals(record2.getName()) && (record.getType() == 255 || record.getType() == record2.getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Record clone(Record record) {
        return record.cloneRecord();
    }

    public static Record[] extractRecords(Message message, int... iArr) {
        Record[] recordArr = EMPTY_RECORDS;
        for (int i10 : iArr) {
            Record[] sectionArray = message.getSectionArray(i10);
            if (sectionArray != null && sectionArray.length > 0) {
                Record[] recordArr2 = new Record[recordArr.length + sectionArray.length];
                System.arraycopy(recordArr, 0, recordArr2, 0, recordArr.length);
                System.arraycopy(sectionArray, 0, recordArr2, recordArr.length, sectionArray.length);
                recordArr = recordArr2;
            }
        }
        return recordArr;
    }

    public static String getHostName() {
        String str = System.getenv().get("HOSTNAME");
        if (str == null || str.trim().length() == 0) {
            str = System.getenv().get("COMPUTERNAME");
        }
        if (str != null && str.trim().length() != 0) {
            return str;
        }
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            return (hostName == null || hostName.startsWith("unknown")) ? localHost.getCanonicalHostName() : hostName;
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    public static InetAddress[] getLocalAddresses() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        arrayList.add(inetAddresses.nextElement());
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public static String getMachineName() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && str == null) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.getCanonicalHostName().equalsIgnoreCase(nextElement2.getHostAddress())) {
                                str = nextElement2.getCanonicalHostName();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return str;
    }

    public static Name getTargetFromRecord(Record record) {
        if (record instanceof SingleNameBase) {
            return ((SingleNameBase) record).getSingleName();
        }
        try {
            Method method = record.getClass().getMethod("getTarget", new Class[0]);
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(record, new Object[0]);
            if (invoke instanceof Name) {
                return (Name) invoke;
            }
            return null;
        } catch (Exception unused) {
            logger.logp(Level.FINE, MulticastDNSUtils.class.getName(), "getTargetFromRecord", "No target specified in record " + record.getClass().getSimpleName() + ": " + record);
            return null;
        }
    }

    public static boolean messagesEqual(Message message, Message message2) {
        boolean z10;
        if (message == message2) {
            return true;
        }
        if (message == null || message2 == null) {
            return false;
        }
        Header header = message.getHeader();
        Header header2 = message2.getHeader();
        if (header != header2 && header != null && header2 != null) {
            if (!Arrays.equals(header.getFlags(), header2.getFlags())) {
                return false;
            }
            if (header.getOpcode() == header2.getOpcode() && header.getRcode() == header2.getRcode()) {
                z10 = true;
                return !z10 && Arrays.equals(extractRecords(message2, 0, 1, 2, 3), extractRecords(message, 0, 1, 2, 3));
            }
        }
        z10 = false;
        if (z10) {
        }
    }

    public static Message newQueryResponse(Record[] recordArr, int i10) {
        Message message = new Message();
        Header header = message.getHeader();
        header.setRcode(0);
        header.setOpcode(0);
        header.setFlag(0);
        for (Record record : recordArr) {
            message.addRecord(record, i10);
        }
        return message;
    }

    public static void setDClassForRecord(Record record, int i10) {
        record.dclass = i10;
    }

    public static void setTLLForRecord(Record record, long j10) {
        record.setTTL(j10);
    }

    public static Message[] splitMessage(Message message) {
        ArrayList arrayList = new ArrayList();
        int intValue = Options.intValue("mdns_max_records_per_message");
        if (intValue > 1) {
            intValue = 10;
        }
        int[] iArr = {0, 1, 2, 3};
        Message message2 = null;
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            Record[] sectionArray = message.getSectionArray(i11);
            for (int i12 = 0; i12 < sectionArray.length; i12++) {
                if (message2 == null) {
                    message2 = new Message();
                    Header header = (Header) message.getHeader().clone();
                    header.setCount(0, 0);
                    header.setCount(1, 0);
                    header.setCount(2, 0);
                    header.setCount(3, 0);
                    message2.setHeader(header);
                    message2.addRecord(sectionArray[i12], i11);
                } else {
                    message2.addRecord(sectionArray[i12], i11);
                }
                if (i12 != 0 && i12 % intValue == 0) {
                    arrayList.add(message2);
                    message2 = null;
                }
            }
        }
        return (Message[]) arrayList.toArray(new Message[arrayList.size()]);
    }

    public static final Record[] extractRecords(RRset rRset) {
        Iterator rrs;
        int i10 = 0;
        if (rRset == null) {
            return new Record[0];
        }
        int size = rRset.size();
        Record[] recordArr = new Record[size];
        if (size > 0 && (rrs = rRset.rrs(false)) != null) {
            while (rrs.hasNext()) {
                recordArr[i10] = (Record) rrs.next();
                i10++;
            }
        }
        return recordArr;
    }

    public static final Record[] extractRecords(RRset[] rRsetArr) {
        if (rRsetArr != null && rRsetArr.length != 0) {
            int i10 = 0;
            for (RRset rRset : rRsetArr) {
                i10 += rRset.size();
            }
            Record[] recordArr = new Record[i10];
            int i11 = 0;
            for (RRset rRset2 : rRsetArr) {
                Record[] extractRecords = extractRecords(rRset2);
                int length = extractRecords.length;
                int i12 = 0;
                while (i12 < length) {
                    recordArr[i11] = extractRecords[i12];
                    i12++;
                    i11++;
                }
            }
            return recordArr;
        }
        return EMPTY_RECORDS;
    }
}
