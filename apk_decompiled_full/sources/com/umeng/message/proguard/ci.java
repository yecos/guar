package com.umeng.message.proguard;

import com.umeng.message.proguard.bx;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class ci {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<bx.c, ch> f11732a = new ConcurrentHashMap<>(8);

    public static ch a(bx.c cVar) {
        ch chVar;
        if (cVar == null) {
            throw new IllegalArgumentException("type cant be null!");
        }
        ConcurrentHashMap<bx.c, ch> concurrentHashMap = f11732a;
        ch chVar2 = concurrentHashMap.get(cVar);
        if (chVar2 != null) {
            return chVar2;
        }
        synchronized (concurrentHashMap) {
            chVar = concurrentHashMap.get(cVar);
            if (chVar == null) {
                chVar = new cj(cVar);
                concurrentHashMap.put(cVar, chVar);
            }
        }
        return chVar;
    }
}
