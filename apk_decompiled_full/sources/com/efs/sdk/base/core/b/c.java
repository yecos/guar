package com.efs.sdk.base.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f6066a = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.b.c.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f6067b = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.b.c.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", 2097152L);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private Map<String, AtomicInteger> f6068c;

    /* renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f6069d;

    /* renamed from: e, reason: collision with root package name */
    private volatile SharedPreferences.Editor f6070e;

    /* renamed from: f, reason: collision with root package name */
    private Context f6071f;

    /* renamed from: g, reason: collision with root package name */
    private String f6072g;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f6073a = new c(0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c a() {
        return a.f6073a;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th) {
            Log.e("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.f6069d == null) {
            synchronized (c.class) {
                if (this.f6069d == null) {
                    this.f6069d = SharedPreferencesUtils.getSharedPreferences(this.f6071f, this.f6072g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.f6070e == null) {
            synchronized (c.class) {
                if (this.f6070e == null) {
                    this.f6070e = this.f6069d.edit();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i10 = message.what;
        if (i10 == 0) {
            b();
            if (this.f6069d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
                return;
            }
            if (this.f6070e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
                return;
            }
            String valueOf = String.valueOf(message.obj);
            long j10 = message.arg1;
            String netStatus = GlobalInfoManager.getInstance().getNetStatus();
            for (String str : f6066a.keySet()) {
                String concat = "curr_time_".concat(String.valueOf(str));
                if (!this.f6069d.contains(concat)) {
                    this.f6070e.putLong(concat, System.currentTimeMillis());
                }
                for (String str2 : a(str, valueOf, netStatus)) {
                    this.f6070e.putLong(str2, this.f6069d.getLong(str2, 0L) + j10);
                }
            }
            this.f6070e.apply();
            return;
        }
        if (i10 != 1) {
            Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
            return;
        }
        String valueOf2 = String.valueOf(message.obj);
        long j11 = message.arg1;
        b();
        if (this.f6069d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            return;
        }
        if (this.f6070e == null) {
            Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            return;
        }
        String concat2 = "curr_time_".concat(valueOf2);
        if (Math.abs(System.currentTimeMillis() - this.f6069d.getLong(concat2, System.currentTimeMillis())) >= j11) {
            for (String str3 : this.f6069d.getAll().keySet()) {
                if (str3.startsWith(valueOf2)) {
                    this.f6070e.putLong(str3, 0L);
                }
            }
            this.f6070e.putLong(concat2, System.currentTimeMillis());
            this.f6070e.apply();
            this.f6068c.clear();
        }
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper());
        this.f6068c = new ConcurrentHashMap(5);
        this.f6071f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.f6072g = ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        File c10 = com.efs.sdk.base.core.util.a.c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (c10.exists()) {
            FileUtil.delete(c10);
        }
    }

    public final boolean a(String str, long j10) {
        String netStatus = GlobalInfoManager.getInstance().getNetStatus();
        boolean z10 = true;
        for (Map.Entry<String, Long> entry : f6066a.entrySet()) {
            z10 = a(entry.getKey(), entry.getValue().longValue(), str, netStatus, j10);
            if (!z10) {
                break;
            }
        }
        return z10;
    }

    private boolean a(String str, long j10, String str2, String str3, long j11) {
        b();
        if (this.f6069d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> a10 = a(str, str2, str3);
        Map<String, String> c10 = com.efs.sdk.base.core.config.remote.b.a().c();
        for (String str4 : a10) {
            if (Math.abs(System.currentTimeMillis() - this.f6069d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j10) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                obtain.arg1 = Long.valueOf(j10).intValue();
                sendMessage(obtain);
            }
            long a11 = a(c10, str, str4);
            long j12 = this.f6069d.getLong(str4, 0L);
            if (j12 + j11 > a11) {
                Log.i("efs.flow", "flow limit, key: " + str4 + ", max: " + a11 + ", now: " + j12 + ", size: " + j11);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void a(String str) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        if (!this.f6068c.containsKey(str) || this.f6068c.get(str) == null || this.f6068c.get(str).get() <= 10) {
            fVar = f.a.f6196a;
            fVar.a(com.efs.sdk.base.core.config.remote.b.a().f6151d.mConfigVersion, str);
            if (str.equals("flow_day")) {
                fVar2 = f.a.f6196a;
                fVar2.a(com.efs.sdk.base.core.config.remote.b.a().f6151d.mConfigVersion);
            }
            if (!this.f6068c.containsKey(str)) {
                this.f6068c.put(str, new AtomicInteger());
            }
            this.f6068c.get(str).incrementAndGet();
        }
    }

    private static long a(Map<String, String> map, String str, String str2) {
        long longValue = f6067b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return longValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            Log.w("efs.flow", "get max flow error", th);
            return longValue;
        }
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }
}
