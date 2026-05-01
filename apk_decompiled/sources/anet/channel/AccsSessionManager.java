package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
class AccsSessionManager {

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet<ISessionListener> f3761c = new CopyOnWriteArraySet<>();

    /* renamed from: a, reason: collision with root package name */
    SessionCenter f3762a;

    /* renamed from: b, reason: collision with root package name */
    Set<String> f3763b = Collections.EMPTY_SET;

    public AccsSessionManager(SessionCenter sessionCenter) {
        this.f3762a = null;
        this.f3762a = sessionCenter;
    }

    private boolean b() {
        return !(GlobalAppRuntimeInfo.isAppBackground() && AwcnConfig.isAccsSessionCreateForbiddenInBg()) && NetworkStatusHelper.isConnected();
    }

    public synchronized void checkAndStartSession() {
        Collection<SessionInfo> a10 = this.f3762a.f3845g.a();
        Set<String> set = Collections.EMPTY_SET;
        if (!a10.isEmpty()) {
            set = new TreeSet<>();
        }
        for (SessionInfo sessionInfo : a10) {
            if (sessionInfo.isKeepAlive) {
                set.add(StringUtils.concatString(StrategyCenter.getInstance().getSchemeByHost(sessionInfo.host, sessionInfo.isAccs ? "https" : HttpConstant.HTTP), HttpConstant.SCHEME_SPLIT, sessionInfo.host));
            }
        }
        for (String str : this.f3763b) {
            if (!set.contains(str)) {
                a(str);
            }
        }
        if (b()) {
            for (String str2 : set) {
                try {
                    this.f3762a.get(str2, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, Constants.KEY_HOST, str2);
                }
            }
            this.f3763b = set;
        }
    }

    public synchronized void forceCloseSession(boolean z10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.AccsSessionManager", "forceCloseSession", this.f3762a.f3841c, "reCreate", Boolean.valueOf(z10));
        }
        Iterator<String> it = this.f3763b.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        if (z10) {
            checkAndStartSession();
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f3761c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f3761c.remove(iSessionListener);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.d("awcn.AccsSessionManager", "closeSessions", this.f3762a.f3841c, Constants.KEY_HOST, str);
        this.f3762a.a(str).b(false);
    }
}
