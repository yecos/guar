package com.mobile.brasiltv.view;

import com.mobile.brasiltv.view.AlphaRelativeLayout;

/* loaded from: classes3.dex */
public final class AlphaRelativeLayout$delayHide$1 extends t9.j implements s9.l {
    final /* synthetic */ AlphaRelativeLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaRelativeLayout$delayHide$1(AlphaRelativeLayout alphaRelativeLayout) {
        super(1);
        this.this$0 = alphaRelativeLayout;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return h9.t.f14242a;
    }

    public final void invoke(Long l10) {
        this.this$0.hide();
        AlphaRelativeLayout.OnVisibility listener = this.this$0.getListener();
        if (listener != null) {
            listener.onVisible(8);
        }
    }
}
