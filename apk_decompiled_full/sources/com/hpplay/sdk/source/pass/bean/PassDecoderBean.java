package com.hpplay.sdk.source.pass.bean;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.DecoderBean;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PassDecoderBean extends BaseBean {
    private static final String TAG = "PassDecoderBean";
    public List<DecoderBean> decs;

    public PassDecoderBean() {
        this.manifestVer = 1;
    }

    public static PassDecoderBean formJson(String str) {
        try {
            PassDecoderBean passDecoderBean = new PassDecoderBean();
            JSONObject jSONObject = new JSONObject(str);
            passDecoderBean.manifestVer = jSONObject.optInt("manifestVer");
            JSONArray optJSONArray = jSONObject.optJSONArray("decs");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    DecoderBean decoderBean = new DecoderBean();
                    decoderBean.name = optJSONObject.optString("name");
                    decoderBean.type = optJSONObject.optString("type");
                    String optString = optJSONObject.optString(Constants.SEND_TYPE_RES);
                    if (!TextUtils.isEmpty(optString) && optString.contains("x")) {
                        String[] split = optString.split("x");
                        try {
                            decoderBean.maxWidth = Integer.valueOf(split[0]).intValue();
                            decoderBean.maxHeight = Integer.valueOf(split[1]).intValue();
                        } catch (Exception e10) {
                            SourceLog.w(TAG, e10);
                        }
                    }
                    arrayList.add(decoderBean);
                }
                passDecoderBean.decs = arrayList;
            }
            return passDecoderBean;
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
            return null;
        }
    }
}
