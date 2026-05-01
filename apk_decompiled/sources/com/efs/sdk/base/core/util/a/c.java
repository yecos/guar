package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.HttpResponse;

/* loaded from: classes.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {

    /* renamed from: a, reason: collision with root package name */
    public b f6234a;

    public c(b bVar) {
        super(bVar);
        this.f6234a = bVar;
    }

    public final HttpResponse b() {
        this.f6234a.f6231e = "post";
        return a();
    }
}
