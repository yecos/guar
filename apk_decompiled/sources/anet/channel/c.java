package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    Map<String, Integer> f3895a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    Map<String, SessionInfo> f3896b = new ConcurrentHashMap();

    public void a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        }
        if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.f3896b.put(sessionInfo.host, sessionInfo);
    }

    public SessionInfo b(String str) {
        return this.f3896b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.f3895a) {
            num = this.f3895a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public SessionInfo a(String str) {
        return this.f3896b.remove(str);
    }

    public Collection<SessionInfo> a() {
        return this.f3896b.values();
    }

    public void a(String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3895a) {
                this.f3895a.put(str, Integer.valueOf(i10));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
