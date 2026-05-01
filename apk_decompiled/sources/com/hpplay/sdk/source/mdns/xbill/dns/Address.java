package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    private Address() {
    }

    private static InetAddress addrFromRecord(String str, Record record) {
        return InetAddress.getByAddress(str, (record instanceof ARecord ? ((ARecord) record).getAddress() : ((AAAARecord) record).getAddress()).getAddress());
    }

    public static int addressLength(int i10) {
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress getByAddress(String str) {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static String getHostName(InetAddress inetAddress) {
        Record[] run = new Lookup(ReverseMap.fromAddress(inetAddress), 12).run();
        if (run != null) {
            return ((PTRRecord) run[0]).getTarget().toString();
        }
        throw new UnknownHostException("unknown address");
    }

    private static Record[] lookupHostName(String str, boolean z10) {
        Record[] run;
        try {
            Lookup lookup = new Lookup(str, 1);
            Record[] run2 = lookup.run();
            if (run2 == null) {
                if (lookup.getResult() != 4 || (run = new Lookup(str, 28).run()) == null) {
                    throw new UnknownHostException("unknown host");
                }
                return run;
            }
            if (!z10) {
                return run2;
            }
            Record[] run3 = new Lookup(str, 28).run();
            if (run3 == null) {
                return run2;
            }
            Record[] recordArr = new Record[run2.length + run3.length];
            System.arraycopy(run2, 0, recordArr, 0, run2.length);
            System.arraycopy(run3, 0, recordArr, run2.length, run3.length);
            return recordArr;
        } catch (Exception unused) {
            throw new UnknownHostException("invalid name");
        }
    }

    private static byte[] parseV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char charAt = str.charAt(i13);
            if (charAt < '0' || charAt > '9') {
                if (charAt != '.' || i10 == 3 || i11 == 0) {
                    return null;
                }
                bArr[i10] = (byte) i12;
                i10++;
                i11 = 0;
                i12 = 0;
            } else {
                if (i11 == 3) {
                    return null;
                }
                if (i11 > 0 && i12 == 0) {
                    return null;
                }
                i11++;
                i12 = (i12 * 10) + (charAt - '0');
                if (i12 > 255) {
                    return null;
                }
            }
        }
        if (i10 != 3 || i11 == 0) {
            return null;
        }
        bArr[i10] = (byte) i12;
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (r8 >= 16) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c0, code lost:
    
        if (r3 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c2, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c3, code lost:
    
        if (r3 < 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c5, code lost:
    
        r12 = (16 - r8) + r3;
        java.lang.System.arraycopy(r1, r3, r1, r12, r8 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00cc, code lost:
    
        if (r3 >= r12) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ce, code lost:
    
        r1[r3] = 0;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d3, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] parseV6(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Address.parseV6(java.lang.String):byte[]");
    }

    public static int[] toArray(String str, int i10) {
        byte[] byteArray = toByteArray(str, i10);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i11 = 0; i11 < byteArray.length; i11++) {
            iArr[i11] = byteArray[i11] & UnsignedBytes.MAX_VALUE;
        }
        return iArr;
    }

    public static byte[] toByteArray(String str, int i10) {
        if (i10 == 1) {
            return parseV4(str);
        }
        if (i10 == 2) {
            return parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & UnsignedBytes.MAX_VALUE) + "." + (bArr[1] & UnsignedBytes.MAX_VALUE) + "." + (bArr[2] & UnsignedBytes.MAX_VALUE) + "." + (bArr[3] & UnsignedBytes.MAX_VALUE);
    }

    public static InetAddress truncate(InetAddress inetAddress, int i10) {
        int i11;
        int addressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i10 < 0 || i10 > addressLength) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i10 == addressLength) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i12 = i10 / 8;
        int i13 = i12 + 1;
        while (true) {
            if (i13 >= address.length) {
                break;
            }
            address[i13] = 0;
            i13++;
        }
        int i14 = 0;
        for (i11 = 0; i11 < i10 % 8; i11++) {
            i14 |= 1 << (7 - i11);
        }
        address[i12] = (byte) (address[i12] & i14);
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static InetAddress getByAddress(String str, int i10) {
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("unknown address family");
        }
        byte[] byteArray = toByteArray(str, i10);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }
}
