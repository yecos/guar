package com.taobao.accs.net;

import android.content.Intent;
import android.os.Handler;
import anet.channel.ISessionListener;
import com.hpplay.component.protocol.push.IPushHandler;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;

/* loaded from: classes3.dex */
class m implements ISessionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9208a;

    public m(k kVar) {
        this.f9208a = kVar;
    }

    @Override // anet.channel.ISessionListener
    public void onConnectionChanged(Intent intent) {
        Handler handler;
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            ALog.e(this.f9208a.d(), "onConnectionChanged", "currentHost", "https://" + this.f9208a.f9165i.getInappHost(), "changeHost", stringExtra, IPushHandler.STATE, Boolean.valueOf(booleanExtra));
            if (("https://" + this.f9208a.f9165i.getInappHost()).equals(stringExtra)) {
                g.a(GlobalClientInfo.getContext()).a();
                int intExtra = intent.getIntExtra("errorCode", -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = booleanExtra ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, intExtra, stringExtra2);
                connectInfo.connected = booleanExtra;
                Iterator<AccsConnectStateListener> it = this.f9208a.n().iterator();
                while (it.hasNext()) {
                    AccsConnectStateListener next = it.next();
                    handler = this.f9208a.f9198r;
                    handler.post(new n(this, connectInfo, next));
                }
            }
        }
    }
}
