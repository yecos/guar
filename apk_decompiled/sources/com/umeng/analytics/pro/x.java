package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class x {

    /* renamed from: c, reason: collision with root package name */
    private static final int f10589c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f10590d = new JSONArray();

    /* renamed from: e, reason: collision with root package name */
    private static Object f10591e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f10594f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    Stack<String> f10592a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f10593b = PageNameMonitor.getInstance();

    public int a() {
        return 2;
    }

    public void b(String str) {
        Long l10;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f10594f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f10592a.size() == 0) {
                UMLog.aq(l.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f10594f) {
            l10 = this.f10594f.get(str);
            this.f10594f.remove(str);
        }
        if (l10 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f10592a.size() > 0 && str.equals(this.f10592a.peek())) {
            this.f10592a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l10.longValue();
        synchronized (f10591e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f.f10340v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(f.f10342x, l10);
                jSONObject.put("type", a());
                f10590d.put(jSONObject);
                if (f10590d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, q.a.f10523c, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f10592a.size() == 0) {
            return;
        }
        UMLog.aq(l.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f10591e) {
                    jSONArray = f10590d.toString();
                    f10590d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        k.a(context).a(w.a().c(), jSONObject, k.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f10592a.size() != 0) {
            String[] strArr = {this.f10592a.peek()};
            UMLog.aq(l.F, 0, "\\|", new String[]{"@"}, strArr, null, null);
        }
        this.f10593b.customPageBegin(str);
        synchronized (this.f10594f) {
            this.f10594f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f10592a.push(str);
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f10594f) {
            str = null;
            long j10 = 0;
            for (Map.Entry<String, Long> entry : this.f10594f.entrySet()) {
                if (entry.getValue().longValue() > j10) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j10 = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
