package com.umeng.analytics.filter;

import android.util.Base64;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f9819b = "Ă";

    /* renamed from: c, reason: collision with root package name */
    private MessageDigest f9821c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9823e;

    /* renamed from: a, reason: collision with root package name */
    private final String f9820a = "MD5";

    /* renamed from: d, reason: collision with root package name */
    private Set<Object> f9822d = new HashSet();

    public d(boolean z10, String str) {
        this.f9823e = z10;
        try {
            this.f9821c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        }
        if (str != null) {
            int i10 = 0;
            if (!z10) {
                String[] split = str.split(f9819b);
                int length = split.length;
                while (i10 < length) {
                    this.f9822d.add(split[i10]);
                    i10++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i10 < decode.length / 4) {
                    int i11 = i10 * 4;
                    this.f9822d.add(Integer.valueOf(((decode[i11 + 0] & UnsignedBytes.MAX_VALUE) << 24) + ((decode[i11 + 1] & UnsignedBytes.MAX_VALUE) << 16) + ((decode[i11 + 2] & UnsignedBytes.MAX_VALUE) << 8) + (decode[i11 + 3] & UnsignedBytes.MAX_VALUE)));
                    i10++;
                }
            } catch (IllegalArgumentException e11) {
                e11.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f9821c.update(str.getBytes());
            byte[] digest = this.f9821c.digest();
            return Integer.valueOf(((digest[0] & UnsignedBytes.MAX_VALUE) << 24) + ((digest[1] & UnsignedBytes.MAX_VALUE) << 16) + ((digest[2] & UnsignedBytes.MAX_VALUE) << 8) + (digest[3] & UnsignedBytes.MAX_VALUE));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f9823e ? this.f9822d.contains(c(str)) : this.f9822d.contains(str);
    }

    public void b(String str) {
        if (this.f9823e) {
            this.f9822d.add(c(str));
        } else {
            this.f9822d.add(str);
        }
    }

    public String toString() {
        if (!this.f9823e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f9822d) {
                if (sb.length() > 0) {
                    sb.append(f9819b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f9822d.size() * 4];
        Iterator<Object> it = this.f9822d.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((-16777216) & intValue) >> 24);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((16711680 & intValue) >> 16);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((65280 & intValue) >> 8);
            i10 = i13 + 1;
            bArr[i13] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f9822d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
