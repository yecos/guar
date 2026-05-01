package com.hpplay.component.protocol.push;

import android.text.TextUtils;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl r10, java.lang.String... r11) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.push.LelinkV2PushHandler.parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl, java.lang.String[]):void");
    }

    @Override // com.hpplay.component.protocol.push.IPushHandler
    public String setVolume(int i10) {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_PROP_TYPE, PlistBuilder.VALUE_TYPE_VOLUME).addIntagerToRoot("value", i10).getPotocol();
        return builderHeader(new NLProtocolBuiler().getSetHttpProperty(), potocol.length()) + potocol;
    }
}
