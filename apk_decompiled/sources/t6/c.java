package t6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hpplay.component.protocol.push.IPushHandler;
import com.mobile.brasiltv.bean.event.StopPlayEvent;
import k7.f;
import q8.e;
import t9.i;

/* loaded from: classes3.dex */
public final class c extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final String f18908a = IPushHandler.REASON;

    /* renamed from: b, reason: collision with root package name */
    public final String f18909b = "recentapps";

    /* renamed from: c, reason: collision with root package name */
    public final String f18910c = "homekey";

    /* renamed from: d, reason: collision with root package name */
    public final String f18911d = "lock";

    /* renamed from: e, reason: collision with root package name */
    public final String f18912e = "dream";

    /* renamed from: f, reason: collision with root package name */
    public final String f18913f = "assist";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        i.g(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (i.b(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            String stringExtra = intent.getStringExtra(this.f18908a);
            f.e("reason: " + stringExtra, new Object[0]);
            if (i.b(stringExtra, this.f18910c) ? true : i.b(stringExtra, this.f18909b) ? true : i.b(stringExtra, this.f18911d) ? true : i.b(stringExtra, this.f18912e) ? true : i.b(stringExtra, this.f18913f)) {
                xa.c.c().j(new StopPlayEvent(StopPlayEvent.Reason.PRESS_HOME));
            }
        }
        if (i.b(action, "android.intent.action.SCREEN_OFF")) {
            f.e("SCREEN_OFF", new Object[0]);
            xa.c.c().j(new StopPlayEvent(StopPlayEvent.Reason.SCREEN_OFF));
            e.e("stop");
        } else if (i.b(action, "android.intent.action.SCREEN_ON")) {
            f.e("SCREEN_ON", new Object[0]);
            e.e("start");
        }
    }
}
