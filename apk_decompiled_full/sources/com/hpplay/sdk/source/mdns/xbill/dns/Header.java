package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Random;

/* loaded from: classes3.dex */
public class Header implements Cloneable {
    public static final int LENGTH = 12;
    private static Random random = new Random();
    private int[] counts;
    private int flags;
    private int id;

    public Header(int i10) {
        init();
        setID(i10);
    }

    private static void checkFlag(int i10) {
        if (validFlag(i10)) {
            return;
        }
        throw new IllegalArgumentException("invalid flag bit " + i10);
    }

    private void init() {
        this.counts = new int[4];
        this.flags = 0;
        this.id = -1;
    }

    public static int setFlag(int i10, int i11, boolean z10) {
        checkFlag(i11);
        int i12 = 1 << (15 - i11);
        return z10 ? i10 | i12 : i10 & (i12 ^ (-1));
    }

    private static boolean validFlag(int i10) {
        return i10 >= 0 && i10 <= 15 && Flags.isFlag(i10);
    }

    public Object clone() {
        Header header = new Header();
        header.id = this.id;
        header.flags = this.flags;
        int[] iArr = this.counts;
        System.arraycopy(iArr, 0, header.counts, 0, iArr.length);
        return header;
    }

    public void decCount(int i10) {
        int[] iArr = this.counts;
        int i11 = iArr[i10];
        if (i11 == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        iArr[i10] = i11 - 1;
    }

    public int getCount(int i10) {
        return this.counts[i10];
    }

    public boolean getFlag(int i10) {
        checkFlag(i10);
        return ((1 << (15 - i10)) & this.flags) != 0;
    }

    public boolean[] getFlags() {
        boolean[] zArr = new boolean[16];
        for (int i10 = 0; i10 < 16; i10++) {
            if (validFlag(i10)) {
                zArr[i10] = getFlag(i10);
            }
        }
        return zArr;
    }

    public int getFlagsByte() {
        return this.flags;
    }

    public int getID() {
        int i10;
        int i11 = this.id;
        if (i11 >= 0) {
            return i11;
        }
        synchronized (this) {
            if (this.id < 0) {
                this.id = random.nextInt(Message.MAXLENGTH);
            }
            i10 = this.id;
        }
        return i10;
    }

    public int getOpcode() {
        return (this.flags >> 11) & 15;
    }

    public int getRcode() {
        return this.flags & 15;
    }

    public void incCount(int i10) {
        int[] iArr = this.counts;
        int i11 = iArr[i10];
        if (i11 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i10] = i11 + 1;
    }

    public String printFlags() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 16; i10++) {
            if (validFlag(i10) && getFlag(i10)) {
                stringBuffer.append(Flags.string(i10));
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public void setCount(int i10, int i11) {
        if (i11 >= 0 && i11 <= 65535) {
            this.counts[i10] = i11;
            return;
        }
        throw new IllegalArgumentException("DNS section count " + i11 + " is out of range");
    }

    public void setID(int i10) {
        if (i10 >= 0 && i10 <= 65535) {
            this.id = i10;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i10 + " is out of range");
    }

    public void setOpcode(int i10) {
        if (i10 >= 0 && i10 <= 15) {
            this.flags = (i10 << 11) | (this.flags & 34815);
        } else {
            throw new IllegalArgumentException("DNS Opcode " + i10 + "is out of range");
        }
    }

    public void setRcode(int i10) {
        if (i10 >= 0 && i10 <= 15) {
            this.flags = i10 | (this.flags & (-16));
            return;
        }
        throw new IllegalArgumentException("DNS Rcode " + i10 + " is out of range");
    }

    public String toString() {
        return toStringWithRcode(getRcode());
    }

    public String toStringWithRcode(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append("opcode: " + Opcode.string(getOpcode()));
        stringBuffer.append(", status: " + Rcode.string(i10));
        stringBuffer.append(", id: " + getID());
        stringBuffer.append("\n");
        stringBuffer.append(";; flags: " + printFlags());
        stringBuffer.append("; ");
        for (int i11 = 0; i11 < 4; i11++) {
            stringBuffer.append(Section.string(i11) + ": " + getCount(i11) + " ");
        }
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(getID());
        dNSOutput.writeU16(this.flags);
        int i10 = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i10 >= iArr.length) {
                return;
            }
            dNSOutput.writeU16(iArr[i10]);
            i10++;
        }
    }

    public void setFlag(int i10) {
        checkFlag(i10);
        this.flags = setFlag(this.flags, i10, true);
    }

    public Header() {
        init();
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public Header(DNSInput dNSInput) {
        this(dNSInput.readU16());
        this.flags = dNSInput.readU16();
        int i10 = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = dNSInput.readU16();
            i10++;
        }
    }

    public Header(byte[] bArr) {
        this(new DNSInput(bArr));
    }
}
