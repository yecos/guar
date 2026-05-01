package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.taobao.accs.common.Constants;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class EDNSOption {
    private final int code;

    public static class Code {
        public static final int CLIENT_SUBNET = 8;
        public static final int NSID = 3;
        private static Mnemonic codes;

        static {
            Mnemonic mnemonic = new Mnemonic("EDNS Option Codes", 2);
            codes = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            codes.setPrefix("CODE");
            codes.setNumericAllowed(true);
            codes.add(3, "NSID");
            codes.add(8, "CLIENT_SUBNET");
        }

        private Code() {
        }

        public static String string(int i10) {
            return codes.getText(i10);
        }

        public static int value(String str) {
            return codes.getValue(str);
        }
    }

    public EDNSOption(int i10) {
        this.code = Record.checkU16(Constants.KEY_HTTP_CODE, i10);
    }

    public static EDNSOption fromWire(DNSInput dNSInput) {
        int readU16 = dNSInput.readU16();
        int readU162 = dNSInput.readU16();
        if (dNSInput.remaining() < readU162) {
            throw new Exception("truncated option");
        }
        int saveActive = dNSInput.saveActive();
        dNSInput.setActive(readU162);
        EDNSOption genericEDNSOption = readU16 != 3 ? readU16 != 8 ? new GenericEDNSOption(readU16) : new ClientSubnetOption() : new NSIDOption();
        genericEDNSOption.optionFromWire(dNSInput);
        dNSInput.restoreActive(saveActive);
        return genericEDNSOption;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EDNSOption)) {
            return false;
        }
        EDNSOption eDNSOption = (EDNSOption) obj;
        if (this.code != eDNSOption.code) {
            return false;
        }
        return Arrays.equals(getData(), eDNSOption.getData());
    }

    public int getCode() {
        return this.code;
    }

    public byte[] getData() {
        DNSOutput dNSOutput = new DNSOutput();
        optionToWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public int hashCode() {
        int i10 = 0;
        for (byte b10 : getData()) {
            i10 += (i10 << 3) + (b10 & UnsignedBytes.MAX_VALUE);
        }
        return i10;
    }

    public abstract void optionFromWire(DNSInput dNSInput);

    public abstract String optionToString();

    public abstract void optionToWire(DNSOutput dNSOutput);

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(Code.string(this.code));
        stringBuffer.append(": ");
        stringBuffer.append(optionToString());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.code);
        int current = dNSOutput.current();
        dNSOutput.writeU16(0);
        optionToWire(dNSOutput);
        dNSOutput.writeU16At((dNSOutput.current() - current) - 2, current);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public static EDNSOption fromWire(byte[] bArr) {
        return fromWire(new DNSInput(bArr));
    }
}
