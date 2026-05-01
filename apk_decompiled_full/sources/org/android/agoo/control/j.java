package org.android.agoo.control;

import android.content.Context;
import org.android.agoo.message.MessageService;

/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17855a;

    public j(BaseIntentService baseIntentService) {
        this.f17855a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        NotifManager notifManager;
        MessageService messageService;
        AgooFactory agooFactory;
        NotifManager notifManager2;
        MessageService messageService2;
        com.taobao.accs.client.a.f9050f.incrementAndGet();
        this.f17855a.notifyManager = new NotifManager();
        notifManager = this.f17855a.notifyManager;
        notifManager.init(this.f17855a.getApplicationContext());
        this.f17855a.messageService = new MessageService();
        messageService = this.f17855a.messageService;
        messageService.a(this.f17855a.getApplicationContext());
        this.f17855a.agooFactory = new AgooFactory();
        agooFactory = this.f17855a.agooFactory;
        Context applicationContext = this.f17855a.getApplicationContext();
        notifManager2 = this.f17855a.notifyManager;
        messageService2 = this.f17855a.messageService;
        agooFactory.init(applicationContext, notifManager2, messageService2);
    }
}
