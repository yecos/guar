package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LelinkV2PushHandler extends IPushHandler {
    private static final String TAG = "LelinkV2PushHandler";
    public static final int TYPE_APPEND_PLAYLIST = 2;
    public static final int TYPE_CLEAR_PLAYLIST = 3;
    public static final int TYPE_PLAY_ASSIGN = 6;
    public static final int TYPE_PLAY_NEXT = 5;
    public static final int TYPE_PLAY_PRE = 4;
    public static final int TYPE_SET_PLAYLIST = 1;
    private int cseq;
    private String currentMediaType;

    public LelinkV2PushHandler(ParamsMap paramsMap) {
        super(paramsMap);
        this.cseq = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String buildActionContent(ParamsMap paramsMap, int i10) {
        int i11;
        int i12;
        PlistBuilder plistBuilder = new PlistBuilder();
        plistBuilder.addStringToRoot(PlistBuilder.KEY_PROP_TYPE, i10 == 1 ? "set-playlist" : i10 == 2 ? DramaInfoBean.APPEND_PLAY_LIST : i10 == 3 ? DramaInfoBean.CLEAR_PLAY_LIST : i10 == 4 ? "play_prev" : i10 == 5 ? "play_next" : i10 == 6 ? "play_assign" : "");
        String stringParam = paramsMap != null ? paramsMap.getStringParam("category") : "";
        if (i10 == 2 || i10 == 1) {
            plistBuilder.addStringToRoot("curplayid", paramsMap.getStringParam("curplayid")).addIntagerToRoot("period", paramsMap.getIntParam("period")).addStringToRoot("category", stringParam).addIntagerToRoot(ParamsMap.PushParams.KEY_HEAD_DURATION, paramsMap.getIntParam(ParamsMap.PushParams.KEY_HEAD_DURATION)).addIntagerToRoot(ParamsMap.PushParams.KEY_TAIL_DURATION, paramsMap.getIntParam(ParamsMap.PushParams.KEY_TAIL_DURATION)).addStringToRoot("uuid", this.mPushUri);
            this.currentMediaType = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_TYPE).equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO) ? PlistBuilder.TYPE_AUDIO : "video";
            try {
                JSONArray jSONArray = ((JSONObject) paramsMap.get(ParamsMap.PushParams.KEY_PLAY_LIST_JSON)).getJSONArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON);
                plistBuilder.createIPlistArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray.length());
                int i13 = 0;
                while (i13 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i13);
                    plistBuilder.addStringToArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, i13, "name", jSONObject.optString("name"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("urls");
                    plistBuilder.createIPlistArray("urls", jSONArray2.length());
                    int i14 = 0;
                    while (i14 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i14);
                        int optInt = jSONObject2.optInt("width");
                        JSONArray jSONArray3 = jSONArray;
                        int optInt2 = jSONObject2.optInt("height");
                        String optString = jSONObject2.optString("url");
                        JSONArray jSONArray4 = jSONArray2;
                        String optString2 = jSONObject2.optString("playid");
                        String optString3 = jSONObject2.optString("category");
                        plistBuilder.addIntagerToArray("urls", i14, "width", optInt);
                        plistBuilder.addIntagerToArray("urls", i14, "height", optInt2);
                        plistBuilder.addStringToArray("urls", i14, "url", optString);
                        plistBuilder.addStringToArray("urls", i14, "id", optString2);
                        plistBuilder.addStringToArray("urls", i14, "category", optString3);
                        i14++;
                        jSONArray = jSONArray3;
                        jSONArray2 = jSONArray4;
                    }
                    plistBuilder.addArrayToArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, i13, "urls");
                    i13++;
                    jSONArray = jSONArray;
                }
                plistBuilder.addArrayToRoot(ParamsMap.PushParams.KEY_PLAY_LIST_JSON);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } else if (i10 == 6) {
            String stringParam2 = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME);
            String stringParam3 = paramsMap.getStringParam("curplayid");
            String stringParam4 = paramsMap.getStringParam("url");
            try {
                i11 = ((Integer) paramsMap.get("width")).intValue();
            } catch (Exception e11) {
                e = e11;
                i11 = 0;
            }
            try {
                i12 = ((Integer) paramsMap.get("height")).intValue();
            } catch (Exception e12) {
                e = e12;
                CLog.w(TAG, e);
                i12 = 0;
                plistBuilder.addStringToRoot("name", stringParam2);
                plistBuilder.addStringToRoot("curplayid", stringParam3);
                plistBuilder.addStringToRoot("url", stringParam4);
                plistBuilder.addIntagerToRoot("width", i11);
                plistBuilder.addIntagerToRoot("height", i12);
                String potocol = plistBuilder.getPotocol();
                CLog.i(TAG, " content : " + potocol);
                return potocol;
            }
            plistBuilder.addStringToRoot("name", stringParam2);
            plistBuilder.addStringToRoot("curplayid", stringParam3);
            plistBuilder.addStringToRoot("url", stringParam4);
            plistBuilder.addIntagerToRoot("width", i11);
            plistBuilder.addIntagerToRoot("height", i12);
        }
        String potocol2 = plistBuilder.getPotocol();
        CLog.i(TAG, " content : " + potocol2);
        return potocol2;
    }

    private String buildPlayContent(String str, ParamsMap paramsMap) {
        String str2;
        String potocol;
        String stringParam = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        String stringParam2 = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME);
        String stringParam3 = paramsMap.getStringParam("category");
        String stringParam4 = paramsMap.getStringParam("playid");
        if (stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO) || stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_VIDEO)) {
            str2 = stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO) ? PlistBuilder.TYPE_AUDIO : "video";
            potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, str2).createIPlistArray("items", 1).addIntagerToArray("items", 0, PlistBuilder.KEY_START_POSITION, this.mStartPosition).addStringToArray("items", 0, "uuid", this.mPushUri).addStringToArray("items", 0, PlistBuilder.KEY_CONTENT_LOCATION, str).addStringToArray("items", 0, "name", stringParam2).addStringToArray("items", 0, "category", stringParam3).addStringToArray("items", 0, "playid", stringParam4).addArrayToRoot("items").getPotocol();
        } else {
            PlistBuilder plistBuilder = new PlistBuilder();
            str2 = PlistBuilder.TYPE_IMAGE;
            potocol = plistBuilder.addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, PlistBuilder.TYPE_IMAGE).createIPlistArray("items", 1).addStringToArray("items", 0, "uuid", this.mPushUri).addStringToArray("items", 0, PlistBuilder.KEY_CONTENT_LOCATION, str).addArrayToRoot("items").getPotocol();
        }
        this.currentMediaType = str2;
        return potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildAddPlayList(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 2);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildAudiotrack(int i10) {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_PROP_TYPE, PlistBuilder.VALUE_TYPE_AUDIOTRACK).addIntagerToRoot("value", i10).addStringToRoot("uuid", this.mPushUri).getPotocol();
        return builderHeader(new NLProtocolBuiler().getSetHttpProperty(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildClearList() {
        String buildActionContent = buildActionContent(null, 3);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildDecreaseVolume() {
        String potocol = new PlistBuilder().addStringToRoot("type", PlistBuilder.VALUE_TYPE_VOLUME).addStringToRoot("event", PlistBuilder.VALUE_TYPE_DECREASE).getPotocol();
        return builderHeader(new NLProtocolBuiler().getNewLelinkVolumeContr(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetPlayInfo() {
        return builderHeader(new NLProtocolBuiler().getNewLeinkPlayBackInfoCmd(), 0);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildGetStateInfo() {
        return null;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildIncreaseVolume() {
        String potocol = new PlistBuilder().addStringToRoot("type", PlistBuilder.VALUE_TYPE_VOLUME).addStringToRoot("event", PlistBuilder.VALUE_TYPE_INCREASE).getPotocol();
        return builderHeader(new NLProtocolBuiler().getNewLelinkVolumeContr(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPause() {
        String potocol = new PlistBuilder().addStringToRoot("uuid", this.mPushUri).getPotocol();
        return builderHeader(new NLProtocolBuiler().getNewLeinkPuase(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPlayNext() {
        String buildActionContent = buildActionContent(null, 5);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPlayPre() {
        String buildActionContent = buildActionContent(null, 4);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildPush(String str, ParamsMap paramsMap) {
        String buildPlayContent = buildPlayContent(str, paramsMap);
        return builderHeader(new NLProtocolBuiler().getNewLeinkPlayCmd(), buildPlayContent.length()) + buildPlayContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildResume() {
        String potocol = new PlistBuilder().addStringToRoot("uuid", this.mPushUri).getPotocol();
        return builderHeader(new NLProtocolBuiler().getNewResumeCmd(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildSeekTo(int i10) {
        String potocol = new PlistBuilder().addStringToRoot("type", "position").addStringToRoot("uuid", this.mPushUri).addIntagerToRoot(PlistBuilder.KEY_SEEK_POSTION, i10).getPotocol();
        return builderHeader(new NLProtocolBuiler().getNewLelinkSeekToScrubCmd(), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildSelectPlay(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 6);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildSetPlayList(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 1);
        return builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length()) + buildActionContent;
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String buildStopPlay() {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, this.currentMediaType).addStringToRoot("uuid", this.mPushUri).getPotocol();
        return builderHeader(new NLProtocolBuiler().getStopCmd(), potocol.length()) + potocol;
    }

    public String builderHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        this.cseq++;
        return nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setContentType(NLProtocolBuiler.CONTENT_TYPE_PLIST).setNewLelinkClientId("0x" + this.mMac).setNewSessionId(this.mSessionId).setNewClientUid(this.mUid).setNewCSEQ(String.valueOf(this.cseq)).setContentLength(i10 + "").getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String getReverseData() {
        return new NLProtocolBuiler().getReverseCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewLelinkClientId("0x" + this.mMac).setNewSessionId(this.mSessionId).setPurposeKey("event").setConnectionKey("Upgrade").setContentLength("0").getString(true);
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        String obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(str.getBytes()));
                if (nSDictionary.containsKey("duration")) {
                    String obj2 = nSDictionary.containsKey("uuid") ? nSDictionary.objectForKey("uuid").toString() : "";
                    String obj3 = nSDictionary.objectForKey("duration").toString();
                    String obj4 = nSDictionary.objectForKey("position").toString();
                    obj = nSDictionary.containsKey("playid") ? nSDictionary.objectForKey("playid").toString() : "";
                    if (protocolListener != null) {
                        protocolListener.onResult(i10, obj3, obj4, obj2, obj);
                    }
                    return true;
                }
                if (nSDictionary.containsKey("playid")) {
                    obj = nSDictionary.containsKey("uuid") ? nSDictionary.objectForKey("uuid").toString() : "";
                    String obj5 = nSDictionary.objectForKey("playid").toString();
                    if (protocolListener != null) {
                        protocolListener.onResult(i10, "curPlayInfo", obj5, obj);
                    }
                    return true;
                }
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0164, code lost:
    
        if (r4.equals("stopped") == false) goto L58;
     */
    @Override // com.hpplay.component.protocol.push.IPushHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseReversePlist(PushControllerImpl pushControllerImpl, String... strArr) {
        if (strArr != null) {
            char c10 = 0;
            String str = strArr[0];
            if (str == null) {
                return;
            }
            CLog.d(TAG, "---------------->" + str);
            if (str.contains(IPushHandler.SP)) {
            }
            if (str.contains(IPushHandler.PHOTO_HIDE) && pushControllerImpl != null) {
                CLog.d(TAG, "on PHOTO_HIDE");
                pushControllerImpl.disConnect();
                pushControllerImpl.eventCallback(16, new String[0]);
                return;
            }
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(str.getBytes());
                if (nSDictionary != null) {
                    String obj = nSDictionary.containsKey("playid") ? nSDictionary.objectForKey("playid").toString() : "";
                    String obj2 = nSDictionary.containsKey("uuid") ? nSDictionary.objectForKey("uuid").toString() : "";
                    String obj3 = nSDictionary.containsKey("duration") ? nSDictionary.objectForKey("duration").toString() : "0";
                    String obj4 = nSDictionary.containsKey("position") ? nSDictionary.objectForKey("position").toString() : "0";
                    if (nSDictionary.containsKey(IPushHandler.READY_PLAY)) {
                        return;
                    }
                    try {
                        if (Integer.parseInt(obj3) > 0 && Integer.parseInt(obj4) > 0 && pushControllerImpl != null) {
                            CLog.d(TAG, "reverse to uiduration : " + obj3 + "position : " + obj4);
                            pushControllerImpl.eventCallback(17, obj3, obj4, obj2);
                            return;
                        }
                    } catch (Exception e10) {
                        CLog.w(TAG, e10);
                    }
                    if (nSDictionary.containsKey(IPushHandler.STOP_TYPE) && pushControllerImpl != null) {
                        String obj5 = nSDictionary.objectForKey(IPushHandler.STOP_TYPE).toString();
                        if (TextUtils.equals(obj5, IPushHandler.MEDIA_COMPLETION)) {
                            pushControllerImpl.eventCallback(12, obj2, obj);
                        } else if (TextUtils.equals(obj5, IPushHandler.PHONE_VIDEO_HIDE)) {
                            pushControllerImpl.eventCallback(16, obj2, obj);
                            CLog.d(TAG, "on stop");
                        }
                        pushControllerImpl.disConnect();
                        return;
                    }
                    if (!nSDictionary.containsKey(IPushHandler.STATE) || pushControllerImpl == null) {
                        return;
                    }
                    String obj6 = nSDictionary.objectForKey(IPushHandler.STATE).toString();
                    obj6.hashCode();
                    switch (obj6.hashCode()) {
                        case -1884319283:
                            break;
                        case -995321554:
                            if (obj6.equals("paused")) {
                                c10 = 1;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case -493563858:
                            if (obj6.equals("playing")) {
                                c10 = 2;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 96784904:
                            if (obj6.equals("error")) {
                                c10 = 3;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 336650556:
                            if (obj6.equals("loading")) {
                                c10 = 4;
                                break;
                            }
                            c10 = 65535;
                            break;
                        default:
                            c10 = 65535;
                            break;
                    }
                    switch (c10) {
                        case 0:
                            if (nSDictionary.containsKey(IPushHandler.REASON)) {
                                String obj7 = nSDictionary.objectForKey(IPushHandler.REASON).toString();
                                if (!TextUtils.equals(obj7, IPushHandler.ENDED)) {
                                    if (!TextUtils.equals(obj7, IPushHandler.EPISODE_STOPED)) {
                                        if (TextUtils.equals(obj7, IPushHandler.PREEMPT_STOPPED)) {
                                            pushControllerImpl.eventCallback(28, obj2, obj);
                                            break;
                                        }
                                    } else {
                                        pushControllerImpl.eventCallback(26, obj2, obj);
                                        break;
                                    }
                                } else {
                                    pushControllerImpl.eventCallback(12, obj2, obj);
                                    break;
                                }
                            }
                            pushControllerImpl.eventCallback(16, obj2, obj);
                            pushControllerImpl.disConnect();
                            CLog.i(TAG, "state on stop---------");
                            break;
                        case 1:
                            CLog.i(TAG, "PAUSED " + this.isPlaying);
                            pushControllerImpl.eventCallback(15, obj2, obj);
                            break;
                        case 2:
                            pushControllerImpl.eventCallback(13, obj2, obj);
                            CLog.i(TAG, "--- PLAYING ---");
                            break;
                        case 3:
                            CLog.d(TAG, MediaError.ERROR_TYPE_ERROR);
                            pushControllerImpl.eventCallback(16, obj2, obj);
                            break;
                        case 4:
                            pushControllerImpl.eventCallback(14, obj2, obj);
                            CLog.i(TAG, "LOADING");
                            break;
                    }
                }
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String setVolume(int i10) {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_PROP_TYPE, PlistBuilder.VALUE_TYPE_VOLUME).addIntagerToRoot("value", i10).getPotocol();
        return builderHeader(new NLProtocolBuiler().getSetHttpProperty(), potocol.length()) + potocol;
    }
}
