package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.adView.SmallAdNativeView;
import h9.t;

/* loaded from: classes3.dex */
public final class SmallAdNativeContainer$showOwnAdView$1 extends t9.j implements s9.p {
    final /* synthetic */ SmallAdNativeContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallAdNativeContainer$showOwnAdView$1(SmallAdNativeContainer smallAdNativeContainer) {
        super(2);
        this.this$0 = smallAdNativeContainer;
    }

    @Override // s9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((AdInfo) obj, ((Boolean) obj2).booleanValue());
        return t.f14242a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        if (r7.isShowFlag() == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(AdInfo adInfo, boolean z10) {
        SmallAdNativeView.NativeAdCallback nativeAdCallback;
        String ad_id;
        if (!z10) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
            return;
        }
        this.this$0.reportEvent(false);
        s1.m mVar = s1.m.f18686a;
        Context context = this.this$0.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        String adType = ((AdvertImageView) this.this$0._$_findCachedViewById(R$id.mIvAd)).getAdType();
        String str = "";
        if (adType == null) {
            adType = "";
        }
        if (adInfo != null && (ad_id = adInfo.getAd_id()) != null) {
            str = ad_id;
        }
        mVar.d0(context, adType, str);
        nativeAdCallback = this.this$0.mCallback;
        if (nativeAdCallback != null) {
            nativeAdCallback.onAttachNativeAd();
        }
        boolean z11 = adInfo != null;
        if (z11) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(0);
        } else {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
        }
    }
}
