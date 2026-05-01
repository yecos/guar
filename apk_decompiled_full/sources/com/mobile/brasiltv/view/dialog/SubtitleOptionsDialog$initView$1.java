package com.mobile.brasiltv.view.dialog;

import com.mobile.brasiltv.bean.SubtitleManager;
import g5.l3;

/* loaded from: classes3.dex */
public final class SubtitleOptionsDialog$initView$1 extends t9.j implements s9.l {
    final /* synthetic */ SubtitleOptionsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsDialog$initView$1(SubtitleOptionsDialog subtitleOptionsDialog) {
        super(1);
        this.this$0 = subtitleOptionsDialog;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return h9.t.f14242a;
    }

    public final void invoke(int i10) {
        l3 l3Var;
        l3 l3Var2;
        String optionType = this.this$0.getOptionType();
        int hashCode = optionType.hashCode();
        if (hashCode != -2091952084) {
            if (hashCode != -2079692355) {
                if (hashCode == -1949434365 && optionType.equals(SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE)) {
                    SubtitleManager.INSTANCE.setMGlobalLanguage(i10);
                }
            } else if (optionType.equals(SubtitleManager.GLOBAL_AUDIO_LANGUAGE)) {
                SubtitleManager.INSTANCE.setMGlobalAudioLanguage(i10);
            }
        } else if (optionType.equals(SubtitleManager.GLOBAL_SUBTITLE_SIZE)) {
            SubtitleManager.INSTANCE.setMGlobalSize(i10);
        }
        l3Var = this.this$0.mAdapter;
        if (l3Var != null) {
            l3Var.e(i10);
        }
        l3Var2 = this.this$0.mAdapter;
        if (l3Var2 != null) {
            l3Var2.notifyDataSetChanged();
        }
        this.this$0.cancel();
    }
}
