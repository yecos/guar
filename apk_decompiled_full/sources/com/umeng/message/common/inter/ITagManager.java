package com.umeng.message.common.inter;

import com.umeng.analytics.pro.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ITagManager {
    public static final String FAIL = "fail";
    public static final String SUCCESS = "ok";

    public static class Result {
        public String errors;
        public long interval;
        public String jsonString;
        public int remain;
        public String status;

        public Result() {
            this.status = ITagManager.FAIL;
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.jsonString = "";
        }

        public void setErrors(String str) {
            this.errors = str;
        }

        public String toString() {
            return this.jsonString;
        }

        public Result(JSONObject jSONObject) {
            this.status = ITagManager.FAIL;
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.jsonString = "";
            if (jSONObject == null) {
                return;
            }
            this.jsonString = jSONObject.toString();
            this.status = jSONObject.optString("success", ITagManager.FAIL);
            this.remain = jSONObject.optInt("remain", 0);
            this.interval = jSONObject.optLong(bt.f10040ba, 0L);
            this.errors = jSONObject.optString("errors");
        }
    }
}
