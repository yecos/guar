package com.umeng.ut.a.c;

/* loaded from: classes3.dex */
public class d {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int[] f12361a;

        /* renamed from: x, reason: collision with root package name */
        public int f12362x;

        /* renamed from: y, reason: collision with root package name */
        public int f12363y;

        private a() {
            this.f12361a = new int[256];
        }
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i10 = 0; i10 < 256; i10++) {
            aVar.f12361a[i10] = i10;
        }
        aVar.f12362x = 0;
        aVar.f12363y = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            try {
                char charAt = str.charAt(i11);
                int[] iArr = aVar.f12361a;
                int i14 = iArr[i13];
                i12 = ((charAt + i14) + i12) % 256;
                iArr[i13] = iArr[i12];
                iArr[i12] = i14;
                i11 = (i11 + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    public static byte[] b(byte[] bArr) {
        a a10;
        if (bArr == null || (a10 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a10);
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i10 = aVar.f12362x;
        int i11 = aVar.f12363y;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i10 = (i10 + 1) % 256;
            int[] iArr = aVar.f12361a;
            int i13 = iArr[i10];
            i11 = (i11 + i13) % 256;
            iArr[i10] = iArr[i11];
            iArr[i11] = i13;
            int i14 = (iArr[i10] + i13) % 256;
            bArr[i12] = (byte) (iArr[i14] ^ bArr[i12]);
        }
        aVar.f12362x = i10;
        aVar.f12363y = i11;
        return bArr;
    }
}
