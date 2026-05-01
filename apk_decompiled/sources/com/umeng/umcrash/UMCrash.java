package com.umeng.umcrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.fluttersdk.FlutterManager;
import com.efs.sdk.h5pagesdk.H5Manager;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.pa.IPaClient;
import com.efs.sdk.pa.PAFactory;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import com.google.android.gms.measurement.AppMeasurement;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory;
import com.umeng.innner.umcrash.UMCrashUtil;
import com.umeng.logsdk.ULogManager;
import com.umeng.logsdk.UploadFileFilterCodeLog;
import com.umeng.pagesdk.PageManger;
import com.umeng.powersdk.PowerManager;
import com.umeng.umcrash.IUMCrashCallbackWithType;
import com.umeng.umcrash.customlog.UAPMCustomLogManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UMCrash {
    private static final boolean DEFAULT_VALUE_CODE_LOG = true;
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_FLUTTER = true;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final boolean DEFAULT_VALUE_POWER = true;
    private static final String INTEGRATIONTESTING_SP = "itconfig";
    private static final String IT_DEBUGKEY = "apm_debugkey";
    private static final String IT_SENDAGING = "apm_sendaging";
    private static final String KEY_ACTIITY_ON_CREATED = "onCreated";
    private static final String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    private static final String KEY_ACTIITY_ON_PAUSED = "onPaused";
    private static final String KEY_ACTIITY_ON_RESUMED = "onResumed";
    private static final String KEY_ACTIITY_ON_STARTED = "onStarted";
    private static final String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_CUSTOM_LOG = "um_custom_log";
    public static final String KEY_CALLBACK_CUSTOM_MAPPING = "um_custom_mapping";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_SESSION_ID = "um_session_id";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_CALLBACK_UM_INFOS = "um_infos:";
    private static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    private static final String KEY_CALLBACK_USER_STRING_ANR = "um_user_str_anr:";
    private static final String KEY_CALLBACK_USER_STRING_CUSTOM_LOG = "um_user_str_custom_log:";
    private static final String KEY_CALLBACK_USER_STRING_JAVA = "um_user_str_java:";
    private static final String KEY_CALLBACK_USER_STRING_NATIVE = "um_user_str_native:";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CODE_LOG = "enableCodeLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_FLUTTER = "enableFlutterLog";
    public static final String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_ENABLE_PAGE = "enablePageLog";
    public static final String KEY_ENABLE_POWER = "enablePowerLog";
    public static final String KEY_HEADER_ACCESS = "um_access";
    public static final String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_BESRIAL = "um_bserial";
    public static final String KEY_HEADER_BSVER = "um_bsver";
    public static final String KEY_HEADER_BVER = "um_bver";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    public static final String KEY_LOG_DEVICES_ID = "log_devices_id";
    public static final String KEY_LOG_USER_ID = "log_user_id";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    private static final String TAG = "UMCrash";
    private static String crashSdkVersion = "1.9.12";
    private static boolean isBuildId = true;
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isIntl = false;
    private static boolean isZip = true;
    private static Context mContext = null;
    private static UMCrashCallback mUMCrashCallback = null;
    private static IUMCrashCallbackWithType mUMCrashCallbackWithType = null;
    private static boolean sIsEnableLogBackup = false;
    private static boolean sIsKillProcessAfterCrash = true;
    public static EfsReporter sReporter;
    private static String userBesrial;
    private static String userBsver;
    private static String userBver;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);
    private static boolean isCodeLog = false;
    private static int sApmCallbackLimit = 0;
    private static boolean isPA = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isPage = false;
    private static boolean isPower = false;
    private static boolean isFlutter = false;
    private static boolean enableJavaLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableANRLog = true;
    private static boolean enablePaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNetLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enablePageLog = true;
    private static boolean enableCodeLog = true;
    private static boolean enablePowerLog = true;
    private static boolean enableFlutterLog = true;
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static long paTimeoutTime = DEFAULT_PA_TIMEOUT_TIME;
    private static int index = 0;
    private static boolean isOpenUserCrash = true;
    private static boolean isUploadNowUserCrash = false;
    private static Map<String, String> sCustomInfo = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i10, int i11) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z10) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z10) {
            String onCallback;
            String onCallback2;
            String onCallback3;
            String onCallback4;
            String onCallback5;
            if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                return UMCrash.getUMID(UMCrash.mContext);
            }
            if (!UMCrash.KEY_CALLBACK_UM_INFOS.equals(str)) {
                if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType != null || UMCrash.mUMCrashCallback == null || (onCallback5 = UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback5.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback5, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback5;
                }
                if (UMCrash.KEY_CALLBACK_USER_STRING_JAVA.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType == null || (onCallback4 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_JAVA)) == null) {
                        return null;
                    }
                    return onCallback4.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback4, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback4;
                }
                if (UMCrash.KEY_CALLBACK_USER_STRING_NATIVE.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType == null || (onCallback3 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_NATIVE)) == null) {
                        return null;
                    }
                    return onCallback3.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback3, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback3;
                }
                if (UMCrash.KEY_CALLBACK_USER_STRING_ANR.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType == null || (onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_ANR)) == null) {
                        return null;
                    }
                    return onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback2;
                }
                if (!UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG.equals(str) || UMCrash.mUMCrashCallbackWithType == null || (onCallback = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_CUSTOM_LOG)) == null) {
                    return null;
                }
                return onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("source", 0);
                    jSONObject2.put("action_name", "page_view");
                    jSONObject2.put("action_page_state", UMCrash.isPage);
                    JSONArray jSONArray = new JSONArray();
                    for (int i10 = 0; i10 < UMCrash.mArrayList.size(); i10++) {
                        String str2 = (String) UMCrash.mArrayList.get(i10);
                        if (str2 != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", str2);
                            jSONArray.put(jSONObject3);
                        }
                    }
                    jSONObject2.put("action_parameter", jSONArray);
                    String jSONObject4 = jSONObject2.toString();
                    if (UMCrash.isDebug) {
                        String unused = UMCrash.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("page json is ");
                        sb.append(jSONObject4);
                    }
                    jSONObject.put(UMCrash.KEY_CALLBACK_PAGE_ACTION, jSONObject4);
                }
            } catch (Throwable unused2) {
            }
            try {
                jSONObject.put(UMCrash.KEY_CALLBACK_SESSION_ID, UMCrash.getSessionId(UMCrash.mContext));
                jSONObject.put(UMCrash.KEY_CALLBACK_CUSTOM_LOG, UAPMCustomLogManager.getCustomLogs());
                jSONObject.put(UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, InnerCustomMappingManager.getCustomMappingJsonStr());
                return jSONObject.toString();
            } catch (JSONException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public static class PaClientImpl implements IPaClient {
        private PaClientImpl() {
        }

        @Override // com.efs.sdk.pa.IPaClient
        public String onGetCallbackInfo(String str) {
            String onCallback;
            String str2 = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType != null) {
                        String onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_BLOCK);
                        if (onCallback2 == null) {
                            return null;
                        }
                        return onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback2;
                    }
                    if (UMCrash.mUMCrashCallback == null || (onCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback;
                }
                return null;
            }
            try {
                if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", 0);
                    jSONObject.put("action_name", "page_view");
                    jSONObject.put("action_page_state", UMCrash.isPage);
                    JSONArray jSONArray = new JSONArray();
                    for (int i10 = 0; i10 < UMCrash.mArrayList.size(); i10++) {
                        String str3 = (String) UMCrash.mArrayList.get(i10);
                        if (str3 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str3);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("action_parameter", jSONArray);
                    str2 = jSONObject.toString();
                    if (UMCrash.isDebug) {
                        String unused = UMCrash.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("page json is ");
                        sb.append(str2);
                    }
                }
            } catch (Throwable unused2) {
            }
            return str2;
        }
    }

    public static /* synthetic */ int access$1208() {
        int i10 = index;
        index = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$1210() {
        int i10 = index;
        index = i10 - 1;
        return i10;
    }

    public static void addCustomInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "addCustomInfo failed ! key or value is empty .");
            return;
        }
        if (sCustomInfo.containsKey(str)) {
            sCustomInfo.put(str, str2);
        } else if (sCustomInfo.size() >= 10) {
            Log.e(TAG, "addCustomInfo failed ! sCustomInfo is full with 10 limit.");
        } else {
            sCustomInfo.put(str, str2);
        }
        JSONObject jSONObject = new JSONObject(sCustomInfo);
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_custom_info", jSONObject.toString());
        }
    }

    @Deprecated
    public static void enableANRLog(boolean z10) {
        enableANRLog = z10;
    }

    public static void enableJavaScriptBridge(WebView webView) {
        enableJavaScriptBridge((View) webView);
    }

    public static void enableKillProcessAfterCrash(boolean z10) {
        sIsKillProcessAfterCrash = z10;
    }

    public static void enableLogBackup(boolean z10) {
        sIsEnableLogBackup = z10;
    }

    @Deprecated
    public static void enableMemoryMonitor(boolean z10) {
        UMMemoryMonitor.get().setEnable(z10);
    }

    @Deprecated
    public static void enableNativeLog(boolean z10) {
        enableNativeLog = z10;
    }

    public static void generateCustomLog(Throwable th, String str) {
        generateCustomLog(th, str, false, false);
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String getSessionId(Context context) {
        Class<DeviceConfig> cls;
        Method method;
        synchronized (UMCrash.class) {
            String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = DeviceConfig.class;
                String str2 = DeviceConfig.UNKNOW;
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getSid", Context.class);
                } catch (NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    public static String getUMAPMFlag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 0);
            jSONObject.put(AppMeasurement.CRASH_ORIGIN, 1);
            if (enableJavaLog) {
                jSONObject.put("crashJava", 1);
            } else {
                jSONObject.put("crashJava", 0);
            }
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put(LogType.ANR_TYPE, 1);
            } else {
                jSONObject.put(LogType.ANR_TYPE, 0);
            }
            if (isPA) {
                jSONObject.put("pa", 1);
            } else {
                jSONObject.put("pa", 0);
            }
            if (isLa) {
                jSONObject.put("la", 1);
            } else {
                jSONObject.put("la", 0);
            }
            if (UMMemoryMonitor.get().isEnable()) {
                jSONObject.put("mem", 1);
            } else {
                jSONObject.put("mem", 0);
            }
            if (isNet) {
                jSONObject.put("net", 1);
            } else {
                jSONObject.put("net", 0);
            }
            if (H5Manager.getH5ConfigMananger() == null || !H5Manager.getH5ConfigMananger().isH5TracerEnable()) {
                jSONObject.put(CastUtil.PLAT_TYPE_H5, 0);
            } else {
                jSONObject.put(CastUtil.PLAT_TYPE_H5, 1);
            }
            if (isOpenUserCrash) {
                jSONObject.put("crashUser", 1);
            } else {
                jSONObject.put("crashUser", 0);
            }
            if (isPage) {
                jSONObject.put("page", 1);
            } else {
                jSONObject.put("page", 0);
            }
            if (isPower) {
                jSONObject.put("power", 1);
            } else {
                jSONObject.put("power", 0);
            }
            if (isCodeLog) {
                jSONObject.put("codelog", 1);
            } else {
                jSONObject.put("codelog", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String getUMID(Context context) {
        Class<UMConfigure> cls;
        Method method;
        synchronized (UMCrash.class) {
            String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = UMConfigure.class;
                UMLog uMLog = UMConfigure.umDebugLog;
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getUMIDString", Context.class);
                } catch (NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    public static void init(final Context context, final String str, String str2) {
        if (context == null || str == null) {
            Log.e(TAG, "context is null or appkey is null, init failed.");
            return;
        }
        Log.e(TAG, "==================可接入免费的网络分析能力!!!===================\n============================详情见============================\nhttps://developer.umeng.com/docs/193624/detail/194590#h2-n5n-d0l-fmj");
        mContext = context;
        try {
            WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ImprintHandler.getImprintService(UMCrash.mContext).registImprintCallback(UMCrashContent.KEY_APM_CTR_FLAG, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.1.1
                            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                            public void onImprintValueChanged(String str3, String str4) {
                                try {
                                    if (TextUtils.isEmpty(str3) || !UMCrashContent.KEY_APM_CTR_FLAG.equals(str3)) {
                                        return;
                                    }
                                    if (UMCrash.isDebug) {
                                        String unused = UMCrash.TAG;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("common callback. apm ctr flag is ");
                                        sb.append(str4);
                                    }
                                    UMCrashUtils.saveInnerConfig(context.getApplicationContext(), str3, str4);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(UMCrash.mContext, UMCrashContent.KEY_APM_CTR_FLAG, "0");
                        if (UMCrash.isDebug) {
                            String unused = UMCrash.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("get common. apm ctr flag is ");
                            sb.append(imprintProperty);
                        }
                        if (imprintProperty == null || TextUtils.isEmpty(imprintProperty)) {
                            return;
                        }
                        UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.KEY_APM_CTR_FLAG, imprintProperty);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            int innerConfig = UMCrashUtils.getInnerConfig(mContext, UMCrashContent.KEY_APM_CTR_FLAG, 0);
            if (isDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("int apm. flag is ");
                sb.append(innerConfig);
            }
            if (innerConfig == -1) {
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            int innerConfig2 = UMCrashUtils.getInnerConfig(mContext, UMCrashContent.APM_STATE_HIT_WL, 0);
            if (isDebug) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("int apm. hitWlState is ");
                sb2.append(innerConfig2);
            }
            SamplingWhiteListUtil.setHitWL(innerConfig2 == 1);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        final SharedPreferences sharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, INTEGRATIONTESTING_SP);
        try {
            try {
                if (enableJavaLog) {
                    enableJavaLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, 100));
                }
                if (enableNativeLog) {
                    enableNativeLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, 100));
                }
                if (enableANRLog) {
                    enableANRLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, 100));
                }
                isOpenUserCrash = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, 100));
                if (UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, -1) == 0) {
                    isUploadNowUserCrash = true;
                } else {
                    isUploadNowUserCrash = false;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("mDebug", isDebug);
        bundle.putBoolean("mEncryptLog", isEncrypt);
        bundle.putBoolean("mZipLog", isZip);
        bundle.putBoolean("mEnableKillProcessAfterCrash", sIsKillProcessAfterCrash);
        bundle.putBoolean(KEY_ENABLE_CRASH_JAVA, enableJavaLog);
        bundle.putBoolean(KEY_ENABLE_CRASH_NATIVE, true);
        bundle.putBoolean(KEY_ENABLE_ANR, enableANRLog);
        if (sIsEnableLogBackup) {
            bundle.putBoolean("mBackupLogs", true);
            bundle.putString("mLogsBackupPathName", context.getApplicationInfo().dataDir + File.separator + "apm_backup_files");
        }
        if (isDebug) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("enable : java is ");
            sb3.append(enableJavaLog);
            sb3.append(", native is ");
            sb3.append(enableNativeLog);
            sb3.append(", anr is ");
            sb3.append(enableANRLog);
        }
        bundle.putBoolean(KEY_ENABLE_CRASH_UNEXP, false);
        bundle.putBoolean("mIsInternational", isIntl);
        bundle.putBoolean("mDumpUserSolibBuildId", isBuildId);
        if (isIntl) {
            bundle.putString("mCrashLogUploadUrl", "https://errnewlogos.umeng.com/upload");
            bundle.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            bundle.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            boolean z10 = isDebug;
        } else {
            bundle.putString("mCrashLogUploadUrl", "https://errnewlog.umeng.com/upload");
            bundle.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL);
            bundle.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL);
            boolean z11 = isDebug;
        }
        final CrashApi createInstanceEx = CrashApi.createInstanceEx(context, str, isDebug, bundle, new CrashClientImpl());
        try {
            if (createInstanceEx != null) {
                createInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
                createInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                createInstanceEx.addHeaderInfo(KEY_HEADER_OS, "android");
                createInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                createInstanceEx.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
                try {
                    String[] activeUser = UMCrashUtils.getActiveUser(context);
                    if (activeUser != null && activeUser.length == 2) {
                        createInstanceEx.addHeaderInfo(KEY_HEADER_PUID, activeUser[1]);
                        createInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, activeUser[0]);
                    }
                } catch (Throwable unused2) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PUID, "");
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, "");
                }
                createInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                if (!TextUtils.isEmpty(userBver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
                try {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, "" + NetworkUtil.getNetworkTypeUmeng(context));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    if (UMCrashUtils.isHarmony(context)) {
                        createInstanceEx.addHeaderInfo("others_OS", "harmony");
                    } else {
                        createInstanceEx.addHeaderInfo("others_OS", "Android");
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                registerInfoCallback(createInstanceEx);
                if (context instanceof Application) {
                    ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.2
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityCreated(Activity activity, Bundle bundle2) {
                            Intent intent;
                            Uri data;
                            String scheme;
                            long j10;
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_CREATED);
                            if (UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty()) {
                                return;
                            }
                            if (scheme.contains("um." + str)) {
                                Set<String> queryParameterNames = data.getQueryParameterNames();
                                if (queryParameterNames.contains(UMCrash.IT_DEBUGKEY) && queryParameterNames.contains(UMCrash.IT_SENDAGING)) {
                                    String queryParameter = data.getQueryParameter(UMCrash.IT_DEBUGKEY);
                                    try {
                                        j10 = Long.parseLong(data.getQueryParameter(UMCrash.IT_SENDAGING));
                                    } catch (NumberFormatException unused3) {
                                        j10 = 0;
                                    }
                                    if (j10 < 0) {
                                        sharedPreferences.edit().clear().apply();
                                        IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                                        return;
                                    }
                                    if (j10 > 6) {
                                        j10 = 6;
                                    }
                                    sharedPreferences.edit().putString("debugkey", queryParameter).apply();
                                    sharedPreferences.edit().putLong(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis() + (j10 * 60 * 60 * 1000)).apply();
                                    UMCrashUtils.setIntegrationTesingParams(queryParameter);
                                    IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                                }
                            }
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_DESTROYED);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPaused(Activity activity) {
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_PAUSED);
                            UMCrash.access$1210();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityResumed(Activity activity) {
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_RESUMED);
                            UMMemoryMonitor.get().onActivityResumed(activity);
                            PowerManager.onActivityResumed(activity);
                            UMCrash.access$1208();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STARTED);
                            UMMemoryMonitor.get().onActivityStarted(activity);
                            PowerManager.onActivityStarted(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                            UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STOPPED);
                            UMMemoryMonitor.get().onActivityStopped(activity);
                            PowerManager.onActivityStopped(activity);
                        }
                    });
                } else {
                    Log.e(TAG, "context not instanceof application.");
                }
                try {
                    WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(context);
                                if ("Wi-Fi".equals(networkAccessMode[0])) {
                                    createInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, "wifi");
                                } else if ("2G/3G".equals(networkAccessMode[0])) {
                                    createInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                                } else {
                                    createInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, "unknow");
                                }
                                if ("".equals(networkAccessMode[1])) {
                                    return;
                                }
                                createInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                    });
                } catch (Throwable th7) {
                    th7.printStackTrace();
                }
            } else {
                Log.e(TAG, "create CrashAPI is null.");
            }
        } catch (Throwable unused3) {
        }
        try {
            int innerConfig3 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, -1);
            if (isDebug) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("inner config : code log rate is ");
                sb4.append(innerConfig3);
            }
            if (innerConfig3 == 0) {
                boolean z12 = isDebug;
            } else if (innerConfig3 == 100) {
                boolean z13 = isDebug;
                if (enableCodeLog) {
                    if (TextUtils.isEmpty(ULogManager.getDeviceID())) {
                        String uMId = UMUtils.getUMId(mContext);
                        if (isDebug) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("inner config : code log set umid is ");
                            sb5.append(uMId);
                        }
                        ULogManager.setDeviceID(uMId);
                    }
                    isCodeLog = true;
                }
            }
            if (isDebug) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("enable codeLog is ");
                sb6.append(isCodeLog);
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
        try {
            initReporter(context, str, str2);
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
        try {
            String string = sharedPreferences.getString("debugkey", "");
            if (sharedPreferences.getLong(SP_KEY_TIMESTAMP, 0L) - System.currentTimeMillis() < 0 || TextUtils.isEmpty(string)) {
                sharedPreferences.edit().clear().apply();
                IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
            } else {
                IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                UMCrashUtils.setIntegrationTesingParams(string);
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
        }
        try {
            if (enablePaLog) {
                WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PAFactory.Builder builder = new PAFactory.Builder(context.getApplicationContext(), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.4.1
                                @Override // com.efs.sdk.pa.config.IEfsReporter
                                public EfsReporter getReporter() {
                                    return UMCrash.sReporter;
                                }
                            });
                            builder.packageLevel(PackageLevel.RELEASE);
                            builder.timeoutTime(UMCrash.paTimeoutTime);
                            builder.setPaClient(new PaClientImpl());
                            PAFactory build = builder.build();
                            build.getPaInstance().start();
                            boolean unused4 = UMCrash.isPA = build.getConfigManager().enableTracer();
                        } catch (Throwable th11) {
                            th11.printStackTrace();
                        }
                    }
                });
            } else if (isDebug) {
                Log.e(TAG, "enablePaLog is false");
            }
        } catch (Throwable th11) {
            th11.printStackTrace();
        }
        try {
            if (enableLaunchLog) {
                LaunchManager.init(context, sReporter);
                try {
                    if (LaunchManager.getLaunchConfigManager() != null) {
                        isLa = LaunchManager.getLaunchConfigManager().enableTracer();
                    }
                } catch (Throwable th12) {
                    th12.printStackTrace();
                }
                String uMId2 = UMUtils.getUMId(context);
                if (uMId2 == null || TextUtils.isEmpty(uMId2)) {
                    boolean z14 = isDebug;
                    ImprintHandler.getImprintService(context).registImprintCallback(bt.f10046g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.5
                        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                        public void onImprintValueChanged(String str3, String str4) {
                            if (UMCrash.isDebug) {
                                String unused4 = UMCrash.TAG;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("common callback.  key is ");
                                sb7.append(str3);
                                sb7.append("; value is ");
                                sb7.append(str4);
                            }
                            try {
                                if (bt.f10046g.equals(str3)) {
                                    LaunchManager.sendLaunchCache(context, str4);
                                    ImprintHandler.getImprintService(context).unregistImprintCallback(bt.f10046g, this);
                                }
                            } catch (Throwable th13) {
                                th13.printStackTrace();
                            }
                        }
                    });
                }
            } else if (isDebug) {
                Log.e(TAG, "enableLaunchLog is false");
            }
        } catch (Throwable th13) {
            th13.printStackTrace();
        }
        try {
            if (enableMemLog) {
                UMMemoryMonitor.get().start(context, sReporter);
            } else if (isDebug) {
                Log.e(TAG, "enableMemLog is false");
            }
        } catch (Throwable th14) {
            th14.printStackTrace();
        }
        try {
            int innerConfig4 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, -1);
            if (isDebug) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("inner config : net rate is ");
                sb7.append(innerConfig4);
            }
            if (innerConfig4 == 0) {
                boolean z15 = isDebug;
            } else if (innerConfig4 == 100) {
                boolean z16 = isDebug;
                if (enableNetLog) {
                    NetManager.init(context, sReporter);
                    try {
                        if (NetManager.getNetConfigManager() != null) {
                            isNet = NetManager.getNetConfigManager().enableTracer();
                            int innerConfig5 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET_REQUEST_BODY, -1);
                            if (isDebug) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("inner config : net reqBody rate is ");
                                sb8.append(innerConfig5);
                            }
                            if (innerConfig5 == 100) {
                                boolean z17 = isDebug;
                                NetManager.getNetConfigManager().setNetRequestBodyCollectState(true);
                            } else if (innerConfig5 == 0) {
                                boolean z18 = isDebug;
                            }
                        }
                    } catch (Throwable th15) {
                        th15.printStackTrace();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableNetLog is false");
                }
            }
        } catch (Throwable th16) {
            th16.printStackTrace();
        }
        try {
            int innerConfig6 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, -1);
            if (isDebug) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("inner config : nativeH5Rate is ");
                sb9.append(innerConfig6);
            }
            if (innerConfig6 == 0) {
                boolean z19 = isDebug;
            } else if (innerConfig6 == 100) {
                boolean z20 = isDebug;
                if (enableH5PageLog) {
                    H5Manager.init(context, sReporter);
                } else if (isDebug) {
                    Log.e(TAG, "enableH5PageLog is false");
                }
            }
        } catch (Throwable th17) {
            th17.printStackTrace();
        }
        try {
            int innerConfig7 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, -1);
            if (isDebug) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append("inner config : page rate is ");
                sb10.append(innerConfig7);
            }
            if (innerConfig7 == 0) {
                boolean z21 = isDebug;
            } else if (innerConfig7 == 100) {
                boolean z22 = isDebug;
                if (enablePageLog) {
                    PageManger.init(mContext, sReporter);
                    try {
                        if (PageManger.getPageConfigManger() != null) {
                            isPage = PageManger.getPageConfigManger().enableTracer();
                        }
                    } catch (Throwable th18) {
                        th18.printStackTrace();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enablePageLog is false");
                }
            }
        } catch (Throwable th19) {
            th19.printStackTrace();
        }
        try {
            int innerConfig8 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, -1);
            if (isDebug) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("inner config : power rate is ");
                sb11.append(innerConfig8);
            }
            if (innerConfig8 == 0) {
                boolean z23 = isDebug;
            } else if (innerConfig8 == 100) {
                boolean z24 = isDebug;
                if (enablePowerLog) {
                    PowerManager.init(mContext, sReporter);
                    try {
                        if (PowerManager.getPowerConfigManager() != null) {
                            isPower = PowerManager.getPowerConfigManager().enableTracer();
                        }
                    } catch (Throwable th20) {
                        th20.printStackTrace();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enablePowerLog is false");
                }
            }
        } catch (Throwable th21) {
            th21.printStackTrace();
        }
        try {
            int innerConfig9 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, -1);
            if (isDebug) {
                StringBuilder sb12 = new StringBuilder();
                sb12.append("inner config : flutter rate is ");
                sb12.append(innerConfig9);
            }
            if (innerConfig9 == 0) {
                boolean z25 = isDebug;
            } else if (innerConfig9 == 100) {
                boolean z26 = isDebug;
                if (enableFlutterLog) {
                    FlutterManager.init(mContext, sReporter);
                    try {
                        if (FlutterManager.getFlutterConfigManager() != null) {
                            isFlutter = FlutterManager.getFlutterConfigManager().isFlutterEnable();
                        }
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableFlutterLog is false");
                }
            }
        } catch (Throwable th23) {
            th23.printStackTrace();
        }
        try {
            sApmCallbackLimit = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, -1);
            if (isDebug) {
                StringBuilder sb13 = new StringBuilder();
                sb13.append("inner config : callback limit is ");
                sb13.append(sApmCallbackLimit);
            }
        } catch (Throwable th24) {
            th24.printStackTrace();
        }
        if (isCodeLog) {
            ULogManager.init(mContext, sReporter);
        }
    }

    public static void initConfig(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = bundle.getLong(KEY_PA_TIMEOUT_TIME, DEFAULT_PA_TIMEOUT_TIME);
            if (bundle.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
            try {
                if (bundle.getBoolean(KEY_ENABLE_CODE_LOG, true)) {
                    enableCodeLog = true;
                } else {
                    enableCodeLog = false;
                }
                ULogManager.setUserID(bundle.getString(KEY_LOG_USER_ID, ""));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (bundle.getBoolean(KEY_ENABLE_POWER, true)) {
                enablePowerLog = true;
            } else {
                enablePowerLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_FLUTTER, true)) {
                enableFlutterLog = true;
            } else {
                enableFlutterLog = false;
            }
        }
    }

    private static void initReporter(final Context context, String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(KEY_HEADER_UMID, getUMID(context));
        hashMap.put(KEY_HEADER_CHANNEL, str2);
        hashMap.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        hashMap.put(KEY_HEADER_OS, "android");
        hashMap.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] activeUser = UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                hashMap.put(KEY_HEADER_PUID, activeUser[1]);
                hashMap.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (Throwable unused) {
            hashMap.put(KEY_HEADER_PUID, "");
            hashMap.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            hashMap.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            hashMap.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (UMCrashUtils.isHarmony(context)) {
                hashMap.put("others_OS", "harmony");
            } else {
                hashMap.put("others_OS", "Android");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EfsReporter build = new EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).enablePaBackup(sIsEnableLogBackup).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).logUid(ULogManager.getUserID()).logDid(ULogManager.getDeviceID()).setOpenCodeLog(isCodeLog).build();
        sReporter = build;
        build.addPublicParams(hashMap);
        try {
            if (isCodeLog) {
                sReporter.setFileFilterCodeLog(new UploadFileFilterCodeLog());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_CODE_LOG, UMCrashContent.APM_STATE_HIT_WL, UMCrashContent.APM_STATE_FLUTTER, UMCrashContent.APM_STATE_POWER, UMCrashContent.APM_STATE_PAGE, UMCrashContent.APM_STATE_NET, UMCrashContent.APM_STATE_NET_REQUEST_BODY, UMCrashContent.APM_STATE_NATIVE_H5, UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_MAX_COUNT, UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, UMCrashContent.APM_CALLBACK_LIMIT}, new IConfigCallback() { // from class: com.umeng.umcrash.UMCrash.6
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public void onChange(Map<String, Object> map) {
                    try {
                        Object obj = map.get(UMCrashContent.APM_STATE_NET);
                        if (obj != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("callback netRate is ");
                                sb.append(obj.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, obj);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    try {
                        Object obj2 = map.get(UMCrashContent.APM_STATE_NET_REQUEST_BODY);
                        if (obj2 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("callback netReqBodyRate is ");
                                sb2.append(obj2.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET_REQUEST_BODY, obj2);
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        Object obj3 = map.get(UMCrashContent.APM_STATE_NATIVE_H5);
                        if (obj3 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("callback nativeH5Rate is ");
                                sb3.append(obj3.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, obj3);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        UMCrash.saveLocalCrashSampling(context, map);
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    try {
                        UMCrash.updateLocalCrashConfig(context, map);
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                    try {
                        Object obj4 = map.get(UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE);
                        if (obj4 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("callback uploadType is ");
                                sb4.append(obj4.toString());
                            }
                            if (Integer.valueOf(obj4.toString()).intValue() == 0) {
                                boolean unused2 = UMCrash.isUploadNowUserCrash = true;
                            } else {
                                boolean unused3 = UMCrash.isUploadNowUserCrash = false;
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, obj4);
                        }
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                    try {
                        Object obj5 = map.get(UMCrashContent.APM_STATE_PAGE);
                        if (obj5 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("callback pageRate is ");
                                sb5.append(obj5.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, obj5);
                        }
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                    try {
                        Object obj6 = map.get(UMCrashContent.APM_STATE_CODE_LOG);
                        if (obj6 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("callback codeLogRate is ");
                                sb6.append(obj6.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, obj6);
                        }
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                    }
                    try {
                        Object obj7 = map.get(UMCrashContent.APM_STATE_POWER);
                        if (obj7 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("callback powerRate is ");
                                sb7.append(obj7);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, obj7);
                        }
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                    try {
                        Object obj8 = map.get(UMCrashContent.APM_STATE_HIT_WL);
                        if (obj8 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("callback hitwl is ");
                                sb8.append(obj8);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_HIT_WL, obj8);
                        }
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                    try {
                        Object obj9 = map.get(UMCrashContent.APM_STATE_FLUTTER);
                        if (obj9 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("callback flutterRate is ");
                                sb9.append(obj9);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, obj9);
                        }
                    } catch (Throwable th13) {
                        th13.printStackTrace();
                    }
                    try {
                        Object obj10 = map.get(UMCrashContent.APM_CALLBACK_LIMIT);
                        if (obj10 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("callback callbackLimit is ");
                                sb10.append(obj10);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, obj10);
                        }
                    } catch (Throwable th14) {
                        th14.printStackTrace();
                    }
                }
            });
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void isBuildId(boolean z10) {
        isBuildId = z10;
    }

    private static void registerInfoCallback(CrashApi crashApi) {
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_JAVA, 16);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_NATIVE, 1);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_ANR, LogType.ANR);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_CUSTOM_LOG, 256);
        crashApi.registerInfoCallback(KEY_CALLBACK_UM_INFOS, IAPI.OPTION_11);
        crashApi.registerInfoCallback(KEY_CALLBACK_UMID, IAPI.OPTION_11);
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        EfsReporter.registerPerfCallback(iUMPerfCallback);
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback == null) {
            Log.e(TAG, "callback error.");
            return;
        }
        mUMCrashCallback = uMCrashCallback;
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, IAPI.OPTION_11);
        } else {
            Log.e(TAG, "callback error, instance is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveActivityState(String str, String str2) {
        try {
            ArrayList<String> arrayList = mArrayList;
            if (arrayList != null) {
                if (arrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                mArrayList.add(str + Operator.Operation.MINUS + System.currentTimeMillis() + Operator.Operation.MINUS + str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalCrashSampling(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Object obj = map.get(UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
        if (obj != null) {
            if (isDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("callback crashJavaSampling is ");
                sb.append(obj.toString());
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, obj);
        }
        Object obj2 = map.get(UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj2 != null) {
            if (isDebug) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("callback crashNativeSampling is ");
                sb2.append(obj2.toString());
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, obj2);
        }
        Object obj3 = map.get(UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
        if (obj3 != null) {
            if (isDebug) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("callback crashANRSampling is ");
                sb3.append(obj3.toString());
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, obj3);
        }
        Object obj4 = map.get(UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
        if (obj4 != null) {
            if (isDebug) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("callback crashUserSampling is ");
                sb4.append(obj4.toString());
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, obj4);
        }
    }

    public static void setAppVersion(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.trim().getBytes().length > 128) {
                    str = UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            } else if (isDebug) {
                Log.e(TAG, "version is null or empty !");
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.trim().getBytes().length > 128) {
                    str2 = UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            } else if (isDebug) {
                Log.e(TAG, "sub version is null or empty !");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.trim().getBytes().length > 128) {
                    str3 = UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            } else if (isDebug) {
                Log.e(TAG, "build id is null or empty !");
            }
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else if (isDebug) {
                Log.e(TAG, "set app version. crashApi is null");
            }
            HashMap hashMap = new HashMap(1);
            if (!TextUtils.isEmpty(userBver)) {
                hashMap.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                hashMap.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            EfsReporter efsReporter = sReporter;
            if (efsReporter != null) {
                efsReporter.addPublicParams(hashMap);
            } else if (isDebug) {
                Log.e(TAG, "set app version.  sReporter is null");
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (TextUtils.isEmpty(userBesrial)) {
                return;
            }
            UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z10) {
        isDebug = z10;
        LaunchManager.isDebug = z10;
        H5Manager.isDebug = z10;
        PageManger.isDebug = z10;
        PowerManager.isDebug = z10;
        ULogManager.isDebug = z10;
    }

    public static void setPaTimeoutTime(long j10) {
        paTimeoutTime = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocalCrashConfig(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Bundle bundle = new Bundle();
        Object obj = map.get(UMCrashContent.APM_CRASH_USER_MAX_COUNT);
        if (obj != null) {
            if (isDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("callback crashMaxUserCount is ");
                sb.append(obj.toString());
            }
            bundle.putInt("mMaxCustomLogCountPerTypePerDay", Integer.valueOf(obj.toString()).intValue());
            bundle.putInt("mMaxUploadCustomLogCountPerDay", Integer.valueOf(obj.toString()).intValue());
        }
        CrashApi.getInstance().updateCustomInfo(bundle);
    }

    private static void updateLocalCrashSampling(Object obj, Object obj2, Object obj3, Object obj4) {
        CrashApi crashApi = CrashApi.getInstance();
        if (crashApi != null) {
            if (obj != null && UMCrashUtils.random(Integer.valueOf(obj.toString()).intValue())) {
                crashApi.disableLog(16);
            }
            if (obj2 != null && UMCrashUtils.random(Integer.valueOf(obj2.toString()).intValue())) {
                crashApi.disableLog(1);
            }
            if (obj3 != null && UMCrashUtils.random(Integer.valueOf(obj3.toString()).intValue())) {
                crashApi.disableLog(LogType.ANR);
            }
            if (obj4 == null || !UMCrashUtils.random(Integer.valueOf(obj4.toString()).intValue())) {
                return;
            }
            isOpenUserCrash = false;
        }
    }

    private static void useIntlServices(boolean z10) {
        isIntl = z10;
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("useIntlServices is ");
            sb.append(isIntl);
        }
    }

    public static void enableJavaScriptBridge(View view) {
        try {
            H5Manager.setWebView(view);
        } catch (Throwable unused) {
        }
    }

    public static void generateCustomLog(Throwable th, String str, boolean z10, boolean z11) {
        generateCustomLog(th, str, (String) null, z10, z11);
    }

    public static void generateCustomLog(final Throwable th, final String str, final String str2, final boolean z10, final boolean z11) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
        } else if (th != null && !TextUtils.isEmpty(str)) {
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.umeng.umcrash.UMCrash.7
                @Override // java.lang.Runnable
                public void run() {
                    CustomLogInfo build;
                    try {
                        UMCustomLogInfoBuilder addLogCat = new UMCustomLogInfoBuilder(str).stack(th, str2).addLogCat(z10);
                        if (z11) {
                            StringBuilder sb = new StringBuilder("AllThreadsTraces: \n");
                            for (Map.Entry<String, String> entry : UMCrashUtil.getAllThreadTraces().entrySet()) {
                                sb.append(entry.getKey());
                                sb.append("\n");
                                sb.append(entry.getValue());
                                sb.append("\n");
                            }
                            build = addLogCat.addSection(sb.toString()).build();
                        } else {
                            build = addLogCat.build();
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                        arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                        build.mCallbacks = arrayList;
                        String unused = UMCrash.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("upload is ");
                        sb2.append(UMCrash.isUploadNowUserCrash);
                        build.mUploadNow = UMCrash.isUploadNowUserCrash;
                        CrashApi crashApi = CrashApi.getInstance();
                        if (crashApi == null) {
                            Log.e(UMCrash.TAG, "CrashApi is null, not init .");
                        } else {
                            crashApi.generateCustomLog(build);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        }
    }

    public static void registerUMCrashCallback(IUMCrashCallbackWithType iUMCrashCallbackWithType) {
        if (iUMCrashCallbackWithType != null) {
            mUMCrashCallbackWithType = iUMCrashCallbackWithType;
        } else {
            Log.e(TAG, "callback error.");
        }
    }

    public static void generateCustomLog(String str, String str2) {
        generateCustomLog(str, str2, false, false);
    }

    public static void generateCustomLog(String str, String str2, boolean z10, boolean z11) {
        generateCustomLog(str, str2, (String) null, z10, z11);
    }

    public static void generateCustomLog(final String str, final String str2, final String str3, final boolean z10, final boolean z11) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.umeng.umcrash.UMCrash.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CustomLogInfo customLogInfo = new CustomLogInfo(null, "exception");
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                        arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                        customLogInfo.mCallbacks = arrayList;
                        String unused = UMCrash.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("upload is ");
                        sb.append(UMCrash.isUploadNowUserCrash);
                        customLogInfo.mUploadNow = UMCrash.isUploadNowUserCrash;
                        customLogInfo.mAddLogcat = z10;
                        HashMap hashMap = new HashMap(20);
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str2);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append(SOAP.DELIM);
                            stringBuffer.append((String) entry.getValue());
                            stringBuffer.append("\n");
                        }
                        String str4 = str3;
                        if (str4 == null) {
                            str4 = "";
                        }
                        String str5 = "Exception message:" + str4 + "\nBack traces starts.\n" + str + "\nBack traces ends.";
                        if (!TextUtils.isEmpty(str5)) {
                            stringBuffer.append(str5);
                            stringBuffer.append("\n");
                        }
                        if (z11) {
                            Map<String, String> allThreadTraces = UMCrashUtil.getAllThreadTraces();
                            stringBuffer.append(UMCustomLogInfoBuilder.LOG_SECTION_SEP);
                            stringBuffer.append("\n");
                            stringBuffer.append("AllThreadsTraces: \n");
                            for (Map.Entry<String, String> entry2 : allThreadTraces.entrySet()) {
                                stringBuffer.append(entry2.getKey());
                                stringBuffer.append("\n");
                                stringBuffer.append(entry2.getValue());
                                stringBuffer.append("\n");
                            }
                        }
                        customLogInfo.mData = stringBuffer;
                        CrashApi crashApi = CrashApi.getInstance();
                        if (crashApi == null) {
                            Log.e(UMCrash.TAG, "CrashApi is null, not init .");
                        } else {
                            crashApi.generateCustomLog(customLogInfo);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        }
    }
}
