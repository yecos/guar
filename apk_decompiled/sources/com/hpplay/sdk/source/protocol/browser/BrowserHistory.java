package com.hpplay.sdk.source.protocol.browser;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.BrowserTypeBean;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class BrowserHistory {
    private static final String TAG = "BrowserHistory";
    private static BrowserHistory sInstance;
    private long mLocalBrowserTimeStamp = -1;
    private long mSonicBrowserTimeStamp = -1;
    private long mBLEBrowserTimeStamp = -1;
    private long mHisBrowserTimeStamp = -1;
    private boolean isUseMdns = false;
    private boolean isUseUPnP = false;
    private boolean isUseQR = false;
    private boolean isUsePinCode = false;
    private boolean isUseBLE = false;
    private boolean isUseSonic = false;
    private boolean isHistory = false;
    private ConcurrentHashMap<String, BrowserTypeBean> mBrowserMap = new ConcurrentHashMap<>();

    public static synchronized BrowserHistory getInstance() {
        synchronized (BrowserHistory.class) {
            synchronized (BrowserHistory.class) {
                if (sInstance == null) {
                    sInstance = new BrowserHistory();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private void setBrowserType(BrowserTypeBean browserTypeBean, BrowserInfo browserInfo, int i10, long j10) {
        if (browserTypeBean == null || browserInfo == null) {
            return;
        }
        if (i10 == 1) {
            if (browserInfo.getType() == 1) {
                browserTypeBean.isMDns = true;
                if (browserTypeBean.mDnsTime < 0) {
                    browserTypeBean.mDnsTime = System.currentTimeMillis() - this.mLocalBrowserTimeStamp;
                    return;
                }
                return;
            }
            if (browserInfo.getType() == 3) {
                browserTypeBean.isUPnP = true;
                if (browserTypeBean.UPnPTime < 0) {
                    browserTypeBean.UPnPTime = System.currentTimeMillis() - this.mLocalBrowserTimeStamp;
                }
                return;
            }
            return;
        }
        if (i10 == 2) {
            browserTypeBean.isQRCode = true;
            browserTypeBean.qrCodeCloudTime = j10;
            return;
        }
        if (i10 == 5) {
            browserTypeBean.isPinCode = true;
            browserTypeBean.pinCodeCloudTime = j10;
            return;
        }
        switch (i10) {
            case 9:
                browserTypeBean.isSonic = true;
                if (browserTypeBean.sonicTime < 0) {
                    browserTypeBean.sonicTime = System.currentTimeMillis() - this.mSonicBrowserTimeStamp;
                    browserTypeBean.sonicCloudTime = j10;
                    break;
                }
                break;
            case 10:
                browserTypeBean.isBle = true;
                if (browserTypeBean.bleTime < 0) {
                    browserTypeBean.bleTime = System.currentTimeMillis() - this.mBLEBrowserTimeStamp;
                    browserTypeBean.bleCloudTime = j10;
                    break;
                }
                break;
            case 11:
                browserTypeBean.isHistory = true;
                if (browserTypeBean.hisTime < 0) {
                    browserTypeBean.hisTime = System.currentTimeMillis() - this.mHisBrowserTimeStamp;
                    browserTypeBean.hisCloudTime = j10;
                    break;
                }
                break;
        }
    }

    public void clearHistory() {
        this.mBrowserMap.clear();
        this.isUseMdns = false;
        this.isUseUPnP = false;
        this.isUseQR = false;
        this.isUsePinCode = false;
        this.isUseSonic = false;
        this.isUseBLE = false;
    }

    public BrowserTypeBean getBrowserTypeBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mBrowserMap.get(str);
    }

    public boolean isUseBLE() {
        return this.isUseBLE;
    }

    public boolean isUseMdns() {
        return this.isUseMdns;
    }

    public boolean isUsePinCode() {
        return this.isUsePinCode;
    }

    public boolean isUseQR() {
        return this.isUseQR;
    }

    public boolean isUseSonic() {
        return this.isUseSonic;
    }

    public boolean isUseUPnP() {
        return this.isUseUPnP;
    }

    public void startBLEBrowser() {
        this.isUseBLE = true;
        this.mBLEBrowserTimeStamp = System.currentTimeMillis();
    }

    public void startHistoryBrowser() {
        this.isHistory = true;
        this.mHisBrowserTimeStamp = System.currentTimeMillis();
    }

    public void startLocalBrowser(int i10) {
        if (i10 == 1) {
            this.isUseMdns = true;
        } else if (i10 == 2) {
            this.isUseUPnP = true;
        } else {
            this.isUseMdns = true;
            this.isUseUPnP = true;
        }
        this.mLocalBrowserTimeStamp = System.currentTimeMillis();
    }

    public void startPinCodeBrowser() {
        this.isUsePinCode = true;
    }

    public void startQRBrowser() {
        this.isUseQR = true;
    }

    public void startSonicBrowser() {
        this.isUseSonic = true;
        this.mSonicBrowserTimeStamp = System.currentTimeMillis();
    }

    public void updateBrowserInfo(BrowserInfo browserInfo, int i10, long j10) {
        if (browserInfo == null || TextUtils.isEmpty(browserInfo.getName())) {
            return;
        }
        BrowserTypeBean browserTypeBean = this.mBrowserMap.get(browserInfo.getName());
        if (browserTypeBean != null) {
            setBrowserType(browserTypeBean, browserInfo, i10, j10);
            return;
        }
        BrowserTypeBean browserTypeBean2 = new BrowserTypeBean();
        setBrowserType(browserTypeBean2, browserInfo, i10, j10);
        this.mBrowserMap.put(browserInfo.getName(), browserTypeBean2);
    }
}
