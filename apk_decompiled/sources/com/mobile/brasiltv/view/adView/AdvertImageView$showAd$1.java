package com.mobile.brasiltv.view.adView;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import h9.t;

/* loaded from: classes3.dex */
public final class AdvertImageView$showAd$1 extends t9.j implements s9.l {
    final /* synthetic */ AdvertImageView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvertImageView$showAd$1(AdvertImageView advertImageView) {
        super(1);
        this.this$0 = advertImageView;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f14242a;
    }

    public final void invoke(boolean z10) {
        s9.p pVar;
        String str;
        AdInfo adInfo;
        AdInfo adInfo2;
        pVar = this.this$0.mShowAdListener;
        if (pVar != null) {
            adInfo2 = this.this$0.mAdInfo;
            pVar.invoke(adInfo2, Boolean.valueOf(z10));
        }
        if (z10) {
            s1.q qVar = s1.q.f18727a;
            Context context = this.this$0.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            d6.b bVar = d6.b.f12660a;
            Context context2 = this.this$0.getContext();
            t9.i.f(context2, com.umeng.analytics.pro.f.X);
            String m10 = bVar.m(context2);
            str = this.this$0.mAdType;
            if (str == null) {
                str = "";
            }
            adInfo = this.this$0.mAdInfo;
            t9.i.d(adInfo);
            qVar.j(context, m10, str, adInfo);
        }
    }
}
