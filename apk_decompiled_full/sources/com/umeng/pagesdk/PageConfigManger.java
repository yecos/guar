package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes3.dex */
public class PageConfigManger {
    public static final String APM_FPSPERF_COLLECT_INTERVAL = "apm_pageperf_collect_interval";
    public static final String APM_FPSPERF_COLLECT_INTERVAL_TOGETHER = "apm_pageperf_collect_interval_together";
    public static final String APM_FPSPERF_COLLECT_MAX_PERIOD_SEC = "apm_pageperf_collect_max_period_sec";

    /* renamed from: b, reason: collision with root package name */
    private Context f12256b;

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f12257c;

    /* renamed from: d, reason: collision with root package name */
    private int f12258d;

    /* renamed from: f, reason: collision with root package name */
    private int f12260f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12261g;

    /* renamed from: a, reason: collision with root package name */
    private final String f12255a = "PageConfigManager";

    /* renamed from: e, reason: collision with root package name */
    private final int f12259e = 0;

    public PageConfigManger(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        this.f12258d = 100;
        this.f12261g = false;
        Context applicationContext = context.getApplicationContext();
        this.f12256b = applicationContext;
        this.f12257c = efsReporter;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("efs_page", 0);
        if (sharedPreferences != null) {
            this.f12260f = sharedPreferences.getInt("apm_pageperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences2 = this.f12256b.getSharedPreferences("efs_page", 0);
        int i10 = sharedPreferences2 != null ? sharedPreferences2.getInt("apm_pageperf_sampling_rate", -1) : -1;
        this.f12257c.getAllSdkConfig(new String[]{"apm_pageperf_sampling_rate", APM_FPSPERF_COLLECT_INTERVAL, APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, APM_FPSPERF_COLLECT_MAX_PERIOD_SEC}, new IConfigCallback() { // from class: com.umeng.pagesdk.PageConfigManger.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences.Editor edit6;
                try {
                    SharedPreferences sharedPreferences3 = PageConfigManger.this.f12256b.getSharedPreferences("efs_page", 0);
                    if (sharedPreferences3 == null || (edit6 = sharedPreferences3.edit()) == null || map == null) {
                        return;
                    }
                    Object obj = map.get("apm_pageperf_sampling_rate");
                    if (obj != null) {
                        edit6.putInt("apm_pageperf_sampling_rate", Integer.parseInt(obj.toString()));
                    }
                    Object obj2 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL);
                    if (obj2 != null) {
                        edit6.putFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, Float.parseFloat(obj2.toString()) * 1000.0f);
                    }
                    Object obj3 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER);
                    if (obj3 != null) {
                        edit6.putInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, Integer.parseInt(obj3.toString()));
                    }
                    Object obj4 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC);
                    if (obj4 != null) {
                        edit6.putLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, Long.parseLong(obj4.toString()) * 1000);
                    }
                    edit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f12258d = i10;
        }
        boolean z10 = true;
        if (!SamplingWhiteListUtil.isHitWL()) {
            SharedPreferences sharedPreferences3 = this.f12256b.getSharedPreferences("efs_page", 0);
            long j10 = sharedPreferences3 != null ? sharedPreferences3.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
            boolean z11 = sharedPreferences3 != null ? sharedPreferences3.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i11 = this.f12258d;
            if (i11 == 0) {
                if (z11 && sharedPreferences3 != null && (edit5 = sharedPreferences3.edit()) != null) {
                    edit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    edit5.commit();
                }
                if (j10 != 0 && sharedPreferences3 != null && (edit4 = sharedPreferences3.edit()) != null) {
                    edit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                    edit4.commit();
                }
            } else {
                boolean z12 = i11 != this.f12260f;
                Long valueOf = Long.valueOf(j10);
                int i12 = this.f12258d;
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z11 && valueOf3.longValue() < 86400000 && !z12) {
                    String str = PageManger.TAG;
                } else if (valueOf3.longValue() >= 86400000 || z12) {
                    if (i12 != 0 && (i12 == 100 || new Random().nextInt(100) <= i12)) {
                        String str2 = PageManger.TAG;
                    } else {
                        String str3 = PageManger.TAG;
                        z10 = false;
                    }
                    SharedPreferences sharedPreferences4 = this.f12256b.getSharedPreferences("efs_page", 0);
                    if (sharedPreferences4 != null && (edit3 = sharedPreferences4.edit()) != null) {
                        edit3.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z10);
                        edit3.commit();
                    }
                    if (sharedPreferences4 != null && (edit2 = sharedPreferences4.edit()) != null) {
                        edit2.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                        edit2.commit();
                    }
                } else {
                    String str4 = PageManger.TAG;
                }
            }
            z10 = false;
        }
        this.f12261g = z10;
        SharedPreferences sharedPreferences5 = this.f12256b.getSharedPreferences("efs_page", 0);
        if (sharedPreferences5 == null || (edit = sharedPreferences5.edit()) == null) {
            return;
        }
        edit.putInt("apm_pageperf_sampling_rate_last", this.f12258d);
        edit.commit();
    }

    public boolean enableTracer() {
        return this.f12261g;
    }
}
