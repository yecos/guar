package com.hpplay.sdk.source.process;

import android.content.Context;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.CastUtil;

/* loaded from: classes3.dex */
public class PushConnectCallback implements LelinkSdkManager.ConnectCallback {
    private static final String TAG = "PushConnectCallback";
    private LelinkServiceInfo lelinkServiceInfo;
    private Context mContext;
    private OutParameter playInfo;
    private LelinkPlayerInfo playerInfo;

    public PushConnectCallback(Context context, OutParameter outParameter, LelinkPlayerInfo lelinkPlayerInfo, LelinkServiceInfo lelinkServiceInfo) {
        this.mContext = context;
        this.playInfo = outParameter;
        this.playerInfo = lelinkPlayerInfo;
        this.lelinkServiceInfo = lelinkServiceInfo;
    }

    @Override // com.hpplay.sdk.source.process.LelinkSdkManager.ConnectCallback
    public void onConnect(int i10, boolean z10) {
        if (i10 == 3) {
            this.playInfo.currentBrowserInfo = CastUtil.getPrePushInfoByProtocol(this.lelinkServiceInfo, i10);
        } else {
            this.playInfo.currentBrowserInfo = CastUtil.getPrePushInfo(this.lelinkServiceInfo);
        }
        OutParameter outParameter = this.playInfo;
        BrowserInfo browserInfo = outParameter.currentBrowserInfo;
        if (browserInfo == null) {
            SourceLog.w(TAG, "startPlayMedia ignore,invalid browser info");
            return;
        }
        outParameter.protocol = browserInfo.getType();
        this.playInfo.connectSession = ConnectManager.getInstance().getConnectSession(this.lelinkServiceInfo);
        BusinessEntity.getInstance().dispatch(this.mContext, this.playInfo, false);
    }
}
