package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f3990a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f3991b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f3992c;

    public h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f3992c = sessionRequest;
        this.f3990a = intent;
        this.f3991b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable("intent", this.f3990a);
            messenger.send(message);
            try {
                this.f3991b.unbindService(this);
            } catch (Throwable th) {
                ALog.e("awcn.SessionRequest", "onServiceConnected unbindService error.", null, th, new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                ALog.e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, th2, new Object[0]);
                try {
                    this.f3991b.unbindService(this);
                } catch (Throwable th3) {
                    ALog.e("awcn.SessionRequest", "onServiceConnected unbindService error.", null, th3, new Object[0]);
                }
            } catch (Throwable th4) {
                try {
                    this.f3991b.unbindService(this);
                } catch (Throwable th5) {
                    ALog.e("awcn.SessionRequest", "onServiceConnected unbindService error.", null, th5, new Object[0]);
                }
                throw th4;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        try {
            this.f3991b.unbindService(this);
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "onServiceDisconnected unbindService error.", null, th, new Object[0]);
        }
    }
}
