package com.hpplay.cybergarage.util;

import com.hpplay.component.common.utils.CLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes2.dex */
public final class FileUtil {
    private static final String TAG = "Cyber-FileUtil";

    public static final boolean isXMLFileName(String str) {
        if (StringUtil.hasData(str)) {
            return str.toLowerCase().endsWith("xml");
        }
        return false;
    }

    public static final byte[] load(String str) {
        try {
            return load(new FileInputStream(str));
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return new byte[0];
        }
    }

    public static final byte[] load(File file) {
        try {
            return load(new FileInputStream(file));
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return new byte[0];
        }
    }

    public static final byte[] load(FileInputStream fileInputStream) {
        byte[] bArr = new byte[524288];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read = fileInputStream.read(bArr);
            while (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
                read = fileInputStream.read(bArr);
            }
            fileInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return new byte[0];
        }
    }
}
