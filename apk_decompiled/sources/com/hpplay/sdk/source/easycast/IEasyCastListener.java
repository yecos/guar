package com.hpplay.sdk.source.easycast;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.easycast.bean.EasyCastBean;

/* loaded from: classes3.dex */
public interface IEasyCastListener {
    EasyCastBean onCast(LelinkServiceInfo lelinkServiceInfo);

    void onCastCompletion(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean);

    void onCastError(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean, int i10, int i11);

    void onCastLoading(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean);

    void onCastPause(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean);

    void onCastPositionUpdate(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean, long j10, long j11);

    void onCastStart(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean);

    void onCastStop(LelinkServiceInfo lelinkServiceInfo, EasyCastBean easyCastBean);

    void onDismiss();
}
