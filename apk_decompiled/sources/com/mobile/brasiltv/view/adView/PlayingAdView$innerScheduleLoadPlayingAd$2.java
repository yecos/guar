package com.mobile.brasiltv.view.adView;

import com.mobile.brasiltv.utils.b0;
import h9.t;

/* loaded from: classes3.dex */
public final class PlayingAdView$innerScheduleLoadPlayingAd$2 extends t9.j implements s9.l {
    final /* synthetic */ PlayingAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayingAdView$innerScheduleLoadPlayingAd$2(PlayingAdView playingAdView) {
        super(1);
        this.this$0 = playingAdView;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return t.f14242a;
    }

    public final void invoke(Throwable th) {
        th.printStackTrace();
        b0.U(this.this$0, "schedule load playing ad failure.");
    }
}
