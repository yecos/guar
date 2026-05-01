package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class IPushHandler {
    public static final String DURATION = "duration";
    public static final String ENDED = "ended";
    public static final String EPISODE_STOPED = "episode_stopped";
    public static final String ERROR = "error";
    public static final String KEY_URL = "url";
    public static final String KEY_URL_ID = "urlID";
    public static final String KEY_UUID = "uuid";
    public static final String LOADING = "loading";
    public static final String MEDIA_COMPLETION = "media_completion";
    public static final String PAUSED = "paused";
    public static final String PHONE_VIDEO_HIDE = "phonevideohide";
    public static final String PHOTO_HIDE = "photohide";
    public static final String PLAYING = "playing";
    public static final String POSITION = "position";
    public static final String PREEMPT_STOPPED = "preempt_stopped";
    public static final String READY_PLAY = "readyToPlay";
    public static final String REASON = "reason";
    public static final String SP = "Switching Protocols";
    public static final String STATE = "state";
    public static final String STOPPED = "stopped";
    public static final String STOP_TYPE = "stoptype";
    public static final String SUPPORT_DANGBEI_APP_VERSION_NUM1 = "5.0.1.6";
    public static final String SUPPORT_DANGBEI_APP_VERSION_NUM2 = "5.2.1.1";
    public static final String SUPPORT_HAISENSE_VERSION_NUM = "5.3.2.9";
    private static final String TAG = "IPushHandler";
    public String dlnaAlbum;
    public String dlnaAlbumUrl;
    public String dlnaArtist;
    public String dlnaCreator;
    public String dlnaDuration;
    public String dlnaID;
    public String dlnaResolution;
    public long dlnaSize;
    public boolean isPlaying;
    public String mAppid;
    public String mConnectSessionId;
    public String mHid;
    public String mImei;
    public String mMac;
    public String mMethod;
    public String mNonce;
    public String mPushUri;
    public String mRealm;
    public String mSessionId;
    public int mStartPosition;
    public String mUid;
    public String mUri;
    public String mUserAgent;
    public String mediaAssetName;
    public String parentId;

    public class ProtocolResultParser extends ProtocolListener {
        private final ProtocolListener listener;

        public ProtocolResultParser(int i10, ProtocolListener protocolListener) {
            this.listener = protocolListener;
            this.cmdType = i10;
        }

        private void addReportInfo(JSONObject jSONObject) {
            jSONObject.put("uri", IPushHandler.this.mPushUri);
            jSONObject.put(ParamsMap.DeviceParams.KEY_SESSION_ID, IPushHandler.this.mSessionId);
            jSONObject.put(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, IPushHandler.this.mConnectSessionId);
        }

        private void convertAndCallback(int i10, ProtocolListener protocolListener, String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                protocolListener.onResult(i10, "failed");
                return;
            }
            if (i10 != 1) {
                if (i10 == 8) {
                    if (IPushHandler.this.parsePlayBackInfo(i10, strArr[0], protocolListener)) {
                        return;
                    }
                    protocolListener.onResult(i10, strArr);
                    return;
                } else {
                    if (i10 == 9) {
                        protocolListener.onResult(i10, strArr);
                        return;
                    }
                    if (!strArr[0].contains(ProtocolBuilder.LELINK_STATE_SUCCESS) && !strArr[0].contains("successful")) {
                        protocolListener.onResult(i10, "failed");
                        return;
                    } else {
                        if (protocolListener != null) {
                            protocolListener.onResult(i10, "successful");
                            return;
                        }
                        return;
                    }
                }
            }
            if (strArr[0].contains(ProtocolBuilder.LELINK_STATE_SCREENCODE) && screenCodeCallback(i10, protocolListener, strArr[0])) {
                return;
            }
            if (strArr[0].contains(ProtocolBuilder.LELINK_STATE_SUCCESS) || strArr[0].contains("successful")) {
                JSONObject jSONObject = new JSONObject();
                addReportInfo(jSONObject);
                protocolListener.onResult(i10, "successful", jSONObject.toString());
                return;
            }
            if (!"failed".equals(strArr[0])) {
                if (!(IPushHandler.this instanceof LelinkV2PushHandler)) {
                    protocolListener.onResult(i10, strArr);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                addReportInfo(jSONObject2);
                protocolListener.onResult(i10, "successful", jSONObject2.toString());
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strArr[1]);
            addReportInfo(jSONObject3);
            strArr[1] = jSONObject3.toString();
            protocolListener.onResult(i10, strArr);
            CLog.i(IPushHandler.TAG, "======RESULT_FAILED============>>> " + jSONObject3.toString().replace(".", ""));
        }

        private boolean screenCodeCallback(int i10, ProtocolListener protocolListener, String str) {
            String[] split = str.split("\r\n");
            if (split == null || split.length <= 0) {
                return false;
            }
            String str2 = split[split.length - 1];
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int indexOf = str2.indexOf(Operator.Operation.EQUALS);
            int indexOf2 = str2.indexOf(",");
            String replace = str2.substring(indexOf + 1, indexOf2 - 1).replace("\"", "");
            String substring = str2.substring(indexOf2 + 1);
            String replace2 = substring.substring(substring.indexOf(Operator.Operation.EQUALS) + 1).replace("\"", "");
            IPushHandler iPushHandler = IPushHandler.this;
            iPushHandler.mRealm = replace;
            iPushHandler.mNonce = replace2;
            iPushHandler.mMethod = "POST";
            iPushHandler.mUri = "/play";
            CLog.d(IPushHandler.TAG, "author  :  " + str2);
            if (protocolListener == null) {
                return false;
            }
            protocolListener.onResult(i10, "screencode");
            return true;
        }

        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            try {
                CLog.d(IPushHandler.TAG, " result  :  " + strArr[0]);
                convertAndCallback(i10, this.listener, strArr);
            } catch (Exception e10) {
                CLog.w(IPushHandler.TAG, e10);
            }
        }
    }

    public IPushHandler(ParamsMap paramsMap) {
        this.mUserAgent = ProtocolBuilder.MEDIACONTROL_AGENT;
        this.mStartPosition = 0;
        this.mPushUri = paramsMap.getStringParam("uri");
        this.mImei = paramsMap.getStringParam("imei");
        this.mAppid = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_APPID);
        this.dlnaDuration = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_DURATION);
        try {
            this.dlnaSize = Long.parseLong(paramsMap.getParam(ParamsMap.PushParams.KEY_DLNA_SIZE, 0).toString());
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (paramsMap.containsKey(ParamsMap.PushParams.KEY_START_POSITION)) {
            this.mStartPosition = Integer.parseInt(paramsMap.get(ParamsMap.PushParams.KEY_START_POSITION).toString());
        }
        this.dlnaResolution = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_RESOLUTION);
        this.mUid = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_UID);
        this.mHid = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_HID);
        this.mSessionId = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SESSION_ID);
        this.mConnectSessionId = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID);
        this.mMac = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_MAC);
        this.mediaAssetName = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME);
        this.dlnaAlbum = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_ALBUM);
        this.dlnaAlbumUrl = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_ALBUM_URL);
        this.dlnaArtist = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_ARTIST);
        this.dlnaCreator = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_CREATOR);
        this.dlnaID = paramsMap.getStringParam("playid");
        String stringParam = paramsMap.getStringParam("dlna_parentId");
        this.parentId = stringParam;
        this.parentId = TextUtils.isEmpty(stringParam) ? "0" : this.parentId;
        String stringParam2 = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_CHANNEL_VERSION);
        if (TextUtils.isEmpty(stringParam2)) {
            return;
        }
        if (stringParam2.contains("5.0.1.6") || stringParam2.contains("5.2.1.1")) {
            this.mUserAgent = ProtocolBuilder.HAPPYCAST_AGENT;
        }
    }

    public String buildAddPlayList(ParamsMap paramsMap) {
        return null;
    }

    public String buildAudiotrack(int i10) {
        return null;
    }

    public String buildClearList() {
        return null;
    }

    public abstract String buildDecreaseVolume();

    public abstract String buildGetPlayInfo();

    public abstract String buildGetStateInfo();

    public abstract String buildIncreaseVolume();

    public abstract String buildPause();

    public String buildPlayNext() {
        return null;
    }

    public String buildPlayPre() {
        return null;
    }

    public abstract String buildPush(String str, ParamsMap paramsMap);

    public abstract String buildResume();

    public abstract String buildSeekTo(int i10);

    public String buildSelectPlay(ParamsMap paramsMap) {
        return null;
    }

    public String buildSetPlayList(ParamsMap paramsMap) {
        return null;
    }

    public abstract String buildStopPlay();

    public ProtocolListener getProtocolListener(int i10, ProtocolListener protocolListener) {
        return new ProtocolResultParser(i10, protocolListener);
    }

    public String getReverseData() {
        return null;
    }

    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        return false;
    }

    public void parseReversePlist(PushControllerImpl pushControllerImpl, String... strArr) {
    }

    public abstract String setVolume(int i10);
}
