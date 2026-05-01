package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SDKConfigBean {
    public Data data;
    public int status;

    public static class Data {
        public String APP_TVDevName_Prompt;
        public Data_connect data_connect;
        public Data_search data_search;
        public Data_transfer data_transfer;
        public String notuploadlog_channel;
        public String switch_collectiondev;
        public String switch_historicaldev;
        public int switch_netadapt;

        public static class Data_connect {
            public int enable;
            public int upload_interval;
        }

        public static class Data_search {
            public int enable;
            public int searchtime;
        }

        public static class Data_transfer {
            public int enable;
            public int netdetect_time;
            public int upload_interval;
            public int videoquality_time;
        }
    }

    public static SDKConfigBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SDKConfigBean sDKConfigBean = new SDKConfigBean();
            sDKConfigBean.status = jSONObject.optInt(Constant.KEY_STATUS);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return sDKConfigBean;
            }
            Data data = new Data();
            sDKConfigBean.data = data;
            data.switch_netadapt = optJSONObject.optInt("switch_netadapt");
            sDKConfigBean.data.notuploadlog_channel = optJSONObject.optString("notuploadlog_channel");
            sDKConfigBean.data.switch_collectiondev = optJSONObject.optString("Switch_CollectionDev");
            sDKConfigBean.data.switch_historicaldev = optJSONObject.optString("Switch_HistoricalDev");
            sDKConfigBean.data.APP_TVDevName_Prompt = optJSONObject.optString("APP_TVDevName_Prompt");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data_search");
            if (optJSONObject2 != null) {
                sDKConfigBean.data.data_search = new Data.Data_search();
                sDKConfigBean.data.data_search.enable = optJSONObject2.optInt("enable");
                sDKConfigBean.data.data_search.searchtime = optJSONObject2.optInt("searchtime");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("data_connect");
            if (optJSONObject3 != null) {
                sDKConfigBean.data.data_connect = new Data.Data_connect();
                sDKConfigBean.data.data_connect.enable = optJSONObject3.optInt("enable");
                sDKConfigBean.data.data_connect.upload_interval = optJSONObject3.optInt("upload_interval");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("data_transfer");
            if (optJSONObject4 != null) {
                sDKConfigBean.data.data_transfer = new Data.Data_transfer();
                sDKConfigBean.data.data_transfer.enable = optJSONObject4.optInt("enable");
                sDKConfigBean.data.data_transfer.upload_interval = optJSONObject4.optInt("upload_interval");
                sDKConfigBean.data.data_transfer.netdetect_time = optJSONObject4.optInt("netdetect_time");
                sDKConfigBean.data.data_transfer.videoquality_time = optJSONObject4.optInt("videoquality_time");
            }
            return sDKConfigBean;
        } catch (Exception e10) {
            SourceLog.w("SDKConfigBean", e10);
            return null;
        }
    }
}
