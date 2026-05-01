package com.hpplay.sdk.source.process;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.easycast.BrowserDevice;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class BrowserDispatcher implements IBrowseListener {
    private static final String TAG = "IBrowserDispatcher";
    private IBrowseListener mOuterBrowseListener;
    private IBrowseListener mRetryIBrowseListener;
    private final int WHAT_DELAY_NOTIFY_WITH_DLNA = 1;
    private final int DELAY_NOTIFY_WITH_DLNA = 2000;
    private long mBrowserTimeStamp = -1;
    private boolean isOnlyNotifyLelink = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.process.BrowserDispatcher.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (BrowserDispatcher.this.hasLelink()) {
                    BrowserDispatcher.this.isOnlyNotifyLelink = true;
                } else {
                    BrowserDispatcher.this.isOnlyNotifyLelink = false;
                    SourceLog.i(BrowserDispatcher.TAG, "WHAT_DELAY_NOTIFY_ALL ");
                    if (BrowserDispatcher.this.mBrowserList.size() > 0 && BrowserDispatcher.this.mOuterBrowseListener != null) {
                        BrowserDispatcher.this.mOuterBrowseListener.onBrowse(1, BrowserDispatcher.this.filterLelink());
                    }
                }
            }
            return false;
        }
    });
    private final List<LelinkServiceInfo> mBrowserList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public List<LelinkServiceInfo> filterLelink() {
        List<LelinkServiceInfo> serviceListSort;
        SourceLog.i(TAG, "filterLelink,isOnlyNotifyLelink:" + this.isOnlyNotifyLelink);
        if (this.isOnlyNotifyLelink) {
            ArrayList arrayList = new ArrayList();
            for (LelinkServiceInfo lelinkServiceInfo : this.mBrowserList) {
                if (CastUtil.isSupportLelink(lelinkServiceInfo)) {
                    arrayList.add(lelinkServiceInfo);
                }
            }
            serviceListSort = BrowserDevice.getInstance().serviceListSort(arrayList);
        } else {
            serviceListSort = BrowserDevice.getInstance().serviceListSort(this.mBrowserList);
        }
        String sinkAppSearchNamePrefer = SDKConfig.getInstance().getSinkAppSearchNamePrefer();
        if (!TextUtils.isEmpty(sinkAppSearchNamePrefer) && serviceListSort != null && serviceListSort.size() > 0) {
            LelinkServiceInfo lelinkServiceInfo2 = serviceListSort.get(0);
            if (BrowserDevice.PACKAGE_NAME_SINK_APP.equalsIgnoreCase(lelinkServiceInfo2.getPackageName()) && !lelinkServiceInfo2.getName().endsWith(sinkAppSearchNamePrefer)) {
                SourceLog.i(TAG, "filterLelink,set sink app search name prefer");
                lelinkServiceInfo2.setName(lelinkServiceInfo2.getName() + sinkAppSearchNamePrefer);
            }
        }
        return serviceListSort;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasLelink() {
        Iterator<LelinkServiceInfo> it = this.mBrowserList.iterator();
        while (it.hasNext()) {
            if (CastUtil.isSupportLelink(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void notifyBrowserResult(int i10) {
        if (this.mOuterBrowseListener != null) {
            List<LelinkServiceInfo> filterLelink = filterLelink();
            if (i10 != 1) {
                this.mHandler.removeMessages(1);
                this.mOuterBrowseListener.onBrowse(i10, filterLelink);
            } else {
                if (filterLelink.isEmpty()) {
                    return;
                }
                this.mHandler.removeMessages(1);
                this.mOuterBrowseListener.onBrowse(i10, filterLelink);
            }
        }
    }

    public void browser() {
        this.mBrowserTimeStamp = System.currentTimeMillis();
        this.isOnlyNotifyLelink = Session.getInstance().isPreferLelink;
        if (Session.getInstance().isPreferLelink) {
            this.mHandler.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    public void clearBrowserList() {
        List<LelinkServiceInfo> list = this.mBrowserList;
        if (list != null) {
            list.clear();
        }
        this.mRetryIBrowseListener = null;
    }

    public List<LelinkServiceInfo> getBrowserList() {
        return this.mBrowserList;
    }

    public void notifyBrowserStop() {
        IBrowseListener iBrowseListener = this.mOuterBrowseListener;
        if (iBrowseListener != null) {
            iBrowseListener.onBrowse(2, filterLelink());
        }
    }

    public void notifyBrowserSuccess() {
        notifyBrowserResult(1);
    }

    @Override // com.hpplay.sdk.source.browse.api.IBrowseListener
    public void onBrowse(int i10, List<LelinkServiceInfo> list) {
        BrowserResolver.updateServiceList(list);
        notifyBrowserResult(i10);
        IBrowseListener iBrowseListener = this.mRetryIBrowseListener;
        if (iBrowseListener != null) {
            iBrowseListener.onBrowse(i10, list);
        }
    }

    public void setBrowseListener(IBrowseListener iBrowseListener) {
        this.mOuterBrowseListener = iBrowseListener;
    }

    public void setRetryBrowseListener(IBrowseListener iBrowseListener) {
        this.mRetryIBrowseListener = iBrowseListener;
    }

    public void stopBrowser() {
        this.mHandler.removeMessages(1);
    }
}
