package com.mobile.brasiltv.view.login;

import com.mobile.brasiltv.db.SwitchAccountBean;

/* loaded from: classes3.dex */
public final class QuickLoginPanel$initListeners$2 extends t9.j implements s9.p {
    final /* synthetic */ QuickLoginPanel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel$initListeners$2(QuickLoginPanel quickLoginPanel) {
        super(2);
        this.this$0 = quickLoginPanel;
    }

    @Override // s9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (SwitchAccountBean) obj2);
        return h9.t.f14242a;
    }

    public final void invoke(int i10, SwitchAccountBean switchAccountBean) {
        IQuickLoginCallback iQuickLoginCallback;
        t9.i.g(switchAccountBean, "bean");
        iQuickLoginCallback = this.this$0.mQuickLoginCallback;
        if (iQuickLoginCallback != null) {
            iQuickLoginCallback.onRemoveAccount(i10, switchAccountBean);
        }
    }
}
