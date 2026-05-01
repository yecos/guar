package org.android.agoo.control;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* loaded from: classes.dex */
class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17851a;

    public g(BaseIntentService baseIntentService) {
        this.f17851a = baseIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            ALog.i("BaseIntentService", "handleMessage on receive msg", Constant.KEY_MSG, message.toString());
            Intent intent = (Intent) message.getData().getParcelable("intent");
            if (intent != null) {
                ALog.i("BaseIntentService", "handleMessage get intent success", "intent", intent.toString());
                ThreadPoolExecutorFactory.execute(new h(this, intent));
            }
        }
    }
}
