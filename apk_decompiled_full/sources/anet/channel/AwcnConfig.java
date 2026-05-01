package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f3764a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f3765b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f3766c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f3767d = true;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f3768e = false;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f3769f = true;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f3770g = 43200000;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f3771h = true;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f3772i = true;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f3773j = true;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f3774k = false;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f3775l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f3776m = true;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f3777n = false;

    /* renamed from: o, reason: collision with root package name */
    private static volatile int f3778o = 10000;

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f3779p = false;

    /* renamed from: q, reason: collision with root package name */
    private static volatile boolean f3780q = true;

    /* renamed from: r, reason: collision with root package name */
    private static volatile int f3781r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f3782s = true;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f3783t = true;

    /* renamed from: u, reason: collision with root package name */
    private static volatile boolean f3784u = false;

    /* renamed from: v, reason: collision with root package name */
    private static volatile boolean f3785v = true;

    /* renamed from: w, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f3786w = null;

    /* renamed from: x, reason: collision with root package name */
    private static volatile boolean f3787x = true;

    /* renamed from: y, reason: collision with root package name */
    private static volatile boolean f3788y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return f3778o;
    }

    public static long getIpv6BlackListTtl() {
        return f3770g;
    }

    public static int getXquicCongControl() {
        return f3781r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return f3764a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (f3786w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return f3786w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f3773j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f3774k;
    }

    public static boolean isCarrierInfoEnable() {
        return f3788y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return f3783t;
    }

    public static boolean isHorseRaceEnable() {
        return f3766c;
    }

    public static boolean isHttp3Enable() {
        return f3779p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f3780q;
    }

    public static boolean isHttpsSniEnable() {
        return f3765b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f3769f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return f3782s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f3772i;
    }

    public static boolean isIpv6Enable() {
        return f3771h;
    }

    public static boolean isNetworkDetectEnable() {
        return f3777n;
    }

    public static boolean isPing6Enable() {
        return f3776m;
    }

    public static boolean isQuicEnable() {
        return f3768e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return f3784u;
    }

    public static boolean isSendConnectInfoByService() {
        return f3785v;
    }

    public static boolean isTbNextLaunch() {
        return f3775l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f3767d;
    }

    public static boolean isWifiInfoEnable() {
        return f3787x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    String string = jSONObject.getString(Constants.KEY_HOST);
                    if (!anet.channel.strategy.utils.d.c(string)) {
                        return;
                    }
                    StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, null, null, null));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 > 10000) {
            i10 = 10000;
        }
        f3778o = i10;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z10) {
        f3764a = z10;
    }

    public static void setAppLifeCycleListenerEnable(boolean z10) {
        f3773j = z10;
    }

    public static void setAsyncLoadStrategyEnable(boolean z10) {
        f3774k = z10;
    }

    public static void setCarrierInfoEnable(boolean z10) {
        f3788y = z10;
    }

    public static void setCookieHeaderRedundantFix(boolean z10) {
        f3783t = z10;
    }

    public static void setHorseRaceEnable(boolean z10) {
        f3766c = z10;
    }

    public static void setHttp3Enable(boolean z10) {
        f3779p = z10;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z10));
    }

    public static void setHttp3OrangeEnable(boolean z10) {
        f3780q = z10;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f3786w = copyOnWriteArrayList;
        } catch (Exception e10) {
            ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e10, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z10) {
        f3765b = z10;
    }

    public static void setIdleSessionCloseEnable(boolean z10) {
        f3769f = z10;
    }

    public static void setIpStackDetectByUdpConnect(boolean z10) {
        f3782s = z10;
    }

    public static void setIpv6BlackListEnable(boolean z10) {
        f3772i = z10;
    }

    public static void setIpv6BlackListTtl(long j10) {
        f3770g = j10;
    }

    public static void setIpv6Enable(boolean z10) {
        f3771h = z10;
    }

    public static void setNetworkDetectEnable(boolean z10) {
        f3777n = z10;
    }

    public static void setPing6Enable(boolean z10) {
        f3776m = z10;
    }

    public static void setQuicEnable(boolean z10) {
        f3768e = z10;
    }

    public static void setSendConnectInfoByBroadcast(boolean z10) {
        f3784u = z10;
    }

    public static void setSendConnectInfoByService(boolean z10) {
        f3785v = z10;
    }

    public static void setTbNextLaunch(boolean z10) {
        f3775l = z10;
    }

    public static void setTnetHeaderCacheEnable(boolean z10) {
        f3767d = z10;
    }

    public static void setWifiInfoEnable(boolean z10) {
        f3787x = z10;
    }

    public static void setXquicCongControl(int i10) {
        if (i10 < 0) {
            return;
        }
        f3781r = i10;
    }
}
