package com.hpplay.sdk.source.protocol.browser.p2p;

import android.net.wifi.p2p.WifiP2pDevice;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.common.wifidirect.IWDirectController;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.BrowserResolver;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class P2PProxy {
    private static String TAG = "";
    private IWDirectController mWifiP2pController;
    private ArrayList<WifiP2pDevice> wifiP2pDevices;

    private void discoverWifiP2pDevices() {
        SourceLog.e(TAG, "start wifiP2p browse ---- ");
        IWDirectController iWDirectController = this.mWifiP2pController;
        if (iWDirectController == null) {
            return;
        }
        iWDirectController.setBrowseResultListener(new IBrowseResultListener() { // from class: com.hpplay.sdk.source.protocol.browser.p2p.P2PProxy.2
            @Override // com.hpplay.component.common.browse.IBrowseResultListener
            public void onBrowseResultCallback(int i10, Object obj) {
                if (4 == i10) {
                    ArrayList arrayList = new ArrayList();
                    P2PProxy.this.wifiP2pDevices = (ArrayList) obj;
                    if (P2PProxy.this.wifiP2pDevices.size() > 0) {
                        for (int i11 = 0; i11 < P2PProxy.this.wifiP2pDevices.size(); i11++) {
                            SourceLog.e(P2PProxy.TAG, "start onBrowseResultCallback ---- " + ((WifiP2pDevice) P2PProxy.this.wifiP2pDevices.get(i11)).deviceName);
                            LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo();
                            lelinkServiceInfo.setName("direct " + ((WifiP2pDevice) P2PProxy.this.wifiP2pDevices.get(i11)).deviceName);
                            lelinkServiceInfo.setIp(((WifiP2pDevice) P2PProxy.this.wifiP2pDevices.get(i11)).deviceAddress);
                            lelinkServiceInfo.setUid("100 " + P2PProxy.getDeviceStatus(((WifiP2pDevice) P2PProxy.this.wifiP2pDevices.get(i11)).status) + ((WifiP2pDevice) P2PProxy.this.wifiP2pDevices.get(i11)).deviceAddress);
                            arrayList.add(lelinkServiceInfo);
                        }
                    }
                    BrowserResolver.updateServiceList(arrayList);
                }
            }
        });
        this.mWifiP2pController.discover();
    }

    public static String getDeviceStatus(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "未知" : "不可用的" : "可用的" : "失败的" : "邀请中" : "已连接";
    }

    private void wifiP2PInit() {
        if (LelinkConfig.isP2PEnable()) {
            SourceLog.i(TAG, "wifpP2pInit ");
            try {
                IWDirectController iWDirectController = (IWDirectController) ModuleLinker.getInstance().loadModule(ModuleIds.CLAZZ_ID1073_WDIRECTCONTROLLER);
                this.mWifiP2pController = iWDirectController;
                iWDirectController.init(false);
                this.mWifiP2pController.setWDirectStateListener(new ProtocolListener() { // from class: com.hpplay.sdk.source.protocol.browser.p2p.P2PProxy.1
                    @Override // com.hpplay.component.common.protocol.ProtocolListener
                    public void onResult(int i10, String... strArr) {
                        if (1 == i10) {
                            SourceLog.i(P2PProxy.TAG, "wifi2p connect time ");
                        } else if (9 == i10) {
                            SourceLog.i(P2PProxy.TAG, "wifi2p connect failed ");
                        }
                    }
                });
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        ArrayList<WifiP2pDevice> arrayList;
        if (!lelinkServiceInfo.getUid().contains("100") || (arrayList = this.wifiP2pDevices) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i10 = 0; i10 < this.wifiP2pDevices.size(); i10++) {
            if (this.wifiP2pDevices.get(i10).deviceAddress.equals(lelinkServiceInfo.getIp())) {
                this.mWifiP2pController.connect(this.wifiP2pDevices.get(i10));
                return;
            }
        }
    }

    public void disconnect(LelinkServiceInfo lelinkServiceInfo) {
        this.mWifiP2pController.stopDirect();
    }
}
