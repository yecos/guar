package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* loaded from: classes3.dex */
class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private PendingIntent f9180c;

    /* renamed from: d, reason: collision with root package name */
    private AlarmManager f9181d;

    public e(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    public void a(int i10) {
        if (GlobalConfig.isAlarmHeartbeatEnable()) {
            if (this.f9181d == null) {
                this.f9181d = (AlarmManager) this.f9185a.getSystemService("alarm");
            }
            if (this.f9181d == null) {
                ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
                return;
            }
            if (this.f9180c == null) {
                Intent intent = new Intent();
                intent.setPackage(this.f9185a.getPackageName());
                intent.addFlags(32);
                intent.setAction(Constants.ACTION_COMMAND);
                intent.putExtra("command", 201);
                this.f9180c = PendingIntent.getBroadcast(this.f9185a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(13, i10);
            this.f9181d.set(0, calendar.getTimeInMillis(), this.f9180c);
        }
    }
}
