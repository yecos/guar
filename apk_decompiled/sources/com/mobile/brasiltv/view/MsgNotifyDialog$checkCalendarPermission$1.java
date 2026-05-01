package com.mobile.brasiltv.view;

import android.content.Intent;
import android.net.Uri;

/* loaded from: classes3.dex */
public final class MsgNotifyDialog$checkCalendarPermission$1 extends t9.j implements s9.l {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$checkCalendarPermission$1(MsgNotifyDialog msgNotifyDialog) {
        super(1);
        this.this$0 = msgNotifyDialog;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return h9.t.f14242a;
    }

    public final void invoke(Boolean bool) {
        com.mobile.brasiltv.utils.b0.U(this.this$0, "check calendar permission: " + bool);
        t9.i.f(bool, "it");
        if (bool.booleanValue()) {
            this.this$0.requestCalendarPermission();
            return;
        }
        this.this$0.getContext().startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.this$0.getContext().getPackageName())));
    }
}
