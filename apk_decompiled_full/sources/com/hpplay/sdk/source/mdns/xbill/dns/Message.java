package com.hpplay.sdk.source.mdns.xbill.dns;

import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class Message implements Cloneable {
    public static final int MAXLENGTH = 65535;
    static final int TSIG_FAILED = 4;
    static final int TSIG_INTERMEDIATE = 2;
    static final int TSIG_SIGNED = 3;
    static final int TSIG_UNSIGNED = 0;
    static final int TSIG_VERIFIED = 1;
    private Header header;
    private TSIGRecord querytsig;
    private List[] sections;
    int sig0start;
    private int size;
    int tsigState;
    private int tsigerror;
    private TSIG tsigkey;
    int tsigstart;
    private static Record[] emptyRecordArray = new Record[0];
    private static RRset[] emptyRRsetArray = new RRset[0];

    private Message(Header header) {
        this.sections = new List[4];
        this.header = header;
    }

    public static Message newQuery(Record record) {
        Message message = new Message();
        message.header.setOpcode(0);
        message.header.setFlag(7);
        message.addRecord(record, 0);
        return message;
    }

    public static Message newUpdate(Name name) {
        return new Update(name);
    }

    private static boolean sameSet(Record record, Record record2) {
        return record.getRRsetType() == record2.getRRsetType() && record.getDClass() == record2.getDClass() && record.getName().equals(record2.getName());
    }

    private int sectionToWire(DNSOutput dNSOutput, int i10, Compression compression, int i11) {
        int size = this.sections[i10].size();
        int current = dNSOutput.current();
        Record record = null;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            Record record2 = (Record) this.sections[i10].get(i14);
            if (i10 == 3 && (record2 instanceof OPTRecord)) {
                i12++;
            } else {
                if (record != null && !sameSet(record2, record)) {
                    current = dNSOutput.current();
                    i13 = i14;
                }
                record2.toWire(dNSOutput, i10, compression);
                if (dNSOutput.current() > i11) {
                    dNSOutput.jump(current);
                    return (size - i13) + i12;
                }
                record = record2;
            }
        }
        return i12;
    }

    public void addRecord(Record record, int i10) {
        List[] listArr = this.sections;
        if (listArr[i10] == null) {
            listArr[i10] = new LinkedList();
        }
        this.header.incCount(i10);
        this.sections[i10].add(record);
    }

    public Object clone() {
        Message message = new Message();
        int i10 = 0;
        while (true) {
            List[] listArr = this.sections;
            if (i10 >= listArr.length) {
                message.header = (Header) this.header.clone();
                message.size = this.size;
                return message;
            }
            if (listArr[i10] != null) {
                message.sections[i10] = new LinkedList(this.sections[i10]);
            }
            i10++;
        }
    }

    public boolean findRRset(Name name, int i10, int i11) {
        if (this.sections[i11] == null) {
            return false;
        }
        for (int i12 = 0; i12 < this.sections[i11].size(); i12++) {
            Record record = (Record) this.sections[i11].get(i12);
            if (record.getType() == i10 && name.equals(record.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findRecord(Record record, int i10) {
        List list = this.sections[i10];
        return list != null && list.contains(record);
    }

    public Header getHeader() {
        return this.header;
    }

    public OPTRecord getOPT() {
        for (Record record : getSectionArray(3)) {
            if (record instanceof OPTRecord) {
                return (OPTRecord) record;
            }
        }
        return null;
    }

    public Record getQuestion() {
        List list = this.sections[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (Record) list.get(0);
    }

    public int getRcode() {
        int rcode = this.header.getRcode();
        OPTRecord opt = getOPT();
        return opt != null ? rcode + (opt.getExtendedRcode() << 4) : rcode;
    }

    public Record[] getSectionArray(int i10) {
        List list = this.sections[i10];
        return list == null ? emptyRecordArray : (Record[]) list.toArray(new Record[list.size()]);
    }

    public RRset[] getSectionRRsets(int i10) {
        if (this.sections[i10] == null) {
            return emptyRRsetArray;
        }
        LinkedList linkedList = new LinkedList();
        Record[] sectionArray = getSectionArray(i10);
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < sectionArray.length; i11++) {
            Name name = sectionArray[i11].getName();
            boolean z10 = true;
            if (hashSet.contains(name)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    RRset rRset = (RRset) linkedList.get(size);
                    if (rRset.getType() == sectionArray[i11].getRRsetType() && rRset.getDClass() == sectionArray[i11].getDClass() && rRset.getName().equals(name)) {
                        rRset.addRR(sectionArray[i11]);
                        z10 = false;
                        break;
                    }
                    size--;
                }
            }
            if (z10) {
                linkedList.add(new RRset(sectionArray[i11]));
                hashSet.add(name);
            }
        }
        return (RRset[]) linkedList.toArray(new RRset[linkedList.size()]);
    }

    public TSIGRecord getTSIG() {
        int count = this.header.getCount(3);
        if (count == 0) {
            return null;
        }
        Record record = (Record) this.sections[3].get(count - 1);
        if (record.type != 250) {
            return null;
        }
        return (TSIGRecord) record;
    }

    public boolean isSigned() {
        int i10 = this.tsigState;
        return i10 == 3 || i10 == 1 || i10 == 4;
    }

    public boolean isVerified() {
        return this.tsigState == 1;
    }

    public int numBytes() {
        return this.size;
    }

    public void removeAllRecords(int i10) {
        this.sections[i10] = null;
        this.header.setCount(i10, 0);
    }

    public boolean removeRecord(Record record, int i10) {
        List list = this.sections[i10];
        if (list == null || !list.remove(record)) {
            return false;
        }
        this.header.decCount(i10);
        return true;
    }

    public String sectionToString(int i10) {
        if (i10 > 3) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Record record : getSectionArray(i10)) {
            if (i10 == 0) {
                stringBuffer.append(";;\t" + record.name);
                stringBuffer.append(", type = " + Type.string(record.type));
                stringBuffer.append(", class = " + DClass.string(record.dclass));
            } else {
                stringBuffer.append(record);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setTSIG(TSIG tsig, int i10, TSIGRecord tSIGRecord) {
        this.tsigkey = tsig;
        this.tsigerror = i10;
        this.querytsig = tSIGRecord;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (getOPT() != null) {
            stringBuffer.append(this.header.toStringWithRcode(getRcode()) + "\n");
        } else {
            stringBuffer.append(this.header + "\n");
        }
        if (isSigned()) {
            stringBuffer.append(";; TSIG ");
            if (isVerified()) {
                stringBuffer.append(ITagManager.SUCCESS);
            } else {
                stringBuffer.append("invalid");
            }
            stringBuffer.append('\n');
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if (this.header.getOpcode() != 5) {
                stringBuffer.append(";; " + Section.longString(i10) + ":\n");
            } else {
                stringBuffer.append(";; " + Section.updString(i10) + ":\n");
            }
            stringBuffer.append(sectionToString(i10) + "\n");
        }
        stringBuffer.append(";; Message size: " + numBytes() + " bytes");
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        for (int i10 = 0; i10 < 4; i10++) {
            if (this.sections[i10] != null) {
                for (int i11 = 0; i11 < this.sections[i10].size(); i11++) {
                    ((Record) this.sections[i10].get(i11)).toWire(dNSOutput, i10, compression);
                }
            }
        }
    }

    public boolean findRecord(Record record) {
        for (int i10 = 1; i10 <= 3; i10++) {
            List list = this.sections[i10];
            if (list != null && list.contains(record)) {
                return true;
            }
        }
        return false;
    }

    public Message(int i10) {
        this(new Header(i10));
    }

    public Message() {
        this(new Header());
    }

    public boolean findRRset(Name name, int i10) {
        return findRRset(name, i10, 1) || findRRset(name, i10, 2) || findRRset(name, i10, 3);
    }

    public Message(DNSInput dNSInput) {
        this(new Header(dNSInput));
        boolean z10 = this.header.getOpcode() == 5;
        boolean flag = this.header.getFlag(6);
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                int count = this.header.getCount(i10);
                if (count > 0) {
                    this.sections[i10] = new ArrayList(count);
                }
                for (int i11 = 0; i11 < count; i11++) {
                    int current = dNSInput.current();
                    Record fromWire = Record.fromWire(dNSInput, i10, z10);
                    this.sections[i10].add(fromWire);
                    if (i10 == 3) {
                        if (fromWire.getType() == 250) {
                            this.tsigstart = current;
                        }
                        if (fromWire.getType() == 24 && ((SIGRecord) fromWire).getTypeCovered() == 0) {
                            this.sig0start = current;
                        }
                    }
                }
            } catch (Exception e10) {
                if (!flag) {
                    throw e10;
                }
            }
        }
        this.size = dNSInput.current();
    }

    private boolean toWire(DNSOutput dNSOutput, int i10) {
        byte[] bArr;
        if (i10 < 12) {
            return false;
        }
        TSIG tsig = this.tsigkey;
        if (tsig != null) {
            i10 -= tsig.recordLength();
        }
        OPTRecord opt = getOPT();
        if (opt != null) {
            bArr = opt.toWire(3);
            i10 -= bArr.length;
        } else {
            bArr = null;
        }
        int current = dNSOutput.current();
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int flagsByte = this.header.getFlagsByte();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= 4) {
                break;
            }
            if (this.sections[i11] != null) {
                int sectionToWire = sectionToWire(dNSOutput, i11, compression, i10);
                if (sectionToWire != 0 && i11 != 3) {
                    flagsByte = Header.setFlag(flagsByte, 6, true);
                    int count = this.header.getCount(i11) - sectionToWire;
                    int i13 = current + 4;
                    dNSOutput.writeU16At(count, (i11 * 2) + i13);
                    for (int i14 = i11 + 1; i14 < 3; i14++) {
                        dNSOutput.writeU16At(0, (i14 * 2) + i13);
                    }
                } else if (i11 == 3) {
                    i12 = this.header.getCount(i11) - sectionToWire;
                }
            }
            i11++;
        }
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
            i12++;
        }
        if (flagsByte != this.header.getFlagsByte()) {
            dNSOutput.writeU16At(flagsByte, current + 2);
        }
        if (i12 != this.header.getCount(3)) {
            dNSOutput.writeU16At(i12, current + 10);
        }
        TSIG tsig2 = this.tsigkey;
        if (tsig2 != null) {
            tsig2.generate(this, dNSOutput.toByteArray(), this.tsigerror, this.querytsig).toWire(dNSOutput, 3, compression);
            dNSOutput.writeU16At(i12 + 1, current + 10);
        }
        return true;
    }

    public Message(byte[] bArr) {
        this(new DNSInput(bArr));
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i10) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i10);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }
}
