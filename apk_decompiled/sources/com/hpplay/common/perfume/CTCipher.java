package com.hpplay.common.perfume;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class CTCipher {
    private final String TAG = "CTCipher";
    private String mKey;

    public CTCipher(String str) {
        this.mKey = str;
    }

    private String encipher(String str) {
        byte b10;
        if (TextUtils.isEmpty(this.mKey) || TextUtils.isEmpty(str)) {
            LeLog.w("CTCipher", "encrypt invalid input");
            return "";
        }
        byte[] bytes = this.mKey.getBytes();
        int length = bytes.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < bytes.length; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= bytes.length) {
                    i11 = -1;
                    b10 = -1;
                    break;
                }
                b10 = bytes[i11];
                if (b10 >= 0) {
                    break;
                }
                i11++;
            }
            for (int i12 = 0; i12 < bytes.length; i12++) {
                byte b11 = bytes[i12];
                if (b11 >= 0 && b11 < b10) {
                    i11 = i12;
                    b10 = b11;
                }
            }
            bytes[i11] = -1;
            iArr[i11] = i10;
        }
        String str2 = "";
        for (int i13 = 0; i13 < bytes.length; i13++) {
            int arrayIndex = getArrayIndex(iArr, i13);
            if (arrayIndex < 0) {
                LeLog.w("CTCipher", "encrypt failed");
                return "";
            }
            int i14 = 0;
            while (true) {
                int i15 = (length * i14) + arrayIndex;
                if (i15 < str.length()) {
                    str2 = str2 + str.charAt(i15);
                    i14++;
                }
            }
        }
        return str2;
    }

    private int getArrayIndex(int[] iArr, int i10) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public String encrypt(String str) {
        return encipher(str);
    }
}
