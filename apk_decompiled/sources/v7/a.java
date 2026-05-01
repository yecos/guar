package v7;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f19123a = new byte[103];

    static {
        for (int i10 = 0; i10 <= 102; i10++) {
            f19123a[i10] = -1;
        }
        for (int i11 = 48; i11 <= 57; i11++) {
            f19123a[i11] = (byte) (i11 - 48);
        }
        for (int i12 = 65; i12 <= 70; i12++) {
            f19123a[i12] = (byte) ((i12 - 65) + 10);
        }
        for (int i13 = 97; i13 <= 102; i13++) {
            f19123a[i13] = (byte) ((i13 - 97) + 10);
        }
    }

    public static int a(char c10) {
        if (c10 > 'f') {
            throw new IllegalArgumentException("Invalid hex character: " + c10);
        }
        byte b10 = f19123a[c10];
        if (b10 >= 0) {
            return b10;
        }
        throw new IllegalArgumentException("Invalid hex character: " + c10);
    }

    public static String b(String str) {
        int length = str.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("fromHexString requires an even number of hex characters");
        }
        byte[] bArr = new byte[length / 2];
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            bArr[i11] = (byte) ((a(str.charAt(i10)) << 4) | a(str.charAt(i10 + 1)));
            i10 += 2;
            i11++;
        }
        return new String(bArr, "UTF-8");
    }

    public static String c(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb.append(Integer.toHexString(str.charAt(i10)));
        }
        return sb.toString();
    }
}
