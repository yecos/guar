package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public b f6235a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> f6236b;

    public d(String str) {
        b bVar = new b();
        this.f6235a = bVar;
        bVar.f6227a = str;
    }

    public final d a(Map<String, String> map) {
        this.f6235a.f6228b = map;
        return this;
    }

    public final d a(String str, String str2) {
        b bVar = this.f6235a;
        if (bVar.f6232f == null) {
            bVar.f6232f = new HashMap(5);
        }
        this.f6235a.f6232f.put(str, str2);
        return this;
    }

    public final d a(AbsHttpListener absHttpListener) {
        if (this.f6236b == null) {
            this.f6236b = new ArrayList(5);
        }
        this.f6236b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.f6235a);
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> list = this.f6236b;
        if (list != null && list.size() > 0) {
            cVar.a(this.f6236b);
        }
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
