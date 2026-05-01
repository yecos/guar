package com.alibaba.sdk.android.httpdns.a;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.beacon.Beacon;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.i;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5839a;
    private Context mContext = null;

    /* renamed from: a, reason: collision with other field name */
    private b f3a = null;

    /* renamed from: a, reason: collision with other field name */
    private Beacon f2a = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5840m = true;

    /* renamed from: a, reason: collision with other field name */
    private final Beacon.OnUpdateListener f1a = new Beacon.OnUpdateListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.1
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnUpdateListener
        public void onUpdate(List<Beacon.Config> list) {
            try {
                a.this.b(list);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private final Beacon.OnServiceErrListener f0a = new Beacon.OnServiceErrListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.2
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnServiceErrListener
        public void onErr(Beacon.Error error) {
            Log.e("HTTPDNS:BeaconManager", "beacon error. errorCode:" + error.errCode + ", errorMsg:" + error.errMsg);
        }
    };

    private a() {
    }

    public static a a() {
        if (f5839a == null) {
            synchronized (a.class) {
                if (f5839a == null) {
                    f5839a = new a();
                }
            }
        }
        return f5839a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<Beacon.Config> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Beacon.Config config : list) {
            if (config.key.equalsIgnoreCase("___httpdns_service___")) {
                a(config);
            }
        }
    }

    private void i(String str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("is IP probe enabled:");
            sb.append(str);
            this.f5840m = !str.equalsIgnoreCase("disabled");
        }
    }

    private void j(String str) {
        if (str != null) {
            com.alibaba.sdk.android.httpdns.b.a(!"disabled".equals(str));
            i.e("[beacon] httpdns enable: " + com.alibaba.sdk.android.httpdns.b.a());
        }
    }

    public void c(Context context, String str) {
        this.mContext = context;
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdkId", "httpdns");
            hashMap.put("accountId", str);
            Beacon build = new Beacon.Builder().appKey("24657847").appSecret("f30fc0937f2b1e9e50a1b7134f1ddb10").loopInterval(7200000L).extras(hashMap).build();
            this.f2a = build;
            build.addUpdateListener(this.f1a);
            this.f2a.addServiceErrListener(this.f0a);
            this.f2a.start(this.mContext.getApplicationContext());
        }
    }

    public boolean f() {
        return this.f5840m;
    }

    private boolean f(String str) {
        if (str == null || this.f3a == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is report enabled:");
        sb.append(str);
        if (str.equalsIgnoreCase("disabled")) {
            this.f3a.e(false);
        } else {
            this.f3a.e(true);
        }
        return true;
    }

    public void a(b bVar) {
        this.f3a = bVar;
    }

    private boolean a(Beacon.Config config) {
        if (config == null || !config.key.equalsIgnoreCase("___httpdns_service___")) {
            return false;
        }
        String str = config.value;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("httpdns configs:");
            sb.append(str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ut")) {
                    f(jSONObject.getString("ut"));
                }
                if (jSONObject.has("ip-ranking")) {
                    i(jSONObject.getString("ip-ranking"));
                }
                if (jSONObject.has(Constant.KEY_STATUS)) {
                    j(jSONObject.getString(Constant.KEY_STATUS));
                }
            } catch (Exception e10) {
                Log.e("HTTPDNS:BeaconManager", "parse push configs failed.", e10);
                return false;
            }
        }
        return true;
    }
}
