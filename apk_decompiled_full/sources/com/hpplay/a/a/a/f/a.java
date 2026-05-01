package com.hpplay.a.a.a.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    protected long f7328a;

    /* renamed from: b, reason: collision with root package name */
    private final List<com.hpplay.a.a.a.a> f7329b = Collections.synchronizedList(new ArrayList());

    public List<com.hpplay.a.a.a.a> a() {
        return this.f7329b;
    }

    @Override // com.hpplay.a.a.a.f.b
    public void b() {
        Iterator it = new ArrayList(this.f7329b).iterator();
        while (it.hasNext()) {
            ((com.hpplay.a.a.a.a) it.next()).a();
        }
    }

    public Thread c(com.hpplay.a.a.a.a aVar) {
        Thread thread = new Thread(aVar);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f7328a + ")");
        return thread;
    }

    @Override // com.hpplay.a.a.a.f.b
    public void a(com.hpplay.a.a.a.a aVar) {
        this.f7329b.remove(aVar);
    }

    @Override // com.hpplay.a.a.a.f.b
    public void b(com.hpplay.a.a.a.a aVar) {
        this.f7328a++;
        this.f7329b.add(aVar);
        c(aVar).start();
    }
}
