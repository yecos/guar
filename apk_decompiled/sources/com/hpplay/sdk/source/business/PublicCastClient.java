package com.hpplay.sdk.source.business;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.Encode;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.imsdk.IMConnectBean;
import com.hpplay.imsdk.IMEntrance;
import com.hpplay.imsdk.OnConnectServerListener;
import com.hpplay.imsdk.OnReceiveMessageListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CapbilityBean;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.NetCastPassSender;
import com.hpplay.sdk.source.pass.Parser;
import com.hpplay.sdk.source.pass.Pass;
import com.hpplay.sdk.source.pass.bean.NetPassBean;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventIMChannel;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.browser.ble.BleProxy;
import com.hpplay.sdk.source.protocol.connect.AbsIMMsgReceiveListener;
import com.hpplay.sdk.source.protocol.connect.CloudConnectBridge;
import com.hpplay.sdk.source.protocol.connect.OnConnectIMListener;
import com.hpplay.sdk.source.protocol.connect.OnConnectSinkListener;
import com.hpplay.sdk.source.protocol.connect.OnPlayStateListener;
import com.hpplay.sdk.source.utils.Feature;
import com.taobao.accs.common.Constants;
import com.titans.entity.CdnType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PublicCastClient {
    private static final int ACTION_APP_MSG_END = 83886079;
    private static final int ACTION_APP_MSG_START = 50331903;
    private static final int ACTION_CONNECT = 33555967;
    private static final int ACTION_CONNECT_MESSAGE = 33556479;
    private static final int ACTION_DEVICE_RIGHTS_UPDATE = 33568511;
    private static final int ACTION_GET_TV_INFO = 33556735;
    private static final int ACTION_INTERACTIVE = 33559295;
    private static final int ACTION_MEETING_CLOSE = 34604287;
    private static final int ACTION_MEETING_KICK_OFF = 34604031;
    private static final int ACTION_MIRROR = 33555199;
    private static final int ACTION_PASS = 33560575;
    private static final int ACTION_PLAY_CONTROL = 33555711;
    private static final int ACTION_PLAY_STATUS = 33555455;
    private static final int ACTION_PUSH = 33554943;
    private static final int ACTION_REVERSE_EVENT = 33567999;
    private static final int ACTION_SINK_ACCEPT_MEETING = 34605055;
    private static final int ACTION_SINK_SERVICE_MESSAGE = 33568255;
    private static final int ACTION_UPLOAD_LOG = 33566975;
    private static final String COMMAND_CONNECT = "020005ff";
    private static final String COMMAND_DISCONNECT = "020038ff";
    private static final String COMMAND_PLAY_CONTROL = "020004ff";
    private static final String COMMAND_PUSH = "020001ff";
    private static final String COMMAND_PUSH_LIST = "020037ff";
    private static final String CONNECT_ACTION = "/Connect";
    private static final String KEY_APPID = "appid";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_PASSTHROUGH_CONTENT = "pc";
    private static final String KEY_PROTOCOL_VERSION = "ver";
    private static final String KEY_RECEIVER_APPID = "ra";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_U = "u";
    private static final String KEY_UID = "uid";
    private static final String KEY_USERINFO = "user_info";
    private static final int PLAY_ACTION_NEXt_DRAMA = 9;
    private static final int PLAY_ACTION_PAUSE = 2;
    private static final int PLAY_ACTION_PRE_DRAMA = 10;
    private static final int PLAY_ACTION_SEEK = 4;
    private static final int PLAY_ACTION_SELECT_TRACK = 11;
    private static final int PLAY_ACTION_SET_PLAY_ID = 8;
    private static final int PLAY_ACTION_START = 1;
    private static final int PLAY_ACTION_STOP = 3;
    private static final int PLAY_ACTION_VOLUME_ADD = 6;
    private static final int PLAY_ACTION_VOLUME_REDUCE = 7;
    private static final int PLAY_ACTION_VOLUME_TO = 5;
    private static final int PLAY_CALLBACK_ERROR = 4;
    private static final int PLAY_CALLBACK_PAUSE = 2;
    private static final int PLAY_CALLBACK_PLAYING = 0;
    private static final int PLAY_CALLBACK_START = 1;
    private static final int PLAY_CALLBACK_STOP = 3;
    public static final int PLAY_STATE_ERROR = 4;
    public static final int PLAY_STATE_PAUSE = 2;
    public static final int PLAY_STATE_PROGRESS = 0;
    public static final int PLAY_STATE_START = 1;
    public static final int PLAY_STATE_STOP = 3;
    private static final String PUSH_ACTION = "/PushUrl";
    private static final String TAG = "PublicCastClient";
    private static PublicCastClient mInstance;
    private static int mRCEventCount;
    private Context mContext;
    private NetCastPassSender mNetCastPassSender;
    private String mToken;
    private String mUrl;
    private final int IM_AUTH_RESULT_SUCCESS = 0;
    private final int IM_AUTH_RESULT_FAIL = 1;
    private final int IM_AUTH_RESULT_SERVER_FULL = 2;
    private List<OnConnectIMListener> mIMListenerList = new ArrayList();
    private OnPlayStateListener mPlayStateListener = null;
    private List<AbsIMMsgReceiveListener> mIMMsgReceiveListenerList = new ArrayList();
    private Map<String, CloudConnectBridge> mConnectBridgeMap = new HashMap();
    private OnReceiveMessageListener mMsgListener = new OnReceiveMessageListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.1
        @Override // com.hpplay.imsdk.OnReceiveMessageListener
        public void onMsg(long j10, String str) {
            SourceLog.i(PublicCastClient.TAG, "OnReceiveMessageListener action：" + j10);
            switch ((int) j10) {
                case PublicCastClient.ACTION_MIRROR /* 33555199 */:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.optString(BrowserInfo.KEY_POL);
                        jSONObject.optString("app_id");
                        String optString = jSONObject.optString("sid");
                        String optString2 = jSONObject.optString("suid");
                        String optString3 = jSONObject.optString("roomid");
                        String optString4 = jSONObject.optString("username");
                        String optString5 = jSONObject.optString("uri");
                        if (LelinkSdkManager.getInstance().mOuterCloudMirrorPlayListener != null) {
                            SourceLog.i(PublicCastClient.TAG, "ACTION_MIRROR");
                            LelinkSdkManager.getInstance().mOuterCloudMirrorPlayListener.onCloudMirrorStart(true, optString4, optString3, optString2, optString, optString5);
                            SourceDataReport.getInstance().onReceiveCloudMirrorConnectRequest(optString, optString, optString5, optString3);
                            break;
                        } else {
                            SourceLog.w(PublicCastClient.TAG, "ACTION_MIRROR ignore");
                            break;
                        }
                    } catch (Exception e10) {
                        SourceLog.w(PublicCastClient.TAG, e10);
                    }
                case PublicCastClient.ACTION_PLAY_STATUS /* 33555455 */:
                    PublicCastClient.this.resolvePlayStateMsg(str);
                    break;
                case PublicCastClient.ACTION_CONNECT_MESSAGE /* 33556479 */:
                    PublicCastClient.this.resolveConnectMsg(str);
                    break;
                case PublicCastClient.ACTION_INTERACTIVE /* 33559295 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_INTERACTIVE do nothing");
                    break;
                case PublicCastClient.ACTION_PASS /* 33560575 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_PASS " + str);
                    NetPassBean formJson = NetPassBean.formJson(str);
                    if (formJson != null) {
                        PublicCastClient.this.processPassMsg(formJson.pc);
                        break;
                    }
                    break;
                case PublicCastClient.ACTION_UPLOAD_LOG /* 33566975 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_UPLOAD_LOG");
                    break;
                case PublicCastClient.ACTION_REVERSE_EVENT /* 33567999 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_REVERSE_EVENT");
                    PublicCastClient.this.reverseEventMsg(str);
                    break;
                case PublicCastClient.ACTION_SINK_SERVICE_MESSAGE /* 33568255 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_SINK_SERVICE_MESSAGE");
                    PublicCastClient.this.reveiveSinkServiceMsg(1, str);
                    break;
                case PublicCastClient.ACTION_DEVICE_RIGHTS_UPDATE /* 33568511 */:
                    SourceLog.i(PublicCastClient.TAG, "ACTION_DEVICE_RIGHTS_UPDATE");
                    RightsManager.getInstance().vipAuth();
                    break;
                case PublicCastClient.ACTION_MEETING_KICK_OFF /* 34604031 */:
                    PublicCastClient.this.reveiveSinkServiceMsg(3, str);
                    break;
                case PublicCastClient.ACTION_MEETING_CLOSE /* 34604287 */:
                    PublicCastClient.this.reveiveSinkServiceMsg(4, str);
                    break;
                case PublicCastClient.ACTION_SINK_ACCEPT_MEETING /* 34605055 */:
                    PublicCastClient.this.reveiveSinkServiceMsg(2, str);
                    break;
                default:
                    if (j10 >= 50331903 && j10 <= 83886079) {
                        SourceLog.i(PublicCastClient.TAG, "onMsg IM app msg");
                        break;
                    }
                    break;
            }
        }
    };
    private boolean isCallbackSeverFailed = false;
    private OnConnectServerListener mServerListener = new OnConnectServerListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.2
        @Override // com.hpplay.imsdk.OnConnectServerListener
        public void onAuthCallback(String str) {
            SourceLog.i(PublicCastClient.TAG, "authResult,result: " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (new JSONObject(str).optInt(Constants.KEY_HTTP_CODE) == 2) {
                    AuthSDK.getInstance().updateIMRootUrl();
                }
            } catch (Exception e10) {
                SourceLog.w(PublicCastClient.TAG, e10);
            }
        }

        @Override // com.hpplay.imsdk.OnConnectServerListener
        public void onConnectFailed() {
            if (PublicCastClient.this.isCallbackSeverFailed) {
                SourceLog.i(PublicCastClient.TAG, "onConnectFailed ignore");
                return;
            }
            for (OnConnectIMListener onConnectIMListener : PublicCastClient.this.mIMListenerList) {
                PublicCastClient.this.isCallbackSeverFailed = true;
                onConnectIMListener.onConnectFailed();
            }
        }

        @Override // com.hpplay.imsdk.OnConnectServerListener
        public void onConnectSuccess() {
            SourceLog.i(PublicCastClient.TAG, "onConnectSuccess");
            BleProxy.startPublish(PublicCastClient.this.mContext, Preference.getInstance().get(Preference.KEY_DEVICE_ID));
            PublicCastClient.this.isCallbackSeverFailed = false;
            Iterator it = PublicCastClient.this.mIMListenerList.iterator();
            while (it.hasNext()) {
                ((OnConnectIMListener) it.next()).onConnectSuccess();
            }
        }

        @Override // com.hpplay.imsdk.OnConnectServerListener
        public void onRestart() {
            SourceLog.i(PublicCastClient.TAG, "onRestart");
            PublicCastClient.this.reconnect();
        }
    };

    private PublicCastClient(Context context) {
        this.mContext = context;
        this.mNetCastPassSender = new NetCastPassSender(context);
    }

    private String decodeXORData(String str) {
        String str2 = Session.getInstance().appSecret;
        if (TextUtils.isEmpty(str2)) {
            SourceLog.i(TAG, "decodeXORData appsecret is empty");
        }
        return Encode.decode(str, str2);
    }

    private String encodeXORData(String str) {
        String str2 = Session.getInstance().appSecret;
        if (TextUtils.isEmpty(str2)) {
            SourceLog.i(TAG, "encodeXORData appsecret is empty");
        }
        try {
            return Encode.encode(URLEncoder.encode(str, XML.CHARSET_UTF8), str2);
        } catch (UnsupportedEncodingException e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private JSONObject genConnectContent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", Session.getInstance().getUID());
            jSONObject.put("u", str2);
            jSONObject.put("appid", Session.getInstance().appKey);
            jSONObject.put("token", a.a());
            jSONObject.put(KEY_USERINFO, str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    private JSONObject genPostContent(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", Session.getInstance().getUID());
            jSONObject.put("u", str3);
            jSONObject.put("appid", Session.getInstance().appKey);
            jSONObject.put(KEY_RECEIVER_APPID, str2);
            jSONObject.put("ver", Constant.DATAREPORT_PROTOCOL_VER);
            jSONObject.put("token", a.a());
            jSONObject.put("content", str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public static synchronized PublicCastClient getInstance() {
        PublicCastClient publicCastClient;
        synchronized (PublicCastClient.class) {
            if (mInstance == null) {
                init(HapplayUtils.getApplication());
            }
            publicCastClient = mInstance;
        }
        return publicCastClient;
    }

    public static void init(Context context) {
        synchronized (PublicCastClient.class) {
            if (mInstance == null) {
                mInstance = new PublicCastClient(context);
            }
        }
    }

    private boolean isServerConnected() {
        return IMEntrance.getInstance().isConnected();
    }

    private void playControl(OutParameter outParameter, final int i10, int i11, int i12, String str, int i13) {
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject jSONObject = new JSONObject();
        try {
            String uid = outParameter.currentBrowserInfo.getUid();
            jSONObject.put("sid", outParameter.session);
            jSONObject.put("st", i10);
            jSONObject.put("uri", outParameter.urlID);
            if (i10 == 4) {
                jSONObject.put("seekto", i11);
            } else if (i10 == 5) {
                jSONObject.put("vt", i12);
            } else if (i10 == 8) {
                jSONObject.put("dramaid", str);
            } else if (i10 == 11) {
                jSONObject.put("trackIndex", i13);
            }
            stringBuffer.append("020004ff");
            stringBuffer.append(",");
            stringBuffer.append(jSONObject.toString());
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + PUSH_ACTION, genPostContent(stringBuffer.toString(), uid).toString());
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            in.requestMethod = 1;
            in.connectTimeout = 2000;
            in.readTimeout = 2000;
            IMQueue.getInstance().addTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.5
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    AsyncHttpParameter.Out out;
                    if (asyncHttpParameter2 == null || (out = asyncHttpParameter2.out) == null || out.result == null) {
                        SourceLog.w(PublicCastClient.TAG, "playControl " + i10 + " failed");
                        return;
                    }
                    SourceLog.debug(PublicCastClient.TAG, "playControl " + i10 + " " + asyncHttpParameter2.out.result);
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPassMsg(String str) {
        SourceLog.i(TAG, "processPassMsg");
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "processPassMsg error:data is empty");
            return;
        }
        String decodeXORData = decodeXORData(str);
        try {
            decodeXORData = URLDecoder.decode(decodeXORData, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (TextUtils.isEmpty(decodeXORData)) {
            SourceLog.i(TAG, "processPassMsg error:decodeXORData is empty");
            return;
        }
        Parser parser = Parser.getInstance();
        try {
            JSONArray jSONArray = new JSONArray(decodeXORData);
            if (jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    parser.parseByNetCast(jSONArray.optString(i10));
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolveConnectMsg(String str) {
        SourceLog.i(TAG, "resolveConnectMsg " + str);
        try {
            CloudConnectBridge cloudConnectBridge = this.mConnectBridgeMap.get(new JSONObject(str).optString("sid"));
            if (cloudConnectBridge != null) {
                cloudConnectBridge.resolveConnectMsg(str);
                return;
            }
            SourceLog.i(TAG, "resolveConnectMsg ignore, cloudConnectBridge is null. map: " + this.mConnectBridgeMap);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolvePlayStateMsg(String str) {
        OutParameter lastPlayInfo;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("st"));
            String optString = jSONObject.optString("uri");
            String optString2 = jSONObject.optString("dramaid");
            if (!TextUtils.isEmpty(optString2) && (lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo()) != null) {
                lastPlayInfo.dramaID = optString2;
            }
            if (parseInt == 0) {
                if (this.mPlayStateListener != null) {
                    this.mPlayStateListener.onPlaying(optString, jSONObject.optInt("duration"), jSONObject.optInt("period"));
                    return;
                }
                return;
            }
            if (parseInt == 1) {
                OnPlayStateListener onPlayStateListener = this.mPlayStateListener;
                if (onPlayStateListener != null) {
                    onPlayStateListener.onStart(optString);
                    return;
                }
                return;
            }
            if (parseInt == 2) {
                OnPlayStateListener onPlayStateListener2 = this.mPlayStateListener;
                if (onPlayStateListener2 != null) {
                    onPlayStateListener2.onPause(optString);
                    return;
                }
                return;
            }
            if (parseInt == 3) {
                if (this.mPlayStateListener != null) {
                    this.mPlayStateListener.onStop(optString, jSONObject.optInt(DramaInfoBean.CATEGORY_STD));
                }
            } else {
                if (parseInt != 4) {
                    return;
                }
                SourceLog.i(TAG, "resolvePlayStateMsg PLAY_CALLBACK_ERROR:" + jSONObject.optString("er"));
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reveiveSinkServiceMsg(int i10, String str) {
        SourceLog.i(TAG, "reveiveSinkServiceMsg " + str);
        Iterator<AbsIMMsgReceiveListener> it = this.mIMMsgReceiveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onMsgReceive(i10, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reverseEventMsg(String str) {
        int parseInt;
        SourceLog.i(TAG, "reverseEventMsg " + str);
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("m");
            String optString = jSONObject.optString("ts");
            parseInt = Integer.parseInt(optString);
            SourceLog.i(TAG, "reverseEventMsg ts:" + optString + "mRCEventCount:" + mRCEventCount + ", count:" + parseInt);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (parseInt < mRCEventCount) {
            mRCEventCount = 0;
        } else {
            mRCEventCount = parseInt;
            SinkTouchEventIMChannel.getInstance().onReceiveIMTouchEvent(str2);
        }
    }

    public void addVolume(OutParameter outParameter) {
        playControl(outParameter, 6, -1, -1, null, -1);
    }

    public void connectServer(String str, String str2, OnConnectIMListener onConnectIMListener) {
        if (Feature.isDisableIM()) {
            return;
        }
        if (onConnectIMListener != null && !this.mIMListenerList.contains(onConnectIMListener)) {
            this.mIMListenerList.add(onConnectIMListener);
        }
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "connectServer ignore,invalid url");
            return;
        }
        this.isCallbackSeverFailed = false;
        this.mUrl = str;
        this.mToken = str2;
        SourceLog.i(TAG, "connectServer: " + str);
        IMEntrance.getInstance().disconnect();
        CapbilityBean capbilityBean = new CapbilityBean();
        capbilityBean.localip = DeviceUtil.getIPAddress(this.mContext);
        try {
            capbilityBean.pol = Feature.cloudMirrorSupportProtocol();
            capbilityBean.fe = "10000000";
            if (TextUtils.isEmpty(DeviceUtil.getBluetoothName())) {
                capbilityBean.name = "uk";
            } else {
                capbilityBean.name = URLEncoder.encode(DeviceUtil.getBluetoothName(), XML.CHARSET_UTF8);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        capbilityBean.localport = Session.getInstance().serverPort + "";
        String jSONObject = capbilityBean.encode().toString();
        IMConnectBean iMConnectBean = new IMConnectBean();
        iMConnectBean.imUrl = this.mUrl;
        iMConnectBean.uid = Session.getInstance().getUID();
        iMConnectBean.appid = Session.getInstance().appKey;
        iMConnectBean.sdkVersion = 41214;
        iMConnectBean.token = this.mToken;
        iMConnectBean.capability = jSONObject;
        IMEntrance.getInstance().setReceiveMessageListener(this.mMsgListener);
        IMEntrance.getInstance().setOnConnectListener(this.mServerListener);
        IMEntrance.getInstance().connect(iMConnectBean);
    }

    public void connectTV(BrowserInfo browserInfo, String str, String str2, String str3, final OnConnectSinkListener onConnectSinkListener, CloudConnectBridge cloudConnectBridge) {
        if (!isServerConnected()) {
            SourceLog.w(TAG, "connectTV ignore, is not connect server yet");
            return;
        }
        this.mConnectBridgeMap.put(str3, cloudConnectBridge);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", str3);
            jSONObject.put("suid", Session.getInstance().getUID());
            jSONObject.put("shid", Session.getInstance().getHID());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sname", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("sicon", str2);
            }
            jSONObject.put("sdkv", "4.12.14");
            jSONObject.put("app_id", "2004");
            String string = FieldUtil.getString(FieldUtil.f7332m);
            Session.getInstance();
            jSONObject.put(string, Session.DEFAULT_M);
            jSONObject.put("sm", Pass.SM_PASS_THROUGH);
            jSONObject.put("one_to_multi", Preference.getInstance().get(Constant.KEY_CLOUD_MULTI_CAST, 0));
            jSONObject.put("vuuid", Preference.getInstance().get(Constant.KEY_VUUID));
            jSONObject.put("vsession", Preference.getInstance().get(Constant.KEY_VSESSION));
            jSONObject.put("tid", Session.getInstance().tid);
            try {
                jSONObject.put("sdid", "");
                jSONObject.put("uuid", "");
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            jSONObject.put("sc", Session.getInstance().appKey);
            jSONObject.put("s_oaid", DeviceUtil.getOAID(this.mContext));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("020005ff");
            stringBuffer.append(",");
            stringBuffer.append(jSONObject.toString());
            JSONObject genConnectContent = genConnectContent(stringBuffer.toString(), browserInfo.getUid());
            final HttpEncrypt httpEncrypt = new HttpEncrypt();
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + CONNECT_ACTION, httpEncrypt.encode(genConnectContent.toString()));
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            in.requestMethod = 1;
            in.requestHeaders = httpEncrypt.buildHeader();
            IMQueue.getInstance().addTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.3
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    int optInt;
                    AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                    if (out == null || out.resultType != 2) {
                        if (out == null || TextUtils.isEmpty(out.result)) {
                            OnConnectSinkListener onConnectSinkListener2 = onConnectSinkListener;
                            if (onConnectSinkListener2 != null) {
                                onConnectSinkListener2.onDisconnect(212011);
                                return;
                            }
                            return;
                        }
                        String decode = httpEncrypt.decode(asyncHttpParameter2.out);
                        SourceLog.debug(PublicCastClient.TAG, "connectTV onRequestResult " + decode);
                        try {
                            optInt = new JSONObject(decode).optInt(Constant.KEY_STATUS);
                        } catch (Exception e11) {
                            SourceLog.w(PublicCastClient.TAG, e11);
                        }
                        if (optInt == 200) {
                            SourceLog.w(PublicCastClient.TAG, "send connectTV success");
                            return;
                        }
                        if (optInt == 403) {
                            SourceLog.w(PublicCastClient.TAG, "connectTV onRequestResult " + decode);
                            OnConnectSinkListener onConnectSinkListener3 = onConnectSinkListener;
                            if (onConnectSinkListener3 != null) {
                                onConnectSinkListener3.onDisconnect(212018);
                                return;
                            }
                            return;
                        }
                        SourceLog.w(PublicCastClient.TAG, "connectTV onRequestResult " + decode);
                        OnConnectSinkListener onConnectSinkListener4 = onConnectSinkListener;
                        if (onConnectSinkListener4 != null) {
                            onConnectSinkListener4.onDisconnect(212011);
                        }
                    }
                }
            });
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }

    public void disconnectServer() {
        SourceLog.i(TAG, "disconnectServer");
        IMEntrance.getInstance().disconnect();
    }

    public void disconnectTV(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", str);
            jSONObject.put("suid", Session.getInstance().getUID());
            jSONObject.put("uid", str2);
            stringBuffer.append(COMMAND_DISCONNECT);
            stringBuffer.append(",");
            stringBuffer.append(jSONObject.toString());
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + PUSH_ACTION, genPostContent(stringBuffer.toString(), str2).toString());
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            in.requestMethod = 1;
            in.connectTimeout = 2000;
            in.readTimeout = 2000;
            IMQueue.getInstance().addTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.6
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    AsyncHttpParameter.Out out;
                    if (asyncHttpParameter2 == null || (out = asyncHttpParameter2.out) == null || out.result == null) {
                        SourceLog.w(PublicCastClient.TAG, "disconnectTV  failed");
                        return;
                    }
                    SourceLog.debug(PublicCastClient.TAG, "disconnectTV result ：" + asyncHttpParameter2.out.result);
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public boolean isConnectedServer() {
        return IMEntrance.getInstance().isConnected();
    }

    public void pause(OutParameter outParameter) {
        playControl(outParameter, 2, -1, -1, null, -1);
    }

    public void play(OutParameter outParameter, String str, AsyncHttpRequestListener asyncHttpRequestListener) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject jSONObject = new JSONObject();
        try {
            String uid = outParameter.currentBrowserInfo.getUid();
            try {
                jSONObject.put("url", URLEncoder.encode(outParameter.getPlayUrl(), XML.CHARSET_UTF8));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            jSONObject.put("suid", Session.getInstance().getUID());
            jSONObject.put("uri", outParameter.urlID);
            jSONObject.put("timeout", CdnType.DIGITAL_TYPE_PCDN);
            jSONObject.put("sdkv", "4.12.14");
            jSONObject.put("app_id", Session.getInstance().appKey);
            jSONObject.put("sid", outParameter.session);
            jSONObject.put("pos", outParameter.startPosition);
            jSONObject.put("mt", outParameter.mimeType);
            jSONObject.put("pc", str);
            SourceLog.i(TAG, HTTP.SID + outParameter.session);
            DramaInfoBean[] dramaInfoBeanArr = outParameter.urls;
            if (dramaInfoBeanArr == null || dramaInfoBeanArr.length <= 0) {
                try {
                    jSONObject.put("url", URLEncoder.encode(outParameter.getPlayUrl(), XML.CHARSET_UTF8));
                } catch (Exception e11) {
                    SourceLog.w(TAG, e11);
                }
                stringBuffer.append("020001ff");
                stringBuffer.append(",");
                stringBuffer.append(jSONObject.toString());
            } else {
                JSONArray jSONArray = new JSONArray();
                for (DramaInfoBean dramaInfoBean : outParameter.urls) {
                    jSONArray.put(dramaInfoBean.toJson());
                }
                jSONObject.put("playid", outParameter.dramaID);
                jSONObject.put("period", outParameter.period);
                jSONObject.put(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray);
                jSONObject.put(PlistBuilder.KEY_PROP_TYPE, "set-playlist");
                jSONObject.put(ParamsMap.PushParams.KEY_HEAD_DURATION, outParameter.headLength);
                jSONObject.put(ParamsMap.PushParams.KEY_TAIL_DURATION, outParameter.tailLength);
                stringBuffer.append(COMMAND_PUSH_LIST);
                stringBuffer.append(",");
                stringBuffer.append(jSONObject.toString());
            }
            try {
                str2 = outParameter.currentBrowserInfo.getExtras().get("a");
            } catch (Exception e12) {
                SourceLog.w(TAG, e12);
                str2 = null;
            }
            JSONObject genPostContent = genPostContent(stringBuffer.toString(), str2, uid);
            SourceLog.i(TAG, "play push: " + genPostContent.toString());
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + PUSH_ACTION, genPostContent.toString());
            asyncHttpParameter.in.requestMethod = 1;
            IMQueue.getInstance().addTask(asyncHttpParameter, asyncHttpRequestListener);
        } catch (Exception e13) {
            SourceLog.w(TAG, e13);
        }
    }

    public void playDrama(OutParameter outParameter, String str) {
        playControl(outParameter, 8, -1, -1, str, -1);
    }

    public void playNextDrama(OutParameter outParameter) {
        playControl(outParameter, 9, -1, -1, null, -1);
    }

    public void playPreDrama(OutParameter outParameter) {
        playControl(outParameter, 10, -1, -1, null, -1);
    }

    public void reconnect() {
        if (TextUtils.isEmpty(this.mUrl) || TextUtils.isEmpty(this.mToken)) {
            SourceLog.w(TAG, "reconnect ignore");
        } else {
            SourceLog.i(TAG, "reconnect");
            connectServer(this.mUrl, this.mToken, null);
        }
    }

    public void removeConnectIMListener(OnConnectIMListener onConnectIMListener) {
        if (this.mIMListenerList.contains(onConnectIMListener)) {
            this.mIMListenerList.remove(onConnectIMListener);
        }
    }

    public void removeIMMsgReceiveListener(AbsIMMsgReceiveListener absIMMsgReceiveListener) {
        if (this.mIMMsgReceiveListenerList.contains(absIMMsgReceiveListener)) {
            this.mIMMsgReceiveListenerList.remove(absIMMsgReceiveListener);
        }
    }

    public void resume(OutParameter outParameter) {
        playControl(outParameter, 1, -1, -1, null, -1);
    }

    public void seekTo(OutParameter outParameter, int i10) {
        playControl(outParameter, 4, i10, -1, null, -1);
    }

    public void selectTrack(OutParameter outParameter, int i10) {
        playControl(outParameter, 11, -1, -1, null, i10);
    }

    public boolean sendPass(String str, String str2) {
        try {
            String encodeXORData = encodeXORData(str2);
            if (TextUtils.isEmpty(encodeXORData)) {
                SourceLog.i(TAG, "sendPass encrypt xor data is empty");
                return false;
            }
            NetPassBean netPassBean = new NetPassBean();
            netPassBean.pc = encodeXORData;
            this.mNetCastPassSender.sendMsg(str, ACTION_PASS, netPassBean.toJson().toString());
            return true;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return false;
        }
    }

    public void setIMMsgReceiveListener(AbsIMMsgReceiveListener absIMMsgReceiveListener) {
        if (this.mIMMsgReceiveListenerList.contains(absIMMsgReceiveListener)) {
            return;
        }
        this.mIMMsgReceiveListenerList.add(absIMMsgReceiveListener);
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        this.mPlayStateListener = onPlayStateListener;
    }

    public void setPlayList(OutParameter outParameter, String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject jSONObject = new JSONObject();
        try {
            String uid = outParameter.currentBrowserInfo.getUid();
            jSONObject.put("suid", Session.getInstance().getUID());
            jSONObject.put("uri", outParameter.urlID);
            jSONObject.put("timeout", CdnType.DIGITAL_TYPE_PCDN);
            jSONObject.put("sdkv", "4.12.14");
            jSONObject.put("app_id", Session.getInstance().appKey);
            jSONObject.put("sid", outParameter.session);
            jSONObject.put("pos", outParameter.startPosition);
            jSONObject.put("mt", outParameter.mimeType);
            jSONObject.put("pc", "");
            if (!DramaInfoBean.CLEAR_PLAY_LIST.equals(str)) {
                JSONArray jSONArray = new JSONArray();
                for (DramaInfoBean dramaInfoBean : dramaInfoBeanArr) {
                    jSONArray.put(dramaInfoBean.toJson());
                }
                jSONObject.put("period", i10);
                jSONObject.put(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray);
                jSONObject.put(ParamsMap.PushParams.KEY_HEAD_DURATION, i11);
                jSONObject.put(ParamsMap.PushParams.KEY_TAIL_DURATION, i12);
            }
            jSONObject.put(PlistBuilder.KEY_PROP_TYPE, str);
            stringBuffer.append(COMMAND_PUSH_LIST);
            stringBuffer.append(",");
            stringBuffer.append(jSONObject.toString());
            try {
                str2 = outParameter.currentBrowserInfo.getExtras().get("a");
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                str2 = null;
            }
            JSONObject genPostContent = genPostContent(stringBuffer.toString(), str2, uid);
            SourceLog.i(TAG, "setPlayList:" + genPostContent.toString());
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + PUSH_ACTION, genPostContent.toString());
            asyncHttpParameter.in.requestMethod = 1;
            IMQueue.getInstance().addTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.PublicCastClient.4
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                    AsyncHttpParameter.Out out;
                    String str3;
                    if (asyncHttpParameter2 == null || (out = asyncHttpParameter2.out) == null || (str3 = out.result) == null) {
                        SourceLog.w(PublicCastClient.TAG, "setPlayList onRequestResult failed ");
                        return;
                    }
                    SourceLog.debug(PublicCastClient.TAG, "setPlayList onRequestResult " + str3);
                }
            });
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }

    public void setVolume(OutParameter outParameter, int i10) {
        playControl(outParameter, 5, -1, i10, null, -1);
    }

    public void stop(OutParameter outParameter) {
        playControl(outParameter, 3, -1, -1, null, -1);
    }

    public void subVolume(OutParameter outParameter) {
        playControl(outParameter, 7, -1, -1, null, -1);
    }

    private JSONObject genPostContent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", Session.getInstance().getUID());
            jSONObject.put("u", str2);
            jSONObject.put("appid", Session.getInstance().appKey);
            jSONObject.put("token", a.a());
            jSONObject.put("content", str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }
}
