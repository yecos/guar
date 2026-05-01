package com.hpplay.component.protocol.connection;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolBuilder;

/* loaded from: classes2.dex */
public class LelinkConnection extends IConnection {
    private static final String TAG = "LelinkConnection";

    public LelinkConnection(ParamsMap paramsMap) {
        super(paramsMap);
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean checkConnection() {
        try {
            if (!this.paramsMap.getChannelVersion().contains("5.0") && !this.paramsMap.getChannelVersion().contains("3.")) {
                return this.mProtocolSender.tcpCheckTvState(this.mIp, this.mPort);
            }
            String str = new String(this.mProtocolSender.interactiveData(new ProtocolBuilder().getFeedbackCmd().setPlatfrom().setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setLelinkDeviceId("0x" + this.paramsMap.getMac()).setUserLelinkSessionId(this.sessionId).setContentLength("0").getProtocal(true)));
            return !TextUtils.isEmpty(str) && str.contains(ProtocolBuilder.LELINK_STATE_SUCCESS);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean startConnect() {
        byte[] interactiveData;
        byte[] protocal = new ProtocolBuilder().getServerInfoCmd().setPlatfrom().setLelinkDeviceId(this.mHid).setContentLength("0").setMobileDeviceName(this.mDeviceName).setMobileDeviceChannel(this.paramsMap.getAppKey()).setSendEndValue("1").setMobileDeviceVersion("3.18.99").setDevicesIMEI(this.paramsMap.getIMEI()).setMobileDevCu(this.paramsMap.getCuid()).setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setUserLelinkSessionId("").getProtocal(true);
        if (!this.mProtocolSender.connectServer(this.mTimeout) || (interactiveData = this.mProtocolSender.interactiveData(protocal)) == null) {
            return false;
        }
        String str = new String(interactiveData);
        return !TextUtils.isEmpty(str) && str.contains(ProtocolBuilder.LELINK_STATE_SUCCESS);
    }
}
