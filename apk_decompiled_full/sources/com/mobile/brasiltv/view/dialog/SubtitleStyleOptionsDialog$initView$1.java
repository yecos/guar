package com.mobile.brasiltv.view.dialog;

import com.mobile.brasiltv.bean.SubtitleManager;
import g5.n3;

/* loaded from: classes3.dex */
public final class SubtitleStyleOptionsDialog$initView$1 extends t9.j implements s9.l {
    final /* synthetic */ SubtitleStyleOptionsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleStyleOptionsDialog$initView$1(SubtitleStyleOptionsDialog subtitleStyleOptionsDialog) {
        super(1);
        this.this$0 = subtitleStyleOptionsDialog;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return h9.t.f14242a;
    }

    public final void invoke(int i10) {
        n3 n3Var;
        n3 n3Var2;
        if (t9.i.b(this.this$0.getOptionType(), SubtitleManager.GLOBAL_SUBTITLE_COLOR)) {
            SubtitleManager.INSTANCE.setMGlobalColor(i10);
        }
        n3Var = this.this$0.mAdapter;
        if (n3Var != null) {
            n3Var.e(i10);
        }
        n3Var2 = this.this$0.mAdapter;
        if (n3Var2 != null) {
            n3Var2.notifyDataSetChanged();
        }
        this.this$0.cancel();
    }
}
