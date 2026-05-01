package com.hpplay.common.utils;

import android.util.Base64;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.log.LeLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HttpEncrypt {
    private static final String ENCRYPT_DATA = "encryptedData";
    private static final String KEY = "23046885";
    private static final String TAG = "HttpEncrypt";
    private static final String X_LB_EN = "x-lb-en";
    private static final String X_LB_EN_RAND = "x-lb-en-rand";
    private static final String X_LB_EN_VALUE = "2";
    private String randomKey;

    public HttpEncrypt() {
        this.randomKey = "";
        this.randomKey = getRandomKey();
    }

    private String getRandomKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i10 = 0; i10 < 8; i10++) {
            if (random.nextInt(2) % 2 != 0) {
                sb.append(random.nextInt(10));
            } else if (random.nextInt(2) % 2 == 0) {
                sb.append((char) (random.nextInt(27) + 65));
            } else {
                sb.append((char) (random.nextInt(27) + 97));
            }
        }
        return sb.toString();
    }

    public Map<String, String> buildHeader() {
        HashMap hashMap = new HashMap(2);
        hashMap.put(X_LB_EN, "2");
        hashMap.put(X_LB_EN_RAND, this.randomKey);
        return hashMap;
    }

    public String decode(AsyncHttpParameter.Out out) {
        List<String> list;
        List<String> list2;
        String str = out.result;
        Map<String, List<String>> map = out.headers;
        LeLog.i(TAG, "decode, headers = " + map);
        return (map != null && (list = map.get(X_LB_EN)) != null && list.size() >= 1 && "2".equals(list.get(0)) && (list2 = map.get(X_LB_EN_RAND)) != null && list2.size() >= 1) ? decode(str, list2.get(0)) : str;
    }

    public String encode(String str) {
        LeLog.i(TAG, "encode, randomKey: " + this.randomKey + " , " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ENCRYPT_DATA, Base64.encodeToString(Encode.encodeToByte(str, this.randomKey + KEY), 2));
        } catch (Exception e10) {
            LeLog.w(TAG, "encode: " + e10);
        }
        LeLog.i(TAG, "encode, " + jSONObject.toString());
        return jSONObject.toString();
    }

    private String decode(String str, String str2) {
        LeLog.w(TAG, "decode, randomKey: " + str2);
        try {
            str = Encode.decodeByteToString(Base64.decode(new JSONObject(str).optString(ENCRYPT_DATA), 2), str2 + KEY);
        } catch (Exception e10) {
            LeLog.w(TAG, "decode: " + e10);
        }
        LeLog.w(TAG, "decode, result: " + str);
        return str;
    }
}
