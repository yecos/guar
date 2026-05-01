package com.mobile.brasiltv.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f8726a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static Map f8727b = new LinkedHashMap();

    public final void a() {
        f8727b.clear();
    }

    public final long b(String str) {
        t9.i.g(str, "key");
        Long l10 = (Long) f8727b.get(str);
        if (l10 == null) {
            l10 = 0L;
        }
        return l10.longValue();
    }

    public final void c(String str, long j10) {
        t9.i.g(str, "key");
        f8727b.put(str, Long.valueOf(j10));
    }
}
