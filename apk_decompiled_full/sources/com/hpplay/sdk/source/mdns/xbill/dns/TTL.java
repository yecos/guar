package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public final class TTL {
    public static final long MAX_VALUE = 2147483647L;

    private TTL() {
    }

    public static void check(long j10) {
        if (j10 < 0 || j10 > MAX_VALUE) {
            throw new InvalidDClassException((int) j10);
        }
    }

    public static String format(long j10) {
        check(j10);
        StringBuffer stringBuffer = new StringBuffer();
        long j11 = j10 % 60;
        long j12 = j10 / 60;
        long j13 = j12 % 60;
        long j14 = j12 / 60;
        long j15 = j14 % 24;
        long j16 = j14 / 24;
        long j17 = j16 % 7;
        long j18 = j16 / 7;
        if (j18 > 0) {
            stringBuffer.append(j18 + "W");
        }
        if (j17 > 0) {
            stringBuffer.append(j17 + "D");
        }
        if (j15 > 0) {
            stringBuffer.append(j15 + "H");
        }
        if (j13 > 0) {
            stringBuffer.append(j13 + "M");
        }
        if (j11 > 0 || (j18 == 0 && j17 == 0 && j15 == 0 && j13 == 0)) {
            stringBuffer.append(j11 + "S");
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long parse(String str, boolean z10) {
        if (str != null && str.length() != 0) {
            if (Character.isDigit(str.charAt(0))) {
                long j10 = 0;
                long j11 = 0;
                for (int i10 = 0; i10 < str.length(); i10++) {
                    char charAt = str.charAt(i10);
                    if (Character.isDigit(charAt)) {
                        long numericValue = (10 * j11) + Character.getNumericValue(charAt);
                        if (numericValue < j11) {
                            throw new NumberFormatException();
                        }
                        j11 = numericValue;
                    } else {
                        char upperCase = Character.toUpperCase(charAt);
                        if (upperCase != 'D') {
                            if (upperCase != 'H') {
                                if (upperCase != 'M') {
                                    if (upperCase != 'S') {
                                        if (upperCase != 'W') {
                                            throw new NumberFormatException();
                                        }
                                        j11 *= 7;
                                    }
                                    j10 += j11;
                                    if (j10 <= 4294967295L) {
                                        throw new NumberFormatException();
                                    }
                                    j11 = 0;
                                }
                                j11 *= 60;
                                j10 += j11;
                                if (j10 <= 4294967295L) {
                                }
                            }
                            j11 *= 60;
                            j11 *= 60;
                            j10 += j11;
                            if (j10 <= 4294967295L) {
                            }
                        }
                        j11 *= 24;
                        j11 *= 60;
                        j11 *= 60;
                        j10 += j11;
                        if (j10 <= 4294967295L) {
                        }
                    }
                }
                if (j10 == 0) {
                    j10 = j11;
                }
                if (j10 <= 4294967295L) {
                    return (j10 <= MAX_VALUE || !z10) ? j10 : MAX_VALUE;
                }
                throw new NumberFormatException();
            }
        }
        throw new NumberFormatException();
    }

    public static long parseTTL(String str) {
        return parse(str, true);
    }
}
