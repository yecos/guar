package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ab implements aj {

    /* renamed from: a, reason: collision with root package name */
    private String f9839a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ac> f9840b;

    /* renamed from: c, reason: collision with root package name */
    private String f9841c;

    /* renamed from: d, reason: collision with root package name */
    private String f9842d;

    /* renamed from: e, reason: collision with root package name */
    private String f9843e;

    /* renamed from: f, reason: collision with root package name */
    private String f9844f;

    public ab(String str, ArrayList<ac> arrayList) {
        this.f9839a = null;
        new ArrayList();
        this.f9841c = "";
        this.f9842d = "";
        this.f9843e = "";
        this.f9844f = "";
        this.f9839a = str;
        this.f9840b = arrayList;
    }

    public String a() {
        return this.f9839a;
    }

    @Override // com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
    }

    public String c() {
        return this.f9842d;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f9839a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f9844f = forbidSdkArray.toString();
            for (String str3 : split) {
                if (CcgAgent.getActionInfo(str3) != null && !forbidSdkArray.contains(str3)) {
                    return str3;
                }
            }
            return "";
        }
        for (String str4 : split) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= supportAction.length) {
                            break;
                        }
                        if (this.f9839a.equals(supportAction[i10])) {
                            str2 = str4;
                            break;
                        }
                        i10++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    public void a(String str) {
        this.f9841c = str;
    }

    public String b() {
        return this.f9841c;
    }

    @Override // com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f9840b.size();
            if (size == 0) {
                return null;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f9840b.get(i10).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f9842d)) {
                String c10 = c(this.f9842d);
                this.f9843e = c10;
                if (TextUtils.isEmpty(c10)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f9839a + "; 未选中可用Module ; sdk: " + this.f9842d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f9839a + "; 选中Module: " + this.f9843e + "; sdk: " + this.f9842d);
                }
            }
            ac acVar = this.f9840b.get(size - 1);
            if (acVar == null || !(acVar instanceof af)) {
                return null;
            }
            long c11 = acVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f9839a);
                jSONObject2.put(com.umeng.ccg.a.f10661u, this.f9842d);
                jSONObject2.put(com.umeng.ccg.a.f10658r, this.f9841c);
                jSONObject2.put("delay", c11);
                jSONObject2.put(com.umeng.ccg.a.f10659s, this.f9843e);
                jSONObject2.put(com.umeng.ccg.a.f10660t, this.f9844f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void b(String str) {
        this.f9842d = str;
    }
}
