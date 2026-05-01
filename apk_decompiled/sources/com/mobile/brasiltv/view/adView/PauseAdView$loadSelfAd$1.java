package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i1;
import h9.t;

/* loaded from: classes3.dex */
public final class PauseAdView$loadSelfAd$1 extends t9.j implements s9.l {
    final /* synthetic */ AdInfo $adInfo;
    final /* synthetic */ PauseAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PauseAdView$loadSelfAd$1(AdInfo adInfo, PauseAdView pauseAdView) {
        super(1);
        this.$adInfo = adInfo;
        this.this$0 = pauseAdView;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f14242a;
    }

    public final void invoke(boolean z10) {
        if (!z10) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(8);
            return;
        }
        if (this.$adInfo.isShowFlag()) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(0);
        } else {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(8);
        }
        ((FrameLayout) this.this$0._$_findCachedViewById(R$id.mFlOwner)).setVisibility(0);
        i1.e(this.this$0.getContext(), "EVENT_AD_SHOW_PAUSE");
        PauseAdView pauseAdView = this.this$0;
        pauseAdView.reportDelayedSubp = i1.p(pauseAdView.getContext(), "EVENT_AD_LONG_SHOW_PAUSE");
        s1.q qVar = s1.q.f18727a;
        Context context = this.this$0.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context2 = this.this$0.getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        String m10 = bVar.m(context2);
        a6.a aVar = a6.a.f228a;
        qVar.j(context, m10, aVar.k(), this.$adInfo);
        s1.m mVar = s1.m.f18686a;
        Context context3 = this.this$0.getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        mVar.d0(context3, aVar.k(), this.$adInfo.getAd_id());
    }
}
