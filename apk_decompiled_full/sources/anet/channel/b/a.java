package anet.channel.b;

import androidx.appcompat.app.m;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;
import n1.a;

/* loaded from: classes.dex */
public class a implements n1.a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3886a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Object f3887b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f3888c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f3889d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f3887b = new b();
            f3888c = new c();
            f3889d = new d();
        } catch (ClassNotFoundException unused) {
            f3886a = false;
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (cacheForModule != null) {
            return cacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache cacheForModule;
        if (f3886a && (cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = Long.valueOf(com.hpplay.logwriter.b.f7378a);
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            cacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // n1.a
    public void clear() {
        if (f3886a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f3889d);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "clear cache failed", null, e10, new Object[0]);
            }
        }
    }

    public a.C0295a get(String str) {
        if (!f3886a) {
            return null;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                m.a(b10.objectForKey(StringUtils.md5ToHex(str)));
                return null;
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, e10, new Object[0]);
        }
        return null;
    }

    public void put(String str, a.C0295a c0295a) {
        if (f3886a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.setObjectForKey(StringUtils.md5ToHex(str), c0295a, (IAVFSCache.OnObjectSetCallback) f3887b);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", null, e10, new Object[0]);
            }
        }
    }

    public void remove(String str) {
        if (f3886a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f3888c);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "remove cache failed", null, e10, new Object[0]);
            }
        }
    }
}
