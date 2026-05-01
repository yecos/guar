package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f3872a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsSessionManager f3873b;

    public a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f3873b = accsSessionManager;
        this.f3872a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = AccsSessionManager.f3761c;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f3872a);
            } catch (Exception e10) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e10, new Object[0]);
            }
        }
    }
}
