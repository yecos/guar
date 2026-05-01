package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final f f6386a;

    /* renamed from: b, reason: collision with root package name */
    public ByteArrayOutputStream f6387b;

    /* renamed from: c, reason: collision with root package name */
    public a f6388c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6389d;

    public h(f fVar, String str) {
        this.f6386a = fVar;
        this.f6389d = str;
    }

    public final boolean a() {
        return this.f6387b != null;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
