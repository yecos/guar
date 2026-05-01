package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static l f12422a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f12423b;

    public static l a() {
        if (f12422a == null) {
            synchronized (l.class) {
                if (f12422a == null) {
                    f12422a = new l();
                }
            }
        }
        return f12422a;
    }

    public ExecutorService b() {
        if (this.f12423b == null) {
            synchronized (l.class) {
                if (this.f12423b == null) {
                    this.f12423b = Executors.newSingleThreadExecutor();
                }
            }
        }
        return this.f12423b;
    }
}
