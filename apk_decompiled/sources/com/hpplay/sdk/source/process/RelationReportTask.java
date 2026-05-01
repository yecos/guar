package com.hpplay.sdk.source.process;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.BrowserTypeBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserBridge;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RelationReportTask {
    private static final String TAG = "RelationReportTask";
    private static final int WHAT_REPORT = 1;
    private static RelationReportTask sInstance;
    private long mStartTimeStamp = -1;
    private long mStopTimeStamp = -1;
    private boolean isReport = false;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.process.RelationReportTask.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            try {
                RelationReportTask.this.reportRelation((Context) message.obj);
                return false;
            } catch (Exception e10) {
                SourceLog.w(RelationReportTask.TAG, e10);
                return false;
            }
        }
    });

    private RelationReportTask() {
    }

    public static synchronized RelationReportTask getInstance() {
        synchronized (RelationReportTask.class) {
            synchronized (RelationReportTask.class) {
                if (sInstance == null) {
                    sInstance = new RelationReportTask();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private String getScanBody(List<LelinkServiceInfo> list) {
        BrowserTypeBean browserTypeBean;
        JSONArray jSONArray = new JSONArray();
        for (LelinkServiceInfo lelinkServiceInfo : list) {
            if (lelinkServiceInfo != null && (browserTypeBean = BrowserHistory.getInstance().getBrowserTypeBean(lelinkServiceInfo.getName())) != null) {
                try {
                    if (browserTypeBean.isMDns) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                        jSONObject.put("pt", 1);
                        jSONObject.put("mt", browserTypeBean.mDnsTime);
                        jSONObject.put("wmt", 0);
                        jSONArray.put(jSONObject);
                    }
                    if (browserTypeBean.isUPnP) {
                        JSONObject jSONObject2 = new JSONObject();
                        BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 3);
                        if (browserInfo != null) {
                            jSONObject2.put(ParamsMap.DeviceParams.KEY_UID, browserInfo.getExtras().get(BrowserInfo.KEY_DLNA_UUID));
                            jSONObject2.put("pt", 2);
                            jSONObject2.put("mt", browserTypeBean.UPnPTime);
                            jSONObject2.put("wmt", 0);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    if (browserTypeBean.isQRCode) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                        jSONObject3.put("pt", 3);
                        jSONObject3.put("mt", browserTypeBean.qrCodeCloudTime);
                        jSONObject3.put("wmt", browserTypeBean.qrCodeCloudTime);
                        jSONArray.put(jSONObject3);
                    }
                    if (browserTypeBean.isPinCode) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                        jSONObject4.put("pt", 4);
                        jSONObject4.put("mt", browserTypeBean.pinCodeCloudTime);
                        jSONObject4.put("wmt", browserTypeBean.pinCodeCloudTime);
                        jSONArray.put(jSONObject4);
                    }
                    if (browserTypeBean.isSonic) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                        jSONObject5.put("pt", 5);
                        jSONObject5.put("mt", browserTypeBean.sonicTime);
                        jSONObject5.put("wmt", browserTypeBean.sonicCloudTime);
                        jSONArray.put(jSONObject5);
                    }
                    if (browserTypeBean.isBle) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                        jSONObject6.put("pt", 6);
                        jSONObject6.put("mt", browserTypeBean.bleTime);
                        jSONObject6.put("wmt", browserTypeBean.bleCloudTime);
                        jSONArray.put(jSONObject6);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return jSONArray.toString();
    }

    private String getScanTypes() {
        StringBuilder sb = new StringBuilder();
        BrowserHistory browserHistory = BrowserHistory.getInstance();
        if (browserHistory.isUseMdns()) {
            sb.append("1,");
        }
        if (browserHistory.isUseUPnP()) {
            sb.append("2,");
        }
        if (browserHistory.isUseQR()) {
            sb.append("3,");
        }
        if (browserHistory.isUsePinCode()) {
            sb.append("4,");
        }
        if (browserHistory.isUseSonic()) {
            sb.append("5,");
        }
        if (browserHistory.isUseBLE()) {
            sb.append("6,");
        }
        return sb.toString();
    }

    private void release() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRelation(Context context) {
        this.isReport = true;
        List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
        if (browserList == null || browserList.isEmpty()) {
            SourceDataReport.getInstance().relation(this.mStartTimeStamp, this.mStopTimeStamp, "", "", "", getScanTypes(), BrowserBridge.getInstance().getBrowseErrorMsg());
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (LelinkServiceInfo lelinkServiceInfo : browserList) {
            BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 1);
            if (browserInfo != null) {
                browserInfo.getUid();
            }
            BrowserInfo browserInfo2 = CastUtil.getBrowserInfo(lelinkServiceInfo, 3);
            if (browserInfo2 != null) {
                String str = browserInfo2.getExtras().get(BrowserInfo.KEY_MANUFACTURER);
                String name = browserInfo2.getName();
                sb.append(str);
                sb.append("|");
                sb.append(name);
                sb.append("|");
                sb.append(System.currentTimeMillis());
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(",")) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        String scanBody = getScanBody(browserList);
        SourceLog.debug(TAG, "reportRelation s:" + scanBody);
        SourceLog.debug(TAG, "reportRelation w:");
        SourceDataReport.getInstance().relation(this.mStartTimeStamp, this.mStopTimeStamp, sb2, scanBody, "", getScanTypes(), null);
    }

    public static void unInit() {
        RelationReportTask relationReportTask = sInstance;
        if (relationReportTask == null) {
            return;
        }
        relationReportTask.release();
        sInstance = null;
    }

    public void clear() {
        this.isReport = false;
    }

    public void report(Context context, long j10, long j11, long j12) {
        if (this.isReport || this.mHandler == null) {
            return;
        }
        if (SDKConfig.getInstance().getSearchEnable() != 1) {
            SourceLog.w(TAG, "relation ignore");
            return;
        }
        this.mStartTimeStamp = j10;
        this.mStopTimeStamp = j11;
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1, context), j12);
    }

    public void reportSinkDevice(long j10, String str, String str2) {
        SourceDataReport.getInstance().relation(this.mStartTimeStamp, j10, str2, null, null, null, str, null);
    }

    public void stopBrowser() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }
}
