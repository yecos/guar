package anet.channel.strategy.dispatch;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: classes.dex */
class a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static Random f4191b = new Random();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f4192a;

    /* renamed from: anet.channel.strategy.dispatch.a$a, reason: collision with other inner class name */
    public class RunnableC0066a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f4194b;

        public RunnableC0066a(Map<String, Object> map) {
            this.f4194b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.f4194b;
                if (map2 == null) {
                    synchronized (a.class) {
                        map = a.this.f4192a;
                        a.this.f4192a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.isConnected()) {
                    if (GlobalAppRuntimeInfo.getEnv() != map2.get("Env")) {
                        ALog.w(a.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        b.a(d.a(map2));
                    }
                }
            } catch (Exception e10) {
                ALog.e(a.TAG, "exec amdc task failed.", null, e10, new Object[0]);
            }
        }

        public RunnableC0066a() {
        }
    }

    public void a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                Map<String, Object> map2 = this.f4192a;
                if (map2 == null) {
                    this.f4192a = map;
                    int nextInt = f4191b.nextInt(3000) + 2000;
                    ALog.i(TAG, "merge amdc request", null, "delay", Integer.valueOf(nextInt));
                    anet.channel.strategy.utils.a.a(new RunnableC0066a(), nextInt);
                } else {
                    Set set = (Set) map2.get(DispatchConstants.HOSTS);
                    Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                    if (map.get("Env") != this.f4192a.get("Env")) {
                        this.f4192a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.f4192a = map;
                    } else {
                        anet.channel.strategy.utils.a.a(new RunnableC0066a(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
