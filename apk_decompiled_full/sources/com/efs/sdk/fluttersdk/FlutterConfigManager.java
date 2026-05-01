package com.efs.sdk.fluttersdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class FlutterConfigManager {

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f6245c;

    /* renamed from: i, reason: collision with root package name */
    private Context f6251i;

    /* renamed from: a, reason: collision with root package name */
    private final String f6243a = "FlutterConfigManager";

    /* renamed from: b, reason: collision with root package name */
    private final int f6244b = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f6246d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f6247e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f6248f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f6249g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6250h = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6252j = false;

    public FlutterConfigManager(Context context, EfsReporter efsReporter) {
        this.f6251i = context;
        this.f6245c = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"flutter_pv_sampling_rate", "flutter_pv_max_count", "flutter_dart_exception_state", "flutter_dart_exception_max_count"}, new IConfigCallback() { // from class: com.efs.sdk.fluttersdk.FlutterConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("flutter_pv_sampling_rate");
                    if (obj != null) {
                        FlutterConfigManager.this.f6246d = Integer.parseInt(obj.toString());
                        FlutterConfigManager flutterConfigManager = FlutterConfigManager.this;
                        flutterConfigManager.f6250h = FlutterConfigManager.a(flutterConfigManager.f6246d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    Object obj2 = map.get("flutter_pv_max_count");
                    if (obj2 != null) {
                        FlutterConfigManager.this.f6247e = Integer.parseInt(obj2.toString());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    Object obj3 = map.get("flutter_dart_exception_state");
                    if (obj3 != null) {
                        FlutterConfigManager.this.f6248f = Integer.parseInt(obj3.toString());
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    Object obj4 = map.get("flutter_dart_exception_max_count");
                    if (obj4 != null) {
                        FlutterConfigManager.this.f6249g = Integer.parseInt(obj4.toString());
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                FlutterConfigManager.b(FlutterConfigManager.this);
            }
        });
    }

    public Map<String, Object> getCloudConfig() {
        if (!this.f6252j) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("flutter_pv_max_count", Integer.valueOf(this.f6247e));
        hashMap.put("flutter_dart_exception_state", Integer.valueOf(this.f6248f));
        hashMap.put("flutter_dart_exception_max_count", Integer.valueOf(this.f6249g));
        hashMap.put("flutter_pv_sampling_hit", Boolean.valueOf(this.f6250h));
        return hashMap;
    }

    public Map<String, Object> getNativeParams() {
        HashMap hashMap = null;
        if (!this.f6252j) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                Intent registerReceiver = this.f6251i.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                hashMap2.put(bt.Z, Integer.valueOf(registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0)));
                hashMap2.put("temperature", Integer.valueOf(registerReceiver.getIntExtra("temperature", 0)));
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                long blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
                long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[1];
                double d10 = availableBlocksLong;
                double d11 = blockCountLong;
                Double.isNaN(d10);
                Double.isNaN(d11);
                objArr[0] = Double.valueOf((d10 / d11) * 100.0d);
                hashMap2.put("disk_ratio", String.format(locale, "%.2f", objArr));
                hashMap2.putAll(GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap());
                hashMap2.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
                return hashMap2;
            } catch (Throwable unused) {
                hashMap = hashMap2;
                return hashMap;
            }
        } catch (Throwable unused2) {
        }
    }

    public boolean isFlutterEnable() {
        return this.f6250h;
    }

    public static /* synthetic */ boolean b(FlutterConfigManager flutterConfigManager) {
        flutterConfigManager.f6252j = true;
        return true;
    }

    public static /* synthetic */ boolean a(int i10) {
        if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i10 != 0) {
            return i10 == 100 || new Random().nextInt(100) <= i10;
        }
        return false;
    }
}
