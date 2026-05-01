package com.hpplay.sdk.source.mdns.xbill.dns;

import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public final class DClass {
    public static final int ANY = 255;
    public static final int CH = 3;
    public static final int CHAOS = 3;
    public static final int HESIOD = 4;
    public static final int HS = 4;
    public static final int IN = 1;
    public static final int NONE = 254;
    private static Mnemonic classes;

    public static class DClassMnemonic extends Mnemonic {
        public DClassMnemonic() {
            super("DClass", 2);
            setPrefix("CLASS");
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Mnemonic
        public void check(int i10) {
            DClass.check(i10);
        }
    }

    static {
        DClassMnemonic dClassMnemonic = new DClassMnemonic();
        classes = dClassMnemonic;
        dClassMnemonic.add(1, Operator.Operation.IN);
        classes.add(3, "CH");
        classes.addAlias(3, "CHAOS");
        classes.add(4, "HS");
        classes.addAlias(4, "HESIOD");
        classes.add(254, "NONE");
        classes.add(255, "ANY");
    }

    private DClass() {
    }

    public static void check(int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new InvalidDClassException(i10);
        }
    }

    public static String string(int i10) {
        return classes.getText(i10);
    }

    public static int value(String str) {
        return classes.getValue(str);
    }
}
