package com.hpplay.sdk.source.da;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ADENSTUtils;
import com.taobao.accs.common.Constants;
import com.umeng.umcrash.UMCrash;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7665a = "DaRequest";

    /* renamed from: b, reason: collision with root package name */
    private l f7666b;

    /* renamed from: c, reason: collision with root package name */
    private AsyncTask f7667c;

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(f7665a, "parseDaConfig,json is invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
            String optString = jSONObject.optString("data");
            String optString2 = jSONObject.optString("ciphertext");
            if (optInt != 200) {
                SourceLog.w(f7665a, "parseDaConfig, msg: " + jSONObject.optString(Constant.KEY_MSG));
                return;
            }
            if (TextUtils.isEmpty(optString)) {
                optString = null;
            }
            if (!TextUtils.isEmpty(optString2)) {
                optString = ADENSTUtils.decryptByKey(Session.getInstance().appSecret, optString2);
            }
            SourceLog.i(f7665a, "parseDaConfig resultData:" + optString);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(optString);
            d.a(jSONObject2.optInt("se_app_sw"));
            d.b(jSONObject2.optInt("dlna_sw"));
            String optString3 = jSONObject2.optString("re_app_list");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            d.a(optString3.substring(1, optString3.length() - 1));
        } catch (Exception e10) {
            SourceLog.w(f7665a, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.hpplay.sdk.source.da.a.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(f7665a, "parseDaBean,json is invalid");
            return null;
        }
        try {
            com.hpplay.sdk.source.da.a.a aVar = new com.hpplay.sdk.source.da.a.a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.f7607a = jSONObject.optInt(Constant.KEY_STATUS);
            String optString = jSONObject.optString("data");
            String optString2 = jSONObject.optString("aesda");
            if (aVar.f7607a != 200) {
                SourceLog.w(f7665a, "parseDaBean, error status");
                return aVar;
            }
            if (TextUtils.isEmpty(optString)) {
                optString = null;
            }
            if (!TextUtils.isEmpty(optString2)) {
                optString = ADENSTUtils.decryptByKey(Session.getInstance().appSecret, optString2);
            }
            SourceLog.debug(f7665a, "parseDaBean resultData:" + optString);
            if (TextUtils.isEmpty(optString)) {
                return aVar;
            }
            aVar.f7609c = jSONObject.optInt("adrnum");
            aVar.f7610d = jSONObject.optInt("adtout");
            JSONObject jSONObject2 = new JSONObject(optString);
            a.C0129a c0129a = new a.C0129a();
            c0129a.f7611a = jSONObject2.optInt("postua");
            c0129a.f7612b = jSONObject2.optString("er");
            c0129a.f7613c = jSONObject2.optString("ads");
            c0129a.f7614d = jSONObject2.optInt("cid");
            c0129a.f7617g = jSONObject2.optString("surl");
            JSONArray optJSONArray = jSONObject2.optJSONArray("tpurl");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("tpurl2");
            c0129a.f7615e = new ArrayList();
            c0129a.f7616f = new ArrayList();
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    c0129a.f7615e.add(optJSONArray.optString(i10));
                }
            }
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    c0129a.f7616f.add(optJSONArray2.optString(i11));
                }
            }
            aVar.f7608b = c0129a;
            return aVar;
        } catch (Exception e10) {
            SourceLog.w(f7665a, "parseDaBean" + e10);
            return null;
        }
    }

    public void a() {
        String str = Session.getInstance().appKey;
        String str2 = Session.getInstance().appSecret;
        TreeMap treeMap = new TreeMap();
        treeMap.put("se_app_id", str);
        treeMap.put("se_uid", Session.getInstance().getUID());
        treeMap.put(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        treeMap.put("sign", EncryptUtil.md5EncryData(HapplayUtils.getMapParams(treeMap) + str2).toLowerCase());
        AsyncHttpRequestListener asyncHttpRequestListener = new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.da.i.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter == null || asyncHttpParameter.out == null) {
                    return;
                }
                SourceLog.debug(i.f7665a, "onRequestResult result:" + asyncHttpParameter.out.result);
                if (asyncHttpParameter.out.resultType == 0) {
                    SourceLog.i(i.f7665a, "onRequestResult type:" + asyncHttpParameter.out.resultType);
                    i.b(asyncHttpParameter.out.result);
                }
            }
        };
        String mapParams = HapplayUtils.getMapParams(treeMap);
        SourceLog.debug(f7665a, "requestDaConfig url:" + CloudAPI.sQuerySeAppConfig + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sQuerySeAppConfig, mapParams);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 0;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, asyncHttpRequestListener);
    }

    public void a(Context context, final com.hpplay.sdk.source.da.a.b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(UMCrash.SP_KEY_TIMESTAMP, "" + System.currentTimeMillis());
        treeMap.put("adpos", bVar.f7618a);
        treeMap.put(ParamsMap.DeviceParams.KEY_APPID, bVar.f7619b);
        if (!TextUtils.isEmpty(bVar.f7620c)) {
            treeMap.put(ParamsMap.DeviceParams.KEY_HID, bVar.f7620c);
        }
        if (!TextUtils.isEmpty(bVar.f7621d)) {
            treeMap.put(ParamsMap.DeviceParams.KEY_UID, bVar.f7621d);
        }
        String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(context);
        if (!TextUtils.isEmpty(wifiBSSIDNoneColon)) {
            treeMap.put("bid", wifiBSSIDNoneColon);
        }
        String aid = DeviceUtil.getAID(context);
        if (!TextUtils.isEmpty(aid)) {
            treeMap.put("manid", aid);
        }
        String oaid = DeviceUtil.getOAID(context);
        if (!TextUtils.isEmpty(oaid)) {
            treeMap.put("mloaid", oaid);
        }
        treeMap.put("cappid", Session.getInstance().appKey);
        treeMap.put("suid", Session.getInstance().getUID());
        treeMap.put("s", bVar.f7624g);
        treeMap.put("csv", "4.12.14");
        if (!TextUtils.isEmpty(bVar.f7622e)) {
            treeMap.put("udn", bVar.f7622e);
        }
        treeMap.put("uri", bVar.f7625h);
        treeMap.put("version", "1.1");
        treeMap.put("suuid", Preference.getInstance().get(Constant.KEY_VUUID, ""));
        treeMap.put("sssid", Preference.getInstance().get(Constant.KEY_VSESSION, ""));
        treeMap.put("url", bVar.f7623f);
        String md5EncryData = EncryptUtil.md5EncryData(HapplayUtils.getMapParamsWithoutEmpty(treeMap) + Session.getInstance().appSecret);
        if (!TextUtils.isEmpty(md5EncryData)) {
            treeMap.put("sign", md5EncryData.toLowerCase());
        }
        if (!TextUtils.isEmpty(bVar.f7623f)) {
            try {
                treeMap.put("url", URLEncoder.encode(bVar.f7623f, XML.CHARSET_UTF8));
            } catch (Exception e10) {
                SourceLog.w(f7665a, e10);
            }
        }
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        AsyncHttpRequestListener asyncHttpRequestListener = new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.da.i.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                AsyncHttpParameter.Out out;
                AsyncHttpParameter.In in;
                i.this.f7667c = null;
                String str = (asyncHttpParameter == null || (in = asyncHttpParameter.in) == null) ? "" : in.id;
                if (asyncHttpParameter != null && (out = asyncHttpParameter.out) != null && out.resultType != 2) {
                    String decode = httpEncrypt.decode(out);
                    SourceLog.debug(i.f7665a, "requestDaData onRequestResult result:" + decode);
                    com.hpplay.sdk.source.da.a.a c10 = i.this.c(decode);
                    if (i.this.f7666b != null) {
                        i.this.f7666b.a(bVar.f7618a, str, c10);
                        return;
                    }
                }
                if (i.this.f7666b != null) {
                    i.this.f7666b.a(bVar.f7618a, str, null);
                }
            }
        };
        String mapParams = HapplayUtils.getMapParams(treeMap);
        SourceLog.debug(f7665a, "requestDaData params:" + CloudAPI.sSendCreative + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sSendCreative, httpEncrypt.encode(mapParams));
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.tryCount = 1;
        in.id = String.valueOf(bVar.f7626i);
        asyncHttpParameter.in.requestHeaders = httpEncrypt.buildHeader();
        this.f7667c = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, asyncHttpRequestListener);
    }

    public void b() {
        if (this.f7667c != null) {
            SourceLog.i(f7665a, "release");
            this.f7667c.cancel(true);
            this.f7666b = null;
        }
    }

    public void c() {
        if (this.f7667c != null) {
            SourceLog.i(f7665a, "cancelTask");
            this.f7667c.cancel(true);
        }
    }

    public void a(l lVar) {
        this.f7666b = lVar;
    }
}
