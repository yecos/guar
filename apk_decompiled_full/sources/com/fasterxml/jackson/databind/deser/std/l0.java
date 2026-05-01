package com.fasterxml.jackson.databind.deser.std;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes.dex */
public class l0 extends o {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6573a;

    static {
        int[] iArr = new int[127];
        f6573a = iArr;
        Arrays.fill(iArr, -1);
        for (int i10 = 0; i10 < 10; i10++) {
            f6573a[i10 + 48] = i10;
        }
        for (int i11 = 0; i11 < 6; i11++) {
            int[] iArr2 = f6573a;
            int i12 = i11 + 10;
            iArr2[i11 + 97] = i12;
            iArr2[i11 + 65] = i12;
        }
    }

    public l0() {
        super(UUID.class);
    }

    public static int m(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i10] << Ascii.CAN) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static long n(byte[] bArr, int i10) {
        return ((m(bArr, i10 + 4) << 32) >>> 32) | (m(bArr, i10) << 32);
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return new UUID(0L, 0L);
    }

    public int h(String str, int i10, k3.g gVar, char c10) {
        throw gVar.L0(str, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(c10), Integer.toHexString(c10)));
    }

    public final UUID i(String str, k3.g gVar) {
        return (UUID) gVar.j0(handledType(), str, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public UUID a(String str, k3.g gVar) {
        if (str.length() != 36) {
            return str.length() == 24 ? l(c3.b.a().f(str), gVar) : i(str, gVar);
        }
        if (str.charAt(8) != '-' || str.charAt(13) != '-' || str.charAt(18) != '-' || str.charAt(23) != '-') {
            i(str, gVar);
        }
        return new UUID((p(str, 0, gVar) << 32) + ((q(str, 9, gVar) << 16) | q(str, 14, gVar)), ((p(str, 28, gVar) << 32) >>> 32) | ((q(str, 24, gVar) | (q(str, 19, gVar) << 16)) << 32));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public UUID b(Object obj, k3.g gVar) {
        return obj instanceof byte[] ? l((byte[]) obj, gVar) : (UUID) super.b(obj, gVar);
    }

    public final UUID l(byte[] bArr, k3.g gVar) {
        if (bArr.length == 16) {
            return new UUID(n(bArr, 0), n(bArr, 8));
        }
        throw p3.c.v(gVar.S(), "Can only construct UUIDs from byte[16]; got " + bArr.length + " bytes", bArr, handledType());
    }

    public int o(String str, int i10, k3.g gVar) {
        char charAt = str.charAt(i10);
        int i11 = i10 + 1;
        char charAt2 = str.charAt(i11);
        if (charAt <= 127 && charAt2 <= 127) {
            int[] iArr = f6573a;
            int i12 = iArr[charAt2] | (iArr[charAt] << 4);
            if (i12 >= 0) {
                return i12;
            }
        }
        return (charAt > 127 || f6573a[charAt] < 0) ? h(str, i10, gVar, charAt) : h(str, i11, gVar, charAt2);
    }

    public int p(String str, int i10, k3.g gVar) {
        return (o(str, i10, gVar) << 24) + (o(str, i10 + 2, gVar) << 16) + (o(str, i10 + 4, gVar) << 8) + o(str, i10 + 6, gVar);
    }

    public int q(String str, int i10, k3.g gVar) {
        return (o(str, i10, gVar) << 8) + o(str, i10 + 2, gVar);
    }
}
