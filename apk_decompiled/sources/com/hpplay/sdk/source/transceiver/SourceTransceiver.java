package com.hpplay.sdk.source.transceiver;

import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.bean.ChangeHostSetBean;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.transceiver.bean.NotifyMirrorBean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SourceTransceiver {
    private final String TAG = "SourceTransceiver";

    public void notifySinkChangeHost(int i10, String str) {
        ChangeHostSetBean changeHostSetBean = new ChangeHostSetBean();
        changeHostSetBean.action = 4;
        changeHostSetBean.value = i10;
        changeHostSetBean.tu = str;
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_HOST_SETTING, changeHostSetBean.toJson());
    }

    public void notifySinkMirror(NotifyMirrorBean notifyMirrorBean) {
        if (notifyMirrorBean == null) {
            return;
        }
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_NOTIFY_SINK_MIRROR, notifyMirrorBean.toJSON());
    }

    public void notifySinkPull(int i10, String str) {
        ChangeHostSetBean changeHostSetBean = new ChangeHostSetBean();
        changeHostSetBean.action = 3;
        changeHostSetBean.value = i10;
        changeHostSetBean.tu = str;
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_HOST_SETTING, changeHostSetBean.toJson());
    }

    public void notifySinkShowLaser(boolean z10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", 2);
            jSONObject.put("action", z10 ? 1 : 0);
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_PAINT, jSONObject.toString());
        } catch (Exception e10) {
            SourceLog.w("SourceTransceiver", e10);
        }
    }

    public void notifySinkShowPaint(boolean z10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", 1);
            jSONObject.put("action", z10 ? 1 : 0);
            LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_PAINT, jSONObject.toString());
        } catch (Exception e10) {
            SourceLog.w("SourceTransceiver", e10);
        }
    }

    public void setCastSetting2SinkHost(int i10) {
        ChangeHostSetBean changeHostSetBean = new ChangeHostSetBean();
        changeHostSetBean.action = 1;
        changeHostSetBean.value = i10;
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_HOST_SETTING, changeHostSetBean.toJson());
    }

    public void setHostStatusChangeListener(IHostStatusChangeListener iHostStatusChangeListener) {
        LelinkSourceSDK.getInstance().getListenerDispatcher().setHostStatusChangeListener(iHostStatusChangeListener);
    }

    public void setRemoteSeverListener(IRemoteServerListener iRemoteServerListener) {
        LelinkSourceSDK.getInstance().getListenerDispatcher().setRemoteSeverListener(iRemoteServerListener);
    }

    public void setReverseCastSetting2SinkHost(int i10) {
        ChangeHostSetBean changeHostSetBean = new ChangeHostSetBean();
        changeHostSetBean.action = 2;
        changeHostSetBean.value = i10;
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_CHANGE_SINK_HOST_SETTING, changeHostSetBean.toJson());
    }

    @Deprecated
    public void setSinkHostSettingChangeListener(ISinkHostSettingChangeListener iSinkHostSettingChangeListener) {
        LelinkSourceSDK.getInstance().getListenerDispatcher().setSinkHostSettingChangeListener(iSinkHostSettingChangeListener);
    }

    public void startRemoteServer(LelinkServiceInfo lelinkServiceInfo, int i10) {
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_NOTIFY_REMOTE_SERVER, lelinkServiceInfo.getUid(), String.valueOf(i10), "1");
    }

    public void stopRemoteServer(LelinkServiceInfo lelinkServiceInfo, int i10) {
        LelinkSourceSDK.getInstance().setOption(IAPI.OPTION_NOTIFY_REMOTE_SERVER, lelinkServiceInfo.getUid(), String.valueOf(i10), "2");
    }
}
