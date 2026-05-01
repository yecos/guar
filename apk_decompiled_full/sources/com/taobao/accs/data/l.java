package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f9132a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f9133b;

    public l(MsgDistributeService msgDistributeService, Intent intent) {
        this.f9133b = msgDistributeService;
        this.f9132a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.f9132a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.f9132a.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = this.f9132a.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra3 = this.f9132a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f9133b.getApplicationContext(), stringExtra2, stringExtra3).a(this.f9133b.getApplicationContext(), accsRequest, stringExtra, false);
    }
}
