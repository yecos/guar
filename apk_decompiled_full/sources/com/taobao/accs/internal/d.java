package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.v;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class d implements IBaseService {

    /* renamed from: a, reason: collision with root package name */
    protected static ConcurrentHashMap<String, com.taobao.accs.net.a> f9151a = new ConcurrentHashMap<>(2);

    /* renamed from: b, reason: collision with root package name */
    private Context f9152b;

    /* renamed from: c, reason: collision with root package name */
    private Service f9153c;

    public d(Service service) {
        this.f9153c = service;
        this.f9152b = service.getApplicationContext();
    }

    public static com.taobao.accs.net.a a(Context context, String str, boolean z10) {
        com.taobao.accs.net.a aVar = null;
        try {
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "getConnection", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(f9151a.size()));
            if (f9151a.size() > 0) {
                return f9151a.elements().nextElement();
            }
            return null;
        }
        ALog.i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, "start", Boolean.valueOf(z10));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int b10 = v.b(context);
        String str2 = str + "|" + b10;
        synchronized (d.class) {
            try {
                com.taobao.accs.net.a aVar2 = f9151a.get(str2);
                if (aVar2 == null) {
                    try {
                        AccsClientConfig.mEnv = b10;
                        aVar = new com.taobao.accs.net.v(context, 0, str);
                        f9151a.put(str2, aVar);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    aVar = aVar2;
                }
                if (z10) {
                    aVar.a();
                }
                return aVar;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, "appSecret", stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.f9152b.getPackageName())) {
                v.a(this.f9152b, intExtra);
                com.taobao.accs.net.a a10 = a(this.f9152b, stringExtra5, false);
                if (a10 != null) {
                    a10.f9157a = stringExtra3;
                } else {
                    ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
                }
            }
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f9152b = null;
        this.f9153c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        }
        return a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    public static com.taobao.accs.net.a b(Context context, String str, boolean z10) {
        return a(context, str, z10);
    }
}
