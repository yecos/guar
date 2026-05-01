package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ae extends ab {

    /* renamed from: a, reason: collision with root package name */
    private int f9847a;

    /* renamed from: b, reason: collision with root package name */
    private int f9848b;

    /* renamed from: c, reason: collision with root package name */
    private int f9849c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Pair<String, Integer>> f9850d;

    public ae(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
    }

    public void a(int i10) {
        this.f9847a = i10;
    }

    public void b(int i10) {
        this.f9848b = i10;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(ax.a(Base64.decode(str, 0), UMUtils.genSin())));
            int length = jSONArray.length();
            if (length > 0) {
                this.f9850d = new ArrayList<>();
            }
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String optString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                int valueOf = jSONObject.has(com.umeng.ccg.a.B) ? Integer.valueOf(jSONObject.optInt(com.umeng.ccg.a.B)) : 1;
                if (!TextUtils.isEmpty(optString)) {
                    this.f9850d.add(new Pair<>(optString, valueOf));
                }
            }
            this.f9849c = this.f9850d.size();
        } catch (Throwable unused) {
        }
    }

    public int d() {
        return this.f9849c;
    }

    public int e() {
        return this.f9847a;
    }

    public int f() {
        return this.f9848b;
    }

    public ArrayList<Pair<String, Integer>> g() {
        return this.f9850d;
    }

    @Override // com.umeng.analytics.pro.ab
    public String a() {
        return super.a();
    }

    @Override // com.umeng.analytics.pro.ab
    public String b() {
        return super.b();
    }

    @Override // com.umeng.analytics.pro.ab
    public void a(String str) {
        super.a(str);
    }

    @Override // com.umeng.analytics.pro.ab
    public void b(String str) {
        super.b(str);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i10 = this.f9847a;
                int i11 = 0;
                if (i10 != 0) {
                    if (i10 == 1) {
                        int randNumber = DeviceConfig.getRandNumber(0, this.f9849c - 1);
                        String str = (String) this.f9850d.get(randNumber).first;
                        int intValue = ((Integer) this.f9850d.get(randNumber).second).intValue();
                        jSONObject.put("target", str);
                        jSONObject.put(com.umeng.ccg.a.B, intValue);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 1, currIndex: " + randNumber);
                        return;
                    }
                    return;
                }
                SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
                if (a10 != null) {
                    int i12 = a10.getInt(au.f9920h, 0);
                    if (i12 < this.f9849c) {
                        String str2 = (String) this.f9850d.get(i12).first;
                        int intValue2 = ((Integer) this.f9850d.get(i12).second).intValue();
                        jSONObject.put("target", str2);
                        jSONObject.put(com.umeng.ccg.a.B, intValue2);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 0, currIndex: " + i12);
                        if (i12 < this.f9849c - 1) {
                            i11 = i12 + 1;
                        }
                    } else {
                        String str3 = (String) this.f9850d.get(0).first;
                        int intValue3 = ((Integer) this.f9850d.get(0).second).intValue();
                        jSONObject.put("target", str3);
                        jSONObject.put(com.umeng.ccg.a.B, intValue3);
                    }
                    a10.edit().putInt(au.f9920h, i11).commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.f10665y)) {
            a(jSONObject.optInt(com.umeng.ccg.a.f10665y));
        }
        if (jSONObject.has(com.umeng.ccg.a.f10666z)) {
            b(jSONObject.optInt(com.umeng.ccg.a.f10666z));
        }
        if (jSONObject.has(com.umeng.ccg.a.f10664x)) {
            c(jSONObject.optString(com.umeng.ccg.a.f10664x));
        }
    }

    @Override // com.umeng.analytics.pro.ab
    public String c() {
        return super.c();
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (this.f9849c == 0) {
            return null;
        }
        if (jSONObject != null) {
            try {
                a10.put(com.umeng.ccg.a.f10666z, this.f9848b);
                a10.put(com.umeng.ccg.a.f10665y, this.f9847a);
                int optInt = jSONObject.optInt(com.umeng.ccg.a.f10650j);
                if (this.f9848b == 0 && optInt == 202) {
                    a(a10);
                }
                if (this.f9848b == 1 && optInt == 304) {
                    a(a10);
                }
            } catch (Throwable unused) {
            }
        }
        return a10;
    }
}
