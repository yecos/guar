package com.hpplay.component.protocol.plist;

/* loaded from: classes2.dex */
public class NSNumber extends NSObject implements Comparable<Object> {
    public static final int BOOLEAN = 2;
    public static final int INTEGER = 0;
    public static final int REAL = 1;
    private boolean boolValue;
    private double doubleValue;
    private long longValue;
    private int type;

    public NSNumber(byte[] bArr, int i10) {
        this(bArr, 0, bArr.length, i10);
    }

    public boolean boolValue() {
        return this.type == 2 ? this.boolValue : doubleValue() != 0.0d;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        double doubleValue = doubleValue();
        if (obj instanceof NSNumber) {
            double doubleValue2 = ((NSNumber) obj).doubleValue();
            if (doubleValue < doubleValue2) {
                return -1;
            }
            return doubleValue == doubleValue2 ? 0 : 1;
        }
        if (!(obj instanceof Number)) {
            return -1;
        }
        double doubleValue3 = ((Number) obj).doubleValue();
        if (doubleValue < doubleValue3) {
            return -1;
        }
        return doubleValue == doubleValue3 ? 0 : 1;
    }

    public double doubleValue() {
        return this.doubleValue;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NSNumber nSNumber = (NSNumber) obj;
        return this.type == nSNumber.type && this.longValue == nSNumber.longValue && this.doubleValue == nSNumber.doubleValue && this.boolValue == nSNumber.boolValue;
    }

    public float floatValue() {
        return (float) this.doubleValue;
    }

    public int hashCode() {
        int i10 = this.type * 37;
        long j10 = this.longValue;
        return ((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.doubleValue) ^ (Double.doubleToLongBits(this.doubleValue) >>> 32)))) * 37) + (boolValue() ? 1 : 0);
    }

    public int intValue() {
        return (int) this.longValue;
    }

    public boolean isBoolean() {
        return this.type == 2;
    }

    public boolean isInteger() {
        return this.type == 0;
    }

    public boolean isReal() {
        return this.type == 1;
    }

    public long longValue() {
        return this.longValue;
    }

    public String stringValue() {
        int i10 = this.type;
        if (i10 == 0) {
            return String.valueOf(longValue());
        }
        if (i10 == 1) {
            return String.valueOf(doubleValue());
        }
        if (i10 == 2) {
            return String.valueOf(boolValue());
        }
        throw new IllegalStateException("The NSNumber instance has an invalid type: " + this.type);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        if (isBoolean()) {
            sb.append(boolValue() ? "YES" : "NO");
        } else {
            sb.append(toString());
        }
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        int type = type();
        if (type == 0) {
            sb.append("<*I");
            sb.append(toString());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        } else if (type == 1) {
            sb.append("<*R");
            sb.append(toString());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        } else {
            if (type != 2) {
                return;
            }
            if (boolValue()) {
                sb.append("<*BY>");
            } else {
                sb.append("<*BN>");
            }
        }
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        int type = type();
        if (type != 0) {
            if (type == 1) {
                binaryPropertyListWriter.write(35);
                binaryPropertyListWriter.writeDouble(doubleValue());
                return;
            } else {
                if (type != 2) {
                    return;
                }
                binaryPropertyListWriter.write(boolValue() ? 9 : 8);
                return;
            }
        }
        if (longValue() < 0) {
            binaryPropertyListWriter.write(19);
            binaryPropertyListWriter.writeBytes(longValue(), 8);
            return;
        }
        if (longValue() <= 255) {
            binaryPropertyListWriter.write(16);
            binaryPropertyListWriter.writeBytes(longValue(), 1);
        } else if (longValue() <= 65535) {
            binaryPropertyListWriter.write(17);
            binaryPropertyListWriter.writeBytes(longValue(), 2);
        } else if (longValue() <= 4294967295L) {
            binaryPropertyListWriter.write(18);
            binaryPropertyListWriter.writeBytes(longValue(), 4);
        } else {
            binaryPropertyListWriter.write(19);
            binaryPropertyListWriter.writeBytes(longValue(), 8);
        }
    }

    public String toString() {
        int type = type();
        return type != 0 ? type != 1 ? type != 2 ? super.toString() : String.valueOf(boolValue()) : String.valueOf(doubleValue()) : String.valueOf(longValue());
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        int type = type();
        if (type == 0) {
            sb.append("<integer>");
            sb.append(longValue());
            sb.append("</integer>");
        } else if (type == 1) {
            sb.append("<real>");
            sb.append(doubleValue());
            sb.append("</real>");
        } else {
            if (type != 2) {
                return;
            }
            if (boolValue()) {
                sb.append("<true/>");
            } else {
                sb.append("<false/>");
            }
        }
    }

    public int type() {
        return this.type;
    }

    public NSNumber(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == 0) {
            long parseLong = BinaryPropertyListParser.parseLong(bArr, i10, i11);
            this.longValue = parseLong;
            this.doubleValue = parseLong;
        } else {
            if (i12 != 1) {
                throw new IllegalArgumentException("Type argument is not valid.");
            }
            double parseDouble = BinaryPropertyListParser.parseDouble(bArr, i10, i11);
            this.doubleValue = parseDouble;
            this.longValue = Math.round(parseDouble);
        }
        this.type = i12;
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public NSNumber mo35clone() {
        int i10 = this.type;
        if (i10 == 0) {
            return new NSNumber(this.longValue);
        }
        if (i10 == 1) {
            return new NSNumber(this.doubleValue);
        }
        if (i10 == 2) {
            return new NSNumber(this.boolValue);
        }
        throw new IllegalStateException("The NSNumber instance has an invalid type: " + this.type);
    }

    public NSNumber(String str) {
        long parseLong;
        if (str != null) {
            try {
                if (str.startsWith("0x")) {
                    parseLong = Long.parseLong(str.substring(2), 16);
                } else {
                    parseLong = Long.parseLong(str);
                }
                this.longValue = parseLong;
                this.doubleValue = parseLong;
                this.type = 0;
                return;
            } catch (Exception unused) {
                try {
                    try {
                        double parseDouble = Double.parseDouble(str);
                        this.doubleValue = parseDouble;
                        this.longValue = Math.round(parseDouble);
                        this.type = 1;
                        return;
                    } catch (Exception unused2) {
                        boolean z10 = str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes");
                        this.boolValue = z10;
                        if (!z10 && !str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no")) {
                            throw new Exception("not a boolean");
                        }
                        this.type = 2;
                        long j10 = this.boolValue ? 1L : 0L;
                        this.longValue = j10;
                        this.doubleValue = j10;
                        return;
                    }
                } catch (Exception unused3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
        throw new IllegalArgumentException("The given string is null and cannot be parsed as number.");
    }

    public NSNumber(int i10) {
        long j10 = i10;
        this.longValue = j10;
        this.doubleValue = j10;
        this.type = 0;
    }

    public NSNumber(long j10) {
        this.longValue = j10;
        this.doubleValue = j10;
        this.type = 0;
    }

    public NSNumber(double d10) {
        this.doubleValue = d10;
        this.longValue = (long) d10;
        this.type = 1;
    }

    public NSNumber(boolean z10) {
        this.boolValue = z10;
        long j10 = z10 ? 1L : 0L;
        this.longValue = j10;
        this.doubleValue = j10;
        this.type = 2;
    }
}
