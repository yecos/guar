package com.mobile.brasiltv.view.adView;

import android.content.Context;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class PauseAdView$mAdPortUnitId$2 extends t9.j implements s9.a {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PauseAdView$mAdPortUnitId$2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // s9.a
    public final String invoke() {
        String string = this.$context.getString(R.string.play_pause_ad_id_port);
        t9.i.f(string, "context.getString(R.string.play_pause_ad_id_port)");
        return string;
    }
}
