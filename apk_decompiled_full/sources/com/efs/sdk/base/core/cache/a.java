package com.efs.sdk.base.core.cache;

import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Byte, d> f6110a = new ConcurrentHashMap<>();

    public final d a(byte b10) {
        if (!this.f6110a.containsKey(Byte.valueOf(b10))) {
            if (b10 == 1) {
                this.f6110a.putIfAbsent(Byte.valueOf(b10), new e());
            } else if (b10 != 2) {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b10)));
            } else {
                this.f6110a.putIfAbsent(Byte.valueOf(b10), new c());
            }
        }
        return this.f6110a.get(Byte.valueOf(b10));
    }
}
