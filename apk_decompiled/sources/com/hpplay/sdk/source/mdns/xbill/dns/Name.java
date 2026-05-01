package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public class Name implements Serializable, Comparable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXLABELS = 128;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 7;
    private static final DecimalFormat byteFormat;
    public static final Name empty;
    private static final byte[] lowercase;
    public static final Name root;
    private static final long serialVersionUID = -7257019940971525644L;
    private static final Name wild;
    private int hashcode;
    private byte[] name;
    private long offsets;
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        lowercase = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i10 = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i10 >= bArr.length) {
                Name name = new Name();
                root = name;
                name.appendSafe(emptyLabel, 0, 1);
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.appendSafe(wildLabel, 0, 1);
                return;
            }
            if (i10 < 65 || i10 > 90) {
                bArr[i10] = (byte) i10;
            } else {
                bArr[i10] = (byte) ((i10 - 65) + 97);
            }
            i10++;
        }
    }

    private Name() {
    }

    private final void append(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length - offset(0);
        int i12 = i10;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = bArr[i12];
            if (i15 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i16 = i15 + 1;
            i12 += i16;
            i13 += i16;
        }
        int i17 = length + i13;
        if (i17 > 255) {
            throw new Exception();
        }
        int i18 = getlabels();
        int i19 = i18 + i11;
        if (i19 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i17];
        if (length != 0) {
            System.arraycopy(this.name, offset(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i10, bArr3, length, i13);
        this.name = bArr3;
        for (int i20 = 0; i20 < i11; i20++) {
            setoffset(i18 + i20, length);
            length += bArr3[length] + 1;
        }
        setlabels(i19);
    }

    private final void appendFromString(String str, byte[] bArr, int i10, int i11) {
        try {
            append(bArr, i10, i11);
        } catch (Exception unused) {
            throw parseException(str, "Name too long");
        }
    }

    private final void appendSafe(byte[] bArr, int i10, int i11) {
        try {
            append(bArr, i10, i11);
        } catch (Exception unused) {
        }
    }

    private String byteString(byte[] bArr, int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = i10 + 1;
        int i12 = bArr[i10];
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            int i14 = bArr[i13] & UnsignedBytes.MAX_VALUE;
            if (i14 <= 32 || i14 >= 127) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append(byteFormat.format(i14));
            } else if (i14 == 34 || i14 == 40 || i14 == 41 || i14 == 46 || i14 == 59 || i14 == 92 || i14 == 64 || i14 == 36) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append((char) i14);
            } else {
                stringBuffer.append((char) i14);
            }
        }
        return stringBuffer.toString();
    }

    public static Name concatenate(Name name, Name name2) {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        copy(name, name3);
        name3.append(name2.name, name2.offset(0), name2.getlabels());
        return name3;
    }

    private static final void copy(Name name, Name name2) {
        if (name.offset(0) == 0) {
            name2.name = name.name;
            name2.offsets = name.offsets;
            return;
        }
        int offset = name.offset(0);
        int length = name.name.length - offset;
        int labels = name.labels();
        byte[] bArr = new byte[length];
        name2.name = bArr;
        System.arraycopy(name.name, offset, bArr, 0, length);
        for (int i10 = 0; i10 < labels && i10 < 7; i10++) {
            name2.setoffset(i10, name.offset(i10) - offset);
        }
        name2.setlabels(labels);
    }

    private final boolean equals(byte[] bArr, int i10) {
        int labels = labels();
        int offset = offset(0);
        for (int i11 = 0; i11 < labels; i11++) {
            byte b10 = this.name[offset];
            if (b10 != bArr[i10]) {
                return false;
            }
            offset++;
            i10++;
            if (b10 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i12 = 0;
            while (i12 < b10) {
                byte[] bArr2 = lowercase;
                int i13 = offset + 1;
                int i14 = i10 + 1;
                if (bArr2[this.name[offset] & UnsignedBytes.MAX_VALUE] != bArr2[bArr[i10] & UnsignedBytes.MAX_VALUE]) {
                    return false;
                }
                i12++;
                i10 = i14;
                offset = i13;
            }
        }
        return true;
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public static Name fromString(String str, Name name) {
        return (!str.equals("@") || name == null) ? str.equals(".") ? root : new Name(str, name) : name;
    }

    private final int getlabels() {
        return (int) (this.offsets & 255);
    }

    private final int offset(int i10) {
        if (i10 == 0 && getlabels() == 0) {
            return 0;
        }
        if (i10 < 0 || i10 >= getlabels()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i10 < 7) {
            return ((int) (this.offsets >>> ((7 - i10) * 8))) & 255;
        }
        int offset = offset(6);
        for (int i11 = 6; i11 < i10; i11++) {
            offset += this.name[offset] + 1;
        }
        return offset;
    }

    private static Exception parseException(String str, String str2) {
        return new Exception("'" + str + "': " + str2);
    }

    private final void setlabels(int i10) {
        this.offsets = (this.offsets & (-256)) | i10;
    }

    private final void setoffset(int i10, int i11) {
        if (i10 < 7) {
            int i12 = (7 - i10) * 8;
            this.offsets = (i11 << i12) | (this.offsets & ((255 << i12) ^ (-1)));
        }
    }

    public Name canonicalize() {
        boolean z10;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.name;
            if (i11 >= bArr.length) {
                z10 = true;
                break;
            }
            byte[] bArr2 = lowercase;
            byte b10 = bArr[i11];
            if (bArr2[b10 & UnsignedBytes.MAX_VALUE] != b10) {
                z10 = false;
                break;
            }
            i11++;
        }
        if (z10) {
            return this;
        }
        Name name = new Name();
        name.appendSafe(this.name, offset(0), getlabels());
        while (true) {
            byte[] bArr3 = name.name;
            if (i10 >= bArr3.length) {
                return name;
            }
            bArr3[i10] = lowercase[bArr3[i10] & UnsignedBytes.MAX_VALUE];
            i10++;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Name name = (Name) obj;
        if (this == name) {
            return 0;
        }
        int labels = labels();
        int labels2 = name.labels();
        int i10 = labels > labels2 ? labels2 : labels;
        for (int i11 = 1; i11 <= i10; i11++) {
            int offset = offset(labels - i11);
            int offset2 = name.offset(labels2 - i11);
            byte b10 = this.name[offset];
            byte b11 = name.name[offset2];
            for (int i12 = 0; i12 < b10 && i12 < b11; i12++) {
                byte[] bArr = lowercase;
                int i13 = bArr[this.name[(i12 + offset) + 1] & UnsignedBytes.MAX_VALUE] - bArr[name.name[(i12 + offset2) + 1] & UnsignedBytes.MAX_VALUE];
                if (i13 != 0) {
                    return i13;
                }
            }
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return labels - labels2;
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) {
        Name name = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name)) {
            return null;
        }
        int labels = labels() - name.labels();
        int length = length() - name.length();
        int offset = offset(0);
        int labels2 = target.labels();
        short length2 = target.length();
        int i10 = length + length2;
        if (i10 > 255) {
            throw new Exception();
        }
        Name name2 = new Name();
        int i11 = labels + labels2;
        name2.setlabels(i11);
        byte[] bArr = new byte[i10];
        name2.name = bArr;
        System.arraycopy(this.name, offset, bArr, 0, length);
        System.arraycopy(target.name, 0, name2.name, length, length2);
        int i12 = 0;
        for (int i13 = 0; i13 < 7 && i13 < i11; i13++) {
            name2.setoffset(i13, i12);
            i12 += name2.name[i12] + 1;
        }
        return name2;
    }

    public byte[] getLabel(int i10) {
        int offset = offset(i10);
        byte[] bArr = this.name;
        int i11 = (byte) (bArr[offset] + 1);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, offset, bArr2, 0, i11);
        return bArr2;
    }

    public String getLabelString(int i10) {
        return byteString(this.name, offset(i10));
    }

    public int hashCode() {
        int i10 = this.hashcode;
        if (i10 != 0) {
            return i10;
        }
        int i11 = 0;
        int offset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (offset >= bArr.length) {
                this.hashcode = i11;
                return i11;
            }
            i11 += (i11 << 3) + lowercase[bArr[offset] & UnsignedBytes.MAX_VALUE];
            offset++;
        }
    }

    public boolean isAbsolute() {
        int labels = labels();
        return labels != 0 && this.name[offset(labels - 1)] == 0;
    }

    public boolean isWild() {
        if (labels() == 0) {
            return false;
        }
        byte[] bArr = this.name;
        return bArr[0] == 1 && bArr[1] == 42;
    }

    public int labels() {
        return getlabels();
    }

    public short length() {
        if (getlabels() == 0) {
            return (short) 0;
        }
        return (short) (this.name.length - offset(0));
    }

    public Name relativize(Name name) {
        if (name == null || !subdomain(name)) {
            return this;
        }
        Name name2 = new Name();
        copy(this, name2);
        int length = length() - name.length();
        name2.setlabels(name2.labels() - name.labels());
        name2.name = new byte[length];
        System.arraycopy(this.name, offset(0), name2.name, 0, length);
        return name2;
    }

    public boolean subdomain(Name name) {
        int labels = labels();
        int labels2 = name.labels();
        if (labels2 > labels) {
            return false;
        }
        return labels2 == labels ? equals(name) : name.equals(this.name, offset(labels - labels2));
    }

    public String toString(boolean z10) {
        int labels = labels();
        if (labels == 0) {
            return "@";
        }
        int i10 = 0;
        if (labels == 1 && this.name[offset(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int offset = offset(0);
        while (true) {
            if (i10 >= labels) {
                break;
            }
            byte b10 = this.name[offset];
            if (b10 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b10 != 0) {
                if (i10 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(byteString(this.name, offset));
                offset += b10 + 1;
                i10++;
            } else if (!z10) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        if (!isAbsolute()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int labels = labels();
        int i10 = 0;
        while (i10 < labels - 1) {
            Name name = i10 == 0 ? this : new Name(this, i10);
            int i11 = compression != null ? compression.get(name) : -1;
            if (i11 >= 0) {
                dNSOutput.writeU16(49152 | i11);
                return;
            }
            if (compression != null) {
                compression.add(dNSOutput.current(), name);
            }
            int offset = offset(i10);
            byte[] bArr = this.name;
            dNSOutput.writeByteArray(bArr, offset, bArr[offset] + 1);
            i10++;
        }
        dNSOutput.writeU8(0);
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public Name wild(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
        try {
            Name name = new Name();
            copy(wild, name);
            name.append(this.name, offset(i10), getlabels() - i10);
            return name;
        } catch (Exception unused) {
            throw new IllegalStateException("Name.wild: concatenate failed");
        }
    }

    public Name(String str, Name name) {
        if (str.equals("")) {
            throw parseException(str, "empty name");
        }
        if (str.equals("@")) {
            if (name == null) {
                copy(empty, this);
                return;
            } else {
                copy(name, this);
                return;
            }
        }
        if (str.equals(".")) {
            copy(root, this);
            return;
        }
        byte[] bArr = new byte[64];
        boolean z10 = true;
        int i10 = -1;
        boolean z11 = false;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            byte charAt = (byte) str.charAt(i14);
            if (z11) {
                if (charAt >= 48 && charAt <= 57 && i12 < 3) {
                    i12++;
                    i13 = (i13 * 10) + (charAt - 48);
                    if (i12 >= 3) {
                        charAt = (byte) i13;
                    }
                }
                bArr[i11] = charAt;
                z11 = false;
                int i15 = i11;
                i11++;
                i10 = i15;
            } else if (charAt == 92) {
                z11 = true;
                i12 = 0;
                i13 = 0;
            } else if (charAt == 46) {
                bArr[0] = (byte) (i11 - 1);
                appendFromString(str, bArr, 0, 1);
                i10 = -1;
                i11 = 1;
            } else {
                i10 = i10 == -1 ? i14 : i10;
                bArr[i11] = charAt;
                i11++;
            }
        }
        if (i10 == -1) {
            appendFromString(str, emptyLabel, 0, 1);
        } else {
            bArr[0] = (byte) (i11 - 1);
            appendFromString(str, bArr, 0, 1);
            z10 = false;
        }
        if (name == null || z10) {
            return;
        }
        appendFromString(str, name.name, name.offset(0), name.getlabels());
    }

    public static Name fromString(String str) {
        return fromString(str, null);
    }

    public byte[] toWireCanonical() {
        int labels = labels();
        if (labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length - offset(0)];
        int offset = offset(0);
        int i10 = 0;
        for (int i11 = 0; i11 < labels; i11++) {
            byte b10 = this.name[offset];
            if (b10 <= 63) {
                offset++;
                bArr[i10] = b10;
                i10++;
                int i12 = 0;
                while (i12 < b10) {
                    bArr[i10] = lowercase[this.name[offset] & UnsignedBytes.MAX_VALUE];
                    i12++;
                    i10++;
                    offset++;
                }
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.hashcode == 0) {
            name.hashCode();
        }
        if (this.hashcode == 0) {
            hashCode();
        }
        if (name.hashcode == this.hashcode && name.labels() == labels()) {
            return equals(name.name, name.offset(0));
        }
        return false;
    }

    public String toString() {
        return toString(false);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, null);
        return dNSOutput.toByteArray();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        if (z10) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    public Name(String str) {
        this(str, (Name) null);
    }

    public Name(DNSInput dNSInput) {
        byte[] bArr = new byte[64];
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            int readU8 = dNSInput.readU8();
            int i10 = readU8 & 192;
            if (i10 != 0) {
                if (i10 == 192) {
                    int readU82 = dNSInput.readU8() + ((readU8 & (-193)) << 8);
                    if (Options.check("verbosecompression")) {
                        System.err.println("currently " + dNSInput.current() + ", pointer to " + readU82);
                    }
                    if (readU82 < dNSInput.current() - 2) {
                        if (!z11) {
                            dNSInput.save();
                            z11 = true;
                        }
                        dNSInput.jump(readU82);
                        if (Options.check("verbosecompression")) {
                            System.err.println("current name '" + this + "', seeking to " + readU82);
                        }
                    } else {
                        throw new Exception("bad compression");
                    }
                } else {
                    throw new Exception("bad label type");
                }
            } else {
                if (getlabels() >= 128) {
                    throw new Exception("too many labels");
                }
                if (readU8 == 0) {
                    append(emptyLabel, 0, 1);
                    z10 = true;
                } else {
                    bArr[0] = (byte) readU8;
                    dNSInput.readByteArray(bArr, 1, readU8);
                    append(bArr, 0, 1);
                }
            }
        }
        if (z11) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) {
        this(new DNSInput(bArr));
    }

    public Name(Name name, int i10) {
        int labels = name.labels();
        if (i10 <= labels) {
            this.name = name.name;
            int i11 = labels - i10;
            setlabels(i11);
            for (int i12 = 0; i12 < 7 && i12 < i11; i12++) {
                setoffset(i12, name.offset(i12 + i10));
            }
            return;
        }
        throw new IllegalArgumentException("attempted to remove too many labels");
    }
}
