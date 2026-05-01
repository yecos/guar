package com.hpplay.component.protocol.plist;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Locale;
import java.util.Scanner;

/* loaded from: classes2.dex */
public class NSString extends NSObject implements Comparable<Object> {
    private static CharsetEncoder asciiEncoder;
    private static CharsetEncoder utf16beEncoder;
    private static CharsetEncoder utf8Encoder;
    private String content;

    public NSString(byte[] bArr, String str) {
        this(bArr, 0, bArr.length, str);
    }

    public static String escapeStringForASCII(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (c10 > 127) {
                sb.append("\\U");
                String hexString = Integer.toHexString(c10);
                while (hexString.length() < 4) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            } else if (c10 == '\\') {
                sb.append("\\\\");
            } else if (c10 == '\"') {
                sb.append("\\\"");
            } else if (c10 == '\b') {
                sb.append("\\b");
            } else if (c10 == '\n') {
                sb.append("\\n");
            } else if (c10 == '\r') {
                sb.append("\\r");
            } else if (c10 == '\t') {
                sb.append("\\t");
            } else {
                sb.append(c10);
            }
        }
        return sb.toString();
    }

    public void append(NSString nSString) {
        append(nSString.getContent());
    }

    public boolean boolValue() {
        return new Scanner(this.content.trim()).useLocale(Locale.ROOT).hasNext("([+-]?[0]*)?[YyTt1-9].*");
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof NSString) {
            return getContent().compareTo(((NSString) obj).getContent());
        }
        if (obj instanceof String) {
            return getContent().compareTo((String) obj);
        }
        return -1;
    }

    public double doubleValue() {
        Scanner useDelimiter = new Scanner(this.content.trim()).useLocale(Locale.ROOT).useDelimiter("[^0-9.+-]+");
        if (useDelimiter.hasNextDouble()) {
            return useDelimiter.nextDouble();
        }
        return 0.0d;
    }

    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.content.equals(((NSString) obj).content);
    }

    public float floatValue() {
        double doubleValue = doubleValue();
        if (doubleValue > 3.4028234663852886E38d) {
            return Float.MAX_VALUE;
        }
        if (doubleValue < -3.4028234663852886E38d) {
            return -3.4028235E38f;
        }
        return (float) doubleValue;
    }

    public String getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public int intValue() {
        double doubleValue = doubleValue();
        if (doubleValue > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (doubleValue < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) doubleValue;
    }

    public void prepend(String str) {
        this.content = str + this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("\"");
        sb.append(escapeStringForASCII(this.content));
        sb.append("\"");
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("\"");
        sb.append(escapeStringForASCII(this.content));
        sb.append("\"");
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        ByteBuffer encode;
        int i10;
        CharBuffer wrap = CharBuffer.wrap(this.content);
        synchronized (NSString.class) {
            CharsetEncoder charsetEncoder = asciiEncoder;
            if (charsetEncoder == null) {
                asciiEncoder = Charset.forName("ASCII").newEncoder();
            } else {
                charsetEncoder.reset();
            }
            if (asciiEncoder.canEncode(wrap)) {
                encode = asciiEncoder.encode(wrap);
                i10 = 5;
            } else {
                CharsetEncoder charsetEncoder2 = utf16beEncoder;
                if (charsetEncoder2 == null) {
                    utf16beEncoder = Charset.forName("UTF-16BE").newEncoder();
                } else {
                    charsetEncoder2.reset();
                }
                encode = utf16beEncoder.encode(wrap);
                i10 = 6;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        binaryPropertyListWriter.writeIntHeader(i10, this.content.length());
        binaryPropertyListWriter.write(bArr);
    }

    public String toString() {
        return this.content;
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        String str;
        indent(sb, i10);
        sb.append("<string>");
        synchronized (NSString.class) {
            CharsetEncoder charsetEncoder = utf8Encoder;
            if (charsetEncoder == null) {
                utf8Encoder = Charset.forName("UTF-8").newEncoder();
            } else {
                charsetEncoder.reset();
            }
            try {
                ByteBuffer encode = utf8Encoder.encode(CharBuffer.wrap(this.content));
                byte[] bArr = new byte[encode.remaining()];
                encode.get(bArr);
                str = new String(bArr, "UTF-8");
                this.content = str;
            } catch (Exception e10) {
                throw new RuntimeException("Could not encode the NSString into UTF-8: " + String.valueOf(e10.getMessage()));
            }
        }
        if (str.contains(DispatchConstants.SIGN_SPLIT_SYMBOL) || this.content.contains(Operator.Operation.LESS_THAN) || this.content.contains(Operator.Operation.GREATER_THAN)) {
            sb.append("<![CDATA[");
            sb.append(this.content.replaceAll("]]>", "]]]]><![CDATA[>"));
            sb.append("]]>");
        } else {
            sb.append(this.content);
        }
        sb.append("</string>");
    }

    public NSString(byte[] bArr, int i10, int i11, String str) {
        this.content = new String(bArr, i10, i11 - i10, str);
    }

    public void append(String str) {
        this.content += str;
    }

    public void prepend(NSString nSString) {
        prepend(nSString.getContent());
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public NSString mo35clone() {
        return new NSString(this.content);
    }

    public NSString(String str) {
        this.content = str;
    }
}
