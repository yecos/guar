package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.taobao.accs.common.Constants;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public c f6192a;

    /* renamed from: b, reason: collision with root package name */
    public ControllerCenter f6193b;

    /* renamed from: c, reason: collision with root package name */
    public d f6194c;

    /* renamed from: d, reason: collision with root package name */
    public g f6195d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f6196a = new f(0);
    }

    public /* synthetic */ f(byte b10) {
        this();
    }

    public final void a(String str, String str2, String str3) {
        this.f6195d.a(str, str2, str3);
    }

    private f() {
        this.f6192a = new c();
        this.f6194c = new d();
        this.f6195d = new g();
    }

    public final void a(int i10) {
        ControllerCenter controllerCenter = this.f6193b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i10));
        }
    }

    public final void a(int i10, String str) {
        if (this.f6193b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            b a10 = a("flow_limit_type", i10);
            a10.put(Constants.KEY_HTTP_CODE, str);
            this.f6193b.send(a10);
        }
    }

    public final b a(String str, int i10) {
        b bVar = new b("efs_core", str, this.f6192a.f6186c);
        bVar.put("cver", Integer.valueOf(i10));
        return bVar;
    }
}
