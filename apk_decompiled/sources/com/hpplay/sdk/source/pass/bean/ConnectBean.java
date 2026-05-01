package com.hpplay.sdk.source.pass.bean;

import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Pass;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConnectBean extends BaseBean {
    private static final String TAG = "ConnectBean";
    public String appID;
    public int deviceType;
    public int favoriteDev;
    public int fm;
    public int fms;
    public int historyDev;
    public String mf;
    public int mirror;
    public String model;
    public int plat = 100;
    public int serviceType;
    public String sm;
    public String tid;

    public ConnectBean() {
        this.manifestVer = 7;
        this.sm = Pass.SM_PASS_THROUGH;
        this.model = DeviceProperties.getModel();
        this.mf = DeviceProperties.getManufacturer();
        this.appID = Session.getInstance().appKey;
        this.tid = Session.getInstance().tid;
    }

    public static ConnectBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ConnectBean connectBean = new ConnectBean();
            connectBean.model = jSONObject.optString(Constants.KEY_MODEL);
            connectBean.mf = jSONObject.optString("mf");
            connectBean.appID = jSONObject.optString("appID");
            connectBean.sm = jSONObject.optString("sm");
            connectBean.tid = jSONObject.optString("tid");
            connectBean.mirror = jSONObject.optInt("mirror");
            connectBean.fm = jSONObject.optInt("fm");
            connectBean.fms = jSONObject.optInt("fms");
            connectBean.plat = jSONObject.optInt("plat");
            connectBean.deviceType = jSONObject.optInt("deviceType");
            connectBean.serviceType = jSONObject.optInt("serviceType");
            connectBean.favoriteDev = jSONObject.optInt("favoriteDev");
            connectBean.historyDev = jSONObject.optInt("historyDev");
            return connectBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("mf", this.mf);
            jSONObject.put("sm", this.sm);
            jSONObject.put(Constants.KEY_MODEL, this.model);
            jSONObject.put("appID", this.appID);
            jSONObject.put("tid", this.tid);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
