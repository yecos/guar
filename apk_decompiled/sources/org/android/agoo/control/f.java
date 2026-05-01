package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.service.SendMessage;

/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooFactory.a f17850a;

    public f(AgooFactory.a aVar) {
        this.f17850a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ServiceConnection serviceConnection;
        ServiceConnection serviceConnection2;
        SendMessage sendMessage;
        Intent intent;
        ServiceConnection serviceConnection3;
        try {
            ALog.d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            sendMessage = this.f17850a.f17831c;
            intent = this.f17850a.f17829a;
            sendMessage.doSend(intent);
            ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f17850a.f17831c = null;
            try {
                Context context = AgooFactory.mContext;
                serviceConnection3 = this.f17850a.f17832d;
                context.unbindService(serviceConnection3);
            } catch (Throwable th) {
                ALog.e("AgooFactory", "unbindService error", th, new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                ALog.e("AgooFactory", "send error", th2, new Object[0]);
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f17850a.f17831c = null;
                try {
                    Context context2 = AgooFactory.mContext;
                    serviceConnection2 = this.f17850a.f17832d;
                    context2.unbindService(serviceConnection2);
                } catch (Throwable th3) {
                    ALog.e("AgooFactory", "unbindService error", th3, new Object[0]);
                }
            } catch (Throwable th4) {
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f17850a.f17831c = null;
                try {
                    Context context3 = AgooFactory.mContext;
                    serviceConnection = this.f17850a.f17832d;
                    context3.unbindService(serviceConnection);
                } catch (Throwable th5) {
                    ALog.e("AgooFactory", "unbindService error", th5, new Object[0]);
                }
                throw th4;
            }
        }
    }
}
