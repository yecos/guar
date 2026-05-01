package com.umeng.ut.a.a;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.ut.b.a.a.d;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        String str2;
        Context m69a = com.umeng.ut.a.a.a().m69a();
        if (m69a == null) {
            return "";
        }
        try {
            str2 = UMUtils.getAppkey(m69a);
        } catch (Throwable unused) {
            str2 = "";
        }
        return d.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", com.umeng.ut.a.a.a().m70a(), a(str, "", str2, m69a.getPackageName())));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put(DispatchConstants.APP_NAME, str4);
        return new JSONObject(d.a(hashMap)).toString();
    }
}
