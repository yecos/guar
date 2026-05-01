package com.umeng.ut.b.a.a;

import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f12366d = true;

    /* renamed from: com.umeng.ut.b.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0202a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f12367a;

        /* renamed from: b, reason: collision with root package name */
        public int f12368b;
    }

    public static class b extends AbstractC0202a {

        /* renamed from: b, reason: collision with root package name */
        private static final byte[] f12369b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: c, reason: collision with root package name */
        private static final byte[] f12370c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f12371d = true;

        /* renamed from: c, reason: collision with other field name */
        int f60c;
        private int count;

        /* renamed from: d, reason: collision with other field name */
        private final byte[] f61d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f12372e;

        /* renamed from: e, reason: collision with other field name */
        private final byte[] f62e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f12373f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f12374g;

        public b(int i10, byte[] bArr) {
            this.f12367a = bArr;
            this.f12372e = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.f12373f = z10;
            this.f12374g = (i10 & 4) != 0;
            this.f62e = (i10 & 8) == 0 ? f12369b : f12370c;
            this.f61d = new byte[2];
            this.f60c = 0;
            this.count = z10 ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.a.a.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    private a() {
    }

    public static String a(byte[] bArr, int i10) {
        try {
            return new String(m74a(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m74a(byte[] bArr, int i10) {
        return a(bArr, 0, bArr.length, i10);
    }

    public static byte[] a(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, null);
        int i13 = (i11 / 3) * 4;
        if (bVar.f12372e) {
            if (i11 % 3 > 0) {
                i13 += 4;
            }
        } else {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        }
        if (bVar.f12373f && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (bVar.f12374g ? 2 : 1);
        }
        bVar.f12367a = new byte[i13];
        bVar.a(bArr, i10, i11, true);
        if (f12366d || bVar.f12368b == i13) {
            return bVar.f12367a;
        }
        throw new AssertionError();
    }
}
