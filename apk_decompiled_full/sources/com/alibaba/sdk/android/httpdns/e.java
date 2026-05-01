package com.alibaba.sdk.android.httpdns;

import android.text.Html;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private String f5896a;

    /* renamed from: b, reason: collision with root package name */
    private long f5897b;

    /* renamed from: b, reason: collision with other field name */
    private String f17b;

    /* renamed from: c, reason: collision with root package name */
    private long f5898c;
    private String hostName;
    private String[] ips;

    public e(com.alibaba.sdk.android.httpdns.b.e eVar) {
        this.hostName = eVar.host;
        this.f5898c = com.alibaba.sdk.android.httpdns.b.c.a(eVar.f5853n);
        this.f5897b = -1000L;
        ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList = eVar.f7a;
        if (arrayList != null && arrayList.size() > 0) {
            int size = eVar.f7a.size();
            this.ips = new String[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.ips[i10] = eVar.f7a.get(i10).f5855o;
            }
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m20a()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<com.alibaba.sdk.android.httpdns.b.g> arrayList3 = eVar.f8b;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i11 = 0; i11 < eVar.f8b.size(); i11++) {
                    arrayList2.add(eVar.f8b.get(i11).f5855o);
                }
            }
            com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName, arrayList2);
        }
        this.f5896a = eVar.f5850a;
        this.f17b = eVar.f5851b;
    }

    public long a() {
        return this.f5897b;
    }

    public long b() {
        return this.f5898c;
    }

    public boolean c() {
        return a() == -1000;
    }

    public String getCacheKey() {
        return this.f17b;
    }

    public String[] getIps() {
        return this.ips;
    }

    public void setCacheKey(String str) {
        this.f17b = str;
    }

    public String toString() {
        String str = "host: " + this.hostName + " ip cnt: " + this.ips.length + " ttl: " + this.f5897b;
        for (int i10 = 0; i10 < this.ips.length; i10++) {
            str = str + "\n ip: " + this.ips[i10];
        }
        return str;
    }

    public e(String str) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(str);
        this.hostName = jSONObject.getString(Constants.KEY_HOST);
        try {
            if (jSONObject.has("ips")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ips");
                int length = jSONArray2.length();
                this.ips = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.ips[i10] = jSONArray2.getString(i10);
                }
            }
            if (com.alibaba.sdk.android.httpdns.net64.a.a().m20a() && jSONObject.has("ipsv6") && (jSONArray = jSONObject.getJSONArray("ipsv6")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    arrayList.add(jSONArray.getString(i11));
                }
                com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName, arrayList);
            }
            if (jSONObject.has("extra")) {
                this.f5896a = jSONObject.getString("extra");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f5897b = jSONObject.getLong("ttl");
        this.f5898c = System.currentTimeMillis() / 1000;
    }

    /* renamed from: a, reason: collision with other method in class */
    public com.alibaba.sdk.android.httpdns.b.e m13a() {
        List<String> a10;
        com.alibaba.sdk.android.httpdns.b.e eVar = new com.alibaba.sdk.android.httpdns.b.e();
        eVar.host = this.hostName;
        eVar.f5853n = String.valueOf(this.f5898c);
        eVar.f5852m = com.alibaba.sdk.android.httpdns.b.b.i();
        String[] strArr = this.ips;
        if (strArr != null && strArr.length > 0) {
            eVar.f7a = new ArrayList<>();
            for (String str : this.ips) {
                com.alibaba.sdk.android.httpdns.b.g gVar = new com.alibaba.sdk.android.httpdns.b.g();
                gVar.f5855o = str;
                gVar.f5856p = String.valueOf(this.f5897b);
                eVar.f7a.add(gVar);
            }
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m20a() && (a10 = com.alibaba.sdk.android.httpdns.net64.a.a().a(this.hostName)) != null && a10.size() > 0) {
            eVar.f8b = new ArrayList<>();
            for (String str2 : a10) {
                com.alibaba.sdk.android.httpdns.b.g gVar2 = new com.alibaba.sdk.android.httpdns.b.g();
                gVar2.f5855o = str2;
                gVar2.f5856p = String.valueOf(this.f5897b);
                eVar.f8b.add(gVar2);
            }
        }
        eVar.f5850a = this.f5896a;
        eVar.f5851b = this.f17b;
        return eVar;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m16b() {
        return b() + a() < System.currentTimeMillis() / 1000 || c();
    }

    public e(String str, String[] strArr, long j10, long j11, String str2, String str3) {
        this.hostName = str;
        this.ips = strArr;
        this.f5897b = j10;
        this.f5898c = j11;
        this.f5896a = str2;
        this.f17b = str3;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m14a() {
        return this.f5896a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m15a() {
        HashMap hashMap = new HashMap();
        if (this.f5896a != null) {
            try {
                JSONObject jSONObject = new JSONObject(Html.fromHtml(Html.fromHtml(this.f5896a).toString()).toString());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.get(next) == null ? null : jSONObject.get(next).toString());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return hashMap;
    }
}
