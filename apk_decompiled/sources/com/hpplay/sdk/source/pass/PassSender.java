package com.hpplay.sdk.source.pass;

import android.text.TextUtils;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.MicroAppInfoBean;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.pass.bean.RateQueryBean;
import com.hpplay.sdk.source.pass.bean.ShortVideoListBean;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.OnConnectIMListener;
import com.hpplay.sdk.source.transceiver.bean.NotifyMirrorBean;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.taobao.accs.common.Constants;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PassSender {
    private static final String TAG = "PassSender";
    private static PassSender sInstance;
    private Map<String, String> mUnconnectedMsg = new LinkedHashMap(3);

    private PassSender() {
    }

    public static synchronized PassSender getInstance() {
        synchronized (PassSender.class) {
            synchronized (PassSender.class) {
                if (sInstance == null) {
                    sInstance = new PassSender();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private void send(LelinkServiceInfo lelinkServiceInfo, String str, int i10, int i11, int i12, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                str3 = (String) new JSONObject(str2).get(ParamsMap.DeviceParams.KEY_UID);
            } catch (Exception unused) {
            }
            if (lelinkServiceInfo != null || (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase(lelinkServiceInfo.getUid()))) {
                SourceLog.w(TAG, "send unconnected msg");
                sendUnconnected(str, i10, i11, i12, str2);
            }
            DescribeBean describeBean = Creator.getDescribeBean(str, i10, i11, i12);
            describeBean.id = CreateUtil.createPassMsgID();
            String json = describeBean.toJson();
            SourceLog.i(TAG, "send header " + json);
            ConnectManager.getInstance().sendPassData(lelinkServiceInfo, i10, json, str2);
            return;
        }
        str3 = null;
        if (lelinkServiceInfo != null) {
        }
        SourceLog.w(TAG, "send unconnected msg");
        sendUnconnected(str, i10, i11, i12, str2);
    }

    private void sendUnconnected(String str, int i10, int i11, int i12, String str2) {
        try {
            String str3 = (String) new JSONObject((String) new JSONObject(str2).get("data")).get(ParamsMap.DeviceParams.KEY_UID);
            if (TextUtils.isEmpty(str3)) {
                SourceLog.w(TAG, "sendUnconnected, uid is null.");
            } else {
                send(str, str3, i10, i11, i12, str2);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, "sendUnconnected, cause = " + e10.getCause() + ", msg = " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sendUnconnectedMsgReal() {
        SourceLog.i(TAG, "sendUnconnectedMsgReal");
        for (Map.Entry<String, String> entry : this.mUnconnectedMsg.entrySet()) {
            PublicCastClient.getInstance().sendPass(entry.getKey(), entry.getValue());
        }
        this.mUnconnectedMsg.clear();
    }

    public void playRate(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 12, 1, 2, str);
    }

    public void queryRate() {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 15, 1, 2, new RateQueryBean().toJson());
    }

    public void sendChangeSinkPaint(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendSinkHostSettingMsg ignore 2");
        } else {
            send(lastServiceInfo, "", 44, 1, 2, str);
        }
    }

    public void sendConnectMsg(LelinkServiceInfo lelinkServiceInfo) {
        send(lelinkServiceInfo, "", 4, 7, 2, new ConnectBean().toJson());
    }

    public void sendDanmu(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 6, 1, 2, str);
    }

    public void sendFavoriteConfirm(LelinkServiceInfo lelinkServiceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            String str = "";
            try {
                String str2 = Preference.getInstance().get(Constant.KEY_USERNAME);
                if (TextUtils.isEmpty(str2)) {
                    str2 = DeviceUtil.getBluetoothName();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = DeviceProperties.getModel();
                    }
                }
                str = URLEncoder.encode(str2, XML.CHARSET_UTF8);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            jSONObject.put("name", str);
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
        send(lelinkServiceInfo, "", 52, 1, 2, jSONObject.toString());
    }

    public void sendHarassCode(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendHarassCode ignore");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put(Constants.KEY_HTTP_CODE, str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lastServiceInfo, "", 47, 1, 2, jSONObject.toString());
    }

    public void sendMediaAssets(MediaAssetBean mediaAssetBean, String str) {
        SourceLog.i(TAG, "sendMediaAssets");
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            mediaAssetBean.setManifestVer(String.valueOf(1));
            send(lastServiceInfo, str, 2, 1, 2, mediaAssetBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void sendMicroAppInfo(MicroAppInfoBean microAppInfoBean, String str) {
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            microAppInfoBean.setManifestVer(1);
            send(lastServiceInfo, str, 33, 1, 2, microAppInfoBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void sendMicroPass(String str, String str2, int i10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, lastServiceInfo.getAppId());
            jSONObject.put("content", str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lastServiceInfo, str2, 34, 1, 2, jSONObject.toString());
    }

    public void sendMirrorState(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 26, 1, 2, str);
    }

    public void sendNotifyMirrorMsg(NotifyMirrorBean notifyMirrorBean) {
        if (notifyMirrorBean == null) {
            SourceLog.w(TAG, "sendNotifyMirrorMsg ignore 1");
            return;
        }
        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(notifyMirrorBean.uid);
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "sendNotifyMirrorMsg ignore 2");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("ip", notifyMirrorBean.ip);
            jSONObject.put("port", notifyMirrorBean.port);
            jSONObject.put("name", notifyMirrorBean.name);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lelinkServiceInfo, "", 38, 1, 2, jSONObject.toString());
    }

    public void sendNotifyRemoteMsg(String str, int i10, int i11) {
        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(str);
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "sendNotifyRemoteMsg ignore 2");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
            jSONObject.put("action", i11);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lelinkServiceInfo, "", 39, 1, 2, jSONObject.toString());
    }

    public void sendPass(int i10, String str, boolean z10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (i10 == 100) {
            send(lastServiceInfo, "", 100, 1, z10 ? 2 : 1, str);
        } else if (i10 != 10000) {
            SourceLog.w(TAG, "sendPass ignore, never should be here");
        } else {
            send(lastServiceInfo, "", 10000, 1, z10 ? 2 : 1, str);
        }
    }

    public void sendPlayerInfo(PlayerInfoBean playerInfoBean, String str) {
        SourceLog.i(TAG, "sendPlayerInfo");
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            playerInfoBean.setManifestVer(3);
            send(lastServiceInfo, str, 1, 3, 2, playerInfoBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void sendReceiverPropertiesSync() {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        SourceLog.i(TAG, "sendReceiverPropertiesSync info: " + lastServiceInfo);
        send(lastServiceInfo, "", 50, 1, 2, "{}");
    }

    public void sendReceiverProperty(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "sendReceiverProperty is ignore");
        }
        SourceLog.i(TAG, "sendReceiverProperty body: " + str);
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        SourceLog.i(TAG, "sendReceiverProperty info: " + lastServiceInfo);
        send(lastServiceInfo, "", 49, 1, 2, str);
    }

    public void sendShortVideoList(String str) {
        SourceLog.i(TAG, "sendShortVideoList");
        try {
            ShortVideoListBean shortVideoListBean = new ShortVideoListBean();
            shortVideoListBean.manifestVer = 1;
            shortVideoListBean.index = 0;
            shortVideoListBean.videoList = new JSONArray(str);
            send(ConnectManager.getInstance().getLastServiceInfo(), "", 30, 1, 2, ShortVideoListBean.toJSON(shortVideoListBean));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void sendSinkHostSettingMsg(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendSinkHostSettingMsg ignore 2");
        } else {
            send(lastServiceInfo, "", 42, 1, 2, str);
        }
    }

    public void sendSinkKeyRegister(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 28, 1, 2, str);
    }

    public void sendSinkTouchEvent(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 11, 1, 2, str);
    }

    public void sendSinkTouchRegister(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 31, 1, 2, str);
    }

    public void sendStopMicro(String str, int i10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lastServiceInfo, str, 35, 1, 2, jSONObject.toString());
    }

    public void sendTempRestrict(String str, boolean z10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("enable", z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        send(lastServiceInfo, str, 36, 1, 2, jSONObject.toString());
    }

    public void sendVIPQuery(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 22, 1, 2, str);
    }

    public void setDanmuProperty(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 5, 1, 2, str);
    }

    public void syncLogReport(LelinkServiceInfo lelinkServiceInfo, String str) {
        send(lelinkServiceInfo, "", 21, 1, 2, str);
    }

    public void send(String str, String str2, int i10, int i11, int i12, String str3) {
        DescribeBean describeBean = Creator.getDescribeBean(str, i10, i11, i12);
        describeBean.id = CreateUtil.createPassMsgID();
        String json = describeBean.toJson();
        SourceLog.i(TAG, "send header " + json);
        try {
            String str4 = Pass.PLACEHOLDER_START + json + Pass.PLACEHOLDER_END + Pass.PLACEHOLDER_START + str3 + Pass.PLACEHOLDER_END;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, str4);
            this.mUnconnectedMsg.put(str2, jSONArray.toString());
            SourceLog.i(TAG, "send put value, uid = " + str2 + ", msg = " + str4);
            if (!PublicCastClient.getInstance().isConnectedServer()) {
                if (TextUtils.isEmpty(CloudAPI.sImServer)) {
                    SourceLog.w(TAG, "connect ignore, invalid im url");
                    return;
                } else {
                    PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), new OnConnectIMListener() { // from class: com.hpplay.sdk.source.pass.PassSender.1
                        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
                        public void onConnectFailed() {
                            SourceLog.w(PassSender.TAG, "onConnectFailed.send browser msg failed.");
                        }

                        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
                        public void onConnectSuccess() {
                            SourceLog.i(PassSender.TAG, "onConnectSuccess, send browser msg.");
                            PassSender.this.sendUnconnectedMsgReal();
                        }
                    });
                    return;
                }
            }
            sendUnconnectedMsgReal();
        } catch (Exception e10) {
            SourceLog.w(TAG, "send browser failed. cause " + e10.getCause());
        }
    }
}
