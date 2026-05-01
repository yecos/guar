package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.taobao.accs.common.Constants;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class GlobalInfo {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f6138a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f6138a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.f6138a.get(str);
        return (obj2 != null || this.f6138a.containsKey(str)) ? obj2 : obj;
    }

    public Map<String, Object> getGlobalInfoMap() {
        HashMap hashMap = new HashMap(this.f6138a);
        a.a();
        hashMap.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        hashMap.put("w_tm", Long.valueOf(a.b() / 1000));
        return hashMap;
    }

    public List<AbsSection> getGlobalSectionList(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection put = kVSection.put("type", str).put(ParamsMap.DeviceParams.KEY_APPID, this.f6138a.get(ParamsMap.DeviceParams.KEY_APPID)).put("wid", this.f6138a.get("wid")).put("pid", this.f6138a.get("pid")).put("pkg", this.f6138a.get("pkg")).put(BrowserInfo.KEY_VER, this.f6138a.get(BrowserInfo.KEY_VER)).put("vcode", this.f6138a.get("vcode")).put("ps", this.f6138a.get("ps")).put("stime", this.f6138a.get("stime"));
        a.a();
        KVSection put2 = put.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        put2.put("w_tm", Long.valueOf(a.b() / 1000)).put("sdk_ver", this.f6138a.get("sdk_ver"));
        String valueOf = String.valueOf(b(ParamsMap.DeviceParams.KEY_UID, ""));
        if (!TextUtils.isEmpty(valueOf)) {
            kVSection.put(ParamsMap.DeviceParams.KEY_UID, valueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.f6138a.get("lang")).put(Constants.KEY_BRAND, this.f6138a.get(Constants.KEY_BRAND)).put(Constants.KEY_MODEL, this.f6138a.get(Constants.KEY_MODEL)).put("build_model", this.f6138a.get("build_model")).put("rom", this.f6138a.get("rom")).put(com.umeng.ccg.a.f10661u, this.f6138a.get(com.umeng.ccg.a.f10661u)).put("dsp_h", this.f6138a.get("dsp_h")).put("dsp_w", this.f6138a.get("dsp_w")).put("tzone", this.f6138a.get("tzone")).put("net", this.f6138a.get("net")).put("fr", this.f6138a.get("fr"));
        try {
            if (this.f6138a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f6138a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f6138a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f6138a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f6138a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f6138a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public String getUUID(Context context) {
        String valueOf = String.valueOf(b("wid", ""));
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String a10 = c.a(context);
        a("wid", a10);
        return a10;
    }
}
