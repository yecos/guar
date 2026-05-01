package anet.channel.strategy;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.strategy.c;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes.dex */
class g implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {

    /* renamed from: a, reason: collision with root package name */
    boolean f4202a = false;

    /* renamed from: b, reason: collision with root package name */
    StrategyInfoHolder f4203b = null;

    /* renamed from: c, reason: collision with root package name */
    long f4204c = 0;

    /* renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<IStrategyListener> f4205d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private IStrategyFilter f4206e = new h(this);

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (a() || TextUtils.isEmpty(str)) {
            return;
        }
        ALog.i("awcn.StrategyCenter", "force refresh strategy", null, Constants.KEY_HOST, str);
        this.f4203b.d().a(str, true);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (a() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f4203b.d().getCnameByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        return a() ? "" : this.f4203b.d().f4170b;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.f4206e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String urlString = parse.urlString();
        try {
            String schemeByHost = getSchemeByHost(parse.host(), parse.scheme());
            if (!schemeByHost.equalsIgnoreCase(parse.scheme())) {
                urlString = StringUtils.concatString(schemeByHost, SOAP.DELIM, str.substring(str.indexOf("//")));
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyCenter", "", null, "raw", StringUtils.simplifyString(str, 128), "ret", StringUtils.simplifyString(urlString, 128));
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e10, "raw", str);
        }
        return urlString;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (a()) {
            return null;
        }
        return this.f4203b.f4159b.b(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (this.f4202a || context == null) {
            return;
        }
        try {
            ALog.i("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
            AmdcRuntimeInfo.setContext(context);
            m.a(context);
            HttpDispatcher.getInstance().addListener(this);
            this.f4203b = StrategyInfoHolder.a();
            this.f4202a = true;
            ALog.i("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
        } catch (Exception e10) {
            ALog.e("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e10, new Object[0]);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (a() || iConnStrategy == null || !(iConnStrategy instanceof IPConnStrategy)) {
            return;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
        if (iPConnStrategy.f4145b == 1) {
            this.f4203b.f4160c.a(str, connEvent);
        } else if (iPConnStrategy.f4145b == 0) {
            this.f4203b.d().a(str, iConnStrategy, connEvent);
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType != 1 || this.f4203b == null) {
            return;
        }
        ALog.d("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
        l.d a10 = l.a((JSONObject) dispatchEvent.extraObject);
        if (a10 == null) {
            return;
        }
        this.f4203b.a(a10);
        saveData();
        Iterator<IStrategyListener> it = this.f4205d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStrategyUpdated(a10);
            } catch (Exception e10) {
                ALog.e("awcn.StrategyCenter", "onStrategyUpdated failed", null, e10, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f4205d);
        if (iStrategyListener != null) {
            this.f4205d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.i("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f4204c > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            this.f4204c = currentTimeMillis;
            anet.channel.strategy.utils.a.a(new i(this), 500L);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        m.a();
        HttpDispatcher.getInstance().switchENV();
        StrategyInfoHolder strategyInfoHolder = this.f4203b;
        if (strategyInfoHolder != null) {
            strategyInfoHolder.b();
            this.f4203b = StrategyInfoHolder.a();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f4205d);
        this.f4205d.remove(iStrategyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (this.f4203b != null) {
            return false;
        }
        ALog.w("awcn.StrategyCenter", "StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.f4202a));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (r17.f4203b.d().a(r2, anet.channel.AwcnConfig.getIpv6BlackListTtl()) != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    @Override // anet.channel.strategy.IStrategyInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        String str2;
        boolean z10;
        ListIterator<IConnStrategy> listIterator;
        if (TextUtils.isEmpty(str) || a()) {
            return Collections.EMPTY_LIST;
        }
        String cnameByHost = this.f4203b.d().getCnameByHost(str);
        if (TextUtils.isEmpty(cnameByHost)) {
            cnameByHost = str;
        }
        List queryByHost = this.f4203b.d().queryByHost(cnameByHost);
        if (queryByHost.isEmpty()) {
            queryByHost = this.f4203b.f4160c.a(cnameByHost);
        }
        if (queryByHost.isEmpty() || iStrategyFilter == null) {
            ALog.d("awcn.StrategyCenter", "getConnStrategyListByHost", null, Constants.KEY_HOST, cnameByHost, "result", queryByHost);
            return queryByHost;
        }
        if (AwcnConfig.isIpv6Enable()) {
            if (AwcnConfig.isIpv6BlackListEnable()) {
                str2 = "getConnStrategyListByHost";
            } else {
                str2 = "getConnStrategyListByHost";
            }
            z10 = false;
            listIterator = queryByHost.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                if (!iStrategyFilter.accept(next)) {
                    listIterator.remove();
                } else if (z10 && anet.channel.strategy.utils.d.b(next.getIp())) {
                    listIterator.remove();
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyCenter", str2, null, Constants.KEY_HOST, cnameByHost, "result", queryByHost);
            }
            return queryByHost;
        }
        str2 = "getConnStrategyListByHost";
        z10 = true;
        listIterator = queryByHost.listIterator();
        while (listIterator.hasNext()) {
        }
        if (ALog.isPrintLog(1)) {
        }
        return queryByHost;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a()) {
            return str2;
        }
        String a10 = this.f4203b.f4159b.a(str);
        if (a10 != null || TextUtils.isEmpty(str2)) {
            str2 = a10;
        }
        if (str2 == null && (str2 = c.a.f4181a.a(str)) == null) {
            str2 = HttpConstant.HTTP;
        }
        ALog.d("awcn.StrategyCenter", "getSchemeByHost", null, Constants.KEY_HOST, str, "scheme", str2);
        return str2;
    }
}
