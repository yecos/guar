package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class HttpDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<IDispatchEventListener> f4184a;

    /* renamed from: b, reason: collision with root package name */
    private anet.channel.strategy.dispatch.a f4185b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f4186c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f4187d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f4188e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f4189f;

    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static HttpDispatcher f4190a = new HttpDispatcher();

        private a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return a.f4190a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    public void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.f4184a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f4188e.addAll(list);
            this.f4187d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f4184a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f4188e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f4187d.contains(str);
        if (!contains) {
            this.f4187d.add(str);
        }
        return !contains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f4184a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i10) {
        if (!this.f4186c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DispatchConstants.HOSTS, set);
        hashMap.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i10));
        this.f4185b.a(hashMap);
    }

    public void setEnable(boolean z10) {
        this.f4186c = z10;
    }

    public void switchENV() {
        this.f4187d.clear();
        this.f4188e.clear();
        this.f4189f.set(false);
    }

    private HttpDispatcher() {
        this.f4184a = new CopyOnWriteArraySet<>();
        this.f4185b = new anet.channel.strategy.dispatch.a();
        this.f4186c = true;
        this.f4187d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f4188e = new TreeSet();
        this.f4189f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (this.f4189f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f4189f.compareAndSet(false, true)) {
            return;
        }
        this.f4188e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f4188e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
