package com.hpplay.component.protocol;

import android.content.Context;

/* loaded from: classes2.dex */
public class NLProtocolBuiler extends ProtocolBuilder {
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_PLIST = "application/plist+xml";
    public static final String NEW_HAPPYCAST_AGENT = "HappyCast5,0/500.0";
    public static final String NEW_HAPPYCAST_AGENT_51 = "HappyCast5,1/500.0";
    public static final String NEW_LELINK_ACTION_PLAY = "POST /lelink-play HTTP/1.1";
    private static String NEW_LELINK_ANNOUNCE_CMD = "ANNOUNCE rtsp://%s/%s RTSP/1.0";
    private static String NEW_LELINK_AUDIO_SETUP_CMD = "SETUP rtsp://%s/%s RTSP/1.0";
    public static final String NEW_LELINK_CONNECTION = "POST /lelink-connect HTTP/1.1";
    public static final String NEW_LELINK_DISCONNECT_PLAY = "POST /lelink-disconnect HTTP/1.1";
    public static final String NEW_LELINK_FEEDBACK = "POST /lelink-feedback HTTP/1.1";
    public static final String NEW_LELINK_GET_HTTP_PROPERTY = "POST /lelink-get-property HTTP/1.1";
    public static final String NEW_LELINK_GET_MIRROR_INFO = "GET /lelink-player-info HTTP/1.1";
    public static final String NEW_LELINK_GET_RTSP_PROPERTY = "POST /lelink-get-property RTSP/1.0";
    public static final String NEW_LELINK_MIRRORMODE_CMD = "POST /lelink-mirrormode RTSP/1.0";
    private static final String NEW_LELINK_PASSTH_REVERSE = "POST /passth-reverse HTTP/1.1";
    public static final String NEW_LELINK_PLAYBACK_INFO = "GET /lelink-playinfo HTTP/1.1";
    public static final String NEW_LELINK_PLAYER_SERVER = "GET /lelink-player-info HTTP/1.1";
    public static final String NEW_LELINK_PUASE = "POST /lelink-pause HTTP/1.1";
    private static String NEW_LELINK_RECORD_CMD = "RECORD rtsp://%s/%s RTSP/1.0";
    public static final String NEW_LELINK_RESUME = "POST /lelink-resume HTTP/1.1";
    private static final String NEW_LELINK_REVERSE = "POST /lelink-reverse HTTP/1.1";
    public static final String NEW_LELINK_RTSP_FEEDBACK = "POST /lelink-feedback RTSP/1.0";
    public static final String NEW_LELINK_SEEKTO = "POST /lelink-seekto HTTP/1.1";
    public static final String NEW_LELINK_SETUP = "POST /lelink-setup HTTP/1.1";
    public static final String NEW_LELINK_SET_HTTP_PROPERTY = "POST /lelink-set-property HTTP/1.1";
    public static final String NEW_LELINK_SET_RTSP_PROPERTY = "POST /lelink-set-property RTSP/1.0";
    public static final String NEW_LELINK_STOP = "POST /lelink-stop HTTP/1.1";
    public static final String NEW_LELINK_STREAMING = "POST /lelink-streaming HTTP/1.1";
    private static String NEW_LELINK_TEARDOWN_CMD = "TEARDOWN rtsp://%s/%s RTSP/1.0";
    public static final String NEW_LELINK_VERIFY = "POST /lelink-verify HTTP/1.1";
    private static String NEW_LELINK_VIDEO_SETUP_CMD = "SETUP rtsp://%s/%s RTSP/1.0";
    public static final String NEW_LELINK_VOLUME_CONTR = "POST /lelink-volume HTTP/1.1";
    public static final String RESPONSE_OK = "HTTP/1.1 200 OK";
    private final String TAG = "NLProtocolBuiler";
    private String LELINK_CLIENT_ID = "LeLink-Client-ID: ";
    private String NEW_LELINK_SESSION_ID = "LeLink-Session-ID: ";
    private String NEW_LELINK_CLIENT_NAME = "LeLink-Client-Name: ";
    private String NEW_LELINK_CLIENT_APPID = "LeLink-Client-APPID: ";
    private String NEW_LELINK_CLIENT_VERSION = "LeLink-Client-Version: ";
    private String NEW_LELINK_CLIENT_DID = "LeLink-Client-DID: ";
    private String NEW_LELINK_CLIENT_CU = "LeLink-Client-CU: ";
    private String NEW_LELINK_CLIENT_IIU = "LeLink-Client-UID: ";
    private String NEW_LELINK_CSEQ = "CSeq: ";
    private String NEW_LELINK_PLATFROM = "LeLink-Platform: ";
    private String NEW_PURPOSE_KEY = "LeLink-Purpose: ";
    private String NEW_MIRRORMODE_KEY = "mirror-mode: ";

    public NLProtocolBuiler getActionInfoCmd() {
        this.mBuildProtocol += "GET /lelink-player-info HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getAudioSetUpCmd(String str, String str2) {
        this.mBuildProtocol = String.format(NEW_LELINK_AUDIO_SETUP_CMD, str, str2) + "\r\n";
        return this;
    }

    public String getConnectionProtocol(Context context, String str, int i10) {
        return null;
    }

    public NLProtocolBuiler getHttpProperty() {
        this.mBuildProtocol += "POST /lelink-get-property HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getMirrorModeCmd() {
        this.mBuildProtocol = "POST /lelink-mirrormode RTSP/1.0\r\n";
        return this;
    }

    public NLProtocolBuiler getNewConnectionCmd() {
        this.mBuildProtocol += "POST /lelink-connect HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewFeedbackCmd() {
        this.mBuildProtocol += "POST /lelink-feedback HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLeinkPlayBackInfoCmd() {
        this.mBuildProtocol += "GET /lelink-playinfo HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLeinkPlayCmd() {
        this.mBuildProtocol += "POST /lelink-play HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLeinkPuase() {
        this.mBuildProtocol += "POST /lelink-pause HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLelinkPlayerinfoCmd() {
        this.mBuildProtocol += "GET /lelink-player-info HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLelinkSeekToScrubCmd() {
        this.mBuildProtocol += "POST /lelink-seekto HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewLelinkVolumeContr() {
        this.mBuildProtocol += "POST /lelink-volume HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getNewResumeCmd() {
        this.mBuildProtocol += "POST /lelink-resume HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getPassthReverseCmd() {
        this.mBuildProtocol = "POST /passth-reverse HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getPlayActionCmd() {
        this.mBuildProtocol += "POST /lelink-action HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getRecordCmd(String str, String str2) {
        this.mBuildProtocol = String.format(NEW_LELINK_RECORD_CMD, str, str2) + "\r\n";
        return this;
    }

    public NLProtocolBuiler getRtspFeedbackCmd() {
        this.mBuildProtocol += "POST /lelink-feedback RTSP/1.0\r\n";
        return this;
    }

    public NLProtocolBuiler getRtspProperty() {
        this.mBuildProtocol += "POST /lelink-get-property RTSP/1.0\r\n";
        return this;
    }

    public NLProtocolBuiler getSetHttpProperty() {
        this.mBuildProtocol += "POST /lelink-set-property HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getSetRtspProperty() {
        this.mBuildProtocol += "POST /lelink-set-property HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getSetupCmd() {
        this.mBuildProtocol += "POST /lelink-setup HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getStreamCmd() {
        this.mBuildProtocol += "POST /lelink-streaming HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getTearDownCmd(String str, String str2) {
        this.mBuildProtocol = String.format(NEW_LELINK_TEARDOWN_CMD, str, str2) + "\r\n";
        return this;
    }

    public NLProtocolBuiler getVerifyCmd() {
        this.mBuildProtocol += "POST /lelink-verify HTTP/1.1\r\n";
        return this;
    }

    public NLProtocolBuiler getVideoSetUpCmd(String str, String str2) {
        this.mBuildProtocol = String.format(NEW_LELINK_VIDEO_SETUP_CMD, str, str2) + "\r\n";
        return this;
    }

    public NLProtocolBuiler setMirrorMode(String str) {
        this.mBuildProtocol += this.NEW_MIRRORMODE_KEY + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewCSEQ(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CSEQ + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientAppid(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_APPID + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientCU(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_CU + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientDid(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_DID + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientName(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_NAME + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientUid(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_IIU + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewClientVersion(String str) {
        this.mBuildProtocol += this.NEW_LELINK_CLIENT_VERSION + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewLelinkClientId(String str) {
        this.mBuildProtocol += this.LELINK_CLIENT_ID + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setNewSessionId(String str) {
        this.mBuildProtocol += this.NEW_LELINK_SESSION_ID + str + "\r\n";
        return this;
    }

    public NLProtocolBuiler setPurposeKey(String str) {
        this.mBuildProtocol += this.NEW_PURPOSE_KEY + str + "\r\n";
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler getOptionsCmd() {
        super.getOptionsCmd();
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler getReverseCmd() {
        this.mBuildProtocol = "POST /lelink-reverse HTTP/1.1\r\n";
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler getStopCmd() {
        this.mBuildProtocol += "POST /lelink-stop HTTP/1.1\r\n";
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler setContentType(String str) {
        super.setContentType(str);
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler setPlatfrom() {
        this.mBuildProtocol += this.NEW_LELINK_PLATFROM + "Android\r\n";
        return this;
    }

    @Override // com.hpplay.component.protocol.ProtocolBuilder
    public NLProtocolBuiler setUserAgent(String str) {
        super.setUserAgent(str);
        return this;
    }
}
