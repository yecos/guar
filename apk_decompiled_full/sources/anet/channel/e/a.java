package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f3946a;

    /* renamed from: b, reason: collision with root package name */
    private static String f3947b;

    /* renamed from: f, reason: collision with root package name */
    private static SharedPreferences f3951f;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f3948c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f3949d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static long f3950e = 21600000;

    /* renamed from: g, reason: collision with root package name */
    private static IStrategyFilter f3952g = new anet.channel.e.b();

    /* renamed from: h, reason: collision with root package name */
    private static AtomicInteger f3953h = new AtomicInteger(1);

    /* renamed from: i, reason: collision with root package name */
    private static IStrategyListener f3954i = new c();

    /* renamed from: j, reason: collision with root package name */
    private static NetworkStatusHelper.INetworkStatusChangeListener f3955j = new d();

    /* renamed from: anet.channel.e.a$a, reason: collision with other inner class name */
    public static class C0064a {

        /* renamed from: a, reason: collision with root package name */
        long f3956a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3957b;

        private C0064a() {
        }

        public /* synthetic */ C0064a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = f3946a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f3949d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f3947b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f3947b, f3952g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f3948c.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f3949d.set(true);
                    return;
                }
            }
            if (f3946a == null) {
                f3946a = new b();
            }
            if (f3946a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, C0064a> f3958a = new ConcurrentHashMap();

        public b() {
            a();
        }

        private void a() {
            anet.channel.e.b bVar = null;
            String string = a.f3951f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                    C0064a c0064a = new C0064a(bVar);
                    String string2 = jSONObject.getString("networkUniqueId");
                    c0064a.f3956a = jSONObject.getLong(AgooConstants.MESSAGE_TIME);
                    c0064a.f3957b = jSONObject.getBoolean("enable");
                    if (a(c0064a.f3956a)) {
                        synchronized (this.f3958a) {
                            this.f3958a.put(string2, c0064a);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public boolean b(String str) {
            synchronized (this.f3958a) {
                C0064a c0064a = this.f3958a.get(str);
                if (c0064a == null) {
                    return false;
                }
                return c0064a.f3957b;
            }
        }

        public boolean a(String str) {
            synchronized (this.f3958a) {
                C0064a c0064a = this.f3958a.get(str);
                boolean z10 = true;
                if (c0064a == null) {
                    return true;
                }
                if (a(c0064a.f3956a)) {
                    z10 = false;
                }
                return z10;
            }
        }

        private boolean a(long j10) {
            return System.currentTimeMillis() - j10 < a.f3950e;
        }

        public void a(String str, boolean z10) {
            C0064a c0064a = new C0064a(null);
            c0064a.f3957b = z10;
            c0064a.f3956a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f3958a) {
                this.f3958a.put(str, c0064a);
                for (Map.Entry<String, C0064a> entry : this.f3958a.entrySet()) {
                    String key = entry.getKey();
                    C0064a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put(AgooConstants.MESSAGE_TIME, value.f3956a);
                        jSONObject.put("enable", value.f3957b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            a.f3951f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f3951f = defaultSharedPreferences;
            f3947b = defaultSharedPreferences.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f3955j);
            StrategyCenter.getInstance().registerListener(f3954i);
        } catch (Exception e10) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e10, new Object[0]);
        }
    }

    public static void a(long j10) {
        if (j10 < 0) {
            return;
        }
        f3950e = j10;
    }

    public static void a(boolean z10) {
        b bVar = f3946a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z10);
        }
    }
}
