package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Type {
    public static final int A = 1;
    public static final int A6 = 38;
    public static final int AAAA = 28;
    public static final int AFSDB = 18;
    public static final int ANY = 255;
    public static final int APL = 42;
    public static final int ATMA = 34;
    public static final int AXFR = 252;
    public static final int CERT = 37;
    public static final int CNAME = 5;
    public static final int DHCID = 49;
    public static final int DLV = 32769;
    public static final int DNAME = 39;
    public static final int DNSKEY = 48;
    public static final int DS = 43;
    public static final int EID = 31;
    public static final int GPOS = 27;
    public static final int HINFO = 13;
    public static final int IPSECKEY = 45;
    public static final int ISDN = 20;
    public static final int IXFR = 251;
    public static final int KEY = 25;
    public static final int KX = 36;
    public static final int LOC = 29;
    public static final int MAILA = 254;
    public static final int MAILB = 253;
    public static final int MB = 7;
    public static final int MD = 3;
    public static final int MF = 4;
    public static final int MG = 8;
    public static final int MINFO = 14;
    public static final int MR = 9;
    public static final int MX = 15;
    public static final int NAPTR = 35;
    public static final int NIMLOC = 32;
    public static final int NS = 2;
    public static final int NSAP = 22;
    public static final int NSAP_PTR = 23;
    public static final int NSEC = 47;
    public static final int NSEC3 = 50;
    public static final int NSEC3PARAM = 51;
    public static final int NULL = 10;
    public static final int NXT = 30;
    public static final int OPT = 41;
    public static final int PTR = 12;
    public static final int PX = 26;
    public static final int RP = 17;
    public static final int RRSIG = 46;
    public static final int RT = 21;
    public static final int SIG = 24;
    public static final int SOA = 6;
    public static final int SPF = 99;
    public static final int SRV = 33;
    public static final int SSHFP = 44;
    public static final int TKEY = 249;
    public static final int TLSA = 52;
    public static final int TSIG = 250;
    public static final int TXT = 16;
    public static final int URI = 256;
    public static final int WKS = 11;
    public static final int X25 = 19;
    private static TypeMnemonic types;

    public static class TypeMnemonic extends Mnemonic {
        private HashMap objects;

        public TypeMnemonic() {
            super("Type", 2);
            setPrefix("TYPE");
            this.objects = new HashMap();
        }

        public void add(int i10, String str, Record record) {
            super.add(i10, str);
            this.objects.put(Mnemonic.toInteger(i10), record);
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.Mnemonic
        public void check(int i10) {
            Type.check(i10);
        }

        public Record getProto(int i10) {
            check(i10);
            return (Record) this.objects.get(Mnemonic.toInteger(i10));
        }
    }

    static {
        TypeMnemonic typeMnemonic = new TypeMnemonic();
        types = typeMnemonic;
        typeMnemonic.add(1, "A", new ARecord());
        types.add(12, "PTR", new PTRRecord());
        types.add(16, "TXT", new TXTRecord());
        types.add(28, "AAAA", new AAAARecord());
        types.add(33, "SRV", new SRVRecord());
        types.add(250, "TSIG", new TSIGRecord());
        types.add(255, "ANY");
    }

    private Type() {
    }

    public static void check(int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new InvalidDClassException(i10);
        }
    }

    public static Record getProto(int i10) {
        return types.getProto(i10);
    }

    public static boolean isRR(int i10) {
        if (i10 == 41) {
            return false;
        }
        switch (i10) {
            case TKEY /* 249 */:
            case 250:
            case IXFR /* 251 */:
            case AXFR /* 252 */:
            case MAILB /* 253 */:
            case 254:
            case 255:
                return false;
            default:
                return true;
        }
    }

    public static String string(int i10) {
        return types.getText(i10);
    }

    public static int value(String str, boolean z10) {
        int value = types.getValue(str);
        if (value != -1 || !z10) {
            return value;
        }
        return types.getValue("TYPE" + str);
    }

    public static int value(String str) {
        return value(str, false);
    }
}
