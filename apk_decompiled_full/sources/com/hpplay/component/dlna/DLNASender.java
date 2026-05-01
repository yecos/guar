package com.hpplay.component.dlna;

import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.upnp.Action;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DLNASender {
    public static String AV_TRANSPORT_1 = "urn:schemas-upnp-org:service:AVTransport:1";
    private static final int DEFAULT_POSITION = -1;
    public static final String DLNA_DURATION = "duration";
    public static final String DLNA_POSITION = "position";
    public static int DMR_SERVER_ERROR = 500;
    public static String DMR_UNSUPPORTED_RESPONSE = "Resource not found";
    public static String GET_MEDIA_INFO = "GetMediaInfo";
    public static String GET_MUTE = "GetMute";
    public static String GET_POSITION_INFO = "GetPositionInfo";
    public static String GET_TRANSPORT_INFO = "GetTransportInfo";
    public static String GET_VOLUME = "GetVolume";
    public static String GET_VOLUME_DB_RANGE = "GetVolumeDBRange";
    public static String HTTP = "http";
    public static String HTTPS = "https";
    public static final String LOADING = "loading";
    private static final String NOT_IMPLEMENTED = "NOT_IMPLEMENTED";
    public static String PAUSE = "Pause";
    public static final String PAUSED = "paused";
    public static String PLAY = "Play";
    public static final String PLAYING = "playing";
    public static String RENDERING_CONTROL = "urn:schemas-upnp-org:service:RenderingControl:1";
    public static String SEEK = "Seek";
    public static String SET_AV_TRANSPORT_URI = "SetAVTransportURI";
    public static String SET_MUTE = "SetMute";
    public static String SET_VOLUME = "SetVolume";
    public static String STOP = "Stop";
    public static final String STOPPED = "stopped";
    private static final String TAG = "DLNASender";
    private String mCUid;
    private String mDesc;
    private Device mDevice;
    public int mErrorCode;
    private String mLocation;
    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
    private boolean isRetryHttp = false;
    public String mErrorMsg = "unknow";
    private int mStartPosition = 0;
    private final Action.ResponseCallbackLisener responseCallbackLisener = new Action.ResponseCallbackLisener() { // from class: com.hpplay.component.dlna.DLNASender.1
        @Override // com.hpplay.cybergarage.upnp.Action.ResponseCallbackLisener
        public void onCallback(String str, String str2) {
            try {
                CLog.i(DLNASender.TAG, "  send play order ===> " + new String(Base64.encode(str.getBytes(), 0)) + " \r\n response === :" + str2);
            } catch (Exception e10) {
                CLog.w(DLNASender.TAG, e10);
            }
        }
    };

    public DLNASender(Device device, String str) {
        this.mCUid = str;
        this.mDevice = device;
    }

    private boolean sendPlayOrder(String str, String str2) {
        try {
            this.mDesc = this.mDevice.getDesc();
            this.mLocation = this.mDevice.getLocation();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null) {
            this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_GETSERVICE;
            return false;
        }
        Action action = service.getAction(SET_AV_TRANSPORT_URI);
        if (action == null) {
            this.mErrorMsg = service.getErrorMsg();
            this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_GETACTION;
            return false;
        }
        Action action2 = service.getAction(PLAY);
        if (action2 == null) {
            this.mErrorMsg = service.getErrorMsg();
            this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_GETPLAY_ACTION;
            return false;
        }
        action.setArgumentValue("InstanceID", 0);
        action.setArgumentValue("CurrentURI", str);
        action.setArgumentValue("CurrentURIMetaData", str2);
        action.setResponseCallbackLisener(this.responseCallbackLisener);
        String str3 = "";
        for (int i10 = 0; i10 < 5; i10++) {
            str3 = action.postPlayAction(this.mCUid);
            if (action.isSuccessful) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
        if (!action.isSuccessful) {
            this.mErrorMsg = str3;
            try {
                if (str3.contains(DMR_UNSUPPORTED_RESPONSE) || str3.toLowerCase().contains(DMR_UNSUPPORTED_RESPONSE.toLowerCase())) {
                    this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_URL_UNSUPPORT;
                    return false;
                }
            } catch (Exception e12) {
                CLog.w(TAG, e12);
            }
            this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_SETURL_CMD;
            return false;
        }
        action2.setArgumentValue("InstanceID", 0);
        action2.setArgumentValue("Speed", "1");
        action2.setResponseCallbackLisener(this.responseCallbackLisener);
        String postPlayAction = action2.postPlayAction(this.mCUid);
        CLog.i(TAG, "PLAY =========>> " + postPlayAction);
        if (action.isSuccessful) {
            return true;
        }
        this.mErrorMsg = postPlayAction;
        this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_PLAYCMD;
        return true;
    }

    public long formatToMillis(String str) {
        CLog.d(TAG, "---formatToMillis --> " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, NOT_IMPLEMENTED)) {
            this.formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            try {
                return this.formatter.parse(str).getTime();
            } catch (ParseException e10) {
                CLog.w(TAG, e10);
            }
        }
        return -1L;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public int getErrCode() {
        return this.mErrorCode;
    }

    public String getErrMsg() {
        return this.mErrorMsg;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public int getMaxVolumeValue() {
        String volumeDbRange = getVolumeDbRange("MaxValue");
        if (TextUtils.isEmpty(volumeDbRange)) {
            return 100;
        }
        return Integer.parseInt(volumeDbRange);
    }

    public String getMediaDuration() {
        Action action;
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null || (action = service.getAction(GET_MEDIA_INFO)) == null) {
            return null;
        }
        action.setArgumentValue("InstanceID", "0");
        if (action.postControlAction(this.mCUid)) {
            return action.getArgumentValue("MediaDuration");
        }
        return null;
    }

    public int getMinVolumeValue() {
        String volumeDbRange = getVolumeDbRange("MinValue");
        if (TextUtils.isEmpty(volumeDbRange)) {
            return 0;
        }
        return Integer.parseInt(volumeDbRange);
    }

    public String getMute() {
        Action action;
        Service service = this.mDevice.getService(RENDERING_CONTROL);
        if (service == null || (action = service.getAction(GET_MUTE)) == null) {
            return null;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Channel", "Master");
        action.postControlAction(this.mCUid);
        return action.getArgumentValue("CurrentMute");
    }

    public String getPositionInfo() {
        long formatToMillis;
        int i10;
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        StringBuilder sb = new StringBuilder();
        sb.append(" start get positionInfo ");
        sb.append(service == null);
        CLog.i(TAG, sb.toString());
        if (service == null) {
            return null;
        }
        Action action = service.getAction(GET_POSITION_INFO);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("action is null ");
        sb2.append(action == null);
        CLog.i(TAG, sb2.toString());
        if (action == null) {
            return null;
        }
        action.setArgumentValue("InstanceID", "0");
        boolean postControlAction = action.postControlAction(this.mCUid);
        CLog.i(TAG, "uis get successful " + postControlAction);
        if (postControlAction) {
            String argumentValue = action.getArgumentValue("AbsTime");
            String argumentValue2 = action.getArgumentValue("RelTime");
            String argumentValue3 = action.getArgumentValue("TrackURI");
            String argumentValue4 = action.getArgumentValue("TrackDuration");
            CLog.i(TAG, " position is  " + argumentValue + " relTime " + argumentValue2);
            if (TextUtils.isEmpty(argumentValue) || TextUtils.equals(argumentValue, NOT_IMPLEMENTED)) {
                formatToMillis = formatToMillis(argumentValue2);
                CLog.i(TAG, "use reltime " + formatToMillis);
            } else if (TextUtils.isEmpty(argumentValue2) || TextUtils.equals(argumentValue2, NOT_IMPLEMENTED)) {
                formatToMillis = formatToMillis(argumentValue);
            } else {
                formatToMillis = formatToMillis(argumentValue2);
                long formatToMillis2 = formatToMillis(argumentValue);
                if (formatToMillis2 > 0 && !TextUtils.equals(argumentValue, argumentValue4)) {
                    formatToMillis = formatToMillis2;
                } else if (formatToMillis <= 0) {
                    formatToMillis = 0;
                }
            }
            CLog.i(TAG, "dlna call back time : position :   " + formatToMillis + " TrackDuration:  " + argumentValue4);
            long formatToMillis3 = formatToMillis(argumentValue4);
            JSONObject jSONObject = new JSONObject();
            if (formatToMillis3 > -1) {
                try {
                    formatToMillis3 /= 1000;
                } catch (Exception e10) {
                    CLog.w(TAG, e10);
                }
            }
            if (formatToMillis > -1) {
                formatToMillis /= 1000;
            }
            if (formatToMillis > 0 && (i10 = this.mStartPosition) > 0) {
                seek(String.valueOf(i10 * 1000));
                this.mStartPosition = 0;
            }
            jSONObject.put("position", formatToMillis);
            jSONObject.put("duration", formatToMillis3);
            jSONObject.put("url", argumentValue3);
            return jSONObject.toString();
        }
        return null;
    }

    public String getTransportState() {
        Action action;
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null || (action = service.getAction(GET_TRANSPORT_INFO)) == null) {
            return null;
        }
        action.setArgumentValue("InstanceID", "0");
        if (!action.postControlAction(this.mCUid)) {
            return null;
        }
        String argumentValue = action.getArgumentValue("CurrentTransportState");
        CLog.i(TAG, "play state " + argumentValue);
        if (TextUtils.isEmpty(argumentValue)) {
            return argumentValue;
        }
        String lowerCase = argumentValue.toLowerCase();
        String str = "paused";
        if (!lowerCase.toLowerCase().contains("paused")) {
            str = "playing";
            if (!lowerCase.toLowerCase().contains("playing")) {
                str = "stopped";
                if (!lowerCase.toLowerCase().contains("stopped")) {
                    return lowerCase;
                }
            }
        }
        return str;
    }

    public int getVoice() {
        Action action;
        Service service = this.mDevice.getService(RENDERING_CONTROL);
        if (service == null || (action = service.getAction(GET_VOLUME)) == null) {
            return -1;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Channel", "Master");
        if (action.postControlAction(this.mCUid)) {
            return action.getArgumentIntegerValue("CurrentVolume");
        }
        return -1;
    }

    public String getVolumeDbRange(String str) {
        Action action;
        Service service = this.mDevice.getService(RENDERING_CONTROL);
        if (service == null || (action = service.getAction(GET_VOLUME_DB_RANGE)) == null) {
            return null;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Channel", "Master");
        if (action.postControlAction(this.mCUid)) {
            return action.getArgumentValue(str);
        }
        return null;
    }

    public String millisToFormat(long j10) {
        CLog.d(TAG, "---Millis   To   Format --> " + j10);
        if (j10 <= 0) {
            return "00:00:00";
        }
        this.formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return this.formatter.format(Long.valueOf(j10));
    }

    public boolean pause() {
        Action action;
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null || (action = service.getAction(PAUSE)) == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", 0);
        return action.postControlAction(this.mCUid);
    }

    public boolean play(String str, String str2) {
        boolean sendPlayOrder = sendPlayOrder(str, str2);
        if (sendPlayOrder || !str.startsWith(HTTPS) || !this.isRetryHttp) {
            return sendPlayOrder;
        }
        String replace = str.replace(HTTPS, HTTP);
        return sendPlayOrder(replace, replace.replace(HTTPS, HTTP));
    }

    public boolean resume() {
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null) {
            return false;
        }
        CLog.i(TAG, "actionList-->" + service.getActionList().toString());
        Action action = service.getAction(PLAY);
        if (action == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", 0);
        action.setArgumentValue("Speed", "1");
        return action.postControlAction(this.mCUid);
    }

    public void retryHttpSwitch(boolean z10) {
        this.isRetryHttp = z10;
    }

    public boolean seek(String str) {
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null) {
            return false;
        }
        String millisToFormat = millisToFormat(Long.valueOf(str).longValue());
        Action action = service.getAction(SEEK);
        if (action == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Unit", "REL_TIME");
        action.setArgumentValue("Target", millisToFormat);
        boolean postControlAction = action.postControlAction(this.mCUid);
        if (postControlAction) {
            return postControlAction;
        }
        action.setArgumentValue("Unit", "ABS_TIME");
        action.setArgumentValue("Target", millisToFormat);
        return action.postControlAction(this.mCUid);
    }

    public boolean setMute(String str) {
        Action action;
        Service service = this.mDevice.getService(RENDERING_CONTROL);
        if (service == null || (action = service.getAction(SET_MUTE)) == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Channel", "Master");
        action.setArgumentValue("DesiredMute", str);
        return action.postControlAction(this.mCUid);
    }

    public void setStartPosition(int i10) {
        this.mStartPosition = i10;
    }

    public boolean setVoice(int i10) {
        Action action;
        Service service = this.mDevice.getService(RENDERING_CONTROL);
        if (service == null || (action = service.getAction(SET_VOLUME)) == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", "0");
        action.setArgumentValue("Channel", "Master");
        action.setArgumentValue("DesiredVolume", i10);
        return action.postControlAction(this.mCUid);
    }

    public boolean stop() {
        Action action;
        Service service = this.mDevice.getService(AV_TRANSPORT_1);
        if (service == null || (action = service.getAction(STOP)) == null) {
            return false;
        }
        action.setArgumentValue("InstanceID", 0);
        return action.postControlAction(this.mCUid);
    }
}
