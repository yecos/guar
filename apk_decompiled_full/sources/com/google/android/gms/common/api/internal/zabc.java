package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class zabc extends com.google.android.gms.internal.base.zau {
    final /* synthetic */ zabe zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabc(zabe zabeVar, Looper looper) {
        super(looper);
        this.zaa = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            zabe.zaj(this.zaa);
        } else {
            if (i10 == 2) {
                zabe.zai(this.zaa);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown message id: ");
            sb.append(i10);
        }
    }
}
