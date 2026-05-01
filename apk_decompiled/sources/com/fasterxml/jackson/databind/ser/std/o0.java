package com.fasterxml.jackson.databind.ser.std;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.UUID;

/* loaded from: classes.dex */
public class o0 extends h0 implements a4.i {

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f6700b = "0123456789abcdef".toCharArray();

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f6701a;

    public o0() {
        this(null);
    }

    public static final void c(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >> 16);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public static void d(int i10, char[] cArr, int i11) {
        e(i10 >> 16, cArr, i11);
        e(i10, cArr, i11 + 4);
    }

    public static void e(int i10, char[] cArr, int i11) {
        char[] cArr2 = f6700b;
        cArr[i11] = cArr2[(i10 >> 12) & 15];
        int i12 = i11 + 1;
        cArr[i12] = cArr2[(i10 >> 8) & 15];
        int i13 = i12 + 1;
        cArr[i13] = cArr2[(i10 >> 4) & 15];
        cArr[i13 + 1] = cArr2[i10 & 15];
    }

    public static final byte[] f(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        c((int) (mostSignificantBits >> 32), bArr, 0);
        c((int) mostSignificantBits, bArr, 4);
        c((int) (leastSignificantBits >> 32), bArr, 8);
        c((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        visitStringFormat(fVar, jVar, u3.m.UUID);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r2, k3.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            b3.k$d r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L1c
            b3.k$c r2 = r2.i()
            b3.k$c r3 = b3.k.c.BINARY
            if (r2 != r3) goto L15
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L1d
        L15:
            b3.k$c r3 = b3.k.c.STRING
            if (r2 != r3) goto L1c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L1d
        L1c:
            r2 = 0
        L1d:
            java.lang.Boolean r3 = r1.f6701a
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L2b
            com.fasterxml.jackson.databind.ser.std.o0 r3 = new com.fasterxml.jackson.databind.ser.std.o0
            r3.<init>(r2)
            return r3
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.o0.b(k3.c0, k3.d):k3.o");
    }

    public boolean g(c3.h hVar) {
        Boolean bool = this.f6701a;
        return bool != null ? bool.booleanValue() : !(hVar instanceof d4.y) && hVar.f();
    }

    @Override // k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, UUID uuid) {
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void serialize(UUID uuid, c3.h hVar, k3.c0 c0Var) {
        if (g(hVar)) {
            hVar.S(f(uuid));
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits = uuid.getMostSignificantBits();
        d((int) (mostSignificantBits >> 32), cArr, 0);
        cArr[8] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        int i10 = (int) mostSignificantBits;
        e(i10 >>> 16, cArr, 9);
        cArr[13] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        e(i10, cArr, 14);
        cArr[18] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        long leastSignificantBits = uuid.getLeastSignificantBits();
        e((int) (leastSignificantBits >>> 48), cArr, 19);
        cArr[23] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        e((int) (leastSignificantBits >>> 32), cArr, 24);
        d((int) leastSignificantBits, cArr, 28);
        hVar.A0(cArr, 0, 36);
    }

    public o0(Boolean bool) {
        super(UUID.class);
        this.f6701a = bool;
    }
}
