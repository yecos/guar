package com.hpplay.sdk.source.mdns.xbill.dns;

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
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String substitute(java.lang.String r19, long r20) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Generator.substitute(java.lang.String, long):java.lang.String");
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
