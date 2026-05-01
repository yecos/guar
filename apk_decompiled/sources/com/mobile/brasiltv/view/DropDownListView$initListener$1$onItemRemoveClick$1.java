package com.mobile.brasiltv.view;

import com.mobile.brasiltv.db.SwitchAccountBean;

/* loaded from: classes3.dex */
public final class DropDownListView$initListener$1$onItemRemoveClick$1 extends t9.j implements s9.a {
    final /* synthetic */ SwitchAccountBean $bean;
    final /* synthetic */ int $position;
    final /* synthetic */ DropDownListView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownListView$initListener$1$onItemRemoveClick$1(DropDownListView dropDownListView, int i10, SwitchAccountBean switchAccountBean) {
        super(0);
        this.this$0 = dropDownListView;
        this.$position = i10;
        this.$bean = switchAccountBean;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m63invoke() {
        s9.p pVar;
        int i10;
        DropDownPop dropDownPop;
        pVar = this.this$0.mRemoveListener;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(this.$position), this.$bean);
        }
        int i11 = this.$position;
        i10 = this.this$0.mSelectPos;
        if (i11 == i10) {
            this.this$0.mSelectPos = 0;
        }
        dropDownPop = this.this$0.mPop;
        dropDownPop.dismiss();
    }

    @Override // s9.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m63invoke();
        return h9.t.f14242a;
    }
}
