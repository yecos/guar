package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncUploadFileListener;
import com.hpplay.common.asyncmanager.AsyncUploadFileParameter;
import com.hpplay.common.asyncmanager.HttpMethod;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.FileUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.logwriter.b;
import com.hpplay.logwriter.e;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.api.IUploadLogQueryListener;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.LogCache;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LogUpload {
    private static final String TAG = "LogUpload";
    private static boolean isUploadLog = false;

    private static Runnable createUploadLogRunnable(final Map<String, String> map, final UploadLogCallback uploadLogCallback, final String str) {
        return new Runnable() { // from class: com.hpplay.sdk.source.utils.LogUpload.2
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = LogUpload.isUploadLog = true;
                if (TextUtils.isEmpty(str)) {
                    UploadLogCallback uploadLogCallback2 = uploadLogCallback;
                    if (uploadLogCallback2 != null) {
                        uploadLogCallback2.uploadStatus(5);
                    }
                } else {
                    LogUpload.upload(new String[]{str}, map, uploadLogCallback);
                }
                boolean unused2 = LogUpload.isUploadLog = false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void upload(String[] strArr, Map<String, String> map, final UploadLogCallback uploadLogCallback) {
        AsyncUploadFileParameter asyncUploadFileParameter = new AsyncUploadFileParameter(CloudAPI.sLogReportUrl, strArr, map);
        asyncUploadFileParameter.in.httpMethod = HttpMethod.POST;
        AsyncManager.getInstance().exeUploadFileTask(asyncUploadFileParameter, new AsyncUploadFileListener() { // from class: com.hpplay.sdk.source.utils.LogUpload.3
            @Override // com.hpplay.common.asyncmanager.AsyncUploadFileListener
            public void onRequestResult(AsyncUploadFileParameter asyncUploadFileParameter2) {
                if (asyncUploadFileParameter2.out == null) {
                    return;
                }
                SourceLog.i(LogUpload.TAG, "upload response :" + asyncUploadFileParameter2.out.getResult());
                if (UploadLogCallback.this == null) {
                    return;
                }
                try {
                    String str = (String) asyncUploadFileParameter2.out.getResult();
                    if (TextUtils.isEmpty(str)) {
                        UploadLogCallback.this.uploadStatus(-1);
                    } else {
                        try {
                            String optString = new JSONObject(str).optString(Constants.KEY_HTTP_CODE);
                            if (!TextUtils.isEmpty(optString)) {
                                UploadLogCallback.this.uploadStatus(Integer.parseInt(optString));
                            }
                        } catch (Exception e10) {
                            UploadLogCallback.this.uploadStatus(-1);
                            SourceLog.w(LogUpload.TAG, e10);
                        }
                    }
                } catch (Exception e11) {
                    UploadLogCallback.this.uploadStatus(-1);
                    SourceLog.w(LogUpload.TAG, e11);
                }
            }
        });
    }

    public static void uploadErrorLogFile(String str, String str2, String str3) {
        try {
            String str4 = LogCache.getErrorLogFilePath() + File.separator + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.getDefault());
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            String str5 = str4 + "_" + simpleDateFormat.format(date);
            String str6 = str5 + b.f7381d;
            final String str7 = str5 + b.f7382e;
            FileUtil.string2File(str3, str6);
            e.a(str6, str7);
            SourceLog.i(TAG, "uploadErrorLogFile: " + str7);
            uploadLogFile(Session.getInstance().getContext(), null, CreateUtil.createEid(), str, "", str2, str7, new UploadLogCallback() { // from class: com.hpplay.sdk.source.utils.LogUpload.1
                @Override // com.hpplay.sdk.source.utils.UploadLogCallback
                public void uploadStatus(int i10) {
                    if (i10 != 6) {
                        FileUtil.deleteFile(str7);
                    }
                }
            });
            FileUtil.deleteFile(str6);
        } catch (Exception e10) {
            SourceLog.i(TAG, "uploadErrorLogFile: " + e10);
        }
    }

    public static void uploadLogFile(Context context, String str, String str2, String str3, String str4, UploadLogCallback uploadLogCallback) {
        String logOutputFilePath = LogCache.getLogOutputFilePath();
        SourceLog.flushLogWriter();
        if (!TextUtils.isEmpty(logOutputFilePath)) {
            f.a().c(logOutputFilePath);
        }
        uploadLogFile(context, str, str2, str3, str4, (System.currentTimeMillis() / 1000) + "", logOutputFilePath, uploadLogCallback);
    }

    public static void uploadLogFileQuery(Context context, final IUploadLogQueryListener iUploadLogQueryListener) {
        SourceLog.i(TAG, "uploadLogFileQuery");
        try {
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sLogReportQueryUrl, "{}");
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            if (in.requestHeaders == null) {
                in.requestHeaders = new HashMap();
            }
            asyncHttpParameter.in.requestHeaders.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            asyncHttpParameter.in.requestHeaders.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            asyncHttpParameter.in.requestMethod = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.utils.LogUpload.4
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                    if (out.resultType != 0) {
                        IUploadLogQueryListener iUploadLogQueryListener2 = IUploadLogQueryListener.this;
                        if (iUploadLogQueryListener2 != null) {
                            iUploadLogQueryListener2.onError();
                            return;
                        }
                        return;
                    }
                    String str = out.result;
                    IUploadLogQueryListener iUploadLogQueryListener3 = IUploadLogQueryListener.this;
                    if (iUploadLogQueryListener3 != null) {
                        iUploadLogQueryListener3.onQueryResult(str);
                    }
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    private static void uploadLogFile(Context context, String str, String str2, String str3, String str4, String str5, String str6, UploadLogCallback uploadLogCallback) {
        if (!SDKConfig.getInstance().getUploadSwitch()) {
            SourceLog.i(TAG, "uploadLogFile ignore");
            return;
        }
        SourceLog.i(TAG, "uploadLogFile :" + str6);
        if (isUploadLog) {
            if (uploadLogCallback != null) {
                uploadLogCallback.uploadStatus(6);
                return;
            }
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("a", "2004");
            hashMap.put("aid", Session.getInstance().appKey);
            hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            String string = FieldUtil.getString(FieldUtil.f7332m);
            Session.getInstance();
            hashMap.put(string, Session.DEFAULT_M);
            hashMap.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
            hashMap.put("cid", "");
            hashMap.put("j", DeviceProperties.getModel());
            hashMap.put("osv", Build.VERSION.RELEASE);
            hashMap.put("appv", HapplayUtils.getAppVersion(context) + "");
            hashMap.put("sdkv", "4.12.14");
            hashMap.put("ls", str5);
            hashMap.put("et", str3);
            hashMap.put("pn", str4);
            hashMap.put("version", "1.1");
            SourceLog.debug(TAG, "param:" + HapplayUtils.getJsonParams(hashMap));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("eid", str);
                AsyncManager.getInstance().exeRunnable(createUploadLogRunnable(hashMap, uploadLogCallback, str6), null);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            hashMap.put("euqid", str2);
            AsyncManager.getInstance().exeRunnable(createUploadLogRunnable(hashMap, uploadLogCallback, str6), null);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }
}
