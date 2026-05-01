package com.hpplay.sdk.source.protocol.browser.ble;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.ble.AdvertiseManager;
import com.hpplay.ble.DiscoveryAdvertiseManager;
import com.hpplay.ble.DiscoveryResult;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.device.DevicePinParser;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.connect.AbsIMMsgReceiveListener;

/* loaded from: classes3.dex */
public class BleBrowserBridge {
    private static final String TAG = "BleBrowserBridge";
    private static BleBrowserBridge sInstance;
    private DevicePinParser mServerParser;
    private IServiceInfoParseListener mServiceInfoParseListener;
    private boolean isStop = true;
    private boolean isBrowserSuccess = false;
    private boolean isFoundDevice = false;
    private DiscoveryAdvertiseManager.BleDiscoveryCallback mCallback = new DiscoveryAdvertiseManager.BleDiscoveryCallback() { // from class: com.hpplay.sdk.source.protocol.browser.ble.BleBrowserBridge.1
        public void onDiscoveryResult(DiscoveryResult discoveryResult) {
            if (BleBrowserBridge.this.isStop || discoveryResult == null) {
                return;
            }
            String pinCode = discoveryResult.getPinCode();
            if (TextUtils.isEmpty(pinCode)) {
                SourceLog.w(BleBrowserBridge.TAG, "discoveryResult: ble is empty");
            } else {
                if (pinCode.equals(Preference.getInstance().get(Preference.KEY_DEVICE_ID))) {
                    return;
                }
                BleBrowserBridge.this.isFoundDevice = true;
                Device.addDeviceCodeServiceInfo(pinCode, 10, BleBrowserBridge.this.mServiceInfoParseListener);
            }
        }
    };
    private AbsIMMsgReceiveListener mIMMsgReceiveListener = new AbsIMMsgReceiveListener() { // from class: com.hpplay.sdk.source.protocol.browser.ble.BleBrowserBridge.2
        @Override // com.hpplay.sdk.source.protocol.connect.AbsIMMsgReceiveListener
        public void onMsgReceive(int i10, String str) {
            super.onMsgReceive(i10, str);
            if (i10 != 1) {
                return;
            }
            BleBrowserBridge.this.mServerParser.setParseResultListener(BleBrowserBridge.this.mServiceInfoParseListener);
            BleBrowserBridge.this.mServerParser.parseServiceInfo(str, 10);
        }
    };

    private BleBrowserBridge() {
    }

    public static synchronized BleBrowserBridge getInstance() {
        synchronized (BleBrowserBridge.class) {
            synchronized (BleBrowserBridge.class) {
                if (sInstance == null) {
                    sInstance = new BleBrowserBridge();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    public boolean isBrowserSuccess() {
        return this.isBrowserSuccess;
    }

    public void release() {
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
    }

    public boolean startBrowse(Context context) {
        this.isFoundDevice = false;
        if (1 != LelinkConfig.isBrowserBlueToothEnable(context)) {
            SourceLog.w(TAG, "startBrowse has no permission to use ble");
            return false;
        }
        this.isBrowserSuccess = DiscoveryAdvertiseManager.getInstance().startScan(context, this.mCallback);
        SourceLog.w(TAG, "startBrowse " + this.isBrowserSuccess);
        if (this.isBrowserSuccess) {
            this.isStop = false;
            SourceDataReport.getInstance().reportBleStartBrowseTimes();
        } else {
            this.isStop = true;
        }
        ServiceUpdater.getInstance().updateServiceInfo(context);
        return this.isBrowserSuccess;
    }

    public boolean startPublish(Context context, String str) {
        if (1 != LelinkConfig.isPublishBlueToothEnable(context)) {
            SourceLog.w(TAG, "startPublish has no permission to use ble");
            return false;
        }
        SourceLog.i(TAG, "startPublish deviceCode:" + str);
        PublicCastClient.getInstance().setIMMsgReceiveListener(this.mIMMsgReceiveListener);
        return AdvertiseManager.getInstance().startAdvertise(context, str);
    }

    public void stopBrowse(Context context) {
        if (this.isStop) {
            return;
        }
        SourceLog.i(TAG, "stopBrowse");
        this.isStop = true;
        this.isBrowserSuccess = false;
        DiscoveryAdvertiseManager.getInstance().stopScan();
        ServiceUpdater.getInstance().updateServiceInfo(context);
        if (this.isFoundDevice) {
            SourceDataReport.getInstance().reportFoundDeviceOfBle();
        }
        this.isFoundDevice = false;
    }

    public void stopPublish(Context context) {
        SourceLog.i(TAG, "stopPublish");
        AdvertiseManager.getInstance().stopAdvertise();
        ServiceUpdater.getInstance().updateServiceInfo(context);
    }
}
