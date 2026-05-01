package h1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: i, reason: collision with root package name */
    public static final String f14092i = a1.k.f("BatteryNotLowTracker");

    public b(Context context, m1.a aVar) {
        super(context, aVar);
    }

    @Override // h1.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // h1.c
    public void h(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        a1.k.c().a(f14092i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            d(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            d(Boolean.FALSE);
        }
    }

    @Override // h1.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent registerReceiver = this.f14098b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(registerReceiver.getIntExtra(Constant.KEY_STATUS, -1) == 1 || ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        a1.k.c().b(f14092i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
