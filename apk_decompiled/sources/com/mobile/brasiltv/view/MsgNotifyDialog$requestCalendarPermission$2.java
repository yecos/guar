package com.mobile.brasiltv.view;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class MsgNotifyDialog$requestCalendarPermission$2 extends t9.j implements s9.p {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$requestCalendarPermission$2(MsgNotifyDialog msgNotifyDialog) {
        super(2);
        this.this$0 = msgNotifyDialog;
    }

    @Override // s9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ArrayList<Boolean>) obj, (c8.a) obj2);
        return h9.t.f14242a;
    }

    public final void invoke(ArrayList<Boolean> arrayList, c8.a aVar) {
        com.mobile.brasiltv.utils.b0.U(this.this$0, "request calendar permission result: " + aVar);
        Boolean bool = arrayList.get(0);
        t9.i.f(bool, "t1[0]");
        arrayList.set(0, Boolean.valueOf(bool.booleanValue() && aVar.f5627b));
    }
}
