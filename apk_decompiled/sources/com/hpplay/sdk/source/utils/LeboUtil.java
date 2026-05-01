package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.common.log.LeLog;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.UUID;

/* loaded from: classes3.dex */
public class LeboUtil {
    private static final String CUT_ANDROID = "1";
    private static final String DEFAULT_M = "0000000000000000";
    private static final String SIGN_AID = "7";
    private static final String SIGN_IMEI = "2";
    private static final String SIGN_M = "1";
    private static final String SIGN_NEW_M = "8";
    private static final String SIGN_NORMAL = "0";
    private static final String SIGN_OAID = "6";
    private static final String TAG = "LeboUtil";
    private static String sAID = "";

    public static String anonymizeByMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return EncryptUtil.md5EncryData(str.toUpperCase().replace(SOAP.DELIM, "")).toUpperCase();
        } catch (Exception e10) {
            SourceLog.w(TAG, "anonymizeByMD5 error " + e10);
            return str;
        }
    }

    public static String anonymizeBySHA256(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return EncryptUtil.encryptSHA256ToString(str.toUpperCase().replace(SOAP.DELIM, "")).toUpperCase();
        } catch (Exception e10) {
            SourceLog.w(TAG, "anonymizeBySHA256 error " + e10);
            return str;
        }
    }

    public static String anonymizeBySHA256For60Bits(String str) {
        String anonymizeBySHA256 = anonymizeBySHA256(str);
        try {
            return anonymizeBySHA256.substring(2, anonymizeBySHA256.length() - 2);
        } catch (Exception e10) {
            SourceLog.w(TAG, "anonymizeBySHA256For60Bits error " + e10);
            return anonymizeBySHA256;
        }
    }

    public static String getAID(Context context) {
        if (!TextUtils.isEmpty(sAID)) {
            return sAID;
        }
        String str = Preference.getInstance().get(Preference.KEY_LB_FAKE_AID);
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = new String(Base64.decode(str, 0));
                sAID = str2;
                return str2;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        String aid = DeviceUtil.getAID(context);
        sAID = aid;
        if (!TextUtils.isEmpty(aid)) {
            try {
                Preference.getInstance().put(Preference.KEY_LB_FAKE_AID, Base64.encodeToString(sAID.getBytes(), 0));
            } catch (Exception e11) {
                SourceLog.w(TAG, e11);
            }
            return sAID;
        }
        String uuid = UUID.randomUUID().toString();
        sAID = uuid;
        try {
            Preference.getInstance().put(Preference.KEY_LB_FAKE_AID, Base64.encodeToString(uuid.getBytes(), 0));
        } catch (Exception e12) {
            SourceLog.w(TAG, e12);
        }
        return sAID;
    }

    public static int getCUid(Context context) {
        if (context == null) {
            return -1;
        }
        return EncryptUtil.fnvHash(EncryptUtil.md5EncryData16(("1" + getCUidMaterial(context) + context.getPackageName()).toUpperCase()).toUpperCase());
    }

    public static long getCUid64(Context context) {
        return EncryptUtil.parseMd5L16ToLong(EncryptUtil.md5EncryData16(("1" + getCUidMaterial(context) + context.getPackageName()).toUpperCase()).toUpperCase());
    }

    private static String getCUidMaterial(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        try {
            if (!TextUtils.isEmpty(DeviceUtil.getOAID(context))) {
                sb.append(DeviceUtil.getOAID(context));
            } else if (!TextUtils.isEmpty(getAID(context))) {
                sb.append(getAID(context));
            }
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
        }
        if (TextUtils.isEmpty(sb.toString())) {
            sb.append(DEFAULT_M);
        }
        return sb.toString();
    }

    public static String getNewSourceHID(Context context) {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                String md5EncryData = EncryptUtil.md5EncryData("".toUpperCase());
                if (!TextUtils.isEmpty(md5EncryData)) {
                    return "2" + md5EncryData.toUpperCase();
                }
            } catch (Exception e10) {
                LeLog.w(TAG, e10);
            }
        }
        return "0" + EncryptUtil.md5EncryData(DEFAULT_M.toUpperCase()).toUpperCase();
    }
}
