package com.hpplay.sdk.source.device;

import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class DeviceCodeResolver {
    private static String TAG = "DeviceCodeResolver";
    private static DeviceCodeResolver sInstance;
    private ConcurrentHashMap<String, Integer> mDevicePins = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BrowserInfo> mBrowserMap = new ConcurrentHashMap<>();
    private int mReportCreateType = -1;
    private long mParseTimeStamp = -1;

    public static synchronized DeviceCodeResolver getInstance() {
        synchronized (DeviceCodeResolver.class) {
            synchronized (DeviceCodeResolver.class) {
                if (sInstance == null) {
                    sInstance = new DeviceCodeResolver();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    public void clear() {
        this.mDevicePins.clear();
        this.mBrowserMap.clear();
        this.mReportCreateType = -1;
    }

    public void resolveDeviceCode(final String str, int i10, final IServiceInfoParseListener iServiceInfoParseListener) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "addDevicePinServiceInfo: deviceCode is empty");
            return;
        }
        if (!this.mDevicePins.containsKey(str)) {
            SourceLog.i(TAG, "addDevicePinServiceInfo deviceCode:" + str);
            this.mDevicePins.put(str, Integer.valueOf(i10));
            DevicePinParser devicePinParser = new DevicePinParser();
            final long currentTimeMillis = System.currentTimeMillis();
            devicePinParser.setParseResultListener(new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.device.DeviceCodeResolver.1
                @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
                public void onParseResult(int i11, LelinkServiceInfo lelinkServiceInfo) {
                    BrowserInfo browserInfo;
                    IServiceInfoParseListener iServiceInfoParseListener2 = iServiceInfoParseListener;
                    if (iServiceInfoParseListener2 != null) {
                        iServiceInfoParseListener2.onParseResult(i11, lelinkServiceInfo);
                    }
                    if (lelinkServiceInfo == null || (browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 1)) == null) {
                        return;
                    }
                    DeviceCodeResolver.this.mBrowserMap.put(str, browserInfo);
                    DeviceCodeResolver.this.mParseTimeStamp = System.currentTimeMillis() - currentTimeMillis;
                    BrowserHistory.getInstance().updateBrowserInfo(browserInfo, browserInfo.getCreateType(), DeviceCodeResolver.this.mParseTimeStamp);
                    if (DeviceCodeResolver.this.mReportCreateType != -1) {
                        BrowserHistory.getInstance().updateBrowserInfo(browserInfo, DeviceCodeResolver.this.mReportCreateType, DeviceCodeResolver.this.mParseTimeStamp);
                    }
                }
            });
            devicePinParser.parse(str, i10);
            return;
        }
        BrowserInfo browserInfo = this.mBrowserMap.get(str);
        if (browserInfo != null) {
            if (i10 != browserInfo.getCreateType()) {
                BrowserHistory.getInstance().updateBrowserInfo(browserInfo, i10, this.mParseTimeStamp);
            }
        } else {
            Integer num = this.mDevicePins.get(str);
            if (num == null || num.intValue() != i10) {
                return;
            }
            this.mReportCreateType = i10;
        }
    }
}
