package com.hpplay.component.common.wifidirect;

import android.net.wifi.p2p.WifiP2pDevice;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.protocol.ProtocolListener;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IWDirectController {
    public static final int WDIRECT_DISCONVER_START_FAILED = 6;
    public static final int WDIRECT_DISCONVER_START_SUCCESSFUL = 5;
    public static final int WDIRECT_ON_CONNECT_FAILED = 9;
    public static final int WDIRECT_ON_DEVICE_CONNECTED = 1;
    public static final int WDIRECT_ON_DEVICE_DISCONNECT = 2;
    public static final int WDIRECT_ON_SELF_DEVICE_STATUS_CALLBACK = 10;
    public static final int WDIRECT_ON_START_CONNECT_FAILED = 8;
    public static final int WDIRECT_ON_START_CONNECT_SUCCESSFUL = 7;
    public static final int WDIRECT_ON__START_SERVER_FAILED = 4;
    public static final int WDIRECT_ON__START_SERVER_SUCCESSFUL = 3;

    void connect(WifiP2pDevice wifiP2pDevice);

    IDataTransmitter createDataTransmitter(int i10);

    void disConnect();

    void discover();

    String getGoIp();

    int getGroupFreq();

    int init(boolean z10);

    boolean isSupportWifiP2p();

    void release();

    void requestDnsInfos();

    void setBrowseResultListener(IBrowseResultListener iBrowseResultListener);

    void setDnsTxtRecord(Map map);

    void setOptimizationChannel(boolean z10);

    void setPinCode(String str);

    void setServerDeviceName(String str);

    void setWDirectStateListener(ProtocolListener protocolListener);

    void startWifiP2pServer();

    void stopDirect();

    void stopDiscover();
}
