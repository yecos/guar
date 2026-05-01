package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AMSDevReporter;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpDns implements HttpDnsService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5837a = 0;
    private boolean isExpiredIPEnabled = false;
    private static d hostManager = d.a();
    private static DegradationFilter degradationFilter = null;
    static HttpDns instance = null;
    private static boolean inited = false;
    private static String sAccountId = null;
    private static String sSecretKey = null;
    private static Context sContext = null;

    private HttpDns(Context context, String str) {
        f.c(str);
        com.alibaba.sdk.android.httpdns.a.a.a().c(context, str);
        com.alibaba.sdk.android.httpdns.a.a.a().a(com.alibaba.sdk.android.httpdns.d.b.a(context));
    }

    private static void disableReport() {
        com.alibaba.sdk.android.httpdns.d.b.a().k();
    }

    private static String getAccountId() {
        if (!TextUtils.isEmpty(sAccountId)) {
            return sAccountId;
        }
        String accountId = AMSConfigUtils.getAccountId(sContext);
        sAccountId = accountId;
        return accountId;
    }

    private String getIpByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return null;
        }
        String[] ipsByHost = getIpsByHost(str);
        if (ipsByHost != null && ipsByHost.length > 0) {
            return ipsByHost[0];
        }
        return null;
    }

    private String[] getIpsByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            if (!l.b(str)) {
                return f.f20c;
            }
            if (l.c(str)) {
                return new String[]{str};
            }
            DegradationFilter degradationFilter2 = degradationFilter;
            if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
                return f.f20c;
            }
            if (u.e()) {
                return getIpsByHostAsync(str);
            }
            e m6a = hostManager.m6a(str);
            if (m6a != null && m6a.m16b() && this.isExpiredIPEnabled) {
                if (!hostManager.m11a(str)) {
                    i.d("refresh host async: " + str);
                    c.a().submit(new q(str, s.QUERY_HOST));
                }
                return m6a.getIps();
            }
            if (m6a != null && !m6a.m16b()) {
                return m6a.getIps();
            }
            i.d("refresh host sync: " + str);
            try {
                return (String[]) c.a().submit(new q(str, s.QUERY_HOST)).get();
            } catch (Exception e10) {
                i.a(e10);
            }
        }
        return f.f20c;
    }

    private static String getSecretKey() {
        if (!TextUtils.isEmpty(sSecretKey)) {
            return sSecretKey;
        }
        String httpdnsSecretKey = AMSConfigUtils.getHttpdnsSecretKey(sContext);
        sSecretKey = httpdnsSecretKey;
        return httpdnsSecretKey;
    }

    public static synchronized HttpDnsService getService(Context context) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                sContext = applicationContext;
                b.a(applicationContext);
                com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.3
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                        } else {
                            i.f("crash limit exceeds, httpdns disabled");
                            b.b(false);
                        }
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    private static void initHttpDns(Context context, String str, String str2) {
        if (instance == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AMSDevReporter.AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString(), "1.3.2.3-no-bssid-ssid");
            AMSDevReporter.asyncReport(context, AMSDevReporter.AMSSdkTypeEnum.AMS_HTTPDNS, hashMap);
            p.setContext(context);
            q.setContext(context);
            com.alibaba.sdk.android.httpdns.b.b.a(context);
            com.alibaba.sdk.android.httpdns.b.b.b(context);
            u.a(context);
            n.a().a(context, str);
            if (!TextUtils.isEmpty(str2)) {
                a.setSecretKey(str2);
            }
            reportActive(context, str);
            instance = new HttpDns(context, str);
        }
    }

    private static void reportActive(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            i.f("report active failed due to missing context or accountid");
        } else {
            com.alibaba.sdk.android.httpdns.d.b.a(context).setAccountId(str);
            com.alibaba.sdk.android.httpdns.d.b.a(context).l();
        }
    }

    private static void reportHttpDnsSuccess(String str, int i10) {
        com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
        if (a10 != null) {
            a10.a(str, i10, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m1a() ? 1 : 0);
        }
    }

    private static void reportUserGetIP(String str, int i10) {
        com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
        if (a10 != null) {
            a10.b(str, i10, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m1a() ? 1 : 0);
        }
    }

    private static void setAccountId(String str) {
        sAccountId = str;
    }

    private static void setSecretKey(String str) {
        sSecretKey = str;
    }

    public static synchronized void switchDnsService(boolean z10) {
        synchronized (HttpDns.class) {
            b.a(z10);
            if (!b.a()) {
                i.f("httpdns service disabled");
            }
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void clearSdnsGlobalParams() {
        f.clearSdnsGlobalParams();
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z10) {
        com.alibaba.sdk.android.httpdns.net64.a.a().enableIPv6(z10);
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.e(z10 ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public String getIPv6ByHostAsync(String str) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return null;
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m20a()) {
            getIpsByHostAsync(str);
            e m6a = hostManager.m6a(str);
            if (m6a != null) {
                String iPv6ByHostAsync = com.alibaba.sdk.android.httpdns.net64.a.a().getIPv6ByHostAsync(str);
                if (this.isExpiredIPEnabled) {
                    i.d("ipv6 is expired enable, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!m6a.m16b()) {
                    i.d("ipv6 is not expired, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!m6a.c()) {
                    i.d("ipv6 is expired.");
                    return null;
                }
                i.d("ipv6 is from cache, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                return iPv6ByHostAsync;
            }
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getIpByHostAsync(String str) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return null;
            }
            String[] ipsByHostAsync = getIpsByHostAsync(str);
            if (ipsByHostAsync != null && ipsByHostAsync.length > 0) {
                return ipsByHostAsync[0];
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (r3 != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.sdk.android.httpdns.HTTPDNSResult getIpsByHostAsync(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String, java.util.Map, java.lang.String):com.alibaba.sdk.android.httpdns.HTTPDNSResult");
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getSessionId() {
        return com.alibaba.sdk.android.httpdns.e.a.a().getSessionId();
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setAuthCurrentTime(long j10) {
        if (b.a()) {
            a.setAuthCurrentTime(j10);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z10) {
        setCachedIPEnabled(z10, true);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setDegradationFilter(DegradationFilter degradationFilter2) {
        if (b.a()) {
            degradationFilter = degradationFilter2;
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setExpiredIPEnabled(boolean z10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        this.isExpiredIPEnabled = z10;
        com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
        if (a10 != null) {
            a10.d(z10 ? 1 : 0);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setHTTPSRequestEnabled(boolean z10) {
        if (b.a()) {
            f.setHTTPSRequestEnabled(z10);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setIPProbeList(List<IPProbeItem> list) {
        if (b.a()) {
            f.a(list);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogEnabled(boolean z10) {
        i.setLogEnabled(z10);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogger(ILogger iLogger) {
        i.setLogger(iLogger);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveAfterNetworkChanged(boolean z10) {
        if (b.a()) {
            p.f5932i = z10;
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveHosts(ArrayList<String> arrayList) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str = arrayList.get(i10);
            if (l.b(str) && !hostManager.m11a(str)) {
                c.a().submit(new q(str, s.QUERY_HOST));
            }
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setRegion(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else if (TextUtils.isEmpty(str)) {
            i.f("region cannot be empty");
        } else {
            n.a().b(sContext, str);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setSdnsGlobalParams(Map<String, String> map) {
        f.setSdnsGlobalParams(map);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setTimeoutInterval(int i10) {
        if (b.a()) {
            f.setTimeoutInterval(i10);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                b.a(sContext);
                com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.1
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                        } else {
                            i.f("crash limit exceeds, httpdns disabled");
                            b.b(false);
                        }
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r3 != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] getIpsByHostAsync(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String):java.lang.String[]");
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z10, boolean z11) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return;
            }
            i.f("Httpdns DB cache enable = " + z10 + ". autoCleanCacheAfterLoad = " + z11);
            com.alibaba.sdk.android.httpdns.b.b.a(z10, z11);
            d.a().m8a();
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.c(z10 ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, String str2) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                setSecretKey(str2);
                b.a(sContext);
                com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.2
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                        } else {
                            i.f("crash limit exceeds, httpdns disabled");
                            b.b(false);
                        }
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }
}
