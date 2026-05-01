package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentMap<String, Integer> f9386a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f9387b;

    /* renamed from: c, reason: collision with root package name */
    private long f9388c;

    /* renamed from: d, reason: collision with root package name */
    private Context f9389d;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f9389d = context.getApplicationContext();
    }

    public void a(String str) {
        Integer num = this.f9386a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f9386a.put(str, 2);
            com.taobao.accs.client.b.a(this.f9389d, "AGOO_BIND", this.f9388c, this.f9386a);
        }
    }

    public boolean b(String str) {
        if (this.f9386a.isEmpty()) {
            b();
        }
        Integer num = this.f9386a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.f9386a);
        return (UtilityImpl.a(Config.PREFERENCES, this.f9389d) || num == null || num.intValue() != 2) ? false : true;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9387b = str;
    }

    public boolean d(String str) {
        String str2 = this.f9387b;
        return str2 != null && str2.equals(str);
    }

    public void a() {
        this.f9387b = null;
    }

    private void b() {
        try {
            String string = this.f9389d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f9388c = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f9388c;
            if (currentTimeMillis < 86400000 + j10) {
                for (int i10 = 1; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    this.f9386a.put(jSONObject.getString(bt.aD), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.f9386a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(j10));
            this.f9388c = 0L;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
