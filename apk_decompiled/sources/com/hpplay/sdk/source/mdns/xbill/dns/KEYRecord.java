package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.DNSSEC;
import com.uc.crashsdk.export.LogType;
import java.security.PublicKey;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class KEYRecord extends KEYBase {
    private static final long serialVersionUID = 6385613447571488906L;

    public static class Flags {
        private static Mnemonic flags;

        static {
            Mnemonic mnemonic = new Mnemonic("KEY flags", 2);
            flags = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            flags.setNumericAllowed(false);
            flags.add(16384, "NOCONF");
            flags.add(32768, "NOAUTH");
            flags.add(49152, "NOKEY");
            flags.add(8192, "FLAG2");
            flags.add(4096, "EXTEND");
            flags.add(2048, "FLAG4");
            flags.add(1024, "FLAG5");
            flags.add(0, "USER");
            flags.add(256, "ZONE");
            flags.add(512, HTTP.HOST);
            flags.add(LogType.UNEXP_OTHER, "NTYP3");
            flags.add(128, "FLAG8");
            flags.add(64, "FLAG9");
            flags.add(32, "FLAG10");
            flags.add(16, "FLAG11");
            flags.add(0, "SIG0");
            flags.add(1, "SIG1");
            flags.add(2, "SIG2");
            flags.add(3, "SIG3");
            flags.add(4, "SIG4");
            flags.add(5, "SIG5");
            flags.add(6, "SIG6");
            flags.add(7, "SIG7");
            flags.add(8, "SIG8");
            flags.add(9, "SIG9");
            flags.add(10, "SIG10");
            flags.add(11, "SIG11");
            flags.add(12, "SIG12");
            flags.add(13, "SIG13");
            flags.add(14, "SIG14");
            flags.add(15, "SIG15");
        }

        private Flags() {
        }

        public static int value(String str) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt < 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
                int i10 = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    int value = flags.getValue(stringTokenizer.nextToken());
                    if (value < 0) {
                        return -1;
                    }
                    i10 |= value;
                }
                return i10;
            }
        }
    }

    public static class Protocol {
        public static final int ANY = 255;
        private static Mnemonic protocols;

        static {
            Mnemonic mnemonic = new Mnemonic("KEY protocol", 2);
            protocols = mnemonic;
            mnemonic.setMaximum(255);
            protocols.setNumericAllowed(true);
            protocols.add(0, "NONE");
            protocols.add(1, "TLS");
            protocols.add(2, "EMAIL");
            protocols.add(3, "DNSSEC");
            protocols.add(4, "IPSEC");
            protocols.add(255, "ANY");
        }

        private Protocol() {
        }

        public static String string(int i10) {
            return protocols.getText(i10);
        }

        public static int value(String str) {
            return protocols.getValue(str);
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getFlags() {
        return super.getFlags();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ byte[] getKey() {
        return super.getKey();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new KEYRecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getProtocol() {
        return super.getProtocol();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ PublicKey getPublicKey() {
        return super.getPublicKey();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        String identifier = tokenizer.getIdentifier();
        int value = Flags.value(identifier);
        this.flags = value;
        if (value < 0) {
            throw tokenizer.exception("Invalid flags: " + identifier);
        }
        String identifier2 = tokenizer.getIdentifier();
        int value2 = Protocol.value(identifier2);
        this.proto = value2;
        if (value2 < 0) {
            throw tokenizer.exception("Invalid protocol: " + identifier2);
        }
        String identifier3 = tokenizer.getIdentifier();
        int value3 = DNSSEC.Algorithm.value(identifier3);
        this.alg = value3;
        if (value3 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + identifier3);
        }
        if ((this.flags & 49152) == 49152) {
            this.key = null;
        } else {
            this.key = tokenizer.getBase64();
        }
    }
}
