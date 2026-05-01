package com.hpplay.component.common;

import com.hpplay.component.common.utils.CLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ParamsMap extends ConcurrentHashMap {
    private static final String TAG = "ParamsMap";
    public static final int TYPE_DLNA = 3;
    public static final int TYPE_IM = 4;
    public static final int TYPE_LELINK = 1;
    public static final int TYPE_LELINK_V2 = 5;
    public static final int TYPE_LELINK_V3 = 10;

    public interface ConnectParams {
        public static final int ERROR_CODE_DLNA = 120102103;
        public static final int ERROR_CODE_LELINK = 120102101;
        public static final int ERROR_CODE_LELINK_V2 = 120102102;
        public static final String KEY_CONNECT_JSON = "cjson";
        public static final String KEY_CONNECT_SUPPORT = "connect_support";
        public static final String KEY_CONNECT_TIMEOUT = "connect_timeout";
        public static final String KEY_ERRCODE = "errCode";
        public static final String KEY_ERRMSG = "errMsg";
        public static final String KEY_KEEP_ALIVE_INTERVAL = "keep_alive_interval";
        public static final String KEY_KEEP_ALIVE_TIMEOUT = "keep_alive_timeout";
    }

    public interface DeviceParams {
        public static final String KEY_AIRPLAY_PORT = "airplay_port";
        public static final String KEY_APPID = "appid";
        public static final String KEY_APPSECRET = "secret";
        public static final String KEY_ATV = "atv";
        public static final String KEY_AUTH_TOKEN = "token";
        public static final String KEY_CHANNEL_VERSION = "channel_version";
        public static final String KEY_CONNECT_SESSION_ID = "connectSessionId";
        public static final String KEY_HID = "hid";
        public static final String KEY_HTV = "htv";
        public static final String KEY_IMEI = "imei";
        public static final String KEY_IP = "ip";
        public static final String KEY_LELINK_PORT = "lelink_port";
        public static final String KEY_MAC = "mac";
        public static final String KEY_MIRROR_PORT = "mirror_port";
        public static final String KEY_NEW_LELINK_VV = "2";
        public static final String KEY_PORT = "port";
        public static final String KEY_RAOP_PORT = "raop_port";
        public static final String KEY_RECEIVER_UID = "ruid";
        public static final String KEY_SESSION_ID = "sessionId";
        public static final String KEY_SINK_NAME = "sink_name";
        public static final String KEY_UID = "uid";
        public static final String KEY_VV = "vv";
    }

    public interface IMParams {
        public static final String COMMAND_CONNECT = "020005ff";
        public static final String COMMAND_GET_TV_INFO = "020008ff";
        public static final String COMMAND_MIRROR = "020002ff";
        public static final long COMMAND_PASSTHROGHT = 33560575;
        public static final String COMMAND_PLAY_CONTROL = "020004ff";
        public static final String COMMAND_PLAY_STATE = "020003ff";
        public static final String COMMAND_PUSH = "020001ff";
        public static final int CONNECT_CONFRENCE_CHECK_LAN = 212017;
        public static final int CONNECT_ERROR_BAD_REQUEST = 212016;
        public static final int CONNECT_ERROR_FAILED = 212010;
        public static final int CONNECT_ERROR_IM_BLACKLIST = 212015;
        public static final int CONNECT_ERROR_IM_DEV_OFFLINE = 212018;
        public static final int CONNECT_ERROR_IM_REJECT = 212013;
        public static final int CONNECT_ERROR_IM_TIMEOUT = 212014;
        public static final int CONNECT_ERROR_IM_WAITTING = 212012;
        public static final int CONNECT_ERROR_IO = 212011;
        public static final int CONNECT_PINCODE_ERROR = 212019;
        public static final int CONNECT_REQUEST_FAILED = 212018;
        public static final String KEY_CLOUD_MIRROR_MF = "cm_manufacturer";
        public static final String KEY_DEVICE_NAME = "dev_name";
        public static final String KEY_GLSB_URL = "gslb";
        public static final String KEY_IM_SERVER_PORT = "im_server_port";
        public static final long KEY_LOG_REPORT = 33566975;
        public static final String KEY_MDNS_IP = "mdnsip";
        public static final long KEY_RECEIVE_CONNECT_IM = 33556479;
        public static final int KEY_RECEIVE_CONNECT_STATE = 100001;
        public static final long KEY_RECEIVE_CORRELATION_AD = 33559295;
        public static final long KEY_RECEIVE_PLAY_STATE = 33555455;
        public static final int KEY_RECEIVE_RECONNECT = 100000;
        public static final String KEY_SDK_VERSION_CODE = "im_sdk_version";
        public static final String KEY_WIFI_BSSID = "b_ssid";
        public static final int STATE_CONNECT_ALLOW = 2;
        public static final int STATE_CONNECT_FAILED = 4;
        public static final int STATE_CONNECT_REJECT = 3;
        public static final int STATE_CONNECT_WAITING = 1;
        public static final int STATE_DETAIL_DEFAULT = 0;
        public static final int STATE_DETAIL_IN_LIST = 3;
        public static final int STATE_DETAIL_MANUAL = 2;
        public static final int STATE_DETAIL_TIMEOUT = 1;
    }

    public interface MirrorParams {
        public static final int AUDIO_TYPE_AAC = 1;
        public static final int AUDIO_TYPE_PCM = 0;
        public static final int CAPTRUESOURCE_FLAG_MIUI = -2147483647;
        public static final String ENCODE_TYPE_H264 = "video/avc";
        public static final String ENCODE_TYPE_H265 = "video/hevc";
        public static final String ENCODE_TYPE_RGB = "RGB";
        public static final String ENCODE_TYPE_VP8 = "video/x-vnd.on2.vp8";
        public static final String ENCODE_TYPE_VP9 = "video/x-vnd.on2.vp9";
        public static final String ENCODE_TYPE_YUV_I420 = "yuv_i420";
        public static final String KEY_AUTO_BITRATE = "auto_bitrate";
        public static final String KEY_ENCODE_TYPE = "encode_type";
        public static final String KEY_ERRCODE = "errCode";
        public static final String KEY_ERRMSG = "errMsg";
        public static final String KEY_EXTERNAL_VIDEO = "is_external_video";
        public static final int KEY_FRAME_TYPE_EXTERNAL = 100;
        public static final String KEY_MIRROR_AUDIO = "mirror_audio";
        public static final String KEY_MIRROR_RECONNECT_COUNT = "reconnect_count";
        public static final String KEY_MIRROR_SCREEN_CODE = "screencode";
        public static final String KEY_MIRROR_URI = "uri";
        public static final String KEY_NOTIFICTION = "notification";
        public static final String KEY_NOTIFICTION_CHANNEL = "notification_channel";
        public static final String KEY_PHONE_HEIGHT = "phone_height";
        public static final String KEY_PHONE_WIDTH = "phone_width";
        public static final String KEY_PICTURE_ADJUST = "picture_adjust";
        public static final String KEY_PID = "notification_pid";
        public static final String KEY_ROTATION = "rotation";
        public static final String KEY_ROTATION_MONITOR = "rotation_monitor";
        public static final String KEY_SUBMIX_AUTH = "is_submix_auth";
        public static final String KEY_USE_DEFAULT_NOTIFICATION = "use_default_notification";
        public static final String MIRROR_DOC_MODE = "text";
        public static final int MIRROR_ERROR_CODEC = 120105112;
        public static final int MIRROR_ERROR_FORBIDDEN = 120105115;
        public static final int MIRROR_ERROR_FORCE_STOP = 120105104;
        public static final int MIRROR_ERROR_GET_INFO = 120105102;
        public static final int MIRROR_ERROR_GET_PARAMTER = 120105108;
        public static final int MIRROR_ERROR_GET_PORT = 120105101;
        public static final int MIRROR_ERROR_NETWORK_BROKEN = 120105111;
        public static final int MIRROR_ERROR_PREEMPT_STOP = 120105103;
        public static final int MIRROR_ERROR_PREPARE = 120105113;
        public static final int MIRROR_ERROR_PREPARE_ENCODE = 120105114;
        public static final int MIRROR_ERROR_RECORD = 120105107;
        public static final int MIRROR_ERROR_SERVER_STOP = 120105105;
        public static final int MIRROR_ERROR_SETUP = 120105106;
        public static final int MIRROR_ERROR_SET_PARAMTER = 120105109;
        public static final int MIRROR_ERROR_UNSUPPORT_PREEMPT = 120105110;
        public static final String MIRROR_GAME_MODE = "game";
        public static final int MIRROR_INFO_BITRATE_CHANGE = 211037;
        public static final int MIRROR_INFO_BITRATE_DOWN = 211039;
        public static final int MIRROR_INFO_BITRATE_UP = 211038;
        public static final String MIRROR_VIDEO_MODE = "video";
        public static final int NEED_SCREENCODE = 211026;
        public static final int PREEMPT_UNSUPPORTED = 211027;
        public static final int RENDERMODE_CONTINUOUSLY = 1;
        public static final int RENDERMODE_WHEN_DIRTY = 0;
        public static final int RESIZE_ADAPT = 1;
        public static final int RESIZE_HORIZONTAL = 3;
        public static final int RESIZE_VERTICAL = 2;
        public static final int SWITCH_TYPE_CAPTURE_ASUS_ALL = 4;
        public static final int SWITCH_TYPE_CAPTURE_AUDIO = 2;
        public static final int SWITCH_TYPE_CAPTURE_MEDIA_AUDIO = 3;
        public static final int SWITCH_TYPE_CLOSE_AUDIO = 0;
        public static final int SWITCH_TYPE_EXTERNAL_AUDIO = 1;
        public static final int TYPE_CLOUD_MIRROR = 2;
        public static final int TYPE_TCP = 2;
        public static final int TYPE_UDP = 1;
        public static final int TYPE_WLAN_MIRROR = 1;
    }

    public interface PushParams {
        public static final String KEY_CURPLAYID = "curplayid";
        public static final String KEY_DESC = "desc";
        public static final String KEY_DLNA_ALBUM = "dlna_album";
        public static final String KEY_DLNA_ALBUM_URL = "dlna_album_url";
        public static final String KEY_DLNA_ARTIST = "dlna_artist";
        public static final String KEY_DLNA_CREATOR = "dlna_creator";
        public static final String KEY_DLNA_DURATION = "dlna_duration";
        public static final String KEY_DLNA_META_DATA = "dlna_meta_data";
        public static final String KEY_DLNA_RESOLUTION = "dlna_resolution";
        public static final String KEY_DLNA_SIZE = "dlna_size";
        public static final String KEY_ERRCODE = "errCode";
        public static final String KEY_ERRMSG = "errMsg";
        public static final String KEY_HEADER = "header";
        public static final String KEY_HEAD_DURATION = "headduration";
        public static final String KEY_LOCATION_URI = "location_uri";
        public static final String KEY_MEDIA_ASSET_NAME = "mediaAssetName";
        public static final String KEY_MEDIA_TYPE = "mediatype";
        public static final String KEY_PASSTH_URL = "passthurl";
        public static final String KEY_PERIOD = "period";
        public static final String KEY_PLAY_LIST_JSON = "playlist";
        public static final String KEY_PROTOCOL_TYPE = "protocol_type";
        public static final String KEY_PUSH_HEIGHT = "height";
        public static final String KEY_PUSH_SCREEN_CODE = "screencode";
        public static final String KEY_PUSH_URI = "uri";
        public static final String KEY_PUSH_URL = "url";
        public static final String KEY_PUSH_WIDTH = "width";
        public static final String KEY_START_POSITION = "start_postion";
        public static final String KEY_TAIL_DURATION = "tailduration";
        public static final String KEY_TYPE_CATEGORY = "category";
        public static final String KEY_TYPE_MEDIA_NAME = "name";
        public static final String KEY_TYPE_PLAYID = "playid";
        public static final String MEDIA_TYPE_AUDIO = "101";
        public static final String MEDIA_TYPE_IMAGE = "103";
        public static final String MEDIA_TYPE_VIDEO = "102";
        public static final int PUSH_ERROR_DLNA_GETACTION = 120103104;
        public static final int PUSH_ERROR_DLNA_GETPLAY_ACTION = 120103107;
        public static final int PUSH_ERROR_DLNA_GETSERVICE = 120103103;
        public static final int PUSH_ERROR_DLNA_PLAYCMD = 120103106;
        public static final int PUSH_ERROR_DLNA_SETURL_CMD = 120103105;
        public static final int PUSH_ERROR_DLNA_URL_UNSUPPORT = 120103108;
        public static final int PUSH_ERROR_LELINK_V1_CODE = 120103101;
        public static final int PUSH_ERROR_LELINK_V2_CODE = 120103102;
    }

    public static ParamsMap create() {
        return new ParamsMap();
    }

    public String getATV() {
        return get("atv") == 0 ? "" : String.valueOf(get("atv"));
    }

    public int getAirplayPort() {
        if (get(DeviceParams.KEY_AIRPLAY_PORT) == 0) {
            return 0;
        }
        return Integer.parseInt(get(DeviceParams.KEY_AIRPLAY_PORT).toString());
    }

    public String getAppKey() {
        return get(DeviceParams.KEY_APPID) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_APPID));
    }

    public String getAppsecret() {
        return get("secret") == 0 ? "" : String.valueOf(get("secret"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean getBooleanParam(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (get(obj) != 0) {
                return ((Boolean) get(obj)).booleanValue();
            }
            return false;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public String getChannelVersion() {
        return get(DeviceParams.KEY_CHANNEL_VERSION) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_CHANNEL_VERSION));
    }

    public String getCuid() {
        return get(DeviceParams.KEY_UID) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_UID));
    }

    public String getHID() {
        return get(DeviceParams.KEY_HID) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_HID));
    }

    public String getHTV() {
        return get("htv") == 0 ? "" : String.valueOf(get("htv"));
    }

    public String getIMEI() {
        return get("imei") == 0 ? "" : String.valueOf(get("imei"));
    }

    public int getIntParam(Object obj) {
        if (get(obj) == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(get(obj).toString());
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getIp() {
        return get("ip") == 0 ? "" : String.valueOf(get("ip"));
    }

    public int getLelinkPort() {
        if (get(DeviceParams.KEY_LELINK_PORT) == 0) {
            return 0;
        }
        return Integer.parseInt(get(DeviceParams.KEY_LELINK_PORT).toString());
    }

    public String getMac() {
        return get(DeviceParams.KEY_MAC) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_MAC));
    }

    public String getMediaType() {
        return get(PushParams.KEY_MEDIA_TYPE) == 0 ? "" : String.valueOf(get(PushParams.KEY_MEDIA_TYPE));
    }

    public Object getParam(Object obj, Object obj2) {
        return get(obj) == 0 ? obj2 : get(obj);
    }

    public int getPort() {
        if (get("port") == 0) {
            return 0;
        }
        return Integer.parseInt(get("port").toString());
    }

    public String getPushUri() {
        return get("uri") == 0 ? "" : String.valueOf(get("uri"));
    }

    public int getRaopPort() {
        if (get(DeviceParams.KEY_RAOP_PORT) == 0) {
            return 0;
        }
        return Integer.parseInt(get(DeviceParams.KEY_RAOP_PORT).toString());
    }

    public String getRuid() {
        return get(DeviceParams.KEY_RECEIVER_UID) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_RECEIVER_UID));
    }

    public String getScreenCode() {
        return get("screencode") == 0 ? "" : String.valueOf(get("screencode"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getStringParam(Object obj) {
        return get(obj) == 0 ? "" : (String) get(obj);
    }

    public String getToken() {
        return get(DeviceParams.KEY_AUTH_TOKEN) == 0 ? "" : String.valueOf(get(DeviceParams.KEY_AUTH_TOKEN));
    }

    public String getVV() {
        return get("vv") == 0 ? "" : String.valueOf(get("vv"));
    }

    public ParamsMap putBoolean(Object obj, boolean z10) {
        if (obj != null) {
            put(obj, Boolean.valueOf(z10));
        }
        return this;
    }

    public ParamsMap putParam(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            put(obj, obj2);
        }
        return this;
    }

    public String toJason() {
        return new JSONObject(this).toString();
    }

    public static ParamsMap create(String str) {
        try {
            ParamsMap paramsMap = new ParamsMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                paramsMap.put(next, jSONObject.get(next));
            }
            return paramsMap;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }
}
