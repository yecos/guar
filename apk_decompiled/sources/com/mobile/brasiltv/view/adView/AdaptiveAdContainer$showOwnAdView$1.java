package com.mobile.brasiltv.view.adView;

import com.advertlib.bean.AdInfo;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(com.advertlib.bean.AdInfo r4, boolean r5) {
        /*
            r3 = this;
            r0 = 8
            if (r5 == 0) goto L6b
            r5 = 0
            if (r4 == 0) goto Lf
            boolean r1 = r4.isShowFlag()
            r2 = 1
            if (r1 != r2) goto Lf
            goto L10
        Lf:
            r2 = 0
        L10:
            if (r2 == 0) goto L20
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            int r1 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r5)
            goto L2d
        L20:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r1 = r3.this$0
            int r2 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r0)
        L2d:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            com.mobile.brasiltv.view.adView.AdaptiveAdView$AdaptiveAdCallback r0 = com.mobile.brasiltv.view.adView.AdaptiveAdContainer.access$getMListener$p(r0)
            if (r0 == 0) goto L38
            r0.onAdLoaded()
        L38:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer.access$reportEvent(r0, r5)
            s1.m r5 = s1.m.f18686a
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "context"
            t9.i.f(r0, r1)
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r1 = r3.this$0
            int r2 = com.mobile.brasiltv.R$id.mIvAd
            android.view.View r1 = r1._$_findCachedViewById(r2)
            com.mobile.brasiltv.view.adView.AdvertImageView r1 = (com.mobile.brasiltv.view.adView.AdvertImageView) r1
            java.lang.String r1 = r1.getAdType()
            java.lang.String r2 = ""
            if (r1 != 0) goto L5d
            r1 = r2
        L5d:
            if (r4 == 0) goto L67
            java.lang.String r4 = r4.getAd_id()
            if (r4 != 0) goto L66
            goto L67
        L66:
            r2 = r4
        L67:
            r5.d0(r0, r1, r2)
            goto L83
        L6b:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r4 = r3.this$0
            int r5 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r4 = r4._$_findCachedViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r0)
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r4 = r3.this$0
            com.mobile.brasiltv.view.adView.AdaptiveAdView$AdaptiveAdCallback r4 = com.mobile.brasiltv.view.adView.AdaptiveAdContainer.access$getMListener$p(r4)
            if (r4 == 0) goto L83
            r4.onAdFailedToLoad()
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.adView.AdaptiveAdContainer$showOwnAdView$1.invoke(com.advertlib.bean.AdInfo, boolean):void");
    }
}
