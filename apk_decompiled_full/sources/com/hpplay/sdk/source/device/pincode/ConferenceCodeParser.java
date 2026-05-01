package com.hpplay.sdk.source.device.pincode;

import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConferenceCodeParser implements CodeParser {
    private static final String NEW_VERSION = "1.1";
    private static final String OLD_VERSION = "1.0";
    private static final String PUSH_SETTINGS = "/conference/pushSettings?";
    private static final String TAG = "ConferenceCodeParser";
    private int agentPOrt = 30000;
    private String guestModePincode;
    private IConferenceMirrorListener mConferenceMirrorListener;
    private IConferenceFuzzyMatchingPinCodeListener mFuzzyMatchingPinCodeListener;
    private LelinkServiceInfo mLelinkServiceInfo;
    private IServiceInfoParseListener mListener;

    public static /* synthetic */ int access$304(ConferenceCodeParser conferenceCodeParser) {
        int i10 = conferenceCodeParser.agentPOrt + 1;
        conferenceCodeParser.agentPOrt = i10;
        return i10;
    }

    public static String codeEncrypt(String str) {
        try {
            byte[] bArr = (byte[]) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_PROTOCOLUTILS_STRTOMDHASH, "lebo" + str);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (Integer.toHexString(bArr[i10] & UnsignedBytes.MAX_VALUE).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(bArr[i10] & UnsignedBytes.MAX_VALUE));
                } else {
                    stringBuffer.append(Integer.toHexString(bArr[i10] & UnsignedBytes.MAX_VALUE));
                }
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private String createToken(String str, String str2) {
        String codeEncrypt = codeEncrypt(str + "_" + str2);
        return !TextUtils.isEmpty(codeEncrypt) ? codeEncrypt.toLowerCase() : "";
    }

    private Map<String, String> getHeaderParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        return hashMap;
    }

    private void parseDigitsOnlyPinCode(final String str) {
        String str2 = System.currentTimeMillis() + "";
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_HTTP_CODE, str);
        hashMap.put("t", str2);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, createToken(str, str2));
        hashMap.put("v", "1.1");
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sConferenceCodeAuth, HapplayUtils.getMapParams(hashMap));
        asyncHttpParameter.in.requestHeaders = getHeaderParam();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.pincode.ConferenceCodeParser.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.w(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode cancel request");
                    return;
                }
                SourceLog.debug(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode onRequestResult result:" + asyncHttpParameter2.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType != 0) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: resultType not success");
                    if (ConferenceCodeParser.this.mListener != null) {
                        ConferenceCodeParser.this.mListener.onParseResult(5, null);
                        return;
                    }
                    return;
                }
                String str3 = out.result;
                if (TextUtils.isEmpty(str3)) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: response is empty");
                    if (ConferenceCodeParser.this.mListener != null) {
                        ConferenceCodeParser.this.mListener.onParseResult(5, null);
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.optInt(Constant.KEY_STATUS) != 200) {
                        SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: status not equals 200");
                        if (ConferenceCodeParser.this.mListener != null) {
                            ConferenceCodeParser.this.mListener.onParseResult(5, null);
                            return;
                        }
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        LelinkServiceInfo conferenceInfo = LelinkServiceInfoCreator.getConferenceInfo(optJSONObject, str);
                        if (conferenceInfo != null) {
                            if (ConferenceCodeParser.this.mListener != null) {
                                ConferenceCodeParser.this.mListener.onParseResult(1, conferenceInfo);
                                return;
                            }
                            return;
                        } else {
                            SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: parse info is null");
                            if (ConferenceCodeParser.this.mListener != null) {
                                ConferenceCodeParser.this.mListener.onParseResult(5, null);
                                return;
                            }
                            return;
                        }
                    }
                    SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: data is empty");
                    if (ConferenceCodeParser.this.mListener != null) {
                        ConferenceCodeParser.this.mListener.onParseResult(5, null);
                    }
                } catch (Exception unused) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseDigitsOnlyPinCode error: response not json");
                    if (ConferenceCodeParser.this.mListener != null) {
                        ConferenceCodeParser.this.mListener.onParseResult(5, null);
                    }
                }
            }
        });
    }

    private void parseFuzzyMatchingPinCode(PinCodeInfo pinCodeInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("vals", pinCodeInfo.pinCode);
        hashMap.put("pageNum", String.valueOf(pinCodeInfo.page));
        hashMap.put("pageSize", String.valueOf(pinCodeInfo.cout));
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sConferenceLikeEqAuth, HapplayUtils.getMapParams(hashMap));
        asyncHttpParameter.in.requestHeaders = getHeaderParam();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.pincode.ConferenceCodeParser.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.w(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode cancel request");
                    return;
                }
                SourceLog.debug(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode onRequestResult result:" + asyncHttpParameter2.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType != 0) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: resultType not success");
                    if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                        ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                        return;
                    }
                    return;
                }
                String str = out.result;
                if (TextUtils.isEmpty(str)) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: response is empty");
                    if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                        ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(Constant.KEY_STATUS) != 200) {
                        SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: status not equals 200");
                        if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                            ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                            return;
                        }
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode total:" + optJSONObject.optInt("total") + " pageNum:" + optJSONObject.optInt("pageNum") + " pageSize:" + optJSONObject.optInt("pageSize") + " pages:" + optJSONObject.optInt(f.f10338t));
                        JSONArray optJSONArray = optJSONObject.optJSONArray("rows");
                        if (optJSONArray == null) {
                            SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: rows is empty");
                            if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                                ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            LelinkServiceInfo conferenceFuzzyMatchingInfo = LelinkServiceInfoCreator.getConferenceFuzzyMatchingInfo(optJSONArray.optJSONObject(i10));
                            if (conferenceFuzzyMatchingInfo != null) {
                                arrayList.add(conferenceFuzzyMatchingInfo);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                                ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(1, arrayList);
                                return;
                            }
                            return;
                        } else {
                            SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: LelinkServiceInfo infos is empty");
                            if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                                ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                                return;
                            }
                            return;
                        }
                    }
                    SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: data is empty");
                    if (ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener != null) {
                        ConferenceCodeParser.this.mFuzzyMatchingPinCodeListener.onParseResult(5, null);
                    }
                } catch (Exception unused) {
                    SourceLog.i(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode error: response not json");
                    if (ConferenceCodeParser.this.mListener != null) {
                        ConferenceCodeParser.this.mListener.onParseResult(5, null);
                    }
                }
            }
        });
    }

    public String getGeustModeIp(int i10) {
        String[] split = HapplayUtils.getLoaclIp().split("\\.");
        return split[0] + "." + split[1] + "." + split[2] + "." + (i10 % 256);
    }

    public void parseGuestPinCode(String str) {
        try {
            int intValue = Integer.valueOf(str).intValue();
            int i10 = ((intValue / 256) % 51) + 50000;
            String geustModeIp = getGeustModeIp(intValue);
            if (TextUtils.isEmpty(geustModeIp)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", geustModeIp);
            jSONObject.put("linkPort", i10);
            jSONObject.put(ParamsMap.DeviceParams.KEY_AIRPLAY_PORT, i10);
            jSONObject.put("name", "访客模式设备");
            LelinkServiceInfo conferenceInfo = LelinkServiceInfoCreator.getConferenceInfo(jSONObject, str);
            IServiceInfoParseListener iServiceInfoParseListener = this.mListener;
            if (iServiceInfoParseListener != null) {
                iServiceInfoParseListener.onParseResult(1, conferenceInfo);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            IServiceInfoParseListener iServiceInfoParseListener2 = this.mListener;
            if (iServiceInfoParseListener2 != null) {
                iServiceInfoParseListener2.onParseResult(0, null);
            }
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void parsePinCode(PinCodeInfo pinCodeInfo) {
        if (TextUtils.isEmpty(pinCodeInfo.pinCode)) {
            SourceLog.i(TAG, "parsePinCode pinCode is empty");
            IServiceInfoParseListener iServiceInfoParseListener = this.mListener;
            if (iServiceInfoParseListener != null) {
                iServiceInfoParseListener.onParseResult(0, null);
                return;
            }
            return;
        }
        String trim = pinCodeInfo.pinCode.trim();
        SourceLog.i(TAG, "parsePinCode trim:" + trim + " length:" + trim.length());
        if (pinCodeInfo.isFuzzyMatching) {
            parseFuzzyMatchingPinCode(pinCodeInfo);
        } else {
            parseDigitsOnlyPinCode(pinCodeInfo.pinCode);
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void release() {
    }

    public void resetGuestMode(String str, IConferenceMirrorListener iConferenceMirrorListener) {
        try {
            this.guestModePincode = str;
            String geustModeIp = getGeustModeIp(Integer.valueOf(str).intValue());
            this.mConferenceMirrorListener = iConferenceMirrorListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("guestMode", HTTP.CLOSE);
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter("http://" + geustModeIp + SOAP.DELIM + this.agentPOrt + PUSH_SETTINGS + "type=visitorAuth&data=" + jSONObject.toString(), null);
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            in.requestMethod = 1;
            in.connectTimeout = 3000;
            in.readTimeout = 2000;
            in.tryCount = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.pincode.ConferenceCodeParser.5
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    if (asyncHttpParameter2.out.resultType == 2) {
                        SourceLog.w(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode cancel request");
                    } else {
                        try {
                            SourceLog.debug(ConferenceCodeParser.TAG, "startSetGuestMode  request  " + asyncHttpParameter2.out.result);
                            if (new JSONObject(asyncHttpParameter2.out.result).getInt(Constant.KEY_STATUS) == 200) {
                                ConferenceCodeParser.this.agentPOrt = 30000;
                                if (ConferenceCodeParser.this.mConferenceMirrorListener != null) {
                                    ConferenceCodeParser.this.mConferenceMirrorListener.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_OK);
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e10) {
                            SourceLog.w(ConferenceCodeParser.TAG, e10);
                        }
                    }
                    SourceLog.i(ConferenceCodeParser.TAG, "reset guest mode   failed");
                    if (ConferenceCodeParser.this.agentPOrt < 30003) {
                        ConferenceCodeParser.access$304(ConferenceCodeParser.this);
                        ConferenceCodeParser conferenceCodeParser = ConferenceCodeParser.this;
                        conferenceCodeParser.resetGuestMode(conferenceCodeParser.guestModePincode, ConferenceCodeParser.this.mConferenceMirrorListener);
                    } else {
                        ConferenceCodeParser.this.agentPOrt = 30000;
                        if (ConferenceCodeParser.this.mConferenceMirrorListener != null) {
                            ConferenceCodeParser.this.mConferenceMirrorListener.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_FAILED);
                        }
                    }
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            IConferenceMirrorListener iConferenceMirrorListener2 = this.mConferenceMirrorListener;
            if (iConferenceMirrorListener2 != null) {
                iConferenceMirrorListener2.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_FAILED);
            }
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void setCodeCallback(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mListener = iServiceInfoParseListener;
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void setConferenceFuzzyMatchingPinCodeCallback(IConferenceFuzzyMatchingPinCodeListener iConferenceFuzzyMatchingPinCodeListener) {
        this.mFuzzyMatchingPinCodeListener = iConferenceFuzzyMatchingPinCodeListener;
    }

    public void setGuestMode(LelinkServiceInfo lelinkServiceInfo, String str, String str2, IConferenceMirrorListener iConferenceMirrorListener) {
        this.mLelinkServiceInfo = lelinkServiceInfo;
        this.mConferenceMirrorListener = iConferenceMirrorListener;
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("password", str2);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sConferenceVisitorAuth + "username=" + str + "&password=" + str2, null);
        asyncHttpParameter.in.requestMethod = 0;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.pincode.ConferenceCodeParser.3
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.w(ConferenceCodeParser.TAG, "setGuestMode cancel request");
                    return;
                }
                try {
                    SourceLog.debug(ConferenceCodeParser.TAG, "setGuestMode  request" + asyncHttpParameter2.out.result);
                    JSONObject jSONObject = new JSONObject(asyncHttpParameter2.out.result);
                    if (jSONObject.getInt(Constant.KEY_STATUS) == 200) {
                        ConferenceCodeParser.this.startSetGuestMode(jSONObject.getJSONObject("data").getString(ParamsMap.DeviceParams.KEY_AUTH_TOKEN));
                    }
                } catch (Exception e10) {
                    SourceLog.w(ConferenceCodeParser.TAG, e10);
                    if (ConferenceCodeParser.this.mConferenceMirrorListener != null) {
                        ConferenceCodeParser.this.mConferenceMirrorListener.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
                    }
                }
            }
        });
    }

    public void startSetGuestMode(String str) {
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sConferenceSetGuestMode + ("ip=" + this.mLelinkServiceInfo.getIp() + "&agentPort=" + this.mLelinkServiceInfo.getAgentPort() + "&token=" + str), null);
        asyncHttpParameter.in.requestMethod = 0;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.pincode.ConferenceCodeParser.4
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.w(ConferenceCodeParser.TAG, "parseFuzzyMatchingPinCode cancel request");
                } else {
                    try {
                        SourceLog.debug(ConferenceCodeParser.TAG, "startSetGuestMode  request" + asyncHttpParameter2.out.result);
                        if (new JSONObject(asyncHttpParameter2.out.result).getInt(Constant.KEY_STATUS) != 200 || ConferenceCodeParser.this.mConferenceMirrorListener == null) {
                            return;
                        }
                        ConferenceCodeParser.this.mConferenceMirrorListener.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK);
                        return;
                    } catch (Exception e10) {
                        SourceLog.w(ConferenceCodeParser.TAG, e10);
                    }
                }
                if (ConferenceCodeParser.this.mConferenceMirrorListener != null) {
                    ConferenceCodeParser.this.mConferenceMirrorListener.onInfo(202, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
                }
            }
        });
    }
}
