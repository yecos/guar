package androidx.work.impl.diagnostics;

import a1.k;
import a1.m;
import a1.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3715a = k.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        k.c().a(f3715a, "Requesting diagnostics", new Throwable[0]);
        try {
            t.c(context).a(m.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e10) {
            k.c().b(f3715a, "WorkManager is not initialized", e10);
        }
    }
}
