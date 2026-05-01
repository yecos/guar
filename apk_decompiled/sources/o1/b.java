package o1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f17455a = true;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f17456b = true;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f17457c = true;

    /* renamed from: d, reason: collision with root package name */
    public static volatile long f17458d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f17459e = false;

    /* renamed from: f, reason: collision with root package name */
    public static volatile ConcurrentHashMap f17460f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f17461g;

    /* renamed from: h, reason: collision with root package name */
    public static final List f17462h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public static volatile int f17463i = 10000;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f17464j = true;

    /* renamed from: k, reason: collision with root package name */
    public static volatile boolean f17465k = false;

    /* renamed from: l, reason: collision with root package name */
    public static volatile int f17466l = 60000;

    /* renamed from: m, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f17467m = null;

    /* renamed from: n, reason: collision with root package name */
    public static volatile ConcurrentHashMap f17468n = null;

    /* renamed from: o, reason: collision with root package name */
    public static volatile boolean f17469o = true;

    /* renamed from: p, reason: collision with root package name */
    public static volatile boolean f17470p = false;

    /* renamed from: q, reason: collision with root package name */
    public static volatile boolean f17471q = false;

    /* renamed from: r, reason: collision with root package name */
    public static volatile boolean f17472r = true;

    /* renamed from: s, reason: collision with root package name */
    public static volatile boolean f17473s = true;

    /* renamed from: t, reason: collision with root package name */
    public static volatile a f17474t;

    public static int a() {
        return f17463i;
    }

    public static boolean b() {
        return f17471q;
    }

    public static void c(boolean z10) {
        f17472r = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(q1.a.a()).edit();
        edit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", f17472r);
        edit.apply();
    }

    public static void d(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i10 = 0; i10 < length; i10++) {
                    String string = jSONArray.getString(i10);
                    if (d.c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e10) {
                ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e10, new Object[0]);
            }
        }
    }

    public static void e(int i10) {
        f17466l = i10;
    }

    public static void f(boolean z10) {
        f17459e = z10;
    }

    public static void g(boolean z10) {
        f17470p = z10;
    }

    public static void h(long j10) {
        if (j10 != f17458d) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f17458d), "new", Long.valueOf(j10));
            f17458d = j10;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(q1.a.a()).edit();
            edit.putLong("Cache.Flag", f17458d);
            edit.apply();
            n1.b.b();
        }
    }

    public static void i(boolean z10) {
        f17471q = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(q1.a.a()).edit();
        edit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", f17471q);
        edit.apply();
    }

    public static void j(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f17468n = null;
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (Operator.Operation.MULTIPLY.equals(obj)) {
                        concurrentHashMap.put(next, f17462h);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e10, new Object[0]);
        }
        f17468n = concurrentHashMap;
    }

    public static void k(boolean z10) {
        f17457c = z10;
    }

    public static void l(String str) {
        if (TextUtils.isEmpty(str)) {
            f17467m = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.KEY_HOST);
            int length = jSONArray.length();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (d.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f17467m = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e10, new Object[0]);
        }
    }

    public static void m(a aVar) {
        if (f17474t != null) {
            f17474t.unRegister();
        }
        if (aVar != null) {
            aVar.register();
        }
        f17474t = aVar;
    }

    public static void n(boolean z10) {
        f17456b = z10;
    }

    public static void o(boolean z10) {
        f17469o = z10;
    }

    public static void p(int i10) {
        f17463i = i10;
    }

    public static void q(boolean z10) {
        f17464j = z10;
    }

    public static void r(boolean z10) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z10));
        f17455a = z10;
    }

    public static void s(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f17461g = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f17461g = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", null, e10, new Object[0]);
        }
    }

    public static void t(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f17460f = null;
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (Operator.Operation.MULTIPLY.equals(obj)) {
                        concurrentHashMap.put(next, f17462h);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e10, new Object[0]);
        }
        f17460f = concurrentHashMap;
    }
}
