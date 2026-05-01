package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.bt;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f9054a;

    /* renamed from: d, reason: collision with root package name */
    private long f9057d;

    /* renamed from: f, reason: collision with root package name */
    private String f9059f;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, Integer> f9055b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentMap<String, Set<String>> f9056c = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private String f9058e = "ClientManager_";

    public b(Context context, String str) {
        this.f9059f = "ACCS_BIND";
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f9058e += str;
        this.f9054a = context.getApplicationContext();
        this.f9059f = "ACCS_BIND" + str;
        a();
    }

    public void a(String str) {
        Integer num = this.f9055b.get(str);
        if (num == null || num.intValue() != 2) {
            this.f9055b.put(str, 2);
            a(this.f9054a, this.f9059f, this.f9057d, this.f9055b);
        }
    }

    public void b(String str) {
        Integer num = this.f9055b.get(str);
        if (num == null || num.intValue() != 4) {
            this.f9055b.put(str, 4);
            a(this.f9054a, this.f9059f, this.f9057d, this.f9055b);
        }
    }

    public boolean c(String str) {
        if (this.f9055b.isEmpty()) {
            a();
        }
        Integer num = this.f9055b.get(str);
        ALog.i(this.f9058e, "isAppBinded", "appStatus", num, "mBindStatus", this.f9055b);
        return num != null && num.intValue() == 2;
    }

    public boolean d(String str) {
        Integer num = this.f9055b.get(str);
        return num != null && num.intValue() == 4;
    }

    public void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f9056c.remove(str);
        } catch (Exception e10) {
            ALog.e(this.f9058e, this.f9058e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Set<String> set = this.f9056c.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(str2);
                this.f9056c.put(str, set);
            }
        } catch (Exception e10) {
            ALog.e(this.f9058e, this.f9058e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
    }

    public boolean b(String str, String str2) {
        Set<String> set;
        try {
            if (!TextUtils.isEmpty(str) && (set = this.f9056c.get(str)) != null) {
                if (set.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception e10) {
            ALog.e(this.f9058e, this.f9058e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
        return false;
    }

    private void a() {
        try {
            String string = this.f9054a.getSharedPreferences(this.f9059f, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w(this.f9058e, "restoreClients break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f9057d = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f9057d;
            if (currentTimeMillis < 86400000 + j10) {
                for (int i10 = 1; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    this.f9055b.put(jSONObject.getString(bt.aD), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i(this.f9058e, "restoreClients success", "mBindStatus", this.f9055b);
                return;
            }
            ALog.i(this.f9058e, "restoreClients expired", "lastFlushTime", Long.valueOf(j10));
            this.f9057d = 0L;
        } catch (Exception e10) {
            ALog.w(this.f9058e, "restoreClients", e10, new Object[0]);
        }
    }

    public static void a(Context context, String str, long j10, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j10 > 0 && j10 < System.currentTimeMillis()) {
                jSONArray.put(j10);
            } else {
                double currentTimeMillis = System.currentTimeMillis();
                double random = Math.random() * 8.64E7d;
                Double.isNaN(currentTimeMillis);
                jSONArray.put(currentTimeMillis - random);
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bt.aD, str2);
                jSONObject.put("s", map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString("bind_status", jSONArray.toString());
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
