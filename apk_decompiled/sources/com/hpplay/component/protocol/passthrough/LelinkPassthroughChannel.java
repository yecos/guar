package com.hpplay.component.protocol.passthrough;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.LelinkReverseChannel;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.plist.Base64;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.hpplay.component.utils.Encode;
import com.hpplay.sdk.source.utils.CastUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LelinkPassthroughChannel {
    private static final String DECODE_FLAG_END = "\\]\\]\\]\\]\\]L";
    private static final String DECODE_FLAG_START = "L\\[\\[\\[\\[\\[";
    private static final String FLAG_END = "]]]]]L";
    private static final String FLAG_START = "L[[[[[";
    private static final String SP = "Switching Protocols";
    private static String TAG = "LelinkPassthroughChannel";
    private boolean isConnect = false;
    private boolean isIMPush;
    private ParamsMap mMap;
    private int mPType;
    private ProtocolListener mProtocolListener;
    private LelinkReverseChannel mProtocolReceiver;
    private ProtocolSender mProtocolSender;
    private String mSessionId;

    public static class ProtocolResultPaser extends ProtocolListener {
        private ProtocolListener listener;

        public ProtocolResultPaser(int i10, ProtocolListener protocolListener) {
            this.listener = protocolListener;
            this.cmdType = i10;
            CLog.i("lelinkpassths", "start send data ... " + i10);
        }

        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            try {
                if (strArr[0].contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
                    this.listener.onResult(this.cmdType, "successful");
                    CLog.i("lelinkpassths", "cmd :   " + i10 + "  result  :  " + Base64.encodeBytes(strArr[0].getBytes()));
                } else {
                    this.listener.onResult(this.cmdType, "failed");
                    CLog.i("lelinkpassths", "cmd :   " + i10 + " RESULT_FAILED " + Base64.encodeBytes(strArr[0].getBytes()));
                }
            } catch (Exception e10) {
                CLog.w("lelinkpassths", e10);
            }
        }
    }

    public LelinkPassthroughChannel(ParamsMap paramsMap, String str, int i10, ProtocolListener protocolListener) {
        this.mMap = paramsMap;
        this.mSessionId = str;
        this.mProtocolListener = protocolListener;
        this.mPType = i10;
    }

    public static String[] parsePassthroughData(String str) {
        String[] strArr = new String[2];
        try {
            String[] split = str.split(DECODE_FLAG_START);
            String str2 = "";
            String str3 = "";
            for (int i10 = 0; i10 < split.length; i10++) {
                if (split.length - 2 == i10) {
                    str2 = split[i10].split("]]]]]L")[0];
                } else if (split.length - 1 == 2) {
                    str3 = split[i10].split(DECODE_FLAG_END)[0];
                }
            }
            strArr[0] = str2;
            strArr[1] = str3;
            return strArr;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }

    public String buildHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        return nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setContentType(NLProtocolBuiler.CONTENT_TYPE_PLIST).setNewSessionId(ProtocolUtils.createSessionId(this.mMap.getCuid())).setContentLength(i10 + "").getString(true);
    }

    public String buildPassthroughPtc(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("L[[[[[");
        stringBuffer.append(str);
        stringBuffer.append("]]]]]L");
        stringBuffer.append("L[[[[[");
        stringBuffer.append(str2);
        stringBuffer.append("]]]]]L");
        return stringBuffer.toString().trim();
    }

    public String buildPlistProtocol(String str, String str2) {
        String buildPassthroughPtc = buildPassthroughPtc(str, str2);
        if (this.isIMPush) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(buildPassthroughPtc);
            return Encode.encode(jSONArray.toString(), this.mMap.getAppsecret());
        }
        String potocol = new PlistBuilder().addIntagerToRoot("length", buildPassthroughPtc.getBytes().length).addStringToRoot("data", buildPassthroughPtc).getPotocol();
        return buildHeader(new NLProtocolBuiler().getStreamCmd(), potocol.length()) + potocol;
    }

    public void connect() {
        CLog.d(TAG, "connect state : " + this.isConnect + "   ");
        this.isConnect = true;
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
        }
        ProtocolSender protocolSender2 = new ProtocolSender();
        this.mProtocolSender = protocolSender2;
        protocolSender2.setConnectInfo(this.mMap.getIp(), this.mMap.getPort());
        this.mProtocolSender.startConnect(this.mSessionId, null, 1, new ProtocolListener() { // from class: com.hpplay.component.protocol.passthrough.LelinkPassthroughChannel.2
            @Override // com.hpplay.component.common.protocol.ProtocolListener
            public void onResult(int i10, String... strArr) {
                if (strArr[0].contains("successful")) {
                    if (LelinkPassthroughChannel.this.mProtocolListener != null) {
                        LelinkPassthroughChannel.this.mProtocolListener.onResult(18, "successful");
                    }
                } else if (LelinkPassthroughChannel.this.mProtocolListener != null) {
                    LelinkPassthroughChannel.this.mProtocolListener.onResult(18, "failed");
                }
            }
        });
        this.isIMPush = false;
    }

    public void release() {
        CLog.d(TAG, "release SpecialChannel");
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
        }
        LelinkReverseChannel lelinkReverseChannel = this.mProtocolReceiver;
        if (lelinkReverseChannel != null) {
            lelinkReverseChannel.stopReceive();
        }
        CLog.d(TAG, "release complation");
        this.isConnect = false;
        this.mProtocolListener = null;
    }

    public boolean sendPassthData(int i10, String str, String str2, ProtocolListener protocolListener) {
        if (!this.isConnect) {
            return false;
        }
        startSendData(i10, buildPlistProtocol(str, str2), protocolListener);
        return true;
    }

    public void startPassthroughChannel() {
        LelinkReverseChannel lelinkReverseChannel = this.mProtocolReceiver;
        if (lelinkReverseChannel != null) {
            lelinkReverseChannel.stopReceive();
            this.mProtocolReceiver = null;
        }
        this.mProtocolReceiver = new LelinkReverseChannel(this.mMap.getIp(), this.mMap.getPort(), this.mSessionId);
        this.mProtocolReceiver.setRecevelistenerAndProtocol(new ProtocolListener() { // from class: com.hpplay.component.protocol.passthrough.LelinkPassthroughChannel.1
            @Override // com.hpplay.component.common.protocol.ProtocolListener
            public void onResult(int i10, String... strArr) {
                try {
                    CLog.i(LelinkPassthroughChannel.TAG, "---------> cmd :" + i10 + " result : " + Base64.encodeBytes(strArr[0].getBytes()));
                } catch (Exception e10) {
                    CLog.w(LelinkPassthroughChannel.TAG, e10);
                }
                if (strArr[0].contains("Switching Protocols")) {
                    LelinkPassthroughChannel.this.connect();
                    return;
                }
                if (TextUtils.isEmpty(strArr[0])) {
                    return;
                }
                try {
                    NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(strArr[0].getBytes());
                    if (nSDictionary.containsKey("data")) {
                        String obj = nSDictionary.objectForKey("data").toString();
                        if (TextUtils.isEmpty(obj) || LelinkPassthroughChannel.this.mProtocolListener == null) {
                            return;
                        }
                        String[] parsePassthroughData = LelinkPassthroughChannel.parsePassthroughData(obj);
                        LelinkPassthroughChannel.this.mProtocolListener.onResult(19, parsePassthroughData);
                        CLog.i(LelinkPassthroughChannel.TAG, "---------> cmd :" + i10 + " result : " + Base64.encodeBytes(parsePassthroughData[0].getBytes()));
                    }
                } catch (Exception e11) {
                    CLog.w(LelinkPassthroughChannel.TAG, e11);
                }
            }
        }, new NLProtocolBuiler().getPassthReverseCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewLelinkClientId(this.mMap.getMac()).setNewSessionId(this.mSessionId).setPurposeKey("event").setConnectionKey("Upgrade").setContentLength("0").getProtocal(true));
        this.mProtocolReceiver.startReceive();
    }

    public void startSendData(int i10, String str, ProtocolListener protocolListener) {
        if (!this.isIMPush) {
            if (str != null) {
                this.mProtocolSender.protocolEnqueue(new ProtocolResultPaser(i10, protocolListener), str.getBytes());
                return;
            }
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CastUtil.PLAT_TYPE_PC, str);
            sb.append("020017ff");
            sb.append(",");
            sb.append(jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("suid", this.mMap.getCuid());
            jSONObject2.put(ParamsMap.DeviceParams.KEY_RECEIVER_UID, this.mMap.getRuid());
            jSONObject2.put(ParamsMap.DeviceParams.KEY_APPID, this.mMap.getAppKey());
            jSONObject2.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, this.mMap.getToken());
            jSONObject2.put("content", sb.toString());
            CLog.d(TAG, this.mMap.getStringParam(ParamsMap.PushParams.KEY_PASSTH_URL));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }
}
