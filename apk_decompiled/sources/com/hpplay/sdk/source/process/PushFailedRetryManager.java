package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.List;

/* loaded from: classes3.dex */
public class PushFailedRetryManager {
    private static final String TAG = "PushFailedRetryManager";
    public static volatile PushFailedRetryManager mPlayFailedRetryManager;
    private BrowserInfo mBrowseInfo;
    private ConnectRetryListener mConnectRetryListener;
    private PlayRetryListener mPlayRetryListener;
    private LelinkServiceInfo mServiceInfo;
    private int type = 0;
    IBrowseListener iBrowseListener = new IBrowseListener() { // from class: com.hpplay.sdk.source.process.PushFailedRetryManager.1
        @Override // com.hpplay.sdk.source.browse.api.IBrowseListener
        public void onBrowse(int i10, List<LelinkServiceInfo> list) {
            BrowserInfo browserInfo;
            try {
                if (list.size() > 0) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (PushFailedRetryManager.this.mPlayRetryListener != null && (browserInfo = list.get(i11).getBrowserInfos().get(Integer.valueOf(PushFailedRetryManager.this.type))) != null && (browserInfo.getName().equals(PushFailedRetryManager.this.mBrowseInfo.getName()) || browserInfo.getIp().equals(PushFailedRetryManager.this.mBrowseInfo.getIp()))) {
                            SourceLog.i(PushFailedRetryManager.TAG, "replay get device callback to player ");
                            PushFailedRetryManager.this.mPlayRetryListener.onBrowseInfoCallback(list.get(i11), browserInfo);
                            PushFailedRetryManager.this.mPlayRetryListener = null;
                        }
                        if (PushFailedRetryManager.this.mConnectRetryListener != null) {
                            LelinkServiceInfo lelinkServiceInfo = list.get(i11);
                            SourceLog.i(PushFailedRetryManager.TAG, "get retry devs  " + lelinkServiceInfo.getName());
                            if (lelinkServiceInfo.getName().equals(PushFailedRetryManager.this.mServiceInfo.getName()) || lelinkServiceInfo.getIp().equals(PushFailedRetryManager.this.mServiceInfo.getIp())) {
                                SourceLog.i(PushFailedRetryManager.TAG, "reconnect get device callback to controller");
                                PushFailedRetryManager.this.mConnectRetryListener.onLelinkServiceInfoCallback(PushFailedRetryManager.this.mServiceInfo);
                                PushFailedRetryManager.this.mConnectRetryListener = null;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    };

    public interface ConnectRetryListener {
        void onLelinkServiceInfoCallback(LelinkServiceInfo lelinkServiceInfo);
    }

    public interface PlayRetryListener {
        void onBrowseInfoCallback(LelinkServiceInfo lelinkServiceInfo, BrowserInfo browserInfo);
    }

    public static PushFailedRetryManager getInstance() {
        if (mPlayFailedRetryManager == null) {
            synchronized (PushFailedRetryManager.class) {
                mPlayFailedRetryManager = new PushFailedRetryManager();
            }
        }
        return mPlayFailedRetryManager;
    }

    public void connectFailedRetry(LelinkServiceInfo lelinkServiceInfo, ConnectRetryListener connectRetryListener) {
        SourceLog.i(TAG, "connectFailedRetry ... ");
        this.mServiceInfo = lelinkServiceInfo;
        this.mConnectRetryListener = connectRetryListener;
        LelinkSdkManager.getInstance().setRetryBrowseListener(this.iBrowseListener);
        LelinkSdkManager.getInstance().stopBrowse();
        LelinkSdkManager.getInstance().browse(LelinkSdkManager.getInstance().getBrowserConfig());
    }

    public void stopRetry() {
        this.mPlayRetryListener = null;
        this.mConnectRetryListener = null;
        LelinkSdkManager.getInstance().stopBrowse();
    }
}
