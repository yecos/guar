package com.hpplay.sdk.source.mdns.xbill.dns;

import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base16;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class Record implements Serializable, Cloneable, Comparable {
    private static final DecimalFormat byteFormat;
    private static final long serialVersionUID = 2694906050116005466L;
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public Record() {
    }

    public static byte[] byteArrayFromString(String str) {
        boolean z10;
        byte[] bytes = str.getBytes();
        int i10 = 0;
        while (true) {
            if (i10 >= bytes.length) {
                z10 = false;
                break;
            }
            if (bytes[i10] == 92) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            if (bytes.length <= 255) {
                return bytes;
            }
            throw new Exception("text string too long");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        for (byte b10 : bytes) {
            if (z11) {
                if (b10 >= 48 && b10 <= 57 && i11 < 3) {
                    i11++;
                    i12 = (i12 * 10) + (b10 - 48);
                    if (i12 > 255) {
                        throw new Exception("bad escape");
                    }
                    if (i11 >= 3) {
                        b10 = (byte) i12;
                    }
                } else if (i11 > 0 && i11 < 3) {
                    throw new Exception("bad escape");
                }
                byteArrayOutputStream.write(b10);
                z11 = false;
            } else if (b10 == 92) {
                i11 = 0;
                z11 = true;
                i12 = 0;
            } else {
                byteArrayOutputStream.write(b10);
            }
        }
        if (i11 > 0 && i11 < 3) {
            throw new Exception("bad escape");
        }
        if (byteArrayOutputStream.toByteArray().length <= 255) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new Exception("text string too long");
    }

    public static String byteArrayToString(byte[] bArr, boolean z10) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z10) {
            stringBuffer.append('\"');
        }
        for (byte b10 : bArr) {
            int i10 = b10 & UnsignedBytes.MAX_VALUE;
            if (i10 < 32 || i10 >= 127) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append(byteFormat.format(i10));
            } else if (i10 == 34 || i10 == 92) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append((char) i10);
            } else {
                stringBuffer.append((char) i10);
            }
        }
        if (z10) {
            stringBuffer.append('\"');
        }
        return stringBuffer.toString();
    }

    public static byte[] checkByteArrayLength(String str, byte[] bArr, int i10) {
        if (bArr.length <= 65535) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException("\"" + str + "\" array must have no more than " + i10 + " elements");
    }

    public static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        return null;
    }

    public static int checkU16(String str, int i10) {
        if (i10 >= 0 && i10 <= 65535) {
            return i10;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i10 + " must be an unsigned 16 bit value");
    }

    public static long checkU32(String str, long j10) {
        if (j10 >= 0 && j10 <= 4294967295L) {
            return j10;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + j10 + " must be an unsigned 32 bit value");
    }

    public static int checkU8(String str, int i10) {
        if (i10 >= 0 && i10 <= 255) {
            return i10;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i10 + " must be an unsigned 8 bit value");
    }

    public static Record fromString(Name name, int i10, int i11, long j10, Tokenizer tokenizer, Name name2) {
        if (!name.isAbsolute()) {
            throw new Exception("fromString name.isAbsolute");
        }
        Type.check(i10);
        DClass.check(i11);
        TTL.check(j10);
        Tokenizer.Token token = tokenizer.get();
        if (token.type == 3 && token.value.equals("\\#")) {
            int uInt16 = tokenizer.getUInt16();
            byte[] hex = tokenizer.getHex();
            if (hex == null) {
                hex = new byte[0];
            }
            if (uInt16 == hex.length) {
                return newRecord(name, i10, i11, j10, uInt16, new DNSInput(hex));
            }
            throw tokenizer.exception("invalid unknown RR encoding: length mismatch");
        }
        tokenizer.unget();
        Record emptyRecord = getEmptyRecord(name, i10, i11, j10, true);
        emptyRecord.rdataFromString(tokenizer, name2);
        int i12 = tokenizer.get().type;
        if (i12 == 1 || i12 == 0) {
            return emptyRecord;
        }
        throw tokenizer.exception("unexpected tokens at end of record");
    }

    public static Record fromWire(DNSInput dNSInput, int i10, boolean z10) {
        Name name = new Name(dNSInput);
        int readU16 = dNSInput.readU16();
        int readU162 = dNSInput.readU16();
        if (i10 == 0) {
            return newRecord(name, readU16, readU162);
        }
        long readU32 = dNSInput.readU32();
        int readU163 = dNSInput.readU16();
        return (readU163 == 0 && z10 && (i10 == 1 || i10 == 2)) ? newRecord(name, readU16, readU162, readU32) : newRecord(name, readU16, readU162, readU32, readU163, dNSInput);
    }

    private static final Record getEmptyRecord(Name name, int i10, int i11, long j10, boolean z10) {
        Record emptyRecord;
        if (z10) {
            Record proto = Type.getProto(i10);
            emptyRecord = proto != null ? proto.getObject() : new UNKRecord();
        } else {
            emptyRecord = new EmptyRecord();
        }
        emptyRecord.name = name;
        emptyRecord.type = i10;
        emptyRecord.dclass = i11;
        emptyRecord.ttl = j10;
        return emptyRecord;
    }

    private static Record newRecord(Name name, int i10, int i11, long j10, int i12, DNSInput dNSInput) {
        Record emptyRecord = getEmptyRecord(name, i10, i11, j10, dNSInput != null);
        if (dNSInput != null) {
            if (dNSInput.remaining() < i12) {
                throw new Exception("truncated record");
            }
            dNSInput.setActive(i12);
            emptyRecord.rrFromWire(dNSInput);
            if (dNSInput.remaining() > 0) {
                throw new Exception("invalid record length");
            }
            dNSInput.clearActive();
        }
        return emptyRecord;
    }

    private void toWireCanonical(DNSOutput dNSOutput, boolean z10) {
        this.name.toWireCanonical(dNSOutput);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (z10) {
            dNSOutput.writeU32(0L);
        } else {
            dNSOutput.writeU32(this.ttl);
        }
        int current = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, null, true);
        dNSOutput.writeU16At((dNSOutput.current() - current) - 2, current);
    }

    public static String unknownToString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\\# ");
        stringBuffer.append(bArr.length);
        stringBuffer.append(" ");
        stringBuffer.append(base16.toString(bArr));
        return stringBuffer.toString();
    }

    public Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Record record = (Record) obj;
        if (this == record) {
            return 0;
        }
        int compareTo = this.name.compareTo(record.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int i10 = this.dclass - record.dclass;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.type - record.type;
        if (i11 != 0) {
            return i11;
        }
        byte[] rdataToWireCanonical = rdataToWireCanonical();
        byte[] rdataToWireCanonical2 = record.rdataToWireCanonical();
        for (int i12 = 0; i12 < rdataToWireCanonical.length && i12 < rdataToWireCanonical2.length; i12++) {
            int i13 = (rdataToWireCanonical[i12] & UnsignedBytes.MAX_VALUE) - (rdataToWireCanonical2[i12] & UnsignedBytes.MAX_VALUE);
            if (i13 != 0) {
                return i13;
            }
        }
        return rdataToWireCanonical.length - rdataToWireCanonical2.length;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Record)) {
            Record record = (Record) obj;
            if (this.type == record.type && this.dclass == record.dclass && this.name.equals(record.name)) {
                return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
            }
        }
        return false;
    }

    public Name getAdditionalName() {
        return null;
    }

    public int getDClass() {
        return this.dclass;
    }

    public Name getName() {
        return this.name;
    }

    public abstract Record getObject();

    public int getRRsetType() {
        int i10 = this.type;
        return i10 == 46 ? ((RRSIGRecord) this).getTypeCovered() : i10;
    }

    public long getTTL() {
        return this.ttl;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i10 = 0;
        for (byte b10 : toWireCanonical(true)) {
            i10 += (i10 << 3) + (b10 & UnsignedBytes.MAX_VALUE);
        }
        return i10;
    }

    public abstract void rdataFromString(Tokenizer tokenizer, Name name);

    public String rdataToString() {
        return rrToString();
    }

    public byte[] rdataToWireCanonical() {
        DNSOutput dNSOutput = new DNSOutput();
        rrToWire(dNSOutput, null, true);
        return dNSOutput.toByteArray();
    }

    public abstract void rrFromWire(DNSInput dNSInput);

    public abstract String rrToString();

    public abstract void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10);

    public boolean sameRRset(Record record) {
        return getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name);
    }

    public void setTTL(long j10) {
        this.ttl = j10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        if (stringBuffer.length() < 8) {
            stringBuffer.append(HTTP.TAB);
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append(HTTP.TAB);
        }
        stringBuffer.append(HTTP.TAB);
        if (Options.check("BINDTTL")) {
            stringBuffer.append(TTL.format(this.ttl));
        } else {
            stringBuffer.append(this.ttl);
        }
        stringBuffer.append(HTTP.TAB);
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            stringBuffer.append(DClass.string(this.dclass));
            stringBuffer.append(HTTP.TAB);
        }
        stringBuffer.append(Type.string(this.type));
        String rrToString = rrToString();
        if (!rrToString.equals("")) {
            stringBuffer.append(HTTP.TAB);
            stringBuffer.append(rrToString);
        }
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput, int i10, Compression compression) {
        this.name.toWire(dNSOutput, compression);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (i10 != 0) {
            dNSOutput.writeU32(this.ttl);
            int current = dNSOutput.current();
            dNSOutput.writeU16(0);
            rrToWire(dNSOutput, compression, false);
            dNSOutput.writeU16At((dNSOutput.current() - current) - 2, current);
        }
    }

    public Record(Name name, int i10, int i11, long j10) {
        if (!name.isAbsolute()) {
            Log.e("Record", "name.isAbsolute ");
            return;
        }
        Type.check(i10);
        DClass.check(i11);
        TTL.check(j10);
        this.name = name;
        this.type = i10;
        this.dclass = i11;
        this.ttl = j10;
    }

    public static Record newRecord(Name name, int i10, int i11, long j10, int i12, byte[] bArr) {
        if (!name.isAbsolute()) {
            return null;
        }
        Type.check(i10);
        DClass.check(i11);
        TTL.check(j10);
        try {
            return newRecord(name, i10, i11, j10, i12, bArr != null ? new DNSInput(bArr) : null);
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] toWire(int i10) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i10, null);
        return dNSOutput.toByteArray();
    }

    private byte[] toWireCanonical(boolean z10) {
        DNSOutput dNSOutput = new DNSOutput();
        toWireCanonical(dNSOutput, z10);
        return dNSOutput.toByteArray();
    }

    public byte[] toWireCanonical() {
        return toWireCanonical(false);
    }

    public static Record newRecord(Name name, int i10, int i11, long j10) {
        if (!name.isAbsolute()) {
            return null;
        }
        Type.check(i10);
        DClass.check(i11);
        TTL.check(j10);
        return getEmptyRecord(name, i10, i11, j10, false);
    }

    public static Record fromString(Name name, int i10, int i11, long j10, String str, Name name2) {
        return fromString(name, i10, i11, j10, new Tokenizer(str), name2);
    }

    public static Record newRecord(Name name, int i10, int i11) {
        return newRecord(name, i10, i11, 0L);
    }
}
