package com.hpplay.sdk.source.process;

import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class OnlineManager {
    private static final long CHECK_INTERVAL = 120000;
    private final String TAG = "OnlineManager";
    private Map<String, Long> mOnlineTimeStamp = new ConcurrentHashMap();

    public interface OnlineListener {
        void OnLineCheckResult(LelinkServiceInfo lelinkServiceInfo, boolean z10);
    }

    private boolean isInBrowseList(LelinkServiceInfo lelinkServiceInfo) {
        List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
        if (lelinkServiceInfo != null && browserList != null) {
            try {
                Iterator<LelinkServiceInfo> it = browserList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(lelinkServiceInfo)) {
                        return true;
                    }
                }
            } catch (Exception e10) {
                SourceLog.w("OnlineManager", e10);
            }
            SourceLog.w("OnlineManager", "not in browseList, info " + lelinkServiceInfo);
        }
        return false;
    }

    public boolean checkOnline(final LelinkServiceInfo lelinkServiceInfo, final OnlineListener onlineListener) {
        try {
            final boolean isInBrowseList = isInBrowseList(lelinkServiceInfo);
            String key = CastUtil.getKey(lelinkServiceInfo);
            if (isInBrowseList && !TextUtils.isEmpty(key) && this.mOnlineTimeStamp.containsKey(key) && System.currentTimeMillis() - this.mOnlineTimeStamp.get(key).longValue() < CHECK_INTERVAL) {
                return false;
            }
            AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.process.OnlineManager.1
                @Override // java.lang.Runnable
                public void run() {
                    BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 1);
                    if (browserInfo != null) {
                        boolean tcpCheckTvState = KeepAliveUtitls.tcpCheckTvState(browserInfo.getName(), browserInfo.getIp(), browserInfo.getPort());
                        SourceLog.w("OnlineManager", "checkOnline lelink is online:" + tcpCheckTvState);
                        if (tcpCheckTvState) {
                            if (!isInBrowseList) {
                                BrowserResolver.updateServiceList(lelinkServiceInfo);
                            }
                            OnlineListener onlineListener2 = onlineListener;
                            if (onlineListener2 != null) {
                                onlineListener2.OnLineCheckResult(lelinkServiceInfo, true);
                                return;
                            }
                            return;
                        }
                        browserInfo.setOnLine(false);
                    }
                    BrowserInfo browserInfo2 = CastUtil.getBrowserInfo(lelinkServiceInfo, 3);
                    if (browserInfo2 != null) {
                        boolean tcpCheckTvState2 = KeepAliveUtitls.tcpCheckTvState(browserInfo2.getName(), browserInfo2.getIp(), browserInfo2.getPort());
                        SourceLog.w("OnlineManager", "checkOnline dlna is online:" + tcpCheckTvState2);
                        lelinkServiceInfo.setIp(browserInfo2.getIp());
                        lelinkServiceInfo.setPort(browserInfo2.getPort());
                        if (tcpCheckTvState2) {
                            SourceLog.w("OnlineManager", "checkOnline remove lelink info");
                            lelinkServiceInfo.getBrowserInfos().remove(1);
                            if (!isInBrowseList) {
                                BrowserResolver.updateServiceList(lelinkServiceInfo);
                            }
                            OnlineListener onlineListener3 = onlineListener;
                            if (onlineListener3 != null) {
                                onlineListener3.OnLineCheckResult(lelinkServiceInfo, true);
                                return;
                            }
                            return;
                        }
                        browserInfo2.setOnLine(false);
                    }
                    BrowserInfo browserInfo3 = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
                    if (browserInfo3 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(browserInfo3);
                        KeepAliveUtitls.httpPostCheckTvState(arrayList);
                        SourceLog.w("OnlineManager", "checkOnline im is online:" + browserInfo3.isOnLine());
                        lelinkServiceInfo.setIp(browserInfo3.getIp());
                        lelinkServiceInfo.setPort(browserInfo3.getPort());
                        if (browserInfo3.isOnLine()) {
                            SourceLog.w("OnlineManager", "checkOnline remove lelink info");
                            lelinkServiceInfo.getBrowserInfos().remove(1);
                            SourceLog.w("OnlineManager", "checkOnline remove dlna info");
                            lelinkServiceInfo.getBrowserInfos().remove(3);
                            if (!isInBrowseList) {
                                BrowserResolver.updateServiceList(lelinkServiceInfo);
                            }
                            OnlineListener onlineListener4 = onlineListener;
                            if (onlineListener4 != null) {
                                onlineListener4.OnLineCheckResult(lelinkServiceInfo, true);
                                return;
                            }
                            return;
                        }
                        browserInfo3.setOnLine(false);
                    }
                    SourceLog.w("OnlineManager", "checkOnline im is offline:" + lelinkServiceInfo);
                    OnlineListener onlineListener5 = onlineListener;
                    if (onlineListener5 != null) {
                        onlineListener5.OnLineCheckResult(lelinkServiceInfo, false);
                    }
                }
            }, null);
            return true;
        } catch (Exception e10) {
            SourceLog.w("OnlineManager", e10);
            return false;
        }
    }

    public void remove(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mOnlineTimeStamp.remove(key);
    }

    public void updateOnlineTime(LelinkServiceInfo lelinkServiceInfo) {
        this.mOnlineTimeStamp.put(CastUtil.getKey(lelinkServiceInfo), Long.valueOf(System.currentTimeMillis()));
    }
}
