package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17843a;

    public c(AgooFactory agooFactory) {
        this.f17843a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        messageService = this.f17843a.messageService;
        ArrayList<MsgDO> b10 = messageService.b();
        if (b10 == null || b10.size() <= 0) {
            return;
        }
        ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(b10.size()));
        Iterator<MsgDO> it = b10.iterator();
        while (it.hasNext()) {
            MsgDO next = it.next();
            if (next != null) {
                next.isFromCache = true;
                this.f17843a.notifyManager.report(next, null);
            }
        }
    }
}
