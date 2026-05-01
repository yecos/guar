package com.hpplay.sdk.source.common.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class Preference {
    public static final String KEY_AUTH_FAIL_TIME = "auth_fail_time";
    public static final String KEY_DA_CONNECT_TIMEOUT = "da_connect_timeout";
    public static final String KEY_DA_RETRY_COUNT = "da_retry_count";
    public static final String KEY_DEVICE_ID = "key_device_id";
    public static final String KEY_ENABLE_LOG = "key_enable_log";
    public static final String KEY_ENCODE_ERROR_EXIT_MIRROR = "key_encode_error_exit_mirror";

    @Deprecated
    private static final String KEY_IMSERVER_IP = "ImServer";
    public static final String KEY_LB_FAKE_AID = "key_lb_ai";
    public static final String KEY_LICENSE = "key_lcs_data";
    public static final String KEY_LICENSE_TSN = "key_license_tsn";

    @Deprecated
    private static final String KEY_LOCAL_SERVICE_CONFIG = "key_local_service_config";

    @Deprecated
    private static final String KEY_LOGOIN_PARAMS = "key_login_params";

    @Deprecated
    private static final String KEY_LOGOIN_PARAMS_TIME = "key_login_params_time";
    public static final String KEY_LOG_DIR = "key_log_dir";
    public static final String KEY_MIRROR_FPS = "key_mirror_fps";
    public static final String KEY_MIRROR_SECRET_SWITCH = "mirror_secret_switch";
    public static final String KEY_MIRROR_WATERMARK_OBJ_JSON_STR = "mirror_watermark_obj_json_str";
    public static final String KEY_MIRROR_WATERMARK_SWITCH = "mirror_watermark_switch";
    public static final String KEY_MULTI_CHANNEL = "key_multi_channel";
    public static final String KEY_PERMISSION_MODE = "key_permission_mode";
    public static final String KEY_REPEAT_INFO = "repeat_info";
    public static final String KEY_SDK_AUTH_DISABLE = "key_sdk_auth_disable";
    public static final String KEY_SDK_AUTH_TIME = "key_sdk_auth_time";
    public static final String KEY_SDK_AUTH_URL = "key_sdk_auth_url";
    public static final String KEY_SDK_CONFIG = "key_sdk_config";
    public static final String KEY_SDK_LOGIN_TIME = "key_sdk_login_time";
    public static final String KEY_SDK_SERVER_LIST = "sdk_server_list";
    public static final String KEY_SDK_SWITCH = "sdk_switch";
    public static final String KEY_SDK_VERIFY = "sdk_verify";
    public static final String KEY_SDK_VERIFY_SUCCESSFUL = "sdk_verify_successful";

    @Deprecated
    private static final String KEY_SERVER_HID = "server_hid";

    @Deprecated
    private static final String KEY_SERVER_UID = "server_uid";

    @Deprecated
    private static final String KEY_SWITCH_VER = "switch_ver";
    private static final String TAG = "Preference";
    private static Preference mPreference;
    private SharedPreferences mPref;

    private Preference(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPref = defaultSharedPreferences;
        defaultSharedPreferences.edit().remove(KEY_IMSERVER_IP).apply();
        this.mPref.edit().remove(KEY_LOGOIN_PARAMS).apply();
        this.mPref.edit().remove(KEY_LOGOIN_PARAMS_TIME).apply();
        this.mPref.edit().remove(KEY_SERVER_UID).apply();
        this.mPref.edit().remove(KEY_SERVER_HID).apply();
        this.mPref.edit().remove(KEY_SWITCH_VER).apply();
        this.mPref.edit().remove(KEY_LOCAL_SERVICE_CONFIG).apply();
    }

    public static synchronized Preference getInstance() {
        Preference preference;
        synchronized (Preference.class) {
            if (mPreference == null) {
                initPreference(HapplayUtils.getApplication());
            }
            preference = mPreference;
        }
        return preference;
    }

    public static Preference initPreference(Context context) {
        SourceLog.i(TAG, "Preference initPreference");
        if (mPreference == null) {
            mPreference = new Preference(context);
        }
        return mPreference;
    }

    public boolean get(String str, boolean z10) {
        return this.mPref.getBoolean(str, z10);
    }

    public void put(String str, boolean z10) {
        this.mPref.edit().putBoolean(str, z10).apply();
    }

    public int get(String str, int i10) {
        return this.mPref.getInt(str, i10);
    }

    public void put(String str, int i10) {
        this.mPref.edit().putInt(str, i10).apply();
    }

    public float get(String str, float f10) {
        return this.mPref.getFloat(str, f10);
    }

    public void put(String str, float f10) {
        this.mPref.edit().putFloat(str, f10).apply();
    }

    public long get(String str, long j10) {
        return this.mPref.getLong(str, j10);
    }

    public void put(String str, long j10) {
        this.mPref.edit().putLong(str, j10).apply();
    }

    public String get(String str) {
        return get(str, (String) null);
    }

    public void put(String str, String str2) {
        this.mPref.edit().putString(str, str2).apply();
    }

    public String get(String str, String str2) {
        return this.mPref.getString(str, str2);
    }
}
