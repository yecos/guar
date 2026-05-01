package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.TXTRecord;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ServiceInstance implements Serializable {
    private static final long serialVersionUID = 201210181454L;
    private List addresses;
    private Name host;
    private final ServiceName name;
    private String niceText;
    private final List pointers;
    private int port;
    private int priority;
    private String[] text;
    private final Map textAttributes;
    private int weight;

    public ServiceInstance(ServiceName serviceName, int i10, int i11, int i12, Name name, String... strArr) {
        this(serviceName, i10, i11, i12, name, new InetAddress[]{InetAddress.getLocalHost()}, strArr);
    }

    public static Map parseTextRecords(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        if (obj.getClass().isArray()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                linkedHashMap = new LinkedHashMap();
                for (Object obj2 : objArr) {
                    Map parseTextRecords = parseTextRecords(obj2);
                    if (parseTextRecords != null && parseTextRecords.size() > 0) {
                        linkedHashMap.putAll(parseTextRecords);
                    }
                }
            }
            return linkedHashMap;
        }
        if (obj instanceof Collection) {
            return parseTextRecords(((Collection) obj).toArray());
        }
        if (obj instanceof TXTRecord) {
            return parseTextRecords(((TXTRecord) obj).getStrings().toArray());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str2 : split(obj.toString())) {
            if (str2 != null && str2.length() > 0) {
                int indexOf = str2.indexOf(61);
                str = "";
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    int i10 = indexOf + 1;
                    str = i10 <= str2.length() ? str2.substring(i10) : "";
                    str2 = substring;
                }
                linkedHashMap2.put(str2, str);
            }
        }
        return linkedHashMap2;
    }

    private static String[] split(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = (str + '\n').toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (Character.isWhitespace(charArray[i10])) {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else {
                char c10 = charArray[i10];
                if (c10 != '\"') {
                    if (c10 != '\\') {
                        sb.append(c10);
                        if (z10) {
                            z10 = false;
                        }
                    } else {
                        z10 = true;
                    }
                } else if (z10) {
                    sb.append(c10);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addAddress(InetAddress inetAddress) {
        if (this.addresses.contains(inetAddress)) {
            return;
        }
        this.addresses.add(inetAddress);
    }

    public void addPointer(Name name) {
        if (this.pointers.contains(name)) {
            return;
        }
        this.pointers.add(name);
    }

    public void addText(Map map) {
        if (map != null) {
            this.textAttributes.putAll(map);
        }
    }

    public void addTextRecords(TXTRecord... tXTRecordArr) {
        Map parseTextRecords = parseTextRecords(tXTRecordArr);
        if (parseTextRecords != null) {
            this.textAttributes.putAll(parseTextRecords);
        }
    }

    public InetAddress[] getAddresses() {
        List list = this.addresses;
        if (list == null || list.size() == 0) {
            return null;
        }
        List list2 = this.addresses;
        return (InetAddress[]) list2.toArray(new InetAddress[list2.size()]);
    }

    public Name getHost() {
        return this.host;
    }

    public ServiceName getName() {
        return this.name;
    }

    public String getNiceText() {
        return this.niceText;
    }

    public Name[] getPointers() {
        List list = this.pointers;
        if (list == null || list.size() == 0) {
            return null;
        }
        List list2 = this.pointers;
        return (Name[]) list2.toArray(new Name[list2.size()]);
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public String[] getText() {
        return this.text;
    }

    public Map getTextAttributes() {
        return this.textAttributes;
    }

    public int getWeight() {
        return this.weight;
    }

    public void removeAddress(InetAddress inetAddress) {
        this.addresses.remove(inetAddress);
    }

    public void removePointer(Name name) {
        this.pointers.remove(name);
    }

    public void removeTextRecords(TXTRecord... tXTRecordArr) {
        Map parseTextRecords = parseTextRecords(tXTRecordArr);
        if (parseTextRecords != null) {
            Iterator it = parseTextRecords.keySet().iterator();
            while (it.hasNext()) {
                this.textAttributes.remove(it.next());
            }
        }
    }

    public void setAddresses(List list) {
        if (list != null) {
            this.addresses.clear();
            this.addresses.addAll(list);
        }
    }

    public void setHost(Name name) {
        this.host = name;
    }

    public void setNiceText(String str) {
        this.niceText = str;
    }

    public void setPointers(List list) {
        if (list != null) {
            this.pointers.clear();
            this.pointers.addAll(list);
        }
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setWeight(int i10) {
        this.weight = i10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Service (\"");
        sb.append(this.name);
        sb.append("\"");
        if (this.host != null) {
            sb.append(" can be reached at \"");
            sb.append(this.host);
            sb.append("\" ");
            sb.append(Arrays.toString(getAddresses()));
        }
        if (this.port > 0) {
            sb.append(" on port ");
            sb.append(getPort());
        }
        StringBuilder sb2 = new StringBuilder();
        Map map = this.textAttributes;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : this.textAttributes.entrySet()) {
                if (sb2.length() == 0) {
                    sb.append("\n\tTXT: ");
                }
                sb2.append(entry.getKey());
                Object value = entry.getValue();
                if (value != null) {
                    sb2.append("=\"");
                    sb2.append(value.toString());
                    sb2.append("\"");
                }
                sb2.append(", ");
                if (sb2.length() > 100) {
                    sb2.setLength(sb.length() - 2);
                    sb.append((CharSequence) sb2);
                    sb2.setLength(0);
                }
            }
            if (sb2.length() > 0) {
                sb2.setLength(sb.length() - 2);
                sb.append((CharSequence) sb2);
                sb2.setLength(0);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public ServiceInstance(ServiceName serviceName, int i10, int i11, int i12, Name name, InetAddress[] inetAddressArr, Collection collection) {
        this(serviceName, i10, i11, i12, name, inetAddressArr, parseTextRecords(collection));
    }

    public void addText(String str, String str2) {
        this.textAttributes.put(str, str2);
    }

    public ServiceInstance(ServiceName serviceName, int i10, int i11, int i12, Name name, InetAddress[] inetAddressArr, Map map) {
        this.pointers = new ArrayList();
        this.addresses = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.textAttributes = linkedHashMap;
        this.name = serviceName;
        this.host = name;
        this.priority = i10;
        this.weight = i11;
        this.port = i12;
        if (inetAddressArr != null) {
            this.addresses = new ArrayList(Arrays.asList(inetAddressArr));
        }
        if (map != null) {
            linkedHashMap.putAll(map);
            this.text = new String[map.size()];
            Map.Entry[] entryArr = (Map.Entry[]) map.entrySet().toArray(new Map.Entry[map.size()]);
            for (int i13 = 0; i13 < entryArr.length; i13++) {
                this.text[i13] = entryArr[i13].getKey() + Operator.Operation.EQUALS + entryArr[i13].getValue();
            }
        }
    }

    public ServiceInstance(ServiceName serviceName, int i10, int i11, int i12, Name name, InetAddress[] inetAddressArr, String... strArr) {
        this(serviceName, i10, i11, i12, name, inetAddressArr, parseTextRecords(strArr));
    }

    public ServiceInstance(ServiceName serviceName, int i10, int i11, int i12, Name name, InetAddress[] inetAddressArr, TXTRecord... tXTRecordArr) {
        this(serviceName, i10, i11, i12, name, inetAddressArr, parseTextRecords(tXTRecordArr));
    }

    public ServiceInstance(SRVRecord sRVRecord) {
        this(new ServiceName(sRVRecord.getName()), sRVRecord.getPriority(), sRVRecord.getWeight(), sRVRecord.getPort(), sRVRecord.getTarget(), (InetAddress[]) null, (Map) null);
    }
}
