package com.efs.sdk.base.core.config.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public static final Random f6148a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public IConfigRefreshAction f6149b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6150c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteConfig f6151d;

    /* renamed from: e, reason: collision with root package name */
    public Map<IConfigCallback, String[]> f6152e;

    /* renamed from: f, reason: collision with root package name */
    public Map<IConfigCallback, String[]> f6153f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f6154g;

    /* renamed from: h, reason: collision with root package name */
    private d f6155h;

    /* renamed from: i, reason: collision with root package name */
    private long f6156i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6157j;

    /* renamed from: k, reason: collision with root package name */
    private int f6158k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6162a = new b(0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    private void f() {
        boolean z10;
        try {
            z10 = this.f6155h.a(this.f6151d);
        } catch (Throwable unused) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        this.f6154g.sendEmptyMessageDelayed(3, 3000L);
    }

    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.f6149b;
        return iConfigRefreshAction == null ? com.efs.sdk.base.core.config.remote.a.a() : iConfigRefreshAction;
    }

    private boolean h() {
        d.b();
        long j10 = 0;
        try {
            d dVar = this.f6155h;
            dVar.c();
            if (dVar.f6164a != null) {
                j10 = dVar.f6164a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        boolean z10 = System.currentTimeMillis() - j10 >= (this.f6151d.f6145d * 60) * 1000;
        Log.i("efs.config", "isUpdate ".concat(String.valueOf(z10)));
        return z10;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message obtain = Message.obtain(null, 1, new JSONObject(this.f6151d.mSDKConfigMap).toString());
                Message obtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            Iterator<IEfsReporterObserver> it = ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers().iterator();
            while (it.hasNext()) {
                it.next().onConfigChange();
            }
        } catch (Throwable th) {
            Log.e("efs.config", th);
        }
    }

    private void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.remote.b.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.f6153f.keySet()) {
                        String[] strArr = (String[]) b.this.f6153f.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (b.this.f6151d.mSDKConfigMap.containsKey(str)) {
                                    hashMap.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "[from server] configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    b.this.f6153f.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        RemoteConfig remoteConfig;
        h hVar;
        int i10 = message.what;
        if (i10 == 0) {
            boolean a10 = d.a();
            Log.i("efs.config", "delete old config is ".concat(String.valueOf(a10)));
            if (a10) {
                this.f6154g.sendEmptyMessage(1);
            } else {
                d dVar = this.f6155h;
                dVar.c();
                if (dVar.f6164a == null) {
                    remoteConfig = null;
                } else {
                    RemoteConfig a11 = RemoteConfig.a();
                    a11.mConfigVersion = dVar.f6164a.getInt("cver", -1);
                    Set<String> keySet = dVar.f6164a.getAll().keySet();
                    HashMap hashMap = new HashMap();
                    for (String str : keySet) {
                        String string = dVar.f6164a.getString(str, "");
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(str, string);
                        }
                    }
                    a11.a(hashMap);
                    a11.a(dVar.f6164a.getString("sign", ""));
                    remoteConfig = a11;
                }
                if (remoteConfig == null) {
                    Log.i("efs.config", "first load local config false.");
                } else if (a(remoteConfig)) {
                    Log.i("efs.config", "current config to same.");
                } else {
                    this.f6151d = remoteConfig;
                    String str2 = "load config from storage";
                    if (-1 != remoteConfig.mConfigVersion) {
                        i();
                        Log.i("efs.config.register", "call back");
                        d();
                        j();
                        str2 = "load config from storage and notify observer";
                    }
                    Log.i("efs.config", str2);
                }
            }
        } else if (i10 == 1) {
            int i11 = message.arg1;
            if (i11 <= this.f6151d.mConfigVersion) {
                Log.i("efs.config", "current config version is " + i11 + ", no need to refresh");
                Log.i("efs.config", "current config version(" + this.f6151d.mConfigVersion + ") is " + i11 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i10 == 2) {
            try {
                hVar = h.a.f6096a;
                if (hVar.a()) {
                    if (h()) {
                        Log.i("efs.config", "update config");
                        e();
                    } else {
                        Log.i("efs.config", "No update is required, less than 8h since the last update");
                        try {
                            int parseInt = Integer.parseInt(UMEnvelopeBuild.imprintProperty(ControllerCenter.getGlobalEnvStruct().mAppContext, "apm_setting_cver", "-1"));
                            Log.d("efs.config", "APM_CVER_FROM_COMMON from UMEnvelopeBuild.imprintProperty is " + parseInt + " and mRemoteConfig.getConfigVersion() is " + this.f6151d.mConfigVersion);
                            if (parseInt > this.f6151d.mConfigVersion) {
                                this.f6154g.sendEmptyMessage(4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    ImprintHandler.getImprintService(ControllerCenter.getGlobalEnvStruct().mAppContext).registImprintCallback("apm_setting_cver", new UMImprintChangeCallback() { // from class: com.efs.sdk.base.core.config.remote.b.1
                        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                        public final void onImprintValueChanged(String str3, String str4) {
                            try {
                                int parseInt2 = Integer.parseInt(str4);
                                if (b.this.f6158k == parseInt2) {
                                    Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is equals to mCverFromCommonListener");
                                    return;
                                }
                                b.this.f6158k = parseInt2;
                                Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is " + parseInt2 + " and mRemoteConfig.getConfigVersion() is " + b.this.f6151d.mConfigVersion);
                                if (parseInt2 > b.this.f6151d.mConfigVersion) {
                                    b.this.f6154g.sendEmptyMessage(4);
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else if (i10 == 3) {
            f();
        } else if (i10 == 4) {
            e();
        }
        return true;
    }

    private b() {
        this.f6150c = true;
        this.f6152e = new HashMap();
        this.f6153f = new HashMap();
        this.f6157j = false;
        this.f6158k = -1;
        this.f6154g = new Handler(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper(), this);
        this.f6155h = new d();
        this.f6151d = RemoteConfig.a();
        this.f6156i = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
        this.f6157j = ControllerCenter.getGlobalEnvStruct().isOpenCodeLog();
    }

    private void e() {
        h hVar;
        hVar = h.a.f6096a;
        if (!hVar.a()) {
            Log.i("efs.config", "has no permission to refresh config from remote");
            return;
        }
        if (!this.f6150c) {
            Log.i("efs.config", "disable refresh config from remote");
            return;
        }
        String refresh = g().refresh();
        Log.i("efs.config", "from server. efs config is ".concat(String.valueOf(refresh)));
        if (TextUtils.isEmpty(refresh)) {
            Log.e("efs.config", "config is empty");
        } else {
            a(refresh);
        }
    }

    public final void b() {
        this.f6154g.sendEmptyMessage(0);
        this.f6154g.sendEmptyMessageDelayed(2, this.f6156i);
    }

    public final Map<String, String> c() {
        return new HashMap(this.f6151d.mSDKConfigMap);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.remote.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.f6152e.keySet()) {
                        String[] strArr = (String[]) b.this.f6152e.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (b.this.f6151d.mSDKConfigMap.containsKey(str)) {
                                    hashMap.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    b.this.f6152e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static b a() {
        return a.f6162a;
    }

    public final void a(int i10) {
        if (i10 <= this.f6151d.mConfigVersion) {
            Log.i("efs.config", "current config version is " + i10 + ", no need to refresh");
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i10;
        obtain.what = 1;
        this.f6154g.sendMessage(obtain);
    }

    public final String a(String str, String str2) {
        String str3 = this.f6151d.mSDKConfigMap.containsKey(str) ? this.f6151d.mSDKConfigMap.get(str) : str2;
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String a(boolean z10) {
        if (z10) {
            return "https://" + this.f6151d.f6144c;
        }
        return this.f6151d.f6143b + this.f6151d.f6144c;
    }

    public final void a(String str) {
        RemoteConfig a10 = RemoteConfig.a();
        if (c.a(str, a10)) {
            if (a(a10)) {
                return;
            }
            this.f6151d = a10;
            f();
            i();
            d();
            j();
            return;
        }
        this.f6154g.sendEmptyMessageDelayed(1, 3000L);
    }

    private boolean a(RemoteConfig remoteConfig) {
        if (this.f6157j) {
            return false;
        }
        if (this.f6151d.mConfigVersion >= remoteConfig.mConfigVersion) {
            return true;
        }
        Log.i("efs.config", "current config version (" + this.f6151d.mConfigVersion + ") is older than another (" + remoteConfig.mConfigVersion + ")");
        return false;
    }
}
