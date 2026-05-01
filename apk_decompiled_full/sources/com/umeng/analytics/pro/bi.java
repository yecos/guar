package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.analytics.pro.b;
import com.umeng.analytics.pro.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class bi implements be {

    /* renamed from: a, reason: collision with root package name */
    private static String f10013a = "";

    public static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f10014a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f10015b;

        public IBinder a() {
            if (this.f10014a) {
                throw new IllegalStateException();
            }
            this.f10014a = true;
            return this.f10015b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f10015b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f10014a = false;
            this.f10015b = new LinkedBlockingQueue<>();
        }
    }

    public static final class b extends b.AbstractBinderC0171b {
        @Override // com.umeng.analytics.pro.b
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        private b() {
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i10, Bundle bundle) {
            if (i10 != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString(c.f10017b);
            if (bi.c(string)) {
                String unused = bi.f10013a = string;
            }
        }
    }

    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final int f10016a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final String f10017b = "oa_id_flag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (c(string)) {
                    f10013a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        a aVar = new a();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, aVar, 1)) {
            try {
                c.b.a(aVar.a()).a(new b());
                return f10013a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
