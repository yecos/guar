package com.hpplay.sdk.source.easycast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.browse.api.IServiceSelectListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.c;
import com.hpplay.sdk.source.browser.view.a;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BrowserController {
    private static final String TAG = "BrowserController";
    public boolean isPush;
    private a mBrowserView;
    private IEasyCastListener mCastListener;
    private ViewGroup mContainerView;
    private List<LelinkServiceInfo> mLelinkServiceInfoList;
    private IServiceSelectListener mServiceSelectListener;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private c mBusinessCallback = new c() { // from class: com.hpplay.sdk.source.easycast.BrowserController.1
        @Override // com.hpplay.sdk.source.browser.c
        public void onDestroy() {
            SourceLog.i(BrowserController.TAG, "IBrowserUICallback onDestroy");
            BrowserController.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    BrowserController.this.destroyView();
                }
            });
        }

        @Override // com.hpplay.sdk.source.browser.c
        public void onRefresh() {
            BrowserController.this.browser();
        }

        @Override // com.hpplay.sdk.source.browser.c
        public void onSelect(int i10, com.hpplay.sdk.source.browser.a.a aVar) {
            try {
                for (LelinkServiceInfo lelinkServiceInfo : BrowserController.this.mLelinkServiceInfoList) {
                    if (lelinkServiceInfo.getName().equals(aVar.b())) {
                        SourceLog.i(BrowserController.TAG, "IBrowserUICallback onSelect position:" + i10 + ", info:" + lelinkServiceInfo);
                        BrowserController.this.mServiceSelectListener.onSelect(lelinkServiceInfo);
                        BrowserDevice.getInstance().setSelectInfo(lelinkServiceInfo);
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(BrowserController.TAG, e10);
            }
        }
    };
    private IEasyDeviceListener mListener = new IEasyDeviceListener() { // from class: com.hpplay.sdk.source.easycast.BrowserController.2
        @Override // com.hpplay.sdk.source.easycast.IEasyDeviceListener
        public void onBrowserResult(int i10) {
            if (BrowserController.this.mBrowserView != null) {
                BrowserController.this.mBrowserView.a(i10);
            }
        }

        @Override // com.hpplay.sdk.source.easycast.IEasyDeviceListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo) {
        }

        @Override // com.hpplay.sdk.source.easycast.IEasyDeviceListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            BrowserController.this.notifyError("网络异常", "请检查\n大屏和手机端网络后重试");
        }

        @Override // com.hpplay.sdk.source.easycast.IEasyDeviceListener
        public synchronized void onUpdateDevices(List<LelinkServiceInfo> list) {
            if (BrowserController.this.mBrowserView != null) {
                BrowserController.this.mLelinkServiceInfoList = list;
                BrowserController.this.mLelinkServiceBeanList.clear();
                try {
                    boolean z10 = false;
                    for (LelinkServiceInfo lelinkServiceInfo : BrowserController.this.mLelinkServiceInfoList) {
                        try {
                            if (BrowserController.this.isPush || lelinkServiceInfo.getTypes().toLowerCase().contains("lelink")) {
                                com.hpplay.sdk.source.browser.a.a aVar = new com.hpplay.sdk.source.browser.a.a();
                                aVar.a(lelinkServiceInfo.getAppId());
                                aVar.c(lelinkServiceInfo.getIp());
                                aVar.b(lelinkServiceInfo.getName());
                                aVar.a(lelinkServiceInfo.getUid());
                                if (!z10 && BrowserDevice.getInstance().isSelectInfo(lelinkServiceInfo)) {
                                    aVar.a(true);
                                    z10 = true;
                                }
                                BrowserController.this.mLelinkServiceBeanList.add(aVar);
                            } else {
                                SourceLog.i(BrowserController.TAG, "++++++++++++++++++++++" + lelinkServiceInfo.getName());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(BrowserController.TAG, e10);
                        }
                    }
                } catch (Exception e11) {
                    SourceLog.w(BrowserController.TAG, e11);
                }
                BrowserController.this.mBrowserView.a(BrowserController.this.mLelinkServiceBeanList);
            }
        }
    };
    private List<com.hpplay.sdk.source.browser.a.a> mLelinkServiceBeanList = new ArrayList();

    public BrowserController(ViewGroup viewGroup, boolean z10) {
        this.mContainerView = null;
        this.mContainerView = viewGroup;
        this.isPush = z10;
        initView();
    }

    private void initView() {
        if (this.mContainerView == null) {
            SourceLog.w(TAG, "initView ignore,mContainerView is null");
            return;
        }
        a aVar = this.mBrowserView;
        if (aVar != null && aVar.getParent() != null) {
            SourceLog.w(TAG, "initView ignore, parent is not null");
            return;
        }
        Context context = this.mContainerView.getContext();
        b.d(context);
        a aVar2 = new a(context, Session.getInstance().getBannerData());
        this.mBrowserView = aVar2;
        aVar2.setBusinessCallback(this.mBusinessCallback);
        LelinkSourceSDK.getInstance().setSearchBannerDataCallback(new ISearchBannerDataCallback() { // from class: com.hpplay.sdk.source.easycast.BrowserController.3
            @Override // com.hpplay.sdk.source.api.ISearchBannerDataCallback
            public void onBannerData(final String str) {
                if (BrowserController.this.mBrowserView != null) {
                    SourceLog.i(BrowserController.TAG, "onBannerData");
                    BrowserController.this.mBrowserView.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.easycast.BrowserController.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrowserController.this.mBrowserView.a(str);
                        }
                    }, 0L);
                    Session.getInstance().setBannerData(str);
                }
            }
        });
        this.mContainerView.addView(this.mBrowserView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void browser() {
        BrowserDevice.getInstance().setDeviceListener(this.mListener);
        BrowserDevice.getInstance().clearBrowseList();
        LelinkSourceSDK.getInstance().startBrowse();
    }

    public void destroyView() {
        SourceLog.i(TAG, "destroyView mBrowserView:" + this.mBrowserView);
        a aVar = this.mBrowserView;
        if (aVar == null) {
            return;
        }
        aVar.a();
        if (this.mBrowserView.getParent() != null) {
            try {
                SourceLog.i(TAG, "destroyView parent:" + this.mBrowserView.getParent());
                ((ViewGroup) this.mBrowserView.getParent()).removeView(this.mBrowserView);
                IEasyCastListener iEasyCastListener = this.mCastListener;
                if (iEasyCastListener != null) {
                    iEasyCastListener.onDismiss();
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        this.mBrowserView = null;
    }

    public boolean isShowing() {
        ViewGroup viewGroup = this.mContainerView;
        return viewGroup != null && viewGroup.getChildCount() > 0;
    }

    public void notifyError(String str, String str2) {
        a aVar = this.mBrowserView;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void release() {
        destroyView();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void setCastListener(IEasyCastListener iEasyCastListener) {
        this.mCastListener = iEasyCastListener;
    }

    public void setServiceSelectListener(IServiceSelectListener iServiceSelectListener) {
        this.mServiceSelectListener = iServiceSelectListener;
    }
}
