package com.mobile.brasiltv.view.adView;

import com.advertlib.bean.AdInfo;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(com.advertlib.bean.AdInfo r7, boolean r8) {
        /*
            r6 = this;
            r0 = 8
            if (r8 == 0) goto L6b
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r8 = r6.this$0
            r1 = 0
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer.access$reportEvent(r8, r1)
            s1.m r8 = s1.m.f18686a
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r2 = r6.this$0
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "context"
            t9.i.f(r2, r3)
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r3 = r6.this$0
            int r4 = com.mobile.brasiltv.R$id.mIvAd
            android.view.View r3 = r3._$_findCachedViewById(r4)
            com.mobile.brasiltv.view.adView.AdvertImageView r3 = (com.mobile.brasiltv.view.adView.AdvertImageView) r3
            java.lang.String r3 = r3.getAdType()
            java.lang.String r4 = ""
            if (r3 != 0) goto L2a
            r3 = r4
        L2a:
            if (r7 == 0) goto L34
            java.lang.String r5 = r7.getAd_id()
            if (r5 != 0) goto L33
            goto L34
        L33:
            r4 = r5
        L34:
            r8.d0(r2, r3, r4)
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r8 = r6.this$0
            com.mobile.brasiltv.view.adView.SmallAdNativeView$NativeAdCallback r8 = com.mobile.brasiltv.view.adView.SmallAdNativeContainer.access$getMCallback$p(r8)
            if (r8 == 0) goto L42
            r8.onAttachNativeAd()
        L42:
            if (r7 == 0) goto L4c
            boolean r7 = r7.isShowFlag()
            r8 = 1
            if (r7 != r8) goto L4c
            goto L4d
        L4c:
            r8 = 0
        L4d:
            if (r8 == 0) goto L5d
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r1)
            goto L78
        L5d:
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r0)
            goto L78
        L6b:
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r0)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.adView.SmallAdNativeContainer$showOwnAdView$1.invoke(com.advertlib.bean.AdInfo, boolean):void");
    }
}
