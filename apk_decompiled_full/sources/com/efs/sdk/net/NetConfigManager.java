package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class NetConfigManager {

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f6333c;

    /* renamed from: d, reason: collision with root package name */
    private int f6334d;

    /* renamed from: e, reason: collision with root package name */
    private int f6335e;

    /* renamed from: f, reason: collision with root package name */
    private int f6336f;

    /* renamed from: g, reason: collision with root package name */
    private int f6337g;

    /* renamed from: h, reason: collision with root package name */
    private int f6338h;

    /* renamed from: i, reason: collision with root package name */
    private int f6339i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6340j;

    /* renamed from: k, reason: collision with root package name */
    private Context f6341k;

    /* renamed from: l, reason: collision with root package name */
    private int f6342l;

    /* renamed from: a, reason: collision with root package name */
    private final String f6331a = "NetConfigManager";

    /* renamed from: b, reason: collision with root package name */
    private final int f6332b = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6343m = false;

    /* JADX WARN: Removed duplicated region for block: B:15:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetConfigManager(Context context, EfsReporter efsReporter) {
        int i10;
        boolean z10;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        int i11;
        int i12;
        SharedPreferences.Editor edit5;
        this.f6334d = 0;
        this.f6335e = 0;
        this.f6338h = 100;
        this.f6339i = 10;
        this.f6340j = false;
        this.f6342l = -1;
        Context applicationContext = context.getApplicationContext();
        this.f6341k = applicationContext;
        this.f6333c = efsReporter;
        SharedPreferences sharedPreferences3 = applicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences3 != null) {
            this.f6336f = sharedPreferences3.getInt("apm_netperf_sampling_rate_last", 0);
            this.f6337g = sharedPreferences3.getInt("apm_netperf_extra_last", 0);
        }
        SharedPreferences sharedPreferences4 = this.f6341k.getSharedPreferences("net_launch", 0);
        if (sharedPreferences4 != null) {
            i10 = sharedPreferences4.getInt("apm_netperf_sampling_rate", -1);
            this.f6335e = sharedPreferences4.getInt("apm_netperf_extra", -1);
        } else {
            i10 = -1;
        }
        this.f6333c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate", "apm_netperf_day_limit", "apm_netperf_data_rate", "apm_netperf_extra"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences5;
                final SharedPreferences.Editor edit6;
                SharedPreferences sharedPreferences6;
                final SharedPreferences.Editor edit7;
                try {
                    final Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj != null && (sharedPreferences6 = NetConfigManager.this.f6341k.getSharedPreferences("net_launch", 0)) != null && (edit7 = sharedPreferences6.edit()) != null) {
                        new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                edit7.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                                edit7.commit();
                            }
                        }).start();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    final Object obj2 = map.get("apm_netperf_extra");
                    if (obj2 != null && (sharedPreferences5 = NetConfigManager.this.f6341k.getSharedPreferences("net_launch", 0)) != null && (edit6 = sharedPreferences5.edit()) != null) {
                        new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                edit6.putInt("apm_netperf_extra", Integer.parseInt(obj2.toString()));
                                edit6.commit();
                            }
                        }).start();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    NetConfigManager.this.f6338h = Integer.parseInt(map.get("apm_netperf_day_limit").toString());
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    Object obj3 = map.get("apm_netperf_data_rate");
                    if (obj3 != null) {
                        NetConfigManager.this.f6339i = Integer.parseInt(obj3.toString());
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f6334d = i10;
        }
        if (!SamplingWhiteListUtil.isHitWL()) {
            SharedPreferences sharedPreferences5 = this.f6341k.getSharedPreferences("net_launch", 0);
            long j10 = sharedPreferences5 != null ? sharedPreferences5.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
            boolean z11 = sharedPreferences5 != null ? sharedPreferences5.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i13 = this.f6334d;
            if (i13 == 0) {
                if (z11 && sharedPreferences5 != null && (edit4 = sharedPreferences5.edit()) != null) {
                    edit4.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    edit4.commit();
                }
                if (j10 != 0 && sharedPreferences5 != null && (edit3 = sharedPreferences5.edit()) != null) {
                    edit3.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                    edit3.commit();
                }
            } else {
                boolean z12 = Math.max(i13, this.f6335e) != Math.max(this.f6336f, this.f6337g);
                Long valueOf = Long.valueOf(j10);
                int max = Math.max(this.f6334d, this.f6335e);
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z11 && valueOf3.longValue() < 86400000 && !z12) {
                    Log.d("NetConfigManager", " check in allready");
                } else {
                    if (valueOf3.longValue() >= 86400000 || z12) {
                        if (a(max)) {
                            Log.d("NetConfigManager", "random check in");
                            z10 = true;
                        } else {
                            Log.d("NetConfigManager", "random not check in!");
                            z10 = false;
                        }
                        SharedPreferences sharedPreferences6 = this.f6341k.getSharedPreferences("net_launch", 0);
                        if (sharedPreferences6 != null && (edit2 = sharedPreferences6.edit()) != null) {
                            edit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z10);
                            edit2.commit();
                        }
                        if (sharedPreferences6 != null && (edit = sharedPreferences6.edit()) != null) {
                            edit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                            edit.commit();
                        }
                        this.f6340j = z10;
                        sharedPreferences = this.f6341k.getSharedPreferences("net_launch", 0);
                        if (sharedPreferences != null && (edit5 = sharedPreferences.edit()) != null) {
                            edit5.putInt("apm_netperf_sampling_rate_last", this.f6334d);
                            edit5.putInt("apm_netperf_extra_last", this.f6335e);
                            edit5.commit();
                        }
                        sharedPreferences2 = this.f6341k.getSharedPreferences("net_launch", 0);
                        if (sharedPreferences2 != null) {
                            this.f6338h = sharedPreferences2.getInt("apm_netperf_day_limit", 0);
                            this.f6339i = sharedPreferences2.getInt("apm_netperf_data_rate", 0);
                        }
                        i11 = this.f6334d;
                        i12 = this.f6335e;
                        if (i11 >= i12) {
                            this.f6342l = 0;
                            return;
                        }
                        if (i12 == 0) {
                            this.f6342l = 0;
                            return;
                        } else if (a((i11 * 100) / i12)) {
                            this.f6342l = 0;
                            return;
                        } else {
                            this.f6342l = 1;
                            return;
                        }
                    }
                    Log.d("NetConfigManager", "un repeat check in 24 hour!");
                }
            }
            z10 = false;
            this.f6340j = z10;
            sharedPreferences = this.f6341k.getSharedPreferences("net_launch", 0);
            if (sharedPreferences != null) {
                edit5.putInt("apm_netperf_sampling_rate_last", this.f6334d);
                edit5.putInt("apm_netperf_extra_last", this.f6335e);
                edit5.commit();
            }
            sharedPreferences2 = this.f6341k.getSharedPreferences("net_launch", 0);
            if (sharedPreferences2 != null) {
            }
            i11 = this.f6334d;
            i12 = this.f6335e;
            if (i11 >= i12) {
            }
        }
        z10 = true;
        this.f6340j = z10;
        sharedPreferences = this.f6341k.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
        }
        sharedPreferences2 = this.f6341k.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
        }
        i11 = this.f6334d;
        i12 = this.f6335e;
        if (i11 >= i12) {
        }
    }

    public boolean enableTracer() {
        return this.f6340j;
    }

    public int getDataRate() {
        return this.f6339i;
    }

    public int getDayLimit() {
        return this.f6338h;
    }

    public int getExtraRateFlag() {
        return this.f6342l;
    }

    public boolean getNetRequestBodyCollectState() {
        return this.f6343m;
    }

    public void setNetRequestBodyCollectState(boolean z10) {
        this.f6343m = z10;
    }

    private static boolean a(int i10) {
        if (i10 == 0) {
            return false;
        }
        return i10 == 100 || new Random().nextInt(100) <= i10;
    }
}
