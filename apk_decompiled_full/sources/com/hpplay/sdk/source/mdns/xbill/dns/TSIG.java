package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.base.Ascii;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.HMAC;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import java.util.Date;

/* loaded from: classes3.dex */
public class TSIG {
    public static final short FUDGE = 300;
    public static final Name HMAC;
    public static final Name HMAC_MD5;
    public static final Name HMAC_SHA1;
    public static final Name HMAC_SHA224;
    public static final Name HMAC_SHA256;
    public static final Name HMAC_SHA384;
    public static final Name HMAC_SHA512;
    private Name alg;
    private String digest;
    private int digestBlockLength;
    private byte[] key;
    private Name name;

    public static class StreamVerifier {
        private TSIG key;
        private TSIGRecord lastTSIG;
        private int lastsigned;
        private int nresponses = 0;
        private HMAC verifier;

        public StreamVerifier(TSIG tsig, TSIGRecord tSIGRecord) {
            this.key = tsig;
            this.verifier = new HMAC(tsig.digest, this.key.digestBlockLength, this.key.key);
            this.lastTSIG = tSIGRecord;
        }

        public int verify(Message message, byte[] bArr) {
            int i10;
            int length;
            TSIGRecord tsig = message.getTSIG();
            int i11 = this.nresponses + 1;
            this.nresponses = i11;
            if (i11 == 1) {
                int verify = this.key.verify(message, bArr, this.lastTSIG);
                if (verify == 0) {
                    byte[] signature = tsig.getSignature();
                    DNSOutput dNSOutput = new DNSOutput();
                    dNSOutput.writeU16(signature.length);
                    this.verifier.update(dNSOutput.toByteArray());
                    this.verifier.update(signature);
                }
                this.lastTSIG = tsig;
                return verify;
            }
            if (tsig != null) {
                message.getHeader().decCount(3);
            }
            byte[] wire = message.getHeader().toWire();
            if (tsig != null) {
                message.getHeader().incCount(3);
            }
            this.verifier.update(wire);
            if (tsig == null) {
                i10 = bArr.length;
                length = wire.length;
            } else {
                i10 = message.tsigstart;
                length = wire.length;
            }
            this.verifier.update(bArr, wire.length, i10 - length);
            if (tsig == null) {
                if (this.nresponses - this.lastsigned >= 100) {
                    message.tsigState = 4;
                    return 1;
                }
                message.tsigState = 2;
                return 0;
            }
            this.lastsigned = this.nresponses;
            this.lastTSIG = tsig;
            if (!tsig.getName().equals(this.key.name) || !tsig.getAlgorithm().equals(this.key.alg)) {
                if (Options.check("verbose")) {
                    System.err.println("BADKEY failure");
                }
                message.tsigState = 4;
                return 17;
            }
            DNSOutput dNSOutput2 = new DNSOutput();
            long time = tsig.getTimeSigned().getTime() / 1000;
            dNSOutput2.writeU16((int) (time >> 32));
            dNSOutput2.writeU32(time & 4294967295L);
            dNSOutput2.writeU16(tsig.getFudge());
            this.verifier.update(dNSOutput2.toByteArray());
            if (!this.verifier.verify(tsig.getSignature())) {
                if (Options.check("verbose")) {
                    System.err.println("BADSIG failure");
                }
                message.tsigState = 4;
                return 16;
            }
            this.verifier.clear();
            DNSOutput dNSOutput3 = new DNSOutput();
            dNSOutput3.writeU16(tsig.getSignature().length);
            this.verifier.update(dNSOutput3.toByteArray());
            this.verifier.update(tsig.getSignature());
            message.tsigState = 1;
            return 0;
        }
    }

    static {
        Name fromConstantString = Name.fromConstantString("HMAC-MD5.SIG-ALG.REG.INT.");
        HMAC_MD5 = fromConstantString;
        HMAC = fromConstantString;
        HMAC_SHA1 = Name.fromConstantString("hmac-sha1.");
        HMAC_SHA224 = Name.fromConstantString("hmac-sha224.");
        HMAC_SHA256 = Name.fromConstantString("hmac-sha256.");
        HMAC_SHA384 = Name.fromConstantString("hmac-sha384.");
        HMAC_SHA512 = Name.fromConstantString("hmac-sha512.");
    }

    public TSIG(Name name, Name name2, byte[] bArr) {
        this.name = name2;
        this.alg = name;
        this.key = bArr;
        getDigest();
    }

    public static TSIG fromString(String str) {
        String[] split = str.split("[:/]", 3);
        if (split.length < 2) {
            throw new IllegalArgumentException("Invalid TSIG key specification");
        }
        if (split.length == 3) {
            try {
                return new TSIG(split[0], split[1], split[2]);
            } catch (IllegalArgumentException unused) {
                split = str.split("[:/]", 2);
            }
        }
        return new TSIG(HMAC_MD5, split[0], split[1]);
    }

    private void getDigest() {
        if (this.alg.equals(HMAC_MD5)) {
            this.digest = "md5";
            this.digestBlockLength = 64;
            return;
        }
        if (this.alg.equals(HMAC_SHA1)) {
            this.digest = "sha-1";
            this.digestBlockLength = 64;
            return;
        }
        if (this.alg.equals(HMAC_SHA224)) {
            this.digest = "sha-224";
            this.digestBlockLength = 64;
            return;
        }
        if (this.alg.equals(HMAC_SHA256)) {
            this.digest = "sha-256";
            this.digestBlockLength = 64;
        } else if (this.alg.equals(HMAC_SHA512)) {
            this.digest = "sha-512";
            this.digestBlockLength = 128;
        } else {
            if (!this.alg.equals(HMAC_SHA384)) {
                throw new IllegalArgumentException("Invalid algorithm");
            }
            this.digest = "sha-384";
            this.digestBlockLength = 128;
        }
    }

    public void apply(Message message, int i10, TSIGRecord tSIGRecord) {
        message.addRecord(generate(message, message.toWire(), i10, tSIGRecord), 3);
        message.tsigState = 3;
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i10, TSIGRecord tSIGRecord) {
        byte[] bArr2;
        Date date = i10 != 18 ? new Date() : tSIGRecord.getTimeSigned();
        HMAC hmac = (i10 == 0 || i10 == 18) ? new HMAC(this.digest, this.digestBlockLength, this.key) : null;
        int intValue = Options.intValue("tsigfudge");
        int i11 = (intValue < 0 || intValue > 32767) ? 300 : intValue;
        if (tSIGRecord != null) {
            DNSOutput dNSOutput = new DNSOutput();
            dNSOutput.writeU16(tSIGRecord.getSignature().length);
            if (hmac != null) {
                hmac.update(dNSOutput.toByteArray());
                hmac.update(tSIGRecord.getSignature());
            }
        }
        if (hmac != null) {
            hmac.update(bArr);
        }
        DNSOutput dNSOutput2 = new DNSOutput();
        this.name.toWireCanonical(dNSOutput2);
        dNSOutput2.writeU16(255);
        dNSOutput2.writeU32(0L);
        this.alg.toWireCanonical(dNSOutput2);
        long time = date.getTime() / 1000;
        dNSOutput2.writeU16((int) (time >> 32));
        dNSOutput2.writeU32(time & 4294967295L);
        dNSOutput2.writeU16(i11);
        dNSOutput2.writeU16(i10);
        dNSOutput2.writeU16(0);
        if (hmac != null) {
            hmac.update(dNSOutput2.toByteArray());
        }
        byte[] sign = hmac != null ? hmac.sign() : new byte[0];
        if (i10 == 18) {
            DNSOutput dNSOutput3 = new DNSOutput();
            long time2 = new Date().getTime() / 1000;
            dNSOutput3.writeU16((int) (time2 >> 32));
            dNSOutput3.writeU32(time2 & 4294967295L);
            bArr2 = dNSOutput3.toByteArray();
        } else {
            bArr2 = null;
        }
        return new TSIGRecord(this.name, 255, 0L, this.alg, date, i11, sign, message.getHeader().getID(), i10, bArr2);
    }

    public int recordLength() {
        return this.name.length() + 10 + this.alg.length() + 8 + 18 + 4 + 8;
    }

    public byte verify(Message message, byte[] bArr, int i10, TSIGRecord tSIGRecord) {
        message.tsigState = 4;
        TSIGRecord tsig = message.getTSIG();
        HMAC hmac = new HMAC(this.digest, this.digestBlockLength, this.key);
        if (tsig == null) {
            return (byte) 1;
        }
        if (!tsig.getName().equals(this.name) || !tsig.getAlgorithm().equals(this.alg)) {
            if (Options.check("verbose")) {
                System.err.println("BADKEY failure");
            }
            return (byte) 17;
        }
        if (Math.abs(System.currentTimeMillis() - tsig.getTimeSigned().getTime()) > tsig.getFudge() * 1000) {
            if (!Options.check("verbose")) {
                return Ascii.DC2;
            }
            System.err.println("BADTIME failure");
            return Ascii.DC2;
        }
        if (tSIGRecord != null && tsig.getError() != 17 && tsig.getError() != 16) {
            DNSOutput dNSOutput = new DNSOutput();
            dNSOutput.writeU16(tSIGRecord.getSignature().length);
            hmac.update(dNSOutput.toByteArray());
            hmac.update(tSIGRecord.getSignature());
        }
        message.getHeader().decCount(3);
        byte[] wire = message.getHeader().toWire();
        message.getHeader().incCount(3);
        hmac.update(wire);
        hmac.update(bArr, wire.length, message.tsigstart - wire.length);
        DNSOutput dNSOutput2 = new DNSOutput();
        tsig.getName().toWireCanonical(dNSOutput2);
        dNSOutput2.writeU16(tsig.dclass);
        dNSOutput2.writeU32(tsig.ttl);
        tsig.getAlgorithm().toWireCanonical(dNSOutput2);
        long time = tsig.getTimeSigned().getTime() / 1000;
        dNSOutput2.writeU16((int) (time >> 32));
        dNSOutput2.writeU32(time & 4294967295L);
        dNSOutput2.writeU16(tsig.getFudge());
        dNSOutput2.writeU16(tsig.getError());
        if (tsig.getOther() != null) {
            dNSOutput2.writeU16(tsig.getOther().length);
            dNSOutput2.writeByteArray(tsig.getOther());
        } else {
            dNSOutput2.writeU16(0);
        }
        hmac.update(dNSOutput2.toByteArray());
        byte[] signature = tsig.getSignature();
        int digestLength = hmac.digestLength();
        int i11 = this.digest.equals("md5") ? 10 : digestLength / 2;
        if (signature.length > digestLength) {
            if (Options.check("verbose")) {
                System.err.println("BADSIG: signature too long");
            }
            return (byte) 16;
        }
        if (signature.length < i11) {
            if (Options.check("verbose")) {
                System.err.println("BADSIG: signature too short");
            }
            return (byte) 16;
        }
        if (hmac.verify(signature, true)) {
            message.tsigState = 1;
            return (byte) 0;
        }
        if (Options.check("verbose")) {
            System.err.println("BADSIG: signature verification");
        }
        return (byte) 16;
    }

    public void apply(Message message, TSIGRecord tSIGRecord) {
        apply(message, 0, tSIGRecord);
    }

    public TSIG(Name name, byte[] bArr) {
        this(HMAC_MD5, name, bArr);
    }

    public TSIG(Name name, String str, String str2) {
        byte[] fromString = base64.fromString(str2);
        this.key = fromString;
        if (fromString != null) {
            try {
                this.name = Name.fromString(str, Name.root);
                this.alg = name;
                getDigest();
                return;
            } catch (Exception unused) {
                throw new IllegalArgumentException("Invalid TSIG key name");
            }
        }
        throw new IllegalArgumentException("Invalid TSIG key string");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TSIG(String str, String str2, String str3) {
        this(r0, str2, str3);
        Name name = HMAC_MD5;
        if (str.equalsIgnoreCase("hmac-md5")) {
            this.alg = name;
        } else if (str.equalsIgnoreCase("hmac-sha1")) {
            this.alg = HMAC_SHA1;
        } else if (str.equalsIgnoreCase("hmac-sha224")) {
            this.alg = HMAC_SHA224;
        } else if (str.equalsIgnoreCase("hmac-sha256")) {
            this.alg = HMAC_SHA256;
        } else if (str.equalsIgnoreCase("hmac-sha384")) {
            this.alg = HMAC_SHA384;
        } else if (str.equalsIgnoreCase("hmac-sha512")) {
            this.alg = HMAC_SHA512;
        } else {
            throw new IllegalArgumentException("Invalid TSIG algorithm");
        }
        getDigest();
    }

    public TSIG(String str, String str2) {
        this(HMAC_MD5, str, str2);
    }

    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord) {
        return verify(message, bArr, bArr.length, tSIGRecord);
    }
}
