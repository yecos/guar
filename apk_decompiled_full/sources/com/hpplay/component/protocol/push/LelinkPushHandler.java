package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.component.dlna.DLNAControllerImp;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LelinkPushHandler extends IPushHandler {
    private static final String TAG = "LelinkPushHandler";

    public LelinkPushHandler(ParamsMap paramsMap) {
        super(paramsMap);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildDecreaseVolume() {
        return new ProtocolBuilder().getsubVolumeCmd().setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setContentLength("0").setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetPlayInfo() {
        return new ProtocolBuilder().getPositionCmd().setContentType(ProtocolBuilder.CONTENT_APPLE_PLAYLIST_TYPE).setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetStateInfo() {
        return null;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildIncreaseVolume() {
        return new ProtocolBuilder().getaddVolumeCmd().setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setContentLength("0").setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPause() {
        return new ProtocolBuilder().getPauseCmd().setContentLength("0").setUserAgent(this.mUserAgent).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPush(String str, ParamsMap paramsMap) {
        CLog.i(TAG, "start ----------->" + this.mSessionId);
        String str2 = paramsMap.containsKey("screencode") ? (String) paramsMap.get("screencode") : "";
        String str3 = paramsMap.containsKey("header") ? (String) paramsMap.get("header") : "";
        String str4 = (String) paramsMap.get(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        TextUtils.isEmpty(str2);
        String string = new ProtocolBuilder().setContentLocation(str).setStartPosition(this.mStartPosition + "").setContentUri(this.mPushUri).getString(true);
        ProtocolBuilder contentLength = new ProtocolBuilder().getPlayCmd().setContentType(ProtocolBuilder.CONTENT_TEXT_TYPE).setContentLength(string.getBytes().length + "");
        boolean equals = str4.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO);
        String str5 = ProtocolBuilder.HAPPYCAST_AUDIO_AGENT;
        String string2 = contentLength.setUserAgent(equals ? ProtocolBuilder.HAPPYCAST_AUDIO_AGENT : ProtocolBuilder.MEDIACONTROL_AGENT).setAutorization(str2).setUserLelinkSessionId(this.mSessionId).setPlatfrom().setMobileDeviceName(DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel()).setDevicesIMEI(this.mImei).setMobileDeviceChannel(this.mAppid).setLelinkDeviceId(this.mHid).setMobileDevCu(this.mUid).setDeviceType("Android").getString(true);
        if (!TextUtils.isEmpty(str3)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mStartPosition", this.mStartPosition);
                jSONObject.put("playUrl", str);
                jSONObject.put("urlId", this.mPushUri);
                jSONObject.put("header", str3);
                string = jSONObject.toString();
            } catch (Exception e10) {
                e = e10;
                string = string;
            }
            try {
                ProtocolBuilder contentLength2 = new ProtocolBuilder().getSendVideoInfoCmd().setContentType(ProtocolBuilder.CONTENT_TEXT_TYPE).setContentLength(string.getBytes().length + "");
                if (!str4.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
                    str5 = ProtocolBuilder.MEDIACONTROL_AGENT;
                }
                string2 = contentLength2.setUserAgent(str5).setUserLelinkSessionId(this.mSessionId).setPlatfrom().setMobileDeviceName(DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel()).setDevicesIMEI(this.mImei).setMobileDeviceChannel(this.mAppid).setLelinkDeviceId(this.mHid).setMobileDevCu(this.mUid).setDeviceType("Android").getString(true);
            } catch (Exception e11) {
                e = e11;
                CLog.w(TAG, e);
                string2 = string2;
                return string2 + string;
            }
        }
        return string2 + string;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildResume() {
        return new ProtocolBuilder().getRecoverPlayCmd().setContentLength("0").setUserAgent(this.mUserAgent).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildSeekTo(int i10) {
        return String.format(new ProtocolBuilder().getSetPositionCmd().setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true), Integer.valueOf(i10));
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildStopPlay() {
        CLog.i(TAG, "----------->" + this.mSessionId);
        return new ProtocolBuilder().getStopCmd().setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String getReverseData() {
        return new ProtocolBuilder().getReverseCmd().setUpgradeKey(ProtocolBuilder.UPGRADE_PTTH).setConnectionKey("Upgrade").setApplePurposeKey("event").setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        if (str.contains("duration:") && str.contains("position:")) {
            try {
                String trim = str.substring(str.lastIndexOf(SOAP.DELIM) + 1).trim();
                String substring = str.substring(0, str.lastIndexOf("position"));
                String trim2 = substring.substring(substring.lastIndexOf(SOAP.DELIM) + 1).trim();
                if (protocolListener != null) {
                    protocolListener.onResult(i10, trim2, trim);
                }
                return true;
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        return false;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public synchronized void parseReversePlist(PushControllerImpl pushControllerImpl, String... strArr) {
        char c10;
        if (strArr != null) {
            String str = strArr[0];
            if (str != null) {
                CLog.d(TAG, str);
                if (str.contains(IPushHandler.SP)) {
                    return;
                }
                if (str.contains(IPushHandler.PHOTO_HIDE)) {
                    CLog.d(TAG, "on PHOTO_HIDE");
                    pushControllerImpl.disConnect();
                    return;
                }
                try {
                    NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(str.getBytes());
                    if (nSDictionary != null) {
                        String obj = nSDictionary.containsKey(IPushHandler.KEY_URL_ID) ? nSDictionary.objectForKey(IPushHandler.KEY_URL_ID).toString() : "";
                        String upperFirstChar = upperFirstChar("duration");
                        String upperFirstChar2 = upperFirstChar("position");
                        String obj2 = nSDictionary.containsKey(upperFirstChar) ? nSDictionary.objectForKey(upperFirstChar).toString() : "0";
                        String obj3 = nSDictionary.containsKey(upperFirstChar2) ? nSDictionary.objectForKey(upperFirstChar2).toString() : "0";
                        try {
                            if (Integer.valueOf(obj2).intValue() > 0 && Integer.valueOf(obj3).intValue() > 0) {
                                CLog.d(TAG, "reverse to uiduration : " + obj2 + "position : " + obj3);
                                pushControllerImpl.eventCallback(17, obj2, obj3, obj);
                            }
                        } catch (Exception e10) {
                            CLog.w(TAG, e10);
                        }
                        if (nSDictionary.containsKey(IPushHandler.STOP_TYPE)) {
                            String obj4 = nSDictionary.objectForKey(IPushHandler.STOP_TYPE).toString();
                            if (TextUtils.equals(obj4, IPushHandler.MEDIA_COMPLETION)) {
                                pushControllerImpl.disConnect();
                                pushControllerImpl.eventCallback(12, obj);
                                CLog.d(TAG, "on completion");
                                return;
                            } else if (TextUtils.equals(obj4, IPushHandler.PHONE_VIDEO_HIDE)) {
                                CLog.d(TAG, "on stop");
                                pushControllerImpl.disConnect();
                                pushControllerImpl.eventCallback(7, obj);
                                return;
                            }
                        }
                        if (nSDictionary.containsKey(IPushHandler.STATE)) {
                            String obj5 = nSDictionary.objectForKey(IPushHandler.STATE).toString();
                            switch (obj5.hashCode()) {
                                case -1884319283:
                                    if (obj5.equals("stopped")) {
                                        c10 = 3;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -995321554:
                                    if (obj5.equals("paused")) {
                                        c10 = 2;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -493563858:
                                    if (obj5.equals("playing")) {
                                        c10 = 0;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 96784904:
                                    if (obj5.equals("error")) {
                                        c10 = 4;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 336650556:
                                    if (obj5.equals("loading")) {
                                        c10 = 1;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                default:
                                    c10 = 65535;
                                    break;
                            }
                            if (c10 == 0) {
                                if (!this.isPlaying) {
                                    this.isPlaying = true;
                                    pushControllerImpl.eventCallback(13, obj);
                                }
                                CLog.d(TAG, DLNAControllerImp.PLAYING);
                            } else if (c10 == 1) {
                                CLog.d(TAG, "LOADING");
                                pushControllerImpl.eventCallback(14, obj);
                            } else if (c10 == 2) {
                                CLog.d(TAG, "PAUSED ");
                                if (this.isPlaying) {
                                    pushControllerImpl.eventCallback(15, obj);
                                }
                                this.isPlaying = false;
                            } else if (c10 == 3) {
                                pushControllerImpl.disConnect();
                                CLog.d(TAG, "STOPPED ");
                                pushControllerImpl.eventCallback(16, obj);
                                CLog.d(TAG, "state on stop---------");
                            } else if (c10 == 4) {
                                CLog.d(TAG, MediaError.ERROR_TYPE_ERROR);
                                pushControllerImpl.disConnect();
                                pushControllerImpl.eventCallback(16, obj);
                            }
                        }
                    }
                } catch (Exception e11) {
                    CLog.w(TAG, e11);
                }
            }
        }
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String setVolume(int i10) {
        return null;
    }

    public String upperFirstChar(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 == 0) {
                stringBuffer.append(String.valueOf(charArray[0]).toUpperCase());
            } else {
                stringBuffer.append(charArray[i10]);
            }
        }
        return stringBuffer.toString();
    }
}
