package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AlicloudTracker {

    /* renamed from: a, reason: collision with root package name */
    private a f5977a;

    /* renamed from: a, reason: collision with other field name */
    private String f40a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, String> f41a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f5978b;

    public AlicloudTracker(a aVar, String str, String str2) {
        this.f5977a = aVar;
        this.f40a = str;
        this.f5978b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f41a.containsKey(str)) {
            Log.e("AlicloudTracker", "key is null or key is empty,please check it!");
        } else {
            this.f41a.remove(str);
        }
    }

    public void sendCustomHit(String str, long j10, Map<String, String> map) {
        try {
            if (this.f5977a == null) {
                Log.e("AlicloudTracker", "dataTracker is null, can not sendCustomHit");
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f41a);
            map.put("sdkId", this.f40a);
            map.put(Constants.KEY_SDK_VERSION, this.f5978b);
            this.f5977a.sendCustomHit(this.f40a + "_" + str, j10, map);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            Log.e("AlicloudTracker", "key is null or key is empty or value is null,please check it!");
            return;
        }
        if (this.f41a.containsKey(str)) {
            this.f41a.remove(str);
        }
        this.f41a.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
