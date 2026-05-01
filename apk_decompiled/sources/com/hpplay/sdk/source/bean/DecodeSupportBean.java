package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class DecodeSupportBean {
    private final String TAG = "DecodeSupportBean";
    private ArrayList<DecodesInfo> decodesInfos;
    private int manifestVer;

    public class DecodesInfo {
        public String name;
        public String res;
        public String type;

        public DecodesInfo() {
        }

        public void decode(JSONObject jSONObject) {
            this.name = jSONObject.optString("name");
            this.type = jSONObject.optString("type");
            this.res = jSONObject.optString(Constants.SEND_TYPE_RES);
        }
    }

    public void decode(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("decs");
            this.decodesInfos = new ArrayList<>();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                DecodesInfo decodesInfo = new DecodesInfo();
                decodesInfo.decode(jSONArray.getJSONObject(i10));
                this.decodesInfos.add(decodesInfo);
            }
        } catch (Exception e10) {
            SourceLog.w("DecodeSupportBean", e10);
        }
    }

    public ArrayList<DecodesInfo> getDecodesInfos() {
        return this.decodesInfos;
    }
}
