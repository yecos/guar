package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class j extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f9130a;

    public j(MsgDistributeService msgDistributeService) {
        this.f9130a = msgDistributeService;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message != null) {
            ALog.i("MsgDistributeService", "handleMessage on receive msg", Constant.KEY_MSG, message.toString());
            Intent intent = (Intent) message.getData().getParcelable("intent");
            if (intent != null) {
                ALog.i("MsgDistributeService", "handleMessage get intent success", "intent", intent.toString());
                this.f9130a.onStartCommand(intent, 0, 0);
            }
        }
    }
}
