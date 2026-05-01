package com.hpplay.component.protocol.plist;

/* loaded from: classes2.dex */
public class UID extends NSObject {
    private final byte[] bytes;
    private final String name;

    public UID(String str, byte[] bArr) {
        this.name = str;
        this.bytes = bArr;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append('\"');
        int i11 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i11 >= bArr.length) {
                sb.append('\"');
                return;
            }
            byte b10 = bArr[i11];
            if (b10 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b10));
            i11++;
        }
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        toASCII(sb, i10);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.write((this.bytes.length + 128) - 1);
        binaryPropertyListWriter.write(this.bytes);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<string>");
        int i11 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i11 >= bArr.length) {
                sb.append("</string>");
                return;
            }
            byte b10 = bArr[i11];
            if (b10 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b10));
            i11++;
        }
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public UID mo35clone() {
        return new UID(this.name, (byte[]) this.bytes.clone());
    }
}
