package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import com.hpplay.a.a.a.d;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.SDKConfigBean;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SDKConfig {
    private static final String TAG = "SDKConfig";
    private static SDKConfig sInstance;
    private SDKConfigBean mConfigBean;

    private SDKConfig() {
        readCacheData();
    }

    public static synchronized SDKConfig getInstance() {
        synchronized (SDKConfig.class) {
            synchronized (SDKConfig.class) {
                if (sInstance == null) {
                    sInstance = new SDKConfig();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private void readCacheData() {
        SDKConfigBean formJSON;
        String str = Preference.getInstance().get(Preference.KEY_SDK_CONFIG);
        if (TextUtils.isEmpty(str) || (formJSON = SDKConfigBean.formJSON(str)) == null) {
            return;
        }
        this.mConfigBean = formJSON;
    }

    public boolean getFavoriteDevSwitch() {
        SDKConfigBean.Data data;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || TextUtils.isEmpty(data.switch_collectiondev)) {
            return true;
        }
        return !"0".equals(this.mConfigBean.data.switch_collectiondev);
    }

    public boolean getHistoryDevSwitch() {
        SDKConfigBean.Data data;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || TextUtils.isEmpty(data.switch_historicaldev)) {
            return true;
        }
        return !"0".equals(this.mConfigBean.data.switch_historicaldev);
    }

    public int getQualityInterval() {
        SDKConfigBean.Data data;
        SDKConfigBean.Data.Data_transfer data_transfer;
        int i10;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        return (sDKConfigBean == null || (data = sDKConfigBean.data) == null || (data_transfer = data.data_transfer) == null || (i10 = data_transfer.videoquality_time) <= 0) ? d.SOCKET_READ_TIMEOUT : i10 * 1000;
    }

    public int getSearchEnable() {
        SDKConfigBean.Data data;
        SDKConfigBean.Data.Data_search data_search;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || (data_search = data.data_search) == null) {
            return 1;
        }
        return data_search.enable;
    }

    public int getSearchOutTime() {
        SDKConfigBean.Data data;
        SDKConfigBean.Data.Data_search data_search;
        int i10;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || (data_search = data.data_search) == null || (i10 = data_search.searchtime) <= 0) {
            return 30;
        }
        return i10;
    }

    public String getSinkAppSearchNamePrefer() {
        SDKConfigBean.Data data;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null) {
            return null;
        }
        return data.APP_TVDevName_Prompt;
    }

    public int getTransferEnable() {
        SDKConfigBean.Data data;
        SDKConfigBean.Data.Data_transfer data_transfer;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || (data_transfer = data.data_transfer) == null) {
            return 1;
        }
        return data_transfer.enable;
    }

    public boolean getUploadSwitch() {
        SDKConfigBean.Data data;
        String str;
        SDKConfigBean sDKConfigBean = this.mConfigBean;
        if (sDKConfigBean == null || (data = sDKConfigBean.data) == null || (str = data.notuploadlog_channel) == null) {
            return true;
        }
        if ("-1".equals(str)) {
            return false;
        }
        return !this.mConfigBean.data.notuploadlog_channel.contains(Session.getInstance().appKey);
    }

    public void requestConfig() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        hashMap.put("prot_ver", "1.0");
        hashMap.put("sdk_ver", CastUtil.getVersion());
        AsyncManager.getInstance().exeHttpTask(new AsyncHttpParameter(CloudAPI.sConfig, HapplayUtils.getMapParams(hashMap)), new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.SDKConfig.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                AsyncHttpParameter.Out out;
                if (asyncHttpParameter == null || (out = asyncHttpParameter.out) == null || TextUtils.isEmpty(out.result)) {
                    return;
                }
                String str = asyncHttpParameter.out.result;
                SDKConfigBean formJSON = SDKConfigBean.formJSON(str);
                if (formJSON != null) {
                    SDKConfig.this.mConfigBean = formJSON;
                }
                SourceLog.debug(SDKConfig.TAG, "requestConfig:" + str);
                Preference.getInstance().put(Preference.KEY_SDK_CONFIG, str);
            }
        });
    }
}
