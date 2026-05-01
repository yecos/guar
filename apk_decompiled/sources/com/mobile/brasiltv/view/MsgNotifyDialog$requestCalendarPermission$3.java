package com.mobile.brasiltv.view;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class MsgNotifyDialog$requestCalendarPermission$3 extends t9.j implements s9.l {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$requestCalendarPermission$3(MsgNotifyDialog msgNotifyDialog) {
        super(1);
        this.this$0 = msgNotifyDialog;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<Boolean>) obj);
        return h9.t.f14242a;
    }

    public final void invoke(ArrayList<Boolean> arrayList) {
        Boolean bool = arrayList.get(0);
        t9.i.f(bool, "it[0]");
        if (bool.booleanValue()) {
            this.this$0.dismiss();
        }
    }
}
