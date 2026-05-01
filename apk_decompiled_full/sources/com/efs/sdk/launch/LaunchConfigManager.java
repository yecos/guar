package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class LaunchConfigManager {

    /* renamed from: a, reason: collision with root package name */
    private final String f6269a = "LaunchConfigManager";

    /* renamed from: b, reason: collision with root package name */
    private final int f6270b = 0;

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f6271c;

    /* renamed from: d, reason: collision with root package name */
    private int f6272d;

    /* renamed from: e, reason: collision with root package name */
    private int f6273e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6274f;

    /* renamed from: g, reason: collision with root package name */
    private Context f6275g;

    public LaunchConfigManager(Context context, EfsReporter efsReporter) {
        boolean z10;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        this.f6272d = 100;
        this.f6274f = false;
        Context applicationContext = context.getApplicationContext();
        this.f6275g = applicationContext;
        this.f6271c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.f6273e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f6275g.getSharedPreferences("efs_launch", 0);
        int i10 = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.f6271c.getAllSdkConfig(new String[]{"apm_startperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.launch.LaunchConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor edit6;
                try {
                    Object obj = map.get("apm_startperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = LaunchConfigManager.this.f6275g.getSharedPreferences("efs_launch", 0)) == null || (edit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    edit6.putInt("apm_startperf_sampling_rate", Integer.parseInt(obj.toString()));
                    edit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f6272d = i10;
        }
        SharedPreferences sharedPreferences4 = this.f6275g.getSharedPreferences("efs_launch", 0);
        long j10 = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z11 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        if (this.f6272d != 0) {
            z10 = true;
            if (!SamplingWhiteListUtil.isHitWL()) {
                boolean z12 = this.f6272d != this.f6273e;
                Long valueOf = Long.valueOf(j10);
                int i11 = this.f6272d;
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z11 && valueOf3.longValue() < 86400000 && !z12) {
                    boolean z13 = LaunchManager.isDebug;
                } else if (valueOf3.longValue() >= 86400000 || z12) {
                    if (i11 != 0 && (i11 == 100 || new Random().nextInt(100) <= i11)) {
                        boolean z14 = LaunchManager.isDebug;
                    } else {
                        boolean z15 = LaunchManager.isDebug;
                        z10 = false;
                    }
                    SharedPreferences sharedPreferences5 = this.f6275g.getSharedPreferences("efs_launch", 0);
                    if (sharedPreferences5 != null && (edit2 = sharedPreferences5.edit()) != null) {
                        edit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z10);
                        edit2.commit();
                    }
                    if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                        edit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                        edit.commit();
                    }
                } else {
                    boolean z16 = LaunchManager.isDebug;
                }
            }
            this.f6274f = z10;
            sharedPreferences = this.f6275g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (edit3 = sharedPreferences.edit()) == null) {
            }
            edit3.putInt("apm_startperf_sampling_rate_last", this.f6272d);
            edit3.commit();
            return;
        }
        if (z11 && sharedPreferences4 != null && (edit5 = sharedPreferences4.edit()) != null) {
            edit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            edit5.commit();
        }
        if (j10 != 0 && sharedPreferences4 != null && (edit4 = sharedPreferences4.edit()) != null) {
            edit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            edit4.commit();
        }
        z10 = false;
        this.f6274f = z10;
        sharedPreferences = this.f6275g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f6274f;
    }
}
