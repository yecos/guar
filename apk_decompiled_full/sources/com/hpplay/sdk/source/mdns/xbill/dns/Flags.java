package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public final class Flags {
    public static final byte AA = 5;
    public static final byte AD = 10;
    public static final byte CD = 11;
    public static final int DO = 32768;
    public static final byte QR = 0;
    public static final byte RA = 8;
    public static final byte RD = 7;
    public static final byte TC = 6;
    private static Mnemonic flags;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Header Flag", 3);
        flags = mnemonic;
        mnemonic.setMaximum(15);
        flags.setPrefix("FLAG");
        flags.setNumericAllowed(true);
        flags.add(0, "qr");
        flags.add(5, "aa");
        flags.add(6, "tc");
        flags.add(7, "rd");
        flags.add(8, "ra");
        flags.add(10, "ad");
        flags.add(11, "cd");
    }

    private Flags() {
    }

    public static boolean isFlag(int i10) {
        flags.check(i10);
        return (i10 < 1 || i10 > 4) && i10 < 12;
    }

    public static String string(int i10) {
        return flags.getText(i10);
    }

    public static int value(String str) {
        return flags.getValue(str);
    }
}
