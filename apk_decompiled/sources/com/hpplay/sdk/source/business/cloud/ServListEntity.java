package com.hpplay.sdk.source.business.cloud;

import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServListEntity {
    private static final String TAG = "ServerListEntity";
    public List<UrlListEntity> url_list;
    public int ver;

    public static class UrlListEntity {
        public String name;
        public String url;

        public UrlListEntity(JSONObject jSONObject) {
            decode(jSONObject);
        }

        public void decode(JSONObject jSONObject) {
            if (jSONObject == null) {
                SourceLog.i(ServListEntity.TAG, "decode UrlListEntity is emtpy");
            } else {
                this.name = jSONObject.optString("name");
                this.url = jSONObject.optString("url");
            }
        }
    }

    public ServListEntity(JSONObject jSONObject) {
        decode(jSONObject);
    }

    private void decode(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        this.ver = jSONObject.optInt(BrowserInfo.KEY_VER);
        JSONArray optJSONArray = jSONObject.optJSONArray("url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.url_list = new ArrayList();
        int length = optJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            UrlListEntity urlListEntity = new UrlListEntity(optJSONArray.optJSONObject(i10));
            urlListEntity.decode(optJSONArray.optJSONObject(i10));
            this.url_list.add(urlListEntity);
        }
    }
}
