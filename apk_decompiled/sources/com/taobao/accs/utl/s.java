package com.taobao.accs.utl;

import com.hpplay.cybergarage.xml.XML;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class s extends ByteArrayInputStream {
    public s(byte[] bArr) {
        super(bArr);
    }

    public int a() {
        return read() & 255;
    }

    public int b() {
        return (a() << 8) | a();
    }

    public byte[] c() {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }

    public String a(int i10) {
        byte[] bArr = new byte[i10];
        int read = read(bArr);
        if (read == i10) {
            return new String(bArr, XML.CHARSET_UTF8);
        }
        throw new IOException("read len not match. ask for " + i10 + " but read for " + read);
    }
}
