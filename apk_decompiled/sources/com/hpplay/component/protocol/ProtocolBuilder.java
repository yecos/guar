package com.hpplay.component.protocol;

import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ProtocolBuilder {
    private static final String ALBUM_END_NODE = "</upnp:album>";
    private static final String ALBUM_NODE = "<upnp:album>";
    private static final String ANNOUNCE_CMD = "ANNOUNCE rtsp://%s/11634020164747084845 RTSP/1.0";
    private static final String ARTIST_END_NODE = "</upnp:artist>";
    private static final String ARTIST_NODE = "<upnp:artist role=\"Performer\">";
    private static final String AUDIO_SETUP_CMD = "SETUP rtsp://%s/41/audio RTSP/1.0";
    public static final String CONNCTION_UPGRADE = "Upgrade";
    public static final String CONTENT_APPLE_PLAYLIST_TYPE = "text/x-apple-plist+xml";
    public static final String CONTENT_OCTET_STREAM_TYPE = "application/octet-stream";
    public static final String CONTENT_TEXT_TYPE = "text/parameters";
    public static final String CRLF = "\r\n";
    private static final String DCTITLE_END_NODE = "</dc:title>";
    private static final String DCTITLE_NODE = "<dc:title>";
    private static final String DC_ALBUMARTURI_END_NODE = "</dc:albumArtURI>";
    private static final String DC_ALBUMARTURI_NODE = "<dc:albumArtURI>";
    private static final String DC_CHANNEL_END_NODE = "</dc:channel>";
    private static final String DC_CHANNEL_NODE = "<dc:channel>";
    private static final String DC_CREATOR_END_NODE = "</dc:creator>";
    private static final String DC_CREATOR_NODE = "<dc:creator>";
    private static final String DC_SESSION_END_NODE = "</dc:session>";
    private static final String DC_SESSION_NODE = "<dc:session>";
    private static final String DC_UID_END_NODE = "</dc:uid>";
    private static final String DC_UID_NODE = "<dc:uid>";
    private static final String DC_URI_END_NODE = "</dc:uri>";
    private static final String DC_URI_NODE = "<dc:uri>";
    public static final String DEVICE_ANDROID_TYPE = "Android";
    private static final String DIDL_LITE_END_NODE = "</DIDL-Lite>";
    private static final String DIDL_LITE_NODE = "<DIDL-Lite ";
    private static final String FILE_DURATION_KEY = " duration=";
    private static final String FILE_RUSOLUTION_KEY = " resolution=";
    private static final String FILE_SIZE_KEY = " size=";
    private static final String GET_PARAMETER_CMD = "GET_PARAMETER rtsp://%s/41 RTSP/1.0";
    public static final String HAPPYCAST_AGENT = "HappyCast3,1";
    public static final String HAPPYCAST_AUDIO_AGENT = "HappyCast/Audio 1.0";
    private static final String ITEMID_END_NODE = "</item>";
    private static final String ITEMID_KEY = " id=";
    private static final String ITEMID_NODE = "<item";
    private static final String LELINK_ADD_VOLUME_CMD = "POST /add_volume HTTP/1.1";
    public static final String LELINK_AUTH_ERROR = "603";
    private static final String LELINK_CLIENT_NAME = "X-LeLink-Client-Name: ";
    private static final String LELINK_CONNECT = "GET /server-info HTTP/1.1";
    private static final String LELINK_GET_MIRROR_INFO_CMD = "GET /stream.xml HTTP/1.1";
    private static final String LELINK_GET_MIRROR_PORT_CMD = "GET /stream RTSP/1.0";
    private static final String LELINK_GET_POSITION_CMD = "GET /scrub HTTP/1.1";
    public static final String LELINK_HEARTBAT_CMD = "POST /heartbat HTTP/1.1";
    private static final String LELINK_PAUSE_CMD = "POST /rate?value=0.000000 HTTP/1.1";
    public static final String LELINK_PHOTO_CONTROL = "POST /photo-control HTTP/1.1";
    public static final String LELINK_PLAY_ACTION = "POST /lelink-action HTTP/1.1";
    private static final String LELINK_PLAY_CMD = "POST /play HTTP/1.1";
    private static final String LELINK_PUT_PHOTO_CMD = "PUT /photo HTTP/1.1";
    private static final String LELINK_RECOVER_PLAY_CMD = "POST /rate?value=1.000000 HTTP/1.1";
    public static final String LELINK_SCREENSHOT = "POST /shot-screen HTTP/1.1";
    private static final String LELINK_SEND_DANMUKU_CMD = "POST /app_danmu_sendtextlive HTTP/1.1";
    public static final String LELINK_SEND_VIDEO_INFO = "POST /send_videoInfo HTTP/1.1";
    private static final String LELINK_SET_POSITION_CMD = "POST /scrub?position=%s HTTP/1.1";
    public static final String LELINK_STATE_SCREENCODE = "401";
    public static final String LELINK_STATE_SUCCESS = "200";
    private static final String LELINK_STOP_CMD = "POST /stop HTTP/1.1";
    private static final String LELINK_STREAM_POST_CMD = "POST /stream HTTP/1.1";
    private static final String LELINK_SUB_VOLUME_CMD = "POST /sub_volume HTTP/1.1";
    public static final String LELINK_UNSUPPORT_FORBIDDEN = "403";
    public static final String LELINK_UNSUPPORT_PREEMPT = "453";
    private static final String LELINK_VOLUME_CMD = "POST /scrub?volume=%s HTTP/1.1";
    public static final String MEDIACONTROL_AGENT = "MediaControl/1.0";
    public static final String NEW_LELINK_FEEDBACK = "POST /feedback HTTP/1.1";
    private static final String OPTIONS_CMD = "OPTIONS * RTSP/1.0";
    private static final String PARENTID_KEY = " parentID=";
    public static final String PROTOCOLINFO_AUDIO_VALUE = "\"http-get:*:audio/mpeg:DLNA.ORG_OP=01\" ";
    public static final String PROTOCOLINFO_IMAGE_VALUE = "\"http-get:*:image/jpeg:*\" ";
    private static final String PROTOCOLINFO_KEY = " protocolInfo=";
    public static final String PROTOCOLINFO_VIDEO_VALUE = "\"http-get:*:video/mp4:DLNA.ORG_PN=MP3;DLNA.ORG_OP=01;DLNA.ORG_FLAGS=01500000000000000000000000000000\" ";
    private static final String RECORD_CMD = "RECORD rtsp://%s/41 RTSP/1.0";
    private static final String RESTRICTED_KEY = " restricted=";
    private static final String RES_END_NODE = "</res>";
    private static final String RES_NODE = "<res ";
    private static final String REVERSE_CMD = "POST /reverse HTTP/1.1";
    private static final String RTSP_ACTIVE_REMOTE = "Active-Remote: ";
    private static final String RTSP_CSEQ = "CSeq: ";
    private static final String RTSP_DACP = "DACP-ID: ";
    private static final String RTSP_RANGE = "Range:  ";
    private static final String RTSP_RTP_INFO = "RTP-Info:  ";
    private static final String RTSP_TRANSPORT = "Transport: ";
    private static final String SET_PARAMETER_CMD = "SET_PARAMETER rtsp://%s/41 RTSP/1.0";
    private static final String TAG = "";
    private static final String TEARDOWN_CMD = "TEARDOWN rtsp://%s/41 RTSP/1.0";
    public static final String UPGRADE_EVENT = "event";
    public static final String UPGRADE_PTTH = "PTTH/1.0";
    private static final String UPNPCLASS_END_NODE = "</upnp:class>";
    private static final String UPNPCLASS_NODE = "<upnp:class>";
    public static final String UPNP_AUDIO_ITEM_CLASS = "object.item.audioItem.musicTrack";
    private static final String UPNP_IMAGE_ITEM_CLASS = "object.item.imageItem.photo";
    public static final String UPNP_VIDEO_ITEM_CLASS = "object.item.videoItem";
    public static final String USERAGENT_AIRPLAY = "AirPlay/150.33";
    public static final String VALUE_ACTIVE_REMOTE = "2317505163";
    public static final String VALUE_AUDIO_TRANSPORT = "RTP/AVP/UDP;unicast;mode=screen;timing_port=49944;x-events;control_port=56986;redundant=2";
    public static final String VALUE_DACP = "8A3D47D2C13675B8";
    public static final String VALUE_NTP = "npt=0-";
    public static final String VALUE_RTPINFO = "seq=1920;rtptime=0";
    public static final String VALUE_SDP_TYPE = "application/sdp";
    public static final String VALUE_USER_AGENT = "AirPlay/150.33";
    public static final String VALUE_VIDEO_TRANSPORT = "RTP/AVP/TCP;unicast;mode=record";
    private static final String VIDEO_SETUP_CMD = "SETUP rtsp://%s/41/video RTSP/1.0";
    private static final String XMLNS_DC_KEY = "xmlns:dc=";
    private static final String XMLNS_DC_VALUE = "\"http://purl.org/dc/elements/1.1/\" ";
    private static final String XMLNS_KEY = " xmlns=";
    private static final String XMLNS_SEC_KEY = "xmlns:sec=";
    private static final String XMLNS_SEC_VALUE = "\"http://www.sec.co.kr/\" ";
    private static final String XMLNS_UNNP_VALUE = "\"urn:schemas-upnp-org:metadata-1-0/upnp/\" ";
    private static final String XMLNS_UPNP_KEY = "xmlns:upnp=";
    private static final String XMLNS_VALUE = "\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" ";
    public static String mNonce;
    public static String mRealm;
    private String LELINK_DEVICE_ID = "X-LeLink-Device-ID: ";
    private String APPLE_DEVICE_ID = "X-Apple-Device-ID: ";
    private String MOBILE_DEVICE_NAME = "Mobile-Devices-Name: ";
    private String MOBILE_DEVICE_CHANNEL = "Mobile-Devices-Channel: ";
    private String MOBILE_DEVICE_VERSION = "Mobile-Devices-Version: ";
    private String DEVICE_TYPE = "DeviceType: ";
    private String CONTENT_LOCATION = "Content-Location: ";
    private String CONTENT_LENGTH = "Content-Length: ";
    private String CONTENT_TYPE = "Content-Type: ";
    private String START_POSITION = "Start-Position: ";
    private String USER_AGENT = "User-Agent: ";
    private String USER_LELINK_SESSION_ID = "X-LeLink-Session-ID: ";
    private String USER_LELINK_SEND_END = "X-LeLink-Send-End: ";
    private String UPGRADE_KEY = "Upgrade: ";
    private String CONNECTION_KEY = "Connection: ";
    private String APPLE_PURPOSE_KEY = "X-Apple-Purpose: ";
    private String APPLE_SESSION_ID = "X-Apple-Session-ID: ";
    private String APPLE_APPLE_ASSETKEY = "X-Apple-AssetKey: ";
    private String APPLE_DEVICE_NAME = "X-Apple-Device-Name: ";
    private String LELINK_DATA = "Data: ";
    private String LELINK_XAPPLE_PROTOCOLVERSION = "X-Apple-ProtocolVersion: ";
    private String LELINK_XAPPLE_CLIENT_NAME = "X-Apple-Client-Name: ";
    private String LELINK_HAPPLAY = "Hpplay:";
    private String LELINK_STREAM_TIME = "Stream-Time: ";
    private String LELINK_MOBILE_DEVICES_CU = "Mobile-Devices-CU: ";
    private String LELINK_MOBILE_DEVICES_IDFA = "Mobile-Devices-IDFA: ";
    private String LELINK_MOBILE_PLATFROM = "X-LeLink-Platform: ";
    private String LELINK_CONTENT_URI = "Content-URLID: ";
    private String LELINK_AUTHORIZATION = "Authorization: ";
    private String LELINK_DEVICE_NAME = "X-LeLink-Device-Name: ";
    private String LELINK_PROTOCOLVERSION = "X-LeLink-ProtocolVersion: ";
    public String mBuildProtocol = "";
    private String mItemId = "image-item-42";
    private String mParentID = "3";
    private String mChannelID = "";
    private String mRestricted = "0";
    private String mDcTitle = "";
    private String mUPNPclass = UPNP_IMAGE_ITEM_CLASS;
    private String mProtocolInfo = PROTOCOLINFO_IMAGE_VALUE;
    private String mPath = "";
    private long mSize = 0;
    private String sessionId = "";
    private String contentUri = "";
    private String mDuration = "0";
    private String mResolution = "0";
    private String mAlbum = "";
    private String mAlbumUrl = "";
    private String mArtist = "";
    private String mCreator = "";
    private String mUid = "";
    private String BROWSE_MAGIC_NUM_KEY = "magic-number:";
    private String BROWSE_XOR_KEY = "xor-key:";

    public static String makeAuthorization(String str) {
        String str2 = mNonce;
        String str3 = "Digest username=\"" + mRealm + "\", realm=\"" + mRealm + "\", nonce=\"" + str2 + "\", uri=\"/stream.xml\", response=\"" + ProtocolUtils.strEncrpyt(ProtocolUtils.strEncrpyt(mRealm + SOAP.DELIM + mRealm + SOAP.DELIM + str) + SOAP.DELIM + str2 + SOAP.DELIM + ProtocolUtils.strEncrpyt("GET:/stream.xml")) + "\"";
        CLog.d("", str + "  makeAuthorization authorization=" + str3);
        return str3;
    }

    public ProtocolBuilder getAudioMetaData() {
        StringBuilder sb = new StringBuilder();
        sb.append("<DIDL-Lite  xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" ><item id=\"");
        sb.append(this.mItemId);
        sb.append("\"");
        sb.append(PARENTID_KEY);
        sb.append("\"");
        sb.append(this.mParentID);
        sb.append("\"");
        sb.append(RESTRICTED_KEY);
        sb.append("\"");
        sb.append(this.mRestricted);
        sb.append("\">");
        sb.append(DCTITLE_NODE);
        sb.append(this.mDcTitle);
        sb.append(DCTITLE_END_NODE);
        sb.append(DC_CREATOR_NODE);
        sb.append(TextUtils.isEmpty(this.mCreator) ? "unknown" : this.mCreator);
        sb.append(DC_CREATOR_END_NODE);
        sb.append(UPNPCLASS_NODE);
        sb.append(UPNP_AUDIO_ITEM_CLASS);
        sb.append(UPNPCLASS_END_NODE);
        sb.append(getMetaDataCustomNode());
        sb.append(ALBUM_NODE);
        sb.append(TextUtils.isEmpty(this.mAlbum) ? "unknown" : this.mAlbum);
        sb.append(ALBUM_END_NODE);
        sb.append(DC_ALBUMARTURI_NODE);
        sb.append(this.mAlbumUrl);
        sb.append(DC_ALBUMARTURI_END_NODE);
        sb.append(ARTIST_NODE);
        sb.append(TextUtils.isEmpty(this.mArtist) ? "unknown" : this.mArtist);
        sb.append(ARTIST_END_NODE);
        sb.append(RES_NODE);
        sb.append(PROTOCOLINFO_KEY);
        sb.append(this.mProtocolInfo);
        sb.append(FILE_SIZE_KEY);
        sb.append("\"");
        sb.append(this.mSize);
        sb.append("\">");
        sb.append(this.mPath);
        sb.append(RES_END_NODE);
        sb.append(ITEMID_END_NODE);
        sb.append(DIDL_LITE_END_NODE);
        this.mBuildProtocol = sb.toString();
        return this;
    }

    public ProtocolBuilder getAudioSetUpCmd(String str) {
        this.mBuildProtocol = String.format(AUDIO_SETUP_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getAunounce(String str) {
        this.mBuildProtocol = String.format(ANNOUNCE_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getFeedbackCmd() {
        this.mBuildProtocol += "POST /feedback HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getImageMetaData() {
        this.mBuildProtocol = "<DIDL-Lite  xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" ><item id=\"" + this.mItemId + "\"" + PARENTID_KEY + "\"" + this.mParentID + "\"" + RESTRICTED_KEY + "\"" + this.mRestricted + "\">" + DCTITLE_NODE + this.mDcTitle + DCTITLE_END_NODE + DC_CREATOR_NODE + "unknown" + DC_CREATOR_END_NODE + UPNPCLASS_NODE + this.mUPNPclass + UPNPCLASS_END_NODE + getMetaDataCustomNode() + RES_NODE + PROTOCOLINFO_KEY + this.mProtocolInfo + FILE_SIZE_KEY + "\"" + this.mSize + "\">" + this.mPath + RES_END_NODE + ITEMID_END_NODE + DIDL_LITE_END_NODE;
        return this;
    }

    public String getMetaDataCustomNode() {
        String str;
        if (TextUtils.isEmpty(this.sessionId)) {
            str = "";
        } else {
            str = DC_SESSION_NODE + this.sessionId + DC_SESSION_END_NODE;
        }
        if (!TextUtils.isEmpty(this.contentUri)) {
            str = str + DC_URI_NODE + this.contentUri + DC_URI_END_NODE;
        }
        if (!TextUtils.isEmpty(this.mParentID)) {
            str = str + DC_CHANNEL_NODE + this.mChannelID + DC_CHANNEL_END_NODE;
        }
        if (TextUtils.isEmpty(this.mUid)) {
            return str;
        }
        return str + DC_UID_NODE + this.mUid + DC_UID_END_NODE;
    }

    public ProtocolBuilder getMirrorInfoCmd() {
        this.mBuildProtocol += "GET /stream.xml HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getMirrorPortCmd() {
        this.mBuildProtocol += "GET /stream RTSP/1.0\r\n";
        return this;
    }

    public ProtocolBuilder getOptionsCmd() {
        this.mBuildProtocol = "OPTIONS * RTSP/1.0\r\n";
        return this;
    }

    public ProtocolBuilder getParameterCmd(String str) {
        this.mBuildProtocol = String.format(GET_PARAMETER_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getPauseCmd() {
        this.mBuildProtocol += "POST /rate?value=0.000000 HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getPhotoControlCmd() {
        this.mBuildProtocol += "POST /photo-control HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getPlayCmd() {
        this.mBuildProtocol += "POST /play HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getPositionCmd() {
        this.mBuildProtocol += "GET /scrub HTTP/1.1\r\n";
        return this;
    }

    public byte[] getProtocal(boolean z10) {
        String str;
        if (z10) {
            str = this.mBuildProtocol + "\r\n";
        } else {
            str = this.mBuildProtocol;
        }
        this.mBuildProtocol = str;
        return str.getBytes();
    }

    public ProtocolBuilder getPutPhotoCmd() {
        this.mBuildProtocol += "PUT /photo HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getRecordCmd(String str) {
        this.mBuildProtocol = String.format(RECORD_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getRecoverPlayCmd() {
        this.mBuildProtocol += "POST /rate?value=1.000000 HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getReverseCmd() {
        this.mBuildProtocol += "POST /reverse HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getScreenshotCmd() {
        this.mBuildProtocol += "POST /shot-screen HTTP/1.1\r\n";
        return this;
    }

    public String getSdp(String str, String str2) {
        return "v=0\r\no=AirTunes 41 0 IN IP4 " + str + "\r\ns=AirTunes\r\ni=" + str2 + "\r\nc=IN IP4 " + str + "\r\nt=0 0\r\nm=audio 0 RTP/AVP 96\r\na=rtpmap:96 mpeg4-generic/44100/2\r\na=fmtp:96 mode=AAC-eld; constantDuration=480\r\na=min-latency:3750\r\na=max-latency:3750\r\n";
    }

    public ProtocolBuilder getSendDanmukuCmd() {
        this.mBuildProtocol += "POST /app_danmu_sendtextlive HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getSendVideoInfoCmd() {
        this.mBuildProtocol += "POST /send_videoInfo HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getServerInfoCmd() {
        this.mBuildProtocol += "GET /server-info HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getSetParameterCmd(String str) {
        this.mBuildProtocol = String.format(SET_PARAMETER_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getSetPositionCmd() {
        this.mBuildProtocol += "POST /scrub?position=%s HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getStopCmd() {
        this.mBuildProtocol += "POST /stop HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getStreamPortCmd() {
        this.mBuildProtocol += "POST /stream HTTP/1.1\r\n";
        return this;
    }

    public String getString(boolean z10) {
        String str;
        if (z10) {
            str = this.mBuildProtocol + "\r\n";
        } else {
            str = this.mBuildProtocol;
        }
        this.mBuildProtocol = str;
        return str;
    }

    public ProtocolBuilder getTearDown(String str) {
        this.mBuildProtocol = String.format(TEARDOWN_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getVideoMetaData() {
        if (TextUtils.isEmpty(this.mResolution)) {
            StringBuilder sb = new StringBuilder();
            sb.append("<DIDL-Lite  xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:sec=\"http://www.sec.co.kr/\" ><item id=\"");
            sb.append(this.mItemId);
            sb.append("\"");
            sb.append(PARENTID_KEY);
            sb.append("\"");
            sb.append(this.mParentID);
            sb.append("\"");
            sb.append(RESTRICTED_KEY);
            sb.append("\"");
            sb.append(this.mRestricted);
            sb.append("\">");
            sb.append(DCTITLE_NODE);
            sb.append(this.mDcTitle);
            sb.append(DCTITLE_END_NODE);
            sb.append(DC_CREATOR_NODE);
            sb.append(TextUtils.isEmpty(this.mCreator) ? "unknown" : this.mCreator);
            sb.append(DC_CREATOR_END_NODE);
            sb.append(UPNPCLASS_NODE);
            sb.append(this.mUPNPclass);
            sb.append(UPNPCLASS_END_NODE);
            sb.append(getMetaDataCustomNode());
            sb.append(RES_NODE);
            sb.append(PROTOCOLINFO_KEY);
            sb.append(this.mProtocolInfo);
            sb.append(Operator.Operation.GREATER_THAN);
            sb.append(this.mPath);
            sb.append(RES_END_NODE);
            sb.append(ITEMID_END_NODE);
            sb.append(DIDL_LITE_END_NODE);
            this.mBuildProtocol = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<DIDL-Lite  xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:sec=\"http://www.sec.co.kr/\" ><item id=\"");
            sb2.append(this.mItemId);
            sb2.append("\"");
            sb2.append(PARENTID_KEY);
            sb2.append("\"");
            sb2.append(this.mParentID);
            sb2.append("\"");
            sb2.append(RESTRICTED_KEY);
            sb2.append("\"");
            sb2.append(this.mRestricted);
            sb2.append("\">");
            sb2.append(DCTITLE_NODE);
            sb2.append(this.mDcTitle);
            sb2.append(DCTITLE_END_NODE);
            sb2.append(DC_CREATOR_NODE);
            sb2.append(TextUtils.isEmpty(this.mCreator) ? "unknown" : this.mCreator);
            sb2.append(DC_CREATOR_END_NODE);
            sb2.append(UPNPCLASS_NODE);
            sb2.append(this.mUPNPclass);
            sb2.append(UPNPCLASS_END_NODE);
            sb2.append(getMetaDataCustomNode());
            sb2.append(RES_NODE);
            sb2.append(PROTOCOLINFO_KEY);
            sb2.append(this.mProtocolInfo);
            sb2.append("\"");
            sb2.append(FILE_RUSOLUTION_KEY);
            sb2.append("\"");
            sb2.append(this.mResolution);
            sb2.append("\">");
            sb2.append(this.mPath);
            sb2.append(RES_END_NODE);
            sb2.append(ITEMID_END_NODE);
            sb2.append(DIDL_LITE_END_NODE);
            this.mBuildProtocol = sb2.toString();
        }
        return this;
    }

    public ProtocolBuilder getVideoSetUpCmd(String str) {
        this.mBuildProtocol = String.format(VIDEO_SETUP_CMD, str) + "\r\n";
        return this;
    }

    public ProtocolBuilder getVolumeCmd() {
        this.mBuildProtocol += "POST /scrub?volume=%s HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getaddVolumeCmd() {
        this.mBuildProtocol += "POST /add_volume HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder getsubVolumeCmd() {
        this.mBuildProtocol += "POST /sub_volume HTTP/1.1\r\n";
        return this;
    }

    public ProtocolBuilder setAlbum(String str) {
        this.mAlbum = str;
        return this;
    }

    public ProtocolBuilder setAlbumUrl(String str) {
        this.mAlbumUrl = str;
        return this;
    }

    public ProtocolBuilder setAplleDevid(String str) {
        this.APPLE_DEVICE_ID += str;
        this.mBuildProtocol += this.APPLE_DEVICE_ID + "\r\n";
        return this;
    }

    public ProtocolBuilder setAppleAssetkey(String str) {
        this.APPLE_APPLE_ASSETKEY += str;
        this.mBuildProtocol += this.APPLE_APPLE_ASSETKEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setAppleClientName(String str) {
        this.LELINK_XAPPLE_CLIENT_NAME += str;
        this.mBuildProtocol += this.LELINK_XAPPLE_CLIENT_NAME + "\r\n";
        return this;
    }

    public ProtocolBuilder setAppleDevName(String str) {
        this.APPLE_DEVICE_NAME += str;
        this.mBuildProtocol += this.APPLE_DEVICE_NAME + "\r\n";
        return this;
    }

    public ProtocolBuilder setApplePrcVs(String str) {
        this.LELINK_XAPPLE_PROTOCOLVERSION += str;
        this.mBuildProtocol += this.LELINK_XAPPLE_PROTOCOLVERSION + "\r\n";
        return this;
    }

    public ProtocolBuilder setApplePurposeKey(String str) {
        this.APPLE_PURPOSE_KEY += str;
        this.mBuildProtocol += this.APPLE_PURPOSE_KEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setAppleSessionId(String str) {
        this.APPLE_SESSION_ID += str;
        this.mBuildProtocol += this.APPLE_SESSION_ID + "\r\n";
        return this;
    }

    public ProtocolBuilder setArtist(String str) {
        this.mArtist = str;
        return this;
    }

    public ProtocolBuilder setAutorization(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.LELINK_AUTHORIZATION += str;
        this.mBuildProtocol += this.LELINK_AUTHORIZATION + "\r\n";
        return this;
    }

    public ProtocolBuilder setBrowseInfo(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put(BrowserInfo.KEY_VER, str2);
            jSONObject.put("sign", str3);
            jSONObject.put("md5", str4);
            this.mBuildProtocol += jSONObject.toString();
        } catch (JSONException e10) {
            CLog.w("setBrowseInfo", e10);
        }
        return this;
    }

    public ProtocolBuilder setBrowseMgcNum(String str) {
        this.BROWSE_MAGIC_NUM_KEY += str;
        this.mBuildProtocol += this.BROWSE_MAGIC_NUM_KEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setBrowseXorkey(String str) {
        this.BROWSE_XOR_KEY += str;
        this.mBuildProtocol += this.BROWSE_XOR_KEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setChannelId(String str) {
        this.mChannelID = str;
        return this;
    }

    public ProtocolBuilder setConnectionKey(String str) {
        this.CONNECTION_KEY += str;
        this.mBuildProtocol += this.CONNECTION_KEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setContentLength(String str) {
        this.CONTENT_LENGTH += str;
        this.mBuildProtocol += this.CONTENT_LENGTH + "\r\n";
        return this;
    }

    public ProtocolBuilder setContentLocation(String str) {
        this.CONTENT_LOCATION += str;
        this.mBuildProtocol += this.CONTENT_LOCATION + "\r\n";
        return this;
    }

    public ProtocolBuilder setContentType(String str) {
        this.CONTENT_TYPE += str;
        this.mBuildProtocol += this.CONTENT_TYPE + "\r\n";
        return this;
    }

    public ProtocolBuilder setContentUri(String str) {
        this.LELINK_CONTENT_URI += str;
        this.mBuildProtocol += this.LELINK_CONTENT_URI + "\r\n";
        return this;
    }

    public ProtocolBuilder setCreator(String str) {
        this.mCreator = str;
        return this;
    }

    public ProtocolBuilder setDatakey(String str) {
        this.LELINK_DATA += str;
        this.mBuildProtocol += this.LELINK_DATA + "\r\n";
        return this;
    }

    public ProtocolBuilder setDcTitle(String str) {
        this.mDcTitle = str;
        return this;
    }

    public ProtocolBuilder setDeviceType(String str) {
        this.DEVICE_TYPE += str;
        this.mBuildProtocol += this.DEVICE_TYPE + "\r\n";
        return this;
    }

    public ProtocolBuilder setDevicesIMEI(String str) {
        this.LELINK_MOBILE_DEVICES_IDFA += str;
        this.mBuildProtocol += this.LELINK_MOBILE_DEVICES_IDFA + "\r\n";
        return this;
    }

    public ProtocolBuilder setDlnaContentUri(String str) {
        this.contentUri = str;
        return this;
    }

    public ProtocolBuilder setDlnaSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public ProtocolBuilder setDlnaUid(String str) {
        this.mUid = str;
        return this;
    }

    public ProtocolBuilder setDuration(String str) {
        this.mDuration = str;
        return this;
    }

    public ProtocolBuilder setHapplay(String str) {
        this.LELINK_HAPPLAY += str;
        this.mBuildProtocol += this.LELINK_HAPPLAY + "\r\n";
        return this;
    }

    public ProtocolBuilder setId(String str) {
        this.mItemId = str;
        return this;
    }

    public ProtocolBuilder setLelinkClientName(String str) {
        this.mBuildProtocol += LELINK_CLIENT_NAME + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setLelinkDevNameCmd(String str) {
        this.LELINK_DEVICE_NAME += str;
        this.mBuildProtocol += this.LELINK_DEVICE_NAME + "\r\n";
        return this;
    }

    public ProtocolBuilder setLelinkDeviceId(String str) {
        this.LELINK_DEVICE_ID += str;
        this.mBuildProtocol += this.LELINK_DEVICE_ID + "\r\n";
        return this;
    }

    public ProtocolBuilder setLelinkprotocolVersion(String str) {
        this.LELINK_PROTOCOLVERSION += str;
        this.mBuildProtocol += this.LELINK_PROTOCOLVERSION + "\r\n";
        return this;
    }

    public ProtocolBuilder setMobileDevCu(String str) {
        this.LELINK_MOBILE_DEVICES_CU += str;
        this.mBuildProtocol += this.LELINK_MOBILE_DEVICES_CU + "\r\n";
        return this;
    }

    public ProtocolBuilder setMobileDeviceChannel(String str) {
        this.MOBILE_DEVICE_CHANNEL += str;
        this.mBuildProtocol += this.MOBILE_DEVICE_CHANNEL + "\r\n";
        return this;
    }

    public ProtocolBuilder setMobileDeviceName(String str) {
        this.MOBILE_DEVICE_NAME += str;
        this.mBuildProtocol += this.MOBILE_DEVICE_NAME + "\r\n";
        return this;
    }

    public ProtocolBuilder setMobileDeviceVersion(String str) {
        this.MOBILE_DEVICE_VERSION += str;
        this.mBuildProtocol += this.MOBILE_DEVICE_VERSION + "\r\n";
        return this;
    }

    public ProtocolBuilder setParentId(String str) {
        this.mParentID = str;
        return this;
    }

    public ProtocolBuilder setPath(String str) {
        this.mPath = str;
        return this;
    }

    public ProtocolBuilder setPlatfrom() {
        this.LELINK_MOBILE_PLATFROM += "Android";
        this.mBuildProtocol += this.LELINK_MOBILE_PLATFROM + "\r\n";
        return this;
    }

    public ProtocolBuilder setProtocolInfo(String str) {
        this.mProtocolInfo = str;
        return this;
    }

    public ProtocolBuilder setRange(String str) {
        this.mBuildProtocol += RTSP_RANGE + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setResolution(String str) {
        this.mResolution = str;
        return this;
    }

    public ProtocolBuilder setRestricted(String str) {
        this.mRestricted = str;
        return this;
    }

    public ProtocolBuilder setRtpinfo(String str) {
        this.mBuildProtocol += RTSP_RTP_INFO + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setRtsActiveRemote(String str) {
        this.mBuildProtocol += RTSP_ACTIVE_REMOTE + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setRtspDacp(String str) {
        this.mBuildProtocol += RTSP_DACP + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setRtspSeq(String str) {
        this.mBuildProtocol += RTSP_CSEQ + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setSendEndValue(String str) {
        this.USER_LELINK_SEND_END += str;
        this.mBuildProtocol += this.USER_LELINK_SEND_END + "\r\n";
        return this;
    }

    public ProtocolBuilder setSize(long j10) {
        this.mSize = j10;
        return this;
    }

    public ProtocolBuilder setStartPosition(String str) {
        this.START_POSITION += str;
        this.mBuildProtocol += this.START_POSITION + "\r\n";
        return this;
    }

    public ProtocolBuilder setStreamTime(String str) {
        this.LELINK_STREAM_TIME += str;
        this.mBuildProtocol += this.LELINK_STREAM_TIME + "\r\n";
        return this;
    }

    public ProtocolBuilder setTransport(String str) {
        this.mBuildProtocol += RTSP_TRANSPORT + str + "\r\n";
        return this;
    }

    public ProtocolBuilder setUPNPclass(String str) {
        this.mUPNPclass = str;
        return this;
    }

    public ProtocolBuilder setUpgradeKey(String str) {
        this.UPGRADE_KEY += str;
        this.mBuildProtocol += this.UPGRADE_KEY + "\r\n";
        return this;
    }

    public ProtocolBuilder setUserAgent(String str) {
        this.USER_AGENT += str;
        this.mBuildProtocol += this.USER_AGENT + "\r\n";
        return this;
    }

    public ProtocolBuilder setUserLelinkSessionId(String str) {
        this.USER_LELINK_SESSION_ID += str;
        this.mBuildProtocol += this.USER_LELINK_SESSION_ID + "\r\n";
        return this;
    }

    public ProtocolBuilder setSize(int i10) {
        this.mSize = i10;
        return this;
    }
}
