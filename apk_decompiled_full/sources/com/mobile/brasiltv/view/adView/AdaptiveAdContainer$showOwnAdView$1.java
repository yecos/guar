package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.adView.AdaptiveAdView;
import h9.t;

/* loaded from: classes3.dex */
public final class AdaptiveAdContainer$showOwnAdView$1 extends t9.j implements s9.p {
    final /* synthetic */ AdaptiveAdContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer$showOwnAdView$1(AdaptiveAdContainer adaptiveAdContainer) {
        super(2);
        this.this$0 = adaptiveAdContainer;
    }

    @Override // s9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((AdInfo) obj, ((Boolean) obj2).booleanValue());
        return t.f14242a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r4.isShowFlag() == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(AdInfo adInfo, boolean z10) {
        AdaptiveAdView.AdaptiveAdCallback adaptiveAdCallback;
        AdaptiveAdView.AdaptiveAdCallback adaptiveAdCallback2;
        String ad_id;
        if (!z10) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
            adaptiveAdCallback = this.this$0.mListener;
            if (adaptiveAdCallback != null) {
                adaptiveAdCallback.onAdFailedToLoad();
                return;
            }
            return;
        }
        boolean z11 = adInfo != null;
        if (z11) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(0);
        } else {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
        }
        adaptiveAdCallback2 = this.this$0.mListener;
        if (adaptiveAdCallback2 != null) {
            adaptiveAdCallback2.onAdLoaded();
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
    }
}
