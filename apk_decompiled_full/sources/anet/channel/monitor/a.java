package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f4007a;

    /* renamed from: b, reason: collision with root package name */
    private Map<INetworkQualityChangeListener, f> f4008b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private f f4009c = new f();

    private a() {
    }

    public static a a() {
        if (f4007a == null) {
            synchronized (a.class) {
                if (f4007a == null) {
                    f4007a = new a();
                }
            }
        }
        return f4007a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (fVar == null) {
            this.f4009c.f4042b = System.currentTimeMillis();
            this.f4008b.put(iNetworkQualityChangeListener, this.f4009c);
        } else {
            fVar.f4042b = System.currentTimeMillis();
            this.f4008b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f4008b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d10) {
        boolean a10;
        for (Map.Entry<INetworkQualityChangeListener, f> entry : this.f4008b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            f value = entry.getValue();
            if (key != null && value != null && !value.b() && value.f4041a != (a10 = value.a(d10))) {
                value.f4041a = a10;
                key.onNetworkQualityChanged(a10 ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
