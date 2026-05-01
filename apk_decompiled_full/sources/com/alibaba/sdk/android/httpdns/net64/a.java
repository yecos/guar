package com.alibaba.sdk.android.httpdns.net64;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a implements Net64Service {

    /* renamed from: a, reason: collision with root package name */
    private b f5926a;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, List<String>> f33a;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5927o;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f5928p;

    /* renamed from: com.alibaba.sdk.android.httpdns.net64.a$a, reason: collision with other inner class name */
    public static final class C0088a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f5929a = new a();
    }

    private a() {
        this.f5926a = new b();
        this.f33a = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0088a.f5929a;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z10) {
        this.f5927o = z10;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public String getIPv6ByHostAsync(String str) {
        List<String> list;
        if (this.f5927o && (list = this.f33a.get(str)) != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean i() {
        return this.f5928p;
    }

    public List<String> a(String str) {
        return this.f33a.get(str);
    }

    public void a(String str, List<String> list) {
        this.f33a.put(str, list);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m20a() {
        return this.f5927o;
    }
}
