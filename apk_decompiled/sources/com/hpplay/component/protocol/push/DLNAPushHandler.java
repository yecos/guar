package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.xml.XML;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DLNAPushHandler extends IPushHandler {
    private static final String CMD_TAG = "LLL@BBB";
    private static final String TAG = "DLNAPushHandler";

    public DLNAPushHandler(ParamsMap paramsMap) {
        super(paramsMap);
    }

    private String getMetaData(String str, String str2) {
        if (str.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            str = str.substring(0, str.length() - 1);
        }
        String str3 = !TextUtils.isEmpty(this.mediaAssetName) ? this.mediaAssetName : "DLNA-Video";
        try {
            str = URLDecoder.decode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        try {
            str = (String) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_ESCAPEXMLCHARS, str);
        } catch (Exception e11) {
            CLog.w(TAG, e11);
        }
        String str4 = "0";
        if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_VIDEO)) {
            str4 = new ProtocolBuilder().setDlnaContentUri(this.mPushUri).setId(TextUtils.isEmpty(this.dlnaID) ? "0" : this.dlnaID).setDcTitle(str3).setArtist(this.dlnaArtist).setCreator(this.dlnaCreator).setSize(this.dlnaSize).setChannelId(this.mAppid).setParentId(this.parentId).setDuration(this.dlnaDuration).setResolution(this.dlnaResolution).setDlnaUid(this.mUid).setDlnaSessionId(this.mSessionId).setParentId(this.parentId).setRestricted("0").setUPNPclass(ProtocolBuilder.UPNP_VIDEO_ITEM_CLASS).setProtocolInfo(ProtocolBuilder.PROTOCOLINFO_VIDEO_VALUE).setPath(str).getVideoMetaData().getString(false);
        } else if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_IMAGE)) {
            str4 = new ProtocolBuilder().setDlnaContentUri(this.mPushUri).setDlnaSessionId(this.mSessionId).setPath(str).setSize(0).getImageMetaData().getString(false);
        } else if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
            String str5 = !TextUtils.isEmpty(this.mediaAssetName) ? this.mediaAssetName : "DLNA-Music";
            String str6 = null;
            if (!TextUtils.isEmpty(this.dlnaAlbumUrl)) {
                try {
                    str6 = URLDecoder.decode(this.dlnaAlbumUrl, XML.CHARSET_UTF8);
                } catch (Exception e12) {
                    CLog.w(TAG, e12);
                }
                try {
                    str6 = (String) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_ESCAPEXMLCHARS, str6);
                } catch (Exception e13) {
                    CLog.w(TAG, e13);
                }
            }
            str4 = new ProtocolBuilder().setDlnaContentUri(this.mPushUri).setId(TextUtils.isEmpty(this.dlnaID) ? "0" : this.dlnaID).setDcTitle(str5).setAlbum(this.dlnaAlbum).setChannelId(this.mAppid).setParentId(this.parentId).setAlbumUrl(str6).setArtist(this.dlnaArtist).setCreator(this.dlnaCreator).setSize(this.dlnaSize).setDuration(this.dlnaDuration).setDlnaUid(this.mUid).setDlnaSessionId(this.mSessionId).setParentId("0").setRestricted("0").setUPNPclass(ProtocolBuilder.UPNP_AUDIO_ITEM_CLASS).setProtocolInfo(ProtocolBuilder.PROTOCOLINFO_AUDIO_VALUE).setPath(str).getAudioMetaData().getString(false);
        }
        CLog.i(TAG, "metaData---> " + str4);
        return str4;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildDecreaseVolume() {
        return IDLNAController.DEC_VOLUME;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetPlayInfo() {
        return IDLNAController.GET_POSITION_INFO;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetStateInfo() {
        return IDLNAController.GET_TRANSPORT_INFO;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildIncreaseVolume() {
        return IDLNAController.INC_VOLUME;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPause() {
        return IDLNAController.PAUSE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPush(String str, ParamsMap paramsMap) {
        String str2 = (String) paramsMap.get(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        String stringParam = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_META_DATA);
        if (paramsMap.containsKey(ParamsMap.PushParams.KEY_START_POSITION)) {
            this.mStartPosition = Integer.parseInt(paramsMap.get(ParamsMap.PushParams.KEY_START_POSITION).toString());
        }
        if (TextUtils.isEmpty(stringParam)) {
            stringParam = getMetaData(str, str2);
        }
        return "PlayLLL@BBB" + str + CMD_TAG + stringParam + CMD_TAG + this.mStartPosition;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildResume() {
        return IDLNAController.RESUME;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildSeekTo(int i10) {
        return "SeekLLL@BBB" + i10;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildStopPlay() {
        return IDLNAController.STOP;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            protocolListener.onResult(i10, jSONObject.optString("duration"), jSONObject.optString("position"), jSONObject.optString("url"));
            return true;
        } catch (JSONException e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public void retryHttp(boolean z10) {
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_RETRYHTTP, Boolean.valueOf(z10));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String setVolume(int i10) {
        return "SetVolumeLLL@BBB" + i10;
    }
}
