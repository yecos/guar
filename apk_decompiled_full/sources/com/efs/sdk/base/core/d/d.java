package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f6189d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f6190e = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public AtomicInteger f6187b = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f6191f = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f6188c = new AtomicInteger(0);

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        f fVar;
        if ((this.f6189d.get() == 0 && this.f6190e.get() == 0 && this.f6187b.get() == 0 && this.f6188c.get() == 0 && this.f6191f.get() == 0) || this.f6177a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        ControllerCenter controllerCenter = this.f6177a;
        int i10 = this.f6189d.get();
        int i11 = this.f6190e.get();
        int i12 = this.f6187b.get();
        int i13 = this.f6188c.get();
        int i14 = this.f6191f.get();
        fVar = f.a.f6196a;
        b bVar = new b("efs_core", "lf_st", fVar.f6192a.f6186c);
        bVar.put("create_cnt", Integer.valueOf(i10));
        bVar.put("cache_cnt", Integer.valueOf(i11));
        bVar.put("req_cnt", Integer.valueOf(i12));
        bVar.put("err_cnt", Integer.valueOf(i13));
        bVar.put("expire_cnt", Integer.valueOf(i14));
        this.f6189d.addAndGet(i10 * (-1));
        this.f6190e.addAndGet(i11 * (-1));
        this.f6187b.addAndGet(i12 * (-1));
        this.f6188c.addAndGet(i13 * (-1));
        this.f6191f.addAndGet(i14 * (-1));
        controllerCenter.send(bVar);
    }

    public final void b() {
        this.f6189d.incrementAndGet();
    }

    public final void c() {
        this.f6190e.incrementAndGet();
    }

    public final void d() {
        this.f6191f.incrementAndGet();
    }
}
