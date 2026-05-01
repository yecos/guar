package com.umeng.message.proguard;

import android.app.Activity;
import anet.channel.entity.ConnType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class dt {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dt f12015b;

    /* renamed from: a, reason: collision with root package name */
    public final du f12016a = new du("union");

    /* renamed from: c, reason: collision with root package name */
    private volatile Set<String> f12017c;

    private dt() {
    }

    public static dt a() {
        if (f12015b == null) {
            synchronized (dt.class) {
                if (f12015b == null) {
                    f12015b = new dt();
                }
            }
        }
        return f12015b;
    }

    public final void a(boolean z10) {
        this.f12016a.a(ConnType.PK_AUTO, z10);
    }

    public final void a(String str) {
        this.f12016a.a("et", str);
    }

    private void a(Set<String> set) {
        du duVar = this.f12016a;
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            du.c(duVar.a(com.umeng.analytics.pro.bd.f9993t), jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public final void a(List<Class<? extends Activity>> list) {
        HashSet hashSet = new HashSet();
        if (!list.isEmpty()) {
            for (Class<? extends Activity> cls : list) {
                if (cls != null) {
                    hashSet.add(cls.getName());
                }
            }
        }
        this.f12017c = hashSet;
        synchronized (this) {
            a(hashSet);
        }
    }

    public final boolean a(Class<? extends Activity> cls) {
        Set<String> set = this.f12017c;
        if (set == null) {
            synchronized (this) {
                if (this.f12017c == null) {
                    this.f12017c = a().f12016a.a(com.umeng.analytics.pro.bd.f9993t, new HashSet());
                }
                set = this.f12017c;
            }
        }
        return set != null && set.contains(cls.getName());
    }
}
