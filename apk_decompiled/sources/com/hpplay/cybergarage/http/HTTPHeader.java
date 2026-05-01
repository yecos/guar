package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

/* loaded from: classes2.dex */
public class HTTPHeader {
    private static int MAX_LENGTH = 1024;
    private static final String TAG = "Cyber-HTTPHeader";
    private String name;
    private String value;

    public HTTPHeader(String str, String str2) {
        setName(str);
        setValue(str2);
    }

    public static final int getIntegerValue(String str, String str2) {
        try {
            return Integer.parseInt(getValue(str, str2));
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasName() {
        String str = this.name;
        return str != null && str.length() > 0;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public static final int getIntegerValue(byte[] bArr, String str) {
        try {
            return Integer.parseInt(getValue(bArr, str));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final String getValue(LineNumberReader lineNumberReader, String str) {
        String upperCase = str.toUpperCase();
        try {
            String readLine = lineNumberReader.readLine();
            while (readLine != null && readLine.length() > 0) {
                HTTPHeader hTTPHeader = new HTTPHeader(readLine);
                if (!hTTPHeader.hasName()) {
                    readLine = lineNumberReader.readLine();
                } else {
                    if (hTTPHeader.getName().toUpperCase().equals(upperCase)) {
                        return hTTPHeader.getValue();
                    }
                    readLine = lineNumberReader.readLine();
                }
            }
            return "";
        } catch (IOException e10) {
            CLog.d(TAG, null, e10);
            return "";
        }
    }

    public HTTPHeader(String str) {
        int indexOf;
        setName("");
        setValue("");
        if (str != null && (indexOf = str.indexOf(58)) >= 0) {
            String str2 = new String(str.getBytes(), 0, indexOf);
            String str3 = new String(str.getBytes(), indexOf + 1, (str.length() - indexOf) - 1);
            setName(str2.trim());
            setValue(str3.trim());
        }
    }

    public static final String getValue(String str, String str2) {
        try {
            return getValue(new LineNumberReader(new StringReader(str), Math.min(str.length(), MAX_LENGTH)), str2);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return " ";
        }
    }

    public static final String getValue(byte[] bArr, String str) {
        return (bArr == null || bArr.length <= 0) ? " " : getValue(new String(bArr), str);
    }
}
