package com.hpplay.sdk.source.business.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.LogUpload;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SourceErrorLog {
    private static final int LIMIT_REPORT_TIME = 86400000;
    private static final String TAG = "SourceErrorLog";
    private static SourceErrorLog sInstance;
    private SharedPreferences preferences;

    private SourceErrorLog(Context context) {
        this.preferences = context.getSharedPreferences("source_error", 0);
    }

    private long getErrorCode(String str) {
        return this.preferences.getLong(str, 0L);
    }

    public static synchronized SourceErrorLog getInstance() {
        SourceErrorLog sourceErrorLog;
        synchronized (SourceErrorLog.class) {
            if (sInstance == null) {
                sInstance = new SourceErrorLog(Session.getInstance().getContext());
            }
            sourceErrorLog = sInstance;
        }
        return sourceErrorLog;
    }

    private void saveErrorCode(String str, long j10) {
        this.preferences.edit().putLong(str, j10).apply();
    }

    public String getErrorReportExtra(int i10, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i10);
            jSONObject.put("errMsg", str);
        } catch (JSONException e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject.toString();
    }

    public void handleErrorCode(String str, String str2, String str3) {
        SourceLog.i(TAG, "handleErrorCode et:" + str);
        long errorCode = getErrorCode(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (System.currentTimeMillis() - errorCode > 86400000) {
            saveErrorCode(str, currentTimeMillis);
            LogUpload.uploadErrorLogFile(str, str3, str2);
        } else {
            SourceLog.i(TAG, "handleErrorCode ignore " + str);
        }
    }
}
