package com.hpplay.sdk.source.process;

import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class OnlineCheckThread extends Thread {
    private static final String TAG = "OnlineCheckThread";
    private boolean isCompletion;
    private List<LelinkServiceInfo> mCopyLelinkServiceInfo = new CopyOnWriteArrayList();
    private IAPICallbackListener mIapiCallbackListener;
    private List<LelinkServiceInfo> mLelinkServiceInfos;

    public OnlineCheckThread(IAPICallbackListener iAPICallbackListener, List<LelinkServiceInfo> list) {
        setName(TAG);
        this.mLelinkServiceInfos = list;
        this.mIapiCallbackListener = iAPICallbackListener;
    }

    public static void doCheck(Collection<BrowserInfo> collection) {
        List<BrowserInfo> filterBrowserInfosByConnectType = filterBrowserInfosByConnectType(0, collection);
        if (filterBrowserInfosByConnectType != null && !filterBrowserInfosByConnectType.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("doCheck tcpCheck:");
            sb.append("\r\n");
            for (BrowserInfo browserInfo : filterBrowserInfosByConnectType) {
                if (!TextUtils.isEmpty(browserInfo.getIp())) {
                    boolean tcpCheckTvState = KeepAliveUtitls.tcpCheckTvState(browserInfo.getName(), browserInfo.getIp(), browserInfo.getPort());
                    sb.append("name:");
                    sb.append(browserInfo.getName());
                    sb.append(" alive state:");
                    sb.append(tcpCheckTvState);
                    sb.append("\r\n");
                    browserInfo.setLocalWifi(tcpCheckTvState);
                    browserInfo.setOnLine(tcpCheckTvState);
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e10) {
                        SourceLog.w(TAG, e10);
                    }
                }
            }
            SourceLog.i(TAG, sb.toString());
        }
        List<BrowserInfo> filterBrowserInfosByConnectType2 = filterBrowserInfosByConnectType(1, collection);
        if (filterBrowserInfosByConnectType2 == null || filterBrowserInfosByConnectType2.isEmpty()) {
            return;
        }
        SourceLog.i(TAG, "doCheck cloud:" + KeepAliveUtitls.httpPostCheckTvState(filterBrowserInfosByConnectType2));
    }

    private static List<BrowserInfo> filterBrowserInfosByConnectType(int i10, Collection<BrowserInfo> collection) {
        if (collection == null || collection.isEmpty()) {
            SourceLog.i(TAG, "filterBrowserInfosByConnectType is empty");
            return null;
        }
        SourceLog.i(TAG, "filterBrowserInfosByConnectType");
        ArrayList arrayList = new ArrayList();
        for (BrowserInfo browserInfo : collection) {
            if (browserInfo.getConnectionType() == i10) {
                arrayList.add(browserInfo);
            }
        }
        return arrayList;
    }

    public boolean isCompletion() {
        return this.isCompletion;
    }

    public void release() {
        this.mIapiCallbackListener = null;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            this.isCompletion = false;
            this.mCopyLelinkServiceInfo.clear();
            this.mCopyLelinkServiceInfo.addAll(this.mLelinkServiceInfos);
            SourceLog.i(TAG, " init info size  : " + this.mCopyLelinkServiceInfo.size());
            if (this.mCopyLelinkServiceInfo.size() > 0) {
                for (LelinkServiceInfo lelinkServiceInfo : this.mCopyLelinkServiceInfo) {
                    if (lelinkServiceInfo != null) {
                        try {
                            Map<Integer, BrowserInfo> browserInfos = lelinkServiceInfo.getBrowserInfos();
                            if (browserInfos != null) {
                                doCheck(browserInfos.values());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(TAG, e10);
                        }
                    }
                }
            }
            if (this.mIapiCallbackListener != null) {
                SourceLog.i(TAG, " call back size : " + this.mCopyLelinkServiceInfo.size());
                this.mIapiCallbackListener.onResult(IAPI.OPTION_3, this.mCopyLelinkServiceInfo);
                this.isCompletion = true;
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }
}
