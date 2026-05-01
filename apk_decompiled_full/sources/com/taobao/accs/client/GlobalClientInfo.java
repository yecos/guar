package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

@Keep
/* loaded from: classes3.dex */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";

    /* renamed from: a, reason: collision with root package name */
    public static Context f9031a = null;

    /* renamed from: b, reason: collision with root package name */
    public static IAgooAppReceiver f9032b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f9033c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9034d = false;

    /* renamed from: e, reason: collision with root package name */
    private static final String f9035e = "com.taobao.accs.client.GlobalClientInfo";

    /* renamed from: f, reason: collision with root package name */
    private static volatile GlobalClientInfo f9036f;

    /* renamed from: l, reason: collision with root package name */
    private static Map<String, String> f9037l = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, Map<String, String>> f9038m = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, ILoginInfo> f9039g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, IAppReceiver> f9040h;

    /* renamed from: i, reason: collision with root package name */
    private ActivityManager f9041i;

    /* renamed from: j, reason: collision with root package name */
    private ConnectivityManager f9042j;

    /* renamed from: k, reason: collision with root package name */
    private PackageInfo f9043k;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, AccsDataListener> f9044n = new ConcurrentHashMap();

    static {
        f9037l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f9037l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f9037l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        Context context2 = getContext();
        f9031a = context2;
        if (context2 == null && context != null) {
            f9031a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    private void a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (f9038m.get(str) == null) {
            f9038m.put(str, new ConcurrentHashMap());
        }
        f9038m.get(str).putAll(map);
    }

    public static Context getContext() {
        return f9031a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f9036f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f9036f == null) {
                    f9036f = new GlobalClientInfo(context);
                }
            }
        }
        return f9036f;
    }

    public void clearLoginInfoImpl() {
        this.f9039g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f9041i == null) {
            this.f9041i = (ActivityManager) f9031a.getSystemService("activity");
        }
        return this.f9041i;
    }

    public Map<String, String> getAllService(String str) {
        if (f9038m.get(str) == null || f9038m.get(str).isEmpty()) {
            return null;
        }
        return f9038m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f9040h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f9042j == null) {
            this.f9042j = (ConnectivityManager) f9031a.getSystemService("connectivity");
        }
        return this.f9042j;
    }

    public AccsDataListener getListener(String str) {
        return this.f9044n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9039g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f9043k == null) {
                this.f9043k = f9031a.getPackageManager().getPackageInfo(f9031a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f9043k;
    }

    public String getService(String str) {
        return f9037l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9039g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9039g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f9038m.get(str) == null) {
            f9038m.put(str, new ConcurrentHashMap());
        }
        f9038m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.f9044n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f9037l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f9037l.put(str, str2);
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                f9032b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.f9040h == null) {
                this.f9040h = new ConcurrentHashMap<>(2);
            }
            this.f9040h.put(str, iAppReceiver);
            a(str, iAppReceiver.getAllServices());
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f9039g == null) {
            this.f9039g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f9039g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        f9032b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f9040h == null) {
            this.f9040h = new ConcurrentHashMap<>(2);
        }
        this.f9040h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f9037l.remove(str);
    }

    public void unregisterListener(String str) {
        this.f9044n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.f9044n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f9037l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f9038m.get(str) != null) {
            return f9038m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.f9044n.put(str, accsDataListener);
    }
}
