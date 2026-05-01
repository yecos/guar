package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import h9.t;

/* loaded from: classes3.dex */
public final class PauseAdView$loadSelfAdOnAdmob$1 extends t9.j implements s9.l {
    final /* synthetic */ AdInfo $adInfo;
    final /* synthetic */ String $adtype;
    final /* synthetic */ PauseAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PauseAdView$loadSelfAdOnAdmob$1(PauseAdView pauseAdView, AdInfo adInfo, String str) {
        super(1);
        this.this$0 = pauseAdView;
        this.$adInfo = adInfo;
        this.$adtype = str;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f14242a;
    }

    public final void invoke(boolean z10) {
        if (!z10) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
            return;
        }
        ((FrameLayout) this.this$0._$_findCachedViewById(R$id.mFlAdmob)).setVisibility(0);
        ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvOwnerAd2)).setVisibility(0);
        this.this$0.adjustSelfAdOnAdmob();
        if (!this.$adInfo.isShowFlag()) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
        } else if (this.this$0.getResources().getConfiguration().orientation == 1) {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(0);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
        } else {
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(0);
        }
        s1.q qVar = s1.q.f18727a;
        Context context = this.this$0.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context2 = this.this$0.getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        qVar.j(context, bVar.m(context2), this.$adtype, this.$adInfo);
        s1.m mVar = s1.m.f18686a;
        Context context3 = this.this$0.getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        mVar.d0(context3, this.$adtype, this.$adInfo.getAd_id());
    }
}
