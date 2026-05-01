package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class Generator {
    private long current;
    public final int dclass;
    public long end;
    public final String namePattern;
    public final Name origin;
    public final String rdataPattern;
    public long start;
    public long step;
    public final long ttl;
    public final int type;

    public Generator(long j10, long j11, long j12, String str, int i10, int i11, long j13, String str2, Name name) {
        if (j10 < 0 || j11 < 0 || j10 > j11 || j12 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        }
        if (!supportedType(i10)) {
            throw new IllegalArgumentException("unsupported type");
        }
        DClass.check(i11);
        this.start = j10;
        this.end = j11;
        this.step = j12;
        this.namePattern = str;
        this.type = i10;
        this.dclass = i11;
        this.ttl = j13;
        this.rdataPattern = str2;
        this.origin = name;
        this.current = j10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x008f, code lost:
    
        throw new java.lang.Exception("invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bd, code lost:
    
        throw new java.lang.Exception("invalid width");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00be, code lost:
    
        r8 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String substitute(String str, long j10) {
        int i10;
        boolean z10;
        long j11;
        long j12;
        boolean z11;
        int i11;
        byte b10;
        byte[] bytes = str.getBytes();
        StringBuffer stringBuffer = new StringBuffer();
        int i12 = 0;
        boolean z12 = false;
        loop0: while (i12 < bytes.length) {
            char c10 = (char) (bytes[i12] & UnsignedBytes.MAX_VALUE);
            if (z12) {
                stringBuffer.append(c10);
                i10 = 1;
                z12 = false;
            } else if (c10 != '\\') {
                if (c10 == '$') {
                    int i13 = i12 + 1;
                    if (i13 >= bytes.length || (b10 = bytes[i13]) != 36) {
                        long j13 = 10;
                        if (i13 < bytes.length && bytes[i13] == 123) {
                            int i14 = i13 + 1;
                            if (i14 >= bytes.length || bytes[i14] != 45) {
                                z11 = false;
                            } else {
                                i13 = i14;
                                z11 = true;
                            }
                            j12 = 0;
                            while (true) {
                                int i15 = i13 + 1;
                                if (i15 >= bytes.length) {
                                    break;
                                }
                                c10 = (char) (bytes[i15] & UnsignedBytes.MAX_VALUE);
                                if (c10 == ',' || c10 == '}') {
                                    break;
                                }
                                if (c10 < '0' || c10 > '9') {
                                    break loop0;
                                }
                                c10 = (char) (c10 - '0');
                                j12 = (j12 * 10) + c10;
                                i13 = i15;
                            }
                            if (z11) {
                                j12 = -j12;
                            }
                            long j14 = 0;
                            if (c10 == ',') {
                                while (true) {
                                    int i16 = i13 + 1;
                                    if (i16 >= bytes.length) {
                                        break;
                                    }
                                    c10 = (char) (bytes[i16] & UnsignedBytes.MAX_VALUE);
                                    if (c10 == ',' || c10 == '}') {
                                        break;
                                    }
                                    if (c10 < '0' || c10 > '9') {
                                        break loop0;
                                    }
                                    c10 = (char) (c10 - '0');
                                    j14 = (j14 * 10) + c10;
                                    i13 = i16;
                                }
                            }
                            if (c10 == ',') {
                                i13++;
                                if (i13 == bytes.length) {
                                    throw new Exception("invalid base");
                                }
                                char c11 = (char) (bytes[i13] & UnsignedBytes.MAX_VALUE);
                                if (c11 == 'o') {
                                    z10 = false;
                                    i11 = 1;
                                    j13 = 8;
                                } else {
                                    if (c11 == 'x') {
                                        z10 = false;
                                    } else if (c11 == 'X') {
                                        z10 = true;
                                    } else if (c11 != 'd') {
                                        throw new Exception("invalid base");
                                    }
                                    i11 = 1;
                                    j13 = 16;
                                }
                                i13 += i11;
                                if (i13 != bytes.length || bytes[i13] != 125) {
                                    throw new Exception("invalid modifiers");
                                }
                                j11 = j14;
                            }
                            z10 = false;
                            i11 = 1;
                            i13 += i11;
                            if (i13 != bytes.length) {
                            }
                            throw new Exception("invalid modifiers");
                        }
                        i13 = i12;
                        z10 = false;
                        j11 = 0;
                        j12 = 0;
                        long j15 = j10 + j12;
                        if (j15 < 0) {
                            throw new Exception("invalid offset expansion");
                        }
                        String octalString = j13 == 8 ? Long.toOctalString(j15) : j13 == 16 ? Long.toHexString(j15) : Long.toString(j15);
                        if (z10) {
                            octalString = octalString.toUpperCase();
                        }
                        if (j11 != 0 && j11 > octalString.length()) {
                            int length = ((int) j11) - octalString.length();
                            while (true) {
                                int i17 = length - 1;
                                if (length <= 0) {
                                    break;
                                }
                                stringBuffer.append('0');
                                length = i17;
                            }
                        }
                        stringBuffer.append(octalString);
                    } else {
                        stringBuffer.append((char) (b10 & UnsignedBytes.MAX_VALUE));
                    }
                    i12 = i13;
                } else {
                    stringBuffer.append(c10);
                }
                i10 = 1;
            } else {
                if (i12 + 1 == bytes.length) {
                    throw new Exception("invalid escape character");
                }
                i10 = 1;
                z12 = true;
            }
            i12 += i10;
        }
        return stringBuffer.toString();
    }

    public static boolean supportedType(int i10) {
        Type.check(i10);
        return i10 == 12 || i10 == 5 || i10 == 39 || i10 == 1 || i10 == 28 || i10 == 2;
    }

    public Record nextRecord() {
        long j10 = this.current;
        if (j10 > this.end) {
            return null;
        }
        Name fromString = Name.fromString(substitute(this.namePattern, j10), this.origin);
        String substitute = substitute(this.rdataPattern, this.current);
        this.current += this.step;
        return Record.fromString(fromString, this.type, this.dclass, this.ttl, substitute, this.origin);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("$GENERATE ");
        stringBuffer.append(this.start + Operator.Operation.MINUS + this.end);
        if (this.step > 1) {
            stringBuffer.append(Operator.Operation.DIVISION + this.step);
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.namePattern + " ");
        stringBuffer.append(this.ttl + " ");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            stringBuffer.append(DClass.string(this.dclass) + " ");
        }
        stringBuffer.append(Type.string(this.type) + " ");
        stringBuffer.append(this.rdataPattern + " ");
        return stringBuffer.toString();
    }
}
