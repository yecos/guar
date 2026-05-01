package com.hpplay.sdk.source.browse.api;

/* loaded from: classes3.dex */
public interface IAPI {

    @Deprecated
    public static final int ACTION_1 = 393217;
    public static final int INVALID_CALL = -1;
    public static final int MIRROR_DECODE_DELAY_PASSTHROUGH_DATA = 45;
    public static final int MULTIMIRROR_ADDED_DEVES = 1179648;
    public static final int MULTIMIRROR_DELETE_DEVES = 1179649;
    public static final int MULTIPUSH_ADDED_DEVES = 2097207;
    public static final int MULTIPUSH_DELETE_DEVES = 2097208;

    @Deprecated
    public static final int OPTION_0 = 65536;

    @Deprecated
    public static final int OPTION_1 = 65537;

    @Deprecated
    public static final int OPTION_10 = 1048592;
    public static final int OPTION_11 = 1048593;
    public static final int OPTION_12 = 1048594;
    public static final int OPTION_13 = 1048595;
    public static final int OPTION_14 = 1048596;
    public static final int OPTION_15 = 1048597;
    public static final int OPTION_16 = 1048598;
    public static final int OPTION_17 = 1048599;

    @Deprecated
    public static final int OPTION_18 = 1048600;

    @Deprecated
    public static final int OPTION_19 = 1048601;

    @Deprecated
    public static final int OPTION_2 = 65538;
    public static final int OPTION_20 = 1048608;
    public static final int OPTION_21 = 1048609;

    @Deprecated
    public static final int OPTION_22 = 1048610;
    public static final int OPTION_23 = 1048611;
    public static final int OPTION_24 = 1048612;
    public static final int OPTION_25 = 1048613;
    public static final int OPTION_26 = 1048614;

    @Deprecated
    public static final int OPTION_27 = 1048615;
    public static final int OPTION_29 = 1048617;
    public static final int OPTION_3 = 65539;

    @Deprecated
    public static final int OPTION_30 = 1048624;

    @Deprecated
    public static final int OPTION_31 = 1048625;
    public static final int OPTION_32 = 1048626;
    public static final int OPTION_33 = 1048627;
    public static final int OPTION_35 = 1048629;

    @Deprecated
    public static final int OPTION_36 = 1048630;
    public static final int OPTION_37 = 1048631;

    @Deprecated
    public static final int OPTION_38 = 1048632;
    public static final int OPTION_4 = 65540;
    public static final int OPTION_41 = 1048641;

    @Deprecated
    public static final int OPTION_42 = 1048642;

    @Deprecated
    public static final int OPTION_43 = 1048643;
    public static final int OPTION_44 = 1048644;

    @Deprecated
    public static final int OPTION_45 = 1048645;
    public static final int OPTION_46 = 1048646;
    public static final int OPTION_48 = 1048648;
    public static final int OPTION_49 = 1048649;
    public static final int OPTION_5 = 65541;

    @Deprecated
    public static final int OPTION_50 = 1048656;
    public static final int OPTION_51 = 1048657;

    @Deprecated
    public static final int OPTION_52 = 1048658;
    public static final int OPTION_53 = 1048659;

    @Deprecated
    public static final int OPTION_54 = 1048660;

    @Deprecated
    public static final int OPTION_6 = 65542;

    @Deprecated
    public static final int OPTION_60 = 1048672;
    public static final int OPTION_63 = 1048675;
    public static final int OPTION_64 = 1048676;

    @Deprecated
    public static final int OPTION_65 = 1048677;
    public static final int OPTION_7 = 65543;
    public static final int OPTION_8 = 65544;
    public static final int OPTION_9 = 65545;
    public static final int OPTION_APP_PAUSE = 1179657;
    public static final int OPTION_APP_RESUME = 1179664;
    public static final int OPTION_BROWSER = 2097154;
    public static final int OPTION_BROWSER_HISTORY = 2097216;
    public static final int OPTION_CACHE_LIST = 1048680;
    public static final int OPTION_CHANGE_MIRROR = 2097157;
    public static final int OPTION_CHANGE_SINK_HOST_SETTING = 2097193;
    public static final int OPTION_CHANGE_SINK_PAINT = 2097200;
    public static final int OPTION_CLOUD_MULTI_CAST = 2097206;
    public static final int OPTION_CREATE_LELINK_SERVICE = 2097158;
    public static final int OPTION_CREATE_LELINK_SERVICE_LIST = 2097221;
    public static final int OPTION_DISABLE_CLOUD_CAST = 2097184;
    public static final int OPTION_ENABLE_HISTORY_DEV = 2097220;
    public static final int OPTION_ENCODE_ERROR_EXIT_MIRROR = 2097222;
    public static final int OPTION_EXTERNAL_AUDIO = 1048673;
    public static final int OPTION_EXTERNAL_VIDEO = 2097153;
    public static final int OPTION_GET_LOG_DIR = 2097155;
    public static final int OPTION_GET_RECEIVER_PROPERTIES = 2097235;
    public static final int OPTION_IS_MIRRORING = 2097201;
    public static final int OPTION_MICRO_PASS = 2097171;
    public static final int OPTION_MIRROR_NOTIFICATION = 2097176;
    public static final int OPTION_MIRROR_NOTIFY_TYPE = 2097204;

    @Deprecated
    public static final int OPTION_MIRROR_RESIZE_SCREEN = 1179654;
    public static final int OPTION_MIRROR_REUSE_DISPLAY = 2097217;
    public static final int OPTION_MIRROR_ROTATION = 2097202;
    public static final int OPTION_MIRROR_SCREEN_SECRET = 2097192;
    public static final int OPTION_MIRROR_WATERMARK_INFO = 2097185;
    public static final int OPTION_MIRROR_WATERMARK_SWITCH = 2097186;
    public static final int OPTION_MULTI_CHANNEL = 2097156;
    public static final int OPTION_NOTIFY_REMOTE_SERVER = 2097190;
    public static final int OPTION_NOTIFY_SINK_MIRROR = 2097189;
    public static final int OPTION_OVERLAY_PERMISSION = 2097170;
    public static final int OPTION_PERMISSION_MODE = 2097191;
    public static final int OPTION_PLAY_NEXT_DRAMA = 33554448;
    public static final int OPTION_PLAY_PRE_DRAMA = 33554449;
    public static final int OPTION_QUERY_SUPPORT_MULTI_CHANNEL = 2097159;
    public static final int OPTION_QUERY_SUPPORT_REVERSE_CONTROL = 2097173;
    public static final int OPTION_QUERY_SUPPORT_TRACK = 2097177;
    public static final int OPTION_QUERY_SUPPORT_URL_LIST = 2097160;
    public static final int OPTION_REGISTER_LISTENER_BY_COMMON = 2097187;
    public static final int OPTION_REGISTER_SINK_KEY_EVENT = 1048678;
    public static final int OPTION_REGISTER_SINK_TOUCH_EVENT = 1048679;
    public static final int OPTION_RESIZE_MIRROR_SCREEN = 2097218;
    public static final int OPTION_SELECT_TRACK = 2097174;
    public static final int OPTION_SEND_HARASS_CODE = 2097205;
    public static final int OPTION_SET_CONNECT_DEVICE = 2097203;
    public static final int OPTION_SET_DLNA_CUSTOM_IDS = 2097236;
    public static final int OPTION_SET_DRAMA_ID = 2097161;
    public static final int OPTION_SET_EXPANSITION_INFOS = 1179656;
    public static final int OPTION_SET_FRAME_RATE = 2097209;
    public static final int OPTION_SET_MIRROR_VIRTUAL_DISPLAY_NAME = 2097232;
    public static final int OPTION_SET_NOTIFICATION_PID = 2097224;
    public static final int OPTION_SET_OPTIONAL_CAPTURE = 2097237;
    public static final int OPTION_SET_QCOM_OPT_BITRATE = 2097233;
    public static final int OPTION_SET_RC_EVENT_NO_FILTER = 2097225;
    public static final int OPTION_SET_RECEIVER_PROPERTY = 2097234;
    public static final int OPTION_SET_RESOLUTION = 2097223;
    public static final int OPTION_SOURCE_ID = 2097219;
    public static final int OPTION_STOP_MICRO = 2097172;
    public static final int OPTION_SUPER_DEVICE_ID = 1179654;

    @Deprecated
    public static final int OPTION_SWITCH_MIRROR_AUDIO = 1179653;
    public static final int OPTION_TEMP_RESTRICT = 2097175;
    public static final int OPTION_UNREGISTER_LISTENER_BY_COMMON = 2097188;
    public static final int OPTION_UPLOAD_LOG = 1179655;
    public static final int PERMISSION_MODE_CLOUD_LICENSE = 1;
    public static final int RECEIVE_DECODE_SUPPORT = 14;
    public static final int SEND_LEBO_PASSTHROUGH_DATA = 100;
    public static final int SEND_THIRD_PASSTHROUGH_DATA = 10000;
    public static final int SEND_VIP_QUERY_DATA = 22;
    public static final int SET_CLOUDMIRROR_PLAY_LISTENER = 1179651;
    public static final int SET_PASSTHROUGH_LISTENER = 1179650;
    public static final int START_PLAY_CLOUDMIRROR = 1179652;
    public static final int VALID_CALL = 0;

    Object getOption(int i10, Object... objArr);

    Object setOption(int i10, Object... objArr);
}
