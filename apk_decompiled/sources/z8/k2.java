package z8;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class k2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f20696a = Logger.getLogger(k2.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f20697b = "-bin".getBytes(Charsets.US_ASCII);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i10 = length; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b10 : bArr) {
            if (b10 < 32 || b10 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i10) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(bArr[i11]);
        }
        while (i10 < bArr.length) {
            byte[] bArr2 = bArr[i10];
            byte[] bArr3 = bArr[i10 + 1];
            if (a(bArr2, f20697b)) {
                int i12 = 0;
                for (int i13 = 0; i13 <= bArr3.length; i13++) {
                    if (i13 == bArr3.length || bArr3[i13] == 44) {
                        byte[] decode = BaseEncoding.base64().decode(new String(bArr3, i12, i13 - i12, Charsets.US_ASCII));
                        arrayList.add(bArr2);
                        arrayList.add(decode);
                        i12 = i13 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i10 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(y8.v0 v0Var) {
        byte[][] d10 = y8.j0.d(v0Var);
        if (d10 == null) {
            return new byte[0][];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < d10.length; i11 += 2) {
            byte[] bArr = d10[i11];
            byte[] bArr2 = d10[i11 + 1];
            if (a(bArr, f20697b)) {
                d10[i10] = bArr;
                d10[i10 + 1] = y8.j0.f19879b.encode(bArr2).getBytes(Charsets.US_ASCII);
            } else if (b(bArr2)) {
                d10[i10] = bArr;
                d10[i10 + 1] = bArr2;
            } else {
                String str = new String(bArr, Charsets.US_ASCII);
                f20696a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i10 += 2;
        }
        return i10 == d10.length ? d10 : (byte[][]) Arrays.copyOfRange(d10, 0, i10);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10 += 2) {
            byte[] bArr2 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr3 = bArr[i11];
            if (a(bArr2, f20697b)) {
                for (byte b10 : bArr3) {
                    if (b10 == 44) {
                        return c(bArr, i10);
                    }
                }
                bArr[i11] = BaseEncoding.base64().decode(new String(bArr3, Charsets.US_ASCII));
            }
        }
        return bArr;
    }
}
